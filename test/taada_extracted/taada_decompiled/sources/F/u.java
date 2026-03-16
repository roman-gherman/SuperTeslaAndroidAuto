package f;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3167a;
    public final int b;
    public final int c;
    public final int d;

    public u(m mVar, int i, int i3, int i4) {
        this.f3167a = mVar;
        this.b = i;
        this.c = i3;
        this.d = i4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        u uVar = (u) obj;
        int i = uVar.b;
        int i3 = this.b;
        if (i3 != i) {
            return kotlin.reflect.l.j(i3, i);
        }
        int i4 = this.d;
        int i5 = uVar.d;
        return i4 != i5 ? kotlin.reflect.l.j(i4, i5) : kotlin.reflect.l.j(this.c, uVar.c);
    }

    public final String toString() {
        int i = this.d;
        int i3 = this.c;
        int i4 = this.b;
        m mVar = this.f3167a;
        if (mVar == null) {
            return i4 + " " + i3 + " " + i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) mVar.f3159f.get(i4));
        sb.append(".");
        sb.append(mVar.d.get(i));
        int i5 = ((v) mVar.f3160g.get(i3)).d;
        sb.append(i5 == 0 ? y.c : mVar.d(i5).d());
        return sb.toString();
    }
}
