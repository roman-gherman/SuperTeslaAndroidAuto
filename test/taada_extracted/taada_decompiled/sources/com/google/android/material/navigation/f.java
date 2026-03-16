package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes.dex */
public final class f extends MenuBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f2535a;
    public final int b;

    public f(Context context, Class cls, int i) {
        super(context);
        this.f2535a = cls;
        this.b = i;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final MenuItem addInternal(int i, int i3, int i4, CharSequence charSequence) {
        int size = size() + 1;
        int i5 = this.b;
        if (size <= i5) {
            stopDispatchingItemsChanged();
            MenuItem menuItemAddInternal = super.addInternal(i, i3, i4, charSequence);
            if (menuItemAddInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItemAddInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return menuItemAddInternal;
        }
        String simpleName = this.f2535a.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i5);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(B2.b.h(sb, simpleName, "#getMaxItemCount()"));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final SubMenu addSubMenu(int i, int i3, int i4, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f2535a.getSimpleName().concat(" does not support submenus"));
    }
}
