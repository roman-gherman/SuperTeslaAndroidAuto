package w3;

import java.io.IOException;

/* JADX INFO: renamed from: w3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0894l extends AbstractC0899q {
    public static final C0883a b = new C0883a(C0894l.class, 12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f5063a;

    public C0894l(S s3) {
        this.f5063a = s3;
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (abstractC0899q instanceof C0894l) {
            return this.f5063a.b(((C0894l) abstractC0899q).f5063a);
        }
        return false;
    }

    @Override // w3.AbstractC0899q
    public final void c(C0898p c0898p, boolean z6) throws IOException {
        c0898p.p(7, z6);
        c0898p.m(this.f5063a.f5043a, 25, false);
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return false;
    }

    @Override // w3.AbstractC0899q
    public final int e(boolean z6) {
        return this.f5063a.e(z6);
    }

    @Override // w3.AbstractC0899q
    public final AbstractC0899q h() {
        this.f5063a.getClass();
        return this;
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        return ~g5.c.k(this.f5063a.f5043a);
    }

    @Override // w3.AbstractC0899q
    public final AbstractC0899q i() {
        this.f5063a.getClass();
        return this;
    }
}
