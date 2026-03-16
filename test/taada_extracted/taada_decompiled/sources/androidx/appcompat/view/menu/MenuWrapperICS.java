package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = supportMenu;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.mWrappedObject.addIntentOptions(i, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = getMenuItemWrapper(menuItemArr2[i6]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i3) {
        return this.mWrappedObject.performIdentifierAction(i, i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i3) {
        return this.mWrappedObject.performShortcut(i, keyEvent, i3);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        internalRemoveGroup(i);
        this.mWrappedObject.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        internalRemoveItem(i);
        this.mWrappedObject.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z6, boolean z7) {
        this.mWrappedObject.setGroupCheckable(i, z6, z7);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z6) {
        this.mWrappedObject.setGroupEnabled(i, z6);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z6) {
        this.mWrappedObject.setGroupVisible(i, z6);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z6) {
        this.mWrappedObject.setQwertyMode(z6);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return getMenuItemWrapper(this.mWrappedObject.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i3, int i4, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i3, int i4, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i3, int i4, int i5) {
        return getMenuItemWrapper(this.mWrappedObject.add(i, i3, i4, i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i3, int i4, int i5) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i, i3, i4, i5));
    }
}
