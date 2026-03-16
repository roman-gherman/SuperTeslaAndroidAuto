package Y4;

import E1.k;
import b5.n;
import c4.AbstractC0246d;
import g5.e;
import h5.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.pqc.crypto.sphincsplus.f;
import org.bouncycastle.pqc.crypto.sphincsplus.g;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusPrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusPublicKey;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, SPHINCSPlusPrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f f1492a;
    public transient AbstractC0904w b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.b = aVarB.d;
        this.f1492a = (f) k.t(aVarB);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return Arrays.equals(this.f1492a.getEncoded(), ((a) obj).f1492a.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS+";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.f1492a, this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusKey
    public final n getParameterSpec() {
        return (n) n.f1722a.get(e.b(((org.bouncycastle.pqc.crypto.sphincsplus.e) this.f1492a.b).b));
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusPrivateKey
    public final SPHINCSPlusPublicKey getPublicKey() {
        f fVar = this.f1492a;
        org.bouncycastle.pqc.crypto.sphincsplus.e eVar = (org.bouncycastle.pqc.crypto.sphincsplus.e) fVar.b;
        c cVar = fVar.d;
        g gVar = new g(eVar, g5.c.e(cVar.f3461a, cVar.b));
        b bVar = new b();
        bVar.f1493a = gVar;
        return bVar;
    }

    public final int hashCode() {
        return g5.c.k(this.f1492a.getEncoded());
    }
}
