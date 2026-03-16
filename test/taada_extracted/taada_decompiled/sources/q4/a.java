package Q4;

import E1.k;
import b5.g;
import c4.AbstractC0246d;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.KyberPrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.KyberPublicKey;
import w3.AbstractC0904w;
import z4.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements KyberPrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient d f1240a;
    public transient String b;
    public transient AbstractC0904w c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.c = aVarB.d;
        d dVar = (d) k.t(aVarB);
        this.f1240a = dVar;
        this.b = e.c(((z4.c) dVar.b).f5211a);
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
            return Arrays.equals(getEncoded(), ((a) obj).getEncoded());
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
            return AbstractC0246d.y(this.f1240a, this.c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.KyberKey
    public final g getParameterSpec() {
        return (g) g.f1718a.get(e.b(((z4.c) this.f1240a.b).f5211a));
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.KyberPrivateKey
    public final KyberPublicKey getPublicKey() {
        d dVar = this.f1240a;
        z4.e eVar = new z4.e((z4.c) dVar.b, dVar.f5212f, dVar.f5213g);
        b bVar = new b();
        bVar.f1241a = eVar;
        bVar.b = e.c(((z4.c) eVar.b).f5211a);
        return bVar;
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }
}
