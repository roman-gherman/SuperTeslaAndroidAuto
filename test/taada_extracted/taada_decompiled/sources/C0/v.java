package C0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f158a;
    public final Class b;

    public v(Class cls, Class cls2) {
        this.f158a = cls;
        this.b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return vVar.f158a.equals(this.f158a) && vVar.b.equals(this.b);
    }

    public final int hashCode() {
        return Objects.hash(this.f158a, this.b);
    }

    public final String toString() {
        return this.f158a.getSimpleName() + " with serialization type: " + this.b.getSimpleName();
    }
}
