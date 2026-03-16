package w4;

import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier;
import w3.C0898p;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends j implements LMSContextBasedVerifier {
    public final p b;
    public final f c;
    public final byte[] d;
    public final byte[] e;

    public m(p pVar, f fVar, byte[] bArr, byte[] bArr2) {
        super(false);
        this.b = pVar;
        this.c = fVar;
        this.d = g5.c.c(bArr2);
        this.e = g5.c.c(bArr);
    }

    public static m b(Object obj) throws Throwable {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            p pVar = (p) p.e.get(Integer.valueOf(dataInputStream.readInt()));
            f fVarA = f.a(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[pVar.b];
            dataInputStream.readFully(bArr2);
            return new m(pVar, fVarA, bArr2, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return b(AbstractC0246d.k0((InputStream) obj));
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "cannot parse "));
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                m mVarB = b(dataInputStream3);
                dataInputStream3.close();
                return mVarB;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final i a(n nVar) {
        int i = this.c.f5083a;
        if (nVar.b.f5086a.f5083a != i) {
            throw new IllegalArgumentException("ots type from lsm signature does not match ots signature type from embedded ots signature");
        }
        f fVarA = f.a(i);
        byte[] bArr = this.d;
        int i3 = nVar.f5099a;
        g gVar = new g(i3, fVarA, bArr);
        Digest digestJ = io.ktor.utils.io.jvm.javaio.q.j(fVarA);
        t.c(bArr, digestJ);
        t.s(i3, digestJ);
        t.r((short) -32383, digestJ);
        t.c(nVar.b.b, digestJ);
        return new i(gVar, nVar, digestJ);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.b.equals(mVar.b) && this.c.equals(mVar.c) && Arrays.equals(this.d, mVar.d)) {
            return Arrays.equals(this.e, mVar.e);
        }
        return false;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public final i generateLMSContext(byte[] bArr) {
        try {
            return a(n.a(bArr));
        } catch (IOException e) {
            throw new IllegalStateException("cannot parse signature: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        return toByteArray();
    }

    public final int hashCode() {
        return g5.c.k(this.e) + ((g5.c.k(this.d) + ((this.c.hashCode() + (this.b.hashCode() * 31)) * 31)) * 31);
    }

    public final byte[] toByteArray() {
        C0898p c0898p = new C0898p();
        c0898p.h(this.b.f5101a);
        c0898p.h(this.c.f5083a);
        c0898p.b(this.d);
        c0898p.b(this.e);
        return c0898p.f5068a.toByteArray();
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public final boolean verify(i iVar) {
        return Z.w(this, iVar);
    }
}
