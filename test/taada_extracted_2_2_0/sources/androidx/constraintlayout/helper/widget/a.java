package androidx.constraintlayout.helper.widget;

import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.room.InvalidationTracker;
import androidx.work.CoroutineWorker;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import b0.f;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.c;
import com.google.android.material.textfield.i;
import fr.sd.taada.DemoModeHandler;
import fr.sd.taada.activities.HomeActivity;
import fr.sd.taada.billing.BillingManager;
import fr.sd.taada.billing.SubscriptionViewModel;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.service.ServiceRestartScheduler;
import java.util.ArrayList;
import kotlinx.coroutines.Job;
import s.k;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1591a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1591a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1591a) {
            case 0:
                ((Carousel) this.b).lambda$updateItems$0();
                break;
            case 1:
                DefaultSpecialEffectsController.startTransitions$lambda$11((ArrayList) this.b);
                break;
            case 2:
                ((Fragment) this.b).lambda$performCreateView$0();
                break;
            case 3:
                ((InvalidationTracker) this.b).onAutoCloseCallback();
                break;
            case 4:
                CoroutineWorker._init_$lambda$0((CoroutineWorker) this.b);
                break;
            case 5:
                f fVar = (f) this.b;
                fVar.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) fVar.e;
                ViewDragHelper viewDragHelper = sideSheetBehavior.i;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    fVar.a(fVar.b);
                } else if (sideSheetBehavior.f2568h == 2) {
                    sideSheetBehavior.a(fVar.b);
                }
                break;
            case 6:
                ((c) this.b).t(true);
                break;
            case 7:
                i iVar = (i) this.b;
                boolean zIsPopupShowing = iVar.f2662h.isPopupShowing();
                iVar.t(zIsPopupShowing);
                iVar.f2666m = zIsPopupShowing;
                break;
            case 8:
                ConstraintTrackingWorker.startWork$lambda$0((ConstraintTrackingWorker) this.b);
                break;
            case 9:
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$1((Job) this.b);
                break;
            case 10:
                ((ServiceRestartScheduler) this.b).lambda$scheduleRestart$0();
                break;
            case 11:
                ((DemoModeHandler) this.b).lambda$handleDemoModeExpired$0();
                break;
            case 12:
                ((HomeActivity) this.b).lambda$togglePermissionsDropdown$26();
                break;
            case 13:
                ((BillingManager) this.b).lambda$scheduleAutomaticReconnection$0();
                break;
            case 14:
                ((SubscriptionViewModel) this.b).lambda$setupDataObservers$0();
                break;
            case 15:
                ((DemoModeManager) this.b).lambda$onDemoExpired$0();
                break;
            default:
                k kVar = (k) this.b;
                kVar.getClass();
                kVar.d.runCriticalSection(new R0.a(kVar, 15));
                break;
        }
    }
}
