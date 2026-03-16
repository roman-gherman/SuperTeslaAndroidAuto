package b3;

import A2.C0022d;
import A2.y;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import c4.AbstractC0246d;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements CapturedTypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeProjection f1704a;
    public Function0 b;
    public final h c;
    public final TypeParameterDescriptor d;
    public final Object e;

    public /* synthetic */ h(TypeProjection typeProjection, g gVar, TypeParameterDescriptor typeParameterDescriptor, int i) {
        this(typeProjection, (i & 2) != 0 ? null : gVar, (h) null, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final h refine(d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = this.f1704a.refine(kotlinTypeRefiner);
        kotlin.jvm.internal.h.e(typeProjectionRefine, "projection.refine(kotlinTypeRefiner)");
        y yVar = this.b != null ? new y(4, this, kotlinTypeRefiner) : null;
        h hVar = this.c;
        if (hVar == null) {
            hVar = this;
        }
        return new h(typeProjectionRefine, yVar, hVar, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!h.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        h hVar = (h) obj;
        h hVar2 = this.c;
        if (hVar2 == null) {
            hVar2 = this;
        }
        h hVar3 = hVar.c;
        if (hVar3 != null) {
            hVar = hVar3;
        }
        return hVar2 == hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final k2.i getBuiltIns() {
        AbstractC0162z type = this.f1704a.getType();
        kotlin.jvm.internal.h.e(type, "projection.type");
        return AbstractC0246d.O(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        return u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public final TypeProjection getProjection() {
        return this.f1704a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        List list = (List) this.e.getValue();
        return list == null ? u.f3804a : list;
    }

    public final int hashCode() {
        h hVar = this.c;
        return hVar != null ? hVar.hashCode() : super.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return false;
    }

    public final String toString() {
        return "CapturedType(" + this.f1704a + ')';
    }

    public h(TypeProjection projection, Function0 function0, h hVar, TypeParameterDescriptor typeParameterDescriptor) {
        kotlin.jvm.internal.h.f(projection, "projection");
        this.f1704a = projection;
        this.b = function0;
        this.c = hVar;
        this.d = typeParameterDescriptor;
        this.e = AbstractC0132a.N(2, new C0022d(this, 13));
    }
}
