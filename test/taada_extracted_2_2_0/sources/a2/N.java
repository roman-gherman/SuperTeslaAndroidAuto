package A2;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import n2.EnumC0709a;
import v2.EnumC0851b;
import z2.C0941a;
import z2.C0946f;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends O {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f22o = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JavaClass f23m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final C0029k f24n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(C0946f c0946f, JavaClass jClass, C0029k c0029k) {
        super(c0946f, null);
        kotlin.jvm.internal.h.f(jClass, "jClass");
        this.f23m = jClass;
        this.f24n = c0029k;
    }

    public static PropertyDescriptor o(PropertyDescriptor propertyDescriptor) {
        EnumC0709a kind = propertyDescriptor.getKind();
        kind.getClass();
        if (kind != EnumC0709a.b) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.h.e(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(overriddenDescriptors));
        for (PropertyDescriptor it : overriddenDescriptors) {
            kotlin.jvm.internal.h.e(it, "it");
            arrayList.add(o(it));
        }
        return (PropertyDescriptor) kotlin.collections.m.g0(kotlin.collections.m.o0(kotlin.collections.m.r0(arrayList)));
    }

    @Override // A2.G
    public final Set a(U2.f kindFilter, U2.k kVar) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        return kotlin.collections.w.f3807a;
    }

    @Override // A2.G
    public final Set b(U2.f kindFilter, U2.k kVar) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        Set setR0 = kotlin.collections.m.r0(((DeclaredMemberIndex) this.d.invoke()).getMethodNames());
        C0029k c0029k = this.f24n;
        N nM = Z.m(c0029k);
        Set functionNames = nM != null ? nM.getFunctionNames() : null;
        if (functionNames == null) {
            functionNames = kotlin.collections.w.f3807a;
        }
        setR0.addAll(functionNames);
        if (this.f23m.isEnum()) {
            setR0.addAll(kotlin.collections.n.y(k2.p.c, k2.p.f3763a));
        }
        C0946f c0946f = this.f11a;
        setR0.addAll(c0946f.f5204a.x.getStaticFunctionNames(c0946f, c0029k));
        return setR0;
    }

    @Override // A2.G
    public final void c(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
        C0946f c0946f = this.f11a;
        C0941a c0941a = c0946f.f5204a;
        c0941a.x.generateStaticFunctions(c0946f, this.f24n, name, arrayList);
    }

    @Override // A2.G
    public final DeclaredMemberIndex d() {
        return new C0020b(this.f23m, I.f18a);
    }

    @Override // A2.G
    public final void f(LinkedHashSet linkedHashSet, L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        C0029k c0029k = this.f24n;
        N nM = Z.m(c0029k);
        Collection collectionS0 = nM == null ? kotlin.collections.w.f3807a : kotlin.collections.m.s0(nM.getContributedFunctions(name, EnumC0851b.e));
        C0941a c0941a = this.f11a.f5204a;
        linkedHashSet.addAll(k1.j.p(name, collectionS0, linkedHashSet, this.f24n, c0941a.f5185f, c0941a.u.b));
        if (this.f23m.isEnum()) {
            if (name.equals(k2.p.c)) {
                linkedHashSet.add(N2.q.i(c0029k));
            } else if (name.equals(k2.p.f3763a)) {
                linkedHashSet.add(N2.q.j(c0029k));
            }
        }
    }

    @Override // A2.O, A2.G
    public final void g(L2.f name, ArrayList arrayList) {
        q2.I iH;
        kotlin.jvm.internal.h.f(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        J j6 = new J(name, 0);
        C0029k c0029k = this.f24n;
        j3.p.c(Z.p(c0029k), H.f17a, new M(c0029k, linkedHashSet, j6));
        boolean zIsEmpty = arrayList.isEmpty();
        C0946f c0946f = this.f11a;
        if (zIsEmpty) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : linkedHashSet) {
                PropertyDescriptor propertyDescriptorO = o((PropertyDescriptor) obj);
                Object arrayList2 = linkedHashMap.get(propertyDescriptorO);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(propertyDescriptorO, arrayList2);
                }
                ((List) arrayList2).add(obj);
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) ((Map.Entry) it.next()).getValue();
                C0941a c0941a = c0946f.f5204a;
                kotlin.collections.s.F(k1.j.p(name, collection, arrayList, this.f24n, c0941a.f5185f, c0941a.u.b), arrayList3);
            }
            arrayList.addAll(arrayList3);
        } else {
            C0941a c0941a2 = c0946f.f5204a;
            arrayList.addAll(k1.j.p(name, linkedHashSet, arrayList, this.f24n, c0941a2.f5185f, c0941a2.u.b));
        }
        if (this.f23m.isEnum() && name.equals(k2.p.b) && (iH = N2.q.h(c0029k)) != null) {
            arrayList.add(iH);
        }
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return null;
    }

    @Override // A2.G
    public final Set h(U2.f kindFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        Set setR0 = kotlin.collections.m.r0(((DeclaredMemberIndex) this.d.invoke()).getFieldNames());
        K k6 = K.f20a;
        C0029k c0029k = this.f24n;
        j3.p.c(Z.p(c0029k), H.f17a, new M(c0029k, setR0, k6));
        if (this.f23m.isEnum()) {
            setR0.add(k2.p.b);
        }
        return setR0;
    }

    @Override // A2.G
    public final DeclarationDescriptor j() {
        return this.f24n;
    }
}
