package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f3589a;
    public static final r b;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        kotlin.jvm.internal.h.e(byteBufferAllocate, "allocate(0)");
        f3589a = byteBufferAllocate;
        b = new r(0);
    }
}
