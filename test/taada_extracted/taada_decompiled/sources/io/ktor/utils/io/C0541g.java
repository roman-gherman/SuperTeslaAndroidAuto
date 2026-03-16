package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: io.ktor.utils.io.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0541g extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3573a;
    public final /* synthetic */ long b;
    public final /* synthetic */ ByteBuffer c;
    public final /* synthetic */ long d;
    public final /* synthetic */ kotlin.jvm.internal.t e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0541g(long j6, long j7, ByteBuffer byteBuffer, long j8, kotlin.jvm.internal.t tVar) {
        super(1);
        this.f3573a = j6;
        this.b = j7;
        this.c = byteBuffer;
        this.d = j8;
        this.e = tVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ByteBuffer nioBuffer = (ByteBuffer) obj;
        kotlin.jvm.internal.h.f(nioBuffer, "nioBuffer");
        long jRemaining = nioBuffer.remaining();
        long j6 = this.f3573a;
        if (jRemaining > j6) {
            ByteBuffer byteBufferDuplicate = nioBuffer.duplicate();
            kotlin.jvm.internal.h.c(byteBufferDuplicate);
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) j6));
            int iLimit = byteBufferDuplicate.limit();
            ByteBuffer byteBuffer = this.c;
            long jLimit = byteBuffer.limit();
            long j7 = this.d;
            byteBufferDuplicate.limit((int) Math.min(byteBufferDuplicate.limit(), Math.min(this.b, jLimit - j7) + j6));
            this.e.f3814a = byteBufferDuplicate.remaining();
            C5.f.p(byteBufferDuplicate, byteBuffer, (int) j7);
            byteBufferDuplicate.limit(iLimit);
        }
        return N1.m.f1129a;
    }
}
