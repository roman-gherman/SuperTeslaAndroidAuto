package p042g2;

import android.content.Context;
import com.google.protobuf.InvalidProtocolBufferException;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.AudioFocusNotification;
import fr.sd.taada.proto.AudioFocusRequestNotification;
import fr.sd.taada.proto.AudioFocusRequestType;
import fr.sd.taada.proto.AudioFocusStateType;
import fr.sd.taada.proto.ControlMessageType;
import fr.sd.taada.proto.NavFocusNotification;
import fr.sd.taada.proto.NavFocusType;
import fr.sd.taada.proto.PingRequest;
import fr.sd.taada.proto.PingResponse;
import p003a2.AbstractC0041a;
import p024d2.ProtocolMessage;
import p024d2.ProtocolMessagePool;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2293a {
    private static ProtocolMessagePool messagePool = ProtocolMessagePool.getInstance();

    public static ProtocolMessage m3199a(ProtocolMessage protocolMessage, Context context) {
        ControlMessageType controlMessageTypeForNumber = ControlMessageType.forNumber(protocolMessage.getMessageType());
        if (protocolMessage.getService() == 3 && controlMessageTypeForNumber == ControlMessageType.MESSAGE_SERVICE_DISCOVERY_REQUEST) {
            return AbstractC0041a.m13031a(context);
        }
        if (protocolMessage.getService() == 3 && controlMessageTypeForNumber == ControlMessageType.MESSAGE_AUDIO_FOCUS_REQUEST) {
            try {
                protocolMessage.trimMessageTypeBytes();
                ProtocolMessage protocolMessageCreateMessage = messagePool.createMessage((byte) 0, (byte) 3, (short) 0, (short) 0, 19, null);
                AudioFocusNotification.Builder builderNewBuilder = AudioFocusNotification.newBuilder();
                builderNewBuilder.setFocusState(AudioFocusRequestNotification.parseFrom(protocolMessage.getPayload()).getRequest() == AudioFocusRequestType.AUDIO_FOCUS_RELEASE ? AudioFocusStateType.AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK : AudioFocusStateType.AUDIO_FOCUS_STATE_GAIN);
                protocolMessageCreateMessage.setPayloadFromProto(builderNewBuilder);
                return protocolMessageCreateMessage;
            } catch (InvalidProtocolBufferException e) {
                LogManager.getInstance(context).logError("AbstractC2293a", "Error parsing AudioFocusRequestNotification: " + e.getMessage());
                return null;
            }
        }
        if (protocolMessage.getService() == 3 && controlMessageTypeForNumber == ControlMessageType.MESSAGE_NAV_FOCUS_REQUEST) {
            NavFocusNotification.Builder builderNewBuilder2 = NavFocusNotification.newBuilder();
            builderNewBuilder2.setFocusType(NavFocusType.NAV_FOCUS_PROJECTED);
            return messagePool.createMessage((byte) 0, (byte) 3, 14, builderNewBuilder2.build().toByteArray());
        }
        if (protocolMessage.getService() != 3 || controlMessageTypeForNumber != ControlMessageType.MESSAGE_PING_REQUEST) {
            protocolMessage.getService();
            return null;
        }
        try {
            protocolMessage.trimMessageTypeBytes();
            return messagePool.createMessage((byte) 0, (byte) 3, 12, PingResponse.newBuilder().setTimestamp(PingRequest.parseFrom(protocolMessage.getPayload()).getTimestamp()).build().toByteArray());
        } catch (InvalidProtocolBufferException e6) {
            LogManager.getInstance(context).logError("AbstractC2293a", "Error parsing PingRequest: " + e6.getMessage());
            return null;
        }
    }
}
