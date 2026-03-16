package f;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3166a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public t(m mVar, int i, int i3, int i4, int i5) {
        this.f3166a = mVar;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        t tVar = (t) obj;
        int i = tVar.b;
        int i3 = this.b;
        return i3 != i ? s.a(i3, i) : kotlin.reflect.l.j(this.d, tVar.d);
    }

    public final String toString() {
        int i = this.d;
        int i3 = this.b;
        m mVar = this.f3166a;
        if (mVar == null) {
            return s.c(i3) + " " + i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.c(i3));
        sb.append(" ");
        int iB = s.b(i3);
        sb.append((iB == 0 || iB == 1 || iB == 2 || iB == 3) ? (Comparable) mVar.f3161h.get(i) : (Comparable) mVar.i.get(i));
        return sb.toString();
    }
}
