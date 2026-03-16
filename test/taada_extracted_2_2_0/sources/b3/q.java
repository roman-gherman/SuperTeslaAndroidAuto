package b3;

import a.AbstractC0132a;
import a3.C0152o;
import a3.O;
import a3.c0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f1709a;
    public static final m b;
    public static final p c;
    public static final n d;
    public static final /* synthetic */ q[] e;

    static {
        o oVar = new o();
        f1709a = oVar;
        m mVar = new m();
        b = mVar;
        p pVar = new p();
        c = pVar;
        n nVar = new n();
        d = nVar;
        e = new q[]{oVar, mVar, pVar, nVar};
    }

    public static q b(c0 c0Var) {
        kotlin.jvm.internal.h.f(c0Var, "<this>");
        if (c0Var.d()) {
            return b;
        }
        if (c0Var instanceof C0152o) {
        }
        return kotlin.reflect.l.L(e.n(false, null, 24), AbstractC0132a.Q(c0Var), O.b) ? d : c;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) e.clone();
    }

    public abstract q a(c0 c0Var);
}
