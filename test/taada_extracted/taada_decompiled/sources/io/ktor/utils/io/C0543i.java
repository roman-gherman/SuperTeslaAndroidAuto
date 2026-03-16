package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0543i extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3578a;
    public ByteBuffer b;
    public /* synthetic */ Object c;
    public final /* synthetic */ U d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0543i(U u, Continuation continuation) {
        super(continuation);
        this.d = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.v(null, this);
    }
}
