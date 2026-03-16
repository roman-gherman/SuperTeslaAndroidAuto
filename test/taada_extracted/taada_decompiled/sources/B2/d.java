package B2;

import C0.l;
import C0.r;
import C0.t;
import C0.x;
import D0.n;
import G0.A1;
import G0.C0073m1;
import G0.C0076n1;
import G0.C0084r0;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.c0;
import a3.d0;
import android.content.Context;
import c4.AbstractC0246d;
import com.android.billingclient.api.A;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.v;
import com.google.android.gms.internal.play_billing.C0279g;
import com.google.crypto.tink.o;
import com.google.crypto.tink.shaded.protobuf.D;
import com.google.crypto.tink.shaded.protobuf.V;
import e2.C0430f;
import io.ktor.utils.io.Z;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Provider;
import k.C0569b;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlinx.coroutines.selects.SelectClause1;
import s.k;
import s2.C0813c;
import v0.i;
import v0.j;
import v0.m;
import y4.C0937a;
import z2.C0941a;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements TransportFactory, Factory, SelectClause1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f124a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ d(int i) {
        this.f124a = i;
    }

    public static final d i(C0076n1 c0076n1) throws GeneralSecurityException {
        if (c0076n1 == null || c0076n1.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        ArrayList arrayList = new ArrayList(c0076n1.getKeyCount());
        for (C0073m1 c0073m1 : c0076n1.getKeyList()) {
            c0073m1.getClass();
            try {
                try {
                    com.google.crypto.tink.b bVarA = l.b.a(r.a(c0073m1.getKeyData().getTypeUrl(), c0073m1.getKeyData().getValue(), c0073m1.getKeyData().getKeyMaterialType(), c0073m1.getOutputPrefixType(), c0073m1.getOutputPrefixType() == A1.RAW ? null : Integer.valueOf(c0073m1.getKeyId())));
                    int iOrdinal = c0073m1.getStatus().ordinal();
                    if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    arrayList.add(new com.google.crypto.tink.g(bVarA));
                } catch (GeneralSecurityException unused) {
                    arrayList.add(null);
                }
            } catch (GeneralSecurityException e) {
                throw new x("Creating a protokey serialization failed", e);
            }
        }
        return new d(c0076n1, Collections.unmodifiableList(arrayList));
    }

    public static final d m(com.google.crypto.tink.e eVar, B0.c cVar) throws GeneralSecurityException {
        byte[] bArr = new byte[0];
        C0084r0 encrypted = eVar.readEncrypted();
        if (encrypted.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            C0076n1 c0076n1X = C0076n1.x(cVar.decrypt(encrypted.getEncryptedKeyset().k(), bArr), D.a());
            if (c0076n1X.getKeyCount() > 0) {
                return i(c0076n1X);
            }
            throw new GeneralSecurityException("empty keyset");
        } catch (V unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public static int n(d dVar, int i, int i3, byte[] bArr, int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < i3 && i7 < i4) {
            byte b = bArr[i7];
            int i8 = b & 15;
            i7++;
            int i9 = (b & 255) >> 4;
            if (i5 == 2) {
                if (i8 < 15) {
                    ((int[]) dVar.b)[i + i6] = 2 - (i8 - (((i8 * 205) >> 10) * 5));
                    i6++;
                }
                if (i9 < 15 && i6 < i3) {
                    ((int[]) dVar.b)[i + i6] = 2 - (i9 - (((i9 * 205) >> 10) * 5));
                    i6++;
                }
            } else if (i5 == 4) {
                if (i8 < 9) {
                    ((int[]) dVar.b)[i + i6] = 4 - i8;
                    i6++;
                }
                if (i9 < 9 && i6 < i3) {
                    ((int[]) dVar.b)[i + i6] = 4 - i9;
                    i6++;
                }
            }
        }
        return i6;
    }

    public static int o(d dVar, int i, int i3, byte[] bArr, int i4) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = i6 + 3;
            if (i7 > i4) {
                break;
            }
            int i8 = (((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255)) & 8388607;
            if (i8 < 8380417) {
                ((int[]) dVar.b)[i + i5] = i8;
                i5++;
            }
            i6 = i7;
        }
        return i5;
    }

    public D0.a a() throws GeneralSecurityException {
        B.g gVar;
        I0.a aVarA;
        D0.g gVar2 = (D0.g) this.b;
        if (gVar2 == null || (gVar = (B.g) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (gVar2.f238a != ((I0.a) gVar.b).f749a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        D0.f fVar = D0.f.f228f;
        D0.f fVar2 = gVar2.c;
        if (fVar2 != fVar && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar2 == fVar && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar2 == fVar) {
            aVarA = I0.a.a(new byte[0]);
        } else if (fVar2 == D0.f.e || fVar2 == D0.f.d) {
            aVarA = I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar2 != D0.f.c) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + ((D0.g) this.b).c);
            }
            aVarA = I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new D0.a((D0.g) this.b, (B.g) this.c, aVarA, (Integer) this.d);
    }

    public D0.g b() {
        Integer num = (Integer) this.b;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (((Integer) this.c) == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (((D0.f) this.d) != null) {
            return new D0.g(num.intValue(), ((Integer) this.c).intValue(), (D0.f) this.d);
        }
        throw new GeneralSecurityException("variant not set");
    }

    public D0.l c() throws GeneralSecurityException {
        B.g gVar;
        I0.a aVarA;
        n nVar = (n) this.b;
        if (nVar == null || (gVar = (B.g) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (nVar.f244a != ((I0.a) gVar.b).f749a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        D0.f fVar = D0.f.f236o;
        D0.f fVar2 = nVar.c;
        if (fVar2 != fVar && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar2 == fVar && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar2 == fVar) {
            aVarA = I0.a.a(new byte[0]);
        } else if (fVar2 == D0.f.f235n || fVar2 == D0.f.f234m) {
            aVarA = I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar2 != D0.f.f233l) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: " + ((n) this.b).c);
            }
            aVarA = I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new D0.l((n) this.b, (B.g) this.c, aVarA, (Integer) this.d);
    }

    public v0.e d() throws GeneralSecurityException {
        B.g gVar;
        v0.g gVar2 = (v0.g) this.b;
        if (gVar2 == null || (gVar = (B.g) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (gVar2.f4908a != ((I0.a) gVar.b).f749a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        v0.f fVar = v0.f.e;
        v0.f fVar2 = gVar2.d;
        if (fVar2 != fVar && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar2 == fVar && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar2 == fVar) {
            I0.a.a(new byte[0]);
        } else if (fVar2 == v0.f.d) {
            I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar2 != v0.f.c) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + ((v0.g) this.b).d);
            }
            I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new v0.e((v0.g) this.b, (B.g) this.c, (Integer) this.d);
    }

    public i e() throws GeneralSecurityException {
        B.g gVar;
        j jVar = (j) this.b;
        if (jVar == null || (gVar = (B.g) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (jVar.f4911a != ((I0.a) gVar.b).f749a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        v0.f fVar = v0.f.f4899h;
        v0.f fVar2 = jVar.d;
        if (fVar2 != fVar && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar2 == fVar && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar2 == fVar) {
            I0.a.a(new byte[0]);
        } else if (fVar2 == v0.f.f4898g) {
            I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar2 != v0.f.f4897f) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + ((j) this.b).d);
            }
            I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new i((j) this.b, (B.g) this.c, (Integer) this.d);
    }

    public m f() throws GeneralSecurityException {
        B.g gVar;
        v0.n nVar = (v0.n) this.b;
        if (nVar == null || (gVar = (B.g) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (nVar.f4915a != ((I0.a) gVar.b).f749a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        v0.f fVar = v0.f.f4901k;
        v0.f fVar2 = nVar.b;
        if (fVar2 != fVar && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar2 == fVar && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar2 == fVar) {
            I0.a.a(new byte[0]);
        } else if (fVar2 == v0.f.f4900j) {
            I0.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar2 != v0.f.i) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + ((v0.n) this.b).b);
            }
            I0.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new m((v0.n) this.b, (B.g) this.c, (Integer) this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0144  */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r5v26, types: [kotlin.reflect.jvm.internal.impl.types.TypeConstructor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a3.F g(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r23, B2.a r24, a3.F r25) {
        /*
            Method dump skipped, instruction units count: 979
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B2.d.g(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, B2.a, a3.F):a3.F");
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.f124a) {
            case 7:
                return new v(new D.d(11, (byte) 0), new z5.b(10), (Scheduler) ((D.b) this.b).get(), (s.j) ((B0.a) this.c).get(), (k) ((t) this.d).get());
            default:
                return new s.c((Context) ((com.google.android.material.snackbar.f) this.b).f2591a, (EventStore) ((Provider) this.c).get(), (s.a) ((n0.d) this.d).get());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.b;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getOnCancellationConstructor() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.f] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getProcessResFunc() {
        return (kotlin.jvm.internal.f) this.d;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.f] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getRegFunc() {
        return (kotlin.jvm.internal.f) this.c;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public Transport getTransport(String str, Class cls, Transformer transformer) {
        return getTransport(str, cls, new C0569b("proto"), transformer);
    }

    public TypeConstructor h(JavaClassifierType javaClassifierType) {
        L2.b bVarJ = L2.b.j(new L2.c(javaClassifierType.getClassifierQualifiedName()));
        X2.g gVarC = ((C0946f) this.b).f5203a.d.c();
        TypeConstructor typeConstructor = gVarC.f1424l.g(bVarJ, Z.p(0)).getTypeConstructor();
        kotlin.jvm.internal.h.e(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.Class r15) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B2.d.j(java.lang.Class):java.lang.Object");
    }

    public void k(int i, byte[] bArr) {
        byte[] bArr2 = new byte[8];
        int i3 = ((C0937a) this.c).e;
        if (i3 != 2) {
            if (i3 != 4) {
                throw new RuntimeException("Eta needs to be 2 or 4!");
            }
            for (int i4 = 0; i4 < 128; i4++) {
                int i5 = i4 * 2;
                int[] iArr = (int[]) this.b;
                byte b = (byte) (i3 - iArr[i5]);
                bArr2[0] = b;
                byte b2 = (byte) (i3 - iArr[i5 + 1]);
                bArr2[1] = b2;
                bArr[i + i4] = (byte) ((b2 << 4) | b);
            }
            return;
        }
        for (int i6 = 0; i6 < 32; i6++) {
            int i7 = i6 * 8;
            int[] iArr2 = (int[]) this.b;
            byte b6 = (byte) (i3 - iArr2[i7]);
            bArr2[0] = b6;
            byte b7 = (byte) (i3 - iArr2[i7 + 1]);
            bArr2[1] = b7;
            byte b8 = (byte) (i3 - iArr2[i7 + 2]);
            bArr2[2] = b8;
            bArr2[3] = (byte) (i3 - iArr2[i7 + 3]);
            bArr2[4] = (byte) (i3 - iArr2[i7 + 4]);
            bArr2[5] = (byte) (i3 - iArr2[i7 + 5]);
            bArr2[6] = (byte) (i3 - iArr2[i7 + 6]);
            bArr2[7] = (byte) (i3 - iArr2[i7 + 7]);
            int i8 = (i6 * 3) + i;
            bArr[i8] = (byte) (b6 | (b7 << 3) | (b8 << 6));
            bArr[i8 + 1] = (byte) ((bArr2[2] >> 2) | (bArr2[3] << 1) | (bArr2[4] << 4) | (bArr2[5] << 7));
            bArr[i8 + 2] = (byte) ((bArr2[7] << 5) | (bArr2[5] >> 1) | (bArr2[6] << 2));
        }
    }

    public void l(int i, byte[] bArr) {
        int i3 = ((C0937a) this.c).e;
        int i4 = 0;
        if (i3 != 2) {
            if (i3 == 4) {
                while (i4 < 128) {
                    int i5 = i4 * 2;
                    byte b = bArr[i + i4];
                    int[] iArr = (int[]) this.b;
                    iArr[i5] = b & 15;
                    int i6 = i5 + 1;
                    iArr[i6] = (b & 255) >> 4;
                    iArr[i5] = i3 - iArr[i5];
                    iArr[i6] = i3 - iArr[i6];
                    i4++;
                }
                return;
            }
            return;
        }
        while (i4 < 32) {
            int i7 = (i4 * 3) + i;
            int i8 = i4 * 8;
            byte b2 = bArr[i7];
            int[] iArr2 = (int[]) this.b;
            iArr2[i8] = b2 & 7;
            int i9 = i8 + 1;
            int i10 = b2 & 255;
            iArr2[i9] = (i10 >> 3) & 7;
            int i11 = i8 + 2;
            int i12 = bArr[i7 + 1] & 255;
            iArr2[i11] = (i10 >> 6) | ((i12 << 2) & 7);
            int i13 = i8 + 3;
            iArr2[i13] = (i12 >> 1) & 7;
            int i14 = i8 + 4;
            iArr2[i14] = (i12 >> 4) & 7;
            int i15 = i8 + 5;
            int i16 = bArr[i7 + 2] & 255;
            iArr2[i15] = (i12 >> 7) | ((i16 << 1) & 7);
            int i17 = i8 + 6;
            iArr2[i17] = (i16 >> 2) & 7;
            int i18 = i8 + 7;
            iArr2[i18] = (i16 >> 5) & 7;
            iArr2[i8] = i3 - iArr2[i8];
            iArr2[i9] = i3 - iArr2[i9];
            iArr2[i11] = i3 - iArr2[i11];
            iArr2[i13] = i3 - iArr2[i13];
            iArr2[i14] = i3 - iArr2[i14];
            iArr2[i15] = i3 - iArr2[i15];
            iArr2[i17] = i3 - iArr2[i17];
            iArr2[i18] = i3 - iArr2[i18];
            i4++;
        }
    }

    public void p(int i) {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
        }
        this.b = Integer.valueOf(i);
    }

    public void q(int i) {
        if (i < 10 || 16 < i) {
            throw new GeneralSecurityException(b.c(i, "Invalid tag size for AesCmacParameters: "));
        }
        this.c = Integer.valueOf(i);
    }

    public c0 r(JavaArrayType arrayType, a aVar, boolean z6) {
        kotlin.jvm.internal.h.f(arrayType, "arrayType");
        JavaType componentType = arrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        k2.k type = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        C0946f c0946f = (C0946f) this.b;
        C0944d c0944d = new C0944d(c0946f, arrayType, true);
        C0941a c0941a = c0946f.f5203a;
        boolean z7 = aVar.d;
        if (type != null) {
            F fP = c0941a.f5192o.d.p(type);
            AbstractC0162z abstractC0162zU0 = AbstractC0246d.u0(fP, new o2.g(new Annotations[]{fP.getAnnotations(), c0944d}));
            kotlin.jvm.internal.h.d(abstractC0162zU0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            F f6 = (F) abstractC0162zU0;
            return z7 ? f6 : C.a(f6, f6.g(true));
        }
        AbstractC0162z abstractC0162zS = s(componentType, kotlin.reflect.l.f0(2, z7, null, 6));
        d0 d0Var = d0.INVARIANT;
        d0 d0Var2 = d0.OUT_VARIANCE;
        if (!z7) {
            return C.a(c0941a.f5192o.d.h(d0Var, abstractC0162zS, c0944d), c0941a.f5192o.d.h(d0Var2, abstractC0162zS, c0944d).g(true));
        }
        if (z6) {
            d0Var = d0Var2;
        }
        return c0941a.f5192o.d.h(d0Var, abstractC0162zS, c0944d);
    }

    public AbstractC0162z s(JavaType javaType, a aVar) {
        F fG;
        boolean z6 = javaType instanceof JavaPrimitiveType;
        C0946f c0946f = (C0946f) this.b;
        if (z6) {
            k2.k type = ((JavaPrimitiveType) javaType).getType();
            F fR = type != null ? c0946f.f5203a.f5192o.d.r(type) : c0946f.f5203a.f5192o.d.v();
            kotlin.jvm.internal.h.e(fR, "{\n                val pr…ns.unitType\n            }");
            return fR;
        }
        boolean z7 = false;
        if (!(javaType instanceof JavaClassifierType)) {
            if (javaType instanceof JavaArrayType) {
                return r((JavaArrayType) javaType, aVar, false);
            }
            if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                return bound != null ? s(bound, aVar) : c0946f.f5203a.f5192o.d.n();
            }
            if (javaType == null) {
                return c0946f.f5203a.f5192o.d.n();
            }
            throw new UnsupportedOperationException("Unsupported type: " + javaType);
        }
        JavaClassifierType javaClassifierType = (JavaClassifierType) javaType;
        if (!aVar.d && aVar.f121a != 1) {
            z7 = true;
        }
        boolean zIsRaw = javaClassifierType.isRaw();
        c3.i iVar = c3.i.UNRESOLVED_JAVA_CLASS;
        if (!zIsRaw && !z7) {
            F fG2 = g(javaClassifierType, aVar, null);
            return fG2 != null ? fG2 : c3.j.c(iVar, javaClassifierType.getPresentableText());
        }
        F fG3 = g(javaClassifierType, aVar.b(3), null);
        if (fG3 != null && (fG = g(javaClassifierType, aVar.b(2), fG3)) != null) {
            return zIsRaw ? new h(fG3, fG) : C.a(fG3, fG);
        }
        return c3.j.c(iVar, javaClassifierType.getPresentableText());
    }

    public void t(byte[] bArr, short s3) {
        int i;
        int i3 = ((C0937a) this.c).e;
        B.h hVar = (B.h) this.d;
        if (i3 == 2) {
            hVar.getClass();
            i = 1;
        } else {
            if (i3 != 4) {
                throw new RuntimeException("Wrong Dilithium Eta!");
            }
            hVar.getClass();
            i = 2;
        }
        hVar.getClass();
        int i4 = i * 136;
        byte[] bArr2 = new byte[i4];
        N3.g gVar = (N3.g) hVar.c;
        gVar.reset();
        gVar.update(bArr, 0, bArr.length);
        gVar.update(new byte[]{(byte) s3, (byte) (s3 >> 8)}, 0, 2);
        gVar.doOutput(bArr2, 0, i4);
        int iN = n(this, 0, 256, bArr2, i4, i3);
        while (iN < 256) {
            gVar.doOutput(bArr2, 0, 136);
            iN += n(this, iN, 256 - iN, bArr2, 136, i3);
        }
    }

    public String toString() {
        switch (this.f124a) {
            case 8:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.b);
                sb.append('{');
                C0279g c0279g = ((C0279g) this.c).b;
                String str = "";
                while (c0279g != null) {
                    A a6 = c0279g.f2077a;
                    sb.append(str);
                    if (a6 == null || !A.class.isArray()) {
                        sb.append(a6);
                    } else {
                        sb.append((CharSequence) Arrays.deepToString(new Object[]{a6}), 1, r2.length() - 1);
                    }
                    c0279g = c0279g.b;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            case 9:
                return o.a((C0076n1) this.b).toString();
            case 19:
                StringBuffer stringBuffer = new StringBuffer("[");
                int i = 0;
                while (true) {
                    int[] iArr = (int[]) this.b;
                    if (i >= iArr.length) {
                        stringBuffer.append("]");
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(iArr[i]);
                    if (i != ((int[]) this.b).length - 1) {
                        stringBuffer.append(", ");
                    }
                    i++;
                }
                break;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, int i) {
        this.f124a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public d(C0937a c0937a) {
        this.f124a = 19;
        this.b = new int[256];
        this.c = c0937a;
        B.h hVar = c0937a.f5145h;
        this.d = hVar;
        hVar.getClass();
    }

    @Override // com.google.android.datatransport.TransportFactory
    public Transport getTransport(String str, Class cls, C0569b c0569b, Transformer transformer) {
        Set set = (Set) this.b;
        if (set.contains(c0569b)) {
            return new D.b((com.google.android.datatransport.runtime.k) this.c, str, c0569b, transformer, (v) this.d);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c0569b, set));
    }

    public d(String str) {
        this.f124a = 8;
        C0279g c0279g = new C0279g();
        this.c = c0279g;
        this.d = c0279g;
        this.b = str;
    }

    public d(E2.e eVar, C0813c c0813c) {
        this.f124a = 14;
        this.b = eVar;
        this.c = c0813c;
        this.d = new ConcurrentHashMap();
    }

    public d(C0430f argumentRange, Method[] methodArr, Method method) {
        this.f124a = 10;
        kotlin.jvm.internal.h.f(argumentRange, "argumentRange");
        this.b = argumentRange;
        this.c = methodArr;
        this.d = method;
    }

    public d(C0946f c, TypeParameterResolver typeParameterResolver) {
        this.f124a = 0;
        kotlin.jvm.internal.h.f(c, "c");
        kotlin.jvm.internal.h.f(typeParameterResolver, "typeParameterResolver");
        this.b = c;
        this.c = typeParameterResolver;
        this.d = new B.h(new z.e(1));
    }

    public d(ClassifierDescriptorWithTypeParameters classifierDescriptor, List arguments, d dVar) {
        this.f124a = 12;
        kotlin.jvm.internal.h.f(classifierDescriptor, "classifierDescriptor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        this.b = classifierDescriptor;
        this.c = arguments;
        this.d = dVar;
    }

    public d() {
        this.f124a = 11;
        this.b = new LinkedHashSet();
        this.c = new LinkedHashMap();
        this.d = kotlin.text.a.f3942a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Object obj, Function3 function3, Function3 function32, o3.k kVar) {
        this.f124a = 15;
        this.b = obj;
        this.c = (kotlin.jvm.internal.f) function3;
        this.d = (kotlin.jvm.internal.f) function32;
    }

    public d(C0076n1 c0076n1, List list) {
        this.f124a = 9;
        this.b = c0076n1;
        this.c = list;
        this.d = F0.a.b;
    }
}
