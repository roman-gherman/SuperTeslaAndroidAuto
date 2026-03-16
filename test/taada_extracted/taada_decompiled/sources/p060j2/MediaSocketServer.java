package p060j2;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLContext;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.DefaultSSLWebSocketServerFactory;
import org.java_websocket.server.WebSocketServer;
import p066k2.SSLHelper;

/* JADX INFO: loaded from: classes.dex */
public class MediaSocketServer extends WebSocketServer {
    private static final String TAG = "MediaSocketServer";
    private WebSocket f8692C;
    private SSLContext f8693D;
    private ByteBuffer f8694E;
    private LogManager logManager;

    public MediaSocketServer(InetSocketAddress inetSocketAddress, Context context) {
        super(inetSocketAddress);
        this.f8694E = ByteBuffer.allocateDirect(524288);
        setTcpNoDelay(true);
        try {
            SSLContext sSLContextCreateSSLContext = SSLHelper.createSSLContext(context, R.raw.server_pbe, "aa");
            this.f8693D = sSLContextCreateSSLContext;
            setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sSLContextCreateSSLContext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m2580j0(byte[] bArr, boolean z6) {
        try {
            if (!z6) {
                this.f8692C.send(bArr);
                return;
            }
            if (this.f8694E.position() < 1048576) {
                try {
                    this.f8694E.put(bArr);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.f8694E.flip();
                this.f8692C.send(this.f8694E);
                this.f8694E.clear();
            }
        } catch (Exception unused) {
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onClose(WebSocket webSocket, int i, String str, boolean z6) {
        LogManager logManager = this.logManager;
        if (logManager != null) {
            logManager.logDebug(TAG, "WebSocket connection closed: " + webSocket.getRemoteSocketAddress() + ", code: " + i + ", reason: " + str + ", remote: " + z6);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onError(WebSocket webSocket, Exception exc) {
        LogManager logManager = this.logManager;
        if (logManager != null) {
            StringBuilder sb = new StringBuilder("WebSocket error for ");
            sb.append(webSocket != null ? webSocket.getRemoteSocketAddress() : EnvironmentCompat.MEDIA_UNKNOWN);
            sb.append(": ");
            sb.append(exc.getMessage());
            logManager.logError(TAG, sb.toString(), exc);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, String str) {
        LogManager logManager = this.logManager;
        if (logManager != null) {
            logManager.logWarning(TAG, "Received unexpected string message from " + webSocket.getRemoteSocketAddress() + ": " + str);
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        LogManager logManager = this.logManager;
        if (logManager != null) {
            logManager.logInfo(TAG, "[TIMING] MediaSocketServer.onOpen() - Client CONNECTED from " + webSocket.getRemoteSocketAddress());
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            if (this.logManager != null) {
                this.logManager.logError(TAG, "Interrupted while waiting for connection stabilization", e);
            }
            Thread.currentThread().interrupt();
        }
        this.f8692C = webSocket;
        LogManager logManager2 = this.logManager;
        if (logManager2 != null) {
            logManager2.logInfo(TAG, "[TIMING] Client WebSocket connection established and configured");
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onStart() {
        LogManager logManager = this.logManager;
        if (logManager != null) {
            logManager.logInfo(TAG, "[TIMING] MediaSocketServer.onStart() - WebSocket server is NOW LISTENING and ready to accept client connections");
        }
    }

    @Override // org.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        LogManager logManager = this.logManager;
        if (logManager != null) {
            logManager.logWarning(TAG, "Received unexpected byte buffer message from " + webSocket.getRemoteSocketAddress() + ", size: " + byteBuffer.remaining());
        }
    }
}
