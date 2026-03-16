package D0;

import C0.y;
import G0.A0;
import G0.A1;
import G0.C0100z0;
import G0.EnumC0086s0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0.n f245a;
    public static final C0.m b;
    public static final C0.b c;
    public static final C0.a d;

    static {
        I0.a aVarB = y.b("type.googleapis.com/google.crypto.tink.HmacKey");
        f245a = new C0.n(n.class, new b(6));
        b = new C0.m(aVarB, new b(7));
        c = new C0.b(l.class, new b(8));
        d = new C0.a(aVarB, new b(9));
    }

    public static A0 a(n nVar) {
        EnumC0086s0 enumC0086s0;
        C0100z0 c0100z0W = A0.w();
        int i = nVar.b;
        c0100z0W.p();
        A0.u((A0) c0100z0W.b, i);
        f fVar = f.f229g;
        f fVar2 = nVar.d;
        if (fVar.equals(fVar2)) {
            enumC0086s0 = EnumC0086s0.SHA1;
        } else if (f.f230h.equals(fVar2)) {
            enumC0086s0 = EnumC0086s0.SHA224;
        } else if (f.i.equals(fVar2)) {
            enumC0086s0 = EnumC0086s0.SHA256;
        } else if (f.f231j.equals(fVar2)) {
            enumC0086s0 = EnumC0086s0.SHA384;
        } else {
            if (!f.f232k.equals(fVar2)) {
                throw new GeneralSecurityException("Unable to serialize HashType " + fVar2);
            }
            enumC0086s0 = EnumC0086s0.SHA512;
        }
        c0100z0W.p();
        A0.t((A0) c0100z0W.b, enumC0086s0);
        return (A0) c0100z0W.build();
    }

    public static f b(EnumC0086s0 enumC0086s0) throws GeneralSecurityException {
        int iOrdinal = enumC0086s0.ordinal();
        if (iOrdinal == 1) {
            return f.f229g;
        }
        if (iOrdinal == 2) {
            return f.f231j;
        }
        if (iOrdinal == 3) {
            return f.i;
        }
        if (iOrdinal == 4) {
            return f.f232k;
        }
        if (iOrdinal == 5) {
            return f.f230h;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + enumC0086s0.getNumber());
    }

    public static A1 c(f fVar) throws GeneralSecurityException {
        if (f.f233l.equals(fVar)) {
            return A1.TINK;
        }
        if (f.f234m.equals(fVar)) {
            return A1.CRUNCHY;
        }
        if (f.f236o.equals(fVar)) {
            return A1.RAW;
        }
        if (f.f235n.equals(fVar)) {
            return A1.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + fVar);
    }

    public static f d(A1 a12) throws GeneralSecurityException {
        int iOrdinal = a12.ordinal();
        if (iOrdinal == 1) {
            return f.f233l;
        }
        if (iOrdinal == 2) {
            return f.f235n;
        }
        if (iOrdinal == 3) {
            return f.f236o;
        }
        if (iOrdinal == 4) {
            return f.f234m;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + a12.getNumber());
    }
}
