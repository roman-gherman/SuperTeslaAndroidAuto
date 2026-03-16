package h4;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements FiniteField {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f3457a;

    public d(BigInteger bigInteger) {
        this.f3457a = bigInteger;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.f3457a.equals(((d) obj).f3457a);
        }
        return false;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public final BigInteger getCharacteristic() {
        return this.f3457a;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    public final int getDimension() {
        return 1;
    }

    public final int hashCode() {
        return this.f3457a.hashCode();
    }
}
