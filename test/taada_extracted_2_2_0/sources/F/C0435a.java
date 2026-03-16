package f;

/* JADX INFO: renamed from: f.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0435a implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3139a;
    public final byte b;
    public final p c;

    public C0435a(m mVar, byte b, p pVar) {
        this.f3139a = mVar;
        this.b = b;
        this.c = pVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.c.compareTo(((C0435a) obj).c);
    }

    public final String toString() {
        p pVar = this.c;
        byte b = this.b;
        m mVar = this.f3139a;
        if (mVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) b);
            sb.append(" ");
            q qVar = new q(pVar, 29);
            qVar.c();
            sb.append(qVar.c);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((int) b);
        sb2.append(" ");
        q qVar2 = new q(pVar, 29);
        qVar2.c();
        sb2.append((String) mVar.f3159f.get(qVar2.c));
        return sb2.toString();
    }
}
