package androidx.room;

import N1.m;
import androidx.room.InvalidationTracker;
import io.ktor.utils.io.jvm.javaio.q;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import m3.AbstractC0690y;
import o3.n;
import p3.v;
import r3.t;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/jvm/JvmSuppressWildcards;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$createFlow$1<R> extends U1.g implements Function2<FlowCollector<R>, Continuation<? super m>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends U1.g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        final /* synthetic */ FlowCollector<R> $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {128, 130}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00121 extends U1.g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ Channel<m> $observerChannel;
            final /* synthetic */ Channel<R> $resultChannel;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00121(RoomDatabase roomDatabase, CoroutinesRoom$Companion$createFlow$1$1$observer$1 coroutinesRoom$Companion$createFlow$1$1$observer$1, Channel channel, Callable callable, Channel channel2, Continuation continuation) {
                super(2, continuation);
                this.$db = roomDatabase;
                this.$observer = coroutinesRoom$Companion$createFlow$1$1$observer$1;
                this.$observerChannel = channel;
                this.$callable = callable;
                this.$resultChannel = channel2;
            }

            @Override // U1.a
            public final Continuation<m> create(Object obj, Continuation<?> continuation) {
                return new C00121(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
            
                if (r4.send(r7, r6) == r0) goto L26;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:7:0x0010, B:18:0x003b, B:22:0x0049, B:24:0x0051, B:14:0x0023, B:17:0x0035), top: B:31:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:8:0x0013). Please report as a decompilation issue!!! */
            @Override // U1.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    T1.a r0 = T1.a.f1304a
                    int r1 = r6.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L27
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r6.L$0
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    kotlin.reflect.l.e0(r7)     // Catch: java.lang.Throwable -> L15
                L13:
                    r7 = r1
                    goto L3b
                L15:
                    r7 = move-exception
                    goto L75
                L17:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1f:
                    java.lang.Object r1 = r6.L$0
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    kotlin.reflect.l.e0(r7)     // Catch: java.lang.Throwable -> L15
                    goto L49
                L27:
                    kotlin.reflect.l.e0(r7)
                    androidx.room.RoomDatabase r7 = r6.$db
                    androidx.room.InvalidationTracker r7 = r7.getInvalidationTracker()
                    androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1 r1 = r6.$observer
                    r7.addObserver(r1)
                    kotlinx.coroutines.channels.Channel<N1.m> r7 = r6.$observerChannel     // Catch: java.lang.Throwable -> L15
                    kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L15
                L3b:
                    r6.L$0 = r7     // Catch: java.lang.Throwable -> L15
                    r6.label = r3     // Catch: java.lang.Throwable -> L15
                    java.lang.Object r1 = r7.hasNext(r6)     // Catch: java.lang.Throwable -> L15
                    if (r1 != r0) goto L46
                    goto L66
                L46:
                    r5 = r1
                    r1 = r7
                    r7 = r5
                L49:
                    java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L15
                    boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L15
                    if (r7 == 0) goto L67
                    r1.next()     // Catch: java.lang.Throwable -> L15
                    java.util.concurrent.Callable<R> r7 = r6.$callable     // Catch: java.lang.Throwable -> L15
                    java.lang.Object r7 = r7.call()     // Catch: java.lang.Throwable -> L15
                    kotlinx.coroutines.channels.Channel<R> r4 = r6.$resultChannel     // Catch: java.lang.Throwable -> L15
                    r6.L$0 = r1     // Catch: java.lang.Throwable -> L15
                    r6.label = r2     // Catch: java.lang.Throwable -> L15
                    java.lang.Object r7 = r4.send(r7, r6)     // Catch: java.lang.Throwable -> L15
                    if (r7 != r0) goto L13
                L66:
                    return r0
                L67:
                    androidx.room.RoomDatabase r7 = r6.$db
                    androidx.room.InvalidationTracker r7 = r7.getInvalidationTracker()
                    androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1 r0 = r6.$observer
                    r7.removeObserver(r0)
                    N1.m r7 = N1.m.f1129a
                    return r7
                L75:
                    androidx.room.RoomDatabase r0 = r6.$db
                    androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                    androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1 r1 = r6.$observer
                    r0.removeObserver(r1)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.C00121.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
                return ((C00121) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z6, RoomDatabase roomDatabase, FlowCollector<R> flowCollector, String[] strArr, Callable<R> callable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$inTransaction = z6;
            this.$db = roomDatabase;
            this.$$this$flow = flowCollector;
            this.$tableNames = strArr;
            this.$callable = callable;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Type inference failed for: r8v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            ContinuationInterceptor transactionDispatcher;
            T1.a aVar = T1.a.f1304a;
            int i = this.label;
            m mVar = m.f1129a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
                return mVar;
            }
            l.e0(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final n nVarA = q.a(-1, null, 6);
            final String[] strArr = this.$tableNames;
            ?? r8 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(Set<String> tables) {
                    nVarA.mo106trySendJP2dKIU(m.f1129a);
                }
            };
            nVarA.mo106trySendJP2dKIU(mVar);
            TransactionElement transactionElement = (TransactionElement) coroutineScope.getCoroutineContext().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            }
            n nVarA2 = q.a(0, null, 7);
            AbstractC0690y.g(coroutineScope, transactionDispatcher, new C00121(this.$db, r8, nVarA, this.$callable, nVarA2, null), 2);
            FlowCollector<R> flowCollector = this.$$this$flow;
            this.label = 1;
            Object objE = v.e(flowCollector, nVarA2, true, this);
            if (objE != aVar) {
                objE = mVar;
            }
            return objE == aVar ? aVar : mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(boolean z6, RoomDatabase roomDatabase, String[] strArr, Callable<R> callable, Continuation<? super CoroutinesRoom$Companion$createFlow$1> continuation) {
        super(2, continuation);
        this.$inTransaction = z6;
        this.$db = roomDatabase;
        this.$tableNames = strArr;
        this.$callable = callable;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, continuation);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.label;
        if (i == 0) {
            l.e0(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$inTransaction, this.$db, (FlowCollector) this.L$0, this.$tableNames, this.$callable, null);
            this.label = 1;
            t tVar = new t(this, getContext());
            if (io.ktor.utils.io.internal.t.q(tVar, tVar, anonymousClass1) == aVar) {
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
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo5invoke(FlowCollector<R> flowCollector, Continuation<? super m> continuation) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(flowCollector, continuation)).invokeSuspend(m.f1129a);
    }
}
