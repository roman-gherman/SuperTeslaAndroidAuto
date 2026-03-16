package r3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f4715f = AtomicLongFieldUpdater.newUpdater(n.class, "_state");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E1.h f4716g = new E1.h("REMOVE_FROZEN", 9);

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4717a;
    public final boolean b;
    public final int c;
    public final AtomicReferenceArray d;

    public n(int i, boolean z6) {
        this.f4717a = i;
        this.b = z6;
        int i3 = i - 1;
        this.c = i3;
        this.d = new AtomicReferenceArray(i);
        if (i3 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i3) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f4715f;
            long j6 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j6) != 0) {
                return (2305843009213693952L & j6) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j6);
            int i3 = (int) ((1152921503533105152L & j6) >> 30);
            int i4 = this.c;
            if (((i3 + 2) & i4) == (i & i4)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (!this.b && atomicReferenceArray.get(i3 & i4) != null) {
                int i5 = this.f4717a;
                if (i5 < 1024 || ((i3 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j6, ((-1152921503533105153L) & j6) | (((long) ((i3 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i3 & i4, runnable);
                n nVarC = this;
                while ((atomicLongFieldUpdater.get(nVarC) & 1152921504606846976L) != 0) {
                    nVarC = nVarC.c();
                    AtomicReferenceArray atomicReferenceArray2 = nVarC.d;
                    int i6 = nVarC.c & i3;
                    Object obj = atomicReferenceArray2.get(i6);
                    if ((obj instanceof m) && ((m) obj).f4714a == i3) {
                        atomicReferenceArray2.set(i6, runnable);
                    } else {
                        nVarC = null;
                    }
                    if (nVarC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        do {
            atomicLongFieldUpdater = f4715f;
            j6 = atomicLongFieldUpdater.get(this);
            if ((j6 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j6) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, 2305843009213693952L | j6));
        return true;
    }

    public final n c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        n nVar;
        while (true) {
            atomicLongFieldUpdater = f4715f;
            j6 = atomicLongFieldUpdater.get(this);
            if ((j6 & 1152921504606846976L) != 0) {
                nVar = this;
                break;
            }
            long j7 = 1152921504606846976L | j6;
            nVar = this;
            if (atomicLongFieldUpdater.compareAndSet(nVar, j6, j7)) {
                j6 = j7;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            n nVar2 = (n) atomicReferenceFieldUpdater.get(this);
            if (nVar2 != null) {
                return nVar2;
            }
            n nVar3 = new n(nVar.f4717a * 2, nVar.b);
            int i = (int) (1073741823 & j6);
            int i3 = (int) ((1152921503533105152L & j6) >> 30);
            while (true) {
                int i4 = nVar.c;
                int i5 = i & i4;
                if (i5 == (i4 & i3)) {
                    break;
                }
                Object mVar = nVar.d.get(i5);
                if (mVar == null) {
                    mVar = new m(i);
                }
                nVar3.d.set(nVar3.c & i, mVar);
                i++;
            }
            atomicLongFieldUpdater.set(nVar3, (-1152921504606846977L) & j6);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, nVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = r3.n.f4715f
            long r2 = r0.get(r1)
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r6
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 == 0) goto L15
            E1.h r0 = r3.n.f4716g
            return r0
        L15:
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r10
            int r4 = (int) r4
            r12 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r12 = r12 & r2
            r5 = 30
            long r12 = r12 >> r5
            int r5 = (int) r12
            int r12 = r1.c
            r5 = r5 & r12
            r12 = r12 & r4
            r13 = 0
            if (r5 != r12) goto L2d
            goto L40
        L2d:
            java.util.concurrent.atomic.AtomicReferenceArray r14 = r1.d
            java.lang.Object r15 = r14.get(r12)
            boolean r5 = r1.b
            if (r15 != 0) goto L3a
            if (r5 == 0) goto L2
            goto L40
        L3a:
            r16 = r6
            boolean r6 = r15 instanceof r3.m
            if (r6 == 0) goto L41
        L40:
            return r13
        L41:
            int r4 = r4 + 1
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            r4 = r4 & r6
            r6 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r6
            r20 = r6
            long r6 = (long) r4
            long r18 = r18 | r6
            r28 = r18
            r18 = r5
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L61
            r14.set(r12, r13)
            return r15
        L61:
            r1 = r30
            if (r18 == 0) goto L2
        L65:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = r3.n.f4715f
            long r24 = r0.get(r1)
            long r2 = r24 & r10
            int r2 = (int) r2
            long r3 = r24 & r16
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L7a
            r3.n r0 = r1.c()
            r1 = r0
            goto L93
        L7a:
            long r3 = r24 & r20
            long r26 = r3 | r6
            r22 = r0
            r23 = r1
            boolean r0 = r22.compareAndSet(r23, r24, r26)
            r1 = r23
            if (r0 == 0) goto L65
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.d
            int r1 = r1.c
            r1 = r1 & r2
            r0.set(r1, r13)
            r1 = r13
        L93:
            if (r1 != 0) goto L65
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.n.d():java.lang.Object");
    }
}
