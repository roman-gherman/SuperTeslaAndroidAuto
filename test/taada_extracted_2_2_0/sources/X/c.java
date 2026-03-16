package X;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends d {
    public int b;

    @Override // X.d
    public final void a(CoordinatorLayout coordinatorLayout, View view, int i) {
        AppBarLayout$ScrollingViewBehavior.b(coordinatorLayout.getDependencies(view));
        coordinatorLayout.onLayoutChild(view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i3, int i4, int i5) {
        int i6 = view.getLayoutParams().height;
        if (i6 != -1 && i6 != -2) {
            return false;
        }
        AppBarLayout$ScrollingViewBehavior.b(coordinatorLayout.getDependencies(view));
        return false;
    }
}
