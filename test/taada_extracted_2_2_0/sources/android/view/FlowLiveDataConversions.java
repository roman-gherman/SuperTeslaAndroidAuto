package android.view;

import N1.m;
import T1.a;
import U1.g;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.RoomTrackingLiveData;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import m3.AbstractC0690y;
import m3.G;
import m3.V;
import n3.C0729d;
import o3.EnumC0743a;
import p3.v;
import q3.AbstractC0786c;
import r3.o;
import t3.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Landroidx/lifecycle/LiveData;", "asLiveData", "timeout", "Ljava/time/Duration;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0}, l = {112, 116}, m = "invokeSuspend", n = {"$this$callbackFlow", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1<T> extends g implements Function2<ProducerScope<? super T>, Continuation<? super m>, Object> {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00041 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00041(LiveData<T> liveData, Observer<T> observer, Continuation<? super C00041> continuation) {
                super(2, continuation);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // U1.a
            public final Continuation<m> create(Object obj, Continuation<?> continuation) {
                return new C00041(this.$this_asFlow, this.$observer, continuation);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // U1.a
            public final Object invokeSuspend(Object obj) {
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
                this.$this_asFlow.observeForever((Observer<? super T>) this.$observer);
                return m.f1129a;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
                return ((C00041) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "LN1/m;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class AnonymousClass2 extends i implements Function0<m> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;

            /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00051 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
                final /* synthetic */ Observer<T> $observer;
                final /* synthetic */ LiveData<T> $this_asFlow;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00051(LiveData<T> liveData, Observer<T> observer, Continuation<? super C00051> continuation) {
                    super(2, continuation);
                    this.$this_asFlow = liveData;
                    this.$observer = observer;
                }

                @Override // U1.a
                public final Continuation<m> create(Object obj, Continuation<?> continuation) {
                    return new C00051(this.$this_asFlow, this.$observer, continuation);
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // U1.a
                public final Object invokeSuspend(Object obj) {
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                    this.$this_asFlow.removeObserver((Observer<? super T>) this.$observer);
                    return m.f1129a;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
                    return ((C00051) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LiveData<T> liveData, Observer<T> observer) {
                super(0);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ m invoke() {
                invoke2();
                return m.f1129a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                V v6 = V.f4115a;
                d dVar = G.f4105a;
                AbstractC0690y.g(v6, ((C0729d) o.f4719a).c, new C00051(this.$this_asFlow, this.$observer, null), 2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
        
            if (o3.AbstractC0740A.a(r3, r9, r8) == r0) goto L16;
         */
        @Override // U1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                T1.a r0 = T1.a.f1304a
                int r1 = r8.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L25
                if (r1 == r3) goto L19
                if (r1 != r2) goto L11
                kotlin.reflect.l.e0(r9)
                goto L62
            L11:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L19:
                java.lang.Object r1 = r8.L$1
                androidx.lifecycle.Observer r1 = (android.view.Observer) r1
                java.lang.Object r3 = r8.L$0
                kotlinx.coroutines.channels.ProducerScope r3 = (kotlinx.coroutines.channels.ProducerScope) r3
                kotlin.reflect.l.e0(r9)
                goto L4e
            L25:
                kotlin.reflect.l.e0(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
                androidx.lifecycle.b r1 = new androidx.lifecycle.b
                r1.<init>()
                t3.d r5 = m3.G.f4105a
                m3.p0 r5 = r3.o.f4719a
                n3.d r5 = (n3.C0729d) r5
                n3.d r5 = r5.c
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r6 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
                androidx.lifecycle.LiveData<T> r7 = r8.$this_asFlow
                r6.<init>(r7, r1, r4)
                r8.L$0 = r9
                r8.L$1 = r1
                r8.label = r3
                java.lang.Object r3 = m3.AbstractC0690y.m(r5, r6, r8)
                if (r3 != r0) goto L4d
                goto L61
            L4d:
                r3 = r9
            L4e:
                androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r9 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
                androidx.lifecycle.LiveData<T> r5 = r8.$this_asFlow
                r9.<init>(r5, r1)
                r8.L$0 = r4
                r8.L$1 = r4
                r8.label = r2
                java.lang.Object r9 = o3.AbstractC0740A.a(r3, r9, r8)
                if (r9 != r0) goto L62
            L61:
                return r0
            L62:
                N1.m r9 = N1.m.f1129a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: android.view.FlowLiveDataConversions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo5invoke(ProducerScope<? super T> producerScope, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Landroidx/lifecycle/LiveDataScope;", "LN1/m;", "<anonymous>", "(Landroidx/lifecycle/LiveDataScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01911<T> extends g implements Function2<LiveDataScope<T>, Continuation<? super m>, Object> {
        final /* synthetic */ Flow<T> $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01911(Flow<? extends T> flow, Continuation<? super C01911> continuation) {
            super(2, continuation);
            this.$this_asLiveData = flow;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            C01911 c01911 = new C01911(this.$this_asLiveData, continuation);
            c01911.L$0 = obj;
            return c01911;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo5invoke(LiveDataScope<T> liveDataScope, Continuation<? super m> continuation) {
            return ((C01911) create(liveDataScope, continuation)).invokeSuspend(m.f1129a);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            if (i == 0) {
                l.e0(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                Flow<T> flow = this.$this_asLiveData;
                FlowCollector<? super T> flowCollector = new FlowCollector() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t6, Continuation<? super m> continuation) {
                        Object objEmit = liveDataScope.emit(t6, continuation);
                        return objEmit == a.f1304a ? objEmit : m.f1129a;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == aVar) {
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
    }

    public static final <T> Flow<T> asFlow(LiveData<T> liveData) {
        h.f(liveData, "<this>");
        return AbstractC0786c.a(v.c(new AnonymousClass1(liveData, null)), null, 0, EnumC0743a.b, 1);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow) {
        h.f(flow, "<this>");
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = S1.g.f1282a;
        }
        if ((i & 2) != 0) {
            j6 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(flow, coroutineContext, j6);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context) {
        h.f(flow, "<this>");
        h.f(context, "context");
        return asLiveData$default(flow, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, long j6) {
        h.f(flow, "<this>");
        h.f(context, "context");
        RoomTrackingLiveData roomTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j6, new C01911(flow, null));
        if (flow instanceof StateFlow) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomTrackingLiveData.setValue(((StateFlow) flow).getValue());
                return roomTrackingLiveData;
            }
            roomTrackingLiveData.postValue(((StateFlow) flow).getValue());
        }
        return roomTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, Duration duration, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = S1.g.f1282a;
        }
        return asLiveData(flow, duration, coroutineContext);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, Duration timeout, CoroutineContext context) {
        h.f(flow, "<this>");
        h.f(timeout, "timeout");
        h.f(context, "context");
        return asLiveData(flow, context, C0189Api26Impl.INSTANCE.toMillis(timeout));
    }
}
