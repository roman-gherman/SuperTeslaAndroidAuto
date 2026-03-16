package o2;

import M2.n;
import a3.AbstractC0162z;
import a3.F;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: o2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0738b implements AnnotationDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4280a;
    public final Map b;
    public final SourceElement c;

    public C0738b(F f6, Map map, SourceElement sourceElement) {
        if (f6 == null) {
            a(0);
            throw null;
        }
        if (map == null) {
            a(1);
            throw null;
        }
        if (sourceElement == null) {
            a(2);
            throw null;
        }
        this.f4280a = f6;
        this.b = map;
        this.c = sourceElement;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final Map getAllValueArguments() {
        Map map = this.b;
        if (map != null) {
            return map;
        }
        a(4);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final L2.c getFqName() {
        ClassDescriptor classDescriptorD = R2.e.d(this);
        if (classDescriptorD != null) {
            if (c3.j.f(classDescriptorD)) {
                classDescriptorD = null;
            }
            if (classDescriptorD != null) {
                return R2.e.c(classDescriptorD);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final SourceElement getSource() {
        SourceElement sourceElement = this.c;
        if (sourceElement != null) {
            return sourceElement;
        }
        a(5);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final AbstractC0162z getType() {
        F f6 = this.f4280a;
        if (f6 != null) {
            return f6;
        }
        a(3);
        throw null;
    }

    public final String toString() {
        return n.f1060a.l(this, null);
    }
}
