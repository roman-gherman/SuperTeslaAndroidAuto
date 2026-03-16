package androidx.navigation.fragment;

import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleEventObserver;", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FragmentNavigator$fragmentViewObserver$1 extends i implements Function1<NavBackStackEntry, LifecycleEventObserver> {
    final /* synthetic */ FragmentNavigator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavigator$fragmentViewObserver$1(FragmentNavigator fragmentNavigator) {
        super(1);
        this.this$0 = fragmentNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(FragmentNavigator this$0, NavBackStackEntry entry, LifecycleOwner owner, Lifecycle.Event event) {
        h.f(this$0, "this$0");
        h.f(entry, "$entry");
        h.f(owner, "owner");
        h.f(event, "event");
        if (event == Lifecycle.Event.ON_RESUME && this$0.getState().getBackStack().getValue().contains(entry)) {
            if (FragmentManager.isLoggingEnabled(2)) {
                entry.toString();
                owner.toString();
            }
            this$0.getState().markTransitionComplete(entry);
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (FragmentManager.isLoggingEnabled(2)) {
                entry.toString();
                owner.toString();
            }
            this$0.getState().markTransitionComplete(entry);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final LifecycleEventObserver invoke(final NavBackStackEntry entry) {
        h.f(entry, "entry");
        final FragmentNavigator fragmentNavigator = this.this$0;
        return new LifecycleEventObserver() { // from class: androidx.navigation.fragment.d
            @Override // android.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                FragmentNavigator$fragmentViewObserver$1.invoke$lambda$0(fragmentNavigator, entry, lifecycleOwner, event);
            }
        };
    }
}
