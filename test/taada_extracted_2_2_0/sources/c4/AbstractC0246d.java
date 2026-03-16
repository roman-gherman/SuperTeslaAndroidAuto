package c4;

import A2.C0022d;
import C0.x;
import a.AbstractC0132a;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C;
import a3.C0148k;
import a3.C0158v;
import a3.D;
import a3.F;
import a3.K;
import a3.M;
import a3.b0;
import a3.c0;
import a3.d0;
import a4.C0163a;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import f2.AbstractC0441a;
import h2.n0;
import io.ktor.utils.io.Z;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k0.AbstractC0572b;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.l;
import n2.EnumC0711c;
import org.bouncycastle.math.ec.ECConstants;
import w3.C0886d;
import w3.W;

/* JADX INFO: renamed from: c4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0246d implements ECConstants {
    public static Context b;
    public static Boolean c;
    public static Boolean d;
    public static Boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f1788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f1789g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1790a = 19;

    public static String A(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iT0);
        return string;
    }

    public static Object A0(String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method method = Class.forName(str).getMethod(str2, clsArr);
            if (method == null) {
                return null;
            }
            return method.invoke(null, objArr);
        } catch (ClassNotFoundException e6) {
            e = e6;
            Log.e("TenjinReflection", "Error running static method " + str2 + " on " + str + " : " + e.getMessage());
            return null;
        } catch (IllegalAccessException e7) {
            e = e7;
            Log.e("TenjinReflection", "Error running static method " + str2 + " on " + str + " : " + e.getMessage());
            return null;
        } catch (NoSuchMethodException e8) {
            e = e8;
            Log.e("TenjinReflection", "Error running static method " + str2 + " on " + str + " : " + e.getMessage());
            return null;
        } catch (InvocationTargetException e9) {
            e = e9;
            Log.e("TenjinReflection", "Error running static method " + str2 + " on " + str + " : " + e.getMessage());
            return null;
        } catch (Exception e10) {
            Log.e("TenjinReflection", "Error running static method " + str2 + " on " + str + " : " + e10.getLocalizedMessage());
            return null;
        }
    }

    public static ArrayList B(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iT0);
        return arrayListCreateStringArrayList;
    }

    public static void B0(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + t0(parcel, i));
    }

    public static final n0 C(KClass kClass, List arguments, boolean z6, List annotations) {
        ClassifierDescriptor descriptor;
        M m6;
        K k6;
        kotlin.jvm.internal.h.f(kClass, "<this>");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        kotlin.jvm.internal.h.f(annotations, "annotations");
        KClassifierImpl kClassifierImpl = kClass instanceof KClassifierImpl ? (KClassifierImpl) kClass : null;
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            throw new N1.d("Cannot create type for an unsupported classifier: " + kClass + " (" + kClass.getClass() + ')', 2);
        }
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        kotlin.jvm.internal.h.e(typeConstructor, "descriptor.typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        kotlin.jvm.internal.h.e(parameters, "typeConstructor.parameters");
        if (parameters.size() != arguments.size()) {
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
        }
        if (annotations.isEmpty()) {
            M.b.getClass();
            m6 = M.c;
        } else {
            M.b.getClass();
            m6 = M.c;
        }
        List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
        kotlin.jvm.internal.h.e(parameters2, "typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(o.D(arguments));
        int i = 0;
        for (Object obj : arguments) {
            int i3 = i + 1;
            if (i < 0) {
                n.C();
                throw null;
            }
            kotlin.reflect.d dVar = (kotlin.reflect.d) obj;
            n0 n0Var = dVar.b;
            AbstractC0162z abstractC0162z = n0Var != null ? n0Var.f3423a : null;
            kotlin.reflect.e eVar = dVar.f3823a;
            int i4 = eVar == null ? -1 : AbstractC0441a.f3192a[eVar.ordinal()];
            if (i4 == -1) {
                TypeParameterDescriptor typeParameterDescriptor = parameters2.get(i);
                kotlin.jvm.internal.h.e(typeParameterDescriptor, "parameters[index]");
                k6 = new K(typeParameterDescriptor);
            } else if (i4 == 1) {
                d0 d0Var = d0.INVARIANT;
                kotlin.jvm.internal.h.c(abstractC0162z);
                k6 = new K(abstractC0162z, d0Var);
            } else if (i4 == 2) {
                d0 d0Var2 = d0.IN_VARIANCE;
                kotlin.jvm.internal.h.c(abstractC0162z);
                k6 = new K(abstractC0162z, d0Var2);
            } else {
                if (i4 != 3) {
                    throw new x();
                }
                d0 d0Var3 = d0.OUT_VARIANCE;
                kotlin.jvm.internal.h.c(abstractC0162z);
                k6 = new K(abstractC0162z, d0Var3);
            }
            arrayList.add(k6);
            i = i3;
        }
        return new n0(C.c(m6, arrayList, typeConstructor, z6), null);
    }

    public static Object[] D(Parcel parcel, int i, Parcelable.Creator creator) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iT0);
        return objArrCreateTypedArray;
    }

    public static void D0(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[0]) & 4294967295L;
        int i = 10;
        int i3 = 0;
        int i4 = 4;
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
                long j26 = ((long) iArr[4]) & 4294967295L;
                long j27 = (((long) iArr2[7]) & 4294967295L) + (j25 >>> 32);
                long j28 = j25 & 4294967295L;
                long j29 = (((long) iArr2[8]) & 4294967295L) + (j27 >>> 32);
                long j30 = (j26 * j6) + (jE2 & 4294967295L);
                int i11 = (int) j30;
                iArr2[4] = i10 | (i11 << 1);
                int i12 = i11 >>> 31;
                long jE4 = androidx.constraintlayout.core.motion.a.e(j26, j11, j30 >>> 32, jE3 & 4294967295L);
                long jE5 = androidx.constraintlayout.core.motion.a.e(j26, j14, jE4 >>> 32, j28);
                long jE6 = androidx.constraintlayout.core.motion.a.e(j26, j19, jE5 >>> 32, j27 & 4294967295L);
                long j31 = j29 + (jE6 >>> 32);
                int i13 = (int) jE4;
                iArr2[5] = (i13 << 1) | i12;
                int i14 = (int) jE5;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                int i15 = i14 >>> 31;
                int i16 = (int) jE6;
                iArr2[7] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j31;
                iArr2[8] = i17 | (i18 << 1);
                iArr2[9] = ((iArr2[9] + ((int) (j31 >>> 32))) << 1) | (i18 >>> 31);
                return;
            }
            i4 = i5;
        }
    }

    public static ArrayList E(Parcel parcel, int i, Parcelable.Creator creator) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iT0);
        return arrayListCreateTypedArrayList;
    }

    public static void E0(int[] iArr, int[] iArr2) {
        long j6 = (((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L);
        iArr2[0] = (int) j6;
        long j7 = ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j6 >> 32);
        iArr2[1] = (int) j7;
        long j8 = ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j7 >> 32);
        iArr2[2] = (int) j8;
        long j9 = ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j8 >> 32);
        iArr2[3] = (int) j9;
        iArr2[4] = (int) (((((long) iArr2[4]) & 4294967295L) - (4294967295L & ((long) iArr[4]))) + (j9 >> 32));
    }

    public static final String F(CharsetDecoder charsetDecoder, I1.d dVar) throws Throwable {
        CoderResult coderResultDecode;
        J1.b bVarE;
        boolean z6 = true;
        StringBuilder sb = new StringBuilder((int) Math.min(Integer.MAX_VALUE, dVar.f()));
        CharBuffer charBuffer = H1.a.f737a;
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        J1.b bVarD = J1.c.d(dVar, 1);
        int iRemaining = 0;
        if (bVarD != null) {
            int i = 1;
            int i3 = 1;
            int iRemaining2 = 0;
            while (true) {
                try {
                    int i4 = bVarD.c;
                    int i5 = bVarD.b;
                    int i6 = i4 - i5;
                    if (i6 >= i) {
                        int i7 = Integer.MAX_VALUE - iRemaining2;
                        if (i7 == 0) {
                            i = 0;
                        } else {
                            try {
                                ByteBuffer byteBuffer = bVarD.f750a;
                                ByteBuffer byteBuffer2 = G1.b.f421a;
                                ByteBuffer byteBufferC0 = C5.f.c0(byteBuffer, i5, i6);
                                charBufferAllocate.clear();
                                if (i7 < 8192) {
                                    charBufferAllocate.limit(i7);
                                }
                                CoderResult coderResultDecode2 = charsetDecoder.decode(byteBufferC0, charBufferAllocate, false);
                                charBufferAllocate.flip();
                                iRemaining2 += charBufferAllocate.remaining();
                                sb.append((CharSequence) charBufferAllocate);
                                if (coderResultDecode2.isMalformed() || coderResultDecode2.isUnmappable()) {
                                    H1.a.d(coderResultDecode2);
                                }
                                i3 = (coderResultDecode2.isUnderflow() && byteBufferC0.hasRemaining()) ? i3 + 1 : 1;
                                if (byteBufferC0.limit() != i6) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed");
                                }
                                bVarD.c(byteBufferC0.position());
                                i = i3;
                            } finally {
                            }
                        }
                        i6 = bVarD.c - bVarD.b;
                    }
                    if (i6 == 0) {
                        try {
                            bVarE = J1.c.e(dVar, bVarD);
                        } catch (Throwable th) {
                            th = th;
                            z6 = false;
                            if (z6) {
                                J1.c.a(dVar, bVarD);
                            }
                            throw th;
                        }
                    } else if (i6 < i || bVarD.f751f - bVarD.e < 8) {
                        J1.c.a(dVar, bVarD);
                        bVarE = J1.c.d(dVar, i);
                    } else {
                        bVarE = bVarD;
                    }
                    if (bVarE == null) {
                        break;
                    }
                    if (i <= 0) {
                        iRemaining = 1;
                        bVarD = bVarE;
                        break;
                    }
                    bVarD = bVarE;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (iRemaining != 0) {
                J1.c.a(dVar, bVarD);
            }
            iRemaining = iRemaining2;
        }
        do {
            charBufferAllocate.clear();
            int i8 = Integer.MAX_VALUE - iRemaining;
            if (i8 == 0) {
                break;
            }
            if (i8 < 8192) {
                charBufferAllocate.limit(i8);
            }
            coderResultDecode = charsetDecoder.decode(H1.a.b, charBufferAllocate, true);
            charBufferAllocate.flip();
            iRemaining += charBufferAllocate.remaining();
            sb.append((CharSequence) charBufferAllocate);
            if (coderResultDecode.isUnmappable() || coderResultDecode.isMalformed()) {
                H1.a.d(coderResultDecode);
            }
        } while (coderResultDecode.isOverflow());
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static void F0(f5.e[] eVarArr, int i, int i3) {
        f5.e eVar = eVarArr[i];
        eVarArr[i] = eVarArr[i3];
        eVarArr[i3] = eVar;
    }

    public static final I1.d H(CharsetEncoder charsetEncoder, String input, int i, int i3) {
        kotlin.jvm.internal.h.f(input, "input");
        I1.c cVar = new I1.c();
        try {
            I(charsetEncoder, cVar, input, i, i3);
            return cVar.c();
        } catch (Throwable th) {
            cVar.close();
            throw th;
        }
    }

    public static BigInteger H0(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i3 = iArr[i];
            if (i3 != 0) {
                g5.c.o(bArr, i3, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static final void I(CharsetEncoder charsetEncoder, I1.c cVar, String input, int i, int i3) {
        kotlin.jvm.internal.h.f(input, "input");
        if (i >= i3) {
            return;
        }
        J1.b bVarF = J1.c.f(cVar, 1, null);
        while (true) {
            try {
                int iB = H1.a.b(charsetEncoder, input, i, i3, bVarF);
                if (iB < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                i += iB;
                int i4 = i >= i3 ? 0 : iB == 0 ? 8 : 1;
                if (i4 > 0) {
                    bVarF = J1.c.f(cVar, i4, bVarF);
                } else {
                    cVar.a();
                    J1.b bVarF2 = J1.c.f(cVar, 1, null);
                    int i5 = 1;
                    while (true) {
                        try {
                            i5 = H1.a.a(charsetEncoder, bVarF2) ? 0 : i5 + 1;
                            if (i5 <= 0) {
                                return;
                            } else {
                                bVarF2 = J1.c.f(cVar, 1, bVarF2);
                            }
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static final M I0(Annotations annotations) {
        kotlin.jvm.internal.h.f(annotations, "<this>");
        if (annotations.isEmpty()) {
            M.b.getClass();
            return M.c;
        }
        B.h hVar = M.b;
        List listP = Z.p(new C0148k(annotations));
        hVar.getClass();
        return B.h.b(listP);
    }

    public static void J(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new x(B2.b.c(i, "Overread allowed size end="), parcel);
        }
    }

    public static String J0(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c6 = charArray[i];
                    if (c6 >= 'A' && c6 <= 'Z') {
                        charArray[i] = (char) (c6 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static final void K(AbstractC0162z abstractC0162z, F f6, LinkedHashSet linkedHashSet, Set set) {
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            if (!kotlin.jvm.internal.h.a(abstractC0162z.c(), f6.c())) {
                linkedHashSet.add(declarationDescriptor);
                return;
            }
            for (AbstractC0162z upperBound : ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds()) {
                kotlin.jvm.internal.h.e(upperBound, "upperBound");
                K(upperBound, f6, linkedHashSet, set);
            }
            return;
        }
        ClassifierDescriptor declarationDescriptor2 = abstractC0162z.c().getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor2 : null;
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        int i = 0;
        for (TypeProjection typeProjection : abstractC0162z.a()) {
            int i3 = i + 1;
            TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (TypeParameterDescriptor) m.S(i, declaredTypeParameters) : null;
            if ((typeParameterDescriptor == null || set == null || !set.contains(typeParameterDescriptor)) && !typeProjection.isStarProjection() && !m.L(typeProjection.getType().c().getDeclarationDescriptor(), linkedHashSet) && !kotlin.jvm.internal.h.a(typeProjection.getType().c(), f6.c())) {
                AbstractC0162z type = typeProjection.getType();
                kotlin.jvm.internal.h.e(type, "argument.type");
                K(type, f6, linkedHashSet, set);
            }
            i = i3;
        }
    }

    public static String K0(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c6 = charArray[i];
                    if (c6 >= 'a' && c6 <= 'z') {
                        charArray[i] = (char) (c6 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static final HashSet L(Iterable iterable) {
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set<L2.f> classifierNames = ((MemberScope) it.next()).getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            s.F(classifierNames, hashSet);
        }
        return hashSet;
    }

    public static short[][] L0(short[][] sArr) {
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, sArr[0].length, sArr.length);
        for (int i = 0; i < sArr.length; i++) {
            for (int i3 = 0; i3 < sArr[0].length; i3++) {
                sArr2[i3][i] = sArr[i][i3];
            }
        }
        return sArr2;
    }

    public static int[] M(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[5];
        for (int i = 0; i < 5; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static int M0(Parcel parcel) {
        int i = parcel.readInt();
        int iT0 = t0(parcel, i);
        char c6 = (char) i;
        int iDataPosition = parcel.dataPosition();
        if (c6 != 20293) {
            throw new x("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i3 = iT0 + iDataPosition;
        if (i3 < iDataPosition || i3 > parcel.dataSize()) {
            throw new x(androidx.constraintlayout.core.motion.a.n("Size read is invalid start=", iDataPosition, " end=", i3), parcel);
        }
        return i3;
    }

    public static w3.Z N(byte[] bArr, byte[] bArr2) {
        C0886d c0886d = new C0886d(2);
        c0886d.a(new W(bArr));
        c0886d.a(new W(bArr2));
        w3.Z z6 = new w3.Z(c0886d, false);
        z6.d = -1;
        return z6;
    }

    public static a3.W N0(a3.W w5) {
        if (!(w5 instanceof C0158v)) {
            return new O2.c(w5, 0);
        }
        C0158v c0158v = (C0158v) w5;
        TypeProjection[] typeProjectionArr = c0158v.c;
        kotlin.jvm.internal.h.f(typeProjectionArr, "<this>");
        TypeParameterDescriptor[] other = c0158v.b;
        kotlin.jvm.internal.h.f(other, "other");
        int iMin = Math.min(typeProjectionArr.length, other.length);
        ArrayList<N1.e> arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(new N1.e(typeProjectionArr[i], other[i]));
        }
        ArrayList arrayList2 = new ArrayList(o.D(arrayList));
        for (N1.e eVar : arrayList) {
            arrayList2.add(v((TypeProjection) eVar.f1121a, (TypeParameterDescriptor) eVar.b));
        }
        return new C0158v(other, (TypeProjection[]) arrayList2.toArray(new TypeProjection[0]), true);
    }

    public static final k2.i O(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        k2.i builtIns = abstractC0162z.c().getBuiltIns();
        kotlin.jvm.internal.h.e(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static final void O0(J1.b bVar, ByteBuffer byteBuffer) throws A.a {
        kotlin.jvm.internal.h.f(bVar, "<this>");
        int iRemaining = byteBuffer.remaining();
        int i = bVar.c;
        int i3 = bVar.e - i;
        if (i3 >= iRemaining) {
            C5.f.p(byteBuffer, bVar.f750a, i);
            bVar.a(iRemaining);
            return;
        }
        String message = "Not enough free space to write buffer content of " + iRemaining + " bytes, available " + i3 + " bytes.";
        kotlin.jvm.internal.h.f(message, "message");
        throw new A.a(message);
    }

    public static HttpURLConnection P(URL url, String str, Map map, HashMap map2) throws InterruptedException, IOException {
        HttpURLConnection httpURLConnection;
        int i = 0;
        while (true) {
            if (i > 1) {
                Thread.sleep(Math.round(Math.random() * Math.min(3600.0d, Math.pow(i, 2.0d))) * 1000);
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            if (map2 != null && map2.size() > 0) {
                for (Map.Entry entry : map2.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (str.equals("POST")) {
                String strQ = q(map, false);
                byte[] bytes = strQ.getBytes();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(0);
                httpURLConnection.setReadTimeout(0);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("charset", "utf-8");
                if (bytes.length > 0) {
                    httpURLConnection.setRequestProperty("Content-Length", Integer.toString(strQ.getBytes().length));
                }
                httpURLConnection.setUseCaches(false);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(strQ.getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
            } else {
                httpURLConnection.setRequestMethod("GET");
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 500 || responseCode > 599) {
                break;
            }
            httpURLConnection.disconnect();
            i++;
            map.put("retry_attempts", Integer.toString(i));
        }
        return httpURLConnection;
    }

    public static void P0(Parcel parcel, int i, int i3) {
        int iT0 = t0(parcel, i);
        if (iT0 == i3) {
            return;
        }
        String hexString = Integer.toHexString(iT0);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(iT0);
        sb.append(" (0x");
        throw new x(B2.b.h(sb, hexString, ")"), parcel);
    }

    public static float Q(int i, String[] strArr) {
        float f6 = Float.parseFloat(strArr[i]);
        if (f6 >= 0.0f && f6 <= 1.0f) {
            return f6;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f6);
    }

    public static final AbstractC0162z R(TypeParameterDescriptor typeParameterDescriptor) {
        Object obj;
        kotlin.jvm.internal.h.f(typeParameterDescriptor, "<this>");
        List<AbstractC0162z> upperBounds = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.h.e(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<AbstractC0162z> upperBounds2 = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.h.e(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ClassifierDescriptor declarationDescriptor = ((AbstractC0162z) next).c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null && classDescriptor.getKind() != EnumC0711c.b && classDescriptor.getKind() != EnumC0711c.e) {
                obj = next;
                break;
            }
        }
        AbstractC0162z abstractC0162z = (AbstractC0162z) obj;
        if (abstractC0162z != null) {
            return abstractC0162z;
        }
        List<AbstractC0162z> upperBounds3 = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.h.e(upperBounds3, "upperBounds");
        Object objP = m.P(upperBounds3);
        kotlin.jvm.internal.h.e(objP, "upperBounds.first()");
        return (AbstractC0162z) objP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String S(java.util.Map r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0246d.S(java.util.Map):java.lang.String");
    }

    public static final Object T(NotNullLazyValue notNullLazyValue, KProperty p5) {
        kotlin.jvm.internal.h.f(notNullLazyValue, "<this>");
        kotlin.jvm.internal.h.f(p5, "p");
        return notNullLazyValue.invoke();
    }

    public static boolean U(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
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

    public static final boolean V(TypeParameterDescriptor typeParameter, TypeConstructor typeConstructor, Set set) {
        kotlin.jvm.internal.h.f(typeParameter, "typeParameter");
        List<AbstractC0162z> upperBounds = typeParameter.getUpperBounds();
        kotlin.jvm.internal.h.e(upperBounds, "typeParameter.upperBounds");
        if (upperBounds.isEmpty()) {
            return false;
        }
        for (AbstractC0162z upperBound : upperBounds) {
            kotlin.jvm.internal.h.e(upperBound, "upperBound");
            if (p(upperBound, typeParameter.getDefaultType().c(), set) && (typeConstructor == null || kotlin.jvm.internal.h.a(upperBound.c(), typeConstructor))) {
                return true;
            }
        }
        return false;
    }

    public static String X(Check check, FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
        if (check.check(functionDescriptor)) {
            return null;
        }
        return check.getDescription();
    }

    public static final boolean Y(PropertyDescriptor propertyDescriptor) {
        kotlin.jvm.internal.h.f(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }

    public static boolean Z(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static int a(int[] iArr, int[] iArr2, int[] iArr3) {
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
        return (int) (j10 >>> 32);
    }

    public static boolean b0(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (d == null) {
            d = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        d.booleanValue();
        if (e == null) {
            e = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return e.booleanValue() && Build.VERSION.SDK_INT >= 30;
    }

    public static short[][] c(short[][] sArr, short[][] sArr2) {
        if (sArr.length == sArr2.length) {
            short[] sArr3 = sArr[0];
            if (sArr3.length == sArr2[0].length) {
                short[][] sArr4 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, sArr.length, sArr3.length);
                for (int i = 0; i < sArr.length; i++) {
                    for (int i3 = 0; i3 < sArr[0].length; i3++) {
                        short[] sArr5 = sArr4[i];
                        short s3 = sArr[i][i3];
                        short s6 = sArr2[i][i3];
                        byte[][] bArr = E4.a.f320a;
                        sArr5[i3] = (short) (s3 ^ s6);
                    }
                }
                return sArr4;
            }
        }
        throw new RuntimeException("Addition is not possible!");
    }

    public static short[][] d(short[][] sArr) {
        if (sArr.length == sArr[0].length) {
            return c(sArr, L0(sArr));
        }
        throw new RuntimeException("Addition is not possible!");
    }

    public static final j3.j d0(ArrayList arrayList) {
        j3.j jVar = new j3.j();
        for (Object obj : arrayList) {
            MemberScope memberScope = (MemberScope) obj;
            if (memberScope != null && memberScope != U2.m.f1338a) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    public static void e(Throwable th, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.h.f(th, "<this>");
        kotlin.jvm.internal.h.f(exception, "exception");
        if (th != exception) {
            W1.c.f1390a.a(th, exception);
        }
    }

    public static final c0 e0(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        c0 c0VarH = b0.h(abstractC0162z, true);
        kotlin.jvm.internal.h.e(c0VarH, "makeNullable(this)");
        return c0VarH;
    }

    public static final K f(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        return new K(abstractC0162z);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00cb A[EDGE_INSN: B:19:0x00cb->B:61:0x0190 BREAK  A[LOOP:1: B:55:0x0169->B:153:?]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f0(a3.AbstractC0162z r20, E2.r r21, kotlin.jvm.functions.Function3 r22) {
        /*
            Method dump skipped, instruction units count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0246d.f0(a3.z, E2.r, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static void g0(int[] iArr, int[] iArr2, int[] iArr3) {
        long j6 = ((long) iArr2[0]) & 4294967295L;
        long j7 = ((long) iArr2[1]) & 4294967295L;
        long j8 = ((long) iArr2[2]) & 4294967295L;
        long j9 = ((long) iArr2[3]) & 4294967295L;
        long j10 = ((long) iArr2[4]) & 4294967295L;
        long j11 = ((long) iArr[0]) & 4294967295L;
        int i = 1;
        long j12 = j11 * j6;
        iArr3[0] = (int) j12;
        char c6 = ' ';
        long j13 = (j12 >>> 32) + (j11 * j7);
        iArr3[1] = (int) j13;
        long j14 = (j13 >>> 32) + (j11 * j8);
        iArr3[2] = (int) j14;
        long j15 = (j14 >>> 32) + (j11 * j9);
        iArr3[3] = (int) j15;
        long j16 = (j11 * j10) + (j15 >>> 32);
        iArr3[4] = (int) j16;
        int i3 = 5;
        iArr3[5] = (int) (j16 >>> 32);
        while (true) {
            int i4 = i;
            if (i4 >= i3) {
                return;
            }
            long j17 = ((long) iArr[i4]) & 4294967295L;
            long j18 = (j17 * j6) + (((long) iArr3[i4]) & 4294967295L);
            iArr3[i4] = (int) j18;
            i = i4 + 1;
            char c7 = c6;
            long j19 = (j17 * j7) + (((long) iArr3[i]) & 4294967295L) + (j18 >>> c6);
            iArr3[i] = (int) j19;
            int i5 = i4 + 2;
            long j20 = j10;
            long j21 = (j17 * j8) + (((long) iArr3[i5]) & 4294967295L) + (j19 >>> c7);
            iArr3[i5] = (int) j21;
            long j22 = j21 >>> c7;
            int i6 = i4 + 3;
            long j23 = (j17 * j9) + (((long) iArr3[i6]) & 4294967295L) + j22;
            iArr3[i6] = (int) j23;
            long j24 = j23 >>> c7;
            int i7 = i4 + 4;
            long j25 = (j17 * j20) + (((long) iArr3[i7]) & 4294967295L) + j24;
            iArr3[i7] = (int) j25;
            iArr3[i4 + 5] = (int) (j25 >>> c7);
            c6 = c7;
            j10 = j20;
            i3 = 5;
        }
    }

    public static long h(long j6, long j7) {
        long j8 = j6 + j7;
        AbstractC0132a.m(((j6 ^ j7) < 0) | ((j6 ^ j8) >= 0), "checkedAdd", j6, j7);
        return j8;
    }

    public static long i(long j6, long j7) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j7) + Long.numberOfLeadingZeros(j7) + Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j6);
        if (iNumberOfLeadingZeros > 65) {
            return j6 * j7;
        }
        AbstractC0132a.m(iNumberOfLeadingZeros >= 64, "checkedMultiply", j6, j7);
        AbstractC0132a.m((j6 >= 0) | (j7 != Long.MIN_VALUE), "checkedMultiply", j6, j7);
        long j8 = j6 * j7;
        AbstractC0132a.m(j6 == 0 || j8 / j6 == j7, "checkedMultiply", j6, j7);
        return j8;
    }

    public static short[][] i0(short[][] sArr, short[][] sArr2) {
        if (sArr[0].length != sArr2.length) {
            throw new RuntimeException("Multiplication is not possible!");
        }
        short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, sArr.length, sArr2[0].length);
        for (int i = 0; i < sArr.length; i++) {
            for (int i3 = 0; i3 < sArr2.length; i3++) {
                for (int i4 = 0; i4 < sArr2[0].length; i4++) {
                    short s3 = (short) (E4.a.f320a[sArr[i][i3]][sArr2[i3][i4]] & 255);
                    short[] sArr4 = sArr3[i];
                    sArr4[i4] = (short) (s3 ^ sArr4[i4]);
                }
            }
        }
        return sArr3;
    }

    public static long j(long j6, long j7) {
        long j8 = j6 - j7;
        AbstractC0132a.m(((j6 ^ j7) >= 0) | ((j6 ^ j8) >= 0), "checkedSubtract", j6, j7);
        return j8;
    }

    public static short[][][] j0(short[][] sArr, short[][][] sArr2, short[][][] sArr3) {
        short[][] sArr4 = sArr2[0];
        int length = sArr4.length;
        short[][] sArr5 = sArr3[0];
        if (length == sArr5.length) {
            int length2 = sArr4[0].length;
            short[] sArr6 = sArr5[0];
            if (length2 == sArr6.length && sArr2.length == sArr[0].length && sArr3.length == sArr.length) {
                short[][][] sArr7 = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, sArr3.length, sArr5.length, sArr6.length);
                for (int i = 0; i < sArr2[0].length; i++) {
                    for (int i3 = 0; i3 < sArr2[0][0].length; i3++) {
                        for (int i4 = 0; i4 < sArr.length; i4++) {
                            for (int i5 = 0; i5 < sArr[0].length; i5++) {
                                short s3 = (short) (E4.a.f320a[sArr[i4][i5]][sArr2[i5][i][i3]] & 255);
                                short[] sArr8 = sArr7[i4][i];
                                sArr8[i3] = (short) (s3 ^ sArr8[i3]);
                            }
                            short[] sArr9 = sArr7[i4][i];
                            short s6 = sArr3[i4][i][i3];
                            short s7 = sArr9[i3];
                            byte[][] bArr = E4.a.f320a;
                            sArr9[i3] = (short) (s6 ^ s7);
                        }
                    }
                }
                return sArr7;
            }
        }
        throw new RuntimeException("Multiplication not possible!");
    }

    public static final KotlinTypeMarker k(KotlinTypeMarker kotlinTypeMarker, HashSet hashSet) {
        KotlinTypeMarker kotlinTypeMarkerK;
        b3.k kVar = b3.k.f1707a;
        TypeConstructorMarker typeConstructorMarkerTypeConstructor = kVar.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructorMarkerTypeConstructor)) {
            return null;
        }
        TypeParameterDescriptor typeParameterDescriptorB = b3.e.B(typeConstructorMarkerTypeConstructor);
        if (typeParameterDescriptorB != null) {
            KotlinTypeMarker kotlinTypeMarkerY = b3.e.y(typeParameterDescriptorB);
            KotlinTypeMarker kotlinTypeMarkerK2 = k(kotlinTypeMarkerY, hashSet);
            if (kotlinTypeMarkerK2 != null) {
                return ((kotlinTypeMarkerK2 instanceof SimpleTypeMarker) && b3.e.U((SimpleTypeMarker) kotlinTypeMarkerK2) && b3.e.T(kotlinTypeMarker) && (b3.e.O(kVar.typeConstructor(kotlinTypeMarkerY)) || ((kotlinTypeMarkerY instanceof SimpleTypeMarker) && b3.e.U((SimpleTypeMarker) kotlinTypeMarkerY)))) ? kVar.makeNullable(kotlinTypeMarkerY) : (b3.e.T(kotlinTypeMarkerK2) || !kVar.isMarkedNullable(kotlinTypeMarker)) ? kotlinTypeMarkerK2 : kVar.makeNullable(kotlinTypeMarkerK2);
            }
            return null;
        }
        if (!b3.e.O(typeConstructorMarkerTypeConstructor)) {
            return kotlinTypeMarker;
        }
        F fC = b3.e.C(kotlinTypeMarker);
        if (fC == null || (kotlinTypeMarkerK = k(fC, hashSet)) == null) {
            return null;
        }
        return !b3.e.T(kotlinTypeMarker) ? kotlinTypeMarkerK : b3.e.T(kotlinTypeMarkerK) ? kotlinTypeMarker : ((kotlinTypeMarkerK instanceof SimpleTypeMarker) && b3.e.U((SimpleTypeMarker) kotlinTypeMarkerK)) ? kotlinTypeMarker : kVar.makeNullable(kotlinTypeMarkerK);
    }

    public static byte[] k0(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr, 0, 4096);
            if (i < 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String l(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration r4) {
        /*
            java.lang.String r0 = "klass"
            kotlin.jvm.internal.h.f(r3, r0)
            java.lang.String r0 = "typeMappingConfiguration"
            kotlin.jvm.internal.h.f(r4, r0)
            java.lang.String r0 = r4.getPredefinedFullInternalNameForClass(r3)
            if (r0 == 0) goto L11
            return r0
        L11:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r3.getContainingDeclaration()
            java.lang.String r1 = "klass.containingDeclaration"
            kotlin.jvm.internal.h.e(r0, r1)
            L2.f r1 = r3.getName()
            if (r1 == 0) goto L27
            L2.f r2 = L2.h.f964a
            boolean r2 = r1.b
            if (r2 != 0) goto L27
            goto L29
        L27:
            L2.f r1 = L2.h.c
        L29:
            java.lang.String r1 = r1.c()
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            if (r2 == 0) goto L5d
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r0
            L2.c r3 = r0.getFqName()
            boolean r4 = r3.d()
            if (r4 == 0) goto L3e
            return r1
        L3e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r3 = r3.b()
            r0 = 46
            r2 = 47
            java.lang.String r3 = kotlin.text.r.A(r3, r0, r2)
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            return r3
        L5d:
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 == 0) goto L65
            r2 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            goto L66
        L65:
            r2 = 0
        L66:
            if (r2 == 0) goto L87
            java.lang.String r3 = r4.getPredefinedInternalNameForClass(r2)
            if (r3 != 0) goto L72
            java.lang.String r3 = l(r2, r4)
        L72:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r3 = 36
            r4.append(r3)
            r4.append(r1)
            java.lang.String r3 = r4.toString()
            return r3
        L87:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected container: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = " for "
            r1.append(r0)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0246d.l(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration):java.lang.String");
    }

    public static boolean l0(Parcel parcel, int i) {
        P0(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static final Collection m(Collection collection, Collection collection2) {
        kotlin.jvm.internal.h.f(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static byte[] m0(I1.d dVar) {
        long jF = dVar.f();
        if (jF > 2147483647L) {
            throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
        }
        int i = (int) jF;
        kotlin.jvm.internal.h.f(dVar, "<this>");
        if (i == 0) {
            return J1.c.f830a;
        }
        byte[] bArr = new byte[i];
        boolean z6 = true;
        J1.b bVarD = J1.c.d(dVar, 1);
        if (bVarD != null) {
            int i3 = 0;
            while (true) {
                try {
                    int iMin = Math.min(i, bVarD.c - bVarD.b);
                    AbstractC0132a.W(bVarD, bArr, i3, iMin);
                    i -= iMin;
                    i3 += iMin;
                    if (i <= 0) {
                        J1.c.a(dVar, bVarD);
                        break;
                    }
                    try {
                        bVarD = J1.c.e(dVar, bVarD);
                        if (bVarD == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z6 = false;
                        if (z6) {
                            J1.c.a(dVar, bVarD);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        if (i <= 0) {
            return bArr;
        }
        throw new EOFException(B2.b.d(i, "Premature end of stream: expected ", " bytes"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(java.lang.String r6, java.util.Map r7, java.util.HashMap r8) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r6 = "POST"
            java.net.HttpURLConnection r6 = P(r2, r6, r7, r8)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            int r8 = r6.getResponseCode()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r2 = 200(0xc8, float:2.8E-43)
            if (r2 > r8) goto L23
            r3 = 299(0x12b, float:4.19E-43)
            if (r8 > r3) goto L23
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            goto L27
        L1e:
            r7 = move-exception
            goto L88
        L21:
            r7 = move-exception
            goto L77
        L23:
            java.io.InputStream r1 = r6.getErrorStream()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
        L27:
            if (r1 != 0) goto L37
            if (r1 == 0) goto L33
            r1.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r7 = move-exception
            r7.printStackTrace()
        L33:
            r6.disconnect()
            return r0
        L37:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
        L41:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            if (r4 == 0) goto L55
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r5.<init>()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r5.append(r4)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            java.lang.String r4 = "\n"
            r5.append(r4)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            goto L41
        L55:
            r3.close()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21 java.io.IOException -> L59
            goto L5d
        L59:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
        L5d:
            java.util.Objects.toString(r7)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            if (r8 != r2) goto L63
            r0 = 1
        L63:
            r1.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r7 = move-exception
            r7.printStackTrace()
        L6b:
            r6.disconnect()
            goto L87
        L6f:
            r6 = r1
            goto L88
        L71:
            r6 = r1
            goto L77
        L73:
            r7 = move-exception
            goto L6f
        L75:
            r7 = move-exception
            goto L71
        L77:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L84
            r1.close()     // Catch: java.io.IOException -> L80
            goto L84
        L80:
            r7 = move-exception
            r7.printStackTrace()
        L84:
            if (r6 == 0) goto L87
            goto L6b
        L87:
            return r0
        L88:
            if (r1 == 0) goto L92
            r1.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r8 = move-exception
            r8.printStackTrace()
        L92:
            if (r6 == 0) goto L97
            r6.disconnect()
        L97:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0246d.n(java.lang.String, java.util.Map, java.util.HashMap):boolean");
    }

    public static float n0(Parcel parcel, int i) {
        P0(parcel, i, 4);
        return parcel.readFloat();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:24|(2:25|(1:27)(1:84))|29|33|(1:35)(6:37|(1:41)|92|43|47|73)|36|92|43|47|73) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair o(java.lang.String r7, java.util.Map r8, java.util.HashMap r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0246d.o(java.lang.String, java.util.Map, java.util.HashMap):android.util.Pair");
    }

    public static int o0(InputStream inputStream, byte[] bArr, int i) throws IOException {
        int i3 = 0;
        while (i3 < i) {
            int i4 = inputStream.read(bArr, i3, i - i3);
            if (i4 < 0) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static final boolean p(AbstractC0162z abstractC0162z, TypeConstructor typeConstructor, Set set) {
        boolean zP;
        if (kotlin.jvm.internal.h.a(abstractC0162z.c(), typeConstructor)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null;
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        Iterable iterableT0 = m.t0(abstractC0162z.a());
        if (!(iterableT0 instanceof Collection) || !((Collection) iterableT0).isEmpty()) {
            Iterator it = iterableT0.iterator();
            do {
                k3.b bVar = (k3.b) it;
                if (bVar.c.hasNext()) {
                    kotlin.collections.x xVar = (kotlin.collections.x) bVar.next();
                    int i = xVar.f3808a;
                    TypeProjection typeProjection = (TypeProjection) xVar.b;
                    TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (TypeParameterDescriptor) m.S(i, declaredTypeParameters) : null;
                    if ((typeParameterDescriptor == null || set == null || !set.contains(typeParameterDescriptor)) && !typeProjection.isStarProjection()) {
                        AbstractC0162z type = typeProjection.getType();
                        kotlin.jvm.internal.h.e(type, "argument.type");
                        zP = p(type, typeConstructor, set);
                    } else {
                        zP = false;
                    }
                }
            } while (!zP);
            return true;
        }
        return false;
    }

    public static IBinder p0(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iT0);
        return strongBinder;
    }

    public static String q(Map map, boolean z6) {
        String string = "";
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (string.length() > 0) {
                    string = string.concat("&");
                }
                if (z6) {
                    StringBuilder sbK = B2.b.k(string);
                    sbK.append(Uri.encode((String) entry.getKey()));
                    sbK.append("=");
                    sbK.append(Uri.encode((String) entry.getValue()));
                    string = sbK.toString();
                } else {
                    StringBuilder sbK2 = B2.b.k(string);
                    sbK2.append((String) entry.getKey());
                    sbK2.append("=");
                    sbK2.append((String) entry.getValue());
                    string = sbK2.toString();
                }
            }
        }
        return string;
    }

    public static int q0(Parcel parcel, int i) {
        P0(parcel, i, 4);
        return parcel.readInt();
    }

    public static C0163a r(ECParameterSpec eCParameterSpec) {
        int i;
        AbstractC0243a c0244b;
        EllipticCurve curve = eCParameterSpec.getCurve();
        ECField field = curve.getField();
        BigInteger a6 = curve.getA();
        BigInteger b2 = curve.getB();
        if (field instanceof ECFieldFp) {
            c0244b = new C0245c(((ECFieldFp) field).getP(), a6, b2, null, null, false);
            AbstractC0243a abstractC0243a = (AbstractC0243a) W3.a.f1399a.get(c0244b);
            if (abstractC0243a != null) {
                c0244b = abstractC0243a;
            }
        } else {
            ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
            int m6 = eCFieldF2m.getM();
            int[] midTermsOfReductionPolynomial = eCFieldF2m.getMidTermsOfReductionPolynomial();
            int[] iArr = new int[3];
            if (midTermsOfReductionPolynomial.length == 1) {
                iArr[0] = midTermsOfReductionPolynomial[0];
            } else {
                if (midTermsOfReductionPolynomial.length != 3) {
                    throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
                }
                int i3 = midTermsOfReductionPolynomial[0];
                int i4 = midTermsOfReductionPolynomial[1];
                if (i3 >= i4 || i3 >= (i = midTermsOfReductionPolynomial[2])) {
                    int i5 = midTermsOfReductionPolynomial[2];
                    if (i4 < i5) {
                        iArr[0] = i4;
                        int i6 = midTermsOfReductionPolynomial[0];
                        if (i6 < i5) {
                            iArr[1] = i6;
                            iArr[2] = i5;
                        } else {
                            iArr[1] = i5;
                            iArr[2] = i6;
                        }
                    } else {
                        iArr[0] = i5;
                        int i7 = midTermsOfReductionPolynomial[0];
                        if (i7 < i4) {
                            iArr[1] = i7;
                            iArr[2] = midTermsOfReductionPolynomial[1];
                        } else {
                            iArr[1] = i4;
                            iArr[2] = i7;
                        }
                    }
                } else {
                    iArr[0] = i3;
                    if (i4 < i) {
                        iArr[1] = i4;
                        iArr[2] = i;
                    } else {
                        iArr[1] = i;
                        iArr[2] = midTermsOfReductionPolynomial[1];
                    }
                }
            }
            c0244b = new C0244b(m6, iArr[0], iArr[1], iArr[2], a6, b2, null, null);
        }
        ECPoint generator = eCParameterSpec.getGenerator();
        j jVarB = c0244b.b(generator.getAffineX(), generator.getAffineY());
        eCParameterSpec.getOrder();
        BigInteger.valueOf(eCParameterSpec.getCofactor());
        eCParameterSpec.getCurve().getSeed();
        C0163a c0163a = new C0163a();
        c0163a.f1561a = c0244b;
        c0163a.b = jVarB.f();
        return c0163a;
    }

    public static long r0(Parcel parcel, int i) {
        P0(parcel, i, 8);
        return parcel.readLong();
    }

    public static BigDecimal s(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i3 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iT0);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i3);
    }

    public static Long s0(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        if (iT0 == 0) {
            return null;
        }
        if (iT0 == 8) {
            return Long.valueOf(parcel.readLong());
        }
        throw new x("Expected size 8 got " + iT0 + " (0x" + Integer.toHexString(iT0) + ")", parcel);
    }

    public static Bundle t(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iT0);
        return bundle;
    }

    public static int t0(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static byte[] u(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iT0);
        return bArrCreateByteArray;
    }

    public static final AbstractC0162z u0(AbstractC0162z abstractC0162z, Annotations annotations) {
        return (abstractC0162z.getAnnotations().isEmpty() && annotations.isEmpty()) ? abstractC0162z : abstractC0162z.f().i(v0(abstractC0162z.b(), annotations));
    }

    public static final TypeProjection v(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == d0.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() != typeProjection.getProjectionKind()) {
            O2.b bVar = new O2.b(typeProjection);
            M.b.getClass();
            return new K(new O2.a(typeProjection, bVar, false, M.c));
        }
        if (!typeProjection.isStarProjection()) {
            return new K(typeProjection.getType());
        }
        Z2.b NO_LOCKS = Z2.n.e;
        kotlin.jvm.internal.h.e(NO_LOCKS, "NO_LOCKS");
        return new K(new D(NO_LOCKS, new C0022d(typeProjection, 2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a3.M v0(a3.M r5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.h.f(r5, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = a3.AbstractC0149l.a(r5)
            if (r0 != r6) goto Lc
            return r5
        Lc:
            kotlin.reflect.KProperty[] r0 = a3.AbstractC0149l.f1555a
            r1 = 0
            r0 = r0[r1]
            com.android.billingclient.api.z r1 = a3.AbstractC0149l.b
            java.lang.Object r0 = r1.getValue(r5, r0)
            a3.k r0 = (a3.C0148k) r0
            if (r0 == 0) goto L5f
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L22
            goto L50
        L22:
            g3.a r1 = r5.f3309a
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L2d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r1.next()
            r4 = r3
            a3.k r4 = (a3.C0148k) r4
            boolean r4 = kotlin.jvm.internal.h.a(r4, r0)
            if (r4 != 0) goto L2d
            r2.add(r3)
            goto L2d
        L44:
            int r0 = r2.size()
            g3.a r1 = r5.f3309a
            int r1 = r1.a()
            if (r0 != r1) goto L52
        L50:
            r0 = r5
            goto L5b
        L52:
            B.h r0 = a3.M.b
            r0.getClass()
            a3.M r0 = B.h.b(r2)
        L5b:
            if (r0 != 0) goto L5e
            goto L5f
        L5e:
            r5 = r0
        L5f:
            java.util.Iterator r0 = r6.iterator()
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L70
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L70
            goto L8b
        L70:
            a3.k r0 = new a3.k
            r0.<init>(r6)
            kotlin.jvm.internal.x r6 = kotlin.jvm.internal.w.f3818a
            java.lang.Class<a3.k> r1 = a3.C0148k.class
            kotlin.reflect.KClass r6 = r6.b(r1)
            B.h r1 = a3.M.b
            int r6 = r1.j(r6)
            g3.a r1 = r5.f3309a
            java.lang.Object r6 = r1.get(r6)
            if (r6 == 0) goto L8c
        L8b:
            return r5
        L8c:
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L9c
            a3.M r5 = new a3.M
            java.util.List r6 = io.ktor.utils.io.Z.p(r0)
            r5.<init>(r6)
            return r5
        L9c:
            java.util.List r5 = kotlin.collections.m.o0(r5)
            java.util.ArrayList r5 = kotlin.collections.m.d0(r0, r5)
            a3.M r5 = B.h.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.AbstractC0246d.v0(a3.M, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):a3.M");
    }

    public static int[] w(Parcel parcel, int i) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iT0);
        return iArrCreateIntArray;
    }

    public static final c0 w0(AbstractC0162z abstractC0162z) {
        c0 c0VarZ;
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        c0 c0VarF = abstractC0162z.f();
        if (c0VarF instanceof AbstractC0155s) {
            AbstractC0155s abstractC0155s = (AbstractC0155s) c0VarF;
            F fZ = abstractC0155s.b;
            if (!fZ.c().getParameters().isEmpty() && fZ.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = fZ.c().getParameters();
                kotlin.jvm.internal.h.e(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(o.D(parameters));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new K((TypeParameterDescriptor) it.next()));
                }
                fZ = AbstractC0132a.Z(fZ, arrayList, null, 2);
            }
            F fZ2 = abstractC0155s.c;
            if (!fZ2.c().getParameters().isEmpty() && fZ2.c().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = fZ2.c().getParameters();
                kotlin.jvm.internal.h.e(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(o.D(parameters2));
                Iterator<T> it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new K((TypeParameterDescriptor) it2.next()));
                }
                fZ2 = AbstractC0132a.Z(fZ2, arrayList2, null, 2);
            }
            c0VarZ = C.a(fZ, fZ2);
        } else {
            if (!(c0VarF instanceof F)) {
                throw new x();
            }
            F f6 = (F) c0VarF;
            boolean zIsEmpty = f6.c().getParameters().isEmpty();
            c0VarZ = f6;
            if (!zIsEmpty) {
                ClassifierDescriptor declarationDescriptor = f6.c().getDeclarationDescriptor();
                c0VarZ = f6;
                if (declarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = f6.c().getParameters();
                    kotlin.jvm.internal.h.e(parameters3, "constructor.parameters");
                    ArrayList arrayList3 = new ArrayList(o.D(parameters3));
                    Iterator<T> it3 = parameters3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new K((TypeParameterDescriptor) it3.next()));
                    }
                    c0VarZ = AbstractC0132a.Z(f6, arrayList3, null, 2);
                }
            }
        }
        return l.M(c0VarZ, c0VarF);
    }

    public static Parcelable x(Parcel parcel, int i, Parcelable.Creator creator) {
        int iT0 = t0(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iT0 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iT0);
        return parcelable;
    }

    public static int x0(Context context, int i, int i3) {
        TypedValue typedValueA = AbstractC0572b.a(context, i);
        return (typedValueA == null || typedValueA.type != 16) ? i3 : typedValueA.data;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    public static C3.a y(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r46v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */

    public static TimeInterpolator y0(Context context, int i, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!Z(strValueOf, "cubic-bezier") && !Z(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!Z(strValueOf, "cubic-bezier")) {
            if (Z(strValueOf, "path")) {
                return PathInterpolatorCompat.create(PathParser.createPathFromPathData(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return PathInterpolatorCompat.create(Q(0, strArrSplit), Q(1, strArrSplit), Q(2, strArrSplit), Q(3, strArrSplit));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static final K z(AbstractC0162z type, d0 d0Var, TypeParameterDescriptor typeParameterDescriptor) {
        kotlin.jvm.internal.h.f(type, "type");
        if ((typeParameterDescriptor != null ? typeParameterDescriptor.getVariance() : null) == d0Var) {
            d0Var = d0.INVARIANT;
        }
        return new K(type, d0Var);
    }

    public static Object z0(Object obj, String str, Class[] clsArr, Object... objArr) {
        if (obj != null) {
            try {
                Method method = obj.getClass().getMethod(str, clsArr);
                if (method == null) {
                    return null;
                }
                return method.invoke(obj, objArr);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            } catch (Exception e6) {
                StringBuilder sbM = B2.b.m("Error running instance method ", str, " on ");
                sbM.append(obj.toString());
                sbM.append(" : ");
                sbM.append(e6.getLocalizedMessage());
                Log.e("TenjinReflection", sbM.toString());
            }
        }
        return null;
    }

    public abstract AbstractC0246d C0();

    public abstract AbstractC0246d G(AbstractC0246d abstractC0246d);

    public abstract BigInteger G0();

    public abstract AbstractC0246d W();

    public boolean a0() {
        return g() == 1;
    }

    public abstract AbstractC0246d b(AbstractC0246d abstractC0246d);

    public boolean c0() {
        return G0().signum() == 0;
    }

    public int g() {
        return G0().bitLength();
    }

    public abstract AbstractC0246d h0(AbstractC0246d abstractC0246d);

    public String toString() {
        switch (this.f1790a) {
            case 19:
                return G0().toString(16);
            default:
                return super.toString();
        }
    }
}
