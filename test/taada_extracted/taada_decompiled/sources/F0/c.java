package F0;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f346a;
    public final List b;
    public final Integer c;

    public c(a aVar, List list, Integer num) {
        this.f346a = aVar;
        this.b = list;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f346a.equals(cVar.f346a) && this.b.equals(cVar.b) && Objects.equals(this.c, cVar.c);
    }

    public final int hashCode() {
        return Objects.hash(this.f346a, this.b);
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.f346a, this.b, this.c);
    }
}
