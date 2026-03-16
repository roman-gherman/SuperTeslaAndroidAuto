package o3;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends r3.u {
    public final n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f4355f;

    public w(long j6, w wVar, n nVar, int i) {
        super(j6, wVar, i);
        this.e = nVar;
        this.f4355f = new AtomicReferenceArray(p.b * 2);
    }

    @Override // r3.u
    public final int f() {
        return p.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        kotlin.jvm.internal.h.c(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // r3.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r4 = this;
            int r6 = o3.p.b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r4.f4355f
            int r1 = r5 * 2
            r6.get(r1)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof kotlinx.coroutines.Waiter
            o3.n r2 = r4.e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof o3.E
            if (r1 == 0) goto L21
            goto L62
        L21:
            E1.h r1 = o3.p.f4342j
            if (r6 == r1) goto L59
            E1.h r1 = o3.p.f4343k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            E1.h r1 = o3.p.f4340g
            if (r6 == r1) goto L11
            E1.h r1 = o3.p.f4339f
            if (r6 != r1) goto L33
            goto L11
        L33:
            E1.h r5 = o3.p.i
            if (r6 == r5) goto L7c
            E1.h r5 = o3.p.d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            E1.h r5 = o3.p.f4344l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.m(r5, r3)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.h.c(r2)
            return
        L62:
            if (r0 == 0) goto L67
            E1.h r1 = o3.p.f4342j
            goto L69
        L67:
            E1.h r1 = o3.p.f4343k
        L69:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.h.c(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.w.g(int, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean j(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f4355f;
        int i3 = (i * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object k(int i) {
        return this.f4355f.get((i * 2) + 1);
    }

    public final void l(int i, boolean z6) {
        if (z6) {
            n nVar = this.e;
            kotlin.jvm.internal.h.c(nVar);
            nVar.D((this.c * ((long) p.b)) + ((long) i));
        }
        h();
    }

    public final void m(int i, Object obj) {
        this.f4355f.lazySet(i * 2, obj);
    }

    public final void n(int i, E1.h hVar) {
        this.f4355f.set((i * 2) + 1, hVar);
    }
}
