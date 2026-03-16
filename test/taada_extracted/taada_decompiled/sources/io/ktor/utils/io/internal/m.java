package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends p {
    public final k c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k initial) {
        super(initial.f3588a, initial.b);
        kotlin.jvm.internal.h.f(initial, "initial");
        this.c = initial;
    }

    @Override // io.ktor.utils.io.internal.p
    public final ByteBuffer b() {
        return this.c.d;
    }

    @Override // io.ktor.utils.io.internal.p
    public final ByteBuffer c() {
        return this.c.c;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p f() {
        return this.c.f3586g;
    }

    @Override // io.ktor.utils.io.internal.p
    public final p g() {
        return this.c.f3585f;
    }

    public final String toString() {
        return "Reading+Writing";
    }
}
