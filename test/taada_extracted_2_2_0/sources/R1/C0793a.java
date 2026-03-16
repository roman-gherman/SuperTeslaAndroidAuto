package r1;

/* JADX INFO: renamed from: r1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0793a extends E1.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E1.h f4681g = new E1.h("Before", 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final E1.h f4682h = new E1.h("State", 0);
    public static final E1.h i = new E1.h("After", 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final E1.h f4683j = new E1.h("Receive", 0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final E1.h f4684k = new E1.h("Parse", 0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final E1.h f4685l = new E1.h("Transform", 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final E1.h f4686m = new E1.h("State", 0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final E1.h f4687n = new E1.h("After", 0);
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4688f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0793a(int i3, boolean z6) {
        super(f4681g, f4682h, i);
        this.e = i3;
        switch (i3) {
            case 1:
                super(f4683j, f4684k, f4685l, f4686m, f4687n);
                this.f4688f = z6;
                break;
            default:
                this.f4688f = z6;
                break;
        }
    }

    @Override // E1.e
    public final boolean d() {
        switch (this.e) {
        }
        return this.f4688f;
    }
}
