package r1;

/* JADX INFO: renamed from: r1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0793a extends E1.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final E1.h f4680g = new E1.h("Before", 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final E1.h f4681h = new E1.h("State", 0);
    public static final E1.h i = new E1.h("After", 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final E1.h f4682j = new E1.h("Receive", 0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final E1.h f4683k = new E1.h("Parse", 0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final E1.h f4684l = new E1.h("Transform", 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final E1.h f4685m = new E1.h("State", 0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final E1.h f4686n = new E1.h("After", 0);
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4687f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0793a(int i3, boolean z6) {
        super(f4680g, f4681h, i);
        this.e = i3;
        switch (i3) {
            case 1:
                super(f4682j, f4683k, f4684l, f4685m, f4686n);
                this.f4687f = z6;
                break;
            default:
                this.f4687f = z6;
                break;
        }
    }

    @Override // E1.e
    public final boolean d() {
        switch (this.e) {
        }
        return this.f4687f;
    }
}
