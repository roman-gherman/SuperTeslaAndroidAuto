package a3;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends AbstractC0154q {
    public final M c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(F f6, M attributes) {
        super(f6);
        kotlin.jvm.internal.h.f(attributes, "attributes");
        this.c = attributes;
    }

    @Override // a3.AbstractC0153p, a3.AbstractC0162z
    public final M b() {
        return this.c;
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        return new H(f6, this.c);
    }
}
