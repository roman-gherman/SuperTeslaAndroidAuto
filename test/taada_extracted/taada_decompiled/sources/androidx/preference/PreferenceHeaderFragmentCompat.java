package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.C0166ViewTreeOnBackPressedDispatcherOwner;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.OnBackPressedCallback;
import android.view.OnBackPressedDispatcher;
import android.view.OnBackPressedDispatcherOwner;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\r\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010!\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0017¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0012H&¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0017¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0011\u00101\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Landroidx/preference/PreferenceHeaderFragmentCompat;", "Landroidx/fragment/app/Fragment;", "Landroidx/preference/PreferenceFragmentCompat$OnPreferenceStartFragmentCallback;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "buildContentView", "(Landroid/view/LayoutInflater;)Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "Landroidx/preference/Preference;", "header", "LN1/m;", "openPreferenceHeader", "(Landroidx/preference/Preference;)V", "Landroid/content/Intent;", "intent", "(Landroid/content/Intent;)V", "Landroidx/preference/PreferenceFragmentCompat;", "caller", "pref", "", "onPreferenceStartFragment", "(Landroidx/preference/PreferenceFragmentCompat;Landroidx/preference/Preference;)Z", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onCreatePreferenceHeader", "()Landroidx/preference/PreferenceFragmentCompat;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewStateRestored", "(Landroid/os/Bundle;)V", "onCreateInitialDetailFragment", "()Landroidx/fragment/app/Fragment;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "getSlidingPaneLayout", "()Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "slidingPaneLayout", "InnerOnBackPressedCallback", "preference_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    private OnBackPressedCallback onBackPressedCallback;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/preference/PreferenceHeaderFragmentCompat$InnerOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$PanelSlideListener;", "Landroidx/preference/PreferenceHeaderFragmentCompat;", "caller", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/preference/PreferenceHeaderFragmentCompat;)V", "LN1/m;", "handleOnBackPressed", "()V", "Landroid/view/View;", "panel", "", "slideOffset", "onPanelSlide", "(Landroid/view/View;F)V", "onPanelOpened", "(Landroid/view/View;)V", "onPanelClosed", "Landroidx/preference/PreferenceHeaderFragmentCompat;", "preference_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        private final PreferenceHeaderFragmentCompat caller;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(PreferenceHeaderFragmentCompat caller) {
            super(true);
            h.f(caller, "caller");
            this.caller = caller;
            caller.getSlidingPaneLayout().addPanelSlideListener(this);
        }

        @Override // android.view.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.caller.getSlidingPaneLayout().closePane();
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View panel) {
            h.f(panel, "panel");
            setEnabled(false);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View panel) {
            h.f(panel, "panel");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View panel, float slideOffset) {
            h.f(panel, "panel");
        }
    }

    private final SlidingPaneLayout buildContentView(LayoutInflater inflater) {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(inflater.getContext());
        slidingPaneLayout.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(inflater.getContext());
        fragmentContainerView.setId(R.id.preferences_header);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_header_width), -1);
        layoutParams.weight = getResources().getInteger(R.integer.preferences_header_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(inflater.getContext());
        fragmentContainerView2.setId(R.id.preferences_detail);
        SlidingPaneLayout.LayoutParams layoutParams2 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width), -1);
        layoutParams2.weight = getResources().getInteger(R.integer.preferences_detail_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView2, layoutParams2);
        return slidingPaneLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-10, reason: not valid java name */
    public static final void m26onViewCreated$lambda10(PreferenceHeaderFragmentCompat this$0) {
        h.f(this$0, "this$0");
        OnBackPressedCallback onBackPressedCallback = this$0.onBackPressedCallback;
        h.c(onBackPressedCallback);
        onBackPressedCallback.setEnabled(this$0.getChildFragmentManager().getBackStackEntryCount() == 0);
    }

    private final void openPreferenceHeader(Preference header) {
        if (header.getFragment() == null) {
            openPreferenceHeader(header.getIntent());
            return;
        }
        String fragment = header.getFragment();
        Fragment fragmentInstantiate = fragment == null ? null : getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), fragment);
        if (fragmentInstantiate != null) {
            fragmentInstantiate.setArguments(header.getExtras());
        }
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = getChildFragmentManager().getBackStackEntryAt(0);
            h.e(backStackEntryAt, "childFragmentManager.getBackStackEntryAt(0)");
            getChildFragmentManager().popBackStack(backStackEntryAt.getId(), 1);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        h.e(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        int i = R.id.preferences_detail;
        h.c(fragmentInstantiate);
        fragmentTransactionBeginTransaction.replace(i, fragmentInstantiate);
        if (getSlidingPaneLayout().isOpen()) {
            fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        getSlidingPaneLayout().openPane();
        fragmentTransactionBeginTransaction.commit();
    }

    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        h.f(context, "context");
        super.onAttach(context);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        h.e(parentFragmentManager, "parentFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
        h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.setPrimaryNavigationFragment(this);
        fragmentTransactionBeginTransaction.commit();
    }

    public Fragment onCreateInitialDetailFragment() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R.id.preferences_header);
        if (fragmentFindFragmentById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
        }
        PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) fragmentFindFragmentById;
        if (preferenceFragmentCompat.getPreferenceScreen().getPreferenceCount() <= 0) {
            return null;
        }
        int preferenceCount = preferenceFragmentCompat.getPreferenceScreen().getPreferenceCount();
        int i = 0;
        while (true) {
            if (i >= preferenceCount) {
                break;
            }
            int i3 = i + 1;
            Preference preference = preferenceFragmentCompat.getPreferenceScreen().getPreference(i);
            h.e(preference, "headerFragment.preferenc…reen.getPreference(index)");
            if (preference.getFragment() == null) {
                i = i3;
            } else {
                String fragment = preference.getFragment();
                fragmentInstantiate = fragment != null ? getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), fragment) : null;
                if (fragmentInstantiate == null) {
                    return fragmentInstantiate;
                }
                fragmentInstantiate.setArguments(preference.getExtras());
            }
        }
        return fragmentInstantiate;
    }

    public abstract PreferenceFragmentCompat onCreatePreferenceHeader();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.f(inflater, "inflater");
        SlidingPaneLayout slidingPaneLayoutBuildContentView = buildContentView(inflater);
        if (getChildFragmentManager().findFragmentById(R.id.preferences_header) == null) {
            PreferenceFragmentCompat preferenceFragmentCompatOnCreatePreferenceHeader = onCreatePreferenceHeader();
            FragmentManager childFragmentManager = getChildFragmentManager();
            h.e(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
            fragmentTransactionBeginTransaction.setReorderingAllowed(true);
            fragmentTransactionBeginTransaction.add(R.id.preferences_header, preferenceFragmentCompatOnCreatePreferenceHeader);
            fragmentTransactionBeginTransaction.commit();
        }
        slidingPaneLayoutBuildContentView.setLockMode(3);
        return slidingPaneLayoutBuildContentView;
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {
        h.f(caller, "caller");
        h.f(pref, "pref");
        if (caller.getId() == R.id.preferences_header) {
            openPreferenceHeader(pref);
            return true;
        }
        if (caller.getId() != R.id.preferences_detail) {
            return false;
        }
        FragmentFactory fragmentFactory = getChildFragmentManager().getFragmentFactory();
        ClassLoader classLoader = requireContext().getClassLoader();
        String fragment = pref.getFragment();
        h.c(fragment);
        Fragment fragmentInstantiate = fragmentFactory.instantiate(classLoader, fragment);
        h.e(fragmentInstantiate, "childFragmentManager.fra….fragment!!\n            )");
        fragmentInstantiate.setArguments(pref.getExtras());
        FragmentManager childFragmentManager = getChildFragmentManager();
        h.e(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.replace(R.id.preferences_detail, fragmentInstantiate);
        fragmentTransactionBeginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransactionBeginTransaction.addToBackStack(null);
        fragmentTransactionBeginTransaction.commit();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        h.f(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.onBackPressedCallback = new InnerOnBackPressedCallback(this);
        SlidingPaneLayout slidingPaneLayout = getSlidingPaneLayout();
        if (!ViewCompat.isLaidOut(slidingPaneLayout) || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.preference.PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    h.g(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    OnBackPressedCallback onBackPressedCallback = this.this$0.onBackPressedCallback;
                    h.c(onBackPressedCallback);
                    onBackPressedCallback.setEnabled(this.this$0.getSlidingPaneLayout().isSlideable() && this.this$0.getSlidingPaneLayout().isOpen());
                }
            });
        } else {
            OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
            h.c(onBackPressedCallback);
            onBackPressedCallback.setEnabled(getSlidingPaneLayout().isSlideable() && getSlidingPaneLayout().isOpen());
        }
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: androidx.preference.a
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                PreferenceHeaderFragmentCompat.m26onViewCreated$lambda10(this.f1659a);
            }
        });
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = C0166ViewTreeOnBackPressedDispatcherOwner.get(view);
        if (onBackPressedDispatcherOwner == null || (onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
        h.c(onBackPressedCallback2);
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        Fragment fragmentOnCreateInitialDetailFragment;
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null || (fragmentOnCreateInitialDetailFragment = onCreateInitialDetailFragment()) == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        h.e(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        h.e(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.replace(R.id.preferences_detail, fragmentOnCreateInitialDetailFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    private final void openPreferenceHeader(Intent intent) {
        if (intent == null) {
            return;
        }
        startActivity(intent);
    }
}
