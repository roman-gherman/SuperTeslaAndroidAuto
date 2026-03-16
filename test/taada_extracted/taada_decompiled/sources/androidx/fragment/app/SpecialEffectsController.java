package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.jvm.JvmStatic;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\b \u0018\u0000 62\u00020\u0001:\u0003678B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0012¢\u0006\u0004\b#\u0010\u0016J\r\u0010$\u001a\u00020\u0012¢\u0006\u0004\b$\u0010\u0016J\r\u0010%\u001a\u00020\u0012¢\u0006\u0004\b%\u0010\u0016J\r\u0010&\u001a\u00020\u0012¢\u0006\u0004\b&\u0010\u0016J*\u0010*\u001a\u00020\u00122\u0011\u0010)\u001a\r\u0012\t\u0012\u00070\b¢\u0006\u0002\b(0'2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101R\u0016\u00103\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104¨\u00069"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "Landroid/view/ViewGroup;", "container", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/view/ViewGroup;)V", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "findPendingOperation", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/SpecialEffectsController$Operation;", "findRunningOperation", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/FragmentStateManager;", "fragmentStateManager", "LN1/m;", "enqueue", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;)V", "updateFinalState", "()V", "getAwaitingCompletionLifecycleImpact", "(Landroidx/fragment/app/FragmentStateManager;)Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "enqueueAdd", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/FragmentStateManager;)V", "enqueueShow", "(Landroidx/fragment/app/FragmentStateManager;)V", "enqueueHide", "enqueueRemove", "", "isPop", "updateOperationDirection", "(Z)V", "markPostponedState", "forcePostponedExecutePendingOperations", "executePendingOperations", "forceCompleteAllOperations", "", "Lkotlin/jvm/JvmSuppressWildcards;", "operations", "executeOperations", "(Ljava/util/List;Z)V", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "", "pendingOperations", "Ljava/util/List;", "runningOperations", "operationDirectionIsPop", "Z", "isContainerPostponed", "Companion", "FragmentStateManagerOperation", "Operation", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SpecialEffectsController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ViewGroup container;
    private boolean isContainerPostponed;
    private boolean operationDirectionIsPop;
    private final List<Operation> pendingOperations;
    private final List<Operation> runningOperations;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Companion;", "", "()V", "getOrCreateController", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "factory", "Landroidx/fragment/app/SpecialEffectsControllerFactory;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.d dVar) {
            this();
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup container, FragmentManager fragmentManager) {
            kotlin.jvm.internal.h.f(container, "container");
            kotlin.jvm.internal.h.f(fragmentManager, "fragmentManager");
            SpecialEffectsControllerFactory specialEffectsControllerFactory = fragmentManager.getSpecialEffectsControllerFactory();
            kotlin.jvm.internal.h.e(specialEffectsControllerFactory, "fragmentManager.specialEffectsControllerFactory");
            return getOrCreateController(container, specialEffectsControllerFactory);
        }

        private Companion() {
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup container, SpecialEffectsControllerFactory factory) {
            kotlin.jvm.internal.h.f(container, "container");
            kotlin.jvm.internal.h.f(factory, "factory");
            Object tag = container.getTag(R.id.special_effects_controller_view_tag);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController specialEffectsControllerCreateController = factory.createController(container);
            kotlin.jvm.internal.h.e(specialEffectsControllerCreateController, "factory.createController(container)");
            container.setTag(R.id.special_effects_controller_view_tag, specialEffectsControllerCreateController);
            return specialEffectsControllerCreateController;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/FragmentStateManager;", "fragmentStateManager", "Landroidx/core/os/CancellationSignal;", "cancellationSignal", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;Landroidx/core/os/CancellationSignal;)V", "LN1/m;", "onStart", "()V", "complete", "Landroidx/fragment/app/FragmentStateManager;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager fragmentStateManager;

        /* JADX WARN: Illegal instructions before constructor call */
        public FragmentStateManagerOperation(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
            kotlin.jvm.internal.h.f(cancellationSignal, "cancellationSignal");
            Fragment fragment = fragmentStateManager.getFragment();
            kotlin.jvm.internal.h.e(fragment, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragment, cancellationSignal);
            this.fragmentStateManager = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.fragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) {
                if (getLifecycleImpact() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragment = this.fragmentStateManager.getFragment();
                    kotlin.jvm.internal.h.e(fragment, "fragmentStateManager.fragment");
                    View viewRequireView = fragment.requireView();
                    kotlin.jvm.internal.h.e(viewRequireView, "fragment.requireView()");
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString(viewRequireView.findFocus());
                        viewRequireView.toString();
                        fragment.toString();
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = this.fragmentStateManager.getFragment();
            kotlin.jvm.internal.h.e(fragment2, "fragmentStateManager.fragment");
            View viewFindFocus = fragment2.mView.findFocus();
            if (viewFindFocus != null) {
                fragment2.setFocusedView(viewFindFocus);
                if (FragmentManager.isLoggingEnabled(2)) {
                    viewFindFocus.toString();
                    fragment2.toString();
                }
            }
            View viewRequireView2 = getFragment().requireView();
            kotlin.jvm.internal.h.e(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                this.fragmentStateManager.addViewToContainer();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001:\u000278B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001d\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0002012\u0006\u00102\u001a\u0002018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b3\u00105R$\u00106\u001a\u0002012\u0006\u00102\u001a\u0002018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00104\u001a\u0004\b6\u00105¨\u00069"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "lifecycleImpact", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/core/os/CancellationSignal;", "cancellationSignal", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;Landroidx/core/os/CancellationSignal;)V", "", "toString", "()Ljava/lang/String;", "LN1/m;", "cancel", "()V", "mergeWith", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Ljava/lang/Runnable;", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER, "addCompletionListener", "(Ljava/lang/Runnable;)V", "onStart", "signal", "markStartedSpecialEffect", "(Landroidx/core/os/CancellationSignal;)V", "completeSpecialEffect", "complete", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "getFinalState", "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "getLifecycleImpact", "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "", "completionListeners", "Ljava/util/List;", "", "specialEffectsSignals", "Ljava/util/Set;", "", "<set-?>", "isCanceled", "Z", "()Z", "isComplete", "LifecycleImpact", "State", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Operation {
        private final List<Runnable> completionListeners;
        private State finalState;
        private final Fragment fragment;
        private boolean isCanceled;
        private boolean isComplete;
        private LifecycleImpact lifecycleImpact;
        private final Set<CancellationSignal> specialEffectsSignals;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", "NONE", "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;I)V", "Landroid/view/View;", "view", "LN1/m;", "applyState", "(Landroid/view/View;)V", "Companion", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u00020\u0004*\u00020\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "visibility", "", "asOperationState", "Landroid/view/View;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(kotlin.jvm.internal.d dVar) {
                    this();
                }

                public final State asOperationState(View view) {
                    kotlin.jvm.internal.h.f(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? State.INVISIBLE : from(view.getVisibility());
                }

                @JvmStatic
                public final State from(int visibility) {
                    if (visibility == 0) {
                        return State.VISIBLE;
                    }
                    if (visibility == 4) {
                        return State.INVISIBLE;
                    }
                    if (visibility == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException(B2.b.c(visibility, "Unknown visibility "));
                }

                private Companion() {
                }
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @JvmStatic
            public static final State from(int i) {
                return INSTANCE.from(i);
            }

            public final void applyState(View view) {
                kotlin.jvm.internal.h.f(view, "view");
                int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
                if (i == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            view.toString();
                            viewGroup.toString();
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        view.toString();
                    }
                    view.setVisibility(0);
                } else if (i == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        view.toString();
                    }
                    view.setVisibility(8);
                } else {
                    if (i != 4) {
                        return;
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        view.toString();
                    }
                    view.setVisibility(4);
                }
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[LifecycleImpact.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LifecycleImpact.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LifecycleImpact.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Operation(State finalState, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.h.f(fragment, "fragment");
            kotlin.jvm.internal.h.f(cancellationSignal, "cancellationSignal");
            this.finalState = finalState;
            this.lifecycleImpact = lifecycleImpact;
            this.fragment = fragment;
            this.completionListeners = new ArrayList();
            this.specialEffectsSignals = new LinkedHashSet();
            cancellationSignal.setOnCancelListener(new R0.a(this, 4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(Operation this$0) {
            kotlin.jvm.internal.h.f(this$0, "this$0");
            this$0.cancel();
        }

        public final void addCompletionListener(Runnable listener) {
            kotlin.jvm.internal.h.f(listener, "listener");
            this.completionListeners.add(listener);
        }

        public final void cancel() {
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            if (this.specialEffectsSignals.isEmpty()) {
                complete();
                return;
            }
            Iterator it = m.r0(this.specialEffectsSignals).iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
        }

        public void complete() {
            if (this.isComplete) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                toString();
            }
            this.isComplete = true;
            Iterator<T> it = this.completionListeners.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void completeSpecialEffect(CancellationSignal signal) {
            kotlin.jvm.internal.h.f(signal, "signal");
            if (this.specialEffectsSignals.remove(signal) && this.specialEffectsSignals.isEmpty()) {
                complete();
            }
        }

        public final State getFinalState() {
            return this.finalState;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        /* JADX INFO: renamed from: isCanceled, reason: from getter */
        public final boolean getIsCanceled() {
            return this.isCanceled;
        }

        /* JADX INFO: renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public final void markStartedSpecialEffect(CancellationSignal signal) {
            kotlin.jvm.internal.h.f(signal, "signal");
            onStart();
            this.specialEffectsSignals.add(signal);
        }

        public final void mergeWith(State finalState, LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            int i = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
            if (i == 1) {
                if (this.finalState == State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString(this.fragment);
                        Objects.toString(this.lifecycleImpact);
                    }
                    this.finalState = State.VISIBLE;
                    this.lifecycleImpact = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(this.fragment);
                    Objects.toString(this.finalState);
                    Objects.toString(this.lifecycleImpact);
                }
                this.finalState = State.REMOVED;
                this.lifecycleImpact = LifecycleImpact.REMOVING;
                return;
            }
            if (i == 3 && this.finalState != State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(this.fragment);
                    Objects.toString(this.finalState);
                    finalState.toString();
                }
                this.finalState = finalState;
            }
        }

        public void onStart() {
        }

        public final void setFinalState(State state) {
            kotlin.jvm.internal.h.f(state, "<set-?>");
            this.finalState = state;
        }

        public final void setLifecycleImpact(LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.h.f(lifecycleImpact, "<set-?>");
            this.lifecycleImpact = lifecycleImpact;
        }

        public String toString() {
            StringBuilder sbM = B2.b.m("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
            sbM.append(this.finalState);
            sbM.append(" lifecycleImpact = ");
            sbM.append(this.lifecycleImpact);
            sbM.append(" fragment = ");
            sbM.append(this.fragment);
            sbM.append('}');
            return sbM.toString();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup container) {
        kotlin.jvm.internal.h.f(container, "container");
        this.container = container;
        this.pendingOperations = new ArrayList();
        this.runningOperations = new ArrayList();
    }

    private final void enqueue(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.pendingOperations) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Fragment fragment = fragmentStateManager.getFragment();
            kotlin.jvm.internal.h.e(fragment, "fragmentStateManager.fragment");
            Operation operationFindPendingOperation = findPendingOperation(fragment);
            if (operationFindPendingOperation != null) {
                operationFindPendingOperation.mergeWith(finalState, lifecycleImpact);
                return;
            }
            FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(finalState, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.pendingOperations.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.addCompletionListener(new i(this, fragmentStateManagerOperation, 0));
            fragmentStateManagerOperation.addCompletionListener(new i(this, fragmentStateManagerOperation, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$4$lambda$2(SpecialEffectsController this$0, FragmentStateManagerOperation operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        if (this$0.pendingOperations.contains(operation)) {
            Operation.State finalState = operation.getFinalState();
            View view = operation.getFragment().mView;
            kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
            finalState.applyState(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$4$lambda$3(SpecialEffectsController this$0, FragmentStateManagerOperation operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        this$0.pendingOperations.remove(operation);
        this$0.runningOperations.remove(operation);
    }

    private final Operation findPendingOperation(Fragment fragment) {
        Object next;
        Iterator<T> it = this.pendingOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.h.a(operation.getFragment(), fragment) && !operation.getIsCanceled()) {
                break;
            }
        }
        return (Operation) next;
    }

    private final Operation findRunningOperation(Fragment fragment) {
        Object next;
        Iterator<T> it = this.runningOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.h.a(operation.getFragment(), fragment) && !operation.getIsCanceled()) {
                break;
            }
        }
        return (Operation) next;
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return INSTANCE.getOrCreateController(viewGroup, fragmentManager);
    }

    private final void updateFinalState() {
        for (Operation operation : this.pendingOperations) {
            if (operation.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                View viewRequireView = operation.getFragment().requireView();
                kotlin.jvm.internal.h.e(viewRequireView, "fragment.requireView()");
                operation.mergeWith(Operation.State.INSTANCE.from(viewRequireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void enqueueAdd(Operation.State finalState, FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.h.f(finalState, "finalState");
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragmentStateManager.getFragment());
        }
        enqueue(finalState, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void enqueueHide(FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void enqueueRemove(FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public final void enqueueShow(FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public abstract void executeOperations(List<Operation> operations, boolean isPop);

    public final void executePendingOperations() {
        if (this.isContainerPostponed) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this.container)) {
            forceCompleteAllOperations();
            this.operationDirectionIsPop = false;
            return;
        }
        synchronized (this.pendingOperations) {
            try {
                if (!this.pendingOperations.isEmpty()) {
                    ArrayList<Operation> arrayListP0 = m.p0(this.runningOperations);
                    this.runningOperations.clear();
                    for (Operation operation : arrayListP0) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(operation);
                        }
                        operation.cancel();
                        if (!operation.getIsComplete()) {
                            this.runningOperations.add(operation);
                        }
                    }
                    updateFinalState();
                    ArrayList arrayListP02 = m.p0(this.pendingOperations);
                    this.pendingOperations.clear();
                    this.runningOperations.addAll(arrayListP02);
                    FragmentManager.isLoggingEnabled(2);
                    Iterator it = arrayListP02.iterator();
                    while (it.hasNext()) {
                        ((Operation) it.next()).onStart();
                    }
                    executeOperations(arrayListP02, this.operationDirectionIsPop);
                    this.operationDirectionIsPop = false;
                    FragmentManager.isLoggingEnabled(2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void forceCompleteAllOperations() {
        FragmentManager.isLoggingEnabled(2);
        boolean zIsAttachedToWindow = ViewCompat.isAttachedToWindow(this.container);
        synchronized (this.pendingOperations) {
            try {
                updateFinalState();
                Iterator<Operation> it = this.pendingOperations.iterator();
                while (it.hasNext()) {
                    it.next().onStart();
                }
                for (Operation operation : m.p0(this.runningOperations)) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (!zIsAttachedToWindow) {
                            Objects.toString(this.container);
                        }
                        Objects.toString(operation);
                    }
                    operation.cancel();
                }
                for (Operation operation2 : m.p0(this.pendingOperations)) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (!zIsAttachedToWindow) {
                            Objects.toString(this.container);
                        }
                        Objects.toString(operation2);
                    }
                    operation2.cancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void forcePostponedExecutePendingOperations() {
        if (this.isContainerPostponed) {
            FragmentManager.isLoggingEnabled(2);
            this.isContainerPostponed = false;
            executePendingOperations();
        }
    }

    public final Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        Fragment fragment = fragmentStateManager.getFragment();
        kotlin.jvm.internal.h.e(fragment, "fragmentStateManager.fragment");
        Operation operationFindPendingOperation = findPendingOperation(fragment);
        Operation.LifecycleImpact lifecycleImpact = operationFindPendingOperation != null ? operationFindPendingOperation.getLifecycleImpact() : null;
        Operation operationFindRunningOperation = findRunningOperation(fragment);
        Operation.LifecycleImpact lifecycleImpact2 = operationFindRunningOperation != null ? operationFindRunningOperation.getLifecycleImpact() : null;
        int i = lifecycleImpact == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
        return (i == -1 || i == 1) ? lifecycleImpact2 : lifecycleImpact;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final void markPostponedState() {
        Operation operationPrevious;
        synchronized (this.pendingOperations) {
            try {
                updateFinalState();
                List<Operation> list = this.pendingOperations;
                ListIterator<Operation> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        operationPrevious = null;
                        break;
                    }
                    operationPrevious = listIterator.previous();
                    Operation operation = operationPrevious;
                    Operation.State.Companion companion = Operation.State.INSTANCE;
                    View view = operation.getFragment().mView;
                    kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
                    Operation.State stateAsOperationState = companion.asOperationState(view);
                    Operation.State finalState = operation.getFinalState();
                    Operation.State state = Operation.State.VISIBLE;
                    if (finalState == state && stateAsOperationState != state) {
                        break;
                    }
                }
                Operation operation2 = operationPrevious;
                Fragment fragment = operation2 != null ? operation2.getFragment() : null;
                this.isContainerPostponed = fragment != null ? fragment.isPostponed() : false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateOperationDirection(boolean isPop) {
        this.operationDirectionIsPop = isPop;
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup viewGroup, SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        return INSTANCE.getOrCreateController(viewGroup, specialEffectsControllerFactory);
    }
}
