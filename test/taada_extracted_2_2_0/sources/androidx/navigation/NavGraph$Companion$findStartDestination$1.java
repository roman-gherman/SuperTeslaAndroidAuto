package androidx.navigation;

import fr.sd.taada.helpers.LocaleHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", LocaleHelper.LANGUAGE_ITALIAN, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class NavGraph$Companion$findStartDestination$1 extends i implements Function1<NavDestination, NavDestination> {
    public static final NavGraph$Companion$findStartDestination$1 INSTANCE = new NavGraph$Companion$findStartDestination$1();

    public NavGraph$Companion$findStartDestination$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final NavDestination invoke(NavDestination it) {
        h.f(it, "it");
        if (!(it instanceof NavGraph)) {
            return null;
        }
        NavGraph navGraph = (NavGraph) it;
        return navGraph.findNode(navGraph.getStartDestId());
    }
}
