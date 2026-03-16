package B;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f83a;
    public final com.google.android.gms.common.api.b b;
    public final String c;

    public a(com.google.android.gms.common.api.b bVar, String str) {
        D.e eVar = D.e.f203a;
        this.b = bVar;
        this.c = str;
        this.f83a = Arrays.hashCode(new Object[]{bVar, eVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!D.j.f(this.b, aVar.b)) {
            return false;
        }
        D.e eVar = D.e.f203a;
        return D.j.f(eVar, eVar) && D.j.f(this.c, aVar.c);
    }

    public final int hashCode() {
        return this.f83a;
    }
}
