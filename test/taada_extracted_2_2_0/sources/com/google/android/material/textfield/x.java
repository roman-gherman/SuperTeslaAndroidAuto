package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2724a;
    public final /* synthetic */ TextInputLayout b;

    public /* synthetic */ x(TextInputLayout textInputLayout, int i) {
        this.f2724a = i;
        this.b = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2724a) {
            case 0:
                CheckableImageButton checkableImageButton = this.b.c.f2676g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                break;
            default:
                this.b.d.requestLayout();
                break;
        }
    }
}
