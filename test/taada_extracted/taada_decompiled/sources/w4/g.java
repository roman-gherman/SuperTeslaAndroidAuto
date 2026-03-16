package w4;

import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import w3.C0898p;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Encodable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f5085a;
    public final byte[] b;
    public final int c;

    public g(int i, f fVar, byte[] bArr) {
        this.f5085a = fVar;
        this.b = bArr;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.c == gVar.c && g5.c.a(this.f5085a, gVar.f5085a) && Arrays.equals(this.b, gVar.b) && Arrays.equals((byte[]) null, (byte[]) null);
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        C0898p c0898p = new C0898p();
        c0898p.h(this.f5085a.f5083a);
        c0898p.b(this.b);
        c0898p.h(this.c);
        c0898p.b(null);
        return c0898p.f5068a.toByteArray();
    }

    public final int hashCode() {
        return (g5.c.k(this.b) + ((g5.c.j(this.f5085a) + (this.c * 31)) * 31)) * 31;
    }
}
