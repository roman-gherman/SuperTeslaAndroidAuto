package android.view;

import N1.a;
import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.h;

/* JADX INFO: renamed from: androidx.savedstate.ViewKt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"findViewTreeSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroid/view/View;", "savedstate-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class C0217ViewKt {
    @Deprecated(level = a.c, message = "Replaced by View.findViewTreeSavedStateRegistryOwner() from savedstate module", replaceWith = @ReplaceWith(expression = "findViewTreeSavedStateRegistryOwner()", imports = {"androidx.savedstate.findViewTreeSavedStateRegistryOwner"}))
    public static final /* synthetic */ SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View view) {
        h.f(view, "<this>");
        return C0218ViewTreeSavedStateRegistryOwner.get(view);
    }
}
