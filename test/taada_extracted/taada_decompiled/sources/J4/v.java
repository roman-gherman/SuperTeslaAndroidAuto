package J4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends H4.a implements XMSSStoreableObjectInterface, Encodable {
    public final t c;
    public final byte[] d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile a f916h;

    /* JADX WARN: Illegal instructions before constructor call */
    public v(u uVar) {
        t tVar = uVar.f910a;
        super(true, tVar.f907f);
        this.c = tVar;
        int i = tVar.f908g;
        byte[] bArr = uVar.d;
        if (bArr == null) {
            this.d = new byte[i];
        } else {
            if (bArr.length != i) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.d = bArr;
        }
        byte[] bArr2 = uVar.e;
        if (bArr2 == null) {
            this.e = new byte[i];
        } else {
            if (bArr2.length != i) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.e = bArr2;
        }
        byte[] bArr3 = uVar.f911f;
        if (bArr3 == null) {
            this.f914f = new byte[i];
        } else {
            if (bArr3.length != i) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f914f = bArr3;
        }
        byte[] bArr4 = uVar.f912g;
        if (bArr4 == null) {
            this.f915g = new byte[i];
        } else {
            if (bArr4.length != i) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f915g = bArr4;
        }
        a aVar = uVar.f913h;
        if (aVar != null) {
            this.f916h = aVar;
        } else {
            int i3 = uVar.b;
            int i4 = 1 << tVar.b;
            if (i3 >= i4 - 2 || bArr3 == null || bArr == null) {
                this.f916h = new a(tVar, i4 - 1, i3);
            } else {
                k kVar = new k(new i(1));
                int i5 = uVar.b;
                C0.t tVar2 = new C0.t(tVar.f909h);
                int i6 = tVar.b;
                aVar = new a(tVar2, i6, tVar.c, (1 << i6) - 1);
                aVar.a(bArr3, bArr, kVar);
                while (aVar.i < i5) {
                    aVar.b(bArr3, bArr, kVar);
                    aVar.f877j = false;
                }
                this.f916h = aVar;
            }
        }
        int i7 = uVar.c;
        if (i7 >= 0 && i7 != this.f916h.f878k) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public final long getUsagesRemaining() {
        long j6;
        synchronized (this) {
            j6 = (this.f916h.f878k - this.f916h.i) + 1;
        }
        return j6;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public final byte[] toByteArray() {
        byte[] bArrE;
        synchronized (this) {
            try {
                int i = this.c.f908g;
                int i3 = i + 4;
                int i4 = i3 + i;
                int i5 = i4 + i;
                byte[] bArr = new byte[i + i5];
                g5.c.o(bArr, this.f916h.i, 0);
                C5.f.n(4, bArr, this.d);
                C5.f.n(i3, bArr, this.e);
                C5.f.n(i4, bArr, this.f914f);
                C5.f.n(i5, bArr, this.f915g);
                try {
                    a aVar = this.f916h;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(aVar);
                    objectOutputStream.flush();
                    bArrE = g5.c.e(bArr, byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    throw new RuntimeException("error serializing bds state: " + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrE;
    }
}
