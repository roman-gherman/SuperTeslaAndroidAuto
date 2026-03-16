package r1;

import io.ktor.client.plugins.HttpClientPlugin;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import m1.y;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1.c f4694a;
    public final g1.f b;

    public j(q1.c cVar, g1.f client) {
        Set setKeySet;
        kotlin.jvm.internal.h.f(client, "client");
        this.f4694a = cVar;
        this.b = client;
        Map map = (Map) cVar.f4513f.getOrNull(j1.f.f3651a);
        if (map == null || (setKeySet = map.keySet()) == null) {
            return;
        }
        ArrayList<HttpClientPlugin> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof HttpClientPlugin) {
                arrayList.add(obj);
            }
        }
        for (HttpClientPlugin httpClientPlugin : arrayList) {
            if (y.b(this.b, httpClientPlugin) == null) {
                throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(r1.b r5, U1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof r1.f
            if (r0 == 0) goto L13
            r0 = r6
            r1.f r0 = (r1.f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            r1.f r0 = new r1.f
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r6)
            goto L5c
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.reflect.l.e0(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            m3.a0 r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlin.jvm.internal.h.c(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.a()     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.h.f(r5, r2)     // Catch: java.lang.Throwable -> L51
            r2 = 0
            r5.cancel(r2)     // Catch: java.lang.Throwable -> L51
        L51:
            r0.f4690a = r6
            r0.d = r3
            java.lang.Object r5 = r6.join(r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            N1.m r5 = N1.m.f1129a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.j.a(r1.b, U1.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:57|(1:(1:(1:(1:(2:14|15)(3:16|17|50))(3:21|22|23))(5:24|53|25|42|(2:44|49)(1:45)))(2:29|30))(3:32|33|(2:35|49)(1:36))|37|55|38|(3:41|42|(0)(0))|49) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
    
        if (r2.a(r11, r0) == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(r1.h r10, U1.c r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof r1.g
            if (r0 == 0) goto L13
            r0 = r11
            r1.g r0 = (r1.g) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            r1.g r0 = new r1.g
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.c
            T1.a r1 = T1.a.f1304a
            int r2 = r0.e
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L64
            if (r2 == r7) goto L58
            if (r2 == r6) goto L47
            if (r2 == r5) goto L41
            if (r2 == r4) goto L35
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            java.lang.Object r10 = r0.f4691a
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.reflect.l.e0(r11)     // Catch: java.util.concurrent.CancellationException -> L3e
            goto La3
        L3e:
            r10 = move-exception
            goto La4
        L41:
            java.lang.Object r10 = r0.f4691a
            kotlin.reflect.l.e0(r11)     // Catch: java.util.concurrent.CancellationException -> L3e
            return r10
        L47:
            java.lang.Object r10 = r0.b
            r1.b r10 = (r1.b) r10
            java.lang.Object r2 = r0.f4691a
            r1.j r2 = (r1.j) r2
            kotlin.reflect.l.e0(r11)     // Catch: java.lang.Throwable -> L53
            goto L87
        L53:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L96
        L58:
            java.lang.Object r10 = r0.b
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r2 = r0.f4691a
            r1.j r2 = (r1.j) r2
            kotlin.reflect.l.e0(r11)     // Catch: java.util.concurrent.CancellationException -> L3e
            goto L75
        L64:
            kotlin.reflect.l.e0(r11)
            r0.f4691a = r9     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.b = r10     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.e = r7     // Catch: java.util.concurrent.CancellationException -> L3e
            java.lang.Object r11 = r9.c(r0)     // Catch: java.util.concurrent.CancellationException -> L3e
            if (r11 != r1) goto L74
            goto La2
        L74:
            r2 = r9
        L75:
            r1.b r11 = (r1.b) r11     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.f4691a = r2     // Catch: java.lang.Throwable -> L95
            r0.b = r11     // Catch: java.lang.Throwable -> L95
            r0.e = r6     // Catch: java.lang.Throwable -> L95
            java.lang.Object r10 = r10.mo5invoke(r11, r0)     // Catch: java.lang.Throwable -> L95
            if (r10 != r1) goto L84
            goto La2
        L84:
            r8 = r11
            r11 = r10
            r10 = r8
        L87:
            r0.f4691a = r11     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.b = r3     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.e = r5     // Catch: java.util.concurrent.CancellationException -> L3e
            java.lang.Object r10 = r2.a(r10, r0)     // Catch: java.util.concurrent.CancellationException -> L3e
            if (r10 != r1) goto L94
            goto La2
        L94:
            return r11
        L95:
            r10 = move-exception
        L96:
            r0.f4691a = r10     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.b = r3     // Catch: java.util.concurrent.CancellationException -> L3e
            r0.e = r4     // Catch: java.util.concurrent.CancellationException -> L3e
            java.lang.Object r11 = r2.a(r11, r0)     // Catch: java.util.concurrent.CancellationException -> L3e
            if (r11 != r1) goto La3
        La2:
            return r1
        La3:
            throw r10     // Catch: java.util.concurrent.CancellationException -> L3e
        La4:
            java.lang.Throwable r10 = s1.AbstractC0809b.b(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.j.b(r1.h, U1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(U1.c r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof r1.i
            if (r0 == 0) goto L13
            r0 = r5
            r1.i r0 = (r1.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            r1.i r0 = new r1.i
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f4693a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.reflect.l.e0(r5)     // Catch: java.util.concurrent.CancellationException -> L27
            goto L49
        L27:
            r5 = move-exception
            goto L50
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.reflect.l.e0(r5)
            q1.c r5 = new q1.c     // Catch: java.util.concurrent.CancellationException -> L27
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L27
            q1.c r2 = r4.f4694a     // Catch: java.util.concurrent.CancellationException -> L27
            r5.b(r2)     // Catch: java.util.concurrent.CancellationException -> L27
            g1.f r2 = r4.b     // Catch: java.util.concurrent.CancellationException -> L27
            r0.c = r3     // Catch: java.util.concurrent.CancellationException -> L27
            java.lang.Object r5 = r2.a(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L27
            if (r5 != r1) goto L49
            return r1
        L49:
            h1.b r5 = (h1.C0494b) r5     // Catch: java.util.concurrent.CancellationException -> L27
            r1.b r5 = r5.d()     // Catch: java.util.concurrent.CancellationException -> L27
            return r5
        L50:
            java.lang.Throwable r5 = s1.AbstractC0809b.b(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.j.c(U1.c):java.lang.Object");
    }

    public final String toString() {
        return "HttpStatement[" + this.f4694a.f4512a + ']';
    }
}
