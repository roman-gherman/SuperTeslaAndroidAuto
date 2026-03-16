package kotlin.text;

import e2.C0429e;
import e2.C0430f;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends q {
    public static String A(String str, char c, char c6) {
        kotlin.jvm.internal.h.f(str, "<this>");
        String strReplace = str.replace(c, c6);
        kotlin.jvm.internal.h.e(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
        return strReplace;
    }

    public static String B(String str, String str2, String str3) {
        kotlin.jvm.internal.h.f(str, "<this>");
        int iG = i.G(str, str2, 0, false);
        if (iG < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i3 = 0;
        do {
            sb.append((CharSequence) str, i3, iG);
            sb.append(str3);
            i3 = iG + length;
            if (iG >= str.length()) {
                break;
            }
            iG = i.G(str, str2, iG + i, false);
        } while (iG > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static boolean C(String str, String prefix) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        return str.startsWith(prefix);
    }

    public static boolean w(String str, String suffix) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(suffix, "suffix");
        return str.endsWith(suffix);
    }

    public static boolean x(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static boolean y(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable c0430f = new C0430f(0, charSequence.length() - 1, 1);
            if (!(c0430f instanceof Collection) || !((Collection) c0430f).isEmpty()) {
                C0429e it = c0430f.iterator();
                while (it.c) {
                    if (!io.ktor.utils.io.jvm.javaio.q.m(charSequence.charAt(it.nextInt()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean z(String str, int i, boolean z6, String other, int i3, int i4) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        return !z6 ? str.regionMatches(i, other, i3, i4) : str.regionMatches(z6, i, other, i3, i4);
    }
}
