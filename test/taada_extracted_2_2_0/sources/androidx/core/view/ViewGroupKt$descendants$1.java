package androidx.core.view;

import N1.m;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lk3/l;", "Landroid/view/View;", "LN1/m;", "<anonymous>", "(Lk3/l;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {119, 121}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
public final class ViewGroupKt$descendants$1 extends U1.f implements Function2<k3.l, Continuation<? super m>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, Continuation<? super ViewGroupKt$descendants$1> continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, continuation);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        k3.l lVar;
        ViewGroup viewGroup;
        int childCount;
        int i;
        int i3;
        int i4;
        ViewGroup viewGroup2;
        k3.l lVar2;
        T1.a aVar = T1.a.f1304a;
        int i5 = this.label;
        if (i5 != 0) {
            if (i5 == 1) {
                childCount = this.I$1;
                i3 = this.I$0;
                View view = (View) this.L$2;
                viewGroup = (ViewGroup) this.L$1;
                lVar = (k3.l) this.L$0;
                kotlin.reflect.l.e0(obj);
                if (view instanceof ViewGroup) {
                    Sequence<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view);
                    this.L$0 = lVar;
                    this.L$1 = viewGroup;
                    this.L$2 = null;
                    this.I$0 = i3;
                    this.I$1 = childCount;
                    this.label = 2;
                    if (lVar.b(descendants, this) == aVar) {
                        return aVar;
                    }
                    i4 = i3;
                    viewGroup2 = viewGroup;
                    lVar2 = lVar;
                }
                i = i3 + 1;
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                childCount = this.I$1;
                i4 = this.I$0;
                viewGroup2 = (ViewGroup) this.L$1;
                lVar2 = (k3.l) this.L$0;
                kotlin.reflect.l.e0(obj);
            }
            viewGroup = viewGroup2;
            lVar = lVar2;
            i3 = i4;
            i = i3 + 1;
        } else {
            kotlin.reflect.l.e0(obj);
            lVar = (k3.l) this.L$0;
            viewGroup = this.$this_descendants;
            childCount = viewGroup.getChildCount();
            i = 0;
        }
        if (i >= childCount) {
            return m.f1129a;
        }
        View childAt = viewGroup.getChildAt(i);
        this.L$0 = lVar;
        this.L$1 = viewGroup;
        this.L$2 = childAt;
        this.I$0 = i;
        this.I$1 = childCount;
        this.label = 1;
        lVar.a(childAt, this);
        return aVar;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(k3.l lVar, Continuation<? super m> continuation) {
        return ((ViewGroupKt$descendants$1) create(lVar, continuation)).invokeSuspend(m.f1129a);
    }
}
