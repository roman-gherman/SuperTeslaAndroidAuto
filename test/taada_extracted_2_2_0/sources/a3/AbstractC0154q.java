package a3;

/* JADX INFO: renamed from: a3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0154q extends AbstractC0153p {
    public final F b;

    public AbstractC0154q(F f6) {
        this.b = f6;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        return z6 == d() ? this : this.b.g(z6).i(b());
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return newAttributes != b() ? new H(this, newAttributes) : this;
    }

    @Override // a3.AbstractC0153p
    public final F l() {
        return this.b;
    }
}
