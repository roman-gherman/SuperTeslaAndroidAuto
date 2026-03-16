package androidx.navigation;

import N1.m;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LN1/m;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class NavController$NavControllerNavigatorState$pop$1 extends i implements Function0<m> {
    final /* synthetic */ NavBackStackEntry $popUpTo;
    final /* synthetic */ boolean $saveState;
    final /* synthetic */ NavController.NavControllerNavigatorState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavController$NavControllerNavigatorState$pop$1(NavController.NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z6) {
        super(0);
        this.this$0 = navControllerNavigatorState;
        this.$popUpTo = navBackStackEntry;
        this.$saveState = z6;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ m invoke() {
        invoke2();
        return m.f1129a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        super/*androidx.navigation.NavigatorState*/.pop(this.$popUpTo, this.$saveState);
    }
}
