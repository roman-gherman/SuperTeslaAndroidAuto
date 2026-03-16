package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f2496a;
    public final TextPaint b;
    public final int c;
    public int d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2500j;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2497f = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2498g = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2499h = 1;
    public boolean i = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextUtils.TruncateAt f2501k = null;

    public j(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f2496a = charSequence;
        this.b = textPaint;
        this.c = i;
        this.d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f2496a == null) {
            this.f2496a = "";
        }
        int iMax = Math.max(0, this.c);
        CharSequence charSequenceEllipsize = this.f2496a;
        int i = this.f2497f;
        TextPaint textPaint = this.b;
        if (i == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f2501k);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.d);
        this.d = iMin;
        if (this.f2500j && this.f2497f == 1) {
            this.e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.e);
        builderObtain.setIncludePad(this.i);
        builderObtain.setTextDirection(this.f2500j ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f2501k;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f2497f);
        float f6 = this.f2498g;
        if (f6 != 1.0f) {
            builderObtain.setLineSpacing(0.0f, f6);
        }
        if (this.f2497f > 1) {
            builderObtain.setHyphenationFrequency(this.f2499h);
        }
        return builderObtain.build();
    }
}
