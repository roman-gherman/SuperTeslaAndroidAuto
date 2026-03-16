package h2;

import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends i0 implements KMutableProperty0.Setter {
    public final H i;

    public G(H property) {
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
    public final N1.m invoke(Object obj) {
        this.i.set(obj);
        return N1.m.f1129a;
    }
}
