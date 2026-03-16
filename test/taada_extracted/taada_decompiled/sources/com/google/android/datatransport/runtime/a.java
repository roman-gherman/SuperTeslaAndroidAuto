package com.google.android.datatransport.runtime;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.Collections;
import java.util.HashMap;
import p.C0751a;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1871a = new a();
    public static final com.google.firebase.encoders.b b;
    public static final com.google.firebase.encoders.b c;
    public static final com.google.firebase.encoders.b d;
    public static final com.google.firebase.encoders.b e;

    static {
        L0.a aVar = new L0.a(1);
        HashMap map = new HashMap();
        map.put(Protobuf.class, aVar);
        b = new com.google.firebase.encoders.b("window", Collections.unmodifiableMap(new HashMap(map)));
        L0.a aVar2 = new L0.a(2);
        HashMap map2 = new HashMap();
        map2.put(Protobuf.class, aVar2);
        c = new com.google.firebase.encoders.b("logSourceMetrics", Collections.unmodifiableMap(new HashMap(map2)));
        L0.a aVar3 = new L0.a(3);
        HashMap map3 = new HashMap();
        map3.put(Protobuf.class, aVar3);
        d = new com.google.firebase.encoders.b("globalMetrics", Collections.unmodifiableMap(new HashMap(map3)));
        L0.a aVar4 = new L0.a(4);
        HashMap map4 = new HashMap();
        map4.put(Protobuf.class, aVar4);
        e = new com.google.firebase.encoders.b("appNamespace", Collections.unmodifiableMap(new HashMap(map4)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0751a c0751a = (C0751a) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(b, c0751a.f4460a);
        objectEncoderContext2.add(c, c0751a.b);
        objectEncoderContext2.add(d, c0751a.c);
        objectEncoderContext2.add(e, c0751a.d);
    }
}
