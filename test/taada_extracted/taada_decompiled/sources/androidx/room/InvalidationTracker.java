package androidx.room;

import P1.j;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.view.LiveData;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.collections.m;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.collections.w;
import kotlin.jvm.internal.h;
import kotlin.text.r;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 x2\u00020\u0001:\u0005xyz{|BX\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\b0\u0004\u0012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0004\b\f\u0010\rB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0004\b\f\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010 \u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0011H\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b(\u0010'J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0017¢\u0006\u0004\b)\u0010'J\u000f\u0010-\u001a\u00020*H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020\u0011H\u0016¢\u0006\u0004\b.\u0010\"J\u000f\u0010/\u001a\u00020\u0011H\u0017¢\u0006\u0004\b/\u0010\"J#\u00101\u001a\u00020\u00112\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005H\u0007¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0015H\u0000¢\u0006\u0004\b3\u0010\u0017J\u000f\u00104\u001a\u00020\u0011H\u0000¢\u0006\u0004\b3\u0010\"J;\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u001052\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000006H\u0017¢\u0006\u0004\b9\u0010:JC\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u001052\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u0006\u0010;\u001a\u00020*2\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000006H\u0017¢\u0006\u0004\b9\u0010<J\u000f\u0010=\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u0010\"J\u001f\u0010A\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00152\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00152\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bC\u0010BJ'\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\bD\u0010EJ'\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u000e\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\bG\u0010ER\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bI\u0010JR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010KR+\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010KR&\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020?0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010K\u001a\u0004\bM\u0010NR\"\u0010O\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010SR\u001a\u0010U\u001a\u00020T8GX\u0087\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR$\u0010\\\u001a\u0004\u0018\u00010[8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR&\u0010j\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020i0h8\u0000X\u0081\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010rR\u001a\u0010u\u001a\u00020t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bu\u0010v\u0012\u0004\bw\u0010\"¨\u0006}"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "Lkotlin/jvm/JvmSuppressWildcards;", "viewTables", "", "tableNames", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "Landroidx/room/AutoCloser;", "autoCloser", "LN1/m;", "setAutoCloser$room_runtime_release", "(Landroidx/room/AutoCloser;)V", "setAutoCloser", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "internalInit$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "internalInit", "Landroid/content/Context;", "context", "name", "Landroid/content/Intent;", "serviceIntent", "startMultiInstanceInvalidation$room_runtime_release", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "startMultiInstanceInvalidation", "stopMultiInstanceInvalidation$room_runtime_release", "()V", "stopMultiInstanceInvalidation", "Landroidx/room/InvalidationTracker$Observer;", "observer", "addObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "addWeakObserver", "removeObserver", "", "ensureInitialization$room_runtime_release", "()Z", "ensureInitialization", "refreshVersionsAsync", "refreshVersionsSync", "tables", "notifyObserversByTableNames", "([Ljava/lang/String;)V", "syncTriggers$room_runtime_release", "syncTriggers", "T", "Ljava/util/concurrent/Callable;", "computeFunction", "Landroidx/lifecycle/LiveData;", "createLiveData", "([Ljava/lang/String;Ljava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "inTransaction", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "onAutoCloseCallback", "db", "", "tableId", "stopTrackingTable", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "startTrackingTable", "validateAndResolveTableNames", "([Ljava/lang/String;)[Ljava/lang/String;", "names", "resolveViews", "Landroidx/room/RoomDatabase;", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "Ljava/util/Map;", "tableIdLookup", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "[Ljava/lang/String;", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "Landroidx/room/AutoCloser;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Z", "Landroidx/sqlite/db/SupportSQLiteStatement;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "Landroidx/room/InvalidationLiveDataContainer;", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/MultiInstanceInvalidationClient;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "syncTriggersLock", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "trackerLock", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "WeakObserver", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u0003R\u001a\u0010\u0013\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u0012\u0004\b\u0014\u0010\u0003R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Landroidx/room/InvalidationTracker$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "tableName", "triggerType", "getTriggerName$room_runtime_release", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getTriggerName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "LN1/m;", "beginTransactionInternal$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "beginTransactionInternal", "RESET_UPDATED_TABLES_SQL", "Ljava/lang/String;", "getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations", "SELECT_UPDATED_TABLES_SQL", "getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations", "CREATE_TRACKING_TABLE_SQL", "INVALIDATED_COLUMN_NAME", "TABLE_ID_COLUMN_NAME", "", "TRIGGERS", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.d dVar) {
            this();
        }

        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase database) {
            h.f(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String tableName, String triggerType) {
            h.f(tableName, "tableName");
            h.f(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "", "tableCount", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(I)V", "", "tableIds", "", "onAdded", "([I)Z", "onRemoved", "LN1/m;", "resetTriggerState", "()V", "getTablesToSync", "()[I", "", "tableObservers", "[J", "getTableObservers", "()[J", "", "triggerStates", "[Z", "triggerStateChanges", "[I", "needsSync", "Z", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public ObservedTableTracker(int i) {
            this.tableObservers = new long[i];
            this.triggerStates = new boolean[i];
            this.triggerStateChanges = new int[i];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i = 0;
                    int i3 = 0;
                    while (i < length) {
                        int i4 = i3 + 1;
                        int i5 = 1;
                        boolean z6 = jArr[i] > 0;
                        boolean[] zArr = this.triggerStates;
                        if (z6 != zArr[i3]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z6) {
                                i5 = 2;
                            }
                            iArr[i3] = i5;
                        } else {
                            this.triggerStateChanges[i3] = 0;
                        }
                        zArr[i3] = z6;
                        i++;
                        i3 = i4;
                    }
                    this.needsSync = false;
                    return (int[]) this.triggerStateChanges.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean onAdded(int... tableIds) {
            boolean z6;
            h.f(tableIds, "tableIds");
            synchronized (this) {
                z6 = false;
                for (int i : tableIds) {
                    long[] jArr = this.tableObservers;
                    long j6 = jArr[i];
                    jArr[i] = 1 + j6;
                    if (j6 == 0) {
                        z6 = true;
                        this.needsSync = true;
                    }
                }
            }
            return z6;
        }

        public final boolean onRemoved(int... tableIds) {
            boolean z6;
            h.f(tableIds, "tableIds");
            synchronized (this) {
                z6 = false;
                for (int i : tableIds) {
                    long[] jArr = this.tableObservers;
                    long j6 = jArr[i];
                    jArr[i] = j6 - 1;
                    if (j6 == 1) {
                        z6 = true;
                        this.needsSync = true;
                    }
                }
            }
            return z6;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
            }
        }

        public final void setNeedsSync(boolean z6) {
            this.needsSync = z6;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "Landroidx/room/InvalidationTracker$Observer;", "observer", "", "tableIds", "", "", "tableNames", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "", "", "invalidatedTablesIds", "LN1/m;", "notifyByTableInvalidStatus$room_runtime_release", "(Ljava/util/Set;)V", "notifyByTableInvalidStatus", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "notifyByTableNames", "Landroidx/room/InvalidationTracker$Observer;", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "[I", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "singleTableSet", "Ljava/util/Set;", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            h.f(observer, "observer");
            h.f(tableIds, "tableIds");
            h.f(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            this.singleTableSet = !(tableNames.length == 0) ? t.p(tableNames[0]) : w.f3806a;
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        /* JADX INFO: renamed from: getObserver$room_runtime_release, reason: from getter */
        public final Observer getObserver() {
            return this.observer;
        }

        /* JADX INFO: renamed from: getTableIds$room_runtime_release, reason: from getter */
        public final int[] getTableIds() {
            return this.tableIds;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> invalidatedTablesIds) {
            h.f(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            w wVar = w.f3806a;
            Set<String> set = wVar;
            if (length != 0) {
                int i = 0;
                if (length != 1) {
                    j jVar = new j();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i3 = 0;
                    while (i < length2) {
                        int i4 = i3 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i]))) {
                            jVar.add(this.tableNames[i3]);
                        }
                        i++;
                        i3 = i4;
                    }
                    t.b(jVar);
                    set = jVar;
                } else {
                    set = wVar;
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr[0]))) {
                        set = this.singleTableSet;
                    }
                }
            }
            if (set.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(set);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v2, types: [androidx.room.InvalidationTracker$Observer] */
        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.collections.w] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection, java.util.Set] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Set<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r1v3, types: [P1.j] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void notifyByTableNames$room_runtime_release(String[] tables) {
            h.f(tables, "tables");
            int length = this.tableNames.length;
            ?? jVar = w.f3806a;
            if (length != 0) {
                if (length != 1) {
                    jVar = new j();
                    for (String str : tables) {
                        for (String str2 : this.tableNames) {
                            if (r.x(str2, str)) {
                                jVar.add(str2);
                            }
                        }
                    }
                    t.b(jVar);
                } else {
                    int length2 = tables.length;
                    int i = 0;
                    while (true) {
                        if (i >= length2) {
                            break;
                        }
                        if (r.x(tables[i], this.tableNames[0])) {
                            jVar = this.singleTableSet;
                            break;
                        }
                        i++;
                    }
                }
            }
            if (jVar.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(jVar);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/InvalidationTracker$WeakObserver;", "Landroidx/room/InvalidationTracker$Observer;", "Landroidx/room/InvalidationTracker;", "tracker", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/room/InvalidationTracker;Landroidx/room/InvalidationTracker$Observer;)V", "", "", "tables", "LN1/m;", "onInvalidated", "(Ljava/util/Set;)V", "Landroidx/room/InvalidationTracker;", "getTracker", "()Landroidx/room/InvalidationTracker;", "Ljava/lang/ref/WeakReference;", "delegateRef", "Ljava/lang/ref/WeakReference;", "getDelegateRef", "()Ljava/lang/ref/WeakReference;", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker tracker, Observer delegate) {
            super(delegate.getTables());
            h.f(tracker, "tracker");
            h.f(delegate, "delegate");
            this.tracker = tracker;
            this.delegateRef = new WeakReference<>(delegate);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> tables) {
            h.f(tables, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }

    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        String lowerCase;
        h.f(database, "database");
        h.f(shadowTablesMap, "shadowTablesMap");
        h.f(viewTables, "viewTables");
        h.f(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String str = tableNames[i];
            Locale US = Locale.US;
            h.e(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            h.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i));
            String str2 = this.shadowTablesMap.get(tableNames[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(US);
                h.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            h.e(US2, "US");
            String lowerCase3 = value.toLowerCase(US2);
            h.e(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(US2);
                h.e(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, (Integer) A.H(map, lowerCase3));
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() throws IOException {
                InvalidationTracker invalidationTracker = this.this$0;
                j jVar = new j();
                Cursor cursorQuery$default = RoomDatabase.query$default(invalidationTracker.getDatabase(), new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), null, 2, null);
                while (cursorQuery$default.moveToNext()) {
                    try {
                        jVar.add(Integer.valueOf(cursorQuery$default.getInt(0)));
                    } finally {
                    }
                }
                cursorQuery$default.close();
                t.b(jVar);
                if (jVar.f1215a.isEmpty()) {
                    return jVar;
                }
                if (this.this$0.getCleanupStatement() == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                SupportSQLiteStatement cleanupStatement = this.this$0.getCleanupStatement();
                if (cleanupStatement == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                cleanupStatement.executeUpdateDelete();
                return jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<Integer> setCheckUpdatedTable;
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                Lock closeLock$room_runtime_release = this.this$0.getDatabase().getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                    } finally {
                        closeLock$room_runtime_release.unlock();
                        autoCloser2 = this.this$0.autoCloser;
                        if (autoCloser2 != null) {
                            autoCloser2.decrementCountAndScheduleClose();
                        }
                    }
                } catch (SQLiteException e) {
                    Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
                    setCheckUpdatedTable = w.f3806a;
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                    }
                } catch (IllegalStateException e6) {
                    Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e6);
                    setCheckUpdatedTable = w.f3806a;
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                    }
                }
                if (!this.this$0.ensureInitialization$room_runtime_release()) {
                    if (autoCloser2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (!this.this$0.getPendingRefresh().compareAndSet(true, false)) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser3 = this.this$0.autoCloser;
                    if (autoCloser3 != null) {
                        autoCloser3.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                if (this.this$0.getDatabase().inTransaction()) {
                    closeLock$room_runtime_release.unlock();
                    AutoCloser autoCloser4 = this.this$0.autoCloser;
                    if (autoCloser4 != null) {
                        autoCloser4.decrementCountAndScheduleClose();
                        return;
                    }
                    return;
                }
                SupportSQLiteDatabase writableDatabase = this.this$0.getDatabase().getOpenHelper().getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    setCheckUpdatedTable = checkUpdatedTable();
                    writableDatabase.setTransactionSuccessful();
                    closeLock$room_runtime_release.unlock();
                    autoCloser = this.this$0.autoCloser;
                    if (autoCloser != null) {
                        autoCloser.decrementCountAndScheduleClose();
                    }
                    if (setCheckUpdatedTable.isEmpty()) {
                        return;
                    }
                    SafeIterableMap<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper> observerMap$room_runtime_release = this.this$0.getObserverMap$room_runtime_release();
                    InvalidationTracker invalidationTracker = this.this$0;
                    synchronized (observerMap$room_runtime_release) {
                        Iterator<Map.Entry<K, V>> it = invalidationTracker.getObserverMap$room_runtime_release().iterator();
                        while (it.hasNext()) {
                            ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setCheckUpdatedTable);
                        }
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        };
    }

    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            SupportSQLiteStatement supportSQLiteStatement = this.cleanupStatement;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
            }
        }
    }

    private final String[] resolveViews(String[] names) {
        j jVar = new j();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            Locale US = Locale.US;
            h.e(US, "US");
            String lowerCase = str.toLowerCase(US);
            h.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                String lowerCase2 = str.toLowerCase(US);
                h.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                h.c(set);
                jVar.addAll(set);
            } else {
                jVar.add(str);
            }
        }
        t.b(jVar);
        return (String[]) jVar.toArray(new String[0]);
    }

    private final void startTrackingTable(SupportSQLiteDatabase db, int tableId) {
        db.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + tableId + ", 0)");
        String str = this.tablesNames[tableId];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + INSTANCE.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + tableId + " AND invalidated = 0; END";
            h.e(str3, "StringBuilder().apply(builderAction).toString()");
            db.execSQL(str3);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase db, int tableId) {
        String str = this.tablesNames[tableId];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + INSTANCE.getTriggerName$room_runtime_release(str, str2);
            h.e(str3, "StringBuilder().apply(builderAction).toString()");
            db.execSQL(str3);
        }
    }

    private final String[] validateAndResolveTableNames(String[] tableNames) {
        String[] strArrResolveViews = resolveViews(tableNames);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            h.e(US, "US");
            String lowerCase = str.toLowerCase(US);
            h.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException("There is no table with name ".concat(str).toString());
            }
        }
        return strArrResolveViews;
    }

    public void addObserver(Observer observer) {
        ObserverWrapper observerWrapperPutIfAbsent;
        h.f(observer, "observer");
        String[] strArrResolveViews = resolveViews(observer.getTables());
        ArrayList arrayList = new ArrayList(strArrResolveViews.length);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            h.e(US, "US");
            String lowerCase = str.toLowerCase(US);
            h.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name ".concat(str));
            }
            arrayList.add(num);
        }
        int[] iArrN0 = m.n0(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArrN0, strArrResolveViews);
        synchronized (this.observerMap) {
            observerWrapperPutIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (observerWrapperPutIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(iArrN0, iArrN0.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    public void addWeakObserver(Observer observer) {
        h.f(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @Deprecated(message = "Use [createLiveData(String[], boolean, Callable)]")
    public <T> LiveData<T> createLiveData(String[] tableNames, Callable<T> computeFunction) {
        h.f(tableNames, "tableNames");
        h.f(computeFunction, "computeFunction");
        return createLiveData(tableNames, false, computeFunction);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    }

    /* JADX INFO: renamed from: getCleanupStatement$room_runtime_release, reason: from getter */
    public final SupportSQLiteStatement getCleanupStatement() {
        return this.cleanupStatement;
    }

    /* JADX INFO: renamed from: getDatabase$room_runtime_release, reason: from getter */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    /* JADX INFO: renamed from: getTablesNames$room_runtime_release, reason: from getter */
    public final String[] getTablesNames() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase database) {
        h.f(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
        }
    }

    public final void notifyObserversByTableNames(String... tables) {
        h.f(tables, "tables");
        synchronized (this.observerMap) {
            Iterator<Map.Entry<K, V>> it = this.observerMap.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                h.e(entry, "(observer, wrapper)");
                Observer observer = (Observer) entry.getKey();
                ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                if (!observer.isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(tables);
                }
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    public void removeObserver(Observer observer) {
        ObserverWrapper observerWrapperRemove;
        h.f(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapperRemove = this.observerMap.remove(observer);
        }
        if (observerWrapperRemove != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds = observerWrapperRemove.getTableIds();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds, tableIds.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        h.f(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new androidx.constraintlayout.helper.widget.a(this, 3));
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String name, Intent serviceIntent) {
        h.f(context, "context");
        h.f(name, "name");
        h.f(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase database) {
        h.f(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync != null) {
                        INSTANCE.beginTransactionInternal$room_runtime_release(database);
                        try {
                            int length = tablesToSync.length;
                            int i = 0;
                            int i3 = 0;
                            while (i < length) {
                                int i4 = tablesToSync[i];
                                int i5 = i3 + 1;
                                if (i4 == 1) {
                                    startTrackingTable(database, i3);
                                } else if (i4 == 2) {
                                    stopTrackingTable(database, i3);
                                }
                                i++;
                                i3 = i5;
                            }
                            database.setTransactionSuccessful();
                            database.endTransaction();
                        } catch (Throwable th) {
                            database.endTransaction();
                            throw th;
                        }
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
        } catch (IllegalStateException e6) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e6);
        }
    }

    public <T> LiveData<T> createLiveData(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        h.f(tableNames, "tableNames");
        h.f(computeFunction, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), inTransaction, computeFunction);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\tJ\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "", "", "tables", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "([Ljava/lang/String;)V", "firstTable", "rest", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "LN1/m;", "onInvalidated", "(Ljava/util/Set;)V", "[Ljava/lang/String;", "getTables$room_runtime_release", "()[Ljava/lang/String;", "", "isRemote$room_runtime_release", "()Z", "isRemote", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Observer {
        private final String[] tables;

        public Observer(String firstTable, String... rest) {
            h.f(firstTable, "firstTable");
            h.f(rest, "rest");
            P1.b bVar = new P1.b();
            s.G(bVar, rest);
            bVar.add(firstTable);
            Z.b(bVar);
            this((String[]) bVar.toArray(new String[0]));
        }

        /* JADX INFO: renamed from: getTables$room_runtime_release, reason: from getter */
        public final String[] getTables() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> tables);

        public Observer(String[] tables) {
            h.f(tables, "tables");
            this.tables = tables;
        }
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InvalidationTracker(RoomDatabase database, String... tableNames) {
        h.f(database, "database");
        h.f(tableNames, "tableNames");
        v vVar = v.f3805a;
        this(database, vVar, vVar, (String[]) Arrays.copyOf(tableNames, tableNames.length));
    }
}
