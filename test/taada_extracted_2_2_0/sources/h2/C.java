package h2;

import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends B.g {
    @Override // B.g, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public final Object visitConstructorDescriptor(ConstructorDescriptor descriptor, Object obj) {
        N1.m data = (N1.m) obj;
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        kotlin.jvm.internal.h.f(data, "data");
        throw new IllegalStateException("No constructors should appear here: " + descriptor);
    }
}
