package h2;

import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends i0 implements KMutableProperty2.Setter {
    public final L i;

    public K(L property) {
        kotlin.jvm.internal.h.f(property, "property");
        this.i = property;
    }

    @Override // kotlin.reflect.KProperty.Accessor
    public final KProperty getProperty() {
        return this.i;
    }

    @Override // h2.e0
    public final k0 i() {
        return this.i;
    }

    @Override // kotlin.jvm.functions.Function3
    public final N1.m invoke(Object obj, Object obj2, Object obj3) {
        this.i.set(obj, obj2, obj3);
        return N1.m.f1129a;
    }
}
