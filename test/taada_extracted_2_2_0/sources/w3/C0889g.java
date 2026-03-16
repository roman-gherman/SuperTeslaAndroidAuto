package w3;

import java.util.Arrays;

/* JADX INFO: renamed from: w3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0889g extends AbstractC0899q {
    public static final C0883a b = new C0883a(C0889g.class, 6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5057a;

    public C0889g(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("GeneralizedTime string too short");
        }
        this.f5057a = bArr;
        if (!j(0) || !j(1) || !j(2) || !j(3)) {
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (!(abstractC0899q instanceof C0889g)) {
            return false;
        }
        return Arrays.equals(this.f5057a, ((C0889g) abstractC0899q).f5057a);
    }

    @Override // w3.AbstractC0899q
    public void c(C0898p c0898p, boolean z6) {
        c0898p.m(this.f5057a, 24, z6);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public int e(boolean z6) {
        return C0898p.f(this.f5057a.length, z6);
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        return new Q(this.f5057a);
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return g5.c.k(this.f5057a);
    }

    public final boolean j(int i) {
        byte b2;
        byte[] bArr = this.f5057a;
        return bArr.length > i && (b2 = bArr[i]) >= 48 && b2 <= 57;
    }
}
