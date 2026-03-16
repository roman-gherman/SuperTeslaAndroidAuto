package a3;

import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends AbstractC0153p implements TypeWithEnhancement {
    public final F b;
    public final AbstractC0162z c;

    public I(F delegate, AbstractC0162z enhancement) {
        kotlin.jvm.internal.h.f(delegate, "delegate");
        kotlin.jvm.internal.h.f(enhancement, "enhancement");
        this.b = delegate;
        this.c = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public final AbstractC0162z getEnhancement() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public final c0 getOrigin() {
        return this.b;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        c0 c0VarK0 = kotlin.reflect.l.k0(this.b.g(z6), this.c.f().g(z6));
        kotlin.jvm.internal.h.d(c0VarK0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (F) c0VarK0;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        c0 c0VarK0 = kotlin.reflect.l.k0(this.b.i(newAttributes), this.c);
        kotlin.jvm.internal.h.d(c0VarK0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (F) c0VarK0;
    }

    @Override // a3.AbstractC0153p
    public final F l() {
        return this.b;
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        return new I(f6, this.c);
    }

    @Override // a3.AbstractC0153p
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final I e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = this.b;
        kotlin.jvm.internal.h.f(type, "type");
        AbstractC0162z type2 = this.c;
        kotlin.jvm.internal.h.f(type2, "type");
        return new I(type, type2);
    }

    @Override // a3.F
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.c + ")] " + this.b;
    }
}
