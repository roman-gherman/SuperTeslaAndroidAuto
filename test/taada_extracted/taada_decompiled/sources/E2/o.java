package E2;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements DeserializedContainerSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KotlinJvmBinaryClass f310a;

    public o(KotlinJvmBinaryClass kotlinJvmBinaryClass, int i) {
        com.google.protobuf.a.p(i, "abiStability");
        this.f310a = kotlinJvmBinaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public final SourceFile getContainingFile() {
        SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.h.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public final String getPresentableString() {
        return "Class '" + this.f310a.getClassId().b().b() + '\'';
    }

    public final String toString() {
        return o.class.getSimpleName() + ": " + this.f310a;
    }
}
