package h2;

import com.android.multidex.ClassPathElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;
import t2.AbstractC0823e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D implements ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlin.text.g f3363a = new kotlin.text.g("<v#(\\d+)>");

    public static Method j(Class cls, String str, Class[] clsArr, Class cls2, boolean z6) {
        Class clsV;
        Method methodJ;
        if (z6) {
            clsArr[0] = cls;
        }
        Method methodM = m(cls, str, clsArr, cls2);
        if (methodM != null) {
            return methodM;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null && (methodJ = j(superclass, str, clsArr, cls2, z6)) != null) {
            return methodJ;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.h.e(interfaces, "interfaces");
        for (Class<?> superInterface : interfaces) {
            kotlin.jvm.internal.h.e(superInterface, "superInterface");
            Method methodJ2 = j(superInterface, str, clsArr, cls2, z6);
            if (methodJ2 != null) {
                return methodJ2;
            }
            if (z6 && (clsV = io.ktor.utils.io.Z.v(AbstractC0823e.d(superInterface), superInterface.getName().concat("$DefaultImpls"))) != null) {
                clsArr[0] = superInterface;
                Method methodM2 = m(clsV, str, clsArr, cls2);
                if (methodM2 != null) {
                    return methodM2;
                }
            }
        }
        return null;
    }

    public static Constructor l(Class cls, ArrayList arrayList) {
        try {
            Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method m(Class cls, String str, Class[] clsArr, Class cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (kotlin.jvm.internal.h.a(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            kotlin.jvm.internal.h.e(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                if (kotlin.jvm.internal.h.a(method.getName(), str) && kotlin.jvm.internal.h.a(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final void a(ArrayList arrayList, String str, boolean z6) {
        ArrayList arrayListI = i(str);
        arrayList.addAll(arrayListI);
        int size = (arrayListI.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            Class TYPE = Integer.TYPE;
            kotlin.jvm.internal.h.e(TYPE, "TYPE");
            arrayList.add(TYPE);
        }
        if (!z6) {
            arrayList.add(Object.class);
        } else {
            arrayList.remove(kotlin.jvm.internal.d.class);
            arrayList.add(kotlin.jvm.internal.d.class);
        }
    }

    public final Method b(String name, String desc) throws ClassNotFoundException {
        Method methodJ;
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(desc, "desc");
        if (name.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            return null;
        }
        Class[] clsArr = (Class[]) i(desc).toArray(new Class[0]);
        Class clsK = k(kotlin.text.i.I(desc, ')', 0, 6) + 1, desc.length(), desc);
        Method methodJ2 = j(g(), name, clsArr, clsK, false);
        if (methodJ2 != null) {
            return methodJ2;
        }
        if (!g().isInterface() || (methodJ = j(Object.class, name, clsArr, clsK, false)) == null) {
            return null;
        }
        return methodJ;
    }

    public abstract Collection c();

    public abstract Collection d(L2.f fVar);

    public abstract PropertyDescriptor e(int i);

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List f(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.h.f(r9, r0)
            java.lang.String r0 = "belonginess"
            com.google.protobuf.a.p(r10, r0)
            h2.C r0 = new h2.C
            r0.<init>(r8)
            r1 = 0
            r2 = 3
            java.util.Collection r9 = a.AbstractC0132a.y(r9, r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r9 = r9.iterator()
        L1e:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L62
            java.lang.Object r3 = r9.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L5b
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            n2.f r5 = r4.getVisibility()
            n2.d r6 = n2.AbstractC0713e.f4235h
            boolean r5 = kotlin.jvm.internal.h.a(r5, r6)
            if (r5 != 0) goto L5b
            n2.a r4 = r4.getKind()
            r4.getClass()
            n2.a r5 = n2.EnumC0709a.b
            r6 = 0
            r7 = 1
            if (r4 == r5) goto L4c
            r4 = r7
            goto L4d
        L4c:
            r4 = r6
        L4d:
            if (r10 != r7) goto L50
            r6 = r7
        L50:
            if (r4 != r6) goto L5b
            N1.m r4 = N1.m.f1129a
            java.lang.Object r3 = r3.accept(r0, r4)
            h2.q r3 = (h2.AbstractC0514q) r3
            goto L5c
        L5b:
            r3 = r1
        L5c:
            if (r3 == 0) goto L1e
            r2.add(r3)
            goto L1e
        L62:
            java.util.List r9 = kotlin.collections.m.o0(r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.D.f(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, int):java.util.List");
    }

    public Class g() {
        Class<?> jClass = getJClass();
        List list = AbstractC0823e.f4804a;
        kotlin.jvm.internal.h.f(jClass, "<this>");
        Class cls = (Class) AbstractC0823e.c.get(jClass);
        return cls == null ? getJClass() : cls;
    }

    public abstract Collection h(L2.f fVar);

    public final ArrayList i(String str) {
        int I;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i3 = i;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char cCharAt = str.charAt(i3);
            if (kotlin.text.i.E("VZCBSIFJD", cCharAt)) {
                I = i3 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new N1.d("Unknown type prefix in the method signature: ".concat(str), 2);
                }
                I = kotlin.text.i.I(str, TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, i, 4) + 1;
            }
            arrayList.add(k(i, I, str));
            i = I;
        }
        return arrayList;
    }

    public final Class k(int i, int i3, String str) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'L') {
            ClassLoader classLoaderD = AbstractC0823e.d(getJClass());
            String strSubstring = str.substring(i + 1, i3 - 1);
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Class<?> clsLoadClass = classLoaderD.loadClass(kotlin.text.r.A(strSubstring, ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
            kotlin.jvm.internal.h.e(clsLoadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return clsLoadClass;
        }
        if (cCharAt == '[') {
            Class clsK = k(i + 1, i3, str);
            L2.c cVar = x0.f3451a;
            kotlin.jvm.internal.h.f(clsK, "<this>");
            return Array.newInstance((Class<?>) clsK, 0).getClass();
        }
        if (cCharAt == 'V') {
            Class TYPE = Void.TYPE;
            kotlin.jvm.internal.h.e(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'C') {
            return Character.TYPE;
        }
        if (cCharAt == 'B') {
            return Byte.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'D') {
            return Double.TYPE;
        }
        throw new N1.d("Unknown type prefix in the method signature: ".concat(str), 2);
    }
}
