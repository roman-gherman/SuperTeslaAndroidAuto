package a;

import A2.C0022d;
import A2.y;
import C0.x;
import J1.b;
import J4.r;
import J4.w;
import N1.i;
import N1.j;
import N1.l;
import N1.n;
import R2.e;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.M;
import a3.Z;
import a3.b0;
import a3.c0;
import a3.d0;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c3.g;
import c4.AbstractC0246d;
import com.google.common.base.Predicate;
import e2.C0429e;
import e2.C0430f;
import f.s;
import f3.C0442a;
import f3.d;
import g5.c;
import i2.C0529b;
import io.ktor.utils.io.j0;
import io.ktor.utils.io.jvm.javaio.q;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k2.p;
import kotlin.Lazy;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.protobuf.A;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0609j;
import kotlin.reflect.jvm.internal.impl.protobuf.C0613n;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import net.bytebuddy.pool.TypePool;
import o2.f;
import o4.k;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.internal.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import q4.C0789a;
import q4.C0791c;
import r4.C0806b;
import s4.C0814a;
import s4.C0816c;
import t4.C0829a;
import u4.C0844a;
import v4.C0858a;
import w3.AbstractC0904w;
import w3.C0896n;
import w3.W;
import w4.C0910c;
import x4.C0926a;
import y4.C0938b;

/* JADX INFO: renamed from: a.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0132a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Z0.a f1522a;

    public static byte[] A(short[][][] sArr, boolean z6) {
        int length = sArr.length;
        short[][] sArr2 = sArr[0];
        int length2 = sArr2.length;
        int length3 = sArr2[0].length;
        byte[] bArr = new byte[z6 ? (((length2 + 1) * length2) / 2) * length : length * length2 * length3];
        int i = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length3; i4++) {
                for (short[][] sArr3 : sArr) {
                    if (!z6 || i3 <= i4) {
                        bArr[i] = (byte) sArr3[i3][i4];
                        i++;
                    }
                }
            }
        }
        return bArr;
    }

    public static byte[] B(Q3.a aVar, AbstractC0904w abstractC0904w) {
        if (!aVar.f1235a) {
            throw new IllegalArgumentException("public key found");
        }
        try {
            return AbstractC0246d.y(aVar, abstractC0904w).a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] C(Q3.a aVar) {
        if (aVar.f1235a) {
            throw new IllegalArgumentException("private key found");
        }
        try {
            return r(aVar).a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object D(AbstractC0612m abstractC0612m, o extension) {
        h.f(abstractC0612m, "<this>");
        h.f(extension, "extension");
        if (abstractC0612m.e(extension)) {
            return abstractC0612m.d(extension);
        }
        return null;
    }

    public static final Object E(AbstractC0612m abstractC0612m, o extension, int i) {
        h.f(abstractC0612m, "<this>");
        h.f(extension, "extension");
        abstractC0612m.h(extension);
        C0609j c0609j = abstractC0612m.f3870a;
        c0609j.getClass();
        C0613n c0613n = extension.d;
        if (!c0613n.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        A a6 = c0609j.f3868a;
        Object obj = a6.get(c0613n);
        if (i >= (obj == null ? 0 : ((List) obj).size())) {
            return null;
        }
        abstractC0612m.h(extension);
        if (!c0613n.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj2 = a6.get(c0613n);
        if (obj2 != null) {
            return extension.a(((List) obj2).get(i));
        }
        throw new IndexOutOfBoundsException();
    }

    public static boolean F(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
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

    public static final IndexOutOfBoundsException H(int i, int i3) {
        return new IndexOutOfBoundsException("0 (offset) + " + i + " (length) > " + i3 + " (array.length)");
    }

    public static final boolean I(AbstractC0162z abstractC0162z) {
        h.f(abstractC0162z, "<this>");
        return abstractC0162z.f() instanceof AbstractC0155s;
    }

    public static boolean J(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean K(long[] jArr) {
        for (int i = 0; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static String L(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static j M(Function0 initializer) {
        h.f(initializer, "initializer");
        return new j(initializer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Lazy N(int i, Function0 initializer) {
        com.google.protobuf.a.p(i, "mode");
        h.f(initializer, "initializer");
        int iB = s.b(i);
        if (iB == 0) {
            return new j(initializer);
        }
        l lVar = l.f1128a;
        if (iB == 1) {
            i iVar = new i();
            iVar.f1125a = (kotlin.jvm.internal.i) initializer;
            iVar.b = lVar;
            return iVar;
        }
        if (iB != 2) {
            throw new x();
        }
        n nVar = new n();
        nVar.f1130a = (kotlin.jvm.internal.i) initializer;
        nVar.b = lVar;
        return nVar;
    }

    public static int O(short[][] sArr, byte[] bArr, int i) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                sArr[i4][i3] = (short) (bArr[(i3 * length) + i + i4] & 255);
            }
        }
        return length * length2;
    }

    public static int P(short[][][] sArr, byte[] bArr, int i, boolean z6) {
        short[][] sArr2 = sArr[0];
        int length = sArr2.length;
        int length2 = sArr2[0].length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < length2; i5++) {
                for (short[][] sArr3 : sArr) {
                    if (!z6 || i4 <= i5) {
                        sArr3[i4][i5] = (short) (bArr[i3 + i] & 255);
                        i3++;
                    }
                }
            }
        }
        return i3;
    }

    public static final F Q(AbstractC0162z abstractC0162z) {
        h.f(abstractC0162z, "<this>");
        c0 c0VarF = abstractC0162z.f();
        if (c0VarF instanceof AbstractC0155s) {
            return ((AbstractC0155s) c0VarF).b;
        }
        if (c0VarF instanceof F) {
            return (F) c0VarF;
        }
        throw new x();
    }

    public static int R(byte[] bArr) {
        if (bArr.length != 8 || bArr[0] != 100 || bArr[1] != 101 || bArr[2] != 120 || bArr[3] != 10 || bArr[7] != 0) {
            return -1;
        }
        String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
        if (str.equals("035")) {
            return 13;
        }
        if (str.equals("037")) {
            return 24;
        }
        if (str.equals("038")) {
            return 26;
        }
        if (str.equals("039")) {
            return 28;
        }
        if (str.equals("040")) {
            return 10000;
        }
        return str.equals("039") ? 28 : -1;
    }

    public static final void S(int i) {
        throw new IllegalArgumentException("Malformed code-point " + Integer.toHexString(i) + " found");
    }

    public static void U(int[] iArr, int[] iArr2, int[] iArr3) {
        long j6 = ((long) iArr2[0]) & 4294967295L;
        long j7 = ((long) iArr2[1]) & 4294967295L;
        long j8 = ((long) iArr2[2]) & 4294967295L;
        long j9 = ((long) iArr2[3]) & 4294967295L;
        long j10 = ((long) iArr2[4]) & 4294967295L;
        long j11 = ((long) iArr2[5]) & 4294967295L;
        int i = 1;
        long j12 = ((long) iArr[0]) & 4294967295L;
        long j13 = j12 * j6;
        iArr3[0] = (int) j13;
        long j14 = (j12 * j7) + (j13 >>> 32);
        iArr3[1] = (int) j14;
        long j15 = (j12 * j8) + (j14 >>> 32);
        iArr3[2] = (int) j15;
        long j16 = (j12 * j9) + (j15 >>> 32);
        iArr3[3] = (int) j16;
        long j17 = (j12 * j10) + (j16 >>> 32);
        iArr3[4] = (int) j17;
        long j18 = (j12 * j11) + (j17 >>> 32);
        iArr3[5] = (int) j18;
        int i3 = 6;
        iArr3[6] = (int) (j18 >>> 32);
        while (true) {
            int i4 = i;
            if (i4 >= i3) {
                return;
            }
            long j19 = ((long) iArr[i4]) & 4294967295L;
            long j20 = (j19 * j6) + (((long) iArr3[i4]) & 4294967295L);
            iArr3[i4] = (int) j20;
            i = i4 + 1;
            long j21 = j10;
            long j22 = (j19 * j7) + (((long) iArr3[i]) & 4294967295L) + (j20 >>> 32);
            iArr3[i] = (int) j22;
            int i5 = i4 + 2;
            long j23 = (j19 * j8) + (((long) iArr3[i5]) & 4294967295L) + (j22 >>> 32);
            iArr3[i5] = (int) j23;
            int i6 = i4 + 3;
            long j24 = (j19 * j9) + (((long) iArr3[i6]) & 4294967295L) + (j23 >>> 32);
            iArr3[i6] = (int) j24;
            int i7 = i4 + 4;
            long j25 = (j19 * j21) + (((long) iArr3[i7]) & 4294967295L) + (j24 >>> 32);
            iArr3[i7] = (int) j25;
            int i8 = i4 + 5;
            long j26 = (j19 * j11) + (((long) iArr3[i8]) & 4294967295L) + (j25 >>> 32);
            iArr3[i8] = (int) j26;
            iArr3[i4 + 6] = (int) (j26 >>> 32);
            j10 = j21;
            i3 = 6;
        }
    }

    public static byte[] V(File file) {
        if (!file.exists()) {
            throw new RuntimeException(file + ": file not found");
        }
        if (!file.isFile()) {
            throw new RuntimeException(file + ": not a file");
        }
        if (!file.canRead()) {
            throw new RuntimeException(file + ": file not readable");
        }
        long length = file.length();
        int i = (int) length;
        if (i != length) {
            throw new RuntimeException(file + ": file too long");
        }
        byte[] bArr = new byte[i];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i3 = 0;
            while (i > 0) {
                int i4 = fileInputStream.read(bArr, i3, i);
                if (i4 == -1) {
                    throw new RuntimeException(file + ": unexpected EOF");
                }
                i3 += i4;
                i -= i4;
            }
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(file + ": trouble reading", e);
        }
    }

    public static final void W(b bVar, byte[] bArr, int i, int i3) throws EOFException {
        int i4 = bVar.b;
        if (bVar.c - i4 < i3) {
            throw new EOFException("Not enough bytes to read a byte array of size " + i3 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        ByteBuffer copyTo = bVar.f750a;
        h.f(copyTo, "$this$copyTo");
        if (!copyTo.hasArray() || copyTo.isReadOnly()) {
            copyTo.duplicate().get(bArr, i, i3);
        } else {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i4, bArr, i, i3);
        }
        bVar.c(i3);
    }

    public static final F X(F f6, List newArguments, M newAttributes) {
        h.f(f6, "<this>");
        h.f(newArguments, "newArguments");
        h.f(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == f6.b()) {
            return f6;
        }
        if (newArguments.isEmpty()) {
            return f6.i(newAttributes);
        }
        if (!(f6 instanceof g)) {
            return C.c(newAttributes, newArguments, f6.c(), f6.d());
        }
        g gVar = (g) f6;
        String[] strArr = gVar.f1751g;
        return new g(gVar.b, gVar.c, gVar.d, newArguments, gVar.f1750f, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static AbstractC0162z Y(AbstractC0162z abstractC0162z, List list, Annotations annotations, int i) {
        if ((i & 2) != 0) {
            annotations = abstractC0162z.getAnnotations();
        }
        h.f(abstractC0162z, "<this>");
        if ((list.isEmpty() || list == abstractC0162z.a()) && annotations == abstractC0162z.getAnnotations()) {
            return abstractC0162z;
        }
        M mB = abstractC0162z.b();
        if ((annotations instanceof o2.j) && annotations.isEmpty()) {
            Annotations.Companion.getClass();
            annotations = f.b;
        }
        M mV0 = AbstractC0246d.v0(mB, annotations);
        c0 c0VarF = abstractC0162z.f();
        if (c0VarF instanceof AbstractC0155s) {
            AbstractC0155s abstractC0155s = (AbstractC0155s) c0VarF;
            return C.a(X(abstractC0155s.b, list, mV0), X(abstractC0155s.c, list, mV0));
        }
        if (c0VarF instanceof F) {
            return X((F) c0VarF, list, mV0);
        }
        throw new x();
    }

    public static /* synthetic */ F Z(F f6, List list, M m6, int i) {
        if ((i & 1) != 0) {
            list = f6.a();
        }
        if ((i & 2) != 0) {
            m6 = f6.b();
        }
        return X(f6, list, m6);
    }

    public static String a(char c) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a3.AbstractC0162z a0(a3.AbstractC0162z r9, java.util.ArrayList r10) {
        /*
            java.util.List r0 = r9.a()
            r0.size()
            r10.size()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = kotlin.collections.o.D(r10)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
        L17:
            boolean r1 = r10.hasNext()
            r2 = 0
            if (r1 == 0) goto L95
            java.lang.Object r1 = r10.next()
            f3.d r1 = (f3.d) r1
            r1.getClass()
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r3 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
            a3.z r4 = r1.b
            a3.z r5 = r1.c
            r3.isSubtypeOf(r4, r5)
            boolean r3 = kotlin.jvm.internal.h.a(r4, r5)
            if (r3 != 0) goto L8c
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r1 = r1.f3195a
            a3.d0 r3 = r1.getVariance()
            a3.d0 r6 = a3.d0.IN_VARIANCE
            if (r3 != r6) goto L41
            goto L8c
        L41:
            boolean r3 = k2.i.D(r4)
            a3.d0 r7 = a3.d0.OUT_VARIANCE
            a3.d0 r8 = a3.d0.INVARIANT
            if (r3 == 0) goto L5e
            a3.d0 r3 = r1.getVariance()
            if (r3 == r6) goto L5e
            a3.K r2 = new a3.K
            a3.d0 r1 = r1.getVariance()
            if (r7 != r1) goto L5a
            r7 = r8
        L5a:
            r2.<init>(r5, r7)
            goto L91
        L5e:
            if (r5 == 0) goto L86
            boolean r2 = k2.i.w(r5)
            if (r2 == 0) goto L79
            boolean r2 = r5.d()
            if (r2 == 0) goto L79
            a3.K r2 = new a3.K
            a3.d0 r1 = r1.getVariance()
            if (r6 != r1) goto L75
            r6 = r8
        L75:
            r2.<init>(r4, r6)
            goto L91
        L79:
            a3.K r2 = new a3.K
            a3.d0 r1 = r1.getVariance()
            if (r7 != r1) goto L82
            r7 = r8
        L82:
            r2.<init>(r5, r7)
            goto L91
        L86:
            r9 = 140(0x8c, float:1.96E-43)
            k2.i.a(r9)
            throw r2
        L8c:
            a3.K r2 = new a3.K
            r2.<init>(r4)
        L91:
            r0.add(r2)
            goto L17
        L95:
            r10 = 6
            a3.z r9 = Y(r9, r0, r2, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0132a.a0(a3.z, java.util.ArrayList):a3.z");
    }

    public static final void b(Throwable th) throws Throwable {
        Throwable thB;
        try {
            thB = j0.b(th, th);
        } catch (Throwable unused) {
            thB = null;
        }
        if (thB != null) {
            throw thB;
        }
    }

    public static final boolean b0(AbstractC0162z abstractC0162z) {
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (declarationDescriptor != null && N2.i.b(declarationDescriptor) && !e.g((ClassDescriptor) declarationDescriptor).equals(p.f3764g)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor2 = abstractC0162z.c().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor2 instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor2 : null;
        return typeParameterDescriptor == null ? false : b0(AbstractC0246d.R(typeParameterDescriptor));
    }

    public static int c(int[] iArr, int[] iArr2, int[] iArr3) {
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
        return (int) (j11 >>> 32);
    }

    public static final void c0(Object[] objArr, int i, int i3) {
        h.f(objArr, "<this>");
        while (i < i3) {
            objArr[i] = null;
            i++;
        }
    }

    public static int d(int i, int i3, int[] iArr, int[] iArr2, int i4) {
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
        long j11 = (((long) iArr[i + 5]) & 4294967295L) + (4294967295L & ((long) iArr2[i9])) + (j10 >>> 32);
        iArr2[i9] = (int) j11;
        return (int) (j11 >>> 32);
    }

    public static void d0(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[0]) & 4294967295L;
        int i = 12;
        int i3 = 0;
        int i4 = 5;
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
                long j30 = j27 & 4294967295L;
                long j31 = (j26 * j6) + (jE2 & 4294967295L);
                int i11 = (int) j31;
                iArr2[4] = i10 | (i11 << 1);
                int i12 = i11 >>> 31;
                long jE4 = androidx.constraintlayout.core.motion.a.e(j26, j11, j31 >>> 32, jE3 & 4294967295L);
                long jE5 = androidx.constraintlayout.core.motion.a.e(j26, j14, jE4 >>> 32, j28);
                long jE6 = androidx.constraintlayout.core.motion.a.e(j26, j19, jE5 >>> 32, j30);
                long j32 = j29 + (jE6 >>> 32);
                long j33 = ((long) iArr[5]) & 4294967295L;
                long j34 = (((long) iArr2[9]) & 4294967295L) + (j32 >>> 32);
                long j35 = j32 & 4294967295L;
                long j36 = (((long) iArr2[10]) & 4294967295L) + (j34 >>> 32);
                long j37 = j34 & 4294967295L;
                long j38 = (j33 * j6) + (jE4 & 4294967295L);
                int i13 = (int) j38;
                iArr2[5] = i12 | (i13 << 1);
                int i14 = i13 >>> 31;
                long jE7 = androidx.constraintlayout.core.motion.a.e(j33, j11, j38 >>> 32, jE5 & 4294967295L);
                long jE8 = androidx.constraintlayout.core.motion.a.e(j33, j14, jE7 >>> 32, jE6 & 4294967295L);
                long jE9 = androidx.constraintlayout.core.motion.a.e(j33, j19, jE8 >>> 32, j35);
                long jE10 = androidx.constraintlayout.core.motion.a.e(j33, j26, jE9 >>> 32, j37);
                long j39 = j36 + (jE10 >>> 32);
                int i15 = (int) jE7;
                iArr2[6] = (i15 << 1) | i14;
                int i16 = (int) jE8;
                iArr2[7] = (i15 >>> 31) | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) jE9;
                iArr2[8] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) jE10;
                iArr2[9] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j39;
                iArr2[10] = i21 | (i22 << 1);
                iArr2[11] = ((iArr2[11] + ((int) (j39 >>> 32))) << 1) | (i22 >>> 31);
                return;
            }
            i4 = i5;
        }
    }

    public static int e(int[] iArr, int[] iArr2) {
        long j6 = (((long) iArr[6]) & 4294967295L) + (((long) iArr2[12]) & 4294967295L);
        int i = (int) j6;
        iArr[6] = i;
        iArr2[12] = i;
        long j7 = (((long) iArr[7]) & 4294967295L) + (((long) iArr2[13]) & 4294967295L) + (j6 >>> 32);
        int i3 = (int) j7;
        iArr[7] = i3;
        iArr2[13] = i3;
        long j8 = (((long) iArr[8]) & 4294967295L) + (((long) iArr2[14]) & 4294967295L) + (j7 >>> 32);
        int i4 = (int) j8;
        iArr[8] = i4;
        iArr2[14] = i4;
        long j9 = (((long) iArr[9]) & 4294967295L) + (((long) iArr2[15]) & 4294967295L) + (j8 >>> 32);
        int i5 = (int) j9;
        iArr[9] = i5;
        iArr2[15] = i5;
        long j10 = (((long) iArr[10]) & 4294967295L) + (((long) iArr2[16]) & 4294967295L) + (j9 >>> 32);
        int i6 = (int) j10;
        iArr[10] = i6;
        iArr2[16] = i6;
        long j11 = (((long) iArr[11]) & 4294967295L) + (4294967295L & ((long) iArr2[17])) + (j10 >>> 32);
        int i7 = (int) j11;
        iArr[11] = i7;
        iArr2[17] = i7;
        return (int) (j11 >>> 32);
    }

    public static void e0(int[] iArr, int i, int[] iArr2, int i3, int[] iArr3) {
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
        iArr3[5] = (int) (((((long) iArr[i + 5]) & 4294967295L) - (((long) iArr2[i3 + 5]) & 4294967295L)) + (j10 >> 32));
    }

    public static String f(int i) {
        String str = "039";
        if (i < 28) {
            if (i >= 10000) {
                str = "040";
            } else if (i < 28) {
                str = i >= 26 ? "038" : i >= 24 ? "037" : "035";
            }
        }
        return androidx.constraintlayout.core.motion.a.q("dex\n", str, "\u0000");
    }

    public static void f0(int[] iArr, int[] iArr2) {
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
        iArr2[5] = (int) (((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5]))) + (j10 >> 32));
    }

    public static final C0442a g(AbstractC0162z type) {
        Object objA0;
        d dVar;
        h.f(type, "type");
        if (I(type)) {
            C0442a c0442aG = g(Q(type));
            C0442a c0442aG2 = g(j0(type));
            return new C0442a(kotlin.reflect.l.M(C.a(Q((AbstractC0162z) c0442aG.f3193a), j0((AbstractC0162z) c0442aG2.f3193a)), type), kotlin.reflect.l.M(C.a(Q((AbstractC0162z) c0442aG.b), j0((AbstractC0162z) c0442aG2.b)), type));
        }
        TypeConstructor typeConstructorC = type.c();
        boolean z6 = true;
        if (type.c() instanceof CapturedTypeConstructor) {
            h.d(typeConstructorC, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            TypeProjection projection = ((CapturedTypeConstructor) typeConstructorC).getProjection();
            AbstractC0162z type2 = projection.getType();
            h.e(type2, "typeProjection.type");
            AbstractC0162z abstractC0162zI = b0.i(type2, type.d());
            h.e(abstractC0162zI, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            int iOrdinal = projection.getProjectionKind().ordinal();
            if (iOrdinal == 1) {
                return new C0442a(abstractC0162zI, AbstractC0246d.O(type).n());
            }
            if (iOrdinal != 2) {
                throw new AssertionError("Only nontrivial projections should have been captured, not: " + projection);
            }
            F fM = AbstractC0246d.O(type).m();
            h.e(fM, "type.builtIns.nothingType");
            AbstractC0162z abstractC0162zI2 = b0.i(fM, type.d());
            h.e(abstractC0162zI2, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            return new C0442a(abstractC0162zI2, abstractC0162zI);
        }
        if (type.a().isEmpty() || type.a().size() != typeConstructorC.getParameters().size()) {
            return new C0442a(type, type);
        }
        ArrayList<d> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listA = type.a();
        List<TypeParameterDescriptor> parameters = typeConstructorC.getParameters();
        h.e(parameters, "typeConstructor.parameters");
        for (N1.e eVar : m.u0(listA, parameters)) {
            TypeProjection typeProjection = (TypeProjection) eVar.f1121a;
            TypeParameterDescriptor typeParameter = (TypeParameterDescriptor) eVar.b;
            h.e(typeParameter, "typeParameter");
            d0 variance = typeParameter.getVariance();
            if (variance == null) {
                Z.a(35);
                throw null;
            }
            if (typeProjection == null) {
                Z.a(36);
                throw null;
            }
            Z z7 = Z.b;
            int iOrdinal2 = (typeProjection.isStarProjection() ? d0.OUT_VARIANCE : Z.b(variance, typeProjection.getProjectionKind())).ordinal();
            if (iOrdinal2 == 0) {
                AbstractC0162z type3 = typeProjection.getType();
                h.e(type3, "type");
                AbstractC0162z type4 = typeProjection.getType();
                h.e(type4, "type");
                dVar = new d(typeParameter, type3, type4);
            } else if (iOrdinal2 == 1) {
                AbstractC0162z type5 = typeProjection.getType();
                h.e(type5, "type");
                dVar = new d(typeParameter, type5, e.e(typeParameter).n());
            } else {
                if (iOrdinal2 != 2) {
                    throw new x();
                }
                F fM2 = e.e(typeParameter).m();
                h.e(fM2, "typeParameter.builtIns.nothingType");
                AbstractC0162z type6 = typeProjection.getType();
                h.e(type6, "type");
                dVar = new d(typeParameter, fM2, type6);
            }
            if (typeProjection.isStarProjection()) {
                arrayList.add(dVar);
                arrayList2.add(dVar);
            } else {
                C0442a c0442aG3 = g(dVar.b);
                AbstractC0162z abstractC0162z = (AbstractC0162z) c0442aG3.f3193a;
                AbstractC0162z abstractC0162z2 = (AbstractC0162z) c0442aG3.b;
                C0442a c0442aG4 = g(dVar.c);
                AbstractC0162z abstractC0162z3 = (AbstractC0162z) c0442aG4.f3193a;
                AbstractC0162z abstractC0162z4 = (AbstractC0162z) c0442aG4.b;
                TypeParameterDescriptor typeParameterDescriptor = dVar.f3195a;
                d dVar2 = new d(typeParameterDescriptor, abstractC0162z2, abstractC0162z3);
                d dVar3 = new d(typeParameterDescriptor, abstractC0162z, abstractC0162z4);
                arrayList.add(dVar2);
                arrayList2.add(dVar3);
            }
        }
        if (arrayList.isEmpty()) {
            z6 = false;
        } else {
            for (d dVar4 : arrayList) {
                dVar4.getClass();
                if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(dVar4.b, dVar4.c)) {
                    break;
                }
            }
            z6 = false;
        }
        if (z6) {
            objA0 = AbstractC0246d.O(type).m();
            h.e(objA0, "type.builtIns.nothingType");
        } else {
            objA0 = a0(type, arrayList);
        }
        return new C0442a(objA0, a0(type, arrayList2));
    }

    public static BigInteger g0(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 6; i++) {
            int i3 = iArr[i];
            if (i3 != 0) {
                c.o(bArr, i3, (5 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static final F h(AbstractC0162z abstractC0162z) {
        h.f(abstractC0162z, "<this>");
        c0 c0VarF = abstractC0162z.f();
        F f6 = c0VarF instanceof F ? (F) c0VarF : null;
        if (f6 != null) {
            return f6;
        }
        throw new IllegalStateException(("This is should be simple type: " + abstractC0162z).toString());
    }

    public static BigInteger h0(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 3; i++) {
            long j6 = jArr[i];
            if (j6 != 0) {
                c.t(bArr, (2 - i) << 3, j6);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int i(int i, int i3, int i4) {
        int i5 = i3 & ((i >>> i4) ^ i);
        return i ^ (i5 ^ (i5 << i4));
    }

    public static final void i0(byte b) {
        Object objSubSequence;
        StringBuilder sb = new StringBuilder("Unsupported byte code, first byte is 0x");
        q.c(16);
        String string = Integer.toString(b & 255, 16);
        h.e(string, "toString(this, checkRadix(radix))");
        if (2 > string.length()) {
            StringBuilder sb2 = new StringBuilder(2);
            C0429e c0429eA = new C0430f(1, 2 - string.length(), 1).iterator();
            while (c0429eA.c) {
                c0429eA.nextInt();
                sb2.append('0');
            }
            sb2.append((CharSequence) string);
            objSubSequence = sb2;
        } else {
            objSubSequence = string.subSequence(0, string.length());
        }
        sb.append(objSubSequence.toString());
        throw new IllegalStateException(sb.toString().toString());
    }

    public static long j(int i, long j6, long j7) {
        long j8 = j7 & ((j6 >>> i) ^ j6);
        return (j8 ^ (j8 << i)) ^ j6;
    }

    public static final F j0(AbstractC0162z abstractC0162z) {
        h.f(abstractC0162z, "<this>");
        c0 c0VarF = abstractC0162z.f();
        if (c0VarF instanceof AbstractC0155s) {
            return ((AbstractC0155s) c0VarF).c;
        }
        if (c0VarF instanceof F) {
            return (F) c0VarF;
        }
        throw new x();
    }

    public static BigInteger k(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        boolean z6 = bigInteger2.signum() < 0;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2.abs());
        boolean zTestBit = bigIntegerMultiply.testBit(i - 1);
        BigInteger bigIntegerShiftRight = bigIntegerMultiply.shiftRight(i);
        if (zTestBit) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(ECConstants.ONE);
        }
        return z6 ? bigIntegerShiftRight.negate() : bigIntegerShiftRight;
    }

    public static void k0(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        parcel.writeBundle(bundle);
        t0(parcel, iS0);
    }

    public static void l(String str, int i, int i3, boolean z6) {
        if (z6) {
            return;
        }
        StringBuilder sb = new StringBuilder("overflow: ");
        sb.append(str);
        sb.append("(");
        sb.append(i);
        sb.append(", ");
        throw new ArithmeticException(B2.b.g(sb, ")", i3));
    }

    public static void l0(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        parcel.writeStrongBinder(iBinder);
        t0(parcel, iS0);
    }

    public static void m(boolean z6, String str, long j6, long j7) {
        if (z6) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j6 + ", " + j7 + ")");
    }

    public static void m0(Parcel parcel, int i, Parcelable parcelable, int i3) {
        if (parcelable == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        parcelable.writeToParcel(parcel, i3);
        t0(parcel, iS0);
    }

    public static short[][] n(short[][] sArr) {
        short[][] sArr2 = new short[sArr.length][];
        for (int i = 0; i < sArr.length; i++) {
            sArr2[i] = c.d(sArr[i]);
        }
        return sArr2;
    }

    public static void n0(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        parcel.writeString(str);
        t0(parcel, iS0);
    }

    public static short[][][] o(short[][][] sArr) {
        short[][][] sArr2 = (short[][][]) Array.newInstance((Class<?>) short[].class, sArr.length, sArr[0].length);
        for (int i = 0; i < sArr.length; i++) {
            for (int i3 = 0; i3 < sArr[0].length; i3++) {
                sArr2[i][i3] = c.d(sArr[i][i3]);
            }
        }
        return sArr2;
    }

    public static void o0(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        parcel.writeStringList(list);
        t0(parcel, iS0);
    }

    public static Object[] p(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static void p0(StringBuilder sb, HashMap map) {
        sb.append("{");
        boolean z6 = true;
        for (String str : map.keySet()) {
            if (!z6) {
                sb.append(",");
            }
            String str2 = (String) map.get(str);
            B2.b.r(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                B2.b.r(sb, "\"", str2, "\"");
            }
            z6 = false;
        }
        sb.append("}");
    }

    public static final Object q(Class annotationClass, Map map, List methods) {
        h.f(annotationClass, "annotationClass");
        h.f(methods, "methods");
        j jVarM = M(new C0022d(map, 20));
        Object objNewProxyInstance = Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new C0529b(annotationClass, map, M(new y(7, annotationClass, map)), jVarM, methods));
        h.d(objNewProxyInstance, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return objNewProxyInstance;
    }

    public static void q0(Parcel parcel, int i, Parcelable[] parcelableArr, int i3) {
        if (parcelableArr == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i3);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        t0(parcel, iS0);
    }

    public static H3.d r(Q3.a aVar) throws IOException {
        if (aVar instanceof e5.b) {
            e5.b bVar = (e5.b) aVar;
            return new H3.d(I4.c.f(bVar.b), c.c(bVar.c));
        }
        if (aVar instanceof H4.c) {
            H4.c cVar = (H4.c) aVar;
            return new H3.d(new H3.a(PQCObjectIdentifiers.sphincs256, new o4.g(I4.c.g(cVar.b))), c.c(cVar.c));
        }
        if (aVar instanceof A4.b) {
            return new H3.d(new H3.a(PQCObjectIdentifiers.newHope), c.c(((A4.b) aVar).b));
        }
        if (aVar instanceof w4.m) {
            w4.m mVar = (w4.m) aVar;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write((byte) 0);
            byteArrayOutputStream.write((byte) 0);
            byteArrayOutputStream.write((byte) 0);
            byteArrayOutputStream.write((byte) 1);
            try {
                byteArrayOutputStream.write(mVar.toByteArray());
                return new H3.d(new H3.a(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), byteArrayOutputStream.toByteArray());
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        if (aVar instanceof C0910c) {
            C0910c c0910c = (C0910c) aVar;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            int i = c0910c.b;
            byteArrayOutputStream2.write((byte) (i >>> 24));
            byteArrayOutputStream2.write((byte) (i >>> 16));
            byteArrayOutputStream2.write((byte) (i >>> 8));
            byteArrayOutputStream2.write((byte) i);
            try {
                byteArrayOutputStream2.write(c0910c.c.toByteArray());
                return new H3.d(new H3.a(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), byteArrayOutputStream2.toByteArray());
            } catch (Exception e6) {
                throw new RuntimeException(e6.getMessage(), e6);
            }
        }
        if (aVar instanceof org.bouncycastle.pqc.crypto.slhdsa.g) {
            org.bouncycastle.pqc.crypto.slhdsa.g gVar = (org.bouncycastle.pqc.crypto.slhdsa.g) aVar;
            h5.c cVar2 = gVar.c;
            return new H3.d(new H3.a((C0896n) I4.c.f804N.get((org.bouncycastle.pqc.crypto.slhdsa.e) gVar.b)), c.e(cVar2.f3460a, cVar2.b));
        }
        if (aVar instanceof org.bouncycastle.pqc.crypto.sphincsplus.g) {
            org.bouncycastle.pqc.crypto.sphincsplus.g gVar2 = (org.bouncycastle.pqc.crypto.sphincsplus.g) aVar;
            h5.c cVar3 = gVar2.c;
            return new H3.d(new H3.a((C0896n) I4.c.f819r.get((org.bouncycastle.pqc.crypto.sphincsplus.e) gVar2.b)), c.e(cVar3.f3460a, cVar3.b));
        }
        if (aVar instanceof r4.d) {
            r4.d dVar = (r4.d) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f818p.get((C0806b) dVar.b)), c.c(dVar.c));
        }
        if (aVar instanceof w) {
            w wVar = (w) aVar;
            byte[] bArrJ = C5.f.j(wVar.f917f);
            byte[] bArrJ2 = C5.f.j(wVar.e);
            byte[] byteArray = wVar.toByteArray();
            return byteArray.length > bArrJ.length + bArrJ2.length ? new H3.d(new H3.a(IsaraObjectIdentifiers.id_alg_xmss), new W(byteArray)) : new H3.d(new H3.a(PQCObjectIdentifiers.xmss, new o4.j(wVar.c.b, I4.c.i(wVar.b))), new o4.o(bArrJ, bArrJ2));
        }
        if (aVar instanceof r) {
            r rVar = (r) aVar;
            byte[] bArrJ3 = C5.f.j(rVar.f904f);
            byte[] bArr = rVar.e;
            byte[] bArrJ4 = C5.f.j(bArr);
            byte[] byteArray2 = rVar.toByteArray();
            if (byteArray2.length > bArrJ3.length + bArrJ4.length) {
                return new H3.d(new H3.a(IsaraObjectIdentifiers.id_alg_xmssmt), new W(byteArray2));
            }
            C0896n c0896n = PQCObjectIdentifiers.xmss_mt;
            J4.o oVar = rVar.c;
            return new H3.d(new H3.a(c0896n, new k(oVar.c, I4.c.i(rVar.b), oVar.d)), new o4.m(C5.f.j(rVar.f904f), C5.f.j(bArr)));
        }
        if (aVar instanceof d5.b) {
            d5.b bVar2 = (d5.b) aVar;
            return new H3.d(new H3.a(PQCObjectIdentifiers.mcElieceCca2), new o4.f(bVar2.c, bVar2.d, bVar2.e, I4.c.a(bVar2.b)));
        }
        if (aVar instanceof u4.c) {
            u4.c cVar4 = (u4.c) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f814l.get((C0844a) cVar4.b)), new W(c.c(cVar4.c)));
        }
        if (aVar instanceof F4.c) {
            F4.c cVar5 = (F4.c) aVar;
            byte[] bArrC = c.c(cVar5.c);
            H3.a aVar2 = new H3.a((C0896n) I4.c.f816n.get((F4.a) cVar5.b));
            w3.Z z6 = new w3.Z(new W(bArrC), 0);
            z6.d = -1;
            return new H3.d(aVar2, z6);
        }
        if (aVar instanceof D4.c) {
            D4.c cVar6 = (D4.c) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f812j.get((D4.a) cVar6.b)), new W(c.c(cVar6.c)));
        }
        if (aVar instanceof B4.d) {
            B4.d dVar2 = (B4.d) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f821t.get((B4.b) dVar2.b)), c.c(dVar2.c));
        }
        if (aVar instanceof t4.c) {
            t4.c cVar7 = (t4.c) aVar;
            byte[] bArrC2 = c.c(cVar7.c);
            HashMap map = I4.c.f822v;
            C0829a c0829a = (C0829a) cVar7.b;
            H3.a aVar3 = new H3.a((C0896n) map.get(c0829a));
            byte[] bArr2 = new byte[bArrC2.length + 1];
            bArr2[0] = (byte) c0829a.b;
            System.arraycopy(bArrC2, 0, bArr2, 1, bArrC2.length);
            return new H3.d(aVar3, bArr2);
        }
        if (aVar instanceof z4.e) {
            z4.e eVar = (z4.e) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.J.get((z4.c) eVar.b)), eVar.getEncoded());
        }
        if (aVar instanceof C4.c) {
            C4.c cVar8 = (C4.c) aVar;
            byte[] bArr3 = new byte[((C4.a) cVar8.b).f170a];
            byte[] bArr4 = cVar8.c;
            System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
            int length = bArr4.length;
            byte[] bArr5 = cVar8.d;
            System.arraycopy(bArr5, 0, bArr3, length, bArr5.length);
            return new H3.d(new H3.a((C0896n) I4.c.x.get((C4.a) cVar8.b)), new W(bArr3));
        }
        if (aVar instanceof C4.f) {
            C4.f fVar = (C4.f) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f824z.get((C4.d) fVar.b)), new W(c.c(fVar.c)));
        }
        if (aVar instanceof C0816c) {
            C0816c c0816c = (C0816c) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f797B.get((C0814a) c0816c.b)), c.e(c0816c.c, c0816c.d));
        }
        if (aVar instanceof y4.d) {
            y4.d dVar3 = (y4.d) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f802L.get((C0938b) dVar3.b)), c.e(dVar3.c, dVar3.d));
        }
        if (aVar instanceof C0791c) {
            C0791c c0791c = (C0791c) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f798D.get((C0789a) c0791c.b)), c.c(c0791c.c));
        }
        if (aVar instanceof v4.c) {
            v4.c cVar9 = (v4.c) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f799F.get((C0858a) cVar9.b)), c.c(cVar9.c));
        }
        if (aVar instanceof E4.e) {
            E4.e eVar2 = (E4.e) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.H.get((E4.c) eVar2.b)), new W(((E4.c) eVar2.b).f329g != 1 ? c.e(c.e(c.e(c.e(c.e(eVar2.d, A(eVar2.e, false)), A(eVar2.f340f, true)), A(eVar2.f341g, false)), A(eVar2.f342h, true)), A(eVar2.i, true)) : A(eVar2.c, true)));
        }
        if (aVar instanceof x4.c) {
            x4.c cVar10 = (x4.c) aVar;
            return new H3.d(new H3.a((C0896n) I4.c.f806P.get((C0926a) cVar10.b)), new W(c.c(cVar10.c)));
        }
        if (!(aVar instanceof G4.c)) {
            throw new IOException("key parameters not recognized");
        }
        G4.c cVar11 = (G4.c) aVar;
        return new H3.d(new H3.a((C0896n) I4.c.R.get(cVar11.c)), new W(c.c(cVar11.b)));
    }

    public static void r0(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iS0 = s0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcelable parcelable = (Parcelable) list.get(i3);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        t0(parcel, iS0);
    }

    public static final long s(int i, int i3) {
        return (((long) i3) & 4294967295L) | (((long) i) << 32);
    }

    public static int s0(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static boolean t(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z6;
        int i = 5;
        while (true) {
            z6 = true;
            if (i < 0) {
                break;
            }
            int i3 = iArr[6 + i] ^ Integer.MIN_VALUE;
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
            e0(iArr, 6, iArr2, 0, iArr3);
            return z6;
        }
        e0(iArr2, 0, iArr, 6, iArr3);
        return z6;
    }

    public static void t0(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static final KotlinJvmBinaryClass u(KotlinClassFinder kotlinClassFinder, L2.b bVar, K2.f jvmMetadataVersion) {
        h.f(kotlinClassFinder, "<this>");
        h.f(jvmMetadataVersion, "jvmMetadataVersion");
        E2.m mVarFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(bVar, jvmMetadataVersion);
        if (mVarFindKotlinClassOrContent != null) {
            E2.l lVar = mVarFindKotlinClassOrContent instanceof E2.l ? (E2.l) mVarFindKotlinClassOrContent : null;
            if (lVar != null) {
                return lVar.f308a;
            }
        }
        return null;
    }

    public static void u0(Parcel parcel, int i, int i3) {
        parcel.writeInt(i | (i3 << 16));
    }

    public static int[] v(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[6];
        for (int i = 0; i < 6; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static short[][][] w(E4.b bVar, int i, int i3, int i4, boolean z6) {
        byte[] bArr = new byte[z6 ? (((i3 + 1) * i3) / 2) * i : i * i3 * i4];
        bVar.nextBytes(bArr);
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, i, i3, i4);
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                for (int i8 = 0; i8 < i; i8++) {
                    if (!z6 || i6 <= i7) {
                        sArr[i8][i6][i7] = (short) (bArr[i5] & 255);
                        i5++;
                    }
                }
            }
        }
        return sArr;
    }

    public static short[][] x(E4.b bVar, int i, int i3) {
        byte[] bArr = new byte[i * i3];
        bVar.nextBytes(bArr);
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                sArr[i5][i4] = (short) (bArr[(i4 * i) + i5] & 255);
            }
        }
        return sArr;
    }

    public static Collection y(ResolutionScope resolutionScope, U2.f fVar, int i) {
        if ((i & 1) != 0) {
            fVar = U2.f.f1326m;
        }
        MemberScope.Companion.getClass();
        return resolutionScope.getContributedDescriptors(fVar, U2.l.b);
    }

    public static byte[] z(short[][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        byte[] bArr = new byte[length * length2];
        for (int i = 0; i < length2; i++) {
            for (int i3 = 0; i3 < length; i3++) {
                bArr[(i * length) + i3] = (byte) sArr[i3][i];
            }
        }
        return bArr;
    }

    public int G(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException(kotlin.reflect.l.e(i, length, "index"));
        }
        while (i < length) {
            if (T(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean T(char c);

    @Override // com.google.common.base.Predicate
    public boolean apply(Object obj) {
        return T(((Character) obj).charValue());
    }
}
