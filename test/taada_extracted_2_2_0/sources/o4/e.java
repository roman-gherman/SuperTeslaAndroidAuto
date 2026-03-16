package o4;

import w3.AbstractC0893k;
import w3.AbstractC0899q;
import w3.C0886d;
import w3.C0891i;
import w3.W;
import w3.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AbstractC0893k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4365a;
    public int b;
    public byte[] c;
    public byte[] d;
    public byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public H3.a f4366f;

    public e(int i, int i3, f5.b bVar, f5.e eVar, f5.d dVar, H3.a aVar) {
        int i4;
        this.f4365a = i;
        this.b = i3;
        int i5 = bVar.b;
        this.c = new byte[]{(byte) i5, (byte) (i5 >>> 8), (byte) (i5 >>> 16), (byte) (i5 >>> 24)};
        int i6 = 8;
        int i7 = 1;
        while (eVar.f3257a.f3254a > i6) {
            i7++;
            i6 += 8;
        }
        byte[] bArr = new byte[eVar.c.length * i7];
        int i8 = 0;
        for (int i9 = 0; i9 < eVar.c.length; i9++) {
            int i10 = 0;
            while (i10 < i6) {
                bArr[i8] = (byte) (eVar.c[i9] >>> i10);
                i10 += 8;
                i8++;
            }
        }
        this.d = bArr;
        int[] iArr = dVar.f3256a;
        int length = iArr.length;
        int i11 = length - 1;
        int i12 = f5.c.f3255a;
        if (i11 == 0) {
            i4 = 1;
        } else {
            i4 = 0;
            for (i11 = i11 < 0 ? -i11 : i11; i11 > 0; i11 >>>= 8) {
                i4++;
            }
        }
        byte[] bArr2 = new byte[(length * i4) + 4];
        C5.f.a(bArr2, length, 0);
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            int i15 = (i13 * i4) + 4;
            for (int i16 = i4 - 1; i16 >= 0; i16--) {
                bArr2[i15 + i16] = (byte) (i14 >>> (i16 * 8));
            }
        }
        this.e = bArr2;
        this.f4366f = aVar;
    }

    public final f5.b b() {
        f5.b bVar = new f5.b();
        bVar.f3254a = 0;
        byte[] bArr = this.c;
        if (bArr.length != 4) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        int i = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24);
        bVar.b = i;
        if (!E1.k.V(i)) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        bVar.f3254a = E1.k.v(i);
        return bVar;
    }

    @Override // w3.AbstractC0893k, org.bouncycastle.asn1.ASN1Encodable
    public final AbstractC0899q toASN1Primitive() {
        C0886d c0886d = new C0886d();
        c0886d.a(new C0891i(this.f4365a));
        c0886d.a(new C0891i(this.b));
        c0886d.a(new W(this.c));
        c0886d.a(new W(this.d));
        c0886d.a(new W(this.e));
        c0886d.a(this.f4366f);
        Z z6 = new Z(c0886d, false);
        z6.d = -1;
        return z6;
    }
}
