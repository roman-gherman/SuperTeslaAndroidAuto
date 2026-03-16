package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
final class BackgroundPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue = new PendingPostQueue();

    public BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription, Object obj) {
        PendingPost pendingPostObtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            try {
                this.queue.enqueue(pendingPostObtainPendingPost);
                if (!this.executorRunning) {
                    this.executorRunning = true;
                    this.eventBus.getExecutorService().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost pendingPostPoll;
        while (true) {
            try {
                try {
                    pendingPostPoll = this.queue.poll(1000);
                } catch (InterruptedException e) {
                    this.eventBus.getLogger().log(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.executorRunning = false;
                    return;
                }
            } catch (Throwable th) {
                this.executorRunning = false;
                throw th;
            }
            if (pendingPostPoll == null) {
                synchronized (this) {
                    pendingPostPoll = this.queue.poll();
                    if (pendingPostPoll == null) {
                        this.executorRunning = false;
                        this.executorRunning = false;
                        return;
                    }
                    this.executorRunning = false;
                    throw th;
                }
            }
            this.eventBus.invokeSubscriber(pendingPostPoll);
        }
    }
}
