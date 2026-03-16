package com.google.android.material.bottomappbar;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar$Behavior f2213a;

    public a(BottomAppBar$Behavior bottomAppBar$Behavior) {
        this.f2213a = bottomAppBar$Behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.f2213a.i.get() != null) {
            throw new ClassCastException();
        }
        view.removeOnLayoutChangeListener(this);
    }
}
