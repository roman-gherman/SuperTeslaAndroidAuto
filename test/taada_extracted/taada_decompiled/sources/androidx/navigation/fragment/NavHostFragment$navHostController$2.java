package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.SavedStateRegistry;
import android.view.ViewModelStore;
import androidx.core.os.BundleKt;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/navigation/NavHostController;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class NavHostFragment$navHostController$2 extends i implements Function0<NavHostController> {
    final /* synthetic */ NavHostFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostFragment$navHostController$2(NavHostFragment navHostFragment) {
        super(0);
        this.this$0 = navHostFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle invoke$lambda$5$lambda$2(NavHostController this_apply) {
        h.f(this_apply, "$this_apply");
        Bundle bundleSaveState = this_apply.saveState();
        if (bundleSaveState != null) {
            return bundleSaveState;
        }
        Bundle EMPTY = Bundle.EMPTY;
        h.e(EMPTY, "EMPTY");
        return EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle invoke$lambda$5$lambda$4(NavHostFragment this$0) {
        h.f(this$0, "this$0");
        if (this$0.graphId != 0) {
            return BundleKt.bundleOf(new N1.e(NavHostFragment.KEY_GRAPH_ID, Integer.valueOf(this$0.graphId)));
        }
        Bundle bundle = Bundle.EMPTY;
        h.e(bundle, "{\n                    Bu…e.EMPTY\n                }");
        return bundle;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final NavHostController invoke() {
        Context context = this.this$0.getContext();
        if (context == null) {
            throw new IllegalStateException("NavController cannot be created before the fragment is attached");
        }
        final NavHostController navHostController = new NavHostController(context);
        final NavHostFragment navHostFragment = this.this$0;
        navHostController.setLifecycleOwner(navHostFragment);
        ViewModelStore viewModelStore = navHostFragment.getViewModelStore();
        h.e(viewModelStore, "viewModelStore");
        navHostController.setViewModelStore(viewModelStore);
        navHostFragment.onCreateNavHostController(navHostController);
        Bundle bundleConsumeRestoredStateForKey = navHostFragment.getSavedStateRegistry().consumeRestoredStateForKey("android-support-nav:fragment:navControllerState");
        if (bundleConsumeRestoredStateForKey != null) {
            navHostController.restoreState(bundleConsumeRestoredStateForKey);
        }
        final int i = 0;
        navHostFragment.getSavedStateRegistry().registerSavedStateProvider("android-support-nav:fragment:navControllerState", new SavedStateRegistry.SavedStateProvider() { // from class: androidx.navigation.fragment.e
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                switch (i) {
                    case 0:
                        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$2((NavHostController) navHostController);
                    default:
                        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$4((NavHostFragment) navHostController);
                }
            }
        });
        Bundle bundleConsumeRestoredStateForKey2 = navHostFragment.getSavedStateRegistry().consumeRestoredStateForKey(NavHostFragment.KEY_GRAPH_ID);
        if (bundleConsumeRestoredStateForKey2 != null) {
            navHostFragment.graphId = bundleConsumeRestoredStateForKey2.getInt(NavHostFragment.KEY_GRAPH_ID);
        }
        final int i3 = 1;
        navHostFragment.getSavedStateRegistry().registerSavedStateProvider(NavHostFragment.KEY_GRAPH_ID, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.navigation.fragment.e
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                switch (i3) {
                    case 0:
                        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$2((NavHostController) navHostFragment);
                    default:
                        return NavHostFragment$navHostController$2.invoke$lambda$5$lambda$4((NavHostFragment) navHostFragment);
                }
            }
        });
        if (navHostFragment.graphId != 0) {
            navHostController.setGraph(navHostFragment.graphId);
            return navHostController;
        }
        Bundle arguments = navHostFragment.getArguments();
        int i4 = arguments != null ? arguments.getInt(NavHostFragment.KEY_GRAPH_ID) : 0;
        Bundle bundle = arguments != null ? arguments.getBundle(NavHostFragment.KEY_START_DESTINATION_ARGS) : null;
        if (i4 != 0) {
            navHostController.setGraph(i4, bundle);
        }
        return navHostController;
    }
}
