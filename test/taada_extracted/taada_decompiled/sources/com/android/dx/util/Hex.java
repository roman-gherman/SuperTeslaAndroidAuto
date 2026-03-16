package com.android.dx.util;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public final class Hex {
    private Hex() {
    }

    public static String dump(byte[] bArr, int i, int i3, int i4, int i5, int i6) {
        int i7 = i + i3;
        if ((i | i3 | i7) < 0 || i7 > bArr.length) {
            throw new IndexOutOfBoundsException("arr.length " + bArr.length + "; " + i + "..!" + i7);
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("outOffset < 0");
        }
        if (i3 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((i3 * 4) + 6);
        int i8 = 0;
        while (i3 > 0) {
            if (i8 == 0) {
                sb.append(i6 != 2 ? i6 != 4 ? i6 != 6 ? u4(i4) : u3(i4) : u2(i4) : u1(i4));
                sb.append(": ");
            } else if ((i8 & 1) == 0) {
                sb.append(' ');
            }
            sb.append(u1(bArr[i]));
            i4++;
            i++;
            i8++;
            if (i8 == i5) {
                sb.append('\n');
                i8 = 0;
            }
            i3--;
        }
        if (i8 != 0) {
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String s1(int i) {
        char[] cArr = new char[3];
        if (i < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i = -i;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            cArr[2 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String s2(int i) {
        char[] cArr = new char[5];
        if (i < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i = -i;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[4 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String s4(int i) {
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i = -i;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            cArr[8 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String s8(long j6) {
        char[] cArr = new char[17];
        if (j6 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            j6 = -j6;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i = 0; i < 16; i++) {
            cArr[16 - i] = Character.forDigit(((int) j6) & 15, 16);
            j6 >>= 4;
        }
        return new String(cArr);
    }

    public static String u1(int i) {
        char[] cArr = new char[2];
        for (int i3 = 0; i3 < 2; i3++) {
            cArr[1 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u2(int i) {
        char[] cArr = new char[4];
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[3 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u2or4(int i) {
        return i == ((char) i) ? u2(i) : u4(i);
    }

    public static String u3(int i) {
        char[] cArr = new char[6];
        for (int i3 = 0; i3 < 6; i3++) {
            cArr[5 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u4(int i) {
        char[] cArr = new char[8];
        for (int i3 = 0; i3 < 8; i3++) {
            cArr[7 - i3] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u8(long j6) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j6) & 15, 16);
            j6 >>= 4;
        }
        return new String(cArr);
    }

    public static String uNibble(int i) {
        return new String(new char[]{Character.forDigit(i & 15, 16)});
    }
}
