package Q4;

import H3.d;
import a.AbstractC0132a;
import b5.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.KyberPublicKey;
import z4.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements KyberPublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient e f1241a;
    public transient String b;
    public transient byte[] c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        e eVar = (e) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
        this.f1241a = eVar;
        this.b = g5.e.c(((z4.c) eVar.b).f5211a);
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
            this.c = AbstractC0132a.C(this.f1241a);
        }
        return g5.c.c(this.c);
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.KyberKey
    public final g getParameterSpec() {
        return (g) g.f1718a.get(g5.e.b(((z4.c) this.f1241a.b).f5211a));
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }
}
