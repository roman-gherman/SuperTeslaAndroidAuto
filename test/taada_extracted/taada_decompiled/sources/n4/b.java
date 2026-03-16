package N4;

import H3.d;
import a.AbstractC0132a;
import b5.C0236c;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.DilithiumPublicKey;
import s4.C0814a;
import s4.C0816c;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements DilithiumPublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0816c f1172a;
    public transient String b;
    public transient byte[] c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C0816c c0816c = (C0816c) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
        this.f1172a = c0816c;
        this.b = e.c(((C0814a) c0816c.b).b);
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
            this.c = AbstractC0132a.C(this.f1172a);
        }
        return g5.c.c(this.c);
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.DilithiumKey
    public final C0236c getParameterSpec() {
        return (C0236c) C0236c.f1715a.get(e.b(((C0814a) this.f1172a.b).b));
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }
}
