package k0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f3682a;
    public final String b;
    public final int c;
    public final int d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f3683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f3684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3685h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ColorStateList f3686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3689m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Typeface f3690n;

    public f(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, V.a.E);
        this.f3687k = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.f3686j = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 3);
        AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 4);
        AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 5);
        this.c = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i3 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f3688l = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
        this.b = typedArrayObtainStyledAttributes.getString(i3);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f3682a = AbstractC0573c.a(context, typedArrayObtainStyledAttributes, 6);
        this.e = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f3683f = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.f3684g = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, V.a.u);
        this.f3685h = typedArrayObtainStyledAttributes2.hasValue(0);
        this.i = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f3690n;
        int i = this.c;
        if (typeface == null && (str = this.b) != null) {
            this.f3690n = Typeface.create(str, i);
        }
        if (this.f3690n == null) {
            int i3 = this.d;
            if (i3 == 1) {
                this.f3690n = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                this.f3690n = Typeface.SERIF;
            } else if (i3 != 3) {
                this.f3690n = Typeface.DEFAULT;
            } else {
                this.f3690n = Typeface.MONOSPACE;
            }
            this.f3690n = Typeface.create(this.f3690n, i);
        }
    }

    public final Typeface b(Context context) {
        if (this.f3689m) {
            return this.f3690n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f3688l);
                this.f3690n = font;
                if (font != null) {
                    this.f3690n = Typeface.create(font, this.c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException | Exception unused) {
            }
        }
        a();
        this.f3689m = true;
        return this.f3690n;
    }

    public final void c(Context context, g gVar) {
        int i = this.f3688l;
        if ((i != 0 ? ResourcesCompat.getCachedFont(context, i) : null) != null) {
            b(context);
        } else {
            a();
        }
        if (i == 0) {
            this.f3689m = true;
        }
        if (this.f3689m) {
            gVar.b(this.f3690n, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i, new C0574d(this, gVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f3689m = true;
            gVar.a(1);
        } catch (Exception unused2) {
            this.f3689m = true;
            gVar.a(-3);
        }
    }

    public final void d(Context context, TextPaint textPaint, g gVar) {
        e(context, textPaint, gVar);
        ColorStateList colorStateList = this.f3686j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        ColorStateList colorStateList2 = this.f3682a;
        textPaint.setShadowLayer(this.f3684g, this.e, this.f3683f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, g gVar) {
        int i = this.f3688l;
        if ((i != 0 ? ResourcesCompat.getCachedFont(context, i) : null) != null) {
            f(context, textPaint, b(context));
            return;
        }
        a();
        f(context, textPaint, this.f3690n);
        c(context, new C0575e(this, context, textPaint, gVar));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = h.a(context.getResources().getConfiguration(), typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.c;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f3687k);
        if (this.f3685h) {
            textPaint.setLetterSpacing(this.i);
        }
    }
}
