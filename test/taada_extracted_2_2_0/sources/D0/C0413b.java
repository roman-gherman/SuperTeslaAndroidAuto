package d0;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.chip.Chip;
import fr.sd.taada.R;
import java.util.List;

/* JADX INFO: renamed from: d0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0413b extends ExploreByTouchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f3068a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0413b(Chip chip, Chip chip2) {
        super(chip2);
        this.f3068a = chip;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int getVirtualViewAt(float f6, float f7) {
        Rect rect = Chip.f2327t;
        Chip chip = this.f3068a;
        return (chip.d() && chip.getCloseIconTouchBounds().contains(f6, f7)) ? 1 : 0;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void getVisibleVirtualViews(List list) {
        boolean z6 = false;
        list.add(0);
        Rect rect = Chip.f2327t;
        Chip chip = this.f3068a;
        if (chip.d()) {
            C0414c c0414c = chip.f2329a;
            if (c0414c != null && c0414c.f3081K) {
                z6 = true;
            }
            if (!z6 || chip.d == null) {
                return;
            }
            list.add(1);
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean onPerformActionForVirtualView(int i, int i3, Bundle bundle) {
        boolean z6 = false;
        if (i3 == 16) {
            Chip chip = this.f3068a;
            if (i == 0) {
                return chip.performClick();
            }
            if (i == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.d;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z6 = true;
                }
                if (chip.f2339p) {
                    chip.f2338o.sendEventForVirtualView(1, 1);
                }
            }
        }
        return z6;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Chip chip = this.f3068a;
        C0414c c0414c = chip.f2329a;
        accessibilityNodeInfoCompat.setCheckable(c0414c != null && c0414c.f3087Q);
        accessibilityNodeInfoCompat.setClickable(chip.isClickable());
        accessibilityNodeInfoCompat.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfoCompat.setText(chip.getText());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i != 1) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.f2327t);
            return;
        }
        Chip chip = this.f3068a;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfoCompat.setContentDescription(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfoCompat.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        accessibilityNodeInfoCompat.setEnabled(chip.isEnabled());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onVirtualViewKeyboardFocusChanged(int i, boolean z6) {
        if (i == 1) {
            Chip chip = this.f3068a;
            chip.f2333j = z6;
            chip.refreshDrawableState();
        }
    }
}
