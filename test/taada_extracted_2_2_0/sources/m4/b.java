package M4;

import a.AbstractC0132a;
import b5.C0235b;
import g5.c;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.CMCEKey;
import r4.C0806b;
import r4.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, CMCEKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient d f1116a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f1116a = (d) I4.b.a(H3.d.b((byte[]) objectInputStream.readObject()));
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
            return Arrays.equals(c.c(this.f1116a.c), c.c(((b) obj).f1116a.c));
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return e.c(((C0806b) this.f1116a.b).f4738a);
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1116a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.CMCEKey
    public final C0235b getParameterSpec() {
        return (C0235b) C0235b.f1714a.get(e.b(((C0806b) this.f1116a.b).f4738a));
    }

    public final int hashCode() {
        return c.k(c.c(this.f1116a.c));
    }
}
