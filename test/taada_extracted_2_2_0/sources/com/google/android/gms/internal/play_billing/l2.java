package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class l2 extends j2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ m2 f2102h;

    public l2(m2 m2Var) {
        this.f2102h = m2Var;
    }

    @Override // com.google.android.gms.internal.play_billing.j2
    public final String a() {
        k2 k2Var = (k2) this.f2102h.f2106a.get();
        return k2Var == null ? "Completer object has been garbage collected, future will fail soon" : androidx.constraintlayout.core.motion.a.q("tag=[", String.valueOf(k2Var.f2099a), "]");
    }
}
