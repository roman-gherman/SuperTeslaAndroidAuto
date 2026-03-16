package com.android.dx.util;

import androidx.constraintlayout.core.motion.a;

/* JADX INFO: loaded from: classes.dex */
public final class HexParser {
    private HexParser() {
    }

    public static byte[] parse(String str) {
        int iIndexOf;
        int length = str.length();
        int i = length / 2;
        byte[] bArr = new byte[i];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iIndexOf2 = str.indexOf(10, i4);
            if (iIndexOf2 < 0) {
                iIndexOf2 = length;
            }
            int iIndexOf3 = str.indexOf(35, i4);
            String strSubstring = (iIndexOf3 < 0 || iIndexOf3 >= iIndexOf2) ? str.substring(i4, iIndexOf2) : str.substring(i4, iIndexOf3);
            int i6 = iIndexOf2 + 1;
            int iIndexOf4 = strSubstring.indexOf(58);
            if (iIndexOf4 != -1 && ((iIndexOf = strSubstring.indexOf(34)) == -1 || iIndexOf >= iIndexOf4)) {
                String strTrim = strSubstring.substring(i3, iIndexOf4).trim();
                strSubstring = strSubstring.substring(iIndexOf4 + 1);
                if (Integer.parseInt(strTrim, 16) != i5) {
                    throw new RuntimeException(a.p("bogus offset marker: ", strTrim));
                }
            }
            int length2 = strSubstring.length();
            int i7 = i3;
            int i8 = i7;
            int i9 = -1;
            while (i7 < length2) {
                char cCharAt = strSubstring.charAt(i7);
                if (i8 != 0) {
                    if (cCharAt == '\"') {
                        i8 = 0;
                    } else {
                        bArr[i5] = (byte) cCharAt;
                        i5++;
                    }
                } else if (cCharAt > ' ') {
                    if (cCharAt != '\"') {
                        int iDigit = Character.digit(cCharAt, 16);
                        if (iDigit == -1) {
                            throw new RuntimeException("bogus digit character: \"" + cCharAt + "\"");
                        }
                        if (i9 == -1) {
                            i9 = iDigit;
                        } else {
                            bArr[i5] = (byte) ((i9 << 4) | iDigit);
                            i5++;
                            i9 = -1;
                        }
                    } else {
                        if (i9 != -1) {
                            throw new RuntimeException("spare digit around offset " + Hex.u4(i5));
                        }
                        i8 = 1;
                    }
                }
                i7++;
            }
            if (i9 != -1) {
                throw new RuntimeException("spare digit around offset " + Hex.u4(i5));
            }
            if (i8 != 0) {
                throw new RuntimeException("unterminated quote around offset " + Hex.u4(i5));
            }
            i4 = i6;
            i3 = 0;
        }
        if (i5 >= i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        return bArr2;
    }
}
