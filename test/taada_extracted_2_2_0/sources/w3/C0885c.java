package w3;

import java.io.IOException;

/* JADX INFO: renamed from: w3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0885c extends AbstractC0899q {
    public static final C0883a b = new C0883a(C0885c.class, 2);
    public static final C0885c c = new C0885c((byte) 0);
    public static final C0885c d = new C0885c((byte) -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f5049a;

    public C0885c(byte b2) {
        this.f5049a = b2;
    }

    public static C0885c j(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b2 = bArr[0];
        return b2 != -1 ? b2 != 0 ? new C0885c(b2) : c : d;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (abstractC0899q instanceof C0885c) {
            if ((this.f5049a != 0) == (((C0885c) abstractC0899q).f5049a != 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.p(1, z6);
        c0898p.k(1);
        c0898p.i(this.f5049a);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return C0898p.f(1, z6);
    }

    @Override // w3.AbstractC0899q
    public final AbstractC0899q h() {
        return this.f5049a != 0 ? d : c;
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return this.f5049a != 0 ? 1 : 0;
    }

    public final String toString() {
        return this.f5049a != 0 ? "TRUE" : "FALSE";
    }
}
