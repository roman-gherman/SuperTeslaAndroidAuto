package a3;

import a.AbstractC0132a;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: renamed from: a3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0143f implements TypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b3.d f1549a;
    public final Object b;
    public final /* synthetic */ AbstractC0147j c;

    public C0143f(AbstractC0147j abstractC0147j, b3.d dVar) {
        this.c = abstractC0147j;
        this.f1549a = dVar;
        this.b = AbstractC0132a.N(2, new A2.y(2, this, abstractC0147j));
    }

    public final boolean equals(Object obj) {
        return this.c.equals(obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        k2.i builtIns = this.c.getBuiltIns();
        kotlin.jvm.internal.h.e(builtIns, "this@AbstractTypeConstructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        return this.c.getDeclarationDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        List<TypeParameterDescriptor> parameters = this.c.getParameters();
        kotlin.jvm.internal.h.e(parameters, "this@AbstractTypeConstructor.parameters");
        return parameters;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        return (List) this.b.getValue();
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return this.c.isDenotable();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final TypeConstructor refine(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.c.refine(kotlinTypeRefiner);
    }

    public final String toString() {
        return this.c.toString();
    }
}
