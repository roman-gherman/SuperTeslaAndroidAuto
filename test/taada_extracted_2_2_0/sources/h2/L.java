package h2;

import A2.C0022d;
import a.AbstractC0132a;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends d0 implements KMutableProperty2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f3374o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(D container, PropertyDescriptor propertyDescriptor) {
        super(container, propertyDescriptor);
        kotlin.jvm.internal.h.f(container, "container");
        this.f3374o = AbstractC0132a.N(2, new C0022d(this, 18));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty
    public final KMutableProperty.Setter getSetter() {
        return (K) this.f3374o.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty2
    public final void set(Object obj, Object obj2, Object obj3) {
        ((K) this.f3374o.getValue()).call(obj, obj2, obj3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty2, kotlin.reflect.KMutableProperty
    public final KMutableProperty2.Setter getSetter() {
        return (K) this.f3374o.getValue();
    }
}
