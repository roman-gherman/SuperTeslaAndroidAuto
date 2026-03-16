package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0354a0 extends AbstractC0356b0 {
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0356b0
    public final void a(Object obj, long j6) {
        ((Internal$ProtobufList) S0.c.k(obj, j6)).makeImmutable();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0356b0
    public final void b(Object obj, Object obj2, long j6) {
        R0 r02 = S0.c;
        Internal$ProtobufList internal$ProtobufListMutableCopyWithCapacity2 = (Internal$ProtobufList) r02.k(obj, j6);
        Internal$ProtobufList internal$ProtobufList = (Internal$ProtobufList) r02.k(obj2, j6);
        int size = internal$ProtobufListMutableCopyWithCapacity2.size();
        int size2 = internal$ProtobufList.size();
        if (size > 0 && size2 > 0) {
            if (!internal$ProtobufListMutableCopyWithCapacity2.isModifiable()) {
                internal$ProtobufListMutableCopyWithCapacity2 = internal$ProtobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size2 + size);
            }
            internal$ProtobufListMutableCopyWithCapacity2.addAll(internal$ProtobufList);
        }
        if (size > 0) {
            internal$ProtobufList = internal$ProtobufListMutableCopyWithCapacity2;
        }
        S0.p(obj, j6, internal$ProtobufList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0356b0
    public final List c(Object obj, long j6) {
        Internal$ProtobufList internal$ProtobufList = (Internal$ProtobufList) S0.c.k(obj, j6);
        if (internal$ProtobufList.isModifiable()) {
            return internal$ProtobufList;
        }
        int size = internal$ProtobufList.size();
        Internal$ProtobufList internal$ProtobufListMutableCopyWithCapacity2 = internal$ProtobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
        S0.p(obj, j6, internal$ProtobufListMutableCopyWithCapacity2);
        return internal$ProtobufListMutableCopyWithCapacity2;
    }
}
