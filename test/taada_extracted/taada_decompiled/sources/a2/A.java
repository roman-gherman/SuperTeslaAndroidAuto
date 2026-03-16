package A2;

import a3.AbstractC0162z;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0162z f4a;
    public final AbstractC0162z b;
    public final List c;
    public final List d;
    public final List e;

    public A(AbstractC0162z returnType, AbstractC0162z abstractC0162z, List valueParameters, List typeParameters, List list) {
        kotlin.jvm.internal.h.f(returnType, "returnType");
        kotlin.jvm.internal.h.f(valueParameters, "valueParameters");
        kotlin.jvm.internal.h.f(typeParameters, "typeParameters");
        this.f4a = returnType;
        this.b = abstractC0162z;
        this.c = valueParameters;
        this.d = typeParameters;
        this.e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a6 = (A) obj;
        return kotlin.jvm.internal.h.a(this.f4a, a6.f4a) && kotlin.jvm.internal.h.a(this.b, a6.b) && kotlin.jvm.internal.h.a(this.c, a6.c) && kotlin.jvm.internal.h.a(this.d, a6.d) && this.e.equals(a6.e);
    }

    public final int hashCode() {
        int iHashCode = this.f4a.hashCode() * 31;
        AbstractC0162z abstractC0162z = this.b;
        return this.e.hashCode() + androidx.constraintlayout.core.motion.a.d(this.d, androidx.constraintlayout.core.motion.a.d(this.c, (iHashCode + (abstractC0162z == null ? 0 : abstractC0162z.hashCode())) * 31, 31), 961);
    }

    public final String toString() {
        return "MethodSignatureData(returnType=" + this.f4a + ", receiverType=" + this.b + ", valueParameters=" + this.c + ", typeParameters=" + this.d + ", hasStableParameterNames=false, errors=" + this.e + ')';
    }
}
