package a3;

import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;

/* JADX INFO: renamed from: a3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0157u extends AbstractC0155s implements TypeWithEnhancement {
    public final AbstractC0155s d;
    public final AbstractC0162z e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0157u(AbstractC0155s origin, AbstractC0162z enhancement) {
        super(origin.b, origin.c);
        kotlin.jvm.internal.h.f(origin, "origin");
        kotlin.jvm.internal.h.f(enhancement, "enhancement");
        this.d = origin;
        this.e = enhancement;
    }

    @Override // a3.AbstractC0162z
    public final AbstractC0162z e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        AbstractC0155s type = this.d;
        kotlin.jvm.internal.h.f(type, "type");
        AbstractC0162z type2 = this.e;
        kotlin.jvm.internal.h.f(type2, "type");
        return new C0157u(type, type2);
    }

    @Override // a3.c0
    public final c0 g(boolean z6) {
        return kotlin.reflect.l.k0(this.d.g(z6), this.e.f().g(z6));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public final AbstractC0162z getEnhancement() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public final c0 getOrigin() {
        return this.d;
    }

    @Override // a3.c0
    /* JADX INFO: renamed from: h */
    public final c0 e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        AbstractC0155s type = this.d;
        kotlin.jvm.internal.h.f(type, "type");
        AbstractC0162z type2 = this.e;
        kotlin.jvm.internal.h.f(type2, "type");
        return new C0157u(type, type2);
    }

    @Override // a3.c0
    public final c0 i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return kotlin.reflect.l.k0(this.d.i(newAttributes), this.e);
    }

    @Override // a3.AbstractC0155s
    public final F j() {
        return this.d.j();
    }

    @Override // a3.AbstractC0155s
    public final String k(M2.s sVar, M2.s sVar2) {
        return sVar2.d.getEnhancedTypes() ? sVar.M(this.e) : this.d.k(sVar, sVar2);
    }

    @Override // a3.AbstractC0155s
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.e + ")] " + this.d;
    }
}
