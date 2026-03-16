package R2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1272a = new d(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DeclarationDescriptor it = (DeclarationDescriptor) obj;
        h.f(it, "it");
        return it.getContainingDeclaration();
    }
}
