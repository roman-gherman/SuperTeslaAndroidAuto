package androidx.interpolator.view.animation;

import B2.b;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f6), fArr.length - 2);
        float f7 = this.mStepSize;
        float f8 = (f6 - (iMin * f7)) / f7;
        float[] fArr2 = this.mValues;
        float f9 = fArr2[iMin];
        return b.a(fArr2[iMin + 1], f9, f8, f9);
    }
}
