package D0;

import G0.A0;
import G0.B;
import G0.C0035a;
import G0.C0038b;
import G0.C0041c;
import G0.C0044d;
import G0.C0047e;
import G0.C0050f;
import G0.C0055g1;
import G0.C0058h1;
import G0.C0092v0;
import G0.C0093w;
import G0.C0094w0;
import G0.C0095x;
import G0.C0096x0;
import G0.C0097y;
import G0.C0098y0;
import G0.C0099z;
import G0.EnumC0046d1;
import G0.K;
import G0.L;
import android.text.Editable;
import androidx.arch.core.util.Function;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.PreferenceUtils;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.material.textfield.TextInputLayout;
import com.google.crypto.tink.internal.KeyParser$KeyParsingFunction;
import com.google.crypto.tink.internal.KeySerializer$KeySerializationFunction;
import com.google.crypto.tink.internal.ParametersParser$ParametersParsingFunction;
import com.google.crypto.tink.internal.ParametersSerializer$ParametersSerializationFunction;
import com.google.crypto.tink.internal.PrimitiveConstructor$PrimitiveConstructionFunction;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.V;
import java.security.GeneralSecurityException;
import java.util.List;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements PrimitiveConstructor$PrimitiveConstructionFunction, ParametersSerializer$ParametersSerializationFunction, ParametersParser$ParametersParsingFunction, KeySerializer$KeySerializationFunction, KeyParser$KeyParsingFunction, Interpolator, Function, TransportScheduleCallback, TextInputLayout.LengthCounter, MockedConstruction.MockInitializer, MemberAccessor.OnConstruction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f225a;

    public /* synthetic */ b(int i) {
        this.f225a = i;
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        switch (this.f225a) {
            case 17:
                return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
            default:
                return PreferenceUtils.lambda$getLastCancelAllTimeMillisLiveData$0((Long) obj);
        }
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor$PrimitiveConstructionFunction
    public Object constructPrimitive(com.google.crypto.tink.b bVar) {
        switch (this.f225a) {
            case 0:
                return new E0.b((a) bVar);
            default:
                return new E0.b((l) bVar);
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        int[][] iArr = TextInputLayout.f2594y0;
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f6) {
        switch (this.f225a) {
            case 10:
                return Transition.lambda$getInterpolator$1(f6);
            case 11:
                return Transition.lambda$getInterpolator$2(f6);
            case 12:
                return Transition.lambda$getInterpolator$3(f6);
            case 13:
                return Transition.lambda$getInterpolator$4(f6);
            case 14:
                return Transition.lambda$getInterpolator$5(f6);
            case 15:
                return Transition.lambda$getInterpolator$6(f6);
            default:
                return Transition.lambda$getInterpolator$7(f6);
        }
    }

    @Override // org.mockito.plugins.MemberAccessor.OnConstruction
    public Object invoke(MemberAccessor.ConstructionDispatcher constructionDispatcher) {
        return constructionDispatcher.newInstance();
    }

    @Override // com.google.android.datatransport.TransportScheduleCallback
    public void onSchedule(Exception exc) {
    }

    @Override // com.google.crypto.tink.internal.KeyParser$KeyParsingFunction
    public com.google.crypto.tink.b parseKey(Serialization serialization, com.google.crypto.tink.n nVar) throws GeneralSecurityException {
        C0.r rVar = (C0.r) serialization;
        switch (this.f225a) {
            case 4:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
                }
                try {
                    C0038b c0038bX = C0038b.x(rVar.c, D.a());
                    if (c0038bX.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    B2.d dVar = new B2.d(2);
                    dVar.b = null;
                    dVar.c = null;
                    dVar.d = f.f228f;
                    dVar.p(c0038bX.getKeyValue().size());
                    dVar.q(c0038bX.getParams().getTagSize());
                    dVar.d = h.b(rVar.e);
                    g gVarB = dVar.b();
                    B2.d dVar2 = new B2.d(1);
                    dVar2.c = null;
                    dVar2.d = null;
                    dVar2.b = gVarB;
                    byte[] bArrK = c0038bX.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    dVar2.c = B.g.a(bArrK, nVar);
                    dVar2.d = rVar.f154f;
                    return dVar2.a();
                } catch (V | IllegalArgumentException unused) {
                    throw new GeneralSecurityException("Parsing AesCmacKey failed");
                }
            case 9:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
                }
                try {
                    C0094w0 c0094w0Y = C0094w0.y(rVar.c, D.a());
                    if (c0094w0Y.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    C0.t tVar = new C0.t(2, false);
                    tVar.b = null;
                    tVar.c = null;
                    tVar.d = null;
                    tVar.e = f.f236o;
                    tVar.b = Integer.valueOf(c0094w0Y.getKeyValue().size());
                    tVar.c = Integer.valueOf(c0094w0Y.getParams().getTagSize());
                    tVar.d = o.b(c0094w0Y.getParams().getHash());
                    tVar.e = o.d(rVar.e);
                    n nVarB = tVar.b();
                    B2.d dVar3 = new B2.d(3);
                    dVar3.c = null;
                    dVar3.d = null;
                    dVar3.b = nVarB;
                    byte[] bArrK2 = c0094w0Y.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    dVar3.c = B.g.a(bArrK2, nVar);
                    dVar3.d = rVar.f154f;
                    return dVar3.c();
                } catch (V | IllegalArgumentException unused2) {
                    throw new GeneralSecurityException("Parsing HmacKey failed");
                }
            default:
                if (!rVar.f153a.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
                }
                try {
                    C0095x c0095xX = C0095x.x(rVar.c, D.a());
                    if (c0095xX.getVersion() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    C0.t tVar2 = new C0.t(19, false);
                    tVar2.b = null;
                    tVar2.c = null;
                    tVar2.d = null;
                    tVar2.e = v0.f.e;
                    tVar2.q(c0095xX.getKeyValue().size());
                    tVar2.p(c0095xX.getParams().getIvSize());
                    tVar2.r();
                    tVar2.e = v0.h.c(rVar.e);
                    v0.g gVarC = tVar2.c();
                    B2.d dVar4 = new B2.d(16);
                    dVar4.c = null;
                    dVar4.d = null;
                    dVar4.b = gVarC;
                    byte[] bArrK3 = c0095xX.getKeyValue().k();
                    com.google.crypto.tink.n.a(nVar);
                    dVar4.c = B.g.a(bArrK3, nVar);
                    dVar4.d = rVar.f154f;
                    return dVar4.d();
                } catch (V unused3) {
                    throw new GeneralSecurityException("Parsing AesEaxcKey failed");
                }
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersParser$ParametersParsingFunction
    public com.google.crypto.tink.i parseParameters(Serialization serialization) throws GeneralSecurityException {
        C0.s sVar = (C0.s) serialization;
        switch (this.f225a) {
            case 2:
                boolean zEquals = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.AesCmacKey");
                C0058h1 c0058h1 = sVar.b;
                if (!zEquals) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters: " + c0058h1.getTypeUrl());
                }
                try {
                    C0044d c0044dW = C0044d.w(c0058h1.getValue(), D.a());
                    B2.d dVar = new B2.d(2);
                    dVar.b = null;
                    dVar.c = null;
                    dVar.d = f.f228f;
                    dVar.p(c0044dW.getKeySize());
                    dVar.q(c0044dW.getParams().getTagSize());
                    dVar.d = h.b(c0058h1.getOutputPrefixType());
                    return dVar.b();
                } catch (V e) {
                    throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
                }
            case 7:
                boolean zEquals2 = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.HmacKey");
                C0058h1 c0058h12 = sVar.b;
                if (!zEquals2) {
                    throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + c0058h12.getTypeUrl());
                }
                try {
                    C0098y0 c0098y0X = C0098y0.x(c0058h12.getValue(), D.a());
                    if (c0098y0X.getVersion() != 0) {
                        throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + c0098y0X.getVersion());
                    }
                    C0.t tVar = new C0.t(2, false);
                    tVar.b = null;
                    tVar.c = null;
                    tVar.d = null;
                    tVar.e = f.f236o;
                    tVar.b = Integer.valueOf(c0098y0X.getKeySize());
                    tVar.c = Integer.valueOf(c0098y0X.getParams().getTagSize());
                    tVar.d = o.b(c0098y0X.getParams().getHash());
                    tVar.e = o.d(c0058h12.getOutputPrefixType());
                    return tVar.b();
                } catch (V e6) {
                    throw new GeneralSecurityException("Parsing HmacParameters failed: ", e6);
                }
            default:
                boolean zEquals3 = sVar.b.getTypeUrl().equals("type.googleapis.com/google.crypto.tink.AesEaxKey");
                C0058h1 c0058h13 = sVar.b;
                if (!zEquals3) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: " + c0058h13.getTypeUrl());
                }
                try {
                    C0099z c0099zW = C0099z.w(c0058h13.getValue(), D.a());
                    C0.t tVar2 = new C0.t(19, false);
                    tVar2.b = null;
                    tVar2.c = null;
                    tVar2.d = null;
                    tVar2.e = v0.f.e;
                    tVar2.q(c0099zW.getKeySize());
                    tVar2.p(c0099zW.getParams().getIvSize());
                    tVar2.r();
                    tVar2.e = v0.h.c(c0058h13.getOutputPrefixType());
                    return tVar2.c();
                } catch (V e7) {
                    throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e7);
                }
        }
    }

    @Override // org.mockito.MockedConstruction.MockInitializer
    public void prepare(Object obj, MockedConstruction.Context context) {
        switch (this.f225a) {
            case 21:
                Mockito.lambda$mockConstructionWithAnswer$1(obj, context);
                break;
            case 22:
                Mockito.lambda$mockConstruction$3(obj, context);
                break;
            default:
                Mockito.lambda$mockConstruction$5(obj, context);
                break;
        }
    }

    @Override // com.google.crypto.tink.internal.KeySerializer$KeySerializationFunction
    public Serialization serializeKey(com.google.crypto.tink.b bVar, com.google.crypto.tink.n nVar) throws GeneralSecurityException {
        switch (this.f225a) {
            case 3:
                a aVar = (a) bVar;
                C0035a c0035aW = C0038b.w();
                g gVar = aVar.f224a;
                C0047e c0047eV = C0050f.v();
                int i = gVar.b;
                c0047eV.p();
                C0050f.t((C0050f) c0047eV.b, i);
                C0050f c0050f = (C0050f) c0047eV.build();
                c0035aW.p();
                C0038b.v((C0038b) c0035aW.b, c0050f);
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC = aVar.b.c(nVar);
                C0379n c0379nC = AbstractC0381o.c(bArrC, 0, bArrC.length);
                c0035aW.p();
                C0038b.u((C0038b) c0035aW.b, c0379nC);
                return C0.r.a("type.googleapis.com/google.crypto.tink.AesCmacKey", ((C0038b) c0035aW.build()).toByteString(), EnumC0046d1.SYMMETRIC, h.a(aVar.f224a.c), aVar.d);
            case 8:
                l lVar = (l) bVar;
                C0092v0 c0092v0X = C0094w0.x();
                A0 a0A = o.a(lVar.f243a);
                c0092v0X.p();
                C0094w0.u((C0094w0) c0092v0X.b, a0A);
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC2 = lVar.b.c(nVar);
                C0379n c0379nC2 = AbstractC0381o.c(bArrC2, 0, bArrC2.length);
                c0092v0X.p();
                C0094w0.v((C0094w0) c0092v0X.b, c0379nC2);
                return C0.r.a("type.googleapis.com/google.crypto.tink.HmacKey", ((C0094w0) c0092v0X.build()).toByteString(), EnumC0046d1.SYMMETRIC, o.c(lVar.f243a.c), lVar.d);
            default:
                v0.e eVar = (v0.e) bVar;
                C0093w c0093wW = C0095x.w();
                B bA = v0.h.a(eVar.f4896a);
                c0093wW.p();
                C0095x.u((C0095x) c0093wW.b, bA);
                com.google.crypto.tink.n.a(nVar);
                byte[] bArrC3 = eVar.b.c(nVar);
                C0379n c0379nC3 = AbstractC0381o.c(bArrC3, 0, bArrC3.length);
                c0093wW.p();
                C0095x.v((C0095x) c0093wW.b, c0379nC3);
                return C0.r.a("type.googleapis.com/google.crypto.tink.AesEaxKey", ((C0095x) c0093wW.build()).toByteString(), EnumC0046d1.SYMMETRIC, v0.h.b(eVar.f4896a.d), eVar.c);
        }
    }

    @Override // com.google.crypto.tink.internal.ParametersSerializer$ParametersSerializationFunction
    public Serialization serializeParameters(com.google.crypto.tink.i iVar) {
        switch (this.f225a) {
            case 1:
                g gVar = (g) iVar;
                C0055g1 c0055g1X = C0058h1.x();
                c0055g1X.v("type.googleapis.com/google.crypto.tink.AesCmacKey");
                C0041c c0041cV = C0044d.v();
                C0047e c0047eV = C0050f.v();
                int i = gVar.b;
                c0047eV.p();
                C0050f.t((C0050f) c0047eV.b, i);
                C0050f c0050f = (C0050f) c0047eV.build();
                c0041cV.p();
                C0044d.u((C0044d) c0041cV.b, c0050f);
                c0041cV.p();
                C0044d.t((C0044d) c0041cV.b, gVar.f238a);
                c0055g1X.w((C0379n) ((C0044d) c0041cV.build()).toByteString());
                c0055g1X.u(h.a(gVar.c));
                return new C0.s((C0058h1) c0055g1X.build());
            case 6:
                n nVar = (n) iVar;
                C0055g1 c0055g1X2 = C0058h1.x();
                c0055g1X2.v("type.googleapis.com/google.crypto.tink.HmacKey");
                C0096x0 c0096x0W = C0098y0.w();
                A0 a0A = o.a(nVar);
                c0096x0W.p();
                C0098y0.t((C0098y0) c0096x0W.b, a0A);
                c0096x0W.p();
                C0098y0.u((C0098y0) c0096x0W.b, nVar.f244a);
                c0055g1X2.w((C0379n) ((C0098y0) c0096x0W.build()).toByteString());
                c0055g1X2.u(o.c(nVar.c));
                return new C0.s((C0058h1) c0055g1X2.build());
            case 25:
                v0.g gVar2 = (v0.g) iVar;
                C0055g1 c0055g1X3 = C0058h1.x();
                c0055g1X3.v("type.googleapis.com/google.crypto.tink.AesEaxKey");
                C0097y c0097yV = C0099z.v();
                B bA = v0.h.a(gVar2);
                c0097yV.p();
                C0099z.t((C0099z) c0097yV.b, bA);
                c0097yV.p();
                C0099z.u((C0099z) c0097yV.b, gVar2.f4908a);
                c0055g1X3.w((C0379n) ((C0099z) c0097yV.build()).toByteString());
                c0055g1X3.u(v0.h.b(gVar2.d));
                return new C0.s((C0058h1) c0055g1X3.build());
            default:
                v0.j jVar = (v0.j) iVar;
                v0.l.c(jVar);
                C0055g1 c0055g1X4 = C0058h1.x();
                c0055g1X4.v("type.googleapis.com/google.crypto.tink.AesGcmKey");
                K kU = L.u();
                kU.p();
                L.t((L) kU.b, jVar.f4911a);
                c0055g1X4.w((C0379n) ((L) kU.build()).toByteString());
                c0055g1X4.u(v0.l.a(jVar.d));
                return new C0.s((C0058h1) c0055g1X4.build());
        }
    }
}
