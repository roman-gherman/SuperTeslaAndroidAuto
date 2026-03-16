package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0314s extends AbstractC0317t {
    public static final C0314s b = new C0314s(0);
    public static final C0314s c = new C0314s(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2123a;

    public /* synthetic */ C0314s(int i) {
        this.f2123a = i;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0317t
    public final int a(AbstractC0317t abstractC0317t) {
        switch (this.f2123a) {
            case 0:
                return abstractC0317t == this ? 0 : 1;
            default:
                return abstractC0317t == this ? 0 : -1;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0317t
    public final void b(StringBuilder sb) {
        switch (this.f2123a) {
            case 0:
                throw new AssertionError();
            default:
                sb.append("(-∞");
                return;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0317t
    public final void c(StringBuilder sb) {
        switch (this.f2123a) {
            case 0:
                sb.append("+∞)");
                return;
            default:
                throw new AssertionError();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        switch (this.f2123a) {
            case 0:
                return ((AbstractC0317t) obj) == this ? 0 : 1;
            default:
                return ((AbstractC0317t) obj) == this ? 0 : -1;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC0317t
    public final int hashCode() {
        switch (this.f2123a) {
        }
        return System.identityHashCode(this);
    }

    public final String toString() {
        switch (this.f2123a) {
            case 0:
                return "+∞";
            default:
                return "-∞";
        }
    }
}
