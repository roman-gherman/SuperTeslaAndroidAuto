package R4;

import E1.k;
import c4.AbstractC0246d;
import g5.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey;
import w3.AbstractC0904w;
import w4.C0909b;
import w4.j;
import w4.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PrivateKey, LMSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient j f1274a;
    public transient AbstractC0904w b;

    public a(j jVar) {
        C0909b c0909b;
        if (jVar instanceof C0909b) {
            c0909b = (C0909b) jVar;
        } else {
            l lVar = (l) jVar;
            c0909b = new C0909b(lVar, lVar.d(), ((long) lVar.d()) + lVar.getUsagesRemaining());
        }
        this.f1274a = c0909b;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        C3.a aVarB = C3.a.b((byte[]) objectInputStream.readObject());
        this.b = aVarB.d;
        this.f1274a = (j) k.t(aVarB);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        try {
            return Arrays.equals(this.f1274a.getEncoded(), ((a) obj).f1274a.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to perform equals");
        }
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public final LMSPrivateKey extractKeyShard(int i) {
        long j6;
        long j7;
        ArrayList arrayList;
        List list;
        l lVar;
        j jVar = this.f1274a;
        if (jVar instanceof l) {
            l lVar2 = (l) jVar;
            synchronized (lVar2) {
                if (i < 0) {
                    throw new IllegalArgumentException("usageCount cannot be negative");
                }
                int i3 = lVar2.e;
                int i4 = lVar2.f5098j;
                if (i > i3 - i4) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
                int i5 = i + i4;
                lVar2.f5098j = i5;
                lVar = new l(lVar2, i4, i5);
            }
            return new a(lVar);
        }
        C0909b c0909b = (C0909b) jVar;
        try {
            synchronized (c0909b) {
                if (i < 0) {
                    throw new IllegalArgumentException("usageCount cannot be negative");
                }
                long j8 = i;
                long j9 = c0909b.f5080f;
                j6 = c0909b.f5081g;
                if (j8 > j9 - j6) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");
                }
                j7 = j6 + j8;
                c0909b.f5081g = j7;
                arrayList = new ArrayList(c0909b.b());
                synchronized (c0909b) {
                    list = c0909b.e;
                }
                return new a(c0909bA);
            }
            C0909b c0909bA = C0909b.a(new C0909b(c0909b.b, arrayList, new ArrayList(list), j6, j7, true).getEncoded());
            c0909b.d();
            return new a(c0909bA);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        try {
            return AbstractC0246d.y(this.f1274a, this.b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public final long getIndex() {
        long j6;
        if (getUsagesRemaining() == 0) {
            throw new IllegalStateException("key exhausted");
        }
        j jVar = this.f1274a;
        if (jVar instanceof l) {
            return ((l) jVar).d();
        }
        C0909b c0909b = (C0909b) jVar;
        synchronized (c0909b) {
            j6 = c0909b.f5081g;
        }
        return j6;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public final int getLevels() {
        j jVar = this.f1274a;
        if (jVar instanceof l) {
            return 1;
        }
        return ((C0909b) jVar).b;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public final long getUsagesRemaining() {
        j jVar = this.f1274a;
        return jVar instanceof l ? ((l) jVar).getUsagesRemaining() : ((C0909b) jVar).getUsagesRemaining();
    }

    public final int hashCode() {
        try {
            return c.k(this.f1274a.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }
}
