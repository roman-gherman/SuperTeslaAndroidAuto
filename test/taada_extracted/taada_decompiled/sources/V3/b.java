package V3;

import N3.g;
import a.AbstractC0132a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.bouncycastle.jcajce.interfaces.MLKEMPublicKey;
import z4.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements MLKEMPublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient e f1375a;
    public transient String b;

    public b(e eVar) {
        this.f1375a = eVar;
        this.b = g5.e.c(Y3.c.a(((z4.c) eVar.b).f5211a).f1489a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        e eVar = (e) I4.b.a(H3.d.b((byte[]) objectInputStream.readObject()));
        this.f1375a = eVar;
        this.b = g5.e.c(Y3.c.a(((z4.c) eVar.b).f5211a).f1489a);
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
        try {
            return AbstractC0132a.r(this.f1375a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMKey
    public final Y3.c getParameterSpec() {
        return Y3.c.a(((z4.c) this.f1375a.b).f5211a);
    }

    @Override // org.bouncycastle.jcajce.interfaces.MLKEMPublicKey
    public final byte[] getPublicData() {
        return this.f1375a.getEncoded();
    }

    public final int hashCode() {
        return g5.c.k(getEncoded());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = g5.e.f3346a;
        byte[] encoded = this.f1375a.getEncoded();
        sb.append(this.b);
        sb.append(" Public Key [");
        g gVar = new g(256);
        gVar.update(encoded, 0, encoded.length);
        byte[] bArr = new byte[20];
        gVar.doFinal(bArr, 0, 20);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != 20; i++) {
            if (i > 0) {
                stringBuffer.append(":");
            }
            char[] cArr = g5.c.f3344a;
            stringBuffer.append(cArr[(bArr[i] >>> 4) & 15]);
            stringBuffer.append(cArr[bArr[i] & 15]);
        }
        sb.append(stringBuffer.toString());
        sb.append("]");
        sb.append(str);
        sb.append("    public data: ");
        sb.append(g5.e.a(h5.b.b(encoded.length, encoded)));
        sb.append(str);
        return sb.toString();
    }
}
