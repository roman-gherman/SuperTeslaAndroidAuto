package kotlin.text;

import e2.C0429e;
import e2.C0430f;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends r {
    public static boolean D(CharSequence charSequence, String other, boolean z6) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        return H(0, 2, charSequence, other, z6) >= 0;
    }

    public static boolean E(String str, char c) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return I(str, c, 0, 2) >= 0;
    }

    public static int F(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int G(CharSequence charSequence, String string, int i, boolean z6) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(string, "string");
        if (!z6 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i);
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        C0430f c0430f = new C0430f(i, length, 1);
        boolean z7 = charSequence instanceof String;
        int i3 = c0430f.c;
        int i4 = c0430f.b;
        int i5 = c0430f.f3132a;
        if (!z7 || string == null) {
            if ((i3 <= 0 || i5 > i4) && (i3 >= 0 || i4 > i5)) {
                return -1;
            }
            while (!O(i5, string.length(), charSequence, string, z6)) {
                if (i5 == i4) {
                    return -1;
                }
                i5 += i3;
            }
            return i5;
        }
        if ((i3 <= 0 || i5 > i4) && (i3 >= 0 || i4 > i5)) {
            return -1;
        }
        int i6 = i5;
        while (true) {
            String str = string;
            boolean z8 = z6;
            if (r.z(str, 0, z8, (String) charSequence, i6, string.length())) {
                return i6;
            }
            if (i6 == i4) {
                return -1;
            }
            i6 += i3;
            string = str;
            z6 = z8;
        }
    }

    public static /* synthetic */ int H(int i, int i3, CharSequence charSequence, String str, boolean z6) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z6 = false;
        }
        return G(charSequence, str, i, z6);
    }

    public static int I(CharSequence charSequence, char c, int i, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return !(charSequence instanceof String) ? J(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static final int J(CharSequence charSequence, char[] cArr, int i, boolean z6) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (!z6 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        C0429e it = new C0430f(i, F(charSequence), 1).iterator();
        while (it.c) {
            int iNextInt = it.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            for (char c : cArr) {
                if (io.ktor.utils.io.jvm.javaio.q.h(c, cCharAt, z6)) {
                    return iNextInt;
                }
            }
        }
        return -1;
    }

    public static char K(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(F(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int L(int i, String str, String string) {
        int iF = (i & 2) != 0 ? F(str) : 0;
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(string, "string");
        return str.lastIndexOf(string, iF);
    }

    public static int M(String str, char c) {
        int iF = F(str);
        kotlin.jvm.internal.h.f(str, "<this>");
        return str.lastIndexOf(c, iF);
    }

    public static final List N(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return k3.m.F(k3.m.D(new k3.j(str, new j1.m(kotlin.collections.j.t(new String[]{"\r\n", "\n", "\r"}), 3)), new D2.j(str, 21)));
    }

    public static final boolean O(int i, int i3, CharSequence other, String str, boolean z6) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        if (i >= 0 && str.length() - i3 >= 0 && i <= other.length() - i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (io.ktor.utils.io.jvm.javaio.q.h(str.charAt(i4), other.charAt(i + i4), z6)) {
                }
            }
            return true;
        }
        return false;
    }

    public static String P(String str, String str2) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (!r.C(str, str2)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static List Q(String str, char[] cArr) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (cArr.length != 1) {
            k3.j<C0430f> jVar = new k3.j(str, new j1.m(cArr, 2));
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(new k3.q(jVar, 0)));
            for (C0430f range : jVar) {
                kotlin.jvm.internal.h.f(range, "range");
                arrayList.add(str.subSequence(range.f3132a, range.b + 1).toString());
            }
            return arrayList;
        }
        String strValueOf = String.valueOf(cArr[0]);
        int iG = G(str, strValueOf, 0, false);
        if (iG == -1) {
            return Z.p(str.toString());
        }
        ArrayList arrayList2 = new ArrayList(10);
        int length = 0;
        do {
            arrayList2.add(str.subSequence(length, iG).toString());
            length = strValueOf.length() + iG;
            iG = G(str, strValueOf, length, false);
        } while (iG != -1);
        arrayList2.add(str.subSequence(length, str.length()).toString());
        return arrayList2;
    }

    public static boolean R(String str, char c) {
        kotlin.jvm.internal.h.f(str, "<this>");
        return str.length() > 0 && io.ktor.utils.io.jvm.javaio.q.h(str.charAt(0), c, false);
    }

    public static String S(String str, String delimiter, String str2) {
        kotlin.jvm.internal.h.f(delimiter, "delimiter");
        int iH = H(0, 6, str, delimiter, false);
        if (iH == -1) {
            return str2;
        }
        String strSubstring = str.substring(delimiter.length() + iH, str.length());
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String T(String str) {
        int I = I(str, '$', 0, 6);
        if (I == -1) {
            return str;
        }
        String strSubstring = str.substring(I + 1, str.length());
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String U(String missingDelimiterValue, char c) {
        kotlin.jvm.internal.h.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.h.f(missingDelimiterValue, "missingDelimiterValue");
        int iM = M(missingDelimiterValue, c);
        if (iM == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(iM + 1, missingDelimiterValue.length());
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String V(String missingDelimiterValue, String str) {
        kotlin.jvm.internal.h.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.h.f(missingDelimiterValue, "missingDelimiterValue");
        int iH = H(0, 6, missingDelimiterValue, str, false);
        if (iH == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iH);
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String W(int i, String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.d(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(0, i);
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static CharSequence X(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        int length = str.length() - 1;
        int i = 0;
        boolean z6 = false;
        while (i <= length) {
            boolean zM = io.ktor.utils.io.jvm.javaio.q.m(str.charAt(!z6 ? i : length));
            if (z6) {
                if (!zM) {
                    break;
                }
                length--;
            } else if (zM) {
                i++;
            } else {
                z6 = true;
            }
        }
        return str.subSequence(i, length + 1);
    }
}
