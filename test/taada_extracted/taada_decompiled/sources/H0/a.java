package H0;

import D0.m;
import G0.A;
import G0.A0;
import G0.B;
import G0.C0056h;
import G0.C0059i;
import G0.C0062j;
import G0.C0068l;
import G0.C0071m;
import G0.C0074n;
import G0.C0077o;
import G0.C0080p;
import G0.C0085s;
import G0.C0087t;
import G0.C0089u;
import G0.C0091v;
import G0.C0094w0;
import G0.C0095x;
import G0.C0096x0;
import G0.C0097y;
import G0.C0098y0;
import G0.C0099z;
import G0.C0100z0;
import G0.E;
import G0.EnumC0046d1;
import G0.EnumC0086s0;
import G0.F;
import G0.G;
import G0.H;
import G0.J;
import G0.K;
import G0.L;
import G0.M1;
import G0.N;
import G0.O;
import G0.P;
import G0.S;
import G0.W;
import G0.r;
import G0.t1;
import G0.x1;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.C;
import com.google.crypto.tink.subtle.IndCpaCipher;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a extends C0.e {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Class cls, D0.c[] cVarArr, int i) {
        super(cls, cVarArr);
        this.d = i;
    }

    public static C0.c h(int i, int i3) {
        C0097y c0097yV = C0099z.v();
        c0097yV.p();
        C0099z.u((C0099z) c0097yV.b, i);
        A aV = B.v();
        aV.p();
        B.t((B) aV.b, 16);
        B b = (B) aV.build();
        c0097yV.p();
        C0099z.t((C0099z) c0097yV.b, b);
        return new C0.c((C0099z) c0097yV.build(), i3);
    }

    public static C0.c i(int i, int i3, int i4) {
        EnumC0086s0 enumC0086s0 = EnumC0086s0.SHA256;
        C0085s c0085sW = C0087t.w();
        C0089u c0089uV = C0091v.v();
        c0089uV.p();
        C0091v.t((C0091v) c0089uV.b);
        C0091v c0091v = (C0091v) c0089uV.build();
        c0085sW.p();
        C0087t.t((C0087t) c0085sW.b, c0091v);
        c0085sW.p();
        C0087t.u((C0087t) c0085sW.b, i);
        C0087t c0087t = (C0087t) c0085sW.build();
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
        C0098y0.u((C0098y0) c0096x0W.b, 32);
        C0098y0 c0098y0 = (C0098y0) c0096x0W.build();
        C0059i c0059iV = C0062j.v();
        c0059iV.p();
        C0062j.t((C0062j) c0059iV.b, c0087t);
        c0059iV.p();
        C0062j.u((C0062j) c0059iV.b, c0098y0);
        return new C0.c((C0062j) c0059iV.build(), i4);
    }

    public static C0.c j(int i, int i3) {
        K kU = L.u();
        kU.p();
        L.t((L) kU.b, i);
        return new C0.c((L) kU.build(), i3);
    }

    public static C0.c k(int i, int i3) {
        O oU = P.u();
        oU.p();
        P.t((P) oU.b, i);
        return new C0.c((P) oU.build(), i3);
    }

    public static C0074n l(int i, int i3, int i4) {
        EnumC0086s0 enumC0086s0 = EnumC0086s0.SHA256;
        C0100z0 c0100z0W = A0.w();
        c0100z0W.p();
        A0.t((A0) c0100z0W.b, enumC0086s0);
        c0100z0W.p();
        A0.u((A0) c0100z0W.b, 32);
        A0 a02 = (A0) c0100z0W.build();
        C0077o c0077oY = C0080p.y();
        c0077oY.p();
        C0080p.t((C0080p) c0077oY.b, i4);
        c0077oY.p();
        C0080p.u((C0080p) c0077oY.b, i3);
        c0077oY.p();
        C0080p.v((C0080p) c0077oY.b);
        c0077oY.p();
        C0080p.w((C0080p) c0077oY.b, a02);
        C0080p c0080p = (C0080p) c0077oY.build();
        C0071m c0071mV = C0074n.v();
        c0071mV.p();
        C0074n.t((C0074n) c0071mV.b, c0080p);
        c0071mV.p();
        C0074n.u((C0074n) c0071mV.b, i);
        return (C0074n) c0071mV.build();
    }

    public static F m(int i, int i3, int i4) {
        G gX = H.x();
        gX.p();
        H.t((H) gX.b, i4);
        gX.p();
        H.u((H) gX.b, i3);
        gX.p();
        H.v((H) gX.b);
        H h3 = (H) gX.build();
        E eV = F.v();
        eV.p();
        F.u((F) eV.b, i);
        eV.p();
        F.t((F) eV.b, h3);
        return (F) eV.build();
    }

    public static void n(C0080p c0080p) throws GeneralSecurityException {
        C.a(c0080p.getDerivedKeySize());
        if (c0080p.getHkdfHashType() != EnumC0086s0.SHA1 && c0080p.getHkdfHashType() != EnumC0086s0.SHA256 && c0080p.getHkdfHashType() != EnumC0086s0.SHA512) {
            throw new GeneralSecurityException("Invalid HKDF hash type: " + c0080p.getHkdfHashType().getNumber());
        }
        if (c0080p.getHmacParams().getHash() == EnumC0086s0.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
        A0 hmacParams = c0080p.getHmacParams();
        if (hmacParams.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iOrdinal = hmacParams.getHash().ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new GeneralSecurityException("unknown hash type");
                }
                if (hmacParams.getTagSize() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (hmacParams.getTagSize() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (hmacParams.getTagSize() > 20) {
            throw new GeneralSecurityException("tag size too big");
        }
        if (c0080p.getCiphertextSegmentSize() < c0080p.getHmacParams().getTagSize() + c0080p.getDerivedKeySize() + 9) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
        }
    }

    public static void o(H h3) throws GeneralSecurityException {
        C.a(h3.getDerivedKeySize());
        if (h3.getHkdfHashType() == EnumC0086s0.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        }
        if (h3.getCiphertextSegmentSize() < h3.getDerivedKeySize() + 25) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + NONCE_PREFIX_IN_BYTES + TAG_SIZE_IN_BYTES + 2)");
        }
    }

    @Override // C0.e
    public int a() {
        switch (this.d) {
            case 2:
                return 2;
            case 3:
            default:
                return super.a();
            case 4:
                return 2;
        }
    }

    @Override // C0.e
    public final String b() {
        switch (this.d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
            case 1:
                return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
            case 2:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
            case 3:
                return "type.googleapis.com/google.crypto.tink.AesEaxKey";
            case 4:
                return "type.googleapis.com/google.crypto.tink.AesGcmKey";
            case 5:
                return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
            case 6:
                return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
            case 7:
                return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
            case 8:
                return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
            case 9:
                return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
            default:
                return "type.googleapis.com/google.crypto.tink.AesSivKey";
        }
    }

    @Override // C0.e
    public final C0.d d() {
        switch (this.d) {
            case 0:
                return new m(this);
            case 1:
                return new m(this, (byte) 0);
            case 2:
                return new m(this, (char) 0);
            case 3:
                return new m(this, 0);
            case 4:
                return new m(this, (short) 0);
            case 5:
                return new m(this, (byte) 0, false);
            case 6:
                return new m(this, (byte) 0, (byte) 0);
            case 7:
                return new m(this, (byte) 0, (char) 0);
            case 8:
                return new m(this, (byte) 0, 0);
            case 9:
                return new m(this, (byte) 0, (short) 0);
            default:
                return new m(this, (char) 0, false);
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
                return C0068l.x(abstractC0381o, D.a());
            case 1:
                return G0.D.x(abstractC0381o, D.a());
            case 2:
                return C0056h.x(abstractC0381o, D.a());
            case 3:
                return C0095x.x(abstractC0381o, D.a());
            case 4:
                return J.w(abstractC0381o, D.a());
            case 5:
                return N.w(abstractC0381o, D.a());
            case 6:
                return W.w(abstractC0381o, D.a());
            case 7:
                return t1.w(abstractC0381o, D.a());
            case 8:
                return x1.w(abstractC0381o, D.a());
            case 9:
                return M1.w(abstractC0381o, D.a());
            default:
                return S.w(abstractC0381o, D.a());
        }
    }

    @Override // C0.e
    public final void g(MessageLite messageLite) throws GeneralSecurityException {
        switch (this.d) {
            case 0:
                C0068l c0068l = (C0068l) messageLite;
                C.c(c0068l.getVersion());
                if (c0068l.getKeyValue().size() < 16) {
                    throw new GeneralSecurityException("key_value must have at least 16 bytes");
                }
                if (c0068l.getKeyValue().size() < c0068l.getParams().getDerivedKeySize()) {
                    throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
                }
                n(c0068l.getParams());
                return;
            case 1:
                G0.D d = (G0.D) messageLite;
                C.c(d.getVersion());
                o(d.getParams());
                return;
            case 2:
                C0056h c0056h = (C0056h) messageLite;
                C.c(c0056h.getVersion());
                D0.c[] cVarArr = {new D0.c(IndCpaCipher.class, 5)};
                HashMap map = new HashMap();
                for (int i = 0; i < 1; i++) {
                    D0.c cVar = cVarArr[i];
                    boolean zContainsKey = map.containsKey(cVar.f226a);
                    Class cls = cVar.f226a;
                    if (zContainsKey) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map.put(cls, cVar);
                }
                Class cls2 = cVarArr[0].f226a;
                Collections.unmodifiableMap(map);
                r aesCtrKey = c0056h.getAesCtrKey();
                C.c(aesCtrKey.getVersion());
                C.a(aesCtrKey.getKeyValue().size());
                C0091v params = aesCtrKey.getParams();
                if (params.getIvSize() < 12 || params.getIvSize() > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                D0.c[] cVarArr2 = {new D0.c(Mac.class, 1)};
                HashMap map2 = new HashMap();
                D0.c cVar2 = cVarArr2[0];
                boolean zContainsKey2 = map2.containsKey(cVar2.f226a);
                Class cls3 = cVar2.f226a;
                if (zContainsKey2) {
                    throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                }
                map2.put(cls3, cVar2);
                Class cls4 = cVarArr2[0].f226a;
                Collections.unmodifiableMap(map2);
                C0094w0 hmacKey = c0056h.getHmacKey();
                C.c(hmacKey.getVersion());
                if (hmacKey.getKeyValue().size() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                D0.e.j(hmacKey.getParams());
                return;
            case 3:
                C0095x c0095x = (C0095x) messageLite;
                C.c(c0095x.getVersion());
                C.a(c0095x.getKeyValue().size());
                if (c0095x.getParams().getIvSize() != 12 && c0095x.getParams().getIvSize() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 4:
                J j6 = (J) messageLite;
                C.c(j6.getVersion());
                C.a(j6.getKeyValue().size());
                return;
            case 5:
                N n6 = (N) messageLite;
                C.c(n6.getVersion());
                C.a(n6.getKeyValue().size());
                return;
            case 6:
                W w5 = (W) messageLite;
                C.c(w5.getVersion());
                if (w5.getKeyValue().size() != 32) {
                    throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
                }
                return;
            case 7:
                C.c(((t1) messageLite).getVersion());
                return;
            case 8:
                C.c(((x1) messageLite).getVersion());
                return;
            case 9:
                M1 m12 = (M1) messageLite;
                C.c(m12.getVersion());
                if (m12.getKeyValue().size() != 32) {
                    throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
                }
                return;
            default:
                S s3 = (S) messageLite;
                C.c(s3.getVersion());
                if (s3.getKeyValue().size() == 64) {
                    return;
                }
                throw new InvalidKeyException("invalid key size: " + s3.getKeyValue().size() + ". Valid keys must have 64 bytes.");
        }
    }
}
