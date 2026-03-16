package com.google.android.material.bottomsheet;

import B2.b;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import b0.C0228b;
import b0.C0229c;
import b0.C0230d;
import b0.RunnableC0227a;
import b0.e;
import b0.f;
import b0.g;
import com.google.android.material.internal.s;
import fr.sd.taada.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import k0.AbstractC0573c;
import n0.j;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final f f2215A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final ValueAnimator f2216B;
    public final int C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f2217D;
    public int E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final float f2218F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f2219G;
    public final float H;
    public boolean I;
    public boolean J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final boolean f2220K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f2221L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public ViewDragHelper f2222M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f2223N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f2224O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f2225P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final float f2226Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f2227T;
    public WeakReference U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public WeakReference f2228V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final ArrayList f2229W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public VelocityTracker f2230X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public int f2231Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public int f2232Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2233a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f2234a0;
    public boolean b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public HashMap f2235b0;
    public final float c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final SparseIntArray f2236c0;
    public final int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final C0230d f2237d0;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2240h;
    public final n0.f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ColorStateList f2241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2243l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2244m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2245n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f2246o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f2247p;
    public final boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f2248r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f2249s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f2250t;
    public final boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2252w;
    public final boolean x;
    public final j y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2253z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.f2233a = 0;
        this.b = true;
        this.f2242k = -1;
        this.f2243l = -1;
        this.f2215A = new f(this);
        this.f2218F = 0.5f;
        this.H = -1.0f;
        this.f2220K = true;
        this.f2221L = 4;
        this.f2226Q = 0.1f;
        this.f2229W = new ArrayList();
        this.f2236c0 = new SparseIntArray();
        this.f2237d0 = new C0230d(this);
    }

    public static View d(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewD = d(viewGroup.getChildAt(i));
            if (viewD != null) {
                return viewD;
            }
        }
        return null;
    }

    public static int e(int i, int i3, int i4, int i5) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i3, i5);
        if (i4 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i4), BasicMeasure.EXACTLY);
        }
        if (size != 0) {
            i4 = Math.min(size, i4);
        }
        return View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
    }

    public final void a() {
        int iB = b();
        if (this.b) {
            this.f2219G = Math.max(this.f2227T - iB, this.f2217D);
        } else {
            this.f2219G = this.f2227T - iB;
        }
    }

    public final int b() {
        int i;
        return this.f2238f ? Math.min(Math.max(this.f2239g, this.f2227T - ((this.S * 9) / 16)), this.R) + this.f2251v : (this.f2245n || this.f2246o || (i = this.f2244m) <= 0) ? this.e + this.f2251v : Math.max(this.e, i + this.f2240h);
    }

    public final void c(int i) {
        if (((View) this.U.get()) != null) {
            ArrayList arrayList = this.f2229W;
            if (arrayList.isEmpty()) {
                return;
            }
            int i3 = this.f2219G;
            if (i <= i3 && i3 != f()) {
                f();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final int f() {
        if (this.b) {
            return this.f2217D;
        }
        return Math.max(this.C, this.f2248r ? 0 : this.f2252w);
    }

    public final int g(int i) {
        if (i == 3) {
            return f();
        }
        if (i == 4) {
            return this.f2219G;
        }
        if (i == 5) {
            return this.f2227T;
        }
        if (i == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(b.c(i, "Invalid state to get top offset: "));
    }

    public final void h(int i) {
        if (i == -1) {
            if (this.f2238f) {
                return;
            } else {
                this.f2238f = true;
            }
        } else {
            if (!this.f2238f && this.e == i) {
                return;
            }
            this.f2238f = false;
            this.e = Math.max(0, i);
        }
        o();
    }

    public final void i(int i) {
        if (this.f2221L == i) {
            return;
        }
        this.f2221L = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z6 = this.I;
        }
        WeakReference weakReference = this.U;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            n(true);
        } else if (i == 6 || i == 5 || i == 4) {
            n(false);
        }
        m(i, true);
        ArrayList arrayList = this.f2229W;
        if (arrayList.size() <= 0) {
            l();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean j(View view, float f6) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.f2219G) {
            return false;
        }
        return Math.abs(((f6 * this.f2226Q) + ((float) view.getTop())) - ((float) this.f2219G)) / ((float) b()) > 0.5f;
    }

    public final void k(View view, int i, boolean z6) {
        int iG = g(i);
        ViewDragHelper viewDragHelper = this.f2222M;
        if (viewDragHelper == null || (!z6 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), iG) : viewDragHelper.settleCapturedViewAt(view.getLeft(), iG))) {
            i(i);
            return;
        }
        i(2);
        m(i, true);
        this.f2215A.a(i);
    }

    public final void l() {
        View view;
        WeakReference weakReference = this.U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        SparseIntArray sparseIntArray = this.f2236c0;
        int i = sparseIntArray.get(0, -1);
        if (i != -1) {
            ViewCompat.removeAccessibilityAction(view, i);
            sparseIntArray.delete(0);
        }
        if (!this.b && this.f2221L != 6) {
            sparseIntArray.put(0, ViewCompat.addAccessibilityAction(view, view.getResources().getString(R.string.bottomsheet_action_expand_halfway), new e(this, 6)));
        }
        if (this.I && this.f2221L != 5) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new e(this, 5));
        }
        int i3 = this.f2221L;
        if (i3 == 3) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new e(this, this.b ? 4 : 6));
            return;
        }
        if (i3 == 4) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new e(this, this.b ? 3 : 6));
        } else {
            if (i3 != 6) {
                return;
            }
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, null, new e(this, 4));
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new e(this, 3));
        }
    }

    public final void m(int i, boolean z6) {
        n0.f fVar = this.i;
        ValueAnimator valueAnimator = this.f2216B;
        if (i == 2) {
            return;
        }
        boolean z7 = this.f2221L == 3 && (this.x || f() == 0);
        if (this.f2253z == z7 || fVar == null) {
            return;
        }
        this.f2253z = z7;
        if (!z6 || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            fVar.l(this.f2253z ? 0.0f : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
            return;
        }
        float f6 = z7 ? 0.0f : 1.0f;
        valueAnimator.setFloatValues(1.0f - f6, f6);
        valueAnimator.start();
    }

    public final void n(boolean z6) {
        WeakReference weakReference = this.U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z6) {
                if (this.f2235b0 != null) {
                    return;
                } else {
                    this.f2235b0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.U.get() && z6) {
                    this.f2235b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z6) {
                return;
            }
            this.f2235b0 = null;
        }
    }

    public final void o() {
        View view;
        if (this.U != null) {
            a();
            if (this.f2221L != 4 || (view = (View) this.U.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.U = null;
        this.f2222M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.U = null;
        this.f2222M = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.f2220K) {
            this.f2223N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2231Y = -1;
            VelocityTracker velocityTracker = this.f2230X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2230X = null;
            }
        }
        if (this.f2230X == null) {
            this.f2230X = VelocityTracker.obtain();
        }
        this.f2230X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.f2232Z = (int) motionEvent.getY();
            if (this.f2221L != 2) {
                WeakReference weakReference = this.f2228V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.f2232Z)) {
                    this.f2231Y = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2234a0 = true;
                }
            }
            this.f2223N = this.f2231Y == -1 && !coordinatorLayout.isPointInChildBounds(view, x, this.f2232Z);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2234a0 = false;
            this.f2231Y = -1;
            if (this.f2223N) {
                this.f2223N = false;
                return false;
            }
        }
        if (this.f2223N || (viewDragHelper = this.f2222M) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            WeakReference weakReference2 = this.f2228V;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.f2223N || this.f2221L == 1 || coordinatorLayout.isPointInChildBounds(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f2222M == null || Math.abs(this.f2232Z - motionEvent.getY()) <= this.f2222M.getTouchSlop()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.U == null) {
            this.f2239g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z6 = (Build.VERSION.SDK_INT < 29 || this.f2245n || this.f2238f) ? false : true;
            if (this.f2246o || this.f2247p || this.q || this.f2249s || this.f2250t || this.u || z6) {
                s.a(view, new C0229c(this, z6));
            }
            ViewCompat.setWindowInsetsAnimationCallback(view, new g(view));
            this.U = new WeakReference(view);
            n0.f fVar = this.i;
            if (fVar != null) {
                ViewCompat.setBackground(view, fVar);
                n0.f fVar2 = this.i;
                float elevation = this.H;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(view);
                }
                fVar2.j(elevation);
            } else {
                ColorStateList colorStateList = this.f2241j;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            l();
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
        }
        if (this.f2222M == null) {
            this.f2222M = ViewDragHelper.create(coordinatorLayout, this.f2237d0);
        }
        int top = view.getTop();
        coordinatorLayout.onLayoutChild(view, i);
        this.S = coordinatorLayout.getWidth();
        this.f2227T = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.R = height;
        int i3 = this.f2227T;
        int i4 = i3 - height;
        int i5 = this.f2252w;
        if (i4 < i5) {
            if (this.f2248r) {
                this.R = i3;
            } else {
                this.R = i3 - i5;
            }
        }
        this.f2217D = Math.max(0, i3 - this.R);
        this.E = (int) ((1.0f - this.f2218F) * this.f2227T);
        a();
        int i6 = this.f2221L;
        if (i6 == 3) {
            ViewCompat.offsetTopAndBottom(view, f());
        } else if (i6 == 6) {
            ViewCompat.offsetTopAndBottom(view, this.E);
        } else if (this.I && i6 == 5) {
            ViewCompat.offsetTopAndBottom(view, this.f2227T);
        } else if (i6 == 4) {
            ViewCompat.offsetTopAndBottom(view, this.f2219G);
        } else if (i6 == 1 || i6 == 2) {
            ViewCompat.offsetTopAndBottom(view, top - view.getTop());
        }
        m(this.f2221L, false);
        this.f2228V = new WeakReference(d(view));
        ArrayList arrayList = this.f2229W;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(e(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, this.f2242k, marginLayoutParams.width), e(i4, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, this.f2243l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f6, float f7) {
        WeakReference weakReference = this.f2228V;
        return weakReference != null && view2 == weakReference.get() && (this.f2221L != 3 || super.onNestedPreFling(coordinatorLayout, view, view2, f6, f7));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i3, int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference weakReference = this.f2228V;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < f()) {
                int iF = top - f();
                iArr[1] = iF;
                ViewCompat.offsetTopAndBottom(view, -iF);
                i(3);
            } else {
                if (!this.f2220K) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(view, -i3);
                i(1);
            }
        } else if (i3 < 0 && !view2.canScrollVertically(-1)) {
            int i6 = this.f2219G;
            if (i5 > i6 && !this.I) {
                int i7 = top - i6;
                iArr[1] = i7;
                ViewCompat.offsetTopAndBottom(view, -i7);
                i(4);
            } else {
                if (!this.f2220K) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(view, -i3);
                i(1);
            }
        }
        c(view.getTop());
        this.f2224O = i3;
        this.f2225P = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        int i = this.f2233a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.e = savedState.b;
            }
            if (i == -1 || (i & 2) == 2) {
                this.b = savedState.c;
            }
            if (i == -1 || (i & 4) == 4) {
                this.I = savedState.d;
            }
            if (i == -1 || (i & 8) == 8) {
                this.J = savedState.e;
            }
        }
        int i3 = savedState.f2254a;
        if (i3 == 1 || i3 == 2) {
            this.f2221L = 4;
        } else {
            this.f2221L = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i3) {
        this.f2224O = 0;
        this.f2225P = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.f()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.i(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.f2228V
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.f2225P
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.f2224O
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.f2230X
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f2230X
            int r6 = r2.f2231Y
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.j(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.f2224O
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.b
            if (r1 == 0) goto L74
            int r5 = r2.f2217D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f2219G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.f2219G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2219G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2219G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.k(r4, r0, r3)
            r2.f2225P = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f2221L;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f2222M;
        if (viewDragHelper != null && (this.f2220K || i == 1)) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.f2231Y = -1;
            VelocityTracker velocityTracker = this.f2230X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2230X = null;
            }
        }
        if (this.f2230X == null) {
            this.f2230X = VelocityTracker.obtain();
        }
        this.f2230X.addMovement(motionEvent);
        if (this.f2222M != null && ((this.f2220K || this.f2221L == 1) && actionMasked == 2 && !this.f2223N && Math.abs(this.f2232Z - motionEvent.getY()) > this.f2222M.getTouchSlop())) {
            this.f2222M.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2223N;
    }

    public final void setState(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(b.h(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i3 = (i == 6 && this.b && g(i) <= this.f2217D) ? 3 : i;
        WeakReference weakReference = this.U;
        if (weakReference == null || weakReference.get() == null) {
            i(i);
            return;
        }
        View view = (View) this.U.get();
        RunnableC0227a runnableC0227a = new RunnableC0227a(this, view, i3);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view)) {
            view.post(runnableC0227a);
        } else {
            runnableC0227a.run();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2254a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2254a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
            this.d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2254a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f2254a = bottomSheetBehavior.f2221L;
            this.b = bottomSheetBehavior.e;
            this.c = bottomSheetBehavior.b;
            this.d = bottomSheetBehavior.I;
            this.e = bottomSheetBehavior.J;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        int i3 = 0;
        this.f2233a = 0;
        this.b = true;
        this.f2242k = -1;
        this.f2243l = -1;
        this.f2215A = new f(this);
        this.f2218F = 0.5f;
        this.H = -1.0f;
        this.f2220K = true;
        this.f2221L = 4;
        this.f2226Q = 0.1f;
        this.f2229W = new ArrayList();
        this.f2236c0 = new SparseIntArray();
        this.f2237d0 = new C0230d(this);
        this.f2240h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.a.c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f2241j = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            this.y = j.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        j jVar = this.y;
        if (jVar != null) {
            n0.f fVar = new n0.f(jVar);
            this.i = fVar;
            fVar.i(context);
            ColorStateList colorStateList = this.f2241j;
            if (colorStateList != null) {
                this.i.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2216B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f2216B.addUpdateListener(new C0228b(this, i3));
        this.H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f2242k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f2243l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            h(i);
        } else {
            h(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(8, false);
        if (this.I != z6) {
            this.I = z6;
            if (!z6 && this.f2221L == 5) {
                setState(4);
            }
            l();
        }
        this.f2245n = typedArrayObtainStyledAttributes.getBoolean(13, false);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.b != z7) {
            this.b = z7;
            if (this.U != null) {
                a();
            }
            i((this.b && this.f2221L == 6) ? 3 : this.f2221L);
            m(this.f2221L, true);
            l();
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.f2220K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f2233a = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f6 = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f6 > 0.0f && f6 < 1.0f) {
            this.f2218F = f6;
            if (this.U != null) {
                this.E = (int) ((1.0f - f6) * this.f2227T);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i4 = typedValuePeekValue2.data;
                if (i4 >= 0) {
                    this.C = i4;
                    m(this.f2221L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.C = dimensionPixelOffset;
                    m(this.f2221L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.d = typedArrayObtainStyledAttributes.getInt(11, 500);
            this.f2246o = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f2247p = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.q = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f2248r = typedArrayObtainStyledAttributes.getBoolean(20, true);
            this.f2249s = typedArrayObtainStyledAttributes.getBoolean(14, false);
            this.f2250t = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.u = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.x = typedArrayObtainStyledAttributes.getBoolean(23, true);
            typedArrayObtainStyledAttributes.recycle();
            this.c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
