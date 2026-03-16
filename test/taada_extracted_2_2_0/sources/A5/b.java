package a5;

import C5.f;
import J4.r;
import a.AbstractC0132a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, XMSSMTKey {
    private static final long serialVersionUID = 3230324130542413475L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0896n f1563a;
    public transient r b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        r rVar = (r) I4.b.a(H3.d.b((byte[]) objectInputStream.readObject()));
        this.b = rVar;
        this.f1563a = f.E(rVar.b);
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
            b bVar = (b) obj;
            if (this.f1563a.f(bVar.f1563a) && Arrays.equals(this.b.toByteArray(), bVar.b.toByteArray())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public final int getHeight() {
        return this.b.c.c;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public final int getLayers() {
        return this.b.c.d;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public final String getTreeDigest() {
        return f.H(this.f1563a);
    }

    public final int hashCode() {
        return (g5.c.k(this.b.toByteArray()) * 37) + g5.c.k(this.f1563a.f5065a);
    }
}
