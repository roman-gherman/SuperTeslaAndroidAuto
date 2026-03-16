package androidx.navigation.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/navigation/ui/ActionBarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/ui/AppBarConfiguration;)V", "", "title", "LN1/m;", "setTitle", "(Ljava/lang/CharSequence;)V", "Landroid/graphics/drawable/Drawable;", "icon", "", "contentDescription", "setNavigationIcon", "(Landroid/graphics/drawable/Drawable;I)V", "Landroidx/appcompat/app/AppCompatActivity;", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final AppCompatActivity activity;

    /* JADX WARN: Illegal instructions before constructor call */
    public ActionBarOnDestinationChangedListener(AppCompatActivity activity, AppBarConfiguration configuration) {
        h.f(activity, "activity");
        h.f(configuration, "configuration");
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = activity.getDrawerToggleDelegate();
        if (drawerToggleDelegate == null) {
            throw new IllegalStateException(("Activity " + activity + " does not have an DrawerToggleDelegate set").toString());
        }
        Context actionBarThemedContext = drawerToggleDelegate.getActionBarThemedContext();
        h.e(actionBarThemedContext, "checkNotNull(activity.dr… }.actionBarThemedContext");
        super(actionBarThemedContext, configuration);
        this.activity = activity;
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    public void setNavigationIcon(Drawable icon, int contentDescription) {
        ActionBar supportActionBar = this.activity.getSupportActionBar();
        if (supportActionBar == null) {
            throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
        }
        supportActionBar.setDisplayHomeAsUpEnabled(icon != null);
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = this.activity.getDrawerToggleDelegate();
        if (drawerToggleDelegate != null) {
            drawerToggleDelegate.setActionBarUpIndicator(icon, contentDescription);
            return;
        }
        throw new IllegalStateException(("Activity " + this.activity + " does not have an DrawerToggleDelegate set").toString());
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    public void setTitle(CharSequence title) {
        ActionBar supportActionBar = this.activity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
            return;
        }
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
