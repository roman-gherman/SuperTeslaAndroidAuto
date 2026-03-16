package r3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import m3.AbstractC0690y;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4712a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");

    @Volatile
    @Nullable
    private volatile Object _next = this;

    @Volatile
    @Nullable
    private volatile Object _prev = this;

    @Volatile
    @Nullable
    private volatile Object _removedRef;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r6 = ((r3.r) r6).f4719a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (r5.get(r4) == r3) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r3.k a() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r3.k.b
            java.lang.Object r1 = r0.get(r9)
            r3.k r1 = (r3.k) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = r3.k.f4712a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            goto L2d
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            goto L2d
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.e()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            if (r6 != 0) goto L2e
        L2d:
            return r3
        L2e:
            boolean r7 = r6 instanceof r3.q
            if (r7 == 0) goto L38
            r3.q r6 = (r3.q) r6
            r6.a(r3)
            goto L0
        L38:
            boolean r7 = r6 instanceof r3.r
            if (r7 == 0) goto L58
            if (r4 == 0) goto L51
            r3.r r6 = (r3.r) r6
            r3.k r6 = r6.f4719a
        L42:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L4a
            r3 = r4
            goto La
        L4a:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L42
            goto L0
        L51:
            java.lang.Object r3 = r0.get(r3)
            r3.k r3 = (r3.k) r3
            goto Lb
        L58:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.h.d(r6, r4)
            r4 = r6
            r3.k r4 = (r3.k) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.k.a():r3.k");
    }

    public final void b(k kVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            k kVar2 = (k) atomicReferenceFieldUpdater.get(kVar);
            if (c() != kVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, kVar2, this)) {
                if (atomicReferenceFieldUpdater.get(kVar) != kVar2) {
                    break;
                }
            }
            if (e()) {
                kVar.a();
                return;
            }
            return;
        }
    }

    public final Object c() {
        while (true) {
            Object obj = f4712a.get(this);
            if (!(obj instanceof q)) {
                return obj;
            }
            ((q) obj).a(this);
        }
    }

    public final k d() {
        k kVar;
        Object objC = c();
        r rVar = objC instanceof r ? (r) objC : null;
        if (rVar != null && (kVar = rVar.f4719a) != null) {
            return kVar;
        }
        kotlin.jvm.internal.h.d(objC, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (k) objC;
    }

    public boolean e() {
        return c() instanceof r;
    }

    public String toString() {
        return new j(this, AbstractC0690y.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + AbstractC0690y.e(this);
    }
}
