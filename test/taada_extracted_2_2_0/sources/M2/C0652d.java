package m2;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import k2.C0584c;
import k2.p;
import kotlin.text.q;
import l2.EnumC0621e;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: renamed from: m2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0652d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4075a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final L2.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final L2.c f4076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final L2.b f4077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f4078h;
    public static final HashMap i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f4079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f4080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap f4081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap f4082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List f4083n;

    static {
        StringBuilder sb = new StringBuilder();
        EnumC0621e enumC0621e = EnumC0621e.d;
        sb.append(enumC0621e.f3974a.f958a.toString());
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb.append(enumC0621e.b);
        f4075a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        EnumC0621e enumC0621e2 = EnumC0621e.f3971f;
        sb2.append(enumC0621e2.f3974a.f958a.toString());
        sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb2.append(enumC0621e2.b);
        b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        EnumC0621e enumC0621e3 = EnumC0621e.e;
        sb3.append(enumC0621e3.f3974a.f958a.toString());
        sb3.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb3.append(enumC0621e3.b);
        c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        EnumC0621e enumC0621e4 = EnumC0621e.f3972g;
        sb4.append(enumC0621e4.f3974a.f958a.toString());
        sb4.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        sb4.append(enumC0621e4.b);
        d = sb4.toString();
        L2.b bVarJ = L2.b.j(new L2.c("kotlin.jvm.functions.FunctionN"));
        e = bVarJ;
        f4076f = bVarJ.b();
        f4077g = L2.i.f975n;
        d(Class.class);
        f4078h = new HashMap();
        i = new HashMap();
        f4079j = new HashMap();
        f4080k = new HashMap();
        f4081l = new HashMap();
        f4082m = new HashMap();
        L2.b bVarJ2 = L2.b.j(k2.o.f3725A);
        L2.c cVar = k2.o.I;
        L2.c cVarG = bVarJ2.g();
        L2.c cVarG2 = bVarJ2.g();
        kotlin.jvm.internal.h.e(cVarG2, "kotlinReadOnly.packageFqName");
        L2.c cVarD0 = kotlin.reflect.l.d0(cVar, cVarG2);
        C0651c c0651c = new C0651c(d(Iterable.class), bVarJ2, new L2.b(cVarG, cVarD0, false));
        L2.b bVarJ3 = L2.b.j(k2.o.f3762z);
        L2.c cVar2 = k2.o.H;
        L2.c cVarG3 = bVarJ3.g();
        L2.c cVarG4 = bVarJ3.g();
        kotlin.jvm.internal.h.e(cVarG4, "kotlinReadOnly.packageFqName");
        C0651c c0651c2 = new C0651c(d(Iterator.class), bVarJ3, new L2.b(cVarG3, kotlin.reflect.l.d0(cVar2, cVarG4), false));
        L2.b bVarJ4 = L2.b.j(k2.o.f3726B);
        L2.c cVar3 = k2.o.J;
        L2.c cVarG5 = bVarJ4.g();
        L2.c cVarG6 = bVarJ4.g();
        kotlin.jvm.internal.h.e(cVarG6, "kotlinReadOnly.packageFqName");
        C0651c c0651c3 = new C0651c(d(Collection.class), bVarJ4, new L2.b(cVarG5, kotlin.reflect.l.d0(cVar3, cVarG6), false));
        L2.b bVarJ5 = L2.b.j(k2.o.C);
        L2.c cVar4 = k2.o.f3730K;
        L2.c cVarG7 = bVarJ5.g();
        L2.c cVarG8 = bVarJ5.g();
        kotlin.jvm.internal.h.e(cVarG8, "kotlinReadOnly.packageFqName");
        C0651c c0651c4 = new C0651c(d(List.class), bVarJ5, new L2.b(cVarG7, kotlin.reflect.l.d0(cVar4, cVarG8), false));
        L2.b bVarJ6 = L2.b.j(k2.o.E);
        L2.c cVar5 = k2.o.f3732M;
        L2.c cVarG9 = bVarJ6.g();
        L2.c cVarG10 = bVarJ6.g();
        kotlin.jvm.internal.h.e(cVarG10, "kotlinReadOnly.packageFqName");
        C0651c c0651c5 = new C0651c(d(Set.class), bVarJ6, new L2.b(cVarG9, kotlin.reflect.l.d0(cVar5, cVarG10), false));
        L2.b bVarJ7 = L2.b.j(k2.o.f3727D);
        L2.c cVar6 = k2.o.f3731L;
        L2.c cVarG11 = bVarJ7.g();
        L2.c cVarG12 = bVarJ7.g();
        kotlin.jvm.internal.h.e(cVarG12, "kotlinReadOnly.packageFqName");
        C0651c c0651c6 = new C0651c(d(ListIterator.class), bVarJ7, new L2.b(cVarG11, kotlin.reflect.l.d0(cVar6, cVarG12), false));
        L2.c cVar7 = k2.o.f3728F;
        L2.b bVarJ8 = L2.b.j(cVar7);
        L2.c cVar8 = k2.o.f3733N;
        L2.c cVarG13 = bVarJ8.g();
        L2.c cVarG14 = bVarJ8.g();
        kotlin.jvm.internal.h.e(cVarG14, "kotlinReadOnly.packageFqName");
        C0651c c0651c7 = new C0651c(d(Map.class), bVarJ8, new L2.b(cVarG13, kotlin.reflect.l.d0(cVar8, cVarG14), false));
        L2.b bVarD = L2.b.j(cVar7).d(k2.o.f3729G.f());
        L2.c cVar9 = k2.o.f3734O;
        L2.c cVarG15 = bVarD.g();
        L2.c cVarG16 = bVarD.g();
        kotlin.jvm.internal.h.e(cVarG16, "kotlinReadOnly.packageFqName");
        List<C0651c> listY = kotlin.collections.n.y(c0651c, c0651c2, c0651c3, c0651c4, c0651c5, c0651c6, c0651c7, new C0651c(d(Map.Entry.class), bVarD, new L2.b(cVarG15, kotlin.reflect.l.d0(cVar9, cVarG16), false)));
        f4083n = listY;
        c(Object.class, k2.o.f3743a);
        c(String.class, k2.o.f3747f);
        c(CharSequence.class, k2.o.e);
        a(d(Throwable.class), L2.b.j(k2.o.f3751k));
        c(Cloneable.class, k2.o.c);
        c(Number.class, k2.o.i);
        a(d(Comparable.class), L2.b.j(k2.o.f3752l));
        c(Enum.class, k2.o.f3750j);
        a(d(Annotation.class), L2.b.j(k2.o.f3758s));
        for (C0651c c0651c8 : listY) {
            L2.b bVar = c0651c8.f4074a;
            L2.b bVar2 = c0651c8.b;
            a(bVar, bVar2);
            L2.b bVar3 = c0651c8.c;
            b(bVar3.b(), bVar);
            f4081l.put(bVar3, bVar2);
            f4082m.put(bVar2, bVar3);
            L2.c cVarB = bVar2.b();
            L2.c cVarB2 = bVar3.b();
            L2.e eVarI = bVar3.b().i();
            kotlin.jvm.internal.h.e(eVarI, "mutableClassId.asSingleFqName().toUnsafe()");
            f4079j.put(eVarI, cVarB);
            L2.e eVarI2 = cVarB.i();
            kotlin.jvm.internal.h.e(eVarI2, "readOnlyFqName.toUnsafe()");
            f4080k.put(eVarI2, cVarB2);
        }
        for (S2.b bVar4 : S2.b.values()) {
            L2.b bVarJ9 = L2.b.j(bVar4.e());
            k2.k kVarD = bVar4.d();
            kotlin.jvm.internal.h.e(kVarD, "jvmType.primitiveType");
            a(bVarJ9, L2.b.j(p.f3768k.c(kVarD.f3721a)));
        }
        for (L2.b bVar5 : C0584c.f3704a) {
            a(L2.b.j(new L2.c("kotlin.jvm.internal." + bVar5.i().b() + "CompanionObject")), bVar5.d(L2.h.b));
        }
        for (int i3 = 0; i3 < 23; i3++) {
            a(L2.b.j(new L2.c(B2.b.c(i3, "kotlin.jvm.functions.Function"))), new L2.b(p.f3768k, L2.f.e("Function" + i3)));
            b(new L2.c(b + i3), f4077g);
        }
        for (int i4 = 0; i4 < 22; i4++) {
            EnumC0621e enumC0621e5 = EnumC0621e.f3972g;
            b(new L2.c((enumC0621e5.f3974a.f958a.toString() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + enumC0621e5.b) + i4), f4077g);
        }
        L2.c cVarG17 = k2.o.b.g();
        kotlin.jvm.internal.h.e(cVarG17, "nothing.toSafe()");
        b(cVarG17, d(Void.class));
    }

    public static void a(L2.b bVar, L2.b bVar2) {
        L2.e eVarI = bVar.b().i();
        kotlin.jvm.internal.h.e(eVarI, "javaClassId.asSingleFqName().toUnsafe()");
        f4078h.put(eVarI, bVar2);
        b(bVar2.b(), bVar);
    }

    public static void b(L2.c cVar, L2.b bVar) {
        L2.e eVarI = cVar.i();
        kotlin.jvm.internal.h.e(eVarI, "kotlinFqNameUnsafe.toUnsafe()");
        i.put(eVarI, bVar);
    }

    public static void c(Class cls, L2.e eVar) {
        L2.c cVarG = eVar.g();
        kotlin.jvm.internal.h.e(cVarG, "kotlinFqName.toSafe()");
        a(d(cls), L2.b.j(cVarG));
    }

    public static L2.b d(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        return declaringClass == null ? L2.b.j(new L2.c(cls.getCanonicalName())) : d(declaringClass).d(L2.f.e(cls.getSimpleName()));
    }

    public static boolean e(L2.e eVar, String str) {
        Integer numV;
        String str2 = eVar.f961a;
        if (str2 != null) {
            String strS = kotlin.text.i.S(str2, str, "");
            return strS.length() > 0 && !kotlin.text.i.R(strS, '0') && (numV = q.v(strS)) != null && numV.intValue() >= 23;
        }
        L2.e.a(4);
        throw null;
    }

    public static L2.b f(L2.e eVar) {
        return (e(eVar, f4075a) || e(eVar, c)) ? e : (e(eVar, b) || e(eVar, d)) ? f4077g : (L2.b) i.get(eVar);
    }
}
