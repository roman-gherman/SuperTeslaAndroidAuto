package g3;

import a3.C0148k;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC0484a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0148k f3320a;
    public final int b;

    public r(int i, C0148k c0148k) {
        this.f3320a = c0148k;
        this.b = i;
    }

    @Override // g3.AbstractC0484a
    public final int a() {
        return 1;
    }

    @Override // g3.AbstractC0484a
    public final void b(int i, C0148k c0148k) {
        throw new IllegalStateException();
    }

    @Override // g3.AbstractC0484a
    public final Object get(int i) {
        if (i == this.b) {
            return this.f3320a;
        }
        return null;
    }

    @Override // g3.AbstractC0484a, java.lang.Iterable
    public final Iterator iterator() {
        return new q(this);
    }
}
