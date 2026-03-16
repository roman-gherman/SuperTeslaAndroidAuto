package z2;

import kotlin.Lazy;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;

/* JADX INFO: renamed from: z2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0946f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0941a f5204a;
    public final TypeParameterResolver b;
    public final Object c;
    public final Object d;
    public final B2.d e;

    public C0946f(C0941a c0941a, TypeParameterResolver typeParameterResolver, Lazy lazy) {
        h.f(typeParameterResolver, "typeParameterResolver");
        this.f5204a = c0941a;
        this.b = typeParameterResolver;
        this.c = lazy;
        this.d = lazy;
        this.e = new B2.d(this, typeParameterResolver);
    }
}
