package m1;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.g0;
import java.io.InputStream;
import java.util.List;
import m3.V;
import u1.AbstractC0838c;
import u1.C0840e;

/* JADX INFO: renamed from: m1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0644m extends v1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4058a = 0;
    public final Long b;
    public final C0840e c;
    public final /* synthetic */ Object d;

    public C0644m(E1.f fVar, C0840e c0840e, Object obj) {
        this.d = obj;
        u1.m mVar = ((q1.c) fVar.f289a).c;
        List list = u1.q.f4869a;
        String str = mVar.get("Content-Length");
        this.b = str != null ? Long.valueOf(Long.parseLong(str)) : null;
        if (c0840e == null) {
            C0840e c0840e2 = AbstractC0838c.f4859a;
            c0840e = AbstractC0838c.b;
        }
        this.c = c0840e;
    }

    @Override // v1.g
    public final Long a() {
        switch (this.f4058a) {
        }
        return this.b;
    }

    @Override // v1.g
    public final C0840e b() {
        switch (this.f4058a) {
        }
        return this.c;
    }

    @Override // v1.f
    public final ByteReadChannel d() {
        switch (this.f4058a) {
            case 0:
                return (ByteReadChannel) this.d;
            default:
                InputStream inputStream = (InputStream) this.d;
                t3.c context = m3.G.c;
                K1.a pool = K1.b.f930a;
                kotlin.jvm.internal.h.f(inputStream, "<this>");
                kotlin.jvm.internal.h.f(context, "context");
                kotlin.jvm.internal.h.f(pool, "pool");
                return g0.b(V.f4114a, context, true, new io.ktor.utils.io.jvm.javaio.n(pool, inputStream, null)).b;
        }
    }

    public C0644m(q1.c cVar, C0840e c0840e, Object obj) {
        this.d = obj;
        u1.m mVar = cVar.c;
        List list = u1.q.f4869a;
        String str = mVar.get("Content-Length");
        this.b = str != null ? Long.valueOf(Long.parseLong(str)) : null;
        if (c0840e == null) {
            C0840e c0840e2 = AbstractC0838c.f4859a;
            c0840e = AbstractC0838c.b;
        }
        this.c = c0840e;
    }
}
