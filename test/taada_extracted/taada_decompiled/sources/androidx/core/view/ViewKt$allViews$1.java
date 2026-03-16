package androidx.core.view;

import N1.m;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lk3/l;", "Landroid/view/View;", "LN1/m;", "<anonymous>", "(Lk3/l;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {414, TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class ViewKt$allViews$1 extends U1.f implements Function2<k3.l, Continuation<? super m>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.label;
        if (i == 0) {
            kotlin.reflect.l.e0(obj);
            k3.l lVar = (k3.l) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = lVar;
            this.label = 1;
            lVar.a(view, this);
            return aVar;
        }
        if (i == 1) {
            k3.l lVar2 = (k3.l) this.L$0;
            kotlin.reflect.l.e0(obj);
            View view2 = this.$this_allViews;
            if (view2 instanceof ViewGroup) {
                Sequence<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
                this.L$0 = null;
                this.label = 2;
                if (lVar2.b(descendants, this) == aVar) {
                    return aVar;
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.reflect.l.e0(obj);
        }
        return m.f1129a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(k3.l lVar, Continuation<? super m> continuation) {
        return ((ViewKt$allViews$1) create(lVar, continuation)).invokeSuspend(m.f1129a);
    }
}
