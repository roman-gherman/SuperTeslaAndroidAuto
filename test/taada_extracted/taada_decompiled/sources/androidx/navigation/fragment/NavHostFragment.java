package androidx.navigation.fragment;

import a.AbstractC0132a;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0015¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016H\u0015¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\"\u0010#J)\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\nH\u0017¢\u0006\u0004\b)\u0010\rJ\u000f\u0010*\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u0010\u0004R\u001b\u0010\u000f\u001a\u00020\u000e8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u0010\u0013\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavHost;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "LN1/m;", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/navigation/NavHostController;", "navHostController", "onCreateNavHostController", "(Landroidx/navigation/NavHostController;)V", "Landroidx/navigation/NavController;", "navController", "onCreateNavController", "(Landroidx/navigation/NavController;)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "createFragmentNavigator", "()Landroidx/navigation/Navigator;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/util/AttributeSet;", "attrs", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "navHostController$delegate", "Lkotlin/Lazy;", "getNavHostController$navigation_fragment_release", "()Landroidx/navigation/NavHostController;", "viewParent", "Landroid/view/View;", "", "graphId", "I", "", "defaultNavHost", "Z", "getContainerId", "()I", "containerId", "getNavController", "()Landroidx/navigation/NavController;", "Companion", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavHostFragment extends Fragment implements NavHost {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
    public static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
    public static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean defaultNavHost;
    private int graphId;

    /* JADX INFO: renamed from: navHostController$delegate, reason: from kotlin metadata */
    private final Lazy navHostController = AbstractC0132a.M(new NavHostFragment$navHostController$2(this));
    private View viewParent;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment$Companion;", "", "()V", "KEY_DEFAULT_NAV_HOST", "", "KEY_GRAPH_ID", "KEY_NAV_CONTROLLER_STATE", "KEY_START_DESTINATION_ARGS", "create", "Landroidx/navigation/fragment/NavHostFragment;", "graphResId", "", "startDestinationArgs", "Landroid/os/Bundle;", "findNavController", "Landroidx/navigation/NavController;", "fragment", "Landroidx/fragment/app/Fragment;", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.d dVar) {
            this();
        }

        public static /* synthetic */ NavHostFragment create$default(Companion companion, int i, Bundle bundle, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                bundle = null;
            }
            return companion.create(i, bundle);
        }

        @JvmStatic
        public final NavHostFragment create(int i) {
            return create$default(this, i, null, 2, null);
        }

        @JvmStatic
        public final NavController findNavController(Fragment fragment) {
            Dialog dialog;
            Window window;
            h.f(fragment, "fragment");
            for (Fragment parentFragment = fragment; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment instanceof NavHostFragment) {
                    return ((NavHostFragment) parentFragment).getNavHostController$navigation_fragment_release();
                }
                Fragment primaryNavigationFragment = parentFragment.getParentFragmentManager().getPrimaryNavigationFragment();
                if (primaryNavigationFragment instanceof NavHostFragment) {
                    return ((NavHostFragment) primaryNavigationFragment).getNavHostController$navigation_fragment_release();
                }
            }
            View view = fragment.getView();
            if (view != null) {
                return Navigation.findNavController(view);
            }
            View decorView = null;
            DialogFragment dialogFragment = fragment instanceof DialogFragment ? (DialogFragment) fragment : null;
            if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
                decorView = window.getDecorView();
            }
            if (decorView != null) {
                return Navigation.findNavController(decorView);
            }
            throw new IllegalStateException(androidx.constraintlayout.core.motion.a.o("Fragment ", fragment, " does not have a NavController set"));
        }

        private Companion() {
        }

        @JvmStatic
        public final NavHostFragment create(int graphResId, Bundle startDestinationArgs) {
            Bundle bundle;
            if (graphResId != 0) {
                bundle = new Bundle();
                bundle.putInt(NavHostFragment.KEY_GRAPH_ID, graphResId);
            } else {
                bundle = null;
            }
            if (startDestinationArgs != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle(NavHostFragment.KEY_START_DESTINATION_ARGS, startDestinationArgs);
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle != null) {
                navHostFragment.setArguments(bundle);
            }
            return navHostFragment;
        }
    }

    @JvmStatic
    public static final NavHostFragment create(int i) {
        return INSTANCE.create(i);
    }

    @JvmStatic
    public static final NavController findNavController(Fragment fragment) {
        return INSTANCE.findNavController(fragment);
    }

    private final int getContainerId() {
        int id = getId();
        return (id == 0 || id == -1) ? R.id.nav_host_fragment_container : id;
    }

    @Deprecated(message = "Use {@link #onCreateNavController(NavController)}")
    public Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        Context contextRequireContext = requireContext();
        h.e(contextRequireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        h.e(childFragmentManager, "childFragmentManager");
        return new FragmentNavigator(contextRequireContext, childFragmentManager, getContainerId());
    }

    @Override // androidx.navigation.NavHost
    public final NavController getNavController() {
        return getNavHostController$navigation_fragment_release();
    }

    public final NavHostController getNavHostController$navigation_fragment_release() {
        return (NavHostController) this.navHostController.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        h.f(context, "context");
        super.onAttach(context);
        if (this.defaultNavHost) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        getNavHostController$navigation_fragment_release();
        if (savedInstanceState != null && savedInstanceState.getBoolean(KEY_DEFAULT_NAV_HOST, false)) {
            this.defaultNavHost = true;
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
        super.onCreate(savedInstanceState);
    }

    @Deprecated(message = "Override {@link #onCreateNavHostController(NavHostController)} to gain\n      access to the full {@link NavHostController} that is created by this NavHostFragment.")
    public void onCreateNavController(NavController navController) {
        h.f(navController, "navController");
        NavigatorProvider navigatorProvider = navController.get_navigatorProvider();
        Context contextRequireContext = requireContext();
        h.e(contextRequireContext, "requireContext()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        h.e(childFragmentManager, "childFragmentManager");
        navigatorProvider.addNavigator(new DialogFragmentNavigator(contextRequireContext, childFragmentManager));
        navController.get_navigatorProvider().addNavigator(createFragmentNavigator());
    }

    public void onCreateNavHostController(NavHostController navHostController) {
        h.f(navHostController, "navHostController");
        onCreateNavController(navHostController);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.f(inflater, "inflater");
        Context context = inflater.getContext();
        h.e(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(getContainerId());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.viewParent;
        if (view != null && Navigation.findNavController(view) == getNavHostController$navigation_fragment_release()) {
            Navigation.setViewNavController(view, null);
        }
        this.viewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        h.f(context, "context");
        h.f(attrs, "attrs");
        super.onInflate(context, attrs, savedInstanceState);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, androidx.navigation.R.styleable.NavHost);
        h.e(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.graphId = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attrs, R.styleable.NavHostFragment);
        h.e(typedArrayObtainStyledAttributes2, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (typedArrayObtainStyledAttributes2.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.defaultNavHost = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        h.f(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.defaultNavHost) {
            outState.putBoolean(KEY_DEFAULT_NAV_HOST, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        h.f(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
        }
        Navigation.setViewNavController(view, getNavHostController$navigation_fragment_release());
        if (view.getParent() != null) {
            Object parent = view.getParent();
            h.d(parent, "null cannot be cast to non-null type android.view.View");
            View view2 = (View) parent;
            this.viewParent = view2;
            if (view2.getId() == getId()) {
                View view3 = this.viewParent;
                h.c(view3);
                Navigation.setViewNavController(view3, getNavHostController$navigation_fragment_release());
            }
        }
    }

    @JvmStatic
    public static final NavHostFragment create(int i, Bundle bundle) {
        return INSTANCE.create(i, bundle);
    }
}
