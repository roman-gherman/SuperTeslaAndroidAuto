package R0;

import C0.t;
import android.app.Activity;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.C0257h;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.tenjin.android.store.TenjinDatasource$TenjinCallback;
import fr.sd.taada.billing.BillingManager;
import fr.sd.taada.helpers.ReviewRequestManager;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.mockito.plugins.MemberAccessor;
import s.j;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements TenjinDatasource$TenjinCallback, ProductDetailsResponseListener, AcknowledgePurchaseResponseListener, PurchasesResponseListener, OnCompleteListener, MemberAccessor.ConstructionDispatcher, SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1245a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.f1245a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.f1245a) {
            case 6:
                ((j) this.b).c.recordSuccess((Iterable) this.c);
                break;
            default:
                j jVar = (j) this.b;
                jVar.getClass();
                Iterator it = ((HashMap) this.c).entrySet().iterator();
                while (it.hasNext()) {
                    jVar.i.recordLogEventDropped(((Integer) r2.getValue()).intValue(), p.c.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
                }
                break;
        }
        return null;
    }

    @Override // org.mockito.plugins.MemberAccessor.ConstructionDispatcher
    public Object newInstance() {
        return ((Constructor) this.b).newInstance((Object[]) this.c);
    }

    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
    public void onAcknowledgePurchaseResponse(C0257h c0257h) {
        ((BillingManager) this.b).lambda$acknowledgePurchase$5((Purchase) this.c, c0257h);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(com.google.android.gms.tasks.b bVar) {
        ((ReviewRequestManager) this.b).lambda$processPendingReviewRequest$1((Activity) this.c, bVar);
    }

    @Override // com.tenjin.android.store.TenjinDatasource$TenjinCallback
    public void onEventsLoaded(List list) {
        if (list.isEmpty()) {
            t tVar = (t) this.b;
            ((ExecutorService) tVar.c).execute(new X0.f(tVar, (X0.a) this.c, 1));
        }
    }

    @Override // com.android.billingclient.api.ProductDetailsResponseListener
    public void onProductDetailsResponse(C0257h c0257h, List list) {
        ((BillingManager) this.b).lambda$queryAllProductDetails$2((ArrayList) this.c, c0257h, list);
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public void onQueryPurchasesResponse(C0257h c0257h, List list) {
        ((BillingManager) this.b).lambda$checkExistingPurchases$3((List) this.c, c0257h, list);
    }
}
