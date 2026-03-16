package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: loaded from: classes.dex */
public final class a extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f2294a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
        this.f2294a = carouselLayoutManager;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDxToMakeVisible(View view, int i) {
        CarouselLayoutManager carouselLayoutManager = this.f2294a;
        return (int) (carouselLayoutManager.f2290a - carouselLayoutManager.g(carouselLayoutManager.f2291f.f2302a, carouselLayoutManager.getPosition(view)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final PointF computeScrollVectorForPosition(int i) {
        if (this.f2294a.f2291f == null) {
            return null;
        }
        return new PointF(r0.g(r1.f2302a, i) - r0.f2290a, 0.0f);
    }
}
