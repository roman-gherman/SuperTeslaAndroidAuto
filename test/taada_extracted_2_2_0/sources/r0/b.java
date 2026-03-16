package R0;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1243a;
    public final /* synthetic */ h b;

    public /* synthetic */ b(h hVar, int i) {
        this.f1243a = i;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1243a) {
            case 0:
                synchronized (this.b.c) {
                    this.b.f1263h.f();
                    break;
                }
                return;
            case 1:
                boolean z6 = this.b.i;
                throw null;
            default:
                HashMap map = this.b.f1267m;
                throw null;
        }
    }

    public b(h hVar, boolean z6) {
        this.f1243a = 1;
        this.b = hVar;
    }
}
