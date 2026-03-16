package M0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class j extends com.google.gson.stream.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final i f999p = new i();
    public static final com.google.gson.v q = new com.google.gson.v("closed");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f1000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f1001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.google.gson.p f1002o;

    public j() {
        super(f999p);
        this.f1000m = new ArrayList();
        this.f1002o = com.google.gson.r.f3040a;
    }

    @Override // com.google.gson.stream.c
    public final void b() {
        com.google.gson.o oVar = new com.google.gson.o();
        u(oVar);
        this.f1000m.add(oVar);
    }

    @Override // com.google.gson.stream.c
    public final void c() {
        com.google.gson.s sVar = new com.google.gson.s();
        u(sVar);
        this.f1000m.add(sVar);
    }

    @Override // com.google.gson.stream.c, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.f1000m;
        if (!arrayList.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList.add(q);
    }

    @Override // com.google.gson.stream.c
    public final void e() {
        ArrayList arrayList = this.f1000m;
        if (arrayList.isEmpty() || this.f1001n != null) {
            throw new IllegalStateException();
        }
        if (!(t() instanceof com.google.gson.o)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // com.google.gson.stream.c
    public final void f() {
        ArrayList arrayList = this.f1000m;
        if (arrayList.isEmpty() || this.f1001n != null) {
            throw new IllegalStateException();
        }
        if (!(t() instanceof com.google.gson.s)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // com.google.gson.stream.c, java.io.Flushable
    public final void flush() {
    }

    @Override // com.google.gson.stream.c
    public final void g(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f1000m.isEmpty() || this.f1001n != null) {
            throw new IllegalStateException();
        }
        if (!(t() instanceof com.google.gson.s)) {
            throw new IllegalStateException();
        }
        this.f1001n = str;
    }

    @Override // com.google.gson.stream.c
    public final com.google.gson.stream.c i() {
        u(com.google.gson.r.f3040a);
        return this;
    }

    @Override // com.google.gson.stream.c
    public final void l(double d) {
        if (this.f3058f || !(Double.isNaN(d) || Double.isInfinite(d))) {
            u(new com.google.gson.v(Double.valueOf(d)));
        } else {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
        }
    }

    @Override // com.google.gson.stream.c
    public final void m(long j6) {
        u(new com.google.gson.v(Long.valueOf(j6)));
    }

    @Override // com.google.gson.stream.c
    public final void n(Boolean bool) {
        if (bool == null) {
            u(com.google.gson.r.f3040a);
        } else {
            u(new com.google.gson.v(bool));
        }
    }

    @Override // com.google.gson.stream.c
    public final void o(Number number) {
        if (number == null) {
            u(com.google.gson.r.f3040a);
            return;
        }
        if (!this.f3058f) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        u(new com.google.gson.v(number));
    }

    @Override // com.google.gson.stream.c
    public final void p(String str) {
        if (str == null) {
            u(com.google.gson.r.f3040a);
        } else {
            u(new com.google.gson.v(str));
        }
    }

    @Override // com.google.gson.stream.c
    public final void q(boolean z6) {
        u(new com.google.gson.v(Boolean.valueOf(z6)));
    }

    public final com.google.gson.p s() {
        ArrayList arrayList = this.f1000m;
        if (arrayList.isEmpty()) {
            return this.f1002o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + arrayList);
    }

    public final com.google.gson.p t() {
        return (com.google.gson.p) androidx.constraintlayout.core.motion.a.g(1, this.f1000m);
    }

    public final void u(com.google.gson.p pVar) {
        if (this.f1001n != null) {
            if (!(pVar instanceof com.google.gson.r) || this.i) {
                com.google.gson.s sVar = (com.google.gson.s) t();
                sVar.f3042a.put(this.f1001n, pVar);
            }
            this.f1001n = null;
            return;
        }
        if (this.f1000m.isEmpty()) {
            this.f1002o = pVar;
            return;
        }
        com.google.gson.p pVarT = t();
        if (!(pVarT instanceof com.google.gson.o)) {
            throw new IllegalStateException();
        }
        ((com.google.gson.o) pVarT).f3039a.add(pVar);
    }
}
