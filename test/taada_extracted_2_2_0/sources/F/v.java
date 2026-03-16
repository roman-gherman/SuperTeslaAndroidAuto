package f;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3168a;
    public final int b;
    public final int c;
    public final int d;

    public v(m mVar, int i, int i3, int i4) {
        this.f3168a = mVar;
        this.b = i;
        this.c = i3;
        this.d = i4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        v vVar = (v) obj;
        int i = vVar.c;
        int i3 = this.c;
        return i3 != i ? kotlin.reflect.l.j(i3, i) : kotlin.reflect.l.j(this.d, vVar.d);
    }

    public final String toString() {
        int i = this.d;
        int i3 = this.c;
        int i4 = this.b;
        m mVar = this.f3168a;
        if (mVar == null) {
            return i4 + " " + i3 + " " + i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mVar.d.get(i4));
        sb.append(": ");
        sb.append((String) mVar.f3159f.get(i3));
        sb.append(" ");
        sb.append(i == 0 ? y.c : mVar.d(i).d());
        return sb.toString();
    }
}
