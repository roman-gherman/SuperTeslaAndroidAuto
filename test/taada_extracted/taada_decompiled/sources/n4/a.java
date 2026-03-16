package N4;

import E1.k;
import a.AbstractC0132a;
import b5.C0236c;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.DilithiumPrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.DilithiumPublicKey;
import s4.C0814a;
import s4.C0815b;
import s4.C0816c;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements DilithiumPrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0815b f1171a;
    public transient String b;
    public transient byte[] c;
    public transient AbstractC0904w d;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        C0815b c0815b = (C0815b) k.t(aVarB);
        this.d = aVarB.d;
        this.f1171a = c0815b;
        this.b = e.c(((C0814a) c0815b.b).b);
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
            this.c = AbstractC0132a.B(this.f1171a, this.d);
        }
        return g5.c.c(this.c);
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.DilithiumKey
    public final C0236c getParameterSpec() {
        return (C0236c) C0236c.f1715a.get(e.b(((C0814a) this.f1171a.b).b));
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.DilithiumPrivateKey
    public final DilithiumPublicKey getPublicKey() {
        C0815b c0815b = this.f1171a;
        byte[] bArr = c0815b.c;
        C0814a c0814a = (C0814a) c0815b.b;
        C0816c c0816c = new C0816c(c0814a, bArr, c0815b.i);
        b bVar = new b();
        bVar.f1172a = c0816c;
        bVar.b = e.c(c0814a.b);
        return bVar;
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }
}
