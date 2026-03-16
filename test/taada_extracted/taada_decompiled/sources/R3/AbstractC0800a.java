package r3;

import c4.AbstractC0246d;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: renamed from: r3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0800a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E1.h f4700a = new E1.h("NO_DECISION", 9);
    public static final E1.h b = new E1.h("CLOSED", 9);
    public static final E1.h c = new E1.h("UNDEFINED", 9);
    public static final E1.h d = new E1.h("REUSABLE_CLAIMED", 9);
    public static final E1.h e = new E1.h("CONDITION_FALSE", 9);

    public static final void a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(B2.b.c(i, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final Object b(u uVar, long j6, Function2 function2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            if (uVar.c >= j6 && !uVar.c()) {
                return uVar;
            }
            Object obj = AbstractC0803d.f4703a.get(uVar);
            E1.h hVar = b;
            if (obj == hVar) {
                return hVar;
            }
            u uVar2 = (u) ((AbstractC0803d) obj);
            if (uVar2 == null) {
                uVar2 = (u) function2.mo5invoke(Long.valueOf(uVar.c + 1), uVar);
                do {
                    atomicReferenceFieldUpdater = AbstractC0803d.f4703a;
                    if (atomicReferenceFieldUpdater.compareAndSet(uVar, null, uVar2)) {
                        if (uVar.c()) {
                            uVar.d();
                        }
                    }
                } while (atomicReferenceFieldUpdater.get(uVar) == null);
            }
            uVar = uVar2;
        }
    }

    public static final u c(Object obj) {
        if (obj != b) {
            return (u) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final void d(CoroutineContext coroutineContext, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Throwable runtimeException;
        Iterator it = f.f4705a.iterator();
        while (it.hasNext()) {
            try {
                ((CoroutineExceptionHandler) it.next()).handleException(coroutineContext, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    AbstractC0246d.e(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            AbstractC0246d.e(th, new g(coroutineContext));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == b;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[Catch: all -> 0x006d, DONT_GENERATE, TryCatch #2 {all -> 0x006d, blocks: (B:16:0x004a, B:18:0x0058, B:20:0x005e, B:33:0x0091, B:23:0x006f, B:25:0x007d, B:30:0x0088, B:32:0x008e, B:38:0x009e, B:41:0x00a7, B:40:0x00a4, B:28:0x0083), top: B:54:0x004a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof r3.h
            if (r0 == 0) goto Lb2
            r3.h r10 = (r3.h) r10
            java.lang.Throwable r0 = N1.h.a(r9)
            if (r0 != 0) goto Le
            r1 = r9
            goto L14
        Le:
            m3.k r1 = new m3.k
            r2 = 0
            r1.<init>(r0, r2)
        L14:
            kotlin.coroutines.Continuation r0 = r10.e
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            m3.s r3 = r10.d
            boolean r2 = r3.isDispatchNeeded(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f4708f = r1
            r10.c = r4
            kotlin.coroutines.CoroutineContext r9 = r0.getContext()
            r3.dispatch(r9, r10)
            return
        L2f:
            m3.K r2 = m3.u0.a()
            long r5 = r2.f4108a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L46
            r10.f4708f = r1
            r10.c = r4
            r2.b(r10)
            goto Lac
        L46:
            r2.c(r4)
            r3 = 0
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()     // Catch: java.lang.Throwable -> L6d
            m3.a0 r6 = kotlinx.coroutines.Job.Key     // Catch: java.lang.Throwable -> L6d
            kotlin.coroutines.CoroutineContext$Element r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L6d
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5     // Catch: java.lang.Throwable -> L6d
            if (r5 == 0) goto L6f
            boolean r6 = r5.isActive()     // Catch: java.lang.Throwable -> L6d
            if (r6 != 0) goto L6f
            java.util.concurrent.CancellationException r9 = r5.getCancellationException()     // Catch: java.lang.Throwable -> L6d
            r10.a(r1, r9)     // Catch: java.lang.Throwable -> L6d
            N1.g r9 = kotlin.reflect.l.n(r9)     // Catch: java.lang.Throwable -> L6d
            r10.resumeWith(r9)     // Catch: java.lang.Throwable -> L6d
            goto L91
        L6d:
            r9 = move-exception
            goto La8
        L6f:
            java.lang.Object r1 = r10.f4709g     // Catch: java.lang.Throwable -> L6d
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r1 = r3.AbstractC0797A.c(r5, r1)     // Catch: java.lang.Throwable -> L6d
            E1.h r6 = r3.AbstractC0797A.f4695a     // Catch: java.lang.Throwable -> L6d
            if (r1 == r6) goto L82
            m3.y0 r6 = m3.AbstractC0682p.c(r0, r5, r1)     // Catch: java.lang.Throwable -> L6d
            goto L83
        L82:
            r6 = r3
        L83:
            r0.resumeWith(r9)     // Catch: java.lang.Throwable -> L9b
            if (r6 == 0) goto L8e
            boolean r9 = r6.I()     // Catch: java.lang.Throwable -> L6d
            if (r9 == 0) goto L91
        L8e:
            r3.AbstractC0797A.a(r5, r1)     // Catch: java.lang.Throwable -> L6d
        L91:
            boolean r9 = r2.e()     // Catch: java.lang.Throwable -> L6d
            if (r9 != 0) goto L91
        L97:
            r2.a(r4)
            goto Lac
        L9b:
            r9 = move-exception
            if (r6 == 0) goto La4
            boolean r0 = r6.I()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto La7
        La4:
            r3.AbstractC0797A.a(r5, r1)     // Catch: java.lang.Throwable -> L6d
        La7:
            throw r9     // Catch: java.lang.Throwable -> L6d
        La8:
            r10.e(r9, r3)     // Catch: java.lang.Throwable -> Lad
            goto L97
        Lac:
            return
        Lad:
            r9 = move-exception
            r2.a(r4)
            throw r9
        Lb2:
            r10.resumeWith(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.AbstractC0800a.g(java.lang.Object, kotlin.coroutines.Continuation):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long i(long r23, long r25, long r27, java.lang.String r29) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.AbstractC0800a.i(long, long, long, java.lang.String):long");
    }

    public static int j(int i, int i3, String str) {
        return (int) i(i, 1, (i3 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }
}
