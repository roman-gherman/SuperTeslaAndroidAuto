package p3;

import java.util.List;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f4481a;

    public h(List list) {
        this.f4481a = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p3.g
            if (r0 == 0) goto L13
            r0 = r7
            p3.g r0 = (p3.g) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            p3.g r0 = new p3.g
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4480a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.util.Iterator r6 = r0.e
            kotlinx.coroutines.flow.FlowCollector r2 = r0.d
            kotlin.reflect.l.e0(r7)
            r7 = r2
            goto L40
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.reflect.l.e0(r7)
            java.util.List r7 = r5.f4481a
            java.util.Iterator r7 = r7.iterator()
            r4 = r7
            r7 = r6
            r6 = r4
        L40:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L57
            java.lang.Object r2 = r6.next()
            r0.d = r7
            r0.e = r6
            r0.b = r3
            java.lang.Object r2 = r7.emit(r2, r0)
            if (r2 != r1) goto L40
            return r1
        L57:
            N1.m r6 = N1.m.f1129a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.h.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
