package com.google.android.material.navigation;

import a0.C0133a;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0133a f2511a;

    public a(C0133a c0133a) {
        this.f2511a = c0133a;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Y.a aVar;
        C0133a c0133a = this.f2511a;
        ImageView imageView = c0133a.f2525m;
        if (imageView.getVisibility() != 0 || (aVar = c0133a.f2517D) == null) {
            return;
        }
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.d(imageView, null);
    }
}
