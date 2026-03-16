package a3;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: renamed from: a3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0158v extends W {
    public final TypeParameterDescriptor[] b;
    public final TypeProjection[] c;
    public final boolean d;

    public C0158v(TypeParameterDescriptor[] parameters, TypeProjection[] arguments, boolean z6) {
        kotlin.jvm.internal.h.f(parameters, "parameters");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        this.b = parameters;
        this.c = arguments;
        this.d = z6;
    }

    @Override // a3.W
    public final boolean b() {
        return this.d;
    }

    @Override // a3.W
    public final TypeProjection d(AbstractC0162z abstractC0162z) {
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor != null) {
            int index = typeParameterDescriptor.getIndex();
            TypeParameterDescriptor[] typeParameterDescriptorArr = this.b;
            if (index < typeParameterDescriptorArr.length && kotlin.jvm.internal.h.a(typeParameterDescriptorArr[index].getTypeConstructor(), typeParameterDescriptor.getTypeConstructor())) {
                return this.c[index];
            }
        }
        return null;
    }

    @Override // a3.W
    public final boolean e() {
        return this.c.length == 0;
    }
}
