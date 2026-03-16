package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.E;
import kotlin.collections.m;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import net.bytebuddy.description.method.MethodDescription;
import p3.q;
import p3.v;
import p3.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001a\u0010\bR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R*\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00118G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R#\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"0*8\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.¨\u00061"}, d2 = {"Landroidx/navigation/NavigatorState;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroidx/navigation/NavBackStackEntry;", "backStackEntry", "LN1/m;", "push", "(Landroidx/navigation/NavBackStackEntry;)V", "pushWithTransition", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "createBackStackEntry", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "saveState", "pop", "(Landroidx/navigation/NavBackStackEntry;Z)V", "popWithTransition", "onLaunchSingleTop", "onLaunchSingleTopWithTransition", "entry", "markTransitionComplete", "prepareForTransition", "Ljava/util/concurrent/locks/ReentrantLock;", "backStackLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_backStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_transitionsInProgress", "<set-?>", "isNavigating", "Z", "()Z", "setNavigating", "(Z)V", "Lkotlinx/coroutines/flow/StateFlow;", "backStack", "Lkotlinx/coroutines/flow/StateFlow;", "getBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "transitionsInProgress", "getTransitionsInProgress", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class NavigatorState {
    private final MutableStateFlow<List<NavBackStackEntry>> _backStack;
    private final MutableStateFlow<Set<NavBackStackEntry>> _transitionsInProgress;
    private final StateFlow<List<NavBackStackEntry>> backStack;
    private final ReentrantLock backStackLock = new ReentrantLock(true);
    private boolean isNavigating;
    private final StateFlow<Set<NavBackStackEntry>> transitionsInProgress;

    public NavigatorState() {
        z zVarA = v.a(u.f3804a);
        this._backStack = zVarA;
        z zVarA2 = v.a(w.f3806a);
        this._transitionsInProgress = zVarA2;
        this.backStack = new q(zVarA);
        this.transitionsInProgress = new q(zVarA2);
    }

    public abstract NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments);

    public final StateFlow<List<NavBackStackEntry>> getBackStack() {
        return this.backStack;
    }

    public final StateFlow<Set<NavBackStackEntry>> getTransitionsInProgress() {
        return this.transitionsInProgress;
    }

    /* JADX INFO: renamed from: isNavigating, reason: from getter */
    public final boolean getIsNavigating() {
        return this.isNavigating;
    }

    public void markTransitionComplete(NavBackStackEntry entry) {
        h.f(entry, "entry");
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
        mutableStateFlow.setValue(E.u(mutableStateFlow.getValue(), entry));
    }

    public void onLaunchSingleTop(NavBackStackEntry backStackEntry) {
        int iNextIndex;
        h.f(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            ArrayList arrayListP0 = m.p0(this.backStack.getValue());
            ListIterator listIterator = arrayListP0.listIterator(arrayListP0.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                } else if (h.a(((NavBackStackEntry) listIterator.previous()).getId(), backStackEntry.getId())) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            arrayListP0.set(iNextIndex, backStackEntry);
            this._backStack.setValue(arrayListP0);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void onLaunchSingleTopWithTransition(NavBackStackEntry backStackEntry) {
        h.f(backStackEntry, "backStackEntry");
        List<NavBackStackEntry> value = this.backStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry navBackStackEntryPrevious = listIterator.previous();
            if (h.a(navBackStackEntryPrevious.getId(), backStackEntry.getId())) {
                MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
                mutableStateFlow.setValue(E.v(E.v(mutableStateFlow.getValue(), navBackStackEntryPrevious), backStackEntry));
                onLaunchSingleTop(backStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public void pop(NavBackStackEntry popUpTo, boolean saveState) {
        h.f(popUpTo, "popUpTo");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this._backStack;
            List<NavBackStackEntry> value = mutableStateFlow.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (h.a((NavBackStackEntry) obj, popUpTo)) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            mutableStateFlow.setValue(arrayList);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
        NavBackStackEntry navBackStackEntryPrevious;
        h.f(popUpTo, "popUpTo");
        Set<NavBackStackEntry> value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((NavBackStackEntry) it.next()) == popUpTo) {
                    List<NavBackStackEntry> value2 = this.backStack.getValue();
                    if ((value2 instanceof Collection) && value2.isEmpty()) {
                        return;
                    }
                    Iterator<T> it2 = value2.iterator();
                    while (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == popUpTo) {
                        }
                    }
                    return;
                }
            }
        }
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
        mutableStateFlow.setValue(E.v(mutableStateFlow.getValue(), popUpTo));
        List<NavBackStackEntry> value3 = this.backStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value3.listIterator(value3.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
            if (!h.a(navBackStackEntry, popUpTo) && this.backStack.getValue().lastIndexOf(navBackStackEntry) < this.backStack.getValue().lastIndexOf(popUpTo)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntryPrevious;
        if (navBackStackEntry2 != null) {
            MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow2 = this._transitionsInProgress;
            mutableStateFlow2.setValue(E.v(mutableStateFlow2.getValue(), navBackStackEntry2));
        }
        pop(popUpTo, saveState);
    }

    public void prepareForTransition(NavBackStackEntry entry) {
        h.f(entry, "entry");
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
        mutableStateFlow.setValue(E.v(mutableStateFlow.getValue(), entry));
    }

    public void push(NavBackStackEntry backStackEntry) {
        h.f(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this._backStack;
            mutableStateFlow.setValue(m.d0(backStackEntry, mutableStateFlow.getValue()));
        } finally {
            reentrantLock.unlock();
        }
    }

    public void pushWithTransition(NavBackStackEntry backStackEntry) {
        h.f(backStackEntry, "backStackEntry");
        Set<NavBackStackEntry> value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((NavBackStackEntry) it.next()) == backStackEntry) {
                    List<NavBackStackEntry> value2 = this.backStack.getValue();
                    if (!(value2 instanceof Collection) || !value2.isEmpty()) {
                        Iterator<T> it2 = value2.iterator();
                        while (it2.hasNext()) {
                            if (((NavBackStackEntry) it2.next()) == backStackEntry) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) m.Y(this.backStack.getValue());
        if (navBackStackEntry != null) {
            MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this._transitionsInProgress;
            mutableStateFlow.setValue(E.v(mutableStateFlow.getValue(), navBackStackEntry));
        }
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow2 = this._transitionsInProgress;
        mutableStateFlow2.setValue(E.v(mutableStateFlow2.getValue(), backStackEntry));
        push(backStackEntry);
    }

    public final void setNavigating(boolean z6) {
        this.isNavigating = z6;
    }
}
