package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class M extends N {
    public static final M c = new M(C0314s.c, C0314s.b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0317t f2044a;
    public final AbstractC0317t b;

    public M(AbstractC0317t abstractC0317t, AbstractC0317t abstractC0317t2) {
        this.f2044a = abstractC0317t;
        this.b = abstractC0317t2;
        if (abstractC0317t.a(abstractC0317t2) > 0 || abstractC0317t == C0314s.b || abstractC0317t2 == C0314s.c) {
            StringBuilder sb = new StringBuilder(16);
            abstractC0317t.b(sb);
            sb.append("..");
            abstractC0317t2.c(sb);
            throw new IllegalArgumentException("Invalid range: ".concat(sb.toString()));
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof M) {
            M m6 = (M) obj;
            if (this.f2044a.equals(m6.f2044a) && this.b.equals(m6.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f2044a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(16);
        this.f2044a.b(sb);
        sb.append("..");
        this.b.c(sb);
        return sb.toString();
    }
}
