package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2750a;

    public b(ClockFaceView clockFaceView) {
        this.f2750a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f2750a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.d.d) - clockFaceView.f2732l;
        if (height != clockFaceView.b) {
            clockFaceView.b = height;
            clockFaceView.a();
            int i = clockFaceView.b;
            ClockHandView clockHandView = clockFaceView.d;
            clockHandView.f2744l = i;
            clockHandView.invalidate();
        }
        return true;
    }
}
