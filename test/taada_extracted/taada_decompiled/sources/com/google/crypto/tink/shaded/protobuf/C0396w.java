package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0396w extends AbstractC0398x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f2921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2923h;
    public final OutputStream i;

    public C0396w(OutputStream outputStream, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.f2921f = new byte[iMax];
        this.f2922g = iMax;
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.i = outputStream;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void L(byte b) {
        if (this.f2923h == this.f2922g) {
            n0();
        }
        int i = this.f2923h;
        this.f2923h = i + 1;
        this.f2921f[i] = b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void M(int i, boolean z6) {
        o0(11);
        k0(i, 0);
        byte b = z6 ? (byte) 1 : (byte) 0;
        int i3 = this.f2923h;
        this.f2923h = i3 + 1;
        this.f2921f[i3] = b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void N(int i, byte[] bArr) throws IOException {
        f0(i);
        p0(bArr, 0, i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void O(int i, AbstractC0381o abstractC0381o) {
        d0(i, 2);
        P(abstractC0381o);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void P(AbstractC0381o abstractC0381o) {
        f0(abstractC0381o.size());
        abstractC0381o.m(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void Q(int i, int i3) {
        o0(14);
        k0(i, 5);
        i0(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void R(int i) {
        o0(4);
        i0(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void S(int i, long j6) {
        o0(18);
        k0(i, 1);
        j0(j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void T(long j6) {
        o0(8);
        j0(j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void U(int i, int i3) {
        o0(20);
        k0(i, 0);
        if (i3 >= 0) {
            l0(i3);
        } else {
            m0(i3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void V(int i) {
        if (i >= 0) {
            f0(i);
        } else {
            h0(i);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void W(int i, MessageLite messageLite) {
        d0(i, 2);
        Y(messageLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void X(int i, MessageLite messageLite, Schema schema) {
        d0(i, 2);
        f0(((AbstractC0357c) messageLite).a(schema));
        schema.writeTo(messageLite, this.c);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void Y(MessageLite messageLite) {
        f0(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void Z(int i, MessageLite messageLite) {
        d0(1, 3);
        e0(2, i);
        W(3, messageLite);
        d0(1, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void a0(int i, AbstractC0381o abstractC0381o) {
        d0(1, 3);
        e0(2, i);
        O(3, abstractC0381o);
        d0(1, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void b0(int i, String str) throws IOException {
        d0(i, 2);
        c0(str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void c0(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int I = AbstractC0398x.I(length);
            int i = I + length;
            int i3 = this.f2922g;
            if (i > i3) {
                byte[] bArr = new byte[length];
                int iR = V0.f2851a.r(0, length, str, bArr);
                f0(iR);
                p0(bArr, 0, iR);
                return;
            }
            if (i > i3 - this.f2923h) {
                n0();
            }
            int I5 = AbstractC0398x.I(str.length());
            int i4 = this.f2923h;
            byte[] bArr2 = this.f2921f;
            try {
                if (I5 == I) {
                    int i5 = i4 + I5;
                    this.f2923h = i5;
                    int iR2 = V0.f2851a.r(i5, i3 - i5, str, bArr2);
                    this.f2923h = i4;
                    l0((iR2 - i4) - I5);
                    this.f2923h = iR2;
                } else {
                    int iB = V0.b(str);
                    l0(iB);
                    this.f2923h = V0.f2851a.r(this.f2923h, iB, str, bArr2);
                }
            } catch (U0 e) {
                this.f2923h = i4;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e6) {
                throw new C0394v(e6);
            }
        } catch (U0 e7) {
            K(str, e7);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void d0(int i, int i3) {
        f0((i << 3) | i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void e0(int i, int i3) {
        o0(20);
        k0(i, 0);
        l0(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void f0(int i) {
        o0(5);
        l0(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void g0(int i, long j6) {
        o0(20);
        k0(i, 0);
        m0(j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void h0(long j6) {
        o0(10);
        m0(j6);
    }

    public final void i0(int i) {
        int i3 = this.f2923h;
        int i4 = i3 + 1;
        this.f2923h = i4;
        byte[] bArr = this.f2921f;
        bArr[i3] = (byte) (i & 255);
        int i5 = i3 + 2;
        this.f2923h = i5;
        bArr[i4] = (byte) ((i >> 8) & 255);
        int i6 = i3 + 3;
        this.f2923h = i6;
        bArr[i5] = (byte) ((i >> 16) & 255);
        this.f2923h = i3 + 4;
        bArr[i6] = (byte) ((i >> 24) & 255);
    }

    public final void j0(long j6) {
        int i = this.f2923h;
        int i3 = i + 1;
        this.f2923h = i3;
        byte[] bArr = this.f2921f;
        bArr[i] = (byte) (j6 & 255);
        int i4 = i + 2;
        this.f2923h = i4;
        bArr[i3] = (byte) ((j6 >> 8) & 255);
        int i5 = i + 3;
        this.f2923h = i5;
        bArr[i4] = (byte) ((j6 >> 16) & 255);
        int i6 = i + 4;
        this.f2923h = i6;
        bArr[i5] = (byte) (255 & (j6 >> 24));
        int i7 = i + 5;
        this.f2923h = i7;
        bArr[i6] = (byte) (((int) (j6 >> 32)) & 255);
        int i8 = i + 6;
        this.f2923h = i8;
        bArr[i7] = (byte) (((int) (j6 >> 40)) & 255);
        int i9 = i + 7;
        this.f2923h = i9;
        bArr[i8] = (byte) (((int) (j6 >> 48)) & 255);
        this.f2923h = i + 8;
        bArr[i9] = (byte) (((int) (j6 >> 56)) & 255);
    }

    public final void k0(int i, int i3) {
        l0((i << 3) | i3);
    }

    public final void l0(int i) {
        boolean z6 = AbstractC0398x.e;
        byte[] bArr = this.f2921f;
        if (z6) {
            while ((i & (-128)) != 0) {
                int i3 = this.f2923h;
                this.f2923h = i3 + 1;
                S0.k(bArr, i3, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            int i4 = this.f2923h;
            this.f2923h = i4 + 1;
            S0.k(bArr, i4, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i5 = this.f2923h;
            this.f2923h = i5 + 1;
            bArr[i5] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        int i6 = this.f2923h;
        this.f2923h = i6 + 1;
        bArr[i6] = (byte) i;
    }

    public final void m0(long j6) {
        boolean z6 = AbstractC0398x.e;
        byte[] bArr = this.f2921f;
        if (z6) {
            while ((j6 & (-128)) != 0) {
                int i = this.f2923h;
                this.f2923h = i + 1;
                S0.k(bArr, i, (byte) ((((int) j6) & 127) | 128));
                j6 >>>= 7;
            }
            int i3 = this.f2923h;
            this.f2923h = i3 + 1;
            S0.k(bArr, i3, (byte) j6);
            return;
        }
        while ((j6 & (-128)) != 0) {
            int i4 = this.f2923h;
            this.f2923h = i4 + 1;
            bArr[i4] = (byte) ((((int) j6) & 127) | 128);
            j6 >>>= 7;
        }
        int i5 = this.f2923h;
        this.f2923h = i5 + 1;
        bArr[i5] = (byte) j6;
    }

    public final void n0() {
        this.i.write(this.f2921f, 0, this.f2923h);
        this.f2923h = 0;
    }

    public final void o0(int i) {
        if (this.f2922g - this.f2923h < i) {
            n0();
        }
    }

    public final void p0(byte[] bArr, int i, int i3) throws IOException {
        int i4 = this.f2923h;
        int i5 = this.f2922g;
        int i6 = i5 - i4;
        byte[] bArr2 = this.f2921f;
        if (i6 >= i3) {
            System.arraycopy(bArr, i, bArr2, i4, i3);
            this.f2923h += i3;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i4, i6);
        int i7 = i + i6;
        int i8 = i3 - i6;
        this.f2923h = i5;
        n0();
        if (i8 > i5) {
            this.i.write(bArr, i7, i8);
        } else {
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.f2923h = i8;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0369i
    public final void y(byte[] bArr, int i, int i3) throws IOException {
        p0(bArr, i, i3);
    }
}
