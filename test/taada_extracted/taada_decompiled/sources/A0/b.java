package a0;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.google.android.material.navigation.g;
import fr.sd.taada.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int f1523F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int f1524G;
    public final int H;
    public final int I;
    public boolean J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final ArrayList f1525K;

    public b(Context context) {
        super(context);
        this.f1525K = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f1523F = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f1524G = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.H = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.I = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i;
        int i7 = i5 - i3;
        int measuredWidth = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i6 - measuredWidth;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i7);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i7);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        int i5;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        ArrayList arrayList = this.f1525K;
        arrayList.clear();
        int size3 = View.MeasureSpec.getSize(i3);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, BasicMeasure.EXACTLY);
        int labelVisibilityMode = getLabelVisibilityMode();
        boolean z6 = labelVisibilityMode != -1 ? labelVisibilityMode == 0 : size2 > 3;
        int i6 = this.H;
        if (z6 && this.J) {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int iMax = this.I;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f1524G * i7), Math.min(iMax, i6));
            int i8 = size - iMin;
            int iMin2 = Math.min(i8 / (i7 != 0 ? i7 : 1), this.f1523F);
            int i9 = i8 - (i7 * iMin2);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    i5 = i10 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i9 > 0) {
                        i5++;
                        i9--;
                    }
                } else {
                    i5 = 0;
                }
                arrayList.add(Integer.valueOf(i5));
                i10++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), i6);
            int i11 = size - (size2 * iMin3);
            for (int i12 = 0; i12 < childCount; i12++) {
                if (getChildAt(i12).getVisibility() == 8) {
                    i4 = 0;
                } else if (i11 > 0) {
                    i4 = iMin3 + 1;
                    i11--;
                } else {
                    i4 = iMin3;
                }
                arrayList.add(Integer.valueOf(i4));
            }
        }
        int measuredWidth = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i13)).intValue(), BasicMeasure.EXACTLY), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth = childAt2.getMeasuredWidth() + measuredWidth;
            }
        }
        setMeasuredDimension(measuredWidth, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z6) {
        this.J = z6;
    }
}
