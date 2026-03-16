package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Annotations {
    public static final /* synthetic */ KProperty[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotNullLazyValue f3886a;

    static {
        x xVar = w.f3817a;
        b = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public a(StorageManager storageManager, Function0 function0) {
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        this.f3886a = storageManager.createLazyValue(function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final AnnotationDescriptor findAnnotation(L2.c cVar) {
        return Z.h(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean hasAnnotation(L2.c cVar) {
        return Z.n(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return ((List) AbstractC0246d.T(this.f3886a, b[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator<AnnotationDescriptor> iterator() {
        return ((List) AbstractC0246d.T(this.f3886a, b[0])).iterator();
    }
}
