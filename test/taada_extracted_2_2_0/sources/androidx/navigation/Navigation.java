package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import fr.sd.taada.helpers.LocaleHelper;
import java.lang.ref.WeakReference;
import k3.m;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\rJ%\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0012\u0010\u0016J!\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Landroidx/navigation/Navigation;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/app/Activity;", "activity", "", "viewId", "Landroidx/navigation/NavController;", "findNavController", "(Landroid/app/Activity;I)Landroidx/navigation/NavController;", "Landroid/view/View;", "view", "(Landroid/view/View;)Landroidx/navigation/NavController;", "resId", "Landroid/os/Bundle;", "args", "Landroid/view/View$OnClickListener;", "createNavigateOnClickListener", "(ILandroid/os/Bundle;)Landroid/view/View$OnClickListener;", "Landroidx/navigation/NavDirections;", "directions", "(Landroidx/navigation/NavDirections;)Landroid/view/View$OnClickListener;", "controller", "LN1/m;", "setViewNavController", "(Landroid/view/View;Landroidx/navigation/NavController;)V", "findViewNavController", "getViewNavController", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Navigation {
    public static final Navigation INSTANCE = new Navigation();

    /* JADX INFO: renamed from: androidx.navigation.Navigation$findViewNavController$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", LocaleHelper.LANGUAGE_ITALIAN, "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends i implements Function1<View, View> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final View invoke(View it) {
            h.f(it, "it");
            Object parent = it.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.Navigation$findViewNavController$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/navigation/NavController;", LocaleHelper.LANGUAGE_ITALIAN, "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 extends i implements Function1<View, NavController> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final NavController invoke(View it) {
            h.f(it, "it");
            return Navigation.INSTANCE.getViewNavController(it);
        }
    }

    private Navigation() {
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(int i) {
        return createNavigateOnClickListener$default(i, null, 2, null);
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int i, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        return createNavigateOnClickListener(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNavigateOnClickListener$lambda$0(int i, Bundle bundle, View view) {
        h.e(view, "view");
        findNavController(view).navigate(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNavigateOnClickListener$lambda$1(NavDirections directions, View view) {
        h.f(directions, "$directions");
        h.e(view, "view");
        findNavController(view).navigate(directions);
    }

    @JvmStatic
    public static final NavController findNavController(Activity activity, int viewId) {
        h.f(activity, "activity");
        View viewRequireViewById = ActivityCompat.requireViewById(activity, viewId);
        h.e(viewRequireViewById, "requireViewById<View>(activity, viewId)");
        NavController navControllerFindViewNavController = INSTANCE.findViewNavController(viewRequireViewById);
        if (navControllerFindViewNavController != null) {
            return navControllerFindViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + viewId);
    }

    private final NavController findViewNavController(View view) {
        return (NavController) m.y(m.E(m.B(view, AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getViewNavController(View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    @JvmStatic
    public static final void setViewNavController(View view, NavController controller) {
        h.f(view, "view");
        view.setTag(R.id.nav_controller_view_tag, controller);
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(final int resId, final Bundle args) {
        return new View.OnClickListener() { // from class: androidx.navigation.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Navigation.createNavigateOnClickListener$lambda$0(resId, args, view);
            }
        };
    }

    @JvmStatic
    public static final View.OnClickListener createNavigateOnClickListener(NavDirections directions) {
        h.f(directions, "directions");
        return new b(directions, 0);
    }

    @JvmStatic
    public static final NavController findNavController(View view) {
        h.f(view, "view");
        NavController navControllerFindViewNavController = INSTANCE.findViewNavController(view);
        if (navControllerFindViewNavController != null) {
            return navControllerFindViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
