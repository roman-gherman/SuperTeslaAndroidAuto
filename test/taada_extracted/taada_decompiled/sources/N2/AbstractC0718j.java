package n2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import q2.C0763B;
import v2.EnumC0851b;

/* JADX INFO: renamed from: n2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0718j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0720l f4246a = new C0720l("InvalidModuleNotifier");

    public static final B2.d a(a3.F f6, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        if (classifierDescriptorWithTypeParameters == null || c3.j.f(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
        if (classifierDescriptorWithTypeParameters.isInner()) {
            List listSubList = f6.a().subList(i, size);
            DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
            return new B2.d(classifierDescriptorWithTypeParameters, listSubList, a(f6, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
        }
        if (size != f6.a().size()) {
            N2.f.o(classifierDescriptorWithTypeParameters);
        }
        return new B2.d(classifierDescriptorWithTypeParameters, f6.a().subList(i, f6.a().size()), (B2.d) null);
    }

    public static final void b(PackageFragmentProvider packageFragmentProvider, L2.c fqName, Collection collection) {
        kotlin.jvm.internal.h.f(packageFragmentProvider, "<this>");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(fqName, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
    }

    public static final List c(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> parameters;
        Object next;
        TypeConstructor typeConstructor;
        kotlin.jvm.internal.h.f(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        kotlin.jvm.internal.h.e(declaredTypeParameters, "declaredTypeParameters");
        if (!classifierDescriptorWithTypeParameters.isInner() && !(classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            return declaredTypeParameters;
        }
        int i = R2.e.f1273a;
        R2.d dVar = R2.d.f1272a;
        Sequence sequenceB = k3.m.B(classifierDescriptorWithTypeParameters, dVar);
        Sequence sequenceDrop = sequenceB instanceof DropTakeSequence ? ((DropTakeSequence) sequenceB).drop(1) : new k3.c(sequenceB, 1);
        w predicate = w.f4260a;
        kotlin.jvm.internal.h.f(sequenceDrop, "<this>");
        kotlin.jvm.internal.h.f(predicate, "predicate");
        List listF = k3.m.F(k3.m.z(k3.m.w(new k3.j(sequenceDrop, predicate), x.f4261a), y.f4262a));
        Sequence sequenceB2 = k3.m.B(classifierDescriptorWithTypeParameters, dVar);
        Iterator it = (sequenceB2 instanceof DropTakeSequence ? ((DropTakeSequence) sequenceB2).drop(1) : new k3.c(sequenceB2, 1)).iterator();
        while (true) {
            parameters = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof ClassDescriptor) {
                break;
            }
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) next;
        if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
            parameters = typeConstructor.getParameters();
        }
        if (parameters == null) {
            parameters = kotlin.collections.u.f3804a;
        }
        if (listF.isEmpty() && parameters.isEmpty()) {
            List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
            kotlin.jvm.internal.h.e(declaredTypeParameters2, "declaredTypeParameters");
            return declaredTypeParameters2;
        }
        ArrayList<TypeParameterDescriptor> arrayListB0 = kotlin.collections.m.b0(parameters, listF);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(arrayListB0));
        for (TypeParameterDescriptor it2 : arrayListB0) {
            kotlin.jvm.internal.h.e(it2, "it");
            arrayList.add(new C0710b(it2, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
        }
        return kotlin.collections.m.b0(arrayList, declaredTypeParameters);
    }

    public static final ClassDescriptor d(ModuleDescriptor moduleDescriptor, L2.b classId) {
        kotlin.jvm.internal.h.f(moduleDescriptor, "<this>");
        kotlin.jvm.internal.h.f(classId, "classId");
        ClassifierDescriptor classifierDescriptorE = e(moduleDescriptor, classId);
        if (classifierDescriptorE instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptorE;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0148 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor e(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10, L2.b r11) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.AbstractC0718j.e(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, L2.b):kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor");
    }

    public static final ClassDescriptor f(ModuleDescriptor moduleDescriptor, L2.b classId, C0.t notFoundClasses) {
        kotlin.jvm.internal.h.f(moduleDescriptor, "<this>");
        kotlin.jvm.internal.h.f(classId, "classId");
        kotlin.jvm.internal.h.f(notFoundClasses, "notFoundClasses");
        ClassDescriptor classDescriptorD = d(moduleDescriptor, classId);
        return classDescriptorD != null ? classDescriptorD : notFoundClasses.g(classId, k3.m.F(k3.m.D(k3.m.B(classId, C0715g.f4243a), C0716h.f4244a)));
    }

    public static final ClassifierDescriptor g(DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.h.f(declarationDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if (containingDeclaration == null || (declarationDescriptor instanceof PackageFragmentDescriptor)) {
            return null;
        }
        if (!(containingDeclaration.getContainingDeclaration() instanceof PackageFragmentDescriptor)) {
            return g(containingDeclaration);
        }
        if (containingDeclaration instanceof ClassifierDescriptor) {
            return (ClassifierDescriptor) containingDeclaration;
        }
        return null;
    }

    public static final boolean h(PackageFragmentProvider packageFragmentProvider, L2.c fqName) {
        kotlin.jvm.internal.h.f(packageFragmentProvider, "<this>");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return packageFragmentProvider instanceof PackageFragmentProviderOptimized ? ((PackageFragmentProviderOptimized) packageFragmentProvider).isEmpty(fqName) : i(packageFragmentProvider, fqName).isEmpty();
    }

    public static final ArrayList i(PackageFragmentProvider packageFragmentProvider, L2.c fqName) {
        kotlin.jvm.internal.h.f(packageFragmentProvider, "<this>");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        b(packageFragmentProvider, fqName, arrayList);
        return arrayList;
    }

    public static final ClassDescriptor j(C0763B c0763b, L2.c fqName) {
        ClassifierDescriptor contributedClassifier;
        MemberScope unsubstitutedInnerClassesScope;
        EnumC0851b enumC0851b = EnumC0851b.f4933a;
        kotlin.jvm.internal.h.f(c0763b, "<this>");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        if (!fqName.d()) {
            L2.c cVarE = fqName.e();
            kotlin.jvm.internal.h.e(cVarE, "fqName.parent()");
            MemberScope memberScope = c0763b.getPackage(cVarE).getMemberScope();
            L2.f fVarF = fqName.f();
            kotlin.jvm.internal.h.e(fVarF, "fqName.shortName()");
            ClassifierDescriptor contributedClassifier2 = memberScope.getContributedClassifier(fVarF, enumC0851b);
            ClassDescriptor classDescriptor = contributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier2 : null;
            if (classDescriptor != null) {
                return classDescriptor;
            }
            L2.c cVarE2 = fqName.e();
            kotlin.jvm.internal.h.e(cVarE2, "fqName.parent()");
            ClassDescriptor classDescriptorJ = j(c0763b, cVarE2);
            if (classDescriptorJ == null || (unsubstitutedInnerClassesScope = classDescriptorJ.getUnsubstitutedInnerClassesScope()) == null) {
                contributedClassifier = null;
            } else {
                L2.f fVarF2 = fqName.f();
                kotlin.jvm.internal.h.e(fVarF2, "fqName.shortName()");
                contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(fVarF2, enumC0851b);
            }
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
        }
        return null;
    }
}
