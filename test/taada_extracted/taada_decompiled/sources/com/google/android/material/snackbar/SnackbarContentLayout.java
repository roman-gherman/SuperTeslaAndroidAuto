package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import c4.AbstractC0246d;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f2585a;
    public Button b;
    public final TimeInterpolator c;
    public int d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = AbstractC0246d.y0(context, R.attr.motionEasingEmphasizedInterpolator, W.a.b);
    }

    public final boolean a(int i, int i3, int i4) {
        boolean z6;
        if (i != getOrientation()) {
            setOrientation(i);
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.f2585a.getPaddingTop() == i3 && this.f2585a.getPaddingBottom() == i4) {
            return z6;
        }
        TextView textView = this.f2585a;
        if (ViewCompat.isPaddingRelative(textView)) {
            ViewCompat.setPaddingRelative(textView, ViewCompat.getPaddingStart(textView), i3, ViewCompat.getPaddingEnd(textView), i4);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i3, textView.getPaddingRight(), i4);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public final void animateContentIn(int i, int i3) {
        this.f2585a.setAlpha(0.0f);
        long j6 = i3;
        ViewPropertyAnimator duration = this.f2585a.animate().alpha(1.0f).setDuration(j6);
        TimeInterpolator timeInterpolator = this.c;
        long j7 = i;
        duration.setInterpolator(timeInterpolator).setStartDelay(j7).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(1.0f).setDuration(j6).setInterpolator(timeInterpolator).setStartDelay(j7).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public final void animateContentOut(int i, int i3) {
        this.f2585a.setAlpha(1.0f);
        long j6 = i3;
        ViewPropertyAnimator duration = this.f2585a.animate().alpha(0.0f).setDuration(j6);
        TimeInterpolator timeInterpolator = this.c;
        long j7 = i;
        duration.setInterpolator(timeInterpolator).setStartDelay(j7).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(1.0f);
            this.b.animate().alpha(0.0f).setDuration(j6).setInterpolator(timeInterpolator).setStartDelay(j7).start();
        }
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.f2585a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2585a = (TextView) findViewById(R.id.snackbar_text);
        this.b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f2585a.getLayout();
        boolean z6 = layout != null && layout.getLineCount() > 1;
        if (!z6 || this.d <= 0 || this.b.getMeasuredWidth() <= this.d) {
            if (!z6) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i3);
    }

    public void setMaxInlineActionWidth(int i) {
        this.d = i;
    }
}
