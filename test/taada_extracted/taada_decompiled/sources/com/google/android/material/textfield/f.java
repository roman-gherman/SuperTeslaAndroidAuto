package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class f extends n0.f {
    public static final /* synthetic */ int y = 0;
    public e x;

    @Override // n0.f
    public final void e(Canvas canvas) {
        if (this.x.q.isEmpty()) {
            super.e(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.x.q);
        super.e(canvas);
        canvas.restore();
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.x = new e(this.x);
        return this;
    }

    public final void q(float f6, float f7, float f8, float f9) {
        RectF rectF = this.x.q;
        if (f6 == rectF.left && f7 == rectF.top && f8 == rectF.right && f9 == rectF.bottom) {
            return;
        }
        rectF.set(f6, f7, f8, f9);
        invalidateSelf();
    }
}
