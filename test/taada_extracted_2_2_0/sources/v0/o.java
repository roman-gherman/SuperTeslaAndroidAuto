package v0;

import C0.y;
import G0.A1;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0.n f4917a;
    public static final C0.m b;
    public static final C0.b c;
    public static final C0.a d;

    static {
        I0.a aVarB = y.b("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        f4917a = new C0.n(n.class, new k(3));
        b = new C0.m(aVarB, new k(4));
        c = new C0.b(m.class, new k(5));
        d = new C0.a(aVarB, new k(6));
    }

    public static A1 a(f fVar) throws GeneralSecurityException {
        if (f.i.equals(fVar)) {
            return A1.TINK;
        }
        if (f.f4901j.equals(fVar)) {
            return A1.CRUNCHY;
        }
        if (f.f4902k.equals(fVar)) {
            return A1.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + fVar);
    }

    public static f b(A1 a12) throws GeneralSecurityException {
        int iOrdinal = a12.ordinal();
        if (iOrdinal == 1) {
            return f.i;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return f.f4902k;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + a12.getNumber());
            }
        }
        return f.f4901j;
    }
}
