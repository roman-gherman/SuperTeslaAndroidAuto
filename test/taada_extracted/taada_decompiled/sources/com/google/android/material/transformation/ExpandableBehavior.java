package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2759a;

    public ExpandableBehavior() {
        this.f2759a = 0;
    }

    public abstract void a(View view, View view2, boolean z6, boolean z7);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (expandableWidget.isExpanded()) {
            int i = this.f2759a;
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (this.f2759a != 1) {
            return false;
        }
        this.f2759a = expandableWidget.isExpanded() ? 1 : 2;
        a((View) expandableWidget, view, expandableWidget.isExpanded(), true);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (!ViewCompat.isLaidOut(view)) {
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                layoutDependsOn(coordinatorLayout, view, dependencies.get(i3));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2759a = 0;
    }
}
