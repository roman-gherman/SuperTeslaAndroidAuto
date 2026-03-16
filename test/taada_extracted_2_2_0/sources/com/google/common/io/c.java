package com.google.common.io;

import kotlin.reflect.l;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {
    /* JADX WARN: Illegal instructions before constructor call */
    public c(String str, String str2) {
        Character chValueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        char[] charArray = str2.toCharArray();
        super(new a(str, charArray), chValueOf);
        if (charArray.length != 64) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.google.common.io.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        CharSequence charSequenceC = c(charSequence);
        int length = charSequenceC.length();
        a aVar = this.f2787a;
        if (!aVar.f2786h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceC.length());
        }
        int i = 0;
        int i3 = 0;
        while (i < charSequenceC.length()) {
            int i4 = i + 2;
            int iA = (aVar.a(charSequenceC.charAt(i + 1)) << 12) | (aVar.a(charSequenceC.charAt(i)) << 18);
            int i5 = i3 + 1;
            bArr[i3] = (byte) (iA >>> 16);
            if (i4 < charSequenceC.length()) {
                int i6 = i + 3;
                int iA2 = iA | (aVar.a(charSequenceC.charAt(i4)) << 6);
                int i7 = i3 + 2;
                bArr[i5] = (byte) ((iA2 >>> 8) & 255);
                if (i6 < charSequenceC.length()) {
                    i += 4;
                    i3 += 3;
                    bArr[i7] = (byte) ((iA2 | aVar.a(charSequenceC.charAt(i6))) & 255);
                } else {
                    i3 = i7;
                    i = i6;
                }
            } else {
                i3 = i5;
                i = i4;
            }
        }
        return i3;
    }

    public final void d(Appendable appendable, byte[] bArr, int i) {
        a aVar;
        int i3 = 0;
        l.h(0, i, bArr.length);
        int i4 = i;
        int i5 = 0;
        while (true) {
            aVar = this.f2787a;
            if (i4 < 3) {
                break;
            }
            int i6 = i5 + 2;
            int i7 = ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5] & 255) << 16);
            i5 += 3;
            int i8 = i7 | (bArr[i6] & 255);
            StringBuilder sb = (StringBuilder) appendable;
            sb.append(aVar.b[i8 >>> 18]);
            char[] cArr = aVar.b;
            sb.append(cArr[(i8 >>> 12) & 63]);
            sb.append(cArr[(i8 >>> 6) & 63]);
            sb.append(cArr[i8 & 63]);
            i4 -= 3;
        }
        if (i5 < i) {
            int i9 = i - i5;
            StringBuilder sb2 = (StringBuilder) appendable;
            l.h(i5, i5 + i9, bArr.length);
            if (i9 > aVar.f2784f) {
                throw new IllegalArgumentException();
            }
            long j6 = 0;
            for (int i10 = 0; i10 < i9; i10++) {
                j6 = (j6 | ((long) (bArr[i5 + i10] & 255))) << 8;
            }
            int i11 = aVar.d;
            int i12 = ((i9 + 1) * 8) - i11;
            while (i3 < i9 * 8) {
                sb2.append(aVar.b[((int) (j6 >>> (i12 - i3))) & aVar.c]);
                i3 += i11;
            }
            Character ch = this.b;
            if (ch != null) {
                while (i3 < aVar.f2784f * 8) {
                    sb2.append(ch.charValue());
                    i3 += i11;
                }
            }
        }
    }
}
