package A2;

import a3.AbstractC0162z;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;

/* JADX INFO: loaded from: classes2.dex */
public final class H implements DFS$Neighbors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f17a = new H();

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors
    public final Iterable getNeighbors(Object obj) {
        int i = N.f22o;
        Collection<AbstractC0162z> supertypes = ((ClassDescriptor) obj).getTypeConstructor().getSupertypes();
        kotlin.jvm.internal.h.e(supertypes, "it.typeConstructor.supertypes");
        return new k3.q(k3.m.E(kotlin.collections.m.K(supertypes), L.f21a), 0);
    }
}
