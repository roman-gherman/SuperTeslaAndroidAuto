package p3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import m3.AbstractC0684s;
import o3.EnumC0743a;
import q3.AbstractC0786c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E1.h f4501a = new E1.h("NO_VALUE", 9);
    public static final E1.h b = new E1.h("NONE", 9);
    public static final E1.h c = new E1.h("PENDING", 9);

    public static final z a(Object obj) {
        if (obj == null) {
            obj = AbstractC0786c.b;
        }
        return new z(obj);
    }

    public static final void b(Object[] objArr, long j6, Object obj) {
        objArr[((int) j6) & (objArr.length - 1)] = obj;
    }

    public static final c c(Function2 function2) {
        return new c(function2, S1.g.f1282a, -2, EnumC0743a.f4320a);
    }

    public static final Flow d(Flow flow) {
        k kVar = l.f4485a;
        if (flow instanceof StateFlow) {
            return flow;
        }
        k kVar2 = l.f4485a;
        j jVar = l.b;
        if (flow instanceof f) {
            f fVar = (f) flow;
            if (fVar.b == kVar2 && fVar.c == jVar) {
                return flow;
            }
        }
        return new f(flow, kVar2, jVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r2.emit(r10, r0) == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x002f, B:24:0x0052, B:28:0x0067, B:30:0x006f, B:20:0x0047, B:23:0x004e), top: B:47:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlinx.coroutines.channels.Channel, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v3, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0081 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(kotlinx.coroutines.flow.FlowCollector r7, kotlinx.coroutines.channels.Channel r8, boolean r9, U1.c r10) {
        /*
            boolean r0 = r10 instanceof p3.i
            if (r0 == 0) goto L13
            r0 = r10
            p3.i r0 = (p3.i) r0
            int r1 = r0.f4482f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4482f = r1
            goto L18
        L13:
            p3.i r0 = new p3.i
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.e
            T1.a r1 = T1.a.f1304a
            int r2 = r0.f4482f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            boolean r9 = r0.d
            kotlinx.coroutines.channels.ChannelIterator r7 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r8 = r0.b
            kotlinx.coroutines.flow.FlowCollector r2 = r0.f4481a
            kotlin.reflect.l.e0(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r2
            goto L52
        L35:
            r7 = move-exception
            goto L8c
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            boolean r9 = r0.d
            kotlinx.coroutines.channels.ChannelIterator r7 = r0.c
            kotlinx.coroutines.channels.ReceiveChannel r8 = r0.b
            kotlinx.coroutines.flow.FlowCollector r2 = r0.f4481a
            kotlin.reflect.l.e0(r10)     // Catch: java.lang.Throwable -> L35
            goto L67
        L4b:
            kotlin.reflect.l.e0(r10)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L52:
            r0.f4481a = r7     // Catch: java.lang.Throwable -> L35
            r0.b = r8     // Catch: java.lang.Throwable -> L35
            r0.c = r10     // Catch: java.lang.Throwable -> L35
            r0.d = r9     // Catch: java.lang.Throwable -> L35
            r0.f4482f = r5     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.hasNext(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L63
            goto L83
        L63:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L67:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L84
            java.lang.Object r10 = r7.next()     // Catch: java.lang.Throwable -> L35
            r0.f4481a = r2     // Catch: java.lang.Throwable -> L35
            r0.b = r8     // Catch: java.lang.Throwable -> L35
            r0.c = r7     // Catch: java.lang.Throwable -> L35
            r0.d = r9     // Catch: java.lang.Throwable -> L35
            r0.f4482f = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L32
        L83:
            return r1
        L84:
            if (r9 == 0) goto L89
            r8.cancel(r3)
        L89:
            N1.m r7 = N1.m.f1129a
            return r7
        L8c:
            throw r7     // Catch: java.lang.Throwable -> L8d
        L8d:
            r10 = move-exception
            if (r9 == 0) goto La6
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L97
            r3 = r7
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
        L97:
            if (r3 != 0) goto La3
            java.util.concurrent.CancellationException r3 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r3.<init>(r9)
            r3.initCause(r7)
        La3:
            r8.cancel(r3)
        La6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.v.e(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.Channel, boolean, U1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(x1.d r4, x1.f r5, U1.c r6) {
        /*
            boolean r0 = r6 instanceof p3.o
            if (r0 == 0) goto L13
            r0 = r6
            p3.o r0 = (p3.o) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            p3.o r0 = new p3.o
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            p3.n r4 = r0.b
            kotlin.jvm.internal.v r5 = r0.f4488a
            kotlin.reflect.l.e0(r6)     // Catch: q3.C0784a -> L2b
            goto L59
        L2b:
            r6 = move-exception
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.reflect.l.e0(r6)
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            p3.n r2 = new p3.n
            r2.<init>(r5, r6)
            r0.f4488a = r6     // Catch: q3.C0784a -> L51
            r0.b = r2     // Catch: q3.C0784a -> L51
            r0.d = r3     // Catch: q3.C0784a -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: q3.C0784a -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r5 = r6
            goto L59
        L51:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L55:
            p3.n r0 = r6.f4650a
            if (r0 != r4) goto L5c
        L59:
            java.lang.Object r4 = r5.f3816a
            return r4
        L5c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.v.f(x1.d, x1.f, U1.c):java.lang.Object");
    }

    public static final Flow g(Flow flow, AbstractC0684s abstractC0684s) {
        if (abstractC0684s.get(Job.Key) == null) {
            return abstractC0684s.equals(S1.g.f1282a) ? flow : flow instanceof FusibleFlow ? AbstractC0786c.a((FusibleFlow) flow, abstractC0684s, 0, null, 6) : new q3.j(flow, abstractC0684s, -3, EnumC0743a.f4320a);
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + abstractC0684s).toString());
    }

    public static final Flow h(SharedFlow sharedFlow, CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        return ((i == 0 || i == -3) && enumC0743a == EnumC0743a.f4320a) ? sharedFlow : new q3.j(sharedFlow, coroutineContext, i, enumC0743a);
    }
}
