package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1668a;
    public final /* synthetic */ QueryInterceptorDatabase b;
    public final /* synthetic */ SupportSQLiteQuery c;
    public final /* synthetic */ QueryInterceptorProgram d;

    public /* synthetic */ e(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram, int i) {
        this.f1668a = i;
        this.b = queryInterceptorDatabase;
        this.c = supportSQLiteQuery;
        this.d = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1668a) {
            case 0:
                QueryInterceptorDatabase.query$lambda$8(this.b, this.c, this.d);
                break;
            default:
                QueryInterceptorDatabase.query$lambda$9(this.b, this.c, this.d);
                break;
        }
    }
}
