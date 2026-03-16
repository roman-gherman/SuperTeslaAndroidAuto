package net.bytebuddy.utility;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class QueueFactory {
    private static final boolean ACCESS_CONTROLLER;
    private static final QueueFactory INSTANCE;
    private final Dispatcher dispatcher = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));

    @JavaDispatcher.Defaults
    @JavaDispatcher.Proxied("java.util.ArrayDeque")
    public interface Dispatcher {
        @JavaDispatcher.IsConstructor
        @MaybeNull
        @JavaDispatcher.Proxied("arrayDeque")
        <T> Queue<T> arrayDeque();

        @JavaDispatcher.IsConstructor
        @MaybeNull
        @JavaDispatcher.Proxied("arrayDeque")
        <T> Queue<T> arrayDeque(Collection<? extends T> collection);
    }

    static {
        boolean z6 = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = z6;
        } catch (SecurityException unused2) {
            z6 = true;
            ACCESS_CONTROLLER = z6;
        }
        INSTANCE = new QueueFactory();
    }

    private QueueFactory() {
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static <T> Queue<T> make() {
        Queue<T> queueArrayDeque = INSTANCE.dispatcher.arrayDeque();
        return queueArrayDeque == null ? new LinkedList() : queueArrayDeque;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((QueueFactory) obj).dispatcher);
    }

    public int hashCode() {
        return this.dispatcher.hashCode() + (getClass().hashCode() * 31);
    }

    public static <T> Queue<T> make(Collection<? extends T> collection) {
        Queue<T> queueArrayDeque = INSTANCE.dispatcher.arrayDeque(collection);
        return queueArrayDeque == null ? new LinkedList(collection) : queueArrayDeque;
    }
}
