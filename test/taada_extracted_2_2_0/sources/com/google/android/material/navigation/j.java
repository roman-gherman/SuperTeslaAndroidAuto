package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* JADX INFO: loaded from: classes.dex */
public final class j implements MenuBuilder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomNavigationView f2557a;

    public j(BottomNavigationView bottomNavigationView) {
        this.f2557a = bottomNavigationView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        BottomNavigationView bottomNavigationView = this.f2557a;
        if (bottomNavigationView.f2560f == null || menuItem.getItemId() != bottomNavigationView.getSelectedItemId()) {
            NavigationBarView$OnItemSelectedListener navigationBarView$OnItemSelectedListener = bottomNavigationView.e;
            return (navigationBarView$OnItemSelectedListener == null || navigationBarView$OnItemSelectedListener.onNavigationItemSelected(menuItem)) ? false : true;
        }
        bottomNavigationView.f2560f.onNavigationItemReselected(menuItem);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
