package t0;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.tasks.c f4781a;

    public d() {
        this.f4781a = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e) {
            com.google.android.gms.tasks.c cVar = this.f4781a;
            if (cVar != null) {
                cVar.a(e);
            }
        }
    }

    public d(com.google.android.gms.tasks.c cVar) {
        this.f4781a = cVar;
    }
}
