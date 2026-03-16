package h2;

import A2.C0022d;
import a.AbstractC0132a;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends a0 implements KMutableProperty1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f3373o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(D container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(signature, "signature");
        this.f3373o = AbstractC0132a.N(2, new C0022d(this, 17));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty
    public final KMutableProperty.Setter getSetter() {
        return (I) this.f3373o.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty1
    public final void set(Object obj, Object obj2) {
        ((I) this.f3373o.getValue()).call(obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    public final KMutableProperty1.Setter getSetter() {
        return (I) this.f3373o.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(D container, PropertyDescriptor propertyDescriptor) {
        super(container, propertyDescriptor);
        kotlin.jvm.internal.h.f(container, "container");
        this.f3373o = AbstractC0132a.N(2, new C0022d(this, 17));
    }
}
