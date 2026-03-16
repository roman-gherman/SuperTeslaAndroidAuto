package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0388s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2914a;
    public C0390t b;

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j6) {
        return (-(j6 & 1)) ^ (j6 >>> 1);
    }

    public static C0383p f(byte[] bArr, int i, int i3, boolean z6) {
        C0383p c0383p = new C0383p(bArr, i, i3, z6);
        try {
            c0383p.j(i3);
            return c0383p;
        } catch (V e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static AbstractC0388s g(InputStream inputStream) {
        if (inputStream != null) {
            return new C0385q(inputStream);
        }
        byte[] bArr = T.b;
        return f(bArr, 0, bArr.length, false);
    }

    public static AbstractC0388s h(ByteBuffer byteBuffer, boolean z6) {
        if (byteBuffer.hasArray()) {
            return f(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z6);
        }
        if (byteBuffer.isDirect() && S0.d) {
            return new r(byteBuffer, z6);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return f(bArr, 0, iRemaining, true);
    }

    public static int t(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i3 = i & 127;
        int i4 = 7;
        while (i4 < 32) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw V.g();
            }
            i3 |= (i5 & 127) << i4;
            if ((i5 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int i6 = inputStream.read();
            if (i6 == -1) {
                throw V.g();
            }
            if ((i6 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw V.d();
    }

    public abstract int A();

    public abstract int B();

    public abstract long C();

    public abstract boolean D(int i);

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract void i(int i);

    public abstract int j(int i);

    public abstract boolean k();

    public abstract C0379n l();

    public abstract double m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract float q();

    public abstract int r();

    public abstract long s();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract String y();

    public abstract String z();
}
