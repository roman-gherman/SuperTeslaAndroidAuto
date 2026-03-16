package com.google.crypto.tink.shaded.protobuf;

import fr.sd.taada.proto.KeyCode;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class T0 extends AbstractC0369i {
    public final /* synthetic */ int c;

    public /* synthetic */ T0(int i) {
        this.c = i;
    }

    public static int z(byte[] bArr, int i, long j6, int i3) {
        if (i3 == 0) {
            AbstractC0369i abstractC0369i = V0.f2851a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i3 == 1) {
            return V0.c(i, S0.g(bArr, j6));
        }
        if (i3 == 2) {
            return V0.d(i, S0.g(bArr, j6), S0.g(bArr, j6 + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0369i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(byte[] r8, int r9, int r10) throws com.google.crypto.tink.shaded.protobuf.V {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.T0.k(byte[], int, int):java.lang.String");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0369i
    public final String m(ByteBuffer byteBuffer, int i, int i3) throws V {
        long j6;
        byte bE;
        byte bE2;
        switch (this.c) {
            case 0:
                return AbstractC0369i.l(byteBuffer, i, i3);
            default:
                if ((i | i3 | ((byteBuffer.limit() - i) - i3)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i3)));
                }
                long j7 = S0.c.j(byteBuffer, S0.f2847g) + ((long) i);
                long j8 = ((long) i3) + j7;
                char[] cArr = new char[i3];
                int i4 = 0;
                while (true) {
                    j6 = 1;
                    if (j7 < j8 && (bE2 = S0.c.e(j7)) >= 0) {
                        j7++;
                        cArr[i4] = (char) bE2;
                        i4++;
                    }
                }
                int i5 = i4;
                while (j7 < j8) {
                    long j9 = j7 + j6;
                    R0 r02 = S0.c;
                    byte bE3 = r02.e(j7);
                    if (bE3 >= 0) {
                        int i6 = i5 + 1;
                        cArr[i5] = (char) bE3;
                        while (j9 < j8 && (bE = S0.c.e(j9)) >= 0) {
                            j9 += j6;
                            cArr[i6] = (char) bE;
                            i6++;
                        }
                        i5 = i6;
                        j7 = j9;
                    } else {
                        if (!(bE3 < -32)) {
                            if (bE3 < -16) {
                                if (j9 >= j8 - j6) {
                                    throw V.b();
                                }
                                long j10 = j7 + 2;
                                j7 += 3;
                                AbstractC0369i.c(bE3, r02.e(j9), r02.e(j10), cArr, i5);
                                i5++;
                            } else {
                                if (j9 >= j8 - 2) {
                                    throw V.b();
                                }
                                byte bE4 = r02.e(j9);
                                long j11 = j7 + 3;
                                byte bE5 = r02.e(j7 + 2);
                                j7 += 4;
                                AbstractC0369i.a(bE3, bE4, bE5, r02.e(j11), cArr, i5);
                                i5 += 2;
                            }
                        } else {
                            if (j9 >= j8) {
                                throw V.b();
                            }
                            j7 += 2;
                            AbstractC0369i.b(bE3, r02.e(j9), cArr, i5);
                            i5++;
                        }
                    }
                    j6 = 1;
                }
                return new String(cArr, 0, i5);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0369i
    public final int r(int i, int i3, String str, byte[] bArr) {
        int i4;
        int i5;
        char cCharAt;
        long j6;
        char c;
        long j7;
        String str2;
        int i6;
        char c6;
        int i7;
        char cCharAt2;
        String str3 = str;
        switch (this.c) {
            case 0:
                int length = str3.length();
                int i8 = i3 + i;
                int i9 = 0;
                while (i9 < length && (i5 = i9 + i) < i8 && (cCharAt = str3.charAt(i9)) < 128) {
                    bArr[i5] = (byte) cCharAt;
                    i9++;
                }
                if (i9 == length) {
                    return i + length;
                }
                int i10 = i + i9;
                while (i9 < length) {
                    char cCharAt3 = str3.charAt(i9);
                    if (cCharAt3 < 128 && i10 < i8) {
                        bArr[i10] = (byte) cCharAt3;
                        i10++;
                    } else if (cCharAt3 < 2048 && i10 <= i8 - 2) {
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) ((cCharAt3 >>> 6) | 960);
                        i10 += 2;
                        bArr[i11] = (byte) ((cCharAt3 & '?') | 128);
                    } else {
                        if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i10 > i8 - 3) {
                            if (i10 > i8 - 4) {
                                if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i4 = i9 + 1) == str3.length() || !Character.isSurrogatePair(cCharAt3, str3.charAt(i4)))) {
                                    throw new U0(i9, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i10);
                            }
                            int i12 = i9 + 1;
                            if (i12 != str3.length()) {
                                char cCharAt4 = str3.charAt(i12);
                                if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                    int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                    bArr[i10] = (byte) ((codePoint >>> 18) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE);
                                    bArr[i10 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i13 = i10 + 3;
                                    bArr[i10 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i10 += 4;
                                    bArr[i13] = (byte) ((codePoint & 63) | 128);
                                    i9 = i12;
                                } else {
                                    i9 = i12;
                                }
                            }
                            throw new U0(i9 - 1, length);
                        }
                        bArr[i10] = (byte) ((cCharAt3 >>> '\f') | 480);
                        int i14 = i10 + 2;
                        bArr[i10 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                        i10 += 3;
                        bArr[i14] = (byte) ((cCharAt3 & '?') | 128);
                    }
                    i9++;
                }
                return i10;
            default:
                long j8 = i;
                long j9 = ((long) i3) + j8;
                int length2 = str3.length();
                if (length2 > i3 || bArr.length - i3 < i) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str3.charAt(length2 - 1) + " at index " + (i + i3));
                }
                int i15 = 0;
                while (true) {
                    j6 = 1;
                    c = 128;
                    if (i15 < length2 && (cCharAt2 = str3.charAt(i15)) < 128) {
                        S0.k(bArr, j8, (byte) cCharAt2);
                        i15++;
                        j8 = 1 + j8;
                    }
                }
                if (i15 != length2) {
                    while (i15 < length2) {
                        char cCharAt5 = str3.charAt(i15);
                        if (cCharAt5 < c && j8 < j9) {
                            S0.k(bArr, j8, (byte) cCharAt5);
                            i6 = i15;
                            c6 = c;
                            j7 = j6;
                            j8 += j6;
                        } else if (cCharAt5 >= 2048 || j8 > j9 - 2) {
                            j7 = j6;
                            if ((cCharAt5 >= 55296 && 57343 >= cCharAt5) || j8 > j9 - 3) {
                                if (j8 > j9 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i7 = i15 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i7)))) {
                                        throw new U0(i15, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j8);
                                }
                                i6 = i15 + 1;
                                if (i6 != length2) {
                                    str2 = str;
                                    char cCharAt6 = str2.charAt(i6);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        S0.k(bArr, j8, (byte) ((codePoint2 >>> 18) | KeyCode.KEYCODE_TV_SATELLITE_SERVICE_VALUE));
                                        int i16 = (codePoint2 >>> 12) & 63;
                                        c6 = 128;
                                        S0.k(bArr, j8 + j7, (byte) (i16 | 128));
                                        long j10 = j8 + 3;
                                        S0.k(bArr, j8 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j8 += 4;
                                        S0.k(bArr, j10, (byte) ((codePoint2 & 63) | 128));
                                    } else {
                                        i15 = i6;
                                    }
                                }
                                throw new U0(i15 - 1, length2);
                            }
                            S0.k(bArr, j8, (byte) ((cCharAt5 >>> '\f') | 480));
                            long j11 = j8 + 2;
                            S0.k(bArr, j8 + j7, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j8 += 3;
                            S0.k(bArr, j11, (byte) ((cCharAt5 & '?') | 128));
                            str2 = str;
                            i6 = i15;
                            c6 = 128;
                            c = c6;
                            i15 = i6 + 1;
                            str3 = str2;
                            j6 = j7;
                        } else {
                            j7 = j6;
                            long j12 = j8 + j7;
                            S0.k(bArr, j8, (byte) ((cCharAt5 >>> 6) | 960));
                            j8 += 2;
                            S0.k(bArr, j12, (byte) ((cCharAt5 & '?') | c));
                            i6 = i15;
                            c6 = c;
                        }
                        str2 = str3;
                        c = c6;
                        i15 = i6 + 1;
                        str3 = str2;
                        j6 = j7;
                    }
                }
                return (int) j8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fa, code lost:
    
        return -1;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0369i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int w(byte[] r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.T0.w(byte[], int, int):int");
    }
}
