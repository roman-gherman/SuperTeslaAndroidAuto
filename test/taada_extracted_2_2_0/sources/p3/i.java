package p3;

import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlowCollector f4482a;
    public ReceiveChannel b;
    public ChannelIterator c;
    public boolean d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4483f;

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f4483f |= Integer.MIN_VALUE;
        return v.e(null, null, false, this);
    }
}
