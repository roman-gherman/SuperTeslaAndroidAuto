package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0015\u0010\u0018J-\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0001\u0010\u001b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010#J)\u0010!\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00022\u0010\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a0\u0019H&¢\u0006\u0004\b!\u0010$J\u0017\u0010!\u001a\u00020\"2\u0006\u0010!\u001a\u00020%H&¢\u0006\u0004\b!\u0010&J!\u0010!\u001a\u00020\"2\u0006\u0010!\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H'¢\u0006\u0004\b!\u0010)J'\u0010/\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H&¢\u0006\u0004\b/\u00100J5\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u00022\u0012\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H&¢\u0006\u0004\b3\u00104JE\u00105\u001a\u00020+2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u00010\u00022\u0012\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H&¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b7\u00108J)\u00107\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a0\u0019H&¢\u0006\u0004\b7\u0010\u001dJ\u0017\u0010:\u001a\u00020\u00122\u0006\u00109\u001a\u00020+H&¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H&¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020+H&¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0012H'¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0012H&¢\u0006\u0004\bF\u0010\u0014J\u000f\u0010G\u001a\u00020\u0007H'¢\u0006\u0004\bG\u0010\tR\u0014\u0010H\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0014R\u0014\u0010I\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0014R\u001c\u0010M\u001a\u00020+8&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010BR\u0014\u0010P\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001c\u0010T\u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010O\"\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0014R\u0014\u0010V\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0014R\u0016\u0010Y\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020\u00128gX¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0014R(\u0010_\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\\\u0018\u00010[8fX¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006aÀ\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteDatabase;", "Ljava/io/Closeable;", "", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "compileStatement", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "LN1/m;", "beginTransaction", "()V", "beginTransactionNonExclusive", "Landroid/database/sqlite/SQLiteTransactionListener;", "transactionListener", "beginTransactionWithListener", "(Landroid/database/sqlite/SQLiteTransactionListener;)V", "beginTransactionWithListenerNonExclusive", "endTransaction", "setTransactionSuccessful", "", "inTransaction", "()Z", "yieldIfContendedSafely", "", "sleepAfterYieldDelayMillis", "(J)Z", "", "", "bindArgs", "execPerConnectionSQL", "(Ljava/lang/String;[Ljava/lang/Object;)V", "numBytes", "setMaximumSize", "(J)J", "query", "Landroid/database/Cursor;", "(Ljava/lang/String;)Landroid/database/Cursor;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "insert", "(Ljava/lang/String;ILandroid/content/ContentValues;)J", "whereClause", "whereArgs", "delete", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "execSQL", "(Ljava/lang/String;)V", "newVersion", "needUpgrade", "(I)Z", "Ljava/util/Locale;", "locale", "setLocale", "(Ljava/util/Locale;)V", "cacheSize", "setMaxSqlCacheSize", "(I)V", "enabled", "setForeignKeyConstraintsEnabled", "(Z)V", "enableWriteAheadLogging", "disableWriteAheadLogging", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "getVersion", "()I", "setVersion", "version", "getMaximumSize", "()J", "maximumSize", "getPageSize", "setPageSize", "(J)V", "pageSize", "isReadOnly", "isOpen", "getPath", "()Ljava/lang/String;", "path", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "getAttachedDbs", "()Ljava/util/List;", "attachedDbs", "isDatabaseIntegrityOk", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionWithListener(SQLiteTransactionListener transactionListener);

    void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener);

    SupportSQLiteStatement compileStatement(String sql);

    int delete(String table, String whereClause, Object[] whereArgs);

    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    default void execPerConnectionSQL(String sql, Object[] bindArgs) {
        h.f(sql, "sql");
        throw new UnsupportedOperationException();
    }

    void execSQL(String sql);

    void execSQL(String sql, Object[] bindArgs);

    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(String table, int conflictAlgorithm, ContentValues values);

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    default boolean isExecPerConnectionSQLSupported() {
        return false;
    }

    boolean isOpen();

    boolean isReadOnly();

    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int newVersion);

    Cursor query(SupportSQLiteQuery query);

    Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal);

    Cursor query(String query);

    Cursor query(String query, Object[] bindArgs);

    void setForeignKeyConstraintsEnabled(boolean enabled);

    void setLocale(Locale locale);

    void setMaxSqlCacheSize(int cacheSize);

    long setMaximumSize(long numBytes);

    void setPageSize(long j6);

    void setTransactionSuccessful();

    void setVersion(int i);

    int update(String table, int conflictAlgorithm, ContentValues values, String whereClause, Object[] whereArgs);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long sleepAfterYieldDelayMillis);
}
