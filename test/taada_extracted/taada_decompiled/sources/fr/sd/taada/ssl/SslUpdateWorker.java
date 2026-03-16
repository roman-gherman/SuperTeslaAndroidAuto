package fr.sd.taada.ssl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* JADX INFO: loaded from: classes2.dex */
public class SslUpdateWorker extends Worker {
    public SslUpdateWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    @NonNull
    public ListenableWorker.Result doWork() {
        try {
            SslCertificateManager.checkAndDownloadCertificate(getApplicationContext());
            return ListenableWorker.Result.success();
        } catch (Exception unused) {
            return ListenableWorker.Result.retry();
        }
    }
}
