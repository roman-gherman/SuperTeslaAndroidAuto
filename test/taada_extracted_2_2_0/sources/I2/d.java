package I2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f764a;
    public final int b;

    public d(int i, int i3) {
        this.f764a = i;
        this.b = i3;
    }

    public static b a(d dVar) {
        return new b(dVar.f764a + dVar.b);
    }

    public static b b() {
        return new b(0);
    }
}
