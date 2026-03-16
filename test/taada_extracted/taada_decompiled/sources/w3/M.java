package w3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class M extends AbstractC0884b {
    public M(int i) {
        super(AbstractC0884b.l(i), AbstractC0884b.o(i));
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        byte[] bArr = this.f5046a;
        int i = bArr[0] & 255;
        int length = bArr.length;
        int i3 = length - 1;
        byte b = bArr[i3];
        byte b2 = (byte) ((255 << i) & b);
        if (b == b2) {
            c0898p.m(bArr, 3, z6);
            return;
        }
        c0898p.p(3, z6);
        c0898p.k(length);
        c0898p.j(bArr, 0, i3);
        c0898p.i(b2);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(this.f5046a.length, z6);
    }

    @Override // w3.AbstractC0884b, w3.AbstractC0899q
    public final AbstractC0899q h() {
        return this;
    }

    @Override // w3.AbstractC0884b, w3.AbstractC0899q
    public final AbstractC0899q i() {
        return this;
    }
}
