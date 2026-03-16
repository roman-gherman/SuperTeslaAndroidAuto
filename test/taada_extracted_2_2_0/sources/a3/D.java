package a3;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends AbstractC0162z {
    public final Z2.n b;
    public final kotlin.jvm.internal.i c;
    public final NotNullLazyValue d;

    /* JADX WARN: Multi-variable type inference failed */
    public D(Z2.n storageManager, Function0 function0) {
        kotlin.jvm.internal.h.f(storageManager, "storageManager");
        this.b = storageManager;
        this.c = (kotlin.jvm.internal.i) function0;
        this.d = storageManager.createLazyValue(function0);
    }

    @Override // a3.AbstractC0162z
    public final List a() {
        return g().a();
    }

    @Override // a3.AbstractC0162z
    public final M b() {
        return g().b();
    }

    @Override // a3.AbstractC0162z
    public final TypeConstructor c() {
        return g().c();
    }

    @Override // a3.AbstractC0162z
    public final boolean d() {
        return g().d();
    }

    @Override // a3.AbstractC0162z
    public final AbstractC0162z e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new D(this.b, new A2.y(3, kotlinTypeRefiner, this));
    }

    @Override // a3.AbstractC0162z
    public final c0 f() {
        AbstractC0162z abstractC0162zG = g();
        while (abstractC0162zG instanceof D) {
            abstractC0162zG = ((D) abstractC0162zG).g();
        }
        kotlin.jvm.internal.h.d(abstractC0162zG, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (c0) abstractC0162zG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC0162z g() {
        return (AbstractC0162z) this.d.invoke();
    }

    @Override // a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        return g().getMemberScope();
    }

    public final String toString() {
        return this.d.isComputed() ? g().toString() : "<Not computed yet>";
    }
}
