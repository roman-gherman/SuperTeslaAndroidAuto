package w3;

import org.bouncycastle.asn1.ASN1Encodable;

/* JADX INFO: renamed from: w3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0886d {
    public static final ASN1Encodable[] d = new ASN1Encodable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ASN1Encodable[] f5051a;
    public int b;
    public boolean c;

    public C0886d() {
        this(10);
    }

    public final void a(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        ASN1Encodable[] aSN1EncodableArr = this.f5051a;
        int length = aSN1EncodableArr.length;
        int i = this.b + 1;
        if (this.c | (i > length)) {
            ASN1Encodable[] aSN1EncodableArr2 = new ASN1Encodable[Math.max(aSN1EncodableArr.length, (i >> 1) + i)];
            System.arraycopy(this.f5051a, 0, aSN1EncodableArr2, 0, this.b);
            this.f5051a = aSN1EncodableArr2;
            this.c = false;
        }
        this.f5051a[this.b] = aSN1Encodable;
        this.b = i;
    }

    public final ASN1Encodable b(int i) {
        if (i < this.b) {
            return this.f5051a[i];
        }
        throw new ArrayIndexOutOfBoundsException(i + " >= " + this.b);
    }

    public final ASN1Encodable[] c() {
        int i = this.b;
        if (i == 0) {
            return d;
        }
        ASN1Encodable[] aSN1EncodableArr = this.f5051a;
        if (aSN1EncodableArr.length == i) {
            this.c = true;
            return aSN1EncodableArr;
        }
        ASN1Encodable[] aSN1EncodableArr2 = new ASN1Encodable[i];
        System.arraycopy(aSN1EncodableArr, 0, aSN1EncodableArr2, 0, i);
        return aSN1EncodableArr2;
    }

    public C0886d(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f5051a = i == 0 ? d : new ASN1Encodable[i];
        this.b = 0;
        this.c = false;
    }
}
