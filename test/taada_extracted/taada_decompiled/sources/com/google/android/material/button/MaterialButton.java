package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.o;
import com.google.android.material.internal.s;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k0.AbstractC0573c;
import l0.AbstractC0615a;
import n0.C0695a;
import n0.i;
import n0.j;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f2255o = {R.attr.state_checkable};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f2256p = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2257a;
    public final LinkedHashSet b;
    public OnPressedChangeListener c;
    public PorterDuff.Mode d;
    public ColorStateList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2260h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2265n;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z6);
    }

    public interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z6);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2266a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f2266a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2266a ? 1 : 0);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(AbstractC0792a.a(context, attributeSet, fr.sd.taada.R.attr.materialButtonStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Button), attributeSet, fr.sd.taada.R.attr.materialButtonStyle);
        this.b = new LinkedHashSet();
        this.f2263l = false;
        this.f2264m = false;
        Context context2 = getContext();
        TypedArray typedArrayD = o.d(context2, attributeSet, V.a.f1359m, fr.sd.taada.R.attr.materialButtonStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f2262k = typedArrayD.getDimensionPixelSize(12, 0);
        int i = typedArrayD.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.d = s.c(i, mode);
        this.e = AbstractC0573c.a(getContext(), typedArrayD, 14);
        this.f2258f = AbstractC0573c.c(getContext(), typedArrayD, 10);
        this.f2265n = typedArrayD.getInteger(11, 1);
        this.f2260h = typedArrayD.getDimensionPixelSize(13, 0);
        b bVar = new b(this, j.b(context2, attributeSet, fr.sd.taada.R.attr.materialButtonStyle, fr.sd.taada.R.style.Widget_MaterialComponents_Button).a());
        this.f2257a = bVar;
        bVar.c = typedArrayD.getDimensionPixelOffset(1, 0);
        bVar.d = typedArrayD.getDimensionPixelOffset(2, 0);
        bVar.e = typedArrayD.getDimensionPixelOffset(3, 0);
        bVar.f2274f = typedArrayD.getDimensionPixelOffset(4, 0);
        if (typedArrayD.hasValue(8)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(8, -1);
            bVar.f2275g = dimensionPixelSize;
            float f6 = dimensionPixelSize;
            i iVarE = bVar.b.e();
            iVarE.e = new C0695a(f6);
            iVarE.f4194f = new C0695a(f6);
            iVarE.f4195g = new C0695a(f6);
            iVarE.f4196h = new C0695a(f6);
            bVar.c(iVarE.a());
            bVar.f2283p = true;
        }
        bVar.f2276h = typedArrayD.getDimensionPixelSize(20, 0);
        bVar.i = s.c(typedArrayD.getInt(7, -1), mode);
        bVar.f2277j = AbstractC0573c.a(getContext(), typedArrayD, 6);
        bVar.f2278k = AbstractC0573c.a(getContext(), typedArrayD, 19);
        bVar.f2279l = AbstractC0573c.a(getContext(), typedArrayD, 16);
        bVar.q = typedArrayD.getBoolean(5, false);
        bVar.f2286t = typedArrayD.getDimensionPixelSize(9, 0);
        bVar.f2284r = typedArrayD.getBoolean(21, true);
        int paddingStart = ViewCompat.getPaddingStart(this);
        int paddingTop = getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this);
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(0)) {
            bVar.f2282o = true;
            setSupportBackgroundTintList(bVar.f2277j);
            setSupportBackgroundTintMode(bVar.i);
        } else {
            bVar.e();
        }
        ViewCompat.setPaddingRelative(this, paddingStart + bVar.c, paddingTop + bVar.e, paddingEnd + bVar.d, paddingBottom + bVar.f2274f);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.f2262k);
        c(this.f2258f != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    public final boolean a() {
        b bVar = this.f2257a;
        return (bVar == null || bVar.f2282o) ? false : true;
    }

    public final void b() {
        int i = this.f2265n;
        boolean z6 = true;
        if (i != 1 && i != 2) {
            z6 = false;
        }
        if (z6) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f2258f, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f2258f, null);
        } else if (i == 16 || i == 32) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f2258f, null, null);
        }
    }

    public final void c(boolean z6) {
        Drawable drawable = this.f2258f;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f2258f = drawableMutate;
            DrawableCompat.setTintList(drawableMutate, this.e);
            PorterDuff.Mode mode = this.d;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f2258f, mode);
            }
            int intrinsicWidth = this.f2260h;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f2258f.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f2260h;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f2258f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2258f;
            int i = this.i;
            int i3 = this.f2261j;
            drawable2.setBounds(i, i3, intrinsicWidth + i, intrinsicHeight + i3);
            this.f2258f.setVisible(true, z6);
        }
        if (z6) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i4 = this.f2265n;
        if (((i4 == 1 || i4 == 2) && drawable3 != this.f2258f) || (((i4 == 3 || i4 == 4) && drawable5 != this.f2258f) || ((i4 == 16 || i4 == 32) && drawable4 != this.f2258f))) {
            b();
        }
    }

    public final void d(int i, int i3) {
        if (this.f2258f == null || getLayout() == null) {
            return;
        }
        int i4 = this.f2265n;
        if (!(i4 == 1 || i4 == 2) && i4 != 3 && i4 != 4) {
            if (i4 == 16 || i4 == 32) {
                this.i = 0;
                if (i4 == 16) {
                    this.f2261j = 0;
                    c(false);
                    return;
                }
                int intrinsicHeight = this.f2260h;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f2258f.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i3 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f2262k) - getPaddingBottom()) / 2);
                if (this.f2261j != iMax) {
                    this.f2261j = iMax;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f2261j = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i5 = this.f2265n;
        if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.i = 0;
            c(false);
            return;
        }
        int intrinsicWidth = this.f2260h;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f2258f.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - intrinsicWidth) - this.f2262k) - ViewCompat.getPaddingStart(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((ViewCompat.getLayoutDirection(this) == 1) != (this.f2265n == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.i != textLayoutWidth) {
            this.i = textLayoutWidth;
            c(false);
        }
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f2259g)) {
            return this.f2259g;
        }
        b bVar = this.f2257a;
        return ((bVar == null || !bVar.q) ? Button.class : CompoundButton.class).getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f2257a.f2275g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f2258f;
    }

    public int getIconGravity() {
        return this.f2265n;
    }

    public int getIconPadding() {
        return this.f2262k;
    }

    public int getIconSize() {
        return this.f2260h;
    }

    public ColorStateList getIconTint() {
        return this.e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.d;
    }

    public int getInsetBottom() {
        return this.f2257a.f2274f;
    }

    public int getInsetTop() {
        return this.f2257a.e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f2257a.f2279l;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    public j getShapeAppearanceModel() {
        if (a()) {
            return this.f2257a.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f2257a.f2278k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f2257a.f2276h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f2257a.f2277j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f2257a.i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2263l;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            k1.j.q(this, this.f2257a.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        b bVar = this.f2257a;
        if (bVar != null && bVar.q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2255o);
        }
        if (this.f2263l) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2256p);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f2263l);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        b bVar = this.f2257a;
        accessibilityNodeInfo.setCheckable(bVar != null && bVar.q);
        accessibilityNodeInfo.setChecked(this.f2263l);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        super.onLayout(z6, i, i3, i4, i5);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f2266a);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2266a = this.f2263l;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        super.onTextChanged(charSequence, i, i3, i4);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f2257a.f2284r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f2258f != null) {
            if (this.f2258f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f2259g = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!a()) {
            super.setBackgroundColor(i);
            return;
        }
        b bVar = this.f2257a;
        if (bVar.b(false) != null) {
            bVar.b(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        b bVar = this.f2257a;
        bVar.f2282o = true;
        ColorStateList colorStateList = bVar.f2277j;
        MaterialButton materialButton = bVar.f2273a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(bVar.i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z6) {
        if (a()) {
            this.f2257a.q = z6;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z6) {
        b bVar = this.f2257a;
        if (bVar == null || !bVar.q || !isEnabled() || this.f2263l == z6) {
            return;
        }
        this.f2263l = z6;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z7 = this.f2263l;
            if (!materialButtonToggleGroup.f2269f) {
                materialButtonToggleGroup.b(getId(), z7);
            }
        }
        if (this.f2264m) {
            return;
        }
        this.f2264m = true;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((OnCheckedChangeListener) it.next()).onCheckedChanged(this, this.f2263l);
        }
        this.f2264m = false;
    }

    public void setCornerRadius(int i) {
        if (a()) {
            b bVar = this.f2257a;
            if (bVar.f2283p && bVar.f2275g == i) {
                return;
            }
            bVar.f2275g = i;
            bVar.f2283p = true;
            float f6 = i;
            i iVarE = bVar.b.e();
            iVarE.e = new C0695a(f6);
            iVarE.f4194f = new C0695a(f6);
            iVarE.f4195g = new C0695a(f6);
            iVarE.f4196h = new C0695a(f6);
            bVar.c(iVarE.a());
        }
    }

    public void setCornerRadiusResource(int i) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        if (a()) {
            this.f2257a.b(false).j(f6);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f2258f != drawable) {
            this.f2258f = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.f2265n != i) {
            this.f2265n = i;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.f2262k != i) {
            this.f2262k = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2260h != i) {
            this.f2260h = i;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInsetBottom(int i) {
        b bVar = this.f2257a;
        bVar.d(bVar.e, i);
    }

    public void setInsetTop(int i) {
        b bVar = this.f2257a;
        bVar.d(i, bVar.f2274f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.c = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z6) {
        OnPressedChangeListener onPressedChangeListener = this.c;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged(this, z6);
        }
        super.setPressed(z6);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            b bVar = this.f2257a;
            if (bVar.f2279l != colorStateList) {
                bVar.f2279l = colorStateList;
                MaterialButton materialButton = bVar.f2273a;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(AbstractC0615a.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (a()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(j jVar) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f2257a.c(jVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z6) {
        if (a()) {
            b bVar = this.f2257a;
            bVar.f2281n = z6;
            bVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            b bVar = this.f2257a;
            if (bVar.f2278k != colorStateList) {
                bVar.f2278k = colorStateList;
                bVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (a()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (a()) {
            b bVar = this.f2257a;
            if (bVar.f2276h != i) {
                bVar.f2276h = i;
                bVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        b bVar = this.f2257a;
        if (bVar.f2277j != colorStateList) {
            bVar.f2277j = colorStateList;
            if (bVar.b(false) != null) {
                DrawableCompat.setTintList(bVar.b(false), bVar.f2277j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        b bVar = this.f2257a;
        if (bVar.i != mode) {
            bVar.i = mode;
            if (bVar.b(false) == null || bVar.i == null) {
                return;
            }
            DrawableCompat.setTintMode(bVar.b(false), bVar.i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z6) {
        this.f2257a.f2284r = z6;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f2263l);
    }
}
