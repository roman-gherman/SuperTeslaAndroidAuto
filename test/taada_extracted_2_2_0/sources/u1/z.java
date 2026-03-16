package u1;

import com.android.multidex.ClassPathElement;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f4884a = Z.p("");

    public static final int a(int i, int i3, String str) {
        boolean z6 = false;
        while (i < i3) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '[') {
                z6 = true;
            } else if (cCharAt == ']') {
                z6 = false;
            } else if (cCharAt == ':' && !z6) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void b(y yVar, String urlString) {
        kotlin.jvm.internal.h.f(yVar, "<this>");
        kotlin.jvm.internal.h.f(urlString, "urlString");
        if (kotlin.text.r.y(urlString)) {
            return;
        }
        try {
            c(yVar, urlString);
        } catch (Throwable th) {
            throw new com.google.android.gms.tasks.a(8, "Fail to parse url: ".concat(urlString), th);
        }
    }

    public static final void c(y yVar, String urlString) {
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        List listQ;
        int iIntValue;
        int i8 = 1;
        kotlin.jvm.internal.h.f(yVar, "<this>");
        kotlin.jvm.internal.h.f(urlString, "urlString");
        int length = urlString.length();
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                i9 = -1;
                break;
            } else if (!io.ktor.utils.io.jvm.javaio.q.m(urlString.charAt(i9))) {
                break;
            } else {
                i9++;
            }
        }
        int length2 = urlString.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i10 = length2 - 1;
                if (!io.ktor.utils.io.jvm.javaio.q.m(urlString.charAt(length2))) {
                    break;
                } else if (i10 < 0) {
                    break;
                } else {
                    length2 = i10;
                }
            }
            length2 = -1;
        } else {
            length2 = -1;
        }
        int i11 = length2 + 1;
        char cCharAt = urlString.charAt(i9);
        char c = 'A';
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i = i9;
            i3 = i;
        } else {
            i3 = -1;
            i = i9;
        }
        while (true) {
            i4 = i8;
            if (i >= i11) {
                break;
            }
            char cCharAt2 = urlString.charAt(i);
            if (cCharAt2 == ':') {
                if (i3 != -1) {
                    throw new IllegalArgumentException(B2.b.c(i3, "Illegal character in scheme at position "));
                }
                i5 = i - i9;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '?' || cCharAt2 == '#') {
                    break;
                }
                if (i3 == -1 && (('a' > cCharAt2 || cCharAt2 >= '{') && (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')))) {
                    i3 = i;
                }
                i++;
                i8 = i4;
            }
        }
        i5 = -1;
        if (i5 > 0) {
            String strSubstring = urlString.substring(i9, i9 + i5);
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            C0832A c0832a = C0832A.c;
            int length3 = strSubstring.length();
            int i12 = 0;
            while (true) {
                if (i12 >= length3) {
                    i12 = -1;
                    break;
                }
                char cCharAt3 = strSubstring.charAt(i12);
                if ((('A' > cCharAt3 || cCharAt3 >= '[') ? (cCharAt3 < 0 || cCharAt3 >= 128) ? Character.toLowerCase(cCharAt3) : cCharAt3 : (char) (cCharAt3 + ' ')) != cCharAt3) {
                    break;
                } else {
                    i12++;
                }
            }
            if (i12 != -1) {
                StringBuilder sb = new StringBuilder(strSubstring.length());
                sb.append((CharSequence) strSubstring, 0, i12);
                int iF = kotlin.text.i.F(strSubstring);
                if (i12 <= iF) {
                    while (true) {
                        char cCharAt4 = strSubstring.charAt(i12);
                        if (c <= cCharAt4 && cCharAt4 < '[') {
                            cCharAt4 = (char) (cCharAt4 + ' ');
                        } else if (cCharAt4 < 0 || cCharAt4 >= 128) {
                            cCharAt4 = Character.toLowerCase(cCharAt4);
                        }
                        sb.append(cCharAt4);
                        if (i12 == iF) {
                            break;
                        }
                        i12++;
                        c = 'A';
                    }
                }
                strSubstring = sb.toString();
                kotlin.jvm.internal.h.e(strSubstring, "StringBuilder(capacity).…builderAction).toString()");
            }
            C0832A c0832a2 = (C0832A) C0832A.d.get(strSubstring);
            if (c0832a2 == null) {
                c0832a2 = new C0832A(strSubstring, 0);
            }
            yVar.f4879a = c0832a2;
            i9 += i5 + 1;
        }
        int i13 = 0;
        while (true) {
            i6 = i9 + i13;
            if (i6 >= i11 || urlString.charAt(i6) != '/') {
                break;
            } else {
                i13++;
            }
        }
        if (yVar.f4879a.f4846a.equals("file")) {
            if (i13 != 2) {
                if (i13 != 3) {
                    throw new IllegalArgumentException("Invalid file url: ".concat(urlString));
                }
                yVar.b = "";
                String strSubstring2 = urlString.substring(i6, i11);
                kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                io.ktor.utils.io.internal.t.o(yVar, "/".concat(strSubstring2));
                return;
            }
            int I = kotlin.text.i.I(urlString, ClassPathElement.SEPARATOR_CHAR, i6, 4);
            if (I == -1 || I == i11) {
                String strSubstring3 = urlString.substring(i6, i11);
                kotlin.jvm.internal.h.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                yVar.b = strSubstring3;
                return;
            } else {
                String strSubstring4 = urlString.substring(i6, I);
                kotlin.jvm.internal.h.e(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                yVar.b = strSubstring4;
                String strSubstring5 = urlString.substring(I, i11);
                kotlin.jvm.internal.h.e(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
                io.ktor.utils.io.internal.t.o(yVar, strSubstring5);
                return;
            }
        }
        if (yVar.f4879a.f4846a.equals("mailto")) {
            if (i13 != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int iH = kotlin.text.i.H(i6, 4, urlString, "@", false);
            if (iH == -1) {
                throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.q("Invalid mailto url: ", urlString, ", it should contain '@'."));
            }
            String strSubstring6 = urlString.substring(i6, iH);
            kotlin.jvm.internal.h.e(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
            String strD = AbstractC0837b.d(strSubstring6);
            yVar.e = strD != null ? AbstractC0837b.f(strD, false) : null;
            String strSubstring7 = urlString.substring(iH + 1, i11);
            kotlin.jvm.internal.h.e(strSubstring7, "this as java.lang.String…ing(startIndex, endIndex)");
            yVar.b = strSubstring7;
            return;
        }
        if (i13 >= 2) {
            while (true) {
                char[] cArr = new char[5];
                for (int i14 = 0; i14 < 5; i14++) {
                    cArr[i14] = "@/\\?#".charAt(i14);
                }
                int iJ = kotlin.text.i.J(urlString, cArr, i6, false);
                Integer numValueOf = Integer.valueOf(iJ);
                if (iJ <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : i11;
                if (iIntValue >= i11 || urlString.charAt(iIntValue) != '@') {
                    break;
                }
                int iA = a(i6, iIntValue, urlString);
                if (iA != -1) {
                    String strSubstring8 = urlString.substring(i6, iA);
                    kotlin.jvm.internal.h.e(strSubstring8, "this as java.lang.String…ing(startIndex, endIndex)");
                    yVar.e = strSubstring8;
                    String strSubstring9 = urlString.substring(iA + 1, iIntValue);
                    kotlin.jvm.internal.h.e(strSubstring9, "this as java.lang.String…ing(startIndex, endIndex)");
                    yVar.f4880f = strSubstring9;
                } else {
                    String strSubstring10 = urlString.substring(i6, iIntValue);
                    kotlin.jvm.internal.h.e(strSubstring10, "this as java.lang.String…ing(startIndex, endIndex)");
                    yVar.e = strSubstring10;
                }
                i6 = iIntValue + 1;
            }
            int iA2 = a(i6, iIntValue, urlString);
            Integer numValueOf2 = Integer.valueOf(iA2);
            if (iA2 <= 0) {
                numValueOf2 = null;
            }
            int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : iIntValue;
            String strSubstring11 = urlString.substring(i6, iIntValue2);
            kotlin.jvm.internal.h.e(strSubstring11, "this as java.lang.String…ing(startIndex, endIndex)");
            yVar.b = strSubstring11;
            int i15 = iIntValue2 + 1;
            if (i15 < iIntValue) {
                String strSubstring12 = urlString.substring(i15, iIntValue);
                kotlin.jvm.internal.h.e(strSubstring12, "this as java.lang.String…ing(startIndex, endIndex)");
                yVar.c = Integer.parseInt(strSubstring12);
            } else {
                yVar.c = 0;
            }
            i6 = iIntValue;
        }
        List list = kotlin.collections.u.f3805a;
        List list2 = f4884a;
        if (i6 >= i11) {
            if (urlString.charAt(length2) == '/') {
                list = list2;
            }
            kotlin.jvm.internal.h.f(list, "<set-?>");
            yVar.f4882h = list;
            return;
        }
        yVar.f4882h = i13 == 0 ? kotlin.collections.m.N(yVar.f4882h) : list;
        char[] cArr2 = new char[2];
        for (int i16 = 0; i16 < 2; i16++) {
            cArr2[i16] = "?#".charAt(i16);
        }
        int iJ2 = kotlin.text.i.J(urlString, cArr2, i6, false);
        Integer numValueOf3 = Integer.valueOf(iJ2);
        if (iJ2 <= 0) {
            numValueOf3 = null;
        }
        int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : i11;
        if (iIntValue3 > i6) {
            String strSubstring13 = urlString.substring(i6, iIntValue3);
            kotlin.jvm.internal.h.e(strSubstring13, "this as java.lang.String…ing(startIndex, endIndex)");
            List list3 = (yVar.f4882h.size() == i4 && ((CharSequence) kotlin.collections.m.P(yVar.f4882h)).length() == 0) ? list : yVar.f4882h;
            if (strSubstring13.equals("/")) {
                listQ = list2;
                i7 = 1;
            } else {
                i7 = 1;
                listQ = kotlin.text.i.Q(strSubstring13, new char[]{ClassPathElement.SEPARATOR_CHAR});
            }
            if (i13 == i7) {
                list = list2;
            }
            yVar.f4882h = kotlin.collections.m.b0(kotlin.collections.m.b0(listQ, list), list3);
            i6 = iIntValue3;
        }
        if (i6 < i11 && urlString.charAt(i6) == '?') {
            int i17 = i6 + 1;
            if (i17 == i11) {
                yVar.d = true;
                i6 = i11;
            } else {
                int I5 = kotlin.text.i.I(urlString, '#', i17, 4);
                Integer numValueOf4 = I5 > 0 ? Integer.valueOf(I5) : null;
                int iIntValue4 = numValueOf4 != null ? numValueOf4.intValue() : i11;
                String strSubstring14 = urlString.substring(i17, iIntValue4);
                kotlin.jvm.internal.h.e(strSubstring14, "this as java.lang.String…ing(startIndex, endIndex)");
                b0.y(strSubstring14).forEach(new j1.m(yVar, 4));
                i6 = iIntValue4;
            }
        }
        if (i6 >= i11 || urlString.charAt(i6) != '#') {
            return;
        }
        String strSubstring15 = urlString.substring(i6 + 1, i11);
        kotlin.jvm.internal.h.e(strSubstring15, "this as java.lang.String…ing(startIndex, endIndex)");
        yVar.f4881g = strSubstring15;
    }
}
