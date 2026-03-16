package r1;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F1.a f4689a;
    public final Object b;

    public c(F1.a expectedType, Object response) {
        kotlin.jvm.internal.h.f(expectedType, "expectedType");
        kotlin.jvm.internal.h.f(response, "response");
        this.f4689a = expectedType;
        this.b = response;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.h.a(this.f4689a, cVar.f4689a) && kotlin.jvm.internal.h.a(this.b, cVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4689a.hashCode() * 31);
    }

    public final String toString() {
        return "HttpResponseContainer(expectedType=" + this.f4689a + ", response=" + this.b + ')';
    }
}
