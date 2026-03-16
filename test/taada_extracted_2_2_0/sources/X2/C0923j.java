package x2;

import c4.AbstractC0246d;
import java.util.Map;
import k2.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import w2.C0866A;
import z2.C0946f;

/* JADX INFO: renamed from: x2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0923j extends C0915b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f5122h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotNullLazyValue f5123g;

    static {
        x xVar = w.f3818a;
        f5122h = new KProperty[]{xVar.f(new q(xVar.b(C0923j.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0923j(JavaAnnotation annotation, C0946f c) {
        super(c, annotation, o.f3759t);
        kotlin.jvm.internal.h.f(annotation, "annotation");
        kotlin.jvm.internal.h.f(c, "c");
        this.f5123g = c.f5204a.f5184a.createLazyValue(new C0866A(this, 2));
    }

    @Override // x2.C0915b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final Map getAllValueArguments() {
        return (Map) AbstractC0246d.T(this.f5123g, f5122h[0]);
    }
}
