package com.google.android.material.sidesheet;

import B.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import fr.sd.taada.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k0.AbstractC0573c;
import n0.f;
import n0.j;

/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2565a;
    public final f b;
    public final ColorStateList c;
    public final j d;
    public final b0.f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f2566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2568h;
    public ViewDragHelper i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f2570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2573n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference f2574o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference f2575p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public VelocityTracker f2576r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2577s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinkedHashSet f2578t;
    public final b u;

    public SideSheetBehavior() {
        this.e = new b0.f(this);
        this.f2567g = true;
        this.f2568h = 5;
        this.f2570k = 0.1f;
        this.q = -1;
        this.f2578t = new LinkedHashSet();
        this.u = new b(this);
    }

    public final void a(int i) {
        View view;
        if (this.f2568h == i) {
            return;
        }
        this.f2568h = i;
        WeakReference weakReference = this.f2574o;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i3 = this.f2568h == 5 ? 4 : 0;
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
        Iterator it = this.f2578t.iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).onStateChanged(view, i);
        }
        d();
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final void addCallback(SheetCallback sheetCallback) {
        if (sheetCallback != null) {
            throw new ClassCastException();
        }
        this.f2578t.add(null);
    }

    public final boolean b() {
        if (this.i != null) {
            return this.f2567g || this.f2568h == 1;
        }
        return false;
    }

    public final void c(View view, int i, boolean z6) {
        int iB;
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2565a.b;
        if (i == 3) {
            iB = sideSheetBehavior.f2565a.b();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(B2.b.c(i, "Invalid state to get outer edge offset: "));
            }
            iB = ((SideSheetBehavior) sideSheetBehavior.f2565a.b).f2572m;
        }
        ViewDragHelper viewDragHelper = sideSheetBehavior.i;
        if (viewDragHelper == null || (!z6 ? viewDragHelper.smoothSlideViewTo(view, iB, view.getTop()) : viewDragHelper.settleCapturedViewAt(iB, view.getTop()))) {
            a(i);
        } else {
            a(2);
            this.e.a(i);
        }
    }

    public final void d() {
        View view;
        WeakReference weakReference = this.f2574o;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        final int i = 5;
        if (this.f2568h != 5) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.a
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view2, AccessibilityViewCommand.CommandArguments commandArguments) {
                    this.f2580a.setState(i);
                    return true;
                }
            });
        }
        final int i3 = 3;
        if (this.f2568h != 3) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.a
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view2, AccessibilityViewCommand.CommandArguments commandArguments) {
                    this.f2580a.setState(i3);
                    return true;
                }
            });
        }
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final int getState() {
        return this.f2568h;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f2574o = null;
        this.i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f2574o = null;
        this.i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && ViewCompat.getAccessibilityPaneTitle(view) == null) || !this.f2567g) {
            this.f2569j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f2576r) != null) {
            velocityTracker.recycle();
            this.f2576r = null;
        }
        if (this.f2576r == null) {
            this.f2576r = VelocityTracker.obtain();
        }
        this.f2576r.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f2577s = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f2569j) {
            this.f2569j = false;
            return false;
        }
        return (this.f2569j || (viewDragHelper = this.i) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i3;
        int i4;
        View viewFindViewById;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            view.setFitsSystemWindows(true);
        }
        int left = 0;
        if (this.f2574o == null) {
            this.f2574o = new WeakReference(view);
            f fVar = this.b;
            if (fVar != null) {
                ViewCompat.setBackground(view, fVar);
                f fVar2 = this.b;
                float elevation = this.f2566f;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(view);
                }
                fVar2.j(elevation);
            } else {
                ColorStateList colorStateList = this.c;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            int i5 = this.f2568h == 5 ? 4 : 0;
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            d();
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
            if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
                ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        if (this.i == null) {
            this.i = ViewDragHelper.create(coordinatorLayout, this.u);
        }
        g gVar = this.f2565a;
        gVar.getClass();
        int left2 = view.getLeft() - ((SideSheetBehavior) gVar.b).f2573n;
        coordinatorLayout.onLayoutChild(view, i);
        this.f2572m = coordinatorLayout.getWidth();
        this.f2571l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            this.f2565a.getClass();
            i3 = marginLayoutParams.rightMargin;
        } else {
            i3 = 0;
        }
        this.f2573n = i3;
        int i6 = this.f2568h;
        if (i6 == 1 || i6 == 2) {
            g gVar2 = this.f2565a;
            gVar2.getClass();
            left = left2 - (view.getLeft() - ((SideSheetBehavior) gVar2.b).f2573n);
        } else if (i6 != 3) {
            if (i6 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f2568h);
            }
            left = ((SideSheetBehavior) this.f2565a.b).f2572m;
        }
        ViewCompat.offsetLeftAndRight(view, left);
        if (this.f2575p == null && (i4 = this.q) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i4)) != null) {
            this.f2575p = new WeakReference(viewFindViewById);
        }
        for (SheetCallback sheetCallback : this.f2578t) {
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        }
        int i = savedState.f2579a;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.f2568h = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2568h == 1 && actionMasked == 0) {
            return true;
        }
        if (b()) {
            this.i.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f2576r) != null) {
            velocityTracker.recycle();
            this.f2576r = null;
        }
        if (this.f2576r == null) {
            this.f2576r = VelocityTracker.obtain();
        }
        this.f2576r.addMovement(motionEvent);
        if (b() && actionMasked == 2 && !this.f2569j && b() && Math.abs(this.f2577s - motionEvent.getX()) > this.i.getTouchSlop()) {
            this.i.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2569j;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final void removeCallback(SheetCallback sheetCallback) {
        if (sheetCallback != null) {
            throw new ClassCastException();
        }
        this.f2578t.remove(null);
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final void setState(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(B2.b.h(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = this.f2574o;
        if (weakReference == null || weakReference.get() == null) {
            a(i);
            return;
        }
        View view = (View) this.f2574o.get();
        androidx.core.content.res.a aVar = new androidx.core.content.res.a(i, 1, this);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view)) {
            view.post(aVar);
        } else {
            aVar.run();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2579a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2579a = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2579a);
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.f2579a = sideSheetBehavior.f2568h;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new b0.f(this);
        this.f2567g = true;
        this.f2568h = 5;
        this.f2570k = 0.1f;
        this.q = -1;
        this.f2578t = new LinkedHashSet();
        this.u = new b(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.a.C);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.c = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.d = j.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.q = resourceId;
            WeakReference weakReference = this.f2575p;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f2575p = null;
            WeakReference weakReference2 = this.f2574o;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && ViewCompat.isLaidOut(view)) {
                    view.requestLayout();
                }
            }
        }
        j jVar = this.d;
        if (jVar != null) {
            f fVar = new f(jVar);
            this.b = fVar;
            fVar.i(context);
            ColorStateList colorStateList = this.c;
            if (colorStateList != null) {
                this.b.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.b.setTint(typedValue.data);
            }
        }
        this.f2566f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.f2567g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f2565a == null) {
            this.f2565a = new g(this, 24);
        }
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
