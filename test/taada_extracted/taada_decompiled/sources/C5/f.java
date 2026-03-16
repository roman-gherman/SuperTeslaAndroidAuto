package C5;

import A2.C0022d;
import C0.x;
import G2.A;
import G2.j0;
import G2.k0;
import I2.g;
import M2.s;
import X2.t;
import a3.AbstractC0162z;
import a3.C0138a;
import a3.C0142e;
import a3.C0152o;
import a3.C0161y;
import a3.F;
import a3.b0;
import a3.c0;
import a3.d0;
import android.widget.EditText;
import c4.AbstractC0246d;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import f.n;
import h2.n0;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.m;
import kotlin.collections.o;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.w;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.l;
import m2.C0652d;
import n2.AbstractC0713e;
import n2.C0712d;
import n2.EnumC0709a;
import n2.EnumC0711c;
import net.bytebuddy.pool.TypePool;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.ExtendedDigest;
import w3.C0896n;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f180a = null;
    public static boolean b = false;

    public static byte[] A(byte[] bArr, int i, int i3) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        }
        if (i + i3 > bArr.length) {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
        byte[] bArr2 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr2[i4] = bArr[i + i4];
        }
        return bArr2;
    }

    public static int[] B(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static final int C(Caller caller) {
        h.f(caller, "<this>");
        return caller.getParameterTypes().size();
    }

    public static N3.h D(ExtendedDigest extendedDigest, int i, L3.c cVar) {
        return new N3.h(extendedDigest.getDigestSize() * 4, i, extendedDigest.getAlgorithmName(), cVar);
    }

    public static C0896n E(String str) {
        if (str.equals("SHA-256")) {
            return NISTObjectIdentifiers.id_sha256;
        }
        if (str.equals("SHA-512")) {
            return NISTObjectIdentifiers.id_sha512;
        }
        if (str.equals("SHAKE128")) {
            return NISTObjectIdentifiers.id_shake128;
        }
        if (str.equals("SHAKE256")) {
            return NISTObjectIdentifiers.id_shake256;
        }
        throw new IllegalArgumentException("unrecognized digest: ".concat(str));
    }

    public static final KClass F(KClassifier kClassifier) {
        Object obj;
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (!(kClassifier instanceof KTypeParameter)) {
            throw new N1.d("Cannot calculate JVM erasure for type: " + kClassifier, 2);
        }
        List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            KType kType = (KType) next;
            h.d(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            ClassifierDescriptor declarationDescriptor = ((n0) kType).f3422a.c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null && classDescriptor.getKind() != EnumC0711c.b && classDescriptor.getKind() != EnumC0711c.e) {
                obj = next;
                break;
            }
        }
        KType kType2 = (KType) obj;
        if (kType2 == null) {
            kType2 = (KType) m.R(upperBounds);
        }
        return kType2 != null ? G(kType2) : w.f3817a.b(Object.class);
    }

    public static final KClass G(KType kType) {
        h.f(kType, "<this>");
        KClassifier classifier = kType.getClassifier();
        if (classifier != null) {
            return F(classifier);
        }
        throw new N1.d("Cannot calculate JVM erasure for type: " + kType, 2);
    }

    public static String H(C0896n c0896n) {
        if (c0896n.f(NISTObjectIdentifiers.id_sha256)) {
            return "SHA256";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_sha512)) {
            return "SHA512";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_shake128)) {
            return "SHAKE128";
        }
        if (c0896n.f(NISTObjectIdentifiers.id_shake256)) {
            return "SHAKE256";
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + c0896n);
    }

    public static boolean I(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            int i3 = iArr[i] ^ Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE ^ iArr2[i];
            if (i3 < i4) {
                return false;
            }
            if (i3 > i4) {
                return true;
            }
        }
        return true;
    }

    public static Continuation J(Continuation continuation) {
        Continuation<Object> continuationIntercepted;
        h.f(continuation, "<this>");
        U1.c cVar = continuation instanceof U1.c ? (U1.c) continuation : null;
        return (cVar == null || (continuationIntercepted = cVar.intercepted()) == null) ? continuation : continuationIntercepted;
    }

    public static boolean K(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean L(int i, long j6) {
        if (j6 >= 0) {
            return j6 < (1 << i);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean M(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean N(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static final boolean O(int i, String str) {
        char cCharAt = str.charAt(i);
        return 'A' <= cCharAt && cCharAt < '[';
    }

    public static boolean P(int[] iArr) {
        for (int i = 0; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean Q(long[] jArr) {
        for (int i = 0; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static String R(String str, Object... objArr) {
        int iIndexOf;
        String string;
        int i = 0;
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            try {
                string = String.valueOf(obj);
            } catch (Exception e) {
                String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                StringBuilder sbM = B2.b.m("<", str2, " threw ");
                sbM.append(e.getClass().getName());
                sbM.append(">");
                string = sbM.toString();
            }
            objArr[i3] = string;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + str.length());
        int i4 = 0;
        while (i < objArr.length && (iIndexOf = str.indexOf("%s", i4)) != -1) {
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(objArr[i]);
            i4 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) str, i4, str.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static final c0 S(c0 c0Var, boolean z6) {
        h.f(c0Var, "<this>");
        C0152o c0152oO = C0142e.o(c0Var, z6);
        if (c0152oO != null) {
            return c0152oO;
        }
        F fT = T(c0Var);
        return fT != null ? fT : c0Var.g(false);
    }

    public static final F T(c0 c0Var) {
        C0161y c0161y;
        TypeConstructor typeConstructorC = c0Var.c();
        C0161y c0161y2 = typeConstructorC instanceof C0161y ? (C0161y) typeConstructorC : null;
        if (c0161y2 != null) {
            LinkedHashSet<AbstractC0162z> linkedHashSet = c0161y2.b;
            ArrayList arrayList = new ArrayList(o.D(linkedHashSet));
            boolean z6 = false;
            for (AbstractC0162z abstractC0162zS : linkedHashSet) {
                if (b0.f(abstractC0162zS)) {
                    abstractC0162zS = S(abstractC0162zS.f(), false);
                    z6 = true;
                }
                arrayList.add(abstractC0162zS);
            }
            if (z6) {
                AbstractC0162z abstractC0162zS2 = c0161y2.f1559a;
                if (abstractC0162zS2 == null) {
                    abstractC0162zS2 = null;
                } else if (b0.f(abstractC0162zS2)) {
                    abstractC0162zS2 = S(abstractC0162zS2.f(), false);
                }
                arrayList.isEmpty();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList);
                linkedHashSet2.hashCode();
                c0161y = new C0161y(linkedHashSet2);
                c0161y.f1559a = abstractC0162zS2;
            } else {
                c0161y = null;
            }
            if (c0161y != null) {
                return c0161y.a();
            }
        }
        return null;
    }

    public static final EnumC0709a U(A a6) {
        int i = a6 == null ? -1 : t.f1450a[a6.ordinal()];
        EnumC0709a enumC0709a = EnumC0709a.f4226a;
        if (i != 1) {
            if (i == 2) {
                return EnumC0709a.b;
            }
            if (i == 3) {
                return EnumC0709a.c;
            }
            if (i == 4) {
                return EnumC0709a.d;
            }
        }
        return enumC0709a;
    }

    public static int V(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int i = 1;
        int iNumberOfLeadingZeros = (length << 5) - Integer.numberOfLeadingZeros(iArr[length - 1]);
        int i3 = 30;
        int i4 = (iNumberOfLeadingZeros + 29) / 30;
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[i4];
        int[] iArr7 = new int[i4];
        int[] iArr8 = new int[i4];
        int i5 = 0;
        iArr5[0] = 1;
        v(iArr2, iArr7, iNumberOfLeadingZeros);
        v(iArr, iArr8, iNumberOfLeadingZeros);
        System.arraycopy(iArr8, 0, iArr6, 0, i4);
        int i6 = iArr8[0];
        int i7 = (2 - (i6 * i6)) * i6;
        int i8 = (2 - (i6 * i7)) * i7;
        int i9 = (2 - (i6 * i8)) * i8;
        int i10 = (2 - (i6 * i9)) * i9;
        int i11 = (int) (((((long) iNumberOfLeadingZeros) * 150964) + 99243) >>> 16);
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = iArr6[i5];
            int i15 = iArr7[i5];
            int i16 = i10;
            int i17 = iNumberOfLeadingZeros;
            int i18 = i;
            int i19 = i5;
            int i20 = i19;
            int i21 = i20;
            int i22 = 1073741824;
            int i23 = 1073741824;
            while (i21 < i3) {
                int i24 = i3;
                int i25 = i13 >> 31;
                int i26 = i21;
                int i27 = -(i15 & 1);
                int i28 = i15 - ((i14 ^ i25) & i27);
                int i29 = i20 - ((i22 ^ i25) & i27);
                int i30 = i23 - ((i19 ^ i25) & i27);
                int i31 = i27 & (~i25);
                i13 = (i13 ^ i31) + 1;
                i14 += i28 & i31;
                i22 += i29 & i31;
                i19 += i31 & i30;
                i15 = i28 >> 1;
                i20 = i29 >> 1;
                i23 = i30 >> 1;
                i21 = i26 + 1;
                i3 = i24;
            }
            int i32 = i3;
            int[] iArr9 = {i22, i19, i20, i23};
            int i33 = iArr9[i21];
            int i34 = iArr9[i18];
            int i35 = iArr9[2];
            int i36 = iArr9[3];
            int i37 = i4 - 1;
            int i38 = iArr4[i37] >> 31;
            int i39 = iArr5[i37] >> 31;
            int i40 = (i33 & i38) + (i34 & i39);
            int i41 = (i35 & i38) + (i36 & i39);
            int i42 = iArr8[i21];
            int[] iArr10 = iArr4;
            int i43 = i11;
            int i44 = i12;
            long j6 = i33;
            long j7 = iArr4[i21];
            long j8 = i34;
            long j9 = iArr5[i21];
            long j10 = (j8 * j9) + (j6 * j7);
            long j11 = i35;
            long j12 = j7 * j11;
            long j13 = i36;
            long j14 = (j13 * j9) + j12;
            int i45 = i40 - (((((int) j10) * i16) + i40) & 1073741823);
            long j15 = i42;
            long j16 = i45;
            long j17 = (j15 * j16) + j10;
            long j18 = i41 - (((((int) j14) * i16) + i41) & 1073741823);
            long j19 = j17 >> i32;
            int i46 = i18;
            long j20 = ((j15 * j18) + j14) >> i32;
            while (i46 < i4) {
                int i47 = iArr8[i46];
                long j21 = j18;
                long j22 = iArr10[i46];
                long j23 = j6 * j22;
                long j24 = iArr5[i46];
                long j25 = (j8 * j24) + j23;
                long j26 = i47;
                long jE = androidx.constraintlayout.core.motion.a.e(j26, j16, j25, j19);
                long jE2 = androidx.constraintlayout.core.motion.a.e(j26, j21, (j24 * j13) + (j11 * j22), j20);
                int i48 = i46 - 1;
                iArr10[i48] = ((int) jE) & 1073741823;
                iArr5[i48] = ((int) jE2) & 1073741823;
                j20 = jE2 >> i32;
                i46++;
                j19 = jE >> i32;
                j18 = j21;
            }
            iArr10[i37] = (int) j19;
            iArr5[i37] = (int) j20;
            int i49 = iArr9[i21];
            int i50 = iArr9[i18];
            int i51 = iArr9[2];
            int i52 = iArr9[3];
            long j27 = i49;
            int[] iArr11 = iArr5;
            long j28 = iArr6[i21];
            long j29 = j27 * j28;
            long j30 = i50;
            long j31 = iArr7[i21];
            long j32 = (j30 * j31) + j29;
            long j33 = i51;
            long j34 = j33 * j28;
            long j35 = i52;
            long j36 = ((j31 * j35) + j34) >> i32;
            int i53 = i18;
            long j37 = j32 >> i32;
            while (i53 < i4) {
                long j38 = j35;
                long j39 = iArr6[i53];
                long j40 = iArr7[i53];
                long j41 = j30;
                long jE3 = androidx.constraintlayout.core.motion.a.e(j41, j40, j27 * j39, j37);
                j30 = j41;
                long jE4 = androidx.constraintlayout.core.motion.a.e(j38, j40, j33 * j39, j36);
                int i54 = i53 - 1;
                iArr6[i54] = ((int) jE3) & 1073741823;
                iArr7[i54] = ((int) jE4) & 1073741823;
                j36 = jE4 >> i32;
                i53++;
                j35 = j38;
                j37 = jE3 >> i32;
            }
            iArr6[i37] = (int) j37;
            iArr7[i37] = (int) j36;
            i12 = i44 + 30;
            iArr5 = iArr11;
            i5 = i21;
            i = i18;
            i10 = i16;
            iNumberOfLeadingZeros = i17;
            i3 = i32;
            iArr4 = iArr10;
            i11 = i43;
        }
        int i55 = iNumberOfLeadingZeros;
        int i56 = i;
        int[] iArr12 = iArr4;
        int i57 = i5;
        int i58 = i4 - 1;
        int i59 = iArr6[i58] >> 31;
        int i60 = i57;
        int i61 = i60;
        while (i60 < i58) {
            int i62 = ((iArr6[i60] ^ i59) - i59) + i61;
            iArr6[i60] = i62 & 1073741823;
            i61 = i62 >> 30;
            i60++;
        }
        iArr6[i58] = ((iArr6[i58] ^ i59) - i59) + i61;
        int i63 = iArr12[i58] >> 31;
        int i64 = i57;
        int i65 = i64;
        while (i64 < i58) {
            int i66 = (((iArr12[i64] + (iArr8[i64] & i63)) ^ i59) - i59) + i65;
            iArr12[i64] = i66 & 1073741823;
            i65 = i66 >> 30;
            i64++;
        }
        int i67 = (((iArr12[i58] + (i63 & iArr8[i58])) ^ i59) - i59) + i65;
        iArr12[i58] = i67;
        int i68 = i67 >> 31;
        int i69 = i57;
        int i70 = i69;
        while (i69 < i58) {
            int i71 = iArr12[i69] + (iArr8[i69] & i68) + i70;
            iArr12[i69] = i71 & 1073741823;
            i70 = i71 >> 30;
            i69++;
        }
        iArr12[i58] = iArr12[i58] + (i68 & iArr8[i58]) + i70;
        long j42 = 0;
        int i72 = i57;
        int i73 = i72;
        int i74 = i73;
        int i75 = i55;
        while (i75 > 0) {
            while (i72 < Math.min(32, i75)) {
                j42 |= ((long) iArr12[i73]) << i72;
                i72 += 30;
                i73++;
            }
            iArr3[i74] = (int) j42;
            j42 >>>= 32;
            i72 -= 32;
            i75 -= 32;
            i74++;
        }
        return z(i4, i56, iArr6) & z(i4, i57, iArr7);
    }

    public static void W(int[] iArr, int[] iArr2, int[] iArr3) {
        long j6 = ((long) iArr2[0]) & 4294967295L;
        long j7 = ((long) iArr2[1]) & 4294967295L;
        long j8 = ((long) iArr2[2]) & 4294967295L;
        long j9 = ((long) iArr2[3]) & 4294967295L;
        long j10 = ((long) iArr2[4]) & 4294967295L;
        long j11 = ((long) iArr2[5]) & 4294967295L;
        long j12 = ((long) iArr2[6]) & 4294967295L;
        long j13 = ((long) iArr2[7]) & 4294967295L;
        long j14 = ((long) iArr[0]) & 4294967295L;
        long j15 = j14 * j6;
        iArr3[0] = (int) j15;
        long j16 = (j14 * j7) + (j15 >>> 32);
        iArr3[1] = (int) j16;
        long j17 = (j14 * j8) + (j16 >>> 32);
        iArr3[2] = (int) j17;
        long j18 = (j14 * j9) + (j17 >>> 32);
        iArr3[3] = (int) j18;
        long j19 = (j14 * j10) + (j18 >>> 32);
        iArr3[4] = (int) j19;
        long j20 = (j14 * j11) + (j19 >>> 32);
        iArr3[5] = (int) j20;
        long j21 = (j14 * j12) + (j20 >>> 32);
        iArr3[6] = (int) j21;
        long j22 = (j14 * j13) + (j21 >>> 32);
        iArr3[7] = (int) j22;
        int i = (int) (j22 >>> 32);
        iArr3[8] = i;
        int i3 = 1;
        for (int i4 = 8; i3 < i4; i4 = 8) {
            long j23 = ((long) iArr[i3]) & 4294967295L;
            long j24 = j10;
            long j25 = (j23 * j6) + (((long) iArr3[i3]) & 4294967295L);
            iArr3[i3] = (int) j25;
            int i5 = i3 + 1;
            long j26 = (j23 * j7) + (((long) iArr3[i5]) & 4294967295L) + (j25 >>> 32);
            iArr3[i5] = (int) j26;
            int i6 = i3 + 2;
            long j27 = (j23 * j8) + (((long) iArr3[i6]) & 4294967295L) + (j26 >>> 32);
            iArr3[i6] = (int) j27;
            int i7 = i3 + 3;
            long j28 = (j23 * j9) + (((long) iArr3[i7]) & 4294967295L) + (j27 >>> 32);
            iArr3[i7] = (int) j28;
            int i8 = i3 + 4;
            long j29 = (j23 * j24) + (((long) iArr3[i8]) & 4294967295L) + (j28 >>> 32);
            iArr3[i8] = (int) j29;
            int i9 = i3 + 5;
            long j30 = (j23 * j11) + (((long) iArr3[i9]) & 4294967295L) + (j29 >>> 32);
            iArr3[i9] = (int) j30;
            int i10 = i3 + 6;
            long j31 = (j23 * j12) + (((long) iArr3[i10]) & 4294967295L) + (j30 >>> 32);
            iArr3[i10] = (int) j31;
            long j32 = j31 >>> 32;
            int i11 = i3 + 7;
            long j33 = (j23 * j13) + (((long) iArr3[i11]) & 4294967295L) + j32;
            iArr3[i11] = (int) j33;
            iArr3[i3 + 8] = (int) (j33 >>> 32);
            i3 = i5;
            j10 = j24;
        }
    }

    public static final void X(I1.d dVar, ByteBuffer byteBuffer) throws EOFException {
        h.f(dVar, "<this>");
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            J1.b bVarE = dVar.e();
            if (dVar.e - dVar.d < 1) {
                bVarE = dVar.g(1, bVarE);
            }
            if (bVarE == null) {
                break;
            }
            int iRemaining = byteBuffer.remaining();
            int i = bVarE.c - bVarE.b;
            if (iRemaining < i) {
                l.U(bVarE, byteBuffer, iRemaining);
                dVar.d = bVarE.b;
                break;
            } else {
                l.U(bVarE, byteBuffer, i);
                dVar.h(bVarE);
            }
        }
        if (byteBuffer.hasRemaining()) {
            throw new EOFException("Not enough data in packet to fill buffer: " + byteBuffer.remaining() + " more bytes required");
        }
    }

    public static int Y(ByteInput byteInput) {
        int i;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        do {
            byte b2 = byteInput.readByte();
            i3 |= (b2 & 127) << (i5 * 7);
            i4 <<= 7;
            i5++;
            i = b2 & 128;
            if (i != 128) {
                break;
            }
        } while (i5 < 5);
        if (i != 128) {
            return ((i4 >> 1) & i3) != 0 ? i3 | i4 : i3;
        }
        throw new n("invalid LEB128 sequence", null);
    }

    public static int Z(ByteInput byteInput) {
        int i;
        int i3 = 0;
        int i4 = 0;
        do {
            byte b2 = byteInput.readByte();
            i3 |= (b2 & 127) << (i4 * 7);
            i4++;
            i = b2 & 128;
            if (i != 128) {
                break;
            }
        } while (i4 < 5);
        if (i != 128) {
            return i3;
        }
        throw new n("invalid LEB128 sequence", null);
    }

    public static void a(byte[] bArr, int i, int i3) {
        bArr[i3] = (byte) i;
        bArr[i3 + 1] = (byte) (i >>> 8);
        bArr[i3 + 2] = (byte) (i >>> 16);
        bArr[i3 + 3] = (byte) (i >>> 24);
    }

    public static final void a0(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final org.slf4j.Logger b(String str) {
        org.slf4j.Logger loggerE = A5.a.e(str);
        h.e(loggerE, "getLogger(name)");
        return loggerE;
    }

    public static final String b0(ClassDescriptor classDescriptor, String str) {
        String internalName;
        h.f(classDescriptor, "classDescriptor");
        String str2 = C0652d.f4074a;
        L2.e eVarI = R2.e.g(classDescriptor).i();
        h.e(eVarI, "fqNameSafe.toUnsafe()");
        L2.b bVarF = C0652d.f(eVarI);
        if (bVarF != null) {
            internalName = S2.a.b(bVarF).e();
            h.e(internalName, "byClassId(it).internalName");
        } else {
            internalName = AbstractC0246d.l(classDescriptor, E2.f.d);
        }
        h.f(internalName, "internalName");
        return internalName + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
    }

    public static int c(int i, byte[] bArr) {
        int i3 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        return ((bArr[i + 3] & 255) << 24) | i3 | ((bArr[i + 2] & 255) << 16);
    }

    public static final ByteBuffer c0(ByteBuffer byteBuffer, int i, int i3) {
        h.f(byteBuffer, "<this>");
        ByteBuffer myDuplicate$lambda$1 = byteBuffer.duplicate();
        h.e(myDuplicate$lambda$1, "myDuplicate$lambda$1");
        myDuplicate$lambda$1.position(i);
        myDuplicate$lambda$1.limit(i + i3);
        ByteBuffer mySlice$lambda$2 = myDuplicate$lambda$1.slice();
        h.e(mySlice$lambda$2, "mySlice$lambda$2");
        return mySlice$lambda$2;
    }

    public static int d(int[] iArr, int[] iArr2, int[] iArr3) {
        long j6 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L);
        iArr3[0] = (int) j6;
        long j7 = (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (j6 >>> 32);
        iArr3[1] = (int) j7;
        long j8 = (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (j7 >>> 32);
        iArr3[2] = (int) j8;
        long j9 = (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (j8 >>> 32);
        iArr3[3] = (int) j9;
        long j10 = (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (j9 >>> 32);
        iArr3[4] = (int) j10;
        long j11 = (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (j10 >>> 32);
        iArr3[5] = (int) j11;
        long j12 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (j11 >>> 32);
        iArr3[6] = (int) j12;
        long j13 = (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L) + (j12 >>> 32);
        iArr3[7] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static void d0(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[0]) & 4294967295L;
        int i = 16;
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i4 - 1;
            long j7 = ((long) iArr[i4]) & 4294967295L;
            long j8 = j7 * j7;
            iArr2[i - 1] = (i3 << 31) | ((int) (j8 >>> 33));
            i -= 2;
            iArr2[i] = (int) (j8 >>> 1);
            i3 = (int) j8;
            if (i5 <= 0) {
                long j9 = j6 * j6;
                long j10 = (j9 >>> 33) | (((long) (i3 << 31)) & 4294967295L);
                iArr2[0] = (int) j9;
                int i6 = ((int) (j9 >>> 32)) & 1;
                long j11 = ((long) iArr[1]) & 4294967295L;
                long j12 = ((long) iArr2[2]) & 4294967295L;
                long j13 = (j11 * j6) + j10;
                int i7 = (int) j13;
                iArr2[1] = i6 | (i7 << 1);
                long j14 = ((long) iArr[2]) & 4294967295L;
                long j15 = ((long) iArr2[3]) & 4294967295L;
                long j16 = ((long) iArr2[4]) & 4294967295L;
                long j17 = (j14 * j6) + j12 + (j13 >>> 32);
                int i8 = (int) j17;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long jE = androidx.constraintlayout.core.motion.a.e(j14, j11, j17 >>> 32, j15);
                long j18 = j16 + (jE >>> 32);
                long j19 = ((long) iArr[3]) & 4294967295L;
                long j20 = (((long) iArr2[5]) & 4294967295L) + (j18 >>> 32);
                long j21 = j18 & 4294967295L;
                long j22 = (((long) iArr2[6]) & 4294967295L) + (j20 >>> 32);
                long j23 = j20 & 4294967295L;
                long j24 = (j19 * j6) + (jE & 4294967295L);
                int i9 = (int) j24;
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
                int i10 = i9 >>> 31;
                long jE2 = androidx.constraintlayout.core.motion.a.e(j19, j11, j24 >>> 32, j21);
                long jE3 = androidx.constraintlayout.core.motion.a.e(j19, j14, jE2 >>> 32, j23);
                long j25 = j22 + (jE3 >>> 32);
                long j26 = jE3 & 4294967295L;
                long j27 = ((long) iArr[4]) & 4294967295L;
                long j28 = (((long) iArr2[7]) & 4294967295L) + (j25 >>> 32);
                long j29 = (((long) iArr2[8]) & 4294967295L) + (j28 >>> 32);
                long j30 = j28 & 4294967295L;
                long j31 = (j27 * j6) + (jE2 & 4294967295L);
                int i11 = (int) j31;
                iArr2[4] = i10 | (i11 << 1);
                long jE4 = androidx.constraintlayout.core.motion.a.e(j27, j11, j31 >>> 32, j26);
                long jE5 = androidx.constraintlayout.core.motion.a.e(j27, j14, jE4 >>> 32, j25 & 4294967295L);
                long jE6 = androidx.constraintlayout.core.motion.a.e(j27, j19, jE5 >>> 32, j30);
                long j32 = jE5 & 4294967295L;
                long j33 = j29 + (jE6 >>> 32);
                long j34 = jE6 & 4294967295L;
                long j35 = ((long) iArr[5]) & 4294967295L;
                long j36 = (((long) iArr2[9]) & 4294967295L) + (j33 >>> 32);
                long j37 = (((long) iArr2[10]) & 4294967295L) + (j36 >>> 32);
                long j38 = (j35 * j6) + (jE4 & 4294967295L);
                int i12 = (int) j38;
                iArr2[5] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long jE7 = androidx.constraintlayout.core.motion.a.e(j35, j11, j38 >>> 32, j32);
                long jE8 = androidx.constraintlayout.core.motion.a.e(j35, j14, jE7 >>> 32, j34);
                long jE9 = androidx.constraintlayout.core.motion.a.e(j35, j19, jE8 >>> 32, j33 & 4294967295L);
                long j39 = jE8 & 4294967295L;
                long jE10 = androidx.constraintlayout.core.motion.a.e(j35, j27, jE9 >>> 32, j36 & 4294967295L);
                long j40 = jE9 & 4294967295L;
                long j41 = j37 + (jE10 >>> 32);
                long j42 = ((long) iArr[6]) & 4294967295L;
                long j43 = (((long) iArr2[11]) & 4294967295L) + (j41 >>> 32);
                long j44 = (((long) iArr2[12]) & 4294967295L) + (j43 >>> 32);
                long j45 = (j42 * j6) + (jE7 & 4294967295L);
                int i14 = (int) j45;
                iArr2[6] = i13 | (i14 << 1);
                int i15 = i14 >>> 31;
                long jE11 = androidx.constraintlayout.core.motion.a.e(j42, j11, j45 >>> 32, j39);
                long jE12 = androidx.constraintlayout.core.motion.a.e(j42, j14, jE11 >>> 32, j40);
                long jE13 = androidx.constraintlayout.core.motion.a.e(j42, j19, jE12 >>> 32, jE10 & 4294967295L);
                long j46 = jE12 & 4294967295L;
                long jE14 = androidx.constraintlayout.core.motion.a.e(j42, j27, jE13 >>> 32, j41 & 4294967295L);
                long j47 = jE13 & 4294967295L;
                long jE15 = androidx.constraintlayout.core.motion.a.e(j42, j35, jE14 >>> 32, j43 & 4294967295L);
                long j48 = j44 + (jE15 >>> 32);
                long j49 = ((long) iArr[7]) & 4294967295L;
                long j50 = (((long) iArr2[13]) & 4294967295L) + (j48 >>> 32);
                long j51 = (((long) iArr2[14]) & 4294967295L) + (j50 >>> 32);
                long j52 = j50 & 4294967295L;
                long j53 = (j49 * j6) + (jE11 & 4294967295L);
                int i16 = (int) j53;
                iArr2[7] = (i16 << 1) | i15;
                int i17 = i16 >>> 31;
                long jE16 = androidx.constraintlayout.core.motion.a.e(j49, j11, j53 >>> 32, j46);
                long jE17 = androidx.constraintlayout.core.motion.a.e(j49, j14, jE16 >>> 32, j47);
                long jE18 = androidx.constraintlayout.core.motion.a.e(j49, j19, jE17 >>> 32, jE14 & 4294967295L);
                long jE19 = androidx.constraintlayout.core.motion.a.e(j49, j27, jE18 >>> 32, jE15 & 4294967295L);
                long jE20 = androidx.constraintlayout.core.motion.a.e(j49, j35, jE19 >>> 32, j48 & 4294967295L);
                long jE21 = androidx.constraintlayout.core.motion.a.e(j49, j42, jE20 >>> 32, j52);
                long j54 = j51 + (jE21 >>> 32);
                int i18 = (int) jE16;
                iArr2[8] = (i18 << 1) | i17;
                int i19 = (int) jE17;
                iArr2[9] = (i18 >>> 31) | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) jE18;
                iArr2[10] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) jE19;
                iArr2[11] = i22 | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) jE20;
                iArr2[12] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) jE21;
                iArr2[13] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j54;
                iArr2[14] = i28 | (i29 << 1);
                iArr2[15] = ((iArr2[15] + ((int) (j54 >>> 32))) << 1) | (i29 >>> 31);
                return;
            }
            i4 = i5;
        }
    }

    public static int e(int i, int i3, int[] iArr, int[] iArr2, int i4) {
        long j6 = (((long) iArr[i]) & 4294967295L) + (((long) iArr2[i3]) & 4294967295L) + (((long) i4) & 4294967295L);
        iArr2[i3] = (int) j6;
        int i5 = i3 + 1;
        long j7 = (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L) + (j6 >>> 32);
        iArr2[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L) + (j7 >>> 32);
        iArr2[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L) + (j8 >>> 32);
        iArr2[i7] = (int) j9;
        int i8 = i3 + 4;
        long j10 = (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i8]) & 4294967295L) + (j9 >>> 32);
        iArr2[i8] = (int) j10;
        int i9 = i3 + 5;
        long j11 = (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i9]) & 4294967295L) + (j10 >>> 32);
        iArr2[i9] = (int) j11;
        int i10 = i3 + 6;
        long j12 = (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L) + (j11 >>> 32);
        iArr2[i10] = (int) j12;
        int i11 = i3 + 7;
        long j13 = (((long) iArr[i + 7]) & 4294967295L) + (4294967295L & ((long) iArr2[i11])) + (j12 >>> 32);
        iArr2[i11] = (int) j13;
        return (int) (j13 >>> 32);
    }

    public static boolean e0(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (classicTypeSystemContext.argumentsCount(simpleTypeMarker) == classicTypeSystemContext.argumentsCount(simpleTypeMarker2) && classicTypeSystemContext.isMarkedNullable(simpleTypeMarker) == classicTypeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            if ((classicTypeSystemContext.asDefinitelyNotNullType(simpleTypeMarker) == null) == (classicTypeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2) == null) && classicTypeSystemContext.areEqualTypeConstructors(classicTypeSystemContext.typeConstructor(simpleTypeMarker), classicTypeSystemContext.typeConstructor(simpleTypeMarker2))) {
                if (!classicTypeSystemContext.identicalArguments(simpleTypeMarker, simpleTypeMarker2)) {
                    int iArgumentsCount = classicTypeSystemContext.argumentsCount(simpleTypeMarker);
                    for (int i = 0; i < iArgumentsCount; i++) {
                        TypeArgumentMarker argument = classicTypeSystemContext.getArgument(simpleTypeMarker, i);
                        TypeArgumentMarker argument2 = classicTypeSystemContext.getArgument(simpleTypeMarker2, i);
                        if (classicTypeSystemContext.isStarProjection(argument) == classicTypeSystemContext.isStarProjection(argument2) && (classicTypeSystemContext.isStarProjection(argument) || (classicTypeSystemContext.getVariance(argument) == classicTypeSystemContext.getVariance(argument2) && f0(classicTypeSystemContext, classicTypeSystemContext.getType(argument), classicTypeSystemContext.getType(argument2))))) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static int f(int[] iArr, int[] iArr2) {
        long j6 = (((long) iArr[8]) & 4294967295L) + (((long) iArr2[16]) & 4294967295L);
        int i = (int) j6;
        iArr[8] = i;
        iArr2[16] = i;
        long j7 = (((long) iArr[9]) & 4294967295L) + (((long) iArr2[17]) & 4294967295L) + (j6 >>> 32);
        int i3 = (int) j7;
        iArr[9] = i3;
        iArr2[17] = i3;
        long j8 = (((long) iArr[10]) & 4294967295L) + (((long) iArr2[18]) & 4294967295L) + (j7 >>> 32);
        int i4 = (int) j8;
        iArr[10] = i4;
        iArr2[18] = i4;
        long j9 = (((long) iArr[11]) & 4294967295L) + (((long) iArr2[19]) & 4294967295L) + (j8 >>> 32);
        int i5 = (int) j9;
        iArr[11] = i5;
        iArr2[19] = i5;
        long j10 = (((long) iArr[12]) & 4294967295L) + (((long) iArr2[20]) & 4294967295L) + (j9 >>> 32);
        int i6 = (int) j10;
        iArr[12] = i6;
        iArr2[20] = i6;
        long j11 = (((long) iArr[13]) & 4294967295L) + (((long) iArr2[21]) & 4294967295L) + (j10 >>> 32);
        int i7 = (int) j11;
        iArr[13] = i7;
        iArr2[21] = i7;
        long j12 = (((long) iArr[14]) & 4294967295L) + (((long) iArr2[22]) & 4294967295L) + (j11 >>> 32);
        int i8 = (int) j12;
        iArr[14] = i8;
        iArr2[22] = i8;
        long j13 = (((long) iArr[15]) & 4294967295L) + (4294967295L & ((long) iArr2[23])) + (j12 >>> 32);
        int i9 = (int) j13;
        iArr[15] = i9;
        iArr2[23] = i9;
        return (int) (j13 >>> 32);
    }

    public static boolean f0(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        SimpleTypeMarker simpleTypeMarkerAsSimpleType = classicTypeSystemContext.asSimpleType(kotlinTypeMarker);
        SimpleTypeMarker simpleTypeMarkerAsSimpleType2 = classicTypeSystemContext.asSimpleType(kotlinTypeMarker2);
        if (simpleTypeMarkerAsSimpleType != null && simpleTypeMarkerAsSimpleType2 != null) {
            return e0(classicTypeSystemContext, simpleTypeMarkerAsSimpleType, simpleTypeMarkerAsSimpleType2);
        }
        FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = classicTypeSystemContext.asFlexibleType(kotlinTypeMarker);
        FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType2 = classicTypeSystemContext.asFlexibleType(kotlinTypeMarker2);
        return flexibleTypeMarkerAsFlexibleType != null && flexibleTypeMarkerAsFlexibleType2 != null && e0(classicTypeSystemContext, classicTypeSystemContext.lowerBound(flexibleTypeMarkerAsFlexibleType), classicTypeSystemContext.lowerBound(flexibleTypeMarkerAsFlexibleType2)) && e0(classicTypeSystemContext, classicTypeSystemContext.upperBound(flexibleTypeMarkerAsFlexibleType), classicTypeSystemContext.upperBound(flexibleTypeMarkerAsFlexibleType2));
    }

    public static long g(int i, byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("in == null");
        }
        long j6 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            j6 = (j6 << 8) | ((long) (bArr[i3] & 255));
        }
        return j6;
    }

    public static void g0(int[] iArr, int i, int[] iArr2, int i3, int[] iArr3) {
        long j6 = (((long) iArr[i]) & 4294967295L) - (((long) iArr2[i3]) & 4294967295L);
        iArr3[0] = (int) j6;
        long j7 = ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i3 + 1]) & 4294967295L)) + (j6 >> 32);
        iArr3[1] = (int) j7;
        long j8 = ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i3 + 2]) & 4294967295L)) + (j7 >> 32);
        iArr3[2] = (int) j8;
        long j9 = ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i3 + 3]) & 4294967295L)) + (j8 >> 32);
        iArr3[3] = (int) j9;
        long j10 = ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i3 + 4]) & 4294967295L)) + (j9 >> 32);
        iArr3[4] = (int) j10;
        long j11 = ((((long) iArr[i + 5]) & 4294967295L) - (((long) iArr2[i3 + 5]) & 4294967295L)) + (j10 >> 32);
        iArr3[5] = (int) j11;
        long j12 = ((((long) iArr[i + 6]) & 4294967295L) - (((long) iArr2[i3 + 6]) & 4294967295L)) + (j11 >> 32);
        iArr3[6] = (int) j12;
        iArr3[7] = (int) (((((long) iArr[i + 7]) & 4294967295L) - (((long) iArr2[i3 + 7]) & 4294967295L)) + (j12 >> 32));
    }

    public static final String h(String str) {
        char cCharAt;
        h.f(str, "<this>");
        if (str.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt >= '{') {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        String strSubstring = str.substring(1);
        h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return upperCase + strSubstring;
    }

    public static void h0(int[] iArr, int[] iArr2) {
        long j6 = (((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j6;
        long j7 = ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j6 >> 32);
        iArr2[1] = (int) j7;
        long j8 = ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j7 >> 32);
        iArr2[2] = (int) j8;
        long j9 = ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j8 >> 32);
        iArr2[3] = (int) j9;
        long j10 = ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) + (j9 >> 32);
        iArr2[4] = (int) j10;
        long j11 = ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) + (j10 >> 32);
        iArr2[5] = (int) j11;
        long j12 = ((((long) iArr2[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) + (j11 >> 32);
        iArr2[6] = (int) j12;
        iArr2[7] = (int) (((((long) iArr2[7]) & 4294967295L) - (4294967295L & ((long) iArr[7]))) + (j12 >> 32));
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (V(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static BigInteger i0(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 8; i++) {
            int i3 = iArr[i];
            if (i3 != 0) {
                g5.c.o(bArr, i3, (7 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static byte[] j(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("in == null");
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static BigInteger j0(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 4; i++) {
            long j6 = jArr[i];
            if (j6 != 0) {
                g5.c.t(bArr, (3 - i) << 3, j6);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static byte[][] k(byte[][] bArr) {
        if (bArr != null) {
            for (byte[] bArr2 : bArr) {
                if (bArr2 != null) {
                }
            }
            byte[][] bArr3 = new byte[bArr.length][];
            for (int i = 0; i < bArr.length; i++) {
                byte[] bArr4 = new byte[bArr[i].length];
                bArr3[i] = bArr4;
                byte[] bArr5 = bArr[i];
                System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
            }
            return bArr3;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static byte[] k0(int i, long j6) {
        byte[] bArr = new byte[i];
        for (int i3 = i - 1; i3 >= 0; i3--) {
            bArr[i3] = (byte) j6;
            j6 >>>= 8;
        }
        return bArr;
    }

    public static final void l(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC0246d.e(th, th2);
            }
        }
    }

    public static final String l0(String str) {
        h.f(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        h.e(string, "builder.toString()");
        return string;
    }

    public static final d3.c m(d0 d0Var) {
        int iOrdinal = d0Var.ordinal();
        if (iOrdinal == 0) {
            return d3.c.INV;
        }
        if (iOrdinal == 1) {
            return d3.c.IN;
        }
        if (iOrdinal == 2) {
            return d3.c.OUT;
        }
        throw new x();
    }

    public static int m0(int i) {
        int i3 = i >> 7;
        int i4 = 0;
        while (i3 != 0) {
            i3 >>= 7;
            i4++;
        }
        return i4 + 1;
    }

    public static void n(int i, byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            throw new NullPointerException("src == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (bArr2.length + i > bArr.length) {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            bArr[i + i3] = bArr2[i3];
        }
    }

    public static final F n0(F f6, F abbreviatedType) {
        h.f(f6, "<this>");
        h.f(abbreviatedType, "abbreviatedType");
        return l.O(f6) ? f6 : new C0138a(f6, abbreviatedType);
    }

    public static final void o(ByteBuffer copyTo, ByteBuffer byteBuffer, int i) {
        h.f(copyTo, "$this$copyTo");
        int iRemaining = byteBuffer.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && byteBuffer.hasArray() && !byteBuffer.isReadOnly()) {
            int iPosition = byteBuffer.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, iRemaining);
            byteBuffer.position(iPosition + iRemaining);
        } else {
            ByteBuffer byteBufferDuplicate = copyTo.duplicate();
            byteBufferDuplicate.limit(iRemaining + i);
            byteBufferDuplicate.position(i);
            byteBuffer.put(byteBufferDuplicate);
        }
    }

    public static s o0(Function1 changeOptions) {
        h.f(changeOptions, "changeOptions");
        M2.x xVar = new M2.x();
        changeOptions.invoke(xVar);
        xVar.f1095a = true;
        return new s(xVar);
    }

    public static final void p(ByteBuffer byteBuffer, ByteBuffer destination, int i) {
        h.f(destination, "destination");
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            c0(destination, i, byteBuffer.remaining()).put(byteBuffer);
            return;
        }
        byte[] bArrArray = byteBuffer.array();
        h.e(bArrArray, "array()");
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining();
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrArray, iPosition, iRemaining).slice().order(ByteOrder.BIG_ENDIAN);
        h.e(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        G1.b.a(byteBufferOrder, destination, 0, iRemaining, i);
        byteBuffer.position(byteBuffer.limit());
    }

    public static final int p0(J1.b bVar, J1.b bVar2, int i) {
        int iMin = Math.min(bVar2.c - bVar2.b, i);
        int i3 = bVar.e;
        int i4 = bVar.c;
        int i5 = i3 - i4;
        if (i5 <= iMin) {
            int i6 = bVar.f751f;
            if ((i6 - i3) + i5 < iMin) {
                throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
            }
            if ((i4 + iMin) - i3 > 0) {
                bVar.e = i6;
            }
        }
        G1.b.a(bVar2.f750a, bVar.f750a, bVar2.b, iMin, i4);
        bVar2.c(iMin);
        bVar.a(iMin);
        return iMin;
    }

    public static g q(j0 table) {
        h.f(table, "table");
        if (table.b.size() == 0) {
            return g.b;
        }
        List list = table.b;
        h.e(list, "table.requirementList");
        return new g(list);
    }

    public static void q0(ByteOutput byteOutput, int i) {
        int i3 = i >> 7;
        int i4 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i5 = i;
        int i6 = i3;
        boolean z6 = true;
        while (z6) {
            z6 = (i6 == i4 && (i6 & 1) == ((i5 >> 6) & 1)) ? false : true;
            byteOutput.writeByte((byte) ((i5 & 127) | (z6 ? 128 : 0)));
            i5 = i6;
            i6 >>= 7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation r(Continuation continuation, Continuation continuation2, Function2 function2) {
        h.f(function2, "<this>");
        if (function2 instanceof U1.a) {
            return ((U1.a) function2).create(continuation, continuation2);
        }
        CoroutineContext context = continuation2.getContext();
        return context == S1.g.f1282a ? new T1.b(continuation2, continuation, function2) : new T1.c(continuation2, context, function2, continuation);
    }

    public static void r0(ByteOutput byteOutput, int i) {
        while (true) {
            int i3 = i;
            i >>>= 7;
            if (i == 0) {
                byteOutput.writeByte((byte) (i3 & 127));
                return;
            }
            byteOutput.writeByte((byte) ((i3 & 127) | 128));
        }
    }

    public static final C0712d s(k0 k0Var) {
        switch (k0Var == null ? -1 : t.b[k0Var.ordinal()]) {
            case 1:
                C0712d INTERNAL = AbstractC0713e.d;
                h.e(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                C0712d PRIVATE = AbstractC0713e.f4232a;
                h.e(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                C0712d PRIVATE_TO_THIS = AbstractC0713e.b;
                h.e(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                C0712d PROTECTED = AbstractC0713e.c;
                h.e(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                C0712d PUBLIC = AbstractC0713e.e;
                h.e(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                C0712d LOCAL = AbstractC0713e.f4233f;
                h.e(LOCAL, "LOCAL");
                return LOCAL;
            default:
                C0712d PRIVATE2 = AbstractC0713e.f4232a;
                h.e(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }

    public static String s0(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i = 0;
        int i3 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(string2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
                    String name2 = e.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(string2).length() + 9 + name2.length());
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i3] = string;
            i3++;
        }
        StringBuilder sb3 = new StringBuilder((length * 16) + str.length());
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i4, iIndexOf);
            sb3.append(objArr[i]);
            i++;
            i4 = iIndexOf + 2;
        }
        sb3.append((CharSequence) str, i4, str.length());
        if (i < length2) {
            sb3.append(" [");
            sb3.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb3.append(", ");
                sb3.append(objArr[i5]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static Object t(byte[] bArr, Class cls) throws ClassNotFoundException, IOException {
        J4.x xVar = new J4.x(cls, new ByteArrayInputStream(bArr));
        Object object = xVar.readObject();
        if (xVar.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        }
        if (cls.isInstance(object)) {
            return object;
        }
        throw new IOException("unexpected class found in ObjectInputStream");
    }

    public static boolean u(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z6;
        int i = 7;
        while (true) {
            z6 = true;
            if (i < 0) {
                break;
            }
            int i3 = iArr[8 + i] ^ Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE ^ iArr2[i];
            if (i3 < i4) {
                z6 = false;
                break;
            }
            if (i3 > i4) {
                break;
            }
            i--;
        }
        if (z6) {
            g0(iArr, 8, iArr2, 0, iArr3);
            return z6;
        }
        g0(iArr2, 0, iArr, 8, iArr3);
        return z6;
    }

    public static void v(int[] iArr, int[] iArr2, int i) {
        int i3 = 0;
        long j6 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i > 0) {
            if (i3 < Math.min(30, i)) {
                j6 |= (((long) iArr[i4]) & 4294967295L) << i3;
                i3 += 32;
                i4++;
            }
            iArr2[i5] = ((int) j6) & 1073741823;
            j6 >>>= 30;
            i3 -= 30;
            i -= 30;
            i5++;
        }
    }

    public static final V1.a w(Enum[] entries) {
        h.f(entries, "entries");
        V1.a aVar = new V1.a(new C0022d(entries, 8));
        int length = aVar.b().length;
        return aVar;
    }

    public static boolean x(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean y(long[] jArr, long[] jArr2) {
        for (int i = 3; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int z(int i, int i3, int[] iArr) {
        int i4 = i3 ^ iArr[0];
        for (int i5 = 1; i5 < i; i5++) {
            i4 |= iArr[i5];
        }
        return (((i4 >>> 1) | (i4 & 1)) - 1) >> 31;
    }
}
