package com.google.common.collect;

import com.google.common.base.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class k extends l implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f2782a;
    private static final long serialVersionUID = 0;

    static {
        c cVar = c.f2780a;
        b bVar = b.f2779a;
        k kVar = new k();
        if (cVar != bVar && bVar != cVar) {
            f2782a = kVar;
            return;
        }
        StringBuilder sb = new StringBuilder("Invalid range: ");
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append("(-∞..+∞)");
        sb.append(sb2.toString());
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        ((Comparable) obj).getClass();
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        ((k) obj).getClass();
        c cVar = c.f2780a;
        if (!cVar.equals(cVar)) {
            return false;
        }
        b bVar = b.f2779a;
        return bVar.equals(bVar);
    }

    public final int hashCode() {
        return System.identityHashCode(b.f2779a) + (System.identityHashCode(c.f2780a) * 31);
    }

    public Object readResolve() {
        k kVar = f2782a;
        return equals(kVar) ? kVar : this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("(-∞");
        sb.append("..");
        sb.append("+∞)");
        return sb.toString();
    }
}
