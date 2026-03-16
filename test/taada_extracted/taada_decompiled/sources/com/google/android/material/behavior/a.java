package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2209a;
    public int b = -1;
    public final /* synthetic */ SwipeDismissBehavior c;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.c = swipeDismissBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i, int i3) {
        int width;
        int width2;
        int width3;
        boolean z6 = ViewCompat.getLayoutDirection(view) == 1;
        int i4 = this.c.d;
        if (i4 == 0) {
            if (z6) {
                width = this.f2209a - view.getWidth();
                width2 = this.f2209a;
            } else {
                width = this.f2209a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i4 != 1) {
            width = this.f2209a - view.getWidth();
            width2 = view.getWidth() + this.f2209a;
        } else if (z6) {
            width = this.f2209a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f2209a - view.getWidth();
            width2 = this.f2209a;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i, int i3) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View view) {
        return view.getWidth();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewCaptured(View view, int i) {
        this.b = i;
        this.f2209a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.c;
            swipeDismissBehavior.c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.c = false;
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i) {
        this.c.getClass();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i, int i3, int i4, int i5) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.c;
        float f6 = width * swipeDismissBehavior.f2206f;
        float width2 = view.getWidth() * swipeDismissBehavior.f2207g;
        float fAbs = Math.abs(i - this.f2209a);
        if (fAbs <= f6) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f6) / (width2 - f6))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewReleased(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            com.google.android.material.behavior.SwipeDismissBehavior r2 = r8.c
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L37
            int r5 = androidx.core.view.ViewCompat.getLayoutDirection(r9)
            if (r5 != r3) goto L18
            r5 = r3
            goto L19
        L18:
            r5 = r4
        L19:
            int r6 = r2.d
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L64
            goto L50
        L28:
            if (r1 <= 0) goto L64
            goto L50
        L2b:
            if (r6 != r3) goto L64
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L64
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L64
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.f2209a
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r2.e
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L64
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.f2209a
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L67
        L5f:
            int r10 = r8.f2209a
            int r0 = r10 - r11
            goto L67
        L64:
            int r0 = r8.f2209a
            r3 = r4
        L67:
            androidx.customview.widget.ViewDragHelper r10 = r2.f2205a
            int r11 = r9.getTop()
            boolean r10 = r10.settleCapturedViewAt(r0, r11)
            if (r10 == 0) goto L7b
            com.google.android.material.behavior.c r10 = new com.google.android.material.behavior.c
            r10.<init>(r2, r9, r3)
            androidx.core.view.ViewCompat.postOnAnimation(r9, r10)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.a.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i) {
        int i3 = this.b;
        return (i3 == -1 || i3 == i) && this.c.a(view);
    }
}
