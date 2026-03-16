package h2;

import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends g0 implements KProperty2.Getter {
    public final d0 i;

    public b0(d0 property) {
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
    public final Object mo5invoke(Object obj, Object obj2) {
        return this.i.get(obj, obj2);
    }
}
