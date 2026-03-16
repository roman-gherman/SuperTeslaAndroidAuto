package com.google.common.io;

import java.util.Arrays;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final c c = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final c d = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2787a;
    public final Character b;

    static {
        new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        new b();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(com.google.common.io.a r3, java.lang.Character r4) {
        /*
            r2 = this;
            r2.<init>()
            r2.f2787a = r3
            if (r4 == 0) goto L17
            char r0 = r4.charValue()
            byte[] r3 = r3.f2785g
            int r1 = r3.length
            if (r0 >= r1) goto L17
            r3 = r3[r0]
            r0 = -1
            if (r3 == r0) goto L17
            r3 = 0
            goto L18
        L17:
            r3 = 1
        L18:
            if (r3 == 0) goto L1d
            r2.b = r4
            return
        L1d:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r0 = "Padding character %s was already in alphabet"
            java.lang.String r4 = C5.f.R(r0, r4)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.e.<init>(com.google.common.io.a, java.lang.Character):void");
    }

    public final byte[] a(String str) {
        try {
            CharSequence charSequenceC = c(str);
            int length = (int) (((((long) this.f2787a.d) * ((long) charSequenceC.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int iB = b(bArr, charSequenceC);
            if (iB == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[iB];
            System.arraycopy(bArr, 0, bArr2, 0, iB);
            return bArr2;
        } catch (d e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int b(byte[] bArr, CharSequence charSequence) throws d {
        int i;
        int i3;
        CharSequence charSequenceC = c(charSequence);
        int length = charSequenceC.length();
        a aVar = this.f2787a;
        if (!aVar.f2786h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceC.length());
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < charSequenceC.length()) {
            long jA = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i = aVar.d;
                i3 = aVar.e;
                if (i6 >= i3) {
                    break;
                }
                jA <<= i;
                if (i4 + i6 < charSequenceC.length()) {
                    jA |= (long) aVar.a(charSequenceC.charAt(i7 + i4));
                    i7++;
                }
                i6++;
            }
            int i8 = aVar.f2784f;
            int i9 = (i8 * 8) - (i7 * i);
            int i10 = (i8 - 1) * 8;
            while (i10 >= i9) {
                bArr[i5] = (byte) ((jA >>> i10) & 255);
                i10 -= 8;
                i5++;
            }
            i4 += i3;
        }
        return i5;
    }

    public final CharSequence c(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.b;
        if (ch == null) {
            return charSequence;
        }
        char cCharValue = ch.charValue();
        int length = charSequence.length() - 1;
        while (length >= 0 && charSequence.charAt(length) == cCharValue) {
            length--;
        }
        return charSequence.subSequence(0, length + 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f2787a.equals(eVar.f2787a)) {
                Character ch = this.b;
                Character ch2 = eVar.b;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2787a.b) ^ Arrays.hashCode(new Object[]{this.b});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        a aVar = this.f2787a;
        sb.append(aVar.f2783a);
        if (8 % aVar.d != 0) {
            Character ch = this.b;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public e(String str, String str2) {
        this(new a(str, str2.toCharArray()), Character.valueOf(SignatureVisitor.INSTANCEOF));
    }
}
