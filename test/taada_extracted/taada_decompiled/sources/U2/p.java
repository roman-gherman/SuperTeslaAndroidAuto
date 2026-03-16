package U2;

import c4.AbstractC0246d;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends n {
    public static final /* synthetic */ KProperty[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g f1340a;
    public final NotNullLazyValue b;
    public final NotNullLazyValue c;

    static {
        x xVar = w.f3817a;
        d = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(p.class), "functions", "getFunctions()Ljava/util/List;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(p.class), "properties", "getProperties()Ljava/util/List;"))};
    }

    public p(StorageManager storageManager, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar) {
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        this.f1340a = gVar;
        this.b = storageManager.createLazyValue(new o(this, 0));
        this.c = storageManager.createLazyValue(new o(this, 1));
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        KProperty[] kPropertyArr = d;
        return kotlin.collections.m.b0((List) AbstractC0246d.T(this.c, kPropertyArr[1]), (List) AbstractC0246d.T(this.b, kPropertyArr[0]));
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        List list = (List) AbstractC0246d.T(this.b, d[0]);
        j3.j jVar = new j3.j();
        for (Object obj : list) {
            if (kotlin.jvm.internal.h.a(((SimpleFunctionDescriptor) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        List list = (List) AbstractC0246d.T(this.c, d[1]);
        j3.j jVar = new j3.j();
        for (Object obj : list) {
            if (kotlin.jvm.internal.h.a(((PropertyDescriptor) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }
}
