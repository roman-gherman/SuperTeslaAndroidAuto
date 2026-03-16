package fr.sd.taada.helpers.event;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class EventHelper {
    private static final String TAG = "TaaDa-Event";
    private static EventBus eventBus;

    public static synchronized EventBus getEventBus() {
        try {
            if (eventBus == null) {
                eventBus = EventBus.getDefault();
            }
        } catch (Throwable th) {
            throw th;
        }
        return eventBus;
    }

    public static void postEvent(Object obj) {
        getEventBus().post(obj);
    }

    public static void postEventSticky(Object obj) {
        getEventBus().postSticky(obj);
    }

    public static void register(Object obj) {
        if (getEventBus().isRegistered(obj)) {
            return;
        }
        getEventBus().register(obj);
    }

    public static void removeAllStickyEvents() {
        getEventBus().removeAllStickyEvents();
    }

    public static <T> void removeStickyEvent(Class<T> cls) {
        Object stickyEvent = getEventBus().getStickyEvent(cls);
        if (stickyEvent != null) {
            getEventBus().removeStickyEvent(stickyEvent);
        }
    }

    public static void unregister(Object obj) {
        if (getEventBus().isRegistered(obj)) {
            getEventBus().unregister(obj);
        }
    }
}
