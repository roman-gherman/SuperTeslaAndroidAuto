package androidx.core.content.res;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1601a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i, int i3, Object obj) {
        this.f1601a = i3;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1601a) {
            case 0:
                ((ResourcesCompat.FontCallback) this.c).lambda$callbackFailAsync$1(this.b);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.c;
                View view = (View) sideSheetBehavior.f2574o.get();
                if (view != null) {
                    sideSheetBehavior.c(view, this.b, false);
                }
                break;
        }
    }
}
