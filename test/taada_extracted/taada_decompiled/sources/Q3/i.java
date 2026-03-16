package q3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import o3.EnumC0743a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends g {
    public final Flow d;

    public i(Flow flow, CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        super(coroutineContext, i, enumC0743a);
        this.d = flow;
    }

    @Override // q3.g
    public final Object a(ProducerScope producerScope, Continuation continuation) {
        Object objCollect = ((j) this).d.collect(new w(producerScope), continuation);
        T1.a aVar = T1.a.f1304a;
        N1.m mVar = N1.m.f1129a;
        if (objCollect != aVar) {
            objCollect = mVar;
        }
        return objCollect == aVar ? objCollect : mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    @Override // q3.g, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            T1.a r0 = T1.a.f1304a
            N1.m r1 = N1.m.f1129a
            int r2 = r6.b
            r3 = -3
            if (r2 != r3) goto L5d
            kotlin.coroutines.CoroutineContext r2 = r8.getContext()
            kotlin.coroutines.CoroutineContext r3 = r6.f4655a
            kotlin.coroutines.CoroutineContext r3 = r2.plus(r3)
            boolean r4 = kotlin.jvm.internal.h.a(r3, r2)
            if (r4 == 0) goto L29
            r2 = r6
            q3.j r2 = (q3.j) r2
            kotlinx.coroutines.flow.Flow r2 = r2.d
            java.lang.Object r7 = r2.collect(r7, r8)
            if (r7 != r0) goto L25
            goto L26
        L25:
            r7 = r1
        L26:
            if (r7 != r0) goto L64
            return r7
        L29:
            S1.f r4 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Element r5 = r3.get(r4)
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r4)
            boolean r2 = kotlin.jvm.internal.h.a(r5, r2)
            if (r2 == 0) goto L5d
            kotlin.coroutines.CoroutineContext r2 = r8.getContext()
            boolean r4 = r7 instanceof q3.w
            if (r4 == 0) goto L42
            goto L48
        L42:
            p3.e r4 = new p3.e
            r4.<init>(r7, r2)
            r7 = r4
        L48:
            q3.h r2 = new q3.h
            r4 = 0
            r2.<init>(r6, r4)
            java.lang.Object r4 = r3.AbstractC0797A.b(r3)
            java.lang.Object r7 = q3.AbstractC0786c.b(r3, r7, r4, r2, r8)
            if (r7 != r0) goto L59
            goto L5a
        L59:
            r7 = r1
        L5a:
            if (r7 != r0) goto L64
            return r7
        L5d:
            java.lang.Object r7 = super.collect(r7, r8)
            if (r7 != r0) goto L64
            return r7
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.i.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // q3.g
    public final String toString() {
        return this.d + " -> " + super.toString();
    }
}
