package androidx.navigation;

import N1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/Function1;", "Landroidx/navigation/NavDeepLinkDslBuilder;", "LN1/m;", "Lkotlin/ExtensionFunctionType;", "deepLinkBuilder", "Landroidx/navigation/NavDeepLink;", "navDeepLink", "(Lkotlin/jvm/functions/Function1;)Landroidx/navigation/NavDeepLink;", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavDeepLinkDslBuilderKt {
    public static final NavDeepLink navDeepLink(Function1<? super NavDeepLinkDslBuilder, m> deepLinkBuilder) {
        h.f(deepLinkBuilder, "deepLinkBuilder");
        NavDeepLinkDslBuilder navDeepLinkDslBuilder = new NavDeepLinkDslBuilder();
        deepLinkBuilder.invoke(navDeepLinkDslBuilder);
        return navDeepLinkDslBuilder.build$navigation_common_release();
    }
}
