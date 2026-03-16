package D0;

import G0.A0;
import G0.B;
import G0.C;
import G0.C0053g;
import G0.C0056h;
import G0.C0062j;
import G0.C0065k;
import G0.C0068l;
import G0.C0074n;
import G0.C0080p;
import G0.C0082q;
import G0.C0087t;
import G0.C0091v;
import G0.C0092v0;
import G0.C0093w;
import G0.C0094w0;
import G0.C0095x;
import G0.C0098y0;
import G0.C0099z;
import G0.D;
import G0.EnumC0086s0;
import G0.F;
import G0.H;
import G0.I;
import G0.J;
import G0.L;
import G0.L1;
import G0.M;
import G0.M1;
import G0.N;
import G0.O1;
import G0.P;
import G0.Q;
import G0.S;
import G0.T;
import G0.U;
import G0.V;
import G0.W;
import G0.Y;
import G0.s1;
import G0.t1;
import G0.v1;
import G0.w1;
import G0.x1;
import G0.z1;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.subtle.v;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m extends C0.d {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ C0.e d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, byte b, char c) {
        super(v1.class, 0);
        this.d = aVar;
    }

    @Override // C0.d
    public final MessageLite b(MessageLite messageLite) {
        switch (this.c) {
            case 0:
                C0098y0 c0098y0 = (C0098y0) messageLite;
                C0092v0 c0092v0X = C0094w0.x();
                ((e) this.d).getClass();
                c0092v0X.p();
                C0094w0.t((C0094w0) c0092v0X.b);
                A0 params = c0098y0.getParams();
                c0092v0X.p();
                C0094w0.u((C0094w0) c0092v0X.b, params);
                byte[] bArrA = v.a(c0098y0.getKeySize());
                C0379n c0379nC = AbstractC0381o.c(bArrA, 0, bArrA.length);
                c0092v0X.p();
                C0094w0.v((C0094w0) c0092v0X.b, c0379nC);
                return (C0094w0) c0092v0X.build();
            case 1:
                C0074n c0074n = (C0074n) messageLite;
                C0065k c0065kW = C0068l.w();
                byte[] bArrA2 = v.a(c0074n.getKeySize());
                C0379n c0379nC2 = AbstractC0381o.c(bArrA2, 0, bArrA2.length);
                c0065kW.p();
                C0068l.v((C0068l) c0065kW.b, c0379nC2);
                C0080p params2 = c0074n.getParams();
                c0065kW.p();
                C0068l.u((C0068l) c0065kW.b, params2);
                ((H0.a) this.d).getClass();
                c0065kW.p();
                C0068l.t((C0068l) c0065kW.b);
                return (C0068l) c0065kW.build();
            case 2:
                F f6 = (F) messageLite;
                C cW = D.w();
                byte[] bArrA3 = v.a(f6.getKeySize());
                C0379n c0379nC3 = AbstractC0381o.c(bArrA3, 0, bArrA3.length);
                cW.p();
                D.v((D) cW.b, c0379nC3);
                H params3 = f6.getParams();
                cW.p();
                D.u((D) cW.b, params3);
                ((H0.a) this.d).getClass();
                cW.p();
                D.t((D) cW.b);
                return (D) cW.build();
            case 3:
                C0062j c0062j = (C0062j) messageLite;
                c[] cVarArr = {new c(IndCpaCipher.class, 5)};
                HashMap map = new HashMap();
                for (c cVar : cVarArr) {
                    boolean zContainsKey = map.containsKey(cVar.f226a);
                    Class cls = cVar.f226a;
                    if (zContainsKey) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map.put(cls, cVar);
                }
                if (cVarArr.length > 0) {
                    Class cls2 = cVarArr[0].f226a;
                }
                Collections.unmodifiableMap(map);
                C0087t aesCtrKeyFormat = c0062j.getAesCtrKeyFormat();
                C0082q c0082qX = G0.r.x();
                C0091v params4 = aesCtrKeyFormat.getParams();
                c0082qX.p();
                G0.r.u((G0.r) c0082qX.b, params4);
                byte[] bArrA4 = v.a(aesCtrKeyFormat.getKeySize());
                C0379n c0379nC4 = AbstractC0381o.c(bArrA4, 0, bArrA4.length);
                c0082qX.p();
                G0.r.v((G0.r) c0082qX.b, c0379nC4);
                c0082qX.p();
                G0.r.t((G0.r) c0082qX.b);
                G0.r rVar = (G0.r) c0082qX.build();
                c[] cVarArr2 = {new c(Mac.class, 1)};
                HashMap map2 = new HashMap();
                for (c cVar2 : cVarArr2) {
                    boolean zContainsKey2 = map2.containsKey(cVar2.f226a);
                    Class cls3 = cVar2.f226a;
                    if (zContainsKey2) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map2.put(cls3, cVar2);
                }
                if (cVarArr2.length > 0) {
                    Class cls4 = cVarArr2[0].f226a;
                }
                Collections.unmodifiableMap(map2);
                C0098y0 hmacKeyFormat = c0062j.getHmacKeyFormat();
                C0092v0 c0092v0X2 = C0094w0.x();
                c0092v0X2.p();
                C0094w0.t((C0094w0) c0092v0X2.b);
                A0 params5 = hmacKeyFormat.getParams();
                c0092v0X2.p();
                C0094w0.u((C0094w0) c0092v0X2.b, params5);
                byte[] bArrA5 = v.a(hmacKeyFormat.getKeySize());
                C0379n c0379nC5 = AbstractC0381o.c(bArrA5, 0, bArrA5.length);
                c0092v0X2.p();
                C0094w0.v((C0094w0) c0092v0X2.b, c0379nC5);
                C0094w0 c0094w0 = (C0094w0) c0092v0X2.build();
                C0053g c0053gW = C0056h.w();
                c0053gW.p();
                C0056h.u((C0056h) c0053gW.b, rVar);
                c0053gW.p();
                C0056h.v((C0056h) c0053gW.b, c0094w0);
                ((H0.a) this.d).getClass();
                c0053gW.p();
                C0056h.t((C0056h) c0053gW.b);
                return (C0056h) c0053gW.build();
            case 4:
                C0099z c0099z = (C0099z) messageLite;
                C0093w c0093wW = C0095x.w();
                byte[] bArrA6 = v.a(c0099z.getKeySize());
                C0379n c0379nC6 = AbstractC0381o.c(bArrA6, 0, bArrA6.length);
                c0093wW.p();
                C0095x.v((C0095x) c0093wW.b, c0379nC6);
                B params6 = c0099z.getParams();
                c0093wW.p();
                C0095x.u((C0095x) c0093wW.b, params6);
                ((H0.a) this.d).getClass();
                c0093wW.p();
                C0095x.t((C0095x) c0093wW.b);
                return (C0095x) c0093wW.build();
            case 5:
                I iV = J.v();
                byte[] bArrA7 = v.a(((L) messageLite).getKeySize());
                C0379n c0379nC7 = AbstractC0381o.c(bArrA7, 0, bArrA7.length);
                iV.p();
                J.u((J) iV.b, c0379nC7);
                ((H0.a) this.d).getClass();
                iV.p();
                J.t((J) iV.b);
                return (J) iV.build();
            case 6:
                M mV = N.v();
                byte[] bArrA8 = v.a(((P) messageLite).getKeySize());
                C0379n c0379nC8 = AbstractC0381o.c(bArrA8, 0, bArrA8.length);
                mV.p();
                N.u((N) mV.b, c0379nC8);
                ((H0.a) this.d).getClass();
                mV.p();
                N.t((N) mV.b);
                return (N) mV.build();
            case 7:
                V v6 = W.v();
                ((H0.a) this.d).getClass();
                v6.p();
                W.t((W) v6.b);
                byte[] bArrA9 = v.a(32);
                C0379n c0379nC9 = AbstractC0381o.c(bArrA9, 0, bArrA9.length);
                v6.p();
                W.u((W) v6.b, c0379nC9);
                return (W) v6.build();
            case 8:
                s1 s1VarV = t1.v();
                s1VarV.p();
                t1.u((t1) s1VarV.b, (v1) messageLite);
                ((H0.a) this.d).getClass();
                s1VarV.p();
                t1.t((t1) s1VarV.b);
                return (t1) s1VarV.build();
            case 9:
                w1 w1VarV = x1.v();
                w1VarV.p();
                x1.u((x1) w1VarV.b, (z1) messageLite);
                ((H0.a) this.d).getClass();
                w1VarV.p();
                x1.t((x1) w1VarV.b);
                return (x1) w1VarV.build();
            case 10:
                L1 l1V = M1.v();
                ((H0.a) this.d).getClass();
                l1V.p();
                M1.t((M1) l1V.b);
                byte[] bArrA10 = v.a(32);
                C0379n c0379nC10 = AbstractC0381o.c(bArrA10, 0, bArrA10.length);
                l1V.p();
                M1.u((M1) l1V.b, c0379nC10);
                return (M1) l1V.build();
            default:
                Q qV = S.v();
                byte[] bArrA11 = v.a(((U) messageLite).getKeySize());
                C0379n c0379nC11 = AbstractC0381o.c(bArrA11, 0, bArrA11.length);
                qV.p();
                S.u((S) qV.b, c0379nC11);
                ((H0.a) this.d).getClass();
                qV.p();
                S.t((S) qV.b);
                return (S) qV.build();
        }
    }

    @Override // C0.d
    public MessageLite c(MessageLite messageLite, InputStream inputStream) throws GeneralSecurityException {
        switch (this.c) {
            case 0:
                C0098y0 c0098y0 = (C0098y0) messageLite;
                int version = c0098y0.getVersion();
                ((e) this.d).getClass();
                com.google.crypto.tink.subtle.C.c(version);
                int keySize = c0098y0.getKeySize();
                byte[] bArr = new byte[keySize];
                try {
                    C0.d.j(inputStream, bArr);
                    C0092v0 c0092v0X = C0094w0.x();
                    c0092v0X.p();
                    C0094w0.t((C0094w0) c0092v0X.b);
                    A0 params = c0098y0.getParams();
                    c0092v0X.p();
                    C0094w0.u((C0094w0) c0092v0X.b, params);
                    C0379n c0379nC = AbstractC0381o.c(bArr, 0, keySize);
                    c0092v0X.p();
                    C0094w0.v((C0094w0) c0092v0X.b, c0379nC);
                    return (C0094w0) c0092v0X.build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            case 2:
                F f6 = (F) messageLite;
                int version2 = f6.getVersion();
                ((H0.a) this.d).getClass();
                com.google.crypto.tink.subtle.C.c(version2);
                int keySize2 = f6.getKeySize();
                byte[] bArr2 = new byte[keySize2];
                try {
                    C0.d.j(inputStream, bArr2);
                    C cW = D.w();
                    C0379n c0379nC2 = AbstractC0381o.c(bArr2, 0, keySize2);
                    cW.p();
                    D.v((D) cW.b, c0379nC2);
                    H params2 = f6.getParams();
                    cW.p();
                    D.u((D) cW.b, params2);
                    cW.p();
                    D.t((D) cW.b);
                    return (D) cW.build();
                } catch (IOException e6) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e6);
                }
            case 5:
                L l6 = (L) messageLite;
                int version3 = l6.getVersion();
                ((H0.a) this.d).getClass();
                com.google.crypto.tink.subtle.C.c(version3);
                int keySize3 = l6.getKeySize();
                byte[] bArr3 = new byte[keySize3];
                try {
                    C0.d.j(inputStream, bArr3);
                    I iV = J.v();
                    C0379n c0379nC3 = AbstractC0381o.c(bArr3, 0, keySize3);
                    iV.p();
                    J.u((J) iV.b, c0379nC3);
                    iV.p();
                    J.t((J) iV.b);
                    return (J) iV.build();
                } catch (IOException e7) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e7);
                }
            case 6:
                P p5 = (P) messageLite;
                int version4 = p5.getVersion();
                ((H0.a) this.d).getClass();
                com.google.crypto.tink.subtle.C.c(version4);
                int keySize4 = p5.getKeySize();
                byte[] bArr4 = new byte[keySize4];
                try {
                    C0.d.j(inputStream, bArr4);
                    M mV = N.v();
                    C0379n c0379nC4 = AbstractC0381o.c(bArr4, 0, keySize4);
                    mV.p();
                    N.u((N) mV.b, c0379nC4);
                    mV.p();
                    N.t((N) mV.b);
                    return (N) mV.build();
                } catch (IOException e8) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e8);
                }
            case 10:
                int version5 = ((O1) messageLite).getVersion();
                ((H0.a) this.d).getClass();
                com.google.crypto.tink.subtle.C.c(version5);
                byte[] bArr5 = new byte[32];
                try {
                    C0.d.j(inputStream, bArr5);
                    L1 l1V = M1.v();
                    C0379n c0379nC5 = AbstractC0381o.c(bArr5, 0, 32);
                    l1V.p();
                    M1.u((M1) l1V.b, c0379nC5);
                    l1V.p();
                    M1.t((M1) l1V.b);
                    return (M1) l1V.build();
                } catch (IOException e9) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e9);
                }
            case 11:
                int version6 = ((U) messageLite).getVersion();
                ((H0.a) this.d).getClass();
                com.google.crypto.tink.subtle.C.c(version6);
                byte[] bArr6 = new byte[64];
                try {
                    C0.d.j(inputStream, bArr6);
                    Q qV = S.v();
                    C0379n c0379nC6 = AbstractC0381o.c(bArr6, 0, 64);
                    qV.p();
                    S.u((S) qV.b, c0379nC6);
                    qV.p();
                    S.t((S) qV.b);
                    return (S) qV.build();
                } catch (IOException e10) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e10);
                }
            default:
                return super.c(messageLite, inputStream);
        }
    }

    @Override // C0.d
    public Map h() {
        switch (this.c) {
            case 0:
                HashMap map = new HashMap();
                EnumC0086s0 enumC0086s0 = EnumC0086s0.SHA256;
                map.put("HMAC_SHA256_128BITTAG", e.h(32, 16, enumC0086s0, 1));
                map.put("HMAC_SHA256_128BITTAG_RAW", e.h(32, 16, enumC0086s0, 3));
                map.put("HMAC_SHA256_256BITTAG", e.h(32, 32, enumC0086s0, 1));
                map.put("HMAC_SHA256_256BITTAG_RAW", e.h(32, 32, enumC0086s0, 3));
                EnumC0086s0 enumC0086s02 = EnumC0086s0.SHA512;
                map.put("HMAC_SHA512_128BITTAG", e.h(64, 16, enumC0086s02, 1));
                map.put("HMAC_SHA512_128BITTAG_RAW", e.h(64, 16, enumC0086s02, 3));
                map.put("HMAC_SHA512_256BITTAG", e.h(64, 32, enumC0086s02, 1));
                map.put("HMAC_SHA512_256BITTAG_RAW", e.h(64, 32, enumC0086s02, 3));
                map.put("HMAC_SHA512_512BITTAG", e.h(64, 64, enumC0086s02, 1));
                map.put("HMAC_SHA512_512BITTAG_RAW", e.h(64, 64, enumC0086s02, 3));
                return Collections.unmodifiableMap(map);
            case 1:
                HashMap map2 = new HashMap();
                map2.put("AES128_CTR_HMAC_SHA256_4KB", new C0.c(H0.a.l(16, 16, 4096), 3));
                map2.put("AES128_CTR_HMAC_SHA256_1MB", new C0.c(H0.a.l(16, 16, 1048576), 3));
                map2.put("AES256_CTR_HMAC_SHA256_4KB", new C0.c(H0.a.l(32, 32, 4096), 3));
                map2.put("AES256_CTR_HMAC_SHA256_1MB", new C0.c(H0.a.l(32, 32, 1048576), 3));
                return Collections.unmodifiableMap(map2);
            case 2:
                HashMap map3 = new HashMap();
                map3.put("AES128_GCM_HKDF_4KB", new C0.c(H0.a.m(16, 16, 4096), 3));
                map3.put("AES128_GCM_HKDF_1MB", new C0.c(H0.a.m(16, 16, 1048576), 3));
                map3.put("AES256_GCM_HKDF_4KB", new C0.c(H0.a.m(32, 32, 4096), 3));
                map3.put("AES256_GCM_HKDF_1MB", new C0.c(H0.a.m(32, 32, 1048576), 3));
                return Collections.unmodifiableMap(map3);
            case 3:
                HashMap map4 = new HashMap();
                map4.put("AES128_CTR_HMAC_SHA256", H0.a.i(16, 16, 1));
                map4.put("AES128_CTR_HMAC_SHA256_RAW", H0.a.i(16, 16, 3));
                map4.put("AES256_CTR_HMAC_SHA256", H0.a.i(32, 32, 1));
                map4.put("AES256_CTR_HMAC_SHA256_RAW", H0.a.i(32, 32, 3));
                return Collections.unmodifiableMap(map4);
            case 4:
                HashMap map5 = new HashMap();
                map5.put("AES128_EAX", H0.a.h(16, 1));
                map5.put("AES128_EAX_RAW", H0.a.h(16, 3));
                map5.put("AES256_EAX", H0.a.h(32, 1));
                map5.put("AES256_EAX_RAW", H0.a.h(32, 3));
                return Collections.unmodifiableMap(map5);
            case 5:
                HashMap map6 = new HashMap();
                map6.put("AES128_GCM", H0.a.j(16, 1));
                map6.put("AES128_GCM_RAW", H0.a.j(16, 3));
                map6.put("AES256_GCM", H0.a.j(32, 1));
                map6.put("AES256_GCM_RAW", H0.a.j(32, 3));
                return Collections.unmodifiableMap(map6);
            case 6:
                HashMap map7 = new HashMap();
                map7.put("AES128_GCM_SIV", H0.a.k(16, 1));
                map7.put("AES128_GCM_SIV_RAW", H0.a.k(16, 3));
                map7.put("AES256_GCM_SIV", H0.a.k(32, 1));
                map7.put("AES256_GCM_SIV_RAW", H0.a.k(32, 3));
                return Collections.unmodifiableMap(map7);
            case 7:
                HashMap map8 = new HashMap();
                map8.put("CHACHA20_POLY1305", new C0.c(Y.t(), 1));
                map8.put("CHACHA20_POLY1305_RAW", new C0.c(Y.t(), 3));
                return Collections.unmodifiableMap(map8);
            case 8:
            case 9:
            default:
                return super.h();
            case 10:
                HashMap map9 = new HashMap();
                map9.put("XCHACHA20_POLY1305", new C0.c(O1.t(), 1));
                map9.put("XCHACHA20_POLY1305_RAW", new C0.c(O1.t(), 3));
                return Collections.unmodifiableMap(map9);
            case 11:
                HashMap map10 = new HashMap();
                T tU = U.u();
                tU.p();
                U.t((U) tU.b);
                map10.put("AES256_SIV", new C0.c((U) tU.build(), 1));
                T tU2 = U.u();
                tU2.p();
                U.t((U) tU2.b);
                map10.put("AES256_SIV_RAW", new C0.c((U) tU2.build(), 3));
                return Collections.unmodifiableMap(map10);
        }
    }

    @Override // C0.d
    public final MessageLite i(AbstractC0381o abstractC0381o) {
        switch (this.c) {
            case 0:
                return C0098y0.x(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 1:
                return C0074n.w(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 2:
                return F.w(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 3:
                return C0062j.w(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 4:
                return C0099z.w(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 5:
                return L.v(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 6:
                return P.v(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 7:
                return Y.u(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 8:
                return v1.u(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 9:
                return z1.u(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            case 10:
                return O1.u(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
            default:
                return U.v(abstractC0381o, com.google.crypto.tink.shaded.protobuf.D.a());
        }
    }

    @Override // C0.d
    public final void k(MessageLite messageLite) throws GeneralSecurityException {
        switch (this.c) {
            case 0:
                C0098y0 c0098y0 = (C0098y0) messageLite;
                if (c0098y0.getKeySize() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                e.j(c0098y0.getParams());
                return;
            case 1:
                C0074n c0074n = (C0074n) messageLite;
                if (c0074n.getKeySize() < 16) {
                    throw new GeneralSecurityException("key_size must be at least 16 bytes");
                }
                H0.a.n(c0074n.getParams());
                return;
            case 2:
                F f6 = (F) messageLite;
                if (f6.getKeySize() < 16) {
                    throw new GeneralSecurityException("key_size must be at least 16 bytes");
                }
                H0.a.o(f6.getParams());
                return;
            case 3:
                C0062j c0062j = (C0062j) messageLite;
                c[] cVarArr = {new c(IndCpaCipher.class, 5)};
                HashMap map = new HashMap();
                for (c cVar : cVarArr) {
                    boolean zContainsKey = map.containsKey(cVar.f226a);
                    Class cls = cVar.f226a;
                    if (zContainsKey) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map.put(cls, cVar);
                }
                if (cVarArr.length > 0) {
                    Class cls2 = cVarArr[0].f226a;
                }
                Collections.unmodifiableMap(map);
                C0087t aesCtrKeyFormat = c0062j.getAesCtrKeyFormat();
                com.google.crypto.tink.subtle.C.a(aesCtrKeyFormat.getKeySize());
                C0091v params = aesCtrKeyFormat.getParams();
                if (params.getIvSize() < 12 || params.getIvSize() > 16) {
                    throw new GeneralSecurityException("invalid IV size");
                }
                c[] cVarArr2 = {new c(Mac.class, 1)};
                HashMap map2 = new HashMap();
                for (c cVar2 : cVarArr2) {
                    boolean zContainsKey2 = map2.containsKey(cVar2.f226a);
                    Class cls3 = cVar2.f226a;
                    if (zContainsKey2) {
                        throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.l(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
                    }
                    map2.put(cls3, cVar2);
                }
                if (cVarArr2.length > 0) {
                    Class cls4 = cVarArr2[0].f226a;
                }
                Collections.unmodifiableMap(map2);
                C0098y0 hmacKeyFormat = c0062j.getHmacKeyFormat();
                if (hmacKeyFormat.getKeySize() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                e.j(hmacKeyFormat.getParams());
                com.google.crypto.tink.subtle.C.a(c0062j.getAesCtrKeyFormat().getKeySize());
                return;
            case 4:
                C0099z c0099z = (C0099z) messageLite;
                com.google.crypto.tink.subtle.C.a(c0099z.getKeySize());
                if (c0099z.getParams().getIvSize() != 12 && c0099z.getParams().getIvSize() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return;
            case 5:
                com.google.crypto.tink.subtle.C.a(((L) messageLite).getKeySize());
                return;
            case 6:
                com.google.crypto.tink.subtle.C.a(((P) messageLite).getKeySize());
                return;
            case 7:
                return;
            case 8:
                return;
            case 9:
                z1 z1Var = (z1) messageLite;
                if (z1Var.getKekUri().isEmpty() || !z1Var.hasDekTemplate()) {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
                return;
            case 10:
                return;
            default:
                U u = (U) messageLite;
                if (u.getKeySize() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + u.getKeySize() + ". Valid keys must have 64 bytes.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, byte b, int i) {
        super(z1.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, short s3) {
        super(L.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, byte b, byte b2) {
        super(Y.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, byte b, boolean z6) {
        super(P.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, int i) {
        super(C0099z.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, byte b, short s3) {
        super(O1.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, char c, boolean z6) {
        super(U.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, byte b) {
        super(F.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar, char c) {
        super(C0062j.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(H0.a aVar) {
        super(C0074n.class, 0);
        this.d = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(e eVar) {
        super(C0098y0.class, 0);
        this.d = eVar;
    }
}
