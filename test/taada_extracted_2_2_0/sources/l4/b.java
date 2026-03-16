package L4;

import H3.d;
import a.AbstractC0132a;
import b5.C0234a;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.BIKEKey;
import q4.C0789a;
import q4.C0791c;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, BIKEKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0791c f987a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f987a = (C0791c) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
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
            return Arrays.equals(g5.c.c(this.f987a.c), g5.c.c(((b) obj).f987a.c));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return e.c(((C0789a) this.f987a.b).f4676a);
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f987a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.BIKEKey
    public final C0234a getParameterSpec() {
        return (C0234a) C0234a.f1713a.get(e.b(((C0789a) this.f987a.b).f4676a));
    }

    public final int hashCode() {
        return g5.c.k(g5.c.c(this.f987a.c));
    }
}
