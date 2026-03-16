package I3;

import c4.AbstractC0243a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0243a f793a;

    public abstract AbstractC0243a a();

    public final synchronized AbstractC0243a b() {
        try {
            if (this.f793a == null) {
                this.f793a = a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f793a;
    }
}
