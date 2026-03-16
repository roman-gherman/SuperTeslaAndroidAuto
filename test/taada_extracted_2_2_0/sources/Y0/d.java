package Y0;

import B.g;
import C0.t;
import U0.e;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1480a;
    public final /* synthetic */ t b;

    public d(t tVar, g gVar) {
        this.b = tVar;
        this.f1480a = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f1480a.b = e.a((Context) this.b.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
