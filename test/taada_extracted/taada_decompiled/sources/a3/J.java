package a3;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f1532a;

    public J(k2.i kotlinBuiltIns) {
        kotlin.jvm.internal.h.f(kotlinBuiltIns, "kotlinBuiltIns");
        this.f1532a = kotlinBuiltIns.n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final d0 getProjectionKind() {
        return d0.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final AbstractC0162z getType() {
        return this.f1532a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public final TypeProjection refine(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
