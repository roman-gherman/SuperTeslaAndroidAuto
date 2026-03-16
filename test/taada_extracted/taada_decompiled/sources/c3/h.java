package c3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import k2.C0585d;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements TypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1753a;
    public final String[] b;
    public final String c;

    public h(i kind, String... formatParams) {
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        this.f1753a = kind;
        this.b = formatParams;
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        this.c = String.format("[Error type: %s]", Arrays.copyOf(new Object[]{String.format(kind.f1774a, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length))}, 1));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        C0585d c0585d = C0585d.f3704g;
        return C0585d.f3704g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        j.f1775a.getClass();
        return j.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        return u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        return u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final TypeConstructor refine(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final String toString() {
        return this.c;
    }
}
