package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f3843a = new B();
    public static final C b = new C();

    public static int a(int i, int i3) {
        if (i > -12 || i3 > -65) {
            return -1;
        }
        return i ^ (i3 << 8);
    }

    public static int b(byte[] bArr, int i, int i3) {
        byte b2 = bArr[i - 1];
        int i4 = i3 - i;
        if (i4 == 0) {
            if (b2 > -12) {
                return -1;
            }
            return b2;
        }
        if (i4 == 1) {
            return a(b2, bArr[i]);
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        byte b6 = bArr[i];
        byte b7 = bArr[i + 1];
        if (b2 > -12 || b6 > -65 || b7 > -65) {
            return -1;
        }
        return (b7 << 16) ^ ((b6 << 8) ^ b2);
    }

    public static int c(byte[] bArr, int i, int i3) {
        while (i < i3 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i3) {
            return 0;
        }
        while (i < i3) {
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                i = i4;
            } else if (b2 < -32) {
                if (i4 >= i3) {
                    return b2;
                }
                if (b2 < -62) {
                    return -1;
                }
                i += 2;
                if (bArr[i4] > -65) {
                    return -1;
                }
            } else if (b2 < -16) {
                if (i4 >= i3 - 1) {
                    return b(bArr, i4, i3);
                }
                int i5 = i + 2;
                byte b6 = bArr[i4];
                if (b6 > -65) {
                    return -1;
                }
                if (b2 == -32 && b6 < -96) {
                    return -1;
                }
                if (b2 == -19 && b6 >= -96) {
                    return -1;
                }
                i += 3;
                if (bArr[i5] > -65) {
                    return -1;
                }
            } else {
                if (i4 >= i3 - 2) {
                    return b(bArr, i4, i3);
                }
                int i6 = i + 2;
                byte b7 = bArr[i4];
                if (b7 > -65) {
                    return -1;
                }
                if ((((b7 + 112) + (b2 << 28)) >> 30) != 0) {
                    return -1;
                }
                int i7 = i + 3;
                if (bArr[i6] > -65) {
                    return -1;
                }
                i += 4;
                if (bArr[i7] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
