package X0;

import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tenjin.android.store.QueueEventDatabase_Impl;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends RoomOpenHelper.Delegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QueueEventDatabase_Impl f1407a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(QueueEventDatabase_Impl queueEventDatabase_Impl) {
        super(1);
        this.f1407a = queueEventDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `QueueEvent` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `params` TEXT NOT NULL, `date` INTEGER NOT NULL, `endpoint` TEXT NOT NULL)");
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0a5a33ee0f6cf2beee6328f77b70fd7e')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `QueueEvent`");
        QueueEventDatabase_Impl queueEventDatabase_Impl = this.f1407a;
        if (((RoomDatabase) queueEventDatabase_Impl).mCallbacks != null) {
            int size = ((RoomDatabase) queueEventDatabase_Impl).mCallbacks.size();
            for (int i = 0; i < size; i++) {
                ((RoomDatabase.Callback) ((RoomDatabase) queueEventDatabase_Impl).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        QueueEventDatabase_Impl queueEventDatabase_Impl = this.f1407a;
        if (((RoomDatabase) queueEventDatabase_Impl).mCallbacks != null) {
            int size = ((RoomDatabase) queueEventDatabase_Impl).mCallbacks.size();
            for (int i = 0; i < size; i++) {
                ((RoomDatabase.Callback) ((RoomDatabase) queueEventDatabase_Impl).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        QueueEventDatabase_Impl queueEventDatabase_Impl = this.f1407a;
        ((RoomDatabase) queueEventDatabase_Impl).mDatabase = supportSQLiteDatabase;
        queueEventDatabase_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
        if (((RoomDatabase) queueEventDatabase_Impl).mCallbacks != null) {
            int size = ((RoomDatabase) queueEventDatabase_Impl).mCallbacks.size();
            for (int i = 0; i < size; i++) {
                ((RoomDatabase.Callback) ((RoomDatabase) queueEventDatabase_Impl).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException {
        DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        HashMap map = new HashMap(4);
        map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        map.put("params", new TableInfo.Column("params", "TEXT", true, 0, null, 1));
        map.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
        map.put("endpoint", new TableInfo.Column("endpoint", "TEXT", true, 0, null, 1));
        TableInfo tableInfo = new TableInfo("QueueEvent", map, new HashSet(0), new HashSet(0));
        TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "QueueEvent");
        if (tableInfo.equals(tableInfo2)) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
        return new RoomOpenHelper.ValidationResult(false, "QueueEvent(com.tenjin.android.store.QueueEvent).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
    }
}
