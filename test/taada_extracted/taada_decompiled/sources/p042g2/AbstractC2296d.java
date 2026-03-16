package p042g2;

import fr.sd.taada.TransporterService;
import fr.sd.taada.helpers.ReviewRequestManager;
import fr.sd.taada.helpers.video.NalStreamManager;
import fr.sd.taada.proto.Ack;
import fr.sd.taada.proto.Config;
import fr.sd.taada.proto.MediaMessageId;
import fr.sd.taada.proto.Start;
import java.util.Arrays;
import p024d2.ProtocolMessage;
import p030e2.AbstractC2147a;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2296d {
    public static ProtocolMessage m3194a(ProtocolMessage protocolMessage, int i) {
        MediaMessageId mediaMessageIdForNumber = MediaMessageId.forNumber(protocolMessage.getMessageType());
        if (mediaMessageIdForNumber == MediaMessageId.MEDIA_MESSAGE_STOP && protocolMessage.getService() == 3 && protocolMessage.getChannel() != 3) {
            return null;
        }
        if (mediaMessageIdForNumber == MediaMessageId.MEDIA_MESSAGE_SETUP && protocolMessage.getService() == 3) {
            Config.Builder builderNewBuilder = Config.newBuilder();
            ProtocolMessage protocolMessage2 = new ProtocolMessage(protocolMessage.getChannel(), (byte) 3, 32771);
            builderNewBuilder.setMaxUnacked(1);
            builderNewBuilder.setStatus(Config.Status.STATUS_READY);
            if (protocolMessage.getChannel() == 3) {
                TransporterService.isVideoActive = true;
                builderNewBuilder.setMaxUnacked(1);
                builderNewBuilder.addConfigurationIndices(i);
                if (TransporterService.isConnected) {
                    ReviewRequestManager.getInstance(null).onSessionStarted();
                }
            }
            protocolMessage2.setPayloadFromProto(builderNewBuilder);
            return protocolMessage2;
        }
        if (mediaMessageIdForNumber == MediaMessageId.MEDIA_MESSAGE_START && protocolMessage.getService() == 3) {
            protocolMessage.trimMessageTypeBytes();
            try {
                AbstractC2147a.f7665c.put(Byte.valueOf(protocolMessage.getChannel()), Integer.valueOf(Start.parseFrom(protocolMessage.getPayload()).getSessionId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        if (protocolMessage.getChannel() == 5) {
            if (mediaMessageIdForNumber == MediaMessageId.MEDIA_MESSAGE_DATA) {
                TransporterService.getInstance().mediaAudioSocketServer.m2580j0(Arrays.copyOfRange(protocolMessage.getPayload(), 10, protocolMessage.getPayload().length), false);
            } else {
                TransporterService.getInstance().mediaAudioSocketServer.m2580j0(Arrays.copyOfRange(protocolMessage.getPayload(), 2, protocolMessage.getPayload().length), false);
            }
            Ack.Builder builderNewBuilder2 = Ack.newBuilder();
            builderNewBuilder2.setSessionId(AbstractC2147a.f7665c.get((byte) 5).intValue());
            builderNewBuilder2.setAck(1);
            return new ProtocolMessage((byte) 5, (byte) 3, 32772, builderNewBuilder2);
        }
        if (protocolMessage.getChannel() != 6 && protocolMessage.getChannel() != 7) {
            NalStreamManager.buildNal(protocolMessage.getService(), protocolMessage.getPayload(), protocolMessage.getFrameType(), mediaMessageIdForNumber);
            return null;
        }
        if (mediaMessageIdForNumber == MediaMessageId.MEDIA_MESSAGE_DATA) {
            TransporterService.getInstance().voiceSocketServer.m2580j0(Arrays.copyOfRange(protocolMessage.getPayload(), 10, protocolMessage.getPayload().length), false);
        } else {
            TransporterService.getInstance().voiceSocketServer.m2580j0(Arrays.copyOfRange(protocolMessage.getPayload(), 2, protocolMessage.getPayload().length), false);
        }
        Ack.Builder builderNewBuilder3 = Ack.newBuilder();
        builderNewBuilder3.setSessionId(AbstractC2147a.f7665c.get(Byte.valueOf(protocolMessage.getChannel())).intValue());
        builderNewBuilder3.setAck(1);
        return new ProtocolMessage(protocolMessage.getChannel(), (byte) 3, 32772, builderNewBuilder3);
    }
}
