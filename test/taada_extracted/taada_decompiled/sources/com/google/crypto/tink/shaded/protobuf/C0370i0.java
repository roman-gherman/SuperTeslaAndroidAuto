package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0370i0 implements MapFieldSchema {
    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final Map forMapData(Object obj) {
        return (C0368h0) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final C0364f0 forMapMetadata(Object obj) {
        return ((C0366g0) obj).f2879a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final Map forMutableMapData(Object obj) {
        return (C0368h0) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final int getSerializedSize(int i, Object obj, Object obj2) {
        C0368h0 c0368h0 = (C0368h0) obj;
        C0366g0 c0366g0 = (C0366g0) obj2;
        int iB = 0;
        if (c0368h0.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : c0368h0.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            c0366g0.getClass();
            int iG = AbstractC0398x.G(i);
            int iA = C0366g0.a(c0366g0.f2879a, key, value);
            iB = androidx.constraintlayout.core.motion.a.B(iA, iA, iG, iB);
        }
        return iB;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final boolean isImmutable(Object obj) {
        return !((C0368h0) obj).f2881a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final Object mergeFrom(Object obj, Object obj2) {
        C0368h0 c0368h0 = (C0368h0) obj;
        C0368h0 c0368h02 = (C0368h0) obj2;
        if (!c0368h02.isEmpty()) {
            if (!c0368h0.f2881a) {
                if (c0368h0.isEmpty()) {
                    c0368h0 = new C0368h0();
                } else {
                    C0368h0 c0368h03 = new C0368h0(c0368h0);
                    c0368h03.f2881a = true;
                    c0368h0 = c0368h03;
                }
            }
            c0368h0.b();
            if (!c0368h02.isEmpty()) {
                c0368h0.putAll(c0368h02);
            }
        }
        return c0368h0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final Object newMapField(Object obj) {
        C0368h0 c0368h0 = C0368h0.b;
        if (c0368h0.isEmpty()) {
            return new C0368h0();
        }
        C0368h0 c0368h02 = new C0368h0(c0368h0);
        c0368h02.f2881a = true;
        return c0368h02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public final Object toImmutable(Object obj) {
        ((C0368h0) obj).f2881a = false;
        return obj;
    }
}
