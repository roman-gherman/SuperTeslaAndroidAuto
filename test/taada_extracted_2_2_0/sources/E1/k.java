package E1;

import E2.p;
import G0.EnumC0086s0;
import G2.H;
import J4.q;
import J4.t;
import J4.u;
import J4.v;
import M2.z;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import a3.F;
import a3.L;
import a3.W;
import a3.Z;
import a3.b0;
import a3.d0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import c4.AbstractC0246d;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import e2.C0430f;
import h2.x0;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UTFDataFormatException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.E;
import kotlin.collections.s;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.w;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.text.r;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.pool.TypePool;
import o4.C0748a;
import o4.C0749b;
import o4.C0750c;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import q4.C0789a;
import q4.C0790b;
import r4.C0806b;
import s4.C0814a;
import s4.C0815b;
import t4.C0829a;
import t4.C0830b;
import u4.C0844a;
import u4.C0845b;
import v4.C0858a;
import v4.C0859b;
import w3.AbstractC0884b;
import w3.AbstractC0897o;
import w3.AbstractC0899q;
import w3.AbstractC0902u;
import w3.C0891i;
import w3.C0896n;
import w4.C0909b;
import w4.C0910c;
import x4.C0926a;
import x4.C0927b;
import y4.C0938b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292a;

    public /* synthetic */ k(int i) {
        this.f292a = i;
    }

    public static int[] A(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i3 = (i + 31) >> 5;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i4] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static long[] B(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i3 = (i + 63) >> 6;
        long[] jArr = new long[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i4] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArr;
    }

    public static Object D(Context context, Integer num) {
        if (num.intValue() <= 0) {
            Log.e("HuaweiOaid", "Failed to retrieve OAID - giving up");
            return null;
        }
        try {
            return AbstractC0246d.A0("com.huawei.hms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
        } catch (Exception e) {
            e.getLocalizedMessage();
            if (!(e instanceof InvocationTargetException) ? false : ((InvocationTargetException) e).getTargetException() instanceof IOException) {
                return D(context, Integer.valueOf(num.intValue() - 1));
            }
            return null;
        }
    }

    public static final KClass E(Annotation annotation) {
        kotlin.jvm.internal.h.f(annotation, "<this>");
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        kotlin.jvm.internal.h.e(clsAnnotationType, "this as java.lang.annota…otation).annotationType()");
        return K(clsAnnotationType);
    }

    public static final AbstractC0162z G(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        if (dispatchReceiverParameter != null) {
            if (callableMemberDescriptor instanceof ConstructorDescriptor) {
                return dispatchReceiverParameter.getType();
            }
            DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor != null) {
                return classDescriptor.getDefaultType();
            }
        }
        return null;
    }

    public static final Class H(KClass kClass) {
        kotlin.jvm.internal.h.f(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        kotlin.jvm.internal.h.d(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return jClass;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class I(KClass kClass) {
        kotlin.jvm.internal.h.f(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            return jClass;
        }
        String name = jClass.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals(TypedValues.Custom.S_BOOLEAN)) {
                }
                break;
            case 97526364:
                if (!name.equals(TypedValues.Custom.S_FLOAT)) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return jClass;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class J(KClass kClass) {
        kotlin.jvm.internal.h.f(kClass, "<this>");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass.isPrimitive()) {
            return jClass;
        }
        String name = jClass.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final KClass K(Class cls) {
        kotlin.jvm.internal.h.f(cls, "<this>");
        return w.f3818a.b(cls);
    }

    public static final int L(int i, int i3, int i4) {
        if (i4 > 0) {
            if (i < i3) {
                int i5 = i3 % i4;
                if (i5 < 0) {
                    i5 += i4;
                }
                int i6 = i % i4;
                if (i6 < 0) {
                    i6 += i4;
                }
                int i7 = (i5 - i6) % i4;
                if (i7 < 0) {
                    i7 += i4;
                }
                return i3 - i7;
            }
        } else {
            if (i4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i3) {
                int i8 = -i4;
                int i9 = i % i8;
                if (i9 < 0) {
                    i9 += i8;
                }
                int i10 = i3 % i8;
                if (i10 < 0) {
                    i10 += i8;
                }
                int i11 = (i9 - i10) % i8;
                if (i11 < 0) {
                    i11 += i8;
                }
                return i11 + i3;
            }
        }
        return i3;
    }

    public static final p M(H proto, NameResolver nameResolver, I2.f fVar, boolean z6, boolean z7, boolean z8) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        o propertySignature = J2.l.d;
        kotlin.jvm.internal.h.e(propertySignature, "propertySignature");
        J2.f fVar2 = (J2.f) AbstractC0132a.D(proto, propertySignature);
        if (fVar2 != null) {
            if (z6) {
                C0608i c0608i = K2.h.f942a;
                K2.d dVarB = K2.h.b(proto, nameResolver, fVar, z8);
                if (dVarB != null) {
                    return kotlin.reflect.l.v(dVarB);
                }
            } else if (z7 && (fVar2.b & 2) == 2) {
                J2.d dVar = fVar2.d;
                kotlin.jvm.internal.h.e(dVar, "signature.syntheticMethod");
                String name = nameResolver.getString(dVar.c);
                String desc = nameResolver.getString(dVar.d);
                kotlin.jvm.internal.h.f(name, "name");
                kotlin.jvm.internal.h.f(desc, "desc");
                return new p(name.concat(desc));
            }
        }
        return null;
    }

    public static String P(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return B2.b.c(i, "unknown status code: ");
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    public static final Method Q(Class cls, CallableMemberDescriptor descriptor) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            kotlin.jvm.internal.h.e(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new N1.d("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')', 2);
        }
    }

    public static boolean R(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
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

    public static boolean S(int[] iArr, int[] iArr2) {
        for (int i = 11; i >= 0; i--) {
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

    public static int T(int i, int i3, int[] iArr) {
        while (i3 < i) {
            int i4 = iArr[i3] + 1;
            iArr[i3] = i4;
            if (i4 != 0) {
                return 0;
            }
            i3++;
        }
        return 1;
    }

    public static int U(int i, int i3, int[] iArr) {
        while (i3 < i) {
            int i4 = iArr[i3] + 1;
            iArr[i3] = i4;
            if (i4 != 0) {
                return 0;
            }
            i3++;
        }
        return 1;
    }

    public static boolean V(int i) {
        if (i == 0) {
            return false;
        }
        int iV = v(i) >>> 1;
        int iA0 = 2;
        for (int i3 = 0; i3 < iV; i3++) {
            iA0 = a0(iA0, iA0, i);
            int i4 = iA0 ^ 2;
            int i5 = i;
            while (i5 != 0) {
                int iD0 = d0(i4, i5);
                i4 = i5;
                i5 = iD0;
            }
            if (i4 != 1) {
                return false;
            }
        }
        return true;
    }

    public static int X(int[] iArr, int[] iArr2, int i) {
        long j6 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            j6 = (((((long) iArr[i3]) & 4294967295L) - (4294967295L & ((long) iArr2[i3]))) + j6) >> 32;
        }
        return (int) j6;
    }

    public static int Y(int i) {
        RoundingMode roundingMode = RoundingMode.UNNECESSARY;
        if (i <= 0) {
            throw new IllegalArgumentException(B2.b.d(i, "x (", ") must be > 0"));
        }
        switch (com.google.common.math.a.f2788a[roundingMode.ordinal()]) {
            case 1:
                if (!((i > 0) & (((i + (-1)) & i) == 0))) {
                    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                }
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - iNumberOfLeadingZeros) + ((~(~(((-1257966797) >>> iNumberOfLeadingZeros) - i))) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static void Z(String str) {
        if (Log.isLoggable("InstallReferrerClient", 5)) {
            Log.w("InstallReferrerClient", str);
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static int a0(int i, int i3, int i4) {
        int iD0 = d0(i, i4);
        int iD02 = d0(i3, i4);
        int i5 = 0;
        if (iD02 != 0) {
            int iV = 1 << v(i4);
            while (iD0 != 0) {
                if (((byte) (iD0 & 1)) == 1) {
                    i5 ^= iD02;
                }
                iD0 >>>= 1;
                iD02 <<= 1;
                if (iD02 >= iV) {
                    iD02 ^= i4;
                }
            }
        }
        return i5;
    }

    public static int b(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j6 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j7 = (((long) iArr[i3]) & 4294967295L) + (4294967295L & ((long) iArr2[i3])) + j6;
            iArr3[i3] = (int) j7;
            j6 = j7 >>> 32;
        }
        return (int) j6;
    }

    public static String b0(File file) throws IOException {
        Charset charset = kotlin.text.a.f3943a;
        kotlin.jvm.internal.h.f(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[8192];
            for (int i = inputStreamReader.read(cArr); i >= 0; i = inputStreamReader.read(cArr)) {
                stringWriter.write(cArr, 0, i);
            }
            String string = stringWriter.toString();
            kotlin.jvm.internal.h.e(string, "buffer.toString()");
            inputStreamReader.close();
            return string;
        } finally {
        }
    }

    public static void c(int i, int i3, int[] iArr) {
        long j6 = (((long) iArr[0]) & 4294967295L) + (((long) i3) & 4294967295L);
        iArr[0] = (int) j6;
        long j7 = (4294967295L & ((long) iArr[1])) + 1 + (j6 >>> 32);
        iArr[1] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return;
        }
        T(i, 2, iArr);
    }

    public static void c0(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static int d(int i, int i3, int[] iArr, int[] iArr2) {
        long j6 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            long j7 = (((long) iArr[i4]) & 4294967295L) + (4294967295L & ((long) iArr2[i5])) + j6;
            iArr2[i5] = (int) j7;
            j6 = j7 >>> 32;
        }
        return (int) j6;
    }

    public static int d0(int i, int i3) {
        if (i3 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (v(i) >= v(i3)) {
            i ^= i3 << (v(i) - v(i3));
        }
        return i;
    }

    public static void e(int i, int i3, int i4, int[] iArr) {
        long j6 = (((long) i3) & 4294967295L) + (4294967295L & ((long) iArr[i4]));
        iArr[i4] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return;
        }
        T(i, i4 + 1, iArr);
    }

    public static final String e0(L2.f fVar) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        String strB = fVar.b();
        kotlin.jvm.internal.h.e(strB, "asString()");
        if (!z.f1113a.contains(strB)) {
            for (int i = 0; i < strB.length(); i++) {
                char cCharAt = strB.charAt(i);
                if (Character.isLetterOrDigit(cCharAt) || cCharAt == '_') {
                }
            }
            String strB2 = fVar.b();
            kotlin.jvm.internal.h.e(strB2, "asString()");
            return strB2;
        }
        StringBuilder sb = new StringBuilder();
        String strB3 = fVar.b();
        kotlin.jvm.internal.h.e(strB3, "asString()");
        sb.append("`".concat(strB3));
        sb.append('`');
        return sb.toString();
    }

    public static int f(int i, int i3, int[] iArr) {
        long j6 = (((long) i3) & 4294967295L) + (4294967295L & ((long) iArr[0]));
        iArr[0] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return T(i, 1, iArr);
    }

    public static final String f0(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            L2.f fVar = (L2.f) it.next();
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(e0(fVar));
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static void g(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                DrawableCompat.setTintList(drawable, colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                DrawableCompat.setTintList(drawable, ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static final String g0(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        kotlin.jvm.internal.h.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.h.f(lowerPrefix, "lowerPrefix");
        kotlin.jvm.internal.h.f(upperRendered, "upperRendered");
        kotlin.jvm.internal.h.f(upperPrefix, "upperPrefix");
        kotlin.jvm.internal.h.f(foldedPrefix, "foldedPrefix");
        if (!r.C(lowerRendered, lowerPrefix) || !r.C(upperRendered, upperPrefix)) {
            return null;
        }
        String strSubstring = lowerRendered.substring(lowerPrefix.length());
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        String strSubstring2 = upperRendered.substring(upperPrefix.length());
        kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
        String strConcat = foldedPrefix.concat(strSubstring);
        if (strSubstring.equals(strSubstring2)) {
            return strConcat;
        }
        if (!r0(strSubstring, strSubstring2)) {
            return null;
        }
        return strConcat + '!';
    }

    public static final Object h0(Set set, Enum r22, Enum r32, Enum r42, boolean z6) {
        if (!z6) {
            if (r42 != null) {
                set = kotlin.collections.m.s0(E.v(set, r42));
            }
            return kotlin.collections.m.h0(set);
        }
        Enum r12 = set.contains(r22) ? r22 : set.contains(r32) ? r32 : null;
        if (kotlin.jvm.internal.h.a(r12, r22) && kotlin.jvm.internal.h.a(r42, r32)) {
            return null;
        }
        return r42 == null ? r12 : r42;
    }

    public static final AbstractC0162z i(ArrayList arrayList, List list, k2.i iVar) {
        AbstractC0162z abstractC0162zJ = Z.e(new L(arrayList, 0)).j((AbstractC0162z) kotlin.collections.m.P(list), d0.OUT_VARIANCE);
        return abstractC0162zJ == null ? iVar.n() : abstractC0162zJ;
    }

    public static void i0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z6 = onLongClickListener != null;
        boolean z7 = zHasOnClickListeners || z6;
        checkableImageButton.setFocusable(z7);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z6);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z7 ? 1 : 2);
    }

    public static int j(int i, int i3) {
        long j6 = ((long) i) - ((long) i3);
        int i4 = (int) j6;
        AbstractC0132a.l("checkedSubtract", i, i3, j6 == ((long) i4));
        return i4;
    }

    public static final AbstractC0162z j0(TypeParameterDescriptor typeParameterDescriptor) {
        kotlin.jvm.internal.h.f(typeParameterDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = typeParameterDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.h.e(containingDeclaration, "this.containingDeclaration");
        if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
            List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) containingDeclaration).getTypeConstructor().getParameters();
            kotlin.jvm.internal.h.e(parameters, "descriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(parameters));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                TypeConstructor typeConstructor = ((TypeParameterDescriptor) it.next()).getTypeConstructor();
                kotlin.jvm.internal.h.e(typeConstructor, "it.typeConstructor");
                arrayList.add(typeConstructor);
            }
            List<AbstractC0162z> upperBounds = typeParameterDescriptor.getUpperBounds();
            kotlin.jvm.internal.h.e(upperBounds, "upperBounds");
            return i(arrayList, upperBounds, R2.e.e(typeParameterDescriptor));
        }
        if (!(containingDeclaration instanceof FunctionDescriptor)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List<TypeParameterDescriptor> typeParameters = ((FunctionDescriptor) containingDeclaration).getTypeParameters();
        kotlin.jvm.internal.h.e(typeParameters, "descriptor.typeParameters");
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(typeParameters));
        Iterator<T> it2 = typeParameters.iterator();
        while (it2.hasNext()) {
            TypeConstructor typeConstructor2 = ((TypeParameterDescriptor) it2.next()).getTypeConstructor();
            kotlin.jvm.internal.h.e(typeConstructor2, "it.typeConstructor");
            arrayList2.add(typeConstructor2);
        }
        List<AbstractC0162z> upperBounds2 = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.h.e(upperBounds2, "upperBounds");
        return i(arrayList2, upperBounds2, R2.e.e(typeParameterDescriptor));
    }

    public static long k(long j6, long j7, long j8) {
        if (j7 <= j8) {
            return j6 < j7 ? j7 : j6 > j8 ? j8 : j6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j8 + " is less than minimum " + j7 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
    }

    public static int k0(int i, int i3, int[] iArr, int[] iArr2) {
        long j6 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + i4;
            long j7 = ((((long) iArr2[i5]) & 4294967295L) - (4294967295L & ((long) iArr[i4]))) + j6;
            iArr2[i5] = (int) j7;
            j6 = j7 >> 32;
        }
        return (int) j6;
    }

    public static final Object l(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        AbstractC0162z abstractC0162zG;
        Class clsP0;
        return (((callableMemberDescriptor instanceof PropertyDescriptor) && N2.i.d((VariableDescriptor) callableMemberDescriptor)) || (abstractC0162zG = G(callableMemberDescriptor)) == null || (clsP0 = p0(abstractC0162zG)) == null) ? obj : Q(clsP0, callableMemberDescriptor).invoke(obj, new Object[0]);
    }

    public static Z l0(List list, W w5, DeclarationDescriptor declarationDescriptor, ArrayList arrayList) {
        if (w5 == null) {
            a(1);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(2);
            throw null;
        }
        if (arrayList == null) {
            a(3);
            throw null;
        }
        Z zM0 = m0(list, w5, declarationDescriptor, arrayList, null);
        if (zM0 != null) {
            return zM0;
        }
        throw new AssertionError("Substitution failed");
    }

    public static final void m(int i, int i3) throws EOFException {
        throw new EOFException("Unable to discard " + i + " bytes: only " + i3 + " available for writing");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a3.Z m0(java.util.List r17, a3.W r18, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r19, java.util.ArrayList r20, boolean[] r21) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.k.m0(java.util.List, a3.W, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, java.util.ArrayList, boolean[]):a3.Z");
    }

    public static int n(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static BigInteger n0(int i, int[] iArr) {
        byte[] bArr = new byte[i << 2];
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            if (i4 != 0) {
                g5.c.o(bArr, i4, ((i - 1) - i3) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String o(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5, int r6) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.k.o(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, int):java.lang.String");
    }

    public static String o0(EnumC0086s0 enumC0086s0) throws NoSuchAlgorithmException {
        int iOrdinal = enumC0086s0.ordinal();
        if (iOrdinal == 1) {
            return "HmacSha1";
        }
        if (iOrdinal == 2) {
            return "HmacSha384";
        }
        if (iOrdinal == 3) {
            return "HmacSha256";
        }
        if (iOrdinal == 4) {
            return "HmacSha512";
        }
        if (iOrdinal == 5) {
            return "HmacSha224";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + enumC0086s0);
    }

    public static final String p(CallableDescriptor callableDescriptor) {
        kotlin.jvm.internal.h.f(callableDescriptor, "<this>");
        if (!N2.f.o(callableDescriptor)) {
            DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor != null && !classDescriptor.getName().b) {
                CallableDescriptor original = callableDescriptor.getOriginal();
                SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
                if (simpleFunctionDescriptor != null) {
                    return C5.f.b0(classDescriptor, o(simpleFunctionDescriptor, 3));
                }
            }
        }
        return null;
    }

    public static final Class p0(AbstractC0162z abstractC0162z) {
        F f6;
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        Class clsQ0 = q0(abstractC0162z.c().getDeclarationDescriptor());
        if (clsQ0 == null) {
            return null;
        }
        if (b0.f(abstractC0162z) && ((f6 = N2.i.f(abstractC0162z)) == null || b0.f(f6) || k2.i.F(f6))) {
            return null;
        }
        return clsQ0;
    }

    public static ImageView.ScaleType q(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static final Class q0(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !N2.i.b(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class clsJ = x0.j(classDescriptor);
        if (clsJ != null) {
            return clsJ;
        }
        throw new N1.d("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + R2.e.f((ClassifierDescriptor) declarationDescriptor) + ')', 2);
    }

    public static MemberScope r(String debugName, List list) {
        U2.m mVar;
        kotlin.jvm.internal.h.f(debugName, "debugName");
        j3.j jVar = new j3.j();
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            mVar = U2.m.f1338a;
            if (!zHasNext) {
                break;
            }
            MemberScope memberScope = (MemberScope) it.next();
            if (memberScope != mVar) {
                if (memberScope instanceof U2.a) {
                    s.G(jVar, ((U2.a) memberScope).b);
                } else {
                    jVar.add(memberScope);
                }
            }
        }
        int i = jVar.f3670a;
        return i != 0 ? i != 1 ? new U2.a(debugName, (MemberScope[]) jVar.toArray(new MemberScope[0])) : (MemberScope) jVar.get(0) : mVar;
    }

    public static final boolean r0(String lower, String upper) {
        kotlin.jvm.internal.h.f(lower, "lower");
        kotlin.jvm.internal.h.f(upper, "upper");
        if (lower.equals(r.B(upper, TypeDescription.Generic.OfWildcardType.SYMBOL, ""))) {
            return true;
        }
        if (r.w(upper, TypeDescription.Generic.OfWildcardType.SYMBOL) && kotlin.jvm.internal.h.a(lower.concat(TypeDescription.Generic.OfWildcardType.SYMBOL), upper)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(lower);
        sb.append(")?");
        return kotlin.jvm.internal.h.a(sb.toString(), upper);
    }

    public static final Caller s(Caller caller, FunctionDescriptor descriptor, boolean z6) {
        AbstractC0162z returnType;
        AbstractC0162z abstractC0162zG;
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        if (!N2.i.a(descriptor)) {
            List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
            kotlin.jvm.internal.h.e(valueParameters, "descriptor.valueParameters");
            if (!valueParameters.isEmpty()) {
                Iterator<T> it = valueParameters.iterator();
                while (it.hasNext()) {
                    AbstractC0162z type = ((ValueParameterDescriptor) it.next()).getType();
                    kotlin.jvm.internal.h.e(type, "it.type");
                    if (N2.i.c(type)) {
                        break;
                    }
                }
                returnType = descriptor.getReturnType();
                return returnType != null ? caller : caller;
            }
            returnType = descriptor.getReturnType();
            if ((returnType != null || !N2.i.c(returnType)) && ((caller instanceof BoundCaller) || (abstractC0162zG = G(descriptor)) == null || !N2.i.c(abstractC0162zG))) {
            }
        }
        return new i2.s(caller, descriptor, z6);
    }

    public static C0430f s0(int i, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new C0430f(i, i3 - 1, 1);
        }
        C0430f c0430f = C0430f.d;
        return C0430f.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r8v16, types: [int[]] */
    public static Q3.a t(C3.a aVar) throws IOException {
        o4.e eVar;
        int i;
        int i3;
        int i4;
        int iD;
        d5.a aVar2;
        int[] iArr;
        C0748a c0748a;
        int i5;
        boolean z6 = true;
        if (aVar == null) {
            throw new IllegalArgumentException("keyInfo array null");
        }
        H3.a aVar3 = aVar.b;
        C0896n c0896n = aVar3.f747a;
        if (c0896n.o(PQCObjectIdentifiers.qTESLA)) {
            AbstractC0897o abstractC0897oJ = AbstractC0897o.j(aVar.c());
            int iIntValue = ((Integer) I4.c.i.get(aVar3.f747a)).intValue();
            byte[] bArr = abstractC0897oJ.f5067a;
            e5.a aVar4 = new e5.a(true);
            int length = bArr.length;
            if (iIntValue == 5) {
                i5 = 5224;
            } else {
                if (iIntValue != 6) {
                    throw new IllegalArgumentException(B2.b.c(iIntValue, "unknown security category: "));
                }
                i5 = 12392;
            }
            if (length != i5) {
                throw new IllegalArgumentException("invalid key size for security category");
            }
            aVar4.b = iIntValue;
            aVar4.c = g5.c.c(bArr);
            return aVar4;
        }
        boolean zF = c0896n.f(PQCObjectIdentifiers.sphincs256);
        ASN1Encodable aSN1Encodable = aVar3.b;
        if (zF) {
            return new H4.b(I4.c.h(o4.g.b(aSN1Encodable)), AbstractC0897o.j(aVar.c()).f5067a);
        }
        int i6 = 0;
        if (c0896n.f(PQCObjectIdentifiers.newHope)) {
            byte[] bArr2 = AbstractC0897o.j(aVar.c()).f5067a;
            int length2 = bArr2.length / 2;
            short[] sArr = new short[length2];
            while (i6 != length2) {
                int i7 = i6 * 2;
                sArr[i6] = (short) (((bArr2[i7 + 1] & 255) << 8) | (bArr2[i7] & 255));
                i6++;
            }
            return new A4.a(sArr);
        }
        boolean zF2 = c0896n.f(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig);
        AbstractC0884b abstractC0884b = aVar.e;
        if (zF2) {
            byte[] bArr3 = aVar.c.f5067a;
            AbstractC0897o w5 = new w3.W(bArr3);
            if (bArr3.length != 64) {
                AbstractC0897o abstractC0897oJ2 = (I4.c.d(bArr3) || bArr3[0] != 4) ? null : AbstractC0897o.j(bArr3);
                if (abstractC0897oJ2 != null) {
                    w5 = AbstractC0897o.j(abstractC0897oJ2);
                }
            }
            byte[] bArr4 = w5.f5067a;
            if (abstractC0884b == null) {
                return C0909b.a(g5.c.h(bArr4, 4, bArr4.length));
            }
            byte[] bArrN = abstractC0884b.n();
            C0909b c0909bA = C0909b.a(g5.c.h(bArr4, 4, bArr4.length));
            C0910c.a(bArrN);
            c0909bA.getClass();
            return c0909bA;
        }
        if (c0896n.o(BCObjectIdentifiers.sphincsPlus) || c0896n.o(BCObjectIdentifiers.sphincsPlus_interop)) {
            org.bouncycastle.pqc.crypto.sphincsplus.e eVar2 = (org.bouncycastle.pqc.crypto.sphincsplus.e) I4.c.f820s.get(c0896n);
            AbstractC0899q abstractC0899qC = aVar.c();
            if (!(abstractC0899qC instanceof AbstractC0902u)) {
                return new org.bouncycastle.pqc.crypto.sphincsplus.f(eVar2, AbstractC0897o.j(abstractC0899qC).f5067a);
            }
            o4.h hVarB = o4.h.b((AbstractC0902u) abstractC0899qC);
            o4.i iVarC = hVarB.c();
            return new org.bouncycastle.pqc.crypto.sphincsplus.f(eVar2, hVarB.e(), hVarB.d(), iVarC.c(), iVarC.b());
        }
        HashMap map = I4.c.f805O;
        if (map.containsKey(c0896n)) {
            org.bouncycastle.pqc.crypto.slhdsa.e eVar3 = (org.bouncycastle.pqc.crypto.slhdsa.e) map.get(c0896n);
            AbstractC0897o w6 = new w3.W(aVar.c.f5067a);
            int iA = eVar3.a() * 4;
            byte[] bArr5 = w6.f5067a;
            if (bArr5.length != iA) {
                AbstractC0897o abstractC0897oJ3 = (I4.c.d(bArr5) || bArr5[0] != 4) ? null : AbstractC0897o.j(bArr5);
                if (abstractC0897oJ3 != null) {
                    w6 = AbstractC0897o.j(abstractC0897oJ3);
                }
            }
            return new org.bouncycastle.pqc.crypto.slhdsa.f(eVar3, w6.f5067a);
        }
        if (c0896n.o(BCObjectIdentifiers.picnic)) {
            return new D4.b((D4.a) I4.c.f813k.get(c0896n), AbstractC0897o.j(aVar.c()).f5067a);
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_mceliece)) {
            AbstractC0899q abstractC0899qC2 = aVar.c();
            if (abstractC0899qC2 != null) {
                AbstractC0902u abstractC0902uL = AbstractC0902u.l(abstractC0899qC2);
                c0748a = new C0748a();
                int iM = C0891i.j(abstractC0902uL.m(0)).m();
                c0748a.f4359a = iM;
                if (iM != 0) {
                    throw new IllegalArgumentException("unrecognized version");
                }
                c0748a.b = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(1)).f5067a);
                c0748a.c = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(2)).f5067a);
                c0748a.d = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(3)).f5067a);
                c0748a.e = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(4)).f5067a);
                c0748a.f4360f = g5.c.c(AbstractC0897o.j(abstractC0902uL.m(5)).f5067a);
                if (abstractC0902uL.size() == 7) {
                    c0748a.f4361g = C0749b.b(abstractC0902uL.m(6));
                }
            } else {
                c0748a = null;
            }
            return new r4.c((C0806b) I4.c.q.get(c0896n), g5.c.c(c0748a.b), g5.c.c(c0748a.c), g5.c.c(c0748a.d), g5.c.c(c0748a.e), g5.c.c(c0748a.f4360f));
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_frodo)) {
            byte[] bArr6 = AbstractC0897o.j(aVar.c()).f5067a;
            C0845b c0845b = new C0845b((C0844a) I4.c.f815m.get(c0896n), z6);
            c0845b.c = g5.c.c(bArr6);
            return c0845b;
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_saber)) {
            byte[] bArr7 = AbstractC0897o.j(aVar.c()).f5067a;
            F4.b bVar = new F4.b((F4.a) I4.c.f817o.get(c0896n), z6);
            bVar.c = g5.c.c(bArr7);
            return bVar;
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_ntru)) {
            return new B4.c((B4.b) I4.c.u.get(c0896n), AbstractC0897o.j(aVar.c()).f5067a);
        }
        if (c0896n.f(NISTObjectIdentifiers.id_alg_ml_kem_512) || c0896n.f(NISTObjectIdentifiers.id_alg_ml_kem_768) || c0896n.f(NISTObjectIdentifiers.id_alg_ml_kem_1024)) {
            byte[] bArr8 = aVar.c.f5067a;
            w3.W w7 = new w3.W(bArr8);
            Object objL = w7;
            if (bArr8.length != 64) {
                AbstractC0899q abstractC0899qE = I4.c.e(bArr8);
                if (abstractC0899qE instanceof AbstractC0897o) {
                    objL = AbstractC0897o.j(abstractC0899qE);
                } else {
                    objL = w7;
                    if (abstractC0899qE instanceof AbstractC0902u) {
                        objL = AbstractC0902u.l(abstractC0899qE);
                    }
                }
            }
            z4.c cVar = (z4.c) I4.c.f801K.get(c0896n);
            AbstractC0884b abstractC0884b2 = aVar.e;
            z4.e eVarC = abstractC0884b2 != null ? I4.a.c(cVar, abstractC0884b2) : null;
            if (objL instanceof AbstractC0897o) {
                return new z4.d(cVar, ((AbstractC0897o) objL).f5067a, eVarC);
            }
            if (!(objL instanceof AbstractC0902u)) {
                throw new IllegalArgumentException(B2.b.h(new StringBuilder("invalid "), cVar.f5212a, " private key"));
            }
            AbstractC0902u abstractC0902u = (AbstractC0902u) objL;
            byte[] bArr9 = AbstractC0897o.j(abstractC0902u.m(0)).f5067a;
            byte[] bArr10 = AbstractC0897o.j(abstractC0902u.m(1)).f5067a;
            z4.d dVar = new z4.d(cVar, bArr9, eVarC);
            if (g5.c.g(dVar.getEncoded(), bArr10)) {
                return dVar;
            }
            throw new IllegalArgumentException(B2.b.h(new StringBuilder("inconsistent "), cVar.f5212a, " private key"));
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_ntrulprime)) {
            AbstractC0902u abstractC0902uL2 = AbstractC0902u.l(aVar.c());
            return new C4.b((C4.a) I4.c.y.get(c0896n), AbstractC0897o.j(abstractC0902uL2.m(0)).f5067a, AbstractC0897o.j(abstractC0902uL2.m(1)).f5067a, AbstractC0897o.j(abstractC0902uL2.m(2)).f5067a, AbstractC0897o.j(abstractC0902uL2.m(3)).f5067a);
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_sntruprime)) {
            AbstractC0902u abstractC0902uL3 = AbstractC0902u.l(aVar.c());
            return new C4.e((C4.d) I4.c.f796A.get(c0896n), AbstractC0897o.j(abstractC0902uL3.m(0)).f5067a, AbstractC0897o.j(abstractC0902uL3.m(1)).f5067a, AbstractC0897o.j(abstractC0902uL3.m(2)).f5067a, AbstractC0897o.j(abstractC0902uL3.m(3)).f5067a, AbstractC0897o.j(abstractC0902uL3.m(4)).f5067a);
        }
        HashMap map2 = I4.c.f803M;
        if (map2.containsKey(c0896n)) {
            byte[] bArr11 = aVar.c.f5067a;
            w3.W w8 = new w3.W(bArr11);
            Object objL2 = w8;
            if (bArr11.length != 32) {
                AbstractC0899q abstractC0899qE2 = I4.c.e(bArr11);
                if (abstractC0899qE2 instanceof AbstractC0897o) {
                    objL2 = AbstractC0897o.j(abstractC0899qE2);
                } else {
                    objL2 = w8;
                    if (abstractC0899qE2 instanceof AbstractC0902u) {
                        objL2 = AbstractC0902u.l(abstractC0899qE2);
                    }
                }
            }
            C0938b c0938b = (C0938b) map2.get(c0896n);
            y4.d dVarB = abstractC0884b != null ? I4.a.b(c0938b, abstractC0884b) : null;
            if (objL2 instanceof AbstractC0897o) {
                return new y4.c(c0938b, ((AbstractC0897o) objL2).f5067a, dVarB);
            }
            if (!(objL2 instanceof AbstractC0902u)) {
                throw new IllegalArgumentException(B2.b.h(new StringBuilder("invalid "), c0938b.b, " private key"));
            }
            AbstractC0902u abstractC0902u2 = (AbstractC0902u) objL2;
            byte[] bArr12 = AbstractC0897o.j(abstractC0902u2.m(0)).f5067a;
            byte[] bArr13 = AbstractC0897o.j(abstractC0902u2.m(1)).f5067a;
            y4.c cVar2 = new y4.c(c0938b, bArr12, dVarB);
            if (g5.c.g(cVar2.getEncoded(), bArr13)) {
                return cVar2;
            }
            throw new IllegalArgumentException(B2.b.h(new StringBuilder("inconsistent "), c0938b.b, " private key"));
        }
        if (c0896n.f(BCObjectIdentifiers.dilithium2) || c0896n.f(BCObjectIdentifiers.dilithium3) || c0896n.f(BCObjectIdentifiers.dilithium5)) {
            AbstractC0899q abstractC0899qC3 = aVar.c();
            C0814a c0814a = (C0814a) I4.c.C.get(c0896n);
            if (abstractC0899qC3 instanceof AbstractC0902u) {
                AbstractC0902u abstractC0902uL4 = AbstractC0902u.l(abstractC0899qC3);
                int iM2 = C0891i.j(abstractC0902uL4.m(0)).m();
                if (iM2 == 0) {
                    return abstractC0884b != null ? new C0815b(c0814a, AbstractC0884b.m(abstractC0902uL4.m(1)).n(), AbstractC0884b.m(abstractC0902uL4.m(2)).n(), AbstractC0884b.m(abstractC0902uL4.m(3)).n(), AbstractC0884b.m(abstractC0902uL4.m(4)).n(), AbstractC0884b.m(abstractC0902uL4.m(5)).n(), AbstractC0884b.m(abstractC0902uL4.m(6)).n(), g5.c.c(I4.a.a(c0814a, abstractC0884b).d)) : new C0815b(c0814a, AbstractC0884b.m(abstractC0902uL4.m(1)).n(), AbstractC0884b.m(abstractC0902uL4.m(2)).n(), AbstractC0884b.m(abstractC0902uL4.m(3)).n(), AbstractC0884b.m(abstractC0902uL4.m(4)).n(), AbstractC0884b.m(abstractC0902uL4.m(5)).n(), AbstractC0884b.m(abstractC0902uL4.m(6)).n(), null);
                }
                throw new IOException(B2.b.c(iM2, "unknown private key version: "));
            }
            if (!(abstractC0899qC3 instanceof w3.W)) {
                throw new IOException("not supported");
            }
            byte[] bArr14 = AbstractC0897o.j(abstractC0899qC3).f5067a;
            AbstractC0884b abstractC0884b3 = aVar.e;
            return abstractC0884b3 != null ? new C0815b(c0814a, bArr14, I4.a.a(c0814a, abstractC0884b3)) : new C0815b(c0814a, bArr14, null);
        }
        if (c0896n.f(BCObjectIdentifiers.falcon_512) || c0896n.f(BCObjectIdentifiers.falcon_1024)) {
            C0750c c0750cB = C0750c.b(aVar.c());
            return new C0830b((C0829a) I4.c.f823w.get(c0896n), g5.c.c(c0750cB.b), g5.c.c(c0750cB.c), g5.c.c(c0750cB.d), c0750cB.e.f4364a);
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_bike)) {
            byte[] bArr15 = AbstractC0897o.j(aVar.c()).f5067a;
            C0789a c0789a = (C0789a) I4.c.E.get(c0896n);
            byte[] bArrH = g5.c.h(bArr15, 0, (c0789a.b + 7) / 8);
            int i8 = c0789a.b;
            byte[] bArrH2 = g5.c.h(bArr15, (i8 + 7) / 8, ((i8 + 7) / 8) * 2);
            byte[] bArrH3 = g5.c.h(bArr15, ((c0789a.b + 7) / 8) * 2, bArr15.length);
            C0790b c0790b = new C0790b(c0789a, z6);
            c0790b.c = g5.c.c(bArrH);
            c0790b.d = g5.c.c(bArrH2);
            c0790b.e = g5.c.c(bArrH3);
            return c0790b;
        }
        if (c0896n.o(BCObjectIdentifiers.pqc_kem_hqc)) {
            byte[] bArr16 = AbstractC0897o.j(aVar.c()).f5067a;
            C0859b c0859b = new C0859b((C0858a) I4.c.f800G.get(c0896n));
            c0859b.c = g5.c.c(bArr16);
            return c0859b;
        }
        if (c0896n.o(BCObjectIdentifiers.rainbow)) {
            return new E4.d((E4.c) I4.c.I.get(c0896n), AbstractC0897o.j(aVar.c()).f5067a);
        }
        if (c0896n.f(PQCObjectIdentifiers.xmss)) {
            o4.j jVarB = o4.j.b(aSN1Encodable);
            C0896n c0896n2 = jVarB.c.f747a;
            AbstractC0899q abstractC0899qC4 = aVar.c();
            o4.n nVar = abstractC0899qC4 != null ? new o4.n(AbstractC0902u.l(abstractC0899qC4)) : null;
            try {
                u uVar = new u(new t(jVarB.b, I4.c.b(c0896n2)));
                int i9 = nVar.b;
                byte[] bArr17 = nVar.f4381h;
                uVar.b = i9;
                uVar.d = C5.f.j(g5.c.c(nVar.c));
                uVar.e = C5.f.j(g5.c.c(nVar.d));
                uVar.f911f = C5.f.j(g5.c.c(nVar.e));
                uVar.f912g = C5.f.j(g5.c.c(nVar.f4379f));
                if (nVar.f4378a != 0) {
                    uVar.c = nVar.f4380g;
                }
                if (g5.c.c(bArr17) != null) {
                    J4.a aVar5 = (J4.a) C5.f.t(g5.c.c(bArr17), J4.a.class);
                    aVar5.getClass();
                    uVar.f913h = new J4.a(aVar5, c0896n2);
                }
                return new v(uVar);
            } catch (ClassNotFoundException e) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
            }
        }
        if (c0896n.f(PQCObjectIdentifiers.xmss_mt)) {
            o4.k kVarB = o4.k.b(aSN1Encodable);
            C0896n c0896n3 = kVarB.d.f747a;
            try {
                AbstractC0899q abstractC0899qC5 = aVar.c();
                o4.l lVar = abstractC0899qC5 != null ? new o4.l(AbstractC0902u.l(abstractC0899qC5)) : null;
                J4.p pVar = new J4.p(new J4.o(kVarB.b, kVarB.c, I4.c.b(c0896n3)));
                long j6 = lVar.b;
                byte[] bArr18 = lVar.f4376h;
                pVar.b = j6;
                pVar.d = C5.f.j(g5.c.c(lVar.d));
                pVar.e = C5.f.j(g5.c.c(lVar.e));
                pVar.f898f = C5.f.j(g5.c.c(lVar.f4374f));
                pVar.f899g = C5.f.j(g5.c.c(lVar.f4375g));
                if (lVar.f4373a != 0) {
                    pVar.c = lVar.c;
                }
                if (g5.c.c(bArr18) != null) {
                    pVar.a(((J4.b) C5.f.t(g5.c.c(bArr18), J4.b.class)).b(c0896n3));
                }
                return new q(pVar);
            } catch (ClassNotFoundException e6) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e6.getMessage());
            }
        }
        if (!c0896n.f(PQCObjectIdentifiers.mcElieceCca2)) {
            if (c0896n.o(BCObjectIdentifiers.mayo)) {
                return new C0927b((C0926a) I4.c.f807Q.get(c0896n), AbstractC0897o.j(aVar.c()).f5067a);
            }
            if (c0896n.o(BCObjectIdentifiers.snova)) {
                return new G4.b((G4.a) I4.c.S.get(c0896n), AbstractC0897o.j(aVar.c()).f5067a);
            }
            throw new RuntimeException("algorithm identifier in private key not recognised");
        }
        AbstractC0899q abstractC0899qC6 = aVar.c();
        if (abstractC0899qC6 != null) {
            AbstractC0902u abstractC0902uL5 = AbstractC0902u.l(abstractC0899qC6);
            eVar = new o4.e();
            eVar.f4365a = ((C0891i) abstractC0902uL5.m(0)).m();
            eVar.b = ((C0891i) abstractC0902uL5.m(1)).m();
            eVar.c = ((AbstractC0897o) abstractC0902uL5.m(2)).f5067a;
            eVar.d = ((AbstractC0897o) abstractC0902uL5.m(3)).f5067a;
            eVar.e = ((AbstractC0897o) abstractC0902uL5.m(4)).f5067a;
            eVar.f4366f = H3.a.b(abstractC0902uL5.m(5));
        } else {
            eVar = null;
        }
        int i10 = eVar.f4365a;
        f5.b bVarB = eVar.b();
        f5.b bVarB2 = eVar.b();
        f5.e eVar4 = new f5.e();
        eVar4.f3257a = bVarB2;
        int i11 = 1;
        int i12 = 8;
        while (bVarB2.f3254a > i12) {
            i11++;
            i12 += 8;
        }
        byte[] bArr19 = eVar.d;
        if (bArr19.length % i11 != 0) {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
        eVar4.c = new int[bArr19.length / i11];
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr2 = eVar4.c;
            int i15 = -1;
            if (i13 >= iArr2.length) {
                if (iArr2.length != 1 && iArr2[iArr2.length - 1] == 0) {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
                eVar4.c();
                f5.d dVar2 = new f5.d();
                byte[] bArr20 = eVar.e;
                if (bArr20.length <= 4) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                int iC = C5.f.c(0, bArr20);
                int i16 = iC - 1;
                int i17 = f5.c.f3255a;
                if (i16 == 0) {
                    i = 1;
                } else {
                    if (i16 < 0) {
                        i16 = -i16;
                    }
                    i = 0;
                    while (i16 > 0) {
                        i++;
                        i16 >>>= 8;
                    }
                }
                if (bArr20.length != (iC * i) + 4) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                dVar2.f3256a = new int[iC];
                for (int i18 = 0; i18 < iC; i18++) {
                    int[] iArr3 = dVar2.f3256a;
                    int i19 = (i18 * i) + 4;
                    int i20 = 0;
                    for (int i21 = i - 1; i21 >= 0; i21--) {
                        i20 |= (bArr20[i19 + i21] & 255) << (i21 * 8);
                    }
                    iArr3[i18] = i20;
                }
                int[] iArr4 = dVar2.f3256a;
                int length3 = iArr4.length;
                boolean[] zArr = new boolean[length3];
                for (int i22 : iArr4) {
                    if (i22 < 0 || i22 >= length3 || zArr[i22]) {
                        throw new IllegalArgumentException("invalid encoding");
                    }
                    zArr[i22] = true;
                }
                String strC = I4.c.c(eVar.f4366f.f747a);
                int i23 = bVarB.f3254a;
                int i24 = 1 << i23;
                int[] iArr5 = eVar4.c;
                int length4 = iArr5.length - 1;
                if (iArr5[length4] == 0) {
                    length4 = -1;
                }
                Class cls = Integer.TYPE;
                int[][] iArr6 = (int[][]) Array.newInstance((Class<?>) cls, length4, i24);
                int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) cls, length4, i24);
                int i25 = 0;
                while (i6 < i24) {
                    int[] iArr8 = iArr7[0];
                    boolean z7 = z6;
                    int[] iArr9 = eVar4.c;
                    int i26 = eVar4.b;
                    int iA0 = iArr9[i26];
                    int i27 = i26 - 1;
                    while (i27 >= 0) {
                        int i28 = i27;
                        iA0 = eVar4.c[i28] ^ a0(iA0, i6, eVar4.f3257a.b);
                        i27 = i28 - 1;
                    }
                    iArr8[i6] = bVarB.a(iA0);
                    i6++;
                    z6 = z7;
                }
                boolean z8 = z6;
                int i29 = z8 ? 1 : 0;
                while (true) {
                    i3 = bVarB.b;
                    if (i29 >= length4) {
                        break;
                    }
                    int i30 = 0;
                    while (i30 < i24) {
                        iArr7[i29][i30] = a0(iArr7[i29 - 1][i30], i30, i3);
                        i30++;
                        i29 = i29 == true ? 1 : 0;
                    }
                    i29 = (i29 == true ? 1 : 0) + 1;
                }
                int i31 = 0;
                while (i31 < length4) {
                    int i32 = 0;
                    while (i32 < i24) {
                        int[][] iArr10 = iArr6;
                        int i33 = 0;
                        while (i33 <= i31) {
                            int[] iArr11 = iArr10[i31];
                            int i34 = i31;
                            iArr11[i32] = iArr11[i32] ^ a0(iArr7[i33][i32], eVar4.d((length4 + i33) - i34), i3);
                            i33++;
                            i31 = i34;
                        }
                        i32++;
                        iArr6 = iArr10;
                    }
                    i31++;
                }
                int[][] iArr12 = iArr6;
                int i35 = i24 + 31;
                int[] iArr13 = new int[2];
                iArr13[z8 ? 1 : 0] = i35 >>> 5;
                iArr13[0] = length4 * i23;
                int[][] iArr14 = (int[][]) Array.newInstance((Class<?>) cls, iArr13);
                int i36 = 0;
                while (i36 < i24) {
                    int i37 = i36 >>> 5;
                    int i38 = (z8 ? 1 : 0) << (i36 & 31);
                    int i39 = i24;
                    int i40 = 0;
                    while (i40 < length4) {
                        int i41 = iArr12[i40][i36];
                        int i42 = i40;
                        for (int i43 = 0; i43 < i23; i43++) {
                            if (((i41 >>> i43) & 1) != 0) {
                                int[] iArr15 = iArr14[(((i42 + 1) * i23) - i43) - 1];
                                iArr15[i37] = iArr15[i37] ^ i38;
                            }
                        }
                        i40 = i42 + 1;
                    }
                    i36++;
                    i24 = i39;
                }
                int i44 = i24;
                int[] iArr16 = iArr14[0];
                if (iArr16.length != (i35 >> 5)) {
                    throw new ArithmeticException("Int array does not match given number of columns.");
                }
                int length5 = iArr16.length;
                int i45 = (i44 & 31) == 0 ? -1 : ((z8 ? 1 : 0) << r10) - 1;
                for (int[] iArr17 : iArr14) {
                    int i46 = length5 - 1;
                    iArr17[i46] = iArr17[i46] & i45;
                }
                ?? r11 = z8 ? 1 : 0;
                d5.a aVar6 = new d5.a(r11, strC);
                aVar6.c = i10;
                aVar6.d = eVar.b;
                aVar6.e = bVarB;
                aVar6.f3126f = eVar4;
                aVar6.f3127g = dVar2;
                int[] iArr18 = eVar4.c;
                int length6 = iArr18.length - (r11 == true ? 1 : 0);
                if (iArr18[length6] == 0) {
                    length6 = -1;
                }
                f5.e[] eVarArr = new f5.e[length6];
                int i47 = 0;
                while (true) {
                    i4 = length6 >> 1;
                    if (i47 >= i4) {
                        break;
                    }
                    int i48 = i47 << 1;
                    int[] iArr19 = new int[i48 + 1];
                    iArr19[i48] = r11 == true ? 1 : 0;
                    eVarArr[i47] = new f5.e(bVarB, iArr19);
                    i47 += r11 == true ? 1 : 0;
                }
                while (i4 < length6) {
                    int i49 = i4 << 1;
                    ?? r8 = new int[i49 + 1];
                    r8[i49] = r11;
                    f5.e eVar5 = new f5.e(bVarB, r8);
                    int[] iArr20 = eVar5.c;
                    int[] iArr21 = eVar4.c;
                    int iB = f5.e.b(iArr21);
                    int i50 = i15;
                    if (iB == i50) {
                        throw new ArithmeticException("Division by zero");
                    }
                    int length7 = iArr20.length;
                    int[] iArrA = new int[length7];
                    int iB2 = f5.e.b(iArr21);
                    int iA2 = bVarB.a(iB2 == i50 ? i25 : iArr21[iB2]);
                    int i51 = i25;
                    System.arraycopy(iArr20, i51, iArrA, i51, length7);
                    while (iB <= f5.e.b(iArrA)) {
                        int iB3 = f5.e.b(iArrA);
                        int iA02 = a0(iB3 == i50 ? 0 : iArrA[iB3], iA2, i3);
                        int iB4 = f5.e.b(iArrA) - iB;
                        int iB5 = f5.e.b(iArr21);
                        if (iB5 == i50) {
                            iArr = new int[1];
                            aVar2 = aVar6;
                        } else {
                            int[] iArr22 = new int[iB5 + iB4 + 1];
                            aVar2 = aVar6;
                            System.arraycopy(iArr21, 0, iArr22, iB4, iB5 + 1);
                            iArr = iArr22;
                        }
                        iArrA = eVar5.a(eVar5.e(iA02, iArr), iArrA);
                        i50 = -1;
                        aVar6 = aVar2;
                    }
                    eVarArr[i4] = new f5.e(bVarB, iArrA);
                    i4++;
                    i25 = 0;
                    i15 = -1;
                    aVar6 = aVar6;
                    r11 = 1;
                }
                d5.a aVar7 = aVar6;
                int[] iArr23 = eVar4.c;
                int length8 = iArr23.length - 1;
                int i52 = iArr23[length8] == 0 ? -1 : length8;
                f5.e[] eVarArr2 = new f5.e[i52];
                int i53 = i52 - 1;
                for (int i54 = i53; i54 >= 0; i54--) {
                    f5.e eVar6 = eVarArr[i54];
                    f5.e eVar7 = new f5.e();
                    eVar7.f3257a = eVar6.f3257a;
                    eVar7.b = eVar6.b;
                    int[] iArr24 = eVar6.c;
                    int[] iArr25 = new int[iArr24.length];
                    System.arraycopy(iArr24, 0, iArr25, 0, iArr24.length);
                    eVar7.c = iArr25;
                    eVarArr2[i54] = eVar7;
                }
                f5.e[] eVarArr3 = new f5.e[i52];
                while (i53 >= 0) {
                    f5.e eVar8 = new f5.e();
                    eVar8.f3257a = bVarB;
                    eVar8.b = i53;
                    int[] iArr26 = new int[i53 + 1];
                    eVar8.c = iArr26;
                    iArr26[i53] = 1;
                    eVarArr3[i53] = eVar8;
                    i53--;
                }
                for (int i55 = 0; i55 < i52; i55++) {
                    if (eVarArr2[i55].d(i55) == 0) {
                        int i56 = i55 + 1;
                        boolean z9 = false;
                        while (i56 < i52) {
                            if (eVarArr2[i56].d(i55) != 0) {
                                f5.e eVar9 = eVarArr2[i55];
                                eVarArr2[i55] = eVarArr2[i56];
                                eVarArr2[i56] = eVar9;
                                AbstractC0246d.F0(eVarArr3, i55, i56);
                                i56 = i52;
                                z9 = true;
                            }
                            i56++;
                        }
                        if (!z9) {
                            throw new ArithmeticException("Squaring matrix is not invertible.");
                        }
                    }
                    int iA3 = bVarB.a(eVarArr2[i55].d(i55));
                    f5.e eVar10 = eVarArr2[i55];
                    if (!eVar10.f3257a.b(iA3)) {
                        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
                    }
                    eVar10.c = eVar10.e(iA3, eVar10.c);
                    eVar10.c();
                    f5.e eVar11 = eVarArr3[i55];
                    if (!eVar11.f3257a.b(iA3)) {
                        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
                    }
                    eVar11.c = eVar11.e(iA3, eVar11.c);
                    eVar11.c();
                    for (int i57 = 0; i57 < i52; i57++) {
                        if (i57 != i55 && (iD = eVarArr2[i57].d(i55)) != 0) {
                            f5.e eVar12 = eVarArr2[i55];
                            f5.b bVar2 = eVar12.f3257a;
                            if (!bVar2.b(iD)) {
                                throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
                            }
                            f5.e eVar13 = new f5.e(bVar2, eVar12.e(iD, eVar12.c));
                            f5.e eVar14 = eVarArr3[i55];
                            f5.b bVar3 = eVar14.f3257a;
                            if (!bVar3.b(iD)) {
                                throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
                            }
                            f5.e eVar15 = new f5.e(bVar3, eVar14.e(iD, eVar14.c));
                            f5.e eVar16 = eVarArr2[i57];
                            eVar16.c = eVar16.a(eVar16.c, eVar13.c);
                            eVar16.c();
                            f5.e eVar17 = eVarArr3[i57];
                            eVar17.c = eVar17.a(eVar17.c, eVar15.c);
                            eVar17.c();
                        }
                    }
                }
                return aVar7;
            }
            int i58 = 0;
            while (i58 < i12) {
                int[] iArr27 = eVar4.c;
                iArr27[i13] = iArr27[i13] ^ ((bArr19[i14] & 255) << i58);
                i58 += 8;
                i14++;
            }
            if (!eVar4.f3257a.b(eVar4.c[i13])) {
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            i13++;
        }
    }

    public static final void t0(I1.c cVar, ByteBuffer byteBuffer) {
        kotlin.jvm.internal.h.f(cVar, "<this>");
        int iLimit = byteBuffer.limit();
        J1.b bVarF = J1.c.f(cVar, 1, null);
        while (true) {
            try {
                byteBuffer.limit(byteBuffer.position() + Math.min(byteBuffer.remaining(), bVarF.e - bVarF.c));
                AbstractC0246d.O0(bVarF, byteBuffer);
                byteBuffer.limit(iLimit);
                if (!byteBuffer.hasRemaining()) {
                    return;
                } else {
                    bVarF = J1.c.f(cVar, 1, bVarF);
                }
            } finally {
                cVar.a();
            }
        }
    }

    public static String u(f.l lVar, char[] cArr) throws UTFDataFormatException {
        int i;
        int i3 = 0;
        while (true) {
            ByteBuffer byteBuffer = lVar.b;
            char c = (char) (byteBuffer.get() & 255);
            if (c == 0) {
                return new String(cArr, 0, i3);
            }
            cArr[i3] = c;
            if (c < 128) {
                i3++;
            } else {
                if ((c & 224) == 192) {
                    byte b = byteBuffer.get();
                    if ((b & 192) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i = i3 + 1;
                    cArr[i3] = (char) ((b & 63) | ((c & 31) << 6));
                } else {
                    if ((c & 240) != 224) {
                        throw new UTFDataFormatException("bad byte");
                    }
                    byte b2 = byteBuffer.get();
                    byte b6 = byteBuffer.get();
                    if ((b2 & 192) != 128 || (b6 & 192) != 128) {
                        break;
                    }
                    i = i3 + 1;
                    cArr[i3] = (char) ((b6 & 63) | ((c & 15) << 12) | ((b2 & 63) << 6));
                }
                i3 = i;
            }
        }
        throw new UTFDataFormatException("bad second or third byte");
    }

    public static int v(int i) {
        int i3 = -1;
        while (i != 0) {
            i3++;
            i >>>= 1;
        }
        return i3;
    }

    public static final void w(int i, int i3) throws EOFException {
        throw new EOFException("Unable to discard " + i + " bytes: only " + i3 + " available for reading");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r0 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r4 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if (r4 < 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int x(int r4, int r5) {
        /*
            java.math.RoundingMode r0 = java.math.RoundingMode.CEILING
            r0.getClass()
            if (r5 == 0) goto L4c
            int r1 = r4 / r5
            int r2 = r5 * r1
            int r2 = r4 - r2
            if (r2 != 0) goto L10
            goto L43
        L10:
            r4 = r4 ^ r5
            int r4 = r4 >> 31
            r4 = r4 | 1
            int[] r3 = com.google.common.math.a.f2788a
            int r0 = r0.ordinal()
            r0 = r3[r0]
            switch(r0) {
                case 1: goto L41;
                case 2: goto L43;
                case 3: goto L3d;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L26;
                case 7: goto L26;
                case 8: goto L26;
                default: goto L20;
            }
        L20:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L26:
            int r0 = java.lang.Math.abs(r2)
            int r5 = java.lang.Math.abs(r5)
            int r5 = r5 - r0
            int r0 = r0 - r5
            if (r0 != 0) goto L37
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_UP
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_EVEN
            goto L43
        L37:
            if (r0 <= 0) goto L43
            goto L3f
        L3a:
            if (r4 <= 0) goto L43
            goto L3f
        L3d:
            if (r4 >= 0) goto L43
        L3f:
            int r1 = r1 + r4
            return r1
        L41:
            if (r2 != 0) goto L44
        L43:
            return r1
        L44:
            java.lang.ArithmeticException r4 = new java.lang.ArithmeticException
            java.lang.String r5 = "mode was UNNECESSARY, but rounding was necessary"
            r4.<init>(r5)
            throw r4
        L4c:
            java.lang.ArithmeticException r4 = new java.lang.ArithmeticException
            java.lang.String r5 = "/ by zero"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.k.x(int, int):int");
    }

    public static byte[] y(String str) throws UTFDataFormatException {
        int length = str.length();
        long j6 = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            j6 += (cCharAt == 0 || cCharAt > 127) ? cCharAt <= 2047 ? 2L : 3L : 1L;
            if (j6 > 65535) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        byte[] bArr = new byte[(int) j6];
        int length2 = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4++) {
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 != 0 && cCharAt2 <= 127) {
                bArr[i3] = (byte) cCharAt2;
                i3++;
            } else if (cCharAt2 <= 2047) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (((cCharAt2 >> 6) & 31) | 192);
                i3 += 2;
                bArr[i5] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                bArr[i3] = (byte) (((cCharAt2 >> '\f') & 15) | 224);
                int i6 = i3 + 2;
                bArr[i3 + 1] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                i3 += 3;
                bArr[i6] = (byte) ((cCharAt2 & '?') | 128);
            }
        }
        return bArr;
    }

    public static boolean z(int[] iArr, int[] iArr2, int i) {
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public abstract Method C(Class cls, Field field);

    public abstract Constructor F(Class cls);

    public abstract String[] O(Class cls);

    public abstract boolean W(Class cls);

    public abstract String h();

    public String toString() {
        switch (this.f292a) {
            case 9:
                return h();
            default:
                return super.toString();
        }
    }
}
