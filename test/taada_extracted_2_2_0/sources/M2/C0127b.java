package M2;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: renamed from: M2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0127b implements ClassifierNamePolicy {
    public static final C0127b b = new C0127b(0);
    public static final C0127b c = new C0127b(1);
    public static final C0127b d = new C0127b(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1048a;

    public /* synthetic */ C0127b(int i) {
        this.f1048a = i;
    }

    public static String a(ClassifierDescriptor classifierDescriptor) {
        String strF0;
        L2.f name = classifierDescriptor.getName();
        kotlin.jvm.internal.h.e(name, "descriptor.name");
        String strE0 = E1.k.e0(name);
        if (!(classifierDescriptor instanceof TypeParameterDescriptor)) {
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            kotlin.jvm.internal.h.e(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                strF0 = a((ClassifierDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof PackageFragmentDescriptor) {
                L2.e eVarI = ((PackageFragmentDescriptor) containingDeclaration).getFqName().i();
                kotlin.jvm.internal.h.e(eVarI, "descriptor.fqName.toUnsafe()");
                strF0 = E1.k.f0(eVarI.e());
            } else {
                strF0 = null;
            }
            if (strF0 != null && !strF0.equals("")) {
                return strF0 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + strE0;
            }
        }
        return strE0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    /* JADX WARN: Type inference failed for: r2v8, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Named] */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
    public final String renderClassifier(ClassifierDescriptor classifier, n renderer) {
        switch (this.f1048a) {
            case 0:
                kotlin.jvm.internal.h.f(classifier, "classifier");
                kotlin.jvm.internal.h.f(renderer, "renderer");
                if (classifier instanceof TypeParameterDescriptor) {
                    L2.f name = ((TypeParameterDescriptor) classifier).getName();
                    kotlin.jvm.internal.h.e(name, "classifier.name");
                    return renderer.a(name, false);
                }
                L2.e eVarG = N2.f.g(classifier);
                kotlin.jvm.internal.h.e(eVarG, "getFqName(classifier)");
                return ((s) renderer).c(E1.k.f0(eVarG.e()));
            case 1:
                kotlin.jvm.internal.h.f(classifier, "classifier");
                kotlin.jvm.internal.h.f(renderer, "renderer");
                if (classifier instanceof TypeParameterDescriptor) {
                    L2.f name2 = ((TypeParameterDescriptor) classifier).getName();
                    kotlin.jvm.internal.h.e(name2, "classifier.name");
                    return renderer.a(name2, false);
                }
                ArrayList arrayList = new ArrayList();
                do {
                    arrayList.add(classifier.getName());
                    classifier = classifier.getContainingDeclaration();
                } while (classifier instanceof ClassDescriptor);
                return E1.k.f0(new kotlin.collections.C(arrayList));
            default:
                kotlin.jvm.internal.h.f(classifier, "classifier");
                kotlin.jvm.internal.h.f(renderer, "renderer");
                return a(classifier);
        }
    }
}
