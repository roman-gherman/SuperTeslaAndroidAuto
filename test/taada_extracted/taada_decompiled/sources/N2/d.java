package N2;

import B.w;
import java.util.Collection;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import n2.EnumC0709a;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1134a = new d();

    public static SourceElement d(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != EnumC0709a.b) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            kotlin.jvm.internal.h.e(overriddenDescriptors, "overriddenDescriptors");
            callableDescriptor = (CallableMemberDescriptor) kotlin.collections.m.h0(overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }

    public final boolean a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z6) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return kotlin.jvm.internal.h.a(((ClassDescriptor) declarationDescriptor).getTypeConstructor(), ((ClassDescriptor) declarationDescriptor2).getTypeConstructor());
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return b((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z6, c.f1133a);
        }
        if (!(declarationDescriptor instanceof CallableDescriptor) || !(declarationDescriptor2 instanceof CallableDescriptor)) {
            return ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) ? kotlin.jvm.internal.h.a(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : kotlin.jvm.internal.h.a(declarationDescriptor, declarationDescriptor2);
        }
        CallableDescriptor a6 = (CallableDescriptor) declarationDescriptor;
        CallableDescriptor b = (CallableDescriptor) declarationDescriptor2;
        kotlin.jvm.internal.h.f(a6, "a");
        kotlin.jvm.internal.h.f(b, "b");
        if (!a6.equals(b)) {
            if (!kotlin.jvm.internal.h.a(a6.getName(), b.getName())) {
                return false;
            }
            if ((a6 instanceof MemberDescriptor) && (b instanceof MemberDescriptor) && ((MemberDescriptor) a6).isExpect() != ((MemberDescriptor) b).isExpect()) {
                return false;
            }
            if ((kotlin.jvm.internal.h.a(a6.getContainingDeclaration(), b.getContainingDeclaration()) && (!z6 || !kotlin.jvm.internal.h.a(d(a6), d(b)))) || f.o(a6) || f.o(b) || !c(a6, b, a.f1131a, z6)) {
                return false;
            }
            o oVar = new o(new w(a6, b, z6));
            if (oVar.m(a6, b, null, true).c() != 1 || oVar.m(b, a6, null, true).c() != 1) {
                return false;
            }
        }
        return true;
    }

    public final boolean b(TypeParameterDescriptor a6, TypeParameterDescriptor b, boolean z6, Function2 equivalentCallables) {
        kotlin.jvm.internal.h.f(a6, "a");
        kotlin.jvm.internal.h.f(b, "b");
        kotlin.jvm.internal.h.f(equivalentCallables, "equivalentCallables");
        if (a6.equals(b)) {
            return true;
        }
        return !kotlin.jvm.internal.h.a(a6.getContainingDeclaration(), b.getContainingDeclaration()) && c(a6, b, equivalentCallables, z6) && a6.getIndex() == b.getIndex();
    }

    public final boolean c(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2 function2, boolean z6) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        return ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) ? ((Boolean) function2.mo5invoke(containingDeclaration, containingDeclaration2)).booleanValue() : a(containingDeclaration, containingDeclaration2, z6);
    }
}
