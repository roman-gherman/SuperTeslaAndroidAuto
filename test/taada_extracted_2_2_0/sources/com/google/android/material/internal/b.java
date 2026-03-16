package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.textfield.TextInputLayout;
import k0.C0571a;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public CharSequence f2451A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public CharSequence f2452B;
    public boolean C;
    public Bitmap E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public float f2454F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public float f2455G;
    public float H;
    public float I;
    public float J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f2456K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int[] f2457L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f2458M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final TextPaint f2459N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final TextPaint f2460O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public LinearInterpolator f2461P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public LinearInterpolator f2462Q;
    public float R;
    public float S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public float f2463T;
    public ColorStateList U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public float f2464V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public float f2465W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public float f2466X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public StaticLayout f2467Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public float f2468Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2469a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f2470a0;
    public float b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f2471b0;
    public final Rect c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f2472c0;
    public final Rect d;
    public final RectF e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f2479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f2481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2482m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2483n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f2484o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2485p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Typeface f2486r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Typeface f2487s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f2488t;
    public Typeface u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f2489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f2490w;
    public Typeface x;
    public C0571a y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2475f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2477g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2478h = 15.0f;
    public float i = 15.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextUtils.TruncateAt f2491z = TextUtils.TruncateAt.END;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final boolean f2453D = true;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f2473d0 = 1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final float f2474e0 = 1.0f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f2476f0 = 1;

    public b(TextInputLayout textInputLayout) {
        this.f2469a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.f2459N = textPaint;
        this.f2460O = new TextPaint(textPaint);
        this.d = new Rect();
        this.c = new Rect();
        this.e = new RectF();
        g(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(int i, int i3, float f6) {
        float f7 = 1.0f - f6;
        return Color.argb(Math.round((Color.alpha(i3) * f6) + (Color.alpha(i) * f7)), Math.round((Color.red(i3) * f6) + (Color.red(i) * f7)), Math.round((Color.green(i3) * f6) + (Color.green(i) * f7)), Math.round((Color.blue(i3) * f6) + (Color.blue(i) * f7)));
    }

    public static float f(float f6, float f7, float f8, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f8 = timeInterpolator.getInterpolation(f8);
        }
        return W.a.a(f6, f7, f8);
    }

    public final boolean b(CharSequence charSequence) {
        boolean z6 = ViewCompat.getLayoutDirection(this.f2469a) == 1;
        if (this.f2453D) {
            return (z6 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
        }
        return z6;
    }

    public final void c(float f6, boolean z6) {
        float f7;
        float f8;
        Typeface typeface;
        boolean z7;
        Layout.Alignment alignment;
        if (this.f2451A == null) {
            return;
        }
        float fWidth = this.d.width();
        float fWidth2 = this.c.width();
        if (Math.abs(f6 - 1.0f) < 1.0E-5f) {
            f7 = this.i;
            f8 = this.f2464V;
            this.f2454F = 1.0f;
            typeface = this.f2486r;
        } else {
            float f9 = this.f2478h;
            float f10 = this.f2465W;
            Typeface typeface2 = this.u;
            if (Math.abs(f6 - 0.0f) < 1.0E-5f) {
                this.f2454F = 1.0f;
            } else {
                this.f2454F = f(this.f2478h, this.i, f6, this.f2462Q) / this.f2478h;
            }
            float f11 = this.i / this.f2478h;
            fWidth = (!z6 && fWidth2 * f11 > fWidth) ? Math.min(fWidth / f11, fWidth2) : fWidth2;
            f7 = f9;
            f8 = f10;
            typeface = typeface2;
        }
        TextPaint textPaint = this.f2459N;
        if (fWidth > 0.0f) {
            boolean z8 = this.f2455G != f7;
            boolean z9 = this.f2466X != f8;
            boolean z10 = this.x != typeface;
            StaticLayout staticLayout = this.f2467Y;
            boolean z11 = z8 || z9 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z10 || this.f2458M;
            this.f2455G = f7;
            this.f2466X = f8;
            this.x = typeface;
            this.f2458M = false;
            textPaint.setLinearText(this.f2454F != 1.0f);
            z7 = z11;
        } else {
            z7 = false;
        }
        if (this.f2452B == null || z7) {
            textPaint.setTextSize(this.f2455G);
            textPaint.setTypeface(this.x);
            textPaint.setLetterSpacing(this.f2466X);
            boolean zB = b(this.f2451A);
            this.C = zB;
            int i = this.f2473d0;
            if (i <= 1 || zB) {
                i = 1;
            }
            if (i == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f2475f, zB ? 1 : 0) & 7;
                alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.C ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.C ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
            }
            j jVar = new j(this.f2451A, textPaint, (int) fWidth);
            jVar.f2501k = this.f2491z;
            jVar.f2500j = zB;
            jVar.e = alignment;
            jVar.i = false;
            jVar.f2497f = i;
            jVar.f2498g = this.f2474e0;
            jVar.f2499h = this.f2476f0;
            StaticLayout staticLayout2 = (StaticLayout) Preconditions.checkNotNull(jVar.a());
            this.f2467Y = staticLayout2;
            this.f2452B = staticLayout2.getText();
        }
    }

    public final float d() {
        TextPaint textPaint = this.f2460O;
        textPaint.setTextSize(this.i);
        textPaint.setTypeface(this.f2486r);
        textPaint.setLetterSpacing(this.f2464V);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f2457L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f2488t;
            if (typeface != null) {
                this.f2487s = k0.h.a(configuration, typeface);
            }
            Typeface typeface2 = this.f2490w;
            if (typeface2 != null) {
                this.f2489v = k0.h.a(configuration, typeface2);
            }
            Typeface typeface3 = this.f2487s;
            if (typeface3 == null) {
                typeface3 = this.f2488t;
            }
            this.f2486r = typeface3;
            Typeface typeface4 = this.f2489v;
            if (typeface4 == null) {
                typeface4 = this.f2490w;
            }
            this.u = typeface4;
            h(true);
        }
    }

    public final void h(boolean z6) {
        float fMeasureText;
        StaticLayout staticLayout;
        TextInputLayout textInputLayout = this.f2469a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z6) {
            return;
        }
        c(1.0f, z6);
        CharSequence charSequence = this.f2452B;
        TextPaint textPaint = this.f2459N;
        if (charSequence != null && (staticLayout = this.f2467Y) != null) {
            this.f2472c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.f2491z);
        }
        CharSequence charSequence2 = this.f2472c0;
        if (charSequence2 != null) {
            this.f2468Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f2468Z = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f2477g, this.C ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.d;
        if (i == 48) {
            this.f2482m = rect.top;
        } else if (i != 80) {
            this.f2482m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f2482m = textPaint.ascent() + rect.bottom;
        }
        int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 == 1) {
            this.f2484o = rect.centerX() - (this.f2468Z / 2.0f);
        } else if (i3 != 5) {
            this.f2484o = rect.left;
        } else {
            this.f2484o = rect.right - this.f2468Z;
        }
        c(0.0f, z6);
        float height = this.f2467Y != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f2467Y;
        if (staticLayout2 == null || this.f2473d0 <= 1) {
            CharSequence charSequence3 = this.f2452B;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f2467Y;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f2475f, this.C ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        Rect rect2 = this.c;
        if (i4 == 48) {
            this.f2481l = rect2.top;
        } else if (i4 != 80) {
            this.f2481l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f2481l = textPaint.descent() + (rect2.bottom - height);
        }
        int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i5 == 1) {
            this.f2483n = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i5 != 5) {
            this.f2483n = rect2.left;
        } else {
            this.f2483n = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            bitmap.recycle();
            this.E = null;
        }
        l(this.b);
        float f6 = this.b;
        float f7 = f(rect2.left, rect.left, f6, this.f2461P);
        RectF rectF = this.e;
        rectF.left = f7;
        rectF.top = f(this.f2481l, this.f2482m, f6, this.f2461P);
        rectF.right = f(rect2.right, rect.right, f6, this.f2461P);
        rectF.bottom = f(rect2.bottom, rect.bottom, f6, this.f2461P);
        this.f2485p = f(this.f2483n, this.f2484o, f6, this.f2461P);
        this.q = f(this.f2481l, this.f2482m, f6, this.f2461P);
        l(f6);
        FastOutSlowInInterpolator fastOutSlowInInterpolator = W.a.b;
        this.f2470a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f6, fastOutSlowInInterpolator);
        ViewCompat.postInvalidateOnAnimation(textInputLayout);
        this.f2471b0 = f(1.0f, 0.0f, f6, fastOutSlowInInterpolator);
        ViewCompat.postInvalidateOnAnimation(textInputLayout);
        ColorStateList colorStateList = this.f2480k;
        ColorStateList colorStateList2 = this.f2479j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(e(colorStateList2), e(this.f2480k), f6));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f8 = this.f2464V;
        float f9 = this.f2465W;
        if (f8 != f9) {
            textPaint.setLetterSpacing(f(f9, f8, f6, fastOutSlowInInterpolator));
        } else {
            textPaint.setLetterSpacing(f8);
        }
        this.H = W.a.a(0.0f, this.R, f6);
        this.I = W.a.a(0.0f, this.S, f6);
        this.J = W.a.a(0.0f, this.f2463T, f6);
        int iA = a(0, e(this.U), f6);
        this.f2456K = iA;
        textPaint.setShadowLayer(this.H, this.I, this.J, iA);
        ViewCompat.postInvalidateOnAnimation(textInputLayout);
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f2480k == colorStateList && this.f2479j == colorStateList) {
            return;
        }
        this.f2480k = colorStateList;
        this.f2479j = colorStateList;
        h(false);
    }

    public final boolean j(Typeface typeface) {
        C0571a c0571a = this.y;
        if (c0571a != null) {
            c0571a.c = true;
        }
        if (this.f2488t == typeface) {
            return false;
        }
        this.f2488t = typeface;
        Typeface typefaceA = k0.h.a(this.f2469a.getContext().getResources().getConfiguration(), typeface);
        this.f2487s = typefaceA;
        if (typefaceA == null) {
            typefaceA = this.f2488t;
        }
        this.f2486r = typefaceA;
        return true;
    }

    public final void k(float f6) {
        float fClamp = MathUtils.clamp(f6, 0.0f, 1.0f);
        if (fClamp != this.b) {
            this.b = fClamp;
            float f7 = this.c.left;
            Rect rect = this.d;
            float f8 = f(f7, rect.left, fClamp, this.f2461P);
            RectF rectF = this.e;
            rectF.left = f8;
            rectF.top = f(this.f2481l, this.f2482m, fClamp, this.f2461P);
            rectF.right = f(r2.right, rect.right, fClamp, this.f2461P);
            rectF.bottom = f(r2.bottom, rect.bottom, fClamp, this.f2461P);
            this.f2485p = f(this.f2483n, this.f2484o, fClamp, this.f2461P);
            this.q = f(this.f2481l, this.f2482m, fClamp, this.f2461P);
            l(fClamp);
            FastOutSlowInInterpolator fastOutSlowInInterpolator = W.a.b;
            this.f2470a0 = 1.0f - f(0.0f, 1.0f, 1.0f - fClamp, fastOutSlowInInterpolator);
            TextInputLayout textInputLayout = this.f2469a;
            ViewCompat.postInvalidateOnAnimation(textInputLayout);
            this.f2471b0 = f(1.0f, 0.0f, fClamp, fastOutSlowInInterpolator);
            ViewCompat.postInvalidateOnAnimation(textInputLayout);
            ColorStateList colorStateList = this.f2480k;
            ColorStateList colorStateList2 = this.f2479j;
            TextPaint textPaint = this.f2459N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(e(colorStateList2), e(this.f2480k), fClamp));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f9 = this.f2464V;
            float f10 = this.f2465W;
            if (f9 != f10) {
                textPaint.setLetterSpacing(f(f10, f9, fClamp, fastOutSlowInInterpolator));
            } else {
                textPaint.setLetterSpacing(f9);
            }
            this.H = W.a.a(0.0f, this.R, fClamp);
            this.I = W.a.a(0.0f, this.S, fClamp);
            this.J = W.a.a(0.0f, this.f2463T, fClamp);
            int iA = a(0, e(this.U), fClamp);
            this.f2456K = iA;
            textPaint.setShadowLayer(this.H, this.I, this.J, iA);
            ViewCompat.postInvalidateOnAnimation(textInputLayout);
        }
    }

    public final void l(float f6) {
        c(f6, false);
        ViewCompat.postInvalidateOnAnimation(this.f2469a);
    }

    public final void m(Typeface typeface) {
        boolean z6;
        boolean zJ = j(typeface);
        if (this.f2490w != typeface) {
            this.f2490w = typeface;
            Typeface typefaceA = k0.h.a(this.f2469a.getContext().getResources().getConfiguration(), typeface);
            this.f2489v = typefaceA;
            if (typefaceA == null) {
                typefaceA = this.f2490w;
            }
            this.u = typefaceA;
            z6 = true;
        } else {
            z6 = false;
        }
        if (zJ || z6) {
            h(false);
        }
    }
}
