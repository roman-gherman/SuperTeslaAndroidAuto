package v0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class u extends D0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f4922a;

    public u(f fVar) {
        this.f4922a = fVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).f4922a == this.f4922a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f4922a);
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.f4922a + ")";
    }
}
