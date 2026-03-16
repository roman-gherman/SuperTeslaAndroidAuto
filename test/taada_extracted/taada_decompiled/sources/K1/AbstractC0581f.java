package k1;

import java.util.List;
import kotlin.collections.n;
import u1.r;

/* JADX INFO: renamed from: k1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0581f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f3696a;

    static {
        r rVar = r.b;
        f3696a = n.y(r.b, r.d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0089, code lost:
    
        if (io.ktor.utils.io.jvm.javaio.q.e(r8, r9, androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL, r0) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(v1.g r8, java.io.OutputStream r9, kotlin.coroutines.CoroutineContext r10, U1.c r11) {
        /*
            boolean r0 = r11 instanceof k1.C0579d
            if (r0 == 0) goto L13
            r0 = r11
            k1.d r0 = (k1.C0579d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            k1.d r0 = new k1.d
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.io.OutputStream r9 = r0.f3694a
            kotlin.reflect.l.e0(r11)     // Catch: java.lang.Throwable -> L2d
            goto L90
        L2d:
            r8 = move-exception
            goto Lba
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            java.io.OutputStream r9 = r0.f3694a
            kotlin.reflect.l.e0(r11)     // Catch: java.lang.Throwable -> L2d
            goto L69
        L3e:
            kotlin.reflect.l.e0(r11)
            boolean r11 = r8 instanceof v1.e     // Catch: java.lang.Throwable -> L2d
            if (r11 == 0) goto L4f
            v1.e r8 = (v1.e) r8     // Catch: java.lang.Throwable -> L2d
            byte[] r8 = r8.d()     // Catch: java.lang.Throwable -> L2d
            r9.write(r8)     // Catch: java.lang.Throwable -> L2d
            goto L90
        L4f:
            boolean r11 = r8 instanceof v1.f     // Catch: java.lang.Throwable -> L2d
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r11 == 0) goto L6f
            v1.f r8 = (v1.f) r8     // Catch: java.lang.Throwable -> L2d
            io.ktor.utils.io.ByteReadChannel r8 = r8.d()     // Catch: java.lang.Throwable -> L2d
            r0.f3694a = r9     // Catch: java.lang.Throwable -> L2d
            r0.c = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r11 = io.ktor.utils.io.jvm.javaio.q.e(r8, r9, r6, r0)     // Catch: java.lang.Throwable -> L2d
            if (r11 != r1) goto L69
            goto L8b
        L69:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch: java.lang.Throwable -> L2d
            r11.longValue()     // Catch: java.lang.Throwable -> L2d
            goto L90
        L6f:
            boolean r11 = r8 instanceof v1.i     // Catch: java.lang.Throwable -> L2d
            if (r11 == 0) goto L8c
            m3.V r11 = m3.V.f4114a     // Catch: java.lang.Throwable -> L2d
            k1.e r2 = new k1.e     // Catch: java.lang.Throwable -> L2d
            r2.<init>(r8, r5)     // Catch: java.lang.Throwable -> L2d
            r8 = 0
            io.ktor.utils.io.c0 r8 = io.ktor.utils.io.g0.b(r11, r10, r8, r2)     // Catch: java.lang.Throwable -> L2d
            io.ktor.utils.io.U r8 = r8.b     // Catch: java.lang.Throwable -> L2d
            r0.f3694a = r9     // Catch: java.lang.Throwable -> L2d
            r0.c = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r8 = io.ktor.utils.io.jvm.javaio.q.e(r8, r9, r6, r0)     // Catch: java.lang.Throwable -> L2d
            if (r8 != r1) goto L90
        L8b:
            return r1
        L8c:
            boolean r10 = r8 instanceof s1.C0810c     // Catch: java.lang.Throwable -> L2d
            if (r10 == 0) goto L96
        L90:
            C5.f.l(r9, r5)
            N1.m r8 = N1.m.f1129a
            return r8
        L96:
            com.google.android.gms.tasks.a r10 = new com.google.android.gms.tasks.a     // Catch: java.lang.Throwable -> L2d
            java.lang.String r11 = "content"
            kotlin.jvm.internal.h.f(r8, r11)     // Catch: java.lang.Throwable -> L2d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            java.lang.String r0 = "Failed to write body: "
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.Class r8 = r8.getClass()     // Catch: java.lang.Throwable -> L2d
            kotlin.jvm.internal.x r0 = kotlin.jvm.internal.w.f3817a     // Catch: java.lang.Throwable -> L2d
            kotlin.reflect.KClass r8 = r0.b(r8)     // Catch: java.lang.Throwable -> L2d
            r11.append(r8)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r8 = r11.toString()     // Catch: java.lang.Throwable -> L2d
            r11 = 1
            r10.<init>(r8, r11)     // Catch: java.lang.Throwable -> L2d
            throw r10     // Catch: java.lang.Throwable -> L2d
        Lba:
            throw r8     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            r10 = move-exception
            C5.f.l(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.AbstractC0581f.a(v1.g, java.io.OutputStream, kotlin.coroutines.CoroutineContext, U1.c):java.lang.Object");
    }
}
