package fr.sd.taada.helpers.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.a;
import androidx.preference.PreferenceManager;
import fr.sd.taada.TransporterService;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.Insets;
import fr.sd.taada.proto.MediaMessageId;
import fr.sd.taada.proto.UiConfig;
import fr.sd.taada.proto.UpdateUiConfigRequest;
import fr.sd.taada.proto.VideoFocusMode;
import fr.sd.taada.proto.VideoFocusNotification;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import p024d2.ProtocolMessage;
import p054i2.VideoResolutionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class NalStreamManager {
    private static final String TAG = "NalStreamManager";
    private static LogManager logManager;
    private static final ByteBuffer nalBuffer = ByteBuffer.allocateDirect(8388608);
    public static final ExecutorService ackThread = Executors.newSingleThreadExecutor();
    private static Boolean hasfocus = null;
    private static final FpsTracker serverFpsTracker = new FpsTracker(false);
    private static final FpsTracker clientFpsTracker = new FpsTracker(true);
    private static boolean hasReceivedFirstFrame = false;

    public static class MarginResult {
        public final int heightMargin;
        public final int widthMargin;

        public MarginResult(int i, int i3) {
            this.widthMargin = i;
            this.heightMargin = i3;
        }
    }

    public static class RunnableC2468a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            NalStreamManager.toogleVideoFocus(true);
        }
    }

    public static MarginResult adjustResolution(Context context, int i, int i3) {
        getLogManager(context).logDebug(TAG, a.n("Adjusting resolution to ", i, "x", i3));
        VideoResolutionHelper.setScreenDimensions(i, i3);
        return updateUiConfig(context, i, i3);
    }

    public static void buildNal(byte b, byte[] bArr, int i, MediaMessageId mediaMessageId) {
        if (b == 3) {
            if (mediaMessageId == MediaMessageId.MEDIA_MESSAGE_DATA) {
                process(ByteBuffer.wrap(bArr, 10, bArr.length - 10));
                return;
            }
            if (mediaMessageId == MediaMessageId.MEDIA_MESSAGE_CODEC_CONFIG && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 1) {
                process(ByteBuffer.wrap(bArr, 2, bArr.length - 2));
                return;
            }
            return;
        }
        if (b == 1) {
            ByteBuffer byteBuffer = nalBuffer;
            byteBuffer.clear();
            if (mediaMessageId == MediaMessageId.MEDIA_MESSAGE_DATA) {
                byteBuffer.put(bArr, 10, bArr.length - 10);
                return;
            } else {
                if (mediaMessageId == MediaMessageId.MEDIA_MESSAGE_CODEC_CONFIG) {
                    byteBuffer.put(bArr, 2, bArr.length - 2);
                    return;
                }
                return;
            }
        }
        if (b == 0) {
            nalBuffer.put(bArr);
            return;
        }
        if (b != 2) {
            if (b == 127) {
                process(ByteBuffer.wrap(bArr));
            }
        } else {
            ByteBuffer byteBuffer2 = nalBuffer;
            byteBuffer2.put(bArr);
            byteBuffer2.flip();
            process(byteBuffer2);
        }
    }

    public static Map<String, Object> getAllFpsStats() {
        HashMap map = new HashMap();
        map.putAll(serverFpsTracker.getStatsMap("server_"));
        map.putAll(clientFpsTracker.getStatsMap("client_"));
        return map;
    }

    private static LogManager getLogManager(Context context) {
        if (logManager == null) {
            logManager = LogManager.getInstance(context);
        }
        return logManager;
    }

    public static void process(ByteBuffer byteBuffer) {
        TransporterService.getInstance().controlAndVideoSocketServer.m2579j0(byteBuffer);
        serverFpsTracker.onFrame();
        if (hasReceivedFirstFrame) {
            return;
        }
        hasReceivedFirstFrame = true;
        TelemetryManager.getInstance().log(FunnelEvent.FIRST_FRAME_RECEIVED);
        TelemetryManager.getInstance().log(FunnelEvent.STREAM_STARTED);
        getLogManager(null).logInfo(TAG, "Telemetrie: First Frame Received, Stream Started");
    }

    public static void requestKeyFrame() {
        Boolean bool;
        getLogManager(null).logDebug(TAG, "Requesting keyframe using direct method");
        if (!TransporterService.isVideoActive || (bool = hasfocus) == null || !bool.booleanValue()) {
            getLogManager(null).logDebug(TAG, "Video is not active, can't request keyframe");
            return;
        }
        try {
            VideoFocusNotification.Builder builderNewBuilder = VideoFocusNotification.newBuilder();
            builderNewBuilder.setFocus(VideoFocusMode.VIDEO_FOCUS_PROJECTED);
            builderNewBuilder.setUnsolicited(true);
            EventBus.getDefault().post(new ProtocolMessage((byte) 3, (byte) 3, 32775, builderNewBuilder));
            getLogManager(null).logDebug(TAG, "Keyframe request sent via VIDEO_FOCUS_REQUEST");
        } catch (Exception e) {
            getLogManager(null).logError(TAG, "Error requesting keyframe", e);
            throw e;
        }
    }

    public static void resetStats() {
        serverFpsTracker.reset();
        clientFpsTracker.reset();
        hasReceivedFirstFrame = false;
    }

    public static void toogleVideoFocus(boolean z6) {
        if (!TransporterService.isVideoActive && z6) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC2468a(), 300L);
            return;
        }
        if (Boolean.valueOf(z6).equals(hasfocus)) {
            System.out.println("Same focus request, igrnoring: " + z6);
            return;
        }
        hasfocus = Boolean.valueOf(z6);
        if (z6) {
            TelemetryManager.getInstance().log(FunnelEvent.STREAM_RESUMED);
        } else {
            TelemetryManager.getInstance().log(FunnelEvent.STREAM_PAUSED);
        }
        VideoFocusNotification.Builder builderNewBuilder = VideoFocusNotification.newBuilder();
        builderNewBuilder.setFocus(z6 ? VideoFocusMode.VIDEO_FOCUS_PROJECTED : VideoFocusMode.VIDEO_FOCUS_NATIVE);
        builderNewBuilder.setUnsolicited(true);
        getLogManager(null).logDebug("HU-MEDIACODEC", "Sending video focus: " + builderNewBuilder);
        EventBus.getDefault().post(new ProtocolMessage((byte) 3, (byte) 3, 32776, builderNewBuilder));
    }

    public static void updateClientFps(int i) {
        clientFpsTracker.onFpsReported(i);
    }

    private static MarginResult updateUiConfig(Context context, int i, int i3) {
        getLogManager(context).logDebug(TAG, a.n("Sending UpdateUiConfigRequest for dimensions: ", i, "x", i3));
        try {
            Insets.Builder builderNewBuilder = Insets.newBuilder();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            int i4 = Integer.parseInt(defaultSharedPreferences.getString("resolution", "1"));
            int iIntValue = VideoResolutionHelper.calculateVerticalOffset(i4).intValue();
            int iIntValue2 = VideoResolutionHelper.calculateHorizontalOffset(i4).intValue();
            builderNewBuilder.setLeft(0);
            builderNewBuilder.setTop(0);
            builderNewBuilder.setRight(iIntValue2);
            builderNewBuilder.setBottom(iIntValue);
            UiConfig.Builder builderNewBuilder2 = UiConfig.newBuilder();
            builderNewBuilder2.setMargins(builderNewBuilder);
            UpdateUiConfigRequest.Builder builderNewBuilder3 = UpdateUiConfigRequest.newBuilder();
            builderNewBuilder3.setUiConfig(builderNewBuilder2);
            EventBus.getDefault().post(new ProtocolMessage((byte) 3, (byte) 3, 32777, builderNewBuilder3));
            defaultSharedPreferences.edit().putInt("widthMargin", iIntValue2).putInt("heightMargin", iIntValue).apply();
            return new MarginResult(iIntValue2, iIntValue);
        } catch (Exception e) {
            getLogManager(context).logError(TAG, "Error sending UpdateUiConfigRequest", e);
            return new MarginResult(0, 0);
        }
    }
}
