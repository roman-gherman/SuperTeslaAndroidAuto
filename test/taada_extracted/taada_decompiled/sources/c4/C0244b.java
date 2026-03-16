package c4;

import java.math.BigInteger;

/* JADX INFO: renamed from: c4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0244b extends AbstractC0243a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1780h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f1783l;

    public C0244b(int i, int i3, int i4, int i5, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        super(i, i3, i4, i5);
        this.f1780h = i;
        this.i = i3;
        this.f1781j = i4;
        this.f1782k = i5;
        this.d = bigInteger3;
        this.e = bigInteger4;
        AbstractC0246d abstractC0246d = null;
        this.f1783l = new h(this, abstractC0246d, abstractC0246d, 0);
        this.b = f(bigInteger);
        this.c = f(bigInteger2);
        this.f1778f = 6;
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0243a a() {
        AbstractC0246d abstractC0246d = this.b;
        AbstractC0246d abstractC0246d2 = this.c;
        BigInteger bigInteger = this.d;
        BigInteger bigInteger2 = this.e;
        int i = this.f1780h;
        int i3 = this.i;
        int i4 = this.f1781j;
        int i5 = this.f1782k;
        C0244b c0244b = new C0244b(i, i3, i4, i5);
        c0244b.f1780h = i;
        c0244b.i = i3;
        c0244b.f1781j = i4;
        c0244b.f1782k = i5;
        c0244b.d = bigInteger;
        c0244b.e = bigInteger2;
        AbstractC0246d abstractC0246d3 = null;
        c0244b.f1783l = new h(c0244b, abstractC0246d3, abstractC0246d3, 0);
        c0244b.b = abstractC0246d;
        c0244b.c = abstractC0246d2;
        c0244b.f1778f = 6;
        return c0244b;
    }

    @Override // c4.AbstractC0243a
    public final j c(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2) {
        return new h(this, abstractC0246d, abstractC0246d2, 0);
    }

    @Override // c4.AbstractC0243a
    public final j d(AbstractC0246d abstractC0246d, AbstractC0246d abstractC0246d2, AbstractC0246d[] abstractC0246dArr) {
        return new h(this, abstractC0246d, abstractC0246d2, abstractC0246dArr, 0);
    }

    @Override // c4.AbstractC0243a
    public final AbstractC0246d f(BigInteger bigInteger) {
        int i;
        byte[] bArr;
        if (bigInteger != null && bigInteger.signum() >= 0) {
            int iBitLength = bigInteger.bitLength();
            int i3 = this.f1780h;
            if (iBitLength <= i3) {
                int i4 = this.f1781j;
                int i5 = this.f1782k;
                int i6 = i4 | i5;
                char c = 2;
                int i7 = this.i;
                int[] iArr = i6 == 0 ? new int[]{i7} : new int[]{i7, i4, i5};
                k kVar = new k();
                if (bigInteger.signum() < 0) {
                    throw new IllegalArgumentException("invalid F2m field value");
                }
                if (bigInteger.signum() == 0) {
                    kVar.f1799a = new long[]{0};
                } else {
                    byte[] byteArray = bigInteger.toByteArray();
                    int length = byteArray.length;
                    if (byteArray[0] == 0) {
                        length--;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    int i8 = (length + 7) / 8;
                    kVar.f1799a = new long[i8];
                    int i9 = i8 - 1;
                    int i10 = (length % 8) + i;
                    if (i < i10) {
                        long j6 = 0;
                        while (i < i10) {
                            j6 = (j6 << 8) | ((long) (byteArray[i] & 255));
                            i++;
                            byteArray = byteArray;
                            c = c;
                        }
                        bArr = byteArray;
                        kVar.f1799a[i9] = j6;
                        i9 = i8 - 2;
                    } else {
                        bArr = byteArray;
                    }
                    while (i9 >= 0) {
                        long j7 = 0;
                        int i11 = 0;
                        while (i11 < 8) {
                            j7 = (j7 << 8) | ((long) (bArr[i] & 255));
                            i11++;
                            i++;
                        }
                        kVar.f1799a[i9] = j7;
                        i9--;
                    }
                }
                return new C0247e(i3, iArr, kVar);
            }
        }
        throw new IllegalArgumentException("x value invalid in F2m field element");
    }

    @Override // c4.AbstractC0243a
    public final int g() {
        return this.f1780h;
    }

    @Override // c4.AbstractC0243a
    public final j h() {
        return this.f1783l;
    }

    @Override // c4.AbstractC0243a
    public final boolean l(int i) {
        return i == 0 || i == 1 || i == 6;
    }

    public C0244b(int i, int i3, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this(i, i3, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }
}
