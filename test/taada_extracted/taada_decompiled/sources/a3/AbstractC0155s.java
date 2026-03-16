package a3;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;

/* JADX INFO: renamed from: a3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0155s extends c0 implements FlexibleTypeMarker {
    public final F b;
    public final F c;

    public AbstractC0155s(F lowerBound, F upperBound) {
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
        this.b = lowerBound;
        this.c = upperBound;
    }

    @Override // a3.AbstractC0162z
    public final List a() {
        return j().a();
    }

    @Override // a3.AbstractC0162z
    public final M b() {
        return j().b();
    }

    @Override // a3.AbstractC0162z
    public final TypeConstructor c() {
        return j().c();
    }

    @Override // a3.AbstractC0162z
    public final boolean d() {
        return j().d();
    }

    @Override // a3.AbstractC0162z
    public MemberScope getMemberScope() {
        return j().getMemberScope();
    }

    public abstract F j();

    public abstract String k(M2.s sVar, M2.s sVar2);

    public String toString() {
        return M2.n.c.M(this);
    }
}
