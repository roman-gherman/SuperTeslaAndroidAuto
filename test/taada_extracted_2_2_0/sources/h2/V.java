package h2;

import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: classes2.dex */
public final class V extends g0 implements KProperty0.Getter {
    public final X i;

    public V(X property) {
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

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.i.get();
    }
}
