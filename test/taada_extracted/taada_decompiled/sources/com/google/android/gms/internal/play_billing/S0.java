package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class S0 implements Iterable, Serializable {
    public static final R0 b = new R0(AbstractC0278f1.b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2051a;

    static {
        int i = M0.f2045a;
    }

    public static int d(int i, int i3, int i4) {
        int i5 = i3 - i;
        if ((i | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(B2.b.d(i, "Beginning index: ", " < 0"));
        }
        if (i3 < i) {
            throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("Beginning index larger than ending index: ", i, ", ", i3));
        }
        throw new IndexOutOfBoundsException(androidx.constraintlayout.core.motion.a.n("End index: ", i3, " >= ", i4));
    }

    public static R0 e(byte[] bArr, int i, int i3) {
        d(i, i + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new R0(bArr2);
    }

    public abstract byte a(int i);

    public abstract byte b(int i);

    public abstract int c();

    public final int hashCode() {
        int i = this.f2051a;
        if (i != 0) {
            return i;
        }
        int iC = c();
        R0 r02 = (R0) this;
        int i3 = iC;
        for (int i4 = 0; i4 < iC; i4++) {
            i3 = (i3 * 31) + r02.c[i4];
        }
        if (i3 == 0) {
            i3 = 1;
        }
        this.f2051a = i3;
        return i3;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new P0(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iC = c();
        if (c() <= 50) {
            strConcat = AbstractC0263a1.d(this);
        } else {
            R0 r02 = (R0) this;
            int iD = d(0, 47, r02.c());
            strConcat = AbstractC0263a1.d(iD == 0 ? b : new Q0(r02.c, iD)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iC);
        sb.append(" contents=\"");
        return B2.b.h(sb, strConcat, "\">");
    }
}
