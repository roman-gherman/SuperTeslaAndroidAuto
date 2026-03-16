package a3;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends AbstractC0154q {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ E(F f6, int i) {
        super(f6);
        this.c = i;
    }

    @Override // a3.AbstractC0153p, a3.AbstractC0162z
    public final boolean d() {
        switch (this.c) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        switch (this.c) {
            case 0:
                return new E(f6, 0);
            default:
                return new E(f6, 1);
        }
    }
}
