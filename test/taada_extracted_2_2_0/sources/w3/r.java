package w3;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC0899q {
    public static final C0883a c = new C0883a(r.class, 16);
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5071a;
    public String b = null;

    public r(byte[] bArr) {
        this.f5071a = bArr;
    }

    public static r j(byte[] bArr, boolean z6) {
        if (bArr.length > 4096) {
            throw new IllegalArgumentException("exceeded relative OID contents length limit");
        }
        r rVar = (r) d.get(new C0895m(bArr));
        if (rVar != null) {
            return rVar;
        }
        if (!k(bArr)) {
            throw new IllegalArgumentException("invalid relative OID contents");
        }
        if (z6) {
            bArr = g5.c.c(bArr);
        }
        return new r(bArr);
    }

    public static boolean k(byte[] bArr) {
        if (g5.d.b("org.bouncycastle.asn1.allow_wrong_oid_enc")) {
            return true;
        }
        if (bArr.length < 1) {
            return false;
        }
        boolean z6 = true;
        for (int i = 0; i < bArr.length; i++) {
            if (z6 && (bArr[i] & 255) == 128) {
                return false;
            }
            z6 = (bArr[i] & 128) == 0;
        }
        return z6;
    }

    public static boolean l(int i, String str) {
        int length = str.length();
        int i3 = 0;
        while (true) {
            int i4 = length - 1;
            if (i4 < i) {
                if (i3 == 0 || (i3 > 1 && str.charAt(length) == '0')) {
                    break;
                }
                return true;
            }
            char cCharAt = str.charAt(i4);
            if (cCharAt == '.') {
                if (i3 == 0 || (i3 > 1 && str.charAt(length) == '0')) {
                    break;
                }
                i3 = 0;
                length = i4;
            } else {
                if ('0' > cCharAt || cCharAt > '9') {
                    break;
                }
                i3++;
                length = i4;
            }
        }
        return false;
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, long j6) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j6) & 127);
        while (j6 >= 128) {
            j6 >>= 7;
            i--;
            bArr[i] = (byte) (((int) j6) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i = iBitLength - 1;
        for (int i3 = i; i3 >= 0; i3--) {
            bArr[i3] = (byte) (bigInteger.intValue() | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (this == abstractC0899q) {
            return true;
        }
        if (!(abstractC0899q instanceof r)) {
            return false;
        }
        return Arrays.equals(this.f5071a, ((r) abstractC0899q).f5071a);
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5071a, 13, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5071a.length, z6);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5071a);
    }

    public final String toString() {
        String str;
        synchronized (this) {
            try {
                if (this.b == null) {
                    byte[] bArr = this.f5071a;
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
                                    z6 = false;
                                } else {
                                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                                }
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
                                    z6 = false;
                                } else {
                                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                                }
                                sb.append(bigIntegerOr);
                                bigIntegerShiftLeft = null;
                                j6 = 0;
                            } else {
                                bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                            }
                        }
                    }
                    this.b = sb.toString();
                }
                str = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
