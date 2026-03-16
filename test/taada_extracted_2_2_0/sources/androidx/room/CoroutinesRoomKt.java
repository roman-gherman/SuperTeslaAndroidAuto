package androidx.room;

import java.util.Map;
import kotlin.Metadata;
import m3.AbstractC0684s;
import m3.U;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/room/RoomDatabase;", "Lm3/s;", "getQueryDispatcher", "(Landroidx/room/RoomDatabase;)Lm3/s;", "getTransactionDispatcher", "transactionDispatcher", "room-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutinesRoomKt {
    public static final AbstractC0684s getQueryDispatcher(RoomDatabase roomDatabase) {
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object u = backingFieldMap.get("QueryDispatcher");
        if (u == null) {
            u = new U(roomDatabase.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", u);
        }
        return (AbstractC0684s) u;
    }

    public static final AbstractC0684s getTransactionDispatcher(RoomDatabase roomDatabase) {
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object u = backingFieldMap.get("TransactionDispatcher");
        if (u == null) {
            u = new U(roomDatabase.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", u);
        }
        return (AbstractC0684s) u;
    }
}
