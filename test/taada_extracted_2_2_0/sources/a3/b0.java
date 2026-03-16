package a3;

import a.AbstractC0132a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c3.g f1543a = c3.j.c(c3.i.DONT_CARE, new String[0]);
    public static final c3.g b = c3.j.c(c3.i.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);
    public static final a0 c = new a0("NO_EXPECTED_TYPE");
    public static final a0 d = new a0("UNIT_EXPECTED_TYPE");

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r27) {
        /*
            Method dump skipped, instruction units count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.b0.a(int):void");
    }

    public static boolean b(AbstractC0162z abstractC0162z) {
        if (abstractC0162z == null) {
            a(28);
            throw null;
        }
        if (abstractC0162z.d()) {
            return true;
        }
        return AbstractC0132a.I(abstractC0162z) && b(((AbstractC0155s) abstractC0162z.f()).c);
    }

    public static boolean c(AbstractC0162z abstractC0162z, Function1 function1) {
        if (function1 != null) {
            return d(abstractC0162z, function1, null);
        }
        a(43);
        throw null;
    }

    public static boolean d(AbstractC0162z abstractC0162z, Function1 function1, j3.m mVar) {
        if (function1 == null) {
            a(44);
            throw null;
        }
        if (abstractC0162z == null) {
            return false;
        }
        c0 c0VarF = abstractC0162z.f();
        if (m(abstractC0162z)) {
            return ((Boolean) function1.invoke(c0VarF)).booleanValue();
        }
        if (mVar != null && mVar.contains(abstractC0162z)) {
            return false;
        }
        if (((Boolean) function1.invoke(c0VarF)).booleanValue()) {
            return true;
        }
        if (mVar == null) {
            mVar = new j3.m();
        }
        mVar.add(abstractC0162z);
        AbstractC0155s abstractC0155s = c0VarF instanceof AbstractC0155s ? (AbstractC0155s) c0VarF : null;
        if (abstractC0155s != null && (d(abstractC0155s.b, function1, mVar) || d(abstractC0155s.c, function1, mVar))) {
            return true;
        }
        if ((c0VarF instanceof C0152o) && d(((C0152o) c0VarF).b, function1, mVar)) {
            return true;
        }
        TypeConstructor typeConstructorC = abstractC0162z.c();
        if (typeConstructorC instanceof C0161y) {
            Iterator it = ((C0161y) typeConstructorC).b.iterator();
            while (it.hasNext()) {
                if (d((AbstractC0162z) it.next(), function1, mVar)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection typeProjection : abstractC0162z.a()) {
            if (!typeProjection.isStarProjection() && d(typeProjection.getType(), function1, mVar)) {
                return true;
            }
        }
        return false;
    }

    public static List e(List list) {
        if (list == null) {
            a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new K(((TypeParameterDescriptor) it.next()).getDefaultType()));
        }
        return kotlin.collections.m.o0(arrayList);
    }

    public static boolean f(AbstractC0162z abstractC0162z) {
        if (abstractC0162z == null) {
            a(27);
            throw null;
        }
        if (!abstractC0162z.d() && (!AbstractC0132a.I(abstractC0162z) || !f(((AbstractC0155s) abstractC0162z.f()).c))) {
            if (!(abstractC0162z.f() instanceof C0152o)) {
                if (g(abstractC0162z)) {
                    if (!(abstractC0162z.c().getDeclarationDescriptor() instanceof ClassDescriptor)) {
                        Z zD = Z.d(abstractC0162z);
                        Collection<AbstractC0162z> supertypes = abstractC0162z.c().getSupertypes();
                        ArrayList arrayList = new ArrayList(supertypes.size());
                        for (AbstractC0162z abstractC0162z2 : supertypes) {
                            if (abstractC0162z2 == null) {
                                a(21);
                                throw null;
                            }
                            AbstractC0162z abstractC0162zJ = zD.j(abstractC0162z2, d0.INVARIANT);
                            AbstractC0162z abstractC0162zI = abstractC0162zJ != null ? i(abstractC0162zJ, abstractC0162z.d()) : null;
                            if (abstractC0162zI != null) {
                                arrayList.add(abstractC0162zI);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (f((AbstractC0162z) it.next())) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                TypeConstructor typeConstructorC = abstractC0162z.c();
                if (typeConstructorC instanceof C0161y) {
                    Iterator it2 = ((C0161y) typeConstructorC).b.iterator();
                    while (it2.hasNext()) {
                        if (f((AbstractC0162z) it2.next())) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean g(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            return (abstractC0162z.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) abstractC0162z.c().getDeclarationDescriptor() : null) != null || (abstractC0162z.c() instanceof NewTypeVariableConstructor);
        }
        a(60);
        throw null;
    }

    public static c0 h(AbstractC0162z abstractC0162z, boolean z6) {
        if (abstractC0162z == null) {
            a(3);
            throw null;
        }
        c0 c0VarG = abstractC0162z.f().g(z6);
        if (c0VarG != null) {
            return c0VarG;
        }
        a(4);
        throw null;
    }

    public static AbstractC0162z i(AbstractC0162z abstractC0162z, boolean z6) {
        if (abstractC0162z != null) {
            return z6 ? h(abstractC0162z, true) : abstractC0162z;
        }
        a(8);
        throw null;
    }

    public static F j(F f6, boolean z6) {
        if (f6 == null) {
            a(5);
            throw null;
        }
        if (!z6) {
            return f6;
        }
        F fG = f6.g(true);
        if (fG != null) {
            return fG;
        }
        a(6);
        throw null;
    }

    public static K k(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null) {
            return new K(typeParameterDescriptor);
        }
        a(45);
        throw null;
    }

    public static U l(TypeParameterDescriptor typeParameterDescriptor, B2.a aVar) {
        if (typeParameterDescriptor != null) {
            return aVar.f121a == 1 ? new K(E1.k.j0(typeParameterDescriptor)) : new K(typeParameterDescriptor);
        }
        a(46);
        throw null;
    }

    public static boolean m(AbstractC0162z abstractC0162z) {
        if (abstractC0162z != null) {
            return abstractC0162z == c || abstractC0162z == d;
        }
        a(0);
        throw null;
    }
}
