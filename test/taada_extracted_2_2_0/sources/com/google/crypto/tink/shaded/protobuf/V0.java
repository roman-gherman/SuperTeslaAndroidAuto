package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class V0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0369i f2851a;

    static {
        f2851a = (S0.e && S0.d && !AbstractC0361e.a()) ? new T0(1) : new T0(0);
    }

    public static int a(byte[] bArr, int i, int i3) {
        byte b = bArr[i - 1];
        int i4 = i3 - i;
        if (i4 == 0) {
            if (b > -12) {
                return -1;
            }
            return b;
        }
        if (i4 == 1) {
            return c(b, bArr[i]);
        }
        if (i4 == 2) {
            return d(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i3 = 0;
        while (i3 < length && str.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                int length2 = str.length();
                while (i3 < length2) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) < 65536) {
                                throw new U0(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i4) + 4294967296L));
    }

    public static int c(int i, int i3) {
        if (i > -12 || i3 > -65) {
            return -1;
        }
        return i ^ (i3 << 8);
    }

    public static int d(int i, int i3, int i4) {
        if (i > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i ^ (i3 << 8)) ^ (i4 << 16);
    }
}
