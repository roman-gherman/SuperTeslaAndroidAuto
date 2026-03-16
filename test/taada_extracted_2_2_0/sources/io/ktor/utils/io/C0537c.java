package io.ktor.utils.io;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: io.ktor.utils.io.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0537c extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f3553a;
    public U b;
    public kotlin.jvm.internal.u c;
    public U d;
    public U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public io.ktor.utils.io.internal.r f3554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public io.ktor.utils.io.internal.r f3555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteBuffer f3556h;
    public U i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3559l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f3560m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ U f3561n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3562o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0537c(U u, U1.c cVar) {
        super(cVar);
        this.f3561n = u;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3560m = obj;
        this.f3562o |= Integer.MIN_VALUE;
        return this.f3561n.j(null, 0L, this);
    }
}
