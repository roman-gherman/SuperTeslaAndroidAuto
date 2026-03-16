package org.mockito.internal.util.concurrent;

import java.util.Iterator;
import java.util.Map;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class WeakConcurrentSet<V> implements Runnable, Iterable<V> {
    final WeakConcurrentMap<V, Boolean> target;

    /* JADX INFO: renamed from: org.mockito.internal.util.concurrent.WeakConcurrentSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mockito$internal$util$concurrent$WeakConcurrentSet$Cleaner;

        static {
            int[] iArr = new int[Cleaner.values().length];
            $SwitchMap$org$mockito$internal$util$concurrent$WeakConcurrentSet$Cleaner = iArr;
            try {
                iArr[Cleaner.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mockito$internal$util$concurrent$WeakConcurrentSet$Cleaner[Cleaner.THREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mockito$internal$util$concurrent$WeakConcurrentSet$Cleaner[Cleaner.MANUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Cleaner {
        THREAD,
        INLINE,
        MANUAL
    }

    public static class ReducingIterator<V> implements Iterator<V> {
        private final Iterator<Map.Entry<V, Boolean>> iterator;

        public /* synthetic */ ReducingIterator(Iterator it, AnonymousClass1 anonymousClass1) {
            this(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.iterator.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        private ReducingIterator(Iterator<Map.Entry<V, Boolean>> it) {
            this.iterator = it;
        }
    }

    public WeakConcurrentSet(Cleaner cleaner) {
        int i = AnonymousClass1.$SwitchMap$org$mockito$internal$util$concurrent$WeakConcurrentSet$Cleaner[cleaner.ordinal()];
        if (i == 1) {
            this.target = new WeakConcurrentMap.WithInlinedExpunction();
        } else {
            if (i != 2 && i != 3) {
                throw new AssertionError();
            }
            this.target = new WeakConcurrentMap<>(cleaner == Cleaner.THREAD);
        }
    }

    public boolean add(V v6) {
        return this.target.put(v6, Boolean.TRUE) == null;
    }

    public int approximateSize() {
        return this.target.approximateSize();
    }

    public void clear() {
        this.target.clear();
    }

    public boolean contains(V v6) {
        return this.target.containsKey(v6);
    }

    public void expungeStaleEntries() {
        this.target.expungeStaleEntries();
    }

    public Thread getCleanerThread() {
        return this.target.getCleanerThread();
    }

    @Override // java.lang.Iterable
    public Iterator<V> iterator() {
        return new ReducingIterator(this.target.iterator(), null);
    }

    public boolean remove(V v6) {
        return this.target.remove(v6) != null;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.target.run();
    }
}
