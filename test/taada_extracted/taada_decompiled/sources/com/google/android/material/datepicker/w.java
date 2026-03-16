package com.google.android.material.datepicker;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes.dex */
public final class w implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2435a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;

    public w(int i, View view, int i3) {
        this.f2435a = i;
        this.b = view;
        this.c = i3;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        View view2 = this.b;
        int i3 = this.f2435a;
        if (i3 >= 0) {
            view2.getLayoutParams().height = i3 + i;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.c + i, view2.getPaddingRight(), view2.getPaddingBottom());
        return windowInsetsCompat;
    }
}
