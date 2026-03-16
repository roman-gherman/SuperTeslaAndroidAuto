package com.google.common.io;

import C5.f;
import E1.k;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2783a;
    public final char[] b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f2785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f2786h;

    public a(String str, char[] cArr) {
        this.f2783a = str;
        cArr.getClass();
        this.b = cArr;
        try {
            int length = cArr.length;
            RoundingMode roundingMode = RoundingMode.UNNECESSARY;
            int iY = k.Y(length);
            this.d = iY;
            int iMin = Math.min(8, Integer.lowestOneBit(iY));
            try {
                this.e = 8 / iMin;
                this.f2784f = iY / iMin;
                this.c = cArr.length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                for (int i = 0; i < cArr.length; i++) {
                    char c = cArr[i];
                    if (!(c < 128)) {
                        throw new IllegalArgumentException(f.R("Non-ASCII character: %s", Character.valueOf(c)));
                    }
                    if (!(bArr[c] == -1)) {
                        throw new IllegalArgumentException(f.R("Duplicate character: %s", Character.valueOf(c)));
                    }
                    bArr[c] = (byte) i;
                }
                this.f2785g = bArr;
                boolean[] zArr = new boolean[this.e];
                for (int i3 = 0; i3 < this.f2784f; i3++) {
                    int i4 = this.d;
                    RoundingMode roundingMode2 = RoundingMode.CEILING;
                    zArr[k.x(i3 * 8, i4)] = true;
                }
                this.f2786h = zArr;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("Illegal alphabet ".concat(new String(cArr)), e);
            }
        } catch (ArithmeticException e6) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e6);
        }
    }

    public final int a(char c) throws d {
        if (c > 127) {
            throw new d(androidx.constraintlayout.core.motion.a.h(c, new StringBuilder("Unrecognized character: 0x")));
        }
        byte b = this.f2785g[c];
        if (b != -1) {
            return b;
        }
        if (c <= ' ' || c == 127) {
            throw new d(androidx.constraintlayout.core.motion.a.h(c, new StringBuilder("Unrecognized character: 0x")));
        }
        throw new d("Unrecognized character: " + c);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(this.b, ((a) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public final String toString() {
        return this.f2783a;
    }
}
