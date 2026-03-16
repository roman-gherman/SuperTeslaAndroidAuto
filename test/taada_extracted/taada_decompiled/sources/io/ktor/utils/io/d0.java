package io.ktor.utils.io;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements ReaderScope, WriterScope, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U f3565a;
    public final /* synthetic */ CoroutineScope b;

    public d0(CoroutineScope delegate, U u) {
        kotlin.jvm.internal.h.f(delegate, "delegate");
        this.f3565a = u;
        this.b = delegate;
    }

    @Override // io.ktor.utils.io.ReaderScope
    public final ByteReadChannel getChannel() {
        return this.f3565a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    @Override // io.ktor.utils.io.WriterScope
    /* JADX INFO: renamed from: getChannel, reason: collision with other method in class */
    public final ByteWriteChannel mo98getChannel() {
        return this.f3565a;
    }
}
