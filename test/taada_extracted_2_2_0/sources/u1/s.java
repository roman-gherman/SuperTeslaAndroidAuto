package u1;

import com.android.multidex.ClassPathElement;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final s d = new s("HTTP", 1, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4872a;
    public final int b;
    public final int c;

    public s(String str, int i, int i3) {
        this.f4872a = str;
        this.b = i;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f4872a.equals(sVar.f4872a) && this.b == sVar.b && this.c == sVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (this.f4872a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return this.f4872a + ClassPathElement.SEPARATOR_CHAR + this.b + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + this.c;
    }
}
