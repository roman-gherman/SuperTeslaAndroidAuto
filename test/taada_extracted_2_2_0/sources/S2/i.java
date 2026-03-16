package s2;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import t2.w;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements JavaSourceElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f4773a;

    public i(w javaElement) {
        kotlin.jvm.internal.h.f(javaElement, "javaElement");
        this.f4773a = javaElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public final SourceFile getContainingFile() {
        SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.h.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
    public final JavaElement getJavaElement() {
        return this.f4773a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.motion.a.u(i.class, sb, ": ");
        sb.append(this.f4773a);
        return sb.toString();
    }
}
