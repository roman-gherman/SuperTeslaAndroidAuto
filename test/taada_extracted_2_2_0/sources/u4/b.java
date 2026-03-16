package U4;

import B4.d;
import a.AbstractC0132a;
import b5.j;
import g5.c;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.NTRUKey;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, NTRUKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient d f1346a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f1346a = (d) I4.b.a(H3.d.b((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return Arrays.equals(c.c(this.f1346a.c), c.c(((b) obj).f1346a.c));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NTRU";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1346a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.NTRUKey
    public final j getParameterSpec() {
        return (j) j.f1720a.get(e.b(((B4.b) this.f1346a.b).f130a));
    }

    public final int hashCode() {
        return c.k(c.c(this.f1346a.c));
    }
}
