package m;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class g implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f3997a = new g();
    public static final com.google.firebase.encoders.b b = com.google.firebase.encoders.b.a("networkType");
    public static final com.google.firebase.encoders.b c = com.google.firebase.encoders.b.a("mobileSubtype");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        o oVar = (o) ((w) obj);
        objectEncoderContext2.add(b, oVar.f4014a);
        objectEncoderContext2.add(c, oVar.b);
    }
}
