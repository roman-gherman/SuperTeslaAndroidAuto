package h2;

import a.AbstractC0132a;
import java.lang.reflect.Member;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends k0 implements KProperty2 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f3401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f3402n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(D container, PropertyDescriptor propertyDescriptor) {
        super(container, propertyDescriptor);
        kotlin.jvm.internal.h.f(container, "container");
        this.f3401m = AbstractC0132a.N(2, new c0(this, 0));
        this.f3402n = AbstractC0132a.N(2, new c0(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty2
    public final Object get(Object obj, Object obj2) {
        return ((b0) this.f3401m.getValue()).call(obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty2
    public final Object getDelegate(Object obj, Object obj2) {
        return i((Member) this.f3402n.getValue(), obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty
    public final KProperty.Getter getGetter() {
        return (b0) this.f3401m.getValue();
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.k0
    public final g0 k() {
        return (b0) this.f3401m.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty
    public final KProperty2.Getter getGetter() {
        return (b0) this.f3401m.getValue();
    }
}
