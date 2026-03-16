package w2;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: renamed from: w2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0870d {
    public static final LinkedHashMap c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f5008a;
    public final ConcurrentHashMap b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (EnumC0868b enumC0868b : EnumC0868b.values()) {
            String str = enumC0868b.f5003a;
            if (linkedHashMap.get(str) == null) {
                linkedHashMap.put(str, enumC0868b);
            }
        }
        c = linkedHashMap;
    }

    public C0870d(y javaTypeEnhancementState) {
        kotlin.jvm.internal.h.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f5008a = javaTypeEnhancementState;
        this.b = new ConcurrentHashMap();
    }

    public static ArrayList a(Object obj, boolean z6) {
        AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) obj;
        kotlin.jvm.internal.h.f(annotationDescriptor, "<this>");
        Map<L2.f, P2.g> allValueArguments = annotationDescriptor.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<L2.f, P2.g> entry : allValueArguments.entrySet()) {
            kotlin.collections.s.F((!z6 || kotlin.jvm.internal.h.a(entry.getKey(), D.b)) ? k(entry.getValue()) : kotlin.collections.u.f3805a, arrayList);
        }
        return arrayList;
    }

    public static Object d(Object obj, L2.c cVar) {
        for (Object obj2 : f(obj)) {
            if (kotlin.jvm.internal.h.a(e(obj2), cVar)) {
                return obj2;
            }
        }
        return null;
    }

    public static L2.c e(Object obj) {
        AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) obj;
        kotlin.jvm.internal.h.f(annotationDescriptor, "<this>");
        return annotationDescriptor.getFqName();
    }

    public static Iterable f(Object obj) {
        Annotations annotations;
        AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) obj;
        kotlin.jvm.internal.h.f(annotationDescriptor, "<this>");
        ClassDescriptor classDescriptorD = R2.e.d(annotationDescriptor);
        return (classDescriptorD == null || (annotations = classDescriptorD.getAnnotations()) == null) ? kotlin.collections.u.f3805a : annotations;
    }

    public static boolean g(Object obj, L2.c cVar) {
        Iterable iterableF = f(obj);
        if ((iterableF instanceof Collection) && ((Collection) iterableF).isEmpty()) {
            return false;
        }
        Iterator it = iterableF.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.h.a(e(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    public static List k(P2.g gVar) {
        if (!(gVar instanceof P2.b)) {
            return gVar instanceof P2.i ? Z.p(((P2.i) gVar).c.c()) : kotlin.collections.u.f3805a;
        }
        Iterable iterable = (Iterable) ((P2.b) gVar).f1217a;
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            kotlin.collections.s.F(k((P2.g) it.next()), arrayList);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w2.z b(w2.z r14, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r15) {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.C0870d.b(w2.z, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):w2.z");
    }

    public final D2.i c(Object obj, Function1 function1) {
        D2.i iVarH;
        D2.i iVarH2 = h(obj, ((Boolean) function1.invoke(obj)).booleanValue());
        if (iVarH2 != null) {
            return iVarH2;
        }
        Object objJ = j(obj);
        if (objJ != null) {
            G gI = i(obj);
            if (gI == null) {
                gI = this.f5008a.f5026a.f4962a;
            }
            if (gI != G.IGNORE && (iVarH = h(objJ, ((Boolean) function1.invoke(objJ)).booleanValue())) != null) {
                return D2.i.a(iVarH, null, gI == G.WARN, 1);
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
    
        if (r10.equals("ALWAYS") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
    
        if (r10.equals("UNKNOWN") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
    
        if (r10.equals("NEVER") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
    
        if (r10.equals("MAYBE") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c5, code lost:
    
        if (r0.equals(w2.E.f4982m) != false) goto L57;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final D2.i h(java.lang.Object r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.C0870d.h(java.lang.Object, boolean):D2.i");
    }

    public final G i(Object obj) {
        String str;
        y yVar = this.f5008a;
        G g6 = (G) yVar.f5026a.c.get(e(obj));
        if (g6 != null) {
            return g6;
        }
        Object objD = d(obj, AbstractC0869c.d);
        if (objD == null || (str = (String) kotlin.collections.m.Q(a(objD, false))) == null) {
            return null;
        }
        G g7 = yVar.f5026a.b;
        if (g7 != null) {
            return g7;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return G.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return G.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && str.equals("WARN")) {
            return G.WARN;
        }
        return null;
    }

    public final Object j(Object annotation) {
        Object objJ;
        kotlin.jvm.internal.h.f(annotation, "annotation");
        if (!this.f5008a.f5026a.d) {
            if (kotlin.collections.m.L(e(annotation), AbstractC0869c.f5007h) || g(annotation, AbstractC0869c.b)) {
                return annotation;
            }
            if (g(annotation, AbstractC0869c.f5004a)) {
                ConcurrentHashMap concurrentHashMap = this.b;
                ClassDescriptor classDescriptorD = R2.e.d((AnnotationDescriptor) annotation);
                kotlin.jvm.internal.h.c(classDescriptorD);
                Object obj = concurrentHashMap.get(classDescriptorD);
                if (obj != null) {
                    return obj;
                }
                Iterator it = f(annotation).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        objJ = null;
                        break;
                    }
                    objJ = j(it.next());
                    if (objJ != null) {
                        break;
                    }
                }
                if (objJ != null) {
                    Object objPutIfAbsent = concurrentHashMap.putIfAbsent(classDescriptorD, objJ);
                    return objPutIfAbsent == null ? objJ : objPutIfAbsent;
                }
            }
        }
        return null;
    }
}
