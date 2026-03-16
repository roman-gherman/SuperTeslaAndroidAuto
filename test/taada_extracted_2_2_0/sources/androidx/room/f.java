package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1669a;
    public final /* synthetic */ QueryInterceptorStatement b;

    public /* synthetic */ f(QueryInterceptorStatement queryInterceptorStatement, int i) {
        this.f1669a = i;
        this.b = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1669a) {
            case 0:
                QueryInterceptorStatement.simpleQueryForLong$lambda$3(this.b);
                break;
            case 1:
                QueryInterceptorStatement.executeInsert$lambda$2(this.b);
                break;
            case 2:
                QueryInterceptorStatement.simpleQueryForString$lambda$4(this.b);
                break;
            case 3:
                QueryInterceptorStatement.execute$lambda$0(this.b);
                break;
            default:
                QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.b);
                break;
        }
    }
}
