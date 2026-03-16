package com.google.android.material.navigation;

import a0.C0133a;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import c4.AbstractC0246d;
import com.google.android.material.badge.BadgeState$State;
import java.lang.ref.WeakReference;
import l0.AbstractC0615a;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends FrameLayout implements MenuView.ItemView {
    public static final int[] E = {R.attr.state_checked};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final c f2513F = new c();

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final d f2514G = new d();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f2515A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f2516B;
    public int C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Y.a f2517D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2518a;
    public ColorStateList b;
    public Drawable c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2521h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f2523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f2524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f2525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f2526n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f2527o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f2528p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MenuItemImpl f2529r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f2530s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f2531t;
    public Drawable u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f2532v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f2533w;
    public float x;
    public boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2534z;

    public e(Context context) {
        super(context);
        this.f2518a = false;
        this.q = -1;
        this.f2533w = f2513F;
        this.x = 0.0f;
        this.y = false;
        this.f2534z = 0;
        this.f2515A = 0;
        this.f2516B = false;
        this.C = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f2523k = (FrameLayout) findViewById(fr.sd.taada.R.id.navigation_bar_item_icon_container);
        this.f2524l = findViewById(fr.sd.taada.R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(fr.sd.taada.R.id.navigation_bar_item_icon_view);
        this.f2525m = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(fr.sd.taada.R.id.navigation_bar_item_labels_group);
        this.f2526n = viewGroup;
        TextView textView = (TextView) findViewById(fr.sd.taada.R.id.navigation_bar_item_small_label_view);
        this.f2527o = textView;
        TextView textView2 = (TextView) findViewById(fr.sd.taada.R.id.navigation_bar_item_large_label_view);
        this.f2528p = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.e = viewGroup.getPaddingBottom();
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a((C0133a) this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(android.widget.TextView r4, int r5) {
        /*
            androidx.core.widget.TextViewCompat.setTextAppearance(r4, r5)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r5 != 0) goto Lb
            goto L1f
        Lb:
            int[] r2 = V.a.E
            android.content.res.TypedArray r5 = r0.obtainStyledAttributes(r5, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            boolean r3 = r5.getValue(r1, r2)
            r5.recycle()
            if (r3 != 0) goto L21
        L1f:
            r5 = r1
            goto L4c
        L21:
            int r5 = r2.getComplexUnit()
            r3 = 2
            if (r5 != r3) goto L3e
            int r5 = r2.data
            float r5 = android.util.TypedValue.complexToFloat(r5)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r5 = r5 * r0
            int r5 = java.lang.Math.round(r5)
            goto L4c
        L3e:
            int r5 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r5 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
        L4c:
            if (r5 == 0) goto L52
            float r5 = (float) r5
            r4.setTextSize(r1, r5)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.e.d(android.widget.TextView, int):void");
    }

    public static void e(int i, View view, float f6, float f7) {
        view.setScaleX(f6);
        view.setScaleY(f7);
        view.setVisibility(i);
    }

    public static void f(int i, View view, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f2523k;
        return frameLayout != null ? frameLayout : this.f2525m;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i3 = 0; i3 < iIndexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof e) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconHeight() {
        Y.a aVar = this.f2517D;
        int minimumHeight = aVar != null ? aVar.getMinimumHeight() / 2 : 0;
        return this.f2525m.getMeasuredWidth() + Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        Y.a aVar = this.f2517D;
        int minimumWidth = aVar == null ? 0 : aVar.getMinimumWidth() - this.f2517D.e.b.f2196r.intValue();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.f2525m.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public static void i(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public final void a(float f6, float f7) {
        this.f2519f = f6 - f7;
        this.f2520g = (f7 * 1.0f) / f6;
        this.f2521h = (f6 * 1.0f) / f7;
    }

    public final void b() {
        Drawable rippleDrawable = this.c;
        ColorStateList colorStateList = this.b;
        FrameLayout frameLayout = this.f2523k;
        RippleDrawable rippleDrawable2 = null;
        boolean z6 = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.y && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable2 = new RippleDrawable(AbstractC0615a.b(this.b), null, activeIndicatorDrawable);
                z6 = false;
            } else if (rippleDrawable == null) {
                ColorStateList colorStateList2 = this.b;
                int[] iArr = AbstractC0615a.d;
                int iA = AbstractC0615a.a(colorStateList2, AbstractC0615a.c);
                int[] iArr2 = AbstractC0615a.b;
                rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{iArr, iArr2, StateSet.NOTHING}, new int[]{iA, AbstractC0615a.a(colorStateList2, iArr2), AbstractC0615a.a(colorStateList2, AbstractC0615a.f3956a)}), null, null);
            }
        }
        if (frameLayout != null) {
            ViewCompat.setBackground(frameLayout, rippleDrawable2);
        }
        ViewCompat.setBackground(this, rippleDrawable);
        setDefaultFocusHighlightEnabled(z6);
    }

    public final void c(float f6, float f7) {
        View view = this.f2524l;
        if (view != null) {
            c cVar = this.f2533w;
            cVar.getClass();
            view.setScaleX(W.a.a(0.4f, 1.0f, f6));
            view.setScaleY(cVar.a(f6, f7));
            view.setAlpha(W.a.b(0.0f, 1.0f, f7 == 0.0f ? 0.8f : 0.0f, f7 == 0.0f ? 1.0f : 0.2f, f6));
        }
        this.x = f6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f2523k;
        if (frameLayout != null && this.y) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g(View view) {
        if (this.f2517D != null) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                Y.a aVar = this.f2517D;
                if (aVar != null) {
                    WeakReference weakReference = aVar.f1469m;
                    if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                        WeakReference weakReference2 = aVar.f1469m;
                        (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                    } else {
                        view.getOverlay().remove(aVar);
                    }
                }
            }
            this.f2517D = null;
        }
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f2524l;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public Y.a getBadge() {
        return this.f2517D;
    }

    public int getItemBackgroundResId() {
        return fr.sd.taada.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f2529r;
    }

    public int getItemDefaultMarginResId() {
        return fr.sd.taada.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.f2526n;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.f2526n;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    public final void h(int i) {
        View view = this.f2524l;
        if (view == null) {
            return;
        }
        int iMin = Math.min(this.f2534z, i - (this.C * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.f2516B && this.i == 2) ? iMin : this.f2515A;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f2529r = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.setTooltipText(this, !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        this.f2518a = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.f2529r;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f2529r.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Context context;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Y.a aVar = this.f2517D;
        if (aVar != null && aVar.isVisible()) {
            CharSequence title = this.f2529r.getTitle();
            if (!TextUtils.isEmpty(this.f2529r.getContentDescription())) {
                title = this.f2529r.getContentDescription();
            }
            StringBuilder sb = new StringBuilder();
            sb.append((Object) title);
            sb.append(", ");
            Y.a aVar2 = this.f2517D;
            Object quantityString = null;
            if (aVar2.isVisible()) {
                Y.b bVar = aVar2.e;
                boolean zA = bVar.a();
                BadgeState$State badgeState$State = bVar.b;
                if (!zA) {
                    quantityString = badgeState$State.f2192m;
                } else if (badgeState$State.f2193n != 0 && (context = (Context) aVar2.f1462a.get()) != null) {
                    int iB = aVar2.b();
                    int i = aVar2.f1465h;
                    quantityString = iB <= i ? context.getResources().getQuantityString(badgeState$State.f2193n, aVar2.b(), Integer.valueOf(aVar2.b())) : context.getString(badgeState$State.f2194o, Integer.valueOf(i));
                }
            }
            sb.append(quantityString);
            accessibilityNodeInfo.setContentDescription(sb.toString());
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatWrap.setClickable(false);
            accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(fr.sd.taada.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i4, int i5) {
        super.onSizeChanged(i, i3, i4, i5);
        post(new B.l(i, 1, this));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean prefersCondensedTitle() {
        return false;
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f2524l;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        b();
    }

    public void setActiveIndicatorEnabled(boolean z6) {
        this.y = z6;
        b();
        View view = this.f2524l;
        if (view != null) {
            view.setVisibility(z6 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i) {
        this.f2515A = i;
        h(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.C = i;
        h(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z6) {
        this.f2516B = z6;
    }

    public void setActiveIndicatorWidth(int i) {
        this.f2534z = i;
        h(getWidth());
    }

    public void setBadge(Y.a aVar) {
        Y.a aVar2 = this.f2517D;
        if (aVar2 == aVar) {
            return;
        }
        boolean z6 = aVar2 != null;
        ImageView imageView = this.f2525m;
        if (z6 && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            g(imageView);
        }
        this.f2517D = aVar;
        if (imageView == null || aVar == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        Y.a aVar3 = this.f2517D;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        aVar3.setBounds(rect);
        aVar3.d(imageView, null);
        WeakReference weakReference = aVar3.f1469m;
        if ((weakReference != null ? (FrameLayout) weakReference.get() : null) == null) {
            imageView.getOverlay().add(aVar3);
        } else {
            WeakReference weakReference2 = aVar3.f1469m;
            (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(aVar3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z6) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z6) {
        TextView textView = this.f2528p;
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
        TextView textView2 = this.f2527o;
        textView2.setPivotX(textView2.getWidth() / 2);
        textView2.setPivotY(textView2.getBaseline());
        float f6 = z6 ? 1.0f : 0.0f;
        if (this.y && this.f2518a && ViewCompat.isAttachedToWindow(this)) {
            ValueAnimator valueAnimator = this.f2532v;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f2532v = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.x, f6);
            this.f2532v = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new b(this, f6));
            this.f2532v.setInterpolator(AbstractC0246d.y0(getContext(), fr.sd.taada.R.attr.motionEasingEmphasizedInterpolator, W.a.b));
            this.f2532v.setDuration(AbstractC0246d.x0(getContext(), fr.sd.taada.R.attr.motionDurationLong2, getResources().getInteger(fr.sd.taada.R.integer.material_motion_duration_long_1)));
            this.f2532v.start();
        } else {
            c(f6, f6);
        }
        int i = this.i;
        ViewGroup viewGroup = this.f2526n;
        if (i != -1) {
            if (i == 0) {
                if (z6) {
                    f(this.d, getIconOrContainer(), 49);
                    i(viewGroup, this.e);
                    textView.setVisibility(0);
                } else {
                    f(this.d, getIconOrContainer(), 17);
                    i(viewGroup, 0);
                    textView.setVisibility(4);
                }
                textView2.setVisibility(4);
            } else if (i == 1) {
                i(viewGroup, this.e);
                if (z6) {
                    f((int) (this.d + this.f2519f), getIconOrContainer(), 49);
                    e(0, textView, 1.0f, 1.0f);
                    float f7 = this.f2520g;
                    e(4, textView2, f7, f7);
                } else {
                    f(this.d, getIconOrContainer(), 49);
                    float f8 = this.f2521h;
                    e(4, textView, f8, f8);
                    e(0, textView2, 1.0f, 1.0f);
                }
            } else if (i == 2) {
                f(this.d, getIconOrContainer(), 17);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } else if (this.f2522j) {
            if (z6) {
                f(this.d, getIconOrContainer(), 49);
                i(viewGroup, this.e);
                textView.setVisibility(0);
            } else {
                f(this.d, getIconOrContainer(), 17);
                i(viewGroup, 0);
                textView.setVisibility(4);
            }
            textView2.setVisibility(4);
        } else {
            i(viewGroup, this.e);
            if (z6) {
                f((int) (this.d + this.f2519f), getIconOrContainer(), 49);
                e(0, textView, 1.0f, 1.0f);
                float f9 = this.f2520g;
                e(4, textView2, f9, f9);
            } else {
                f(this.d, getIconOrContainer(), 49);
                float f10 = this.f2521h;
                e(4, textView, f10, f10);
                e(0, textView2, 1.0f, 1.0f);
            }
        }
        refreshDrawableState();
        setSelected(z6);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z6) {
        super.setEnabled(z6);
        this.f2527o.setEnabled(z6);
        this.f2528p.setEnabled(z6);
        this.f2525m.setEnabled(z6);
        if (z6) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable == this.f2531t) {
            return;
        }
        this.f2531t = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.u = drawable;
            ColorStateList colorStateList = this.f2530s;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.f2525m.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        ImageView imageView = this.f2525m;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f2530s = colorStateList;
        if (this.f2529r == null || (drawable = this.u) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorStateList);
        this.u.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemPaddingBottom(int i) {
        if (this.e != i) {
            this.e = i;
            MenuItemImpl menuItemImpl = this.f2529r;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.d != i) {
            this.d = i;
            MenuItemImpl menuItemImpl = this.f2529r;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setItemPosition(int i) {
        this.q = i;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.b = colorStateList;
        b();
    }

    public void setLabelVisibilityMode(int i) {
        if (this.i != i) {
            this.i = i;
            if (this.f2516B && i == 2) {
                this.f2533w = f2514G;
            } else {
                this.f2533w = f2513F;
            }
            h(getWidth());
            MenuItemImpl menuItemImpl = this.f2529r;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z6) {
        if (this.f2522j != z6) {
            this.f2522j = z6;
            MenuItemImpl menuItemImpl = this.f2529r;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void setShortcut(boolean z6, char c) {
    }

    public void setTextAppearanceActive(int i) {
        TextView textView = this.f2528p;
        d(textView, i);
        a(this.f2527o.getTextSize(), textView.getTextSize());
        textView.setTypeface(textView.getTypeface(), 1);
    }

    public void setTextAppearanceInactive(int i) {
        TextView textView = this.f2527o;
        d(textView, i);
        a(textView.getTextSize(), this.f2528p.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f2527o.setTextColor(colorStateList);
            this.f2528p.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f2527o.setText(charSequence);
        this.f2528p.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f2529r;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.f2529r;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.f2529r.getTooltipText();
        }
        TooltipCompat.setTooltipText(this, charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean showsIcon() {
        return true;
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.c = drawable;
        b();
    }
}
