package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import c4.AbstractC0246d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends U2.n {
    public static final /* synthetic */ KProperty[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X2.i f3917a;
    public final DeserializedMemberScope$Implementation b;
    public final NotNullLazyValue c;
    public final NullableLazyValue d;

    static {
        x xVar = w.f3817a;
        e = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(l.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(l.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public l(X2.i c, List functionList, List propertyList, List typeAliasList, Function0 classNames) {
        kotlin.jvm.internal.h.f(c, "c");
        kotlin.jvm.internal.h.f(functionList, "functionList");
        kotlin.jvm.internal.h.f(propertyList, "propertyList");
        kotlin.jvm.internal.h.f(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.h.f(classNames, "classNames");
        this.f3917a = c;
        X2.g gVar = c.f1433a;
        gVar.c.getClass();
        this.b = new j(this, functionList, propertyList, typeAliasList);
        k kVar = new k(classNames);
        StorageManager storageManager = gVar.f1418a;
        this.c = storageManager.createLazyValue(kVar);
        this.d = storageManager.createNullableLazyValue(new k(this, 0));
    }

    public abstract void a(ArrayList arrayList, Function1 function1);

    public final List b(U2.f kindFilter, Function1 nameFilter) {
        TypeAliasDescriptor typeAliasByName;
        ClassDescriptor classDescriptorB;
        EnumC0851b enumC0851b = EnumC0851b.d;
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        ArrayList arrayList = new ArrayList(0);
        if (kindFilter.a(U2.f.f1320f)) {
            a(arrayList, nameFilter);
        }
        DeserializedMemberScope$Implementation deserializedMemberScope$Implementation = this.b;
        deserializedMemberScope$Implementation.addFunctionsAndPropertiesTo(arrayList, kindFilter, nameFilter, enumC0851b);
        if (kindFilter.a(U2.f.f1325l)) {
            for (L2.f fVar : f()) {
                if (((Boolean) nameFilter.invoke(fVar)).booleanValue() && (classDescriptorB = this.f3917a.f1433a.b(e(fVar))) != null) {
                    arrayList.add(classDescriptorB);
                }
            }
        }
        if (kindFilter.a(U2.f.f1321g)) {
            for (L2.f fVar2 : deserializedMemberScope$Implementation.getTypeAliasNames()) {
                if (((Boolean) nameFilter.invoke(fVar2)).booleanValue() && (typeAliasByName = deserializedMemberScope$Implementation.getTypeAliasByName(fVar2)) != null) {
                    arrayList.add(typeAliasByName);
                }
            }
        }
        return j3.p.b(arrayList);
    }

    public void c(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
    }

    public void d(L2.f name, ArrayList arrayList) {
        kotlin.jvm.internal.h.f(name, "name");
    }

    public abstract L2.b e(L2.f fVar);

    public final Set f() {
        return (Set) AbstractC0246d.T(this.c, e[0]);
    }

    public abstract Set g();

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        KProperty p5 = e[1];
        NullableLazyValue nullableLazyValue = this.d;
        kotlin.jvm.internal.h.f(nullableLazyValue, "<this>");
        kotlin.jvm.internal.h.f(p5, "p");
        return (Set) nullableLazyValue.invoke();
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        if (j(name)) {
            return this.f3917a.f1433a.b(e(name));
        }
        DeserializedMemberScope$Implementation deserializedMemberScope$Implementation = this.b;
        if (deserializedMemberScope$Implementation.getTypeAliasNames().contains(name)) {
            return deserializedMemberScope$Implementation.getTypeAliasByName(name);
        }
        return null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return this.b.getContributedFunctions(name, location);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return this.b.getContributedVariables(name, location);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        return this.b.getFunctionNames();
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        return this.b.getVariableNames();
    }

    public abstract Set h();

    public abstract Set i();

    public boolean j(L2.f fVar) {
        return f().contains(fVar);
    }

    public boolean k(o oVar) {
        return true;
    }
}
