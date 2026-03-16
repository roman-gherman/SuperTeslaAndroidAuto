package h2;

import A2.C0022d;
import a.AbstractC0132a;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends X implements KMutableProperty0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f3371o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(D container, PropertyDescriptor propertyDescriptor) {
        super(container, propertyDescriptor);
        kotlin.jvm.internal.h.f(container, "container");
        this.f3371o = AbstractC0132a.N(2, new C0022d(this, 16));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty
    public final KMutableProperty.Setter getSetter() {
        return (G) this.f3371o.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty0
    public final void set(Object obj) {
        ((G) this.f3371o.getValue()).call(obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KMutableProperty
    public final KMutableProperty0.Setter getSetter() {
        return (G) this.f3371o.getValue();
    }
}
