package v0;

import G0.C0055g1;
import G0.C0058h1;
import G0.EnumC0046d1;
import G0.I;
import G0.J;
import G0.L;
import G0.L1;
import G0.M;
import G0.M1;
import G0.N;
import G0.O;
import G0.O1;
import G0.P;
import G0.W;
import G0.Y;
import com.google.crypto.tink.internal.KeyParser$KeyParsingFunction;
import com.google.crypto.tink.internal.KeySerializer$KeySerializationFunction;
import com.google.crypto.tink.internal.ParametersParser$ParametersParsingFunction;
import com.google.crypto.tink.internal.ParametersSerializer$ParametersSerializationFunction;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.V;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements ParametersParser$ParametersParsingFunction, KeySerializer$KeySerializationFunction, KeyParser$KeyParsingFunction, ParametersSerializer$ParametersSerializationFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4912a;

    @Override // com.google.crypto.tink.internal.KeyParser$KeyParsingFunction
    public com.google.crypto.tink.b parseKey(Serialization serialization, com.google.crypto.tink.n nVar) throws GeneralSecurityException {
        C0.r rVar = (C0.r) serialization;
        switch (this.f4912a) {
            case 2:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
                }
                try {
                    J jW = J.w(rVar.c, D.a());
                    if (jW.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    C0.t tVar = new C0.t(20, false);
                    tVar.b = null;
                    tVar.c = null;
                    tVar.d = null;
                    tVar.e = f.f4899h;
                    tVar.q(jW.getKeyValue().size());
                    tVar.c = 12;
                    tVar.r();
                    tVar.e = l.b(rVar.e);
                    j jVarD = tVar.d();
                    B2.d dVar = new B2.d(17);
                    dVar.c = null;
                    dVar.d = null;
                    dVar.b = jVarD;
                    byte[] bArrK = jW.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    dVar.c = B.g.a(bArrK, nVar);
                    dVar.d = rVar.f154f;
                    return dVar.e();
                } catch (V unused) {
                    throw new GeneralSecurityException("Parsing AesGcmKey failed");
                }
            case 6:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
                }
                try {
                    N nW = N.w(rVar.c, D.a());
                    if (nW.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    int size = nW.getKeyValue().size();
                    if (size != 16 && size != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(size)));
                    }
                    n nVar2 = new n(size, o.b(rVar.e));
                    B2.d dVar2 = new B2.d(18);
                    dVar2.c = null;
                    dVar2.d = null;
                    dVar2.b = nVar2;
                    byte[] bArrK2 = nW.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    dVar2.c = B.g.a(bArrK2, nVar);
                    dVar2.d = rVar.f154f;
                    return dVar2.f();
                } catch (V unused2) {
                    throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
                }
            case 10:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
                }
                try {
                    W w5 = W.w(rVar.c, D.a());
                    if (w5.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    f fVarB = r.b(rVar.e);
                    byte[] bArrK3 = w5.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    return p.a(fVarB, B.g.a(bArrK3, nVar), rVar.f154f);
                } catch (V unused3) {
                    throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
                }
            default:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
                }
                try {
                    M1 m1W = M1.w(rVar.c, D.a());
                    if (m1W.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    f fVarB2 = v.b(rVar.e);
                    byte[] bArrK4 = m1W.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    return t.a(fVarB2, B.g.a(bArrK4, nVar), rVar.f154f);
                } catch (V unused4) {
                    throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
                }
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersParser$ParametersParsingFunction
    public com.google.crypto.tink.i parseParameters(Serialization serialization) throws GeneralSecurityException {
        C0.s sVar = (C0.s) serialization;
        switch (this.f4912a) {
            case 0:
                boolean zEquals = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.AesGcmKey");
                C0058h1 c0058h1 = sVar.b;
                if (!zEquals) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters: " + c0058h1.getTypeUrl());
                }
                try {
                    L lV = L.v(c0058h1.getValue(), D.a());
                    C0.t tVar = new C0.t(20, false);
                    tVar.b = null;
                    tVar.c = null;
                    tVar.d = null;
                    tVar.e = f.f4899h;
                    tVar.q(lV.getKeySize());
                    tVar.c = 12;
                    tVar.r();
                    tVar.e = l.b(c0058h1.getOutputPrefixType());
                    return tVar.d();
                } catch (V e) {
                    throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
                }
            case 4:
                boolean zEquals2 = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
                C0058h1 c0058h12 = sVar.b;
                if (!zEquals2) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters: " + c0058h12.getTypeUrl());
                }
                try {
                    int keySize = P.v(c0058h12.getValue(), D.a()).getKeySize();
                    if (keySize == 16 || keySize == 32) {
                        return new n(keySize, o.b(c0058h12.getOutputPrefixType()));
                    }
                    throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(keySize)));
                } catch (V e6) {
                    throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e6);
                }
            case 8:
                boolean zEquals3 = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
                C0058h1 c0058h13 = sVar.b;
                if (!zEquals3) {
                    throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters: " + c0058h13.getTypeUrl());
                }
                try {
                    Y.u(c0058h13.getValue(), D.a());
                    return new q(r.b(c0058h13.getOutputPrefixType()));
                } catch (V e7) {
                    throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e7);
                }
            default:
                boolean zEquals4 = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
                C0058h1 c0058h14 = sVar.b;
                if (!zEquals4) {
                    throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters: " + c0058h14.getTypeUrl());
                }
                try {
                    O1.u(c0058h14.getValue(), D.a());
                    return new u(v.b(c0058h14.getOutputPrefixType()));
                } catch (V e8) {
                    throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e8);
                }
        }
    }

    @Override // com.google.crypto.tink.internal.KeySerializer$KeySerializationFunction
    public Serialization serializeKey(com.google.crypto.tink.b bVar, com.google.crypto.tink.n nVar) throws GeneralSecurityException {
        switch (this.f4912a) {
            case 1:
                i iVar = (i) bVar;
                l.c(iVar.f4910a);
                I iV = J.v();
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC = iVar.b.c(nVar);
                C0379n c0379nC = AbstractC0381o.c(bArrC, 0, bArrC.length);
                iV.p();
                J.u((J) iV.b, c0379nC);
                return C0.r.a("type.googleapis.com/google.crypto.tink.AesGcmKey", ((J) iV.build()).toByteString(), EnumC0046d1.SYMMETRIC, l.a(iVar.f4910a.d), iVar.c);
            case 5:
                m mVar = (m) bVar;
                M mV = N.v();
                B.g gVar = mVar.b;
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC2 = gVar.c(nVar);
                C0379n c0379nC2 = AbstractC0381o.c(bArrC2, 0, bArrC2.length);
                mV.p();
                N.u((N) mV.b, c0379nC2);
                return C0.r.a("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((N) mV.build()).toByteString(), EnumC0046d1.SYMMETRIC, o.a(mVar.f4914a.b), mVar.c);
            case 9:
                p pVar = (p) bVar;
                G0.V v6 = W.v();
                B.g gVar2 = pVar.b;
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC3 = gVar2.c(nVar);
                C0379n c0379nC3 = AbstractC0381o.c(bArrC3, 0, bArrC3.length);
                v6.p();
                W.u((W) v6.b, c0379nC3);
                return C0.r.a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((W) v6.build()).toByteString(), EnumC0046d1.SYMMETRIC, r.a(pVar.f4917a.f4918a), pVar.c);
            default:
                t tVar = (t) bVar;
                L1 l1V = M1.v();
                B.g gVar3 = tVar.b;
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC4 = gVar3.c(nVar);
                C0379n c0379nC4 = AbstractC0381o.c(bArrC4, 0, bArrC4.length);
                l1V.p();
                M1.u((M1) l1V.b, c0379nC4);
                return C0.r.a("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((M1) l1V.build()).toByteString(), EnumC0046d1.SYMMETRIC, v.a(tVar.f4921a.f4922a), tVar.c);
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersSerializer$ParametersSerializationFunction
    public Serialization serializeParameters(com.google.crypto.tink.i iVar) {
        switch (this.f4912a) {
            case 3:
                n nVar = (n) iVar;
                C0055g1 c0055g1X = C0058h1.x();
                c0055g1X.v("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
                O oU = P.u();
                int i = nVar.f4915a;
                oU.p();
                P.t((P) oU.b, i);
                c0055g1X.w((C0379n) ((P) oU.build()).toByteString());
                c0055g1X.u(o.a(nVar.b));
                return new C0.s((C0058h1) c0055g1X.build());
            case 7:
                C0055g1 c0055g1X2 = C0058h1.x();
                c0055g1X2.v("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
                c0055g1X2.w((C0379n) Y.t().toByteString());
                c0055g1X2.u(r.a(((q) iVar).f4918a));
                return new C0.s((C0058h1) c0055g1X2.build());
            default:
                C0055g1 c0055g1X3 = C0058h1.x();
                c0055g1X3.v("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
                c0055g1X3.w((C0379n) O1.t().toByteString());
                c0055g1X3.u(v.a(((u) iVar).f4922a));
                return new C0.s((C0058h1) c0055g1X3.build());
        }
    }
}
