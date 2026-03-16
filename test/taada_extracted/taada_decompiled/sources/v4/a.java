package V4;

import E1.k;
import c4.AbstractC0246d;
import g5.c;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.PicnicKey;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, PicnicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient D4.b f1377a;
    public transient AbstractC0904w b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.b = aVarB.d;
        this.f1377a = (D4.b) k.t(aVarB);
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
            return Arrays.equals(c.c(this.f1377a.c), c.c(((a) obj).f1377a.c));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Picnic";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.f1377a, this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.PicnicKey
    public final b5.k getParameterSpec() {
        return (b5.k) b5.k.f1721a.get(e.b(((D4.a) this.f1377a.b).f277a));
    }

    public final int hashCode() {
        return c.k(c.c(this.f1377a.c));
    }
}
