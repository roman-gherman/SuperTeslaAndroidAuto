package p2;

import L2.f;
import a3.F;
import java.util.Collection;
import kotlin.collections.u;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;

/* JADX INFO: renamed from: p2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0756a implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter, PlatformDependentTypeTransformer {
    public static final C0756a b = new C0756a(0);
    public static final C0756a c = new C0756a(1);
    public static final C0756a d = new C0756a(2);
    public static final C0756a e = new C0756a(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4472a;

    public /* synthetic */ C0756a(int i) {
        this.f4472a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection getConstructors(ClassDescriptor classDescriptor) {
        h.f(classDescriptor, "classDescriptor");
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection getFunctions(f name, ClassDescriptor classDescriptor) {
        h.f(name, "name");
        h.f(classDescriptor, "classDescriptor");
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection getFunctionsNames(ClassDescriptor classDescriptor) {
        h.f(classDescriptor, "classDescriptor");
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection getSupertypes(ClassDescriptor classDescriptor) {
        h.f(classDescriptor, "classDescriptor");
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor functionDescriptor) {
        switch (this.f4472a) {
            case 1:
                h.f(classDescriptor, "classDescriptor");
                h.f(functionDescriptor, "functionDescriptor");
                return true;
            default:
                h.f(classDescriptor, "classDescriptor");
                h.f(functionDescriptor, "functionDescriptor");
                return !functionDescriptor.getAnnotations().hasAnnotation(AbstractC0757b.f4473a);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
    public F transformPlatformType(L2.b classId, F computedType) {
        h.f(classId, "classId");
        h.f(computedType, "computedType");
        return computedType;
    }
}
