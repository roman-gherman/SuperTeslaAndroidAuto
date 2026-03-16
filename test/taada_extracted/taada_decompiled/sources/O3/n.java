package o3;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import m3.AbstractC0690y;
import m3.C0672f;
import org.jetbrains.annotations.Nullable;
import r3.AbstractC0800a;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Channel {
    public static final AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(n.class, "sendersAndCloseStatus");
    public static final AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(n.class, "receivers");
    public static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(n.class, "bufferEnd");
    public static final AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(n.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4332f = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4333g = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4334h = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "bufferEndSegment");
    public static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4335j = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "closeHandler");

    @Volatile
    @Nullable
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4336a;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;

    @Volatile
    @Nullable
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;

    @Volatile
    @Nullable
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    @Nullable
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    public n(int i3) {
        this.f4336a = i3;
        if (i3 < 0) {
            throw new IllegalArgumentException(B2.b.d(i3, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        w wVar = p.f4338a;
        this.bufferEnd = i3 != 0 ? i3 != Integer.MAX_VALUE ? i3 : LocationRequestCompat.PASSIVE_INTERVAL : 0L;
        this.completedExpandBuffersAndPauseFlag = d.get(this);
        w wVar2 = new w(0L, null, this, 3);
        this.sendSegment = wVar2;
        this.receiveSegment = wVar2;
        if (s()) {
            wVar2 = p.f4338a;
            kotlin.jvm.internal.h.d(wVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = wVar2;
        this._closeCause = p.f4350s;
    }

    public static boolean A(Object obj) {
        if (obj instanceof CancellableContinuation) {
            kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return p.a((CancellableContinuation) obj, N1.m.f1129a, null);
        }
        if (!(obj instanceof SelectInstance)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        if (obj != null) {
            throw new ClassCastException();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    public static final w a(n nVar, long j6, w wVar) {
        Object objB;
        n nVar2;
        w wVar2 = p.f4338a;
        o oVar = o.f4337a;
        loop0: while (true) {
            objB = AbstractC0800a.b(wVar, j6, oVar);
            if (!AbstractC0800a.e(objB)) {
                r3.u uVarC = AbstractC0800a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4332f;
                    r3.u uVar = (r3.u) atomicReferenceFieldUpdater.get(nVar);
                    if (uVar.c >= uVarC.c) {
                        break loop0;
                    }
                    if (!uVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(nVar, uVar, uVarC)) {
                        if (atomicReferenceFieldUpdater.get(nVar) != uVar) {
                            if (uVarC.e()) {
                                uVarC.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zE = AbstractC0800a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        if (zE) {
            nVar.isClosedForSend();
            if (wVar.c * ((long) p.b) < atomicLongFieldUpdater.get(nVar)) {
                wVar.a();
                return null;
            }
        } else {
            w wVar3 = (w) AbstractC0800a.c(objB);
            long j7 = wVar3.c;
            if (j7 <= j6) {
                return wVar3;
            }
            long j8 = ((long) p.b) * j7;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = b;
                long j9 = atomicLongFieldUpdater2.get(nVar);
                long j10 = 1152921504606846975L & j9;
                if (j10 >= j8) {
                    nVar2 = nVar;
                    break;
                }
                nVar2 = nVar;
                if (atomicLongFieldUpdater2.compareAndSet(nVar2, j9, j10 + (((long) ((int) (j9 >> 60))) << 60))) {
                    break;
                }
                nVar = nVar2;
            }
            if (j7 * ((long) p.b) < atomicLongFieldUpdater.get(nVar2)) {
                wVar3.a();
            }
        }
        return null;
    }

    public static final void b(n nVar, Object obj, C0672f c0672f) {
        c0672f.resumeWith(kotlin.reflect.l.n(nVar.m()));
    }

    public static final void c(n nVar, SelectInstance selectInstance) {
        w wVar;
        n nVar2;
        SelectInstance selectInstance2;
        int i3;
        nVar.getClass();
        w wVar2 = (w) f4333g.get(nVar);
        while (!nVar.isClosedForReceive()) {
            long andIncrement = c.getAndIncrement(nVar);
            long j6 = p.b;
            long j7 = andIncrement / j6;
            int i4 = (int) (andIncrement % j6);
            if (wVar2.c != j7) {
                w wVarJ = nVar.j(j7, wVar2);
                if (wVarJ == null) {
                    continue;
                } else {
                    wVar = wVarJ;
                    selectInstance2 = selectInstance;
                    i3 = i4;
                    nVar2 = nVar;
                }
            } else {
                wVar = wVar2;
                nVar2 = nVar;
                selectInstance2 = selectInstance;
                i3 = i4;
            }
            Object objB = nVar2.B(wVar, i3, andIncrement, selectInstance2);
            wVar2 = wVar;
            if (objB == p.f4345m) {
                Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(wVar2, i3);
                    return;
                }
                return;
            }
            if (objB != p.f4347o) {
                if (objB == p.f4346n) {
                    throw new IllegalStateException("unexpected");
                }
                wVar2.a();
                selectInstance2.selectInRegistrationPhase(objB);
                return;
            }
            if (andIncrement < nVar2.n()) {
                wVar2.a();
            }
            nVar = nVar2;
            selectInstance = selectInstance2;
        }
        selectInstance.selectInRegistrationPhase(p.f4344l);
    }

    public static final int d(n nVar, w wVar, int i3, Object obj, long j6, Object obj2, boolean z6) {
        wVar.m(i3, obj);
        if (z6) {
            return nVar.C(wVar, i3, obj, j6, obj2, z6);
        }
        Object objK = wVar.k(i3);
        if (objK == null) {
            if (nVar.e(j6)) {
                if (wVar.j(i3, null, p.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (wVar.j(i3, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof Waiter) {
            wVar.m(i3, null);
            if (nVar.z(objK, obj)) {
                wVar.n(i3, p.i);
                return 0;
            }
            E1.h hVar = p.f4343k;
            if (wVar.f4355f.getAndSet((i3 * 2) + 1, hVar) == hVar) {
                return 5;
            }
            wVar.l(i3, true);
            return 5;
        }
        return nVar.C(wVar, i3, obj, j6, obj2, z6);
    }

    public static void p(n nVar) {
        nVar.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        if ((atomicLongFieldUpdater.addAndGet(nVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(nVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object v(o3.n r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof o3.l
            if (r0 == 0) goto L14
            r0 = r14
            o3.l r0 = (o3.l) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            o3.l r0 = new o3.l
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f4330a
            T1.a r0 = T1.a.f1304a
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.reflect.l.e0(r14)
            o3.v r14 = (o3.v) r14
            java.lang.Object r13 = r14.f4354a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            kotlin.reflect.l.e0(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = o3.n.f4333g
            java.lang.Object r14 = r14.get(r13)
            o3.w r14 = (o3.w) r14
        L40:
            boolean r1 = r13.isClosedForReceive()
            if (r1 == 0) goto L50
            java.lang.Throwable r13 = r13.k()
            o3.t r14 = new o3.t
            r14.<init>(r13)
            return r14
        L50:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = o3.n.c
            long r4 = r1.getAndIncrement(r13)
            int r1 = o3.p.b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L6d
            o3.w r1 = r13.j(r9, r14)
            if (r1 != 0) goto L6b
            goto L40
        L6b:
            r8 = r1
            goto L6e
        L6d:
            r8 = r14
        L6e:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.B(r8, r9, r10, r12)
            r1 = r7
            E1.h r14 = o3.p.f4345m
            if (r13 == r14) goto La0
            E1.h r14 = o3.p.f4347o
            if (r13 != r14) goto L8d
            long r13 = r1.n()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L8a
            r8.a()
        L8a:
            r13 = r1
            r14 = r8
            goto L40
        L8d:
            E1.h r14 = o3.p.f4346n
            if (r13 != r14) goto L9c
            r6.c = r2
            r2 = r8
            java.lang.Object r13 = r1.w(r2, r3, r4, r6)
            if (r13 != r0) goto L9b
            return r0
        L9b:
            return r13
        L9c:
            r8.a()
            return r13
        La0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.v(o3.n, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object B(w wVar, int i3, long j6, Object obj) {
        Object objK = wVar.k(i3);
        AtomicReferenceArray atomicReferenceArray = wVar.f4355f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (objK == null) {
            if (j6 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return p.f4346n;
                }
                if (wVar.j(i3, objK, obj)) {
                    i();
                    return p.f4345m;
                }
            }
        } else if (objK == p.d && wVar.j(i3, objK, p.i)) {
            i();
            Object obj2 = atomicReferenceArray.get(i3 * 2);
            wVar.m(i3, null);
            return obj2;
        }
        while (true) {
            Object objK2 = wVar.k(i3);
            if (objK2 == null || objK2 == p.e) {
                if (j6 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (wVar.j(i3, objK2, p.f4341h)) {
                        i();
                        return p.f4347o;
                    }
                } else {
                    if (obj == null) {
                        return p.f4346n;
                    }
                    if (wVar.j(i3, objK2, obj)) {
                        i();
                        return p.f4345m;
                    }
                }
            } else {
                if (objK2 != p.d) {
                    E1.h hVar = p.f4342j;
                    if (objK2 != hVar && objK2 != p.f4341h) {
                        if (objK2 == p.f4344l) {
                            i();
                            return p.f4347o;
                        }
                        if (objK2 != p.f4340g && wVar.j(i3, objK2, p.f4339f)) {
                            boolean z6 = objK2 instanceof E;
                            if (z6) {
                                objK2 = ((E) objK2).f4319a;
                            }
                            if (A(objK2)) {
                                wVar.n(i3, p.i);
                                i();
                                Object obj3 = atomicReferenceArray.get(i3 * 2);
                                wVar.m(i3, null);
                                return obj3;
                            }
                            wVar.n(i3, hVar);
                            wVar.h();
                            if (z6) {
                                i();
                            }
                            return p.f4347o;
                        }
                    }
                    return p.f4347o;
                }
                if (wVar.j(i3, objK2, p.i)) {
                    i();
                    Object obj4 = atomicReferenceArray.get(i3 * 2);
                    wVar.m(i3, null);
                    return obj4;
                }
            }
        }
    }

    public final int C(w wVar, int i3, Object obj, long j6, Object obj2, boolean z6) {
        while (true) {
            Object objK = wVar.k(i3);
            if (objK == null) {
                if (!e(j6) || z6) {
                    if (z6) {
                        if (wVar.j(i3, null, p.f4342j)) {
                            wVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (wVar.j(i3, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (wVar.j(i3, null, p.d)) {
                    break;
                }
            } else {
                if (objK != p.e) {
                    E1.h hVar = p.f4343k;
                    if (objK == hVar) {
                        wVar.m(i3, null);
                        return 5;
                    }
                    if (objK == p.f4341h) {
                        wVar.m(i3, null);
                        return 5;
                    }
                    if (objK == p.f4344l) {
                        wVar.m(i3, null);
                        isClosedForSend();
                        return 4;
                    }
                    wVar.m(i3, null);
                    if (objK instanceof E) {
                        objK = ((E) objK).f4319a;
                    }
                    if (z(objK, obj)) {
                        wVar.n(i3, p.i);
                        return 0;
                    }
                    if (wVar.f4355f.getAndSet((i3 * 2) + 1, hVar) != hVar) {
                        wVar.l(i3, true);
                    }
                    return 5;
                }
                if (wVar.j(i3, objK, p.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void D(long j6) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        n nVar = this;
        if (nVar.s()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = d;
            if (atomicLongFieldUpdater.get(nVar) > j6) {
                break;
            } else {
                nVar = this;
            }
        }
        int i3 = p.c;
        int i4 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
            if (i4 < i3) {
                long j7 = atomicLongFieldUpdater.get(nVar);
                if (j7 == (4611686018427387903L & atomicLongFieldUpdater2.get(nVar)) && j7 == atomicLongFieldUpdater.get(nVar)) {
                    return;
                } else {
                    i4++;
                }
            } else {
                while (true) {
                    long j8 = atomicLongFieldUpdater2.get(nVar);
                    if (atomicLongFieldUpdater2.compareAndSet(nVar, j8, (j8 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        nVar = this;
                    }
                }
                while (true) {
                    long j9 = atomicLongFieldUpdater.get(nVar);
                    long j10 = atomicLongFieldUpdater2.get(nVar);
                    long j11 = j10 & 4611686018427387903L;
                    boolean z6 = (j10 & 4611686018427387904L) != 0;
                    if (j9 == j11 && j9 == atomicLongFieldUpdater.get(nVar)) {
                        break;
                    }
                    if (!z6) {
                        atomicLongFieldUpdater2.compareAndSet(this, j10, 4611686018427387904L + j11);
                    }
                    nVar = this;
                }
                while (true) {
                    long j12 = atomicLongFieldUpdater2.get(nVar);
                    if (atomicLongFieldUpdater2.compareAndSet(nVar, j12, j12 & 4611686018427387903L)) {
                        return;
                    } else {
                        nVar = this;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        f(new CancellationException("Channel was cancelled"), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        return f(th, false);
    }

    public final boolean e(long j6) {
        return j6 < d.get(this) || j6 < c.get(this) + ((long) this.f4336a);
    }

    public final boolean f(Throwable th, boolean z6) {
        n nVar;
        boolean z7;
        long j6;
        long j7;
        long j8;
        Object obj;
        long j9;
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (!z6) {
            nVar = this;
            break;
        }
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                nVar = this;
                break;
            }
            w wVar = p.f4338a;
            nVar = this;
        } while (!atomicLongFieldUpdater.compareAndSet(nVar, j10, (j10 & 1152921504606846975L) + (((long) 1) << 60)));
        E1.h hVar = p.f4350s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, hVar, th)) {
                z7 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != hVar) {
                z7 = false;
                break;
            }
        }
        if (z6) {
            do {
                j9 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(nVar, j9, (((long) 3) << 60) + (j9 & 1152921504606846975L)));
        } else {
            do {
                j6 = atomicLongFieldUpdater.get(this);
                int i3 = (int) (j6 >> 60);
                if (i3 == 0) {
                    j7 = j6 & 1152921504606846975L;
                    j8 = 2;
                } else {
                    if (i3 != 1) {
                        break;
                    }
                    j7 = j6 & 1152921504606846975L;
                    j8 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(nVar, j6, (j8 << 60) + j7));
        }
        isClosedForSend();
        if (z7) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4335j;
                obj = atomicReferenceFieldUpdater2.get(this);
                E1.h hVar2 = obj == null ? p.q : p.f4349r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, hVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                kotlin.jvm.internal.z.d(1, obj);
                ((Function1) obj).invoke(k());
                return z7;
            }
        }
        return z7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        r1 = (o3.w) ((r3.AbstractC0803d) r3.AbstractC0803d.b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o3.w g(long r13) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.g(long):o3.w");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        C0745c c0745c = C0745c.f4322a;
        kotlin.jvm.internal.z.d(3, c0745c);
        C0746d c0746d = C0746d.f4323a;
        kotlin.jvm.internal.z.d(3, c0746d);
        return new B2.d(this, c0745c, c0746d, (k) null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveCatching() {
        C0747e c0747e = C0747e.f4324a;
        kotlin.jvm.internal.z.d(3, c0747e);
        f fVar = f.f4325a;
        kotlin.jvm.internal.z.d(3, fVar);
        return new B2.d(this, c0747e, fVar, (k) null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveOrNull() {
        g gVar = g.f4326a;
        kotlin.jvm.internal.z.d(3, gVar);
        h hVar = h.f4327a;
        kotlin.jvm.internal.z.d(3, hVar);
        return new B2.d(this, gVar, hVar, (k) null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        i iVar = i.f4328a;
        kotlin.jvm.internal.z.d(3, iVar);
        j jVar = j.f4329a;
        kotlin.jvm.internal.z.d(3, jVar);
        return new C0.t(this, iVar, jVar, (v3.f) null);
    }

    public final void h(long j6) {
        w wVar = (w) f4333g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j7 = atomicLongFieldUpdater.get(this);
            if (j6 < Math.max(((long) this.f4336a) + j7, d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j7, 1 + j7)) {
                long j8 = p.b;
                long j9 = j7 / j8;
                int i3 = (int) (j7 % j8);
                if (wVar.c != j9) {
                    w wVarJ = j(j9, wVar);
                    if (wVarJ != null) {
                        wVar = wVarJ;
                    }
                }
                w wVar2 = wVar;
                if (B(wVar2, i3, j7, null) != p.f4347o || j7 < n()) {
                    wVar2.a();
                }
                wVar = wVar2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        p(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.i():void");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f4335j;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            E1.h hVar = p.q;
            if (obj != hVar) {
                if (obj == p.f4349r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            E1.h hVar2 = p.f4349r;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, hVar, hVar2)) {
                if (atomicReferenceFieldUpdater.get(this) != hVar) {
                    break;
                }
            }
            function1.invoke(k());
            return;
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return q(b.get(this), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return q(b.get(this), false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        if (isClosedForReceive() || o()) {
            return false;
        }
        return !isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        return new C0744b(this);
    }

    public final w j(long j6, w wVar) {
        Object objB;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j7;
        w wVar2 = p.f4338a;
        o oVar = o.f4337a;
        loop0: while (true) {
            objB = AbstractC0800a.b(wVar, j6, oVar);
            if (!AbstractC0800a.e(objB)) {
                r3.u uVarC = AbstractC0800a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4333g;
                    r3.u uVar = (r3.u) atomicReferenceFieldUpdater.get(this);
                    if (uVar.c >= uVarC.c) {
                        break loop0;
                    }
                    if (!uVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, uVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != uVar) {
                            if (uVarC.e()) {
                                uVarC.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (AbstractC0800a.e(objB)) {
            isClosedForSend();
            if (wVar.c * ((long) p.b) < n()) {
                wVar.a();
                return null;
            }
        } else {
            w wVar3 = (w) AbstractC0800a.c(objB);
            boolean zS = s();
            long j8 = wVar3.c;
            if (!zS && j6 <= d.get(this) / ((long) p.b)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4334h;
                    r3.u uVar2 = (r3.u) atomicReferenceFieldUpdater2.get(this);
                    if (uVar2.c >= j8 || !wVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, uVar2, wVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != uVar2) {
                            if (wVar3.e()) {
                                wVar3.d();
                            }
                        }
                    }
                    if (uVar2.e()) {
                        uVar2.d();
                    }
                }
            }
            if (j8 <= j6) {
                return wVar3;
            }
            long j9 = j8 * ((long) p.b);
            do {
                atomicLongFieldUpdater = c;
                j7 = atomicLongFieldUpdater.get(this);
                if (j7 >= j9) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j7, j9));
            if (j8 * ((long) p.b) < n()) {
                wVar3.a();
            }
        }
        return null;
    }

    public final Throwable k() {
        return (Throwable) i.get(this);
    }

    public final Throwable l() {
        Throwable thK = k();
        return thK == null ? new x("Channel was closed") : thK;
    }

    public final Throwable m() {
        Throwable thK = k();
        return thK == null ? new com.google.android.gms.tasks.a("Channel was closed", 6) : thK;
    }

    public final long n() {
        return b.get(this) & 1152921504606846975L;
    }

    public final boolean o() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4333g;
            w wVarJ = (w) atomicReferenceFieldUpdater.get(this);
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j6 = atomicLongFieldUpdater.get(this);
            if (n() <= j6) {
                return false;
            }
            int i3 = p.b;
            long j7 = j6 / ((long) i3);
            if (wVarJ.c == j7 || (wVarJ = j(j7, wVarJ)) != null) {
                wVarJ.a();
                int i4 = (int) (j6 % ((long) i3));
                while (true) {
                    Object objK = wVarJ.k(i4);
                    if (objK == null || objK == p.e) {
                        if (wVarJ.j(i4, objK, p.f4341h)) {
                            i();
                            break;
                        }
                    } else {
                        if (objK == p.d) {
                            return true;
                        }
                        if (objK != p.f4342j && objK != p.f4344l && objK != p.i && objK != p.f4341h) {
                            if (objK == p.f4340g) {
                                return true;
                            }
                            if (objK != p.f4339f && j6 == atomicLongFieldUpdater.get(this)) {
                                return true;
                            }
                        }
                    }
                }
                c.compareAndSet(this, j6, j6 + 1);
            } else if (((w) atomicReferenceFieldUpdater.get(this)).c < j7) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(Object obj) throws Throwable {
        Object objMo106trySendJP2dKIU = mo106trySendJP2dKIU(obj);
        if (!(objMo106trySendJP2dKIU instanceof u)) {
            return true;
        }
        Throwable thA = v.a(objMo106trySendJP2dKIU);
        if (thA == null) {
            return false;
        }
        int i3 = r3.v.f4720a;
        throw thA;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object poll() throws Throwable {
        Throwable th;
        Object objMo105tryReceivePtdJZtk = mo105tryReceivePtdJZtk();
        boolean z6 = objMo105tryReceivePtdJZtk instanceof u;
        if (z6) {
            Throwable thA = v.a(objMo105tryReceivePtdJZtk);
            if (thA == null) {
                return null;
            }
            int i3 = r3.v.f4720a;
            throw thA;
        }
        if (!z6) {
            return objMo105tryReceivePtdJZtk;
        }
        if ((objMo105tryReceivePtdJZtk instanceof t) && (th = ((t) objMo105tryReceivePtdJZtk).f4353a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + objMo105tryReceivePtdJZtk).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
    
        r11 = (o3.w) ((r3.AbstractC0803d) r3.AbstractC0803d.b.get(r11));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(long r11, boolean r13) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.q(long, boolean):boolean");
    }

    public boolean r() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation) throws Throwable {
        w wVar;
        Throwable th;
        w wVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4333g;
        w wVar3 = (w) atomicReferenceFieldUpdater.get(this);
        while (!isClosedForReceive()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j6 = p.b;
            long j7 = andIncrement / j6;
            int i3 = (int) (andIncrement % j6);
            if (wVar3.c != j7) {
                w wVarJ = j(j7, wVar3);
                if (wVarJ == null) {
                    continue;
                } else {
                    wVar = wVarJ;
                }
            } else {
                wVar = wVar3;
            }
            Object objB = B(wVar, i3, andIncrement, null);
            E1.h hVar = p.f4345m;
            if (objB == hVar) {
                throw new IllegalStateException("unexpected");
            }
            E1.h hVar2 = p.f4347o;
            if (objB == hVar2) {
                if (andIncrement < n()) {
                    wVar.a();
                }
                wVar3 = wVar;
            } else {
                if (objB != p.f4346n) {
                    wVar.a();
                    return objB;
                }
                C0672f c0672fF = AbstractC0690y.f(C5.f.J(continuation));
                n nVar = this;
                try {
                    Object objB2 = nVar.B(wVar, i3, andIncrement, c0672fF);
                    if (objB2 == hVar) {
                        c0672fF.invokeOnCancellation(wVar, i3);
                    } else {
                        if (objB2 == hVar2) {
                            if (andIncrement < n()) {
                                wVar.a();
                            }
                            w wVar4 = (w) atomicReferenceFieldUpdater.get(this);
                            while (true) {
                                if (isClosedForReceive()) {
                                    c0672fF.resumeWith(kotlin.reflect.l.n(l()));
                                    break;
                                }
                                C0672f c0672f = c0672fF;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j8 = p.b;
                                    long j9 = andIncrement2 / j8;
                                    int i4 = (int) (andIncrement2 % j8);
                                    if (wVar4.c != j9) {
                                        try {
                                            w wVarJ2 = j(j9, wVar4);
                                            if (wVarJ2 == null) {
                                                c0672fF = c0672f;
                                            } else {
                                                wVar2 = wVarJ2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            c0672fF = c0672f;
                                            c0672fF.s();
                                            throw th;
                                        }
                                    } else {
                                        wVar2 = wVar4;
                                    }
                                    objB2 = nVar.B(wVar2, i4, andIncrement2, c0672f);
                                    w wVar5 = wVar2;
                                    c0672fF = c0672f;
                                    if (objB2 == p.f4345m) {
                                        c0672fF.invokeOnCancellation(wVar5, i4);
                                        break;
                                    }
                                    if (objB2 == p.f4347o) {
                                        if (andIncrement2 < n()) {
                                            wVar5.a();
                                        }
                                        nVar = this;
                                        wVar4 = wVar5;
                                    } else {
                                        if (objB2 == p.f4346n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        wVar5.a();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    c0672fF = c0672f;
                                    th = th;
                                    c0672fF.s();
                                    throw th;
                                }
                            }
                        } else {
                            wVar.a();
                        }
                        c0672fF.resume(objB2, null);
                    }
                    return c0672fF.m();
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thL = l();
        int i5 = r3.v.f4720a;
        throw thL;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo104receiveCatchingJP2dKIU(Continuation continuation) {
        return v(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receiveOrNull(Continuation continuation) {
        return k1.j.m(this, continuation);
    }

    public final boolean s() {
        long j6 = d.get(this);
        return j6 == 0 || j6 == LocationRequestCompat.PASSIVE_INTERVAL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0178, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        b(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0164 A[RETURN] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object send(java.lang.Object r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(long r5, o3.w r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            r3.d r0 = r7.b()
            o3.w r0 = (o3.w) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            r3.d r5 = r7.b()
            o3.w r5 = (o3.w) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = o3.n.f4334h
            java.lang.Object r6 = r5.get(r4)
            r3.u r6 = (r3.u) r6
            long r0 = r6.c
            long r2 = r7.c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.t(long, o3.w):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cc, code lost:
    
        r16 = r7;
        r3 = (o3.w) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d5, code lost:
    
        if (r3 != null) goto L97;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.toString():java.lang.String");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo105tryReceivePtdJZtk() {
        w wVarJ;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        long j6 = atomicLongFieldUpdater.get(this);
        long j7 = b.get(this);
        if (q(j7, true)) {
            return new t(k());
        }
        long j8 = j7 & 1152921504606846975L;
        u uVar = v.b;
        if (j6 >= j8) {
            return uVar;
        }
        Object obj = p.f4343k;
        w wVar = (w) f4333g.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            int i3 = p.b;
            long j9 = andIncrement / ((long) i3);
            int i4 = (int) (andIncrement % ((long) i3));
            if (wVar.c != j9) {
                wVarJ = j(j9, wVar);
                if (wVarJ == null) {
                    continue;
                }
            } else {
                wVarJ = wVar;
            }
            Object objB = B(wVarJ, i4, andIncrement, obj);
            if (objB == p.f4345m) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(wVarJ, i4);
                }
                D(andIncrement);
                wVarJ.h();
                return uVar;
            }
            if (objB != p.f4347o) {
                if (objB == p.f4346n) {
                    throw new IllegalStateException("unexpected");
                }
                wVarJ.a();
                return objB;
            }
            if (andIncrement < n()) {
                wVarJ.a();
            }
            wVar = wVarJ;
        }
        return new t(k());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00be A[SYNTHETIC] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo106trySendJP2dKIU(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = o3.n.b
            long r1 = r8.get(r0)
            r9 = 0
            boolean r3 = r0.q(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L17
            r1 = r9
            goto L1d
        L17:
            long r1 = r1 & r11
            boolean r1 = r0.e(r1)
            r1 = r1 ^ r10
        L1d:
            o3.u r13 = o3.v.b
            if (r1 == 0) goto L22
            return r13
        L22:
            E1.h r6 = o3.p.f4342j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = o3.n.f4332f
            java.lang.Object r1 = r1.get(r0)
            o3.w r1 = (o3.w) r1
        L2c:
            long r2 = r8.getAndIncrement(r0)
            long r4 = r2 & r11
            boolean r7 = r0.q(r2, r9)
            int r2 = o3.p.b
            long r14 = (long) r2
            long r14 = r4 / r14
            long r2 = (long) r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r11 = r1.c
            int r3 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r3 == 0) goto L5e
            o3.w r3 = a(r0, r14, r1)
            if (r3 != 0) goto L5d
            if (r7 == 0) goto L57
            java.lang.Throwable r1 = r0.m()
            o3.t r2 = new o3.t
            r2.<init>(r1)
            return r2
        L57:
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2c
        L5d:
            r1 = r3
        L5e:
            r3 = r17
            int r11 = d(r0, r1, r2, r3, r4, r6, r7)
            N1.m r3 = N1.m.f1129a
            if (r11 == 0) goto Lbe
            if (r11 == r10) goto Lbd
            r3 = 2
            if (r11 == r3) goto L9a
            r2 = 3
            if (r11 == r2) goto L92
            r2 = 4
            if (r11 == r2) goto L7b
            r2 = 5
            if (r11 == r2) goto L77
            goto L57
        L77:
            r1.a()
            goto L57
        L7b:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = o3.n.c
            long r2 = r2.get(r0)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L88
            r1.a()
        L88:
            java.lang.Throwable r1 = r0.m()
            o3.t r2 = new o3.t
            r2.<init>(r1)
            return r2
        L92:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L9a:
            if (r7 == 0) goto La9
            r1.h()
            java.lang.Throwable r1 = r0.m()
            o3.t r2 = new o3.t
            r2.<init>(r1)
            return r2
        La9:
            boolean r3 = r6 instanceof kotlinx.coroutines.Waiter
            if (r3 == 0) goto Lb0
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6
            goto Lb1
        Lb0:
            r6 = 0
        Lb1:
            if (r6 == 0) goto Lb9
            int r3 = o3.p.b
            int r2 = r2 + r3
            r6.invokeOnCancellation(r1, r2)
        Lb9:
            r1.h()
            return r13
        Lbd:
            return r3
        Lbe:
            r1.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.mo106trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    public final Object u(Object obj, Continuation continuation) {
        C0672f c0672f = new C0672f(1, C5.f.J(continuation));
        c0672f.initCancellability();
        c0672f.resumeWith(kotlin.reflect.l.n(m()));
        Object objM = c0672f.m();
        return objM == T1.a.f1304a ? objM : N1.m.f1129a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(o3.w r15, int r16, long r17, U1.c r19) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.n.w(o3.w, int, long, U1.c):java.lang.Object");
    }

    public void x(SelectInstance selectInstance, Object obj) {
        w wVar;
        w wVar2 = (w) f4332f.get(this);
        while (true) {
            long andIncrement = b.getAndIncrement(this);
            long j6 = andIncrement & 1152921504606846975L;
            boolean zQ = q(andIncrement, false);
            int i3 = p.b;
            long j7 = i3;
            long j8 = j6 / j7;
            int i4 = (int) (j6 % j7);
            if (wVar2.c != j8) {
                w wVarA = a(this, j8, wVar2);
                if (wVarA != null) {
                    wVar = wVarA;
                } else if (zQ) {
                    selectInstance.selectInRegistrationPhase(p.f4344l);
                    return;
                }
            } else {
                wVar = wVar2;
            }
            SelectInstance selectInstance2 = selectInstance;
            Object obj2 = obj;
            int iD = d(this, wVar, i4, obj2, j6, selectInstance2, zQ);
            wVar2 = wVar;
            N1.m mVar = N1.m.f1129a;
            if (iD == 0) {
                wVar2.a();
                selectInstance2.selectInRegistrationPhase(mVar);
                return;
            }
            if (iD == 1) {
                selectInstance2.selectInRegistrationPhase(mVar);
                return;
            }
            if (iD == 2) {
                if (zQ) {
                    wVar2.h();
                    selectInstance2.selectInRegistrationPhase(p.f4344l);
                    return;
                } else {
                    Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                    if (waiter != null) {
                        waiter.invokeOnCancellation(wVar2, i4 + i3);
                        return;
                    }
                    return;
                }
            }
            if (iD == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iD == 4) {
                if (j6 < c.get(this)) {
                    wVar2.a();
                }
                selectInstance2.selectInRegistrationPhase(p.f4344l);
                return;
            } else {
                if (iD == 5) {
                    wVar2.a();
                }
                obj = obj2;
                selectInstance = selectInstance2;
            }
        }
    }

    public final void y(Waiter waiter, boolean z6) {
        if (waiter instanceof CancellableContinuation) {
            ((Continuation) waiter).resumeWith(kotlin.reflect.l.n(z6 ? l() : m()));
            return;
        }
        if (waiter instanceof C0742C) {
            ((C0742C) waiter).f4317a.resumeWith(new v(new t(k())));
            return;
        }
        if (!(waiter instanceof C0744b)) {
            if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).trySelect(this, p.f4344l);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
            }
        }
        C0744b c0744b = (C0744b) waiter;
        C0672f c0672f = c0744b.b;
        kotlin.jvm.internal.h.c(c0672f);
        c0744b.b = null;
        c0744b.f4321a = p.f4344l;
        Throwable thK = c0744b.c.k();
        if (thK == null) {
            c0672f.resumeWith(Boolean.FALSE);
        } else {
            c0672f.resumeWith(kotlin.reflect.l.n(thK));
        }
    }

    public final boolean z(Object obj, Object obj2) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, obj2);
        }
        if (obj instanceof C0742C) {
            kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            return p.a(((C0742C) obj).f4317a, new v(obj2), null);
        }
        if (!(obj instanceof C0744b)) {
            if (obj instanceof CancellableContinuation) {
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                return p.a((CancellableContinuation) obj, obj2, null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        C0744b c0744b = (C0744b) obj;
        C0672f c0672f = c0744b.b;
        kotlin.jvm.internal.h.c(c0672f);
        c0744b.b = null;
        c0744b.f4321a = obj2;
        return p.a(c0672f, Boolean.TRUE, null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        f(cancellationException, true);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return f(th, true);
    }
}
