package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.g;
import com.google.android.material.internal.s;
import fr.sd.taada.R;
import k0.AbstractC0573c;
import n0.j;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends FrameLayout {
    public static final c i = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f2586a;
    public int b;
    public final float c;
    public final float d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f2588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2589h;

    public d(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        Drawable drawableWrap;
        super(AbstractC0792a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, V.a.f1349D);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            ViewCompat.setElevation(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.b = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f2586a = j.b(context2, attributeSet, 0, 0).a();
        }
        this.c = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(AbstractC0573c.a(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(s.c(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f2587f = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(i);
        setFocusable(true);
        if (getBackground() == null) {
            int iG = g.g(g.f(this, R.attr.colorSurface), g.f(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha());
            j jVar = this.f2586a;
            if (jVar != null) {
                int i3 = e.f2590a;
                n0.f fVar = new n0.f(jVar);
                fVar.k(ColorStateList.valueOf(iG));
                drawable = fVar;
            } else {
                Resources resources = getResources();
                int i4 = e.f2590a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(iG);
                drawable = gradientDrawable;
            }
            if (this.f2588g != null) {
                drawableWrap = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(drawableWrap, this.f2588g);
            } else {
                drawableWrap = DrawableCompat.wrap(drawable);
            }
            ViewCompat.setBackground(this, drawableWrap);
        }
    }

    private void setBaseTransientBottomBar(e eVar) {
    }

    public float getActionTextColorAlpha() {
        return this.d;
    }

    public int getAnimationMode() {
        return this.b;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.c;
    }

    public int getMaxInlineActionWidth() {
        return this.f2587f;
    }

    public int getMaxWidth() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i3, int i4, int i5, int i6) {
        super.onLayout(z6, i3, i4, i5, i6);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int i5 = this.e;
        if (i5 <= 0 || getMeasuredWidth() <= i5) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, BasicMeasure.EXACTLY), i4);
    }

    public void setAnimationMode(int i3) {
        this.b = i3;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f2588g != null) {
            drawable = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTintList(drawable, this.f2588g);
            DrawableCompat.setTintMode(drawable, this.f2589h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f2588g = colorStateList;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintList(drawableWrap, colorStateList);
            DrawableCompat.setTintMode(drawableWrap, this.f2589h);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f2589h = mode;
        if (getBackground() != null) {
            Drawable drawableWrap = DrawableCompat.wrap(getBackground().mutate());
            DrawableCompat.setTintMode(drawableWrap, mode);
            if (drawableWrap != getBackground()) {
                super.setBackgroundDrawable(drawableWrap);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : i);
        super.setOnClickListener(onClickListener);
    }
}
