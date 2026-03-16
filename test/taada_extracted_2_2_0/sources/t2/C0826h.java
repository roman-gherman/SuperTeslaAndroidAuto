package t2;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;

/* JADX INFO: renamed from: t2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0826h extends AbstractC0825g implements JavaAnnotationAsAnnotationArgument {
    public final Annotation b;

    public C0826h(L2.f fVar, Annotation annotation) {
        super(fVar);
        this.b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument
    public final JavaAnnotation getAnnotation() {
        return new C0824f(this.b);
    }
}
