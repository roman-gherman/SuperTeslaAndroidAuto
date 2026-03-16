package q2;

import a3.AbstractC0147j;
import a3.AbstractC0162z;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends U2.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoizedFunctionToNotNull f4606a;
    public final MemoizedFunctionToNotNull b;
    public final NotNullLazyValue c;
    public final /* synthetic */ C0781s d;

    public r(C0781s c0781s, StorageManager storageManager) {
        if (storageManager == null) {
            a(0);
            throw null;
        }
        this.d = c0781s;
        this.f4606a = storageManager.createMemoizedFunction(new C0779p(this, 0));
        int i = 1;
        this.b = storageManager.createMemoizedFunction(new C0779p(this, i));
        this.c = storageManager.createLazyValue(new C0770g(this, i));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.r.a(int):void");
    }

    public final MemberScope b() {
        MemberScope memberScope = ((AbstractC0162z) ((AbstractC0147j) this.d.getTypeConstructor()).getSupertypes().iterator().next()).getMemberScope();
        if (memberScope != null) {
            return memberScope;
        }
        a(9);
        throw null;
    }

    public final LinkedHashSet c(L2.f fVar, Collection collection) {
        if (fVar == null) {
            a(10);
            throw null;
        }
        if (collection == null) {
            a(11);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        N2.o.c.h(fVar, collection, Collections.EMPTY_SET, this.d, new C0780q(linkedHashSet));
        return linkedHashSet;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getClassifierNames() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        a(18);
        throw null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedDescriptors(U2.f fVar, Function1 function1) {
        if (fVar == null) {
            a(13);
            throw null;
        }
        if (function1 == null) {
            a(14);
            throw null;
        }
        Collection collection = (Collection) this.c.invoke();
        if (collection != null) {
            return collection;
        }
        a(15);
        throw null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public final Collection getContributedFunctions(L2.f fVar, LookupLocation lookupLocation) {
        if (fVar == null) {
            a(5);
            throw null;
        }
        if (lookupLocation == null) {
            a(6);
            throw null;
        }
        Collection collection = (Collection) this.f4606a.invoke(fVar);
        if (collection != null) {
            return collection;
        }
        a(7);
        throw null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection getContributedVariables(L2.f fVar, LookupLocation lookupLocation) {
        if (fVar == null) {
            a(1);
            throw null;
        }
        if (lookupLocation == null) {
            a(2);
            throw null;
        }
        Collection collection = (Collection) this.b.invoke(fVar);
        if (collection != null) {
            return collection;
        }
        a(3);
        throw null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getFunctionNames() {
        Set set = (Set) this.d.i.invoke();
        if (set != null) {
            return set;
        }
        a(17);
        throw null;
    }

    @Override // U2.n, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Set getVariableNames() {
        Set set = (Set) this.d.i.invoke();
        if (set != null) {
            return set;
        }
        a(19);
        throw null;
    }
}
