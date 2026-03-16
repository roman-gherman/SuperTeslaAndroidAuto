package com.google.android.material.chip;

import V.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.o;
import com.google.android.material.shape.Shapeable;
import d0.C0412a;
import d0.C0413b;
import d0.C0414c;
import fr.sd.taada.activities.e;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import k0.AbstractC0573c;
import k0.f;
import l0.AbstractC0615a;
import n0.j;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable$Delegate, Shapeable, MaterialCheckable<Chip> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Rect f2327t = new Rect();
    public static final int[] u = {R.attr.state_selected};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f2328v = {R.attr.state_checkable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0414c f2329a;
    public InsetDrawable b;
    public RippleDrawable c;
    public View.OnClickListener d;
    public CompoundButton.OnCheckedChangeListener e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MaterialCheckable.OnCheckedChangeListener f2330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2332h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2335l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2336m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f2337n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C0413b f2338o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2339p;
    public final Rect q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f2340r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f2341s;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(AbstractC0792a.a(context, attributeSet, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, fr.sd.taada.R.attr.chipStyle);
        this.q = new Rect();
        this.f2340r = new RectF();
        this.f2341s = new k(this, 1);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        C0414c c0414c = new C0414c(context2, attributeSet);
        int[] iArr = a.e;
        TypedArray typedArrayD = o.d(c0414c.f3098e0, attributeSet, iArr, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        c0414c.f3078E0 = typedArrayD.hasValue(37);
        Context context3 = c0414c.f3098e0;
        ColorStateList colorStateListA = AbstractC0573c.a(context3, typedArrayD, 24);
        if (c0414c.x != colorStateListA) {
            c0414c.x = colorStateListA;
            c0414c.onStateChange(c0414c.getState());
        }
        ColorStateList colorStateListA2 = AbstractC0573c.a(context3, typedArrayD, 11);
        if (c0414c.y != colorStateListA2) {
            c0414c.y = colorStateListA2;
            c0414c.onStateChange(c0414c.getState());
        }
        float dimension = typedArrayD.getDimension(19, 0.0f);
        if (c0414c.f3116z != dimension) {
            c0414c.f3116z = dimension;
            c0414c.invalidateSelf();
            c0414c.x();
        }
        if (typedArrayD.hasValue(12)) {
            c0414c.D(typedArrayD.getDimension(12, 0.0f));
        }
        c0414c.I(AbstractC0573c.a(context3, typedArrayD, 22));
        c0414c.J(typedArrayD.getDimension(23, 0.0f));
        c0414c.S(AbstractC0573c.a(context3, typedArrayD, 36));
        String text = typedArrayD.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(c0414c.E, text);
        l lVar = c0414c.f3102k0;
        if (!zEquals) {
            c0414c.E = text;
            lVar.d = true;
            c0414c.invalidateSelf();
            c0414c.x();
        }
        f fVar = (!typedArrayD.hasValue(0) || (resourceId3 = typedArrayD.getResourceId(0, 0)) == 0) ? null : new f(context3, resourceId3);
        fVar.f3686k = typedArrayD.getDimension(1, fVar.f3686k);
        lVar.b(fVar, context3);
        int i = typedArrayD.getInt(3, 0);
        if (i == 1) {
            c0414c.f3074B0 = TextUtils.TruncateAt.START;
        } else if (i == 2) {
            c0414c.f3074B0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i == 3) {
            c0414c.f3074B0 = TextUtils.TruncateAt.END;
        }
        c0414c.H(typedArrayD.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            c0414c.H(typedArrayD.getBoolean(15, false));
        }
        c0414c.E(AbstractC0573c.c(context3, typedArrayD, 14));
        if (typedArrayD.hasValue(17)) {
            c0414c.G(AbstractC0573c.a(context3, typedArrayD, 17));
        }
        c0414c.F(typedArrayD.getDimension(16, -1.0f));
        c0414c.P(typedArrayD.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            c0414c.P(typedArrayD.getBoolean(26, false));
        }
        c0414c.K(AbstractC0573c.c(context3, typedArrayD, 25));
        c0414c.O(AbstractC0573c.a(context3, typedArrayD, 30));
        c0414c.M(typedArrayD.getDimension(28, 0.0f));
        c0414c.z(typedArrayD.getBoolean(6, false));
        c0414c.C(typedArrayD.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            c0414c.C(typedArrayD.getBoolean(8, false));
        }
        c0414c.A(AbstractC0573c.c(context3, typedArrayD, 7));
        if (typedArrayD.hasValue(9)) {
            c0414c.B(AbstractC0573c.a(context3, typedArrayD, 9));
        }
        c0414c.U = (!typedArrayD.hasValue(39) || (resourceId2 = typedArrayD.getResourceId(39, 0)) == 0) ? null : W.f.a(context3, resourceId2);
        c0414c.f3089V = (!typedArrayD.hasValue(33) || (resourceId = typedArrayD.getResourceId(33, 0)) == 0) ? null : W.f.a(context3, resourceId);
        float dimension2 = typedArrayD.getDimension(21, 0.0f);
        if (c0414c.f3090W != dimension2) {
            c0414c.f3090W = dimension2;
            c0414c.invalidateSelf();
            c0414c.x();
        }
        c0414c.R(typedArrayD.getDimension(35, 0.0f));
        c0414c.Q(typedArrayD.getDimension(34, 0.0f));
        float dimension3 = typedArrayD.getDimension(41, 0.0f);
        if (c0414c.f3093Z != dimension3) {
            c0414c.f3093Z = dimension3;
            c0414c.invalidateSelf();
            c0414c.x();
        }
        float dimension4 = typedArrayD.getDimension(40, 0.0f);
        if (c0414c.f3094a0 != dimension4) {
            c0414c.f3094a0 = dimension4;
            c0414c.invalidateSelf();
            c0414c.x();
        }
        c0414c.N(typedArrayD.getDimension(29, 0.0f));
        c0414c.L(typedArrayD.getDimension(27, 0.0f));
        float dimension5 = typedArrayD.getDimension(13, 0.0f);
        if (c0414c.f3097d0 != dimension5) {
            c0414c.f3097d0 = dimension5;
            c0414c.invalidateSelf();
            c0414c.x();
        }
        c0414c.f3077D0 = typedArrayD.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayD.recycle();
        o.a(context2, attributeSet, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action);
        o.b(context2, attributeSet, iArr, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action);
        this.f2334k = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.f2336m = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(TypedValue.applyDimension(1, 48, getContext().getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(c0414c);
        c0414c.j(ViewCompat.getElevation(this));
        o.a(context2, attributeSet, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action);
        o.b(context2, attributeSet, iArr, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, fr.sd.taada.R.attr.chipStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f2338o = new C0413b(this, this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new C0412a(this));
        }
        setChecked(this.f2331g);
        setText(c0414c.E);
        setEllipsize(c0414c.f3074B0);
        h();
        if (!this.f2329a.f3075C0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.f2334k) {
            setMinHeight(this.f2336m);
        }
        this.f2335l = ViewCompat.getLayoutDirection(this);
        super.setOnCheckedChangeListener(new e(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f2340r;
        rectF.setEmpty();
        if (d() && this.d != null) {
            C0414c c0414c = this.f2329a;
            Rect bounds = c0414c.getBounds();
            rectF.setEmpty();
            if (c0414c.V()) {
                float f6 = c0414c.f3097d0 + c0414c.f3096c0 + c0414c.f3085O + c0414c.f3095b0 + c0414c.f3094a0;
                if (DrawableCompat.getLayoutDirection(c0414c) == 0) {
                    float f7 = bounds.right;
                    rectF.right = f7;
                    rectF.left = f7 - f6;
                } else {
                    float f8 = bounds.left;
                    rectF.left = f8;
                    rectF.right = f8 + f6;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i3 = (int) closeIconTouchBounds.top;
        int i4 = (int) closeIconTouchBounds.right;
        int i5 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.q;
        rect.set(i, i3, i4, i5);
        return rect;
    }

    private f getTextAppearance() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3102k0.f2504f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z6) {
        if (this.i != z6) {
            this.i = z6;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z6) {
        if (this.f2332h != z6) {
            this.f2332h = z6;
            refreshDrawableState();
        }
    }

    public final void c(int i) {
        this.f2336m = i;
        if (!this.f2334k) {
            InsetDrawable insetDrawable = this.b;
            if (insetDrawable == null) {
                int[] iArr = AbstractC0615a.f3956a;
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.b = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = AbstractC0615a.f3956a;
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.f2329a.f3116z));
        int iMax2 = Math.max(0, i - this.f2329a.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.b;
            if (insetDrawable2 == null) {
                int[] iArr3 = AbstractC0615a.f3956a;
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.b = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = AbstractC0615a.f3956a;
                    f();
                    return;
                }
                return;
            }
        }
        int i3 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i4 = iMax > 0 ? iMax / 2 : 0;
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                int[] iArr5 = AbstractC0615a.f3956a;
                f();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.b = new InsetDrawable((Drawable) this.f2329a, i3, i4, i3, i4);
        int[] iArr6 = AbstractC0615a.f3956a;
        f();
    }

    public final boolean d() {
        C0414c c0414c = this.f2329a;
        if (c0414c == null) {
            return false;
        }
        Drawable drawable = c0414c.f3082L;
        return (drawable != null ? DrawableCompat.unwrap(drawable) : null) != null;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f2339p ? super.dispatchHoverEvent(motionEvent) : this.f2338o.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f2339p) {
            return super.dispatchKeyEvent(keyEvent);
        }
        C0413b c0413b = this.f2338o;
        if (!c0413b.dispatchKeyEvent(keyEvent) || c0413b.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i;
        super.drawableStateChanged();
        C0414c c0414c = this.f2329a;
        boolean zY = false;
        if (c0414c != null && C0414c.w(c0414c.f3082L)) {
            C0414c c0414c2 = this.f2329a;
            ?? IsEnabled = isEnabled();
            int i3 = IsEnabled;
            if (this.f2333j) {
                i3 = IsEnabled + 1;
            }
            int i4 = i3;
            if (this.i) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (this.f2332h) {
                i5 = i4 + 1;
            }
            int i6 = i5;
            if (isChecked()) {
                i6 = i5 + 1;
            }
            int[] iArr = new int[i6];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            } else {
                i = 0;
            }
            if (this.f2333j) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.i) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.f2332h) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            if (!Arrays.equals(c0414c2.f3115y0, iArr)) {
                c0414c2.f3115y0 = iArr;
                if (c0414c2.V()) {
                    zY = c0414c2.y(c0414c2.getState(), iArr);
                }
            }
        }
        if (zY) {
            invalidate();
        }
    }

    public final void e() {
        C0414c c0414c;
        if (!d() || (c0414c = this.f2329a) == null || !c0414c.f3081K || this.d == null) {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.f2339p = false;
        } else {
            ViewCompat.setAccessibilityDelegate(this, this.f2338o);
            this.f2339p = true;
        }
    }

    public final void f() {
        this.c = new RippleDrawable(AbstractC0615a.b(this.f2329a.f3076D), getBackgroundDrawable(), null);
        this.f2329a.getClass();
        ViewCompat.setBackground(this, this.c);
        g();
    }

    public final void g() {
        C0414c c0414c;
        if (TextUtils.isEmpty(getText()) || (c0414c = this.f2329a) == null) {
            return;
        }
        int iT = (int) (c0414c.t() + c0414c.f3097d0 + c0414c.f3094a0);
        C0414c c0414c2 = this.f2329a;
        int iS = (int) (c0414c2.s() + c0414c2.f3090W + c0414c2.f3093Z);
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            iS += rect.left;
            iT += rect.right;
        }
        ViewCompat.setPaddingRelative(this, iS, getPaddingTop(), iT, getPaddingBottom());
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f2337n)) {
            return this.f2337n;
        }
        C0414c c0414c = this.f2329a;
        if (!(c0414c != null && c0414c.f3087Q)) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.b;
        return insetDrawable == null ? this.f2329a : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.S;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3088T;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.y;
        }
        return null;
    }

    public float getChipCornerRadius() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return Math.max(0.0f, c0414c.u());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2329a;
    }

    public float getChipEndPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3097d0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        C0414c c0414c = this.f2329a;
        if (c0414c == null || (drawable = c0414c.f3080G) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    public float getChipIconSize() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.I;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.H;
        }
        return null;
    }

    public float getChipMinHeight() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3116z;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3090W;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3073B;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.C;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        C0414c c0414c = this.f2329a;
        if (c0414c == null || (drawable = c0414c.f3082L) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    public CharSequence getCloseIconContentDescription() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3086P;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3096c0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3085O;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3095b0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3084N;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3074B0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f2339p) {
            C0413b c0413b = this.f2338o;
            if (c0413b.getKeyboardFocusedVirtualViewId() == 1 || c0413b.getAccessibilityFocusedVirtualViewId() == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public W.f getHideMotionSpec() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3089V;
        }
        return null;
    }

    public float getIconEndPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3092Y;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3091X;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3076D;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    public j getShapeAppearanceModel() {
        return this.f2329a.f4177a.f4165a;
    }

    public W.f getShowMotionSpec() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.U;
        }
        return null;
    }

    public float getTextEndPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3094a0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            return c0414c.f3093Z;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            paint.drawableState = c0414c.getState();
        }
        f textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.f2341s);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        k1.j.q(this, this.f2329a);
    }

    @Override // com.google.android.material.chip.ChipDrawable$Delegate
    public final void onChipDrawableSizeChange() {
        c(this.f2336m);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, u);
        }
        C0414c c0414c = this.f2329a;
        if (c0414c != null && c0414c.f3087Q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2328v);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z6, int i, Rect rect) {
        super.onFocusChanged(z6, i, rect);
        if (this.f2339p) {
            this.f2338o.onFocusChanged(z6, i, rect);
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        C0414c c0414c = this.f2329a;
        accessibilityNodeInfo.setCheckable(c0414c != null && c0414c.f3087Q);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.f2335l != i) {
            this.f2335l = i;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f2332h
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r2)
        L2a:
            r0 = r3
            goto L51
        L2c:
            boolean r0 = r5.f2332h
            if (r0 == 0) goto L45
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.d
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.f2339p
            if (r0 == 0) goto L43
            d0.b r0 = r5.f2338o
            r0.sendEventForVirtualView(r3, r3)
        L43:
            r0 = r3
            goto L46
        L45:
            r0 = r2
        L46:
            r5.setCloseIconPressed(r2)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r3)
            goto L2a
        L50:
            r0 = r2
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r2
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f2337n = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.c) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.c) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.z(z6);
        }
    }

    public void setCheckableResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.z(c0414c.f3098e0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z6) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null) {
            this.f2331g = z6;
        } else if (c0414c.f3087Q) {
            super.setChecked(z6);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.A(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z6) {
        setCheckedIconVisible(z6);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.A(AppCompatResources.getDrawable(c0414c.f3098e0, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.B(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.B(AppCompatResources.getColorStateList(c0414c.f3098e0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.C(c0414c.f3098e0.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.y == colorStateList) {
            return;
        }
        c0414c.y = colorStateList;
        c0414c.onStateChange(c0414c.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateList;
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.y == (colorStateList = AppCompatResources.getColorStateList(c0414c.f3098e0, i))) {
            return;
        }
        c0414c.y = colorStateList;
        c0414c.onStateChange(c0414c.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.D(f6);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.D(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(C0414c c0414c) {
        C0414c c0414c2 = this.f2329a;
        if (c0414c2 != c0414c) {
            if (c0414c2 != null) {
                c0414c2.f3072A0 = new WeakReference(null);
            }
            this.f2329a = c0414c;
            c0414c.f3075C0 = false;
            c0414c.f3072A0 = new WeakReference(this);
            c(this.f2336m);
        }
    }

    public void setChipEndPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.f3097d0 == f6) {
            return;
        }
        c0414c.f3097d0 = f6;
        c0414c.invalidateSelf();
        c0414c.x();
    }

    public void setChipEndPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            float dimension = c0414c.f3098e0.getResources().getDimension(i);
            if (c0414c.f3097d0 != dimension) {
                c0414c.f3097d0 = dimension;
                c0414c.invalidateSelf();
                c0414c.x();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.E(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z6) {
        setChipIconVisible(z6);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.E(AppCompatResources.getDrawable(c0414c.f3098e0, i));
        }
    }

    public void setChipIconSize(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.F(f6);
        }
    }

    public void setChipIconSizeResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.F(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.G(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.G(AppCompatResources.getColorStateList(c0414c.f3098e0, i));
        }
    }

    public void setChipIconVisible(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.H(c0414c.f3098e0.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.f3116z == f6) {
            return;
        }
        c0414c.f3116z = f6;
        c0414c.invalidateSelf();
        c0414c.x();
    }

    public void setChipMinHeightResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            float dimension = c0414c.f3098e0.getResources().getDimension(i);
            if (c0414c.f3116z != dimension) {
                c0414c.f3116z = dimension;
                c0414c.invalidateSelf();
                c0414c.x();
            }
        }
    }

    public void setChipStartPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.f3090W == f6) {
            return;
        }
        c0414c.f3090W = f6;
        c0414c.invalidateSelf();
        c0414c.x();
    }

    public void setChipStartPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            float dimension = c0414c.f3098e0.getResources().getDimension(i);
            if (c0414c.f3090W != dimension) {
                c0414c.f3090W = dimension;
                c0414c.invalidateSelf();
                c0414c.x();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.I(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.I(AppCompatResources.getColorStateList(c0414c.f3098e0, i));
        }
    }

    public void setChipStrokeWidth(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.J(f6);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.J(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.K(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.f3086P == charSequence) {
            return;
        }
        c0414c.f3086P = BidiFormatter.getInstance().unicodeWrap(charSequence);
        c0414c.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z6) {
        setCloseIconVisible(z6);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.L(f6);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.L(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.K(AppCompatResources.getDrawable(c0414c.f3098e0, i));
        }
        e();
    }

    public void setCloseIconSize(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.M(f6);
        }
    }

    public void setCloseIconSizeResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.M(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.N(f6);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.N(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.O(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.O(AppCompatResources.getColorStateList(c0414c.f3098e0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i3, int i4, int i5) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i3, int i4, int i5) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i3, i4, i5);
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.j(f6);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2329a == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.f3074B0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z6) {
        this.f2334k = z6;
        c(this.f2336m);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(W.f fVar) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.f3089V = fVar;
        }
    }

    public void setHideMotionSpecResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.f3089V = W.f.a(c0414c.f3098e0, i);
        }
    }

    public void setIconEndPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.Q(f6);
        }
    }

    public void setIconEndPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.Q(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.R(f6);
        }
    }

    public void setIconStartPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.R(c0414c.f3098e0.getResources().getDimension(i));
        }
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    public void setInternalOnCheckedChangeListener(MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.f2330f = onCheckedChangeListener;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f2329a == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.f3077D0 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
        e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.S(colorStateList);
        }
        this.f2329a.getClass();
        f();
    }

    public void setRippleColorResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.S(AppCompatResources.getColorStateList(c0414c.f3098e0, i));
            this.f2329a.getClass();
            f();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(j jVar) {
        this.f2329a.setShapeAppearanceModel(jVar);
    }

    public void setShowMotionSpec(W.f fVar) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.U = fVar;
        }
    }

    public void setShowMotionSpecResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.U = W.f.a(c0414c.f3098e0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z6) {
        if (!z6) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z6);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(c0414c.f3075C0 ? null : charSequence, bufferType);
        C0414c c0414c2 = this.f2329a;
        if (c0414c2 == null || TextUtils.equals(c0414c2.E, charSequence)) {
            return;
        }
        c0414c2.E = charSequence;
        c0414c2.f3102k0.d = true;
        c0414c2.invalidateSelf();
        c0414c2.x();
    }

    public void setTextAppearance(f fVar) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.f3102k0.b(fVar, c0414c.f3098e0);
        }
        h();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.f3094a0 == f6) {
            return;
        }
        c0414c.f3094a0 = f6;
        c0414c.invalidateSelf();
        c0414c.x();
    }

    public void setTextEndPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            float dimension = c0414c.f3098e0.getResources().getDimension(i);
            if (c0414c.f3094a0 != dimension) {
                c0414c.f3094a0 = dimension;
                c0414c.invalidateSelf();
                c0414c.x();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f6) {
        super.setTextSize(i, f6);
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f6, getResources().getDisplayMetrics());
            l lVar = c0414c.f3102k0;
            f fVar = lVar.f2504f;
            if (fVar != null) {
                fVar.f3686k = fApplyDimension;
                lVar.f2503a.setTextSize(fApplyDimension);
                c0414c.onTextSizeChange();
            }
        }
        h();
    }

    public void setTextStartPadding(float f6) {
        C0414c c0414c = this.f2329a;
        if (c0414c == null || c0414c.f3093Z == f6) {
            return;
        }
        c0414c.f3093Z = f6;
        c0414c.invalidateSelf();
        c0414c.x();
    }

    public void setTextStartPaddingResource(int i) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            float dimension = c0414c.f3098e0.getResources().getDimension(i);
            if (c0414c.f3093Z != dimension) {
                c0414c.f3093Z = dimension;
                c0414c.invalidateSelf();
                c0414c.x();
            }
        }
    }

    public void setCloseIconVisible(boolean z6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.P(z6);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.C(z6);
        }
    }

    public void setChipIconVisible(boolean z6) {
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            c0414c.H(z6);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            Context context2 = c0414c.f3098e0;
            c0414c.f3102k0.b(new f(context2, i), context2);
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        C0414c c0414c = this.f2329a;
        if (c0414c != null) {
            Context context = c0414c.f3098e0;
            c0414c.f3102k0.b(new f(context, i), context);
        }
        h();
    }
}
