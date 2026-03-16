package androidx.room.migration;

import N1.m;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "startVersion", "endVersion", "Lkotlin/Function1;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "LN1/m;", "migrate", "Landroidx/room/migration/Migration;", "Migration", "(IILkotlin/jvm/functions/Function1;)Landroidx/room/migration/Migration;", "room-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MigrationKt {
    public static final Migration Migration(int i, int i3, Function1<? super SupportSQLiteDatabase, m> function1) {
        return new MigrationImpl(i, i3, function1);
    }
}
