package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0379n extends AbstractC0381o {
    private static final long serialVersionUID = 1;
    public final byte[] d;

    public C0379n(byte[] bArr) {
        this.f2900a = 0;
        bArr.getClass();
        this.d = bArr;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public byte a(int i) {
        return this.d[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public void e(int i, byte[] bArr) {
        System.arraycopy(this.d, 0, bArr, 0, i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0381o) || size() != ((AbstractC0381o) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C0379n)) {
            return obj.equals(this);
        }
        C0379n c0379n = (C0379n) obj;
        int i = this.f2900a;
        int i3 = c0379n.f2900a;
        if (i != 0 && i3 != 0 && i != i3) {
            return false;
        }
        int size = size();
        if (size > c0379n.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > c0379n.size()) {
            StringBuilder sbJ = B2.b.j(size, "Ran off end of other: 0, ", ", ");
            sbJ.append(c0379n.size());
            throw new IllegalArgumentException(sbJ.toString());
        }
        int iN = n() + size;
        int iN2 = n();
        int iN3 = c0379n.n();
        while (iN2 < iN) {
            if (this.d[iN2] != c0379n.d[iN3]) {
                return false;
            }
            iN2++;
            iN3++;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public byte f(int i) {
        return this.d[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final boolean g() {
        int iN = n();
        return V0.f2851a.u(this.d, iN, size() + iN);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final AbstractC0388s h() {
        return AbstractC0388s.f(this.d, n(), size(), true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final int i(int i, int i3) {
        int iN = n();
        Charset charset = T.f2849a;
        for (int i4 = iN; i4 < iN + i3; i4++) {
            i = (i * 31) + this.d[i4];
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0373k(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final AbstractC0381o j(int i) {
        int iB = AbstractC0381o.b(0, i, size());
        if (iB == 0) {
            return AbstractC0381o.b;
        }
        return new C0377m(this.d, n(), iB);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final String l(Charset charset) {
        return new String(this.d, n(), size(), charset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public final void m(AbstractC0398x abstractC0398x) {
        abstractC0398x.y(this.d, n(), size());
    }

    public int n() {
        return 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0381o
    public int size() {
        return this.d.length;
    }
}
