package p042g2;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.protobuf.InvalidProtocolBufferException;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.MediaPlaybackMetadata;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p024d2.ProtocolMessage;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2295c {
    private static byte[] f8197b;
    static ByteBuffer f8196a = ByteBuffer.allocateDirect(1048576);
    private static boolean f8198c = false;

    public static void m3195a(ProtocolMessage protocolMessage, Context context) {
        boolean z6;
        new Intent();
        if (protocolMessage.getMessageType() != 32769 || ((z6 = f8198c) && !(z6 && protocolMessage.getService() == 3))) {
            if (protocolMessage.getMessageType() != 32771) {
                try {
                    if (f8196a.remaining() < protocolMessage.getPayload().length) {
                        LogManager.getInstance(context).logWarning("AbstractC2295c", "Buffer nearly full, clearing to avoid overflow");
                        f8196a.clear();
                    }
                    f8196a.put(protocolMessage.getPayload());
                    return;
                } catch (Exception e) {
                    f8196a.clear();
                    LogManager.getInstance(context).logError("AbstractC2295c", "Error writing to ByteBuffer, buffer cleared: " + e.getMessage());
                    return;
                }
            }
            protocolMessage.trimMessageTypeBytes();
            try {
                if (f8196a.remaining() < protocolMessage.getPayload().length) {
                    LogManager.getInstance(context).logWarning("AbstractC2295c", "Buffer nearly full, clearing to avoid overflow");
                    f8196a.clear();
                }
                f8196a.put(protocolMessage.getPayload());
            } catch (Exception e6) {
                f8196a.clear();
                LogManager.getInstance(context).logError("AbstractC2295c", "Error writing to ByteBuffer, buffer cleared: " + e6.getMessage());
            }
            f8198c = true;
            return;
        }
        if (f8196a.position() > 0) {
            try {
                f8196a.flip();
                byte[] bArr = new byte[f8196a.remaining()];
                f8196a.get(bArr);
                f8196a.clear();
                MediaPlaybackMetadata from = MediaPlaybackMetadata.parseFrom(bArr);
                if (from.toString().length() > 2) {
                    int durationSeconds = from.getDurationSeconds();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "mediastatus");
                        jSONObject.put("song", from.getSong());
                        jSONObject.put("artist", from.getArtist());
                        jSONObject.put("album", from.getAlbum());
                        jSONObject.put("remaining", String.format(Locale.ROOT, "%02d:%02d", Integer.valueOf(durationSeconds / 60), Integer.valueOf(durationSeconds % 60)));
                        byte[] byteArray = from.getAlbumArt().toByteArray();
                        f8197b = byteArray;
                        if (byteArray != null) {
                            jSONObject.put("fanart", Base64.encodeToString(byteArray, 0));
                        }
                    } catch (JSONException e7) {
                        LogManager.getInstance(context).logError("AbstractC2295c", "Error creating JSON object: " + e7.getMessage());
                    }
                }
            } catch (InvalidProtocolBufferException e8) {
                LogManager.getInstance(context).logError("AbstractC2295c", "Error parsing protocol buffer: " + e8.getMessage());
            }
        }
        f8198c = false;
    }
}
