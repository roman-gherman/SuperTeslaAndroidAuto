package r3;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f4699a;
    public final Object[] b;
    public final ThreadContextElement[] c;
    public int d;

    public E(int i, CoroutineContext coroutineContext) {
        this.f4699a = coroutineContext;
        this.b = new Object[i];
        this.c = new ThreadContextElement[i];
    }
}
