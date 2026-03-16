package a5;

import C5.f;
import E1.k;
import J4.i;
import J4.u;
import J4.v;
import c4.AbstractC0246d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.Arrays;
import o4.j;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey;
import w3.AbstractC0904w;
import w3.C0896n;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements PrivateKey, XMSSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient v f1564a;
    public transient C0896n b;
    public transient AbstractC0904w c;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.c = aVarB.d;
        this.b = j.b(aVarB.b.b).c.f747a;
        this.f1564a = (v) k.t(aVarB);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.b.f(cVar.b) && Arrays.equals(this.f1564a.toByteArray(), cVar.f1564a.toByteArray())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey
    public final XMSSPrivateKey extractKeyShard(int i) {
        v vVar;
        C0896n c0896n = this.b;
        v vVar2 = this.f1564a;
        if (i < 1) {
            vVar2.getClass();
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (vVar2) {
            long j6 = i;
            try {
                if (j6 > vVar2.getUsagesRemaining()) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
                u uVar = new u(vVar2.c);
                uVar.d = f.j(vVar2.d);
                uVar.e = f.j(vVar2.e);
                uVar.f911f = f.j(vVar2.f914f);
                uVar.f912g = f.j(vVar2.f915g);
                uVar.b = vVar2.f916h.i;
                J4.a aVar = vVar2.f916h;
                int i3 = (vVar2.f916h.i + i) - 1;
                C0896n c0896n2 = vVar2.c.d;
                aVar.getClass();
                uVar.f913h = new J4.a(aVar, i3, c0896n2);
                vVar = new v(uVar);
                if (j6 == vVar2.getUsagesRemaining()) {
                    vVar2.f916h = new J4.a(vVar2.c, vVar2.f916h.f878k, vVar2.f916h.i + i);
                } else {
                    J4.k kVar = new J4.k(new i(1));
                    for (int i4 = 0; i4 != i; i4++) {
                        J4.a aVar2 = vVar2.f916h;
                        byte[] bArr = vVar2.f914f;
                        byte[] bArr2 = vVar2.d;
                        aVar2.getClass();
                        vVar2.f916h = new J4.a(aVar2, bArr, bArr2, kVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c cVar = new c();
        cVar.b = c0896n;
        cVar.f1564a = vVar;
        return cVar;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.f1564a, this.c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSKey
    public final int getHeight() {
        return this.f1564a.c.b;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey
    public final long getIndex() {
        if (this.f1564a.getUsagesRemaining() != 0) {
            return this.f1564a.f916h.i;
        }
        throw new IllegalStateException("key exhausted");
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSKey
    public final String getTreeDigest() {
        return f.H(this.b);
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey
    public final long getUsagesRemaining() {
        return this.f1564a.getUsagesRemaining();
    }

    public final int hashCode() {
        return (g5.c.k(this.f1564a.toByteArray()) * 37) + g5.c.k(this.b.f5064a);
    }
}
