package p3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import o3.EnumC0743a;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends q3.g {
    public final U1.g d;
    public final U1.g e;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2 function2, CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        super(coroutineContext, i, enumC0743a);
        U1.g gVar = (U1.g) function2;
        this.d = gVar;
        this.e = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v3, types: [U1.g, kotlin.jvm.functions.Function2] */
    @Override // q3.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlinx.coroutines.channels.ProducerScope r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p3.b
            if (r0 == 0) goto L13
            r0 = r7
            p3.b r0 = (p3.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L1a
        L13:
            p3.b r0 = new p3.b
            U1.c r7 = (U1.c) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            N1.m r3 = N1.m.f1129a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            kotlinx.coroutines.channels.ProducerScope r6 = r0.f4475a
            kotlin.reflect.l.e0(r7)
            goto L49
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.reflect.l.e0(r7)
            r0.f4475a = r6
            r0.d = r4
            U1.g r7 = r5.d
            java.lang.Object r7 = r7.mo5invoke(r6, r0)
            if (r7 != r1) goto L45
            goto L46
        L45:
            r7 = r3
        L46:
            if (r7 != r1) goto L49
            return r1
        L49:
            boolean r6 = r6.isClosedForSend()
            if (r6 == 0) goto L50
            return r3
        L50:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.c.a(kotlinx.coroutines.channels.ProducerScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [U1.g, kotlin.jvm.functions.Function2] */
    @Override // q3.g
    public final q3.g b(CoroutineContext coroutineContext, int i, EnumC0743a enumC0743a) {
        return new c(this.e, coroutineContext, i, enumC0743a);
    }

    @Override // q3.g
    public final String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }
}
