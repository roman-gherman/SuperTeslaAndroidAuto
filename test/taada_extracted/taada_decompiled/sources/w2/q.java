package w2;

import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L2.b f5018a;
    public final byte[] b;
    public final JavaClass c;

    public q(L2.b bVar, JavaClass javaClass, int i) {
        javaClass = (i & 4) != 0 ? null : javaClass;
        this.f5018a = bVar;
        this.b = null;
        this.c = javaClass;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kotlin.jvm.internal.h.a(this.f5018a, qVar.f5018a) && kotlin.jvm.internal.h.a(this.b, qVar.b) && kotlin.jvm.internal.h.a(this.c, qVar.c);
    }

    public final int hashCode() {
        int iHashCode = this.f5018a.hashCode() * 31;
        byte[] bArr = this.b;
        int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
        JavaClass javaClass = this.c;
        return iHashCode2 + (javaClass != null ? javaClass.hashCode() : 0);
    }

    public final String toString() {
        return "Request(classId=" + this.f5018a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.b) + ", outerClass=" + this.c + ')';
    }
}
