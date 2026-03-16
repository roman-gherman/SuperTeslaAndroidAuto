package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c4.AbstractC0246d;
import fr.sd.taada.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2201a;
    public int b;
    public int c;
    public TimeInterpolator d;
    public TimeInterpolator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPropertyAnimator f2204h;

    public interface OnScrollStateChangedListener {
        void onStateChanged(View view, int i);
    }

    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2201a = new LinkedHashSet();
        this.f2202f = 0;
        this.f2203g = 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f2202f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.b = AbstractC0246d.x0(view.getContext(), R.attr.motionDurationLong2, 225);
        this.c = AbstractC0246d.x0(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.d = AbstractC0246d.y0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, W.a.d);
        this.e = AbstractC0246d.y0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, W.a.c);
        return super.onLayoutChild(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i3, int i4, int i5, int i6, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f2201a;
        if (i3 > 0) {
            if (this.f2203g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.f2204h;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f2203g = 1;
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((OnScrollStateChangedListener) it.next()).onStateChanged(view, this.f2203g);
            }
            this.f2204h = view.animate().translationY(this.f2202f).setInterpolator(this.e).setDuration(this.c).setListener(new Z.a(this, 0));
            return;
        }
        if (i3 >= 0 || this.f2203g == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f2204h;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f2203g = 2;
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            ((OnScrollStateChangedListener) it2.next()).onStateChanged(view, this.f2203g);
        }
        this.f2204h = view.animate().translationY(0).setInterpolator(this.d).setDuration(this.b).setListener(new Z.a(this, 0));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i3) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2201a = new LinkedHashSet();
        this.f2202f = 0;
        this.f2203g = 2;
    }
}
