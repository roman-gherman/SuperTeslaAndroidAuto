package Q3;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements CipherParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f1237a;
    public final BigInteger b;
    public final BigInteger c;
    public final d d;

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, d dVar) {
        this.f1237a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
        this.d = dVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.c.equals(this.c)) {
            if (cVar.b.equals(this.b)) {
                if (cVar.f1237a.equals(this.f1237a)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.c.hashCode() ^ this.b.hashCode()) ^ this.f1237a.hashCode();
    }
}
