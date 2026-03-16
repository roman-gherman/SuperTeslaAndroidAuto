package a3;

import java.util.ArrayList;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends S {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ L(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    @Override // a3.W
    public boolean a() {
        switch (this.c) {
            case 1:
                return false;
            default:
                return super.a();
        }
    }

    @Override // a3.W
    public boolean e() {
        switch (this.c) {
            case 1:
                return ((Map) this.d).isEmpty();
            default:
                return super.e();
        }
    }

    @Override // a3.S
    public final TypeProjection g(TypeConstructor key) {
        switch (this.c) {
            case 0:
                kotlin.jvm.internal.h.f(key, "key");
                if (!((ArrayList) this.d).contains(key)) {
                    return null;
                }
                ClassifierDescriptor declarationDescriptor = key.getDeclarationDescriptor();
                kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return b0.k((TypeParameterDescriptor) declarationDescriptor);
            default:
                kotlin.jvm.internal.h.f(key, "key");
                return (TypeProjection) ((Map) this.d).get(key);
        }
    }
}
