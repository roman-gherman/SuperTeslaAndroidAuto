package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.android.AndroidComponents;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: loaded from: classes2.dex */
public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    boolean ignoreGeneratedIndex;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List<SubscriberInfoIndex> subscriberInfoIndexes;
    boolean throwSubscriberException;
    boolean logSubscriberExceptions = true;
    boolean logNoSubscriberMessages = true;
    boolean sendSubscriberExceptionEvent = true;
    boolean sendNoSubscriberEvent = true;
    boolean eventInheritance = true;
    ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;

    public EventBusBuilder addIndex(SubscriberInfoIndex subscriberInfoIndex) {
        if (this.subscriberInfoIndexes == null) {
            this.subscriberInfoIndexes = new ArrayList();
        }
        this.subscriberInfoIndexes.add(subscriberInfoIndex);
        return this;
    }

    public EventBus build() {
        return new EventBus(this);
    }

    public EventBusBuilder eventInheritance(boolean z6) {
        this.eventInheritance = z6;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    public Logger getLogger() {
        Logger logger = this.logger;
        return logger != null ? logger : Logger.Default.get();
    }

    public MainThreadSupport getMainThreadSupport() {
        MainThreadSupport mainThreadSupport = this.mainThreadSupport;
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        }
        if (AndroidComponents.areAvailable()) {
            return AndroidComponents.get().defaultMainThreadSupport;
        }
        return null;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean z6) {
        this.ignoreGeneratedIndex = z6;
        return this;
    }

    public EventBus installDefaultEventBus() {
        EventBus eventBus;
        synchronized (EventBus.class) {
            try {
                if (EventBus.defaultInstance != null) {
                    throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
                }
                EventBus.defaultInstance = build();
                eventBus = EventBus.defaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eventBus;
    }

    public EventBusBuilder logNoSubscriberMessages(boolean z6) {
        this.logNoSubscriberMessages = z6;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean z6) {
        this.logSubscriberExceptions = z6;
        return this;
    }

    public EventBusBuilder logger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean z6) {
        this.sendNoSubscriberEvent = z6;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean z6) {
        this.sendSubscriberExceptionEvent = z6;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> cls) {
        if (this.skipMethodVerificationForClasses == null) {
            this.skipMethodVerificationForClasses = new ArrayList();
        }
        this.skipMethodVerificationForClasses.add(cls);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean z6) {
        this.strictMethodVerification = z6;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean z6) {
        this.throwSubscriberException = z6;
        return this;
    }
}
