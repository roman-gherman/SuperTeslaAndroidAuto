package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final b i;

    public BaseTransientBottomBar$Behavior() {
        b bVar = new b();
        this.f2206f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f2207g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.d = 0;
        this.i = bVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean a(View view) {
        this.i.getClass();
        return view instanceof d;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.i.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (f.b == null) {
                    f.b = new f();
                }
                synchronized (f.b.f2591a) {
                }
            }
        } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (f.b == null) {
                f.b = new f();
            }
            synchronized (f.b.f2591a) {
            }
        }
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
