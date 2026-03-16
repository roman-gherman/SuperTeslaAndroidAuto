package u1;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4865a;
    public final List b;
    public final double c;

    public i(String value, List params) {
        Double d;
        Object next;
        String str;
        Double dU;
        kotlin.jvm.internal.h.f(value, "value");
        kotlin.jvm.internal.h.f(params, "params");
        this.f4865a = value;
        this.b = params;
        Iterator it = params.iterator();
        while (true) {
            d = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (kotlin.jvm.internal.h.a(((j) next).f4866a, "q")) {
                    break;
                }
            }
        }
        j jVar = (j) next;
        double dDoubleValue = 1.0d;
        if (jVar != null && (str = jVar.b) != null && (dU = kotlin.text.p.u(str)) != null) {
            double dDoubleValue2 = dU.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                d = dU;
            }
            if (d != null) {
                dDoubleValue = d.doubleValue();
            }
        }
        this.c = dDoubleValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.h.a(this.f4865a, iVar.f4865a) && kotlin.jvm.internal.h.a(this.b, iVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4865a.hashCode() * 31);
    }

    public final String toString() {
        return "HeaderValue(value=" + this.f4865a + ", params=" + this.b + ')';
    }
}
