package R2;

import L2.f;
import io.ktor.utils.io.Z;
import j3.p;
import k2.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1273a = 0;

    static {
        f.e("value");
    }

    public static final boolean a(ValueParameterDescriptor valueParameterDescriptor) {
        h.f(valueParameterDescriptor, "<this>");
        Boolean boolE = p.e(Z.p(valueParameterDescriptor), a.b, b.f1271a);
        h.e(boolE, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return boolE.booleanValue();
    }

    public static CallableMemberDescriptor b(CallableMemberDescriptor callableMemberDescriptor, Function1 predicate) {
        h.f(callableMemberDescriptor, "<this>");
        h.f(predicate, "predicate");
        return (CallableMemberDescriptor) p.c(Z.p(callableMemberDescriptor), new a(1), new c(new v(), predicate));
    }

    public static final L2.c c(DeclarationDescriptorNonRoot declarationDescriptorNonRoot) {
        h.f(declarationDescriptorNonRoot, "<this>");
        L2.e eVarH = h(declarationDescriptorNonRoot);
        if (!eVarH.d()) {
            eVarH = null;
        }
        if (eVarH != null) {
            return eVarH.g();
        }
        return null;
    }

    public static final ClassDescriptor d(AnnotationDescriptor annotationDescriptor) {
        h.f(annotationDescriptor, "<this>");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static final i e(DeclarationDescriptor declarationDescriptor) {
        h.f(declarationDescriptor, "<this>");
        return j(declarationDescriptor).getBuiltIns();
    }

    public static final L2.b f(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        L2.b bVarF;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new L2.b(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (bVarF = f((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return bVarF.d(classifierDescriptor.getName());
    }

    public static final L2.c g(DeclarationDescriptor declarationDescriptor) {
        h.f(declarationDescriptor, "<this>");
        L2.c cVarH = N2.f.h(declarationDescriptor);
        if (cVarH == null) {
            cVarH = N2.f.g(declarationDescriptor.getContainingDeclaration()).b(declarationDescriptor.getName()).g();
        }
        if (cVarH != null) {
            return cVarH;
        }
        N2.f.a(4);
        throw null;
    }

    public static final L2.e h(DeclarationDescriptor declarationDescriptor) {
        h.f(declarationDescriptor, "<this>");
        L2.e eVarG = N2.f.g(declarationDescriptor);
        h.e(eVarG, "getFqName(this)");
        return eVarG;
    }

    public static final void i(ModuleDescriptor moduleDescriptor) {
        h.f(moduleDescriptor, "<this>");
        if (moduleDescriptor.getCapability(b3.e.f1700a) != null) {
            throw new ClassCastException();
        }
    }

    public static final ModuleDescriptor j(DeclarationDescriptor declarationDescriptor) {
        h.f(declarationDescriptor, "<this>");
        ModuleDescriptor moduleDescriptorD = N2.f.d(declarationDescriptor);
        h.e(moduleDescriptorD, "getContainingModule(this)");
        return moduleDescriptorD;
    }

    public static final CallableMemberDescriptor k(CallableMemberDescriptor callableMemberDescriptor) {
        h.f(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        h.e(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }
}
