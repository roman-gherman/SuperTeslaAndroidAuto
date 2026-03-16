package android.view;

import k3.m;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: renamed from: androidx.activity.ViewTreeFullyDrawnReporterOwner, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroid/view/View;", "Landroidx/activity/FullyDrawnReporterOwner;", "fullyDrawnReporterOwner", "LN1/m;", "set", "(Landroid/view/View;Landroidx/activity/FullyDrawnReporterOwner;)V", "setViewTreeFullyDrawnReporterOwner", "get", "(Landroid/view/View;)Landroidx/activity/FullyDrawnReporterOwner;", "findViewTreeFullyDrawnReporterOwner", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class View {
    public static final FullyDrawnReporterOwner get(android.view.View view) {
        h.f(view, "<this>");
        return (FullyDrawnReporterOwner) m.y(m.E(m.B(view, ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$1.INSTANCE), ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.INSTANCE));
    }

    public static final void set(android.view.View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        h.f(view, "<this>");
        h.f(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
