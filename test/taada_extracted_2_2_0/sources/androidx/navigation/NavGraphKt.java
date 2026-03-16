package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0004\u0010\b\u001a\u001e\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\n\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavGraph;", "", "id", "Landroidx/navigation/NavDestination;", "get", "(Landroidx/navigation/NavGraph;I)Landroidx/navigation/NavDestination;", "", "route", "(Landroidx/navigation/NavGraph;Ljava/lang/String;)Landroidx/navigation/NavDestination;", "", "contains", "(Landroidx/navigation/NavGraph;I)Z", "(Landroidx/navigation/NavGraph;Ljava/lang/String;)Z", "node", "LN1/m;", "plusAssign", "(Landroidx/navigation/NavGraph;Landroidx/navigation/NavDestination;)V", "other", "(Landroidx/navigation/NavGraph;Landroidx/navigation/NavGraph;)V", "minusAssign", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavGraphKt {
    public static final boolean contains(NavGraph navGraph, int i) {
        h.f(navGraph, "<this>");
        return navGraph.findNode(i) != null;
    }

    public static final NavDestination get(NavGraph navGraph, int i) {
        h.f(navGraph, "<this>");
        NavDestination navDestinationFindNode = navGraph.findNode(i);
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + i + " was found in " + navGraph);
    }

    public static final void minusAssign(NavGraph navGraph, NavDestination node) {
        h.f(navGraph, "<this>");
        h.f(node, "node");
        navGraph.remove(node);
    }

    public static final void plusAssign(NavGraph navGraph, NavDestination node) {
        h.f(navGraph, "<this>");
        h.f(node, "node");
        navGraph.addDestination(node);
    }

    public static final boolean contains(NavGraph navGraph, String route) {
        h.f(navGraph, "<this>");
        h.f(route, "route");
        return navGraph.findNode(route) != null;
    }

    public static final NavDestination get(NavGraph navGraph, String route) {
        h.f(navGraph, "<this>");
        h.f(route, "route");
        NavDestination navDestinationFindNode = navGraph.findNode(route);
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final void plusAssign(NavGraph navGraph, NavGraph other) {
        h.f(navGraph, "<this>");
        h.f(other, "other");
        navGraph.addAll(other);
    }
}
