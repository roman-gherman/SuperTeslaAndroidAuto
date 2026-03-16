package g1;

import D2.k;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.util.Attributes;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import m1.AbstractC0642k;
import m1.C0631A;
import m1.C0632a;
import m1.C0634c;
import m1.D;
import m1.G;
import m1.L;
import m1.x;
import m1.y;
import m3.d0;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import r1.C0793a;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements CoroutineScope, Closeable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3292l = AtomicIntegerFieldUpdater.newUpdater(f.class, "closed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpClientEngine f3293a;
    public final boolean b;
    public final d0 c;

    @NotNull
    private volatile /* synthetic */ int closed;
    public final CoroutineContext d;
    public final q1.e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0793a f3294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q1.e f3295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0793a f3296h;
    public final z1.f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v f3297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f3298k;

    public f(HttpClientEngine engine, h hVar) {
        int i = 1;
        int i3 = 0;
        kotlin.jvm.internal.h.f(engine, "engine");
        this.f3293a = engine;
        this.closed = 0;
        d0 d0Var = new d0((Job) engine.getCoroutineContext().get(Job.Key));
        this.c = d0Var;
        this.d = engine.getCoroutineContext().plus(d0Var);
        this.e = new q1.e(0, hVar.f3302g);
        this.f3294f = new C0793a(1, hVar.f3302g);
        q1.e eVar = new q1.e(1, hVar.f3302g);
        this.f3295g = eVar;
        this.f3296h = new C0793a(0, hVar.f3302g);
        this.i = new z1.f();
        engine.getConfig();
        this.f3297j = new v(5);
        h hVar2 = new h();
        this.f3298k = hVar2;
        if (this.b) {
            d0Var.invokeOnCompletion(new C0477a(this));
        }
        engine.install(this);
        Continuation continuation = null;
        eVar.f(q1.e.f4525p, new C0478b(this, continuation, i3));
        C0632a c0632a = G.f4037a;
        c cVar = c.d;
        hVar2.a(c0632a, cVar);
        hVar2.a(C0634c.f4049a, cVar);
        if (hVar.f3301f) {
            c block = c.b;
            kotlin.jvm.internal.h.f(block, "block");
            hVar2.c.put("DefaultTransformers", block);
        }
        hVar2.a(L.b, cVar);
        C0632a c0632a2 = m1.v.d;
        hVar2.a(c0632a2, cVar);
        if (hVar.e) {
            hVar2.a(D.f4034a, cVar);
        }
        hVar2.e = hVar.e;
        hVar2.f3301f = hVar.f3301f;
        hVar2.f3300a.putAll(hVar.f3300a);
        hVar2.b.putAll(hVar.b);
        hVar2.c.putAll(hVar.c);
        if (hVar.f3301f) {
            hVar2.a(C0631A.d, cVar);
        }
        z1.a aVar = AbstractC0642k.f4056a;
        k kVar = new k(hVar2, i);
        Logger logger = x.f4069a;
        hVar2.a(c0632a2, kVar);
        Iterator it = hVar2.f3300a.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this);
        }
        Iterator it2 = hVar2.c.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(this);
        }
        this.f3294f.f(C0793a.f4682j, new d(this, continuation, i3));
        this.b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(q1.c r5, U1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof g1.e
            if (r0 == 0) goto L13
            r0 = r6
            g1.e r0 = (g1.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            g1.e r0 = new g1.e
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f3291a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r6)
            goto L46
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.reflect.l.e0(r6)
            z.e r6 = s1.AbstractC0809b.f4764a
            kotlin.reflect.jvm.internal.impl.protobuf.v r2 = r4.f3297j
            r2.d(r6)
            java.lang.Object r6 = r5.d
            r0.c = r3
            q1.e r2 = r4.e
            java.lang.Object r6 = r2.a(r5, r6, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.lang.String r5 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.h.d(r6, r5)
            h1.b r6 = (h1.C0494b) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.f.a(q1.c, U1.c):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IllegalAccessException, IOException, InvocationTargetException {
        if (f3292l.compareAndSet(this, 0, 1)) {
            Attributes attributes = (Attributes) this.i.get(y.f4070a);
            for (z1.a aVar : attributes.getAllKeys()) {
                kotlin.jvm.internal.h.d(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object obj = attributes.get(aVar);
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                }
            }
            this.c.complete();
            if (this.b) {
                this.f3293a.close();
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.d;
    }

    public final String toString() {
        return "HttpClient[" + this.f3293a + ']';
    }
}
