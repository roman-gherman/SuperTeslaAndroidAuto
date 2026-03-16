package androidx.navigation;

import N1.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LN1/e;", "", "", "invoke", "()LN1/e;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class NavDeepLink$fragArgsAndRegex$2 extends i implements Function0<e> {
    final /* synthetic */ NavDeepLink this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavDeepLink$fragArgsAndRegex$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final e invoke() {
        return this.this$0.parseFragment();
    }
}
