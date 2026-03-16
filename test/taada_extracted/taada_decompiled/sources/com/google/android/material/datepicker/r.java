package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public final class r extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2430a;
    public final /* synthetic */ Object b;

    public /* synthetic */ r(Object obj, int i) {
        this.f2430a = i;
        this.b = obj;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2430a) {
            case 2:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.b).f2439a);
                break;
            default:
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        switch (this.f2430a) {
            case 0:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                MaterialCalendar materialCalendar = (MaterialCalendar) this.b;
                accessibilityNodeInfoCompat.setHintText(materialCalendar.f2384n.getVisibility() == 0 ? materialCalendar.getString(R.string.mtrl_picker_toggle_to_year_selection) : materialCalendar.getString(R.string.mtrl_picker_toggle_to_day_selection));
                break;
            case 1:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setContentDescription(((MaterialDatePicker) this.b).b().getError() + ", " + ((Object) accessibilityNodeInfoCompat.getText()));
                break;
            case 2:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                CheckableImageButton checkableImageButton = (CheckableImageButton) this.b;
                accessibilityNodeInfoCompat.setCheckable(checkableImageButton.b);
                accessibilityNodeInfoCompat.setChecked(checkableImageButton.f2439a);
                break;
            default:
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(((NavigationMenuItemView) this.b).i);
                break;
        }
    }
}
