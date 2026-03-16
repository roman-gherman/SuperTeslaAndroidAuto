package F2;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f352a;
    public final K2.f b;
    public final String[] c;
    public final String[] d;
    public final String[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f354g;

    public b(a kind, K2.f fVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i) {
        kotlin.jvm.internal.h.f(kind, "kind");
        this.f352a = kind;
        this.b = fVar;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f353f = str;
        this.f354g = i;
    }

    public final String toString() {
        return this.f352a + " version=" + this.b;
    }
}
