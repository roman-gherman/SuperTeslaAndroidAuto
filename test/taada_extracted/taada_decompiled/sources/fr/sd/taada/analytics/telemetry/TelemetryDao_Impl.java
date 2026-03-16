package fr.sd.taada.analytics.telemetry;

import N1.m;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class TelemetryDao_Impl implements TelemetryDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<TelemetryEvent> __insertionAdapterOfTelemetryEvent;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOlderThan;
    private final SharedSQLiteStatement __preparedStmtOfDeleteSyncedOlderThan;

    public TelemetryDao_Impl(@NonNull RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTelemetryEvent = new EntityInsertionAdapter<TelemetryEvent>(roomDatabase) { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `telemetry_events` (`id`,`eventType`,`timestamp`,`metadata`,`synced`,`syncAttempts`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull TelemetryEvent telemetryEvent) {
                supportSQLiteStatement.bindLong(1, telemetryEvent.getId());
                if (telemetryEvent.getEventType() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, telemetryEvent.getEventType());
                }
                supportSQLiteStatement.bindLong(3, telemetryEvent.getTimestamp());
                if (telemetryEvent.getMetadata() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, telemetryEvent.getMetadata());
                }
                supportSQLiteStatement.bindLong(5, telemetryEvent.getSynced() ? 1L : 0L);
                supportSQLiteStatement.bindLong(6, telemetryEvent.getSyncAttempts());
            }
        };
        this.__preparedStmtOfDeleteSyncedOlderThan = new SharedSQLiteStatement(roomDatabase) { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM telemetry_events WHERE synced = 1 AND timestamp < ?";
            }
        };
        this.__preparedStmtOfDeleteOlderThan = new SharedSQLiteStatement(roomDatabase) { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            @NonNull
            public String createQuery() {
                return "DELETE FROM telemetry_events WHERE timestamp < ?";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object deleteOlderThan(final long j6, Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Integer>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public Integer call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = TelemetryDao_Impl.this.__preparedStmtOfDeleteOlderThan.acquire();
                supportSQLiteStatementAcquire.bindLong(1, j6);
                try {
                    TelemetryDao_Impl.this.__db.beginTransaction();
                    try {
                        Integer numValueOf = Integer.valueOf(supportSQLiteStatementAcquire.executeUpdateDelete());
                        TelemetryDao_Impl.this.__db.setTransactionSuccessful();
                        return numValueOf;
                    } finally {
                        TelemetryDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    TelemetryDao_Impl.this.__preparedStmtOfDeleteOlderThan.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object deleteSyncedOlderThan(final long j6, Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Integer>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public Integer call() {
                SupportSQLiteStatement supportSQLiteStatementAcquire = TelemetryDao_Impl.this.__preparedStmtOfDeleteSyncedOlderThan.acquire();
                supportSQLiteStatementAcquire.bindLong(1, j6);
                try {
                    TelemetryDao_Impl.this.__db.beginTransaction();
                    try {
                        Integer numValueOf = Integer.valueOf(supportSQLiteStatementAcquire.executeUpdateDelete());
                        TelemetryDao_Impl.this.__db.setTransactionSuccessful();
                        return numValueOf;
                    } finally {
                        TelemetryDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    TelemetryDao_Impl.this.__preparedStmtOfDeleteSyncedOlderThan.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object getLastEvent(Continuation<? super TelemetryEvent> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM telemetry_events ORDER BY timestamp DESC LIMIT 1", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<TelemetryEvent>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @Nullable
            public TelemetryEvent call() {
                TelemetryEvent telemetryEvent = null;
                Cursor cursorQuery = DBUtil.query(TelemetryDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "synced");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncAttempts");
                    if (cursorQuery.moveToFirst()) {
                        telemetryEvent = new TelemetryEvent(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0, cursorQuery.getInt(columnIndexOrThrow6));
                    }
                    return telemetryEvent;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object getLastEventOfType(String str, Continuation<? super TelemetryEvent> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM telemetry_events WHERE eventType = ? ORDER BY timestamp DESC LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<TelemetryEvent>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @Nullable
            public TelemetryEvent call() {
                TelemetryEvent telemetryEvent = null;
                Cursor cursorQuery = DBUtil.query(TelemetryDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "synced");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncAttempts");
                    if (cursorQuery.moveToFirst()) {
                        telemetryEvent = new TelemetryEvent(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0, cursorQuery.getInt(columnIndexOrThrow6));
                    }
                    return telemetryEvent;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object getUnsyncedCount(Continuation<? super Integer> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM telemetry_events WHERE synced = 0", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<Integer>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public Integer call() {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(TelemetryDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                        numValueOf = Integer.valueOf(cursorQuery.getInt(0));
                    }
                    return numValueOf;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object getUnsyncedEvents(int i, Continuation<? super List<TelemetryEvent>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM telemetry_events WHERE synced = 0 ORDER BY timestamp ASC LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<TelemetryEvent>>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.7
            @Override // java.util.concurrent.Callable
            @NonNull
            public List<TelemetryEvent> call() {
                Cursor cursorQuery = DBUtil.query(TelemetryDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "metadata");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "synced");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "syncAttempts");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(new TelemetryEvent(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5) != 0, cursorQuery.getInt(columnIndexOrThrow6)));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object incrementSyncAttempts(final List<Long> list, Continuation<? super m> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<m>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public m call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("UPDATE telemetry_events SET syncAttempts = syncAttempts + 1 WHERE id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = TelemetryDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                int i = 1;
                for (Long l6 : list) {
                    if (l6 == null) {
                        supportSQLiteStatementCompileStatement.bindNull(i);
                    } else {
                        supportSQLiteStatementCompileStatement.bindLong(i, l6.longValue());
                    }
                    i++;
                }
                TelemetryDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    TelemetryDao_Impl.this.__db.setTransactionSuccessful();
                    return m.f1129a;
                } finally {
                    TelemetryDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object insert(final TelemetryEvent telemetryEvent, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public Long call() {
                TelemetryDao_Impl.this.__db.beginTransaction();
                try {
                    Long lValueOf = Long.valueOf(TelemetryDao_Impl.this.__insertionAdapterOfTelemetryEvent.insertAndReturnId(telemetryEvent));
                    TelemetryDao_Impl.this.__db.setTransactionSuccessful();
                    return lValueOf;
                } finally {
                    TelemetryDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDao
    public Object markAsSynced(final List<Long> list, Continuation<? super m> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<m>() { // from class: fr.sd.taada.analytics.telemetry.TelemetryDao_Impl.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            @NonNull
            public m call() {
                StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
                sbNewStringBuilder.append("UPDATE telemetry_events SET synced = 1 WHERE id IN (");
                StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
                sbNewStringBuilder.append(")");
                SupportSQLiteStatement supportSQLiteStatementCompileStatement = TelemetryDao_Impl.this.__db.compileStatement(sbNewStringBuilder.toString());
                int i = 1;
                for (Long l6 : list) {
                    if (l6 == null) {
                        supportSQLiteStatementCompileStatement.bindNull(i);
                    } else {
                        supportSQLiteStatementCompileStatement.bindLong(i, l6.longValue());
                    }
                    i++;
                }
                TelemetryDao_Impl.this.__db.beginTransaction();
                try {
                    supportSQLiteStatementCompileStatement.executeUpdateDelete();
                    TelemetryDao_Impl.this.__db.setTransactionSuccessful();
                    return m.f1129a;
                } finally {
                    TelemetryDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }
}
