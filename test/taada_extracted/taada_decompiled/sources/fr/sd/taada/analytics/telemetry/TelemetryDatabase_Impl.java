package fr.sd.taada.analytics.telemetry;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class TelemetryDatabase_Impl extends TelemetryDatabase {
    private volatile TelemetryDao _telemetryDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `telemetry_events`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "telemetry_events");
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: fr.sd.taada.analytics.telemetry.TelemetryDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `telemetry_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `eventType` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `metadata` TEXT, `synced` INTEGER NOT NULL, `syncAttempts` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '978572ed5646c96055a7ffcfa4b6b5af')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `telemetry_events`");
                List list = ((RoomDatabase) TelemetryDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                List list = ((RoomDatabase) TelemetryDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) TelemetryDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                TelemetryDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                List list = ((RoomDatabase) TelemetryDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws IOException {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            @NonNull
            public RoomOpenHelper.ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(6);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                map.put("eventType", new TableInfo.Column("eventType", "TEXT", true, 0, null, 1));
                map.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                map.put("metadata", new TableInfo.Column("metadata", "TEXT", false, 0, null, 1));
                map.put("synced", new TableInfo.Column("synced", "INTEGER", true, 0, null, 1));
                map.put("syncAttempts", new TableInfo.Column("syncAttempts", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("telemetry_events", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "telemetry_events");
                if (tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "telemetry_events(fr.sd.taada.analytics.telemetry.TelemetryEvent).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
        }, "978572ed5646c96055a7ffcfa4b6b5af", "70901097dc301f61ec70c77dcb571671")).build());
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    @NonNull
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(TelemetryDao.class, TelemetryDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // fr.sd.taada.analytics.telemetry.TelemetryDatabase
    public TelemetryDao telemetryDao() {
        TelemetryDao telemetryDao;
        if (this._telemetryDao != null) {
            return this._telemetryDao;
        }
        synchronized (this) {
            try {
                if (this._telemetryDao == null) {
                    this._telemetryDao = new TelemetryDao_Impl(this);
                }
                telemetryDao = this._telemetryDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return telemetryDao;
    }
}
