package com.android.billingclient.api;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1863a;
    public final /* synthetic */ D b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ y(D d, Object obj, Object obj2, int i) {
        this.f1863a = i;
        this.b = d;
        this.c = obj;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1863a) {
            case 0:
                this.b.y((o) this.c, (ProductDetailsResponseListener) this.d);
                break;
            default:
                this.b.x((E1.h) this.c, (R0.d) this.d);
                break;
        }
    }
}
