package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import b0.C0228b;
import c4.AbstractC0246d;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.CornerSize;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k0.AbstractC0572b;
import k0.AbstractC0573c;
import k0.C0571a;
import n0.C0695a;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int[][] f2594y0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f2595A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public CharSequence f2596B;
    public boolean C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public n0.f f2597D;
    public n0.f E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public StateListDrawable f2598F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f2599G;
    public n0.f H;
    public n0.f I;
    public n0.j J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f2600K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final int f2601L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f2602M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f2603N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f2604O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f2605P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f2606Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final Rect f2607T;
    public final Rect U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final RectF f2608V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public Typeface f2609W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f2610a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ColorDrawable f2611a0;
    public final v b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f2612b0;
    public final m c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final LinkedHashSet f2613c0;
    public EditText d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ColorDrawable f2614d0;
    public CharSequence e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f2615e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2616f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Drawable f2617f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2618g;
    public ColorStateList g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2619h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public ColorStateList f2620h0;
    public int i;
    public int i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q f2621j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f2622j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2623k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f2624k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2625l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public ColorStateList f2626l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2627m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f2628m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LengthCounter f2629n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f2630n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppCompatTextView f2631o;
    public int o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2632p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f2633p0;
    public int q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f2634q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f2635r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f2636r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2637s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final com.google.android.material.internal.b f2638s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AppCompatTextView f2639t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f2640t0;
    public ColorStateList u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f2641u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2642v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ValueAnimator f2643v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Fade f2644w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f2645w0;
    public Fade x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f2646x0;
    public ColorStateList y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f2647z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface LengthCounter {
        int countLength(Editable editable);
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int i);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new z();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f2648a;
        public boolean b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2648a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f2648a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f2648a, parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(AbstractC0792a.a(context, attributeSet, fr.sd.taada.R.attr.textInputStyle, fr.sd.taada.R.style.Widget_Design_TextInputLayout), attributeSet, fr.sd.taada.R.attr.textInputStyle);
        this.f2616f = -1;
        this.f2618g = -1;
        this.f2619h = -1;
        this.i = -1;
        this.f2621j = new q(this);
        this.f2629n = new D0.b(20);
        this.f2607T = new Rect();
        this.U = new Rect();
        this.f2608V = new RectF();
        this.f2613c0 = new LinkedHashSet();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f2638s0 = bVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2610a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = W.a.f1379a;
        bVar.f2462Q = linearInterpolator;
        bVar.h(false);
        bVar.f2461P = linearInterpolator;
        bVar.h(false);
        if (bVar.f2477g != 8388659) {
            bVar.f2477g = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
            bVar.h(false);
        }
        int[] iArr = V.a.f1351G;
        com.google.android.material.internal.o.a(context2, attributeSet, fr.sd.taada.R.attr.textInputStyle, fr.sd.taada.R.style.Widget_Design_TextInputLayout);
        com.google.android.material.internal.o.b(context2, attributeSet, iArr, fr.sd.taada.R.attr.textInputStyle, fr.sd.taada.R.style.Widget_Design_TextInputLayout, 22, 20, 38, 43, 47);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, fr.sd.taada.R.attr.textInputStyle, fr.sd.taada.R.style.Widget_Design_TextInputLayout);
        v vVar = new v(this, tintTypedArrayObtainStyledAttributes);
        this.b = vVar;
        this.f2595A = tintTypedArrayObtainStyledAttributes.getBoolean(46, true);
        setHint(tintTypedArrayObtainStyledAttributes.getText(4));
        this.f2641u0 = tintTypedArrayObtainStyledAttributes.getBoolean(45, true);
        this.f2640t0 = tintTypedArrayObtainStyledAttributes.getBoolean(40, true);
        if (tintTypedArrayObtainStyledAttributes.hasValue(6)) {
            setMinEms(tintTypedArrayObtainStyledAttributes.getInt(6, -1));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(3)) {
            setMinWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(tintTypedArrayObtainStyledAttributes.getInt(5, -1));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.J = n0.j.b(context2, attributeSet, fr.sd.taada.R.attr.textInputStyle, fr.sd.taada.R.style.Widget_Design_TextInputLayout).a();
        this.f2601L = context2.getResources().getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f2603N = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f2605P = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f2606Q = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f2604O = this.f2605P;
        float dimension = tintTypedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = tintTypedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = tintTypedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = tintTypedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        n0.i iVarE = this.J.e();
        if (dimension >= 0.0f) {
            iVarE.e = new C0695a(dimension);
        }
        if (dimension2 >= 0.0f) {
            iVarE.f4194f = new C0695a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            iVarE.f4195g = new C0695a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            iVarE.f4196h = new C0695a(dimension4);
        }
        this.J = iVarE.a();
        ColorStateList colorStateListB = AbstractC0573c.b(context2, tintTypedArrayObtainStyledAttributes, 7);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f2628m0 = defaultColor;
            this.S = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f2630n0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.o0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f2633p0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.o0 = this.f2628m0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, fr.sd.taada.R.color.mtrl_filled_background_color);
                this.f2630n0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.f2633p0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.S = 0;
            this.f2628m0 = 0;
            this.f2630n0 = 0;
            this.o0 = 0;
            this.f2633p0 = 0;
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList2 = tintTypedArrayObtainStyledAttributes.getColorStateList(1);
            this.f2620h0 = colorStateList2;
            this.g0 = colorStateList2;
        }
        ColorStateList colorStateListB2 = AbstractC0573c.b(context2, tintTypedArrayObtainStyledAttributes, 14);
        this.f2624k0 = tintTypedArrayObtainStyledAttributes.getColor(14, 0);
        this.i0 = ContextCompat.getColor(context2, fr.sd.taada.R.color.mtrl_textinput_default_box_stroke_color);
        this.f2634q0 = ContextCompat.getColor(context2, fr.sd.taada.R.color.mtrl_textinput_disabled_color);
        this.f2622j0 = ContextCompat.getColor(context2, fr.sd.taada.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(AbstractC0573c.b(context2, tintTypedArrayObtainStyledAttributes, 15));
        }
        if (tintTypedArrayObtainStyledAttributes.getResourceId(47, -1) != -1) {
            setHintTextAppearance(tintTypedArrayObtainStyledAttributes.getResourceId(47, 0));
        }
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(38, 0);
        CharSequence text = tintTypedArrayObtainStyledAttributes.getText(33);
        int i = tintTypedArrayObtainStyledAttributes.getInt(32, 1);
        boolean z6 = tintTypedArrayObtainStyledAttributes.getBoolean(34, false);
        int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(43, 0);
        boolean z7 = tintTypedArrayObtainStyledAttributes.getBoolean(42, false);
        CharSequence text2 = tintTypedArrayObtainStyledAttributes.getText(41);
        int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(55, 0);
        CharSequence text3 = tintTypedArrayObtainStyledAttributes.getText(54);
        boolean z8 = tintTypedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(tintTypedArrayObtainStyledAttributes.getInt(19, -1));
        this.q = tintTypedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.f2632p = tintTypedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(tintTypedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.f2632p);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.q);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (tintTypedArrayObtainStyledAttributes.hasValue(39)) {
            setErrorTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(39));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(44)) {
            setHelperTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(44));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(48)) {
            setHintTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(48));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(23));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(21));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(56)) {
            setPlaceholderTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(56));
        }
        m mVar = new m(this, tintTypedArrayObtainStyledAttributes);
        this.c = mVar;
        boolean z9 = tintTypedArrayObtainStyledAttributes.getBoolean(0, true);
        tintTypedArrayObtainStyledAttributes.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAutofill(this, 1);
        frameLayout.addView(vVar);
        frameLayout.addView(mVar);
        addView(frameLayout);
        setEnabled(z9);
        setHelperTextEnabled(z7);
        setErrorEnabled(z6);
        setCounterEnabled(z8);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.d;
        if (!(editText instanceof AutoCompleteTextView) || C5.f.K(editText)) {
            return this.f2597D;
        }
        int iF = com.google.android.material.color.g.f(this.d, fr.sd.taada.R.attr.colorControlHighlight);
        int i = this.f2602M;
        int[][] iArr = f2594y0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            n0.f fVar = this.f2597D;
            int i3 = this.S;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{com.google.android.material.color.g.g(iF, i3, 0.1f), i3}), fVar, fVar);
        }
        Context context = getContext();
        n0.f fVar2 = this.f2597D;
        TypedValue typedValueC = AbstractC0572b.c(context, fr.sd.taada.R.attr.colorSurface, "TextInputLayout");
        int i4 = typedValueC.resourceId;
        int color = i4 != 0 ? ContextCompat.getColor(context, i4) : typedValueC.data;
        n0.f fVar3 = new n0.f(fVar2.f4177a.f4165a);
        int iG = com.google.android.material.color.g.g(iF, color, 0.1f);
        fVar3.k(new ColorStateList(iArr, new int[]{iG, 0}));
        fVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iG, color});
        n0.f fVar4 = new n0.f(fVar2.f4177a.f4165a);
        fVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, fVar3, fVar4), fVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f2598F == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f2598F = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f2598F.addState(new int[0], f(false));
        }
        return this.f2598F;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.E == null) {
            this.E = f(true);
        }
        return this.E;
    }

    public static void k(ViewGroup viewGroup, boolean z6) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z6);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z6);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3) {
            boolean z6 = editText instanceof TextInputEditText;
        }
        this.d = editText;
        int i = this.f2616f;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.f2619h);
        }
        int i3 = this.f2618g;
        if (i3 != -1) {
            setMaxEms(i3);
        } else {
            setMaxWidth(this.i);
        }
        this.f2599G = false;
        i();
        setTextInputAccessibilityDelegate(new y(this));
        Typeface typeface = this.d.getTypeface();
        com.google.android.material.internal.b bVar = this.f2638s0;
        bVar.m(typeface);
        float textSize = this.d.getTextSize();
        if (bVar.f2478h != textSize) {
            bVar.f2478h = textSize;
            bVar.h(false);
        }
        float letterSpacing = this.d.getLetterSpacing();
        if (bVar.f2465W != letterSpacing) {
            bVar.f2465W = letterSpacing;
            bVar.h(false);
        }
        int gravity = this.d.getGravity();
        int i4 = (gravity & (-113)) | 48;
        if (bVar.f2477g != i4) {
            bVar.f2477g = i4;
            bVar.h(false);
        }
        if (bVar.f2475f != gravity) {
            bVar.f2475f = gravity;
            bVar.h(false);
        }
        this.d.addTextChangedListener(new w(this));
        if (this.g0 == null) {
            this.g0 = this.d.getHintTextColors();
        }
        if (this.f2595A) {
            if (TextUtils.isEmpty(this.f2596B)) {
                CharSequence hint = this.d.getHint();
                this.e = hint;
                setHint(hint);
                this.d.setHint((CharSequence) null);
            }
            this.C = true;
        }
        if (this.f2631o != null) {
            n(this.d.getText());
        }
        q();
        this.f2621j.b();
        this.b.bringToFront();
        m mVar = this.c;
        mVar.bringToFront();
        Iterator it = this.f2613c0.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).onEditTextAttached(this);
        }
        mVar.l();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        t(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f2596B)) {
            return;
        }
        this.f2596B = charSequence;
        com.google.android.material.internal.b bVar = this.f2638s0;
        if (charSequence == null || !TextUtils.equals(bVar.f2451A, charSequence)) {
            bVar.f2451A = charSequence;
            bVar.f2452B = null;
            Bitmap bitmap = bVar.E;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.E = null;
            }
            bVar.h(false);
        }
        if (this.f2636r0) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z6) {
        if (this.f2637s == z6) {
            return;
        }
        if (z6) {
            AppCompatTextView appCompatTextView = this.f2639t;
            if (appCompatTextView != null) {
                this.f2610a.addView(appCompatTextView);
                this.f2639t.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f2639t;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.f2639t = null;
        }
        this.f2637s = z6;
    }

    public final void a(float f6) {
        int i = 2;
        com.google.android.material.internal.b bVar = this.f2638s0;
        if (bVar.b == f6) {
            return;
        }
        if (this.f2643v0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f2643v0 = valueAnimator;
            valueAnimator.setInterpolator(AbstractC0246d.y0(getContext(), fr.sd.taada.R.attr.motionEasingEmphasizedInterpolator, W.a.b));
            this.f2643v0.setDuration(AbstractC0246d.x0(getContext(), fr.sd.taada.R.attr.motionDurationMedium4, 167));
            this.f2643v0.addUpdateListener(new C0228b(this, i));
        }
        this.f2643v0.setFloatValues(bVar.b, f6);
        this.f2643v0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f2610a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        s();
        setEditText((EditText) view);
    }

    public final void b() {
        int i;
        int i3;
        n0.f fVar = this.f2597D;
        if (fVar == null) {
            return;
        }
        n0.j jVar = fVar.f4177a.f4165a;
        n0.j jVar2 = this.J;
        if (jVar != jVar2) {
            fVar.setShapeAppearanceModel(jVar2);
        }
        if (this.f2602M == 2 && (i = this.f2604O) > -1 && (i3 = this.R) != 0) {
            n0.f fVar2 = this.f2597D;
            fVar2.f4177a.f4169j = i;
            fVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i3);
            n0.e eVar = fVar2.f4177a;
            if (eVar.d != colorStateListValueOf) {
                eVar.d = colorStateListValueOf;
                fVar2.onStateChange(fVar2.getState());
            }
        }
        int iCompositeColors = this.S;
        if (this.f2602M == 1) {
            iCompositeColors = ColorUtils.compositeColors(this.S, com.google.android.material.color.g.e(getContext(), fr.sd.taada.R.attr.colorSurface, 0));
        }
        this.S = iCompositeColors;
        this.f2597D.k(ColorStateList.valueOf(iCompositeColors));
        n0.f fVar3 = this.H;
        if (fVar3 != null && this.I != null) {
            if (this.f2604O > -1 && this.R != 0) {
                fVar3.k(this.d.isFocused() ? ColorStateList.valueOf(this.i0) : ColorStateList.valueOf(this.R));
                this.I.k(ColorStateList.valueOf(this.R));
            }
            invalidate();
        }
        r();
    }

    public final int c() {
        float fD;
        if (!this.f2595A) {
            return 0;
        }
        int i = this.f2602M;
        com.google.android.material.internal.b bVar = this.f2638s0;
        if (i == 0) {
            fD = bVar.d();
        } else {
            if (i != 2) {
                return 0;
            }
            fD = bVar.d() / 2.0f;
        }
        return (int) fD;
    }

    public final Fade d() {
        Fade fade = new Fade();
        fade.setDuration(AbstractC0246d.x0(getContext(), fr.sd.taada.R.attr.motionDurationShort2, 87));
        fade.setInterpolator(AbstractC0246d.y0(getContext(), fr.sd.taada.R.attr.motionEasingLinearInterpolator, W.a.f1379a));
        return fade;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.e != null) {
            boolean z6 = this.C;
            this.C = false;
            CharSequence hint = editText.getHint();
            this.d.setHint(this.e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.d.setHint(hint);
                this.C = z6;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.f2610a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i3 = 0; i3 < frameLayout.getChildCount(); i3++) {
            View childAt = frameLayout.getChildAt(i3);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i3);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f2646x0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f2646x0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        n0.f fVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z6 = this.f2595A;
        com.google.android.material.internal.b bVar = this.f2638s0;
        if (z6) {
            bVar.getClass();
            int iSave = canvas2.save();
            if (bVar.f2452B != null) {
                RectF rectF = bVar.e;
                if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                    TextPaint textPaint = bVar.f2459N;
                    textPaint.setTextSize(bVar.f2455G);
                    float f6 = bVar.f2485p;
                    float f7 = bVar.q;
                    float f8 = bVar.f2454F;
                    if (f8 != 1.0f) {
                        canvas2.scale(f8, f8, f6, f7);
                    }
                    if (bVar.f2473d0 <= 1 || bVar.C) {
                        canvas2.translate(f6, f7);
                        bVar.f2467Y.draw(canvas2);
                    } else {
                        float lineStart = bVar.f2485p - bVar.f2467Y.getLineStart(0);
                        int alpha = textPaint.getAlpha();
                        canvas2.translate(lineStart, f7);
                        float f9 = alpha;
                        textPaint.setAlpha((int) (bVar.f2471b0 * f9));
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 31) {
                            float f10 = bVar.H;
                            float f11 = bVar.I;
                            float f12 = bVar.J;
                            int i3 = bVar.f2456K;
                            textPaint.setShadowLayer(f10, f11, f12, ColorUtils.setAlphaComponent(i3, (textPaint.getAlpha() * Color.alpha(i3)) / 255));
                        }
                        bVar.f2467Y.draw(canvas2);
                        textPaint.setAlpha((int) (bVar.f2470a0 * f9));
                        if (i >= 31) {
                            float f13 = bVar.H;
                            float f14 = bVar.I;
                            float f15 = bVar.J;
                            int i4 = bVar.f2456K;
                            textPaint.setShadowLayer(f13, f14, f15, ColorUtils.setAlphaComponent(i4, (Color.alpha(i4) * textPaint.getAlpha()) / 255));
                        }
                        int lineBaseline = bVar.f2467Y.getLineBaseline(0);
                        CharSequence charSequence = bVar.f2472c0;
                        float f16 = lineBaseline;
                        canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f16, textPaint);
                        if (i >= 31) {
                            textPaint.setShadowLayer(bVar.H, bVar.I, bVar.J, bVar.f2456K);
                        }
                        String strTrim = bVar.f2472c0.toString().trim();
                        if (strTrim.endsWith("…")) {
                            strTrim = strTrim.substring(0, strTrim.length() - 1);
                        }
                        String str = strTrim;
                        textPaint.setAlpha(alpha);
                        canvas2 = canvas;
                        canvas2.drawText(str, 0, Math.min(bVar.f2467Y.getLineEnd(0), str.length()), 0.0f, f16, (Paint) textPaint);
                    }
                    canvas2.restoreToCount(iSave);
                }
            }
        }
        if (this.I == null || (fVar = this.H) == null) {
            return;
        }
        fVar.draw(canvas2);
        if (this.d.isFocused()) {
            Rect bounds = this.I.getBounds();
            Rect bounds2 = this.H.getBounds();
            float f17 = bVar.b;
            int iCenterX = bounds2.centerX();
            bounds.left = W.a.c(iCenterX, bounds2.left, f17);
            bounds.right = W.a.c(iCenterX, bounds2.right, f17);
            this.I.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f2645w0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f2645w0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.b r3 = r4.f2638s0
            if (r3 == 0) goto L2f
            r3.f2457L = r1
            android.content.res.ColorStateList r1 = r3.f2480k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f2479j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.h(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.d
            if (r3 == 0) goto L45
            boolean r3 = androidx.core.view.ViewCompat.isLaidOut(r4)
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = r2
        L42:
            r4.t(r0, r2)
        L45:
            r4.q()
            r4.w()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.f2645w0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final boolean e() {
        return this.f2595A && !TextUtils.isEmpty(this.f2596B) && (this.f2597D instanceof f);
    }

    public final n0.f f(boolean z6) {
        int i = 0;
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_shape_corner_size_small_component);
        float f6 = z6 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.d;
        float popupElevation = editText instanceof t ? ((t) editText).getPopupElevation() : getResources().getDimensionPixelOffset(fr.sd.taada.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        n0.h hVar = new n0.h();
        n0.h hVar2 = new n0.h();
        n0.h hVar3 = new n0.h();
        n0.h hVar4 = new n0.h();
        n0.d dVar = new n0.d(i);
        n0.d dVar2 = new n0.d(i);
        n0.d dVar3 = new n0.d(i);
        n0.d dVar4 = new n0.d(i);
        C0695a c0695a = new C0695a(f6);
        C0695a c0695a2 = new C0695a(f6);
        C0695a c0695a3 = new C0695a(dimensionPixelOffset);
        C0695a c0695a4 = new C0695a(dimensionPixelOffset);
        n0.j jVar = new n0.j();
        jVar.f4200a = hVar;
        jVar.b = hVar2;
        jVar.c = hVar3;
        jVar.d = hVar4;
        jVar.e = c0695a;
        jVar.f4201f = c0695a2;
        jVar.f4202g = c0695a4;
        jVar.f4203h = c0695a3;
        jVar.i = dVar;
        jVar.f4204j = dVar2;
        jVar.f4205k = dVar3;
        jVar.f4206l = dVar4;
        Context context = getContext();
        Paint paint = n0.f.f4176w;
        TypedValue typedValueC = AbstractC0572b.c(context, fr.sd.taada.R.attr.colorSurface, n0.f.class.getSimpleName());
        int i3 = typedValueC.resourceId;
        int color = i3 != 0 ? ContextCompat.getColor(context, i3) : typedValueC.data;
        n0.f fVar = new n0.f();
        fVar.i(context);
        fVar.k(ColorStateList.valueOf(color));
        fVar.j(popupElevation);
        fVar.setShapeAppearanceModel(jVar);
        n0.e eVar = fVar.f4177a;
        if (eVar.f4167g == null) {
            eVar.f4167g = new Rect();
        }
        fVar.f4177a.f4167g.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        fVar.invalidateSelf();
        return fVar;
    }

    public final int g(int i, boolean z6) {
        int compoundPaddingLeft = this.d.getCompoundPaddingLeft() + i;
        if (getPrefixText() == null || z6) {
            return compoundPaddingLeft;
        }
        return getPrefixTextView().getPaddingLeft() + (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.d;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public n0.f getBoxBackground() {
        int i = this.f2602M;
        if (i == 1 || i == 2) {
            return this.f2597D;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.S;
    }

    public int getBoxBackgroundMode() {
        return this.f2602M;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f2603N;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zB = com.google.android.material.internal.s.b(this);
        RectF rectF = this.f2608V;
        return zB ? this.J.f4203h.getCornerSize(rectF) : this.J.f4202g.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zB = com.google.android.material.internal.s.b(this);
        RectF rectF = this.f2608V;
        return zB ? this.J.f4202g.getCornerSize(rectF) : this.J.f4203h.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zB = com.google.android.material.internal.s.b(this);
        RectF rectF = this.f2608V;
        return zB ? this.J.e.getCornerSize(rectF) : this.J.f4201f.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zB = com.google.android.material.internal.s.b(this);
        RectF rectF = this.f2608V;
        return zB ? this.J.f4201f.getCornerSize(rectF) : this.J.e.getCornerSize(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f2624k0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f2626l0;
    }

    public int getBoxStrokeWidth() {
        return this.f2605P;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f2606Q;
    }

    public int getCounterMaxLength() {
        return this.f2625l;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f2623k && this.f2627m && (appCompatTextView = this.f2631o) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f2647z;
    }

    public ColorStateList getCounterTextColor() {
        return this.y;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.g0;
    }

    public EditText getEditText() {
        return this.d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.c.f2676g.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.c.f2676g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.c.f2681m;
    }

    public int getEndIconMode() {
        return this.c.i;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.c.f2682n;
    }

    public CheckableImageButton getEndIconView() {
        return this.c.f2676g;
    }

    public CharSequence getError() {
        q qVar = this.f2621j;
        if (qVar.q) {
            return qVar.f2704p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f2621j.f2707t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f2621j.f2706s;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f2621j.f2705r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.c.c.getDrawable();
    }

    public CharSequence getHelperText() {
        q qVar = this.f2621j;
        if (qVar.x) {
            return qVar.f2709w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f2621j.y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.f2595A) {
            return this.f2596B;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f2638s0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.b bVar = this.f2638s0;
        return bVar.e(bVar.f2480k);
    }

    public ColorStateList getHintTextColor() {
        return this.f2620h0;
    }

    public LengthCounter getLengthCounter() {
        return this.f2629n;
    }

    public int getMaxEms() {
        return this.f2618g;
    }

    public int getMaxWidth() {
        return this.i;
    }

    public int getMinEms() {
        return this.f2616f;
    }

    public int getMinWidth() {
        return this.f2619h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.c.f2676g.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.c.f2676g.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f2637s) {
            return this.f2635r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f2642v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.u;
    }

    public CharSequence getPrefixText() {
        return this.b.c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.b.b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.b.b;
    }

    public n0.j getShapeAppearanceModel() {
        return this.J;
    }

    public CharSequence getStartIconContentDescription() {
        return this.b.d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.b.d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.b.f2720g;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.b.f2721h;
    }

    public CharSequence getSuffixText() {
        return this.c.f2684p;
    }

    public ColorStateList getSuffixTextColor() {
        return this.c.q.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.c.q;
    }

    public Typeface getTypeface() {
        return this.f2609W;
    }

    public final int h(int i, boolean z6) {
        int compoundPaddingRight = i - this.d.getCompoundPaddingRight();
        return (getPrefixText() == null || !z6) ? compoundPaddingRight : (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight()) + compoundPaddingRight;
    }

    public final void i() {
        int i = this.f2602M;
        if (i == 0) {
            this.f2597D = null;
            this.H = null;
            this.I = null;
        } else if (i == 1) {
            this.f2597D = new n0.f(this.J);
            this.H = new n0.f();
            this.I = new n0.f();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(B2.b.g(new StringBuilder(), " is illegal; only @BoxBackgroundMode constants are supported.", this.f2602M));
            }
            if (!this.f2595A || (this.f2597D instanceof f)) {
                this.f2597D = new n0.f(this.J);
            } else {
                n0.j jVar = this.J;
                int i3 = f.y;
                if (jVar == null) {
                    jVar = new n0.j();
                }
                e eVar = new e(jVar, new RectF());
                f fVar = new f(eVar);
                fVar.x = eVar;
                this.f2597D = fVar;
            }
            this.H = null;
            this.I = null;
        }
        r();
        w();
        if (this.f2602M == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f2603N = getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (AbstractC0573c.d(getContext())) {
                this.f2603N = getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.d != null && this.f2602M == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.d;
                ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.d), getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (AbstractC0573c.d(getContext())) {
                EditText editText2 = this.d;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.d), getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.f2602M != 0) {
            s();
        }
        EditText editText3 = this.d;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i4 = this.f2602M;
                if (i4 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i4 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.j():void");
    }

    public final void l(AppCompatTextView appCompatTextView, int i) {
        try {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.setTextAppearance(appCompatTextView, fr.sd.taada.R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(ContextCompat.getColor(getContext(), fr.sd.taada.R.color.design_error));
    }

    public final boolean m() {
        q qVar = this.f2621j;
        return (qVar.f2703o != 1 || qVar.f2705r == null || TextUtils.isEmpty(qVar.f2704p)) ? false : true;
    }

    public final void n(Editable editable) {
        int iCountLength = this.f2629n.countLength(editable);
        boolean z6 = this.f2627m;
        int i = this.f2625l;
        if (i == -1) {
            this.f2631o.setText(String.valueOf(iCountLength));
            this.f2631o.setContentDescription(null);
            this.f2627m = false;
        } else {
            this.f2627m = iCountLength > i;
            Context context = getContext();
            this.f2631o.setContentDescription(context.getString(this.f2627m ? fr.sd.taada.R.string.character_counter_overflowed_content_description : fr.sd.taada.R.string.character_counter_content_description, Integer.valueOf(iCountLength), Integer.valueOf(this.f2625l)));
            if (z6 != this.f2627m) {
                o();
            }
            this.f2631o.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(fr.sd.taada.R.string.character_counter_pattern, Integer.valueOf(iCountLength), Integer.valueOf(this.f2625l))));
        }
        if (this.d == null || z6 == this.f2627m) {
            return;
        }
        t(false, false);
        w();
        q();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f2631o;
        if (appCompatTextView != null) {
            l(appCompatTextView, this.f2627m ? this.f2632p : this.q);
            if (!this.f2627m && (colorStateList2 = this.y) != null) {
                this.f2631o.setTextColor(colorStateList2);
            }
            if (!this.f2627m || (colorStateList = this.f2647z) == null) {
                return;
            }
            this.f2631o.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2638s0.g(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i3, int i4, int i5) {
        super.onLayout(z6, i, i3, i4, i5);
        EditText editText = this.d;
        if (editText != null) {
            ThreadLocal threadLocal = com.google.android.material.internal.c.f2492a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.f2607T;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = com.google.android.material.internal.c.f2492a;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            com.google.android.material.internal.c.a(editText, this, matrix);
            ThreadLocal threadLocal3 = com.google.android.material.internal.c.b;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            n0.f fVar = this.H;
            if (fVar != null) {
                int i6 = rect.bottom;
                fVar.setBounds(rect.left, i6 - this.f2605P, rect.right, i6);
            }
            n0.f fVar2 = this.I;
            if (fVar2 != null) {
                int i7 = rect.bottom;
                fVar2.setBounds(rect.left, i7 - this.f2606Q, rect.right, i7);
            }
            if (this.f2595A) {
                float textSize = this.d.getTextSize();
                com.google.android.material.internal.b bVar = this.f2638s0;
                if (bVar.f2478h != textSize) {
                    bVar.f2478h = textSize;
                    bVar.h(false);
                }
                int gravity = this.d.getGravity();
                int i8 = (gravity & (-113)) | 48;
                if (bVar.f2477g != i8) {
                    bVar.f2477g = i8;
                    bVar.h(false);
                }
                if (bVar.f2475f != gravity) {
                    bVar.f2475f = gravity;
                    bVar.h(false);
                }
                if (this.d == null) {
                    throw new IllegalStateException();
                }
                boolean zB = com.google.android.material.internal.s.b(this);
                int i9 = rect.bottom;
                Rect rect2 = this.U;
                rect2.bottom = i9;
                int i10 = this.f2602M;
                if (i10 == 1) {
                    rect2.left = g(rect.left, zB);
                    rect2.top = rect.top + this.f2603N;
                    rect2.right = h(rect.right, zB);
                } else if (i10 != 2) {
                    rect2.left = g(rect.left, zB);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, zB);
                } else {
                    rect2.left = this.d.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.d.getPaddingRight();
                }
                int i11 = rect2.left;
                int i12 = rect2.top;
                int i13 = rect2.right;
                int i14 = rect2.bottom;
                Rect rect3 = bVar.d;
                if (rect3.left != i11 || rect3.top != i12 || rect3.right != i13 || rect3.bottom != i14) {
                    rect3.set(i11, i12, i13, i14);
                    bVar.f2458M = true;
                }
                if (this.d == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = bVar.f2460O;
                textPaint.setTextSize(bVar.f2478h);
                textPaint.setTypeface(bVar.u);
                textPaint.setLetterSpacing(bVar.f2465W);
                float f6 = -textPaint.ascent();
                rect2.left = this.d.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.f2602M != 1 || this.d.getMinLines() > 1) ? rect.top + this.d.getCompoundPaddingTop() : (int) (rect.centerY() - (f6 / 2.0f));
                rect2.right = rect.right - this.d.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f2602M != 1 || this.d.getMinLines() > 1) ? rect.bottom - this.d.getCompoundPaddingBottom() : (int) (rect2.top + f6);
                rect2.bottom = compoundPaddingBottom;
                int i15 = rect2.left;
                int i16 = rect2.top;
                int i17 = rect2.right;
                Rect rect4 = bVar.c;
                if (rect4.left != i15 || rect4.top != i16 || rect4.right != i17 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i15, i16, i17, compoundPaddingBottom);
                    bVar.f2458M = true;
                }
                bVar.h(false);
                if (!e() || this.f2636r0) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        EditText editText;
        int iMax;
        super.onMeasure(i, i3);
        EditText editText2 = this.d;
        m mVar = this.c;
        boolean z6 = false;
        if (editText2 != null && this.d.getMeasuredHeight() < (iMax = Math.max(mVar.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            this.d.setMinimumHeight(iMax);
            z6 = true;
        }
        boolean zP = p();
        if (z6 || zP) {
            this.d.post(new x(this, 1));
        }
        if (this.f2639t != null && (editText = this.d) != null) {
            this.f2639t.setGravity(editText.getGravity());
            this.f2639t.setPadding(this.d.getCompoundPaddingLeft(), this.d.getCompoundPaddingTop(), this.d.getCompoundPaddingRight(), this.d.getCompoundPaddingBottom());
        }
        mVar.l();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f2648a);
        if (savedState.b) {
            post(new x(this, 0));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z6 = i == 1;
        if (z6 != this.f2600K) {
            CornerSize cornerSize = this.J.e;
            RectF rectF = this.f2608V;
            float cornerSize2 = cornerSize.getCornerSize(rectF);
            float cornerSize3 = this.J.f4201f.getCornerSize(rectF);
            float cornerSize4 = this.J.f4203h.getCornerSize(rectF);
            float cornerSize5 = this.J.f4202g.getCornerSize(rectF);
            n0.j jVar = this.J;
            io.ktor.utils.io.jvm.javaio.q qVar = jVar.f4200a;
            io.ktor.utils.io.jvm.javaio.q qVar2 = jVar.b;
            io.ktor.utils.io.jvm.javaio.q qVar3 = jVar.d;
            io.ktor.utils.io.jvm.javaio.q qVar4 = jVar.c;
            n0.d dVar = new n0.d(0);
            n0.d dVar2 = new n0.d(0);
            n0.d dVar3 = new n0.d(0);
            n0.d dVar4 = new n0.d(0);
            n0.i.b(qVar2);
            n0.i.b(qVar);
            n0.i.b(qVar4);
            n0.i.b(qVar3);
            C0695a c0695a = new C0695a(cornerSize3);
            C0695a c0695a2 = new C0695a(cornerSize2);
            C0695a c0695a3 = new C0695a(cornerSize5);
            C0695a c0695a4 = new C0695a(cornerSize4);
            n0.j jVar2 = new n0.j();
            jVar2.f4200a = qVar2;
            jVar2.b = qVar;
            jVar2.c = qVar3;
            jVar2.d = qVar4;
            jVar2.e = c0695a;
            jVar2.f4201f = c0695a2;
            jVar2.f4202g = c0695a4;
            jVar2.f4203h = c0695a3;
            jVar2.i = dVar;
            jVar2.f4204j = dVar2;
            jVar2.f4205k = dVar3;
            jVar2.f4206l = dVar4;
            this.f2600K = z6;
            setShapeAppearanceModel(jVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (m()) {
            savedState.f2648a = getError();
        }
        m mVar = this.c;
        savedState.b = mVar.i != 0 && mVar.f2676g.f2439a;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.p():boolean");
    }

    public final void q() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.d;
        if (editText == null || this.f2602M != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (m()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f2627m && (appCompatTextView = this.f2631o) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.d.refreshDrawableState();
        }
    }

    public final void r() {
        EditText editText = this.d;
        if (editText == null || this.f2597D == null) {
            return;
        }
        if ((this.f2599G || editText.getBackground() == null) && this.f2602M != 0) {
            ViewCompat.setBackground(this.d, getEditTextBoxBackground());
            this.f2599G = true;
        }
    }

    public final void s() {
        if (this.f2602M != 1) {
            FrameLayout frameLayout = this.f2610a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iC = c();
            if (iC != layoutParams.topMargin) {
                layoutParams.topMargin = iC;
                frameLayout.requestLayout();
            }
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.S != i) {
            this.S = i;
            this.f2628m0 = i;
            this.o0 = i;
            this.f2633p0 = i;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f2628m0 = defaultColor;
        this.S = defaultColor;
        this.f2630n0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.o0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f2633p0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f2602M) {
            return;
        }
        this.f2602M = i;
        if (this.d != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.f2603N = i;
    }

    public void setBoxCornerFamily(int i) {
        n0.i iVarE = this.J.e();
        CornerSize cornerSize = this.J.e;
        io.ktor.utils.io.jvm.javaio.q qVarF = k1.j.f(i);
        iVarE.f4193a = qVarF;
        n0.i.b(qVarF);
        iVarE.e = cornerSize;
        CornerSize cornerSize2 = this.J.f4201f;
        io.ktor.utils.io.jvm.javaio.q qVarF2 = k1.j.f(i);
        iVarE.b = qVarF2;
        n0.i.b(qVarF2);
        iVarE.f4194f = cornerSize2;
        CornerSize cornerSize3 = this.J.f4203h;
        io.ktor.utils.io.jvm.javaio.q qVarF3 = k1.j.f(i);
        iVarE.d = qVarF3;
        n0.i.b(qVarF3);
        iVarE.f4196h = cornerSize3;
        CornerSize cornerSize4 = this.J.f4202g;
        io.ktor.utils.io.jvm.javaio.q qVarF4 = k1.j.f(i);
        iVarE.c = qVarF4;
        n0.i.b(qVarF4);
        iVarE.f4195g = cornerSize4;
        this.J = iVarE.a();
        b();
    }

    public void setBoxStrokeColor(int i) {
        if (this.f2624k0 != i) {
            this.f2624k0 = i;
            w();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.i0 = colorStateList.getDefaultColor();
            this.f2634q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f2622j0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f2624k0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f2624k0 != colorStateList.getDefaultColor()) {
            this.f2624k0 = colorStateList.getDefaultColor();
        }
        w();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f2626l0 != colorStateList) {
            this.f2626l0 = colorStateList;
            w();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f2605P = i;
        w();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f2606Q = i;
        w();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z6) {
        if (this.f2623k != z6) {
            q qVar = this.f2621j;
            if (z6) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f2631o = appCompatTextView;
                appCompatTextView.setId(fr.sd.taada.R.id.textinput_counter);
                Typeface typeface = this.f2609W;
                if (typeface != null) {
                    this.f2631o.setTypeface(typeface);
                }
                this.f2631o.setMaxLines(1);
                qVar.a(this.f2631o, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f2631o.getLayoutParams(), getResources().getDimensionPixelOffset(fr.sd.taada.R.dimen.mtrl_textinput_counter_margin_start));
                o();
                if (this.f2631o != null) {
                    EditText editText = this.d;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                qVar.g(this.f2631o, 2);
                this.f2631o = null;
            }
            this.f2623k = z6;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f2625l != i) {
            if (i > 0) {
                this.f2625l = i;
            } else {
                this.f2625l = -1;
            }
            if (!this.f2623k || this.f2631o == null) {
                return;
            }
            EditText editText = this.d;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.f2632p != i) {
            this.f2632p = i;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f2647z != colorStateList) {
            this.f2647z = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            o();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.g0 = colorStateList;
        this.f2620h0 = colorStateList;
        if (this.d != null) {
            t(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z6) {
        k(this, z6);
        super.setEnabled(z6);
    }

    public void setEndIconActivated(boolean z6) {
        this.c.f2676g.setActivated(z6);
    }

    public void setEndIconCheckable(boolean z6) {
        this.c.f2676g.setCheckable(z6);
    }

    public void setEndIconContentDescription(int i) {
        m mVar = this.c;
        CharSequence text = i != 0 ? mVar.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = mVar.f2676g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        m mVar = this.c;
        Drawable drawable = i != 0 ? AppCompatResources.getDrawable(mVar.getContext(), i) : null;
        CheckableImageButton checkableImageButton = mVar.f2676g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = mVar.f2679k;
            PorterDuff.Mode mode = mVar.f2680l;
            TextInputLayout textInputLayout = mVar.f2674a;
            E1.k.g(textInputLayout, checkableImageButton, colorStateList, mode);
            E1.k.c0(textInputLayout, checkableImageButton, mVar.f2679k);
        }
    }

    public void setEndIconMinSize(int i) {
        m mVar = this.c;
        if (i < 0) {
            mVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != mVar.f2681m) {
            mVar.f2681m = i;
            CheckableImageButton checkableImageButton = mVar.f2676g;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = mVar.c;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.c.f(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        m mVar = this.c;
        View.OnLongClickListener onLongClickListener = mVar.f2683o;
        CheckableImageButton checkableImageButton = mVar.f2676g;
        checkableImageButton.setOnClickListener(onClickListener);
        E1.k.i0(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        m mVar = this.c;
        mVar.f2683o = onLongClickListener;
        CheckableImageButton checkableImageButton = mVar.f2676g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        E1.k.i0(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        m mVar = this.c;
        mVar.f2682n = scaleType;
        mVar.f2676g.setScaleType(scaleType);
        mVar.c.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar.f2679k != colorStateList) {
            mVar.f2679k = colorStateList;
            E1.k.g(mVar.f2674a, mVar.f2676g, colorStateList, mVar.f2680l);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar.f2680l != mode) {
            mVar.f2680l = mode;
            E1.k.g(mVar.f2674a, mVar.f2676g, mVar.f2679k, mode);
        }
    }

    public void setEndIconVisible(boolean z6) {
        this.c.g(z6);
    }

    public void setError(CharSequence charSequence) {
        q qVar = this.f2621j;
        if (!qVar.q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            qVar.f();
            return;
        }
        qVar.c();
        qVar.f2704p = charSequence;
        qVar.f2705r.setText(charSequence);
        int i = qVar.f2702n;
        if (i != 1) {
            qVar.f2703o = 1;
        }
        qVar.i(i, qVar.f2703o, qVar.h(qVar.f2705r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        q qVar = this.f2621j;
        qVar.f2707t = i;
        AppCompatTextView appCompatTextView = qVar.f2705r;
        if (appCompatTextView != null) {
            ViewCompat.setAccessibilityLiveRegion(appCompatTextView, i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        q qVar = this.f2621j;
        qVar.f2706s = charSequence;
        AppCompatTextView appCompatTextView = qVar.f2705r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z6) {
        q qVar = this.f2621j;
        if (qVar.q == z6) {
            return;
        }
        qVar.c();
        TextInputLayout textInputLayout = qVar.f2697h;
        if (z6) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(qVar.f2696g);
            qVar.f2705r = appCompatTextView;
            appCompatTextView.setId(fr.sd.taada.R.id.textinput_error);
            qVar.f2705r.setTextAlignment(5);
            Typeface typeface = qVar.f2693B;
            if (typeface != null) {
                qVar.f2705r.setTypeface(typeface);
            }
            int i = qVar.u;
            qVar.u = i;
            AppCompatTextView appCompatTextView2 = qVar.f2705r;
            if (appCompatTextView2 != null) {
                textInputLayout.l(appCompatTextView2, i);
            }
            ColorStateList colorStateList = qVar.f2708v;
            qVar.f2708v = colorStateList;
            AppCompatTextView appCompatTextView3 = qVar.f2705r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = qVar.f2706s;
            qVar.f2706s = charSequence;
            AppCompatTextView appCompatTextView4 = qVar.f2705r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i3 = qVar.f2707t;
            qVar.f2707t = i3;
            AppCompatTextView appCompatTextView5 = qVar.f2705r;
            if (appCompatTextView5 != null) {
                ViewCompat.setAccessibilityLiveRegion(appCompatTextView5, i3);
            }
            qVar.f2705r.setVisibility(4);
            qVar.a(qVar.f2705r, 0);
        } else {
            qVar.f();
            qVar.g(qVar.f2705r, 0);
            qVar.f2705r = null;
            textInputLayout.q();
            textInputLayout.w();
        }
        qVar.q = z6;
    }

    public void setErrorIconDrawable(int i) {
        m mVar = this.c;
        mVar.h(i != 0 ? AppCompatResources.getDrawable(mVar.getContext(), i) : null);
        E1.k.c0(mVar.f2674a, mVar.c, mVar.d);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        m mVar = this.c;
        CheckableImageButton checkableImageButton = mVar.c;
        View.OnLongClickListener onLongClickListener = mVar.f2675f;
        checkableImageButton.setOnClickListener(onClickListener);
        E1.k.i0(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        m mVar = this.c;
        mVar.f2675f = onLongClickListener;
        CheckableImageButton checkableImageButton = mVar.c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        E1.k.i0(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar.d != colorStateList) {
            mVar.d = colorStateList;
            E1.k.g(mVar.f2674a, mVar.c, colorStateList, mVar.e);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar.e != mode) {
            mVar.e = mode;
            E1.k.g(mVar.f2674a, mVar.c, mVar.d, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        q qVar = this.f2621j;
        qVar.u = i;
        AppCompatTextView appCompatTextView = qVar.f2705r;
        if (appCompatTextView != null) {
            qVar.f2697h.l(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        q qVar = this.f2621j;
        qVar.f2708v = colorStateList;
        AppCompatTextView appCompatTextView = qVar.f2705r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z6) {
        if (this.f2640t0 != z6) {
            this.f2640t0 = z6;
            t(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        q qVar = this.f2621j;
        if (zIsEmpty) {
            if (qVar.x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!qVar.x) {
            setHelperTextEnabled(true);
        }
        qVar.c();
        qVar.f2709w = charSequence;
        qVar.y.setText(charSequence);
        int i = qVar.f2702n;
        if (i != 2) {
            qVar.f2703o = 2;
        }
        qVar.i(i, qVar.f2703o, qVar.h(qVar.y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        q qVar = this.f2621j;
        qVar.f2692A = colorStateList;
        AppCompatTextView appCompatTextView = qVar.y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z6) {
        q qVar = this.f2621j;
        if (qVar.x == z6) {
            return;
        }
        qVar.c();
        if (z6) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(qVar.f2696g);
            qVar.y = appCompatTextView;
            appCompatTextView.setId(fr.sd.taada.R.id.textinput_helper_text);
            qVar.y.setTextAlignment(5);
            Typeface typeface = qVar.f2693B;
            if (typeface != null) {
                qVar.y.setTypeface(typeface);
            }
            qVar.y.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(qVar.y, 1);
            int i = qVar.f2710z;
            qVar.f2710z = i;
            AppCompatTextView appCompatTextView2 = qVar.y;
            if (appCompatTextView2 != null) {
                TextViewCompat.setTextAppearance(appCompatTextView2, i);
            }
            ColorStateList colorStateList = qVar.f2692A;
            qVar.f2692A = colorStateList;
            AppCompatTextView appCompatTextView3 = qVar.y;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            qVar.a(qVar.y, 1);
            qVar.y.setAccessibilityDelegate(new p(qVar));
        } else {
            qVar.c();
            int i3 = qVar.f2702n;
            if (i3 == 2) {
                qVar.f2703o = 0;
            }
            qVar.i(i3, qVar.f2703o, qVar.h(qVar.y, ""));
            qVar.g(qVar.y, 1);
            qVar.y = null;
            TextInputLayout textInputLayout = qVar.f2697h;
            textInputLayout.q();
            textInputLayout.w();
        }
        qVar.x = z6;
    }

    public void setHelperTextTextAppearance(int i) {
        q qVar = this.f2621j;
        qVar.f2710z = i;
        AppCompatTextView appCompatTextView = qVar.y;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f2595A) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z6) {
        this.f2641u0 = z6;
    }

    public void setHintEnabled(boolean z6) {
        if (z6 != this.f2595A) {
            this.f2595A = z6;
            if (z6) {
                CharSequence hint = this.d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f2596B)) {
                        setHint(hint);
                    }
                    this.d.setHint((CharSequence) null);
                }
                this.C = true;
            } else {
                this.C = false;
                if (!TextUtils.isEmpty(this.f2596B) && TextUtils.isEmpty(this.d.getHint())) {
                    this.d.setHint(this.f2596B);
                }
                setHintInternal(null);
            }
            if (this.d != null) {
                s();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        com.google.android.material.internal.b bVar = this.f2638s0;
        TextInputLayout textInputLayout = bVar.f2469a;
        k0.f fVar = new k0.f(textInputLayout.getContext(), i);
        ColorStateList colorStateList = fVar.f3685j;
        if (colorStateList != null) {
            bVar.f2480k = colorStateList;
        }
        float f6 = fVar.f3686k;
        if (f6 != 0.0f) {
            bVar.i = f6;
        }
        ColorStateList colorStateList2 = fVar.f3681a;
        if (colorStateList2 != null) {
            bVar.U = colorStateList2;
        }
        bVar.S = fVar.e;
        bVar.f2463T = fVar.f3682f;
        bVar.R = fVar.f3683g;
        bVar.f2464V = fVar.i;
        C0571a c0571a = bVar.y;
        if (c0571a != null) {
            c0571a.c = true;
        }
        B.g gVar = new B.g(bVar, 23);
        fVar.a();
        bVar.y = new C0571a(gVar, fVar.f3689n);
        fVar.c(textInputLayout.getContext(), bVar.y);
        bVar.h(false);
        this.f2620h0 = bVar.f2480k;
        if (this.d != null) {
            t(false, false);
            s();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f2620h0 != colorStateList) {
            if (this.g0 == null) {
                com.google.android.material.internal.b bVar = this.f2638s0;
                if (bVar.f2480k != colorStateList) {
                    bVar.f2480k = colorStateList;
                    bVar.h(false);
                }
            }
            this.f2620h0 = colorStateList;
            if (this.d != null) {
                t(false, false);
            }
        }
    }

    public void setLengthCounter(LengthCounter lengthCounter) {
        this.f2629n = lengthCounter;
    }

    public void setMaxEms(int i) {
        this.f2618g = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.i = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.f2616f = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.f2619h = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        m mVar = this.c;
        mVar.f2676g.setContentDescription(i != 0 ? mVar.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        m mVar = this.c;
        mVar.f2676g.setImageDrawable(i != 0 ? AppCompatResources.getDrawable(mVar.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z6) {
        m mVar = this.c;
        if (z6 && mVar.i != 1) {
            mVar.f(1);
        } else if (z6) {
            mVar.getClass();
        } else {
            mVar.f(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        m mVar = this.c;
        mVar.f2679k = colorStateList;
        E1.k.g(mVar.f2674a, mVar.f2676g, colorStateList, mVar.f2680l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        m mVar = this.c;
        mVar.f2680l = mode;
        E1.k.g(mVar.f2674a, mVar.f2676g, mVar.f2679k, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f2639t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f2639t = appCompatTextView;
            appCompatTextView.setId(fr.sd.taada.R.id.textinput_placeholder);
            ViewCompat.setImportantForAccessibility(this.f2639t, 2);
            Fade fadeD = d();
            this.f2644w = fadeD;
            fadeD.setStartDelay(67L);
            this.x = d();
            setPlaceholderTextAppearance(this.f2642v);
            setPlaceholderTextColor(this.u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f2637s) {
                setPlaceholderTextEnabled(true);
            }
            this.f2635r = charSequence;
        }
        EditText editText = this.d;
        u(editText == null ? null : editText.getText());
    }

    public void setPlaceholderTextAppearance(int i) {
        this.f2642v = i;
        AppCompatTextView appCompatTextView = this.f2639t;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            AppCompatTextView appCompatTextView = this.f2639t;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        v vVar = this.b;
        vVar.getClass();
        vVar.c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        vVar.b.setText(charSequence);
        vVar.d();
    }

    public void setPrefixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.b.b, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.b.b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(n0.j jVar) {
        n0.f fVar = this.f2597D;
        if (fVar == null || fVar.f4177a.f4165a == jVar) {
            return;
        }
        this.J = jVar;
        b();
    }

    public void setStartIconCheckable(boolean z6) {
        this.b.d.setCheckable(z6);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.b.d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        v vVar = this.b;
        if (i < 0) {
            vVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != vVar.f2720g) {
            vVar.f2720g = i;
            CheckableImageButton checkableImageButton = vVar.d;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        v vVar = this.b;
        View.OnLongClickListener onLongClickListener = vVar.i;
        CheckableImageButton checkableImageButton = vVar.d;
        checkableImageButton.setOnClickListener(onClickListener);
        E1.k.i0(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        v vVar = this.b;
        vVar.i = onLongClickListener;
        CheckableImageButton checkableImageButton = vVar.d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        E1.k.i0(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        v vVar = this.b;
        vVar.f2721h = scaleType;
        vVar.d.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        v vVar = this.b;
        if (vVar.e != colorStateList) {
            vVar.e = colorStateList;
            E1.k.g(vVar.f2718a, vVar.d, colorStateList, vVar.f2719f);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        v vVar = this.b;
        if (vVar.f2719f != mode) {
            vVar.f2719f = mode;
            E1.k.g(vVar.f2718a, vVar.d, vVar.e, mode);
        }
    }

    public void setStartIconVisible(boolean z6) {
        this.b.b(z6);
    }

    public void setSuffixText(CharSequence charSequence) {
        m mVar = this.c;
        mVar.getClass();
        mVar.f2684p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        mVar.q.setText(charSequence);
        mVar.m();
    }

    public void setSuffixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.c.q, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.c.q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(y yVar) {
        EditText editText = this.d;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, yVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f2609W) {
            this.f2609W = typeface;
            this.f2638s0.m(typeface);
            q qVar = this.f2621j;
            if (typeface != qVar.f2693B) {
                qVar.f2693B = typeface;
                AppCompatTextView appCompatTextView = qVar.f2705r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = qVar.y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f2631o;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t(boolean z6, boolean z7) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.d;
        boolean z8 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.d;
        boolean z9 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.g0;
        com.google.android.material.internal.b bVar = this.f2638s0;
        if (colorStateList2 != null) {
            bVar.i(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.g0;
            bVar.i(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f2634q0) : this.f2634q0));
        } else if (m()) {
            AppCompatTextView appCompatTextView2 = this.f2621j.f2705r;
            bVar.i(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f2627m && (appCompatTextView = this.f2631o) != null) {
            bVar.i(appCompatTextView.getTextColors());
        } else if (z9 && (colorStateList = this.f2620h0) != null && bVar.f2480k != colorStateList) {
            bVar.f2480k = colorStateList;
            bVar.h(false);
        }
        m mVar = this.c;
        v vVar = this.b;
        if (z8 || !this.f2640t0 || (isEnabled() && z9)) {
            if (z7 || this.f2636r0) {
                ValueAnimator valueAnimator = this.f2643v0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f2643v0.cancel();
                }
                if (z6 && this.f2641u0) {
                    a(1.0f);
                } else {
                    bVar.k(1.0f);
                }
                this.f2636r0 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.d;
                u(editText3 != null ? editText3.getText() : null);
                vVar.f2722j = false;
                vVar.d();
                mVar.f2685r = false;
                mVar.m();
                return;
            }
            return;
        }
        if (z7 || !this.f2636r0) {
            ValueAnimator valueAnimator2 = this.f2643v0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f2643v0.cancel();
            }
            if (z6 && this.f2641u0) {
                a(0.0f);
            } else {
                bVar.k(0.0f);
            }
            if (e() && !((f) this.f2597D).x.q.isEmpty() && e()) {
                ((f) this.f2597D).q(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f2636r0 = true;
            AppCompatTextView appCompatTextView3 = this.f2639t;
            if (appCompatTextView3 != null && this.f2637s) {
                appCompatTextView3.setText((CharSequence) null);
                TransitionManager.beginDelayedTransition(this.f2610a, this.x);
                this.f2639t.setVisibility(4);
            }
            vVar.f2722j = true;
            vVar.d();
            mVar.f2685r = true;
            mVar.m();
        }
    }

    public final void u(Editable editable) {
        int iCountLength = this.f2629n.countLength(editable);
        FrameLayout frameLayout = this.f2610a;
        if (iCountLength != 0 || this.f2636r0) {
            AppCompatTextView appCompatTextView = this.f2639t;
            if (appCompatTextView == null || !this.f2637s) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(frameLayout, this.x);
            this.f2639t.setVisibility(4);
            return;
        }
        if (this.f2639t == null || !this.f2637s || TextUtils.isEmpty(this.f2635r)) {
            return;
        }
        this.f2639t.setText(this.f2635r);
        TransitionManager.beginDelayedTransition(frameLayout, this.f2644w);
        this.f2639t.setVisibility(0);
        this.f2639t.bringToFront();
        announceForAccessibility(this.f2635r);
    }

    public final void v(boolean z6, boolean z7) {
        int defaultColor = this.f2626l0.getDefaultColor();
        int colorForState = this.f2626l0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f2626l0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z6) {
            this.R = colorForState2;
        } else if (z7) {
            this.R = colorForState;
        } else {
            this.R = defaultColor;
        }
    }

    public final void w() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.f2597D == null || this.f2602M == 0) {
            return;
        }
        boolean z6 = false;
        boolean z7 = isFocused() || ((editText2 = this.d) != null && editText2.hasFocus());
        boolean z8 = isHovered() || ((editText = this.d) != null && editText.isHovered());
        if (m() || (this.f2631o != null && this.f2627m)) {
            z6 = true;
        }
        if (!isEnabled()) {
            this.R = this.f2634q0;
        } else if (m()) {
            if (this.f2626l0 != null) {
                v(z7, z8);
            } else {
                this.R = getErrorCurrentTextColors();
            }
        } else if (!this.f2627m || (appCompatTextView = this.f2631o) == null) {
            if (z7) {
                this.R = this.f2624k0;
            } else if (z8) {
                this.R = this.f2622j0;
            } else {
                this.R = this.i0;
            }
        } else if (this.f2626l0 != null) {
            v(z7, z8);
        } else {
            this.R = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Context context = getContext();
            TypedValue typedValueA = AbstractC0572b.a(context, fr.sd.taada.R.attr.colorControlActivated);
            ColorStateList colorStateListValueOf = null;
            if (typedValueA != null) {
                int i = typedValueA.resourceId;
                if (i != 0) {
                    colorStateListValueOf = ContextCompat.getColorStateList(context, i);
                } else {
                    int i3 = typedValueA.data;
                    if (i3 != 0) {
                        colorStateListValueOf = ColorStateList.valueOf(i3);
                    }
                }
            }
            EditText editText3 = this.d;
            if (editText3 != null && editText3.getTextCursorDrawable() != null && colorStateListValueOf != null) {
                Drawable textCursorDrawable = this.d.getTextCursorDrawable();
                if (z6) {
                    ColorStateList colorStateListValueOf2 = this.f2626l0;
                    if (colorStateListValueOf2 == null) {
                        colorStateListValueOf2 = ColorStateList.valueOf(this.R);
                    }
                    colorStateListValueOf = colorStateListValueOf2;
                }
                DrawableCompat.setTintList(textCursorDrawable, colorStateListValueOf);
            }
        }
        m mVar = this.c;
        mVar.k();
        CheckableImageButton checkableImageButton = mVar.c;
        ColorStateList colorStateList = mVar.d;
        TextInputLayout textInputLayout = mVar.f2674a;
        E1.k.c0(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = mVar.f2679k;
        CheckableImageButton checkableImageButton2 = mVar.f2676g;
        E1.k.c0(textInputLayout, checkableImageButton2, colorStateList2);
        if (mVar.b() instanceof i) {
            if (!textInputLayout.m() || checkableImageButton2.getDrawable() == null) {
                E1.k.g(textInputLayout, checkableImageButton2, mVar.f2679k, mVar.f2680l);
            } else {
                Drawable drawableMutate = DrawableCompat.wrap(checkableImageButton2.getDrawable()).mutate();
                DrawableCompat.setTint(drawableMutate, textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(drawableMutate);
            }
        }
        v vVar = this.b;
        E1.k.c0(vVar.f2718a, vVar.d, vVar.e);
        if (this.f2602M == 2) {
            int i4 = this.f2604O;
            if (z7 && isEnabled()) {
                this.f2604O = this.f2606Q;
            } else {
                this.f2604O = this.f2605P;
            }
            if (this.f2604O != i4 && e() && !this.f2636r0) {
                if (e()) {
                    ((f) this.f2597D).q(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.f2602M == 1) {
            if (!isEnabled()) {
                this.S = this.f2630n0;
            } else if (z8 && !z7) {
                this.S = this.f2633p0;
            } else if (z7) {
                this.S = this.o0;
            } else {
                this.S = this.f2628m0;
            }
        }
        b();
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.b.a(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.c.f2676g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.c.f2676g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.c.h(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.c.f2676g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        m mVar = this.c;
        CheckableImageButton checkableImageButton = mVar.f2676g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = mVar.f2679k;
            PorterDuff.Mode mode = mVar.f2680l;
            TextInputLayout textInputLayout = mVar.f2674a;
            E1.k.g(textInputLayout, checkableImageButton, colorStateList, mode);
            E1.k.c0(textInputLayout, checkableImageButton, mVar.f2679k);
        }
    }
}
