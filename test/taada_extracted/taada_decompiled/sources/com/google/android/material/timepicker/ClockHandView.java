package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import c4.AbstractC0246d;
import fr.sd.taada.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f2738a;
    public boolean b;
    public final ArrayList c;
    public final int d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f2739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f2740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2741h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f2743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2745m;

    public interface OnActionUpListener {
        void onActionUp(float f6, boolean z6);
    }

    public interface OnRotateListener {
        void onRotate(float f6, boolean z6);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.f2738a = new ValueAnimator();
        this.c = new ArrayList();
        Paint paint = new Paint();
        this.f2739f = paint;
        this.f2740g = new RectF();
        this.f2745m = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V.a.f1354g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        AbstractC0246d.x0(context, R.attr.motionDurationLong2, 200);
        AbstractC0246d.y0(context, R.attr.motionEasingEmphasizedInterpolator, W.a.b);
        this.f2744l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f2741h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.e = r4.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(int i) {
        return i == 2 ? Math.round(this.f2744l * 0.66f) : this.f2744l;
    }

    public final void b(float f6) {
        ValueAnimator valueAnimator = this.f2738a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f7 = f6 % 360.0f;
        this.i = f7;
        this.f2743k = Math.toRadians(f7 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.f2745m);
        float fCos = (((float) Math.cos(this.f2743k)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.f2743k))) + height;
        float f8 = this.d;
        this.f2740g.set(fCos - f8, fSin - f8, fCos + f8, fSin + f8);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((OnRotateListener) it.next()).onRotate(f7, false);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f6 = width;
        float fA = a(this.f2745m);
        float fCos = (((float) Math.cos(this.f2743k)) * fA) + f6;
        float f7 = height;
        float fSin = (fA * ((float) Math.sin(this.f2743k))) + f7;
        Paint paint = this.f2739f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.d, paint);
        double dSin = Math.sin(this.f2743k);
        paint.setStrokeWidth(this.f2741h);
        canvas.drawLine(f6, f7, width + ((int) (Math.cos(this.f2743k) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f6, f7, this.e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        super.onLayout(z6, i, i3, i4, i5);
        if (this.f2738a.isRunning()) {
            return;
        }
        b(this.i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z6;
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z8 = false;
        if (actionMasked == 0) {
            this.f2742j = false;
            z6 = true;
            z7 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z7 = this.f2742j;
            if (this.b) {
                this.f2745m = ((float) Math.hypot((double) (x - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z6 = false;
        } else {
            z7 = false;
            z6 = false;
        }
        boolean z9 = this.f2742j;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f6 = i;
        boolean z10 = this.i != f6;
        if (z6 && z10) {
            z8 = true;
        } else if (z10 || z7) {
            b(f6);
            z8 = true;
        }
        this.f2742j = z9 | z8;
        return true;
    }
}
