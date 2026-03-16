package w3;

import java.io.IOException;

/* JADX INFO: renamed from: w3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0906y extends AbstractC0884b {
    public final int d;
    public final AbstractC0884b[] e;

    public C0906y(byte[] bArr, int i) {
        super(bArr, i);
        this.e = null;
        this.d = 1000;
    }

    public static byte[] p(AbstractC0884b[] abstractC0884bArr) {
        int length = abstractC0884bArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return abstractC0884bArr[0].f5046a;
        }
        int i = length - 1;
        int length2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr = abstractC0884bArr[i3].f5046a;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            length2 += bArr.length - 1;
        }
        byte[] bArr2 = abstractC0884bArr[i].f5046a;
        byte b = bArr2[0];
        byte[] bArr3 = new byte[length2 + bArr2.length];
        bArr3[0] = b;
        int i4 = 1;
        for (AbstractC0884b abstractC0884b : abstractC0884bArr) {
            byte[] bArr4 = abstractC0884b.f5046a;
            int length3 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i4, length3);
            i4 += length3;
        }
        return bArr3;
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        boolean zD = d();
        byte[] bArr = this.f5046a;
        if (!zD) {
            int length = bArr.length;
            c0898p.p(3, z6);
            c0898p.k(length);
            c0898p.j(bArr, 0, length);
            return;
        }
        c0898p.p(35, z6);
        c0898p.i(128);
        AbstractC0884b[] abstractC0884bArr = this.e;
        if (abstractC0884bArr != null) {
            c0898p.r(abstractC0884bArr);
        } else if (bArr.length >= 2) {
            byte b = bArr[0];
            int length2 = bArr.length;
            int i = length2 - 1;
            int i3 = this.d;
            int i4 = i3 - 1;
            while (i > i4) {
                c0898p.i(3);
                c0898p.k(i3);
                c0898p.i(0);
                c0898p.j(bArr, length2 - i, i4);
                i -= i4;
            }
            c0898p.i(3);
            c0898p.k(i + 1);
            c0898p.i(b);
            c0898p.j(bArr, length2 - i, i);
        }
        c0898p.i(0);
        c0898p.i(0);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return this.e != null || this.f5046a.length > this.d;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        boolean zD = d();
        byte[] bArr = this.f5046a;
        if (!zD) {
            return C0898p.f(bArr.length, z6);
        }
        int iE = z6 ? 4 : 3;
        AbstractC0884b[] abstractC0884bArr = this.e;
        if (abstractC0884bArr != null) {
            for (AbstractC0884b abstractC0884b : abstractC0884bArr) {
                iE += abstractC0884b.e(true);
            }
            return iE;
        }
        if (bArr.length < 2) {
            return iE;
        }
        int length = bArr.length - 2;
        int i = this.d;
        int i3 = i - 1;
        int i4 = length / i3;
        return C0898p.f(bArr.length - (i3 * i4), true) + (C0898p.f(i, true) * i4) + iE;
    }

    public C0906y(AbstractC0884b[] abstractC0884bArr) {
        super(p(abstractC0884bArr));
        this.e = abstractC0884bArr;
        this.d = 1000;
    }
}
