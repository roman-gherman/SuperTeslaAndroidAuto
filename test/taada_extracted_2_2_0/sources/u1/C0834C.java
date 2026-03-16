package u1;

import com.android.multidex.ClassPathElement;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: u1.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0834C extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4848a;
    public final /* synthetic */ C0835D b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0834C(C0835D c0835d, int i) {
        super(0);
        this.f4848a = i;
        this.b = c0835d;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0835D c0835d = this.b;
        switch (this.f4848a) {
            case 0:
                int I = kotlin.text.i.I(c0835d.i, '#', 0, 6) + 1;
                if (I == 0) {
                    return "";
                }
                String strSubstring = c0835d.i.substring(I);
                kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            case 1:
                String str = c0835d.f4851g;
                if (str == null) {
                    return null;
                }
                if (str.length() == 0) {
                    return "";
                }
                int length = c0835d.f4849a.f4846a.length() + 3;
                String str2 = c0835d.i;
                String strSubstring2 = str2.substring(kotlin.text.i.I(str2, ':', length, 4) + 1, kotlin.text.i.I(str2, '@', 0, 6));
                kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            case 2:
                if (c0835d.d.isEmpty()) {
                    return "";
                }
                int length2 = c0835d.f4849a.f4846a.length() + 3;
                String str3 = c0835d.i;
                int I5 = kotlin.text.i.I(str3, ClassPathElement.SEPARATOR_CHAR, length2, 4);
                if (I5 == -1) {
                    return "";
                }
                int iJ = kotlin.text.i.J(str3, new char[]{'?', '#'}, I5, false);
                if (iJ == -1) {
                    String strSubstring3 = str3.substring(I5);
                    kotlin.jvm.internal.h.e(strSubstring3, "this as java.lang.String).substring(startIndex)");
                    return strSubstring3;
                }
                String strSubstring4 = str3.substring(I5, iJ);
                kotlin.jvm.internal.h.e(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring4;
            case 3:
                int I6 = kotlin.text.i.I(c0835d.i, ClassPathElement.SEPARATOR_CHAR, c0835d.f4849a.f4846a.length() + 3, 4);
                if (I6 == -1) {
                    return "";
                }
                String str4 = c0835d.i;
                int I7 = kotlin.text.i.I(str4, '#', I6, 4);
                if (I7 == -1) {
                    String strSubstring5 = str4.substring(I6);
                    kotlin.jvm.internal.h.e(strSubstring5, "this as java.lang.String).substring(startIndex)");
                    return strSubstring5;
                }
                String strSubstring6 = str4.substring(I6, I7);
                kotlin.jvm.internal.h.e(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring6;
            case 4:
                int I8 = kotlin.text.i.I(c0835d.i, '?', 0, 6) + 1;
                if (I8 == 0) {
                    return "";
                }
                String str5 = c0835d.i;
                int I9 = kotlin.text.i.I(str5, '#', I8, 4);
                if (I9 == -1) {
                    String strSubstring7 = str5.substring(I8);
                    kotlin.jvm.internal.h.e(strSubstring7, "this as java.lang.String).substring(startIndex)");
                    return strSubstring7;
                }
                String strSubstring8 = str5.substring(I8, I9);
                kotlin.jvm.internal.h.e(strSubstring8, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring8;
            default:
                String str6 = c0835d.f4850f;
                if (str6 == null) {
                    return null;
                }
                if (str6.length() == 0) {
                    return "";
                }
                int length3 = c0835d.f4849a.f4846a.length() + 3;
                String str7 = c0835d.i;
                String strSubstring9 = str7.substring(length3, kotlin.text.i.J(str7, new char[]{':', '@'}, length3, false));
                kotlin.jvm.internal.h.e(strSubstring9, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring9;
        }
    }
}
