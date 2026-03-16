package k;

import com.google.android.gms.internal.play_billing.a2;

/* JADX INFO: renamed from: k.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0568a extends AbstractC0570c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2 f3675a;

    public C0568a(a2 a2Var) {
        this.f3675a = a2Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0570c)) {
            return false;
        }
        C0568a c0568a = (C0568a) ((AbstractC0570c) obj);
        c0568a.getClass();
        if (!this.f3675a.equals(c0568a.f3675a)) {
            return false;
        }
        Object obj2 = d.f3677a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return d.f3677a.hashCode() ^ (((1000003 * 1000003) ^ this.f3675a.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f3675a + ", priority=" + d.f3677a + "}";
    }
}
