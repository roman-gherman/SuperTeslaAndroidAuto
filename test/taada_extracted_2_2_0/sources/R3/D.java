package r3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import m3.N;

/* JADX INFO: loaded from: classes2.dex */
public class D {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(D.class, "_size");

    @Volatile
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadSafeHeapNode[] f4699a;

    public final void a(N n6) {
        n6.setHeap(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f4699a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (threadSafeHeapNodeArr == null) {
            threadSafeHeapNodeArr = new ThreadSafeHeapNode[4];
            this.f4699a = threadSafeHeapNodeArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= threadSafeHeapNodeArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(threadSafeHeapNodeArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
            threadSafeHeapNodeArr = (ThreadSafeHeapNode[]) objArrCopyOf;
            this.f4699a = threadSafeHeapNodeArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        threadSafeHeapNodeArr[i] = n6;
        n6.b = i;
        c(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.ThreadSafeHeapNode b(int r9) {
        /*
            r8 = this;
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r0 = r8.f4699a
            kotlin.jvm.internal.h.c(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = r3.D.b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L80
            int r2 = r1.get(r8)
            r8.d(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3c
            r4 = r0[r9]
            kotlin.jvm.internal.h.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r5 = r0[r2]
            kotlin.jvm.internal.h.c(r5)
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3c
            r8.d(r9, r2)
            r8.c(r2)
            goto L80
        L3c:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L47
            goto L80
        L47:
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r5 = r8.f4699a
            kotlin.jvm.internal.h.c(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L67
            r6 = r5[r2]
            kotlin.jvm.internal.h.c(r6)
            java.lang.Comparable r6 = (java.lang.Comparable) r6
            r7 = r5[r4]
            kotlin.jvm.internal.h.c(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L67
            goto L68
        L67:
            r2 = r4
        L68:
            r4 = r5[r9]
            kotlin.jvm.internal.h.c(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r5 = r5[r2]
            kotlin.jvm.internal.h.c(r5)
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L7b
            goto L80
        L7b:
            r8.d(r9, r2)
            r9 = r2
            goto L3c
        L80:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            kotlin.jvm.internal.h.c(r9)
            r2 = 0
            r9.setHeap(r2)
            r9.setIndex(r3)
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.D.b(int):kotlinx.coroutines.internal.ThreadSafeHeapNode");
    }

    public final void c(int i) {
        while (i > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f4699a;
            kotlin.jvm.internal.h.c(threadSafeHeapNodeArr);
            int i3 = (i - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i3];
            kotlin.jvm.internal.h.c(threadSafeHeapNode);
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
            kotlin.jvm.internal.h.c(threadSafeHeapNode2);
            if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) <= 0) {
                return;
            }
            d(i, i3);
            i = i3;
        }
    }

    public final void d(int i, int i3) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f4699a;
        kotlin.jvm.internal.h.c(threadSafeHeapNodeArr);
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i3];
        kotlin.jvm.internal.h.c(threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
        kotlin.jvm.internal.h.c(threadSafeHeapNode2);
        threadSafeHeapNodeArr[i] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i3] = threadSafeHeapNode2;
        threadSafeHeapNode.setIndex(i);
        threadSafeHeapNode2.setIndex(i3);
    }
}
