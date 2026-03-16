package kotlin.reflect;

import C0.x;
import h2.n0;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final d c = new d(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3823a;
    public final n0 b;

    public d(e eVar, n0 n0Var) {
        String str;
        this.f3823a = eVar;
        this.b = n0Var;
        if ((eVar == null) == (n0Var == null)) {
            return;
        }
        if (eVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + eVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f3823a == dVar.f3823a && kotlin.jvm.internal.h.a(this.b, dVar.b);
    }

    public final int hashCode() {
        e eVar = this.f3823a;
        int iHashCode = (eVar == null ? 0 : eVar.hashCode()) * 31;
        n0 n0Var = this.b;
        return iHashCode + (n0Var != null ? n0Var.hashCode() : 0);
    }

    public final String toString() {
        e eVar = this.f3823a;
        int i = eVar == null ? -1 : c.f3822a[eVar.ordinal()];
        if (i == -1) {
            return Marker.ANY_MARKER;
        }
        n0 n0Var = this.b;
        if (i == 1) {
            return String.valueOf(n0Var);
        }
        if (i == 2) {
            return "in " + n0Var;
        }
        if (i != 3) {
            throw new x();
        }
        return "out " + n0Var;
    }
}
