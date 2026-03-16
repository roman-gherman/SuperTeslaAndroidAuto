package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import fr.sd.taada.R;
import k0.AbstractC0573c;

/* JADX INFO: loaded from: classes.dex */
public final class v extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2718a;
    public final AppCompatTextView b;
    public CharSequence c;
    public final CheckableImageButton d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f2719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f2721h;
    public View.OnLongClickListener i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2722j;

    public v(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f2718a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.b = appCompatTextView;
        if (AbstractC0573c.d(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        E1.k.i0(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        E1.k.i0(checkableImageButton, null);
        if (tintTypedArray.hasValue(67)) {
            this.e = AbstractC0573c.b(getContext(), tintTypedArray, 67);
        }
        if (tintTypedArray.hasValue(68)) {
            this.f2719f = com.google.android.material.internal.s.c(tintTypedArray.getInt(68, -1), null);
        }
        if (tintTypedArray.hasValue(64)) {
            a(tintTypedArray.getDrawable(64));
            if (tintTypedArray.hasValue(63) && checkableImageButton.getContentDescription() != (text = tintTypedArray.getText(63))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(tintTypedArray.getBoolean(62, true));
        }
        int dimensionPixelSize = tintTypedArray.getDimensionPixelSize(65, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f2720g) {
            this.f2720g = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (tintTypedArray.hasValue(66)) {
            ImageView.ScaleType scaleTypeQ = E1.k.q(tintTypedArray.getInt(66, -1));
            this.f2721h = scaleTypeQ;
            checkableImageButton.setScaleType(scaleTypeQ);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView, 1);
        TextViewCompat.setTextAppearance(appCompatTextView, tintTypedArray.getResourceId(58, 0));
        if (tintTypedArray.hasValue(59)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(59));
        }
        CharSequence text2 = tintTypedArray.getText(57);
        this.c = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        d();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final void a(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.e;
            PorterDuff.Mode mode = this.f2719f;
            TextInputLayout textInputLayout = this.f2718a;
            E1.k.g(textInputLayout, checkableImageButton, colorStateList, mode);
            b(true);
            E1.k.c0(textInputLayout, checkableImageButton, this.e);
            return;
        }
        b(false);
        View.OnLongClickListener onLongClickListener = this.i;
        checkableImageButton.setOnClickListener(null);
        E1.k.i0(checkableImageButton, onLongClickListener);
        this.i = null;
        checkableImageButton.setOnLongClickListener(null);
        E1.k.i0(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void b(boolean z6) {
        CheckableImageButton checkableImageButton = this.d;
        if ((checkableImageButton.getVisibility() == 0) != z6) {
            checkableImageButton.setVisibility(z6 ? 0 : 8);
            c();
            d();
        }
    }

    public final void c() {
        EditText editText = this.f2718a.d;
        if (editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.b, this.d.getVisibility() == 0 ? 0 : ViewCompat.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void d() {
        int i = (this.c == null || this.f2722j) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.b.setVisibility(i);
        this.f2718a.p();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        c();
    }
}
