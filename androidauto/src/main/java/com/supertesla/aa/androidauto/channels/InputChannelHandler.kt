package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.InputMessageType
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import timber.log.Timber
import java.io.ByteArrayOutputStream

/**
 * Handles input channel (channel 1).
 * Responds to binding requests from the phone and sends touch events.
 */
class InputChannelHandler(
    private val mux: ChannelMux,
    private val displayWidth: Int,
    private val displayHeight: Int
) : ChannelHandler {

    data class TouchPointer(val id: Int, val x: Int, val y: Int)

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        val msgType = frame.messageType

        when (msgType) {
            InputMessageType.BINDING_REQUEST -> {
                Timber.i("Input: received BindingRequest")
                val response = ServiceDiscovery.buildInputBindingResponse(status = 0)
                mux.sendEncryptedControl(ChannelId.INPUT, InputMessageType.BINDING_RESPONSE, response)
                Timber.i("Input: sent BindingResponse OK")
            }

            else -> {
                Timber.v("Input: unhandled msgType=0x${msgType.toString(16)}")
            }
        }
    }

    /**
     * Send a single-pointer touch event (backward compat).
     */
    fun sendTouchEvent(action: Int, x: Int, y: Int, pointerId: Int = 0) {
        sendMultiTouchEvent(action, 0, listOf(TouchPointer(pointerId, x, y)))
    }

    /**
     * Send a multi-pointer touch event to Android Auto.
     *
     * @param action AA PointerAction (0=DOWN, 1=UP, 2=MOVE, 5=POINTER_DOWN, 6=POINTER_UP)
     * @param actionIndex index of the pointer that triggered POINTER_DOWN/POINTER_UP
     * @param pointers all active pointers with their coordinates
     */
    fun sendMultiTouchEvent(action: Int, actionIndex: Int, pointers: List<TouchPointer>) {
        val timestamp = try {
            android.os.SystemClock.elapsedRealtime() * 1_000_000L
        } catch (_: Exception) {
            System.nanoTime() // Fallback for unit tests (no Android framework)
        }

        val out = ByteArrayOutputStream()

        // InputReport
        ProtoEncoder.writeVarintField(out, 1, timestamp)
        ProtoEncoder.writeVarintField(out, 2, ChannelId.VIDEO.toLong())

        // field 3: touch_event
        ProtoEncoder.writeEmbeddedMessage(out, 3) { touchEvent ->
            // pointer_data (field 1, repeated)
            for (pointer in pointers) {
                ProtoEncoder.writeEmbeddedMessage(touchEvent, 1) { pd ->
                    ProtoEncoder.writeVarintField(pd, 1, pointer.x.toLong())
                    ProtoEncoder.writeVarintField(pd, 2, pointer.y.toLong())
                    ProtoEncoder.writeVarintField(pd, 3, pointer.id.toLong())
                }
            }
            // action (field 3)
            ProtoEncoder.writeVarintField(touchEvent, 3, action.toLong())
            // actionIndex (field 4)
            if (actionIndex > 0) {
                ProtoEncoder.writeVarintField(touchEvent, 4, actionIndex.toLong())
            }
        }

        mux.sendEncrypted(ChannelId.INPUT, InputMessageType.INPUT_EVENT, out.toByteArray())
    }

    companion object {
        const val ACTION_DOWN = 0
        const val ACTION_UP = 1
        const val ACTION_MOVE = 2
        const val ACTION_POINTER_DOWN = 5
        const val ACTION_POINTER_UP = 6

        // Browser action IDs (from touch.js)
        private const val BROWSER_DOWN = 0
        private const val BROWSER_MOVE = 1
        private const val BROWSER_UP = 2
        private const val BROWSER_CANCEL = 3

        /**
         * Map browser touch action to AA PointerAction.
         * @param browserAction 0=DOWN, 1=MOVE, 2=UP, 3=CANCEL
         * @param allTouchCount total number of active pointers
         */
        fun mapToAaAction(browserAction: Int, allTouchCount: Int): Int {
            return when (browserAction) {
                BROWSER_DOWN -> if (allTouchCount > 1) ACTION_POINTER_DOWN else ACTION_DOWN
                BROWSER_UP, BROWSER_CANCEL -> if (allTouchCount > 0) ACTION_POINTER_UP else ACTION_UP
                BROWSER_MOVE -> ACTION_MOVE
                else -> ACTION_DOWN
            }
        }
    }
}
