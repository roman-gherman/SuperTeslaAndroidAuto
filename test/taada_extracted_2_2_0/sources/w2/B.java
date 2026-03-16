package w2;

import a.AbstractC0132a;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f4962a;
    public final G b;
    public final Map c;
    public final boolean d;

    public B(G g6, G g7) {
        kotlin.collections.v vVar = kotlin.collections.v.f3806a;
        this.f4962a = g6;
        this.b = g7;
        this.c = vVar;
        AbstractC0132a.M(new C0866A(this, 0));
        G g8 = G.IGNORE;
        this.d = g6 == g8 && g7 == g8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b = (B) obj;
        return this.f4962a == b.f4962a && this.b == b.b && kotlin.jvm.internal.h.a(this.c, b.c);
    }

    public final int hashCode() {
        int iHashCode = this.f4962a.hashCode() * 31;
        G g6 = this.b;
        return this.c.hashCode() + ((iHashCode + (g6 == null ? 0 : g6.hashCode())) * 31);
    }

    public final String toString() {
        return "Jsr305Settings(globalLevel=" + this.f4962a + ", migrationLevel=" + this.b + ", userDefinedLevelForSpecificAnnotation=" + this.c + ')';
    }
}
