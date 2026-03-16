package h2;

import a.AbstractC0132a;
import java.lang.reflect.Member;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public class a0 extends k0 implements KProperty1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f3389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f3390n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(D container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(signature, "signature");
        this.f3389m = AbstractC0132a.N(2, new Z(this, 0));
        this.f3390n = AbstractC0132a.N(2, new Z(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return ((Y) this.f3389m.getValue()).call(obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty1
    public final Object getDelegate(Object obj) {
        return i((Member) this.f3390n.getValue(), obj, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty
    public final KProperty.Getter getGetter() {
        return (Y) this.f3389m.getValue();
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return get(obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.k0
    public final g0 k() {
        return (Y) this.f3389m.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty
    public final KProperty1.Getter getGetter() {
        return (Y) this.f3389m.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(D container, PropertyDescriptor propertyDescriptor) {
        super(container, propertyDescriptor);
        kotlin.jvm.internal.h.f(container, "container");
        this.f3389m = AbstractC0132a.N(2, new Z(this, 0));
        this.f3390n = AbstractC0132a.N(2, new Z(this, 1));
    }
}
