package w3;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: renamed from: w3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0896n extends AbstractC0899q {
    public static final C0883a c = new C0883a(C0896n.class, 13);
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5065a;
    public String b;

    public C0896n(String str) {
        char cCharAt;
        String strSubstring;
        int i;
        String strSubstring2;
        String strSubstring3;
        if (str.length() > 16385) {
            throw new IllegalArgumentException("exceeded OID contents length limit");
        }
        if (str.length() < 3 || str.charAt(1) != '.' || (cCharAt = str.charAt(0)) < '0' || cCharAt > '2' || !r.l(2, str) || !(cCharAt == '2' || str.length() == 3 || str.charAt(3) == '.' || ((str.length() == 4 || str.charAt(4) == '.') && str.charAt(2) < '4'))) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.q("string ", str, " not a valid OID"));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iIndexOf = str.indexOf(46, 0);
        if (iIndexOf == -1) {
            strSubstring = str.substring(0);
            i = -1;
        } else {
            strSubstring = str.substring(0, iIndexOf);
            i = iIndexOf + 1;
        }
        int i3 = Integer.parseInt(strSubstring) * 40;
        if (i == -1) {
            strSubstring2 = null;
        } else {
            int iIndexOf2 = str.indexOf(46, i);
            if (iIndexOf2 == -1) {
                strSubstring2 = str.substring(i);
                i = -1;
            } else {
                String strSubstring4 = str.substring(i, iIndexOf2);
                i = 1 + iIndexOf2;
                strSubstring2 = strSubstring4;
            }
        }
        if (strSubstring2.length() <= 18) {
            r.m(byteArrayOutputStream, Long.parseLong(strSubstring2) + ((long) i3));
        } else {
            r.n(byteArrayOutputStream, new BigInteger(strSubstring2).add(BigInteger.valueOf(i3)));
        }
        while (i != -1) {
            if (i == -1) {
                strSubstring3 = null;
            } else {
                int iIndexOf3 = str.indexOf(46, i);
                if (iIndexOf3 == -1) {
                    strSubstring3 = str.substring(i);
                    i = -1;
                } else {
                    String strSubstring5 = str.substring(i, iIndexOf3);
                    i = iIndexOf3 + 1;
                    strSubstring3 = strSubstring5;
                }
            }
            if (strSubstring3.length() <= 18) {
                r.m(byteArrayOutputStream, Long.parseLong(strSubstring3));
            } else {
                r.n(byteArrayOutputStream, new BigInteger(strSubstring3));
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        k(byteArray.length);
        this.f5065a = byteArray;
        this.b = str;
    }

    public static void k(int i) {
        if (i > 4096) {
            throw new IllegalArgumentException("exceeded OID contents length limit");
        }
    }

    public static C0896n l(byte[] bArr, boolean z6) {
        k(bArr.length);
        C0896n c0896n = (C0896n) d.get(new C0895m(bArr));
        if (c0896n != null) {
            return c0896n;
        }
        if (!r.k(bArr)) {
            throw new IllegalArgumentException("invalid OID contents");
        }
        if (z6) {
            bArr = g5.c.c(bArr);
        }
        return new C0896n(null, bArr);
    }

    public static String p(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        boolean z6 = true;
        BigInteger bigIntegerShiftLeft = null;
        long j6 = 0;
        for (int i = 0; i != bArr.length; i++) {
            byte b = bArr[i];
            if (j6 <= 72057594037927808L) {
                long j7 = j6 + ((long) (b & 127));
                if ((b & 128) == 0) {
                    if (z6) {
                        if (j7 < 40) {
                            sb.append('0');
                        } else if (j7 < 80) {
                            sb.append('1');
                            j7 -= 40;
                        } else {
                            sb.append('2');
                            j7 -= 80;
                        }
                        z6 = false;
                    }
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    sb.append(j7);
                    j6 = 0;
                } else {
                    j6 = j7 << 7;
                }
            } else {
                if (bigIntegerShiftLeft == null) {
                    bigIntegerShiftLeft = BigInteger.valueOf(j6);
                }
                BigInteger bigIntegerOr = bigIntegerShiftLeft.or(BigInteger.valueOf(b & 127));
                if ((b & 128) == 0) {
                    if (z6) {
                        sb.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z6 = false;
                    }
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    sb.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j6 = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        return sb.toString();
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (this == abstractC0899q) {
            return true;
        }
        if (!(abstractC0899q instanceof C0896n)) {
            return false;
        }
        return Arrays.equals(this.f5065a, ((C0896n) abstractC0899q).f5065a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5065a, 6, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5065a.length, z6);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5065a);
    }

    public final C0896n j(String str) {
        byte[] bArrE;
        String strSubstring;
        C0883a c0883a = r.c;
        if (str.length() > 16383) {
            throw new IllegalArgumentException("exceeded relative OID contents length limit");
        }
        int i = 0;
        if (!r.l(0, str)) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.q("string ", str, " not a valid relative OID"));
        }
        int length = str.length();
        byte[] bArr = this.f5065a;
        if (length <= 2) {
            k(bArr.length + 1);
            int iCharAt = str.charAt(0) - '0';
            if (str.length() == 2) {
                iCharAt = (iCharAt * 10) + (str.charAt(1) - '0');
            }
            int length2 = bArr.length;
            bArrE = new byte[1 + length2];
            System.arraycopy(bArr, 0, bArrE, 0, length2);
            bArrE[length2] = (byte) iCharAt;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i != -1) {
                if (i == -1) {
                    strSubstring = null;
                } else {
                    int iIndexOf = str.indexOf(46, i);
                    if (iIndexOf == -1) {
                        strSubstring = str.substring(i);
                        i = -1;
                    } else {
                        strSubstring = str.substring(i, iIndexOf);
                        i = iIndexOf + 1;
                    }
                }
                if (strSubstring.length() <= 18) {
                    r.m(byteArrayOutputStream, Long.parseLong(strSubstring));
                } else {
                    r.n(byteArrayOutputStream, new BigInteger(strSubstring));
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            k(bArr.length + byteArray.length);
            bArrE = g5.c.e(bArr, byteArray);
        }
        return new C0896n(B2.b.f(m(), ".", str), bArrE);
    }

    public final synchronized String m() {
        try {
            if (this.b == null) {
                this.b = p(this.f5065a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    public final C0896n n() {
        C0895m c0895m = new C0895m(this.f5065a);
        ConcurrentHashMap concurrentHashMap = d;
        C0896n c0896n = (C0896n) concurrentHashMap.get(c0895m);
        if (c0896n != null) {
            return c0896n;
        }
        synchronized (concurrentHashMap) {
            try {
                if (concurrentHashMap.containsKey(c0895m)) {
                    return (C0896n) concurrentHashMap.get(c0895m);
                }
                concurrentHashMap.put(c0895m, this);
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o(C0896n c0896n) {
        byte[] bArr = c0896n.f5065a;
        int length = bArr.length;
        byte[] bArr2 = this.f5065a;
        if (bArr2.length > length) {
            for (int i = 0; i < length; i++) {
                if (bArr2[i] == bArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        return m();
    }

    public C0896n(String str, byte[] bArr) {
        this.f5065a = bArr;
        this.b = str;
    }
}
