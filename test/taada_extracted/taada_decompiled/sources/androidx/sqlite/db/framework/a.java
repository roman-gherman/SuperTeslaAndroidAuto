package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1671a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1671a = i;
        this.b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        switch (this.f1671a) {
            case 0:
                return FrameworkSQLiteDatabase.query$lambda$1((SupportSQLiteQuery) this.b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            default:
                return FrameworkSQLiteDatabase.query$lambda$0((Function4) this.b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
