package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f2211a;
    public final boolean b;
    public final /* synthetic */ SwipeDismissBehavior c;

    public c(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z6) {
        this.c = swipeDismissBehavior;
        this.f2211a = view;
        this.b = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SwipeDismissBehavior swipeDismissBehavior = this.c;
        ViewDragHelper viewDragHelper = swipeDismissBehavior.f2205a;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            ViewCompat.postOnAnimation(this.f2211a, this);
        } else if (this.b) {
            swipeDismissBehavior.getClass();
        }
    }
}
