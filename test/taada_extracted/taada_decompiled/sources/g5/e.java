package g5;

import java.security.AccessController;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3346a;

    static {
        try {
            try {
                f3346a = (String) AccessController.doPrivileged(new K4.a());
            } catch (Exception unused) {
                f3346a = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            f3346a = "\n";
        }
    }

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    public static String b(String str) {
        char[] charArray = str.toCharArray();
        boolean z6 = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) (c + ' ');
                z6 = true;
            }
        }
        return z6 ? new String(charArray) : str;
    }

    public static String c(String str) {
        char[] charArray = str.toCharArray();
        boolean z6 = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) (c - ' ');
                z6 = true;
            }
        }
        return z6 ? new String(charArray) : str;
    }
}
