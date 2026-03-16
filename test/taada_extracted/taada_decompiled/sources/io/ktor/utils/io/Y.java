package io.ktor.utils.io;

/* JADX INFO: loaded from: classes2.dex */
public final class Y extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteReadChannel f3545a;
    public ByteWriteChannel b;
    public J1.b c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3548h;
    public int i;

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3548h = obj;
        this.i |= Integer.MIN_VALUE;
        return Z.e(null, null, 0L, this);
    }
}
