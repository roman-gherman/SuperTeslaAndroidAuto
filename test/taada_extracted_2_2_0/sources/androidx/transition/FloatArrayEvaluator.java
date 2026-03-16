package androidx.transition;

import B2.b;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f6, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f7 = fArr[i];
            fArr3[i] = b.a(fArr2[i], f7, f6, f7);
        }
        return fArr3;
    }
}
