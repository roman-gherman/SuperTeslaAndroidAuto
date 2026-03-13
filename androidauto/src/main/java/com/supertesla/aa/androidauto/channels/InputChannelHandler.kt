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
 * Handles input channel (channel 3).
 * Responds to binding requests from the phone and sends touch events.
 */
class InputChannelHandler(
    private val mux: ChannelMux,
    private val displayWidth: Int,
    private val displayHeight: Int
) : ChannelHandler {

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
     * Send a touch event to the Android Auto phone app.
     *
     * @param action 0=DOWN, 1=UP, 2=MOVE
     * @param x X coordinate in display pixels
     * @param y Y coordinate in display pixels
     * @param pointerId pointer ID for multi-touch
     */
    fun sendTouchEvent(action: Int, x: Int, y: Int, pointerId: Int = 0) {
        val timestamp = android.os.SystemClock.elapsedRealtime() * 1_000_000 // convert ms to ns

        val out = ByteArrayOutputStream()

        // InputReport
        // field 1: timestamp (varint, nanoseconds)
        ProtoEncoder.writeVarintField(out, 1, timestamp)

        // field 2: disp_channel_id = VIDEO channel
        ProtoEncoder.writeVarintField(out, 2, ChannelId.VIDEO.toLong())

        // field 3: touch_event (embedded message)
        ProtoEncoder.writeEmbeddedMessage(out, 3) { touchEvent ->
            // pointer_data (field 1, repeated)
            ProtoEncoder.writeEmbeddedMessage(touchEvent, 1) { pointer ->
                ProtoEncoder.writeVarintField(pointer, 1, x.toLong())
                ProtoEncoder.writeVarintField(pointer, 2, y.toLong())
                ProtoEncoder.writeVarintField(pointer, 3, pointerId.toLong())
            }
            // action (field 3)
            ProtoEncoder.writeVarintField(touchEvent, 3, action.toLong())
        }

        mux.sendEncrypted(ChannelId.INPUT, InputMessageType.INPUT_EVENT, out.toByteArray())
    }

    companion object {
        const val ACTION_DOWN = 0
        const val ACTION_UP = 1
        const val ACTION_MOVE = 2
    }
}
