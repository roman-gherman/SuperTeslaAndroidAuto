package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener;
import com.google.android.material.navigation.l;
import com.google.android.material.navigation.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\fJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u000f\u0010\u0013J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0017\u0010\u0019J)\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001eJ1\u0010\u001c\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u001c\u0010!J1\u0010\u001c\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\"J\u001f\u0010\u001c\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010%J'\u0010\u001c\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001c\u0010&J\u001d\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010)2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b*\u0010+J\u001f\u0010\u001c\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010.J'\u0010\u001c\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001c\u0010/J\u001d\u00105\u001a\u00020\b*\u0002002\b\b\u0001\u00102\u001a\u000201H\u0001¢\u0006\u0004\b3\u00104R\u0014\u00107\u001a\u0002068\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108¨\u00069"}, d2 = {"Landroidx/navigation/ui/NavigationUI;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/view/MenuItem;", "item", "Landroidx/navigation/NavController;", "navController", "", "onNavDestinationSelected", "(Landroid/view/MenuItem;Landroidx/navigation/NavController;)Z", "saveState", "(Landroid/view/MenuItem;Landroidx/navigation/NavController;Z)Z", "Landroidx/customview/widget/Openable;", "openableLayout", "navigateUp", "(Landroidx/navigation/NavController;Landroidx/customview/widget/Openable;)Z", "Landroidx/navigation/ui/AppBarConfiguration;", "configuration", "(Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)Z", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "LN1/m;", "setupActionBarWithNavController", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/NavController;Landroidx/customview/widget/Openable;)V", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)V", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "setupWithNavController", "(Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/NavController;Landroidx/customview/widget/Openable;)V", "(Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)V", "LX/a;", "collapsingToolbarLayout", "(LX/a;Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/NavController;Landroidx/customview/widget/Openable;)V", "(LX/a;Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/NavController;Landroidx/navigation/ui/AppBarConfiguration;)V", "Lcom/google/android/material/navigation/m;", "navigationView", "(Lcom/google/android/material/navigation/m;Landroidx/navigation/NavController;)V", "(Lcom/google/android/material/navigation/m;Landroidx/navigation/NavController;Z)V", "Landroid/view/View;", "view", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "findBottomSheetBehavior", "(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/navigation/l;", "navigationBarView", "(Lcom/google/android/material/navigation/l;Landroidx/navigation/NavController;)V", "(Lcom/google/android/material/navigation/l;Landroidx/navigation/NavController;Z)V", "Landroidx/navigation/NavDestination;", "", "destId", "matchDestination$navigation_ui_release", "(Landroidx/navigation/NavDestination;I)Z", "matchDestination", "", "TAG", "Ljava/lang/String;", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavigationUI {
    public static final NavigationUI INSTANCE = new NavigationUI();
    private static final String TAG = "NavigationUI";

    /* JADX INFO: renamed from: androidx.navigation.ui.NavigationUI$setupWithNavController$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"androidx/navigation/ui/NavigationUI$setupWithNavController$4", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "LN1/m;", "onDestinationChanged", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass4 implements NavController.OnDestinationChangedListener {
        final /* synthetic */ NavController $navController;
        final /* synthetic */ WeakReference<m> $weakReference;

        public AnonymousClass4(WeakReference<m> weakReference, NavController navController) {
            this.$weakReference = weakReference;
            this.$navController = navController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {
            h.f(controller, "controller");
            h.f(destination, "destination");
            if (this.$weakReference.get() != null) {
                throw new ClassCastException();
            }
            this.$navController.removeOnDestinationChangedListener(this);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.ui.NavigationUI$setupWithNavController$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"androidx/navigation/ui/NavigationUI$setupWithNavController$7", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "LN1/m;", "onDestinationChanged", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "navigation-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass7 implements NavController.OnDestinationChangedListener {
        final /* synthetic */ NavController $navController;
        final /* synthetic */ WeakReference<m> $weakReference;

        public AnonymousClass7(WeakReference<m> weakReference, NavController navController) {
            this.$weakReference = weakReference;
            this.$navController = navController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {
            h.f(controller, "controller");
            h.f(destination, "destination");
            if (this.$weakReference.get() != null) {
                throw new ClassCastException();
            }
            this.$navController.removeOnDestinationChangedListener(this);
        }
    }

    private NavigationUI() {
    }

    @JvmStatic
    public static final BottomSheetBehavior<?> findBottomSheetBehavior(View view) {
        h.f(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            return null;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            return findBottomSheetBehavior((View) parent);
        }
        return null;
    }

    @JvmStatic
    public static final boolean matchDestination$navigation_ui_release(NavDestination navDestination, int i) {
        h.f(navDestination, "<this>");
        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(navDestination).iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean navigateUp(NavController navController, Openable openableLayout) {
        h.f(navController, "navController");
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openableLayout).build());
    }

    @JvmStatic
    public static final boolean onNavDestinationSelected(MenuItem item, NavController navController) {
        h.f(item, "item");
        h.f(navController, "navController");
        NavOptions.Builder restoreState = new NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(true);
        NavDestination currentDestination = navController.getCurrentDestination();
        h.c(currentDestination);
        NavGraph parent = currentDestination.getParent();
        h.c(parent);
        if (parent.findNode(item.getItemId()) instanceof ActivityNavigator.Destination) {
            restoreState.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        } else {
            restoreState.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
        }
        if ((item.getOrder() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            restoreState.setPopUpTo(NavGraph.INSTANCE.findStartDestination(navController.getGraph()).getId(), false, true);
        }
        try {
            navController.navigate(item.getItemId(), (Bundle) null, restoreState.build());
            NavDestination currentDestination2 = navController.getCurrentDestination();
            if (currentDestination2 != null) {
                if (matchDestination$navigation_ui_release(currentDestination2, item.getItemId())) {
                    return true;
                }
            }
            return false;
        } catch (IllegalArgumentException unused) {
            NavDestination.INSTANCE.getDisplayName(navController.getContext(), item.getItemId());
            Objects.toString(navController.getCurrentDestination());
            return false;
        }
    }

    @JvmStatic
    public static final void setupActionBarWithNavController(AppCompatActivity activity, NavController navController) {
        h.f(activity, "activity");
        h.f(navController, "navController");
        setupActionBarWithNavController$default(activity, navController, null, 4, null);
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(X.a collapsingToolbarLayout, Toolbar toolbar, NavController navController) {
        h.f(collapsingToolbarLayout, "collapsingToolbarLayout");
        throw null;
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWithNavController$lambda$1(NavController navController, AppBarConfiguration configuration, View view) {
        h.f(navController, "$navController");
        h.f(configuration, "$configuration");
        navigateUp(navController, configuration);
    }

    private static final void setupWithNavController$lambda$2(NavController navController, AppBarConfiguration configuration, View view) {
        h.f(navController, "$navController");
        h.f(configuration, "$configuration");
        navigateUp(navController, configuration);
    }

    private static final boolean setupWithNavController$lambda$3(NavController navController, m navigationView, MenuItem menuItem) {
        h.f(navController, "$navController");
        h.f(navigationView, "$navigationView");
        throw null;
    }

    private static final boolean setupWithNavController$lambda$5(NavController navController, boolean z6, m navigationView, MenuItem menuItem) {
        h.f(navController, "$navController");
        h.f(navigationView, "$navigationView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$6(NavController navController, MenuItem item) {
        h.f(navController, "$navController");
        h.f(item, "item");
        return onNavDestinationSelected(item, navController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$8(NavController navController, boolean z6, MenuItem item) {
        h.f(navController, "$navController");
        h.f(item, "item");
        return onNavDestinationSelected(item, navController, z6);
    }

    @JvmStatic
    public static final void setupActionBarWithNavController(AppCompatActivity activity, NavController navController, Openable openableLayout) {
        h.f(activity, "activity");
        h.f(navController, "navController");
        setupActionBarWithNavController(activity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openableLayout).build());
    }

    @JvmStatic
    public static final void setupWithNavController(X.a collapsingToolbarLayout, Toolbar toolbar, NavController navController, Openable openableLayout) {
        h.f(collapsingToolbarLayout, "collapsingToolbarLayout");
        throw null;
    }

    @JvmStatic
    public static final void setupWithNavController(X.a collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration configuration) {
        h.f(collapsingToolbarLayout, "collapsingToolbarLayout");
        throw null;
    }

    public static /* synthetic */ void setupWithNavController$default(X.a aVar, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 8) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(aVar, toolbar, navController, appBarConfiguration);
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, NavController navController) {
        h.f(toolbar, "toolbar");
        h.f(navController, "navController");
        setupWithNavController$default(toolbar, navController, null, 4, null);
    }

    @JvmStatic
    public static final boolean navigateUp(NavController navController, AppBarConfiguration configuration) {
        h.f(navController, "navController");
        h.f(configuration, "configuration");
        Openable openableLayout = configuration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        if (openableLayout != null && currentDestination != null && configuration.isTopLevelDestination(currentDestination)) {
            openableLayout.open();
            return true;
        }
        if (navController.navigateUp()) {
            return true;
        }
        AppBarConfiguration.OnNavigateUpListener fallbackOnNavigateUpListener = configuration.getFallbackOnNavigateUpListener();
        if (fallbackOnNavigateUpListener != null) {
            return fallbackOnNavigateUpListener.onNavigateUp();
        }
        return false;
    }

    @JvmStatic
    public static final void setupWithNavController(m navigationView, NavController navController) {
        h.f(navigationView, "navigationView");
        throw null;
    }

    @JvmStatic
    public static final void setupActionBarWithNavController(AppCompatActivity activity, NavController navController, AppBarConfiguration configuration) {
        h.f(activity, "activity");
        h.f(navController, "navController");
        h.f(configuration, "configuration");
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(activity, configuration));
    }

    @NavigationUiSaveStateControl
    @JvmStatic
    public static final void setupWithNavController(m navigationView, NavController navController, boolean saveState) {
        h.f(navigationView, "navigationView");
        throw null;
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, NavController navController, Openable openableLayout) {
        h.f(toolbar, "toolbar");
        h.f(navController, "navController");
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openableLayout).build());
    }

    @JvmStatic
    public static final void setupWithNavController(Toolbar toolbar, NavController navController, AppBarConfiguration configuration) {
        h.f(toolbar, "toolbar");
        h.f(navController, "navController");
        h.f(configuration, "configuration");
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, configuration));
        toolbar.setNavigationOnClickListener(new b(0, navController, configuration));
    }

    @JvmStatic
    public static final void setupWithNavController(l navigationBarView, final NavController navController) {
        h.f(navigationBarView, "navigationBarView");
        h.f(navController, "navController");
        navigationBarView.setOnItemSelectedListener(new R0.a(navController, 5));
        final WeakReference weakReference = new WeakReference(navigationBarView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.setupWithNavController.9
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {
                h.f(controller, "controller");
                h.f(destination, "destination");
                l lVar = weakReference.get();
                if (lVar == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                if (destination instanceof FloatingWindow) {
                    return;
                }
                Menu menu = lVar.getMenu();
                h.e(menu, "view.menu");
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    h.b(item, "getItem(index)");
                    if (NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }

    @NavigationUiSaveStateControl
    @JvmStatic
    public static final void setupWithNavController(l navigationBarView, final NavController navController, final boolean saveState) {
        h.f(navigationBarView, "navigationBarView");
        h.f(navController, "navController");
        if (!saveState) {
            navigationBarView.setOnItemSelectedListener(new NavigationBarView$OnItemSelectedListener() { // from class: androidx.navigation.ui.a
                @Override // com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener
                public final boolean onNavigationItemSelected(MenuItem menuItem) {
                    return NavigationUI.setupWithNavController$lambda$8(navController, saveState, menuItem);
                }
            });
            final WeakReference weakReference = new WeakReference(navigationBarView);
            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.setupWithNavController.12
                @Override // androidx.navigation.NavController.OnDestinationChangedListener
                public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {
                    h.f(controller, "controller");
                    h.f(destination, "destination");
                    l lVar = weakReference.get();
                    if (lVar == null) {
                        navController.removeOnDestinationChangedListener(this);
                        return;
                    }
                    if (destination instanceof FloatingWindow) {
                        return;
                    }
                    Menu menu = lVar.getMenu();
                    h.e(menu, "view.menu");
                    int size = menu.size();
                    for (int i = 0; i < size; i++) {
                        MenuItem item = menu.getItem(i);
                        h.b(item, "getItem(index)");
                        if (NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId())) {
                            item.setChecked(true);
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
    }

    @NavigationUiSaveStateControl
    @JvmStatic
    public static final boolean onNavDestinationSelected(MenuItem item, NavController navController, boolean saveState) {
        h.f(item, "item");
        h.f(navController, "navController");
        if (!saveState) {
            NavOptions.Builder launchSingleTop = new NavOptions.Builder().setLaunchSingleTop(true);
            NavDestination currentDestination = navController.getCurrentDestination();
            h.c(currentDestination);
            NavGraph parent = currentDestination.getParent();
            h.c(parent);
            if (parent.findNode(item.getItemId()) instanceof ActivityNavigator.Destination) {
                launchSingleTop.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
            } else {
                launchSingleTop.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
            }
            if ((item.getOrder() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                NavOptions.Builder.setPopUpTo$default(launchSingleTop, NavGraph.INSTANCE.findStartDestination(navController.getGraph()).getId(), false, false, 4, (Object) null);
            }
            try {
                navController.navigate(item.getItemId(), (Bundle) null, launchSingleTop.build());
                NavDestination currentDestination2 = navController.getCurrentDestination();
                if (currentDestination2 != null) {
                    if (matchDestination$navigation_ui_release(currentDestination2, item.getItemId())) {
                        return true;
                    }
                }
                return false;
            } catch (IllegalArgumentException unused) {
                NavDestination.INSTANCE.getDisplayName(navController.getContext(), item.getItemId());
                Objects.toString(navController.getCurrentDestination());
                return false;
            }
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
    }
}
