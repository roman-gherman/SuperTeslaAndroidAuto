package io.ktor.utils.io;

import a3.AbstractC0162z;
import android.util.Log;
import c4.AbstractC0246d;
import com.android.multidex.ClassPathElement;
import io.ktor.http.Parameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import l2.C0619c;
import l2.C0620d;
import l2.C0623g;
import l2.EnumC0621e;
import m3.AbstractC0665a;
import n2.AbstractC0713e;
import n2.EnumC0709a;
import n2.EnumC0719k;
import org.slf4j.Marker;
import r3.AbstractC0800a;
import u1.C0840e;
import w2.AbstractC0871e;
import w2.AbstractC0875i;
import w2.C0874h;
import w2.C0876j;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 {
    public static void A(Function2 function2, AbstractC0665a abstractC0665a, AbstractC0665a abstractC0665a2) {
        try {
            AbstractC0800a.g(N1.m.f1129a, C5.f.J(C5.f.r(abstractC0665a, abstractC0665a2, function2)));
        } catch (Throwable th) {
            abstractC0665a2.resumeWith(kotlin.reflect.l.n(th));
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable B(io.ktor.utils.io.ByteReadChannel r4, U1.c r5) {
        /*
            boolean r0 = r5 instanceof z1.b
            if (r0 == 0) goto L13
            r0 = r5
            z1.b r0 = (z1.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            z1.b r0 = new z1.b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f5171a
            T1.a r1 = T1.a.f1304a
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r5)
            goto L40
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.reflect.l.e0(r5)
            r0.b = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r5 = r4.readRemaining(r2, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            I1.d r5 = (I1.d) r5
            byte[] r4 = c4.AbstractC0246d.m0(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.b0.B(io.ktor.utils.io.ByteReadChannel, U1.c):java.io.Serializable");
    }

    public static void C(byte[] bArr, int i, long j6) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i + i3] = (byte) (255 & j6);
            i3++;
            j6 >>= 8;
        }
    }

    public static final int D(int i, int i3, String str) {
        while (i3 > i && io.ktor.utils.io.jvm.javaio.q.m(str.charAt(i3 - 1))) {
            i3--;
        }
        return i3;
    }

    public static final int E(int i, int i3, String str) {
        while (i < i3 && io.ktor.utils.io.jvm.javaio.q.m(str.charAt(i))) {
            i++;
        }
        return i;
    }

    public static final void a(u1.w wVar, String str, int i, int i3, int i4) {
        if (i3 == -1) {
            int iE = E(i, i4, str);
            int iD = D(iE, i4, str);
            if (iD > iE) {
                String strSubstring = str.substring(iE, iD);
                kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                wVar.appendAll(strSubstring, kotlin.collections.u.f3804a);
                return;
            }
            return;
        }
        int iE2 = E(i, i3, str);
        int iD2 = D(iE2, i3, str);
        if (iD2 > iE2) {
            String strSubstring2 = str.substring(iE2, iD2);
            kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            int iE3 = E(i3 + 1, i4, str);
            String strSubstring3 = str.substring(iE3, D(iE3, i4, str));
            kotlin.jvm.internal.h.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            wVar.append(strSubstring2, strSubstring3);
        }
    }

    public static int b(int i, w4.f fVar, byte[] bArr) {
        int i3 = (1 << fVar.c) - 1;
        int i4 = 0;
        int iC = 0;
        while (true) {
            int i5 = fVar.c;
            if (i4 >= (i * 8) / i5) {
                return iC << fVar.e;
            }
            iC = (iC + i3) - c(bArr, i4, i5);
            i4++;
        }
    }

    public static int c(byte[] bArr, int i, int i3) {
        int i4 = (i * i3) / 8;
        return (bArr[i4] >>> (((~i) & ((8 / i3) - 1)) * i3)) & ((1 << i3) - 1);
    }

    public static final Annotations d(Annotations first, Annotations second) {
        kotlin.jvm.internal.h.f(first, "first");
        kotlin.jvm.internal.h.f(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new o2.g(new Annotations[]{first, second});
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long jW = w(0, bArr) & 67108863;
        int i = 3;
        long jW2 = (w(3, bArr) >> 2) & 67108611;
        long jW3 = (w(6, bArr) >> 4) & 67092735;
        long jW4 = (w(9, bArr) >> 6) & 66076671;
        long jW5 = (w(12, bArr) >> 8) & 1048575;
        long j6 = jW2 * 5;
        long j7 = jW3 * 5;
        long j8 = jW4 * 5;
        long j9 = jW5 * 5;
        byte[] bArr3 = new byte[17];
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        int i3 = 0;
        while (i3 < bArr2.length) {
            int iMin = Math.min(16, bArr2.length - i3);
            System.arraycopy(bArr2, i3, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long jW6 = j14 + (w(0, bArr3) & 67108863);
            long jW7 = j10 + ((w(i, bArr3) >> 2) & 67108863);
            long jW8 = j11 + ((w(6, bArr3) >> 4) & 67108863);
            long jW9 = j12 + ((w(9, bArr3) >> 6) & 67108863);
            long j15 = jW2;
            long jW10 = j13 + (((w(12, bArr3) >> 8) & 67108863) | ((long) (bArr3[16] << 24)));
            long j16 = (jW10 * j6) + (jW9 * j7) + (jW8 * j8) + (jW7 * j9) + (jW6 * jW);
            long j17 = (jW10 * j7) + (jW9 * j8) + (jW8 * j9) + (jW7 * jW) + (jW6 * j15);
            long j18 = (jW10 * j8) + (jW9 * j9) + (jW8 * jW) + (jW7 * j15) + (jW6 * jW3);
            long j19 = (jW10 * j9) + (jW9 * jW) + (jW8 * j15) + (jW7 * jW3) + (jW6 * jW4);
            long j20 = jW9 * j15;
            long j21 = jW10 * jW;
            long j22 = j17 + (j16 >> 26);
            long j23 = j18 + (j22 >> 26);
            long j24 = j19 + (j23 >> 26);
            long j25 = j21 + j20 + (jW8 * jW3) + (jW7 * jW4) + (jW6 * jW5) + (j24 >> 26);
            long j26 = j25 >> 26;
            j13 = j25 & 67108863;
            long j27 = (j26 * 5) + (j16 & 67108863);
            i3 += 16;
            j11 = j23 & 67108863;
            j12 = j24 & 67108863;
            j14 = j27 & 67108863;
            j10 = (j22 & 67108863) + (j27 >> 26);
            jW2 = j15;
            i = 3;
        }
        long j28 = j11 + (j10 >> 26);
        long j29 = j28 & 67108863;
        long j30 = j12 + (j28 >> 26);
        long j31 = j30 & 67108863;
        long j32 = j13 + (j30 >> 26);
        long j33 = j32 & 67108863;
        long j34 = ((j32 >> 26) * 5) + j14;
        long j35 = j34 >> 26;
        long j36 = j34 & 67108863;
        long j37 = (j10 & 67108863) + j35;
        long j38 = j36 + 5;
        long j39 = j38 & 67108863;
        long j40 = j37 + (j38 >> 26);
        long j41 = j29 + (j40 >> 26);
        long j42 = j31 + (j41 >> 26);
        long j43 = j42 & 67108863;
        long j44 = (j33 + (j42 >> 26)) - 67108864;
        long j45 = j44 >> 63;
        long j46 = j36 & j45;
        long j47 = j37 & j45;
        long j48 = j29 & j45;
        long j49 = j31 & j45;
        long j50 = j33 & j45;
        long j51 = ~j45;
        long j52 = j47 | (j40 & 67108863 & j51);
        long j53 = j48 | (j41 & 67108863 & j51);
        long j54 = j49 | (j43 & j51);
        long j55 = (j46 | (j39 & j51) | (j52 << 26)) & 4294967295L;
        long j56 = ((j52 >> 6) | (j53 << 20)) & 4294967295L;
        long j57 = ((j53 >> 12) | (j54 << 14)) & 4294967295L;
        long j58 = ((j54 >> 18) | ((j50 | (j44 & j51)) << 8)) & 4294967295L;
        long jW11 = w(16, bArr) + j55;
        long j59 = jW11 & 4294967295L;
        long jW12 = w(20, bArr) + j56 + (jW11 >> 32);
        long jW13 = w(24, bArr) + j57 + (jW12 >> 32);
        long jW14 = (w(28, bArr) + j58 + (jW13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        C(bArr4, 0, j59);
        C(bArr4, 4, jW12 & 4294967295L);
        C(bArr4, 8, jW13 & 4294967295L);
        C(bArr4, 12, jW14);
        return bArr4;
    }

    public static final int f(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        AnnotationDescriptor annotationDescriptorFindAnnotation = abstractC0162z.getAnnotations().findAnnotation(k2.o.q);
        if (annotationDescriptorFindAnnotation == null) {
            return 0;
        }
        P2.g gVar = (P2.g) kotlin.collections.A.H(annotationDescriptorFindAnnotation.getAllValueArguments(), k2.p.d);
        kotlin.jvm.internal.h.d(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number) ((P2.k) gVar).f1217a).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(io.ktor.utils.io.ByteChannel r4, io.ktor.utils.io.V r5, long r6, U1.c r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.a0
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.a0 r0 = (io.ktor.utils.io.a0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.ktor.utils.io.a0 r0 = new io.ktor.utils.io.a0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            T1.a r1 = T1.a.f1304a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.ByteWriteChannel r5 = r0.f3550a
            kotlin.reflect.l.e0(r8)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.reflect.l.e0(r8)
            r0.f3550a = r5
            r0.c = r3
            java.lang.Object r8 = io.ktor.utils.io.Z.d(r4, r5, r6, r0)
            if (r8 != r1) goto L3f
            return r1
        L3f:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.h.f(r5, r4)
            r4 = 0
            r5.close(r4)
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.b0.g(io.ktor.utils.io.ByteChannel, io.ktor.utils.io.V, long, U1.c):java.lang.Object");
    }

    public static C0623g h(C0619c functionClass, boolean z6) {
        String lowerCase;
        kotlin.jvm.internal.h.f(functionClass, "functionClass");
        C0623g c0623g = new C0623g(functionClass, null, EnumC0709a.f4226a, z6);
        ReceiverParameterDescriptor thisAsReceiverParameter = functionClass.getThisAsReceiverParameter();
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        ArrayList arrayList = new ArrayList();
        List list = functionClass.f3968k;
        for (Object obj : list) {
            if (((TypeParameterDescriptor) obj).getVariance() != a3.d0.IN_VARIANCE) {
                break;
            }
            arrayList.add(obj);
        }
        k3.q qVarT0 = kotlin.collections.m.t0(arrayList);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(qVarT0));
        Iterator it = qVarT0.iterator();
        while (true) {
            k3.b bVar = (k3.b) it;
            if (!bVar.c.hasNext()) {
                c0623g.l(null, thisAsReceiverParameter, uVar, uVar, arrayList2, ((TypeParameterDescriptor) kotlin.collections.m.X(list)).getDefaultType(), EnumC0719k.d, AbstractC0713e.e);
                C0623g c0623g2 = c0623g;
                c0623g2.x = true;
                return c0623g2;
            }
            kotlin.collections.x xVar = (kotlin.collections.x) bVar.next();
            int i = xVar.f3807a;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) xVar.b;
            String strB = typeParameterDescriptor.getName().b();
            kotlin.jvm.internal.h.e(strB, "typeParameter.name.asString()");
            if (strB.equals("T")) {
                lowerCase = "instance";
            } else if (strB.equals("E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = strB.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.h.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            C0623g c0623g3 = c0623g;
            Annotations.Companion.getClass();
            o2.e eVar = o2.f.b;
            L2.f fVarE = L2.f.e(lowerCase);
            a3.F defaultType = typeParameterDescriptor.getDefaultType();
            kotlin.jvm.internal.h.e(defaultType, "typeParameter.defaultType");
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            kotlin.jvm.internal.h.e(NO_SOURCE, "NO_SOURCE");
            arrayList2.add(new q2.S(c0623g3, null, i, eVar, fVarE, defaultType, false, false, false, null, NO_SOURCE));
            c0623g = c0623g3;
        }
    }

    public static final a3.F i(k2.i iVar, Annotations annotations, AbstractC0162z abstractC0162z, List list, ArrayList arrayList, AbstractC0162z abstractC0162z2, boolean z6) {
        ClassDescriptor classDescriptorJ;
        ArrayList arrayList2 = new ArrayList(list.size() + arrayList.size() + (abstractC0162z != null ? 1 : 0) + 1);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(AbstractC0246d.f((AbstractC0162z) it.next()));
        }
        arrayList2.addAll(arrayList3);
        a3.K kF = abstractC0162z != null ? AbstractC0246d.f(abstractC0162z) : null;
        if (kF != null) {
            arrayList2.add(kF);
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                kotlin.collections.n.C();
                throw null;
            }
            arrayList2.add(AbstractC0246d.f((AbstractC0162z) obj));
            i = i3;
        }
        arrayList2.add(AbstractC0246d.f(abstractC0162z2));
        int size = list.size() + arrayList.size() + (abstractC0162z == null ? 0 : 1);
        if (z6) {
            classDescriptorJ = iVar.u(size);
        } else {
            L2.f fVar = k2.p.f3762a;
            classDescriptorJ = iVar.j("Function" + size);
        }
        kotlin.jvm.internal.h.e(classDescriptorJ, "if (isSuspendFunction) b…tFunction(parameterCount)");
        if (abstractC0162z != null) {
            L2.c cVar = k2.o.f3755p;
            if (!annotations.hasAnnotation(cVar)) {
                o2.f fVar2 = Annotations.Companion;
                ArrayList arrayListC0 = kotlin.collections.m.c0(new o2.h(iVar, cVar, kotlin.collections.v.f3805a), annotations);
                fVar2.getClass();
                annotations = o2.f.a(arrayListC0);
            }
        }
        if (!list.isEmpty()) {
            int size2 = list.size();
            L2.c cVar2 = k2.o.q;
            if (!annotations.hasAnnotation(cVar2)) {
                o2.f fVar3 = Annotations.Companion;
                ArrayList arrayListC02 = kotlin.collections.m.c0(new o2.h(iVar, cVar2, kotlin.collections.B.G(new N1.e(k2.p.d, new P2.k(size2)))), annotations);
                fVar3.getClass();
                annotations = o2.f.a(arrayListC02);
            }
        }
        return a3.C.b(AbstractC0246d.I0(annotations), classDescriptorJ, arrayList2);
    }

    public static void j(Object obj, String str, String str2) {
        if (Log.isLoggable("TRuntime.".concat(str), 3)) {
            String.format(str2, obj);
        }
    }

    public static void k(String str, String str2, Exception exc) {
        String strConcat = "TRuntime.".concat(str);
        if (Log.isLoggable(strConcat, 6)) {
            Log.e(strConcat, str2, exc);
        }
    }

    public static final L2.f l(AbstractC0162z abstractC0162z) {
        String str;
        AnnotationDescriptor annotationDescriptorFindAnnotation = abstractC0162z.getAnnotations().findAnnotation(k2.o.f3756r);
        if (annotationDescriptorFindAnnotation != null) {
            Object objH0 = kotlin.collections.m.h0(annotationDescriptorFindAnnotation.getAllValueArguments().values());
            P2.v vVar = objH0 instanceof P2.v ? (P2.v) objH0 : null;
            if (vVar != null && (str = (String) vVar.f1217a) != null) {
                if (!L2.f.f(str)) {
                    str = null;
                }
                if (str != null) {
                    return L2.f.e(str);
                }
            }
        }
        return null;
    }

    public static final List m(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        u(abstractC0162z);
        int iF = f(abstractC0162z);
        if (iF == 0) {
            return kotlin.collections.u.f3804a;
        }
        List listSubList = abstractC0162z.a().subList(0, iF);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(listSubList));
        Iterator it = listSubList.iterator();
        while (it.hasNext()) {
            AbstractC0162z type = ((TypeProjection) it.next()).getType();
            kotlin.jvm.internal.h.e(type, "it.type");
            arrayList.add(type);
        }
        return arrayList;
    }

    public static final EnumC0621e n(ClassifierDescriptor classifierDescriptor) {
        if (!(classifierDescriptor instanceof ClassDescriptor) || !k2.i.I(classifierDescriptor)) {
            return null;
        }
        L2.e eVarH = R2.e.h(classifierDescriptor);
        if (!eVarH.d() || eVarH.f961a.isEmpty()) {
            return null;
        }
        n0.d dVar = EnumC0621e.c;
        String strB = eVarH.f().b();
        kotlin.jvm.internal.h.e(strB, "shortName().asString()");
        L2.c cVarE = eVarH.g().e();
        kotlin.jvm.internal.h.e(cVarE, "toSafe().parent()");
        dVar.getClass();
        C0620d c0620dA = n0.d.a(strB, cVarE);
        if (c0620dA != null) {
            return c0620dA.f3969a;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.Map] */
    public static final String o(FunctionDescriptor functionDescriptor) {
        L2.f fVar;
        CallableMemberDescriptor callableMemberDescriptorP = k2.i.y(functionDescriptor) ? p(functionDescriptor) : null;
        if (callableMemberDescriptorP != null) {
            CallableMemberDescriptor callableMemberDescriptorK = R2.e.k(callableMemberDescriptorP);
            if (callableMemberDescriptorK instanceof PropertyDescriptor) {
                k2.i.y(callableMemberDescriptorK);
                CallableMemberDescriptor callableMemberDescriptorB = R2.e.b(R2.e.k(callableMemberDescriptorK), C0876j.f5013a);
                if (callableMemberDescriptorB != null && (fVar = (L2.f) AbstractC0875i.f5012a.get(R2.e.g(callableMemberDescriptorB))) != null) {
                    return fVar.b();
                }
            } else if (callableMemberDescriptorK instanceof SimpleFunctionDescriptor) {
                int i = AbstractC0871e.f5008l;
                LinkedHashMap linkedHashMap = w2.N.i;
                String strP = E1.k.p((SimpleFunctionDescriptor) callableMemberDescriptorK);
                L2.f fVar2 = strP == null ? null : (L2.f) linkedHashMap.get(strP);
                if (fVar2 != null) {
                    return fVar2.b();
                }
            }
        }
        return null;
    }

    public static final CallableMemberDescriptor p(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.h.f(callableMemberDescriptor, "<this>");
        if (!w2.N.f4997j.contains(callableMemberDescriptor.getName()) && !AbstractC0875i.d.contains(R2.e.k(callableMemberDescriptor).getName())) {
            return null;
        }
        if (callableMemberDescriptor instanceof PropertyDescriptor ? true : callableMemberDescriptor instanceof PropertyAccessorDescriptor) {
            return R2.e.b(callableMemberDescriptor, w2.H.f4987a);
        }
        if (callableMemberDescriptor instanceof SimpleFunctionDescriptor) {
            return R2.e.b(callableMemberDescriptor, w2.I.f4988a);
        }
        return null;
    }

    public static final CallableMemberDescriptor q(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.h.f(callableMemberDescriptor, "<this>");
        CallableMemberDescriptor callableMemberDescriptorP = p(callableMemberDescriptor);
        if (callableMemberDescriptorP != null) {
            return callableMemberDescriptorP;
        }
        int i = C0874h.f5011l;
        L2.f name = callableMemberDescriptor.getName();
        kotlin.jvm.internal.h.e(name, "name");
        if (C0874h.b(name)) {
            return R2.e.b(callableMemberDescriptor, w2.J.f4989a);
        }
        return null;
    }

    public static final AbstractC0162z r(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        u(abstractC0162z);
        if (abstractC0162z.getAnnotations().findAnnotation(k2.o.f3755p) == null) {
            return null;
        }
        return ((TypeProjection) abstractC0162z.a().get(f(abstractC0162z))).getType();
    }

    public static final List s(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        u(abstractC0162z);
        List listA = abstractC0162z.a();
        return listA.subList(((!u(abstractC0162z) || abstractC0162z.getAnnotations().findAnnotation(k2.o.f3755p) == null) ? 0 : 1) + f(abstractC0162z), listA.size() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0144, code lost:
    
        if (r6 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014b, code lost:
    
        return !k2.i.y(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean t(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r13, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r14) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.b0.t(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor):boolean");
    }

    public static final boolean u(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        EnumC0621e enumC0621eN = n(declarationDescriptor);
        return enumC0621eN == EnumC0621e.d || enumC0621eN == EnumC0621e.e;
    }

    public static final boolean v(AbstractC0162z abstractC0162z) {
        kotlin.jvm.internal.h.f(abstractC0162z, "<this>");
        ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
        return (declarationDescriptor != null ? n(declarationDescriptor) : null) == EnumC0621e.e;
    }

    public static long w(int i, byte[] bArr) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    public static C0840e x(String str) throws A.a {
        if (kotlin.text.r.y(str)) {
            return C0840e.f4861f;
        }
        u1.i iVar = (u1.i) kotlin.collections.m.X(io.ktor.utils.io.jvm.javaio.q.n(str));
        String str2 = iVar.f4864a;
        int I = kotlin.text.i.I(str2, ClassPathElement.SEPARATOR_CHAR, 0, 6);
        if (I == -1) {
            if (kotlin.jvm.internal.h.a(kotlin.text.i.X(str2).toString(), Marker.ANY_MARKER)) {
                return C0840e.f4861f;
            }
            throw new A.a("Bad Content-Type format: ".concat(str));
        }
        String strSubstring = str2.substring(0, I);
        kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String string = kotlin.text.i.X(strSubstring).toString();
        if (string.length() == 0) {
            throw new A.a("Bad Content-Type format: ".concat(str));
        }
        String strSubstring2 = str2.substring(I + 1);
        kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
        String string2 = kotlin.text.i.X(strSubstring2).toString();
        if (kotlin.text.i.E(string, ' ') || kotlin.text.i.E(string2, ' ')) {
            throw new A.a("Bad Content-Type format: ".concat(str));
        }
        if (string2.length() == 0 || kotlin.text.i.E(string2, ClassPathElement.SEPARATOR_CHAR)) {
            throw new A.a("Bad Content-Type format: ".concat(str));
        }
        return new C0840e(string, string2, iVar.b);
    }

    public static Parameters y(String query) {
        int i;
        kotlin.jvm.internal.h.f(query, "query");
        if (kotlin.text.i.F(query) < 0) {
            Parameters.Companion.getClass();
            return u1.h.f4863a;
        }
        u1.v vVar = Parameters.Companion;
        u1.w wVarA = Z.a();
        int iF = kotlin.text.i.F(query);
        int i3 = 0;
        int i4 = -1;
        if (iF >= 0) {
            int i5 = 0;
            i = 0;
            int i6 = -1;
            while (i3 != 1000) {
                char cCharAt = query.charAt(i5);
                if (cCharAt == '&') {
                    a(wVarA, query, i, i6, i5);
                    i = i5 + 1;
                    i3++;
                    i6 = -1;
                } else if (cCharAt == '=' && i6 == -1) {
                    i6 = i5;
                }
                if (i5 != iF) {
                    i5++;
                } else {
                    i4 = i6;
                }
            }
            return wVarA.build();
        }
        i = 0;
        if (i3 != 1000) {
            a(wVarA, query, i, i4, query.length());
        }
        return wVarA.build();
    }

    public static final C0944d z(C0946f c0946f, JavaAnnotationOwner annotationsOwner) {
        kotlin.jvm.internal.h.f(c0946f, "<this>");
        kotlin.jvm.internal.h.f(annotationsOwner, "annotationsOwner");
        return new C0944d(c0946f, annotationsOwner, false);
    }
}
