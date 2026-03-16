package w4;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Encodable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f5100a;
    public final m b;

    public o(n nVar, m mVar) {
        this.f5100a = nVar;
        this.b = mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            n nVar = oVar.f5100a;
            n nVar2 = this.f5100a;
            if (nVar2 == null ? nVar != null : !nVar2.equals(nVar)) {
                return false;
            }
            m mVar = oVar.b;
            m mVar2 = this.b;
            if (mVar2 != null) {
                return mVar2.equals(mVar);
            }
            if (mVar == null) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public final byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f5100a.getEncoded());
            try {
                byteArrayOutputStream.write(this.b.toByteArray());
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        } catch (Exception e6) {
            throw new RuntimeException(e6.getMessage(), e6);
        }
    }

    public final int hashCode() {
        n nVar = this.f5100a;
        int iHashCode = (nVar != null ? nVar.hashCode() : 0) * 31;
        m mVar = this.b;
        return iHashCode + (mVar != null ? mVar.hashCode() : 0);
    }
}
