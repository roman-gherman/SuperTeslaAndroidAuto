package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteReadChannel f3611a;
    public OutputStream b;
    public byte[] c;
    public long d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3614h;

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.f3613g = obj;
        this.f3614h |= Integer.MIN_VALUE;
        return q.e(null, null, 0L, this);
    }
}
