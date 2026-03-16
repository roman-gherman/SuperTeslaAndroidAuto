package com.google.android.material.navigation;

import a0.C0133a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import c4.AbstractC0246d;
import com.google.android.material.datepicker.t;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends ViewGroup implements MenuView {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final int[] f2536D = {R.attr.state_checked};
    public static final int[] E = {-16842910};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f2537A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public i f2538B;
    public MenuBuilder C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoTransition f2539a;
    public final t b;
    public final Pools.SynchronizedPool c;
    public final SparseArray d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e[] f2540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2542h;
    public ColorStateList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f2544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ColorStateList f2545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f2548o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f2549p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SparseArray f2550r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2551s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2552t;
    public boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2554w;
    public int x;
    public n0.j y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2555z;

    public g(Context context) {
        super(context);
        this.c = new Pools.SynchronizedPool(5);
        this.d = new SparseArray(5);
        this.f2541g = 0;
        this.f2542h = 0;
        this.f2550r = new SparseArray(5);
        this.f2551s = -1;
        this.f2552t = -1;
        this.f2555z = false;
        this.f2545l = b();
        if (isInEditMode()) {
            this.f2539a = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.f2539a = autoTransition;
            autoTransition.setOrdering(0);
            autoTransition.setDuration(AbstractC0246d.x0(getContext(), fr.sd.taada.R.attr.motionDurationMedium4, getResources().getInteger(fr.sd.taada.R.integer.material_motion_duration_long_1)));
            autoTransition.setInterpolator(AbstractC0246d.y0(getContext(), fr.sd.taada.R.attr.motionEasingStandard, W.a.b));
            autoTransition.addTransition(new com.google.android.material.internal.m());
        }
        this.b = new t((a0.b) this, 1);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e getNewItem() {
        e eVar = (e) this.c.acquire();
        return eVar == null ? new C0133a(getContext()) : eVar;
    }

    private void setBadgeIfNeeded(e eVar) {
        Y.a aVar;
        int id = eVar.getId();
        if (id == -1 || (aVar = (Y.a) this.f2550r.get(id)) == null) {
            return;
        }
        eVar.setBadge(aVar);
    }

    public final void a() {
        removeAllViews();
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null) {
                    this.c.release(eVar);
                    eVar.g(eVar.f2525m);
                    eVar.f2529r = null;
                    eVar.x = 0.0f;
                    eVar.f2518a = false;
                }
            }
        }
        if (this.C.size() == 0) {
            this.f2541g = 0;
            this.f2542h = 0;
            this.f2540f = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.C.size(); i++) {
            hashSet.add(Integer.valueOf(this.C.getItem(i).getItemId()));
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f2550r;
            if (i3 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i3++;
        }
        this.f2540f = new e[this.C.size()];
        int i4 = this.e;
        boolean z6 = i4 != -1 ? i4 == 0 : this.C.getVisibleItems().size() > 3;
        for (int i5 = 0; i5 < this.C.size(); i5++) {
            this.f2538B.b = true;
            this.C.getItem(i5).setCheckable(true);
            this.f2538B.b = false;
            e newItem = getNewItem();
            this.f2540f[i5] = newItem;
            newItem.setIconTintList(this.i);
            newItem.setIconSize(this.f2543j);
            newItem.setTextColor(this.f2545l);
            newItem.setTextAppearanceInactive(this.f2546m);
            newItem.setTextAppearanceActive(this.f2547n);
            newItem.setTextColor(this.f2544k);
            int i6 = this.f2551s;
            if (i6 != -1) {
                newItem.setItemPaddingTop(i6);
            }
            int i7 = this.f2552t;
            if (i7 != -1) {
                newItem.setItemPaddingBottom(i7);
            }
            newItem.setActiveIndicatorWidth(this.f2553v);
            newItem.setActiveIndicatorHeight(this.f2554w);
            newItem.setActiveIndicatorMarginHorizontal(this.x);
            newItem.setActiveIndicatorDrawable(c());
            newItem.setActiveIndicatorResizeable(this.f2555z);
            newItem.setActiveIndicatorEnabled(this.u);
            Drawable drawable = this.f2548o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.q);
            }
            newItem.setItemRippleColor(this.f2549p);
            newItem.setShifting(z6);
            newItem.setLabelVisibilityMode(this.e);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.C.getItem(i5);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i5);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener((View.OnTouchListener) this.d.get(itemId));
            newItem.setOnClickListener(this.b);
            int i8 = this.f2541g;
            if (i8 != 0 && itemId == i8) {
                this.f2542h = i5;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.C.size() - 1, this.f2542h);
        this.f2542h = iMin;
        this.C.getItem(iMin).setChecked(true);
    }

    public final ColorStateList b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = E;
        return new ColorStateList(new int[][]{iArr, f2536D, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i, defaultColor});
    }

    public final n0.f c() {
        if (this.y == null || this.f2537A == null) {
            return null;
        }
        n0.f fVar = new n0.f(this.y);
        fVar.k(this.f2537A);
        return fVar;
    }

    public SparseArray<Y.a> getBadgeDrawables() {
        return this.f2550r;
    }

    public ColorStateList getIconTintList() {
        return this.i;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f2537A;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.u;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f2554w;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.x;
    }

    public n0.j getItemActiveIndicatorShapeAppearance() {
        return this.y;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f2553v;
    }

    public Drawable getItemBackground() {
        e[] eVarArr = this.f2540f;
        return (eVarArr == null || eVarArr.length <= 0) ? this.f2548o : eVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.q;
    }

    public int getItemIconSize() {
        return this.f2543j;
    }

    public int getItemPaddingBottom() {
        return this.f2552t;
    }

    public int getItemPaddingTop() {
        return this.f2551s;
    }

    public ColorStateList getItemRippleColor() {
        return this.f2549p;
    }

    public int getItemTextAppearanceActive() {
        return this.f2547n;
    }

    public int getItemTextAppearanceInactive() {
        return this.f2546m;
    }

    public ColorStateList getItemTextColor() {
        return this.f2544k;
    }

    public int getLabelVisibilityMode() {
        return this.e;
    }

    public MenuBuilder getMenu() {
        return this.C;
    }

    public int getSelectedItemId() {
        return this.f2541g;
    }

    public int getSelectedItemPosition() {
        return this.f2542h;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void initialize(MenuBuilder menuBuilder) {
        this.C = menuBuilder;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.C.getVisibleItems().size(), false, 1));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f2537A = colorStateList;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z6) {
        this.u = z6;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorEnabled(z6);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.f2554w = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorHeight(i);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.x = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorMarginHorizontal(i);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z6) {
        this.f2555z = z6;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorResizeable(z6);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(n0.j jVar) {
        this.y = jVar;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.f2553v = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorWidth(i);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f2548o = drawable;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.q = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemBackground(i);
            }
        }
    }

    public void setItemIconSize(int i) {
        this.f2543j = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setIconSize(i);
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.f2552t = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemPaddingBottom(i);
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.f2551s = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemPaddingTop(i);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f2549p = colorStateList;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.f2547n = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.f2544k;
                if (colorStateList != null) {
                    eVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f2546m = i;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.f2544k;
                if (colorStateList != null) {
                    eVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f2544k = colorStateList;
        e[] eVarArr = this.f2540f;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.e = i;
    }

    public void setPresenter(i iVar) {
        this.f2538B = iVar;
    }
}
