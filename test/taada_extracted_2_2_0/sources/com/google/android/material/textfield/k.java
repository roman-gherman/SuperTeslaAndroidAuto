package com.google.android.material.textfield;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class k implements TextInputLayout.OnEditTextAttachedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2672a;

    public k(m mVar) {
        this.f2672a = mVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
    public final void onEditTextAttached(TextInputLayout textInputLayout) {
        m mVar = this.f2672a;
        if (mVar.f2686s == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = mVar.f2686s;
        j jVar = mVar.f2688v;
        if (editText != null) {
            editText.removeTextChangedListener(jVar);
            if (mVar.f2686s.getOnFocusChangeListener() == mVar.b().e()) {
                mVar.f2686s.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        mVar.f2686s = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(jVar);
        }
        mVar.b().m(mVar.f2686s);
        mVar.i(mVar.b());
    }
}
