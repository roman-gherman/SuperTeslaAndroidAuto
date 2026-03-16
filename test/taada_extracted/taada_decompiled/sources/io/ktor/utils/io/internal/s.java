package io.ktor.utils.io.internal;

import io.ktor.utils.io.LookAheadSuspendSession;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements LookAheadSuspendSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f3591a = new s();

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object awaitAtLeast(int i, Continuation continuation) {
        if (i < 0) {
            throw new IllegalArgumentException(B2.b.c(i, "atLeast parameter shouldn't be negative: ").toString());
        }
        if (i <= 4088) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException(B2.b.c(i, "atLeast parameter shouldn't be larger than max buffer size of 4088: ").toString());
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final void consumed(int i) {
        if (i > 0) {
            throw new IllegalStateException(B2.b.d(i, "Unable to mark ", " bytes consumed for already terminated channel"));
        }
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final ByteBuffer request(int i, int i3) {
        return null;
    }
}
