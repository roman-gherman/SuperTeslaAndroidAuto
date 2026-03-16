package a5;

import C5.f;
import J4.w;
import a.AbstractC0132a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSKey;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements PublicKey, XMSSKey {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient w f1565a;
    public transient C0896n b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        w wVar = (w) I4.b.a(H3.d.b((byte[]) objectInputStream.readObject()));
        this.f1565a = wVar;
        this.b = f.E(wVar.b);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            try {
                if (this.b.f(dVar.b)) {
                    if (Arrays.equals(this.f1565a.toByteArray(), dVar.f1565a.toByteArray())) {
                        return true;
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1565a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSKey
    public final int getHeight() {
        return this.f1565a.c.b;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSKey
    public final String getTreeDigest() {
        return f.H(this.b);
    }

    public final int hashCode() {
        try {
            return (g5.c.k(this.f1565a.toByteArray()) * 37) + g5.c.k(this.b.f5065a);
        } catch (IOException unused) {
            return g5.c.k(this.b.f5065a);
        }
    }
}
