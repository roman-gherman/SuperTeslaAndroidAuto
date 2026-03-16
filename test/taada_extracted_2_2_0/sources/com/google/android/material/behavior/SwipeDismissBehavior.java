package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewDragHelper f2205a;
    public boolean b;
    public boolean c;
    public int d = 2;
    public final float e = 0.5f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2206f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2207g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f2208h = new a(this);

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    public boolean a(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.b = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b = false;
        }
        if (zIsPointInChildBounds) {
            if (this.f2205a == null) {
                this.f2205a = ViewDragHelper.create(coordinatorLayout, this.f2208h);
            }
            if (!this.c && this.f2205a.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, view, i);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            if (a(view)) {
                ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b(this));
            }
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f2205a == null) {
            return false;
        }
        if (this.c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f2205a.processTouchEvent(motionEvent);
        return true;
    }
}
