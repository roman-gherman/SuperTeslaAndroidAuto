package io.ktor.utils.io;

import A2.C0019a;

/* JADX INFO: loaded from: classes2.dex */
public final class V extends U {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0019a f3542o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(C0019a c0019a) {
        super(false);
        this.f3542o = c0019a;
    }

    @Override // io.ktor.utils.io.U, io.ktor.utils.io.ByteWriteChannel
    public final boolean close(Throwable th) {
        return super.close((Throwable) this.f3542o.invoke(th));
    }
}
