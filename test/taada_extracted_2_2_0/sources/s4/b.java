package S4;

import H3.d;
import a.AbstractC0132a;
import b5.h;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.MayoKey;
import x4.C0926a;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, MayoKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient x4.c f1298a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f1298a = (x4.c) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
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
            return Arrays.equals(g5.c.c(this.f1298a.c), g5.c.c(((b) obj).f1298a.c));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return e.c(((C0926a) this.f1298a.b).f5126a);
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1298a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.MayoKey
    public final h getParameterSpec() {
        return (h) h.f1719a.get(e.b(((C0926a) this.f1298a.b).f5126a));
    }

    public final int hashCode() {
        return g5.c.k(g5.c.c(this.f1298a.c));
    }
}
