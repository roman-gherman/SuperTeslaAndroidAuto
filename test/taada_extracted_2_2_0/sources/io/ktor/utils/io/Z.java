package io.ktor.utils.io;

import a.AbstractC0132a;
import a3.AbstractC0162z;
import e2.C0429e;
import e2.C0430f;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Annotation;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import k2.C0584c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import n2.EnumC0711c;
import org.bouncycastle.crypto.Digest;
import t2.AbstractC0823e;
import t2.C0824f;
import v2.C0850a;
import v2.C0852c;
import v2.EnumC0853d;
import w3.C0896n;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Z {
    public static u1.w a() {
        return new u1.w(8);
    }

    public static P1.b b(P1.b bVar) {
        if (bVar.e != null) {
            throw new IllegalStateException();
        }
        bVar.e();
        bVar.d = true;
        return bVar;
    }

    public static C0946f c(C0946f c0946f, ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, JavaClass javaClass, int i) {
        if ((i & 2) != 0) {
            javaClass = null;
        }
        kotlin.jvm.internal.h.f(c0946f, "<this>");
        return new C0946f(c0946f.f5204a, javaClass != null ? new Y0.b(c0946f, classOrPackageFragmentDescriptor, javaClass, 0) : c0946f.b, AbstractC0132a.N(3, new A2.y(15, c0946f, classOrPackageFragmentDescriptor)));
    }

    public static final Object d(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j6, U1.c cVar) {
        if (byteReadChannel != byteWriteChannel) {
            return j6 == 0 ? new Long(0L) : ((byteReadChannel instanceof U) && (byteWriteChannel instanceof U)) ? ((U) byteWriteChannel).j((U) byteReadChannel, j6, cVar) : e(byteReadChannel, byteWriteChannel, j6, cVar);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d A[Catch: all -> 0x00dc, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00dc, blocks: (B:38:0x00d2, B:40:0x00d8, B:26:0x007d), top: B:59:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x0038, B:30:0x00a7, B:32:0x00b0, B:47:0x00eb, B:21:0x0057), top: B:55:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c7 -> B:15:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(io.ktor.utils.io.ByteReadChannel r19, io.ktor.utils.io.ByteWriteChannel r20, long r21, U1.c r23) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.Z.e(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, U1.c):java.lang.Object");
    }

    public static final ArrayList f(List newValueParameterTypes, List oldValueParameters, FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.h.f(newValueParameterTypes, "newValueParameterTypes");
        kotlin.jvm.internal.h.f(oldValueParameters, "oldValueParameters");
        newValueParameterTypes.size();
        oldValueParameters.size();
        ArrayList<N1.e> arrayListU0 = kotlin.collections.m.u0(newValueParameterTypes, oldValueParameters);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(arrayListU0));
        for (N1.e eVar : arrayListU0) {
            AbstractC0162z abstractC0162z = (AbstractC0162z) eVar.f1121a;
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) eVar.b;
            int index = valueParameterDescriptor.getIndex();
            Annotations annotations = valueParameterDescriptor.getAnnotations();
            L2.f name = valueParameterDescriptor.getName();
            kotlin.jvm.internal.h.e(name, "oldParameter.name");
            boolean zDeclaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
            boolean zIsCrossinline = valueParameterDescriptor.isCrossinline();
            boolean zIsNoinline = valueParameterDescriptor.isNoinline();
            AbstractC0162z abstractC0162zF = valueParameterDescriptor.getVarargElementType() != null ? R2.e.j(functionDescriptor).getBuiltIns().f(abstractC0162z) : null;
            SourceElement source = valueParameterDescriptor.getSource();
            kotlin.jvm.internal.h.e(source, "oldParameter.source");
            arrayList.add(new q2.S(functionDescriptor, null, index, annotations, name, abstractC0162z, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, abstractC0162zF, source));
        }
        return arrayList;
    }

    public static final C0946f g(C0946f c0946f, Annotations additionalAnnotations) {
        kotlin.jvm.internal.h.f(c0946f, "<this>");
        kotlin.jvm.internal.h.f(additionalAnnotations, "additionalAnnotations");
        if (additionalAnnotations.isEmpty()) {
            return c0946f;
        }
        return new C0946f(c0946f.f5204a, c0946f.b, AbstractC0132a.N(3, new A2.y(16, c0946f, additionalAnnotations)));
    }

    public static AnnotationDescriptor h(Annotations annotations, L2.c fqName) {
        AnnotationDescriptor next;
        kotlin.jvm.internal.h.f(fqName, "fqName");
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.h.a(next.getFqName(), fqName)) {
                break;
            }
        }
        return next;
    }

    public static final C0824f i(Annotation[] annotationArr, L2.c cVar) {
        Annotation annotation;
        kotlin.jvm.internal.h.f(annotationArr, "<this>");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (AbstractC0823e.a(E1.k.H(E1.k.E(annotation))).b().equals(cVar)) {
                break;
            }
            i++;
        }
        if (annotation != null) {
            return new C0824f(annotation);
        }
        return null;
    }

    public static w4.l j(w4.p pVar, w4.f fVar, int i, byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr2.length >= pVar.b) {
            return new w4.l(pVar, fVar, i, bArr, 1 << pVar.c, bArr2);
        }
        throw new IllegalArgumentException("root seed is less than " + pVar.b);
    }

    public static w4.n k(w4.i iVar) {
        com.android.billingclient.api.A a6 = iVar.b;
        byte[] bArr = new byte[34];
        iVar.f5091h.doFinal(bArr, 0);
        iVar.f5091h = null;
        w4.f fVar = (w4.f) a6.b;
        int i = fVar.b;
        int i3 = fVar.d;
        byte[] bArr2 = new byte[i3 * i];
        Digest digestF = io.ktor.utils.io.jvm.javaio.q.f(i, fVar.f5085f);
        w4.q qVar = new w4.q((byte[]) a6.c, (byte[]) a6.d, io.ktor.utils.io.jvm.javaio.q.j((w4.f) a6.b));
        qVar.d = a6.f1800a;
        int iB = b0.b(i, fVar, bArr);
        bArr[i] = (byte) ((iB >>> 8) & 255);
        bArr[i + 1] = (byte) iB;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte[]) a6.c);
            int i4 = a6.f1800a;
            byteArrayOutputStream.write((byte) (i4 >>> 24));
            byteArrayOutputStream.write((byte) (i4 >>> 16));
            byteArrayOutputStream.write((byte) (i4 >>> 8));
            byteArrayOutputStream.write((byte) i4);
            int i5 = i + 23;
            while (byteArrayOutputStream.size() < i5) {
                byteArrayOutputStream.write(0);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            qVar.e = 0;
            int i6 = 0;
            while (i6 < i3) {
                short s3 = (short) i6;
                byteArray[20] = (byte) (s3 >>> 8);
                byteArray[21] = (byte) s3;
                qVar.a(byteArray, 23, i6 < i3 + (-1));
                int iC = b0.c(bArr, i6, fVar.c);
                for (int i7 = 0; i7 < iC; i7++) {
                    byteArray[22] = (byte) i7;
                    digestF.update(byteArray, 0, i5);
                    digestF.doFinal(byteArray, 23);
                }
                System.arraycopy(byteArray, 23, bArr2, i * i6, i);
                i6++;
            }
            return new w4.n(iVar.b.f1800a, new w4.h(fVar, iVar.f5088a, bArr2), iVar.c, iVar.d);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static final ArrayList l(Annotation[] annotationArr) {
        kotlin.jvm.internal.h.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new C0824f(annotation));
        }
        return arrayList;
    }

    public static final A2.N m(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptor2;
        ClassifierDescriptor declarationDescriptor;
        kotlin.jvm.internal.h.f(classDescriptor, "<this>");
        int i = R2.e.f1273a;
        Iterator<AbstractC0162z> it = classDescriptor.getDefaultType().c().getSupertypes().iterator();
        while (true) {
            if (!it.hasNext()) {
                classDescriptor2 = null;
                break;
            }
            AbstractC0162z next = it.next();
            if (!k2.i.w(next)) {
                declarationDescriptor = next.c().getDeclarationDescriptor();
                if (N2.f.n(declarationDescriptor, EnumC0711c.f4229a) || N2.f.n(declarationDescriptor, EnumC0711c.c)) {
                    break;
                }
            }
        }
        kotlin.jvm.internal.h.d(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        classDescriptor2 = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor2 == null) {
            return null;
        }
        MemberScope staticScope = classDescriptor2.getStaticScope();
        A2.N n6 = staticScope instanceof A2.N ? (A2.N) staticScope : null;
        return n6 == null ? m(classDescriptor2) : n6;
    }

    public static boolean n(Annotations annotations, L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return annotations.findAnnotation(fqName) != null;
    }

    public static final boolean o(ClassDescriptor classDescriptor) {
        LinkedHashSet linkedHashSet = C0584c.f3704a;
        if (!N2.f.l(classDescriptor)) {
            return false;
        }
        LinkedHashSet linkedHashSet2 = C0584c.f3704a;
        L2.b bVarF = R2.e.f(classDescriptor);
        return kotlin.collections.m.L(bVarF != null ? bVarF.f() : null, linkedHashSet2);
    }

    public static List p(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.h.e(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    public static Class q(String str) {
        try {
            ClassLoader classLoader = Z3.c.class.getClassLoader();
            return classLoader != null ? classLoader.loadClass(str) : (Class) AccessController.doPrivileged(new K4.b(str, 3));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static String r(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static L2.f s(L2.f fVar, String str, String str2, int i) {
        char cCharAt;
        char cCharAt2;
        Object next;
        boolean z6 = (i & 4) != 0;
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!fVar.b) {
            String strC = fVar.c();
            if (kotlin.text.r.C(strC, str) && strC.length() != str.length() && ('a' > (cCharAt = strC.charAt(str.length())) || cCharAt >= '{')) {
                if (str2 != null) {
                    return L2.f.e(str2.concat(kotlin.text.i.P(strC, str)));
                }
                if (!z6) {
                    return fVar;
                }
                String strP = kotlin.text.i.P(strC, str);
                if (strP.length() != 0 && C5.f.O(0, strP)) {
                    if (strP.length() != 1 && C5.f.O(1, strP)) {
                        C0429e it = new C0430f(0, strP.length() - 1, 1).iterator();
                        while (true) {
                            if (!it.c) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (!C5.f.O(((Number) next).intValue(), strP)) {
                                break;
                            }
                        }
                        Integer num = (Integer) next;
                        if (num != null) {
                            int iIntValue = num.intValue() - 1;
                            String strSubstring = strP.substring(0, iIntValue);
                            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            String strL0 = C5.f.l0(strSubstring);
                            String strSubstring2 = strP.substring(iIntValue);
                            kotlin.jvm.internal.h.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                            strP = strL0.concat(strSubstring2);
                        } else {
                            strP = C5.f.l0(strP);
                        }
                    } else if (strP.length() != 0 && 'A' <= (cCharAt2 = strP.charAt(0)) && cCharAt2 < '[') {
                        char lowerCase = Character.toLowerCase(cCharAt2);
                        String strSubstring3 = strP.substring(1);
                        kotlin.jvm.internal.h.e(strSubstring3, "this as java.lang.String).substring(startIndex)");
                        strP = lowerCase + strSubstring3;
                    }
                }
                if (L2.f.f(strP)) {
                    return L2.f.e(strP);
                }
            }
        }
        return null;
    }

    public static final void t(C0850a c0850a, LookupLocation lookupLocation, ClassDescriptor scopeOwner, L2.f fVar) {
        LocationInfo location;
        kotlin.jvm.internal.h.f(c0850a, "<this>");
        kotlin.jvm.internal.h.f(scopeOwner, "scopeOwner");
        if (c0850a == C0850a.f4933a || (location = lookupLocation.getLocation()) == null) {
            return;
        }
        C0852c c0852c = C0852c.f4938a;
        String filePath = location.getFilePath();
        String str = N2.f.g(scopeOwner).f961a;
        if (str == null) {
            L2.e.a(4);
            throw null;
        }
        EnumC0853d enumC0853d = EnumC0853d.b;
        String strB = fVar.b();
        kotlin.jvm.internal.h.e(strB, "name.asString()");
        c0850a.record(filePath, c0852c, str, enumC0853d, strB);
    }

    public static final void u(C0850a c0850a, LookupLocation lookupLocation, PackageFragmentDescriptor scopeOwner, L2.f fVar) {
        LocationInfo location;
        kotlin.jvm.internal.h.f(c0850a, "<this>");
        kotlin.jvm.internal.h.f(scopeOwner, "scopeOwner");
        String strB = scopeOwner.getFqName().b();
        String strB2 = fVar.b();
        kotlin.jvm.internal.h.e(strB2, "name.asString()");
        if (c0850a == C0850a.f4933a || (location = lookupLocation.getLocation()) == null) {
            return;
        }
        c0850a.record(location.getFilePath(), C0852c.f4938a, strB, EnumC0853d.f4939a, strB2);
    }

    public static final Class v(ClassLoader classLoader, String fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        try {
            return Class.forName(fqName, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean w(w4.m mVar, w4.i iVar) {
        w4.n nVar = iVar.f5089f;
        w4.p pVar = nVar.c;
        int i = pVar.c;
        w4.g gVar = iVar.e;
        w4.f fVar = gVar.f5086a;
        w4.h hVar = nVar != 0 ? nVar.b : (w4.h) nVar;
        int i3 = fVar.b;
        byte[] bArr = new byte[34];
        iVar.f5091h.doFinal(bArr, 0);
        iVar.f5091h = null;
        int iB = b0.b(i3, fVar, bArr);
        bArr[i3] = (byte) ((iB >>> 8) & 255);
        bArr[i3 + 1] = (byte) iB;
        C0896n c0896n = fVar.f5085f;
        int i4 = fVar.b;
        Digest digestF = io.ktor.utils.io.jvm.javaio.q.f(i4, c0896n);
        byte[] bArr2 = gVar.b;
        io.ktor.utils.io.internal.t.c(bArr2, digestF);
        int i5 = gVar.c;
        io.ktor.utils.io.internal.t.s(i5, digestF);
        io.ktor.utils.io.internal.t.r((short) -32640, digestF);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write((byte) (i5 >>> 24));
            byteArrayOutputStream.write((byte) (i5 >>> 16));
            byteArrayOutputStream.write((byte) (i5 >>> 8));
            byteArrayOutputStream.write((byte) i5);
            int i6 = i3 + 23;
            while (byteArrayOutputStream.size() < i6) {
                byteArrayOutputStream.write(0);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int i7 = fVar.c;
            int i8 = (1 << i7) - 1;
            byte[] bArr3 = hVar.c;
            Digest digestF2 = io.ktor.utils.io.jvm.javaio.q.f(i4, c0896n);
            int i9 = 0;
            while (i9 < fVar.d) {
                short s3 = (short) i9;
                int i10 = i;
                byteArray[20] = (byte) (s3 >>> 8);
                byteArray[21] = (byte) s3;
                int i11 = 23;
                System.arraycopy(bArr3, i9 * i3, byteArray, 23, i3);
                for (int iC = b0.c(bArr, i9, i7); iC < i8; iC++) {
                    byteArray[22] = (byte) iC;
                    digestF2.update(byteArray, 0, i6);
                    i11 = 23;
                    digestF2.doFinal(byteArray, 23);
                }
                digestF.update(byteArray, i11, i3);
                i9++;
                i = i10;
            }
            byte[] bArr4 = new byte[i3];
            digestF.doFinal(bArr4, 0);
            int i12 = (1 << i) + nVar.f5100a;
            byte[] bArrC = g5.c.c(mVar.d);
            Digest digestF3 = io.ktor.utils.io.jvm.javaio.q.f(pVar.b, pVar.d);
            int digestSize = digestF3.getDigestSize();
            byte[] bArr5 = new byte[digestSize];
            digestF3.update(bArrC, 0, bArrC.length);
            io.ktor.utils.io.internal.t.s(i12, digestF3);
            io.ktor.utils.io.internal.t.r((short) -32126, digestF3);
            digestF3.update(bArr4, 0, i3);
            digestF3.doFinal(bArr5, 0);
            int i13 = 1;
            int i14 = 0;
            while (i12 > i13) {
                int i15 = i12 & 1;
                byte[][] bArr6 = nVar.d;
                if (i15 == i13) {
                    digestF3.update(bArrC, 0, bArrC.length);
                    io.ktor.utils.io.internal.t.s(i12 / 2, digestF3);
                    io.ktor.utils.io.internal.t.r((short) -31869, digestF3);
                    byte[] bArr7 = bArr6[i14];
                    digestF3.update(bArr7, 0, bArr7.length);
                    digestF3.update(bArr5, 0, digestSize);
                } else {
                    digestF3.update(bArrC, 0, bArrC.length);
                    io.ktor.utils.io.internal.t.s(i12 / 2, digestF3);
                    io.ktor.utils.io.internal.t.r((short) -31869, digestF3);
                    digestF3.update(bArr5, 0, digestSize);
                    byte[] bArr8 = bArr6[i14];
                    digestF3.update(bArr8, 0, bArr8.length);
                }
                digestF3.doFinal(bArr5, 0);
                i12 /= 2;
                i14++;
                if (i14 == bArr6.length) {
                    i13 = 1;
                    if (i12 > 1) {
                        return false;
                    }
                } else {
                    i13 = 1;
                }
            }
            return g5.c.g(mVar.e, bArr5);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
