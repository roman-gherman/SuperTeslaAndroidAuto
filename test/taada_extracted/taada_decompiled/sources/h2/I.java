package h2;

import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends i0 implements KMutableProperty1.Setter {
    public final J i;

    public I(J property) {
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

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final N1.m mo5invoke(Object obj, Object obj2) {
        this.i.set(obj, obj2);
        return N1.m.f1129a;
    }
}
