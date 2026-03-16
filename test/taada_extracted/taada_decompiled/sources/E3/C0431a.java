package e3;

import a3.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: renamed from: e3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0431a extends i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0431a f3134a = new C0431a(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        c0 it = (c0) obj;
        h.f(it, "it");
        ClassifierDescriptor declarationDescriptor = it.c().getDeclarationDescriptor();
        boolean z6 = false;
        if (declarationDescriptor != null && (declarationDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) declarationDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor)) {
            z6 = true;
        }
        return Boolean.valueOf(z6);
    }
}
