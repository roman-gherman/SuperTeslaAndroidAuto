package X2;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends r {
    public final L2.c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(L2.c fqName, NameResolver nameResolver, I2.f fVar, E2.g gVar) {
        super(nameResolver, fVar, gVar);
        kotlin.jvm.internal.h.f(fqName, "fqName");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        this.d = fqName;
    }

    @Override // X2.r
    public final L2.c a() {
        return this.d;
    }
}
