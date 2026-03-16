package D2;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import m1.C0641j;
import m2.C0652d;
import n2.EnumC0709a;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f256a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i) {
        super(i);
        this.f256a = 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1.m mVar = N1.m.f1129a;
        boolean z6 = false;
        switch (this.f256a) {
            case 0:
                t function = (t) obj;
                kotlin.jvm.internal.h.f(function, "$this$function");
                String strConcat = "java/util/".concat("Spliterator");
                e eVar = m.b;
                function.c(strConcat, eVar, eVar);
                return mVar;
            case 1:
                m1.s HttpResponseValidator = (m1.s) obj;
                kotlin.jvm.internal.h.f(HttpResponseValidator, "$this$HttpResponseValidator");
                HttpResponseValidator.c = false;
                HttpResponseValidator.f4064a.add(new C0641j(2, null));
                return mVar;
            case 2:
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
                if (callableMemberDescriptor.getKind() == EnumC0709a.f4226a) {
                    DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
                    kotlin.jvm.internal.h.d(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    String str = C0652d.f4074a;
                    if (C0652d.f4078j.containsKey(N2.f.g((ClassDescriptor) containingDeclaration))) {
                        z6 = true;
                    }
                }
                return Boolean.valueOf(z6);
            default:
                ((b3.c) ((b3.d) obj)).getClass();
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(Object obj, int i) {
        super(1);
        this.f256a = i;
    }
}
