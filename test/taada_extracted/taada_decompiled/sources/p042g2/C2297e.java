package p042g2;

import android.content.Context;
import android.content.Intent;
import com.google.protobuf.InvalidProtocolBufferException;
import fr.sd.taada.activities.MicActivity;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.MicrophoneRequest;
import fr.sd.taada.proto.MicrophoneResponse;
import p024d2.ProtocolMessage;

/* JADX INFO: loaded from: classes.dex */
public class C2297e {
    ProtocolMessage f8199a = null;
    private final Context f8200b;
    private boolean f8201c;
    private LogManager logManager;

    public C2297e(Context context) {
        this.f8200b = context;
    }

    private LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.f8200b);
        }
        return this.logManager;
    }

    public ProtocolMessage m3193a(ProtocolMessage protocolMessage) {
        if (protocolMessage.getMessageType() != 32773) {
            return null;
        }
        protocolMessage.trimMessageTypeBytes();
        try {
            MicrophoneRequest from = MicrophoneRequest.parseFrom(protocolMessage.getPayload());
            getLogManager().logDebug("Mic", "Message: " + from);
            if (!from.getOpen()) {
                Intent intent = new Intent(this.f8200b, (Class<?>) MicActivity.class);
                intent.setFlags(268435456);
                intent.setAction("fr.sd.taada.STOP");
                this.f8200b.startActivity(intent);
                return null;
            }
            this.f8201c = true;
            Intent intent2 = new Intent(this.f8200b, (Class<?>) MicActivity.class);
            intent2.setFlags(268435456);
            this.f8200b.startActivity(intent2);
            this.f8199a = new ProtocolMessage((byte) 4, (byte) 3, 32774);
            MicrophoneResponse.Builder builderNewBuilder = MicrophoneResponse.newBuilder();
            builderNewBuilder.setSessionId(0);
            builderNewBuilder.setStatus(0);
            this.f8199a.setPayloadFromProto(builderNewBuilder);
            return this.f8199a;
        } catch (InvalidProtocolBufferException e) {
            getLogManager().logError("Mic", "Error parsing MicrophoneRequest: " + e.getMessage());
            return null;
        }
    }
}
