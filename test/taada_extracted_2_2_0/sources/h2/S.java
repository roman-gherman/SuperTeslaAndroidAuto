package h2;

import a.AbstractC0132a;
import java.util.Collection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import t2.AbstractC0823e;
import v2.EnumC0851b;

/* JADX INFO: loaded from: classes2.dex */
public final class S extends D {
    public final Class b;
    public final r0 c;

    public S(Class jClass) {
        kotlin.jvm.internal.h.f(jClass, "jClass");
        this.b = jClass;
        this.c = new r0(new M(this, 1));
    }

    @Override // h2.D
    public final Collection c() {
        return kotlin.collections.u.f3805a;
    }

    @Override // h2.D
    public final Collection d(L2.f fVar) {
        P p5 = (P) this.c.invoke();
        p5.getClass();
        KProperty kProperty = P.f3378h[1];
        Object objInvoke = p5.d.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-scope>(...)");
        return ((MemberScope) objInvoke).getContributedFunctions(fVar, EnumC0851b.b);
    }

    @Override // h2.D
    public final PropertyDescriptor e(int i) {
        P p5 = (P) this.c.invoke();
        p5.getClass();
        KProperty kProperty = P.f3378h[3];
        N1.k kVar = (N1.k) p5.f3379f.invoke();
        if (kVar == null) {
            return null;
        }
        K2.g gVar = (K2.g) kVar.f1127a;
        G2.D d = (G2.D) kVar.b;
        K2.f fVar = (K2.f) kVar.c;
        kotlin.reflect.jvm.internal.impl.protobuf.o packageLocalVariable = J2.l.f872n;
        kotlin.jvm.internal.h.e(packageLocalVariable, "packageLocalVariable");
        G2.H h3 = (G2.H) AbstractC0132a.E(d, packageLocalVariable, i);
        if (h3 == null) {
            return null;
        }
        G2.b0 b0Var = d.f430g;
        kotlin.jvm.internal.h.e(b0Var, "packageProto.typeTable");
        return (PropertyDescriptor) x0.f(this.b, h3, gVar, new I2.f(b0Var), fVar, Q.f3381a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof S) {
            return kotlin.jvm.internal.h.a(this.b, ((S) obj).b);
        }
        return false;
    }

    @Override // h2.D
    public final Class g() {
        P p5 = (P) this.c.invoke();
        p5.getClass();
        KProperty kProperty = P.f3378h[2];
        Class cls = (Class) p5.e.invoke();
        return cls == null ? this.b : cls;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.b;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public final Collection getMembers() {
        P p5 = (P) this.c.invoke();
        p5.getClass();
        KProperty kProperty = P.f3378h[4];
        Object objInvoke = p5.f3380g.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-members>(...)");
        return (Collection) objInvoke;
    }

    @Override // h2.D
    public final Collection h(L2.f fVar) {
        P p5 = (P) this.c.invoke();
        p5.getClass();
        KProperty kProperty = P.f3378h[1];
        Object objInvoke = p5.d.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-scope>(...)");
        return ((MemberScope) objInvoke).getContributedVariables(fVar, EnumC0851b.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "file class " + AbstractC0823e.a(this.b).b();
    }
}
