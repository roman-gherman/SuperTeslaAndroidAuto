package a3;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S extends W {
    public static final C0142e b = new C0142e();

    @Override // a3.W
    public final TypeProjection d(AbstractC0162z abstractC0162z) {
        return g(abstractC0162z.c());
    }

    public abstract TypeProjection g(TypeConstructor typeConstructor);
}
