package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0550p extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3622a;
    public ByteBuffer b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3623f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0550p(U u, Continuation continuation) {
        super(continuation);
        this.e = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f3623f |= Integer.MIN_VALUE;
        return this.e.z(null, 0, this);
    }
}
