package p024d2;

import android.content.Context;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.ChannelOpenResponse;
import fr.sd.taada.proto.MessageStatus;
import org.greenrobot.eventbus.EventBus;
import p042g2.AbstractC2293a;
import p042g2.AbstractC2294b;
import p042g2.AbstractC2295c;
import p042g2.AbstractC2296d;
import p042g2.AbstractC2298f;
import p042g2.C2297e;

/* JADX INFO: loaded from: classes.dex */
public class MessageProcessor {
    private final C2297e f7602a;
    private final Context f7604c;
    private LogManager logManager;
    private final int f7603b = 0;
    private int processedMessages = 0;
    private String TAG = "HU-MessageProcessor_";
    private final ProtocolMessagePool messagePool = ProtocolMessagePool.getInstance();

    public MessageProcessor(Context context) {
        this.f7604c = context;
        this.logManager = LogManager.getInstance(context);
        this.f7602a = new C2297e(context);
        this.logManager.logDebug(this.TAG, "MessageProcessor initialized with optimized ProtocolMessage pool");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void processMessage(ProtocolMessage protocolMessage) {
        ProtocolMessage protocolMessageM3199a;
        if (protocolMessage.getFrameSize() == 0 || protocolMessage.getPayload() == null || protocolMessage.getPayload().length == 0) {
            return;
        }
        if (protocolMessage.getMessageType() != 7 || protocolMessage.getExtraFlag() != 4) {
            switch (protocolMessage.getChannel()) {
                case 0:
                    protocolMessageM3199a = AbstractC2293a.m3199a(protocolMessage, this.f7604c);
                    break;
                case 1:
                    protocolMessageM3199a = AbstractC2294b.m3198a(protocolMessage);
                    break;
                case 2:
                    protocolMessageM3199a = AbstractC2298f.m3192a(protocolMessage);
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                    protocolMessageM3199a = AbstractC2296d.m3194a(protocolMessage, 0);
                    break;
                case 4:
                    protocolMessageM3199a = this.f7602a.m3193a(protocolMessage);
                    break;
                case 8:
                default:
                    protocolMessageM3199a = null;
                    break;
                case 9:
                    AbstractC2295c.m3195a(protocolMessage, this.f7604c);
                    protocolMessageM3199a = null;
                    break;
                case 10:
                    LogManager logManager = this.logManager;
                    StringBuilder sb = new StringBuilder("Channel: ");
                    sb.append((int) protocolMessage.getChannel());
                    sb.append(" flag: ");
                    sb.append((int) protocolMessage.getService());
                    sb.append("Message type: ");
                    sb.append(protocolMessage.getMessageType());
                    sb.append("enclen: ");
                    sb.append((int) protocolMessage.getFrameSize());
                    sb.append(", payload: ");
                    sb.append(protocolMessage.getFrameType());
                    sb.append(" size: ");
                    sb.append(protocolMessage.getPayload() != null ? protocolMessage.getPayload().length : 0);
                    sb.append(", data: ");
                    sb.append(protocolMessage.getPayload() != null ? AbstractC2114e.m3592a(protocolMessage.getPayload()) : "null");
                    logManager.logDebug("MessgaeProcessor", sb.toString());
                    protocolMessageM3199a = null;
                    break;
            }
        } else {
            this.logManager.logDebug("MessgaeProcessor", "Open Channel: " + ((int) protocolMessage.getChannel()) + " flag: 4");
            protocolMessageM3199a = this.messagePool.createMessage(protocolMessage.getChannel(), (byte) 3, 8, ChannelOpenResponse.newBuilder().setStatus(MessageStatus.STATUS_SUCCESS));
            protocolMessageM3199a.setExtraFlag((byte) 4);
        }
        if (protocolMessageM3199a != null) {
            EventBus.getDefault().post(protocolMessageM3199a);
        }
        int i = this.processedMessages + 1;
        this.processedMessages = i;
        if (i % 100 == 0) {
            this.logManager.logDebug(this.TAG, "📊 " + this.messagePool.getStatistics());
        }
    }
}
