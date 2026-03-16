package w4;

import c4.AbstractC0246d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import w3.C0898p;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Encodable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5100a;
    public final h b;
    public final p c;
    public final byte[][] d;

    public n(int i, h hVar, p pVar, byte[][] bArr) {
        this.f5100a = i;
        this.b = hVar;
        this.c = pVar;
        this.d = bArr;
    }

    public static n a(Object obj) throws Throwable {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            int i = dataInputStream.readInt();
            h hVarA = h.a(obj);
            p pVar = (p) p.e.get(Integer.valueOf(dataInputStream.readInt()));
            int i3 = pVar.c;
            byte[][] bArr = new byte[i3][];
            for (int i4 = 0; i4 < i3; i4++) {
                byte[] bArr2 = new byte[pVar.b];
                bArr[i4] = bArr2;
                dataInputStream.readFully(bArr2);
            }
            return new n(i, hVarA, pVar, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(AbstractC0246d.k0((InputStream) obj));
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "cannot parse "));
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                n nVarA = a(dataInputStream3);
                dataInputStream3.close();
                return nVarA;
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f5100a != nVar.f5100a) {
            return false;
        }
        h hVar = nVar.b;
        h hVar2 = this.b;
        if (hVar2 == null ? hVar != null : !hVar2.equals(hVar)) {
            return false;
        }
        p pVar = nVar.c;
        p pVar2 = this.c;
        if (pVar2 == null ? pVar == null : pVar2.equals(pVar)) {
            return Arrays.deepEquals(this.d, nVar.d);
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        C0898p c0898p = new C0898p();
        c0898p.h(this.f5100a);
        c0898p.b(this.b.getEncoded());
        c0898p.h(this.c.f5102a);
        byte[][] bArr = this.d;
        try {
            int length = bArr.length;
            int i = 0;
            while (true) {
                ByteArrayOutputStream byteArrayOutputStream = c0898p.f5069a;
                if (i >= length) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr[i]);
                i++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public final int hashCode() {
        int i = this.f5100a * 31;
        h hVar = this.b;
        int iHashCode = (i + (hVar != null ? hVar.hashCode() : 0)) * 31;
        p pVar = this.c;
        return Arrays.deepHashCode(this.d) + ((iHashCode + (pVar != null ? pVar.hashCode() : 0)) * 31);
    }
}
