package w4;

import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier;

/* JADX INFO: renamed from: w4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0910c extends j implements LMSContextBasedVerifier {
    public final int b;
    public final m c;

    public C0910c(int i, m mVar) {
        super(false);
        if (mVar == null) {
            throw new NullPointerException("lmsPublicKey");
        }
        this.b = i;
        this.c = mVar;
    }

    public static C0910c a(Object obj) {
        if (obj instanceof C0910c) {
            return (C0910c) obj;
        }
        if (obj instanceof DataInputStream) {
            return new C0910c(((DataInputStream) obj).readInt(), m.b(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(AbstractC0246d.k0((InputStream) obj));
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "cannot parse "));
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                C0910c c0910cA = a(dataInputStream2);
                dataInputStream2.close();
                return c0910cA;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0910c.class != obj.getClass()) {
            return false;
        }
        C0910c c0910c = (C0910c) obj;
        if (this.b != c0910c.b) {
            return false;
        }
        return this.c.equals(c0910c.c);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public final i generateLMSContext(byte[] bArr) {
        try {
            d dVarA = d.a(this.b, bArr);
            o[] oVarArr = dVarA.b;
            i iVarA = (oVarArr.length != 0 ? oVarArr[oVarArr.length - 1].b : this.c).a(dVarA.c);
            iVarA.f5090g = oVarArr;
            return iVarA;
        } catch (IOException e) {
            throw new IllegalStateException("cannot parse signature: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = this.b;
        byteArrayOutputStream.write((byte) (i >>> 24));
        byteArrayOutputStream.write((byte) (i >>> 16));
        byteArrayOutputStream.write((byte) (i >>> 8));
        byteArrayOutputStream.write((byte) i);
        try {
            byteArrayOutputStream.write(this.c.toByteArray());
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b * 31);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier
    public final boolean verify(i iVar) {
        o[] oVarArr = iVar.f5090g;
        boolean zW = true;
        if (oVarArr.length != this.b - 1) {
            return false;
        }
        m mVar = this.c;
        for (int i = 0; i < oVarArr.length; i++) {
            o oVar = oVarArr[i];
            n nVar = oVar.f5101a;
            byte[] byteArray = oVar.b.toByteArray();
            i iVarA = mVar.a(nVar);
            t.c(byteArray, iVarA);
            zW &= Z.w(mVar, iVarA);
            mVar = oVarArr[i].b;
        }
        mVar.getClass();
        return Z.w(mVar, iVar) & zW;
    }
}
