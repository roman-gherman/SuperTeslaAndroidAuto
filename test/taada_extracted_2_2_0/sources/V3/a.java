package V3;

import E1.k;
import N3.g;
import c4.AbstractC0246d;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.jcajce.interfaces.MLKEMPrivateKey;
import org.bouncycastle.jcajce.interfaces.MLKEMPublicKey;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements MLKEMPrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient z4.d f1374a;
    public transient String b;
    public transient AbstractC0904w c;
    public transient byte[] d;

    public a(z4.d dVar) {
        this.f1374a = dVar;
        this.b = e.c(((z4.c) dVar.b).f5212a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(C3.a.b((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final void a(C3.a aVar) {
        this.c = aVar.d;
        this.d = aVar.getEncoded();
        z4.d dVar = (z4.d) k.t(aVar);
        this.f1374a = dVar;
        this.b = e.c(Y3.c.a(((z4.c) dVar.b).f5212a).f1489a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return Arrays.equals(this.f1374a.getEncoded(), ((a) obj).f1374a.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return this.b;
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            byte[] bArr = this.d;
            return bArr != null ? bArr : AbstractC0246d.y(this.f1374a, this.c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMKey
    public final Y3.c getParameterSpec() {
        return Y3.c.a(((z4.c) this.f1374a.b).f5212a);
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMPrivateKey
    public final byte[] getPrivateData() {
        return this.f1374a.getEncoded();
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMPrivateKey
    public final MLKEMPrivateKey getPrivateKey(boolean z6) {
        return (!z6 || g5.c.c(this.f1374a.f5215h) == null) ? new a(this.f1374a.n(2)) : new a(this.f1374a.n(1));
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMPrivateKey
    public final MLKEMPublicKey getPublicKey() {
        z4.d dVar = this.f1374a;
        return new b(new z4.e((z4.c) dVar.b, dVar.f5213f, dVar.f5214g));
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMPrivateKey
    public final byte[] getSeed() {
        return g5.c.c(this.f1374a.f5215h);
    }

    public final int hashCode() {
        return g5.c.k(this.f1374a.getEncoded());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = e.f3347a;
        z4.d dVar = this.f1374a;
        byte[] bArrE = g5.c.e(dVar.f5213f, dVar.f5214g);
        sb.append(this.b);
        sb.append(" Private Key [");
        g gVar = new g(256);
        gVar.update(bArrE, 0, bArrE.length);
        byte[] bArr = new byte[20];
        gVar.doFinal(bArr, 0, 20);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != 20; i++) {
            if (i > 0) {
                stringBuffer.append(":");
            }
            char[] cArr = g5.c.f3345a;
            stringBuffer.append(cArr[(bArr[i] >>> 4) & 15]);
            stringBuffer.append(cArr[bArr[i] & 15]);
        }
        sb.append(stringBuffer.toString());
        sb.append("]");
        sb.append(str);
        sb.append("    public data: ");
        sb.append(e.a(h5.b.b(bArrE.length, bArrE)));
        sb.append(str);
        return sb.toString();
    }
}
