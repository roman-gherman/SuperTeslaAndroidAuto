package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.AbstractC0289j0;
import com.google.android.gms.internal.play_billing.C0329x;
import com.google.android.gms.internal.play_billing.O;
import fr.sd.taada.billing.BillingManager;
import java.util.ArrayList;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1856a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ r(int i, Object obj, Object obj2) {
        this.f1856a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1856a) {
            case 0:
                C0253d c0253d = (C0253d) this.b;
                c0253d.getClass();
                C0257h c0257h = H.f1812l;
                c0253d.u(24, 9, c0257h);
                C0329x c0329x = com.google.android.gms.internal.play_billing.A.b;
                ((PurchasesResponseListener) this.c).onQueryPurchasesResponse(c0257h, O.e);
                break;
            case 1:
                Future future = (Future) this.b;
                if (!future.isDone() && !future.isCancelled()) {
                    future.cancel(true);
                    AbstractC0289j0.f("BillingClient", "Async task is taking too long, cancel it!");
                    Runnable runnable = (Runnable) this.c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    break;
                }
                break;
            case 2:
                C0253d c0253d2 = (C0253d) this.b;
                c0253d2.getClass();
                C0257h c0257h2 = H.f1812l;
                c0253d2.u(24, 7, c0257h2);
                ((ProductDetailsResponseListener) this.c).onProductDetailsResponse(c0257h2, new ArrayList());
                break;
            case 3:
                C0253d c0253d3 = (C0253d) this.b;
                C0257h c0257h3 = (C0257h) this.c;
                if (((BillingManager) c0253d3.e.c) == null) {
                    AbstractC0289j0.f("BillingClient", "No valid listener is set in BroadcastManager");
                } else {
                    ((BillingManager) c0253d3.e.c).onPurchasesUpdated(c0257h3, null);
                }
                break;
            default:
                C0253d c0253d4 = (C0253d) this.b;
                c0253d4.getClass();
                C0257h c0257h4 = H.f1812l;
                c0253d4.u(24, 3, c0257h4);
                ((R0.d) this.c).onAcknowledgePurchaseResponse(c0257h4);
                break;
        }
    }
}
