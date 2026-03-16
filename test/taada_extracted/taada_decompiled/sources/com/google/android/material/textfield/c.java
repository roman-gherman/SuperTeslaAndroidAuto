package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import c4.AbstractC0246d;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0347j;
import com.google.android.material.internal.CheckableImageButton;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public final class c extends n {
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f2652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f2653h;
    public EditText i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.navigation.b f2654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0347j f2655k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f2656l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f2657m;

    public c(m mVar) {
        super(mVar);
        this.f2654j = new androidx.navigation.b(this, 1);
        this.f2655k = new ViewOnFocusChangeListenerC0347j(this, 1);
        this.e = AbstractC0246d.x0(mVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f2651f = AbstractC0246d.x0(mVar.getContext(), R.attr.motionDurationShort3, 150);
        this.f2652g = AbstractC0246d.y0(mVar.getContext(), R.attr.motionEasingLinearInterpolator, W.a.f1379a);
        this.f2653h = AbstractC0246d.y0(mVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, W.a.d);
    }

    @Override // com.google.android.material.textfield.n
    public final void a() {
        if (this.b.f2684p != null) {
            return;
        }
        t(u());
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener e() {
        return this.f2655k;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.f2654j;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener g() {
        return this.f2655k;
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText editText) {
        this.i = editText;
        this.f2689a.setEndIconVisible(u());
    }

    @Override // com.google.android.material.textfield.n
    public final void p(boolean z6) {
        if (this.b.f2684p == null) {
            return;
        }
        t(z6);
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        final int i = 1;
        final int i3 = 0;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f2653h);
        valueAnimatorOfFloat.setDuration(this.f2651f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a
            public final /* synthetic */ c b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        c cVar = this.b;
                        cVar.getClass();
                        cVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        c cVar2 = this.b;
                        cVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar2.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f2652g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i4 = this.e;
        valueAnimatorOfFloat2.setDuration(i4);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a
            public final /* synthetic */ c b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        c cVar = this.b;
                        cVar.getClass();
                        cVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        c cVar2 = this.b;
                        cVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar2.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f2656l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f2656l.addListener(new b(this, i3));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i4);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a
            public final /* synthetic */ c b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        c cVar = this.b;
                        cVar.getClass();
                        cVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        c cVar2 = this.b;
                        cVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar2.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.f2657m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new b(this, i));
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new androidx.constraintlayout.helper.widget.a(this, 6));
        }
    }

    public final void t(boolean z6) {
        boolean z7 = this.b.c() == z6;
        if (z6 && !this.f2656l.isRunning()) {
            this.f2657m.cancel();
            this.f2656l.start();
            if (z7) {
                this.f2656l.end();
                return;
            }
            return;
        }
        if (z6) {
            return;
        }
        this.f2656l.cancel();
        this.f2657m.start();
        if (z7) {
            this.f2657m.end();
        }
    }

    public final boolean u() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
