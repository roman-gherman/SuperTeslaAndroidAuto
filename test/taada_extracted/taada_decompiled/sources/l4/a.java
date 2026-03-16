package L4;

import E1.k;
import b5.C0234a;
import c4.AbstractC0246d;
import g5.e;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.BIKEKey;
import q4.C0789a;
import q4.C0790b;
import w3.AbstractC0904w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, BIKEKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0790b f986a;
    public transient AbstractC0904w b;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.b = aVarB.d;
        this.f986a = (C0790b) k.t(aVarB);
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
            return Arrays.equals(this.f986a.getEncoded(), ((a) obj).f986a.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return e.c(((C0789a) this.f986a.b).f4675a);
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.f986a, this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.BIKEKey
    public final C0234a getParameterSpec() {
        return (C0234a) C0234a.f1713a.get(e.b(((C0789a) this.f986a.b).f4675a));
    }

    public final int hashCode() {
        return g5.c.k(this.f986a.getEncoded());
    }
}
