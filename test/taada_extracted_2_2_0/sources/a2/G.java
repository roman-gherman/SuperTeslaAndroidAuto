package A2;

import a3.AbstractC0162z;
import a3.c0;
import c4.AbstractC0246d;
import io.ktor.utils.io.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import n2.EnumC0719k;
import q2.C0763B;
import q2.S;
import z2.C0941a;
import z2.C0944d;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G extends U2.n {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f10l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0946f f11a;
    public final r b;
    public final NotNullLazyValue c;
    public final NotNullLazyValue d;
    public final MemoizedFunctionToNotNull e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MemoizedFunctionToNullable f12f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MemoizedFunctionToNotNull f13g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NotNullLazyValue f14h;
    public final NotNullLazyValue i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NotNullLazyValue f15j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MemoizedFunctionToNotNull f16k;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        f10l = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(G.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(G.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(G.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public G(C0946f c, r rVar) {
        kotlin.jvm.internal.h.f(c, "c");
        this.f11a = c;
        this.b = rVar;
        Z2.n nVar = c.f5204a.f5184a;
        this.c = nVar.createRecursionTolerantLazyValue(new C(this, 0), kotlin.collections.u.f3805a);
        this.d = nVar.createLazyValue(new C(this, 2));
        this.e = nVar.createMemoizedFunction(new D(this, 1));
        this.f12f = nVar.createMemoizedFunctionWithNullableValues(new D(this, 0));
        this.f13g = nVar.createMemoizedFunction(new D(this, 2));
        this.f14h = nVar.createLazyValue(new C(this, 3));
        this.i = nVar.createLazyValue(new C(this, 4));
        this.f15j = nVar.createLazyValue(new C(this, 1));
        this.f16k = nVar.createMemoizedFunction(new D(this, 3));
    }

    public static AbstractC0162z e(JavaMethod method, C0946f c0946f) {
        kotlin.jvm.internal.h.f(method, "method");
        B2.a aVarF0 = kotlin.reflect.l.f0(2, method.getContainingClass().isAnnotationType(), null, 6);
        return c0946f.e.s(method.getReturnType(), aVarF0);
    }

    public static B n(C0946f c0946f, q2.v vVar, List jValueParameters) {
        N1.e eVar;
        L2.f name;
        kotlin.jvm.internal.h.f(jValueParameters, "jValueParameters");
        k3.q qVarT0 = kotlin.collections.m.t0(jValueParameters);
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(qVarT0));
        Iterator it = qVarT0.iterator();
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            k3.b bVar = (k3.b) it;
            if (!bVar.c.hasNext()) {
                return new B(kotlin.collections.m.o0(arrayList), 0, z7);
            }
            kotlin.collections.x xVar = (kotlin.collections.x) bVar.next();
            int i = xVar.f3808a;
            JavaValueParameter javaValueParameter = (JavaValueParameter) xVar.b;
            C0944d c0944dZ = b0.z(c0946f, javaValueParameter);
            B2.a aVarF0 = kotlin.reflect.l.f0(2, z6, null, 7);
            boolean zIsVararg = javaValueParameter.isVararg();
            C0941a c0941a = c0946f.f5204a;
            B2.d dVar = c0946f.e;
            C0763B c0763b = c0941a.f5193o;
            if (zIsVararg) {
                JavaType type = javaValueParameter.getType();
                JavaArrayType javaArrayType = type instanceof JavaArrayType ? (JavaArrayType) type : null;
                if (javaArrayType == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + javaValueParameter);
                }
                c0 c0VarR = dVar.r(javaArrayType, aVarF0, true);
                eVar = new N1.e(c0VarR, c0763b.d.f(c0VarR));
            } else {
                eVar = new N1.e(dVar.s(javaValueParameter.getType(), aVarF0), null);
            }
            AbstractC0162z abstractC0162z = (AbstractC0162z) eVar.f1121a;
            AbstractC0162z abstractC0162z2 = (AbstractC0162z) eVar.b;
            if (kotlin.jvm.internal.h.a(vVar.getName().b(), "equals") && jValueParameters.size() == 1 && c0763b.d.n().equals(abstractC0162z)) {
                name = L2.f.e("other");
            } else {
                name = javaValueParameter.getName();
                if (name == null) {
                    z7 = true;
                }
                if (name == null) {
                    name = L2.f.e("p" + i);
                }
            }
            arrayList.add(new S(vVar, null, i, c0944dZ, name, abstractC0162z, false, false, false, abstractC0162z2, c0941a.f5188j.source(javaValueParameter)));
            z6 = false;
        }
    }

    public abstract Set a(U2.f fVar, U2.k kVar);

    public abstract Set b(U2.f fVar, U2.k kVar);

    public void c(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
    }

    public abstract DeclaredMemberIndex d();

    public abstract void f(LinkedHashSet linkedHashSet, L2.f fVar);

    public abstract void g(L2.f fVar, ArrayList arrayList);

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        return (Set) AbstractC0246d.T(this.f15j, f10l[2]);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return (Collection) this.c.invoke();
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return !getFunctionNames().contains(name) ? kotlin.collections.u.f3805a : (Collection) this.f13g.invoke(name);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return !getVariableNames().contains(name) ? kotlin.collections.u.f3805a : (Collection) this.f16k.invoke(name);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        return (Set) AbstractC0246d.T(this.f14h, f10l[0]);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        return (Set) AbstractC0246d.T(this.i, f10l[1]);
    }

    public abstract Set h(U2.f fVar);

    public abstract ReceiverParameterDescriptor i();

    public abstract DeclarationDescriptor j();

    public boolean k(y2.e eVar) {
        return true;
    }

    public abstract A l(JavaMethod javaMethod, ArrayList arrayList, AbstractC0162z abstractC0162z, List list);

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, kotlin.Lazy] */
    public final y2.e m(JavaMethod method) {
        q2.w wVarK;
        kotlin.jvm.internal.h.f(method, "method");
        C0946f c0946f = this.f11a;
        y2.e eVarV = y2.e.v(j(), b0.z(c0946f, method), method.getName(), c0946f.f5204a.f5188j.source(method), ((DeclaredMemberIndex) this.d.invoke()).findRecordComponentByName(method.getName()) != null && method.getValueParameters().isEmpty());
        kotlin.jvm.internal.h.f(c0946f, "<this>");
        C0946f c0946f2 = new C0946f(c0946f.f5204a, new Y0.b(c0946f, eVarV, method, 0), c0946f.c);
        List<JavaTypeParameter> typeParameters = method.getTypeParameters();
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(typeParameters));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = c0946f2.b.resolveTypeParameter((JavaTypeParameter) it.next());
            kotlin.jvm.internal.h.c(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        B bN = n(c0946f2, eVarV, method.getValueParameters());
        AbstractC0162z abstractC0162zE = e(method, c0946f2);
        List list = (List) bN.c;
        A aL = l(method, arrayList, abstractC0162zE, list);
        AbstractC0162z abstractC0162z = aL.b;
        if (abstractC0162z != null) {
            Annotations.Companion.getClass();
            wVarK = N2.q.k(eVarV, abstractC0162z, o2.f.b);
        } else {
            wVarK = null;
        }
        eVarV.u(wVarK, i(), kotlin.collections.u.f3805a, aL.d, aL.c, aL.f4a, method.isAbstract() ? EnumC0719k.d : !method.isFinal() ? EnumC0719k.c : EnumC0719k.f4248a, w2.O.a(method.getVisibility()), abstractC0162z != null ? kotlin.collections.B.G(new N1.e(y2.e.f5139G, kotlin.collections.m.P(list))) : kotlin.collections.v.f3806a);
        eVarV.w(false, bN.b);
        List<String> list2 = aL.e;
        if (!list2.isEmpty()) {
            c0946f2.f5204a.e.reportSignatureErrors(eVarV, list2);
        }
        return eVarV;
    }

    public String toString() {
        return "Lazy scope for " + j();
    }
}
