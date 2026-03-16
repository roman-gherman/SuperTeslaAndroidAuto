package android.view;

import N1.m;
import S1.g;
import fr.sd.taada.helpers.LocaleHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.i;
import m3.AbstractC0684s;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", LocaleHelper.LANGUAGE_ITALIAN, "LN1/m;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends i implements Function1<Throwable, m> {
    final /* synthetic */ AbstractC0684s $lifecycleDispatcher;
    final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(AbstractC0684s abstractC0684s, Lifecycle lifecycle, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
        super(1);
        this.$lifecycleDispatcher = abstractC0684s;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ m invoke(Throwable th) {
        invoke2(th);
        return m.f1129a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        AbstractC0684s abstractC0684s = this.$lifecycleDispatcher;
        g gVar = g.f1282a;
        if (!abstractC0684s.isDispatchNeeded(gVar)) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
            return;
        }
        AbstractC0684s abstractC0684s2 = this.$lifecycleDispatcher;
        final Lifecycle lifecycle = this.$this_suspendWithStateAtLeastUnchecked;
        final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = this.$observer;
        abstractC0684s2.dispatch(gVar, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
            @Override // java.lang.Runnable
            public final void run() {
                lifecycle.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
            }
        });
    }
}
