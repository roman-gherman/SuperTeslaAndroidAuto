package v0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class q extends D0.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f4919a;

    public q(f fVar) {
        this.f4919a = fVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q) && ((q) obj).f4919a == this.f4919a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f4919a);
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.f4919a + ")";
    }
}
