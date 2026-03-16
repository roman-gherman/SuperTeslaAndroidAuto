package com.google.android.material.navigation;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f2512a;
    public final /* synthetic */ e b;

    public b(e eVar, float f6) {
        this.b = eVar;
        this.f2512a = f6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.c(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f2512a);
    }
}
