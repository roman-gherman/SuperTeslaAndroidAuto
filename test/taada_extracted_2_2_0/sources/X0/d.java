package X0;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SharedSQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1406a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(RoomDatabase roomDatabase, int i) {
        super(roomDatabase);
        this.f1406a = i;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f1406a) {
            case 0:
                return "DELETE FROM QueueEvent";
            default:
                return "DELETE FROM QueueEvent WHERE date < ?";
        }
    }
}
