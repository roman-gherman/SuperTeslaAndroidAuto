package androidx.core.os;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    public static class Api22Impl {
        private Api22Impl() {
        }

        public static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        public static void setAsynchronous(Message message, boolean z6) {
            message.setAsynchronous(z6);
        }
    }

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message message) {
        return Api22Impl.isAsynchronous(message);
    }

    public static void setAsynchronous(Message message, boolean z6) {
        Api22Impl.setAsynchronous(message, z6);
    }
}
