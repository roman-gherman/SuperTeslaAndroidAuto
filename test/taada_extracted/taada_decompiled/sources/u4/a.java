package U4;

import B4.c;
import E1.k;
import b5.j;
import c4.AbstractC0246d;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.NTRUKey;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, NTRUKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f1345a;
    public transient AbstractC0904w b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.b = aVarB.d;
        this.f1345a = (c) k.t(aVarB);
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
            return Arrays.equals(g5.c.c(this.f1345a.c), g5.c.c(((a) obj).f1345a.c));
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
            return AbstractC0246d.y(this.f1345a, this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.NTRUKey
    public final j getParameterSpec() {
        return (j) j.f1720a.get(e.b(((B4.b) this.f1345a.b).f130a));
    }

    public final int hashCode() {
        return g5.c.k(g5.c.c(this.f1345a.c));
    }
}
