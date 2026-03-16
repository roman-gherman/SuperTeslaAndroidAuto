package C0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f151a;
    public final Class b;

    public p(Class cls, Class cls2) {
        this.f151a = cls;
        this.b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return pVar.f151a.equals(this.f151a) && pVar.b.equals(this.b);
    }

    public final int hashCode() {
        return Objects.hash(this.f151a, this.b);
    }

    public final String toString() {
        return this.f151a.getSimpleName() + " with primitive type: " + this.b.getSimpleName();
    }
}
