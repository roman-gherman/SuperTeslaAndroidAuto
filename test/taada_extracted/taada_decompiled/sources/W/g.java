package W;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1384a;
    public TimeInterpolator c = null;
    public int d = 0;
    public int e = 1;
    public long b = 150;

    public g(long j6) {
        this.f1384a = j6;
    }

    public final void a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.f1384a);
        objectAnimator.setDuration(this.b);
        objectAnimator.setInterpolator(b());
        objectAnimator.setRepeatCount(this.d);
        objectAnimator.setRepeatMode(this.e);
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f1384a == gVar.f1384a && this.b == gVar.b && this.d == gVar.d && this.e == gVar.e) {
            return b().getClass().equals(gVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j6 = this.f1384a;
        long j7 = this.b;
        return ((((b().getClass().hashCode() + (((((int) (j6 ^ (j6 >>> 32))) * 31) + ((int) ((j7 >>> 32) ^ j7))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(g.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f1384a);
        sb.append(" duration: ");
        sb.append(this.b);
        sb.append(" interpolator: ");
        sb.append(b().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.d);
        sb.append(" repeatMode: ");
        return B2.b.g(sb, "}\n", this.e);
    }
}
