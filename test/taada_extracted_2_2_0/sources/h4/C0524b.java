package h4;

import java.util.Arrays;
import org.bouncycastle.math.field.Polynomial;

/* JADX INFO: renamed from: h4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0524b implements Polynomial {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f3456a;

    public C0524b(int[] iArr) {
        this.f3456a = (int[]) iArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0524b)) {
            return false;
        }
        return Arrays.equals(this.f3456a, ((C0524b) obj).f3456a);
    }

    @Override // org.bouncycastle.math.field.Polynomial
    public final int getDegree() {
        return this.f3456a[r0.length - 1];
    }

    @Override // org.bouncycastle.math.field.Polynomial
    public final int[] getExponentsPresent() {
        int[] iArr = this.f3456a;
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public final int hashCode() {
        return g5.c.l(this.f3456a);
    }
}
