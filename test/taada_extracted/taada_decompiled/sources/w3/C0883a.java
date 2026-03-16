package w3;

/* JADX INFO: renamed from: w3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0883a extends C0.d {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0883a(Class cls, int i) {
        super(cls, 1);
        this.c = i;
    }

    @Override // C0.d
    public AbstractC0899q e(AbstractC0902u abstractC0902u) {
        switch (this.c) {
            case 1:
                return abstractC0902u.o();
            case 4:
                return abstractC0902u.p();
            case 12:
                throw new IllegalStateException("unexpected implicit constructed encoding");
            case 14:
                return abstractC0902u.q();
            case 17:
                return abstractC0902u;
            case 18:
                return abstractC0902u.r();
            default:
                return super.e(abstractC0902u);
        }
    }

    @Override // C0.d
    public AbstractC0899q f(W w5) {
        switch (this.c) {
            case 0:
                return new L(w5.f5066a);
            case 1:
                return AbstractC0884b.j(w5.f5066a);
            case 2:
                return C0885c.j(w5.f5066a);
            case 3:
                return C0887e.j(w5.f5066a, false);
            case 4:
            case 17:
            case 18:
            default:
                return super.f(w5);
            case 5:
                return new P(w5.f5066a);
            case 6:
                return new C0889g(w5.f5066a);
            case 7:
                return new S(w5.f5066a);
            case 8:
                return new T(w5.f5066a);
            case 9:
                return new C0891i(w5.f5066a);
            case 10:
                if (w5.f5066a.length == 0) {
                    return U.b;
                }
                throw new IllegalStateException("malformed NULL encoding encountered");
            case 11:
                return new V(w5.f5066a);
            case 12:
                return new C0894l(new S(w5.f5066a));
            case 13:
                return C0896n.l(w5.f5066a, false);
            case 14:
                return w5;
            case 15:
                return new Y(w5.f5066a);
            case 16:
                return r.j(w5.f5066a, false);
            case 19:
                return new b0(w5.f5066a);
            case 20:
                return new C0905x(w5.f5066a);
            case 21:
                return new c0(w5.f5066a);
            case 22:
                return new d0(w5.f5066a);
            case 23:
                return new e0(w5.f5066a);
            case 24:
                return new f0(w5.f5066a);
        }
    }
}
