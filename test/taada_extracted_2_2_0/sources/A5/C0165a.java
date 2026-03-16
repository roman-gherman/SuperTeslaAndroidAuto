package a5;

import C5.f;
import J4.p;
import J4.q;
import c4.AbstractC0246d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import o4.k;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey;
import w3.AbstractC0904w;
import w3.C0896n;

/* JADX INFO: renamed from: a5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0165a implements PrivateKey, XMSSMTPrivateKey {
    private static final long serialVersionUID = 7682140473044521395L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient C0896n f1562a;
    public transient q b;
    public transient AbstractC0904w c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.c = aVarB.d;
        this.f1562a = k.b(aVarB.b.b).d.f747a;
        this.b = (q) E1.k.t(aVarB);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0165a) {
            C0165a c0165a = (C0165a) obj;
            if (this.f1562a.f(c0165a.f1562a) && Arrays.equals(this.b.toByteArray(), c0165a.b.toByteArray())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey
    public final XMSSMTPrivateKey extractKeyShard(int i) {
        q qVar;
        C0896n c0896n = this.f1562a;
        q qVar2 = this.b;
        if (i < 1) {
            qVar2.getClass();
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (qVar2) {
            long j6 = i;
            try {
                if (j6 > qVar2.getUsagesRemaining()) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
                p pVar = new p(qVar2.c);
                pVar.d = f.j(qVar2.d);
                pVar.e = f.j(qVar2.e);
                pVar.f898f = f.j(qVar2.f901f);
                pVar.f899g = f.j(qVar2.f902g);
                pVar.b = qVar2.f903h;
                pVar.a(new J4.b(qVar2.i, (qVar2.f903h + j6) - 1));
                qVar = new q(pVar);
                for (int i3 = 0; i3 != i; i3++) {
                    qVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C0165a c0165a = new C0165a();
        c0165a.f1562a = c0896n;
        c0165a.b = qVar;
        return c0165a;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.b, this.c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public final int getHeight() {
        return this.b.c.c;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey
    public final long getIndex() {
        if (this.b.getUsagesRemaining() != 0) {
            return this.b.f903h;
        }
        throw new IllegalStateException("key exhausted");
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public final int getLayers() {
        return this.b.c.d;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public final String getTreeDigest() {
        return f.H(this.f1562a);
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey
    public final long getUsagesRemaining() {
        return this.b.getUsagesRemaining();
    }

    public final int hashCode() {
        return (g5.c.k(this.b.toByteArray()) * 37) + g5.c.k(this.f1562a.f5065a);
    }
}
