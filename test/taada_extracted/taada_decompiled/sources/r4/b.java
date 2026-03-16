package R4;

import H3.d;
import a.AbstractC0132a;
import g5.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.util.Arrays;
import org.bouncycastle.pqc.jcajce.interfaces.LMSKey;
import w4.C0910c;
import w4.j;
import w4.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements PublicKey, LMSKey {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient j f1275a;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f1275a = (j) I4.b.a(d.b((byte[]) objectInputStream.readObject()));
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
            try {
                return Arrays.equals(this.f1275a.getEncoded(), ((b) obj).f1275a.getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0132a.r(this.f1275a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public final int getLevels() {
        j jVar = this.f1275a;
        if (jVar instanceof m) {
            return 1;
        }
        return ((C0910c) jVar).b;
    }

    public final int hashCode() {
        try {
            return c.k(this.f1275a.getEncoded());
        } catch (IOException unused) {
            return -1;
        }
    }
}
