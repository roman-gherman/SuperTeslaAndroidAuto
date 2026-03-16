package b0;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: b0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0230d extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f1691a;

    public C0230d(BottomSheetBehavior bottomSheetBehavior) {
        this.f1691a = bottomSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i, int i3) {
        return view.getLeft();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i, int i3) {
        return MathUtils.clamp(i, this.f1691a.f(), getViewVerticalDragRange(view));
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewVerticalDragRange(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f1691a;
        return bottomSheetBehavior.I ? bottomSheetBehavior.f2227T : bottomSheetBehavior.f2219G;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i) {
        if (i == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f1691a;
            if (bottomSheetBehavior.f2220K) {
                bottomSheetBehavior.i(1);
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i, int i3, int i4, int i5) {
        this.f1691a.c(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewReleased(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C0230d.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i) {
        BottomSheetBehavior bottomSheetBehavior = this.f1691a;
        int i3 = bottomSheetBehavior.f2221L;
        if (i3 == 1 || bottomSheetBehavior.f2234a0) {
            return false;
        }
        if (i3 == 3 && bottomSheetBehavior.f2231Y == i) {
            WeakReference weakReference = bottomSheetBehavior.f2228V;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        System.currentTimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.U;
        return weakReference2 != null && weakReference2.get() == view;
    }
}
