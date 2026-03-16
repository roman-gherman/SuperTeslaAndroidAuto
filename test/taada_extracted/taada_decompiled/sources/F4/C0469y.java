package f4;

import c4.AbstractC0246d;
import java.math.BigInteger;

/* JADX INFO: renamed from: f4.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0469y extends AbstractC0246d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f3251h;

    public C0469y(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f3251h = E1.k.B(113, bigInteger);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d C0() {
        long[] jArr = new long[2];
        long[] jArr2 = new long[4];
        kotlin.reflect.l.t(this.f3251h, 2, jArr2);
        AbstractC0447b.L(jArr2, jArr);
        return new C0469y(jArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d G(AbstractC0246d abstractC0246d) {
        return h0(abstractC0246d.W());
    }

    @Override // c4.AbstractC0246d
    public final BigInteger G0() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 2; i++) {
            long j6 = this.f3251h[i];
            if (j6 != 0) {
                g5.c.t(bArr, (1 - i) << 3, j6);
            }
        }
        return new BigInteger(1, bArr);
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d W() {
        long[] jArr = new long[2];
        long[] jArr2 = this.f3251h;
        for (int i = 0; i < 2; i++) {
            if (jArr2[i] != 0) {
                long[] jArr3 = new long[2];
                long[] jArr4 = new long[2];
                long[] jArr5 = new long[4];
                kotlin.reflect.l.t(jArr2, 2, jArr5);
                AbstractC0447b.L(jArr5, jArr3);
                AbstractC0447b.z(jArr3, jArr2, jArr3);
                long[] jArr6 = new long[4];
                kotlin.reflect.l.t(jArr3, 2, jArr6);
                AbstractC0447b.L(jArr6, jArr3);
                AbstractC0447b.z(jArr3, jArr2, jArr3);
                AbstractC0447b.g0(jArr3, 3, jArr4);
                AbstractC0447b.z(jArr4, jArr3, jArr4);
                long[] jArr7 = new long[4];
                kotlin.reflect.l.t(jArr4, 2, jArr7);
                AbstractC0447b.L(jArr7, jArr4);
                AbstractC0447b.z(jArr4, jArr2, jArr4);
                AbstractC0447b.g0(jArr4, 7, jArr3);
                AbstractC0447b.z(jArr3, jArr4, jArr3);
                AbstractC0447b.g0(jArr3, 14, jArr4);
                AbstractC0447b.z(jArr4, jArr3, jArr4);
                AbstractC0447b.g0(jArr4, 28, jArr3);
                AbstractC0447b.z(jArr3, jArr4, jArr3);
                AbstractC0447b.g0(jArr3, 56, jArr4);
                AbstractC0447b.z(jArr4, jArr3, jArr4);
                long[] jArr8 = new long[4];
                kotlin.reflect.l.t(jArr4, 2, jArr8);
                AbstractC0447b.L(jArr8, jArr);
                return new C0469y(jArr);
            }
        }
        throw new IllegalStateException();
    }

    @Override // c4.AbstractC0246d
    public final boolean a0() {
        long[] jArr = this.f3251h;
        return jArr[0] == 1 && jArr[1] == 0;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d b(AbstractC0246d abstractC0246d) {
        long[] jArr = ((C0469y) abstractC0246d).f3251h;
        long[] jArr2 = this.f3251h;
        return new C0469y(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1]});
    }

    @Override // c4.AbstractC0246d
    public final boolean c0() {
        long[] jArr = this.f3251h;
        for (int i = 0; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0469y)) {
            return false;
        }
        long[] jArr = ((C0469y) obj).f3251h;
        for (int i = 1; i >= 0; i--) {
            if (this.f3251h[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // c4.AbstractC0246d
    public final AbstractC0246d h0(AbstractC0246d abstractC0246d) {
        long[] jArr = new long[2];
        AbstractC0447b.z(this.f3251h, ((C0469y) abstractC0246d).f3251h, jArr);
        return new C0469y(jArr);
    }

    public final int hashCode() {
        return g5.c.n(this.f3251h, 2) ^ 113009;
    }

    public C0469y(long[] jArr) {
        this.f3251h = jArr;
    }
}
