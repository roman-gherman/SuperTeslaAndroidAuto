package D0;

import G0.A0;
import G0.C0038b;
import G0.C0044d;
import G0.C0050f;
import G0.C0094w0;
import G0.C0096x0;
import G0.C0098y0;
import G0.C0100z0;
import G0.EnumC0046d1;
import G0.EnumC0086s0;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.C;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class e extends C0.e {
    public static final C0.o e = new C0.o(a.class, new b(0));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0.o f227f = new C0.o(l.class, new b(5));
    public final /* synthetic */ int d = 1;

    public /* synthetic */ e(Class cls, c[] cVarArr) {
        super(cls, cVarArr);
    }

    public static C0.c h(int i, int i3, EnumC0086s0 enumC0086s0, int i4) {
        C0096x0 c0096x0W = C0098y0.w();
        C0100z0 c0100z0W = A0.w();
        c0100z0W.p();
        A0.t((A0) c0100z0W.b, enumC0086s0);
        c0100z0W.p();
        A0.u((A0) c0100z0W.b, i3);
        A0 a02 = (A0) c0100z0W.build();
        c0096x0W.p();
        C0098y0.t((C0098y0) c0096x0W.b, a02);
        c0096x0W.p();
        C0098y0.u((C0098y0) c0096x0W.b, i);
        return new C0.c((C0098y0) c0096x0W.build(), i4);
    }

    public static void i(C0050f c0050f) {
        if (c0050f.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (c0050f.getTagSize() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void j(A0 a02) {
        if (a02.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iOrdinal = a02.getHash().ordinal();
        if (iOrdinal == 1) {
            if (a02.getTagSize() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 2) {
            if (a02.getTagSize() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iOrdinal == 3) {
            if (a02.getTagSize() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (iOrdinal == 4) {
            if (a02.getTagSize() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (iOrdinal != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (a02.getTagSize() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // C0.e
    public int a() {
        switch (this.d) {
            case 1:
                return 2;
            default:
                return super.a();
        }
    }

    @Override // C0.e
    public final String b() {
        switch (this.d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCmacKey";
            default:
                return "type.googleapis.com/google.crypto.tink.HmacKey";
        }
    }

    @Override // C0.e
    public final C0.d d() {
        switch (this.d) {
            case 0:
                return new d(C0044d.class, 0);
            default:
                return new m(this);
        }
    }

    @Override // C0.e
    public final EnumC0046d1 e() {
        switch (this.d) {
        }
        return EnumC0046d1.SYMMETRIC;
    }

    @Override // C0.e
    public final MessageLite f(AbstractC0381o abstractC0381o) {
        switch (this.d) {
            case 0:
                return C0038b.x(abstractC0381o, D.a());
            default:
                return C0094w0.y(abstractC0381o, D.a());
        }
    }

    @Override // C0.e
    public final void g(MessageLite messageLite) throws GeneralSecurityException {
        switch (this.d) {
            case 0:
                C0038b c0038b = (C0038b) messageLite;
                C.c(c0038b.getVersion());
                if (c0038b.getKeyValue().size() != 32) {
                    throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
                }
                i(c0038b.getParams());
                return;
            default:
                C0094w0 c0094w0 = (C0094w0) messageLite;
                C.c(c0094w0.getVersion());
                if (c0094w0.getKeyValue().size() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                j(c0094w0.getParams());
                return;
        }
    }

    public e() {
        super(C0094w0.class, new c(Mac.class, 1));
    }
}
