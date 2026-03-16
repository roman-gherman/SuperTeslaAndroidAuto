package a3;

import a.AbstractC0132a;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes2.dex */
public final class Z {
    public static final Z b = e(W.f1541a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f1542a;

    public Z(W w5) {
        if (w5 != null) {
            this.f1542a = w5;
        } else {
            a(7);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.Z.a(int):void");
    }

    public static d0 b(d0 d0Var, d0 d0Var2) {
        if (d0Var == null) {
            a(38);
            throw null;
        }
        if (d0Var2 == null) {
            a(39);
            throw null;
        }
        d0 d0Var3 = d0.INVARIANT;
        if (d0Var == d0Var3) {
            if (d0Var2 != null) {
                return d0Var2;
            }
            a(40);
            throw null;
        }
        if (d0Var2 == d0Var3) {
            if (d0Var != null) {
                return d0Var;
            }
            a(41);
            throw null;
        }
        if (d0Var == d0Var2) {
            if (d0Var2 != null) {
                return d0Var2;
            }
            a(42);
            throw null;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + d0Var + "' and projection kind '" + d0Var2 + "' cannot be combined");
    }

    public static int c(d0 d0Var, d0 d0Var2) {
        d0 d0Var3 = d0.IN_VARIANCE;
        d0 d0Var4 = d0.OUT_VARIANCE;
        if (d0Var == d0Var3 && d0Var2 == d0Var4) {
            return 3;
        }
        return (d0Var == d0Var4 && d0Var2 == d0Var3) ? 2 : 1;
    }

    public static Z d(AbstractC0162z abstractC0162z) {
        if (abstractC0162z == null) {
            a(6);
            throw null;
        }
        return e(S.b.f(abstractC0162z.c(), abstractC0162z.a()));
    }

    public static Z e(W w5) {
        if (w5 != null) {
            return new Z(w5);
        }
        a(0);
        throw null;
    }

    public static Z f(W w5, W w6) {
        if (w5 == null) {
            a(3);
            throw null;
        }
        if (w6 == null) {
            a(4);
            throw null;
        }
        if (w5.e()) {
            w5 = w6;
        } else if (!w6.e()) {
            w5 = new r(w5, w6);
        }
        return e(w5);
    }

    public static String i(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (j3.p.f(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public final W g() {
        W w5 = this.f1542a;
        if (w5 != null) {
            return w5;
        }
        a(8);
        throw null;
    }

    public final AbstractC0162z h(AbstractC0162z abstractC0162z, d0 d0Var) {
        if (abstractC0162z == null) {
            a(9);
            throw null;
        }
        if (this.f1542a.e()) {
            return abstractC0162z;
        }
        try {
            AbstractC0162z type = k(new K(abstractC0162z, d0Var), null, 0).getType();
            if (type != null) {
                return type;
            }
            a(12);
            throw null;
        } catch (Y e) {
            return c3.j.c(c3.i.UNABLE_TO_SUBSTITUTE_TYPE, e.getMessage());
        }
    }

    public final AbstractC0162z j(AbstractC0162z abstractC0162z, d0 d0Var) {
        if (abstractC0162z == null) {
            a(14);
            throw null;
        }
        if (d0Var == null) {
            a(15);
            throw null;
        }
        TypeProjection k6 = new K(g().f(abstractC0162z, d0Var), d0Var);
        W w5 = this.f1542a;
        if (!w5.e()) {
            try {
                k6 = k(k6, null, 0);
            } catch (Y unused) {
                k6 = null;
            }
        }
        if (w5.a() || w5.b()) {
            boolean zB = w5.b();
            if (k6 == null) {
                k6 = null;
            } else if (!k6.isStarProjection()) {
                AbstractC0162z type = k6.getType();
                kotlin.jvm.internal.h.e(type, "typeProjection.type");
                if (b0.c(type, f3.b.f3194a)) {
                    d0 projectionKind = k6.getProjectionKind();
                    kotlin.jvm.internal.h.e(projectionKind, "typeProjection.projectionKind");
                    if (projectionKind == d0.OUT_VARIANCE) {
                        k6 = new K((AbstractC0162z) AbstractC0132a.g(type).b, projectionKind);
                    } else if (zB) {
                        k6 = new K((AbstractC0162z) AbstractC0132a.g(type).f3193a, projectionKind);
                    } else {
                        Z zE = e(new f3.c());
                        if (!zE.f1542a.e()) {
                            try {
                                k6 = zE.k(k6, null, 0);
                            } catch (Y unused2) {
                                k6 = null;
                            }
                        }
                    }
                }
            }
        }
        if (k6 == null) {
            return null;
        }
        return k6.getType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.types.TypeProjection k(kotlin.reflect.jvm.internal.impl.types.TypeProjection r18, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r19, int r20) throws a3.Y {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.Z.k(kotlin.reflect.jvm.internal.impl.types.TypeProjection, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, int):kotlin.reflect.jvm.internal.impl.types.TypeProjection");
    }
}
