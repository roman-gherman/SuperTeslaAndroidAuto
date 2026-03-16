package a3;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* JADX INFO: renamed from: a3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0152o extends AbstractC0153p implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    public final F b;
    public final boolean c;

    public C0152o(F f6, boolean z6) {
        this.b = f6;
        this.c = z6;
    }

    @Override // a3.AbstractC0153p, a3.AbstractC0162z
    public final boolean d() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public final boolean isTypeParameter() {
        F f6 = this.b;
        return (f6.c() instanceof NewTypeVariableConstructor) || (f6.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        return z6 ? this.b.g(z6) : this;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return new C0152o(this.b.i(newAttributes), this.c);
    }

    @Override // a3.AbstractC0153p
    public final F l() {
        return this.b;
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        return new C0152o(f6, this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public final AbstractC0162z substitutionResult(AbstractC0162z replacement) {
        kotlin.jvm.internal.h.f(replacement, "replacement");
        return C5.f.S(replacement.f(), this.c);
    }

    @Override // a3.F
    public final String toString() {
        return this.b + " & Any";
    }
}
