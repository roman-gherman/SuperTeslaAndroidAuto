package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: classes.dex */
public final class MenuCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static void setGroupDividerEnabled(Menu menu, boolean z6) {
            menu.setGroupDividerEnabled(z6);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(Menu menu, boolean z6) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(z6);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setGroupDividerEnabled(menu, z6);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }
}
