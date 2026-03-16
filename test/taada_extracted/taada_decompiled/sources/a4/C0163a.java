package a4;

import c4.AbstractC0243a;
import c4.j;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: renamed from: a4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0163a implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0243a f1561a;
    public j b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0163a)) {
            return false;
        }
        C0163a c0163a = (C0163a) obj;
        return this.f1561a.e(c0163a.f1561a) && this.b.a(c0163a.b);
    }

    public final int hashCode() {
        return this.f1561a.hashCode() ^ this.b.hashCode();
    }
}
