package A2;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import m2.C0653e;
import n2.AbstractC0718j;
import z2.C0941a;
import z2.C0946f;

/* JADX INFO: renamed from: A2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0024f extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f33a;
    public final /* synthetic */ C0025g b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0024f(C0025g c0025g, int i) {
        super(0);
        this.f33a = i;
        this.b = c0025g;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f33a) {
            case 0:
                C0025g c0025g = this.b;
                Collection<JavaAnnotationArgument> arguments = c0025g.b.getArguments();
                ArrayList arrayList = new ArrayList();
                for (JavaAnnotationArgument javaAnnotationArgument : arguments) {
                    L2.f name = javaAnnotationArgument.getName();
                    if (name == null) {
                        name = w2.D.b;
                    }
                    P2.g gVarA = c0025g.a(javaAnnotationArgument);
                    N1.e eVar = gVarA != null ? new N1.e(name, gVarA) : null;
                    if (eVar != null) {
                        arrayList.add(eVar);
                    }
                }
                return kotlin.collections.A.L(arrayList);
            case 1:
                L2.b classId = this.b.b.getClassId();
                if (classId != null) {
                    return classId.b();
                }
                return null;
            default:
                C0025g c0025g2 = this.b;
                L2.c fqName = c0025g2.getFqName();
                JavaAnnotation javaAnnotation = c0025g2.b;
                if (fqName == null) {
                    return c3.j.c(c3.i.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, javaAnnotation.toString());
                }
                C0946f c0946f = c0025g2.f34a;
                ClassDescriptor classDescriptorB = C0653e.b(fqName, c0946f.f5203a.f5192o.d);
                if (classDescriptorB == null) {
                    JavaClass javaClassResolve = javaAnnotation.resolve();
                    C0941a c0941a = c0946f.f5203a;
                    classDescriptorB = javaClassResolve != null ? c0941a.f5188k.resolveClass(javaClassResolve) : null;
                    if (classDescriptorB == null) {
                        classDescriptorB = AbstractC0718j.f(c0941a.f5192o, L2.b.j(fqName), c0941a.d.c().f1424l);
                    }
                }
                return classDescriptorB.getDefaultType();
        }
    }
}
