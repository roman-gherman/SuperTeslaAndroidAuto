package D;

import android.accounts.Account;
import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.tenjin.android.store.QueueEventDao;
import com.tenjin.android.store.QueueEventDatabase_Impl;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import k.AbstractC0570c;
import k.C0569b;

/* JADX INFO: loaded from: classes.dex */
public final class b implements QueueEventDao, Transport, Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f181a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public b(Account account, Set set, String str, String str2) {
        T.a aVar = T.a.f1299a;
        this.f181a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        Map map = Collections.EMPTY_MAP;
        this.c = map;
        this.d = str2;
        this.e = aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.b = Collections.unmodifiableSet(hashSet);
    }

    @Override // com.tenjin.android.store.QueueEventDao
    public void delete(X0.a aVar) {
        QueueEventDatabase_Impl queueEventDatabase_Impl = (QueueEventDatabase_Impl) this.f181a;
        queueEventDatabase_Impl.assertNotSuspendingTransaction();
        queueEventDatabase_Impl.beginTransaction();
        try {
            ((X0.c) this.c).handle(aVar);
            queueEventDatabase_Impl.setTransactionSuccessful();
        } finally {
            queueEventDatabase_Impl.endTransaction();
        }
    }

    @Override // com.tenjin.android.store.QueueEventDao
    public void deleteAllEvents() {
        QueueEventDatabase_Impl queueEventDatabase_Impl = (QueueEventDatabase_Impl) this.f181a;
        queueEventDatabase_Impl.assertNotSuspendingTransaction();
        X0.d dVar = (X0.d) this.d;
        SupportSQLiteStatement supportSQLiteStatementAcquire = dVar.acquire();
        queueEventDatabase_Impl.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            queueEventDatabase_Impl.setTransactionSuccessful();
        } finally {
            queueEventDatabase_Impl.endTransaction();
            dVar.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.tenjin.android.store.QueueEventDao
    public void deleteOldEvents(Date date) {
        QueueEventDatabase_Impl queueEventDatabase_Impl = (QueueEventDatabase_Impl) this.f181a;
        queueEventDatabase_Impl.assertNotSuspendingTransaction();
        X0.d dVar = (X0.d) this.e;
        SupportSQLiteStatement supportSQLiteStatementAcquire = dVar.acquire();
        Long lValueOf = date == null ? null : Long.valueOf(date.getTime());
        if (lValueOf == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, lValueOf.longValue());
        }
        queueEventDatabase_Impl.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            queueEventDatabase_Impl.setTransactionSuccessful();
        } finally {
            queueEventDatabase_Impl.endTransaction();
            dVar.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new r.a((Executor) ((Provider) this.f181a).get(), (BackendRegistry) ((Provider) this.b).get(), (WorkScheduler) ((B2.d) this.c).get(), (EventStore) ((Provider) this.d).get(), (SynchronizationGuard) ((Provider) this.e).get());
    }

    @Override // com.tenjin.android.store.QueueEventDao
    public List getAllEvents(Date date) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM QueueEvent WHERE date >= ? ORDER BY date DESC", 1);
        Long lValueOf = date == null ? null : Long.valueOf(date.getTime());
        if (lValueOf == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindLong(1, lValueOf.longValue());
        }
        QueueEventDatabase_Impl queueEventDatabase_Impl = (QueueEventDatabase_Impl) this.f181a;
        queueEventDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(queueEventDatabase_Impl, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "params");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endpoint");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                X0.a aVar = new X0.a();
                aVar.f1405a = cursorQuery.getInt(columnIndexOrThrow);
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                aVar.b = string == null ? null : (Map) new com.google.gson.m().c(new StringReader(string), new com.google.gson.reflect.a(new X0.i().b));
                Long lValueOf2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3));
                aVar.c = lValueOf2 == null ? null : new Date(lValueOf2.longValue());
                aVar.d = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.tenjin.android.store.QueueEventDao
    public List getEventsFromParams(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM QueueEvent WHERE params == ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        QueueEventDatabase_Impl queueEventDatabase_Impl = (QueueEventDatabase_Impl) this.f181a;
        queueEventDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(queueEventDatabase_Impl, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "params");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "date");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "endpoint");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                X0.a aVar = new X0.a();
                aVar.f1405a = cursorQuery.getInt(columnIndexOrThrow);
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                aVar.b = string == null ? null : (Map) new com.google.gson.m().c(new StringReader(string), new com.google.gson.reflect.a(new X0.i().b));
                Long lValueOf = cursorQuery.isNull(columnIndexOrThrow3) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow3));
                aVar.c = lValueOf == null ? null : new Date(lValueOf.longValue());
                aVar.d = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.tenjin.android.store.QueueEventDao
    public long insert(X0.a aVar) {
        QueueEventDatabase_Impl queueEventDatabase_Impl = (QueueEventDatabase_Impl) this.f181a;
        queueEventDatabase_Impl.assertNotSuspendingTransaction();
        queueEventDatabase_Impl.beginTransaction();
        try {
            long jInsertAndReturnId = ((X0.b) this.b).insertAndReturnId(aVar);
            queueEventDatabase_Impl.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            queueEventDatabase_Impl.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.Transport
    public void schedule(AbstractC0570c abstractC0570c, TransportScheduleCallback transportScheduleCallback) {
        com.google.android.datatransport.runtime.k kVar = (com.google.android.datatransport.runtime.k) this.f181a;
        if (abstractC0570c == null) {
            throw new NullPointerException("Null event");
        }
        String str = (String) this.d;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        Transformer transformer = (Transformer) this.c;
        if (transformer == null) {
            throw new NullPointerException("Null transformer");
        }
        C0569b c0569b = (C0569b) this.b;
        if (c0569b == null) {
            throw new NullPointerException("Null encoding");
        }
        ((com.google.android.datatransport.runtime.v) this.e).send(new com.google.android.datatransport.runtime.j(kVar, str, abstractC0570c, transformer, c0569b), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void send(AbstractC0570c abstractC0570c) {
        schedule(abstractC0570c, new D0.b(19));
    }

    public b(Provider provider, Provider provider2, B2.d dVar, Provider provider3, Provider provider4) {
        this.f181a = provider;
        this.b = provider2;
        this.c = dVar;
        this.d = provider3;
        this.e = provider4;
    }

    public b(com.google.android.datatransport.runtime.k kVar, String str, C0569b c0569b, Transformer transformer, com.google.android.datatransport.runtime.v vVar) {
        this.f181a = kVar;
        this.d = str;
        this.b = c0569b;
        this.c = transformer;
        this.e = vVar;
    }

    public b(QueueEventDatabase_Impl queueEventDatabase_Impl) {
        this.f181a = queueEventDatabase_Impl;
        this.b = new X0.b(queueEventDatabase_Impl);
        this.c = new X0.c(queueEventDatabase_Impl);
        this.d = new X0.d(queueEventDatabase_Impl, 0);
        this.e = new X0.d(queueEventDatabase_Impl, 1);
    }
}
