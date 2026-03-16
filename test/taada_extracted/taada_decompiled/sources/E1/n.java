package E1;

import io.ktor.utils.io.j0;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends f {
    public final List b;
    public final m c;
    public Object d;
    public final Continuation[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f296g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Object initial, Object context, List blocks) {
        super(context);
        kotlin.jvm.internal.h.f(initial, "initial");
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(blocks, "blocks");
        this.b = blocks;
        this.c = new m(this);
        this.d = initial;
        this.e = new Continuation[blocks.size()];
        this.f295f = -1;
    }

    @Override // E1.f
    public final Object a(Object obj, U1.c cVar) {
        this.f296g = 0;
        if (this.b.size() == 0) {
            return obj;
        }
        kotlin.jvm.internal.h.f(obj, "<set-?>");
        this.d = obj;
        if (this.f295f < 0) {
            return c(cVar);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // E1.f
    public final Object b() {
        return this.d;
    }

    @Override // E1.f
    public final Object c(Continuation continuation) {
        Object obj;
        int i = this.f296g;
        int size = this.b.size();
        T1.a aVar = T1.a.f1304a;
        if (i == size) {
            obj = this.d;
        } else {
            Continuation continuationJ = C5.f.J(continuation);
            int i3 = this.f295f + 1;
            this.f295f = i3;
            Continuation[] continuationArr = this.e;
            continuationArr[i3] = continuationJ;
            if (e(true)) {
                int i4 = this.f295f;
                if (i4 < 0) {
                    throw new IllegalStateException("No more continuations to resume");
                }
                this.f295f = i4 - 1;
                continuationArr[i4] = null;
                obj = this.d;
            } else {
                obj = aVar;
            }
        }
        if (obj == aVar) {
            U1.d.a(continuation);
        }
        return obj;
    }

    @Override // E1.f
    public final Object d(Object obj, Continuation continuation) {
        kotlin.jvm.internal.h.f(obj, "<set-?>");
        this.d = obj;
        return c(continuation);
    }

    public final boolean e(boolean z6) {
        int i;
        List list;
        do {
            i = this.f296g;
            list = this.b;
            if (i == list.size()) {
                if (z6) {
                    return true;
                }
                f(this.d);
                return false;
            }
            this.f296g = i + 1;
            try {
            } catch (Throwable th) {
                f(kotlin.reflect.l.n(th));
                return false;
            }
        } while (((Function3) list.get(i)).invoke(this, this.d, this.c) != T1.a.f1304a);
        return false;
    }

    public final void f(Object obj) {
        Throwable thB;
        int i = this.f295f;
        if (i < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        Continuation[] continuationArr = this.e;
        Continuation continuation = continuationArr[i];
        kotlin.jvm.internal.h.c(continuation);
        int i3 = this.f295f;
        this.f295f = i3 - 1;
        continuationArr[i3] = null;
        if (!(obj instanceof N1.g)) {
            continuation.resumeWith(obj);
            return;
        }
        Throwable thA = N1.h.a(obj);
        kotlin.jvm.internal.h.c(thA);
        try {
            Throwable cause = thA.getCause();
            if (cause != null && !kotlin.jvm.internal.h.a(thA.getCause(), cause) && (thB = j0.b(thA, cause)) != null) {
                thB.setStackTrace(thA.getStackTrace());
                thA = thB;
            }
        } catch (Throwable unused) {
        }
        continuation.resumeWith(kotlin.reflect.l.n(thA));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.c.getContext();
    }
}
