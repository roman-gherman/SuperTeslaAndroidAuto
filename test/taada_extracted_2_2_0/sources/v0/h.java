package v0;

import C0.y;
import G0.A;
import G0.A1;
import G0.B;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0.n f4910a;
    public static final C0.m b;
    public static final C0.b c;
    public static final C0.a d;

    static {
        I0.a aVarB = y.b("type.googleapis.com/google.crypto.tink.AesEaxKey");
        f4910a = new C0.n(g.class, new D0.b(25));
        b = new C0.m(aVarB, new D0.b(26));
        c = new C0.b(e.class, new D0.b(27));
        d = new C0.a(aVarB, new D0.b(28));
    }

    public static B a(g gVar) {
        if (gVar.c != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(gVar.c)));
        }
        A aV = B.v();
        aV.p();
        B.t((B) aV.b, gVar.b);
        return (B) aV.build();
    }

    public static A1 b(f fVar) throws GeneralSecurityException {
        if (f.c.equals(fVar)) {
            return A1.TINK;
        }
        if (f.d.equals(fVar)) {
            return A1.CRUNCHY;
        }
        if (f.e.equals(fVar)) {
            return A1.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + fVar);
    }

    public static f c(A1 a12) throws GeneralSecurityException {
        int iOrdinal = a12.ordinal();
        if (iOrdinal == 1) {
            return f.c;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return f.e;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + a12.getNumber());
            }
        }
        return f.d;
    }
}
