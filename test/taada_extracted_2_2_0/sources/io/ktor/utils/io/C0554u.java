package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: io.ktor.utils.io.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0554u extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3634a;
    public I1.c b;
    public ByteBuffer c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ U f3635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3636g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0554u(U u, Continuation continuation) {
        super(continuation);
        this.f3635f = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f3636g |= Integer.MIN_VALUE;
        return this.f3635f.B(0, null, null, this);
    }
}
