package androidx.room.util;

import C5.f;
import P1.a;
import P1.b;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import io.ktor.utils.io.Z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.text.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u000f\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/room/RoomDatabase;", "db", "Landroidx/sqlite/db/SupportSQLiteQuery;", "sqLiteQuery", "", "maybeCopy", "Landroid/database/Cursor;", "query", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;Z)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "signal", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "LN1/m;", "dropFtsSyncTriggers", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "", "tableName", "foreignKeyCheck", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "Ljava/io/File;", "databaseFile", "", "readVersion", "(Ljava/io/File;)I", "createCancellationSignal", "()Landroid/os/CancellationSignal;", "cursor", "processForeignKeyCheckFailure", "(Landroid/database/Cursor;)Ljava/lang/String;", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase db) throws IOException {
        h.f(db, "db");
        b bVar = new b();
        Cursor cursorQuery = db.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorQuery.moveToNext()) {
            try {
                bVar.add(cursorQuery.getString(0));
            } finally {
            }
        }
        cursorQuery.close();
        Z.b(bVar);
        Iterator it = bVar.iterator();
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return;
            }
            String triggerName = (String) aVar.next();
            h.e(triggerName, "triggerName");
            if (r.C(triggerName, "room_fts_content_sync_")) {
                db.execSQL("DROP TRIGGER IF EXISTS ".concat(triggerName));
            }
        }
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase db, String tableName) {
        h.f(db, "db");
        h.f(tableName, "tableName");
        Cursor cursorQuery = db.query("PRAGMA foreign_key_check(`" + tableName + "`)");
        try {
            if (cursorQuery.getCount() > 0) {
                throw new SQLiteConstraintException(processForeignKeyCheckFailure(cursorQuery));
            }
            f.l(cursorQuery, null);
        } finally {
        }
    }

    private static final String processForeignKeyCheckFailure(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int count = cursor.getCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(cursor.getString(0));
                sb.append("'.\n");
            }
            String constraintIndex = cursor.getString(3);
            if (!linkedHashMap.containsKey(constraintIndex)) {
                h.e(constraintIndex, "constraintIndex");
                String string = cursor.getString(2);
                h.e(string, "cursor.getString(2)");
                linkedHashMap.put(constraintIndex, string);
            }
        }
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(count);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append("\tParent Table = ");
            sb.append(str2);
            sb.append(", Foreign Key Constraint Index = ");
            sb.append(str);
            sb.append("\n");
        }
        String string2 = sb.toString();
        h.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z6) {
        h.f(db, "db");
        h.f(sqLiteQuery, "sqLiteQuery");
        return query(db, sqLiteQuery, z6, null);
    }

    public static final int readVersion(File databaseFile) {
        h.f(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i = byteBufferAllocate.getInt();
            f.l(channel, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.l(channel, th);
                throw th2;
            }
        }
    }

    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z6, CancellationSignal cancellationSignal) {
        h.f(db, "db");
        h.f(sqLiteQuery, "sqLiteQuery");
        Cursor cursorQuery = db.query(sqLiteQuery, cancellationSignal);
        if (!z6 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(cursorQuery) : cursorQuery;
    }
}
