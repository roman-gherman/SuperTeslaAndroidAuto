package N0;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f1117a = TimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa A[Catch: IllegalArgumentException -> 0x00da, NumberFormatException -> 0x00dd, IndexOutOfBoundsException -> 0x00e0, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x00da, IndexOutOfBoundsException -> 0x00e0, NumberFormatException -> 0x00dd, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0076, B:25:0x007c, B:29:0x0086, B:34:0x0096, B:36:0x009e, B:37:0x00a2, B:39:0x00a8, B:44:0x00b5, B:47:0x00c0, B:64:0x00f4, B:66:0x00fa, B:92:0x01ac, B:74:0x010c, B:75:0x0127, B:76:0x0128, B:80:0x0145, B:82:0x0152, B:85:0x015b, B:87:0x017a, B:90:0x0189, B:91:0x01ab, B:79:0x0134, B:94:0x01dd, B:95:0x01e4, B:51:0x00d0, B:52:0x00d3, B:46:0x00bc), top: B:106:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01dd A[Catch: IllegalArgumentException -> 0x00da, NumberFormatException -> 0x00dd, IndexOutOfBoundsException -> 0x00e0, TryCatch #2 {IllegalArgumentException -> 0x00da, IndexOutOfBoundsException -> 0x00e0, NumberFormatException -> 0x00dd, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:17:0x0055, B:19:0x0065, B:20:0x0067, B:22:0x0073, B:23:0x0076, B:25:0x007c, B:29:0x0086, B:34:0x0096, B:36:0x009e, B:37:0x00a2, B:39:0x00a8, B:44:0x00b5, B:47:0x00c0, B:64:0x00f4, B:66:0x00fa, B:92:0x01ac, B:74:0x010c, B:75:0x0127, B:76:0x0128, B:80:0x0145, B:82:0x0152, B:85:0x015b, B:87:0x017a, B:90:0x0189, B:91:0x01ab, B:79:0x0134, B:94:0x01dd, B:95:0x01e4, B:51:0x00d0, B:52:0x00d3, B:46:0x00bc), top: B:106:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date b(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N0.a.b(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int c(int i, int i3, String str) {
        int i4;
        int i5;
        if (i < 0 || i3 > str.length() || i > i3) {
            throw new NumberFormatException(str);
        }
        if (i < i3) {
            i5 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i3));
            }
            i4 = -iDigit;
        } else {
            i4 = 0;
            i5 = i;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int iDigit2 = Character.digit(str.charAt(i5), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i3));
            }
            i4 = (i4 * 10) - iDigit2;
            i5 = i6;
        }
        return -i4;
    }
}
