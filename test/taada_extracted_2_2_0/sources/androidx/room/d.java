package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1667a;
    public final /* synthetic */ QueryInterceptorDatabase b;
    public final /* synthetic */ String c;

    public /* synthetic */ d(QueryInterceptorDatabase queryInterceptorDatabase, String str, int i) {
        this.f1667a = i;
        this.b = queryInterceptorDatabase;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1667a) {
            case 0:
                QueryInterceptorDatabase.query$lambda$6(this.b, this.c);
                break;
            default:
                QueryInterceptorDatabase.execSQL$lambda$10(this.b, this.c);
                break;
        }
    }
}
