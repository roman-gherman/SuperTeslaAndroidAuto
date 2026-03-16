package D2;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f254a;
    public final boolean b;

    public i(h hVar) {
        this.f254a = hVar;
        this.b = false;
    }

    public static i a(i iVar, h qualifier, boolean z6, int i) {
        if ((i & 1) != 0) {
            qualifier = iVar.f254a;
        }
        if ((i & 2) != 0) {
            z6 = iVar.b;
        }
        iVar.getClass();
        kotlin.jvm.internal.h.f(qualifier, "qualifier");
        return new i(qualifier, z6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f254a == iVar.f254a && this.b == iVar.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int iHashCode = this.f254a.hashCode() * 31;
        boolean z6 = this.b;
        ?? r12 = z6;
        if (z6) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public final String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f254a + ", isForWarningOnly=" + this.b + ')';
    }

    public i(h hVar, boolean z6) {
        this.f254a = hVar;
        this.b = z6;
    }
}
