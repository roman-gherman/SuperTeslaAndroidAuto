package a3;

import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: renamed from: a3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0149l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f1555a;
    public static final com.android.billingclient.api.z b;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3817a;
        f1555a = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.c(AbstractC0149l.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};
        B.h hVar = M.b;
        KClass kClassB = xVar.b(C0148k.class);
        hVar.getClass();
        b = new com.android.billingclient.api.z(kClassB, hVar.j(kClassB));
    }

    public static final Annotations a(M m6) {
        Annotations annotations;
        kotlin.jvm.internal.h.f(m6, "<this>");
        C0148k c0148k = (C0148k) b.getValue(m6, f1555a[0]);
        if (c0148k != null && (annotations = c0148k.f1554a) != null) {
            return annotations;
        }
        Annotations.Companion.getClass();
        return o2.f.b;
    }
}
