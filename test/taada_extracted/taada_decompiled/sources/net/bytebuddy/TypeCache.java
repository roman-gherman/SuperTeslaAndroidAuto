package net.bytebuddy;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public class TypeCache<T> extends ReferenceQueue<ClassLoader> {

    @AlwaysNull
    private static final Class<?> NOT_FOUND = null;
    protected final ConcurrentMap<StorageKey, ConcurrentMap<T, Object>> cache;
    protected final Sort sort;

    public static class LookupKey {

        @MaybeNull
        private final ClassLoader classLoader;
        private final int hashCode;

        public LookupKey(@MaybeNull ClassLoader classLoader) {
            this.classLoader = classLoader;
            this.hashCode = System.identityHashCode(classLoader);
        }

        @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LookupKey) {
                return this.classLoader == ((LookupKey) obj).classLoader;
            }
            if (obj instanceof StorageKey) {
                StorageKey storageKey = (StorageKey) obj;
                if (this.hashCode == storageKey.hashCode && this.classLoader == storageKey.get()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class SimpleKey {
        private transient /* synthetic */ int hashCode;
        private final Set<String> types;

        public SimpleKey(Class<?> cls, Class<?>... clsArr) {
            this(cls, Arrays.asList(clsArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.types.equals(((SimpleKey) obj).types);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int iHashCode = this.hashCode != 0 ? 0 : this.types.hashCode();
            if (iHashCode == 0) {
                return this.hashCode;
            }
            this.hashCode = iHashCode;
            return iHashCode;
        }

        public SimpleKey(Class<?> cls, Collection<? extends Class<?>> collection) {
            this(CompoundList.of(cls, new ArrayList(collection)));
        }

        public SimpleKey(Collection<? extends Class<?>> collection) {
            this.types = new HashSet();
            Iterator<? extends Class<?>> it = collection.iterator();
            while (it.hasNext()) {
                this.types.add(it.next().getName());
            }
        }
    }

    public enum Sort {
        WEAK { // from class: net.bytebuddy.TypeCache.Sort.1
            @Override // net.bytebuddy.TypeCache.Sort
            public /* bridge */ /* synthetic */ Object wrap(Class cls) {
                return wrap((Class<?>) cls);
            }

            @Override // net.bytebuddy.TypeCache.Sort
            public Reference<Class<?>> wrap(Class<?> cls) {
                return new WeakReference(cls);
            }
        },
        SOFT { // from class: net.bytebuddy.TypeCache.Sort.2
            @Override // net.bytebuddy.TypeCache.Sort
            public /* bridge */ /* synthetic */ Object wrap(Class cls) {
                return wrap((Class<?>) cls);
            }

            @Override // net.bytebuddy.TypeCache.Sort
            public Reference<Class<?>> wrap(Class<?> cls) {
                return new SoftReference(cls);
            }
        },
        STRONG { // from class: net.bytebuddy.TypeCache.Sort.3
            @Override // net.bytebuddy.TypeCache.Sort
            public Class<?> wrap(Class<?> cls) {
                return cls;
            }

            @Override // net.bytebuddy.TypeCache.Sort
            public /* bridge */ /* synthetic */ Object wrap(Class cls) {
                return wrap((Class<?>) cls);
            }
        };

        public abstract Object wrap(Class<?> cls);
    }

    public static class StorageKey extends WeakReference<ClassLoader> {
        private final int hashCode;

        public StorageKey(@MaybeNull ClassLoader classLoader, ReferenceQueue<? super ClassLoader> referenceQueue) {
            super(classLoader, referenceQueue);
            this.hashCode = System.identityHashCode(classLoader);
        }

        @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LookupKey) {
                LookupKey lookupKey = (LookupKey) obj;
                return this.hashCode == lookupKey.hashCode && get() == lookupKey.classLoader;
            }
            if (obj instanceof StorageKey) {
                StorageKey storageKey = (StorageKey) obj;
                if (this.hashCode == storageKey.hashCode && get() == storageKey.get()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class WithInlineExpunction<S> extends TypeCache<S> {
        public WithInlineExpunction() {
            this(Sort.STRONG);
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> find(@MaybeNull ClassLoader classLoader, S s3) {
            try {
                return super.find(classLoader, s3);
            } finally {
                expungeStaleEntries();
            }
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> findOrInsert(ClassLoader classLoader, S s3, Callable<Class<?>> callable) {
            try {
                return super.findOrInsert(classLoader, s3, callable);
            } finally {
                expungeStaleEntries();
            }
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> insert(@MaybeNull ClassLoader classLoader, S s3, Class<?> cls) {
            try {
                return super.insert(classLoader, s3, cls);
            } finally {
                expungeStaleEntries();
            }
        }

        public WithInlineExpunction(Sort sort) {
            super(sort);
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, S s3, Callable<Class<?>> callable, Object obj) {
            try {
                return super.findOrInsert(classLoader, s3, callable, obj);
            } finally {
                expungeStaleEntries();
            }
        }
    }

    public TypeCache() {
        this(Sort.STRONG);
    }

    public void clear() {
        this.cache.clear();
    }

    public void expungeStaleEntries() {
        while (true) {
            Reference<? extends T> referencePoll = poll();
            if (referencePoll == null) {
                return;
            } else {
                this.cache.remove(referencePoll);
            }
        }
    }

    @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"GC_UNRELATED_TYPES"})
    @MaybeNull
    public Class<?> find(@MaybeNull ClassLoader classLoader, T t6) {
        Object obj;
        ConcurrentMap<T, Object> concurrentMap = this.cache.get(new LookupKey(classLoader));
        if (concurrentMap != null && (obj = concurrentMap.get(t6)) != null) {
            return obj instanceof Reference ? (Class) ((Reference) obj).get() : (Class) obj;
        }
        return NOT_FOUND;
    }

    public Class<?> findOrInsert(ClassLoader classLoader, T t6, Callable<Class<?>> callable) {
        Class<?> clsFind = find(classLoader, t6);
        if (clsFind != null) {
            return clsFind;
        }
        try {
            return insert(classLoader, t6, callable.call());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Could not create type", th);
        }
    }

    @SuppressFBWarnings(justification = "Cross-comparison is intended.", value = {"GC_UNRELATED_TYPES"})
    public Class<?> insert(@MaybeNull ClassLoader classLoader, T t6, Class<?> cls) {
        ConcurrentMap<T, Object> concurrentMapPutIfAbsent;
        ConcurrentMap<T, Object> concurrentHashMap = this.cache.get(new LookupKey(classLoader));
        if (concurrentHashMap == null && (concurrentMapPutIfAbsent = this.cache.putIfAbsent(new StorageKey(classLoader, this), (concurrentHashMap = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap = concurrentMapPutIfAbsent;
        }
        Object objWrap = this.sort.wrap(cls);
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(t6, objWrap);
        while (objPutIfAbsent != null) {
            Class<?> cls2 = (Class) (objPutIfAbsent instanceof Reference ? ((Reference) objPutIfAbsent).get() : objPutIfAbsent);
            if (cls2 != null) {
                return cls2;
            }
            if (concurrentHashMap.remove(t6, objPutIfAbsent)) {
                objPutIfAbsent = concurrentHashMap.putIfAbsent(t6, objWrap);
            } else {
                objPutIfAbsent = concurrentHashMap.get(t6);
                if (objPutIfAbsent == null) {
                    objPutIfAbsent = concurrentHashMap.putIfAbsent(t6, objWrap);
                }
            }
        }
        return cls;
    }

    public TypeCache(Sort sort) {
        this.sort = sort;
        this.cache = new ConcurrentHashMap();
    }

    public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, T t6, Callable<Class<?>> callable, Object obj) {
        Class<?> clsFindOrInsert;
        Class<?> clsFind = find(classLoader, t6);
        if (clsFind != null) {
            return clsFind;
        }
        synchronized (obj) {
            clsFindOrInsert = findOrInsert(classLoader, t6, callable);
        }
        return clsFindOrInsert;
    }
}
