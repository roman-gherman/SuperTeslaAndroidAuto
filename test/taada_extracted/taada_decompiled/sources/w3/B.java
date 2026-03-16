package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends AbstractC0897o {
    public final int d;
    public final AbstractC0897o[] e;

    public B(byte[] bArr, AbstractC0897o[] abstractC0897oArr) {
        super(bArr);
        this.e = abstractC0897oArr;
        this.d = 1000;
    }

    public static byte[] k(AbstractC0897o[] abstractC0897oArr) {
        int length = abstractC0897oArr.length;
        if (length == 0) {
            return AbstractC0897o.c;
        }
        if (length == 1) {
            return abstractC0897oArr[0].f5066a;
        }
        int length2 = 0;
        for (AbstractC0897o abstractC0897o : abstractC0897oArr) {
            length2 += abstractC0897o.f5066a.length;
        }
        byte[] bArr = new byte[length2];
        int length3 = 0;
        for (AbstractC0897o abstractC0897o2 : abstractC0897oArr) {
            byte[] bArr2 = abstractC0897o2.f5066a;
            System.arraycopy(bArr2, 0, bArr, length3, bArr2.length);
            length3 += bArr2.length;
        }
        return bArr;
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.p(36, z6);
        c0898p.i(128);
        AbstractC0897o[] abstractC0897oArr = this.e;
        if (abstractC0897oArr == null) {
            int i = 0;
            while (true) {
                byte[] bArr = this.f5066a;
                if (i >= bArr.length) {
                    break;
                }
                int iMin = Math.min(bArr.length - i, this.d);
                byte[] bArr2 = this.f5066a;
                c0898p.p(4, true);
                c0898p.k(iMin);
                c0898p.j(bArr2, i, iMin);
                i += iMin;
            }
        } else {
            c0898p.r(abstractC0897oArr);
        }
        c0898p.i(0);
        c0898p.i(0);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return true;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        int iE = z6 ? 4 : 3;
        AbstractC0897o[] abstractC0897oArr = this.e;
        if (abstractC0897oArr != null) {
            for (AbstractC0897o abstractC0897o : abstractC0897oArr) {
                iE += abstractC0897o.e(true);
            }
            return iE;
        }
        byte[] bArr = this.f5066a;
        int length = bArr.length;
        int i = this.d;
        int i3 = length / i;
        int iF = (C0898p.f(i, true) * i3) + iE;
        int length2 = bArr.length - (i3 * i);
        return length2 > 0 ? C0898p.f(length2, true) + iF : iF;
    }
}
