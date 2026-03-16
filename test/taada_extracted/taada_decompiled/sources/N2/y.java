package n2;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f4262a = new y(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DeclarationDescriptor it = (DeclarationDescriptor) obj;
        kotlin.jvm.internal.h.f(it, "it");
        List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) it).getTypeParameters();
        kotlin.jvm.internal.h.e(typeParameters, "it as CallableDescriptor).typeParameters");
        return kotlin.collections.m.K(typeParameters);
    }
}
