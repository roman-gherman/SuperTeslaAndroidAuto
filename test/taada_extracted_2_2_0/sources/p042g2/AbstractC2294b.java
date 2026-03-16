package p042g2;

import android.os.SystemClock;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.InputReport;
import fr.sd.taada.proto.KeyBindingResponse;
import fr.sd.taada.proto.KeyEvent;
import fr.sd.taada.proto.RelativeEvent;
import fr.sd.taada.proto.TouchEvent;
import org.greenrobot.eventbus.EventBus;
import p024d2.ProtocolMessage;
import p024d2.ProtocolMessagePool;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2294b {
    private static ProtocolMessagePool messagePool = ProtocolMessagePool.getInstance();

    public static void m3196c(TouchEvent.Builder builder, KeyEvent.Builder builder2, RelativeEvent.Builder builder3, Long l6, Boolean bool) {
        InputReport.Builder builderNewBuilder = InputReport.newBuilder();
        builderNewBuilder.setTimestamp(l6 == null ? SystemClock.uptimeMillis() : l6.longValue());
        if (builder != null && !bool.booleanValue()) {
            builderNewBuilder.setTouchEvent(builder.build());
        } else if (builder != null && bool.booleanValue()) {
            builderNewBuilder.setTouchpadEvent(builder.build());
        }
        if (builder2 != null) {
            builderNewBuilder.setKeyEvent(builder2.build());
        }
        if (builder3 != null) {
            builderNewBuilder.setRelativeEvent(builder3.build());
        }
        ProtocolMessage protocolMessageCreateMessage = messagePool.createMessage((byte) 1, (byte) 3, 32769);
        protocolMessageCreateMessage.setPayloadFromProto(builderNewBuilder);
        LogManager.getInstance(null).logDebug("Input", "Sending input: " + builderNewBuilder);
        EventBus.getDefault().post(protocolMessageCreateMessage);
    }

    public static void m3197b(TouchEvent.Builder builder) {
        m3196c(builder, null, null, null, Boolean.FALSE);
    }

    public static ProtocolMessage m3198a(ProtocolMessage protocolMessage) {
        if (protocolMessage.getMessageType() != 32770) {
            return null;
        }
        KeyBindingResponse.Builder builderNewBuilder = KeyBindingResponse.newBuilder();
        builderNewBuilder.setStatus(0);
        ProtocolMessage protocolMessageCreateMessage = messagePool.createMessage(protocolMessage.getChannel(), (byte) 3, 32771);
        protocolMessageCreateMessage.setPayloadFromProto(builderNewBuilder);
        return protocolMessageCreateMessage;
    }
}
