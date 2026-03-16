package X0;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.gson.m;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends EntityInsertionAdapter {
    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
        a aVar = (a) obj;
        supportSQLiteStatement.bindLong(1, aVar.f1405a);
        Map map = aVar.b;
        String strH = map == null ? null : new m().h(map);
        if (strH == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, strH);
        }
        Date date = aVar.c;
        Long lValueOf = date != null ? Long.valueOf(date.getTime()) : null;
        if (lValueOf == null) {
            supportSQLiteStatement.bindNull(3);
        } else {
            supportSQLiteStatement.bindLong(3, lValueOf.longValue());
        }
        String str = aVar.d;
        if (str == null) {
            supportSQLiteStatement.bindNull(4);
        } else {
            supportSQLiteStatement.bindString(4, str);
        }
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR ABORT INTO `QueueEvent` (`id`,`params`,`date`,`endpoint`) VALUES (nullif(?, 0),?,?,?)";
    }
}
