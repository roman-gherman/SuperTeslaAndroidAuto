package com.google.android.material.transition.platform;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f6, b bVar);

    b evaluate(float f6, float f7, float f8, float f9, float f10, float f11, float f12);

    boolean shouldMaskStartBounds(b bVar);
}
