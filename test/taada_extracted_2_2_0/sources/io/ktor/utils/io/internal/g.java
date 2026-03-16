package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends K1.e {
    @Override // K1.e
    public final void d(Object obj) {
        h.b.recycle(((k) obj).f3589a);
    }

    @Override // K1.e
    public final Object e() {
        return new k((ByteBuffer) h.b.borrow(), 8);
    }
}
