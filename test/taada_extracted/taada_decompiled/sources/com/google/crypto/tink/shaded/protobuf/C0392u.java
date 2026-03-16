package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0392u extends AbstractC0398x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f2917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2919h;

    public C0392u(byte[] bArr, int i) {
        if (((bArr.length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        this.f2917f = bArr;
        this.f2919h = 0;
        this.f2918g = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void L(byte b) throws C0394v {
        try {
            byte[] bArr = this.f2917f;
            int i = this.f2919h;
            this.f2919h = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), 1), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void M(int i, boolean z6) throws C0394v {
        d0(i, 0);
        L(z6 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void N(int i, byte[] bArr) throws C0394v {
        f0(i);
        j0(bArr, 0, i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void O(int i, AbstractC0381o abstractC0381o) throws C0394v {
        d0(i, 2);
        P(abstractC0381o);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void P(AbstractC0381o abstractC0381o) throws C0394v {
        f0(abstractC0381o.size());
        abstractC0381o.m(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void Q(int i, int i3) throws C0394v {
        d0(i, 5);
        R(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void R(int i) throws C0394v {
        try {
            byte[] bArr = this.f2917f;
            int i3 = this.f2919h;
            int i4 = i3 + 1;
            this.f2919h = i4;
            bArr[i3] = (byte) (i & 255);
            int i5 = i3 + 2;
            this.f2919h = i5;
            bArr[i4] = (byte) ((i >> 8) & 255);
            int i6 = i3 + 3;
            this.f2919h = i6;
            bArr[i5] = (byte) ((i >> 16) & 255);
            this.f2919h = i3 + 4;
            bArr[i6] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), 1), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void S(int i, long j6) throws C0394v {
        d0(i, 1);
        T(j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void T(long j6) throws C0394v {
        try {
            byte[] bArr = this.f2917f;
            int i = this.f2919h;
            int i3 = i + 1;
            this.f2919h = i3;
            bArr[i] = (byte) (((int) j6) & 255);
            int i4 = i + 2;
            this.f2919h = i4;
            bArr[i3] = (byte) (((int) (j6 >> 8)) & 255);
            int i5 = i + 3;
            this.f2919h = i5;
            bArr[i4] = (byte) (((int) (j6 >> 16)) & 255);
            int i6 = i + 4;
            this.f2919h = i6;
            bArr[i5] = (byte) (((int) (j6 >> 24)) & 255);
            int i7 = i + 5;
            this.f2919h = i7;
            bArr[i6] = (byte) (((int) (j6 >> 32)) & 255);
            int i8 = i + 6;
            this.f2919h = i8;
            bArr[i7] = (byte) (((int) (j6 >> 40)) & 255);
            int i9 = i + 7;
            this.f2919h = i9;
            bArr[i8] = (byte) (((int) (j6 >> 48)) & 255);
            this.f2919h = i + 8;
            bArr[i9] = (byte) (((int) (j6 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), 1), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void U(int i, int i3) throws C0394v {
        d0(i, 0);
        V(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void V(int i) throws C0394v {
        if (i >= 0) {
            f0(i);
        } else {
            h0(i);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void W(int i, MessageLite messageLite) throws C0394v {
        d0(i, 2);
        Y(messageLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void X(int i, MessageLite messageLite, Schema schema) throws C0394v {
        d0(i, 2);
        f0(((AbstractC0357c) messageLite).a(schema));
        schema.writeTo(messageLite, this.c);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void Y(MessageLite messageLite) throws C0394v {
        f0(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void Z(int i, MessageLite messageLite) throws C0394v {
        d0(1, 3);
        e0(2, i);
        W(3, messageLite);
        d0(1, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void a0(int i, AbstractC0381o abstractC0381o) throws C0394v {
        d0(1, 3);
        e0(2, i);
        O(3, abstractC0381o);
        d0(1, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void b0(int i, String str) throws C0394v {
        d0(i, 2);
        c0(str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void c0(String str) throws C0394v {
        int i = this.f2919h;
        try {
            int I = AbstractC0398x.I(str.length() * 3);
            int I5 = AbstractC0398x.I(str.length());
            byte[] bArr = this.f2917f;
            if (I5 != I) {
                f0(V0.b(str));
                this.f2919h = V0.f2851a.r(this.f2919h, i0(), str, bArr);
                return;
            }
            int i3 = i + I5;
            this.f2919h = i3;
            int iR = V0.f2851a.r(i3, i0(), str, bArr);
            this.f2919h = i;
            f0((iR - i) - I5);
            this.f2919h = iR;
        } catch (U0 e) {
            this.f2919h = i;
            K(str, e);
        } catch (IndexOutOfBoundsException e6) {
            throw new C0394v(e6);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void d0(int i, int i3) throws C0394v {
        f0((i << 3) | i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void e0(int i, int i3) throws C0394v {
        d0(i, 0);
        f0(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void f0(int i) throws C0394v {
        while (true) {
            int i3 = i & (-128);
            byte[] bArr = this.f2917f;
            if (i3 == 0) {
                int i4 = this.f2919h;
                this.f2919h = i4 + 1;
                bArr[i4] = (byte) i;
                return;
            } else {
                try {
                    int i5 = this.f2919h;
                    this.f2919h = i5 + 1;
                    bArr[i5] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), 1), e);
                }
            }
            throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), 1), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void g0(int i, long j6) throws C0394v {
        d0(i, 0);
        h0(j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0398x
    public final void h0(long j6) throws C0394v {
        byte[] bArr = this.f2917f;
        if (AbstractC0398x.e && i0() >= 10) {
            while ((j6 & (-128)) != 0) {
                int i = this.f2919h;
                this.f2919h = i + 1;
                S0.k(bArr, i, (byte) ((((int) j6) & 127) | 128));
                j6 >>>= 7;
            }
            int i3 = this.f2919h;
            this.f2919h = i3 + 1;
            S0.k(bArr, i3, (byte) j6);
            return;
        }
        while ((j6 & (-128)) != 0) {
            try {
                int i4 = this.f2919h;
                this.f2919h = i4 + 1;
                bArr[i4] = (byte) ((((int) j6) & 127) | 128);
                j6 >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), 1), e);
            }
        }
        int i5 = this.f2919h;
        this.f2919h = i5 + 1;
        bArr[i5] = (byte) j6;
    }

    public final int i0() {
        return this.f2918g - this.f2919h;
    }

    public final void j0(byte[] bArr, int i, int i3) throws C0394v {
        try {
            System.arraycopy(bArr, i, this.f2917f, this.f2919h, i3);
            this.f2919h += i3;
        } catch (IndexOutOfBoundsException e) {
            throw new C0394v(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2919h), Integer.valueOf(this.f2918g), Integer.valueOf(i3)), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0369i
    public final void y(byte[] bArr, int i, int i3) throws C0394v {
        j0(bArr, i, i3);
    }
}
