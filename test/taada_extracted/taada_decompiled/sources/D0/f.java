package D0;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f c;
    public static final f d;
    public static final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f230h;
    public static final f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f f234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f f236o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f237a;
    public final String b;

    static {
        int i3 = 0;
        c = new f("TINK", i3);
        d = new f("CRUNCHY", i3);
        e = new f("LEGACY", i3);
        f228f = new f("NO_PREFIX", i3);
        int i4 = 1;
        f229g = new f("SHA1", i4);
        f230h = new f("SHA224", i4);
        i = new f("SHA256", i4);
        f231j = new f("SHA384", i4);
        f232k = new f("SHA512", i4);
        int i5 = 2;
        f233l = new f("TINK", i5);
        f234m = new f("CRUNCHY", i5);
        f235n = new f("LEGACY", i5);
        f236o = new f("NO_PREFIX", i5);
    }

    public /* synthetic */ f(String str, int i3) {
        this.f237a = i3;
        this.b = str;
    }

    public final String toString() {
        switch (this.f237a) {
        }
        return this.b;
    }
}
