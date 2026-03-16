package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Serializable f2099a;
    public m2 b;
    public n2 c;
    public boolean d;

    public final void finalize() {
        n2 n2Var;
        m2 m2Var = this.b;
        if (m2Var != null) {
            l2 l2Var = m2Var.b;
            if (!l2Var.isDone()) {
                if (j2.f2094f.u(l2Var, null, new C0290j1(new E1.c("The completer object was garbage collected - this future would otherwise never complete. The tag was: ".concat(String.valueOf(this.f2099a)), 3)))) {
                    j2.b(l2Var);
                }
            }
        }
        if (this.d || (n2Var = this.c) == null) {
            return;
        }
        n2Var.g(null);
    }
}
