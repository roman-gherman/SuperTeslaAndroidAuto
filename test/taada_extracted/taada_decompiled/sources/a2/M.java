package A2;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends j3.p {
    public final /* synthetic */ C0029k b;
    public final /* synthetic */ Set c;
    public final /* synthetic */ kotlin.jvm.internal.i d;

    /* JADX WARN: Multi-variable type inference failed */
    public M(C0029k c0029k, Set set, Function1 function1) {
        this.b = c0029k;
        this.c = set;
        this.d = (kotlin.jvm.internal.i) function1;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler
    public final boolean beforeChildren(Object obj) {
        ClassDescriptor current = (ClassDescriptor) obj;
        kotlin.jvm.internal.h.f(current, "current");
        if (current == this.b) {
            return true;
        }
        MemberScope staticScope = current.getStaticScope();
        kotlin.jvm.internal.h.e(staticScope, "current.staticScope");
        if (!(staticScope instanceof O)) {
            return true;
        }
        this.c.addAll((Collection) this.d.invoke(staticScope));
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$NodeHandler
    public final /* bridge */ /* synthetic */ Object result() {
        return N1.m.f1129a;
    }
}
