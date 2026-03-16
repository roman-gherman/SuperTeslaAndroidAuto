package kotlin.reflect;

import C0.t;
import C0.x;
import E2.p;
import G2.C0125z;
import G2.H;
import G2.U;
import G2.d0;
import J4.n;
import J4.s;
import a.AbstractC0132a;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C0157u;
import a3.F;
import a3.I;
import a3.O;
import a3.P;
import a3.Q;
import a3.c0;
import androidx.core.util.Pair;
import androidx.core.view.MotionEventCompat;
import c4.AbstractC0246d;
import com.android.billingclient.api.z;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import com.google.android.material.datepicker.L;
import e2.C0429e;
import e2.C0430f;
import h2.n0;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.o;
import kotlin.jvm.internal.KTypeBase;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.sequences.Sequence;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public l() {
        throw null;
    }

    public static String A(int i, String str) {
        StringBuilder sbL = B2.b.l(str, ".");
        sbL.append(Integer.toString(i));
        return sbL.toString();
    }

    public static String B(String str) {
        return B2.b.e(str, ".null");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String C(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.l.C(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String D(String str, String str2, int i, double d) {
        return str + "." + str2 + "." + Integer.toString(i) + "." + Double.toString(d);
    }

    public static String E(String str, String str2, int i, double d) {
        return str + "." + str2 + "." + Integer.toString(i) + "." + Double.toString(d);
    }

    public static final Type F(KType kType) {
        Type javaType;
        kotlin.jvm.internal.h.f(kType, "<this>");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? k(kType, false) : javaType;
    }

    public static final Type G(d dVar) {
        e eVar = dVar.f3823a;
        if (eVar == null) {
            return m.c;
        }
        n0 n0Var = dVar.b;
        kotlin.jvm.internal.h.c(n0Var);
        int iOrdinal = eVar.ordinal();
        if (iOrdinal == 0) {
            return k(n0Var, true);
        }
        if (iOrdinal == 1) {
            return new m(null, k(n0Var, true));
        }
        if (iOrdinal == 2) {
            return new m(k(n0Var, true), null);
        }
        throw new x();
    }

    public static String H(long j6, Locale locale) {
        return L.b("MMMd", locale).format(new Date(j6));
    }

    public static final L2.f I(NameResolver nameResolver, int i) {
        kotlin.jvm.internal.h.f(nameResolver, "<this>");
        return L2.f.d(nameResolver.getString(i));
    }

    public static String J(long j6, Locale locale) {
        return L.b("yMMMd", locale).format(new Date(j6));
    }

    public static boolean K(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
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

    public static boolean L(Q q, SimpleTypeMarker type, P p5) {
        kotlin.jvm.internal.h.f(type, "type");
        ClassicTypeSystemContext classicTypeSystemContext = q.c;
        if ((classicTypeSystemContext.isClassType(type) && !classicTypeSystemContext.isMarkedNullable(type)) || classicTypeSystemContext.isDefinitelyNotNullType(type)) {
            return true;
        }
        q.b();
        ArrayDeque arrayDeque = q.f1538g;
        kotlin.jvm.internal.h.c(arrayDeque);
        j3.m mVar = q.f1539h;
        kotlin.jvm.internal.h.c(mVar);
        arrayDeque.push(type);
        while (!arrayDeque.isEmpty()) {
            if (mVar.b > 1000) {
                StringBuilder sbN = B2.b.n("Too many supertypes for type: ", type, ". Supertypes = ");
                sbN.append(kotlin.collections.m.V(mVar, null, null, null, null, 63));
                throw new IllegalStateException(sbN.toString().toString());
            }
            SimpleTypeMarker current = (SimpleTypeMarker) arrayDeque.pop();
            kotlin.jvm.internal.h.e(current, "current");
            if (mVar.add(current)) {
                boolean zIsMarkedNullable = classicTypeSystemContext.isMarkedNullable(current);
                O o6 = O.c;
                P p6 = zIsMarkedNullable ? o6 : p5;
                if (p6.equals(o6)) {
                    p6 = null;
                }
                if (p6 == null) {
                    continue;
                } else {
                    Iterator<KotlinTypeMarker> it = classicTypeSystemContext.supertypes(classicTypeSystemContext.typeConstructor(current)).iterator();
                    while (it.hasNext()) {
                        SimpleTypeMarker simpleTypeMarkerA = p6.a(q, it.next());
                        if ((classicTypeSystemContext.isClassType(simpleTypeMarkerA) && !classicTypeSystemContext.isMarkedNullable(simpleTypeMarkerA)) || classicTypeSystemContext.isDefinitelyNotNullType(simpleTypeMarkerA)) {
                            q.a();
                            return true;
                        }
                        arrayDeque.add(simpleTypeMarkerA);
                    }
                }
            }
        }
        q.a();
        return false;
    }

    public static final c0 M(c0 c0Var, AbstractC0162z origin) {
        kotlin.jvm.internal.h.f(c0Var, "<this>");
        kotlin.jvm.internal.h.f(origin, "origin");
        return k0(c0Var, z(origin));
    }

    public static boolean N(Q q, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        ClassicTypeSystemContext classicTypeSystemContext = q.c;
        if (classicTypeSystemContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (classicTypeSystemContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (q.b && classicTypeSystemContext.isStubType(simpleTypeMarker)) {
            return true;
        }
        return classicTypeSystemContext.areEqualTypeConstructors(classicTypeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
    }

    public static final boolean O(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        c0 c0VarF = abstractC0162z.f();
        if (c0VarF instanceof c3.g) {
            return true;
        }
        return (c0VarF instanceof AbstractC0155s) && (((AbstractC0155s) c0VarF).j() instanceof c3.g);
    }

    public static s P(t tVar, B.g gVar, J4.j jVar) {
        double d;
        int i;
        int i3;
        int i4;
        long j6;
        int i5;
        int iCeil = ((J4.m) tVar.b).c;
        byte[][] bArrK = C5.f.k((byte[][]) gVar.b);
        s[] sVarArr = new s[bArrK.length];
        for (int i6 = 0; i6 < bArrK.length; i6++) {
            sVarArr[i6] = new s(0, bArrK[i6]);
        }
        J4.i iVar = new J4.i(0);
        iVar.c = jVar.f895a;
        iVar.b = jVar.b;
        iVar.e = jVar.e;
        iVar.f887f = 0;
        iVar.f888g = jVar.f890g;
        iVar.d = jVar.d;
        J4.j jVar2 = new J4.j(iVar);
        while (iCeil > 1) {
            int i7 = 0;
            while (true) {
                d = iCeil / 2;
                int iFloor = (int) Math.floor(d);
                i = jVar2.d;
                i3 = jVar2.f889f;
                i4 = jVar2.e;
                j6 = jVar2.b;
                i5 = jVar2.f895a;
                if (i7 >= iFloor) {
                    break;
                }
                J4.i iVar2 = new J4.i(0);
                iVar2.c = i5;
                iVar2.b = j6;
                iVar2.e = i4;
                iVar2.f887f = i3;
                iVar2.f888g = i7;
                iVar2.d = i;
                J4.j jVar3 = new J4.j(iVar2);
                int i8 = i7 * 2;
                sVarArr[i7] = S(tVar, sVarArr[i8], sVarArr[i8 + 1], jVar3);
                i7++;
                jVar2 = jVar3;
            }
            if (iCeil % 2 == 1) {
                sVarArr[(int) Math.floor(d)] = sVarArr[iCeil - 1];
            }
            iCeil = (int) Math.ceil(((double) iCeil) / 2.0d);
            J4.i iVar3 = new J4.i(0);
            iVar3.c = i5;
            iVar3.b = j6;
            iVar3.e = i4;
            iVar3.f887f = i3 + 1;
            iVar3.f888g = jVar2.f890g;
            iVar3.d = i;
            jVar2 = new J4.j(iVar3);
        }
        return sVarArr[0];
    }

    public static void Q(int[] iArr, int[] iArr2, int[] iArr3) {
        long j6 = ((long) iArr2[0]) & 4294967295L;
        long j7 = ((long) iArr2[1]) & 4294967295L;
        long j8 = ((long) iArr2[2]) & 4294967295L;
        long j9 = ((long) iArr2[3]) & 4294967295L;
        long j10 = ((long) iArr2[4]) & 4294967295L;
        long j11 = ((long) iArr2[5]) & 4294967295L;
        long j12 = ((long) iArr2[6]) & 4294967295L;
        long j13 = ((long) iArr[0]) & 4294967295L;
        long j14 = j13 * j6;
        iArr3[0] = (int) j14;
        long j15 = (j13 * j7) + (j14 >>> 32);
        iArr3[1] = (int) j15;
        long j16 = (j13 * j8) + (j15 >>> 32);
        iArr3[2] = (int) j16;
        long j17 = (j13 * j9) + (j16 >>> 32);
        iArr3[3] = (int) j17;
        long j18 = (j13 * j10) + (j17 >>> 32);
        iArr3[4] = (int) j18;
        long j19 = (j13 * j11) + (j18 >>> 32);
        iArr3[5] = (int) j19;
        long j20 = (j13 * j12) + (j19 >>> 32);
        iArr3[6] = (int) j20;
        iArr3[7] = (int) (j20 >>> 32);
        int i = 1;
        for (int i3 = 7; i < i3; i3 = 7) {
            long j21 = ((long) iArr[i]) & 4294967295L;
            long j22 = (j21 * j6) + (((long) iArr3[i]) & 4294967295L);
            iArr3[i] = (int) j22;
            int i4 = i + 1;
            long j23 = j10;
            long j24 = (j21 * j7) + (((long) iArr3[i4]) & 4294967295L) + (j22 >>> 32);
            iArr3[i4] = (int) j24;
            int i5 = i + 2;
            long j25 = (j21 * j8) + (((long) iArr3[i5]) & 4294967295L) + (j24 >>> 32);
            iArr3[i5] = (int) j25;
            int i6 = i + 3;
            long j26 = (j21 * j9) + (((long) iArr3[i6]) & 4294967295L) + (j25 >>> 32);
            iArr3[i6] = (int) j26;
            int i7 = i + 4;
            long j27 = (j21 * j23) + (((long) iArr3[i7]) & 4294967295L) + (j26 >>> 32);
            iArr3[i7] = (int) j27;
            int i8 = i + 5;
            long j28 = (j21 * j11) + (((long) iArr3[i8]) & 4294967295L) + (j27 >>> 32);
            iArr3[i8] = (int) j28;
            int i9 = i + 6;
            long j29 = (j21 * j12) + (((long) iArr3[i9]) & 4294967295L) + (j28 >>> 32);
            iArr3[i9] = (int) j29;
            iArr3[i + 7] = (int) (j29 >>> 32);
            i = i4;
            j10 = j23;
        }
    }

    public static final U R(U u, I2.f fVar) {
        kotlin.jvm.internal.h.f(u, "<this>");
        int i = u.c;
        if ((i & 256) == 256) {
            return u.f499m;
        }
        if ((i & 512) == 512) {
            return fVar.a(u.f500n);
        }
        return null;
    }

    public static s S(t tVar, s sVar, s sVar2, n nVar) {
        if (sVar == null) {
            throw new NullPointerException("left == null");
        }
        if (sVar2 == null) {
            throw new NullPointerException("right == null");
        }
        int i = sVar2.f905a;
        int i3 = sVar.f905a;
        if (i3 != i) {
            throw new IllegalStateException("height of both nodes must be equal");
        }
        byte[] bArrC = g5.c.c((byte[]) tVar.e);
        if (nVar instanceof J4.j) {
            J4.j jVar = (J4.j) nVar;
            J4.i iVar = new J4.i(0);
            iVar.c = jVar.f895a;
            iVar.b = jVar.b;
            iVar.e = jVar.e;
            iVar.f887f = jVar.f889f;
            iVar.f888g = jVar.f890g;
            iVar.d = 0;
            nVar = new J4.j(iVar);
        } else if (nVar instanceof J4.h) {
            J4.h hVar = (J4.h) nVar;
            J4.g gVar = new J4.g();
            gVar.c = hVar.f895a;
            gVar.b = hVar.b;
            gVar.e = hVar.e;
            gVar.f885f = hVar.f886f;
            gVar.d = 0;
            nVar = new J4.h(gVar);
        }
        byte[] bArrA = nVar.a();
        z zVar = (z) tVar.c;
        byte[] bArrA2 = zVar.a(bArrC, bArrA);
        if (nVar instanceof J4.j) {
            J4.j jVar2 = (J4.j) nVar;
            J4.i iVar2 = new J4.i(0);
            iVar2.c = jVar2.f895a;
            iVar2.b = jVar2.b;
            iVar2.e = jVar2.e;
            iVar2.f887f = jVar2.f889f;
            iVar2.f888g = jVar2.f890g;
            iVar2.d = 1;
            nVar = new J4.j(iVar2);
        } else if (nVar instanceof J4.h) {
            J4.h hVar2 = (J4.h) nVar;
            J4.g gVar2 = new J4.g();
            gVar2.c = hVar2.f895a;
            gVar2.b = hVar2.b;
            gVar2.e = hVar2.e;
            gVar2.f885f = hVar2.f886f;
            gVar2.d = 1;
            nVar = new J4.h(gVar2);
        }
        byte[] bArrA3 = zVar.a(bArrC, nVar.a());
        if (nVar instanceof J4.j) {
            J4.j jVar3 = (J4.j) nVar;
            J4.i iVar3 = new J4.i(0);
            iVar3.c = jVar3.f895a;
            iVar3.b = jVar3.b;
            iVar3.e = jVar3.e;
            iVar3.f887f = jVar3.f889f;
            iVar3.f888g = jVar3.f890g;
            iVar3.d = 2;
            nVar = new J4.j(iVar3);
        } else if (nVar instanceof J4.h) {
            J4.h hVar3 = (J4.h) nVar;
            J4.g gVar3 = new J4.g();
            gVar3.c = hVar3.f895a;
            gVar3.b = hVar3.b;
            gVar3.e = hVar3.e;
            gVar3.f885f = hVar3.f886f;
            gVar3.d = 2;
            nVar = new J4.h(gVar3);
        }
        byte[] bArrA4 = zVar.a(bArrC, nVar.a());
        int i4 = ((J4.m) tVar.b).f894a;
        int i5 = i4 * 2;
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i4; i6++) {
            bArr[i6] = (byte) (C5.f.j(sVar.b)[i6] ^ bArrA3[i6]);
        }
        for (int i7 = 0; i7 < i4; i7++) {
            bArr[i7 + i4] = (byte) (C5.f.j(sVar2.b)[i7] ^ bArrA4[i7]);
        }
        int length = bArrA2.length;
        int i8 = zVar.f1864a;
        if (length != i8) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (i5 == i8 * 2) {
            return new s(i3, zVar.b(1, bArrA2, bArr));
        }
        throw new IllegalArgumentException("wrong in length");
    }

    public static H2.a T(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        C0430f c0430f = new C0430f(1, dataInputStream.readInt(), 1);
        ArrayList arrayList = new ArrayList(o.D(c0430f));
        C0429e c0429eA = c0430f.iterator();
        while (c0429eA.c) {
            c0429eA.nextInt();
            arrayList.add(Integer.valueOf(dataInputStream.readInt()));
        }
        int[] iArrN0 = kotlin.collections.m.n0(arrayList);
        return new H2.a(Arrays.copyOf(iArrN0, iArrN0.length));
    }

    public static final void U(I1.a aVar, ByteBuffer byteBuffer, int i) throws EOFException {
        kotlin.jvm.internal.h.f(aVar, "<this>");
        ByteBuffer byteBuffer2 = aVar.f750a;
        int i3 = aVar.b;
        if (aVar.c - i3 < i) {
            throw new EOFException("Not enough bytes to read a buffer content of size " + i + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            C5.f.o(byteBuffer2, byteBuffer, i3);
            byteBuffer.limit(iLimit);
            aVar.c(i);
        } catch (Throwable th) {
            byteBuffer.limit(iLimit);
            throw th;
        }
    }

    public static int V(ByteInput byteInput, int i) {
        int i3 = 0;
        for (int i4 = i; i4 >= 0; i4--) {
            i3 = (i3 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i3 >> ((3 - i) * 8);
    }

    public static int W(ByteInput byteInput, int i, boolean z6) {
        int i3 = 0;
        if (z6) {
            while (i >= 0) {
                i3 = ((byteInput.readByte() & 255) << 24) | (i3 >>> 8);
                i--;
            }
            return i3;
        }
        for (int i4 = i; i4 >= 0; i4--) {
            i3 = (i3 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i3 >>> ((3 - i) * 8);
    }

    public static final U X(C0125z c0125z, I2.f typeTable) {
        kotlin.jvm.internal.h.f(c0125z, "<this>");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        int i = c0125z.c;
        if ((i & 32) == 32) {
            return c0125z.f691j;
        }
        if ((i & 64) == 64) {
            return typeTable.a(c0125z.f692k);
        }
        return null;
    }

    public static final void Y(J1.b bVar, ByteBuffer child) {
        kotlin.jvm.internal.h.f(bVar, "<this>");
        kotlin.jvm.internal.h.f(child, "child");
        bVar.f(child.limit());
        bVar.b(child.position());
    }

    public static final U Z(C0125z c0125z, I2.f typeTable) {
        kotlin.jvm.internal.h.f(c0125z, "<this>");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        int i = c0125z.c;
        if ((i & 8) == 8) {
            U returnType = c0125z.f689g;
            kotlin.jvm.internal.h.e(returnType, "returnType");
            return returnType;
        }
        if ((i & 16) == 16) {
            return typeTable.a(c0125z.f690h);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    public static final io.ktor.utils.io.U a(byte[] content) {
        kotlin.jvm.internal.h.f(content, "content");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(content, 0, content.length);
        kotlin.jvm.internal.h.e(byteBufferWrap, "wrap(content, offset, length)");
        return new io.ktor.utils.io.U(byteBufferWrap);
    }

    public static final U a0(H h3, I2.f typeTable) {
        kotlin.jvm.internal.h.f(h3, "<this>");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        int i = h3.c;
        if ((i & 8) == 8) {
            U returnType = h3.f454g;
            kotlin.jvm.internal.h.e(returnType, "returnType");
            return returnType;
        }
        if ((i & 16) == 16) {
            return typeTable.a(h3.f455h);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    public static J1.b b(ByteBuffer buffer) {
        kotlin.jvm.internal.h.f(buffer, "buffer");
        ByteBuffer byteBuffer = G1.b.f421a;
        ByteBuffer byteBufferOrder = buffer.slice().order(ByteOrder.BIG_ENDIAN);
        kotlin.jvm.internal.h.e(byteBufferOrder, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        return new J1.b(byteBufferOrder, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b0(h1.C0494b r4, U1.c r5) {
        /*
            boolean r0 = r5 instanceof h1.C0495c
            if (r0 == 0) goto L13
            r0 = r5
            h1.c r0 = (h1.C0495c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            h1.c r0 = new h1.c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            h1.b r4 = r0.f3354a
            e0(r5)
            goto L4c
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            e0(r5)
            r1.b r5 = r4.d()
            io.ktor.utils.io.ByteReadChannel r5 = r5.a()
            r0.f3354a = r4
            r0.c = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r5 = r5.readRemaining(r2, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            I1.d r5 = (I1.d) r5
            byte[] r5 = c4.AbstractC0246d.m0(r5)
            h1.d r0 = new h1.d
            g1.f r1 = r4.f3353a
            io.ktor.client.request.HttpRequest r2 = r4.c()
            r1.b r4 = r4.d()
            r0.<init>(r1, r2, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.l.b0(h1.b, U1.c):java.lang.Object");
    }

    public static final String c(Type type) {
        String name;
        String string;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence sequenceB = k3.m.B(type, k.f3941a);
            StringBuilder sb = new StringBuilder();
            sb.append(((Class) k3.m.C(sequenceB)).getName());
            int iV = k3.m.v(sequenceB);
            if (iV < 0) {
                throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + iV + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
            }
            if (iV != 0) {
                string = "[]";
                if (iV != 1) {
                    StringBuilder sb2 = new StringBuilder(2 * iV);
                    C0429e c0429eA = new C0430f(1, iV, 1).iterator();
                    while (c0429eA.c) {
                        c0429eA.nextInt();
                        sb2.append((CharSequence) "[]");
                    }
                    string = sb2.toString();
                    kotlin.jvm.internal.h.e(string, "{\n                    va…tring()\n                }");
                }
            } else {
                string = "";
            }
            sb.append(string);
            name = sb.toString();
        } else {
            name = cls.getName();
        }
        kotlin.jvm.internal.h.e(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }

    public static void c0(int[] iArr, int[] iArr2) {
        long j6 = ((long) iArr[0]) & 4294967295L;
        int i = 14;
        int i3 = 0;
        int i4 = 6;
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
                long j39 = jE8 & 4294967295L;
                long jE10 = androidx.constraintlayout.core.motion.a.e(j33, j26, jE9 >>> 32, j37);
                long j40 = j36 + (jE10 >>> 32);
                long j41 = jE10 & 4294967295L;
                long j42 = ((long) iArr[6]) & 4294967295L;
                long j43 = (((long) iArr2[11]) & 4294967295L) + (j40 >>> 32);
                long j44 = j40 & 4294967295L;
                long j45 = (((long) iArr2[12]) & 4294967295L) + (j43 >>> 32);
                long j46 = j43 & 4294967295L;
                long j47 = (j42 * j6) + (jE7 & 4294967295L);
                int i15 = (int) j47;
                iArr2[6] = i14 | (i15 << 1);
                int i16 = i15 >>> 31;
                long jE11 = androidx.constraintlayout.core.motion.a.e(j42, j11, j47 >>> 32, j39);
                long jE12 = androidx.constraintlayout.core.motion.a.e(j42, j14, jE11 >>> 32, jE9 & 4294967295L);
                long jE13 = androidx.constraintlayout.core.motion.a.e(j42, j19, jE12 >>> 32, j41);
                long jE14 = androidx.constraintlayout.core.motion.a.e(j42, j26, jE13 >>> 32, j44);
                long jE15 = androidx.constraintlayout.core.motion.a.e(j42, j33, jE14 >>> 32, j46);
                long j48 = j45 + (jE15 >>> 32);
                int i17 = (int) jE11;
                iArr2[7] = (i17 << 1) | i16;
                int i18 = (int) jE12;
                iArr2[8] = (i17 >>> 31) | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) jE13;
                iArr2[9] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) jE14;
                iArr2[10] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) jE15;
                iArr2[11] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j48;
                iArr2[12] = i25 | (i26 << 1);
                iArr2[13] = ((iArr2[13] + ((int) (j48 >>> 32))) << 1) | (i26 >>> 31);
                return;
            }
            i4 = i5;
        }
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
        return (int) (j12 >>> 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final L2.c d0(L2.c r3, L2.c r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.h.f(r3, r0)
            java.lang.String r0 = "prefix"
            kotlin.jvm.internal.h.f(r4, r0)
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L11
            goto L32
        L11:
            boolean r0 = r4.d()
            if (r0 == 0) goto L18
            goto L32
        L18:
            java.lang.String r0 = r3.b()
            java.lang.String r1 = r4.b()
            boolean r2 = kotlin.text.r.C(r0, r1)
            if (r2 == 0) goto L64
            int r1 = r1.length()
            char r0 = r0.charAt(r1)
            r1 = 46
            if (r0 != r1) goto L64
        L32:
            boolean r0 = r4.d()
            if (r0 == 0) goto L39
            goto L64
        L39:
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L47
            L2.c r3 = L2.c.c
            java.lang.String r4 = "ROOT"
            kotlin.jvm.internal.h.e(r3, r4)
            return r3
        L47:
            L2.c r0 = new L2.c
            java.lang.String r3 = r3.b()
            java.lang.String r4 = r4.b()
            int r4 = r4.length()
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)
            java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.h.e(r3, r4)
            r0.<init>(r3)
            return r0
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.l.d0(L2.c, L2.c):L2.c");
    }

    public static String e(int i, int i3, String str) {
        if (i < 0) {
            return C5.f.R("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i3 >= 0) {
            return C5.f.R("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(B2.b.c(i3, "negative size: "));
    }

    public static final void e0(Object obj) {
        if (obj instanceof N1.g) {
            throw ((N1.g) obj).f1123a;
        }
    }

    public static void f(Caller caller, Object[] objArr) {
        if (C5.f.C(caller) == objArr.length) {
            return;
        }
        StringBuilder sb = new StringBuilder("Callable expects ");
        sb.append(C5.f.C(caller));
        sb.append(" arguments, but ");
        throw new IllegalArgumentException(B2.b.g(sb, " were provided.", objArr.length));
    }

    public static B2.a f0(int i, boolean z6, A2.P p5, int i3) {
        boolean z7 = (i3 & 1) != 0 ? false : z6;
        boolean z8 = (i3 & 2) == 0;
        if ((i3 & 4) != 0) {
            p5 = null;
        }
        com.google.protobuf.a.p(i, "<this>");
        return new B2.a(i, z8, z7, p5 != null ? io.ktor.utils.io.internal.t.p(p5) : null, 34);
    }

    public static void g(int i, int i3) {
        String strR;
        if (i < 0 || i >= i3) {
            if (i < 0) {
                strR = C5.f.R("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i3 < 0) {
                    throw new IllegalArgumentException(B2.b.c(i3, "negative size: "));
                }
                strR = C5.f.R("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strR);
        }
    }

    public static BigInteger g0(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i3 = iArr[i];
            if (i3 != 0) {
                g5.c.o(bArr, i3, (6 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void h(int i, int i3, int i4) {
        if (i < 0 || i3 < i || i3 > i4) {
            throw new IndexOutOfBoundsException((i < 0 || i > i4) ? e(i, i4, "start index") : (i3 < 0 || i3 > i4) ? e(i3, i4, "end index") : C5.f.R("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    public static final U h0(d0 d0Var, I2.f typeTable) {
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        int i = d0Var.c;
        if ((i & 4) == 4) {
            U type = d0Var.f563f;
            kotlin.jvm.internal.h.e(type, "type");
            return type;
        }
        if ((i & 8) == 8) {
            return typeTable.a(d0Var.f564g);
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    public static byte[] i(byte[] bArr) {
        if (bArr.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
        bArrCopyOf[bArr.length] = -128;
        return bArrCopyOf;
    }

    public static final F1.a i0(Type type, KClass kClass, KType kType) {
        kotlin.jvm.internal.h.f(kClass, "kClass");
        return new F1.a(type, kClass, kType);
    }

    public static int j(int i, int i3) {
        if (i == i3) {
            return 0;
        }
        return (((long) i) & 4294967295L) < (((long) i3) & 4294967295L) ? -1 : 1;
    }

    public static long j0(long j6) {
        return AbstractC0132a.j(16, AbstractC0132a.j(8, AbstractC0132a.j(4, AbstractC0132a.j(2, AbstractC0132a.j(1, j6, 2459565876494606882L), 868082074056920076L), 67555025218437360L), 280375465148160L), 4294901760L);
    }

    public static final Type k(KType kType, boolean z6) {
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new i((KTypeParameter) classifier);
        }
        if (!(classifier instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) classifier;
        Class clsI = z6 ? E1.k.I(kClass) : E1.k.H(kClass);
        List<d> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return clsI;
        }
        if (!clsI.isArray()) {
            return o(clsI, arguments);
        }
        if (clsI.getComponentType().isPrimitive()) {
            return clsI;
        }
        d dVar = (d) kotlin.collections.m.i0(arguments);
        if (dVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        e eVar = dVar.f3823a;
        int i = eVar == null ? -1 : j.f3829a[eVar.ordinal()];
        if (i == -1 || i == 1) {
            return clsI;
        }
        if (i != 2 && i != 3) {
            throw new x();
        }
        n0 n0Var = dVar.b;
        kotlin.jvm.internal.h.c(n0Var);
        Type typeK = k(n0Var, false);
        return typeK instanceof Class ? clsI : new a(typeK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final c0 k0(c0 c0Var, AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(c0Var, "<this>");
        if (c0Var instanceof TypeWithEnhancement) {
            return k0(((TypeWithEnhancement) c0Var).getOrigin(), abstractC0162z);
        }
        if (abstractC0162z == null || abstractC0162z.equals(c0Var)) {
            return c0Var;
        }
        if (c0Var instanceof F) {
            return new I((F) c0Var, abstractC0162z);
        }
        if (c0Var instanceof AbstractC0155s) {
            return new C0157u((AbstractC0155s) c0Var, abstractC0162z);
        }
        throw new x();
    }

    public static Y2.c l(L2.c fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, InputStream inputStream) throws IOException {
        G2.F f6;
        kotlin.jvm.internal.h.f(fqName, "fqName");
        try {
            H2.a aVar = H2.a.f739f;
            H2.a aVarT = T(inputStream);
            H2.a ourVersion = H2.a.f739f;
            kotlin.jvm.internal.h.f(ourVersion, "ourVersion");
            int i = aVarT.c;
            int i3 = ourVersion.c;
            int i4 = ourVersion.b;
            int i5 = aVarT.b;
            if (i5 == 0) {
                if (i4 == 0 && i == i3) {
                    C0608i c0608i = new C0608i();
                    H2.b.a(c0608i);
                    f6 = (G2.F) G2.F.f437k.parseFrom(inputStream, c0608i);
                }
                f6 = null;
            } else if (i5 != i4 || i > i3) {
                f6 = null;
            } else {
                C0608i c0608i2 = new C0608i();
                H2.b.a(c0608i2);
                f6 = (G2.F) G2.F.f437k.parseFrom(inputStream, c0608i2);
            }
            G2.F f7 = f6;
            inputStream.close();
            if (f7 != null) {
                return new Y2.c(fqName, storageManager, moduleDescriptor, f7, aVarT);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + ourVersion + ", actual " + aVarT + ". Please update Kotlin");
        } finally {
        }
    }

    public static void l0(ByteOutput byteOutput, int i, long j6) {
        int iNumberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j6);
        if (iNumberOfTrailingZeros == 0) {
            iNumberOfTrailingZeros = 1;
        }
        int i3 = (iNumberOfTrailingZeros + 7) >> 3;
        long j7 = j6 >> (64 - (i3 * 8));
        byteOutput.writeByte(i | ((i3 - 1) << 5));
        while (i3 > 0) {
            byteOutput.writeByte((byte) j7);
            j7 >>= 8;
            i3--;
        }
    }

    public static MemberScope m(String message, Collection types) {
        kotlin.jvm.internal.h.f(message, "message");
        kotlin.jvm.internal.h.f(types, "types");
        ArrayList arrayList = new ArrayList(o.D(types));
        Iterator it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbstractC0162z) it.next()).getMemberScope());
        }
        j3.j jVarD0 = AbstractC0246d.d0(arrayList);
        int i = jVarD0.f3670a;
        MemberScope aVar = i != 0 ? i != 1 ? new U2.a(message, (MemberScope[]) jVarD0.toArray(new MemberScope[0])) : (MemberScope) jVarD0.get(0) : U2.m.f1338a;
        return jVarD0.f3670a <= 1 ? aVar : new U2.j(aVar);
    }

    public static void m0(ByteOutput byteOutput, int i, long j6) {
        int iNumberOfLeadingZeros = (72 - Long.numberOfLeadingZeros((j6 >> 63) ^ j6)) >> 3;
        byteOutput.writeByte(i | ((iNumberOfLeadingZeros - 1) << 5));
        while (iNumberOfLeadingZeros > 0) {
            byteOutput.writeByte((byte) j6);
            j6 >>= 8;
            iNumberOfLeadingZeros--;
        }
    }

    public static final N1.g n(Throwable exception) {
        kotlin.jvm.internal.h.f(exception, "exception");
        return new N1.g(exception);
    }

    public static void n0(ByteOutput byteOutput, int i, long j6) {
        int iNumberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j6);
        if (iNumberOfLeadingZeros == 0) {
            iNumberOfLeadingZeros = 1;
        }
        int i3 = (iNumberOfLeadingZeros + 7) >> 3;
        byteOutput.writeByte(i | ((i3 - 1) << 5));
        while (i3 > 0) {
            byteOutput.writeByte((byte) j6);
            j6 >>= 8;
            i3--;
        }
    }

    public static final h o(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(o.D(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(G((d) it.next()));
            }
            return new h(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(o.D(list));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(G((d) it2.next()));
            }
            return new h(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        h hVarO = o(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(o.D(listSubList));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(G((d) it3.next()));
        }
        return new h(cls, hVarO, arrayList3);
    }

    public static void o0(int i, int i3) {
        String strS0;
        if (i < 0 || i >= i3) {
            if (i < 0) {
                strS0 = C5.f.s0("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i3 < 0) {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("negative size: ");
                    sb.append(i3);
                    throw new IllegalArgumentException(sb.toString());
                }
                strS0 = C5.f.s0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strS0);
        }
    }

    public static byte[] p(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = (byte) ((bArr[i] << 1) & 254);
            bArr2[i] = b;
            if (i < 15) {
                bArr2[i] = (byte) (((byte) ((bArr[i + 1] >> 7) & 1)) | b);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }

    public static void p0(int i, int i3, int i4) {
        if (i < 0 || i3 < i || i3 > i4) {
            throw new IndexOutOfBoundsException((i < 0 || i > i4) ? q0(i, i4, "start index") : (i3 < 0 || i3 > i4) ? q0(i3, i4, "end index") : C5.f.s0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    public static boolean q(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z6 = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z6 &= iArr[length] == iArr2[length];
        }
        return z6;
    }

    public static String q0(int i, int i3, String str) {
        if (i < 0) {
            return C5.f.s0("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i3 >= 0) {
            return C5.f.s0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int r(int i) {
        int i3 = i & 65535;
        int i4 = (i3 | (i3 << 8)) & 16711935;
        int i5 = (i4 | (i4 << 4)) & 252645135;
        int i6 = (i5 | (i5 << 2)) & 858993459;
        return (i6 | (i6 << 1)) & 1431655765;
    }

    public static long s(int i) {
        int i3 = AbstractC0132a.i(AbstractC0132a.i(AbstractC0132a.i(AbstractC0132a.i(i, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 8), 15728880, 4), 202116108, 2), 572662306, 1);
        return ((((long) (i3 >>> 1)) & 1431655765) << 32) | (1431655765 & ((long) i3));
    }

    public static void t(long[] jArr, int i, long[] jArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            long j6 = AbstractC0132a.j(1, AbstractC0132a.j(2, AbstractC0132a.j(4, AbstractC0132a.j(8, AbstractC0132a.j(16, jArr[i4], 4294901760L), 280375465148160L), 67555025218437360L), 868082074056920076L), 2459565876494606882L);
            jArr2[i3] = j6 & 6148914691236517205L;
            jArr2[i3 + 1] = (j6 >>> 1) & 6148914691236517205L;
            i3 += 2;
        }
    }

    public static int[] u(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[7];
        for (int i = 0; i < 7; i++) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArr;
    }

    public static p v(E1.k kVar) {
        if (kVar instanceof K2.e) {
            K2.e eVar = (K2.e) kVar;
            String name = eVar.b;
            kotlin.jvm.internal.h.f(name, "name");
            String desc = eVar.c;
            kotlin.jvm.internal.h.f(desc, "desc");
            return new p(name.concat(desc));
        }
        if (!(kVar instanceof K2.d)) {
            throw new x();
        }
        K2.d dVar = (K2.d) kVar;
        String name2 = dVar.b;
        kotlin.jvm.internal.h.f(name2, "name");
        String desc2 = dVar.c;
        kotlin.jvm.internal.h.f(desc2, "desc");
        return new p(name2 + '#' + desc2);
    }

    public static final L2.b w(NameResolver nameResolver, int i) {
        kotlin.jvm.internal.h.f(nameResolver, "<this>");
        return L2.b.e(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
    }

    public static Pair x(Long l6, Long l7) {
        if (l6 == null && l7 == null) {
            return Pair.create(null, null);
        }
        if (l6 == null) {
            return Pair.create(null, y(l7.longValue()));
        }
        if (l7 == null) {
            return Pair.create(y(l6.longValue()), null);
        }
        Calendar calendarF = L.f();
        Calendar calendarG = L.g(null);
        calendarG.setTimeInMillis(l6.longValue());
        Calendar calendarG2 = L.g(null);
        calendarG2.setTimeInMillis(l7.longValue());
        return calendarG.get(1) == calendarG2.get(1) ? calendarG.get(1) == calendarF.get(1) ? Pair.create(H(l6.longValue(), Locale.getDefault()), H(l7.longValue(), Locale.getDefault())) : Pair.create(H(l6.longValue(), Locale.getDefault()), J(l7.longValue(), Locale.getDefault())) : Pair.create(J(l6.longValue(), Locale.getDefault()), J(l7.longValue(), Locale.getDefault()));
    }

    public static String y(long j6) {
        Calendar calendarF = L.f();
        Calendar calendarG = L.g(null);
        calendarG.setTimeInMillis(j6);
        return calendarF.get(1) == calendarG.get(1) ? H(j6, Locale.getDefault()) : J(j6, Locale.getDefault());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AbstractC0162z z(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        if (abstractC0162z instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) abstractC0162z).getEnhancement();
        }
        return null;
    }
}
