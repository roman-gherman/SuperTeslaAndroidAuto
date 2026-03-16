package w3;

import java.io.IOException;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.util.Iterable;

/* JADX INFO: renamed from: w3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0904w extends AbstractC0899q implements Iterable {
    public static final C0883a c = new C0883a(AbstractC0904w.class, 18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ASN1Encodable[] f5075a;
    public ASN1Encodable[] b;

    public AbstractC0904w() {
        ASN1Encodable[] aSN1EncodableArr = C0886d.d;
        this.f5075a = aSN1EncodableArr;
        this.b = aSN1EncodableArr;
    }

    public static byte[] j(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.toASN1Primitive().a();
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static boolean k(byte[] bArr, byte[] bArr2) {
        int i = bArr[0] & 223;
        int i3 = bArr2[0] & 223;
        if (i != i3) {
            return i < i3;
        }
        int iMin = Math.min(bArr.length, bArr2.length) - 1;
        for (int i4 = 1; i4 < iMin; i4++) {
            byte b = bArr[i4];
            byte b2 = bArr2[i4];
            if (b != b2) {
                return (b & 255) < (b2 & 255);
            }
        }
        return (bArr[iMin] & 255) <= (bArr2[iMin] & 255);
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (abstractC0899q instanceof AbstractC0904w) {
            AbstractC0904w abstractC0904w = (AbstractC0904w) abstractC0899q;
            int length = this.f5075a.length;
            if (abstractC0904w.f5075a.length == length) {
                a0 a0Var = (a0) h();
                a0 a0Var2 = (a0) abstractC0904w.h();
                for (int i = 0; i < length; i++) {
                    AbstractC0899q aSN1Primitive = a0Var.f5075a[i].toASN1Primitive();
                    AbstractC0899q aSN1Primitive2 = a0Var2.f5075a[i].toASN1Primitive();
                    if (aSN1Primitive == aSN1Primitive2 || aSN1Primitive.b(aSN1Primitive2)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return true;
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        int i;
        if (this.b == null) {
            ASN1Encodable[] aSN1EncodableArr = (ASN1Encodable[]) this.f5075a.clone();
            this.b = aSN1EncodableArr;
            int length = aSN1EncodableArr.length;
            if (length >= 2) {
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[0];
                ASN1Encodable aSN1Encodable2 = aSN1EncodableArr[1];
                byte[] bArrJ = j(aSN1Encodable);
                byte[] bArrJ2 = j(aSN1Encodable2);
                if (k(bArrJ2, bArrJ)) {
                    aSN1Encodable2 = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable2;
                    bArrJ2 = bArrJ;
                    bArrJ = bArrJ2;
                }
                for (int i3 = 2; i3 < length; i3++) {
                    ASN1Encodable aSN1Encodable3 = aSN1EncodableArr[i3];
                    byte[] bArrJ3 = j(aSN1Encodable3);
                    if (k(bArrJ2, bArrJ3)) {
                        aSN1EncodableArr[i3 - 2] = aSN1Encodable;
                        aSN1Encodable = aSN1Encodable2;
                        bArrJ = bArrJ2;
                        aSN1Encodable2 = aSN1Encodable3;
                        bArrJ2 = bArrJ3;
                    } else if (k(bArrJ, bArrJ3)) {
                        aSN1EncodableArr[i3 - 2] = aSN1Encodable;
                        aSN1Encodable = aSN1Encodable3;
                        bArrJ = bArrJ3;
                    } else {
                        int i4 = i3 - 1;
                        while (true) {
                            i = i4 - 1;
                            if (i <= 0) {
                                break;
                            }
                            ASN1Encodable aSN1Encodable4 = aSN1EncodableArr[i4 - 2];
                            if (k(j(aSN1Encodable4), bArrJ3)) {
                                break;
                            }
                            aSN1EncodableArr[i] = aSN1Encodable4;
                            i4 = i;
                        }
                        aSN1EncodableArr[i] = aSN1Encodable3;
                    }
                }
                aSN1EncodableArr[length - 2] = aSN1Encodable;
                aSN1EncodableArr[length - 1] = aSN1Encodable2;
            }
        }
        a0 a0Var = new a0(true, this.b);
        a0Var.d = -1;
        return a0Var;
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public final int hashCode() {
        ASN1Encodable[] aSN1EncodableArr = this.f5075a;
        int length = aSN1EncodableArr.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode += aSN1EncodableArr[length].toASN1Primitive().hashCode();
        }
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q i() {
        k0 k0Var = new k0(this.f5075a, this.b);
        k0Var.d = -1;
        return k0Var;
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public final Iterator iterator() {
        ASN1Encodable[] aSN1EncodableArr = this.f5075a;
        return new g5.a(aSN1EncodableArr.length < 1 ? C0886d.d : (ASN1Encodable[]) aSN1EncodableArr.clone());
    }

    public final String toString() {
        ASN1Encodable[] aSN1EncodableArr = this.f5075a;
        int length = aSN1EncodableArr.length;
        if (length == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int i = 0;
        while (true) {
            stringBuffer.append(aSN1EncodableArr[i]);
            i++;
            if (i >= length) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    public AbstractC0904w(C0886d c0886d) {
        if (c0886d == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        ASN1Encodable[] aSN1EncodableArrC = c0886d.c();
        this.f5075a = aSN1EncodableArrC;
        this.b = aSN1EncodableArrC.length >= 2 ? null : aSN1EncodableArrC;
    }

    public AbstractC0904w(boolean z6, ASN1Encodable[] aSN1EncodableArr) {
        this.f5075a = aSN1EncodableArr;
        if (!z6 && aSN1EncodableArr.length >= 2) {
            aSN1EncodableArr = null;
        }
        this.b = aSN1EncodableArr;
    }

    public AbstractC0904w(ASN1Encodable[] aSN1EncodableArr, ASN1Encodable[] aSN1EncodableArr2) {
        this.f5075a = aSN1EncodableArr;
        this.b = aSN1EncodableArr2;
    }
}
