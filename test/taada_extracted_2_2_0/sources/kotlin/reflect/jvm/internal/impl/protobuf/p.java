package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends AbstractC0601b implements Serializable {
    public static o a(AbstractC0612m abstractC0612m, p pVar, int i, K k6, Class cls) {
        return new o(abstractC0612m, Collections.EMPTY_LIST, pVar, new C0613n(i, k6, true), cls);
    }

    public static o b(AbstractC0612m abstractC0612m, Serializable serializable, p pVar, int i, M m6, Class cls) {
        return new o(abstractC0612m, serializable, pVar, new C0613n(i, m6, false), cls);
    }
}
