package X4;

import E1.k;
import c4.AbstractC0246d;
import g5.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import o4.g;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import w3.AbstractC0904w;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, SPHINCSKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0896n f1460a;
    public transient H4.b b;
    public transient AbstractC0904w c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.c = aVarB.d;
        this.f1460a = g.b(aVarB.b.b).b.f747a;
        this.b = (H4.b) k.t(aVarB);
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
            a aVar = (a) obj;
            if (this.f1460a.f(aVar.f1460a) && Arrays.equals(c.c(this.b.c), c.c(aVar.b.c))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            H4.b bVar = this.b;
            String str = bVar.b;
            return AbstractC0246d.y(bVar, this.c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public final byte[] getKeyData() {
        return c.c(this.b.c);
    }

    public final int hashCode() {
        return (c.k(c.c(this.b.c)) * 37) + c.k(this.f1460a.f5065a);
    }
}
