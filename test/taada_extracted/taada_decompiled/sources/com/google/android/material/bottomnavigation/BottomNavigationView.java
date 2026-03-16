package com.google.android.material.bottomnavigation;

import V.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.material.internal.o;
import com.google.android.material.internal.s;
import com.google.android.material.navigation.NavigationBarView$OnItemReselectedListener;
import com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener;
import com.google.android.material.navigation.l;
import fr.sd.taada.R;
import z5.b;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends l {

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView$OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView$OnItemSelectedListener {
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        int[] iArr = a.b;
        o.a(context2, attributeSet, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView);
        o.b(context2, attributeSet, iArr, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView, new int[0]);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView);
        setItemHorizontalTranslationEnabled(tintTypedArrayObtainStyledAttributes.getBoolean(2, true));
        if (tintTypedArrayObtainStyledAttributes.hasValue(0)) {
            setMinimumHeight(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
        }
        tintTypedArrayObtainStyledAttributes.getBoolean(1, true);
        tintTypedArrayObtainStyledAttributes.recycle();
        s.a(this, new b(2));
    }

    @Override // com.google.android.material.navigation.l
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i3) != 1073741824 && suggestedMinimumHeight > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), BasicMeasure.EXACTLY);
        }
        super.onMeasure(i, i3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z6) {
        a0.b bVar = (a0.b) getMenuView();
        if (bVar.J != z6) {
            bVar.setItemHorizontalTranslationEnabled(z6);
            getPresenter().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }
}
