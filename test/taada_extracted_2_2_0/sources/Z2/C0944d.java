package z2;

import io.ktor.utils.io.Z;
import java.util.Iterator;
import k2.o;
import k3.m;
import k3.p;
import k3.u;
import kotlin.collections.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.Sequence;
import t2.q;
import x2.AbstractC0916c;

/* JADX INFO: renamed from: z2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0944d implements Annotations {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0946f f5202a;
    public final JavaAnnotationOwner b;
    public final boolean c;
    public final MemoizedFunctionToNullable d;

    public C0944d(C0946f c, JavaAnnotationOwner annotationOwner, boolean z6) {
        h.f(c, "c");
        h.f(annotationOwner, "annotationOwner");
        this.f5202a = c;
        this.b = annotationOwner;
        this.c = z6;
        this.d = c.f5204a.f5184a.createMemoizedFunctionWithNullableValues(new q(this, 5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final AnnotationDescriptor findAnnotation(L2.c fqName) {
        AnnotationDescriptor annotationDescriptor;
        h.f(fqName, "fqName");
        JavaAnnotationOwner javaAnnotationOwner = this.b;
        JavaAnnotation javaAnnotationFindAnnotation = javaAnnotationOwner.findAnnotation(fqName);
        if (javaAnnotationFindAnnotation != null && (annotationDescriptor = (AnnotationDescriptor) this.d.invoke(javaAnnotationFindAnnotation)) != null) {
            return annotationDescriptor;
        }
        L2.f fVar = AbstractC0916c.f5113a;
        return AbstractC0916c.a(fqName, javaAnnotationOwner, this.f5202a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean hasAnnotation(L2.c cVar) {
        return Z.n(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean isEmpty() {
        JavaAnnotationOwner javaAnnotationOwner = this.b;
        return javaAnnotationOwner.getAnnotations().isEmpty() && !javaAnnotationOwner.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public final Iterator<AnnotationDescriptor> iterator() {
        JavaAnnotationOwner javaAnnotationOwner = this.b;
        u uVarD = m.D(kotlin.collections.m.K(javaAnnotationOwner.getAnnotations()), this.d);
        L2.f fVar = AbstractC0916c.f5113a;
        return new k3.e(m.x(m.A(j.u(new Sequence[]{uVarD, j.u(new Object[]{AbstractC0916c.a(o.f3753m, javaAnnotationOwner, this.f5202a)})})), p.d));
    }
}
