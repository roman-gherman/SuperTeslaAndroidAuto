package q1;

import E1.h;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends E1.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f4518g = new h("Before", 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f4519h = new h("State", 0);
    public static final h i = new h("Transform", 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h f4520j = new h("Render", 0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h f4521k = new h("Send", 0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final h f4522l = new h("Before", 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final h f4523m = new h("State", 0);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final h f4524n = new h("Monitoring", 0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final h f4525o = new h("Engine", 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final h f4526p = new h("Receive", 0);
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4527f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, boolean z6) {
        super(f4518g, f4519h, i, f4520j, f4521k);
        this.e = i3;
        switch (i3) {
            case 1:
                super(f4522l, f4523m, f4524n, f4525o, f4526p);
                this.f4527f = z6;
                break;
            default:
                this.f4527f = z6;
                break;
        }
    }

    @Override // E1.e
    public final boolean d() {
        switch (this.e) {
        }
        return this.f4527f;
    }
}
