package A2;

import a3.AbstractC0162z;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L f21a = new L(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassifierDescriptor declarationDescriptor = ((AbstractC0162z) obj).c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }
}
