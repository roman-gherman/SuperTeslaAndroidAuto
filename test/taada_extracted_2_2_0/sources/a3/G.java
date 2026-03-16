package a3;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends F {
    public final TypeConstructor b;
    public final List c;
    public final boolean d;
    public final MemberScope e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1 f1531f;

    public G(TypeConstructor constructor, List arguments, boolean z6, MemberScope memberScope, Function1 function1) {
        kotlin.jvm.internal.h.f(constructor, "constructor");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        kotlin.jvm.internal.h.f(memberScope, "memberScope");
        this.b = constructor;
        this.c = arguments;
        this.d = z6;
        this.e = memberScope;
        this.f1531f = function1;
        if (!(memberScope instanceof c3.f) || (memberScope instanceof c3.k)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + memberScope + '\n' + constructor);
    }

    @Override // a3.AbstractC0162z
    public final List a() {
        return this.c;
    }

    @Override // a3.AbstractC0162z
    public final M b() {
        M.b.getClass();
        return M.c;
    }

    @Override // a3.AbstractC0162z
    public final TypeConstructor c() {
        return this.b;
    }

    @Override // a3.AbstractC0162z
    public final boolean d() {
        return this.d;
    }

    @Override // a3.AbstractC0162z
    public final AbstractC0162z e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F f6 = (F) this.f1531f.invoke(kotlinTypeRefiner);
        return f6 == null ? this : f6;
    }

    @Override // a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        return this.e;
    }

    @Override // a3.c0
    /* JADX INFO: renamed from: h */
    public final c0 e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F f6 = (F) this.f1531f.invoke(kotlinTypeRefiner);
        return f6 == null ? this : f6;
    }

    @Override // a3.F
    /* JADX INFO: renamed from: j */
    public final F g(boolean z6) {
        return z6 == this.d ? this : z6 ? new E(this, 1) : new E(this, 0);
    }

    @Override // a3.F
    /* JADX INFO: renamed from: k */
    public final F i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new H(this, newAttributes);
    }
}
