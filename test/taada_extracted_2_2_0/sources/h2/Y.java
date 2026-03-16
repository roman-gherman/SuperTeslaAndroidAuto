package h2;

import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes2.dex */
public final class Y extends g0 implements KProperty1.Getter {
    public final a0 i;

    public Y(a0 property) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return this.i.get(obj);
    }
}
