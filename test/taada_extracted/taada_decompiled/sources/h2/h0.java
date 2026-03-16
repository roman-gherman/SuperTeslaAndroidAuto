package h2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3406a;
    public final /* synthetic */ i0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(i0 i0Var, int i) {
        super(0);
        this.f3406a = i;
        this.b = i0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3406a) {
            case 0:
                return s0.a(this.b, false);
            default:
                i0 i0Var = this.b;
                PropertySetterDescriptor setter = i0Var.i().e().getSetter();
                if (setter != null) {
                    return setter;
                }
                PropertyDescriptor propertyDescriptorE = i0Var.i().e();
                Annotations.Companion.getClass();
                return N2.q.g(propertyDescriptorE, o2.f.b);
        }
    }
}
