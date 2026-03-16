package A2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;

/* JADX INFO: renamed from: A2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0020b implements DeclaredMemberIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaClass f28a;
    public final kotlin.jvm.internal.i b;
    public final C0019a c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f29f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    public C0020b(JavaClass jClass, Function1 memberFilter) {
        kotlin.jvm.internal.h.f(jClass, "jClass");
        kotlin.jvm.internal.h.f(memberFilter, "memberFilter");
        this.f28a = jClass;
        this.b = (kotlin.jvm.internal.i) memberFilter;
        C0019a c0019a = new C0019a(this, 0);
        this.c = c0019a;
        k3.f fVarW = k3.m.w(kotlin.collections.m.K(jClass.getMethods()), c0019a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        k3.e eVar = new k3.e(fVarW);
        while (eVar.hasNext()) {
            Object next = eVar.next();
            L2.f name = ((JavaMethod) next).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(next);
        }
        this.d = linkedHashMap;
        k3.f fVarW2 = k3.m.w(kotlin.collections.m.K(this.f28a.getFields()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        k3.e eVar2 = new k3.e(fVarW2);
        while (eVar2.hasNext()) {
            Object next2 = eVar2.next();
            linkedHashMap2.put(((JavaField) next2).getName(), next2);
        }
        this.e = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.f28a.getRecordComponents();
        ?? r52 = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : recordComponents) {
            if (((Boolean) r52.invoke(obj)).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        int iF = kotlin.collections.B.F(kotlin.collections.o.D(arrayList2));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iF < 16 ? 16 : iF);
        for (Object obj2 : arrayList2) {
            linkedHashMap3.put(((JavaRecordComponent) obj2).getName(), obj2);
        }
        this.f29f = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final JavaField findFieldByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return (JavaField) this.e.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Collection findMethodsByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        List list = (List) this.d.get(name);
        return list != null ? list : kotlin.collections.u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final JavaRecordComponent findRecordComponentByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return (JavaRecordComponent) this.f29f.get(name);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Set getFieldNames() {
        k3.f fVarW = k3.m.w(kotlin.collections.m.K(this.f28a.getFields()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        k3.e eVar = new k3.e(fVarW);
        while (eVar.hasNext()) {
            linkedHashSet.add(((JavaField) eVar.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Set getMethodNames() {
        k3.f fVarW = k3.m.w(kotlin.collections.m.K(this.f28a.getMethods()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        k3.e eVar = new k3.e(fVarW);
        while (eVar.hasNext()) {
            linkedHashSet.add(((JavaMethod) eVar.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public final Set getRecordComponentNames() {
        return this.f29f.keySet();
    }
}
