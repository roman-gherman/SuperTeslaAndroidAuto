package f;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3164a;
    public final int b;
    public final int c;
    public final int d;

    public r(m mVar, int i, int i3, int i4) {
        this.f3164a = mVar;
        this.b = i;
        this.c = i3;
        this.d = i4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        r rVar = (r) obj;
        int i = rVar.b;
        int i3 = this.b;
        if (i3 != i) {
            return kotlin.reflect.l.j(i3, i);
        }
        int i4 = this.d;
        int i5 = rVar.d;
        return i4 != i5 ? kotlin.reflect.l.j(i4, i5) : kotlin.reflect.l.j(this.c, rVar.c);
    }

    public final String toString() {
        int i = this.d;
        int i3 = this.c;
        m mVar = this.f3164a;
        if (mVar != null) {
            return ((String) mVar.f3159f.get(i3)) + "." + ((String) mVar.d.get(i));
        }
        return this.b + " " + i3 + " " + i;
    }
}
