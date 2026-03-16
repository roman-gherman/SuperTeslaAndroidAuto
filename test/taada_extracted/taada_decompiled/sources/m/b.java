package m;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3979a = new b();
    public static final com.google.firebase.encoders.b b = com.google.firebase.encoders.b.a("sdkVersion");
    public static final com.google.firebase.encoders.b c = com.google.firebase.encoders.b.a("model");
    public static final com.google.firebase.encoders.b d = com.google.firebase.encoders.b.a("hardware");
    public static final com.google.firebase.encoders.b e = com.google.firebase.encoders.b.a("device");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3980f = com.google.firebase.encoders.b.a("product");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3981g = com.google.firebase.encoders.b.a("osBuild");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3982h = com.google.firebase.encoders.b.a("manufacturer");
    public static final com.google.firebase.encoders.b i = com.google.firebase.encoders.b.a("fingerprint");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3983j = com.google.firebase.encoders.b.a("locale");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3984k = com.google.firebase.encoders.b.a("country");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3985l = com.google.firebase.encoders.b.a("mccMnc");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3986m = com.google.firebase.encoders.b.a("applicationBuild");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        i iVar = (i) ((AbstractC0629a) obj);
        objectEncoderContext2.add(b, iVar.f3999a);
        objectEncoderContext2.add(c, iVar.b);
        objectEncoderContext2.add(d, iVar.c);
        objectEncoderContext2.add(e, iVar.d);
        objectEncoderContext2.add(f3980f, iVar.e);
        objectEncoderContext2.add(f3981g, iVar.f4000f);
        objectEncoderContext2.add(f3982h, iVar.f4001g);
        objectEncoderContext2.add(i, iVar.f4002h);
        objectEncoderContext2.add(f3983j, iVar.i);
        objectEncoderContext2.add(f3984k, iVar.f4003j);
        objectEncoderContext2.add(f3985l, iVar.f4004k);
        objectEncoderContext2.add(f3986m, iVar.f4005l);
    }
}
