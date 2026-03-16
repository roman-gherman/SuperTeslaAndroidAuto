package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1615a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f1615a = i;
        this.b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f1615a) {
            case 0:
                return this.b.equals(obj);
            default:
                return ((Predicate) this.b).lambda$negate$1(obj);
        }
    }
}
