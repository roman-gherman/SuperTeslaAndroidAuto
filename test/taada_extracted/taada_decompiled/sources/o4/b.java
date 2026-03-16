package O4;

import H3.d;
import a.AbstractC0132a;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.FalconPublicKey;
import t4.C0829a;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements FalconPublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient t4.c f1193a;
    public transient String b;
    public transient byte[] c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        t4.c cVar = (t4.c) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
        this.f1193a = cVar;
        this.b = e.c(((C0829a) cVar.b).f4841a);
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
            return Arrays.equals(getEncoded(), ((b) obj).getEncoded());
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
            this.c = AbstractC0132a.C(this.f1193a);
        }
        return g5.c.c(this.c);
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.FalconKey
    public final b5.d getParameterSpec() {
        return (b5.d) b5.d.f1716a.get(e.b(((C0829a) this.f1193a.b).f4841a));
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }
}
