package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f3589a;
    public final r b;

    public p(ByteBuffer byteBuffer, r rVar) {
        this.f3589a = byteBuffer;
        this.b = rVar;
    }

    public boolean a() {
        return this instanceof i;
    }

    public ByteBuffer b() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    public ByteBuffer c() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    public p d() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    public p e() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    public p f() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    public p g() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }
}
