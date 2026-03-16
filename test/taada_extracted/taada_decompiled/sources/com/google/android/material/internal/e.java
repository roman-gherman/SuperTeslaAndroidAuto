package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f2493a;
    public final Rect b;
    public final Rect c;
    public int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2494f;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.b = new Rect();
        this.c = new Rect();
        this.d = 119;
        this.e = true;
        this.f2494f = false;
        TypedArray typedArrayD = o.d(context, attributeSet, V.a.f1356j, 0, 0, new int[0]);
        this.d = typedArrayD.getInt(1, this.d);
        Drawable drawable = typedArrayD.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.e = typedArrayD.getBoolean(2, true);
        typedArrayD.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f2493a;
        if (drawable != null) {
            if (this.f2494f) {
                this.f2494f = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z6 = this.e;
                Rect rect = this.b;
                if (z6) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i = this.d;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.c;
                Gravity.apply(i, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f6, float f7) {
        super.drawableHotspotChanged(f6, f7);
        Drawable drawable = this.f2493a;
        if (drawable != null) {
            drawable.setHotspot(f6, f7);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2493a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f2493a.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f2493a;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2493a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        super.onLayout(z6, i, i3, i4, i5);
        this.f2494f = z6 | this.f2494f;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i4, int i5) {
        super.onSizeChanged(i, i3, i4, i5);
        this.f2494f = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f2493a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f2493a);
            }
            this.f2493a = drawable;
            this.f2494f = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.d == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.d != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.d = i;
            if (i == 119 && this.f2493a != null) {
                this.f2493a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2493a;
    }
}
