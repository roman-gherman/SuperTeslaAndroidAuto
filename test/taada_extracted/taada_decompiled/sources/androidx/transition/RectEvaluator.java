package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f6, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - r0) * f6));
        int i3 = rect.top + ((int) ((rect2.top - r1) * f6));
        int i4 = rect.right + ((int) ((rect2.right - r2) * f6));
        int i5 = rect.bottom + ((int) ((rect2.bottom - r6) * f6));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i, i3, i4, i5);
        }
        rect3.set(i, i3, i4, i5);
        return this.mRect;
    }
}
