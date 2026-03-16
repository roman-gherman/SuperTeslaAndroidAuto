package com.google.android.material.checkbox;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Animatable2Compat.AnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2310a;

    public a(c cVar) {
        this.f2310a = cVar;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        super.onAnimationEnd(drawable);
        ColorStateList colorStateList = this.f2310a.f2318k;
        if (colorStateList != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        super.onAnimationStart(drawable);
        c cVar = this.f2310a;
        ColorStateList colorStateList = cVar.f2318k;
        if (colorStateList != null) {
            DrawableCompat.setTint(drawable, colorStateList.getColorForState(cVar.f2322o, colorStateList.getDefaultColor()));
        }
    }
}
