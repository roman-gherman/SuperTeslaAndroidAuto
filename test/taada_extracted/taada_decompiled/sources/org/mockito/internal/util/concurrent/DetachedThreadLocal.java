package org.mockito.internal.util.concurrent;

import org.mockito.internal.util.concurrent.WeakConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class DetachedThreadLocal<T> implements Runnable {
    final WeakConcurrentMap<Thread, T> map;

    /* JADX INFO: renamed from: org.mockito.internal.util.concurrent.DetachedThreadLocal$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$mockito$internal$util$concurrent$DetachedThreadLocal$Cleaner;

        static {
            int[] iArr = new int[Cleaner.values().length];
            $SwitchMap$org$mockito$internal$util$concurrent$DetachedThreadLocal$Cleaner = iArr;
            try {
                iArr[Cleaner.THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mockito$internal$util$concurrent$DetachedThreadLocal$Cleaner[Cleaner.MANUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mockito$internal$util$concurrent$DetachedThreadLocal$Cleaner[Cleaner.INLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Cleaner {
        THREAD,
        INLINE,
        MANUAL
    }

    public DetachedThreadLocal(Cleaner cleaner) {
        int i = AnonymousClass3.$SwitchMap$org$mockito$internal$util$concurrent$DetachedThreadLocal$Cleaner[cleaner.ordinal()];
        if (i == 1 || i == 2) {
            this.map = new WeakConcurrentMap<Thread, T>(cleaner == Cleaner.THREAD) { // from class: org.mockito.internal.util.concurrent.DetachedThreadLocal.1
                @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
                public T defaultValue(Thread thread) {
                    return (T) DetachedThreadLocal.this.initialValue(thread);
                }
            };
        } else {
            if (i != 3) {
                throw new AssertionError();
            }
            this.map = new WeakConcurrentMap.WithInlinedExpunction<Thread, T>() { // from class: org.mockito.internal.util.concurrent.DetachedThreadLocal.2
                @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
                public T defaultValue(Thread thread) {
                    return (T) DetachedThreadLocal.this.initialValue(thread);
                }
            };
        }
    }

    public void clear() {
        this.map.remove(Thread.currentThread());
    }

    public void clearAll() {
        this.map.clear();
    }

    public void define(Thread thread, T t6) {
        this.map.put(thread, t6);
    }

    public T fetchFrom(Thread thread) {
        T t6 = this.map.get(thread);
        if (t6 != null) {
            set(inheritValue(t6));
        }
        return t6;
    }

    public T get() {
        return this.map.get(Thread.currentThread());
    }

    public WeakConcurrentMap<Thread, T> getBackingMap() {
        return this.map;
    }

    public T inheritValue(T t6) {
        return t6;
    }

    public T initialValue(Thread thread) {
        return null;
    }

    public T pushTo(Thread thread) {
        T t6 = get();
        if (t6 != null) {
            this.map.put(thread, inheritValue(t6));
        }
        return t6;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.map.run();
    }

    public void set(T t6) {
        this.map.put(Thread.currentThread(), t6);
    }

    public T get(Thread thread) {
        return this.map.get(thread);
    }
}
