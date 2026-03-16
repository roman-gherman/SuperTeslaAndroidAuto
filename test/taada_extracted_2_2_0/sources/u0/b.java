package U0;

import B.g;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1310a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ c c;

    public /* synthetic */ b(c cVar, CountDownLatch countDownLatch, int i) {
        this.f1310a = i;
        this.c = cVar;
        this.b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1310a) {
            case 0:
                W0.a aVar = new W0.a(this.c.f1311a, 0);
                aVar.f1387g = new g(this, 15);
                if (!aVar.g()) {
                    this.b.countDown();
                }
                break;
            default:
                W0.a aVar2 = new W0.a(this.c.f1311a, 1);
                aVar2.f1387g = new g(this, 16);
                if (!aVar2.g()) {
                    this.b.countDown();
                }
                break;
        }
    }
}
