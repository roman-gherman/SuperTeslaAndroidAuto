package O4;

import E1.k;
import a.AbstractC0132a;
import b5.d;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.FalconPrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.FalconPublicKey;
import t4.C0829a;
import t4.C0830b;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements FalconPrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0830b f1192a;
    public transient String b;
    public transient byte[] c;
    public transient AbstractC0904w d;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        C0830b c0830b = (C0830b) k.t(aVarB);
        this.d = aVarB.d;
        this.f1192a = c0830b;
        this.b = e.c(((C0829a) c0830b.b).f4841a);
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
        if (this.c == null) {
            this.c = AbstractC0132a.B(this.f1192a, this.d);
        }
        return g5.c.c(this.c);
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.FalconKey
    public final d getParameterSpec() {
        return (d) d.f1716a.get(e.b(((C0829a) this.f1192a.b).f4841a));
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.FalconPrivateKey
    public final FalconPublicKey getPublicKey() {
        C0830b c0830b = this.f1192a;
        C0829a c0829a = (C0829a) c0830b.b;
        t4.c cVar = new t4.c(c0829a, g5.c.c(c0830b.c));
        b bVar = new b();
        bVar.f1193a = cVar;
        bVar.b = e.c(c0829a.f4841a);
        return bVar;
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }
}
