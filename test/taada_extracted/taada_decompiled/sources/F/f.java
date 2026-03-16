package f;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3144a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3147h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f3148j;

    public f(m mVar, int i, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f3144a = mVar;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f3145f = i6;
        this.f3146g = i7;
        this.f3147h = i8;
        this.i = i9;
        this.f3148j = i10;
    }

    public final String toString() {
        int i = this.c;
        int i3 = this.e;
        m mVar = this.f3144a;
        if (mVar == null) {
            return i + " " + i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((String) mVar.f3159f.get(i));
        if (i3 != -1) {
            sb.append(" extends ");
            sb.append((String) mVar.f3159f.get(i3));
        }
        return sb.toString();
    }
}
