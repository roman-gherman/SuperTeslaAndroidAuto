package p3;

import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements Flow, CancellableFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U1.g f4492a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function2 function2) {
        this.f4492a = (U1.g) function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v3, types: [U1.g, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof p3.C0759a
            if (r0 == 0) goto L13
            r0 = r8
            p3.a r0 = (p3.C0759a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            p3.a r0 = new p3.a
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            q3.s r7 = r0.f4475a
            kotlin.reflect.l.e0(r8)     // Catch: java.lang.Throwable -> L2b
            goto L53
        L2b:
            r8 = move-exception
            goto L5d
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.reflect.l.e0(r8)
            q3.s r8 = new q3.s
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            r8.<init>(r7, r2)
            r0.f4475a = r8     // Catch: java.lang.Throwable -> L5b
            r0.d = r4     // Catch: java.lang.Throwable -> L5b
            U1.g r7 = r6.f4492a     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r7 = r7.mo5invoke(r8, r0)     // Catch: java.lang.Throwable -> L5b
            if (r7 != r1) goto L4e
            goto L4f
        L4e:
            r7 = r3
        L4f:
            if (r7 != r1) goto L52
            return r1
        L52:
            r7 = r8
        L53:
            r7.releaseIntercepted()
            return r3
        L57:
            r5 = r8
            r8 = r7
            r7 = r5
            goto L5d
        L5b:
            r7 = move-exception
            goto L57
        L5d:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.r.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
