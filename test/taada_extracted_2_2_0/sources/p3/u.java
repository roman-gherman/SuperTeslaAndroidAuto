package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import m3.C0671e;
import m3.C0672f;
import o3.EnumC0743a;
import q3.AbstractC0785b;
import q3.AbstractC0786c;
import q3.AbstractC0787d;

/* JADX INFO: loaded from: classes2.dex */
public class u extends AbstractC0785b implements MutableSharedFlow, CancellableFlow, FusibleFlow {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EnumC0743a f4497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object[] f4498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4499h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4501k;

    public u(int i, EnumC0743a enumC0743a) {
        this.e = i;
        this.f4497f = enumC0743a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:7))(0)|8|(1:52)|(2:10|(1:(1:(7:14|15|16|31|58|(4:32|(9:56|(2:41|42)|43|(1:60)|16|31|58|32|(0)(1:34))(0)|48|49)|45)(2:19|20))(5:21|22|58|(4:32|(0)(0)|48|49)|45))(4:24|54|25|26))(1:29)|50|30|31|58|(4:32|(0)(0)|48|49)|45) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:15:0x0031, B:32:0x0079, B:34:0x0081, B:38:0x0094, B:41:0x009b, B:42:0x009f, B:43:0x00a0, B:22:0x004b), top: B:52:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [q3.b] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [p3.u] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2, types: [q3.d] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [p3.w] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [p3.w] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ae -> B:16:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(p3.u r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof p3.t
            if (r0 == 0) goto L13
            r0 = r10
            p3.t r0 = (p3.t) r0
            int r1 = r0.f4496g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4496g = r1
            goto L18
        L13:
            p3.t r0 = new p3.t
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f4496g
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L5e
            r8 = 1
            if (r2 == r8) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            kotlinx.coroutines.Job r8 = r0.d
            p3.w r9 = r0.c
            kotlinx.coroutines.flow.FlowCollector r2 = r0.b
            p3.u r5 = r0.f4494a
            kotlin.reflect.l.e0(r10)     // Catch: java.lang.Throwable -> L38
        L34:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L76
        L38:
            r8 = move-exception
            goto Lb4
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            kotlinx.coroutines.Job r8 = r0.d
            p3.w r9 = r0.c
            kotlinx.coroutines.flow.FlowCollector r2 = r0.b
            p3.u r5 = r0.f4494a
            kotlin.reflect.l.e0(r10)     // Catch: java.lang.Throwable -> L38
            goto L79
        L4f:
            p3.w r9 = r0.c
            kotlinx.coroutines.flow.FlowCollector r8 = r0.b
            p3.u r2 = r0.f4494a
            kotlin.reflect.l.e0(r10)     // Catch: java.lang.Throwable -> L5b
            r10 = r8
            r8 = r2
            goto L6a
        L5b:
            r8 = move-exception
            r5 = r2
            goto Lb4
        L5e:
            kotlin.reflect.l.e0(r10)
            q3.d r10 = r8.a()
            p3.w r10 = (p3.w) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L6a:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch: java.lang.Throwable -> Lb1
            m3.a0 r5 = kotlinx.coroutines.Job.Key     // Catch: java.lang.Throwable -> Lb1
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r5)     // Catch: java.lang.Throwable -> Lb1
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2     // Catch: java.lang.Throwable -> Lb1
        L76:
            r5 = r8
            r8 = r2
            r2 = r10
        L79:
            java.lang.Object r10 = r5.o(r9)     // Catch: java.lang.Throwable -> L38
            E1.h r6 = p3.v.f4502a     // Catch: java.lang.Throwable -> L38
            if (r10 != r6) goto L92
            r0.f4494a = r5     // Catch: java.lang.Throwable -> L38
            r0.b = r2     // Catch: java.lang.Throwable -> L38
            r0.c = r9     // Catch: java.lang.Throwable -> L38
            r0.d = r8     // Catch: java.lang.Throwable -> L38
            r0.f4496g = r4     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r5.e(r9, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L79
            goto Lb0
        L92:
            if (r8 == 0) goto La0
            boolean r6 = r8.isActive()     // Catch: java.lang.Throwable -> L38
            if (r6 == 0) goto L9b
            goto La0
        L9b:
            java.util.concurrent.CancellationException r8 = r8.getCancellationException()     // Catch: java.lang.Throwable -> L38
            throw r8     // Catch: java.lang.Throwable -> L38
        La0:
            r0.f4494a = r5     // Catch: java.lang.Throwable -> L38
            r0.b = r2     // Catch: java.lang.Throwable -> L38
            r0.c = r9     // Catch: java.lang.Throwable -> L38
            r0.d = r8     // Catch: java.lang.Throwable -> L38
            r0.f4496g = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L34
        Lb0:
            return
        Lb1:
            r10 = move-exception
            r5 = r8
            r8 = r10
        Lb4:
            r5.d(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.u.g(p3.u, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):void");
    }

    @Override // q3.AbstractC0785b
    public final AbstractC0787d b() {
        w wVar = new w();
        wVar.f4503a = -1L;
        return wVar;
    }

    @Override // q3.AbstractC0785b
    public final AbstractC0787d[] c() {
        return new w[2];
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        g(this, flowCollector, continuation);
        return T1.a.f1304a;
    }

    public final Object e(w wVar, t tVar) {
        C0672f c0672f = new C0672f(1, C5.f.J(tVar));
        c0672f.initCancellability();
        synchronized (this) {
            if (n(wVar) < 0) {
                wVar.b = c0672f;
            } else {
                c0672f.resumeWith(N1.m.f1129a);
            }
        }
        Object objM = c0672f.m();
        return objM == T1.a.f1304a ? objM : N1.m.f1129a;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Throwable {
        Throwable th;
        Continuation[] continuationArrJ;
        s sVar;
        if (tryEmit(obj)) {
            return N1.m.f1129a;
        }
        C0672f c0672f = new C0672f(1, C5.f.J(continuation));
        c0672f.initCancellability();
        Continuation[] continuationArrJ2 = AbstractC0786c.f4653a;
        synchronized (this) {
            try {
                if (m(obj)) {
                    try {
                        c0672f.resumeWith(N1.m.f1129a);
                        continuationArrJ = j(continuationArrJ2);
                        sVar = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        s sVar2 = new s(this, k() + ((long) (this.f4500j + this.f4501k)), obj, c0672f);
                        i(sVar2);
                        this.f4501k++;
                        if (this.e == 0) {
                            continuationArrJ2 = j(continuationArrJ2);
                        }
                        continuationArrJ = continuationArrJ2;
                        sVar = sVar2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (sVar != null) {
                    c0672f.invokeOnCancellation(new C0671e(sVar, 1));
                }
                for (Continuation continuation2 : continuationArrJ) {
                    if (continuation2 != null) {
                        continuation2.resumeWith(N1.m.f1129a);
                    }
                }
                Object objM = c0672f.m();
                T1.a aVar = T1.a.f1304a;
                if (objM != aVar) {
                    objM = N1.m.f1129a;
                }
                return objM == aVar ? objM : N1.m.f1129a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void f() {
        if (this.e != 0 || this.f4501k > 1) {
            Object[] objArr = this.f4498g;
            kotlin.jvm.internal.h.c(objArr);
            while (this.f4501k > 0) {
                long jK = k();
                int i = this.f4500j;
                int i3 = this.f4501k;
                if (objArr[((int) ((jK + ((long) (i + i3))) - 1)) & (objArr.length - 1)] != v.f4502a) {
                    return;
                }
                this.f4501k = i3 - 1;
                v.b(objArr, k() + ((long) (this.f4500j + this.f4501k)), null);
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        return v.h(this, coroutineContext, i, enumC0743a);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public final List getReplayCache() {
        synchronized (this) {
            int iK = (int) ((k() + ((long) this.f4500j)) - this.f4499h);
            if (iK == 0) {
                return kotlin.collections.u.f3805a;
            }
            ArrayList arrayList = new ArrayList(iK);
            Object[] objArr = this.f4498g;
            kotlin.jvm.internal.h.c(objArr);
            for (int i = 0; i < iK; i++) {
                arrayList.add(objArr[((int) (this.f4499h + ((long) i))) & (objArr.length - 1)]);
            }
            return arrayList;
        }
    }

    public final void h() {
        AbstractC0787d[] abstractC0787dArr;
        Object[] objArr = this.f4498g;
        kotlin.jvm.internal.h.c(objArr);
        v.b(objArr, k(), null);
        this.f4500j--;
        long jK = k() + 1;
        if (this.f4499h < jK) {
            this.f4499h = jK;
        }
        if (this.i < jK) {
            if (this.b != 0 && (abstractC0787dArr = this.f4652a) != null) {
                for (AbstractC0787d abstractC0787d : abstractC0787dArr) {
                    if (abstractC0787d != null) {
                        w wVar = (w) abstractC0787d;
                        long j6 = wVar.f4503a;
                        if (j6 >= 0 && j6 < jK) {
                            wVar.f4503a = jK;
                        }
                    }
                }
            }
            this.i = jK;
        }
    }

    public final void i(Object obj) {
        int i = this.f4500j + this.f4501k;
        Object[] objArrL = this.f4498g;
        if (objArrL == null) {
            objArrL = l(null, 0, 2);
        } else if (i >= objArrL.length) {
            objArrL = l(objArrL, i, objArrL.length * 2);
        }
        v.b(objArrL, k() + ((long) i), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final Continuation[] j(Continuation[] continuationArr) {
        AbstractC0787d[] abstractC0787dArr;
        w wVar;
        C0672f c0672f;
        int length = continuationArr.length;
        if (this.b != 0 && (abstractC0787dArr = this.f4652a) != null) {
            int length2 = abstractC0787dArr.length;
            int i = 0;
            continuationArr = continuationArr;
            while (i < length2) {
                AbstractC0787d abstractC0787d = abstractC0787dArr[i];
                if (abstractC0787d != null && (c0672f = (wVar = (w) abstractC0787d).b) != null && n(wVar) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) continuationArr, Math.max(2, continuationArr.length * 2));
                        kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
                        continuationArr = objArrCopyOf;
                    }
                    ((Continuation[]) continuationArr)[length] = c0672f;
                    wVar.b = null;
                    length++;
                }
                i++;
                continuationArr = continuationArr;
            }
        }
        return (Continuation[]) continuationArr;
    }

    public final long k() {
        return Math.min(this.i, this.f4499h);
    }

    public final Object[] l(Object[] objArr, int i, int i3) {
        if (i3 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i3];
        this.f4498g = objArr2;
        if (objArr != null) {
            long jK = k();
            for (int i4 = 0; i4 < i; i4++) {
                long j6 = ((long) i4) + jK;
                v.b(objArr2, j6, objArr[((int) j6) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(java.lang.Object r13) {
        /*
            r12 = this;
            int r1 = r12.b
            r9 = 1
            if (r1 != 0) goto L1d
            r12.i(r13)
            int r1 = r12.f4500j
            int r1 = r1 + r9
            r12.f4500j = r1
            if (r1 <= r9) goto L12
            r12.h()
        L12:
            long r1 = r12.k()
            int r3 = r12.f4500j
            long r3 = (long) r3
            long r1 = r1 + r3
            r12.i = r1
            return r9
        L1d:
            int r1 = r12.f4500j
            int r2 = r12.e
            if (r1 < r2) goto L39
            long r3 = r12.i
            long r5 = r12.f4499h
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 > 0) goto L39
            o3.a r1 = r12.f4497f
            int r1 = r1.ordinal()
            if (r1 == 0) goto L37
            r3 = 2
            if (r1 == r3) goto L71
            goto L39
        L37:
            r1 = 0
            return r1
        L39:
            r12.i(r13)
            int r1 = r12.f4500j
            int r1 = r1 + r9
            r12.f4500j = r1
            if (r1 <= r2) goto L46
            r12.h()
        L46:
            long r1 = r12.k()
            int r3 = r12.f4500j
            long r3 = (long) r3
            long r1 = r1 + r3
            long r3 = r12.f4499h
            long r1 = r1 - r3
            int r1 = (int) r1
            if (r1 <= r9) goto L71
            r1 = 1
            long r1 = r1 + r3
            long r3 = r12.i
            long r5 = r12.k()
            int r7 = r12.f4500j
            long r7 = (long) r7
            long r5 = r5 + r7
            long r7 = r12.k()
            int r10 = r12.f4500j
            long r10 = (long) r10
            long r7 = r7 + r10
            int r10 = r12.f4501k
            long r10 = (long) r10
            long r7 = r7 + r10
            r0 = r12
            r0.p(r1, r3, r5, r7)
        L71:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.u.m(java.lang.Object):boolean");
    }

    public final long n(w wVar) {
        long j6 = wVar.f4503a;
        if (j6 < k() + ((long) this.f4500j)) {
            return j6;
        }
        if (this.e <= 0 && j6 <= k() && this.f4501k != 0) {
            return j6;
        }
        return -1L;
    }

    public final Object o(w wVar) {
        Object obj;
        Continuation[] continuationArrQ = AbstractC0786c.f4653a;
        synchronized (this) {
            try {
                long jN = n(wVar);
                if (jN < 0) {
                    obj = v.f4502a;
                } else {
                    long j6 = wVar.f4503a;
                    Object[] objArr = this.f4498g;
                    kotlin.jvm.internal.h.c(objArr);
                    Object obj2 = objArr[((int) jN) & (objArr.length - 1)];
                    if (obj2 instanceof s) {
                        obj2 = ((s) obj2).c;
                    }
                    wVar.f4503a = jN + 1;
                    Object obj3 = obj2;
                    continuationArrQ = q(j6);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrQ) {
            if (continuation != null) {
                continuation.resumeWith(N1.m.f1129a);
            }
        }
        return obj;
    }

    public final void p(long j6, long j7, long j8, long j9) {
        long jMin = Math.min(j7, j6);
        for (long jK = k(); jK < jMin; jK++) {
            Object[] objArr = this.f4498g;
            kotlin.jvm.internal.h.c(objArr);
            v.b(objArr, jK, null);
        }
        this.f4499h = j6;
        this.i = j7;
        this.f4500j = (int) (j8 - jMin);
        this.f4501k = (int) (j9 - j8);
    }

    public final Continuation[] q(long j6) {
        int i;
        long j7;
        int i3;
        Continuation[] continuationArr;
        Continuation[] continuationArr2;
        AbstractC0787d[] abstractC0787dArr;
        long j8 = this.i;
        Continuation[] continuationArr3 = AbstractC0786c.f4653a;
        if (j6 <= j8) {
            long jK = k();
            long j9 = ((long) this.f4500j) + jK;
            int i4 = this.e;
            if (i4 == 0 && this.f4501k > 0) {
                j9++;
            }
            int i5 = 0;
            if (this.b != 0 && (abstractC0787dArr = this.f4652a) != null) {
                for (AbstractC0787d abstractC0787d : abstractC0787dArr) {
                    if (abstractC0787d != null) {
                        long j10 = ((w) abstractC0787d).f4503a;
                        if (j10 >= 0 && j10 < j9) {
                            j9 = j10;
                        }
                    }
                }
            }
            if (j9 > this.i) {
                long jK2 = k() + ((long) this.f4500j);
                int iMin = this.b > 0 ? Math.min(this.f4501k, i4 - ((int) (jK2 - j9))) : this.f4501k;
                long j11 = ((long) this.f4501k) + jK2;
                E1.h hVar = v.f4502a;
                if (iMin > 0) {
                    Continuation[] continuationArr4 = new Continuation[iMin];
                    Object[] objArr = this.f4498g;
                    kotlin.jvm.internal.h.c(objArr);
                    long j12 = jK2;
                    while (true) {
                        if (jK2 >= j11) {
                            i = i4;
                            continuationArr2 = continuationArr4;
                            j7 = jK;
                            i3 = 1;
                            jK2 = j12;
                            break;
                        }
                        i3 = 1;
                        i = i4;
                        Object obj = objArr[(objArr.length - 1) & ((int) jK2)];
                        if (obj != hVar) {
                            kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                            s sVar = (s) obj;
                            int i6 = i5 + 1;
                            continuationArr2 = continuationArr4;
                            continuationArr2[i5] = sVar.d;
                            v.b(objArr, jK2, hVar);
                            j7 = jK;
                            long j13 = j12;
                            v.b(objArr, j13, sVar.c);
                            long j14 = j13 + 1;
                            if (i6 >= iMin) {
                                jK2 = j14;
                                break;
                            }
                            j12 = j14;
                            i5 = i6;
                        } else {
                            continuationArr2 = continuationArr4;
                            j7 = jK;
                        }
                        jK2++;
                        i4 = i;
                        continuationArr4 = continuationArr2;
                        jK = j7;
                    }
                    continuationArr = continuationArr2;
                } else {
                    i = i4;
                    j7 = jK;
                    i3 = 1;
                    continuationArr = continuationArr3;
                }
                int i7 = (int) (jK2 - j7);
                long j15 = this.b == 0 ? jK2 : j9;
                long jMax = Math.max(this.f4499h, jK2 - ((long) Math.min(i3, i7)));
                if (i == 0 && jMax < j11) {
                    Object[] objArr2 = this.f4498g;
                    kotlin.jvm.internal.h.c(objArr2);
                    if (kotlin.jvm.internal.h.a(objArr2[((int) jMax) & (objArr2.length - 1)], hVar)) {
                        jK2++;
                        jMax++;
                    }
                }
                p(jMax, j15, jK2, j11);
                f();
                return continuationArr.length == 0 ? continuationArr : j(continuationArr);
            }
        }
        return continuationArr3;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() throws Throwable {
        synchronized (this) {
            try {
                try {
                    p(k() + ((long) this.f4500j), this.i, k() + ((long) this.f4500j), k() + ((long) this.f4500j) + ((long) this.f4501k));
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(Object obj) {
        int i;
        boolean z6;
        Continuation[] continuationArrJ = AbstractC0786c.f4653a;
        synchronized (this) {
            if (m(obj)) {
                continuationArrJ = j(continuationArrJ);
                z6 = true;
            } else {
                z6 = false;
            }
        }
        for (Continuation continuation : continuationArrJ) {
            if (continuation != null) {
                continuation.resumeWith(N1.m.f1129a);
            }
        }
        return z6;
    }
}
