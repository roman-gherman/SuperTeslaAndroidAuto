package J4;

import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends H4.a implements XMSSStoreableObjectInterface, Encodable {
    public final t c;
    public final int d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f917f;

    /* JADX WARN: Illegal instructions before constructor call */
    public w(C0.t tVar) {
        t tVar2 = (t) tVar.b;
        super(false, tVar2.f907f);
        this.c = tVar2;
        byte[] bArr = (byte[]) tVar.e;
        int i = tVar2.f908g;
        if (bArr != null) {
            if (bArr.length == i + i) {
                this.d = 0;
                this.e = C5.f.A(bArr, 0, i);
                this.f917f = C5.f.A(bArr, i, i);
                return;
            } else {
                int i3 = i + 4;
                if (bArr.length != i3 + i) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.d = g5.c.b(0, bArr);
                this.e = C5.f.A(bArr, 4, i);
                this.f917f = C5.f.A(bArr, i3, i);
                return;
            }
        }
        e eVar = tVar2.f906a;
        if (eVar != null) {
            this.d = eVar.f883a;
        } else {
            this.d = 0;
        }
        byte[] bArr2 = (byte[]) tVar.c;
        if (bArr2 == null) {
            this.e = new byte[i];
        } else {
            if (bArr2.length != i) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.e = bArr2;
        }
        byte[] bArr3 = (byte[]) tVar.d;
        if (bArr3 == null) {
            this.f917f = new byte[i];
        } else {
            if (bArr3.length != i) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f917f = bArr3;
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        return toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public final byte[] toByteArray() {
        byte[] bArr;
        int i = this.c.f908g;
        int i3 = 0;
        int i4 = this.d;
        if (i4 != 0) {
            bArr = new byte[i + 4 + i];
            g5.c.o(bArr, i4, 0);
            i3 = 4;
        } else {
            bArr = new byte[i + i];
        }
        C5.f.n(i3, bArr, this.e);
        C5.f.n(i3 + i, bArr, this.f917f);
        return bArr;
    }
}
