package D0;

import C0.y;
import G0.A1;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0.n f239a;
    public static final C0.m b;
    public static final C0.b c;
    public static final C0.a d;

    static {
        I0.a aVarB = y.b("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f239a = new C0.n(g.class, new b(1));
        b = new C0.m(aVarB, new b(2));
        c = new C0.b(a.class, new b(3));
        d = new C0.a(aVarB, new b(4));
    }

    public static A1 a(f fVar) throws GeneralSecurityException {
        if (f.c.equals(fVar)) {
            return A1.TINK;
        }
        if (f.d.equals(fVar)) {
            return A1.CRUNCHY;
        }
        if (f.f228f.equals(fVar)) {
            return A1.RAW;
        }
        if (f.e.equals(fVar)) {
            return A1.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + fVar);
    }

    public static f b(A1 a12) throws GeneralSecurityException {
        int iOrdinal = a12.ordinal();
        if (iOrdinal == 1) {
            return f.c;
        }
        if (iOrdinal == 2) {
            return f.e;
        }
        if (iOrdinal == 3) {
            return f.f228f;
        }
        if (iOrdinal == 4) {
            return f.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + a12.getNumber());
    }
}
