package android.view;

import N1.m;
import T1.a;
import U1.g;
import android.view.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.i;
import kotlin.reflect.l;
import kotlinx.coroutines.channels.ProducerScope;
import o3.AbstractC0740A;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/lifecycle/Lifecycle$Event;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
public final class LifecycleKt$eventFlow$1 extends g implements Function2<ProducerScope<? super Lifecycle.Event>, Continuation<? super m>, Object> {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleKt$eventFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LN1/m;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends i implements Function0<m> {
        final /* synthetic */ LifecycleEventObserver $observer;
        final /* synthetic */ Lifecycle $this_eventFlow;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            super(0);
            this.$this_eventFlow = lifecycle;
            this.$observer = lifecycleEventObserver;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ m invoke() {
            invoke2();
            return m.f1129a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$this_eventFlow.removeObserver(this.$observer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleKt$eventFlow$1(Lifecycle lifecycle, Continuation<? super LifecycleKt$eventFlow$1> continuation) {
        super(2, continuation);
        this.$this_eventFlow = lifecycle;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, continuation);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        a aVar = a.f1304a;
        int i = this.label;
        if (i == 0) {
            l.e0(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            C0203d c0203d = new C0203d(producerScope, 0);
            this.$this_eventFlow.addObserver(c0203d);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_eventFlow, c0203d);
            this.label = 1;
            if (AbstractC0740A.a(producerScope, anonymousClass1, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.e0(obj);
        }
        return m.f1129a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(ProducerScope<? super Lifecycle.Event> producerScope, Continuation<? super m> continuation) {
        return ((LifecycleKt$eventFlow$1) create(producerScope, continuation)).invokeSuspend(m.f1129a);
    }
}
