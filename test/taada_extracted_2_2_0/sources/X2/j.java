package X2;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.f f1437a;
    public final K2.f b;
    public final K2.f c;
    public final K2.f d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final L2.b f1438f;

    public j(K2.f fVar, K2.f fVar2, K2.f fVar3, K2.f fVar4, String filePath, L2.b classId) {
        kotlin.jvm.internal.h.f(filePath, "filePath");
        kotlin.jvm.internal.h.f(classId, "classId");
        this.f1437a = fVar;
        this.b = fVar2;
        this.c = fVar3;
        this.d = fVar4;
        this.e = filePath;
        this.f1438f = classId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1437a.equals(jVar.f1437a) && kotlin.jvm.internal.h.a(this.b, jVar.b) && kotlin.jvm.internal.h.a(this.c, jVar.c) && this.d.equals(jVar.d) && kotlin.jvm.internal.h.a(this.e, jVar.e) && kotlin.jvm.internal.h.a(this.f1438f, jVar.f1438f);
    }

    public final int hashCode() {
        int iHashCode = this.f1437a.hashCode() * 31;
        K2.f fVar = this.b;
        int iHashCode2 = (iHashCode + (fVar == null ? 0 : fVar.hashCode())) * 31;
        K2.f fVar2 = this.c;
        return this.f1438f.hashCode() + androidx.constraintlayout.core.motion.a.c((this.d.hashCode() + ((iHashCode2 + (fVar2 != null ? fVar2.hashCode() : 0)) * 31)) * 31, 31, this.e);
    }

    public final String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f1437a + ", compilerVersion=" + this.b + ", languageVersion=" + this.c + ", expectedVersion=" + this.d + ", filePath=" + this.e + ", classId=" + this.f1438f + ')';
    }
}
