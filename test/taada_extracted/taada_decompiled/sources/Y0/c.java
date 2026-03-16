package Y0;

import B.g;
import C0.t;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f1479a;

    public c(t tVar) {
        this.f1479a = tVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        U0.c cVar = (U0.c) this.f1479a.b;
        g gVar = cVar.b;
        SharedPreferences sharedPreferences = (SharedPreferences) gVar.b;
        if (sharedPreferences.contains("tenjinGoogleInstallReferrer") || sharedPreferences.contains("tenjinHuaweiInstallReferrer")) {
            cVar.c = b.f(gVar, 1);
            cVar.d = b.f(gVar, 2);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread = new Thread(new U0.b(cVar, countDownLatch, 1));
        thread.start();
        Thread thread2 = new Thread(new U0.b(cVar, countDownLatch, 0));
        thread2.start();
        try {
            thread.join();
            thread2.join();
            countDownLatch.await();
        } catch (Exception e) {
            Log.e("AttributionParams", "Error retrieving referral data from play store, " + e.getMessage());
        }
    }
}
