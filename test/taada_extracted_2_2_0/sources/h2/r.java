package h2;

import a.AbstractC0132a;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3429a;
    public final /* synthetic */ C0519w b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(C0519w c0519w, int i) {
        super(0);
        this.f3429a = i;
        this.b = c0519w;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3429a) {
            case 0:
                C0519w c0519w = this.b;
                c0519w.getClass();
                KProperty[] kPropertyArr = C0519w.f3437t;
                KProperty kProperty = kPropertyArr[14];
                Object objInvoke = c0519w.q.invoke();
                kotlin.jvm.internal.h.e(objInvoke, "<get-allNonStaticMembers>(...)");
                KProperty kProperty2 = kPropertyArr[15];
                Object objInvoke2 = c0519w.f3448r.invoke();
                kotlin.jvm.internal.h.e(objInvoke2, "<get-allStaticMembers>(...)");
                return kotlin.collections.m.b0((Collection) objInvoke2, (Collection) objInvoke);
            case 1:
                C0519w c0519w2 = this.b;
                c0519w2.getClass();
                KProperty[] kPropertyArr2 = C0519w.f3437t;
                KProperty kProperty3 = kPropertyArr2[10];
                Object objInvoke3 = c0519w2.f3444m.invoke();
                kotlin.jvm.internal.h.e(objInvoke3, "<get-declaredNonStaticMembers>(...)");
                KProperty kProperty4 = kPropertyArr2[12];
                Object objInvoke4 = c0519w2.f3446o.invoke();
                kotlin.jvm.internal.h.e(objInvoke4, "<get-inheritedNonStaticMembers>(...)");
                return kotlin.collections.m.b0((Collection) objInvoke4, (Collection) objInvoke3);
            case 2:
                C0519w c0519w3 = this.b;
                c0519w3.getClass();
                KProperty[] kPropertyArr3 = C0519w.f3437t;
                KProperty kProperty5 = kPropertyArr3[11];
                Object objInvoke5 = c0519w3.f3445n.invoke();
                kotlin.jvm.internal.h.e(objInvoke5, "<get-declaredStaticMembers>(...)");
                KProperty kProperty6 = kPropertyArr3[13];
                Object objInvoke6 = c0519w3.f3447p.invoke();
                kotlin.jvm.internal.h.e(objInvoke6, "<get-inheritedStaticMembers>(...)");
                return kotlin.collections.m.b0((Collection) objInvoke6, (Collection) objInvoke5);
            case 3:
                return x0.d(this.b.a());
            case 4:
                C0519w c0519w4 = this.b;
                c0519w4.getClass();
                KProperty[] kPropertyArr4 = C0519w.f3437t;
                KProperty kProperty7 = kPropertyArr4[10];
                Object objInvoke7 = c0519w4.f3444m.invoke();
                kotlin.jvm.internal.h.e(objInvoke7, "<get-declaredNonStaticMembers>(...)");
                KProperty kProperty8 = kPropertyArr4[11];
                Object objInvoke8 = c0519w4.f3445n.invoke();
                kotlin.jvm.internal.h.e(objInvoke8, "<get-declaredStaticMembers>(...)");
                return kotlin.collections.m.b0((Collection) objInvoke8, (Collection) objInvoke7);
            case 5:
                MemberScope unsubstitutedInnerClassesScope = this.b.a().getUnsubstitutedInnerClassesScope();
                kotlin.jvm.internal.h.e(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                Collection collectionY = AbstractC0132a.y(unsubstitutedInnerClassesScope, null, 3);
                ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                for (Object obj : collectionY) {
                    if (!N2.f.m((DeclarationDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (DeclarationDescriptor declarationDescriptor : arrayList) {
                    ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                    Class clsJ = classDescriptor != null ? x0.j(classDescriptor) : null;
                    C0522z c0522z = clsJ != null ? new C0522z(clsJ) : null;
                    if (c0522z != null) {
                        arrayList2.add(c0522z);
                    }
                }
                return arrayList2;
            default:
                Collection<ClassDescriptor> sealedSubclasses = this.b.a().getSealedSubclasses();
                kotlin.jvm.internal.h.e(sealedSubclasses, "descriptor.sealedSubclasses");
                ArrayList arrayList3 = new ArrayList();
                for (ClassDescriptor classDescriptor2 : sealedSubclasses) {
                    kotlin.jvm.internal.h.d(classDescriptor2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class clsJ2 = x0.j(classDescriptor2);
                    C0522z c0522z2 = clsJ2 != null ? new C0522z(clsJ2) : null;
                    if (c0522z2 != null) {
                        arrayList3.add(c0522z2);
                    }
                }
                return arrayList3;
        }
    }
}
