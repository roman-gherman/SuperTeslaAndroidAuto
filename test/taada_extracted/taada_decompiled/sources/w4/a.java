package W4;

import E1.k;
import b5.o;
import c4.AbstractC0246d;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.SnovaKey;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, SnovaKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient G4.b f1400a;
    public transient AbstractC0904w b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.b = aVarB.d;
        this.f1400a = (G4.b) k.t(aVarB);
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
            return Arrays.equals(g5.c.c(this.f1400a.b), g5.c.c(((a) obj).f1400a.b));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return e.c(this.f1400a.c.f729a);
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.f1400a, this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SnovaKey
    public final o getParameterSpec() {
        return (o) o.f1723a.get(e.b(this.f1400a.c.f729a));
    }

    public final int hashCode() {
        return g5.c.k(g5.c.c(this.f1400a.b));
    }
}
