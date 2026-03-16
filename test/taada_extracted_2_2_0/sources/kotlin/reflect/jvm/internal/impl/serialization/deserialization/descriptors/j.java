package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import G2.C0125z;
import G2.H;
import G2.W;
import c4.AbstractC0246d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.B;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0601b;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements DeserializedMemberScope$Implementation {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f3912j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3913a;
    public final LinkedHashMap b;
    public final Object c;
    public final MemoizedFunctionToNotNull d;
    public final MemoizedFunctionToNotNull e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MemoizedFunctionToNullable f3914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotNullLazyValue f3915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NotNullLazyValue f3916h;
    public final /* synthetic */ l i;

    static {
        x xVar = w.f3818a;
        f3912j = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(j.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(j.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
    }

    public j(l lVar, List functionList, List propertyList, List typeAliasList) {
        kotlin.jvm.internal.h.f(functionList, "functionList");
        kotlin.jvm.internal.h.f(propertyList, "propertyList");
        kotlin.jvm.internal.h.f(typeAliasList, "typeAliasList");
        this.i = lVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : functionList) {
            L2.f fVarI = kotlin.reflect.l.I(lVar.f3918a.b, ((C0125z) ((MessageLite) obj)).f688f);
            Object arrayList = linkedHashMap.get(fVarI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(fVarI, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f3913a = a(linkedHashMap);
        l lVar2 = this.i;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : propertyList) {
            L2.f fVarI2 = kotlin.reflect.l.I(lVar2.f3918a.b, ((H) ((MessageLite) obj2)).f453f);
            Object arrayList2 = linkedHashMap2.get(fVarI2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap2.put(fVarI2, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        this.b = a(linkedHashMap2);
        this.i.f3918a.f1433a.c.getClass();
        l lVar3 = this.i;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj3 : typeAliasList) {
            L2.f fVarI3 = kotlin.reflect.l.I(lVar3.f3918a.b, ((W) ((MessageLite) obj3)).e);
            Object arrayList3 = linkedHashMap3.get(fVarI3);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap3.put(fVarI3, arrayList3);
            }
            ((List) arrayList3).add(obj3);
        }
        this.c = a(linkedHashMap3);
        this.d = this.i.f3918a.f1433a.f1418a.createMemoizedFunction(new i(this, 0));
        this.e = this.i.f3918a.f1433a.f1418a.createMemoizedFunction(new i(this, 1));
        this.f3914f = this.i.f3918a.f1433a.f1418a.createMemoizedFunctionWithNullableValues(new i(this, 2));
        l lVar4 = this.i;
        this.f3915g = lVar4.f3918a.f1433a.f1418a.createLazyValue(new h(this, lVar4, 0));
        l lVar5 = this.i;
        this.f3916h = lVar5.f3918a.f1433a.f1418a.createLazyValue(new h(this, lVar5, 1));
    }

    public static LinkedHashMap a(LinkedHashMap linkedHashMap) throws IOException {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(B.F(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<AbstractC0601b> iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
            for (AbstractC0601b abstractC0601b : iterable) {
                int serializedSize = abstractC0601b.getSerializedSize();
                int iF = C0606g.f(serializedSize) + serializedSize;
                if (iF > 4096) {
                    iF = 4096;
                }
                C0606g c0606gJ = C0606g.j(byteArrayOutputStream, iF);
                c0606gJ.v(serializedSize);
                abstractC0601b.writeTo(c0606gJ);
                c0606gJ.i();
                arrayList.add(N1.m.f1129a);
            }
            linkedHashMap2.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final void addFunctionsAndPropertiesTo(Collection result, U2.f kindFilter, Function1 nameFilter, LookupLocation location) {
        kotlin.jvm.internal.h.f(result, "result");
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        kotlin.jvm.internal.h.f(location, "location");
        z.e eVar = U2.f.c;
        boolean zA = kindFilter.a(U2.f.f1323j);
        N2.j jVar = N2.j.b;
        if (zA) {
            Set<L2.f> variableNames = getVariableNames();
            ArrayList arrayList = new ArrayList();
            for (L2.f fVar : variableNames) {
                if (((Boolean) nameFilter.invoke(fVar)).booleanValue()) {
                    arrayList.addAll(getContributedVariables(fVar, location));
                }
            }
            kotlin.collections.r.E(arrayList, jVar);
            result.addAll(arrayList);
        }
        z.e eVar2 = U2.f.c;
        if (kindFilter.a(U2.f.i)) {
            Set<L2.f> functionNames = getFunctionNames();
            ArrayList arrayList2 = new ArrayList();
            for (L2.f fVar2 : functionNames) {
                if (((Boolean) nameFilter.invoke(fVar2)).booleanValue()) {
                    arrayList2.addAll(getContributedFunctions(fVar2, location));
                }
            }
            kotlin.collections.r.E(arrayList2, jVar);
            result.addAll(arrayList2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return !getFunctionNames().contains(name) ? u.f3805a : (Collection) this.d.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return !getVariableNames().contains(name) ? u.f3805a : (Collection) this.e.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final Set getFunctionNames() {
        return (Set) AbstractC0246d.T(this.f3915g, f3912j[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final TypeAliasDescriptor getTypeAliasByName(L2.f name) {
        kotlin.jvm.internal.h.f(name, "name");
        return (TypeAliasDescriptor) this.f3914f.invoke(name);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final Set getTypeAliasNames() {
        return this.c.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$Implementation
    public final Set getVariableNames() {
        return (Set) AbstractC0246d.T(this.f3916h, f3912j[1]);
    }
}
