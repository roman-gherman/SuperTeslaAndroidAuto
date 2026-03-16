package androidx.navigation.fragment;

import N1.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleObserver;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewModel;
import android.view.ViewModelProvider;
import android.view.ViewModelStore;
import android.view.viewmodel.CreationExtras;
import android.view.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.NavigatorState;
import e2.C0429e;
import e2.C0430f;
import fr.sd.taada.helpers.LocaleHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import k3.u;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.flow.StateFlow;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("fragment")
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004UTVWB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J'\u0010(\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b&\u0010'J\u001f\u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001dH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010.J1\u00102\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u000100H\u0017¢\u0006\u0004\b2\u00103J1\u0010\u0016\u001a\u00020\u000f2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u00106J\u0017\u00108\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000bH\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u000f2\u0006\u0010*\u001a\u000200H\u0016¢\u0006\u0004\b<\u0010=R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010>R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010?R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010@R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR,\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001d0E0D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR \u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020J0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b040P8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006X"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "containerId", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/fragment/app/Fragment;", "fragment", "LN1/m;", "attachObservers", "(Landroidx/navigation/NavBackStackEntry;Landroidx/fragment/app/Fragment;)V", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "navigate", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/fragment/app/FragmentTransaction;", "createFragmentTransaction", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavOptions;)Landroidx/fragment/app/FragmentTransaction;", "", "id", "", "isPop", "deduplicate", "addPendingOps", "(Ljava/lang/String;ZZ)V", "Landroidx/navigation/NavigatorState;", "state", "onAttach", "(Landroidx/navigation/NavigatorState;)V", "attachClearViewModel$navigation_fragment_release", "(Landroidx/fragment/app/Fragment;Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavigatorState;)V", "attachClearViewModel", "popUpTo", "savedState", "popBackStack", "(Landroidx/navigation/NavBackStackEntry;Z)V", "createDestination", "()Landroidx/navigation/fragment/FragmentNavigator$Destination;", "className", "Landroid/os/Bundle;", "args", "instantiateFragment", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/fragment/app/Fragment;", "", "entries", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "backStackEntry", "onLaunchSingleTop", "(Landroidx/navigation/NavBackStackEntry;)V", "onSaveState", "()Landroid/os/Bundle;", "onRestoreState", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "Landroidx/fragment/app/FragmentManager;", "I", "", "savedIds", "Ljava/util/Set;", "", "LN1/e;", "pendingOps", "Ljava/util/List;", "getPendingOps$navigation_fragment_release", "()Ljava/util/List;", "Landroidx/lifecycle/LifecycleEventObserver;", "fragmentObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "Lkotlin/Function1;", "fragmentViewObserver", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/flow/StateFlow;", "getBackStack$navigation_fragment_release", "()Lkotlinx/coroutines/flow/StateFlow;", "backStack", "Companion", "ClearEntryStateViewModel", "Destination", "Extras", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class FragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = new Companion(null);
    private static final String KEY_SAVED_IDS = "androidx-nav-fragment:navigator:savedIds";
    private static final String TAG = "FragmentNavigator";
    private final int containerId;
    private final Context context;
    private final FragmentManager fragmentManager;
    private final LifecycleEventObserver fragmentObserver;
    private final Function1<NavBackStackEntry, LifecycleEventObserver> fragmentViewObserver;
    private final List<N1.e> pendingOps;
    private final Set<String> savedIds;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003R.\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$ClearEntryStateViewModel;", "Landroidx/lifecycle/ViewModel;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "LN1/m;", "onCleared", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function0;", "completeTransition", "Ljava/lang/ref/WeakReference;", "getCompleteTransition", "()Ljava/lang/ref/WeakReference;", "setCompleteTransition", "(Ljava/lang/ref/WeakReference;)V", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ClearEntryStateViewModel extends ViewModel {
        public WeakReference<Function0<m>> completeTransition;

        public final WeakReference<Function0<m>> getCompleteTransition() {
            WeakReference<Function0<m>> weakReference = this.completeTransition;
            if (weakReference != null) {
                return weakReference;
            }
            h.n("completeTransition");
            throw null;
        }

        @Override // android.view.ViewModel
        public void onCleared() {
            super.onCleared();
            Function0<m> function0 = getCompleteTransition().get();
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void setCompleteTransition(WeakReference<Function0<m>> weakReference) {
            h.f(weakReference, "<set-?>");
            this.completeTransition = weakReference;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "()V", "KEY_SAVED_IDS", "", "TAG", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.d dVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010\u0015¨\u0006!"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/Navigator;", "fragmentNavigator", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavigatorProvider;", "navigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "LN1/m;", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "className", "setClassName", "(Ljava/lang/String;)Landroidx/navigation/fragment/FragmentNavigator$Destination;", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "_className", "Ljava/lang/String;", "getClassName", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Destination extends NavDestination {
        private String _className;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> fragmentNavigator) {
            super(fragmentNavigator);
            h.f(fragmentNavigator, "fragmentNavigator");
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return other != null && (other instanceof Destination) && super.equals(other) && h.a(this._className, ((Destination) other)._className);
        }

        public final String getClassName() {
            String str = this._className;
            if (str == null) {
                throw new IllegalStateException("Fragment class was not set");
            }
            h.d(str, "null cannot be cast to non-null type kotlin.String");
            return str;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            String str = this._className;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.NavDestination
        public void onInflate(Context context, AttributeSet attrs) {
            h.f(context, "context");
            h.f(attrs, "attrs");
            super.onInflate(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.FragmentNavigator);
            h.e(typedArrayObtainAttributes, "context.resources.obtain…leable.FragmentNavigator)");
            String string = typedArrayObtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            typedArrayObtainAttributes.recycle();
        }

        public final Destination setClassName(String className) {
            h.f(className, "className");
            this._className = className;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this._className;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            String string = sb.toString();
            h.e(string, "sb.toString()");
            return string;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Destination(NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(FragmentNavigator.class));
            h.f(navigatorProvider, "navigatorProvider");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "sharedElements", "", "Landroid/view/View;", "", "(Ljava/util/Map;)V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getSharedElements", "()Ljava/util/Map;", "Builder", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> _sharedElements;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\rJ\u0006\u0010\u000e\u001a\u00020\u000fR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "()V", "_sharedElements", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "addSharedElement", "sharedElement", "name", "addSharedElements", "sharedElements", "", "build", "Landroidx/navigation/fragment/FragmentNavigator$Extras;", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Builder {
            private final LinkedHashMap<View, String> _sharedElements = new LinkedHashMap<>();

            public final Builder addSharedElement(View sharedElement, String name) {
                h.f(sharedElement, "sharedElement");
                h.f(name, "name");
                this._sharedElements.put(sharedElement, name);
                return this;
            }

            public final Builder addSharedElements(Map<View, String> sharedElements) {
                h.f(sharedElements, "sharedElements");
                for (Map.Entry<View, String> entry : sharedElements.entrySet()) {
                    addSharedElement(entry.getKey(), entry.getValue());
                }
                return this;
            }

            public final Extras build() {
                return new Extras(this._sharedElements);
            }
        }

        public Extras(Map<View, String> sharedElements) {
            h.f(sharedElements, "sharedElements");
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this._sharedElements = linkedHashMap;
            linkedHashMap.putAll(sharedElements);
        }

        public final Map<View, String> getSharedElements() {
            return A.M(this._sharedElements);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.fragment.FragmentNavigator$addPendingOps$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LN1/e;", "", "", LocaleHelper.LANGUAGE_ITALIAN, "invoke", "(LN1/e;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends i implements Function1<N1.e, Boolean> {
        final /* synthetic */ String $id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$id = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(N1.e it) {
            h.f(it, "it");
            return Boolean.valueOf(h.a(it.f1121a, this.$id));
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.fragment.FragmentNavigator$attachObservers$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/lifecycle/LifecycleOwner;", "kotlin.jvm.PlatformType", "owner", "LN1/m;", "invoke", "(Landroidx/lifecycle/LifecycleOwner;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C02141 extends i implements Function1<LifecycleOwner, m> {
        final /* synthetic */ NavBackStackEntry $entry;
        final /* synthetic */ Fragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02141(Fragment fragment, NavBackStackEntry navBackStackEntry) {
            super(1);
            this.$fragment = fragment;
            this.$entry = navBackStackEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ m invoke(LifecycleOwner lifecycleOwner) {
            invoke2(lifecycleOwner);
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LifecycleOwner lifecycleOwner) {
            List<N1.e> pendingOps$navigation_fragment_release = FragmentNavigator.this.getPendingOps$navigation_fragment_release();
            Fragment fragment = this.$fragment;
            boolean z6 = false;
            if (pendingOps$navigation_fragment_release == null || !pendingOps$navigation_fragment_release.isEmpty()) {
                Iterator<T> it = pendingOps$navigation_fragment_release.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (h.a(((N1.e) it.next()).f1121a, fragment.getTag())) {
                        z6 = true;
                        break;
                    }
                }
            }
            if (lifecycleOwner == null || z6) {
                return;
            }
            Lifecycle lifecycle = this.$fragment.getViewLifecycleOwner().getLifecycle();
            if (lifecycle.getState().isAtLeast(Lifecycle.State.CREATED)) {
                lifecycle.addObserver((LifecycleObserver) FragmentNavigator.this.fragmentViewObserver.invoke(this.$entry));
            }
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i) {
        h.f(context, "context");
        h.f(fragmentManager, "fragmentManager");
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.containerId = i;
        this.savedIds = new LinkedHashSet();
        this.pendingOps = new ArrayList();
        this.fragmentObserver = new LifecycleEventObserver() { // from class: androidx.navigation.fragment.b
            @Override // android.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                FragmentNavigator.fragmentObserver$lambda$1(this.f1653a, lifecycleOwner, event);
            }
        };
        this.fragmentViewObserver = new FragmentNavigator$fragmentViewObserver$1(this);
    }

    private final void addPendingOps(String id, boolean isPop, boolean deduplicate) {
        int iX;
        if (deduplicate) {
            List<N1.e> list = this.pendingOps;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(id);
            h.f(list, "<this>");
            if (list instanceof RandomAccess) {
                int i = 0;
                C0429e it = new C0430f(0, n.x(list), 1).iterator();
                while (it.c) {
                    int iNextInt = it.nextInt();
                    N1.e eVar = list.get(iNextInt);
                    if (!anonymousClass1.invoke(eVar).booleanValue()) {
                        if (i != iNextInt) {
                            list.set(i, eVar);
                        }
                        i++;
                    }
                }
                if (i < list.size() && i <= (iX = n.x(list))) {
                    while (true) {
                        list.remove(iX);
                        if (iX == i) {
                            break;
                        } else {
                            iX--;
                        }
                    }
                }
            } else {
                if ((list instanceof KMappedMarker) && !(list instanceof KMutableIterable)) {
                    z.f(list, "kotlin.collections.MutableIterable");
                    throw null;
                }
                s.H(list, anonymousClass1, true);
            }
        }
        this.pendingOps.add(new N1.e(id, Boolean.valueOf(isPop)));
    }

    public static /* synthetic */ void addPendingOps$default(FragmentNavigator fragmentNavigator, String str, boolean z6, boolean z7, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPendingOps");
        }
        if ((i & 2) != 0) {
            z6 = false;
        }
        if ((i & 4) != 0) {
            z7 = true;
        }
        fragmentNavigator.addPendingOps(str, z6, z7);
    }

    private final void attachObservers(NavBackStackEntry entry, Fragment fragment) {
        fragment.getViewLifecycleOwnerLiveData().observe(fragment, new FragmentNavigator$sam$androidx_lifecycle_Observer$0(new C02141(fragment, entry)));
        fragment.getLifecycle().addObserver(this.fragmentObserver);
    }

    private final FragmentTransaction createFragmentTransaction(NavBackStackEntry entry, NavOptions navOptions) {
        NavDestination destination = entry.getDestination();
        h.d(destination, "null cannot be cast to non-null type androidx.navigation.fragment.FragmentNavigator.Destination");
        Bundle arguments = entry.getArguments();
        String className = ((Destination) destination).getClassName();
        if (className.charAt(0) == '.') {
            className = this.context.getPackageName() + className;
        }
        Fragment fragmentInstantiate = this.fragmentManager.getFragmentFactory().instantiate(this.context.getClassLoader(), className);
        h.e(fragmentInstantiate, "fragmentManager.fragment…t.classLoader, className)");
        fragmentInstantiate.setArguments(arguments);
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        h.e(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        int enterAnim = navOptions != null ? navOptions.getEnterAnim() : -1;
        int exitAnim = navOptions != null ? navOptions.getExitAnim() : -1;
        int popEnterAnim = navOptions != null ? navOptions.getPopEnterAnim() : -1;
        int popExitAnim = navOptions != null ? navOptions.getPopExitAnim() : -1;
        if (enterAnim != -1 || exitAnim != -1 || popEnterAnim != -1 || popExitAnim != -1) {
            if (enterAnim == -1) {
                enterAnim = 0;
            }
            if (exitAnim == -1) {
                exitAnim = 0;
            }
            if (popEnterAnim == -1) {
                popEnterAnim = 0;
            }
            fragmentTransactionBeginTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim != -1 ? popExitAnim : 0);
        }
        fragmentTransactionBeginTransaction.replace(this.containerId, fragmentInstantiate, entry.getId());
        fragmentTransactionBeginTransaction.setPrimaryNavigationFragment(fragmentInstantiate);
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        return fragmentTransactionBeginTransaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fragmentObserver$lambda$1(FragmentNavigator this$0, LifecycleOwner source, Lifecycle.Event event) {
        h.f(this$0, "this$0");
        h.f(source, "source");
        h.f(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            Fragment fragment = (Fragment) source;
            Object obj = null;
            for (Object obj2 : this$0.getState().getTransitionsInProgress().getValue()) {
                if (h.a(((NavBackStackEntry) obj2).getId(), fragment.getTag())) {
                    obj = obj2;
                }
            }
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (navBackStackEntry != null) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    navBackStackEntry.toString();
                    source.toString();
                }
                this$0.getState().markTransitionComplete(navBackStackEntry);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttach$lambda$3(NavigatorState state, FragmentNavigator this$0, FragmentManager fragmentManager, Fragment fragment) {
        NavBackStackEntry navBackStackEntryPrevious;
        h.f(state, "$state");
        h.f(this$0, "this$0");
        h.f(fragmentManager, "<anonymous parameter 0>");
        h.f(fragment, "fragment");
        List<NavBackStackEntry> value = state.getBackStack().getValue();
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            } else {
                navBackStackEntryPrevious = listIterator.previous();
                if (h.a(navBackStackEntryPrevious.getId(), fragment.getTag())) {
                    break;
                }
            }
        }
        NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
        if (FragmentManager.isLoggingEnabled(2)) {
            fragment.toString();
            Objects.toString(navBackStackEntry);
            Objects.toString(this$0.fragmentManager);
        }
        if (navBackStackEntry != null) {
            this$0.attachObservers(navBackStackEntry, fragment);
            this$0.attachClearViewModel$navigation_fragment_release(fragment, navBackStackEntry, state);
        }
    }

    public final void attachClearViewModel$navigation_fragment_release(Fragment fragment, NavBackStackEntry entry, NavigatorState state) {
        h.f(fragment, "fragment");
        h.f(entry, "entry");
        h.f(state, "state");
        ViewModelStore viewModelStore = fragment.getViewModelStore();
        h.e(viewModelStore, "fragment.viewModelStore");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(w.f3817a.b(ClearEntryStateViewModel.class), FragmentNavigator$attachClearViewModel$viewModel$1$1.INSTANCE);
        ((ClearEntryStateViewModel) new ViewModelProvider(viewModelStore, initializerViewModelFactoryBuilder.build(), CreationExtras.Empty.INSTANCE).get(ClearEntryStateViewModel.class)).setCompleteTransition(new WeakReference<>(new FragmentNavigator$attachClearViewModel$1(entry, state, fragment)));
    }

    public final StateFlow<List<NavBackStackEntry>> getBackStack$navigation_fragment_release() {
        return getState().getBackStack();
    }

    public final List<N1.e> getPendingOps$navigation_fragment_release() {
        return this.pendingOps;
    }

    @Deprecated(message = "Set a custom {@link androidx.fragment.app.FragmentFactory} via\n      {@link FragmentManager#setFragmentFactory(FragmentFactory)} to control\n      instantiation of Fragments.")
    public Fragment instantiateFragment(Context context, FragmentManager fragmentManager, String className, Bundle args) {
        h.f(context, "context");
        h.f(fragmentManager, "fragmentManager");
        h.f(className, "className");
        Fragment fragmentInstantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), className);
        h.e(fragmentInstantiate, "fragmentManager.fragment…t.classLoader, className)");
        return fragmentInstantiate;
    }

    @Override // androidx.navigation.Navigator
    public void navigate(List<NavBackStackEntry> entries, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        h.f(entries, "entries");
        if (this.fragmentManager.isStateSaved()) {
            return;
        }
        Iterator<NavBackStackEntry> it = entries.iterator();
        while (it.hasNext()) {
            navigate(it.next(), navOptions, navigatorExtras);
        }
    }

    @Override // androidx.navigation.Navigator
    public void onAttach(final NavigatorState state) {
        h.f(state, "state");
        super.onAttach(state);
        FragmentManager.isLoggingEnabled(2);
        this.fragmentManager.addFragmentOnAttachListener(new FragmentOnAttachListener() { // from class: androidx.navigation.fragment.c
            @Override // androidx.fragment.app.FragmentOnAttachListener
            public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
                FragmentNavigator.onAttach$lambda$3(state, this, fragmentManager, fragment);
            }
        });
        this.fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: androidx.navigation.fragment.FragmentNavigator.onAttach.2
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void onBackStackChangeCommitted(Fragment fragment, boolean pop) {
                Object obj;
                Object objPrevious;
                h.f(fragment, "fragment");
                ArrayList arrayListB0 = kotlin.collections.m.b0(state.getTransitionsInProgress().getValue(), state.getBackStack().getValue());
                ListIterator listIterator = arrayListB0.listIterator(arrayListB0.size());
                while (true) {
                    obj = null;
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    } else {
                        objPrevious = listIterator.previous();
                        if (h.a(((NavBackStackEntry) objPrevious).getId(), fragment.getTag())) {
                            break;
                        }
                    }
                }
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
                boolean z6 = pop && this.getPendingOps$navigation_fragment_release().isEmpty() && fragment.isRemoving();
                Iterator<T> it = this.getPendingOps$navigation_fragment_release().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (h.a(((N1.e) next).f1121a, fragment.getTag())) {
                        obj = next;
                        break;
                    }
                }
                N1.e eVar = (N1.e) obj;
                if (eVar != null) {
                    this.getPendingOps$navigation_fragment_release().remove(eVar);
                }
                if (!z6 && FragmentManager.isLoggingEnabled(2)) {
                    fragment.toString();
                    Objects.toString(navBackStackEntry);
                }
                boolean z7 = eVar != null && ((Boolean) eVar.b).booleanValue();
                if (!pop && !z7 && navBackStackEntry == null) {
                    throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.o("The fragment ", fragment, " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.").toString());
                }
                if (navBackStackEntry != null) {
                    this.attachClearViewModel$navigation_fragment_release(fragment, navBackStackEntry, state);
                    if (z6) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            fragment.toString();
                            navBackStackEntry.toString();
                        }
                        state.popWithTransition(navBackStackEntry, false);
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void onBackStackChangeStarted(Fragment fragment, boolean pop) {
                NavBackStackEntry navBackStackEntryPrevious;
                h.f(fragment, "fragment");
                if (pop) {
                    List<NavBackStackEntry> value = state.getBackStack().getValue();
                    ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntryPrevious = null;
                            break;
                        } else {
                            navBackStackEntryPrevious = listIterator.previous();
                            if (h.a(navBackStackEntryPrevious.getId(), fragment.getTag())) {
                                break;
                            }
                        }
                    }
                    NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        fragment.toString();
                        Objects.toString(navBackStackEntry);
                    }
                    if (navBackStackEntry != null) {
                        state.prepareForTransition(navBackStackEntry);
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void onBackStackChanged() {
            }
        });
    }

    @Override // androidx.navigation.Navigator
    public void onLaunchSingleTop(NavBackStackEntry backStackEntry) {
        h.f(backStackEntry, "backStackEntry");
        if (this.fragmentManager.isStateSaved()) {
            return;
        }
        FragmentTransaction fragmentTransactionCreateFragmentTransaction = createFragmentTransaction(backStackEntry, null);
        List<NavBackStackEntry> value = getState().getBackStack().getValue();
        if (value.size() > 1) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) kotlin.collections.m.S(n.x(value) - 1, value);
            if (navBackStackEntry != null) {
                addPendingOps$default(this, navBackStackEntry.getId(), false, false, 6, null);
            }
            addPendingOps$default(this, backStackEntry.getId(), true, false, 4, null);
            this.fragmentManager.popBackStack(backStackEntry.getId(), 1);
            addPendingOps$default(this, backStackEntry.getId(), false, false, 2, null);
            fragmentTransactionCreateFragmentTransaction.addToBackStack(backStackEntry.getId());
        }
        fragmentTransactionCreateFragmentTransaction.commit();
        getState().onLaunchSingleTop(backStackEntry);
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(Bundle savedState) {
        h.f(savedState, "savedState");
        ArrayList<String> stringArrayList = savedState.getStringArrayList(KEY_SAVED_IDS);
        if (stringArrayList != null) {
            this.savedIds.clear();
            s.F(stringArrayList, this.savedIds);
        }
    }

    @Override // androidx.navigation.Navigator
    public Bundle onSaveState() {
        if (this.savedIds.isEmpty()) {
            return null;
        }
        return BundleKt.bundleOf(new N1.e(KEY_SAVED_IDS, new ArrayList(this.savedIds)));
    }

    @Override // androidx.navigation.Navigator
    public void popBackStack(NavBackStackEntry popUpTo, boolean savedState) {
        FragmentNavigator fragmentNavigator = this;
        h.f(popUpTo, "popUpTo");
        if (fragmentNavigator.fragmentManager.isStateSaved()) {
            return;
        }
        List<NavBackStackEntry> value = fragmentNavigator.getState().getBackStack().getValue();
        int iIndexOf = value.indexOf(popUpTo);
        List<NavBackStackEntry> listSubList = value.subList(iIndexOf, value.size());
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) kotlin.collections.m.P(value);
        if (savedState) {
            for (NavBackStackEntry navBackStackEntry2 : kotlin.collections.m.e0(listSubList)) {
                if (h.a(navBackStackEntry2, navBackStackEntry)) {
                    Objects.toString(navBackStackEntry2);
                } else {
                    fragmentNavigator.fragmentManager.saveBackStack(navBackStackEntry2.getId());
                    fragmentNavigator.savedIds.add(navBackStackEntry2.getId());
                }
            }
        } else {
            fragmentNavigator.fragmentManager.popBackStack(popUpTo.getId(), 1);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            popUpTo.toString();
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) kotlin.collections.m.S(iIndexOf - 1, value);
        if (navBackStackEntry3 != null) {
            addPendingOps$default(fragmentNavigator, navBackStackEntry3.getId(), false, false, 6, null);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSubList) {
            NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj;
            u uVarD = k3.m.D(kotlin.collections.m.K(fragmentNavigator.pendingOps), FragmentNavigator$popBackStack$1$1.INSTANCE);
            String id = navBackStackEntry4.getId();
            Iterator it = uVarD.f3795a.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object objInvoke = uVarD.b.invoke(it.next());
                if (i < 0) {
                    n.C();
                    throw null;
                }
                if (h.a(id, objInvoke)) {
                    break;
                } else {
                    i++;
                }
            }
            if ((i >= 0) || !h.a(navBackStackEntry4.getId(), navBackStackEntry.getId())) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            addPendingOps$default(fragmentNavigator, ((NavBackStackEntry) it2.next()).getId(), true, false, 4, null);
            fragmentNavigator = this;
        }
        getState().popWithTransition(popUpTo, savedState);
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    private final void navigate(NavBackStackEntry entry, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        boolean zIsEmpty = getState().getBackStack().getValue().isEmpty();
        if (navOptions != null && !zIsEmpty && navOptions.getRestoreState() && this.savedIds.remove(entry.getId())) {
            this.fragmentManager.restoreBackStack(entry.getId());
            getState().pushWithTransition(entry);
            return;
        }
        FragmentTransaction fragmentTransactionCreateFragmentTransaction = createFragmentTransaction(entry, navOptions);
        if (!zIsEmpty) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) kotlin.collections.m.Y(getState().getBackStack().getValue());
            if (navBackStackEntry != null) {
                addPendingOps$default(this, navBackStackEntry.getId(), false, false, 6, null);
            }
            addPendingOps$default(this, entry.getId(), false, false, 6, null);
            fragmentTransactionCreateFragmentTransaction.addToBackStack(entry.getId());
        }
        if (navigatorExtras instanceof Extras) {
            for (Map.Entry<View, String> entry2 : ((Extras) navigatorExtras).getSharedElements().entrySet()) {
                fragmentTransactionCreateFragmentTransaction.addSharedElement(entry2.getKey(), entry2.getValue());
            }
        }
        fragmentTransactionCreateFragmentTransaction.commit();
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(entry);
        }
        getState().pushWithTransition(entry);
    }
}
