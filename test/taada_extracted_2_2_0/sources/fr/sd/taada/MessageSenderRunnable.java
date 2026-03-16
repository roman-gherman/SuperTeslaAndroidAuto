package fr.sd.taada;

import fr.sd.taada.helpers.HexHelper;
import fr.sd.taada.helpers.LogManager;
import p024d2.ProtocolMessage;
import p024d2.ProtocolMessagePool;
import p048h2.MessageHandler;
import p066k2.SSLHandler;

/* JADX INFO: loaded from: classes2.dex */
public class MessageSenderRunnable implements Runnable {
    private static final String TAG = "HU-MessageSender";
    private final LogManager logManager;
    private int messageCounter = 0;
    private final MessageHandler messageHandler;
    private final ProtocolMessagePool messagePool;
    private final ProtocolMessage messageToSend;
    private final TransporterService service;
    private final SSLHandler sslHandler;

    public MessageSenderRunnable(TransporterService transporterService, ProtocolMessage protocolMessage, MessageHandler messageHandler, SSLHandler sSLHandler) {
        this.service = transporterService;
        this.logManager = transporterService.getLogManager();
        this.messagePool = transporterService.getMessagePool();
        this.messageToSend = protocolMessage;
        this.messageHandler = messageHandler;
        this.sslHandler = sSLHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.messageCounter++;
        this.logManager.logDebug(TAG, "===== SENDING MESSAGE #" + this.messageCounter + " =====");
        LogManager logManager = this.logManager;
        StringBuilder sb = new StringBuilder("Message details: Channel=");
        sb.append((int) this.messageToSend.getChannel());
        sb.append(", Service=");
        sb.append((int) this.messageToSend.getService());
        sb.append(", MessageType=0x");
        sb.append(Integer.toHexString(this.messageToSend.getMessageType()));
        sb.append(", PayloadLength=");
        sb.append(this.messageToSend.getPayload() != null ? this.messageToSend.getPayload().length : 0);
        logManager.logDebug(TAG, sb.toString());
        try {
            try {
                byte[] bArrEncryptWithSSL = this.messageToSend.encryptWithSSL(this.sslHandler);
                if (bArrEncryptWithSSL != null) {
                    this.logManager.logDebug(TAG, "Encrypted message #" + this.messageCounter + ", length: " + bArrEncryptWithSSL.length + ", first bytes: " + HexHelper.bytesToHexString(bArrEncryptWithSSL, 0, Math.min(16, bArrEncryptWithSSL.length)));
                    this.messageHandler.sendData(bArrEncryptWithSSL);
                    LogManager logManager2 = this.logManager;
                    StringBuilder sb2 = new StringBuilder("Message #");
                    sb2.append(this.messageCounter);
                    sb2.append(" sent successfully");
                    logManager2.logDebug(TAG, sb2.toString());
                } else {
                    this.logManager.logError(TAG, "Failed to encrypt message #" + this.messageCounter);
                }
                ProtocolMessagePool protocolMessagePool = this.messagePool;
                if (protocolMessagePool != null) {
                    protocolMessagePool.recycleMessage(this.messageToSend);
                }
            } catch (Exception e) {
                this.logManager.logError(TAG, "Error sending message #" + this.messageCounter + ": " + e.getMessage(), e);
                ProtocolMessagePool protocolMessagePool2 = this.messagePool;
                if (protocolMessagePool2 != null) {
                    protocolMessagePool2.recycleMessage(this.messageToSend);
                }
            }
        } catch (Throwable th) {
            ProtocolMessagePool protocolMessagePool3 = this.messagePool;
            if (protocolMessagePool3 != null) {
                protocolMessagePool3.recycleMessage(this.messageToSend);
            }
            throw th;
        }
    }
}
