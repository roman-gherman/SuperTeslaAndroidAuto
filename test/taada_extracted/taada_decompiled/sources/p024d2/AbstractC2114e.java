package p024d2;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2114e {
    private static final char[] f7605a = "0123456789ABCDEF".toCharArray();

    public static String m3592a(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i3 = i * 2;
            char[] cArr2 = f7605a;
            cArr[i3] = cArr2[(b & 255) >>> 4];
            cArr[i3 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
