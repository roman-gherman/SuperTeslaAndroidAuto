package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends e implements MenuView.ItemView {
    public static final int[] q = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2442h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CheckedTextView f2443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f2444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MenuItemImpl f2445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ColorStateList f2446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f2448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.google.android.material.datepicker.r f2449p;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.google.android.material.datepicker.r rVar = new com.google.android.material.datepicker.r(this, 3);
        this.f2449p = rVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(fr.sd.taada.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(fr.sd.taada.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(fr.sd.taada.R.id.design_menu_item_text);
        this.f2443j = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, rVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f2444k == null) {
                this.f2444k = (FrameLayout) ((ViewStub) findViewById(fr.sd.taada.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f2444k.removeAllViews();
            this.f2444k.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f2445l;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl, int i) {
        StateListDrawable stateListDrawable;
        this.f2445l = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(q, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            ViewCompat.setBackground(this, stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        CharSequence title = this.f2445l.getTitle();
        CheckedTextView checkedTextView = this.f2443j;
        if (title == null && this.f2445l.getIcon() == null && this.f2445l.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.f2444k;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.f2444k.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.f2444k;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.f2444k.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.f2445l;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f2445l.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z6) {
        refreshDrawableState();
        if (this.i != z6) {
            this.i = z6;
            this.f2449p.sendAccessibilityEvent(this.f2443j, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z6) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.f2443j;
        checkedTextView.setChecked(z6);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), z6 ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f2447n) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.f2446m);
            }
            int i = this.f2441g;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f2442h) {
            if (this.f2448o == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), fr.sd.taada.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.f2448o = drawable2;
                if (drawable2 != null) {
                    int i3 = this.f2441g;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.f2448o;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f2443j, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f2443j.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.f2441g = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f2446m = colorStateList;
        this.f2447n = colorStateList != null;
        MenuItemImpl menuItemImpl = this.f2445l;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.f2443j.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z6) {
        this.f2442h = z6;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void setShortcut(boolean z6, char c) {
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f2443j, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f2443j.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f2443j.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean showsIcon() {
        return true;
    }
}
