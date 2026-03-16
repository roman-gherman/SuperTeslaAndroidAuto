package a3;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends W {
    public final W b;
    public final W c;

    public r(W w5, W w6) {
        this.b = w5;
        this.c = w6;
    }

    @Override // a3.W
    public final boolean a() {
        return this.b.a() || this.c.a();
    }

    @Override // a3.W
    public final boolean b() {
        return this.b.b() || this.c.b();
    }

    @Override // a3.W
    public final Annotations c(Annotations annotations) {
        kotlin.jvm.internal.h.f(annotations, "annotations");
        return this.c.c(this.b.c(annotations));
    }

    @Override // a3.W
    public final TypeProjection d(AbstractC0162z abstractC0162z) {
        TypeProjection typeProjectionD = this.b.d(abstractC0162z);
        return typeProjectionD == null ? this.c.d(abstractC0162z) : typeProjectionD;
    }

    @Override // a3.W
    public final AbstractC0162z f(AbstractC0162z topLevelType, d0 position) {
        kotlin.jvm.internal.h.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.h.f(position, "position");
        return this.c.f(this.b.f(topLevelType, position), position);
    }
}
