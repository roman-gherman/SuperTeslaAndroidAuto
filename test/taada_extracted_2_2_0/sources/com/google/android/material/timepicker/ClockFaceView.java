package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.timepicker.ClockHandView;
import fr.sd.taada.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k0.AbstractC0573c;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends f implements ClockHandView.OnRotateListener {
    public final ClockHandView d;
    public final Rect e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f2727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f2728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray f2729h;
    public final c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f2730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f2731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f2732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f2734n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f2735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String[] f2736p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ColorStateList f2737r;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Rect();
        this.f2727f = new RectF();
        this.f2728g = new Rect();
        this.f2729h = new SparseArray();
        this.f2731k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.a.f1353f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 1);
        this.f2737r = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.d = clockHandView;
        this.f2732l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f2730j = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.c.add(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.i = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        setValues(strArr, 0);
        this.f2733m = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f2734n = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f2735o = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.f
    public final void a() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        HashMap map = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i3 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i3 == null) {
                    i3 = 1;
                }
                if (!map.containsKey(i3)) {
                    map.put(i3, new ArrayList());
                }
                ((List) map.get(i3)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.b * 0.66f) : this.b;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                constraintSet.constrainCircle(((View) it.next()).getId(), R.id.circle_center, iRound, size);
                size += 360.0f / list.size();
            }
        }
        constraintSet.applyTo(this);
        int i4 = 0;
        while (true) {
            SparseArray sparseArray = this.f2729h;
            if (i4 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i4)).setVisibility(0);
            i4++;
        }
    }

    public final void b() {
        SparseArray sparseArray;
        RectF rectF;
        Rect rect;
        RectF rectF2 = this.d.f2740g;
        float f6 = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.f2729h;
            int size = sparseArray.size();
            rectF = this.f2727f;
            rect = this.e;
            if (i >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f6) {
                    textView = textView2;
                    f6 = fHeight;
                }
            }
            i++;
        }
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            TextView textView3 = (TextView) sparseArray.get(i3);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.f2728g);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.f2730j, this.f2731k, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f2736p.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        super.onLayout(z6, i, i3, i4, i5);
        b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f2735o / Math.max(Math.max(this.f2733m / displayMetrics.heightPixels, this.f2734n / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, BasicMeasure.EXACTLY);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public final void onRotate(float f6, boolean z6) {
        if (Math.abs(this.q - f6) > 0.001f) {
            this.q = f6;
            b();
        }
    }

    public final void setValues(String[] strArr, int i) {
        this.f2736p = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        SparseArray sparseArray = this.f2729h;
        int size = sparseArray.size();
        boolean z6 = false;
        for (int i3 = 0; i3 < Math.max(this.f2736p.length, size); i3++) {
            TextView textView = (TextView) sparseArray.get(i3);
            if (i3 >= this.f2736p.length) {
                removeView(textView);
                sparseArray.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i3, textView);
                    addView(textView);
                }
                textView.setText(this.f2736p[i3]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i3));
                int i4 = (i3 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i4));
                if (i4 > 1) {
                    z6 = true;
                }
                ViewCompat.setAccessibilityDelegate(textView, this.i);
                textView.setTextColor(this.f2737r);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.f2736p[i3]));
                }
            }
        }
        ClockHandView clockHandView = this.d;
        if (clockHandView.b && !z6) {
            clockHandView.f2745m = 1;
        }
        clockHandView.b = z6;
        clockHandView.invalidate();
    }
}
