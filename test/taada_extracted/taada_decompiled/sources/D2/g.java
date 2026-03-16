package D2;

import a3.AbstractC0153p;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.M;
import a3.b0;
import a3.c0;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC0153p implements NotNullTypeParameter {
    public final F b;

    public g(F delegate) {
        kotlin.jvm.internal.h.f(delegate, "delegate");
        this.b = delegate;
    }

    @Override // a3.AbstractC0153p, a3.AbstractC0162z
    public final boolean d() {
        return false;
    }

    @Override // a3.F, a3.c0
    public final c0 i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return new g(this.b.i(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public final boolean isTypeParameter() {
        return true;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        return z6 ? this.b.g(true) : this;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return new g(this.b.i(newAttributes));
    }

    @Override // a3.AbstractC0153p
    public final F l() {
        return this.b;
    }

    @Override // a3.AbstractC0153p
    public final AbstractC0153p n(F f6) {
        return new g(f6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public final AbstractC0162z substitutionResult(AbstractC0162z replacement) {
        kotlin.jvm.internal.h.f(replacement, "replacement");
        c0 c0VarF = replacement.f();
        if (!b0.g(c0VarF) && !b0.f(c0VarF)) {
            return c0VarF;
        }
        if (c0VarF instanceof F) {
            F f6 = (F) c0VarF;
            F fG = f6.g(false);
            return !b0.g(f6) ? fG : new g(fG);
        }
        if (!(c0VarF instanceof AbstractC0155s)) {
            throw new IllegalStateException(("Incorrect type: " + c0VarF).toString());
        }
        AbstractC0155s abstractC0155s = (AbstractC0155s) c0VarF;
        F f7 = abstractC0155s.b;
        F fG2 = f7.g(false);
        if (b0.g(f7)) {
            fG2 = new g(fG2);
        }
        F f8 = abstractC0155s.c;
        F fG3 = f8.g(false);
        if (b0.g(f8)) {
            fG3 = new g(fG3);
        }
        return kotlin.reflect.l.k0(C.a(fG2, fG3), kotlin.reflect.l.z(c0VarF));
    }
}
