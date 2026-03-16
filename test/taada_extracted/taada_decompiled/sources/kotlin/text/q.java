package kotlin.text;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends p {
    public static Integer v(String str) {
        boolean z6;
        int i;
        int i3;
        io.ktor.utils.io.jvm.javaio.q.c(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (kotlin.jvm.internal.h.h(cCharAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z6 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z6 = false;
            }
        } else {
            z6 = false;
            i = 0;
        }
        int i6 = -59652323;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / 10))) || (i3 = i4 * 10) < i5 + iDigit) {
                return null;
            }
            i4 = i3 - iDigit;
            i++;
        }
        return z6 ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }
}
