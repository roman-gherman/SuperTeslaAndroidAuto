package m;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3990a = new e();
    public static final com.google.firebase.encoders.b b = com.google.firebase.encoders.b.a("eventTimeMs");
    public static final com.google.firebase.encoders.b c = com.google.firebase.encoders.b.a("eventCode");
    public static final com.google.firebase.encoders.b d = com.google.firebase.encoders.b.a("eventUptimeMs");
    public static final com.google.firebase.encoders.b e = com.google.firebase.encoders.b.a("sourceExtension");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3991f = com.google.firebase.encoders.b.a("sourceExtensionJsonProto3");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3992g = com.google.firebase.encoders.b.a("timezoneOffsetSeconds");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f3993h = com.google.firebase.encoders.b.a("networkConnectionInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        l lVar = (l) ((s) obj);
        objectEncoderContext2.add(b, lVar.f4009a);
        objectEncoderContext2.add(c, lVar.b);
        objectEncoderContext2.add(d, lVar.c);
        objectEncoderContext2.add(e, lVar.d);
        objectEncoderContext2.add(f3991f, lVar.e);
        objectEncoderContext2.add(f3992g, lVar.f4010f);
        objectEncoderContext2.add(f3993h, lVar.f4011g);
    }
}
