package o3;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends U1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProducerScope f4358a;
    public Function0 b;
    public /* synthetic */ Object c;
    public int d;

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        return AbstractC0740A.a(null, null, this);
    }
}
