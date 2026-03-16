package h2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import n2.EnumC0709a;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3382a;
    public final /* synthetic */ U b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T(U u, int i) {
        super(0);
        this.f3382a = i;
        this.b = u;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3382a) {
            case 0:
                return x0.d(this.b.a());
            default:
                U u = this.b;
                ParameterDescriptor parameterDescriptorA = u.a();
                boolean z6 = parameterDescriptorA instanceof ReceiverParameterDescriptor;
                AbstractC0514q abstractC0514q = u.f3384a;
                if (!z6 || !kotlin.jvm.internal.h.a(x0.g(abstractC0514q.e()), parameterDescriptorA) || abstractC0514q.e().getKind() != EnumC0709a.b) {
                    return abstractC0514q.b().getParameterTypes().get(u.b);
                }
                DeclarationDescriptor containingDeclaration = abstractC0514q.e().getContainingDeclaration();
                kotlin.jvm.internal.h.d(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Class clsJ = x0.j((ClassDescriptor) containingDeclaration);
                if (clsJ != null) {
                    return clsJ;
                }
                throw new N1.d("Cannot determine receiver Java type of inherited declaration: " + parameterDescriptorA, 2);
        }
    }
}
