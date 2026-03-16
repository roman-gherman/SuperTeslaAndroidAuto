package androidx.navigation.fragment;

import N1.m;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a*\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aF\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\f\u001a(\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u0006\u0010\u000f\u001aD\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"Landroidx/fragment/app/DialogFragment;", "F", "Landroidx/navigation/NavGraphBuilder;", "", "id", "LN1/m;", "dialog", "(Landroidx/navigation/NavGraphBuilder;I)V", "Lkotlin/Function1;", "Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "(Landroidx/navigation/NavGraphBuilder;ILkotlin/jvm/functions/Function1;)V", "", "route", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;)V", "(Landroidx/navigation/NavGraphBuilder;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "navigation-fragment_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DialogFragmentNavigatorDestinationBuilderKt {
    @Deprecated(message = "Use routes to create your DialogFragmentDestination instead", replaceWith = @ReplaceWith(expression = "dialog<F>(route = id.toString()) { builder.invoke() }", imports = {}))
    public static final <F extends DialogFragment> void dialog(NavGraphBuilder navGraphBuilder, int i, Function1<? super DialogFragmentNavigatorDestinationBuilder, m> builder) {
        h.f(navGraphBuilder, "<this>");
        h.f(builder, "builder");
        h.k();
        throw null;
    }

    public static final <F extends DialogFragment> void dialog(NavGraphBuilder navGraphBuilder, String route, Function1<? super DialogFragmentNavigatorDestinationBuilder, m> builder) {
        h.f(navGraphBuilder, "<this>");
        h.f(route, "route");
        h.f(builder, "builder");
        h.k();
        throw null;
    }

    @Deprecated(message = "Use routes to create your DialogFragmentDestination instead", replaceWith = @ReplaceWith(expression = "dialog<F>(route = id.toString())", imports = {}))
    public static final <F extends DialogFragment> void dialog(NavGraphBuilder navGraphBuilder, int i) {
        h.f(navGraphBuilder, "<this>");
        h.k();
        throw null;
    }

    public static final <F extends DialogFragment> void dialog(NavGraphBuilder navGraphBuilder, String route) {
        h.f(navGraphBuilder, "<this>");
        h.f(route, "route");
        h.k();
        throw null;
    }
}
