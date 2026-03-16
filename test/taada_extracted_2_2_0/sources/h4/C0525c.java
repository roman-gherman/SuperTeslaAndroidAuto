package h4;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;

/* JADX INFO: renamed from: h4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0525c implements PolynomialExtensionField {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3457a;
    public final C0524b b;

    public C0525c(d dVar, C0524b c0524b) {
        this.f3457a = dVar;
        this.b = c0524b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0525c)) {
            return false;
        }
        C0525c c0525c = (C0525c) obj;
        return this.f3457a.equals(c0525c.f3457a) && this.b.equals(c0525c.b);
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public final BigInteger getCharacteristic() {
        return this.f3457a.f3458a;
    }

    @Override // org.bouncycastle.math.field.ExtensionField
    public final int getDegree() {
        return this.b.getDegree();
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public final int getDimension() {
        this.f3457a.getClass();
        return this.b.getDegree();
    }

    @Override // org.bouncycastle.math.field.PolynomialExtensionField
    public final Polynomial getMinimalPolynomial() {
        return this.b;
    }

    @Override // org.bouncycastle.math.field.ExtensionField
    public final FiniteField getSubfield() {
        return this.f3457a;
    }

    public final int hashCode() {
        return this.f3457a.f3458a.hashCode() ^ Integer.rotateLeft(g5.c.l(this.b.f3456a), 16);
    }
}
