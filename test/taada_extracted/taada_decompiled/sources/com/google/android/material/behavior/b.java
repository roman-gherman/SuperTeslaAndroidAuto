package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;

/* JADX INFO: loaded from: classes.dex */
public final class b implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f2210a;

    public b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f2210a = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        SwipeDismissBehavior swipeDismissBehavior = this.f2210a;
        if (!swipeDismissBehavior.a(view)) {
            return false;
        }
        boolean z6 = ViewCompat.getLayoutDirection(view) == 1;
        int i = swipeDismissBehavior.d;
        ViewCompat.offsetLeftAndRight(view, (!(i == 0 && z6) && (i != 1 || z6)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }
}
