package fr.sd.taada;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import fr.sd.taada.activities.MicActivity;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.helpers.HexHelper;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.ReviewRequestManager;
import fr.sd.taada.helpers.event.EventHelper;
import fr.sd.taada.proto.PingRequest;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import javax.net.ssl.SSLEngine;
import p024d2.MessageProcessor;
import p024d2.ProtocolMessage;
import p024d2.ProtocolMessagePool;
import p048h2.MessageHandler;
import p066k2.SSLHandler;
import p066k2.SSLHelper;

/* JADX INFO: loaded from: classes2.dex */
public class CommunicationHandler {
    private static final byte[] CAR_HELLO_DATA = {0, 3, 0, 6, 0, 1, 0, 1, 0, 6};
    private static final byte[] CLEARTEXT_DATA = {0, 3, 0, 4, 0, 4, 8, 0};
    private static final byte[] EXIT_MESSAGE_DATA = {0, 15, 8, 1};
    private static final String TAG = "HU-CommunicationHandler";
    private Socket clientSocket;
    private Thread connectionThread;
    private final LogManager logManager;
    private MessageHandler messageHandler;
    private final ProtocolMessagePool messagePool;
    private MessageProcessor messageProcessor;
    private final TransporterService service;
    private SSLEngine sslEngine;
    private SSLHandler sslHandler;

    public class CommunicationRunnable implements Runnable {
        private int messageCount;

        private CommunicationRunnable() {
            this.messageCount = 0;
        }

        private void handleCommunicationError(Throwable th) {
            th.printStackTrace();
            HashMap map = new HashMap();
            map.put("error_step", "android_auto_handshake");
            map.put("error_message", th.getMessage() != null ? th.getMessage() : "Unknown Handshake Error");
            TelemetryManager.getInstance().log(FunnelEvent.CONNECTION_FAILURE, map);
            try {
                CommunicationHandler.this.clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String message = th.getMessage();
            if (message == null) {
                message = "Unknown error. If you are trying to connect over Wifi, probably the server is stuck.\nTry force closing Google Play Services on the phone.";
            }
            Toast.makeText(CommunicationHandler.this.service, message, 1).show();
        }

        private void handleCommunicationException(Exception exc) {
            CommunicationHandler.this.logManager.logError(CommunicationHandler.TAG, "Communication error: " + exc.getMessage(), exc);
            synchronized (TransporterService.STATIC_FIELDS_LOCK) {
                TransporterService.isVideoActive = false;
            }
        }

        private void handleFatalError(Throwable th) throws Throwable {
            CommunicationHandler.this.logManager.logError(CommunicationHandler.TAG, "💥 FATAL: Unrecoverable error in communication thread", th);
            synchronized (TransporterService.STATIC_FIELDS_LOCK) {
                TransporterService.isVideoActive = false;
            }
            Intent intent = new Intent(CommunicationHandler.this.service, (Class<?>) MicActivity.class);
            intent.setFlags(268435456);
            intent.setAction("fr.sd.taada.STOP");
            CommunicationHandler.this.service.startActivity(intent);
            CommunicationHandler.this.service.stopSelf();
            CommunicationHandler.this.service.stopForeground(true);
            throw th;
        }

        private void handleOutOfMemoryError(OutOfMemoryError outOfMemoryError) {
            CommunicationHandler.this.logManager.logError(CommunicationHandler.TAG, "❌ CRITICAL: OutOfMemoryError during message processing!", outOfMemoryError);
            synchronized (TransporterService.STATIC_FIELDS_LOCK) {
                TransporterService.isServiceActive = false;
                TransporterService.isConnected = false;
                TransporterService.isVideoActive = false;
            }
            Toast.makeText(CommunicationHandler.this.service, "❌ Mémoire insuffisante. Redémarrage du service...", 1).show();
            final Intent intent = new Intent(CommunicationHandler.this.service, (Class<?>) TransporterService.class);
            CommunicationHandler.this.service.stopSelf();
            new Handler(CommunicationHandler.this.service.getMainLooper()).postDelayed(new Runnable() { // from class: fr.sd.taada.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3258a.lambda$handleOutOfMemoryError$0(intent);
                }
            }, 3000L);
        }

        private void initializeComponents() {
            initializeSSLHandler();
            initializeMessageProcessor();
            sendCleartextMessage();
        }

        private void initializeMessageProcessor() {
            CommunicationHandler communicationHandler = CommunicationHandler.this;
            communicationHandler.messageProcessor = new MessageProcessor(communicationHandler.service);
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "MessageProcessor initialized");
        }

        private void initializeSSLHandler() {
            CommunicationHandler.this.sslHandler = new SSLHandler(CommunicationHandler.this.sslEngine, CommunicationHandler.this.messageHandler, true, CommunicationHandler.this.service);
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "SSL Handler initialized");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleOutOfMemoryError$0(Intent intent) {
            CommunicationHandler.this.logManager.logInfo(CommunicationHandler.TAG, "🔄 Attempting service restart after OOM...");
            CommunicationHandler.this.service.startService(intent);
        }

        private void performHandshake() {
            sendCarHello();
            readPhoneHello();
            TelemetryManager.getInstance().log(FunnelEvent.AA_HANDSHAKE_SUCCESS);
        }

        private void processMessages() throws Throwable {
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "Entering main communication loop");
            while (TransporterService.isServiceActive) {
                try {
                    int i = this.messageCount + 1;
                    this.messageCount = i;
                    processSingleMessage(i);
                } catch (Exception e) {
                    handleCommunicationException(e);
                } catch (OutOfMemoryError e6) {
                    handleOutOfMemoryError(e6);
                    return;
                } catch (Throwable th) {
                    handleFatalError(th);
                    throw th;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void processSingleMessage(int r6) {
            /*
                r5 = this;
                java.lang.String r0 = "HU-CommunicationHandler"
                java.lang.String r1 = "Processing message #"
                r2 = 0
                fr.sd.taada.CommunicationHandler r3 = fr.sd.taada.CommunicationHandler.this     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                p048h2.MessageHandler r3 = fr.sd.taada.CommunicationHandler.access$600(r3)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                byte[] r2 = r3.readData()     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                if (r2 == 0) goto Lc5
                int r3 = r2.length     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                if (r3 != 0) goto L16
                goto Lc5
            L16:
                fr.sd.taada.CommunicationHandler r3 = fr.sd.taada.CommunicationHandler.this     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                fr.sd.taada.helpers.LogManager r3 = fr.sd.taada.CommunicationHandler.access$200(r3)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                boolean r3 = r3.isDebugEnabled(r0)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                if (r3 == 0) goto L49
                fr.sd.taada.CommunicationHandler r3 = fr.sd.taada.CommunicationHandler.this     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                fr.sd.taada.helpers.LogManager r3 = fr.sd.taada.CommunicationHandler.access$200(r3)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                r4.<init>(r1)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                r4.append(r6)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                java.lang.String r6 = ", raw size: "
                r4.append(r6)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                int r6 = r2.length     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                r4.append(r6)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                java.lang.String r6 = r4.toString()     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                r3.logDebug(r0, r6)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                goto L49
            L41:
                r6 = move-exception
                goto L60
            L43:
                r6 = move-exception
                goto L7c
            L45:
                r6 = move-exception
                goto L98
            L47:
                r6 = move-exception
                goto L98
            L49:
                p024d2.ProtocolMessage r6 = new p024d2.ProtocolMessage     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                fr.sd.taada.CommunicationHandler r1 = fr.sd.taada.CommunicationHandler.this     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                p066k2.SSLHandler r1 = fr.sd.taada.CommunicationHandler.access$800(r1)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                r6.<init>(r2, r1)     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
                fr.sd.taada.CommunicationHandler r1 = fr.sd.taada.CommunicationHandler.this     // Catch: java.lang.Throwable -> L5e
                p024d2.MessageProcessor r1 = fr.sd.taada.CommunicationHandler.access$900(r1)     // Catch: java.lang.Throwable -> L5e
                r1.processMessage(r6)     // Catch: java.lang.Throwable -> L5e
                return
            L5e:
                r6 = move-exception
                throw r6     // Catch: java.io.IOException -> L41 javax.net.ssl.SSLException -> L43 java.lang.ArrayIndexOutOfBoundsException -> L45 java.lang.IllegalArgumentException -> L47
            L60:
                fr.sd.taada.CommunicationHandler r1 = fr.sd.taada.CommunicationHandler.this
                fr.sd.taada.helpers.LogManager r1 = fr.sd.taada.CommunicationHandler.access$200(r1)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "IO error reading message: "
                r2.<init>(r3)
                java.lang.String r6 = r6.getMessage()
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                r1.logError(r0, r6)
                goto Lc5
            L7c:
                fr.sd.taada.CommunicationHandler r1 = fr.sd.taada.CommunicationHandler.this
                fr.sd.taada.helpers.LogManager r1 = fr.sd.taada.CommunicationHandler.access$200(r1)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "SSL decryption failed: "
                r2.<init>(r3)
                java.lang.String r6 = r6.getMessage()
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                r1.logError(r0, r6)
                goto Lc5
            L98:
                fr.sd.taada.CommunicationHandler r1 = fr.sd.taada.CommunicationHandler.this
                fr.sd.taada.helpers.LogManager r1 = fr.sd.taada.CommunicationHandler.access$200(r1)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Message parsing failed - Length: "
                r3.<init>(r4)
                if (r2 == 0) goto Lad
                int r2 = r2.length
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto Laf
            Lad:
                java.lang.String r2 = "null"
            Laf:
                r3.append(r2)
                java.lang.String r2 = ", Error: "
                r3.append(r2)
                java.lang.String r6 = r6.getMessage()
                r3.append(r6)
                java.lang.String r6 = r3.toString()
                r1.logError(r0, r6)
            Lc5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.CommunicationHandler.CommunicationRunnable.processSingleMessage(int):void");
        }

        private void readPhoneHello() {
            String str;
            byte[] data = CommunicationHandler.this.messageHandler.readData(2000);
            LogManager logManager = CommunicationHandler.this.logManager;
            StringBuilder sb = new StringBuilder("Phone Hello received: ");
            if (data != null) {
                str = "length=" + data.length;
            } else {
                str = "null";
            }
            sb.append(str);
            logManager.logDebug(CommunicationHandler.TAG, sb.toString());
        }

        private void sendCarHello() {
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "Sending Car Hello: " + HexHelper.bytesToHexString(CommunicationHandler.CAR_HELLO_DATA));
            CommunicationHandler.this.messageHandler.sendData(CommunicationHandler.CAR_HELLO_DATA, 500);
        }

        private void sendCleartextMessage() {
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "Sending cleartext: " + HexHelper.bytesToHexString(CommunicationHandler.CLEARTEXT_DATA));
            CommunicationHandler.this.messageHandler.sendData(CommunicationHandler.CLEARTEXT_DATA);
        }

        private void sendExitMessage() {
            ProtocolMessage protocolMessageCreateMessage = CommunicationHandler.this.messagePool.createMessage((byte) 0, (byte) 3, 0, CommunicationHandler.EXIT_MESSAGE_DATA);
            try {
                CommunicationHandler.this.messageHandler.sendData(protocolMessageCreateMessage.encryptWithSSL(CommunicationHandler.this.sslHandler));
                CommunicationHandler.this.messagePool.recycleMessage(protocolMessageCreateMessage);
                synchronized (TransporterService.STATIC_FIELDS_LOCK) {
                    TransporterService.isVideoActive = false;
                }
                Intent intent = new Intent(CommunicationHandler.this.service, (Class<?>) MicActivity.class);
                intent.setFlags(268435456);
                intent.setAction("fr.sd.taada.STOP");
                CommunicationHandler.this.service.startActivity(intent);
                CommunicationHandler.this.service.stopSelf();
                CommunicationHandler.this.service.stopForeground(true);
            } catch (Throwable th) {
                CommunicationHandler.this.messagePool.recycleMessage(protocolMessageCreateMessage);
                throw th;
            }
        }

        private void setupSSL() {
            CommunicationHandler communicationHandler = CommunicationHandler.this;
            communicationHandler.sslEngine = SSLHelper.createSSLEngine(communicationHandler.service.getBaseContext(), R.raw.keystore, "aa");
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "SSL Engine created successfully");
        }

        private void startConnection() {
            synchronized (TransporterService.STATIC_FIELDS_LOCK) {
                TransporterService.isConnected = true;
            }
            if (TransporterService.isVideoActive) {
                ReviewRequestManager.getInstance(CommunicationHandler.this.service).onSessionStarted();
            }
            CommunicationHandler.this.sendHeartbeat();
        }

        @Override // java.lang.Runnable
        public void run() {
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "===== COMMUNICATION THREAD STARTED =====");
            Looper.prepare();
            try {
                setupSSL();
                performHandshake();
                initializeComponents();
                startConnection();
                processMessages();
                sendExitMessage();
            } catch (Throwable th) {
                handleCommunicationError(th);
            }
        }
    }

    public class HeartbeatRunnable implements Runnable {
        private int heartbeatCount;

        private HeartbeatRunnable() {
            this.heartbeatCount = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TransporterService.isServiceActive) {
                CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "Heartbeat stopped: service is no longer active");
                return;
            }
            this.heartbeatCount++;
            CommunicationHandler.this.logManager.logDebug(CommunicationHandler.TAG, "Heartbeat #" + this.heartbeatCount + " scheduled");
            CommunicationHandler.this.sendHeartbeat();
        }
    }

    public CommunicationHandler(TransporterService transporterService) {
        this.service = transporterService;
        this.logManager = transporterService.getLogManager();
        this.messagePool = transporterService.getMessagePool();
    }

    private void configureSocket() throws SocketException {
        this.clientSocket.setSoTimeout(10000);
        this.clientSocket.setTcpNoDelay(true);
        this.clientSocket.setKeepAlive(true);
        this.clientSocket.setReuseAddress(true);
        this.clientSocket.setTrafficClass(16);
        this.clientSocket.setReceiveBufferSize(1048576);
        this.clientSocket.setSendBufferSize(1048576);
    }

    public void closeResources() {
        try {
            Socket socket = this.clientSocket;
            if (socket != null && !socket.isClosed()) {
                this.clientSocket.close();
            }
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error closing client socket", e);
        }
        try {
            Thread thread = this.connectionThread;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (Exception e6) {
            this.logManager.logError(TAG, "Error interrupting connection thread", e6);
        }
    }

    public MessageHandler getMessageHandler() {
        return this.messageHandler;
    }

    public SSLHandler getSslHandler() {
        return this.sslHandler;
    }

    public void sendHeartbeat() {
        PingRequest.Builder builderNewBuilder = PingRequest.newBuilder();
        builderNewBuilder.setTimestamp(System.currentTimeMillis());
        EventHelper.getEventBus().post(this.messagePool.createMessage((byte) 0, (byte) 3, 11, builderNewBuilder));
        new Handler(this.service.getMainLooper()).postDelayed(new HeartbeatRunnable(), 2000L);
    }

    public void setupConnection(Socket socket) {
        this.clientSocket = socket;
        try {
            configureSocket();
            this.messageHandler = new MessageHandler(socket.getInputStream(), socket.getOutputStream());
            Thread thread = new Thread(new CommunicationRunnable());
            this.connectionThread = thread;
            thread.start();
        } catch (Exception e) {
            this.logManager.logError(TAG, "Error setting up connection", e);
        }
    }
}
