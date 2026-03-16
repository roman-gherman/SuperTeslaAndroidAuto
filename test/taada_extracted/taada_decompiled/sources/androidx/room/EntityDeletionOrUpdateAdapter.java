package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H$¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0015\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/EntityDeletionOrUpdateAdapter;", "T", "Landroidx/room/SharedSQLiteStatement;", "Landroidx/room/RoomDatabase;", "database", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroidx/room/RoomDatabase;)V", "", "createQuery", "()Ljava/lang/String;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "statement", "entity", "LN1/m;", "bind", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "", "handle", "(Ljava/lang/Object;)I", "", "entities", "handleMultiple", "(Ljava/lang/Iterable;)I", "", "([Ljava/lang/Object;)I", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase database) {
        super(database);
        h.f(database, "database");
    }

    public abstract void bind(SupportSQLiteStatement statement, T entity);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public final int handle(T entity) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, entity);
            return supportSQLiteStatementAcquire.executeUpdateDelete();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> entities) {
        h.f(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            int iExecuteUpdateDelete = 0;
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                iExecuteUpdateDelete += supportSQLiteStatementAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final int handleMultiple(T[] entities) {
        h.f(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            int iExecuteUpdateDelete = 0;
            for (T t6 : entities) {
                bind(supportSQLiteStatementAcquire, t6);
                iExecuteUpdateDelete += supportSQLiteStatementAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }
}
