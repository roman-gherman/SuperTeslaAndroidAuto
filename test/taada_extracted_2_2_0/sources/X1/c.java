package x1;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f5107a;
    public final /* synthetic */ Charset b;
    public final /* synthetic */ F1.a c;
    public final /* synthetic */ ByteReadChannel d;

    public c(FlowCollector flowCollector, Charset charset, F1.a aVar, ByteReadChannel byteReadChannel) {
        this.f5107a = flowCollector;
        this.b = charset;
        this.c = aVar;
        this.d = byteReadChannel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r8.emit(r9, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof x1.C0913b
            if (r0 == 0) goto L13
            r0 = r9
            x1.b r0 = (x1.C0913b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            x1.b r0 = new x1.b
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f5106a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.reflect.l.e0(r9)
            goto L5f
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlinx.coroutines.flow.FlowCollector r8 = r0.c
            kotlin.reflect.l.e0(r9)
            goto L53
        L38:
            kotlin.reflect.l.e0(r9)
            io.ktor.serialization.ContentConverter r8 = (io.ktor.serialization.ContentConverter) r8
            kotlinx.coroutines.flow.FlowCollector r9 = r7.f5107a
            r0.c = r9
            r0.b = r4
            F1.a r2 = r7.c
            io.ktor.utils.io.ByteReadChannel r4 = r7.d
            java.nio.charset.Charset r5 = r7.b
            java.lang.Object r8 = r8.deserialize(r5, r2, r4, r0)
            if (r8 != r1) goto L50
            goto L5e
        L50:
            r6 = r9
            r9 = r8
            r8 = r6
        L53:
            r2 = 0
            r0.c = r2
            r0.b = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L5f
        L5e:
            return r1
        L5f:
            N1.m r8 = N1.m.f1129a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.c.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
