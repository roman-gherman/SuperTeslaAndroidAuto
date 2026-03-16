package d0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.chip.ChipDrawable$Delegate;
import com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate;
import com.google.android.material.internal.l;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l0.AbstractC0615a;
import n0.C0695a;
import n0.e;
import n0.f;
import n0.i;

/* JADX INFO: renamed from: d0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0414c extends f implements Drawable.Callback, TextDrawableHelper$TextDrawableDelegate {

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public static final int[] f3069F0 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public static final ShapeDrawable f3070G0 = new ShapeDrawable(new OvalShape());

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f3071A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public WeakReference f3072A0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ColorStateList f3073B;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public TextUtils.TruncateAt f3074B0;
    public float C;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public boolean f3075C0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ColorStateList f3076D;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public int f3077D0;
    public CharSequence E;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public boolean f3078E0;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f3079F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public Drawable f3080G;
    public ColorStateList H;
    public float I;
    public boolean J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f3081K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public Drawable f3082L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public RippleDrawable f3083M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public ColorStateList f3084N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public float f3085O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f3086P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f3087Q;
    public boolean R;
    public Drawable S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public ColorStateList f3088T;
    public W.f U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public W.f f3089V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public float f3090W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public float f3091X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public float f3092Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public float f3093Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f3094a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f3095b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f3096c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f3097d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Context f3098e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Paint f3099f0;
    public final Paint.FontMetrics g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final RectF f3100h0;
    public final PointF i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Path f3101j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final l f3102k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f3103l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3104m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3105n0;
    public int o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f3106p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f3107q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f3108r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f3109s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f3110t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ColorFilter f3111u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public PorterDuffColorFilter f3112v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ColorStateList f3113w0;
    public ColorStateList x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public PorterDuff.Mode f3114x0;
    public ColorStateList y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int[] f3115y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3116z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ColorStateList f3117z0;

    public C0414c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action);
        this.f3071A = -1.0f;
        this.f3099f0 = new Paint(1);
        this.g0 = new Paint.FontMetrics();
        this.f3100h0 = new RectF();
        this.i0 = new PointF();
        this.f3101j0 = new Path();
        this.f3110t0 = 255;
        this.f3114x0 = PorterDuff.Mode.SRC_IN;
        this.f3072A0 = new WeakReference(null);
        i(context);
        this.f3098e0 = context;
        l lVar = new l(this);
        this.f3102k0 = lVar;
        this.E = "";
        lVar.f2503a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f3069F0;
        setState(iArr);
        if (!Arrays.equals(this.f3115y0, iArr)) {
            this.f3115y0 = iArr;
            if (V()) {
                y(getState(), iArr);
            }
        }
        this.f3075C0 = true;
        int[] iArr2 = AbstractC0615a.f3956a;
        f3070G0.setTint(-1);
    }

    public static void W(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean v(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean w(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(Drawable drawable) {
        if (this.S != drawable) {
            float fS = s();
            this.S = drawable;
            float fS2 = s();
            W(this.S);
            q(this.S);
            invalidateSelf();
            if (fS != fS2) {
                x();
            }
        }
    }

    public final void B(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f3088T != colorStateList) {
            this.f3088T = colorStateList;
            if (this.R && (drawable = this.S) != null && this.f3087Q) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void C(boolean z6) {
        if (this.R != z6) {
            boolean zT = T();
            this.R = z6;
            boolean zT2 = T();
            if (zT != zT2) {
                if (zT2) {
                    q(this.S);
                } else {
                    W(this.S);
                }
                invalidateSelf();
                x();
            }
        }
    }

    public final void D(float f6) {
        if (this.f3071A != f6) {
            this.f3071A = f6;
            i iVarE = this.f4177a.f4165a.e();
            iVarE.e = new C0695a(f6);
            iVarE.f4194f = new C0695a(f6);
            iVarE.f4195g = new C0695a(f6);
            iVarE.f4196h = new C0695a(f6);
            setShapeAppearanceModel(iVarE.a());
        }
    }

    public final void E(Drawable drawable) {
        Drawable drawable2 = this.f3080G;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float fS = s();
            this.f3080G = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fS2 = s();
            W(drawableUnwrap);
            if (U()) {
                q(this.f3080G);
            }
            invalidateSelf();
            if (fS != fS2) {
                x();
            }
        }
    }

    public final void F(float f6) {
        if (this.I != f6) {
            float fS = s();
            this.I = f6;
            float fS2 = s();
            invalidateSelf();
            if (fS != fS2) {
                x();
            }
        }
    }

    public final void G(ColorStateList colorStateList) {
        this.J = true;
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (U()) {
                DrawableCompat.setTintList(this.f3080G, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void H(boolean z6) {
        if (this.f3079F != z6) {
            boolean zU = U();
            this.f3079F = z6;
            boolean zU2 = U();
            if (zU != zU2) {
                if (zU2) {
                    q(this.f3080G);
                } else {
                    W(this.f3080G);
                }
                invalidateSelf();
                x();
            }
        }
    }

    public final void I(ColorStateList colorStateList) {
        if (this.f3073B != colorStateList) {
            this.f3073B = colorStateList;
            if (this.f3078E0) {
                e eVar = this.f4177a;
                if (eVar.d != colorStateList) {
                    eVar.d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void J(float f6) {
        if (this.C != f6) {
            this.C = f6;
            this.f3099f0.setStrokeWidth(f6);
            if (this.f3078E0) {
                this.f4177a.f4169j = f6;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void K(Drawable drawable) {
        Drawable drawable2 = this.f3082L;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float fT = t();
            this.f3082L = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            int[] iArr = AbstractC0615a.f3956a;
            this.f3083M = new RippleDrawable(AbstractC0615a.b(this.f3076D), this.f3082L, f3070G0);
            float fT2 = t();
            W(drawableUnwrap);
            if (V()) {
                q(this.f3082L);
            }
            invalidateSelf();
            if (fT != fT2) {
                x();
            }
        }
    }

    public final void L(float f6) {
        if (this.f3096c0 != f6) {
            this.f3096c0 = f6;
            invalidateSelf();
            if (V()) {
                x();
            }
        }
    }

    public final void M(float f6) {
        if (this.f3085O != f6) {
            this.f3085O = f6;
            invalidateSelf();
            if (V()) {
                x();
            }
        }
    }

    public final void N(float f6) {
        if (this.f3095b0 != f6) {
            this.f3095b0 = f6;
            invalidateSelf();
            if (V()) {
                x();
            }
        }
    }

    public final void O(ColorStateList colorStateList) {
        if (this.f3084N != colorStateList) {
            this.f3084N = colorStateList;
            if (V()) {
                DrawableCompat.setTintList(this.f3082L, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void P(boolean z6) {
        if (this.f3081K != z6) {
            boolean zV = V();
            this.f3081K = z6;
            boolean zV2 = V();
            if (zV != zV2) {
                if (zV2) {
                    q(this.f3082L);
                } else {
                    W(this.f3082L);
                }
                invalidateSelf();
                x();
            }
        }
    }

    public final void Q(float f6) {
        if (this.f3092Y != f6) {
            float fS = s();
            this.f3092Y = f6;
            float fS2 = s();
            invalidateSelf();
            if (fS != fS2) {
                x();
            }
        }
    }

    public final void R(float f6) {
        if (this.f3091X != f6) {
            float fS = s();
            this.f3091X = f6;
            float fS2 = s();
            invalidateSelf();
            if (fS != fS2) {
                x();
            }
        }
    }

    public final void S(ColorStateList colorStateList) {
        if (this.f3076D != colorStateList) {
            this.f3076D = colorStateList;
            this.f3117z0 = null;
            onStateChange(getState());
        }
    }

    public final boolean T() {
        return this.R && this.S != null && this.f3108r0;
    }

    public final boolean U() {
        return this.f3079F && this.f3080G != null;
    }

    public final boolean V() {
        return this.f3081K && this.f3082L != null;
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        int i3;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.f3110t0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z6 = this.f3078E0;
        Paint paint = this.f3099f0;
        RectF rectF = this.f3100h0;
        if (!z6) {
            paint.setColor(this.f3103l0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, u(), u(), paint);
        }
        if (!this.f3078E0) {
            paint.setColor(this.f3104m0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f3111u0;
            if (colorFilter == null) {
                colorFilter = this.f3112v0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, u(), u(), paint);
        }
        if (this.f3078E0) {
            super.draw(canvas);
        }
        if (this.C > 0.0f && !this.f3078E0) {
            paint.setColor(this.o0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f3078E0) {
                ColorFilter colorFilter2 = this.f3111u0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f3112v0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f6 = bounds.left;
            float f7 = this.C / 2.0f;
            rectF.set(f6 + f7, bounds.top + f7, bounds.right - f7, bounds.bottom - f7);
            float f8 = this.f3071A - (this.C / 2.0f);
            canvas2.drawRoundRect(rectF, f8, f8, paint);
        }
        paint.setColor(this.f3106p0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f3078E0) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.f3101j0;
            e eVar = this.f4177a;
            this.f4188r.a(eVar.f4165a, eVar.i, rectF2, this.q, path);
            d(canvas2, paint, path, this.f4177a.f4165a, f());
        } else {
            canvas2.drawRoundRect(rectF, u(), u(), paint);
        }
        if (U()) {
            r(bounds, rectF);
            float f9 = rectF.left;
            float f10 = rectF.top;
            canvas2.translate(f9, f10);
            this.f3080G.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f3080G.draw(canvas2);
            canvas2.translate(-f9, -f10);
        }
        if (T()) {
            r(bounds, rectF);
            float f11 = rectF.left;
            float f12 = rectF.top;
            canvas2.translate(f11, f12);
            this.S.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.S.draw(canvas2);
            canvas2.translate(-f11, -f12);
        }
        if (this.f3075C0 && this.E != null) {
            PointF pointF = this.i0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.E;
            l lVar = this.f3102k0;
            if (charSequence != null) {
                float fS = s() + this.f3090W + this.f3093Z;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    pointF.x = bounds.left + fS;
                } else {
                    pointF.x = bounds.right - fS;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = lVar.f2503a;
                Paint.FontMetrics fontMetrics = this.g0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.E != null) {
                float fS2 = s() + this.f3090W + this.f3093Z;
                float fT = t() + this.f3097d0 + this.f3094a0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF.left = bounds.left + fS2;
                    rectF.right = bounds.right - fT;
                } else {
                    rectF.left = bounds.left + fT;
                    rectF.right = bounds.right - fS2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            k0.f fVar = lVar.f2504f;
            TextPaint textPaint2 = lVar.f2503a;
            if (fVar != null) {
                textPaint2.drawableState = getState();
                lVar.f2504f.d(this.f3098e0, textPaint2, lVar.b);
            }
            textPaint2.setTextAlign(align);
            boolean z7 = Math.round(lVar.a(this.E.toString())) > Math.round(rectF.width());
            if (z7) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i3 = iSave;
            } else {
                i3 = 0;
            }
            CharSequence charSequenceEllipsize = this.E;
            if (z7 && this.f3074B0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.f3074B0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z7) {
                canvas2.restoreToCount(i3);
            }
        }
        if (V()) {
            rectF.setEmpty();
            if (V()) {
                float f13 = this.f3097d0 + this.f3096c0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f14 = bounds.right - f13;
                    rectF.right = f14;
                    rectF.left = f14 - this.f3085O;
                } else {
                    float f15 = bounds.left + f13;
                    rectF.left = f15;
                    rectF.right = f15 + this.f3085O;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f16 = this.f3085O;
                float f17 = fExactCenterY - (f16 / 2.0f);
                rectF.top = f17;
                rectF.bottom = f17 + f16;
            }
            float f18 = rectF.left;
            float f19 = rectF.top;
            canvas2.translate(f18, f19);
            this.f3082L.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = AbstractC0615a.f3956a;
            this.f3083M.setBounds(this.f3082L.getBounds());
            this.f3083M.jumpToCurrentState();
            this.f3083M.draw(canvas2);
            canvas2.translate(-f18, -f19);
        }
        if (this.f3110t0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f3110t0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f3111u0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f3116z;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(t() + this.f3102k0.a(this.E.toString()) + s() + this.f3090W + this.f3093Z + this.f3094a0 + this.f3097d0), this.f3077D0);
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.f3078E0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f3116z, this.f3071A);
        } else {
            outline.setRoundRect(bounds, this.f3071A);
            outline2 = outline;
        }
        outline2.setAlpha(this.f3110t0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (v(this.x) || v(this.y) || v(this.f3073B)) {
            return true;
        }
        k0.f fVar = this.f3102k0.f2504f;
        if (fVar == null || (colorStateList = fVar.f3685j) == null || !colorStateList.isStateful()) {
            return (this.R && this.S != null && this.f3087Q) || w(this.f3080G) || w(this.S) || v(this.f3113w0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (U()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f3080G, i);
        }
        if (T()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.S, i);
        }
        if (V()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f3082L, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (U()) {
            zOnLevelChange |= this.f3080G.setLevel(i);
        }
        if (T()) {
            zOnLevelChange |= this.S.setLevel(i);
        }
        if (V()) {
            zOnLevelChange |= this.f3082L.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // n0.f, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        if (this.f3078E0) {
            super.onStateChange(iArr);
        }
        return y(iArr, this.f3115y0);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate
    public final void onTextSizeChange() {
        x();
        invalidateSelf();
    }

    public final void q(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f3082L) {
            if (drawable.isStateful()) {
                drawable.setState(this.f3115y0);
            }
            DrawableCompat.setTintList(drawable, this.f3084N);
            return;
        }
        Drawable drawable2 = this.f3080G;
        if (drawable == drawable2 && this.J) {
            DrawableCompat.setTintList(drawable2, this.H);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void r(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (U() || T()) {
            float f6 = this.f3090W + this.f3091X;
            Drawable drawable = this.f3108r0 ? this.S : this.f3080G;
            float intrinsicWidth = this.I;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f7 = rect.left + f6;
                rectF.left = f7;
                rectF.right = f7 + intrinsicWidth;
            } else {
                float f8 = rect.right - f6;
                rectF.right = f8;
                rectF.left = f8 - intrinsicWidth;
            }
            Drawable drawable2 = this.f3108r0 ? this.S : this.f3080G;
            float fCeil = this.I;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f3098e0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float s() {
        if (!U() && !T()) {
            return 0.0f;
        }
        float f6 = this.f3091X;
        Drawable drawable = this.f3108r0 ? this.S : this.f3080G;
        float intrinsicWidth = this.I;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f6 + this.f3092Y;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j6);
        }
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f3110t0 != i) {
            this.f3110t0 = i;
            invalidateSelf();
        }
    }

    @Override // n0.f, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f3111u0 != colorFilter) {
            this.f3111u0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // n0.f, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f3113w0 != colorStateList) {
            this.f3113w0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // n0.f, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f3114x0 != mode) {
            this.f3114x0 = mode;
            ColorStateList colorStateList = this.f3113w0;
            this.f3112v0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z6, boolean z7) {
        boolean visible = super.setVisible(z6, z7);
        if (U()) {
            visible |= this.f3080G.setVisible(z6, z7);
        }
        if (T()) {
            visible |= this.S.setVisible(z6, z7);
        }
        if (V()) {
            visible |= this.f3082L.setVisible(z6, z7);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final float t() {
        if (V()) {
            return this.f3095b0 + this.f3085O + this.f3096c0;
        }
        return 0.0f;
    }

    public final float u() {
        return this.f3078E0 ? g() : this.f3071A;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void x() {
        ChipDrawable$Delegate chipDrawable$Delegate = (ChipDrawable$Delegate) this.f3072A0.get();
        if (chipDrawable$Delegate != null) {
            chipDrawable$Delegate.onChipDrawableSizeChange();
        }
    }

    public final boolean y(int[] iArr, int[] iArr2) {
        boolean z6;
        boolean z7;
        ColorStateList colorStateList;
        boolean state = true;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.x;
        int iB = b(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f3103l0) : 0);
        if (this.f3103l0 != iB) {
            this.f3103l0 = iB;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.y;
        int iB2 = b(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f3104m0) : 0);
        if (this.f3104m0 != iB2) {
            this.f3104m0 = iB2;
            zOnStateChange = true;
        }
        int iCompositeColors = ColorUtils.compositeColors(iB2, iB);
        if ((this.f3105n0 != iCompositeColors) | (this.f4177a.c == null)) {
            this.f3105n0 = iCompositeColors;
            k(ColorStateList.valueOf(iCompositeColors));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.f3073B;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.o0) : 0;
        if (this.o0 != colorForState) {
            this.o0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f3117z0 == null || !AbstractC0615a.c(iArr)) ? 0 : this.f3117z0.getColorForState(iArr, this.f3106p0);
        if (this.f3106p0 != colorForState2) {
            this.f3106p0 = colorForState2;
        }
        k0.f fVar = this.f3102k0.f2504f;
        int colorForState3 = (fVar == null || (colorStateList = fVar.f3685j) == null) ? 0 : colorStateList.getColorForState(iArr, this.f3107q0);
        if (this.f3107q0 != colorForState3) {
            this.f3107q0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z6 = false;
        } else {
            int length = state2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (state2[i] != 16842912) {
                    i++;
                } else if (this.f3087Q) {
                    z6 = true;
                }
            }
            z6 = false;
        }
        if (this.f3108r0 == z6 || this.S == null) {
            z7 = false;
        } else {
            float fS = s();
            this.f3108r0 = z6;
            if (fS != s()) {
                zOnStateChange = true;
                z7 = true;
            } else {
                zOnStateChange = true;
                z7 = false;
            }
        }
        ColorStateList colorStateList5 = this.f3113w0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.f3109s0) : 0;
        if (this.f3109s0 != colorForState4) {
            this.f3109s0 = colorForState4;
            ColorStateList colorStateList6 = this.f3113w0;
            PorterDuff.Mode mode = this.f3114x0;
            this.f3112v0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (w(this.f3080G)) {
            state |= this.f3080G.setState(iArr);
        }
        if (w(this.S)) {
            state |= this.S.setState(iArr);
        }
        if (w(this.f3082L)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f3082L.setState(iArr3);
        }
        int[] iArr4 = AbstractC0615a.f3956a;
        if (w(this.f3083M)) {
            state |= this.f3083M.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z7) {
            x();
        }
        return state;
    }

    public final void z(boolean z6) {
        if (this.f3087Q != z6) {
            this.f3087Q = z6;
            float fS = s();
            if (!z6 && this.f3108r0) {
                this.f3108r0 = false;
            }
            float fS2 = s();
            invalidateSelf();
            if (fS != fS2) {
                x();
            }
        }
    }
}
