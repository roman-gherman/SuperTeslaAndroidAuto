package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public final class u extends n {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f2716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.navigation.b f2717g;

    public u(m mVar, int i) {
        super(mVar);
        this.e = R.drawable.design_password_eye;
        this.f2717g = new androidx.navigation.b(this, 3);
        if (i != 0) {
            this.e = i;
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void b() {
        q();
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return this.e;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.f2717g;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean k() {
        return true;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean l() {
        EditText editText = this.f2716f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText editText) {
        this.f2716f = editText;
        q();
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        EditText editText = this.f2716f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f2716f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        EditText editText = this.f2716f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
