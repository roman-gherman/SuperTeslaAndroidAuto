package com.google.android.datatransport.runtime;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f1876a = new f();
    public static final com.google.firebase.encoders.b b;
    public static final com.google.firebase.encoders.b c;

    static {
        L0.a aVar = new L0.a(1);
        HashMap map = new HashMap();
        map.put(Protobuf.class, aVar);
        b = new com.google.firebase.encoders.b("currentCacheSizeBytes", Collections.unmodifiableMap(new HashMap(map)));
        L0.a aVar2 = new L0.a(2);
        HashMap map2 = new HashMap();
        map2.put(Protobuf.class, aVar2);
        c = new com.google.firebase.encoders.b("maxCacheSizeBytes", Collections.unmodifiableMap(new HashMap(map2)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        p.f fVar = (p.f) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(b, fVar.f4468a);
        objectEncoderContext2.add(c, fVar.b);
    }
}
