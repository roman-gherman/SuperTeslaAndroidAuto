package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import e0.AbstractC0423b;

/* JADX INFO: loaded from: classes.dex */
public interface CircularRevealWidget extends CircularRevealHelper$Delegate {
    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas canvas);

    Drawable getCircularRevealOverlayDrawable();

    int getCircularRevealScrimColor();

    AbstractC0423b getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(AbstractC0423b abstractC0423b);
}
