package X4;

import H3.d;
import H4.c;
import a.AbstractC0132a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import o4.g;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, SPHINCSKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0896n f1461a;
    public transient c b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        d dVarB = d.b((byte[]) objectInputStream.readObject());
        this.f1461a = g.b(dVarB.f748a.b).b.f747a;
        this.b = (c) I4.b.a(dVarB);
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
            if (this.f1461a.f(bVar.f1461a) && Arrays.equals(g5.c.c(this.b.c), g5.c.c(bVar.b.c))) {
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
            c cVar = this.b;
            String str = cVar.b;
            return AbstractC0132a.r(cVar).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public final byte[] getKeyData() {
        return g5.c.c(this.b.c);
    }

    public final int hashCode() {
        return (g5.c.k(g5.c.c(this.b.c)) * 37) + g5.c.k(this.f1461a.f5064a);
    }
}
