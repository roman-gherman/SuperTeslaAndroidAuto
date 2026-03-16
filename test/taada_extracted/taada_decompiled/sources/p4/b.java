package P4;

import H3.d;
import a.AbstractC0132a;
import b5.f;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.HQCKey;
import v4.C0858a;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, HQCKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient v4.c f1227a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f1227a = (v4.c) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
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
            return Arrays.equals(g5.c.c(this.f1227a.c), g5.c.c(((b) obj).f1227a.c));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return e.c(((C0858a) this.f1227a.b).f4954a);
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1227a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.HQCKey
    public final f getParameterSpec() {
        return (f) f.f1717a.get(e.b(((C0858a) this.f1227a.b).f4954a));
    }

    public final int hashCode() {
        return g5.c.k(g5.c.c(this.f1227a.c));
    }
}
