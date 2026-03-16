package a3;

import c4.AbstractC0246d;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter;

/* JADX INFO: renamed from: a3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0156t extends AbstractC0155s implements CustomTypeParameter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0156t(F lowerBound, F upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
    }

    @Override // a3.AbstractC0162z
    public final AbstractC0162z e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = this.b;
        kotlin.jvm.internal.h.f(type, "type");
        F type2 = this.c;
        kotlin.jvm.internal.h.f(type2, "type");
        return new C0156t(type, type2);
    }

    @Override // a3.c0
    public final c0 g(boolean z6) {
        return C.a(this.b.g(z6), this.c.g(z6));
    }

    @Override // a3.c0
    /* JADX INFO: renamed from: h */
    public final c0 e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = this.b;
        kotlin.jvm.internal.h.f(type, "type");
        F type2 = this.c;
        kotlin.jvm.internal.h.f(type2, "type");
        return new C0156t(type, type2);
    }

    @Override // a3.c0
    public final c0 i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return C.a(this.b.i(newAttributes), this.c.i(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public final boolean isTypeParameter() {
        F f6 = this.b;
        return (f6.c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && kotlin.jvm.internal.h.a(f6.c(), this.c.c());
    }

    @Override // a3.AbstractC0155s
    public final F j() {
        return this.b;
    }

    @Override // a3.AbstractC0155s
    public final String k(M2.s sVar, M2.s sVar2) {
        boolean debugMode = sVar2.d.getDebugMode();
        F f6 = this.c;
        F f7 = this.b;
        if (!debugMode) {
            return sVar.t(sVar.M(f7), sVar.M(f6), AbstractC0246d.O(this));
        }
        return "(" + sVar.M(f7) + ".." + sVar.M(f6) + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public final AbstractC0162z substitutionResult(AbstractC0162z replacement) {
        c0 c0VarA;
        kotlin.jvm.internal.h.f(replacement, "replacement");
        c0 c0VarF = replacement.f();
        if (c0VarF instanceof AbstractC0155s) {
            c0VarA = c0VarF;
        } else {
            if (!(c0VarF instanceof F)) {
                throw new C0.x();
            }
            F f6 = (F) c0VarF;
            c0VarA = C.a(f6, f6.g(true));
        }
        return kotlin.reflect.l.M(c0VarA, c0VarF);
    }

    @Override // a3.AbstractC0155s
    public final String toString() {
        return "(" + this.b + ".." + this.c + ')';
    }
}
