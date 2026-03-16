package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z6);

        void setChecked(boolean z6);

        void setEnabled(boolean z6);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z6, char c);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
