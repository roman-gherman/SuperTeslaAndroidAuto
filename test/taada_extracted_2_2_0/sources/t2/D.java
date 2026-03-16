package t2;

import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends F implements JavaPrimitiveType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4796a;

    public D(Class cls) {
        this.f4796a = cls;
    }

    @Override // t2.F
    public final Type a() {
        return this.f4796a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection getAnnotations() {
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType
    public final k2.k getType() {
        Class cls = Void.TYPE;
        Class cls2 = this.f4796a;
        if (kotlin.jvm.internal.h.a(cls2, cls)) {
            return null;
        }
        return S2.b.b(cls2.getName()).d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
