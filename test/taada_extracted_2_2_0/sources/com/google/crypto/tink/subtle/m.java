package com.google.crypto.tink.subtle;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f2963a = Charset.forName("UTF-8");

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (r7 != 4) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.m.a(java.lang.String):byte[]");
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = l.b;
        int i = (length / 3) * 4;
        if (length % 3 > 0) {
            i += 4;
        }
        byte[] bArr3 = new byte[i];
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int i6 = i3 + 3;
            if (i6 > length) {
                break;
            }
            int i7 = (bArr[i3 + 2] & 255) | ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
            bArr3[i5] = bArr2[(i7 >> 18) & 63];
            bArr3[i5 + 1] = bArr2[(i7 >> 12) & 63];
            bArr3[i5 + 2] = bArr2[(i7 >> 6) & 63];
            bArr3[i5 + 3] = bArr2[i7 & 63];
            int i8 = i5 + 4;
            i4--;
            if (i4 == 0) {
                i5 += 5;
                bArr3[i8] = 10;
                i4 = 19;
            } else {
                i5 = i8;
            }
            i3 = i6;
        }
        if (i3 == length - 1) {
            int i9 = (bArr[i3] & 255) << 4;
            bArr3[i5] = bArr2[(i9 >> 6) & 63];
            bArr3[i5 + 1] = bArr2[i9 & 63];
            bArr3[i5 + 2] = 61;
            bArr3[i5 + 3] = 61;
            return bArr3;
        }
        if (i3 == length - 2) {
            int i10 = ((bArr[i3 + 1] & 255) << 2) | ((bArr[i3] & 255) << 10);
            bArr3[i5] = bArr2[(i10 >> 12) & 63];
            bArr3[i5 + 1] = bArr2[(i10 >> 6) & 63];
            bArr3[i5 + 2] = bArr2[i10 & 63];
            bArr3[i5 + 3] = 61;
        }
        return bArr3;
    }
}
