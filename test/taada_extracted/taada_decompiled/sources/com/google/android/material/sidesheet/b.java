package com.google.android.material.sidesheet;

import B.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ViewDragHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f2581a;

    public b(SideSheetBehavior sideSheetBehavior) {
        this.f2581a = sideSheetBehavior;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i, int i3) {
        SideSheetBehavior sideSheetBehavior = this.f2581a;
        return MathUtils.clamp(i, sideSheetBehavior.f2565a.b(), sideSheetBehavior.f2572m);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i, int i3) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View view) {
        return this.f2581a.f2572m;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i) {
        if (i == 1) {
            SideSheetBehavior sideSheetBehavior = this.f2581a;
            if (sideSheetBehavior.f2567g) {
                sideSheetBehavior.a(1);
            }
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SideSheetBehavior sideSheetBehavior = this.f2581a;
        WeakReference weakReference = sideSheetBehavior.f2575p;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
            g gVar = sideSheetBehavior.f2565a;
            int left = view.getLeft();
            view.getRight();
            int i6 = ((SideSheetBehavior) gVar.b).f2572m;
            if (left <= i6) {
                marginLayoutParams.rightMargin = i6 - left;
            }
            view2.setLayoutParams(marginLayoutParams);
        }
        LinkedHashSet linkedHashSet = sideSheetBehavior.f2578t;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        float f6 = ((SideSheetBehavior) sideSheetBehavior.f2565a.b).f2572m;
        float fB = (f6 - i) / (f6 - r5.b());
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).onSlide(view, fB);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    @Override // androidx.customview.widget.ViewDragHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewReleased(android.view.View r8, float r9, float r10) {
        /*
            r7 = this;
            com.google.android.material.sidesheet.SideSheetBehavior r0 = r7.f2581a
            B.g r1 = r0.f2565a
            r1.getClass()
            r2 = 0
            int r3 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            r4 = 3
            if (r3 >= 0) goto Le
            goto L73
        Le:
            int r3 = r8.getRight()
            float r3 = (float) r3
            java.lang.Object r5 = r1.b
            com.google.android.material.sidesheet.SideSheetBehavior r5 = (com.google.android.material.sidesheet.SideSheetBehavior) r5
            float r6 = r5.f2570k
            float r6 = r6 * r9
            float r6 = r6 + r3
            float r3 = java.lang.Math.abs(r6)
            r6 = 1056964608(0x3f000000, float:0.5)
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            r6 = 5
            if (r3 <= 0) goto L4b
            float r9 = java.lang.Math.abs(r9)
            float r2 = java.lang.Math.abs(r10)
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 <= 0) goto L3a
            r9 = 500(0x1f4, float:7.0E-43)
            float r9 = (float) r9
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 <= 0) goto L3a
            goto L49
        L3a:
            int r9 = r8.getLeft()
            int r10 = r5.f2572m
            int r1 = r1.b()
            int r10 = r10 - r1
            int r10 = r10 / 2
            if (r9 <= r10) goto L73
        L49:
            r4 = r6
            goto L73
        L4b:
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 == 0) goto L5c
            float r9 = java.lang.Math.abs(r9)
            float r10 = java.lang.Math.abs(r10)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L5c
            goto L49
        L5c:
            int r9 = r8.getLeft()
            int r10 = r1.b()
            int r10 = r9 - r10
            int r10 = java.lang.Math.abs(r10)
            int r1 = r5.f2572m
            int r9 = r9 - r1
            int r9 = java.lang.Math.abs(r9)
            if (r10 >= r9) goto L49
        L73:
            r9 = 1
            r0.c(r8, r4, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.b.onViewReleased(android.view.View, float, float):void");
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i) {
        WeakReference weakReference;
        SideSheetBehavior sideSheetBehavior = this.f2581a;
        return (sideSheetBehavior.f2568h == 1 || (weakReference = sideSheetBehavior.f2574o) == null || weakReference.get() != view) ? false : true;
    }
}
