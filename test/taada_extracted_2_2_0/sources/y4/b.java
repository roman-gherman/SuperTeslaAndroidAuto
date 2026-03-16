package Y4;

import H3.d;
import a.AbstractC0132a;
import b5.n;
import g5.e;
import h5.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.crypto.sphincsplus.g;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusPublicKey;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements SPHINCSPlusPublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g f1493a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f1493a = (g) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        c cVar = this.f1493a.c;
        byte[] bArrE = g5.c.e(cVar.f3461a, cVar.b);
        c cVar2 = ((b) obj).f1493a.c;
        return Arrays.equals(bArrE, g5.c.e(cVar2.f3461a, cVar2.b));
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS+-".concat(e.c(((org.bouncycastle.pqc.crypto.sphincsplus.e) this.f1493a.b).b));
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1493a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusKey
    public final n getParameterSpec() {
        return (n) n.f1722a.get(e.b(((org.bouncycastle.pqc.crypto.sphincsplus.e) this.f1493a.b).b));
    }

    public final int hashCode() {
        c cVar = this.f1493a.c;
        return g5.c.k(g5.c.e(cVar.f3461a, cVar.b));
    }
}
