package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.o;
import fr.sd.taada.R;
import k0.AbstractC0573c;
import n0.C0695a;
import r0.AbstractC0792a;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2559a;
    public final a0.b b;
    public final i c;
    public SupportMenuInflater d;
    public NavigationBarView$OnItemSelectedListener e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NavigationBarView$OnItemReselectedListener f2560f;

    public l(Context context, AttributeSet attributeSet) {
        super(AbstractC0792a.a(context, attributeSet, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView), attributeSet, R.attr.bottomNavigationStyle);
        i iVar = new i();
        iVar.b = false;
        this.c = iVar;
        Context context2 = getContext();
        int[] iArr = V.a.y;
        o.a(context2, attributeSet, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView);
        o.b(context2, attributeSet, iArr, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView, 10, 9);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView);
        f fVar = new f(context2, getClass(), getMaxItemCount());
        this.f2559a = fVar;
        a0.b bVar = new a0.b(context2);
        this.b = bVar;
        iVar.f2556a = bVar;
        iVar.c = 1;
        bVar.setPresenter(iVar);
        fVar.addMenuPresenter(iVar);
        getContext();
        iVar.f2556a.C = fVar;
        if (tintTypedArrayObtainStyledAttributes.hasValue(5)) {
            bVar.setIconTintList(tintTypedArrayObtainStyledAttributes.getColorStateList(5));
        } else {
            bVar.setIconTintList(bVar.b());
        }
        setItemIconSize(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(4, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (tintTypedArrayObtainStyledAttributes.hasValue(10)) {
            setItemTextAppearanceInactive(tintTypedArrayObtainStyledAttributes.getResourceId(10, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(9)) {
            setItemTextAppearanceActive(tintTypedArrayObtainStyledAttributes.getResourceId(9, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(11)) {
            setItemTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(11));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            n0.f fVar2 = new n0.f();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                fVar2.k(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            fVar2.i(context2);
            ViewCompat.setBackground(this, fVar2);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(7)) {
            setItemPaddingTop(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(6)) {
            setItemPaddingBottom(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(1)) {
            setElevation(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), AbstractC0573c.b(context2, tintTypedArrayObtainStyledAttributes, 0));
        setLabelVisibilityMode(tintTypedArrayObtainStyledAttributes.getInteger(12, -1));
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            bVar.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(AbstractC0573c.b(context2, tintTypedArrayObtainStyledAttributes, 8));
        }
        int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(2, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, V.a.x);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setItemActiveIndicatorColor(AbstractC0573c.a(context2, typedArrayObtainStyledAttributes, 2));
            setItemActiveIndicatorShapeAppearance(n0.j.a(context2, typedArrayObtainStyledAttributes.getResourceId(4, 0), 0, new C0695a(0)).a());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(13)) {
            int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(13, 0);
            iVar.b = true;
            getMenuInflater().inflate(resourceId3, fVar);
            iVar.b = false;
            iVar.updateMenuView(true);
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        addView(bVar);
        fVar.setCallback(new j((BottomNavigationView) this));
    }

    private MenuInflater getMenuInflater() {
        if (this.d == null) {
            this.d = new SupportMenuInflater(getContext());
        }
        return this.d;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.b.getItemActiveIndicatorMarginHorizontal();
    }

    public n0.j getItemActiveIndicatorShapeAppearance() {
        return this.b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.b.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f2559a;
    }

    public MenuView getMenuView() {
        return this.b;
    }

    public i getPresenter() {
        return this.c;
    }

    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof n0.f) {
            k1.j.q(this, (n0.f) background);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof NavigationBarView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        NavigationBarView$SavedState navigationBarView$SavedState = (NavigationBarView$SavedState) parcelable;
        super.onRestoreInstanceState(navigationBarView$SavedState.getSuperState());
        this.f2559a.restorePresenterStates(navigationBarView$SavedState.f2509a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        NavigationBarView$SavedState navigationBarView$SavedState = new NavigationBarView$SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        navigationBarView$SavedState.f2509a = bundle;
        this.f2559a.savePresenterStates(bundle);
        return navigationBarView$SavedState;
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        Drawable background = getBackground();
        if (background instanceof n0.f) {
            ((n0.f) background).j(f6);
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z6) {
        this.b.setItemActiveIndicatorEnabled(z6);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.b.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.b.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(n0.j jVar) {
        this.b.setItemActiveIndicatorShapeAppearance(jVar);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.b.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.b.setItemBackgroundRes(i);
    }

    public void setItemIconSize(int i) {
        this.b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i) {
        this.b.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.b.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.b.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.b.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        a0.b bVar = this.b;
        if (bVar.getLabelVisibilityMode() != i) {
            bVar.setLabelVisibilityMode(i);
            this.c.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(NavigationBarView$OnItemReselectedListener navigationBarView$OnItemReselectedListener) {
        this.f2560f = navigationBarView$OnItemReselectedListener;
    }

    public void setOnItemSelectedListener(NavigationBarView$OnItemSelectedListener navigationBarView$OnItemSelectedListener) {
        this.e = navigationBarView$OnItemSelectedListener;
    }

    public void setSelectedItemId(int i) {
        f fVar = this.f2559a;
        MenuItem menuItemFindItem = fVar.findItem(i);
        if (menuItemFindItem == null || fVar.performItemAction(menuItemFindItem, this.c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
