package o3;

import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChannelIterator f4353a;
    public /* synthetic */ Object b;
    public int c;

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return io.ktor.utils.io.internal.t.n(null, this);
    }
}
