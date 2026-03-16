package o2;

import A2.C0022d;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements AnnotationDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k2.i f4291a;
    public final L2.c b;
    public final Map c;
    public final Object d;

    public h(k2.i iVar, L2.c fqName, Map map) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        this.f4291a = iVar;
        this.b = fqName;
        this.c = map;
        this.d = AbstractC0132a.N(2, new C0022d(this, 28));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final Map getAllValueArguments() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final L2.c getFqName() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final SourceElement getSource() {
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final AbstractC0162z getType() {
        Object value = this.d.getValue();
        kotlin.jvm.internal.h.e(value, "<get-type>(...)");
        return (AbstractC0162z) value;
    }
}
