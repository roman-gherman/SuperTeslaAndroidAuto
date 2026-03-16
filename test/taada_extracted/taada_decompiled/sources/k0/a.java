package K0;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f920a;

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        switch (this.f920a) {
            case 0:
                throw new com.google.firebase.encoders.a("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
                objectEncoderContext2.add(L0.d.f951g, entry.getKey());
                objectEncoderContext2.add(L0.d.f952h, entry.getValue());
                return;
            default:
                throw new com.google.firebase.encoders.a("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
