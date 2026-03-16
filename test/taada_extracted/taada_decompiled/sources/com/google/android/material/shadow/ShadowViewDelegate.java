package com.google.android.material.shadow;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public interface ShadowViewDelegate {
    float getRadius();

    boolean isCompatPaddingEnabled();

    void setBackgroundDrawable(Drawable drawable);

    void setShadowPadding(int i, int i3, int i4, int i5);
}
