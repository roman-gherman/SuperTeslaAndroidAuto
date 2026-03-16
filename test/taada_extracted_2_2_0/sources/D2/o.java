package D2;

import a3.c0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import m2.C0652d;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f260a = new o(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassifierDescriptor declarationDescriptor = ((c0) obj).c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return Boolean.FALSE;
        }
        L2.f name = declarationDescriptor.getName();
        L2.c cVar = C0652d.f4076f;
        return Boolean.valueOf(kotlin.jvm.internal.h.a(name, cVar.f()) && kotlin.jvm.internal.h.a(R2.e.c(declarationDescriptor), cVar));
    }
}
