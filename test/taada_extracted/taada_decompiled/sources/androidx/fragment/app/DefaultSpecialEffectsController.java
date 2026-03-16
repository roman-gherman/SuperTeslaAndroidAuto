package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.m;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0003345B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJG\u0010\u0014\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\"\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0 H\u0002¢\u0006\u0004\b\"\u0010#J/\u0010(\u001a\u00020\t2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001f0$j\b\u0012\u0004\u0012\u00020\u001f`%2\u0006\u0010'\u001a\u00020\u001fH\u0002¢\u0006\u0004\b(\u0010)J+\u0010,\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0*2\u0006\u0010'\u001a\u00020\u001fH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u00100J%\u00101\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b1\u00102¨\u00066"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "Landroid/view/ViewGroup;", "container", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/view/ViewGroup;)V", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operations", "LN1/m;", "syncAnimations", "(Ljava/util/List;)V", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "animationInfos", "", "awaitingContainerChanges", "", "startedAnyTransition", "", "startedTransitions", "startAnimations", "(Ljava/util/List;Ljava/util/List;ZLjava/util/Map;)V", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "transitionInfos", "isPop", "firstOut", "lastIn", "startTransitions", "(Ljava/util/List;Ljava/util/List;ZLandroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;)Ljava/util/Map;", "Landroidx/collection/ArrayMap;", "", "Landroid/view/View;", "", "names", "retainMatchingViews", "(Landroidx/collection/ArrayMap;Ljava/util/Collection;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "transitioningViews", "view", "captureTransitioningViews", "(Ljava/util/ArrayList;Landroid/view/View;)V", "", "namedViews", "findNamedViews", "(Ljava/util/Map;Landroid/view/View;)V", "operation", "applyContainerChanges", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "executeOperations", "(Ljava/util/List;Z)V", "AnimationInfo", "SpecialEffectsInfo", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;Z)V", "animation", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "isAnimLoaded", "getAnimation", "context", "Landroid/content/Context;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean z6) {
            super(operation, signal);
            kotlin.jvm.internal.h.f(operation, "operation");
            kotlin.jvm.internal.h.f(signal, "signal");
            this.isPop = z6;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            kotlin.jvm.internal.h.f(context, "context");
            if (this.isAnimLoaded) {
                return this.animation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
            this.animation = animationOrAnimatorLoadAnimation;
            this.isAnimLoaded = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "operation", "Landroidx/core/os/CancellationSignal;", "signal", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;)V", "LN1/m;", "completeSpecialEffect", "()V", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "Landroidx/core/os/CancellationSignal;", "getSignal", "()Landroidx/core/os/CancellationSignal;", "", "isVisibilityUnchanged", "()Z", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;
        private final CancellationSignal signal;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal signal) {
            kotlin.jvm.internal.h.f(operation, "operation");
            kotlin.jvm.internal.h.f(signal, "signal");
            this.operation = operation;
            this.signal = signal;
        }

        public final void completeSpecialEffect() {
            this.operation.completeSpecialEffect(this.signal);
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final CancellationSignal getSignal() {
            return this.signal;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.INSTANCE;
            View view = this.operation.getFragment().mView;
            kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateAsOperationState = companion.asOperationState(view);
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            if (stateAsOperationState == finalState) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (stateAsOperationState == state || finalState == state) ? false : true;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u00060\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "entry", "", "", "kotlin.jvm.PlatformType", "Landroid/view/View;", "invoke", "(Ljava/util/Map$Entry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends kotlin.jvm.internal.i implements Function1<Map.Entry<String, View>, Boolean> {
        final /* synthetic */ Collection<String> $names;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Collection<String> collection) {
            super(1);
            this.$names = collection;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Map.Entry<String, View> entry) {
            kotlin.jvm.internal.h.f(entry, "entry");
            return Boolean.valueOf(m.L(ViewCompat.getTransitionName(entry.getValue()), this.$names));
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$startAnimations$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$startAnimations$3", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "LN1/m;", "onAnimationStart", "(Landroid/view/animation/Animation;)V", "onAnimationEnd", "onAnimationRepeat", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ AnimationInfo $animationInfo;
        final /* synthetic */ SpecialEffectsController.Operation $operation;
        final /* synthetic */ View $viewToAnimate;
        final /* synthetic */ DefaultSpecialEffectsController this$0;

        public AnonymousClass3(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController, View view, AnimationInfo animationInfo) {
            this.$operation = operation;
            this.this$0 = defaultSpecialEffectsController;
            this.$viewToAnimate = view;
            this.$animationInfo = animationInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationEnd$lambda$0(DefaultSpecialEffectsController this$0, View view, AnimationInfo animationInfo) {
            kotlin.jvm.internal.h.f(this$0, "this$0");
            kotlin.jvm.internal.h.f(animationInfo, "$animationInfo");
            this$0.getContainer().endViewTransition(view);
            animationInfo.completeSpecialEffect();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.h.f(animation, "animation");
            this.this$0.getContainer().post(new d(this.this$0, this.$viewToAnimate, this.$animationInfo, 0));
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(this.$operation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.h.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.h.f(animation, "animation");
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(this.$operation);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup container) {
        super(container);
        kotlin.jvm.internal.h.f(container, "container");
    }

    private final void applyContainerChanges(SpecialEffectsController.Operation operation) {
        View view = operation.getFragment().mView;
        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
        kotlin.jvm.internal.h.e(view, "view");
        finalState.applyState(view);
    }

    private final void captureTransitioningViews(ArrayList<View> transitioningViews, View view) {
        if (!(view instanceof ViewGroup)) {
            if (transitioningViews.contains(view)) {
                return;
            }
            transitioningViews.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (transitioningViews.contains(view)) {
                return;
            }
            transitioningViews.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(transitioningViews, childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeOperations$lambda$2(List awaitingContainerChanges, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController this$0) {
        kotlin.jvm.internal.h.f(awaitingContainerChanges, "$awaitingContainerChanges");
        kotlin.jvm.internal.h.f(operation, "$operation");
        kotlin.jvm.internal.h.f(this$0, "this$0");
        if (awaitingContainerChanges.contains(operation)) {
            awaitingContainerChanges.remove(operation);
            this$0.applyContainerChanges(operation);
        }
    }

    private final void findNamedViews(Map<String, View> namedViews, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            namedViews.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(namedViews, childAt);
                }
            }
        }
    }

    private final void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Set<Map.Entry<String, View>> entries = arrayMap.entrySet();
        kotlin.jvm.internal.h.e(entries, "entries");
        s.H(entries, new AnonymousClass1(collection), false);
    }

    private final void startAnimations(List<AnimationInfo> animationInfos, List<SpecialEffectsController.Operation> awaitingContainerChanges, boolean startedAnyTransition, Map<SpecialEffectsController.Operation, Boolean> startedTransitions) {
        Context context = getContainer().getContext();
        ArrayList<AnimationInfo> arrayList = new ArrayList();
        boolean z6 = false;
        for (final AnimationInfo animationInfo : animationInfos) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                kotlin.jvm.internal.h.e(context, "context");
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (kotlin.jvm.internal.h.a(startedTransitions.get(operation), Boolean.TRUE)) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Objects.toString(fragment);
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            final boolean z7 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z7) {
                                awaitingContainerChanges.remove(operation);
                            }
                            final View view = fragment.mView;
                            getContainer().startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.startAnimations.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator anim) {
                                    kotlin.jvm.internal.h.f(anim, "anim");
                                    DefaultSpecialEffectsController.this.getContainer().endViewTransition(view);
                                    if (z7) {
                                        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                                        View viewToAnimate = view;
                                        kotlin.jvm.internal.h.e(viewToAnimate, "viewToAnimate");
                                        finalState.applyState(viewToAnimate);
                                    }
                                    animationInfo.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Objects.toString(operation);
                                    }
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                operation.toString();
                            }
                            animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.a
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public final void onCancel() {
                                    DefaultSpecialEffectsController.startAnimations$lambda$3(animator, operation);
                                }
                            });
                            z6 = true;
                        }
                    }
                }
            }
        }
        for (final AnimationInfo animationInfo2 : arrayList) {
            final SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (startedAnyTransition) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment2);
                }
                animationInfo2.completeSpecialEffect();
            } else if (z6) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment2);
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                kotlin.jvm.internal.h.e(context, "context");
                FragmentAnim.AnimationOrAnimator animation2 = animationInfo2.getAnimation(context);
                if (animation2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Animation animation3 = animation2.animation;
                if (animation3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation3);
                    animationInfo2.completeSpecialEffect();
                } else {
                    getContainer().startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation3, getContainer(), view2);
                    endViewTransitionAnimation.setAnimationListener(new AnonymousClass3(operation2, this, view2, animationInfo2));
                    view2.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        operation2.toString();
                    }
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.b
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        DefaultSpecialEffectsController.AnimationInfo animationInfo3 = animationInfo2;
                        SpecialEffectsController.Operation operation3 = operation2;
                        DefaultSpecialEffectsController.startAnimations$lambda$4(view2, this, animationInfo3, operation3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimations$lambda$3(Animator animator, SpecialEffectsController.Operation operation) {
        kotlin.jvm.internal.h.f(operation, "$operation");
        animator.end();
        if (FragmentManager.isLoggingEnabled(2)) {
            operation.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimations$lambda$4(View view, DefaultSpecialEffectsController this$0, AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(animationInfo, "$animationInfo");
        kotlin.jvm.internal.h.f(operation, "$operation");
        view.clearAnimation();
        this$0.getContainer().endViewTransition(view);
        animationInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            operation.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.DefaultSpecialEffectsController, androidx.fragment.app.SpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.fragment.app.DefaultSpecialEffectsController] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r11v25, types: [androidx.core.app.SharedElementCallback] */
    private final Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> transitionInfos, List<SpecialEffectsController.Operation> awaitingContainerChanges, final boolean isPop, final SpecialEffectsController.Operation firstOut, SpecialEffectsController.Operation lastIn) {
        Object obj;
        Object obj2;
        ArrayList<View> arrayList;
        View view;
        LinkedHashMap linkedHashMap;
        View view2;
        Object obj3;
        Object obj4;
        SpecialEffectsController.Operation operation;
        View view3;
        boolean z6;
        int i;
        ?? r02 = this;
        final SpecialEffectsController.Operation operation2 = lastIn;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj5 : transitionInfos) {
            if (!((TransitionInfo) obj5).isVisibilityUnchanged()) {
                arrayList2.add(obj5);
            }
        }
        ArrayList<TransitionInfo> arrayList3 = new ArrayList();
        for (Object obj6 : arrayList2) {
            if (((TransitionInfo) obj6).getHandlingImpl() != null) {
                arrayList3.add(obj6);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl = null;
        for (TransitionInfo transitionInfo : arrayList3) {
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl != null && handlingImpl != fragmentTransitionImpl) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
            fragmentTransitionImpl = handlingImpl;
        }
        if (fragmentTransitionImpl == null) {
            for (TransitionInfo transitionInfo2 : transitionInfos) {
                linkedHashMap2.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return linkedHashMap2;
        }
        View view4 = new View(r02.getContainer().getContext());
        Rect rect = new Rect();
        ArrayList<View> arrayList4 = new ArrayList<>();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayMap arrayMap = new ArrayMap();
        Object obj7 = null;
        View view5 = null;
        boolean z7 = false;
        for (TransitionInfo transitionInfo3 : transitionInfos) {
            if (!transitionInfo3.hasSharedElementTransition() || firstOut == null || operation2 == null) {
                view4 = view4;
                linkedHashMap2 = linkedHashMap2;
                arrayList5 = arrayList5;
                arrayList4 = arrayList4;
                view5 = view5;
                arrayMap = arrayMap;
            } else {
                Object objWrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(transitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                kotlin.jvm.internal.h.e(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                ArrayList<String> sharedElementSourceNames2 = firstOut.getFragment().getSharedElementSourceNames();
                kotlin.jvm.internal.h.e(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                ArrayList<String> sharedElementTargetNames = firstOut.getFragment().getSharedElementTargetNames();
                View view6 = view5;
                kotlin.jvm.internal.h.e(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                int size = sharedElementTargetNames.size();
                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                View view7 = view4;
                int i3 = 0;
                while (i3 < size) {
                    int i4 = size;
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i3));
                    }
                    i3++;
                    size = i4;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                kotlin.jvm.internal.h.e(sharedElementTargetNames2, "lastIn.fragment.sharedElementTargetNames");
                N1.e eVar = !isPop ? new N1.e(firstOut.getFragment().getExitTransitionCallback(), operation2.getFragment().getEnterTransitionCallback()) : new N1.e(firstOut.getFragment().getEnterTransitionCallback(), operation2.getFragment().getExitTransitionCallback());
                SharedElementCallback sharedElementCallback = (SharedElementCallback) eVar.f1121a;
                ?? r11 = (SharedElementCallback) eVar.b;
                int i5 = 0;
                for (int size2 = sharedElementSourceNames.size(); i5 < size2; size2 = size2) {
                    arrayMap.put(sharedElementSourceNames.get(i5), sharedElementTargetNames2.get(i5));
                    i5++;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    for (String str : sharedElementTargetNames2) {
                    }
                    for (String str2 : sharedElementSourceNames) {
                    }
                }
                ArrayMap arrayMap2 = new ArrayMap();
                View view8 = firstOut.getFragment().mView;
                Rect rect2 = rect;
                kotlin.jvm.internal.h.e(view8, "firstOut.fragment.mView");
                r02.findNamedViews(arrayMap2, view8);
                arrayMap2.retainAll(sharedElementSourceNames);
                if (sharedElementCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        firstOut.toString();
                    }
                    sharedElementCallback.onMapSharedElements(sharedElementSourceNames, arrayMap2);
                    int size3 = sharedElementSourceNames.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i6 = size3 - 1;
                            String str3 = sharedElementSourceNames.get(size3);
                            View view9 = (View) arrayMap2.get(str3);
                            if (view9 == null) {
                                arrayMap.remove(str3);
                                i = i6;
                            } else {
                                i = i6;
                                if (!kotlin.jvm.internal.h.a(str3, ViewCompat.getTransitionName(view9))) {
                                    arrayMap.put(ViewCompat.getTransitionName(view9), (String) arrayMap.remove(str3));
                                }
                            }
                            if (i < 0) {
                                break;
                            }
                            size3 = i;
                        }
                    }
                } else {
                    arrayMap.retainAll(arrayMap2.keySet());
                }
                final ArrayMap arrayMap3 = new ArrayMap();
                View view10 = operation2.getFragment().mView;
                kotlin.jvm.internal.h.e(view10, "lastIn.fragment.mView");
                r02.findNamedViews(arrayMap3, view10);
                arrayMap3.retainAll(sharedElementTargetNames2);
                arrayMap3.retainAll(arrayMap.values());
                if (r11 != 0) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        operation2.toString();
                    }
                    r11.onMapSharedElements(sharedElementTargetNames2, arrayMap3);
                    int size4 = sharedElementTargetNames2.size() - 1;
                    if (size4 >= 0) {
                        while (true) {
                            int i7 = size4 - 1;
                            String name = sharedElementTargetNames2.get(size4);
                            View view11 = (View) arrayMap3.get(name);
                            if (view11 == null) {
                                kotlin.jvm.internal.h.e(name, "name");
                                String strFindKeyForValue = FragmentTransition.findKeyForValue(arrayMap, name);
                                if (strFindKeyForValue != null) {
                                    arrayMap.remove(strFindKeyForValue);
                                }
                            } else if (!kotlin.jvm.internal.h.a(name, ViewCompat.getTransitionName(view11))) {
                                kotlin.jvm.internal.h.e(name, "name");
                                String strFindKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, name);
                                if (strFindKeyForValue2 != null) {
                                    arrayMap.put(strFindKeyForValue2, ViewCompat.getTransitionName(view11));
                                }
                            }
                            if (i7 < 0) {
                                break;
                            }
                            size4 = i7;
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap, arrayMap3);
                }
                Set setKeySet = arrayMap.keySet();
                kotlin.jvm.internal.h.e(setKeySet, "sharedElementNameMapping.keys");
                r02.retainMatchingViews(arrayMap2, setKeySet);
                Collection collectionValues = arrayMap.values();
                kotlin.jvm.internal.h.e(collectionValues, "sharedElementNameMapping.values");
                r02.retainMatchingViews(arrayMap3, collectionValues);
                if (arrayMap.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    view5 = view6;
                    linkedHashMap2 = linkedHashMap3;
                    view4 = view7;
                    rect = rect2;
                    obj7 = null;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), firstOut.getFragment(), isPop, arrayMap2, true);
                    OneShotPreDrawListener.add(r02.getContainer(), new Runnable() { // from class: androidx.fragment.app.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultSpecialEffectsController.startTransitions$lambda$9(operation2, firstOut, isPop, arrayMap3);
                        }
                    });
                    arrayList4.addAll(arrayMap2.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view3 = view6;
                    } else {
                        view3 = (View) arrayMap2.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl.setEpicenter(objWrapTransitionInSet, view3);
                    }
                    arrayList5.addAll(arrayMap3.values());
                    if (sharedElementTargetNames2.isEmpty()) {
                        z6 = false;
                    } else {
                        z6 = false;
                        View view12 = (View) arrayMap3.get(sharedElementTargetNames2.get(0));
                        if (view12 != null) {
                            rect = rect2;
                            OneShotPreDrawListener.add(r02.getContainer(), new d(fragmentTransitionImpl, view12, rect, 2));
                            z7 = true;
                        }
                        fragmentTransitionImpl.setSharedElementTargets(objWrapTransitionInSet, view7, arrayList4);
                        ArrayMap arrayMap4 = arrayMap;
                        ArrayList<View> arrayList6 = arrayList5;
                        fragmentTransitionImpl.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList6);
                        Boolean bool = Boolean.TRUE;
                        linkedHashMap3.put(firstOut, bool);
                        linkedHashMap3.put(operation2, bool);
                        view5 = view3;
                        obj7 = objWrapTransitionInSet;
                        arrayList4 = arrayList4;
                        arrayMap = arrayMap4;
                        view4 = view7;
                        linkedHashMap2 = linkedHashMap3;
                        arrayList5 = arrayList6;
                    }
                    rect = rect2;
                    fragmentTransitionImpl.setSharedElementTargets(objWrapTransitionInSet, view7, arrayList4);
                    ArrayMap arrayMap42 = arrayMap;
                    ArrayList<View> arrayList62 = arrayList5;
                    fragmentTransitionImpl.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList62);
                    Boolean bool2 = Boolean.TRUE;
                    linkedHashMap3.put(firstOut, bool2);
                    linkedHashMap3.put(operation2, bool2);
                    view5 = view3;
                    obj7 = objWrapTransitionInSet;
                    arrayList4 = arrayList4;
                    arrayMap = arrayMap42;
                    view4 = view7;
                    linkedHashMap2 = linkedHashMap3;
                    arrayList5 = arrayList62;
                }
            }
        }
        ArrayList<View> arrayList7 = arrayList4;
        ArrayMap arrayMap5 = arrayMap;
        ArrayList<View> arrayList8 = arrayList5;
        View view13 = view5;
        boolean z8 = false;
        LinkedHashMap linkedHashMap4 = linkedHashMap2;
        View view14 = view4;
        ArrayList arrayList9 = new ArrayList();
        Iterator<TransitionInfo> it = transitionInfos.iterator();
        Object objMergeTransitionsTogether = null;
        Object obj8 = null;
        while (it.hasNext()) {
            TransitionInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                linkedHashMap4.put(next.getOperation(), Boolean.FALSE);
                next.completeSpecialEffect();
            } else {
                Object objCloneTransition = fragmentTransitionImpl.cloneTransition(next.getTransition());
                SpecialEffectsController.Operation operation3 = next.getOperation();
                boolean z9 = (obj7 == null || !(operation3 == firstOut || operation3 == operation2)) ? z8 : true;
                if (objCloneTransition != null) {
                    LinkedHashMap linkedHashMap5 = linkedHashMap4;
                    ArrayList<View> arrayList10 = new ArrayList<>();
                    View view15 = operation3.getFragment().mView;
                    Iterator<TransitionInfo> it2 = it;
                    kotlin.jvm.internal.h.e(view15, "operation.fragment.mView");
                    r02.captureTransitioningViews(arrayList10, view15);
                    if (z9) {
                        if (operation3 == firstOut) {
                            arrayList10.removeAll(m.s0(arrayList7));
                        } else {
                            arrayList10.removeAll(m.s0(arrayList8));
                        }
                    }
                    if (arrayList10.isEmpty()) {
                        fragmentTransitionImpl.addTarget(objCloneTransition, view14);
                        obj = objMergeTransitionsTogether;
                        obj4 = obj8;
                        obj2 = objCloneTransition;
                        operation = operation3;
                        arrayList = arrayList8;
                        view = view13;
                        linkedHashMap = linkedHashMap5;
                        view2 = view14;
                        obj3 = obj7;
                    } else {
                        fragmentTransitionImpl.addTargets(objCloneTransition, arrayList10);
                        obj = objMergeTransitionsTogether;
                        obj2 = objCloneTransition;
                        arrayList = arrayList8;
                        view = view13;
                        linkedHashMap = linkedHashMap5;
                        view2 = view14;
                        obj3 = obj7;
                        obj4 = obj8;
                        fragmentTransitionImpl.scheduleRemoveTargets(obj2, obj2, arrayList10, null, null, null, null);
                        if (operation3.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation = operation3;
                            awaitingContainerChanges.remove(operation);
                            ArrayList<View> arrayList11 = new ArrayList<>(arrayList10);
                            arrayList11.remove(operation.getFragment().mView);
                            fragmentTransitionImpl.scheduleHideFragmentView(obj2, operation.getFragment().mView, arrayList11);
                            OneShotPreDrawListener.add(getContainer(), new androidx.constraintlayout.helper.widget.a(arrayList10, 1));
                        } else {
                            operation = operation3;
                        }
                    }
                    if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList9.addAll(arrayList10);
                        if (z7) {
                            fragmentTransitionImpl.setEpicenter(obj2, rect);
                        }
                    } else {
                        fragmentTransitionImpl.setEpicenter(obj2, view);
                    }
                    linkedHashMap.put(operation, Boolean.TRUE);
                    if (next.getIsOverlapAllowed()) {
                        objMergeTransitionsTogether = fragmentTransitionImpl.mergeTransitionsTogether(obj, obj2, null);
                        it = it2;
                        linkedHashMap4 = linkedHashMap;
                        obj7 = obj3;
                        obj8 = obj4;
                        view14 = view2;
                        arrayList8 = arrayList;
                        z8 = false;
                        r02 = this;
                    } else {
                        Object objMergeTransitionsTogether2 = fragmentTransitionImpl.mergeTransitionsTogether(obj4, obj2, null);
                        linkedHashMap4 = linkedHashMap;
                        obj7 = obj3;
                        objMergeTransitionsTogether = obj;
                        obj8 = objMergeTransitionsTogether2;
                        view14 = view2;
                        arrayList8 = arrayList;
                        z8 = false;
                        r02 = this;
                        it = it2;
                    }
                    view13 = view;
                    operation2 = lastIn;
                } else if (!z9) {
                    linkedHashMap4.put(operation3, Boolean.FALSE);
                    next.completeSpecialEffect();
                }
            }
        }
        LinkedHashMap linkedHashMap6 = linkedHashMap4;
        Object obj9 = obj7;
        ArrayList<View> arrayList12 = arrayList8;
        Object objMergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(objMergeTransitionsTogether, obj8, obj9);
        if (objMergeTransitionsInSequence == null) {
            return linkedHashMap6;
        }
        ArrayList<TransitionInfo> arrayList13 = new ArrayList();
        for (Object obj10 : transitionInfos) {
            if (!((TransitionInfo) obj10).isVisibilityUnchanged()) {
                arrayList13.add(obj10);
            }
        }
        for (TransitionInfo transitionInfo4 : arrayList13) {
            Object transition = transitionInfo4.getTransition();
            SpecialEffectsController.Operation operation4 = transitionInfo4.getOperation();
            boolean z10 = obj9 != null && (operation4 == firstOut || operation4 == lastIn);
            if (transition != null || z10) {
                if (ViewCompat.isLaidOut(getContainer())) {
                    fragmentTransitionImpl.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), objMergeTransitionsInSequence, transitionInfo4.getSignal(), new i(transitionInfo4, operation4, 2));
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString(getContainer());
                        Objects.toString(operation4);
                    }
                    transitionInfo4.completeSpecialEffect();
                }
            }
        }
        if (!ViewCompat.isLaidOut(getContainer())) {
            return linkedHashMap6;
        }
        FragmentTransition.setViewVisibility(arrayList9, 4);
        ArrayList<String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList12);
        if (FragmentManager.isLoggingEnabled(2)) {
            for (View sharedElementFirstOutViews : arrayList7) {
                kotlin.jvm.internal.h.e(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                View view16 = sharedElementFirstOutViews;
                view16.toString();
                ViewCompat.getTransitionName(view16);
            }
            for (View sharedElementLastInViews : arrayList12) {
                kotlin.jvm.internal.h.e(sharedElementLastInViews, "sharedElementLastInViews");
                View view17 = sharedElementLastInViews;
                view17.toString();
                ViewCompat.getTransitionName(view17);
            }
        }
        fragmentTransitionImpl.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
        fragmentTransitionImpl.setNameOverridesReordered(getContainer(), arrayList7, arrayList12, arrayListPrepareSetNameOverridesReordered, arrayMap5);
        FragmentTransition.setViewVisibility(arrayList9, 0);
        fragmentTransitionImpl.swapSharedElementTargets(obj9, arrayList7, arrayList12);
        return linkedHashMap6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$10(FragmentTransitionImpl impl, View view, Rect lastInEpicenterRect) {
        kotlin.jvm.internal.h.f(impl, "$impl");
        kotlin.jvm.internal.h.f(lastInEpicenterRect, "$lastInEpicenterRect");
        impl.getBoundsOnScreen(view, lastInEpicenterRect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$11(ArrayList transitioningViews) {
        kotlin.jvm.internal.h.f(transitioningViews, "$transitioningViews");
        FragmentTransition.setViewVisibility(transitioningViews, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$14$lambda$13(TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
        kotlin.jvm.internal.h.f(transitionInfo, "$transitionInfo");
        kotlin.jvm.internal.h.f(operation, "$operation");
        transitionInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            operation.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$9(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z6, ArrayMap lastInViews) {
        kotlin.jvm.internal.h.f(lastInViews, "$lastInViews");
        FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), z6, lastInViews, false);
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> operations) {
        Fragment fragment = ((SpecialEffectsController.Operation) m.X(operations)).getFragment();
        for (SpecialEffectsController.Operation operation : operations) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void executeOperations(java.util.List<? extends androidx.fragment.app.SpecialEffectsController.Operation> r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.executeOperations(java.util.List, boolean):void");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "signal", "Landroidx/core/os/CancellationSignal;", "isPop", "", "providesSharedElementTransition", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/core/os/CancellationSignal;ZZ)V", "handlingImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "getHandlingImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "isOverlapAllowed", "()Z", "sharedElementTransition", "", "getSharedElementTransition", "()Ljava/lang/Object;", "transition", "getTransition", "hasSharedElementTransition", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean z6, boolean z7) {
            Object returnTransition;
            super(operation, signal);
            kotlin.jvm.internal.h.f(operation, "operation");
            kotlin.jvm.internal.h.f(signal, "signal");
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (finalState == state) {
                Fragment fragment = operation.getFragment();
                returnTransition = z6 ? fragment.getReenterTransition() : fragment.getEnterTransition();
            } else {
                Fragment fragment2 = operation.getFragment();
                returnTransition = z6 ? fragment2.getReturnTransition() : fragment2.getExitTransition();
            }
            this.transition = returnTransition;
            this.isOverlapAllowed = operation.getFinalState() == state ? z6 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap() : true;
            this.sharedElementTransition = z7 ? z6 ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition() : null;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean hasSharedElementTransition() {
            return this.sharedElementTransition != null;
        }

        /* JADX INFO: renamed from: isOverlapAllowed, reason: from getter */
        public final boolean getIsOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        private final FragmentTransitionImpl getHandlingImpl(Object transition) {
            if (transition == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(transition)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(transition)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + transition + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
