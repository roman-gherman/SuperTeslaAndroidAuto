package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    public interface Pool<T> {
        T acquire();

        boolean release(T t6);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i];
        }

        private boolean isInPool(T t6) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == t6) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i = this.mPoolSize;
            if (i <= 0) {
                return null;
            }
            int i3 = i - 1;
            Object[] objArr = this.mPool;
            T t6 = (T) objArr[i3];
            objArr[i3] = null;
            this.mPoolSize = i - 1;
            return t6;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t6) {
            if (isInPool(t6)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t6;
            this.mPoolSize = i + 1;
            return true;
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i) {
            super(i);
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t6;
            synchronized (this.mLock) {
                t6 = (T) super.acquire();
            }
            return t6;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T t6) {
            boolean zRelease;
            synchronized (this.mLock) {
                zRelease = super.release(t6);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
