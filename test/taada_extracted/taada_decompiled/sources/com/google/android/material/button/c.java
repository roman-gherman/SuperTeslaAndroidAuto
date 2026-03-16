package com.google.android.material.button;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialButtonToggleGroup f2287a;

    public c(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.f2287a = materialButtonToggleGroup;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        int i3 = MaterialButtonToggleGroup.f2267k;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f2287a;
        if (view instanceof MaterialButton) {
            i = 0;
            for (int i4 = 0; i4 < materialButtonToggleGroup.getChildCount(); i4++) {
                if (materialButtonToggleGroup.getChildAt(i4) == view) {
                    break;
                }
                if ((materialButtonToggleGroup.getChildAt(i4) instanceof MaterialButton) && materialButtonToggleGroup.c(i4)) {
                    i++;
                }
            }
            i = -1;
        } else {
            i = -1;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, ((MaterialButton) view).f2263l));
    }
}
