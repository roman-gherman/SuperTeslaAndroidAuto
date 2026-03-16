package p3;

import io.ktor.utils.io.Z;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import m3.C0672f;
import o3.EnumC0743a;
import org.jetbrains.annotations.Nullable;
import q3.AbstractC0785b;
import q3.AbstractC0786c;
import q3.AbstractC0787d;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends AbstractC0785b implements MutableStateFlow, CancellableFlow, FusibleFlow {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4508f = AtomicReferenceFieldUpdater.newUpdater(z.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;
    public int e;

    public z(Object obj) {
        this._state = obj;
    }

    @Override // q3.AbstractC0785b
    public final AbstractC0787d b() {
        return new C0758A();
    }

    @Override // q3.AbstractC0785b
    public final AbstractC0787d[] c() {
        return new C0758A[2];
    }

    /* JADX WARN: Path cross not found for [B:58:0x00f9, B:59:0x00fa], limit reached: 66 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:14:0x0039, B:28:0x007d, B:30:0x0085, B:33:0x008c, B:34:0x0090, B:36:0x0093, B:46:0x00b4, B:49:0x00c7, B:50:0x00df, B:56:0x00f3, B:53:0x00ea, B:55:0x00f0, B:38:0x0099, B:42:0x00a0, B:21:0x0053, B:24:0x005d, B:27:0x006e), top: B:63:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:14:0x0039, B:28:0x007d, B:30:0x0085, B:33:0x008c, B:34:0x0090, B:36:0x0093, B:46:0x00b4, B:49:0x00c7, B:50:0x00df, B:56:0x00f3, B:53:0x00ea, B:55:0x00f0, B:38:0x0099, B:42:0x00a0, B:21:0x0053, B:24:0x005d, B:27:0x006e), top: B:63:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:14:0x0039, B:28:0x007d, B:30:0x0085, B:33:0x008c, B:34:0x0090, B:36:0x0093, B:46:0x00b4, B:49:0x00c7, B:50:0x00df, B:56:0x00f3, B:53:0x00ea, B:55:0x00f0, B:38:0x0099, B:42:0x00a0, B:21:0x0053, B:24:0x005d, B:27:0x006e), top: B:63:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c6 -> B:28:0x007d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.z.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final boolean compareAndSet(Object obj, Object obj2) {
        E1.h hVar = AbstractC0786c.b;
        if (obj == null) {
            obj = hVar;
        }
        if (obj2 == null) {
            obj2 = hVar;
        }
        return e(obj, obj2);
    }

    public final boolean e(Object obj, Object obj2) {
        int i;
        AbstractC0787d[] abstractC0787dArr;
        E1.h hVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4508f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.h.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.h.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i3 = this.e;
            if ((i3 & 1) != 0) {
                this.e = i3 + 2;
                return true;
            }
            int i4 = i3 + 1;
            this.e = i4;
            AbstractC0787d[] abstractC0787dArr2 = this.f4651a;
            while (true) {
                C0758A[] c0758aArr = (C0758A[]) abstractC0787dArr2;
                if (c0758aArr != null) {
                    for (C0758A c0758a : c0758aArr) {
                        if (c0758a != null) {
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0758A.f4473a;
                                Object obj4 = atomicReferenceFieldUpdater2.get(c0758a);
                                if (obj4 != null && obj4 != (hVar = v.c)) {
                                    E1.h hVar2 = v.b;
                                    if (obj4 != hVar2) {
                                        while (!atomicReferenceFieldUpdater2.compareAndSet(c0758a, obj4, hVar2)) {
                                            if (atomicReferenceFieldUpdater2.get(c0758a) != obj4) {
                                                break;
                                            }
                                        }
                                        ((C0672f) obj4).resumeWith(N1.m.f1129a);
                                        break;
                                    }
                                    while (!atomicReferenceFieldUpdater2.compareAndSet(c0758a, obj4, hVar)) {
                                        if (atomicReferenceFieldUpdater2.get(c0758a) != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.e;
                    if (i == i4) {
                        this.e = i4 + 1;
                        return true;
                    }
                    abstractC0787dArr = this.f4651a;
                }
                abstractC0787dArr2 = abstractC0787dArr;
                i4 = i;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        setValue(obj);
        return N1.m.f1129a;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        return (((i < 0 || i >= 2) && i != -2) || enumC0743a != EnumC0743a.b) ? v.h(this, coroutineContext, i, enumC0743a) : this;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        return Z.p(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        E1.h hVar = AbstractC0786c.b;
        Object obj = f4508f.get(this);
        if (obj == hVar) {
            return null;
        }
        return obj;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final void setValue(Object obj) {
        if (obj == null) {
            obj = AbstractC0786c.b;
        }
        e(null, obj);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(Object obj) {
        setValue(obj);
        return true;
    }
}
