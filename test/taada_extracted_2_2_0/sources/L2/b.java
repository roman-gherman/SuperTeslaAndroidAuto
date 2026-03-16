package L2;

import com.android.multidex.ClassPathElement;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f957a;
    public final c b;
    public final boolean c;

    public b(c cVar, c cVar2, boolean z6) {
        if (cVar == null) {
            a(1);
            throw null;
        }
        this.f957a = cVar;
        this.b = cVar2;
        this.c = z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r10) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L2.b.a(int):void");
    }

    public static b e(String str, boolean z6) {
        String str2;
        if (str == null) {
            a(12);
            throw null;
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            str2 = "";
        } else {
            String strReplace = str.substring(0, iLastIndexOf).replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            str = str.substring(iLastIndexOf + 1);
            str2 = strReplace;
        }
        return new b(new c(str2), new c(str), z6);
    }

    public static b j(c cVar) {
        if (cVar != null) {
            return new b(cVar.e(), cVar.f());
        }
        a(0);
        throw null;
    }

    public final c b() {
        c cVar = this.f957a;
        boolean zD = cVar.d();
        c cVar2 = this.b;
        if (zD) {
            if (cVar2 != null) {
                return cVar2;
            }
            a(9);
            throw null;
        }
        return new c(cVar.b() + "." + cVar2.b());
    }

    public final String c() {
        c cVar = this.f957a;
        boolean zD = cVar.d();
        c cVar2 = this.b;
        if (zD) {
            return cVar2.b();
        }
        String str = cVar.b().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR) + "/" + cVar2.b();
        if (str != null) {
            return str;
        }
        a(14);
        throw null;
    }

    public final b d(f fVar) {
        if (fVar != null) {
            return new b(g(), this.b.c(fVar), this.c);
        }
        a(8);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f957a.equals(bVar.f957a) && this.b.equals(bVar.b) && this.c == bVar.c) {
                return true;
            }
        }
        return false;
    }

    public final b f() {
        c cVarE = this.b.e();
        if (cVarE.d()) {
            return null;
        }
        return new b(g(), cVarE, this.c);
    }

    public final c g() {
        c cVar = this.f957a;
        if (cVar != null) {
            return cVar;
        }
        a(5);
        throw null;
    }

    public final c h() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar;
        }
        a(6);
        throw null;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.c).hashCode() + ((this.b.hashCode() + (this.f957a.hashCode() * 31)) * 31);
    }

    public final f i() {
        f fVarF = this.b.f();
        if (fVarF != null) {
            return fVarF;
        }
        a(7);
        throw null;
    }

    public final String toString() {
        return this.f957a.d() ? "/".concat(c()) : c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c cVar, f fVar) {
        this(cVar, c.j(fVar), false);
        if (cVar == null) {
            a(3);
            throw null;
        }
        if (fVar != null) {
        } else {
            a(4);
            throw null;
        }
    }
}
