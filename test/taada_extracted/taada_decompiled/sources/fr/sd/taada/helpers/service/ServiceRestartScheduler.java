package fr.sd.taada.helpers.service;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.a;
import fr.sd.taada.helpers.LogManager;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceRestartScheduler {
    private static final long SERVICE_RESTART_DELAY_MS = 2000;
    private static final String TAG = "ServiceRestartScheduler";
    private final RestartCallback callback;
    private String currentReason;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final LogManager logManager;
    private Runnable restartRunnable;

    public interface RestartCallback {
        boolean areAllPermissionsGranted();

        boolean isServiceRunning();

        void onServiceRestartRequired();
    }

    public ServiceRestartScheduler(@NonNull LogManager logManager, @NonNull RestartCallback restartCallback) {
        this.logManager = logManager;
        this.callback = restartCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleRestart$0() {
        this.logManager.logDebug(TAG, "Executing scheduled restart for: " + this.currentReason);
        if (!this.callback.areAllPermissionsGranted()) {
            this.logManager.logWarning(TAG, "Cannot restart service: missing permissions");
        } else {
            this.callback.onServiceRestartRequired();
            this.logManager.logDebug(TAG, "Service restart requested");
        }
    }

    public void cancelRestart() {
        Runnable runnable = this.restartRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.restartRunnable = null;
            this.logManager.logDebug(TAG, "Cancelled scheduled restart");
        }
    }

    public void scheduleRestart(String str, long j6) {
        cancelRestart();
        if (!this.callback.isServiceRunning()) {
            this.logManager.logDebug(TAG, "Service not running, no restart needed for: " + str);
            return;
        }
        this.currentReason = str;
        this.logManager.logDebug(TAG, "Scheduling service restart in " + j6 + "ms for: " + str);
        a aVar = new a(this, 10);
        this.restartRunnable = aVar;
        this.handler.postDelayed(aVar, j6);
    }
}
