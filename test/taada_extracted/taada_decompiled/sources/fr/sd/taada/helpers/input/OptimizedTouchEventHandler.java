package fr.sd.taada.helpers.input;

import android.os.Handler;
import android.os.HandlerThread;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.proto.PointerAction;
import fr.sd.taada.proto.TouchEvent;
import java.util.concurrent.LinkedBlockingQueue;
import p042g2.AbstractC2294b;

/* JADX INFO: loaded from: classes2.dex */
public class OptimizedTouchEventHandler {
    private static final String TAG = "TouchEventHandler";
    private static final LinkedBlockingQueue<TouchEvent.Builder> emergencyQueue = new LinkedBlockingQueue<>(32);
    private static LogManager logManager;
    private static Handler touchEventHandler;
    private static HandlerThread touchEventThread;

    static {
        HandlerThread handlerThread = new HandlerThread("TouchEventProcessor", -8);
        touchEventThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(touchEventThread.getLooper());
        touchEventHandler = handler;
        handler.post(new Runnable() { // from class: fr.sd.taada.helpers.input.OptimizedTouchEventHandler.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    TouchEvent.Builder builder = (TouchEvent.Builder) OptimizedTouchEventHandler.emergencyQueue.poll();
                    if (builder == null) {
                        OptimizedTouchEventHandler.touchEventHandler.postDelayed(this, 5L);
                        return;
                    }
                    OptimizedTouchEventHandler.dispatchTouchEvent(builder);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchTouchEvent(TouchEvent.Builder builder) {
        try {
            AbstractC2294b.m3197b(builder);
        } catch (Exception e) {
            if (!emergencyQueue.offer(builder)) {
                getLogManager().logError(TAG, "Emergency queue full, dropping touch event");
            }
            getLogManager().logError(TAG, "Error dispatching touch event", e);
        }
    }

    private static LogManager getLogManager() {
        if (logManager == null) {
            logManager = LogManager.getInstance(null);
        }
        return logManager;
    }

    public static void queueTouchEvent(final TouchEvent.Builder builder, PointerAction pointerAction) {
        touchEventHandler.post(new Runnable() { // from class: fr.sd.taada.helpers.input.OptimizedTouchEventHandler.2
            @Override // java.lang.Runnable
            public void run() {
                OptimizedTouchEventHandler.dispatchTouchEvent(builder);
            }
        });
    }
}
