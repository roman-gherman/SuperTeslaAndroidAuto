package fr.sd.taada.analytics.telemetry;

import N1.m;
import androidx.core.app.NotificationCompat;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Dao
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tH§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tH§@¢\u0006\u0004\b\u0010\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0007H§@¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0017\u0010\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u0018H§@¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryDao;", "", "Lfr/sd/taada/analytics/telemetry/TelemetryEvent;", NotificationCompat.CATEGORY_EVENT, "", "insert", "(Lfr/sd/taada/analytics/telemetry/TelemetryEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "limit", "", "getUnsyncedEvents", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "LN1/m;", "markAsSynced", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementSyncAttempts", "beforeTimestamp", "deleteSyncedOlderThan", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOlderThan", "getUnsyncedCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastEvent", "", "eventType", "getLastEventOfType", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TelemetryDao {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getUnsyncedEvents$default(TelemetryDao telemetryDao, int i, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUnsyncedEvents");
            }
            if ((i3 & 1) != 0) {
                i = 100;
            }
            return telemetryDao.getUnsyncedEvents(i, continuation);
        }
    }

    @Query("DELETE FROM telemetry_events WHERE timestamp < :beforeTimestamp")
    @Nullable
    Object deleteOlderThan(long j6, @NotNull Continuation<? super Integer> continuation);

    @Query("DELETE FROM telemetry_events WHERE synced = 1 AND timestamp < :beforeTimestamp")
    @Nullable
    Object deleteSyncedOlderThan(long j6, @NotNull Continuation<? super Integer> continuation);

    @Query("SELECT * FROM telemetry_events ORDER BY timestamp DESC LIMIT 1")
    @Nullable
    Object getLastEvent(@NotNull Continuation<? super TelemetryEvent> continuation);

    @Query("SELECT * FROM telemetry_events WHERE eventType = :eventType ORDER BY timestamp DESC LIMIT 1")
    @Nullable
    Object getLastEventOfType(@NotNull String str, @NotNull Continuation<? super TelemetryEvent> continuation);

    @Query("SELECT COUNT(*) FROM telemetry_events WHERE synced = 0")
    @Nullable
    Object getUnsyncedCount(@NotNull Continuation<? super Integer> continuation);

    @Query("SELECT * FROM telemetry_events WHERE synced = 0 ORDER BY timestamp ASC LIMIT :limit")
    @Nullable
    Object getUnsyncedEvents(int i, @NotNull Continuation<? super List<TelemetryEvent>> continuation);

    @Query("UPDATE telemetry_events SET syncAttempts = syncAttempts + 1 WHERE id IN (:ids)")
    @Nullable
    Object incrementSyncAttempts(@NotNull List<Long> list, @NotNull Continuation<? super m> continuation);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull TelemetryEvent telemetryEvent, @NotNull Continuation<? super Long> continuation);

    @Query("UPDATE telemetry_events SET synced = 1 WHERE id IN (:ids)")
    @Nullable
    Object markAsSynced(@NotNull List<Long> list, @NotNull Continuation<? super m> continuation);
}
