package m1;

import h1.C0494b;
import io.ktor.client.plugins.Sender;

/* JADX INFO: loaded from: classes2.dex */
public final class J implements Sender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1.f f4041a;
    public int b;
    public C0494b c;

    public J(g1.f fVar) {
        this.f4041a = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.Sender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(q1.c r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof m1.I
            if (r0 == 0) goto L13
            r0 = r7
            m1.I r0 = (m1.I) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            m1.I r0 = new m1.I
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            m1.J r6 = r0.f4040a
            kotlin.reflect.l.e0(r7)
            goto L57
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.reflect.l.e0(r7)
            h1.b r7 = r5.c
            if (r7 == 0) goto L3c
            m3.AbstractC0689x.b(r7, r3)
        L3c:
            int r7 = r5.b
            r2 = 20
            if (r7 >= r2) goto L7b
            int r7 = r7 + r4
            r5.b = r7
            g1.f r7 = r5.f4041a
            java.lang.Object r2 = r6.d
            r0.f4040a = r5
            r0.d = r4
            q1.e r7 = r7.f3296g
            java.lang.Object r7 = r7.a(r6, r2, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r6 = r5
        L57:
            boolean r0 = r7 instanceof h1.C0494b
            if (r0 == 0) goto L5e
            r3 = r7
            h1.b r3 = (h1.C0494b) r3
        L5e:
            if (r3 == 0) goto L63
            r6.c = r3
            return r3
        L63:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L7b:
            com.google.android.gms.tasks.a r6 = new com.google.android.gms.tasks.a
            java.lang.String r7 = "Max send count 20 exceeded. Consider increasing the property maxSendCount if more is required."
            r0 = 4
            r6.<init>(r7, r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.J.execute(q1.c, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
