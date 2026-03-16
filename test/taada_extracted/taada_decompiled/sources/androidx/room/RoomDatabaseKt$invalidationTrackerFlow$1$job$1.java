package androidx.room;

import C0.x;
import N1.m;
import fr.sd.taada.proto.KeyCode;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import m3.D;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$job$1", f = "RoomDatabaseExt.kt", i = {}, l = {KeyCode.KEYCODE_TV_DATA_SERVICE_VALUE}, m = "invokeSuspend", n = {}, s = {})
public final class RoomDatabaseKt$invalidationTrackerFlow$1$job$1 extends U1.g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
    final /* synthetic */ ProducerScope<Set<String>> $$this$callbackFlow;
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ AtomicBoolean $ignoreInvalidation;
    final /* synthetic */ RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 $observer;
    final /* synthetic */ String[] $tables;
    final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$invalidationTrackerFlow$1$job$1(RoomDatabase roomDatabase, RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 roomDatabaseKt$invalidationTrackerFlow$1$observer$1, boolean z6, ProducerScope<? super Set<String>> producerScope, String[] strArr, AtomicBoolean atomicBoolean, Continuation<? super RoomDatabaseKt$invalidationTrackerFlow$1$job$1> continuation) {
        super(2, continuation);
        this.$this_invalidationTrackerFlow = roomDatabase;
        this.$observer = roomDatabaseKt$invalidationTrackerFlow$1$observer$1;
        this.$emitInitialState = z6;
        this.$$this$callbackFlow = producerScope;
        this.$tables = strArr;
        this.$ignoreInvalidation = atomicBoolean;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        return new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, this.$observer, this.$emitInitialState, this.$$this$callbackFlow, this.$tables, this.$ignoreInvalidation, continuation);
    }

    @Override // U1.a
    public final Object invokeSuspend(Object obj) {
        T1.a aVar = T1.a.f1304a;
        int i = this.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.e0(obj);
                throw new x();
            }
            l.e0(obj);
            this.$this_invalidationTrackerFlow.getInvalidationTracker().addObserver(this.$observer);
            if (this.$emitInitialState) {
                this.$$this$callbackFlow.mo106trySendJP2dKIU(j.N(this.$tables));
            }
            this.$ignoreInvalidation.set(false);
            this.label = 1;
            D.a(this);
            return aVar;
        } catch (Throwable th) {
            this.$this_invalidationTrackerFlow.getInvalidationTracker().removeObserver(this.$observer);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
        return ((RoomDatabaseKt$invalidationTrackerFlow$1$job$1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
    }
}
