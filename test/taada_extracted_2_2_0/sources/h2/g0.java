package h2;

import a.AbstractC0132a;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 extends e0 implements KProperty.Getter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f3404h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q0 f3405f = s0.g(null, new f0(this, 1));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3406g = AbstractC0132a.N(2, new f0(this, 0));

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        f3404h = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(g0.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;"))};
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.AbstractC0514q
    public final Caller b() {
        return (Caller) this.f3406g.getValue();
    }

    @Override // h2.AbstractC0514q
    public final CallableMemberDescriptor e() {
        KProperty kProperty = f3404h[0];
        Object objInvoke = this.f3405f.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-descriptor>(...)");
        return (PropertyGetterDescriptor) objInvoke;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof g0) && kotlin.jvm.internal.h.a(i(), ((g0) obj).i());
    }

    @Override // kotlin.reflect.KCallable
    public final String getName() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("<get-"), i().f3414g, '>');
    }

    @Override // h2.e0
    public final PropertyAccessorDescriptor h() {
        KProperty kProperty = f3404h[0];
        Object objInvoke = this.f3405f.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-descriptor>(...)");
        return (PropertyGetterDescriptor) objInvoke;
    }

    public final int hashCode() {
        return i().hashCode();
    }

    public final String toString() {
        return "getter of " + i();
    }
}
