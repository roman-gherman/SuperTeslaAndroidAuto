package J4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends H4.a implements XMSSStoreableObjectInterface, Encodable {
    public final o c;
    public final byte[] d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f903h;
    public volatile b i;

    /* JADX WARN: Illegal instructions before constructor call */
    public q(p pVar) {
        o oVar = pVar.f897a;
        t tVar = oVar.b;
        super(true, tVar.f907f);
        this.c = oVar;
        int i = tVar.f908g;
        this.f903h = pVar.b;
        byte[] bArr = pVar.d;
        if (bArr == null) {
            this.d = new byte[i];
        } else {
            if (bArr.length != i) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.d = bArr;
        }
        byte[] bArr2 = pVar.e;
        if (bArr2 == null) {
            this.e = new byte[i];
        } else {
            if (bArr2.length != i) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.e = bArr2;
        }
        byte[] bArr3 = pVar.f898f;
        if (bArr3 == null) {
            this.f901f = new byte[i];
        } else {
            if (bArr3.length != i) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f901f = bArr3;
        }
        byte[] bArr4 = pVar.f899g;
        if (bArr4 == null) {
            this.f902g = new byte[i];
        } else {
            if (bArr4.length != i) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f902g = bArr4;
        }
        b bVar = pVar.f900h;
        if (bVar == null) {
            bVar = (!C5.f.L(oVar.c, pVar.b) || bArr3 == null || bArr == null) ? new b(pVar.c + 1) : new b(oVar, pVar.b, bArr3, bArr);
        }
        this.i = bVar;
        long j6 = pVar.c;
        if (j6 >= 0 && j6 != this.i.b) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public final void b() {
        synchronized (this) {
            try {
                if (this.f903h < this.i.b) {
                    this.i.a(this.c, this.f903h, this.f901f, this.d);
                    this.f903h++;
                } else {
                    this.f903h = this.i.b + 1;
                    this.i = new b(this.i.b);
                }
            } catch (Throwable th) {
                throw th;
            }
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
            j6 = (this.i.b - this.f903h) + 1;
        }
        return j6;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public final byte[] toByteArray() {
        byte[] bArrE;
        synchronized (this) {
            try {
                o oVar = this.c;
                int i = oVar.b.f908g;
                int i3 = (oVar.c + 7) / 8;
                int i4 = i3 + i;
                int i5 = i4 + i;
                int i6 = i5 + i;
                byte[] bArr = new byte[i + i6];
                C5.f.n(0, bArr, C5.f.k0(i3, this.f903h));
                C5.f.n(i3, bArr, this.d);
                C5.f.n(i4, bArr, this.e);
                C5.f.n(i5, bArr, this.f901f);
                C5.f.n(i6, bArr, this.f902g);
                try {
                    b bVar = this.i;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(bVar);
                    objectOutputStream.flush();
                    bArrE = g5.c.e(bArr, byteArrayOutputStream.toByteArray());
                } catch (IOException e) {
                    throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrE;
    }
}
