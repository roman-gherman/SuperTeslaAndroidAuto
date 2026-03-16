package E2;

import A2.t;
import c4.AbstractC0246d;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements SourceElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f309a;

    public n(t tVar) {
        this.f309a = tVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public final SourceFile getContainingFile() {
        SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.h.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        t tVar = this.f309a;
        sb.append(tVar);
        sb.append(": ");
        sb.append(((Map) AbstractC0246d.T(tVar.f69j, t.f66o[0])).keySet());
        return sb.toString();
    }
}
