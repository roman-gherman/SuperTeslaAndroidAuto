package m;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f3993a = new f();
    public static final com.google.firebase.encoders.b b = com.google.firebase.encoders.b.a("requestTimeMs");
    public static final com.google.firebase.encoders.b c = com.google.firebase.encoders.b.a("requestUptimeMs");
    public static final com.google.firebase.encoders.b d = com.google.firebase.encoders.b.a("clientInfo");
    public static final com.google.firebase.encoders.b e = com.google.firebase.encoders.b.a("logSource");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3994f = com.google.firebase.encoders.b.a("logSourceName");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3995g = com.google.firebase.encoders.b.a("logEvent");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3996h = com.google.firebase.encoders.b.a("qosTier");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        m mVar = (m) ((t) obj);
        objectEncoderContext2.add(b, mVar.f4011a);
        objectEncoderContext2.add(c, mVar.b);
        objectEncoderContext2.add(d, mVar.c);
        objectEncoderContext2.add(e, mVar.d);
        objectEncoderContext2.add(f3994f, mVar.e);
        objectEncoderContext2.add(f3995g, mVar.f4012f);
        objectEncoderContext2.add(f3996h, x.f4018a);
    }
}
