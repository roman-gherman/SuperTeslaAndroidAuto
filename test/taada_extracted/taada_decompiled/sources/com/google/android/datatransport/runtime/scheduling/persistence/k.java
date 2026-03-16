package com.google.android.datatransport.runtime.scheduling.persistence;

import C0.t;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import javax.inject.Provider;
import k.C0569b;
import p.C0751a;
import t.C0817a;
import v.AbstractC0846a;

/* JADX INFO: loaded from: classes.dex */
public final class k implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0569b f1904f = new C0569b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f1905a;
    public final Clock b;
    public final Clock c;
    public final a d;
    public final Provider e;

    public k(Clock clock, Clock clock2, a aVar, m mVar, Provider provider) {
        this.f1905a = mVar;
        this.b = clock;
        this.c = clock2;
        this.d = aVar;
        this.e = provider;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, u uVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        com.google.android.datatransport.runtime.k kVar = (com.google.android.datatransport.runtime.k) uVar;
        ArrayList arrayList = new ArrayList(Arrays.asList(kVar.f1883a, String.valueOf(AbstractC0846a.a(kVar.c))));
        byte[] bArr = kVar.b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String e(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) ((d) it.next())).f1897a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object f(Cursor cursor, SQLiteEventStore$Function sQLiteEventStore$Function) {
        try {
            return sQLiteEventStore$Function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        m mVar = this.f1905a;
        Objects.requireNonNull(mVar);
        Clock clock = this.c;
        long time = clock.getTime();
        while (true) {
            try {
                return mVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (clock.getTime() >= ((long) this.d.c) + time) {
                    throw new C0817a("Timed out while trying to open db.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final Object c(SQLiteEventStore$Function sQLiteEventStore$Function) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = sQLiteEventStore$Function.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final int cleanUp() {
        long time = this.b.getTime() - this.d.d;
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            String[] strArr = {String.valueOf(time)};
            Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
            while (cursorRawQuery.moveToNext()) {
                try {
                    recordLogEventDropped(cursorRawQuery.getInt(0), p.c.MESSAGE_TOO_OLD, cursorRawQuery.getString(1));
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
            cursorRawQuery.close();
            int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", strArr);
            sQLiteDatabaseA.setTransactionSuccessful();
            return iDelete;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1905a.close();
    }

    public final ArrayList d(SQLiteDatabase sQLiteDatabase, u uVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long lB = b(sQLiteDatabase, uVar);
        if (lB == null) {
            return arrayList;
        }
        f(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lB.toString()}, null, null, null, String.valueOf(i)), new f(this, arrayList, uVar, 1));
        return arrayList;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final long getNextCallTime(u uVar) {
        Cursor cursorRawQuery = a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{((com.google.android.datatransport.runtime.k) uVar).f1883a, String.valueOf(AbstractC0846a.a(((com.google.android.datatransport.runtime.k) uVar).c))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            return lValueOf.longValue();
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final boolean hasPendingEventsFor(u uVar) {
        Boolean bool;
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Long lB = b(sQLiteDatabaseA, uVar);
            if (lB == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor cursorRawQuery = a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lB.toString()});
                try {
                    Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    bool = boolValueOf;
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th2) {
            sQLiteDatabaseA.endTransaction();
            throw th2;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final Iterable loadActiveContexts() {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            List list = (List) f(sQLiteDatabaseA.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new i());
            sQLiteDatabaseA.setTransactionSuccessful();
            return list;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final Iterable loadBatch(final u uVar) {
        return (Iterable) c(new SQLiteEventStore$Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.e
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                k kVar = this.f1899a;
                a aVar = kVar.d;
                int i = aVar.b;
                u uVar2 = uVar;
                ArrayList arrayListD = kVar.d(sQLiteDatabase, uVar2, i);
                for (k.d dVar : k.d.values()) {
                    if (dVar != ((com.google.android.datatransport.runtime.k) uVar2).c) {
                        int size = aVar.b - arrayListD.size();
                        if (size <= 0) {
                            break;
                        }
                        uVar2.getClass();
                        com.google.android.datatransport.runtime.k kVar2 = (com.google.android.datatransport.runtime.k) uVar2;
                        String str = kVar2.f1883a;
                        if (str == null) {
                            throw new NullPointerException("Null backendName");
                        }
                        if (dVar == null) {
                            throw new NullPointerException("Null priority");
                        }
                        arrayListD.addAll(kVar.d(sQLiteDatabase, new com.google.android.datatransport.runtime.k(str, kVar2.b, dVar), size));
                    }
                }
                HashMap map = new HashMap();
                StringBuilder sb = new StringBuilder("event_id IN (");
                for (int i3 = 0; i3 < arrayListD.size(); i3++) {
                    sb.append(((b) ((d) arrayListD.get(i3))).f1897a);
                    if (i3 < arrayListD.size() - 1) {
                        sb.append(',');
                    }
                }
                sb.append(')');
                Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        long j6 = cursorQuery.getLong(0);
                        Set hashSet = (Set) map.get(Long.valueOf(j6));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            map.put(Long.valueOf(j6), hashSet);
                        }
                        hashSet.add(new j(cursorQuery.getString(1), cursorQuery.getString(2)));
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
                ListIterator listIterator = arrayListD.listIterator();
                while (listIterator.hasNext()) {
                    b bVar = (b) ((d) listIterator.next());
                    if (map.containsKey(Long.valueOf(bVar.f1897a))) {
                        com.google.android.datatransport.runtime.h hVarC = bVar.c.c();
                        long j7 = bVar.f1897a;
                        for (j jVar : (Set) map.get(Long.valueOf(j7))) {
                            hVarC.a(jVar.f1903a, jVar.b);
                        }
                        listIterator.set(new b(j7, bVar.b, hVarC.b()));
                    }
                }
                return arrayListD;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final C0751a loadClientMetrics() {
        int i = C0751a.e;
        t tVar = new t(15, false);
        tVar.b = null;
        tVar.c = new ArrayList();
        tVar.d = null;
        tVar.e = "";
        HashMap map = new HashMap();
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            C0751a c0751a = (C0751a) f(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new f(this, map, tVar, 2));
            sQLiteDatabaseA.setTransactionSuccessful();
            return c0751a;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final d persist(u uVar, o oVar) {
        com.google.android.datatransport.runtime.k kVar = (com.google.android.datatransport.runtime.k) uVar;
        k.d dVar = kVar.c;
        String str = ((com.google.android.datatransport.runtime.i) oVar).f1880a;
        String str2 = kVar.f1883a;
        if (Log.isLoggable("TRuntime.".concat("SQLiteEventStore"), 3)) {
            new StringBuilder("Storing event with priority=").append(dVar);
        }
        long jLongValue = ((Long) c(new f(this, oVar, uVar, 0))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return new b(jLongValue, uVar, oVar);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void recordFailure(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + e(iterable);
            SQLiteDatabase sQLiteDatabaseA = a();
            sQLiteDatabaseA.beginTransaction();
            try {
                sQLiteDatabaseA.compileStatement(str).execute();
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        recordLogEventDropped(cursorRawQuery.getInt(0), p.c.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
                cursorRawQuery.close();
                sQLiteDatabaseA.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseA.endTransaction();
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final void recordLogEventDropped(final long j6, final p.c cVar, final String str) {
        c(new SQLiteEventStore$Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.h
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                p.c cVar2 = cVar;
                String string = Integer.toString(cVar2.f4465a);
                String str2 = str;
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str2, string});
                try {
                    boolean z6 = cursorRawQuery.getCount() > 0;
                    cursorRawQuery.close();
                    long j7 = j6;
                    int i = cVar2.f4465a;
                    if (z6) {
                        sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j7 + " WHERE log_source = ? AND reason = ?", new String[]{str2, Integer.toString(i)});
                        return null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("log_source", str2);
                    contentValues.put("reason", Integer.valueOf(i));
                    contentValues.put("events_dropped_count", Long.valueOf(j7));
                    sQLiteDatabase.insert("log_event_dropped", null, contentValues);
                    return null;
                } catch (Throwable th) {
                    cursorRawQuery.close();
                    throw th;
                }
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void recordNextCallTime(final u uVar, final long j6) {
        c(new SQLiteEventStore$Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.g
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j6));
                com.google.android.datatransport.runtime.k kVar = (com.google.android.datatransport.runtime.k) uVar;
                String str = kVar.f1883a;
                k.d dVar = kVar.c;
                if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(AbstractC0846a.a(dVar))}) < 1) {
                    contentValues.put("backend_name", kVar.f1883a);
                    contentValues.put("priority", Integer.valueOf(AbstractC0846a.a(dVar)));
                    sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                return null;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void recordSuccess(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            a().compileStatement("DELETE FROM events WHERE _id in " + e(iterable)).execute();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final void resetClientMetrics() {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
            sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.b.getTime()).execute();
            sQLiteDatabaseA.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public final Object runCriticalSection(SynchronizationGuard.CriticalSection criticalSection) {
        SQLiteDatabase sQLiteDatabaseA = a();
        Clock clock = this.c;
        long time = clock.getTime();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objExecute = criticalSection.execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (clock.getTime() >= ((long) this.d.c) + time) {
                    throw new C0817a("Timed out while trying to acquire the lock.", e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
