package P2;

import A2.C0022d;
import a.AbstractC0132a;
import a3.C;
import a3.M;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements TypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f1220a;
    public final N1.j b;

    public m(Set set) {
        M.b.getClass();
        M attributes = M.c;
        int i = C.f1530a;
        kotlin.jvm.internal.h.f(attributes, "attributes");
        C.d(attributes, kotlin.collections.u.f3804a, c3.j.a(2, true, "unknown integer literal type"), this, false);
        this.b = AbstractC0132a.M(new C0022d(this, 3));
        this.f1220a = set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        return kotlin.collections.u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        return (List) this.b.getValue();
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
        StringBuilder sb = new StringBuilder("IntegerLiteralType");
        sb.append("[" + kotlin.collections.m.V(this.f1220a, ",", null, null, l.f1219a, 30) + ']');
        return sb.toString();
    }
}
