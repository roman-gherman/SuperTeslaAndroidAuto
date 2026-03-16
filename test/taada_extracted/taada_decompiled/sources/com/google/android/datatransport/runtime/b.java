package com.google.android.datatransport.runtime;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.Collections;
import java.util.HashMap;
import p.C0752b;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1872a = new b();
    public static final com.google.firebase.encoders.b b;

    static {
        L0.a aVar = new L0.a(1);
        HashMap map = new HashMap();
        map.put(Protobuf.class, aVar);
        b = new com.google.firebase.encoders.b("storageMetrics", Collections.unmodifiableMap(new HashMap(map)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(b, ((C0752b) obj).f4461a);
    }
}
