package F0;

import com.google.crypto.tink.e;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f345a;
    public final int b;
    public final String c;
    public final String d;

    public b(e eVar, int i, String str, String str2) {
        this.f345a = eVar;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f345a == bVar.f345a && this.b == bVar.b && this.c.equals(bVar.c) && this.d.equals(bVar.d);
    }

    public final int hashCode() {
        return Objects.hash(this.f345a, Integer.valueOf(this.b), this.c, this.d);
    }

    public final String toString() {
        return "(status=" + this.f345a + ", keyId=" + this.b + ", keyType='" + this.c + "', keyPrefix='" + this.d + "')";
    }
}
