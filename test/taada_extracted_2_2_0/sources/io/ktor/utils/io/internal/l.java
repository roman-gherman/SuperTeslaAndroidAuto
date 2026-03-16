package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends p {
    public final k c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k initial) {
        super(initial.f3589a, initial.b);
        kotlin.jvm.internal.h.f(initial, "initial");
        this.c = initial;
    }

    @Override // io.ktor.utils.io.internal.p
    public final ByteBuffer b() {
        return this.c.d;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p e() {
        return this.c.f3588h;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p f() {
        return this.c.e;
    }

    public final String toString() {
        return "Reading";
    }
}
