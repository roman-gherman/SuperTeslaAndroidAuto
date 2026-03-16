package C0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f157a;
    public final I0.a b;

    public u(Class cls, I0.a aVar) {
        this.f157a = cls;
        this.b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return uVar.f157a.equals(this.f157a) && uVar.b.equals(this.b);
    }

    public final int hashCode() {
        return Objects.hash(this.f157a, this.b);
    }

    public final String toString() {
        return this.f157a.getSimpleName() + ", object identifier: " + this.b;
    }
}
