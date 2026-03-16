package com.google.android.material.appbar;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.b;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout$BaseBehavior<T extends b> extends X.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference f2181h;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2182a;
        public final boolean b;
        public final int c;
        public final float d;
        public final boolean e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2182a = parcel.readByte() != 0;
            this.b = parcel.readByte() != 0;
            this.c = parcel.readInt();
            this.d = parcel.readFloat();
            this.e = parcel.readByte() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f2182a ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.c);
            parcel.writeFloat(this.d);
            parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        }
    }

    public AppBarLayout$BaseBehavior() {
        this.c = -1;
        this.e = -1;
    }

    @Override // X.d, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (view != null) {
            throw new ClassCastException();
        }
        super.onLayoutChild(coordinatorLayout, null, i);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i3, int i4, int i5) {
        view.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i3, int[] iArr, int i4) {
        if (view != null) {
            throw new ClassCastException();
        }
        if (i3 != 0 && i3 >= 0) {
            throw null;
        }
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i3, int i4, int i5, int i6, int[] iArr) {
        if (view != null) {
            throw new ClassCastException();
        }
        if (i5 < 0) {
            throw null;
        }
        if (i5 != 0) {
            return;
        }
        ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        if (view != null) {
            throw new ClassCastException();
        }
        if (parcelable instanceof SavedState) {
            super.onRestoreInstanceState(coordinatorLayout, null, ((SavedState) parcelable).getSuperState());
        } else {
            super.onRestoreInstanceState(coordinatorLayout, null, parcelable);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        if (view != null) {
            throw new ClassCastException();
        }
        super.onSaveInstanceState(coordinatorLayout, null);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i3) {
        if (view != null) {
            throw new ClassCastException();
        }
        if ((i & 2) != 0) {
            throw null;
        }
        this.f2181h = null;
        this.f2180g = i3;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        if (view != null) {
            throw new ClassCastException();
        }
        if (this.f2180g == 0 || i == 1) {
            throw null;
        }
        this.f2181h = new WeakReference(view2);
    }

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.e = -1;
    }
}
