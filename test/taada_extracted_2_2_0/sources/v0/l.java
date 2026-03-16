package v0;

import C0.y;
import G0.A1;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0.n f4914a;
    public static final C0.m b;
    public static final C0.b c;
    public static final C0.a d;

    static {
        I0.a aVarB = y.b("type.googleapis.com/google.crypto.tink.AesGcmKey");
        f4914a = new C0.n(j.class, new D0.b(29));
        b = new C0.m(aVarB, new k(0));
        c = new C0.b(i.class, new k(1));
        d = new C0.a(aVarB, new k(2));
    }

    public static A1 a(f fVar) throws GeneralSecurityException {
        if (f.f4898f.equals(fVar)) {
            return A1.TINK;
        }
        if (f.f4899g.equals(fVar)) {
            return A1.CRUNCHY;
        }
        if (f.f4900h.equals(fVar)) {
            return A1.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + fVar);
    }

    public static f b(A1 a12) throws GeneralSecurityException {
        int iOrdinal = a12.ordinal();
        if (iOrdinal == 1) {
            return f.f4898f;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return f.f4900h;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + a12.getNumber());
            }
        }
        return f.f4899g;
    }

    public static void c(j jVar) {
        if (jVar.c != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", Integer.valueOf(jVar.c)));
        }
        int i = jVar.b;
        if (i != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", Integer.valueOf(i)));
        }
    }
}
