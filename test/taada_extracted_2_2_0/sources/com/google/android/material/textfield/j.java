package com.google.android.material.textfield;

import android.text.Editable;

/* JADX INFO: loaded from: classes.dex */
public final class j extends com.google.android.material.internal.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2671a;

    public j(m mVar) {
        this.f2671a = mVar;
    }

    @Override // com.google.android.material.internal.n, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f2671a.b().a();
    }

    @Override // com.google.android.material.internal.n, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        this.f2671a.b().b();
    }
}
