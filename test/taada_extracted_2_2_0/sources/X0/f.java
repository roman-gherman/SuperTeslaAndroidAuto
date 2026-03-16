package X0;

import C0.t;
import com.tenjin.android.store.QueueEventDao;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1408a;
    public final /* synthetic */ t b;
    public final /* synthetic */ a c;

    public /* synthetic */ f(t tVar, a aVar, int i) {
        this.f1408a = i;
        this.b = tVar;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1408a) {
            case 0:
                ((QueueEventDao) this.b.b).delete(this.c);
                break;
            default:
                ((QueueEventDao) this.b.b).insert(this.c);
                break;
        }
    }
}
