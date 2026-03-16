package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends AbstractC0356b0 {
    public static final Class c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(Object obj, long j6, int i) {
        List list = (List) S0.c.k(obj, j6);
        if (list.isEmpty()) {
            List y = list instanceof LazyStringList ? new Y(i) : ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal$ProtobufList)) ? ((Internal$ProtobufList) list).mutableCopyWithCapacity2(i) : new ArrayList(i);
            S0.p(obj, j6, y);
            return y;
        }
        if (c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i);
            arrayList.addAll(list);
            S0.p(obj, j6, arrayList);
            return arrayList;
        }
        if (list instanceof N0) {
            Y y6 = new Y(list.size() + i);
            y6.addAll((N0) list);
            S0.p(obj, j6, y6);
            return y6;
        }
        if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal$ProtobufList)) {
            Internal$ProtobufList internal$ProtobufList = (Internal$ProtobufList) list;
            if (!internal$ProtobufList.isModifiable()) {
                Internal$ProtobufList internal$ProtobufListMutableCopyWithCapacity2 = internal$ProtobufList.mutableCopyWithCapacity2(list.size() + i);
                S0.p(obj, j6, internal$ProtobufListMutableCopyWithCapacity2);
                return internal$ProtobufListMutableCopyWithCapacity2;
            }
        }
        return list;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0356b0
    public final void a(Object obj, long j6) {
        Object objUnmodifiableList;
        List list = (List) S0.c.k(obj, j6);
        if (list instanceof LazyStringList) {
            objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal$ProtobufList)) {
                Internal$ProtobufList internal$ProtobufList = (Internal$ProtobufList) list;
                if (internal$ProtobufList.isModifiable()) {
                    internal$ProtobufList.makeImmutable();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        S0.p(obj, j6, objUnmodifiableList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0356b0
    public final void b(Object obj, Object obj2, long j6) {
        List list = (List) S0.c.k(obj2, j6);
        List listD = d(obj, j6, list.size());
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        S0.p(obj, j6, list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0356b0
    public final List c(Object obj, long j6) {
        return d(obj, j6, 10);
    }
}
