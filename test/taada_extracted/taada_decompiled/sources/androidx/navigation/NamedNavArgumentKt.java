package androidx.navigation;

import N1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "name", "Lkotlin/Function1;", "Landroidx/navigation/NavArgumentBuilder;", "LN1/m;", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/navigation/NamedNavArgument;", "navArgument", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Landroidx/navigation/NamedNavArgument;", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NamedNavArgumentKt {
    public static final NamedNavArgument navArgument(String name, Function1<? super NavArgumentBuilder, m> builder) {
        h.f(name, "name");
        h.f(builder, "builder");
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        builder.invoke(navArgumentBuilder);
        return new NamedNavArgument(name, navArgumentBuilder.build());
    }
}
