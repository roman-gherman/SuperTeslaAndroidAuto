package io.ktor.utils.io.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends p {
    public final k c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k initial) {
        super(initial.f3588a, initial.b);
        kotlin.jvm.internal.h.f(initial, "initial");
        this.c = initial;
    }

    @Override // io.ktor.utils.io.internal.p
    public final boolean a() {
        return true;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p d() {
        return this.c.f3585f;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p e() {
        return this.c.f3586g;
    }

    public final String toString() {
        return "IDLE(with buffer)";
    }
}
