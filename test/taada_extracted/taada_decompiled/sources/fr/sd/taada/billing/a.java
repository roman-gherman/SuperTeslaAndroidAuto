package fr.sd.taada.billing;

import com.android.billingclient.api.C0257h;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements ProductDetailsResponseListener, PurchasesResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BillingManager f3269a;

    public /* synthetic */ a(BillingManager billingManager) {
        this.f3269a = billingManager;
    }

    @Override // com.android.billingclient.api.ProductDetailsResponseListener
    public void onProductDetailsResponse(C0257h c0257h, List list) {
        this.f3269a.lambda$queryAllProductDetails$1(c0257h, list);
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public void onQueryPurchasesResponse(C0257h c0257h, List list) {
        this.f3269a.lambda$checkExistingPurchases$4(c0257h, list);
    }
}
