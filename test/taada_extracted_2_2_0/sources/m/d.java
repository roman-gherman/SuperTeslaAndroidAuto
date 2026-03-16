package m;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3989a = new d();
    public static final com.google.firebase.encoders.b b = com.google.firebase.encoders.b.a("clientType");
    public static final com.google.firebase.encoders.b c = com.google.firebase.encoders.b.a("androidClientInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        k kVar = (k) ((r) obj);
        kVar.getClass();
        objectEncoderContext2.add(b, q.f4016a);
        objectEncoderContext2.add(c, kVar.f4008a);
    }
}
