package x2;

import A2.y;
import a3.AbstractC0162z;
import a3.F;
import c4.AbstractC0246d;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.m;
import kotlin.collections.v;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import z2.C0941a;
import z2.C0946f;

/* JADX INFO: renamed from: x2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0915b implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f5110f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.c f5111a;
    public final SourceElement b;
    public final NotNullLazyValue c;
    public final JavaAnnotationArgument d;
    public final boolean e;

    static {
        x xVar = w.f3817a;
        f5110f = new KProperty[]{xVar.f(new q(xVar.b(C0915b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    }

    public C0915b(C0946f c, JavaAnnotation javaAnnotation, L2.c fqName) {
        SourceElement NO_SOURCE;
        Collection<JavaAnnotationArgument> arguments;
        kotlin.jvm.internal.h.f(c, "c");
        kotlin.jvm.internal.h.f(fqName, "fqName");
        this.f5111a = fqName;
        C0941a c0941a = c.f5203a;
        if (javaAnnotation != null) {
            NO_SOURCE = c0941a.f5187j.source(javaAnnotation);
        } else {
            NO_SOURCE = SourceElement.NO_SOURCE;
            kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
        }
        this.b = NO_SOURCE;
        this.c = c0941a.f5183a.createLazyValue(new y(14, c, this));
        this.d = (javaAnnotation == null || (arguments = javaAnnotation.getArguments()) == null) ? null : (JavaAnnotationArgument) m.Q(arguments);
        boolean z6 = false;
        if (javaAnnotation != null && javaAnnotation.isIdeExternalAnnotation()) {
            z6 = true;
        }
        this.e = z6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map getAllValueArguments() {
        return v.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final L2.c getFqName() {
        return this.f5111a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final SourceElement getSource() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final AbstractC0162z getType() {
        return (F) AbstractC0246d.T(this.c, f5110f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public final boolean isIdeExternalAnnotation() {
        return this.e;
    }
}
