package c4;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* JADX INFO: renamed from: c4.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0248f extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BigInteger f1794h;
    public final BigInteger i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BigInteger f1795j;

    public C0248f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f1794h = bigInteger;
        this.i = bigInteger2;
        this.f1795j = bigInteger3;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        BigInteger bigInteger = this.f1795j;
        return new C0248f(this.f1794h, this.i, R0(bigInteger, bigInteger));
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return new C0248f(this.f1794h, this.i, R0(this.f1795j, Q0(abstractC0246d.G0())));
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        return this.f1795j;
    }

    public final BigInteger Q0(BigInteger bigInteger) {
        BigInteger bigInteger2 = g5.b.f3344a;
        BigInteger bigInteger3 = this.f1794h;
        if (!bigInteger3.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        }
        if (bigInteger3.signum() != 1) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > bigInteger3.bitLength()) {
            bigInteger = bigInteger.mod(bigInteger3);
        }
        int iBitLength = bigInteger3.bitLength();
        int[] iArrA = E1.k.A(iBitLength, bigInteger3);
        int[] iArrA2 = E1.k.A(iBitLength, bigInteger);
        int length = iArrA.length;
        int[] iArr = new int[length];
        if (C5.f.V(iArrA, iArrA2, iArr) != 0) {
            return E1.k.n0(length, iArr);
        }
        throw new ArithmeticException("BigInteger not invertible.");
    }

    public final BigInteger R0(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2);
        BigInteger bigInteger3 = this.f1794h;
        BigInteger bigInteger4 = this.i;
        if (bigInteger4 == null) {
            return bigIntegerMultiply.mod(bigInteger3);
        }
        boolean z6 = bigIntegerMultiply.signum() < 0;
        if (z6) {
            bigIntegerMultiply = bigIntegerMultiply.abs();
        }
        int iBitLength = bigInteger3.bitLength();
        boolean zEquals = bigInteger4.equals(ECConstants.ONE);
        while (bigIntegerMultiply.bitLength() > iBitLength + 1) {
            BigInteger bigIntegerShiftRight = bigIntegerMultiply.shiftRight(iBitLength);
            BigInteger bigIntegerSubtract = bigIntegerMultiply.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
            if (!zEquals) {
                bigIntegerShiftRight = bigIntegerShiftRight.multiply(bigInteger4);
            }
            bigIntegerMultiply = bigIntegerShiftRight.add(bigIntegerSubtract);
        }
        while (bigIntegerMultiply.compareTo(bigInteger3) >= 0) {
            bigIntegerMultiply = bigIntegerMultiply.subtract(bigInteger3);
        }
        return (!z6 || bigIntegerMultiply.signum() == 0) ? bigIntegerMultiply : bigInteger3.subtract(bigIntegerMultiply);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        return new C0248f(this.f1794h, this.i, Q0(this.f1795j));
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        BigInteger bigIntegerAdd = this.f1795j.add(abstractC0246d.G0());
        BigInteger bigInteger = this.f1794h;
        if (bigIntegerAdd.compareTo(bigInteger) >= 0) {
            bigIntegerAdd = bigIntegerAdd.subtract(bigInteger);
        }
        return new C0248f(bigInteger, this.i, bigIntegerAdd);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0248f)) {
            return false;
        }
        C0248f c0248f = (C0248f) obj;
        return this.f1794h.equals(c0248f.f1794h) && this.f1795j.equals(c0248f.f1795j);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        return new C0248f(this.f1794h, this.i, R0(this.f1795j, abstractC0246d.G0()));
    }

    public final int hashCode() {
        return this.f1794h.hashCode() ^ this.f1795j.hashCode();
    }
}
