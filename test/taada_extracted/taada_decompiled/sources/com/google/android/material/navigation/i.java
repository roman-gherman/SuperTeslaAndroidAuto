package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.google.android.material.badge.BadgeState$State;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class i implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0.b f2556a;
    public boolean b;
    public int c;

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return this.c;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final MenuView getMenuView(ViewGroup viewGroup) {
        return this.f2556a;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.f2556a.C = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z6) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseArray;
        if (parcelable instanceof NavigationBarPresenter$SavedState) {
            a0.b bVar = this.f2556a;
            NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = (NavigationBarPresenter$SavedState) parcelable;
            int i = navigationBarPresenter$SavedState.f2508a;
            int size = bVar.C.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                MenuItem item = bVar.C.getItem(i3);
                if (i == item.getItemId()) {
                    bVar.f2541g = i;
                    bVar.f2542h = i3;
                    item.setChecked(true);
                    break;
                }
                i3++;
            }
            Context context = this.f2556a.getContext();
            ParcelableSparseArray parcelableSparseArray = navigationBarPresenter$SavedState.b;
            SparseArray sparseArray2 = new SparseArray(parcelableSparseArray.size());
            for (int i4 = 0; i4 < parcelableSparseArray.size(); i4++) {
                int iKeyAt = parcelableSparseArray.keyAt(i4);
                BadgeState$State badgeState$State = (BadgeState$State) parcelableSparseArray.valueAt(i4);
                if (badgeState$State == null) {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
                sparseArray2.put(iKeyAt, new Y.a(context, badgeState$State));
            }
            a0.b bVar2 = this.f2556a;
            bVar2.getClass();
            int i5 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = bVar2.f2550r;
                if (i5 >= size2) {
                    break;
                }
                int iKeyAt2 = sparseArray2.keyAt(i5);
                if (sparseArray.indexOfKey(iKeyAt2) < 0) {
                    sparseArray.append(iKeyAt2, (Y.a) sparseArray2.get(iKeyAt2));
                }
                i5++;
            }
            e[] eVarArr = bVar2.f2540f;
            if (eVarArr != null) {
                for (e eVar : eVarArr) {
                    eVar.setBadge((Y.a) sparseArray.get(eVar.getId()));
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        NavigationBarPresenter$SavedState navigationBarPresenter$SavedState = new NavigationBarPresenter$SavedState();
        navigationBarPresenter$SavedState.f2508a = this.f2556a.getSelectedItemId();
        SparseArray<Y.a> badgeDrawables = this.f2556a.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i = 0; i < badgeDrawables.size(); i++) {
            int iKeyAt = badgeDrawables.keyAt(i);
            Y.a aVarValueAt = badgeDrawables.valueAt(i);
            if (aVarValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, aVarValueAt.e.f1470a);
        }
        navigationBarPresenter$SavedState.b = parcelableSparseArray;
        return navigationBarPresenter$SavedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView(boolean z6) {
        AutoTransition autoTransition;
        if (this.b) {
            return;
        }
        if (z6) {
            this.f2556a.a();
            return;
        }
        a0.b bVar = this.f2556a;
        MenuBuilder menuBuilder = bVar.C;
        if (menuBuilder == null || bVar.f2540f == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != bVar.f2540f.length) {
            bVar.a();
            return;
        }
        int i = bVar.f2541g;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = bVar.C.getItem(i3);
            if (item.isChecked()) {
                bVar.f2541g = item.getItemId();
                bVar.f2542h = i3;
            }
        }
        if (i != bVar.f2541g && (autoTransition = bVar.f2539a) != null) {
            TransitionManager.beginDelayedTransition(bVar, autoTransition);
        }
        int i4 = bVar.e;
        boolean z7 = i4 != -1 ? i4 == 0 : bVar.C.getVisibleItems().size() > 3;
        for (int i5 = 0; i5 < size; i5++) {
            bVar.f2538B.b = true;
            bVar.f2540f[i5].setLabelVisibilityMode(bVar.e);
            bVar.f2540f[i5].setShifting(z7);
            bVar.f2540f[i5].initialize((MenuItemImpl) bVar.C.getItem(i5), 0);
            bVar.f2538B.b = false;
        }
    }
}
