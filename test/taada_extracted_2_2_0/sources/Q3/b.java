package Q3;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements CipherParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f1236a;
    public BigInteger b;
    public BigInteger c;

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        BigInteger bigInteger = this.c;
        if (bigInteger != null) {
            if (!bigInteger.equals(bVar.c)) {
                return false;
            }
        } else if (bVar.c != null) {
            return false;
        }
        if (bVar.b.equals(this.b)) {
            if (bVar.f1236a.equals(this.f1236a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() ^ this.f1236a.hashCode();
        BigInteger bigInteger = this.c;
        return iHashCode ^ (bigInteger != null ? bigInteger.hashCode() : 0);
    }
}
