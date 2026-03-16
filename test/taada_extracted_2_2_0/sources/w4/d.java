package w4;

import c4.AbstractC0246d;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import w3.C0898p;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Encodable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5082a;
    public final o[] b;
    public final n c;

    public d(int i, o[] oVarArr, n nVar) {
        this.f5082a = i;
        this.b = oVarArr;
        this.c = nVar;
    }

    public static d a(int i, Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj instanceof DataInputStream) {
            int i3 = ((DataInputStream) obj).readInt();
            if (i3 != i - 1) {
                throw new IllegalStateException("nspk exceeded maxNspk");
            }
            o[] oVarArr = new o[i3];
            if (i3 != 0) {
                for (int i4 = 0; i4 < i3; i4++) {
                    oVarArr[i4] = new o(n.a(obj), m.b(obj));
                }
            }
            return new d(i3, oVarArr, n.a(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(i, AbstractC0246d.k0((InputStream) obj));
            }
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.m(obj, "cannot parse "));
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                d dVarA = a(i, dataInputStream2);
                dataInputStream2.close();
                return dVarA;
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
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f5082a == dVar.f5082a && Arrays.equals(this.b, dVar.b) && g5.c.a(this.c, dVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        C0898p c0898p = new C0898p();
        c0898p.h(this.f5082a);
        o[] oVarArr = this.b;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                c0898p.a(oVar);
            }
        }
        c0898p.a(this.c);
        return c0898p.f5069a.toByteArray();
    }

    public final int hashCode() {
        int i;
        int i3 = this.f5082a * 31;
        o[] oVarArr = this.b;
        if (oVarArr == null) {
            i = 0;
        } else {
            int length = oVarArr.length;
            int iJ = length + 1;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                iJ = (iJ * 257) ^ g5.c.j(oVarArr[length]);
            }
            i = iJ;
        }
        return g5.c.j(this.c) + ((i3 + i) * 31);
    }
}
