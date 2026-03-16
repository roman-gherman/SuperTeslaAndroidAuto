package androidx.navigation.fragment;

import N1.m;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavigatorState;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LN1/m;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class FragmentNavigator$attachClearViewModel$1 extends i implements Function0<m> {
    final /* synthetic */ NavBackStackEntry $entry;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ NavigatorState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavigator$attachClearViewModel$1(NavBackStackEntry navBackStackEntry, NavigatorState navigatorState, Fragment fragment) {
        super(0);
        this.$entry = navBackStackEntry;
        this.$state = navigatorState;
        this.$fragment = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ m invoke() {
        invoke2();
        return m.f1129a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NavigatorState navigatorState = this.$state;
        Fragment fragment = this.$fragment;
        for (NavBackStackEntry navBackStackEntry : navigatorState.getTransitionsInProgress().getValue()) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(navBackStackEntry);
                Objects.toString(fragment);
            }
            navigatorState.markTransitionComplete(navBackStackEntry);
        }
    }
}
