package q2;

import a3.AbstractC0162z;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: q2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0768e implements TypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p f4591a;

    public C0768e(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.p pVar) {
        this.f4591a = pVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        return R2.e.e(this.f4591a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        return this.f4591a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        List list = this.f4591a.q;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.h.n("typeConstructorParameters");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        Collection<AbstractC0162z> supertypes = this.f4591a.getUnderlyingType().c().getSupertypes();
        kotlin.jvm.internal.h.e(supertypes, "declarationDescriptor.un…pe.constructor.supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final TypeConstructor refine(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final String toString() {
        return "[typealias " + this.f4591a.getName().b() + ']';
    }
}
