package O2;

import a3.AbstractC0162z;
import a3.d0;
import b3.d;
import b3.h;
import io.ktor.utils.io.Z;
import java.util.Collection;
import java.util.List;
import k2.i;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements CapturedTypeConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeProjection f1190a;
    public h b;

    public b(TypeProjection projection) {
        kotlin.jvm.internal.h.f(projection, "projection");
        this.f1190a = projection;
        projection.getProjectionKind();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final i getBuiltIns() {
        i builtIns = this.f1190a.getType().c().getBuiltIns();
        kotlin.jvm.internal.h.e(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        return u.f3804a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public final TypeProjection getProjection() {
        return this.f1190a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final Collection getSupertypes() {
        TypeProjection typeProjection = this.f1190a;
        AbstractC0162z type = typeProjection.getProjectionKind() == d0.OUT_VARIANCE ? typeProjection.getType() : getBuiltIns().n();
        kotlin.jvm.internal.h.e(type, "if (projection.projectio… builtIns.nullableAnyType");
        return Z.p(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final TypeConstructor refine(d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = this.f1190a.refine(kotlinTypeRefiner);
        kotlin.jvm.internal.h.e(typeProjectionRefine, "projection.refine(kotlinTypeRefiner)");
        return new b(typeProjectionRefine);
    }

    public final String toString() {
        return "CapturedTypeConstructor(" + this.f1190a + ')';
    }
}
