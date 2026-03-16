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
import z2.C0946f;

/* JADX INFO: renamed from: x2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0920g extends C0915b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f5116h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotNullLazyValue f5117g;

    static {
        x xVar = w.f3817a;
        f5116h = new KProperty[]{xVar.f(new q(xVar.b(C0920g.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0920g(JavaAnnotation javaAnnotation, C0946f c) {
        super(c, javaAnnotation, o.f3752m);
        kotlin.jvm.internal.h.f(c, "c");
        this.f5117g = c.f5203a.f5183a.createLazyValue(C0919f.f5115a);
    }

    @Override // x2.C0915b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public final Map getAllValueArguments() {
        return (Map) AbstractC0246d.T(this.f5117g, f5116h[0]);
    }
}
