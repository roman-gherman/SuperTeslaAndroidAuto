package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes.dex */
public final class w implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f2723a;

    public w(TextInputLayout textInputLayout) {
        this.f2723a = textInputLayout;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f2723a;
        textInputLayout.t(!textInputLayout.f2646x0, false);
        if (textInputLayout.f2623k) {
            textInputLayout.n(editable);
        }
        if (textInputLayout.f2637s) {
            textInputLayout.u(editable);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
    }
}
