package androidx.room;

import N1.m;
import androidx.room.InvalidationTracker;
import fr.sd.taada.proto.KeyCode;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.reflect.l;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import m3.AbstractC0690y;
import m3.C0672f;
import o3.AbstractC0740A;
import p3.v;
import r3.C0798B;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a9\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\u00022\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\"\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00012'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012¢\u0006\u0002\b\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a9\u0010\u0018\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u001c\u0010\u0019\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001aH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "dispatcher", "Lkotlin/coroutines/ContinuationInterceptor;", "invalidationTrackerFlow", "Lkotlinx/coroutines/flow/Flow;", "", "", "tables", "", "emitInitialState", "", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;Z)Lkotlinx/coroutines/flow/Flow;", "startTransactionCoroutine", "R", "context", "transactionBlock", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "block", "Lkotlin/Function1;", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1", f = "RoomDatabaseExt.kt", i = {}, l = {KeyCode.KEYCODE_TV_TERRESTRIAL_ANALOG_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends U1.g implements Function2<ProducerScope<? super Set<? extends String>>, Continuation<? super m>, Object> {
        final /* synthetic */ boolean $emitInitialState;
        final /* synthetic */ String[] $tables;
        final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LN1/m;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class C00131 extends i implements Function0<m> {
            final /* synthetic */ Job $job;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00131(Job job) {
                super(0);
                this.$job = job;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ m invoke() {
                invoke2();
                return m.f1129a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$job.cancel((CancellationException) null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z6, RoomDatabase roomDatabase, String[] strArr, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$emitInitialState = z6;
            this.$this_invalidationTrackerFlow = roomDatabase;
            this.$tables = strArr;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$emitInitialState, this.$this_invalidationTrackerFlow, this.$tables, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo5invoke(ProducerScope<? super Set<? extends String>> producerScope, Continuation<? super m> continuation) {
            return invoke2((ProducerScope<? super Set<String>>) producerScope, continuation);
        }

        /* JADX WARN: Type inference failed for: r5v0, types: [androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$observer$1] */
        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            ContinuationInterceptor queryDispatcher;
            T1.a aVar = T1.a.f1304a;
            int i = this.label;
            if (i == 0) {
                l.e0(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final AtomicBoolean atomicBoolean = new AtomicBoolean(this.$emitInitialState);
                final String[] strArr = this.$tables;
                ?? r52 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$observer$1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void onInvalidated(Set<String> tables) {
                        if (atomicBoolean.get()) {
                            return;
                        }
                        producerScope.mo106trySendJP2dKIU(tables);
                    }
                };
                TransactionElement transactionElement = (TransactionElement) producerScope.getCoroutineContext().get(TransactionElement.INSTANCE);
                if (transactionElement == null || (queryDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                    queryDispatcher = CoroutinesRoomKt.getQueryDispatcher(this.$this_invalidationTrackerFlow);
                }
                C00131 c00131 = new C00131(AbstractC0690y.g(producerScope, queryDispatcher, new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, r52, this.$emitInitialState, producerScope, this.$tables, atomicBoolean, null), 2));
                this.label = 1;
                if (AbstractC0740A.a(producerScope, c00131, this) == aVar) {
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

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Set<String>> producerScope, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext createTransactionContext(RoomDatabase roomDatabase, ContinuationInterceptor continuationInterceptor) {
        TransactionElement transactionElement = new TransactionElement(continuationInterceptor);
        return continuationInterceptor.plus(transactionElement).plus(new C0798B(Integer.valueOf(System.identityHashCode(transactionElement)), roomDatabase.getSuspendingTransactionId()));
    }

    public static final Flow<Set<String>> invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z6) {
        return v.c(new AnonymousClass1(z6, roomDatabase, strArr, null));
    }

    public static /* synthetic */ Flow invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z6, int i, Object obj) {
        if ((i & 2) != 0) {
            z6 = true;
        }
        return invalidationTrackerFlow(roomDatabase, strArr, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine(final RoomDatabase roomDatabase, final CoroutineContext coroutineContext, final Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        final C0672f c0672f = new C0672f(1, C5.f.J(continuation));
        c0672f.initCancellability();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
                public static final class AnonymousClass1 extends U1.g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
                    final /* synthetic */ CancellableContinuation<R> $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ Function2<CoroutineScope, Continuation<? super R>, Object> $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(RoomDatabase roomDatabase, CancellableContinuation<? super R> cancellableContinuation, Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = cancellableContinuation;
                        this.$transactionBlock = function2;
                    }

                    @Override // U1.a
                    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // U1.a
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Continuation continuation;
                        T1.a aVar = T1.a.f1304a;
                        int i = this.label;
                        if (i == 0) {
                            l.e0(obj);
                            CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(ContinuationInterceptor.Key);
                            h.c(element);
                            CoroutineContext coroutineContextCreateTransactionContext = RoomDatabaseKt.createTransactionContext(this.$this_startTransactionCoroutine, (ContinuationInterceptor) element);
                            Continuation continuation2 = this.$continuation;
                            Function2<CoroutineScope, Continuation<? super R>, Object> function2 = this.$transactionBlock;
                            this.L$0 = continuation2;
                            this.label = 1;
                            obj = AbstractC0690y.m(coroutineContextCreateTransactionContext, function2, this);
                            if (obj == aVar) {
                                return aVar;
                            }
                            continuation = continuation2;
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            continuation = (Continuation) this.L$0;
                            l.e0(obj);
                        }
                        continuation.resumeWith(obj);
                        return m.f1129a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AbstractC0690y.j(coroutineContext.minusKey(ContinuationInterceptor.Key), new AnonymousClass1(roomDatabase, c0672f, function2, null));
                    } catch (Throwable th) {
                        c0672f.cancel(th);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            c0672f.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        return c0672f.m();
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(roomDatabase, function1, null);
        TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.INSTANCE);
        ContinuationInterceptor transactionDispatcher = transactionElement != null ? transactionElement.getTransactionDispatcher() : null;
        return transactionDispatcher != null ? AbstractC0690y.m(transactionDispatcher, roomDatabaseKt$withTransaction$transactionBlock$1, continuation) : startTransactionCoroutine(roomDatabase, continuation.getContext(), roomDatabaseKt$withTransaction$transactionBlock$1, continuation);
    }
}
