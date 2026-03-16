package B;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.customview.widget.ViewDragHelper;
import com.android.billingclient.api.C0253d;
import com.android.billingclient.api.C0257h;
import com.android.billingclient.api.H;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f100a;
    public final Object b;

    public k(i iVar, com.android.billingclient.api.z zVar) {
        this.f100a = 2;
        this.b = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f100a) {
            case 0:
                ((m) this.b).e();
                return;
            case 1:
                Api$Client api$Client = ((m) ((g) this.b).b).b;
                api$Client.disconnect(api$Client.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 2:
                throw null;
            case 3:
                b0.f fVar = (b0.f) this.b;
                fVar.c = false;
                ViewDragHelper viewDragHelper = ((BottomSheetBehavior) fVar.e).f2222M;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    fVar.a(fVar.b);
                    return;
                }
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) fVar.e;
                if (bottomSheetBehavior.f2221L == 2) {
                    bottomSheetBehavior.i(fVar.b);
                    return;
                }
                return;
            case 4:
                com.android.billingclient.api.w wVar = (com.android.billingclient.api.w) this.b;
                C0253d c0253d = wVar.b;
                c0253d.n(0);
                C0257h c0257h = H.f1812l;
                c0253d.u(24, 6, c0257h);
                wVar.a(c0257h);
                return;
            default:
                View view = (View) this.b;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
                return;
        }
    }

    public /* synthetic */ k(Object obj, int i) {
        this.f100a = i;
        this.b = obj;
    }
}
