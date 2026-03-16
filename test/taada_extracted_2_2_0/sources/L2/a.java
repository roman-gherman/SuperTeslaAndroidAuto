package L2;

import com.android.multidex.ClassPathElement;
import kotlin.text.r;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f956a;
    public final f b;

    static {
        c.j(h.f965f);
    }

    public a(c packageName, f fVar) {
        kotlin.jvm.internal.h.f(packageName, "packageName");
        this.f956a = packageName;
        this.b = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.h.a(this.f956a, aVar.f956a) && this.b.equals(aVar.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() + (this.f956a.hashCode() * 961)) * 31;
    }

    public final String toString() {
        String str = r.A(this.f956a.b(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + "/" + this.b;
        kotlin.jvm.internal.h.e(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }
}
