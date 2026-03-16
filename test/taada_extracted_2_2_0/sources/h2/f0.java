package h2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3403a;
    public final /* synthetic */ g0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(g0 g0Var, int i) {
        super(0);
        this.f3403a = i;
        this.b = g0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3403a) {
            case 0:
                return s0.a(this.b, true);
            default:
                g0 g0Var = this.b;
                PropertyGetterDescriptor getter = g0Var.i().e().getGetter();
                if (getter != null) {
                    return getter;
                }
                PropertyDescriptor propertyDescriptorE = g0Var.i().e();
                Annotations.Companion.getClass();
                return N2.q.f(propertyDescriptorE, o2.f.b);
        }
    }
}
