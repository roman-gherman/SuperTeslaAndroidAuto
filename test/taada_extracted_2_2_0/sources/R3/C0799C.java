package r3;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: renamed from: r3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0799C implements CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f4698a;

    public C0799C(ThreadLocal threadLocal) {
        this.f4698a = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0799C) && kotlin.jvm.internal.h.a(this.f4698a, ((C0799C) obj).f4698a);
    }

    public final int hashCode() {
        return this.f4698a.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f4698a + ')';
    }
}
