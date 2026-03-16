package z2;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* JADX INFO: renamed from: z2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0943c implements JavaResolverSettings, TypeParameterResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0943c f5201a = new C0943c();
    public static final C0943c b = new C0943c();

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
    public boolean getCorrectNullabilityForNotNullTypeParameter() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
    public boolean getEnhancePrimitiveArrays() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
    public boolean getIgnoreNullabilityForErasedValueParameters() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
    public boolean getTypeEnhancementImprovementsInStrictMode() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        h.f(javaTypeParameter, "javaTypeParameter");
        return null;
    }
}
