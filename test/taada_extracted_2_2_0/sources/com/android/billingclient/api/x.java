package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1862a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x(Object obj, int i) {
        this.f1862a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f1862a) {
            case 0:
                ArrayList arrayList = new ArrayList();
                ((ProductDetailsResponseListener) this.b).onProductDetailsResponse((C0257h) obj, arrayList);
                break;
            default:
                ((R0.d) this.b).onAcknowledgePurchaseResponse((C0257h) obj);
                break;
        }
    }
}
