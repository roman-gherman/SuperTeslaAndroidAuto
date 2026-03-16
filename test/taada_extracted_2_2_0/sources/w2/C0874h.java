package w2;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: renamed from: w2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0874h extends N {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f5012l = 0;

    public static final FunctionDescriptor a(FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
        L2.f name = functionDescriptor.getName();
        kotlin.jvm.internal.h.e(name, "functionDescriptor.name");
        if (b(name)) {
            return (FunctionDescriptor) R2.e.b(functionDescriptor, C0872f.f5010a);
        }
        return null;
    }

    public static boolean b(L2.f fVar) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        return N.e.contains(fVar);
    }
}
