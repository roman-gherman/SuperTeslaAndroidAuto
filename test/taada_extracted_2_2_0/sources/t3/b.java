package t3;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.Volatile;
import m3.AbstractC0690y;
import net.bytebuddy.asm.Advice;
import r3.s;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f4825h = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4826j = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final E1.h f4827k = new E1.h("NOT_IN_STACK", 9);

    @Volatile
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4828a;
    public final int b;
    public final long c;

    @Volatile
    private volatile long controlState;
    public final String d;
    public final e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f4829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f4830g;

    @Volatile
    private volatile long parkedWorkersStack;

    public b(int i3, int i4, long j6, String str) {
        this.f4828a = i3;
        this.b = i4;
        this.c = j6;
        this.d = str;
        if (i3 < 1) {
            throw new IllegalArgumentException(B2.b.d(i3, "Core pool size ", " should be at least 1").toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.n("Max pool size ", i4, " should be greater than or equals to core pool size ", i3).toString());
        }
        if (i4 > 2097150) {
            throw new IllegalArgumentException(B2.b.d(i4, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j6 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j6 + " must be positive").toString());
        }
        this.e = new e();
        this.f4829f = new e();
        this.f4830g = new s((i3 + 1) * 2);
        this.controlState = ((long) i3) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void c(b bVar, Runnable runnable, int i3) {
        bVar.b(runnable, k.f4838g, (i3 & 4) == 0);
    }

    public final int a() {
        synchronized (this.f4830g) {
            try {
                if (f4826j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = i;
                long j6 = atomicLongFieldUpdater.get(this);
                int i3 = (int) (j6 & 2097151);
                int i4 = i3 - ((int) ((j6 & 4398044413952L) >> 21));
                if (i4 < 0) {
                    i4 = 0;
                }
                if (i4 >= this.f4828a) {
                    return 0;
                }
                if (i3 >= this.b) {
                    return 0;
                }
                int i5 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i5 <= 0 || this.f4830g.b(i5) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                C0828a c0828a = new C0828a(this, i5);
                this.f4830g.c(i5, c0828a);
                if (i5 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i6 = i4 + 1;
                c0828a.start();
                return i6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, i iVar, boolean z6) {
        h jVar;
        int i3;
        k.f4837f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            jVar = (h) runnable;
            jVar.f4834a = jNanoTime;
            jVar.b = iVar;
        } else {
            jVar = new j(runnable, jNanoTime, iVar);
        }
        boolean z7 = false;
        boolean z8 = jVar.b.f4835a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        long jAddAndGet = z8 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        C0828a c0828a = threadCurrentThread instanceof C0828a ? (C0828a) threadCurrentThread : null;
        if (c0828a == null || !kotlin.jvm.internal.h.a(c0828a.f4824h, this)) {
            c0828a = null;
        }
        if (c0828a != null && (i3 = c0828a.c) != 5 && (jVar.b.f4835a != 0 || i3 != 2)) {
            c0828a.f4823g = true;
            m mVar = c0828a.f4821a;
            if (z6) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                h hVar = (h) m.b.getAndSet(mVar, jVar);
                jVar = hVar == null ? null : mVar.a(hVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.b.f4835a == 1 ? this.f4829f.a(jVar) : this.e.a(jVar))) {
                throw new RejectedExecutionException(B2.b.h(new StringBuilder(), this.d, " was terminated"));
            }
        }
        if (z6 && c0828a != null) {
            z7 = true;
        }
        if (z8) {
            if (z7 || f() || e(jAddAndGet)) {
                return;
            }
            f();
            return;
        }
        if (z7 || f() || e(atomicLongFieldUpdater.get(this))) {
            return;
        }
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = t3.b.f4826j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof t3.C0828a
            r3 = 0
            if (r1 == 0) goto L17
            t3.a r0 = (t3.C0828a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            t3.b r1 = r0.f4824h
            boolean r1 = kotlin.jvm.internal.h.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            r3.s r1 = r8.f4830g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = t3.b.i     // Catch: java.lang.Throwable -> Lc0
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc0
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L76
            r1 = r2
        L36:
            r3.s r5 = r8.f4830g
            java.lang.Object r5 = r5.b(r1)
            kotlin.jvm.internal.h.c(r5)
            t3.a r5 = (t3.C0828a) r5
            if (r5 == r0) goto L71
        L43:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L52
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L52:
            t3.m r5 = r5.f4821a
            t3.e r6 = r8.f4829f
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = t3.m.b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            t3.h r7 = (t3.h) r7
            if (r7 == 0) goto L66
            r6.a(r7)
        L66:
            t3.h r7 = r5.b()
            if (r7 != 0) goto L6d
            goto L71
        L6d:
            r6.a(r7)
            goto L66
        L71:
            if (r1 == r4) goto L76
            int r1 = r1 + 1
            goto L36
        L76:
            t3.e r1 = r8.f4829f
            r1.b()
            t3.e r1 = r8.e
            r1.b()
        L80:
            if (r0 == 0) goto L88
            t3.h r1 = r0.a(r2)
            if (r1 != 0) goto Laf
        L88:
            t3.e r1 = r8.e
            java.lang.Object r1 = r1.d()
            t3.h r1 = (t3.h) r1
            if (r1 != 0) goto Laf
            t3.e r1 = r8.f4829f
            java.lang.Object r1 = r1.d()
            t3.h r1 = (t3.h) r1
            if (r1 != 0) goto Laf
            if (r0 == 0) goto La2
            r1 = 5
            r0.h(r1)
        La2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = t3.b.f4825h
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = t3.b.i
            r0.set(r8, r1)
            return
        Laf:
            r1.run()     // Catch: java.lang.Throwable -> Lb3
            goto L80
        Lb3:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L80
        Lc0:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.b.close():void");
    }

    public final void d(C0828a c0828a, int i3, int i4) {
        while (true) {
            long j6 = f4825h.get(this);
            int i5 = (int) (2097151 & j6);
            long j7 = (2097152 + j6) & (-2097152);
            if (i5 == i3) {
                if (i4 == 0) {
                    Object objC = c0828a.c();
                    while (true) {
                        if (objC == f4827k) {
                            i5 = -1;
                            break;
                        }
                        if (objC == null) {
                            i5 = 0;
                            break;
                        }
                        C0828a c0828a2 = (C0828a) objC;
                        int iB = c0828a2.b();
                        if (iB != 0) {
                            i5 = iB;
                            break;
                        }
                        objC = c0828a2.c();
                    }
                } else {
                    i5 = i4;
                }
            }
            if (i5 >= 0) {
                if (f4825h.compareAndSet(this, j6, ((long) i5) | j7)) {
                    return;
                }
            }
        }
    }

    public final boolean e(long j6) {
        int i3 = ((int) (2097151 & j6)) - ((int) ((j6 & 4398044413952L) >> 21));
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.f4828a;
        if (i3 < i4) {
            int iA = a();
            if (iA == 1 && i4 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(this, runnable, 6);
    }

    public final boolean f() {
        E1.h hVar;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f4825h;
            long j6 = atomicLongFieldUpdater.get(this);
            C0828a c0828a = (C0828a) this.f4830g.b((int) (2097151 & j6));
            if (c0828a == null) {
                c0828a = null;
            } else {
                long j7 = (2097152 + j6) & (-2097152);
                Object objC = c0828a.c();
                while (true) {
                    hVar = f4827k;
                    if (objC == hVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    C0828a c0828a2 = (C0828a) objC;
                    iB = c0828a2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = c0828a2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j6, j7 | ((long) iB))) {
                    c0828a.g(hVar);
                }
            }
            if (c0828a == null) {
                return false;
            }
            if (C0828a.i.compareAndSet(c0828a, -1, 0)) {
                LockSupport.unpark(c0828a);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        s sVar = this.f4830g;
        int iA = sVar.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < iA; i8++) {
            C0828a c0828a = (C0828a) sVar.b(i8);
            if (c0828a != null) {
                m mVar = c0828a.f4821a;
                mVar.getClass();
                int i9 = m.b.get(mVar) != null ? (m.c.get(mVar) - m.d.get(mVar)) + 1 : m.c.get(mVar) - m.d.get(mVar);
                int iB = f.s.b(c0828a.c);
                if (iB == 0) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i9);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iB == 1) {
                    i4++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i9);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iB == 2) {
                    i5++;
                } else if (iB == 3) {
                    i6++;
                    if (i9 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i9);
                        sb3.append(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
                        arrayList.add(sb3.toString());
                    }
                } else if (iB == 4) {
                    i7++;
                }
            }
        }
        long j6 = i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.d);
        sb4.append('@');
        sb4.append(AbstractC0690y.e(this));
        sb4.append("[Pool Size {core = ");
        int i10 = this.f4828a;
        sb4.append(i10);
        sb4.append(", max = ");
        sb4.append(this.b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i3);
        sb4.append(", blocking = ");
        sb4.append(i4);
        sb4.append(", parked = ");
        sb4.append(i5);
        sb4.append(", dormant = ");
        sb4.append(i6);
        sb4.append(", terminated = ");
        sb4.append(i7);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f4829f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j6));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j6) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i10 - ((int) ((j6 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
