package com.google.crypto.tink.shaded.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0381o implements Iterable, Serializable {
    public static final C0379n b = new C0379n(T.b);
    public static final ByteString$ByteArrayCopier c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2900a;

    static {
        c = AbstractC0361e.a() ? new C0375l(1) : new C0375l(0);
    }

    public static int b(int i, int i3, int i4) {
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

    public static C0379n c(byte[] bArr, int i, int i3) {
        b(i, i + i3, bArr.length);
        return new C0379n(c.copyFrom(bArr, i, i3));
    }

    public static C0379n d(String str) {
        return new C0379n(str.getBytes(T.f2849a));
    }

    public abstract byte a(int i);

    public abstract void e(int i, byte[] bArr);

    public abstract byte f(int i);

    public abstract boolean g();

    public abstract AbstractC0388s h();

    public final int hashCode() {
        int i = this.f2900a;
        if (i == 0) {
            int size = size();
            i = i(size, size);
            if (i == 0) {
                i = 1;
            }
            this.f2900a = i;
        }
        return i;
    }

    public abstract int i(int i, int i3);

    public abstract AbstractC0381o j(int i);

    public final byte[] k() {
        int size = size();
        if (size == 0) {
            return T.b;
        }
        byte[] bArr = new byte[size];
        e(size, bArr);
        return bArr;
    }

    public abstract String l(Charset charset);

    public abstract void m(AbstractC0398x abstractC0398x);

    public abstract int size();

    public final String toString() {
        String strS;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strS = AbstractC0369i.s(this);
        } else {
            strS = AbstractC0369i.s(j(47)) + "...";
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return B2.b.h(sb, strS, "\">");
    }
}
