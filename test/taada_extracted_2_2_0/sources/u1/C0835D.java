package u1;

import a.AbstractC0132a;
import io.ktor.http.Parameters;
import java.util.ArrayList;

/* JADX INFO: renamed from: u1.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0835D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0832A f4849a;
    public final String b;
    public final int c;
    public final ArrayList d;
    public final Parameters e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4852h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final N1.j f4853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final N1.j f4854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final N1.j f4855l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final N1.j f4856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final N1.j f4857n;

    public C0835D(C0832A protocol, String host, int i, ArrayList arrayList, Parameters parameters, String fragment, String str, String str2, boolean z6, String str3) {
        kotlin.jvm.internal.h.f(protocol, "protocol");
        kotlin.jvm.internal.h.f(host, "host");
        kotlin.jvm.internal.h.f(parameters, "parameters");
        kotlin.jvm.internal.h.f(fragment, "fragment");
        this.f4849a = protocol;
        this.b = host;
        this.c = i;
        this.d = arrayList;
        this.e = parameters;
        this.f4850f = str;
        this.f4851g = str2;
        this.f4852h = z6;
        this.i = str3;
        if ((i < 0 || i >= 65536) && i != 0) {
            throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set");
        }
        this.f4853j = AbstractC0132a.M(new C0834C(this, 2));
        this.f4854k = AbstractC0132a.M(new C0834C(this, 4));
        AbstractC0132a.M(new C0834C(this, 3));
        this.f4855l = AbstractC0132a.M(new C0834C(this, 5));
        this.f4856m = AbstractC0132a.M(new C0834C(this, 1));
        this.f4857n = AbstractC0132a.M(new C0834C(this, 0));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C0835D.class == obj.getClass() && kotlin.jvm.internal.h.a(this.i, ((C0835D) obj).i);
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    public final String toString() {
        return this.i;
    }
}
