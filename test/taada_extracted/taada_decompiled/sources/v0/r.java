package v0;

import C0.y;
import G0.A1;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0.n f4919a;
    public static final C0.m b;
    public static final C0.b c;
    public static final C0.a d;

    static {
        I0.a aVarB = y.b("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        f4919a = new C0.n(q.class, new k(7));
        b = new C0.m(aVarB, new k(8));
        c = new C0.b(p.class, new k(9));
        d = new C0.a(aVarB, new k(10));
    }

    public static A1 a(f fVar) throws GeneralSecurityException {
        if (f.f4902l.equals(fVar)) {
            return A1.TINK;
        }
        if (f.f4903m.equals(fVar)) {
            return A1.CRUNCHY;
        }
        if (f.f4904n.equals(fVar)) {
            return A1.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + fVar);
    }

    public static f b(A1 a12) {
        int iOrdinal = a12.ordinal();
        if (iOrdinal == 1) {
            return f.f4902l;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return f.f4904n;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + a12.getNumber());
            }
        }
        return f.f4903m;
    }
}
