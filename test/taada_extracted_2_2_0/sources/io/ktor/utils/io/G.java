package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f3498a;
    public io.ktor.utils.io.internal.r b;
    public U c;
    public ByteBuffer d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ U f3500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3501h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(U u, Continuation continuation) {
        super(continuation);
        this.f3500g = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3499f = obj;
        this.f3501h |= Integer.MIN_VALUE;
        return U.a0(this.f3500g, (byte) 0, this);
    }
}
