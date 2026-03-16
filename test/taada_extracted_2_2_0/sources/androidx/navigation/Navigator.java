package androidx.navigation;

import N1.m;
import android.os.Bundle;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.ListIterator;
import k3.e;
import k3.p;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002./B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0014\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00028\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u001cJ\u001f\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010 \u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010*\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "D", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroidx/navigation/NavigatorState;", "state", "LN1/m;", "onAttach", "(Landroidx/navigation/NavigatorState;)V", "createDestination", "()Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "navigate", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "backStackEntry", "onLaunchSingleTop", "(Landroidx/navigation/NavBackStackEntry;)V", "destination", "Landroid/os/Bundle;", "args", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "popUpTo", "", "savedState", "popBackStack", "(Landroidx/navigation/NavBackStackEntry;Z)V", "()Z", "onSaveState", "()Landroid/os/Bundle;", "onRestoreState", "(Landroid/os/Bundle;)V", "_state", "Landroidx/navigation/NavigatorState;", "<set-?>", "isAttached", "Z", "getState", "()Landroidx/navigation/NavigatorState;", "Extras", "Name", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Navigator<D extends NavDestination> {
    private NavigatorState _state;
    private boolean isAttached;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/navigation/Navigator$Extras;", "", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Extras {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/Navigator$Name;", "", "value", "", "()Ljava/lang/String;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {O1.b.b, O1.b.f1179a})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(O1.a.c)
    public @interface Name {
        String value();
    }

    /* JADX INFO: renamed from: androidx.navigation.Navigator$navigate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/navigation/NavBackStackEntry;", "D", "Landroidx/navigation/NavDestination;", "backStackEntry", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends i implements Function1<NavBackStackEntry, NavBackStackEntry> {
        final /* synthetic */ NavOptions $navOptions;
        final /* synthetic */ Extras $navigatorExtras;
        final /* synthetic */ Navigator<D> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Navigator<D> navigator, NavOptions navOptions, Extras extras) {
            super(1);
            this.this$0 = navigator;
            this.$navOptions = navOptions;
            this.$navigatorExtras = extras;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NavBackStackEntry invoke(NavBackStackEntry backStackEntry) {
            NavDestination navDestinationNavigate;
            h.f(backStackEntry, "backStackEntry");
            NavDestination destination = backStackEntry.getDestination();
            if (destination == null) {
                destination = null;
            }
            if (destination == null || (navDestinationNavigate = this.this$0.navigate(destination, backStackEntry.getArguments(), this.$navOptions, this.$navigatorExtras)) == null) {
                return null;
            }
            return navDestinationNavigate.equals(destination) ? backStackEntry : this.this$0.getState().createBackStackEntry(navDestinationNavigate, navDestinationNavigate.addInDefaultArgs(backStackEntry.getArguments()));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.Navigator$onLaunchSingleTop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/navigation/NavDestination;", "D", "Landroidx/navigation/NavOptionsBuilder;", "LN1/m;", "invoke", "(Landroidx/navigation/NavOptionsBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02131 extends i implements Function1<NavOptionsBuilder, m> {
        public static final C02131 INSTANCE = new C02131();

        public C02131() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(NavOptionsBuilder navOptionsBuilder) {
            invoke2(navOptionsBuilder);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavOptionsBuilder navOptions) {
            h.f(navOptions, "$this$navOptions");
            navOptions.setLaunchSingleTop(true);
        }
    }

    public abstract D createDestination();

    public final NavigatorState getState() {
        NavigatorState navigatorState = this._state;
        if (navigatorState != null) {
            return navigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    /* JADX INFO: renamed from: isAttached, reason: from getter */
    public final boolean getIsAttached() {
        return this.isAttached;
    }

    public NavDestination navigate(D destination, Bundle args, NavOptions navOptions, Extras navigatorExtras) {
        h.f(destination, "destination");
        return destination;
    }

    public void onAttach(NavigatorState state) {
        h.f(state, "state");
        this._state = state;
        this.isAttached = true;
    }

    public void onLaunchSingleTop(NavBackStackEntry backStackEntry) {
        h.f(backStackEntry, "backStackEntry");
        NavDestination destination = backStackEntry.getDestination();
        if (destination == null) {
            destination = null;
        }
        if (destination == null) {
            return;
        }
        navigate(destination, null, NavOptionsBuilderKt.navOptions(C02131.INSTANCE), null);
        getState().onLaunchSingleTop(backStackEntry);
    }

    public void onRestoreState(Bundle savedState) {
        h.f(savedState, "savedState");
    }

    public Bundle onSaveState() {
        return null;
    }

    public boolean popBackStack() {
        return true;
    }

    public void navigate(List<NavBackStackEntry> entries, NavOptions navOptions, Extras navigatorExtras) {
        h.f(entries, "entries");
        e eVar = new e(k3.m.x(k3.m.D(kotlin.collections.m.K(entries), new AnonymousClass1(this, navOptions, navigatorExtras)), p.d));
        while (eVar.hasNext()) {
            getState().push((NavBackStackEntry) eVar.next());
        }
    }

    public void popBackStack(NavBackStackEntry popUpTo, boolean savedState) {
        h.f(popUpTo, "popUpTo");
        List<NavBackStackEntry> value = getState().getBackStack().getValue();
        if (!value.contains(popUpTo)) {
            throw new IllegalStateException(("popBackStack was called with " + popUpTo + " which does not exist in back stack " + value).toString());
        }
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        NavBackStackEntry navBackStackEntryPrevious = null;
        while (popBackStack()) {
            navBackStackEntryPrevious = listIterator.previous();
            if (h.a(navBackStackEntryPrevious, popUpTo)) {
                break;
            }
        }
        if (navBackStackEntryPrevious != null) {
            getState().pop(navBackStackEntryPrevious, savedState);
        }
    }
}
