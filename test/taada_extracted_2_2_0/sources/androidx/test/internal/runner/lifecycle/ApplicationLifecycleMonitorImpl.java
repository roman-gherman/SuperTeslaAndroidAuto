package androidx.test.internal.runner.lifecycle;

import android.app.Application;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitor;
import androidx.test.runner.lifecycle.ApplicationStage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationLifecycleMonitorImpl implements ApplicationLifecycleMonitor {
    private static final String TAG = "ApplicationLifecycleMonitorImpl";
    private final List<WeakReference<ApplicationLifecycleCallback>> callbacks = new ArrayList();

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void addLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.checkNotNull(applicationLifecycleCallback);
        synchronized (this.callbacks) {
            try {
                Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
                boolean z6 = true;
                while (it.hasNext()) {
                    ApplicationLifecycleCallback applicationLifecycleCallback2 = it.next().get();
                    if (applicationLifecycleCallback2 == null) {
                        it.remove();
                    } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                        z6 = false;
                    }
                }
                if (z6) {
                    this.callbacks.add(new WeakReference<>(applicationLifecycleCallback));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void removeLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.checkNotNull(applicationLifecycleCallback);
        synchronized (this.callbacks) {
            try {
                Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    ApplicationLifecycleCallback applicationLifecycleCallback2 = it.next().get();
                    if (applicationLifecycleCallback2 == null) {
                        it.remove();
                    } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void signalLifecycleChange(Application application, ApplicationStage applicationStage) {
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else {
                    try {
                        String.valueOf(applicationLifecycleCallback);
                        applicationLifecycleCallback.onApplicationLifecycleChanged(application, applicationStage);
                        String.valueOf(applicationLifecycleCallback);
                    } catch (RuntimeException e) {
                        Log.e(TAG, String.format("Callback threw exception! (callback: %s stage: %s)", applicationLifecycleCallback, applicationStage), e);
                    }
                }
            }
        }
    }
}
