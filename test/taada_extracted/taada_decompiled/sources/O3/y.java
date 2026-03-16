package o3;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends n {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final EnumC0743a f4356k;

    public y(int i, EnumC0743a enumC0743a) {
        super(i);
        this.f4356k = enumC0743a;
        if (enumC0743a != EnumC0743a.f4320a) {
            if (i < 1) {
                throw new IllegalArgumentException(B2.b.d(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.w.f3817a.b(n.class).getSimpleName() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            o3.a r1 = o3.EnumC0743a.c
            N1.m r8 = N1.m.f1129a
            o3.a r2 = r15.f4356k
            if (r2 != r1) goto L17
            java.lang.Object r1 = super.mo106trySendJP2dKIU(r16)
            boolean r2 = r1 instanceof o3.u
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof o3.t
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            E1.h r6 = o3.p.d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = o3.n.f4332f
            java.lang.Object r1 = r1.get(r15)
            o3.w r1 = (o3.w) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = o3.n.b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.q(r2, r7)
            int r9 = o3.p.b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            o3.w r2 = o3.n.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.m()
            o3.t r2 = new o3.t
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = o3.n.d(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.a()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = o3.n.c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.a()
        L7e:
            java.lang.Throwable r1 = r15.m()
            o3.t r2 = new o3.t
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.h()
            java.lang.Throwable r1 = r15.m()
            o3.t r2 = new o3.t
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof kotlinx.coroutines.Waiter
            if (r3 == 0) goto La6
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.invokeOnCancellation(r1, r12)
        Lae:
            long r3 = r1.c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.h(r3)
        Lb6:
            return r8
        Lb7:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.y.E(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // o3.n
    public final boolean r() {
        return this.f4356k == EnumC0743a.b;
    }

    @Override // o3.n, kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) throws Throwable {
        Object objE = E(obj, true);
        if (!(objE instanceof t)) {
            return N1.m.f1129a;
        }
        v.a(objE);
        throw m();
    }

    @Override // o3.n, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo106trySendJP2dKIU(Object obj) {
        return E(obj, false);
    }

    @Override // o3.n
    public final void x(SelectInstance selectInstance, Object obj) {
        Object objE = E(obj, false);
        if (!(objE instanceof u)) {
            selectInstance.selectInRegistrationPhase(N1.m.f1129a);
        } else {
            if (!(objE instanceof t)) {
                throw new IllegalStateException("unreachable");
            }
            v.a(objE);
            selectInstance.selectInRegistrationPhase(p.f4344l);
        }
    }
}
