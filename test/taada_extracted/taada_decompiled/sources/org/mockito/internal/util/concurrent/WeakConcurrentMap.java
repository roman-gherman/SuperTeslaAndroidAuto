package org.mockito.internal.util.concurrent;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class WeakConcurrentMap<K, V> extends ReferenceQueue<K> implements Runnable, Iterable<Map.Entry<K, V>> {
    private static final AtomicLong ID = new AtomicLong();
    public final ConcurrentMap<WeakKey<K>, V> target = new ConcurrentHashMap();
    private final Thread thread;

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private final Iterator<Map.Entry<WeakKey<K>, V>> iterator;
        private Map.Entry<WeakKey<K>, V> nextEntry;
        private K nextKey;

        private void findNext() {
            while (this.iterator.hasNext()) {
                Map.Entry<WeakKey<K>, V> next = this.iterator.next();
                this.nextEntry = next;
                K k6 = next.getKey().get();
                this.nextKey = k6;
                if (k6 != null) {
                    return;
                }
            }
            this.nextEntry = null;
            this.nextKey = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextKey != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private EntryIterator(Iterator<Map.Entry<WeakKey<K>, V>> it) {
            this.iterator = it;
            findNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            K k6 = this.nextKey;
            if (k6 == null) {
                throw new NoSuchElementException();
            }
            try {
                return new SimpleEntry(k6, this.nextEntry);
            } finally {
                findNext();
            }
        }
    }

    public static class LatentKey<T> {
        private final int hashCode;
        final T key;

        public LatentKey(T t6) {
            this.key = t6;
            this.hashCode = System.identityHashCode(t6);
        }

        public boolean equals(Object obj) {
            return obj instanceof LatentKey ? ((LatentKey) obj).key == this.key : ((WeakKey) obj).get() == this.key;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public class SimpleEntry implements Map.Entry<K, V> {
        final Map.Entry<WeakKey<K>, V> entry;
        private final K key;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v6) {
            v6.getClass();
            return this.entry.setValue(v6);
        }

        private SimpleEntry(K k6, Map.Entry<WeakKey<K>, V> entry) {
            this.key = k6;
            this.entry = entry;
        }
    }

    public static class WeakKey<T> extends WeakReference<T> {
        private final int hashCode;

        public WeakKey(T t6, ReferenceQueue<? super T> referenceQueue) {
            super(t6, referenceQueue);
            this.hashCode = System.identityHashCode(t6);
        }

        public boolean equals(Object obj) {
            return obj instanceof LatentKey ? ((LatentKey) obj).key == get() : ((WeakKey) obj).get() == get();
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class WithInlinedExpunction<K, V> extends WeakConcurrentMap<K, V> {
        public WithInlinedExpunction() {
            super(false);
        }

        @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
        public int approximateSize() {
            expungeStaleEntries();
            return super.approximateSize();
        }

        @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
        public boolean containsKey(K k6) {
            expungeStaleEntries();
            return super.containsKey(k6);
        }

        @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
        public V get(K k6) {
            expungeStaleEntries();
            return (V) super.get(k6);
        }

        @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            expungeStaleEntries();
            return super.iterator();
        }

        @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
        public V put(K k6, V v6) {
            expungeStaleEntries();
            return (V) super.put(k6, v6);
        }

        @Override // org.mockito.internal.util.concurrent.WeakConcurrentMap
        public V remove(K k6) {
            expungeStaleEntries();
            return (V) super.remove(k6);
        }
    }

    public WeakConcurrentMap(boolean z6) {
        if (!z6) {
            this.thread = null;
            return;
        }
        Thread thread = new Thread(this);
        this.thread = thread;
        thread.setName("weak-ref-cleaner-" + ID.getAndIncrement());
        thread.setPriority(1);
        thread.setDaemon(true);
        thread.start();
    }

    public int approximateSize() {
        return this.target.size();
    }

    public void clear() {
        this.target.clear();
    }

    public boolean containsKey(K k6) {
        k6.getClass();
        return this.target.containsKey(new LatentKey(k6));
    }

    public V defaultValue(K k6) {
        return null;
    }

    public void expungeStaleEntries() {
        while (true) {
            Reference<? extends K> referencePoll = poll();
            if (referencePoll == null) {
                return;
            } else {
                this.target.remove(referencePoll);
            }
        }
    }

    public V get(K k6) {
        V vPutIfAbsent;
        k6.getClass();
        V vDefaultValue = this.target.get(new LatentKey(k6));
        return (vDefaultValue != null || (vDefaultValue = defaultValue(k6)) == null || (vPutIfAbsent = this.target.putIfAbsent(new WeakKey<>(k6, this), vDefaultValue)) == null) ? vDefaultValue : vPutIfAbsent;
    }

    public Thread getCleanerThread() {
        return this.thread;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new EntryIterator(this.target.entrySet().iterator());
    }

    public V put(K k6, V v6) {
        if (k6 == null || v6 == null) {
            throw null;
        }
        return this.target.put(new WeakKey<>(k6, this), v6);
    }

    public V remove(K k6) {
        k6.getClass();
        return this.target.remove(new LatentKey(k6));
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                this.target.remove(remove());
            } catch (InterruptedException unused) {
                clear();
                return;
            }
        }
    }
}
