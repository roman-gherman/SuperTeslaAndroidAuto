package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i3, Bundle bundle) {
            return PendingIntent.getActivities(context, i, intentArr, i3, bundle);
        }

        public static PendingIntent getActivity(Context context, int i, Intent intent, int i3, Bundle bundle) {
            return PendingIntent.getActivity(context, i, intent, i3, bundle);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void send(PendingIntent pendingIntent, Context context, int i, Intent intent, PendingIntent.OnFinished onFinished, Handler handler, String str, Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i, intent, onFinished, handler, str, bundle);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i3) {
            return PendingIntent.getForegroundService(context, i, intent, i3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static class GatedCallback implements Closeable {
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess = false;

        public GatedCallback(PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
            boolean z6 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z6 = true;
                    pendingIntent = pendingIntent;
                    intent = intent;
                    i = i;
                    str = str;
                    bundle = bundle;
                } catch (Throwable th) {
                    if (!z6) {
                        throw th;
                    }
                    Thread.currentThread().interrupt();
                    throw th;
                }
            }
            if (z6) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i, str, bundle);
                this.mCallback = null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntent.OnFinished() { // from class: androidx.core.app.d
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
                    this.f1595a.onSendFinished(pendingIntent, intent, i, str, bundle);
                }
            };
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z6, int i) {
        int i3;
        if (!z6) {
            i3 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i;
            }
            i3 = 33554432;
        }
        return i3 | i;
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i3, Bundle bundle, boolean z6) {
        return Api16Impl.getActivities(context, i, intentArr, addMutabilityFlags(z6, i3), bundle);
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i3, boolean z6) {
        return PendingIntent.getActivity(context, i, intent, addMutabilityFlags(z6, i3));
    }

    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int i3, boolean z6) {
        return PendingIntent.getBroadcast(context, i, intent, addMutabilityFlags(z6, i3));
    }

    public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i3, boolean z6) {
        return Api26Impl.getForegroundService(context, i, intent, addMutabilityFlags(z6, i3));
    }

    public static PendingIntent getService(Context context, int i, Intent intent, int i3, boolean z6) {
        return PendingIntent.getService(context, i, intent, addMutabilityFlags(z6, i3));
    }

    public static void send(PendingIntent pendingIntent, int i, PendingIntent.OnFinished onFinished, Handler handler) {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th) {
            try {
                gatedCallback.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i3, boolean z6) {
        return PendingIntent.getActivities(context, i, intentArr, addMutabilityFlags(z6, i3));
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i3, Bundle bundle, boolean z6) {
        return Api16Impl.getActivity(context, i, intent, addMutabilityFlags(z6, i3), bundle);
    }

    public static void send(PendingIntent pendingIntent, Context context, int i, Intent intent, PendingIntent.OnFinished onFinished, Handler handler) {
        send(pendingIntent, context, i, intent, onFinished, handler, null, null);
    }

    public static void send(PendingIntent pendingIntent, Context context, int i, Intent intent, PendingIntent.OnFinished onFinished, Handler handler, String str, Bundle bundle) {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            Api23Impl.send(pendingIntent, context, i, intent, onFinished, handler, str, bundle);
            gatedCallback.complete();
            gatedCallback.close();
        } finally {
        }
    }
}
