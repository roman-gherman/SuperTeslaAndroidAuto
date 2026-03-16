package s2;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import t2.w;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements ErrorReporter, JavaSourceElementFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4770a = new g();
    public static final g b = new g();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor descriptor) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor descriptor, List unresolvedSuperClasses) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        kotlin.jvm.internal.h.f(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    public JavaSourceElement source(JavaElement javaElement) {
        kotlin.jvm.internal.h.f(javaElement, "javaElement");
        return new i((w) javaElement);
    }
}
