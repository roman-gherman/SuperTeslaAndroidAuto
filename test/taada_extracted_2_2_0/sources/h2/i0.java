package h2;

import a.AbstractC0132a;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i0 extends e0 implements KMutableProperty.Setter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f3408h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0 f3409f = s0.g(null, new h0(this, 1));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3410g = AbstractC0132a.N(2, new h0(this, 0));

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        f3408h = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(i0.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;"))};
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.AbstractC0514q
    public final Caller b() {
        return (Caller) this.f3410g.getValue();
    }

    @Override // h2.AbstractC0514q
    public final CallableMemberDescriptor e() {
        KProperty kProperty = f3408h[0];
        Object objInvoke = this.f3409f.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-descriptor>(...)");
        return (PropertySetterDescriptor) objInvoke;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i0) && kotlin.jvm.internal.h.a(i(), ((i0) obj).i());
    }

    @Override // kotlin.reflect.KCallable
    public final String getName() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("<set-"), i().f3414g, '>');
    }

    @Override // h2.e0
    public final PropertyAccessorDescriptor h() {
        KProperty kProperty = f3408h[0];
        Object objInvoke = this.f3409f.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-descriptor>(...)");
        return (PropertySetterDescriptor) objInvoke;
    }

    public final int hashCode() {
        return i().hashCode();
    }

    public final String toString() {
        return "setter of " + i();
    }
}
