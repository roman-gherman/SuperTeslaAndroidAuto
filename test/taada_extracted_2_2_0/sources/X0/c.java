package X0;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends EntityDeletionOrUpdateAdapter {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
        supportSQLiteStatement.bindLong(1, ((a) obj).f1405a);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `QueueEvent` WHERE `id` = ?";
    }
}
