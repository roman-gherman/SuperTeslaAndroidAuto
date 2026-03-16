package o2;

import a3.X;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Annotations {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Annotations f4292a;
    public final X b;

    public j(Annotations annotations, X x) {
        this.f4292a = annotations;
        this.b = x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final AnnotationDescriptor findAnnotation(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        if (((Boolean) this.b.invoke(fqName)).booleanValue()) {
            return this.f4292a.findAnnotation(fqName);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean hasAnnotation(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        if (((Boolean) this.b.invoke(fqName)).booleanValue()) {
            return this.f4292a.hasAnnotation(fqName);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean isEmpty() {
        Annotations annotations = this.f4292a;
        if ((annotations instanceof Collection) && ((Collection) annotations).isEmpty()) {
            return false;
        }
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            L2.c fqName = it.next().getFqName();
            if (fqName != null && ((Boolean) this.b.invoke(fqName)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<AnnotationDescriptor> iterator() {
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : this.f4292a) {
            L2.c fqName = annotationDescriptor.getFqName();
            if (fqName != null && ((Boolean) this.b.invoke(fqName)).booleanValue()) {
                arrayList.add(annotationDescriptor);
            }
        }
        return arrayList.iterator();
    }
}
