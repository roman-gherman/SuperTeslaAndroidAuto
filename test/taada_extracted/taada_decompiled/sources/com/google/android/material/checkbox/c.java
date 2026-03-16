package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.color.g;
import com.google.android.material.internal.o;
import com.google.android.material.internal.s;
import fr.sd.taada.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k0.AbstractC0572b;
import k0.AbstractC0573c;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AppCompatCheckBox {
    public static final int[] u = {R.attr.state_indeterminate};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f2311v = {R.attr.state_error};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[][] f2312w = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int x = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2313a;
    public final LinkedHashSet b;
    public ColorStateList c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f2315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f2316h;
    public Drawable i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f2319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f2320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f2322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2323p;
    public CharSequence q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f2324r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AnimatedVectorDrawableCompat f2325s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f2326t;

    public c(Context context, AttributeSet attributeSet, int i) {
        super(AbstractC0792a.a(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.f2313a = new LinkedHashSet();
        this.b = new LinkedHashSet();
        this.f2325s = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.f2326t = new a(this);
        Context context2 = getContext();
        this.f2316h = CompoundButtonCompat.getButtonDrawable(this);
        this.f2318k = getSuperButtonTintList();
        setSupportButtonTintList(null);
        int[] iArr = V.a.f1363r;
        o.a(context2, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        o.b(context2, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        this.i = tintTypedArrayObtainStyledAttributes.getDrawable(2);
        if (this.f2316h != null && AbstractC0572b.b(context2, R.attr.isMaterial3Theme, false)) {
            int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId == x && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f2316h = AppCompatResources.getDrawable(context2, R.drawable.mtrl_checkbox_button);
                this.f2317j = true;
                if (this.i == null) {
                    this.i = AppCompatResources.getDrawable(context2, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.f2319l = AbstractC0573c.b(context2, tintTypedArrayObtainStyledAttributes, 3);
        this.f2320m = s.c(tintTypedArrayObtainStyledAttributes.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.d = tintTypedArrayObtainStyledAttributes.getBoolean(10, false);
        this.e = tintTypedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f2314f = tintTypedArrayObtainStyledAttributes.getBoolean(9, false);
        this.f2315g = tintTypedArrayObtainStyledAttributes.getText(8);
        if (tintTypedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(tintTypedArrayObtainStyledAttributes.getInt(7, 0));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        a();
    }

    private String getButtonStateDescription() {
        int i = this.f2321n;
        return i == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.c == null) {
            int iF = g.f(this, R.attr.colorControlActivated);
            int iF2 = g.f(this, R.attr.colorError);
            int iF3 = g.f(this, R.attr.colorSurface);
            int iF4 = g.f(this, R.attr.colorOnSurface);
            this.c = new ColorStateList(f2312w, new int[]{g.g(iF3, iF2, 1.0f), g.g(iF3, iF, 1.0f), g.g(iF3, iF4, 0.54f), g.g(iF3, iF4, 0.38f), g.g(iF3, iF4, 0.38f)});
        }
        return this.c;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f2318k;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        int intrinsicHeight;
        int intrinsicWidth;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawableMutate = this.f2316h;
        ColorStateList colorStateList3 = this.f2318k;
        PorterDuff.Mode buttonTintMode = CompoundButtonCompat.getButtonTintMode(this);
        Drawable drawableMutate2 = null;
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = DrawableCompat.wrap(drawableMutate).mutate();
            if (buttonTintMode != null) {
                DrawableCompat.setTintMode(drawableMutate, buttonTintMode);
            }
        }
        this.f2316h = drawableMutate;
        Drawable drawable = this.i;
        ColorStateList colorStateList4 = this.f2319l;
        PorterDuff.Mode mode = this.f2320m;
        if (drawable != null) {
            if (colorStateList4 != null) {
                drawableMutate2 = DrawableCompat.wrap(drawable).mutate();
                if (mode != null) {
                    DrawableCompat.setTintMode(drawableMutate2, mode);
                }
            } else {
                drawableMutate2 = drawable;
            }
        }
        this.i = drawableMutate2;
        if (this.f2317j) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.f2325s;
            if (animatedVectorDrawableCompat != null) {
                a aVar = this.f2326t;
                animatedVectorDrawableCompat.unregisterAnimationCallback(aVar);
                animatedVectorDrawableCompat.registerAnimationCallback(aVar);
            }
            Drawable drawable2 = this.f2316h;
            if ((drawable2 instanceof AnimatedStateListDrawable) && animatedVectorDrawableCompat != null) {
                ((AnimatedStateListDrawable) drawable2).addTransition(R.id.checked, R.id.unchecked, animatedVectorDrawableCompat, false);
                ((AnimatedStateListDrawable) this.f2316h).addTransition(R.id.indeterminate, R.id.unchecked, animatedVectorDrawableCompat, false);
            }
        }
        Drawable drawable3 = this.f2316h;
        if (drawable3 != null && (colorStateList2 = this.f2318k) != null) {
            DrawableCompat.setTintList(drawable3, colorStateList2);
        }
        Drawable drawable4 = this.i;
        if (drawable4 != null && (colorStateList = this.f2319l) != null) {
            DrawableCompat.setTintList(drawable4, colorStateList);
        }
        Drawable drawable5 = this.f2316h;
        Drawable drawable6 = this.i;
        if (drawable5 == null) {
            drawable5 = drawable6;
        } else if (drawable6 != null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable5, drawable6});
            if (drawable6.getIntrinsicWidth() == -1 || drawable6.getIntrinsicHeight() == -1) {
                int intrinsicWidth2 = drawable5.getIntrinsicWidth();
                intrinsicHeight = drawable5.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth2;
            } else if (drawable6.getIntrinsicWidth() > drawable5.getIntrinsicWidth() || drawable6.getIntrinsicHeight() > drawable5.getIntrinsicHeight()) {
                float intrinsicWidth3 = drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight();
                if (intrinsicWidth3 >= drawable5.getIntrinsicWidth() / drawable5.getIntrinsicHeight()) {
                    intrinsicWidth = drawable5.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth / intrinsicWidth3);
                } else {
                    intrinsicHeight = drawable5.getIntrinsicHeight();
                    intrinsicWidth = (int) (intrinsicWidth3 * intrinsicHeight);
                }
            } else {
                intrinsicWidth = drawable6.getIntrinsicWidth();
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable5 = layerDrawable;
        }
        super.setButtonDrawable(drawable5);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f2316h;
    }

    public Drawable getButtonIconDrawable() {
        return this.i;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f2319l;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f2320m;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f2318k;
    }

    public int getCheckedState() {
        return this.f2321n;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f2315g;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f2321n == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d && this.f2318k == null && this.f2319l == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, u);
        }
        if (this.f2314f) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2311v);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i4 = iArrOnCreateDrawableState[i3];
            if (i4 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i4 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i3] = 16842912;
                break;
            }
            i3++;
        }
        this.f2322o = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.e || !TextUtils.isEmpty(getText()) || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (s.b(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            DrawableCompat.setHotspotBounds(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f2314f) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f2315g));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof MaterialCheckBox$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        MaterialCheckBox$SavedState materialCheckBox$SavedState = (MaterialCheckBox$SavedState) parcelable;
        super.onRestoreInstanceState(materialCheckBox$SavedState.getSuperState());
        setCheckedState(materialCheckBox$SavedState.f2309a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        MaterialCheckBox$SavedState materialCheckBox$SavedState = new MaterialCheckBox$SavedState(super.onSaveInstanceState());
        materialCheckBox$SavedState.f2309a = getCheckedState();
        return materialCheckBox$SavedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.i = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f2319l == colorStateList) {
            return;
        }
        this.f2319l = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f2320m == mode) {
            return;
        }
        this.f2320m = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f2318k == colorStateList) {
            return;
        }
        this.f2318k = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z6) {
        this.e = z6;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z6) {
        setCheckedState(z6 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f2321n != i) {
            this.f2321n = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.q == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f2323p) {
                return;
            }
            this.f2323p = true;
            LinkedHashSet linkedHashSet = this.b;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((MaterialCheckBox$OnCheckedStateChangedListener) it.next()).onCheckedStateChangedListener(this, this.f2321n);
                }
            }
            if (this.f2321n != 2 && (onCheckedChangeListener = this.f2324r) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f2323p = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z6) {
        super.setEnabled(z6);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f2315g = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z6) {
        if (this.f2314f == z6) {
            return;
        }
        this.f2314f = z6;
        refreshDrawableState();
        Iterator it = this.f2313a.iterator();
        while (it.hasNext()) {
            ((MaterialCheckBox$OnErrorChangedListener) it.next()).onErrorChanged(this, this.f2314f);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2324r = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.q = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z6) {
        this.d = z6;
        if (z6) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f2316h = drawable;
        this.f2317j = false;
        a();
    }
}
