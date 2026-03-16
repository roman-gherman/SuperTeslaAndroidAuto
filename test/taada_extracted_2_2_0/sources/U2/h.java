package U2;

import A2.C0022d;
import c4.AbstractC0246d;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import q2.AbstractC0765b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends n {
    public static final /* synthetic */ KProperty[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0765b f1333a;
    public final NotNullLazyValue b;

    static {
        x xVar = w.f3818a;
        c = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(h.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public h(Z2.n nVar, AbstractC0765b abstractC0765b) {
        this.f1333a = abstractC0765b;
        this.b = nVar.createLazyValue(new C0022d(this, 4));
    }

    public abstract List a();

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        if (!kindFilter.a(f.f1327n.b)) {
            return u.f3805a;
        }
        return (List) AbstractC0246d.T(this.b, c[0]);
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        List list = (List) AbstractC0246d.T(this.b, c[0]);
        j3.j jVar = new j3.j();
        for (Object obj : list) {
            if ((obj instanceof SimpleFunctionDescriptor) && kotlin.jvm.internal.h.a(((SimpleFunctionDescriptor) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        List list = (List) AbstractC0246d.T(this.b, c[0]);
        j3.j jVar = new j3.j();
        for (Object obj : list) {
            if ((obj instanceof PropertyDescriptor) && kotlin.jvm.internal.h.a(((PropertyDescriptor) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }
}
