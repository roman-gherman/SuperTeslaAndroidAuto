package androidx.navigation;

import N1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "LN1/m;", "invoke", "(Landroidx/navigation/NavOptionsBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class NavController$clearBackStackInternal$restored$1 extends i implements Function1<NavOptionsBuilder, m> {
    public static final NavController$clearBackStackInternal$restored$1 INSTANCE = new NavController$clearBackStackInternal$restored$1();

    public NavController$clearBackStackInternal$restored$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ m invoke(NavOptionsBuilder navOptionsBuilder) {
        invoke2(navOptionsBuilder);
        return m.f1129a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NavOptionsBuilder navOptions) {
        h.f(navOptions, "$this$navOptions");
        navOptions.setRestoreState(true);
    }
}
