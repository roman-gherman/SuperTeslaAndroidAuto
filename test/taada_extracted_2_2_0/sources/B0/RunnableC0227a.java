package b0;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: renamed from: b0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0227a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1688a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BottomSheetBehavior c;

    public RunnableC0227a(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.c = bottomSheetBehavior;
        this.f1688a = view;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.k(this.f1688a, this.b, false);
    }
}
