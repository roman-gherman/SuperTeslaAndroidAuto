package q1;

import io.ktor.http.HttpMessageBuilder;
import io.ktor.utils.io.jvm.javaio.q;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CompletableJob;
import m3.AbstractC0690y;
import s1.C0810c;
import u1.m;
import u1.r;
import u1.y;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements HttpMessageBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f4512a = new y();
    public r b = r.b;
    public final m c = new m();
    public Object d = C0810c.f4765a;
    public CompletableJob e = AbstractC0690y.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z1.f f4513f = new z1.f();

    public final void a(F1.a aVar) {
        z1.f fVar = this.f4513f;
        if (aVar != null) {
            fVar.put(g.f4530a, aVar);
        } else {
            fVar.remove(g.f4530a);
        }
    }

    public final void b(c builder) {
        h.f(builder, "builder");
        this.e = builder.e;
        this.b = builder.b;
        this.d = builder.d;
        z1.a aVar = g.f4530a;
        z1.f other = builder.f4513f;
        a((F1.a) other.getOrNull(aVar));
        y yVar = builder.f4512a;
        y yVar2 = this.f4512a;
        q.q(yVar2, yVar);
        List list = yVar2.f4881h;
        h.f(list, "<set-?>");
        yVar2.f4881h = list;
        q.b(this.c, builder.c);
        z1.f fVar = this.f4513f;
        h.f(fVar, "<this>");
        h.f(other, "other");
        for (z1.a aVar2 : other.getAllKeys()) {
            h.d(aVar2, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            fVar.put(aVar2, other.get(aVar2));
        }
    }

    @Override // io.ktor.http.HttpMessageBuilder
    public final m getHeaders() {
        return this.c;
    }
}
