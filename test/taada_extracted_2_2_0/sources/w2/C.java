package w2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L2.c f4963a;
    public static final L2.b b;

    static {
        L2.c cVar = new L2.c("kotlin.jvm.JvmField");
        f4963a = cVar;
        L2.b.j(cVar);
        L2.b.j(new L2.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        b = L2.b.e("kotlin/jvm/internal/RepeatableContainer", false);
    }

    public static final String a(String propertyName) {
        kotlin.jvm.internal.h.f(propertyName, "propertyName");
        if (c(propertyName)) {
            return propertyName;
        }
        return "get" + C5.f.h(propertyName);
    }

    public static final String b(String str) {
        String strH;
        StringBuilder sb = new StringBuilder("set");
        if (c(str)) {
            strH = str.substring(2);
            kotlin.jvm.internal.h.e(strH, "this as java.lang.String).substring(startIndex)");
        } else {
            strH = C5.f.h(str);
        }
        sb.append(strH);
        return sb.toString();
    }

    public static final boolean c(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        if (!kotlin.text.r.C(name, "is") || name.length() == 2) {
            return false;
        }
        char cCharAt = name.charAt(2);
        return kotlin.jvm.internal.h.h(97, cCharAt) > 0 || kotlin.jvm.internal.h.h(cCharAt, 122) > 0;
    }
}
