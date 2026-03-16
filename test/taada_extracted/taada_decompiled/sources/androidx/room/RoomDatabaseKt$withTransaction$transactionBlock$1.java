package androidx.room;

import N1.m;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
public final class RoomDatabaseKt$withTransaction$transactionBlock$1<R> extends U1.g implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super RoomDatabaseKt$withTransaction$transactionBlock$1> continuation) {
        super(2, continuation);
        this.$this_withTransaction = roomDatabase;
        this.$block = function1;
    }

    @Override // U1.a
    public final Continuation<m> create(Object obj, Continuation<?> continuation) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, continuation);
        roomDatabaseKt$withTransaction$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt$withTransaction$transactionBlock$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T1.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // U1.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        TransactionElement transactionElement;
        TransactionElement transactionElement2 = T1.a.f1304a;
        int i = this.label;
        try {
            if (i == 0) {
                l.e0(obj);
                CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.INSTANCE);
                h.c(element);
                TransactionElement transactionElement3 = (TransactionElement) element;
                transactionElement3.acquire();
                try {
                    this.$this_withTransaction.beginTransaction();
                    try {
                        Function1<Continuation<? super R>, Object> function1 = this.$block;
                        this.L$0 = transactionElement3;
                        this.label = 1;
                        Object objInvoke = function1.invoke(this);
                        if (objInvoke == transactionElement2) {
                            return transactionElement2;
                        }
                        transactionElement = transactionElement3;
                        obj = objInvoke;
                    } catch (Throwable th2) {
                        th = th2;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } catch (Throwable th3) {
                    transactionElement2 = transactionElement3;
                    th = th3;
                    transactionElement2.release();
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                transactionElement = (TransactionElement) this.L$0;
                try {
                    l.e0(obj);
                } catch (Throwable th4) {
                    th = th4;
                    this.$this_withTransaction.endTransaction();
                    throw th;
                }
            }
            this.$this_withTransaction.setTransactionSuccessful();
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
    }
}
