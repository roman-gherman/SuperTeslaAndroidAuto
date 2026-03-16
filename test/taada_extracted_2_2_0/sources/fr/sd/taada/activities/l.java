package fr.sd.taada.activities;

import android.view.MutableLiveData;
import android.view.Observer;
import fr.sd.taada.billing.BillingManager;
import fr.sd.taada.billing.SubscriptionState;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3269a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(Object obj, int i) {
        this.f3269a = i;
        this.b = obj;
    }

    @Override // android.view.Observer
    public final void onChanged(Object obj) {
        switch (this.f3269a) {
            case 0:
                ((SubscriptionActivity) this.b).lambda$observeViewModel$4((SubscriptionState) obj);
                break;
            case 1:
                ((SubscriptionActivity) this.b).updatePrices((List) obj);
                break;
            default:
                BillingManager.lambda$getProductDetails$6((MutableLiveData) this.b, (List) obj);
                break;
        }
    }
}
