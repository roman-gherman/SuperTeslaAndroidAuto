package f;

/* JADX INFO: renamed from: f.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0436b implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3140a;
    public final int b;

    public C0436b(m mVar, int i) {
        this.f3140a = mVar;
        this.b = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.reflect.l.j(this.b, ((C0436b) obj).b);
    }

    public final String toString() {
        int i = this.b;
        m mVar = this.f3140a;
        return mVar == null ? String.valueOf(i) : ((v) mVar.f3160g.get(i)).toString();
    }
}
