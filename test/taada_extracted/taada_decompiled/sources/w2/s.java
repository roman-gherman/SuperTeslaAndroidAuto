package w2;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D2.i f5020a;
    public final Collection b;
    public final boolean c;

    public s(D2.i iVar, Collection qualifierApplicabilityTypes, boolean z6) {
        kotlin.jvm.internal.h.f(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.f5020a = iVar;
        this.b = qualifierApplicabilityTypes;
        this.c = z6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.h.a(this.f5020a, sVar.f5020a) && kotlin.jvm.internal.h.a(this.b, sVar.b) && this.c == sVar.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f5020a.hashCode() * 31)) * 31;
        boolean z6 = this.c;
        ?? r02 = z6;
        if (z6) {
            r02 = 1;
        }
        return iHashCode + r02;
    }

    public final String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f5020a + ", qualifierApplicabilityTypes=" + this.b + ", definitelyNotNull=" + this.c + ')';
    }

    public s(D2.i iVar, Collection collection) {
        this(iVar, collection, iVar.f254a == D2.h.c);
    }
}
