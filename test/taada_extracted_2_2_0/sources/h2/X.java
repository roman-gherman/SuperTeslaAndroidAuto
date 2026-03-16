package h2;

import a.AbstractC0132a;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public class X extends k0 implements KProperty0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f3386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f3387n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(D container, PropertyDescriptor propertyDescriptor) {
        super(container, propertyDescriptor);
        kotlin.jvm.internal.h.f(container, "container");
        this.f3386m = AbstractC0132a.N(2, new W(this, 0));
        this.f3387n = AbstractC0132a.N(2, new W(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        return ((V) this.f3386m.getValue()).call(new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty0
    public final Object getDelegate() {
        return this.f3387n.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty
    public final KProperty.Getter getGetter() {
        return (V) this.f3386m.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return get();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.k0
    public final g0 k() {
        return (V) this.f3386m.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.KProperty
    public final KProperty0.Getter getGetter() {
        return (V) this.f3386m.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(D container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(signature, "signature");
        this.f3386m = AbstractC0132a.N(2, new W(this, 0));
        this.f3387n = AbstractC0132a.N(2, new W(this, 1));
    }
}
