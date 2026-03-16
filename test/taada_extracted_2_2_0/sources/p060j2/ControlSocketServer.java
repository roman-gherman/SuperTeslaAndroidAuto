package p060j2;

import android.content.Context;
import android.os.Handler;
import androidx.constraintlayout.core.motion.a;
import androidx.core.os.EnvironmentCompat;
import fr.sd.taada.R;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.b;
import fr.sd.taada.helpers.input.OptimizedTouchEventHandler;
import fr.sd.taada.helpers.video.NalStreamManager;
import fr.sd.taada.proto.Ack;
import fr.sd.taada.proto.LocationData;
import fr.sd.taada.proto.NightModeData;
import fr.sd.taada.proto.PointerAction;
import fr.sd.taada.proto.SensorBatch;
import fr.sd.taada.proto.TouchEvent;
import fr.sd.taada.protocol.BinaryTouchDecoder;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import org.greenrobot.eventbus.EventBus;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.DefaultSSLWebSocketServerFactory;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p024d2.ProtocolMessagePool;
import p030e2.AbstractC2147a;
import p066k2.SSLHelper;

/* JADX INFO: loaded from: classes.dex */
public class ControlSocketServer extends WebSocketServer {
    private static final String TAG = "ControlSocketServer";
    private static final byte[] f8698G = {0, 0, 0, 0, 31};
    private static long lastKeyframeRequestTime;
    private final BinaryTouchDecoder binaryTouchDecoder;
    private Context context;
    private WebSocket f8699C;
    private SSLContext f8700D;
    final Handler f8701E;
    final Runnable f8702F;
    private LogManager logManager;
    private final ProtocolMessagePool messagePool;

    public class RunnableC2758a implements Runnable {
        public RunnableC2758a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NalStreamManager.toogleVideoFocus(false);
        }
    }

    public ControlSocketServer(InetSocketAddress inetSocketAddress, Context context) {
        super(inetSocketAddress, (List<Draft>) Collections.singletonList(new Draft_6455((List<IExtension>) Collections.EMPTY_LIST)));
        this.context = context;
        this.f8701E = new Handler();
        this.f8702F = new RunnableC2758a();
        this.messagePool = ProtocolMessagePool.getInstance();
        this.binaryTouchDecoder = new BinaryTouchDecoder();
        setTcpNoDelay(true);
        try {
            SSLContext sSLContextCreateSSLContext = SSLHelper.createSSLContext(context, R.raw.server_pbe, "aa");
            this.f8700D = sSLContextCreateSSLContext;
            setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sSLContextCreateSSLContext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int findNewPointerIndex(List<BinaryTouchDecoder.TouchPoint> list, List<BinaryTouchDecoder.TouchPoint> list2) {
        try {
            if (list.size() > 0) {
                int i = list.get(0).id;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if (list2.get(i3).id == i) {
                        return i3;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.context);
        }
        return this.logManager;
    }

    private void handleAckAction() {
        Ack.Builder builderNewBuilder = Ack.newBuilder();
        builderNewBuilder.setSessionId(AbstractC2147a.f7665c.get((byte) 3).intValue());
        builderNewBuilder.setAck(1);
        EventBus.getDefault().post(this.messagePool.createMessage((byte) 3, (byte) 3, 32772, builderNewBuilder));
    }

    private void handleAction(String str, JSONObject jSONObject, WebSocket webSocket) {
        str.getClass();
        switch (str) {
            case "MULTITOUCH_DOWN":
                handleMultiTouchEvent(jSONObject, PointerAction.ACTION_DOWN);
                break;
            case "MULTITOUCH_MOVE":
                handleMultiTouchEvent(jSONObject, PointerAction.ACTION_MOVED);
                break;
            case "RELOAD":
                handleReloadAction();
                break;
            case "MULTITOUCH_CANCEL":
                handleMultiTouchEvent(jSONObject, PointerAction.ACTION_UP);
                break;
            case "MULTITOUCH_UP":
                handleMultiTouchEvent(jSONObject, PointerAction.ACTION_UP);
                break;
            case "REQUEST_KEYFRAME":
                handleRequestKeyframeAction(webSocket);
                break;
            case "ACK":
                handleAckAction();
                break;
            case "GPS":
                handleGpsAction(jSONObject);
                break;
            case "PING":
                handlePingAction(jSONObject);
                break;
            case "STOP":
                handleStopAction();
                break;
            case "NIGHT":
                handleNightAction(jSONObject);
                break;
            case "START":
                handleStartAction();
                break;
            default:
                getLogManager().logDebug(TAG, "Unknown action received: ".concat(str));
                try {
                    webSocket.send("{\"error\":\"Unknown action: " + str + "\"}");
                    break;
                } catch (Exception e) {
                    getLogManager().logDebug(TAG, "Failed to send error response: " + e.getMessage());
                    return;
                }
                break;
        }
    }

    private void handleBinaryTouchEvent(BinaryTouchDecoder.TouchEvent touchEvent) {
        PointerAction pointerAction;
        try {
            int i = touchEvent.action;
            if (i == 0) {
                pointerAction = PointerAction.ACTION_DOWN;
            } else if (i == 1) {
                pointerAction = PointerAction.ACTION_MOVED;
            } else if (i == 2) {
                pointerAction = PointerAction.ACTION_UP;
            } else {
                if (i != 3) {
                    getLogManager().logDebug(TAG, "Unknown binary touch action: " + touchEvent.action);
                    return;
                }
                pointerAction = PointerAction.ACTION_DOWN;
            }
            processMultiTouchEvent(pointerAction, touchEvent.touches, touchEvent.allTouches);
        } catch (Exception e) {
            getLogManager().logDebug(TAG, "Error handling binary touch event: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleGpsAction(JSONObject jSONObject) {
        SensorBatch.Builder builderNewBuilder = SensorBatch.newBuilder();
        LocationData.Builder builderNewBuilder2 = LocationData.newBuilder();
        try {
            builderNewBuilder2.setAccuracyE3((int) (jSONObject.getDouble("accuracy") * 1000.0d));
        } catch (JSONException unused) {
        }
        try {
            builderNewBuilder2.setLatitudeE7((int) (jSONObject.getDouble("latitude") * 1.0E7d));
        } catch (JSONException unused2) {
        }
        try {
            builderNewBuilder2.setLongitudeE7((int) (jSONObject.getDouble("longitude") * 1.0E7d));
        } catch (JSONException unused3) {
        }
        try {
            builderNewBuilder2.setAltitudeE2((int) (jSONObject.getDouble("altitude") * 100.0d));
        } catch (JSONException unused4) {
        }
        try {
            builderNewBuilder2.setBearingE6((int) (jSONObject.getDouble("heading") * 1000000.0d));
        } catch (JSONException unused5) {
        }
        try {
            builderNewBuilder2.setSpeedE3((int) (jSONObject.getDouble("speed") * 100.0d));
        } catch (JSONException unused6) {
        }
        builderNewBuilder.addLocationData(builderNewBuilder2);
        EventBus.getDefault().post(this.messagePool.createMessage((byte) 2, (byte) 3, 32771, builderNewBuilder));
    }

    private void handleMultiTouchEvent(JSONObject jSONObject, PointerAction pointerAction) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("touches");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("allTouches");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new BinaryTouchDecoder.TouchPoint(jSONObject2.getInt("id"), jSONObject2.getInt("x"), jSONObject2.getInt("y")));
            }
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i3);
                    arrayList2.add(new BinaryTouchDecoder.TouchPoint(jSONObject3.getInt("id"), jSONObject3.getInt("x"), jSONObject3.getInt("y")));
                }
            }
            processMultiTouchEvent(pointerAction, arrayList, arrayList2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleNightAction(JSONObject jSONObject) {
        try {
            SensorBatch.Builder builderNewBuilder = SensorBatch.newBuilder();
            NightModeData.Builder builderNewBuilder2 = NightModeData.newBuilder();
            builderNewBuilder2.setNightMode(jSONObject.getBoolean("value"));
            builderNewBuilder.addNightModeData(builderNewBuilder2);
            EventBus.getDefault().post(this.messagePool.createMessage((byte) 2, (byte) 3, 32771, builderNewBuilder));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handlePingAction(JSONObject jSONObject) {
        if (jSONObject.has("fps")) {
            try {
                NalStreamManager.updateClientFps(jSONObject.getInt("fps"));
            } catch (JSONException unused) {
            }
        }
        try {
            this.f8699C.send(f8698G);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f8701E.removeCallbacks(this.f8702F);
        } catch (Exception unused2) {
        }
        this.f8701E.postDelayed(this.f8702F, 3000L);
    }

    private void handleReloadAction() {
        getLogManager().logDebug("ACK", "REload request from browser");
        NalStreamManager.toogleVideoFocus(false);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        NalStreamManager.toogleVideoFocus(true);
    }

    private static void handleRequestKeyframeAction(WebSocket webSocket, LogManager logManager) {
        StringBuilder sb = new StringBuilder("Keyframe requested - source: ");
        sb.append(webSocket != null ? webSocket.getRemoteSocketAddress() : EnvironmentCompat.MEDIA_UNKNOWN);
        logManager.logDebug(TAG, sb.toString());
        if (System.currentTimeMillis() - lastKeyframeRequestTime < 2000) {
            logManager.logDebug(TAG, "Ignoring keyframe request, too soon after previous request");
            return;
        }
        lastKeyframeRequestTime = System.currentTimeMillis();
        TelemetryManager.getInstance().log(FunnelEvent.KEYFRAME_REQUESTED);
        try {
            NalStreamManager.requestKeyFrame();
        } catch (Exception e) {
            logManager.logDebug(TAG, "Error requesting keyframe with requestKeyFrame(), falling back to toggle: " + e.getMessage());
            NalStreamManager.toogleVideoFocus(false);
            new Handler().postDelayed(new b(logManager, 3), 500L);
        }
    }

    private void handleStartAction() {
        getLogManager().logDebug(TAG, "start video");
        TelemetryManager.getInstance().log(FunnelEvent.STREAM_REQUESTED);
        try {
            this.f8701E.removeCallbacks(this.f8702F);
        } catch (Exception unused) {
        }
        NalStreamManager.toogleVideoFocus(true);
    }

    private void handleStopAction() {
        TelemetryManager.getInstance().log(FunnelEvent.STREAM_STOPPED);
        NalStreamManager.toogleVideoFocus(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleRequestKeyframeAction$0(LogManager logManager) {
        logManager.logDebug(TAG, "Re-enabling video to generate new keyframe");
        NalStreamManager.toogleVideoFocus(true);
    }

    private void processMultiTouchEvent(PointerAction pointerAction, List<BinaryTouchDecoder.TouchPoint> list, List<BinaryTouchDecoder.TouchPoint> list2) {
        try {
            getLogManager().logDebug(TAG, String.format("[PROCESS] action=%s touches=%d allTouches=%d", pointerAction.name(), Integer.valueOf(list.size()), Integer.valueOf(list2.size())));
            int iFindNewPointerIndex = 0;
            if (pointerAction == PointerAction.ACTION_DOWN) {
                if (list2.size() > 1) {
                    pointerAction = PointerAction.ACTION_POINTER_DOWN;
                    iFindNewPointerIndex = findNewPointerIndex(list, list2);
                    getLogManager().logDebug(TAG, String.format("[PROCESS] Changed to POINTER_DOWN, actionIndex=%d", Integer.valueOf(iFindNewPointerIndex)));
                }
                if (list2.size() > 0) {
                    list = list2;
                }
            } else if (pointerAction == PointerAction.ACTION_UP) {
                if (list2.size() > 0) {
                    pointerAction = PointerAction.ACTION_POINTER_UP;
                    ArrayList arrayList = new ArrayList(list2.size() + list.size());
                    arrayList.addAll(list);
                    arrayList.addAll(list2);
                    getLogManager().logDebug(TAG, String.format("[PROCESS] Changed to POINTER_UP, actionIndex=%d, merged %d touches", 0, Integer.valueOf(arrayList.size())));
                    list = arrayList;
                }
            } else if (list2.size() > 0) {
                list = list2;
            }
            TouchEvent.Builder builderNewBuilder = TouchEvent.newBuilder();
            builderNewBuilder.setAction(pointerAction);
            builderNewBuilder.setActionIndex(iFindNewPointerIndex);
            getLogManager().logDebug(TAG, String.format("[PROCESS] Using %d pointers for realAction=%s", Integer.valueOf(list.size()), pointerAction.name()));
            for (BinaryTouchDecoder.TouchPoint touchPoint : list) {
                TouchEvent.Pointer.Builder builderNewBuilder2 = TouchEvent.Pointer.newBuilder();
                builderNewBuilder2.setX(touchPoint.x);
                builderNewBuilder2.setY(touchPoint.y);
                builderNewBuilder2.setPointerId(touchPoint.id);
                builderNewBuilder.addPointerData(builderNewBuilder2.build());
            }
            OptimizedTouchEventHandler.queueTouchEvent(builderNewBuilder, pointerAction);
        } catch (Exception e) {
            getLogManager().logDebug(TAG, "Error processing multitouch event: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void m2579j0(ByteBuffer byteBuffer) {
        WebSocket webSocket = this.f8699C;
        if (webSocket == null || !webSocket.isOpen()) {
            return;
        }
        this.f8699C.send(byteBuffer);
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onClose(WebSocket webSocket, int i, String str, boolean z6) {
        getLogManager().logDebug(TAG, "closed " + webSocket.getRemoteSocketAddress() + " with exit code " + i + " additional info: " + str);
        TelemetryManager telemetryManager = TelemetryManager.getInstance();
        FunnelEvent funnelEvent = FunnelEvent.STREAM_STOPPED;
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("reason", "websocket_closed"), new AbstractMap.SimpleEntry("exit_code", String.valueOf(i))};
        HashMap map = new HashMap(2);
        for (int i3 = 0; i3 < 2; i3++) {
            Map.Entry entry = entryArr[i3];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException(a.m(key, "duplicate key: "));
            }
        }
        telemetryManager.log(funnelEvent, Collections.unmodifiableMap(map));
        NalStreamManager.toogleVideoFocus(false);
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onError(WebSocket webSocket, Exception exc) {
        if (exc != null) {
            String message = EnvironmentCompat.MEDIA_UNKNOWN;
            String string = webSocket != null ? webSocket.getRemoteSocketAddress().toString() : EnvironmentCompat.MEDIA_UNKNOWN;
            LogManager logManager = getLogManager();
            StringBuilder sbM = B2.b.m("WebSocket error from ", string, ": ");
            sbM.append(exc.getMessage());
            logManager.logDebug(TAG, sbM.toString());
            exc.printStackTrace();
            TelemetryManager telemetryManager = TelemetryManager.getInstance();
            FunnelEvent funnelEvent = FunnelEvent.STREAM_FAILED;
            String simpleName = exc.getClass().getSimpleName();
            if (exc.getMessage() != null) {
                message = exc.getMessage();
            }
            Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("error_code", simpleName), new AbstractMap.SimpleEntry("error_message", message)};
            HashMap map = new HashMap(2);
            for (int i = 0; i < 2; i++) {
                Map.Entry entry = entryArr[i];
                Object key = entry.getKey();
                Objects.requireNonNull(key);
                Object value = entry.getValue();
                Objects.requireNonNull(value);
                if (map.put(key, value) != null) {
                    throw new IllegalArgumentException(a.m(key, "duplicate key: "));
                }
            }
            telemetryManager.log(funnelEvent, Collections.unmodifiableMap(map));
            if (webSocket != null) {
                try {
                    if (webSocket.isOpen()) {
                        webSocket.close(1011, "Internal server error");
                        getLogManager().logDebug(TAG, "Closed WebSocket connection due to error");
                    }
                } catch (Exception e) {
                    getLogManager().logDebug(TAG, "Failed to close WebSocket connection: " + e.getMessage());
                }
            }
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, String str) {
        if (str.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            handleAction(jSONObject.getString("action"), jSONObject, webSocket);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        getLogManager().logInfo(TAG, "[TIMING] ControlSocketServer.onOpen() - Client CONNECTED from " + webSocket.getRemoteSocketAddress());
        TelemetryManager.getInstance().log(FunnelEvent.WEBSOCKET_CONNECTED);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        setTcpNoDelay(true);
        this.f8699C = webSocket;
        getLogManager().logInfo(TAG, "[TIMING] Client WebSocket connection established and configured");
        NalStreamManager.toogleVideoFocus(false);
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onStart() {
        getLogManager().logInfo(TAG, "[TIMING] ControlSocketServer.onStart() - WebSocket server is NOW LISTENING and ready to accept client connections");
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        try {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.get(bArr);
            if (BinaryTouchDecoder.isBinaryFormat(bArr)) {
                BinaryTouchDecoder.TouchEvent touchEventDecode = this.binaryTouchDecoder.decode(bArr);
                getLogManager().logDebug(TAG, String.format("[BINARY] %s - touches:%d allTouches:%d", touchEventDecode.getActionName(), Integer.valueOf(touchEventDecode.touches.size()), Integer.valueOf(touchEventDecode.allTouches.size())));
                handleBinaryTouchEvent(touchEventDecode);
            } else {
                getLogManager().logDebug(TAG, "Received non-touch binary message, size: " + iRemaining);
            }
        } catch (Exception e) {
            getLogManager().logDebug(TAG, "Error processing binary message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleRequestKeyframeAction(WebSocket webSocket) {
        handleRequestKeyframeAction(webSocket, getLogManager());
    }
}
