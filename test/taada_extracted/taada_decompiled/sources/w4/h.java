package w4;

import c4.AbstractC0246d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Encodable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f5086a;
    public final byte[] b;
    public final byte[] c;

    public h(f fVar, byte[] bArr, byte[] bArr2) {
        this.f5086a = fVar;
        this.b = bArr;
        this.c = bArr2;
    }

    public static h a(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            f fVarA = f.a(dataInputStream.readInt());
            byte[] bArr = new byte[fVarA.b];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[fVarA.d * fVarA.b];
            dataInputStream.readFully(bArr2);
            return new h(fVarA, bArr, bArr2);
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
                h hVarA = a(dataInputStream3);
                dataInputStream3.close();
                return hVarA;
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
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        f fVar = hVar.f5086a;
        f fVar2 = this.f5086a;
        if (fVar2 == null ? fVar != null : !fVar2.equals(fVar)) {
            return false;
        }
        if (Arrays.equals(this.b, hVar.b)) {
            return Arrays.equals(this.c, hVar.c);
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = this.f5086a.f5083a;
        byteArrayOutputStream.write((byte) 0);
        byteArrayOutputStream.write((byte) 0);
        byteArrayOutputStream.write((byte) 0);
        byteArrayOutputStream.write((byte) i);
        try {
            byteArrayOutputStream.write(this.b);
            try {
                byteArrayOutputStream.write(this.c);
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        } catch (Exception e6) {
            throw new RuntimeException(e6.getMessage(), e6);
        }
    }

    public final int hashCode() {
        f fVar = this.f5086a;
        return Arrays.hashCode(this.c) + ((Arrays.hashCode(this.b) + ((fVar != null ? fVar.hashCode() : 0) * 31)) * 31);
    }
}
