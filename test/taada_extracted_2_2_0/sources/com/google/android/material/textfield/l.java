package com.google.android.material.textfield;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* JADX INFO: loaded from: classes.dex */
public final class l implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2673a;

    public l(m mVar) {
        this.f2673a = mVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        m mVar = this.f2673a;
        if (mVar.u == null || (accessibilityManager = mVar.f2687t) == null || !ViewCompat.isAttachedToWindow(mVar)) {
            return;
        }
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(accessibilityManager, mVar.u);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        m mVar = this.f2673a;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = mVar.u;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = mVar.f2687t) == null) {
            return;
        }
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }
}
