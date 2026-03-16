package X;

import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends d {
    public boolean b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f1402f;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, android.view.MotionEvent r10) {
        /*
            r7 = this;
            int r0 = r7.e
            if (r0 >= 0) goto L12
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r7.e = r0
        L12:
            int r0 = r10.getActionMasked()
            r1 = 2
            r2 = 1
            r3 = -1
            r4 = 0
            if (r0 != r1) goto L42
            boolean r0 = r7.b
            if (r0 == 0) goto L42
            int r0 = r7.c
            if (r0 != r3) goto L26
            goto L9d
        L26:
            int r0 = r10.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            goto L9d
        L2e:
            float r0 = r10.getY(r0)
            int r0 = (int) r0
            int r1 = r7.d
            int r1 = r0 - r1
            int r1 = java.lang.Math.abs(r1)
            int r5 = r7.e
            if (r1 <= r5) goto L42
            r7.d = r0
            return r2
        L42:
            int r0 = r10.getActionMasked()
            if (r0 != 0) goto L96
            r7.c = r3
            float r0 = r10.getX()
            int r0 = (int) r0
            float r1 = r10.getY()
            int r1 = (int) r1
            r5 = r7
            com.google.android.material.appbar.AppBarLayout$BaseBehavior r5 = (com.google.android.material.appbar.AppBarLayout$BaseBehavior) r5
            if (r9 != 0) goto L90
            java.lang.ref.WeakReference r5 = r5.f2181h
            if (r5 == 0) goto L71
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            if (r5 == 0) goto L78
            boolean r6 = r5.isShown()
            if (r6 == 0) goto L78
            boolean r3 = r5.canScrollVertically(r3)
            if (r3 != 0) goto L78
        L71:
            boolean r8 = r8.isPointInChildBounds(r9, r0, r1)
            if (r8 == 0) goto L78
            goto L79
        L78:
            r2 = r4
        L79:
            r7.b = r2
            if (r2 == 0) goto L96
            r7.d = r1
            int r8 = r10.getPointerId(r4)
            r7.c = r8
            android.view.VelocityTracker r8 = r7.f1402f
            if (r8 != 0) goto L96
            android.view.VelocityTracker r8 = android.view.VelocityTracker.obtain()
            r7.f1402f = r8
            goto L96
        L90:
            java.lang.ClassCastException r8 = new java.lang.ClassCastException
            r8.<init>()
            throw r8
        L96:
            android.view.VelocityTracker r8 = r7.f1402f
            if (r8 == 0) goto L9d
            r8.addMovement(r10)
        L9d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: X.b.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[RETURN] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r5, android.view.View r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r5 = r7.getActionMasked()
            r0 = -1
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L46
            r3 = 2
            if (r5 == r3) goto L2d
            r6 = 3
            if (r5 == r6) goto L4a
            r6 = 6
            if (r5 == r6) goto L13
            goto L58
        L13:
            int r5 = r7.getActionIndex()
            if (r5 != 0) goto L1b
            r5 = r1
            goto L1c
        L1b:
            r5 = r2
        L1c:
            int r6 = r7.getPointerId(r5)
            r4.c = r6
            float r5 = r7.getY(r5)
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 + r6
            int r5 = (int) r5
            r4.d = r5
            goto L58
        L2d:
            int r5 = r4.c
            int r5 = r7.findPointerIndex(r5)
            if (r5 != r0) goto L36
            goto L63
        L36:
            float r5 = r7.getY(r5)
            int r5 = (int) r5
            r4.d = r5
            r6.getClass()
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        L46:
            android.view.VelocityTracker r5 = r4.f1402f
            if (r5 != 0) goto L65
        L4a:
            r4.b = r2
            r4.c = r0
            android.view.VelocityTracker r5 = r4.f1402f
            if (r5 == 0) goto L58
            r5.recycle()
            r5 = 0
            r4.f1402f = r5
        L58:
            android.view.VelocityTracker r5 = r4.f1402f
            if (r5 == 0) goto L5f
            r5.addMovement(r7)
        L5f:
            boolean r5 = r4.b
            if (r5 != 0) goto L64
        L63:
            return r2
        L64:
            return r1
        L65:
            r5.addMovement(r7)
            android.view.VelocityTracker r5 = r4.f1402f
            r7 = 1000(0x3e8, float:1.401E-42)
            r5.computeCurrentVelocity(r7)
            android.view.VelocityTracker r5 = r4.f1402f
            int r7 = r4.c
            r5.getYVelocity(r7)
            r6.getClass()
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: X.b.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
