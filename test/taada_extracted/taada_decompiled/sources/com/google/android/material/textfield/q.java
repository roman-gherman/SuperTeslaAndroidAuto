package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import c4.AbstractC0246d;
import fr.sd.taada.R;
import java.util.ArrayList;
import k0.AbstractC0573c;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f2692A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public Typeface f2693B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2694a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f2695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f2696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextInputLayout f2697h;
    public LinearLayout i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f2699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f2700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f2701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f2704p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AppCompatTextView f2705r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f2706s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2707t;
    public int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f2708v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f2709w;
    public boolean x;
    public AppCompatTextView y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2710z;

    public q(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f2696g = context;
        this.f2697h = textInputLayout;
        this.f2701m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f2694a = AbstractC0246d.x0(context, R.attr.motionDurationShort4, 217);
        this.b = AbstractC0246d.x0(context, R.attr.motionDurationMedium4, 167);
        this.c = AbstractC0246d.x0(context, R.attr.motionDurationShort4, 167);
        this.d = AbstractC0246d.y0(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, W.a.d);
        LinearInterpolator linearInterpolator = W.a.f1379a;
        this.e = AbstractC0246d.y0(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f2695f = AbstractC0246d.y0(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(AppCompatTextView appCompatTextView, int i) {
        if (this.i == null && this.f2699k == null) {
            Context context = this.f2696g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.f2697h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f2699k = new FrameLayout(context);
            this.i.addView(this.f2699k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.f2699k.setVisibility(0);
            this.f2699k.addView(appCompatTextView);
        } else {
            this.i.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.f2698j++;
    }

    public final void b() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.f2697h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f2696g;
                boolean zD = AbstractC0573c.d(context);
                LinearLayout linearLayout = this.i;
                int paddingStart = ViewCompat.getPaddingStart(editText);
                if (zD) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zD) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = ViewCompat.getPaddingEnd(editText);
                if (zD) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                ViewCompat.setPaddingRelative(linearLayout, paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f2700l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z6, AppCompatTextView appCompatTextView, int i, int i3, int i4) {
        if (appCompatTextView == null || !z6) {
            return;
        }
        if (i == i4 || i == i3) {
            boolean z7 = i4 == i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, z7 ? 1.0f : 0.0f);
            int i5 = this.c;
            objectAnimatorOfFloat.setDuration(z7 ? this.b : i5);
            objectAnimatorOfFloat.setInterpolator(z7 ? this.e : this.f2695f);
            if (i == i4 && i3 != 0) {
                objectAnimatorOfFloat.setStartDelay(i5);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i4 != i || i3 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.f2701m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f2694a);
            objectAnimatorOfFloat2.setInterpolator(this.d);
            objectAnimatorOfFloat2.setStartDelay(i5);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i) {
        if (i == 1) {
            return this.f2705r;
        }
        if (i != 2) {
            return null;
        }
        return this.y;
    }

    public final void f() {
        this.f2704p = null;
        c();
        if (this.f2702n == 1) {
            if (!this.x || TextUtils.isEmpty(this.f2709w)) {
                this.f2703o = 0;
            } else {
                this.f2703o = 2;
            }
        }
        i(this.f2702n, this.f2703o, h(this.f2705r, ""));
    }

    public final void g(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.f2699k) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i3 = this.f2698j - 1;
        this.f2698j = i3;
        LinearLayout linearLayout2 = this.i;
        if (i3 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f2697h;
        if (ViewCompat.isLaidOut(textInputLayout) && textInputLayout.isEnabled()) {
            return (this.f2703o == this.f2702n && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i, int i3, boolean z6) {
        TextView textViewE;
        TextView textViewE2;
        if (i == i3) {
            return;
        }
        if (z6) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f2700l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.x, this.y, 2, i, i3);
            d(arrayList, this.q, this.f2705r, 1, i, i3);
            W.b.a(animatorSet, arrayList);
            animatorSet.addListener(new o(this, i3, e(i), i, e(i3)));
            animatorSet.start();
        } else if (i != i3) {
            if (i3 != 0 && (textViewE2 = e(i3)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewE = e(i)) != null) {
                textViewE.setVisibility(4);
                if (i == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            this.f2702n = i3;
        }
        TextInputLayout textInputLayout = this.f2697h;
        textInputLayout.q();
        textInputLayout.t(z6, false);
        textInputLayout.w();
    }
}
