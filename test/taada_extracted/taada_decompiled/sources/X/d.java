package X;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends CoordinatorLayout.Behavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1403a;

    public void a(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.onLayoutChild(view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        a(coordinatorLayout, view, i);
        if (this.f1403a == null) {
            this.f1403a = new e(view);
        }
        e eVar = this.f1403a;
        View view2 = (View) eVar.d;
        eVar.b = view2.getTop();
        eVar.c = view2.getLeft();
        e eVar2 = this.f1403a;
        View view3 = (View) eVar2.d;
        ViewCompat.offsetTopAndBottom(view3, 0 - (view3.getTop() - eVar2.b));
        ViewCompat.offsetLeftAndRight(view3, 0 - (view3.getLeft() - eVar2.c));
        return true;
    }
}
