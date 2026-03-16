package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1666a;
    public final /* synthetic */ QueryInterceptorDatabase b;

    public /* synthetic */ c(QueryInterceptorDatabase queryInterceptorDatabase, int i) {
        this.f1666a = i;
        this.b = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1666a) {
            case 0:
                QueryInterceptorDatabase.endTransaction$lambda$4(this.b);
                break;
            case 1:
                QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.b);
                break;
            case 2:
                QueryInterceptorDatabase.beginTransaction$lambda$0(this.b);
                break;
            case 3:
                QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.b);
                break;
            case 4:
                QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.b);
                break;
            default:
                QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.b);
                break;
        }
    }
}
