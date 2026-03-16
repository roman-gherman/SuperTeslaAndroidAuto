package org.mockito.internal.creation.bytebuddy;

import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.bytebuddy.TypeCache;
import org.mockito.mock.SerializableMode;

/* JADX INFO: loaded from: classes.dex */
class TypeCachingBytecodeGenerator extends ReferenceQueue<ClassLoader> implements BytecodeGenerator {
    private static final Object BOOTSTRAP_LOCK = new Object();
    private final BytecodeGenerator bytecodeGenerator;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final TypeCache<MockitoMockKey> typeCache;

    public static class MockitoMockKey extends TypeCache.SimpleKey {
        private final SerializableMode serializableMode;
        private final boolean stripAnnotations;

        @Override // net.bytebuddy.TypeCache.SimpleKey
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
                return false;
            }
            MockitoMockKey mockitoMockKey = (MockitoMockKey) obj;
            return this.stripAnnotations == mockitoMockKey.stripAnnotations && this.serializableMode.equals(mockitoMockKey.serializableMode);
        }

        @Override // net.bytebuddy.TypeCache.SimpleKey
        public int hashCode() {
            return this.serializableMode.hashCode() + (((super.hashCode() * 31) + (this.stripAnnotations ? 1 : 0)) * 31);
        }

        private MockitoMockKey(Class<?> cls, Set<Class<?>> set, SerializableMode serializableMode, boolean z6) {
            super(cls, set);
            this.serializableMode = serializableMode;
            this.stripAnnotations = z6;
        }
    }

    public TypeCachingBytecodeGenerator(BytecodeGenerator bytecodeGenerator, boolean z6) {
        this.bytecodeGenerator = bytecodeGenerator;
        this.typeCache = new TypeCache.WithInlineExpunction(z6 ? TypeCache.Sort.WEAK : TypeCache.Sort.SOFT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Class lambda$mockClass$0(MockFeatures mockFeatures) {
        return this.bytecodeGenerator.mockClass(mockFeatures);
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public void clearAllCaches() {
        this.lock.writeLock().lock();
        try {
            this.typeCache.clear();
            this.bytecodeGenerator.clearAllCaches();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public <T> Class<T> mockClass(final MockFeatures<T> mockFeatures) {
        this.lock.readLock().lock();
        try {
            try {
                Class<T> cls = (Class<T>) this.typeCache.findOrInsert(mockFeatures.mockedType.getClassLoader(), new MockitoMockKey(mockFeatures.mockedType, mockFeatures.interfaces, mockFeatures.serializableMode, mockFeatures.stripAnnotations), new Callable() { // from class: org.mockito.internal.creation.bytebuddy.l
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f4447a.lambda$mockClass$0(mockFeatures);
                    }
                }, BOOTSTRAP_LOCK);
                this.lock.readLock().unlock();
                return cls;
            } catch (IllegalArgumentException e) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw e;
            }
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public void mockClassConstruction(Class<?> cls) {
        this.bytecodeGenerator.mockClassConstruction(cls);
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public void mockClassStatic(Class<?> cls) {
        this.bytecodeGenerator.mockClassStatic(cls);
    }
}
