package y1;

import com.google.gson.m;
import io.ktor.serialization.ContentConverter;
import io.ktor.utils.io.internal.t;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.flow.Flow;
import u1.C0840e;
import v1.i;
import v1.j;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements ContentConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f5134a;

    public g(m mVar) {
        this.f5134a = mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(y1.g r4, kotlinx.coroutines.flow.Flow r5, java.io.OutputStreamWriter r6, U1.c r7) throws java.io.IOException {
        /*
            boolean r0 = r7 instanceof y1.e
            if (r0 == 0) goto L13
            r0 = r7
            y1.e r0 = (y1.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            y1.e r0 = new y1.e
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.io.Writer r6 = r0.f5132a
            kotlin.reflect.l.e0(r7)
            goto L49
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.reflect.l.e0(r7)
            r7 = 91
            r6.write(r7)
            y1.d r7 = new y1.d
            r7.<init>(r6, r4)
            r0.f5132a = r6
            r0.d = r3
            java.lang.Object r4 = r5.collect(r7, r0)
            if (r4 != r1) goto L49
            return r1
        L49:
            r4 = 93
            r6.write(r4)
            r6.flush()
            N1.m r4 = N1.m.f1129a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.g.a(y1.g, kotlinx.coroutines.flow.Flow, java.io.OutputStreamWriter, U1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deserialize(java.nio.charset.Charset r11, F1.a r12, io.ktor.utils.io.ByteReadChannel r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof y1.C0930b
            if (r0 == 0) goto L13
            r0 = r14
            y1.b r0 = (y1.C0930b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            y1.b r0 = new y1.b
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f5129a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.reflect.l.e0(r14)     // Catch: com.google.gson.w -> L27
            return r14
        L27:
            r0 = move-exception
            r11 = r0
            goto L6a
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L32:
            kotlin.reflect.l.e0(r14)
            kotlin.reflect.KClass r14 = r12.f347a
            com.google.gson.m r2 = r10.f5134a
            java.lang.String r4 = "type"
            kotlin.jvm.internal.h.f(r14, r4)
            java.lang.Class r14 = E1.k.H(r14)
            com.google.gson.internal.h r2 = r2.f3022f
            r2.getClass()
            boolean r4 = com.google.gson.internal.h.b(r14)
            if (r4 != 0) goto L87
            r4 = 0
            boolean r14 = r2.a(r14, r4)
            if (r14 != 0) goto L87
            t3.c r14 = m3.G.c     // Catch: com.google.gson.w -> L27
            y1.c r4 = new y1.c     // Catch: com.google.gson.w -> L27
            r9 = 0
            r7 = r10
            r6 = r11
            r8 = r12
            r5 = r13
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: com.google.gson.w -> L27
            r0.c = r3     // Catch: com.google.gson.w -> L27
            java.lang.Object r11 = m3.AbstractC0690y.m(r14, r4, r0)     // Catch: com.google.gson.w -> L27
            if (r11 != r1) goto L69
            return r1
        L69:
            return r11
        L6a:
            x1.g r12 = new x1.g
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Illegal json parameter found: "
            r13.<init>(r14)
            java.lang.String r14 = r11.getMessage()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "message"
            kotlin.jvm.internal.h.f(r13, r14)
            r12.<init>(r13, r11)
            throw r12
        L87:
            r8 = r12
            y1.a r11 = new y1.a
            kotlin.reflect.KClass r12 = r8.f347a
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.g.deserialize(java.nio.charset.Charset, F1.a, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.serialization.ContentConverter
    public final Object serialize(C0840e c0840e, Charset charset, F1.a aVar, Object obj, Continuation continuation) {
        return serializeNullable(c0840e, charset, aVar, obj, continuation);
    }

    @Override // io.ktor.serialization.ContentConverter
    public final Object serializeNullable(C0840e c0840e, Charset charset, F1.a aVar, Object obj, Continuation continuation) {
        if (h.a(aVar.f347a, w.f3817a.b(Flow.class))) {
            return new i(new f(charset, this, obj, null), t.t(c0840e, charset));
        }
        String strH = this.f5134a.h(obj);
        h.e(strH, "gson.toJson(value)");
        return new j(strH, t.t(c0840e, charset));
    }
}
