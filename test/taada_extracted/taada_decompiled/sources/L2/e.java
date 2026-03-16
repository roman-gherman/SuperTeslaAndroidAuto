package L2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final f e = f.g("<root>");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f959f = Pattern.compile("\\.");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f960g = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f961a;
    public transient c b;
    public transient e c;
    public transient f d;

    public e(String str, c cVar) {
        if (str == null) {
            a(0);
            throw null;
        }
        if (cVar == null) {
            a(1);
            throw null;
        }
        this.f961a = str;
        this.b = cVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i3;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i3 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public final e b(f fVar) {
        String strB;
        if (fVar == null) {
            a(9);
            throw null;
        }
        String str = this.f961a;
        if (str.isEmpty()) {
            strB = fVar.b();
        } else {
            strB = str + "." + fVar.b();
        }
        return new e(strB, this, fVar);
    }

    public final void c() {
        String str = this.f961a;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.d = f.d(str.substring(iLastIndexOf + 1));
            this.c = new e(str.substring(0, iLastIndexOf));
        } else {
            this.d = f.d(str);
            this.c = c.c.i();
        }
    }

    public final boolean d() {
        if (this.b != null) {
            return true;
        }
        String str = this.f961a;
        if (str != null) {
            return str.indexOf(60) < 0;
        }
        a(4);
        throw null;
    }

    public final List e() {
        List list;
        String str = this.f961a;
        if (str.isEmpty()) {
            list = Collections.EMPTY_LIST;
        } else {
            String[] strArrSplit = f959f.split(str);
            kotlin.jvm.internal.h.f(strArrSplit, "<this>");
            d transform = f960g;
            kotlin.jvm.internal.h.f(transform, "transform");
            ArrayList arrayList = new ArrayList(strArrSplit.length);
            for (String str2 : strArrSplit) {
                arrayList.add(f.d(str2));
            }
            list = arrayList;
        }
        if (list != null) {
            return list;
        }
        a(14);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f961a.equals(((e) obj).f961a);
    }

    public final f f() {
        f fVar = this.d;
        if (fVar != null) {
            if (fVar != null) {
                return fVar;
            }
            a(10);
            throw null;
        }
        if (this.f961a.isEmpty()) {
            throw new IllegalStateException("root");
        }
        c();
        f fVar2 = this.d;
        if (fVar2 != null) {
            return fVar2;
        }
        a(11);
        throw null;
    }

    public final c g() {
        c cVar = this.b;
        if (cVar == null) {
            c cVar2 = new c(this);
            this.b = cVar2;
            return cVar2;
        }
        if (cVar != null) {
            return cVar;
        }
        a(5);
        throw null;
    }

    public final int hashCode() {
        return this.f961a.hashCode();
    }

    public final String toString() {
        String strB = this.f961a;
        if (strB.isEmpty()) {
            strB = e.b();
        }
        if (strB != null) {
            return strB;
        }
        a(17);
        throw null;
    }

    public e(String str) {
        if (str != null) {
            this.f961a = str;
        } else {
            a(2);
            throw null;
        }
    }

    public e(String str, e eVar, f fVar) {
        if (str != null) {
            this.f961a = str;
            this.c = eVar;
            this.d = fVar;
            return;
        }
        a(3);
        throw null;
    }
}
