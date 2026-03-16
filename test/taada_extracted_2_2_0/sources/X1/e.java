package x1;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.q;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteReadChannel f5109a;
    public F1.a b;
    public /* synthetic */ Object c;
    public int d;

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        return q.g(null, null, null, null, this);
    }
}
