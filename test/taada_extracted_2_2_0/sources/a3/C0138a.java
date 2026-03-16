package a3;

/* JADX INFO: renamed from: a3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0138a extends AbstractC0153p {
    public final F b;
    public final F c;

    public C0138a(F delegate, F abbreviation) {
        kotlin.jvm.internal.h.f(delegate, "delegate");
        kotlin.jvm.internal.h.f(abbreviation, "abbreviation");
        this.b = delegate;
        this.c = abbreviation;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return new C0138a(this.b.i(newAttributes), this.c);
    }

    @Override // a3.AbstractC0153p
    public final F l() {
        return this.b;
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        return new C0138a(f6, this.c);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final C0138a g(boolean z6) {
        return new C0138a(this.b.g(z6), this.c.g(z6));
    }

    @Override // a3.AbstractC0153p
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final C0138a e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = this.b;
        kotlin.jvm.internal.h.f(type, "type");
        F type2 = this.c;
        kotlin.jvm.internal.h.f(type2, "type");
        return new C0138a(type, type2);
    }
}
