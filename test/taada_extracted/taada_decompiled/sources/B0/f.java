package b0;

import B.k;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1693a;
    public int b;
    public boolean c;
    public final Runnable d;
    public final /* synthetic */ CoordinatorLayout.Behavior e;

    public f(SideSheetBehavior sideSheetBehavior) {
        this.f1693a = 1;
        this.e = sideSheetBehavior;
        this.d = new androidx.constraintlayout.helper.widget.a(this, 5);
    }

    public final void a(int i) {
        switch (this.f1693a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.e;
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        ViewCompat.postOnAnimation((View) bottomSheetBehavior.U.get(), (k) this.d);
                        this.c = true;
                    }
                    break;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.e;
                WeakReference weakReference2 = sideSheetBehavior.f2574o;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        ViewCompat.postOnAnimation((View) sideSheetBehavior.f2574o.get(), (androidx.constraintlayout.helper.widget.a) this.d);
                        this.c = true;
                    }
                    break;
                }
                break;
        }
    }

    public f(BottomSheetBehavior bottomSheetBehavior) {
        this.f1693a = 0;
        this.e = bottomSheetBehavior;
        this.d = new k(this, 3);
    }
}
