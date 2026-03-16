package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.C0590a;
import k3.m;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.j;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.r;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 P2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001PB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001a\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c\"\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u001dJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0019\u0010 \u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b \u0010$J#\u0010 \u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u001f\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b \u0010'J!\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\"2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b \u0010(J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)H\u0086\u0002¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0000¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b/\u0010\u0017J\r\u00100\u001a\u00020\u000b¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u001eH\u0007¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u001e¢\u0006\u0004\b5\u00106J\u0015\u00105\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\"¢\u0006\u0004\b5\u00108J\u000f\u00109\u001a\u00020\"H\u0016¢\u0006\u0004\b9\u0010:J\u001a\u0010<\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010;H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u001eH\u0016¢\u0006\u0004\b>\u00103R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010?8G¢\u0006\f\n\u0004\b\u0019\u0010@\u001a\u0004\bA\u0010BR\u0016\u00104\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER.\u0010F\u001a\u0004\u0018\u00010\"2\b\u00107\u001a\u0004\u0018\u00010\"8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010E\u001a\u0004\bG\u0010:\"\u0004\bH\u00108R$\u0010K\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u001e8G@BX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u00103\"\u0004\bJ\u00106R\u0014\u0010M\u001a\u00020\"8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010:R\u0011\u0010O\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\bN\u0010:¨\u0006Q"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/Navigator;", "navGraphNavigator", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "LN1/m;", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/navigation/NavDeepLinkRequest;", "navDeepLinkRequest", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "request", "matchDeepLinkExcludingChildren", "node", "addDestination", "(Landroidx/navigation/NavDestination;)V", "", "nodes", "addDestinations", "(Ljava/util/Collection;)V", "", "([Landroidx/navigation/NavDestination;)V", "", "resId", "findNode", "(I)Landroidx/navigation/NavDestination;", "", "route", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "", "searchParents", "(IZ)Landroidx/navigation/NavDestination;", "(Ljava/lang/String;Z)Landroidx/navigation/NavDestination;", "", "iterator", "()Ljava/util/Iterator;", "other", "addAll", "(Landroidx/navigation/NavGraph;)V", "remove", "clear", "()V", "getStartDestination", "()I", "startDestId", "setStartDestination", "(I)V", "startDestRoute", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "I", "startDestIdName", "Ljava/lang/String;", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "getStartDestinationId", "setStartDestinationId", "startDestinationId", "getDisplayName", "displayName", "getStartDestDisplayName", "startDestDisplayName", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "findStartDestination", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        public final NavDestination findStartDestination(NavGraph navGraph) {
            h.f(navGraph, "<this>");
            return (NavDestination) m.C(m.B(navGraph.findNode(navGraph.getStartDestId()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraph$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "", "hasNext", "()Z", "next", "()Landroidx/navigation/NavDestination;", "LN1/m;", "remove", "()V", "", "index", "I", "wentToNext", "Z", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<NavDestination>, KMutableIterator {
        private int index = -1;
        private boolean wentToNext;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index + 1 < NavGraph.this.getNodes().size();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.wentToNext) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            SparseArrayCompat<NavDestination> nodes = NavGraph.this.getNodes();
            nodes.valueAt(this.index).setParent(null);
            nodes.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NavDestination next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> nodes = NavGraph.this.getNodes();
            int i = this.index + 1;
            this.index = i;
            NavDestination navDestinationValueAt = nodes.valueAt(i);
            h.e(navDestinationValueAt, "nodes.valueAt(++index)");
            return navDestinationValueAt;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navGraphNavigator) {
        super(navGraphNavigator);
        h.f(navGraphNavigator, "navGraphNavigator");
        this.nodes = new SparseArrayCompat<>();
    }

    @JvmStatic
    public static final NavDestination findStartDestination(NavGraph navGraph) {
        return INSTANCE.findStartDestination(navGraph);
    }

    private final void setStartDestinationId(int i) {
        if (i != getId()) {
            if (this.startDestinationRoute != null) {
                setStartDestinationRoute(null);
            }
            this.startDestId = i;
            this.startDestIdName = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
    }

    private final void setStartDestinationRoute(String str) {
        int iHashCode;
        if (str == null) {
            iHashCode = 0;
        } else {
            if (str.equals(getRoute())) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
            }
            if (r.y(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            iHashCode = NavDestination.INSTANCE.createRoute(str).hashCode();
        }
        this.startDestId = iHashCode;
        this.startDestinationRoute = str;
    }

    public final void addAll(NavGraph other) {
        h.f(other, "other");
        Iterator<NavDestination> it = other.iterator();
        while (it.hasNext()) {
            NavDestination next = it.next();
            it.remove();
            addDestination(next);
        }
    }

    public final void addDestination(NavDestination node) {
        h.f(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (getRoute() != null && h.a(route, getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (id == getId()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestination = this.nodes.get(id);
        if (navDestination == node) {
            return;
        }
        if (node.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination != null) {
            navDestination.setParent(null);
        }
        node.setParent(this);
        this.nodes.put(node.getId(), node);
    }

    public final void addDestinations(Collection<? extends NavDestination> nodes) {
        h.f(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavGraph) || !super.equals(other)) {
            return false;
        }
        NavGraph navGraph = (NavGraph) other;
        if (this.nodes.size() != navGraph.nodes.size() || getStartDestId() != navGraph.getStartDestId()) {
            return false;
        }
        for (NavDestination navDestination : (C0590a) m.u(SparseArrayKt.valueIterator(this.nodes))) {
            if (!navDestination.equals(navGraph.nodes.get(navDestination.getId()))) {
                return false;
            }
        }
        return true;
    }

    public final NavDestination findNode(int resId) {
        return findNode(resId, true);
    }

    @Override // androidx.navigation.NavDestination
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String strValueOf = this.startDestinationRoute;
            if (strValueOf == null) {
                strValueOf = String.valueOf(this.startDestId);
            }
            this.startDestIdName = strValueOf;
        }
        String str = this.startDestIdName;
        h.c(str);
        return str;
    }

    @Deprecated(message = "Use getStartDestinationId instead.", replaceWith = @ReplaceWith(expression = "startDestinationId", imports = {}))
    public final int getStartDestination() {
        return getStartDestId();
    }

    /* JADX INFO: renamed from: getStartDestinationId, reason: from getter */
    public final int getStartDestId() {
        return this.startDestId;
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int startDestId = getStartDestId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            startDestId = androidx.constraintlayout.core.motion.a.b(startDestId, 31, sparseArrayCompat.keyAt(i), 31) + sparseArrayCompat.valueAt(i).hashCode();
        }
        return startDestId;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new AnonymousClass1();
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        h.f(navDeepLinkRequest, "navDeepLinkRequest");
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        ArrayList arrayList = new ArrayList();
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink2 = it.next().matchDeepLink(navDeepLinkRequest);
            if (deepLinkMatchMatchDeepLink2 != null) {
                arrayList.add(deepLinkMatchMatchDeepLink2);
            }
        }
        return (NavDestination.DeepLinkMatch) kotlin.collections.m.Z(j.z(new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchDeepLink, (NavDestination.DeepLinkMatch) kotlin.collections.m.Z(arrayList)}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkExcludingChildren(NavDeepLinkRequest request) {
        h.f(request, "request");
        return super.matchDeepLink(request);
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(Context context, AttributeSet attrs) {
        h.f(context, "context");
        h.f(attrs, "attrs");
        super.onInflate(context, attrs);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.NavGraphNavigator);
        h.e(typedArrayObtainAttributes, "context.resources.obtain…vGraphNavigator\n        )");
        setStartDestinationId(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.INSTANCE.getDisplayName(context, this.startDestId);
        typedArrayObtainAttributes.recycle();
    }

    public final void remove(NavDestination node) {
        h.f(node, "node");
        int iIndexOfKey = this.nodes.indexOfKey(node.getId());
        if (iIndexOfKey >= 0) {
            this.nodes.valueAt(iIndexOfKey).setParent(null);
            this.nodes.removeAt(iIndexOfKey);
        }
    }

    public final void setStartDestination(int startDestId) {
        setStartDestinationId(startDestId);
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination navDestinationFindNode = findNode(this.startDestinationRoute);
        if (navDestinationFindNode == null) {
            navDestinationFindNode = findNode(getStartDestId());
        }
        sb.append(" startDestination=");
        if (navDestinationFindNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(navDestinationFindNode.toString());
            sb.append("}");
        }
        String string = sb.toString();
        h.e(string, "sb.toString()");
        return string;
    }

    public final NavDestination findNode(String route) {
        if (route == null || r.y(route)) {
            return null;
        }
        return findNode(route, true);
    }

    public final void setStartDestination(String startDestRoute) {
        h.f(startDestRoute, "startDestRoute");
        setStartDestinationRoute(startDestRoute);
    }

    public final void addDestinations(NavDestination... nodes) {
        h.f(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            addDestination(navDestination);
        }
    }

    public final NavDestination findNode(int resId, boolean searchParents) {
        NavDestination navDestination = this.nodes.get(resId);
        if (navDestination != null) {
            return navDestination;
        }
        if (!searchParents || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        h.c(parent);
        return parent.findNode(resId);
    }

    public final NavDestination findNode(String route, boolean searchParents) {
        Object next;
        h.f(route, "route");
        NavDestination navDestination = this.nodes.get(NavDestination.INSTANCE.createRoute(route).hashCode());
        if (navDestination == null) {
            Iterator it = ((C0590a) m.u(SparseArrayKt.valueIterator(this.nodes))).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((NavDestination) next).matchDeepLink(route) != null) {
                    break;
                }
            }
            navDestination = (NavDestination) next;
        }
        if (navDestination != null) {
            return navDestination;
        }
        if (!searchParents || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        h.c(parent);
        return parent.findNode(route);
    }
}
