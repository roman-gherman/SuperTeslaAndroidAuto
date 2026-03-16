package com.google.android.material.card;

import V.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import c0.C0239c;
import com.google.android.material.color.g;
import com.google.android.material.internal.o;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k0.AbstractC0573c;
import l0.AbstractC0615a;
import n0.e;
import n0.f;
import n0.j;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 8388693;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 8388691;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 8388661;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 8388659;
    private static final String LOG_TAG = "MaterialCardView";
    private final C0239c cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DRAGGED_STATE_SET = {fr.sd.taada.R.attr.state_dragged};
    private static final int DEF_STYLE_RES = fr.sd.taada.R.style.Widget_MaterialComponents_CardView;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z6);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, fr.sd.taada.R.attr.materialCardViewStyle);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.cardViewHelper.c.getBounds());
        return rectF;
    }

    public final void a() {
        C0239c c0239c;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (c0239c = this.cardViewHelper).f1735o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i = bounds.bottom;
        c0239c.f1735o.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        c0239c.f1735o.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.c.f4177a.c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.d.f4177a.c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.cardViewHelper.f1730j;
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.f1728g;
    }

    public int getCheckedIconMargin() {
        return this.cardViewHelper.e;
    }

    public int getCheckedIconSize() {
        return this.cardViewHelper.f1727f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.f1732l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.b.top;
    }

    public float getProgress() {
        return this.cardViewHelper.c.f4177a.i;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.c.g();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.f1731k;
    }

    @Override // com.google.android.material.shape.Shapeable
    public j getShapeAppearanceModel() {
        return this.cardViewHelper.f1733m;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.cardViewHelper.f1734n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.f1734n;
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.f1729h;
    }

    public boolean isCheckable() {
        C0239c c0239c = this.cardViewHelper;
        return c0239c != null && c0239c.f1738s;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k1.j.q(this, this.cardViewHelper.c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (isCheckable()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, DRAGGED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        this.cardViewHelper.e(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setAncestorContentPadding(int i, int i3, int i4, int i5) {
        super.setContentPadding(i, i3, i4, i5);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            C0239c c0239c = this.cardViewHelper;
            if (!c0239c.f1737r) {
                c0239c.f1737r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        C0239c c0239c = this.cardViewHelper;
        c0239c.c.k(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f6) {
        super.setCardElevation(f6);
        C0239c c0239c = this.cardViewHelper;
        c0239c.c.j(c0239c.f1726a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        f fVar = this.cardViewHelper.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        fVar.k(colorStateList);
    }

    public void setCheckable(boolean z6) {
        this.cardViewHelper.f1738s = z6;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z6) {
        if (this.checked != z6) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.cardViewHelper.g(drawable);
    }

    public void setCheckedIconGravity(int i) {
        C0239c c0239c = this.cardViewHelper;
        if (c0239c.f1728g != i) {
            c0239c.f1728g = i;
            MaterialCardView materialCardView = c0239c.f1726a;
            c0239c.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i) {
        this.cardViewHelper.e = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.cardViewHelper.e = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.cardViewHelper.g(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.cardViewHelper.f1727f = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.cardViewHelper.f1727f = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C0239c c0239c = this.cardViewHelper;
        c0239c.f1732l = colorStateList;
        Drawable drawable = c0239c.f1730j;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z6) {
        super.setClickable(z6);
        C0239c c0239c = this.cardViewHelper;
        if (c0239c != null) {
            Drawable drawable = c0239c.i;
            MaterialCardView materialCardView = c0239c.f1726a;
            Drawable drawableC = materialCardView.isClickable() ? c0239c.c() : c0239c.d;
            c0239c.i = drawableC;
            if (drawable != drawableC) {
                if (materialCardView.getForeground() instanceof InsetDrawable) {
                    ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
                } else {
                    materialCardView.setForeground(c0239c.d(drawableC));
                }
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i3, int i4, int i5) {
        C0239c c0239c = this.cardViewHelper;
        c0239c.b.set(i, i3, i4, i5);
        c0239c.j();
    }

    public void setDragged(boolean z6) {
        if (this.dragged != z6) {
            this.dragged = z6;
            refreshDrawableState();
            a();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f6) {
        super.setMaxCardElevation(f6);
        this.cardViewHelper.k();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z6) {
        super.setPreventCornerOverlap(z6);
        this.cardViewHelper.k();
        this.cardViewHelper.j();
    }

    public void setProgress(float f6) {
        C0239c c0239c = this.cardViewHelper;
        c0239c.c.l(f6);
        f fVar = c0239c.d;
        if (fVar != null) {
            fVar.l(f6);
        }
        f fVar2 = c0239c.q;
        if (fVar2 != null) {
            fVar2.l(f6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0051  */
    @Override // androidx.cardview.widget.CardView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setRadius(float r4) {
        /*
            r3 = this;
            super.setRadius(r4)
            c0.c r0 = r3.cardViewHelper
            n0.j r1 = r0.f1733m
            n0.i r1 = r1.e()
            n0.a r2 = new n0.a
            r2.<init>(r4)
            r1.e = r2
            n0.a r2 = new n0.a
            r2.<init>(r4)
            r1.f4194f = r2
            n0.a r2 = new n0.a
            r2.<init>(r4)
            r1.f4195g = r2
            n0.a r2 = new n0.a
            r2.<init>(r4)
            r1.f4196h = r2
            n0.j r4 = r1.a()
            r0.h(r4)
            android.graphics.drawable.Drawable r4 = r0.i
            r4.invalidateSelf()
            boolean r4 = r0.i()
            if (r4 != 0) goto L51
            com.google.android.material.card.MaterialCardView r4 = r0.f1726a
            boolean r4 = r4.getPreventCornerOverlap()
            if (r4 == 0) goto L54
            n0.f r4 = r0.c
            n0.e r1 = r4.f4177a
            n0.j r1 = r1.f4165a
            android.graphics.RectF r4 = r4.f()
            boolean r4 = r1.d(r4)
            if (r4 != 0) goto L54
        L51:
            r0.j()
        L54:
            boolean r4 = r0.i()
            if (r4 == 0) goto L5d
            r0.k()
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.setRadius(float):void");
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C0239c c0239c = this.cardViewHelper;
        c0239c.f1731k = colorStateList;
        int[] iArr = AbstractC0615a.f3956a;
        RippleDrawable rippleDrawable = c0239c.f1735o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        C0239c c0239c = this.cardViewHelper;
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), i);
        c0239c.f1731k = colorStateList;
        int[] iArr = AbstractC0615a.f3956a;
        RippleDrawable rippleDrawable = c0239c.f1735o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.cardViewHelper.h(jVar);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        C0239c c0239c = this.cardViewHelper;
        if (i != c0239c.f1729h) {
            c0239c.f1729h = i;
            f fVar = c0239c.d;
            ColorStateList colorStateList = c0239c.f1734n;
            fVar.f4177a.f4169j = i;
            fVar.invalidateSelf();
            e eVar = fVar.f4177a;
            if (eVar.d != colorStateList) {
                eVar.d = colorStateList;
                fVar.onStateChange(fVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z6) {
        super.setUseCompatPadding(z6);
        this.cardViewHelper.k();
        this.cardViewHelper.j();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            a();
            this.cardViewHelper.f(this.checked, true);
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.checked);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        int i3 = DEF_STYLE_RES;
        super(AbstractC0792a.a(context, attributeSet, i, i3), attributeSet, i);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray typedArrayD = o.d(getContext(), attributeSet, a.q, i, i3, new int[0]);
        C0239c c0239c = new C0239c(this, attributeSet, i, i3);
        this.cardViewHelper = c0239c;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        f fVar = c0239c.c;
        fVar.k(cardBackgroundColor);
        c0239c.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        c0239c.j();
        MaterialCardView materialCardView = c0239c.f1726a;
        ColorStateList colorStateListA = AbstractC0573c.a(materialCardView.getContext(), typedArrayD, 11);
        c0239c.f1734n = colorStateListA;
        if (colorStateListA == null) {
            c0239c.f1734n = ColorStateList.valueOf(-1);
        }
        c0239c.f1729h = typedArrayD.getDimensionPixelSize(12, 0);
        boolean z6 = typedArrayD.getBoolean(0, false);
        c0239c.f1738s = z6;
        materialCardView.setLongClickable(z6);
        c0239c.f1732l = AbstractC0573c.a(materialCardView.getContext(), typedArrayD, 6);
        c0239c.g(AbstractC0573c.c(materialCardView.getContext(), typedArrayD, 2));
        c0239c.f1727f = typedArrayD.getDimensionPixelSize(5, 0);
        c0239c.e = typedArrayD.getDimensionPixelSize(4, 0);
        c0239c.f1728g = typedArrayD.getInteger(3, CHECKED_ICON_GRAVITY_TOP_END);
        ColorStateList colorStateListA2 = AbstractC0573c.a(materialCardView.getContext(), typedArrayD, 7);
        c0239c.f1731k = colorStateListA2;
        if (colorStateListA2 == null) {
            c0239c.f1731k = ColorStateList.valueOf(g.f(materialCardView, fr.sd.taada.R.attr.colorControlHighlight));
        }
        ColorStateList colorStateListA3 = AbstractC0573c.a(materialCardView.getContext(), typedArrayD, 1);
        f fVar2 = c0239c.d;
        fVar2.k(colorStateListA3 == null ? ColorStateList.valueOf(0) : colorStateListA3);
        int[] iArr = AbstractC0615a.f3956a;
        RippleDrawable rippleDrawable = c0239c.f1735o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(c0239c.f1731k);
        }
        fVar.j(materialCardView.getCardElevation());
        float f6 = c0239c.f1729h;
        ColorStateList colorStateList = c0239c.f1734n;
        fVar2.f4177a.f4169j = f6;
        fVar2.invalidateSelf();
        e eVar = fVar2.f4177a;
        if (eVar.d != colorStateList) {
            eVar.d = colorStateList;
            fVar2.onStateChange(fVar2.getState());
        }
        materialCardView.setBackgroundInternal(c0239c.d(fVar));
        Drawable drawableC = materialCardView.isClickable() ? c0239c.c() : fVar2;
        c0239c.i = drawableC;
        materialCardView.setForeground(c0239c.d(drawableC));
        typedArrayD.recycle();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        C0239c c0239c = this.cardViewHelper;
        if (c0239c.f1734n != colorStateList) {
            c0239c.f1734n = colorStateList;
            f fVar = c0239c.d;
            fVar.f4177a.f4169j = c0239c.f1729h;
            fVar.invalidateSelf();
            e eVar = fVar.f4177a;
            if (eVar.d != colorStateList) {
                eVar.d = colorStateList;
                fVar.onStateChange(fVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.cardViewHelper.c.k(colorStateList);
    }
}
