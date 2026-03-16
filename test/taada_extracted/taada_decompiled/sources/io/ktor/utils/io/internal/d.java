package io.ktor.utils.io.internal;

import io.ktor.utils.io.LookAheadSuspendSession;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements LookAheadSuspendSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f3583a;

    public d(Throwable th) {
        this.f3583a = th;
    }

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object awaitAtLeast(int i, Continuation continuation) throws Throwable {
        throw this.f3583a;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final void consumed(int i) throws Throwable {
        throw this.f3583a;
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final ByteBuffer request(int i, int i3) throws Throwable {
        throw this.f3583a;
    }
}
