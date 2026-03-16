package h2;

import G2.C0125z;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import m2.C0652d;
import n2.AbstractC0713e;
import n2.AbstractC0714f;
import net.bytebuddy.pool.TypePool;
import s2.C0811a;
import t2.AbstractC0823e;
import t2.C0824f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L2.c f3451a = new L2.c("kotlin.jvm.JvmStatic");

    public static final AbstractC0514q a(KCallable kCallable) {
        AbstractC0514q abstractC0514q = kCallable instanceof AbstractC0514q ? (AbstractC0514q) kCallable : null;
        if (abstractC0514q != null) {
            return abstractC0514q;
        }
        F fB = b(kCallable);
        return fB != null ? fB : c(kCallable);
    }

    public static final F b(Object obj) {
        F f6 = obj instanceof F ? (F) obj : null;
        if (f6 != null) {
            return f6;
        }
        kotlin.jvm.internal.e eVar = obj instanceof kotlin.jvm.internal.e ? (kotlin.jvm.internal.e) obj : null;
        KCallable kCallableCompute = eVar != null ? eVar.compute() : null;
        if (kCallableCompute instanceof F) {
            return (F) kCallableCompute;
        }
        return null;
    }

    public static final k0 c(Object obj) {
        k0 k0Var = obj instanceof k0 ? (k0) obj : null;
        if (k0Var != null) {
            return k0Var;
        }
        kotlin.jvm.internal.r rVar = obj instanceof kotlin.jvm.internal.r ? (kotlin.jvm.internal.r) obj : null;
        KCallable kCallableCompute = rVar != null ? rVar.compute() : null;
        if (kCallableCompute instanceof k0) {
            return (k0) kCallableCompute;
        }
        return null;
    }

    public static final ArrayList d(Annotated annotated) throws IllegalAccessException, InvocationTargetException {
        List listP;
        Annotation annotationI;
        kotlin.jvm.internal.h.f(annotated, "<this>");
        Annotations annotations = annotated.getAnnotations();
        ArrayList<Annotation> arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            if (source instanceof C0811a) {
                annotationI = ((C0811a) source).f4766a;
            } else if (source instanceof s2.i) {
                t2.w wVar = ((s2.i) source).f4772a;
                C0824f c0824f = wVar instanceof C0824f ? (C0824f) wVar : null;
                annotationI = c0824f != null ? c0824f.f4805a : null;
            } else {
                annotationI = i(annotationDescriptor);
            }
            if (annotationI != null) {
                arrayList.add(annotationI);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (E1.k.H(E1.k.E((Annotation) it.next())).getSimpleName().equals("Container")) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Annotation annotation : arrayList) {
                        Class clsH = E1.k.H(E1.k.E(annotation));
                        if (!clsH.getSimpleName().equals("Container") || clsH.getAnnotation(RepeatableContainer.class) == null) {
                            listP = io.ktor.utils.io.Z.p(annotation);
                        } else {
                            Object objInvoke = clsH.getDeclaredMethod("value", new Class[0]).invoke(annotation, new Object[0]);
                            kotlin.jvm.internal.h.d(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                            listP = kotlin.collections.j.t((Annotation[]) objInvoke);
                        }
                        kotlin.collections.s.F(listP, arrayList2);
                    }
                    return arrayList2;
                }
            }
        }
        return arrayList;
    }

    public static final Object e(Type type) {
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (type.equals(Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (type.equals(Character.TYPE)) {
            return (char) 0;
        }
        if (type.equals(Byte.TYPE)) {
            return (byte) 0;
        }
        if (type.equals(Short.TYPE)) {
            return (short) 0;
        }
        if (type.equals(Integer.TYPE)) {
            return 0;
        }
        if (type.equals(Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (type.equals(Long.TYPE)) {
            return 0L;
        }
        if (type.equals(Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (type.equals(Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final CallableDescriptor f(Class moduleAnchor, AbstractC0612m proto, NameResolver nameResolver, I2.f fVar, I2.a metadataVersion, Function2 createDescriptor) {
        List list;
        kotlin.jvm.internal.h.f(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.h.f(createDescriptor, "createDescriptor");
        s2.h hVarA = p0.a(moduleAnchor);
        if (proto instanceof C0125z) {
            list = ((C0125z) proto).i;
        } else {
            if (!(proto instanceof G2.H)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            list = ((G2.H) proto).i;
        }
        List typeParameters = list;
        X2.g gVar = hVarA.f4771a;
        I2.g gVar2 = I2.g.b;
        kotlin.jvm.internal.h.e(typeParameters, "typeParameters");
        return (CallableDescriptor) createDescriptor.mo5invoke(new X2.o(new X2.i(gVar, nameResolver, gVar.b, fVar, gVar2, metadataVersion, null, null, typeParameters)), proto);
    }

    public static final ReceiverParameterDescriptor g(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.h.f(callableMemberDescriptor, "<this>");
        if (callableMemberDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.h.d(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class h(ClassLoader classLoader, L2.b bVar, int i) {
        String str = C0652d.f4074a;
        L2.e eVarI = bVar.b().i();
        kotlin.jvm.internal.h.e(eVarI, "kotlinClassId.asSingleFqName().toUnsafe()");
        L2.b bVarF = C0652d.f(eVarI);
        if (bVarF != null) {
            bVar = bVarF;
        }
        String strB = bVar.g().b();
        String strB2 = bVar.h().b();
        if (strB.equals("kotlin")) {
            switch (strB2.hashCode()) {
                case -901856463:
                    if (strB2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (strB2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (strB2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (strB2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (strB2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (strB2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (strB2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (strB2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (strB2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            for (int i3 = 0; i3 < i; i3++) {
                sb.append("[");
            }
            sb.append("L");
        }
        if (strB.length() > 0) {
            sb.append(strB.concat("."));
        }
        sb.append(kotlin.text.r.A(strB2, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '$'));
        if (i > 0) {
            sb.append(";");
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return io.ktor.utils.io.Z.v(classLoader, string);
    }

    public static final Annotation i(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor classDescriptorD = R2.e.d(annotationDescriptor);
        Class clsJ = classDescriptorD != null ? j(classDescriptorD) : null;
        if (clsJ == null) {
            clsJ = null;
        }
        if (clsJ == null) {
            return null;
        }
        Set<Map.Entry<L2.f, P2.g>> setEntrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            L2.f fVar = (L2.f) entry.getKey();
            P2.g gVar = (P2.g) entry.getValue();
            ClassLoader classLoader = clsJ.getClassLoader();
            kotlin.jvm.internal.h.e(classLoader, "annotationClass.classLoader");
            Object objL = l(gVar, classLoader);
            N1.e eVar = objL != null ? new N1.e(fVar.b(), objL) : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        Map mapL = kotlin.collections.A.L(arrayList);
        Set setKeySet = mapL.keySet();
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(setKeySet));
        Iterator it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList2.add(clsJ.getDeclaredMethod((String) it2.next(), new Class[0]));
        }
        return (Annotation) AbstractC0132a.q(clsJ, mapL, arrayList2);
    }

    public static final Class j(ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(classDescriptor, "<this>");
        SourceElement source = classDescriptor.getSource();
        kotlin.jvm.internal.h.e(source, "source");
        if (source instanceof E2.o) {
            return ((s2.e) ((E2.o) source).f310a).f4768a;
        }
        if (source instanceof s2.i) {
            t2.w wVar = ((s2.i) source).f4772a;
            kotlin.jvm.internal.h.d(wVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((t2.s) wVar).f4816a;
        }
        L2.b bVarF = R2.e.f(classDescriptor);
        if (bVarF == null) {
            return null;
        }
        return h(AbstractC0823e.d(classDescriptor.getClass()), bVarF, 0);
    }

    public static final kotlin.reflect.f k(AbstractC0714f abstractC0714f) {
        if (abstractC0714f.equals(AbstractC0713e.e)) {
            return kotlin.reflect.f.f3824a;
        }
        if (abstractC0714f.equals(AbstractC0713e.c)) {
            return kotlin.reflect.f.b;
        }
        if (abstractC0714f.equals(AbstractC0713e.d)) {
            return kotlin.reflect.f.c;
        }
        if (abstractC0714f.equals(AbstractC0713e.f4232a) ? true : abstractC0714f.equals(AbstractC0713e.b)) {
            return kotlin.reflect.f.d;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object l(P2.g gVar, ClassLoader classLoader) {
        AbstractC0162z abstractC0162z;
        Class clsH;
        if (gVar instanceof P2.a) {
            return i((AnnotationDescriptor) ((P2.a) gVar).f1217a);
        }
        int i = 0;
        if (gVar instanceof P2.b) {
            P2.b bVar = (P2.b) gVar;
            P2.w wVar = bVar instanceof P2.w ? (P2.w) bVar : null;
            if (wVar != null && (abstractC0162z = wVar.c) != null) {
                Iterable iterable = (Iterable) bVar.f1217a;
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(l((P2.g) it.next(), classLoader));
                }
                L2.f fVar = k2.i.f3709f;
                ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
                k2.k kVarQ = declarationDescriptor == null ? null : k2.i.q(declarationDescriptor);
                int i3 = kVarQ == null ? -1 : w0.f3449a[kVarQ.ordinal()];
                Object obj = bVar.f1217a;
                switch (i3) {
                    case -1:
                        if (!k2.i.x(abstractC0162z)) {
                            throw new IllegalStateException(("Not an array type: " + abstractC0162z).toString());
                        }
                        AbstractC0162z type = ((TypeProjection) kotlin.collections.m.g0(abstractC0162z.a())).getType();
                        kotlin.jvm.internal.h.e(type, "type.arguments.single().type");
                        ClassifierDescriptor declarationDescriptor2 = type.c().getDeclarationDescriptor();
                        ClassDescriptor classDescriptor = declarationDescriptor2 instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor2 : null;
                        if (classDescriptor == null) {
                            throw new IllegalStateException(("Not a class type: " + type).toString());
                        }
                        if (k2.i.G(type)) {
                            int size = ((List) obj).size();
                            String[] strArr = new String[size];
                            while (i < size) {
                                Object obj2 = arrayList.get(i);
                                kotlin.jvm.internal.h.d(obj2, "null cannot be cast to non-null type kotlin.String");
                                strArr[i] = obj2;
                                i++;
                            }
                            return strArr;
                        }
                        if (k2.i.b(classDescriptor, k2.o.f3734P)) {
                            int size2 = ((List) obj).size();
                            Class[] clsArr = new Class[size2];
                            while (i < size2) {
                                Object obj3 = arrayList.get(i);
                                kotlin.jvm.internal.h.d(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                                clsArr[i] = obj3;
                                i++;
                            }
                            return clsArr;
                        }
                        L2.b bVarF = R2.e.f(classDescriptor);
                        if (bVarF != null && (clsH = h(classLoader, bVarF, 0)) != null) {
                            Object objNewInstance = Array.newInstance((Class<?>) clsH, ((List) obj).size());
                            kotlin.jvm.internal.h.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                            Object[] objArr = (Object[]) objNewInstance;
                            int size3 = arrayList.size();
                            while (i < size3) {
                                objArr[i] = arrayList.get(i);
                                i++;
                            }
                            return objArr;
                        }
                        break;
                    case 0:
                    default:
                        throw new C0.x();
                    case 1:
                        int size4 = ((List) obj).size();
                        boolean[] zArr = new boolean[size4];
                        while (i < size4) {
                            Object obj4 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                            zArr[i] = ((Boolean) obj4).booleanValue();
                            i++;
                        }
                        return zArr;
                    case 2:
                        int size5 = ((List) obj).size();
                        char[] cArr = new char[size5];
                        while (i < size5) {
                            Object obj5 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj5, "null cannot be cast to non-null type kotlin.Char");
                            cArr[i] = ((Character) obj5).charValue();
                            i++;
                        }
                        return cArr;
                    case 3:
                        int size6 = ((List) obj).size();
                        byte[] bArr = new byte[size6];
                        while (i < size6) {
                            Object obj6 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj6, "null cannot be cast to non-null type kotlin.Byte");
                            bArr[i] = ((Byte) obj6).byteValue();
                            i++;
                        }
                        return bArr;
                    case 4:
                        int size7 = ((List) obj).size();
                        short[] sArr = new short[size7];
                        while (i < size7) {
                            Object obj7 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj7, "null cannot be cast to non-null type kotlin.Short");
                            sArr[i] = ((Short) obj7).shortValue();
                            i++;
                        }
                        return sArr;
                    case 5:
                        int size8 = ((List) obj).size();
                        int[] iArr = new int[size8];
                        while (i < size8) {
                            Object obj8 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj8, "null cannot be cast to non-null type kotlin.Int");
                            iArr[i] = ((Integer) obj8).intValue();
                            i++;
                        }
                        return iArr;
                    case 6:
                        int size9 = ((List) obj).size();
                        float[] fArr = new float[size9];
                        while (i < size9) {
                            Object obj9 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj9, "null cannot be cast to non-null type kotlin.Float");
                            fArr[i] = ((Float) obj9).floatValue();
                            i++;
                        }
                        return fArr;
                    case 7:
                        int size10 = ((List) obj).size();
                        long[] jArr = new long[size10];
                        while (i < size10) {
                            Object obj10 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj10, "null cannot be cast to non-null type kotlin.Long");
                            jArr[i] = ((Long) obj10).longValue();
                            i++;
                        }
                        return jArr;
                    case 8:
                        int size11 = ((List) obj).size();
                        double[] dArr = new double[size11];
                        while (i < size11) {
                            Object obj11 = arrayList.get(i);
                            kotlin.jvm.internal.h.d(obj11, "null cannot be cast to non-null type kotlin.Double");
                            dArr[i] = ((Double) obj11).doubleValue();
                            i++;
                        }
                        return dArr;
                }
            }
        } else if (gVar instanceof P2.i) {
            N1.e eVar = (N1.e) ((P2.i) gVar).f1217a;
            L2.b bVar2 = (L2.b) eVar.f1121a;
            L2.f fVar2 = (L2.f) eVar.b;
            Class clsH2 = h(classLoader, bVar2, 0);
            if (clsH2 != null) {
                return Enum.valueOf(clsH2, fVar2.b());
            }
        } else if (gVar instanceof P2.r) {
            P2.q qVar = (P2.q) ((P2.r) gVar).f1217a;
            if (qVar instanceof P2.p) {
                P2.f fVar3 = ((P2.p) qVar).f1222a;
                return h(classLoader, fVar3.f1216a, fVar3.b);
            }
            if (!(qVar instanceof P2.o)) {
                throw new C0.x();
            }
            ClassifierDescriptor declarationDescriptor3 = ((P2.o) qVar).f1221a.c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor2 = declarationDescriptor3 instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor3 : null;
            if (classDescriptor2 != null) {
                return j(classDescriptor2);
            }
        } else {
            if (!(gVar instanceof P2.j ? true : gVar instanceof P2.t)) {
                return gVar.b();
            }
        }
        return null;
    }
}
