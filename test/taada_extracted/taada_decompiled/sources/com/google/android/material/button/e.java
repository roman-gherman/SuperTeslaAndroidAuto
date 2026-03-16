package com.google.android.material.button;

import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class e implements MaterialButton.OnPressedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialButtonToggleGroup f2289a;

    public e(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.f2289a = materialButtonToggleGroup;
    }

    @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
    public final void onPressedChanged(MaterialButton materialButton, boolean z6) {
        this.f2289a.invalidate();
    }
}
