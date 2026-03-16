package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public float c;
    public final WeakReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k0.f f2504f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f2503a = new TextPaint(1);
    public final k b = new k(this, 0);
    public boolean d = true;

    public l(TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate) {
        this.e = new WeakReference(null);
        this.e = new WeakReference(textDrawableHelper$TextDrawableDelegate);
    }

    public final float a(String str) {
        if (!this.d) {
            return this.c;
        }
        float fMeasureText = str == null ? 0.0f : this.f2503a.measureText((CharSequence) str, 0, str.length());
        this.c = fMeasureText;
        this.d = false;
        return fMeasureText;
    }

    public final void b(k0.f fVar, Context context) {
        if (this.f2504f != fVar) {
            this.f2504f = fVar;
            if (fVar != null) {
                TextPaint textPaint = this.f2503a;
                k kVar = this.b;
                fVar.e(context, textPaint, kVar);
                TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate = (TextDrawableHelper$TextDrawableDelegate) this.e.get();
                if (textDrawableHelper$TextDrawableDelegate != null) {
                    textPaint.drawableState = textDrawableHelper$TextDrawableDelegate.getState();
                }
                fVar.d(context, textPaint, kVar);
                this.d = true;
            }
            TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate2 = (TextDrawableHelper$TextDrawableDelegate) this.e.get();
            if (textDrawableHelper$TextDrawableDelegate2 != null) {
                textDrawableHelper$TextDrawableDelegate2.onTextSizeChange();
                textDrawableHelper$TextDrawableDelegate2.onStateChange(textDrawableHelper$TextDrawableDelegate2.getState());
            }
        }
    }
}
