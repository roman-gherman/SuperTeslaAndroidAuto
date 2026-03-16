package androidx.test.platform.io;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.util.Checks;
import androidx.test.platform.io.PlatformTestStorageRegistry;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformTestStorageRegistry {
    private static PlatformTestStorage testStorageInstance = (PlatformTestStorage) ServiceLoaderWrapper.loadSingleService(PlatformTestStorage.class, new ServiceLoaderWrapper.Factory() { // from class: androidx.test.platform.io.PlatformTestStorageRegistry$$ExternalSyntheticLambda0
        @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
        public final Object create() {
            return new PlatformTestStorageRegistry.NoOpPlatformTestStorage();
        }
    });

    public static class NoOpPlatformTestStorage implements PlatformTestStorage {

        public static class NullInputStream extends InputStream {
            @Override // java.io.InputStream
            public int read() {
                return -1;
            }
        }

        public static class NullOutputStream extends OutputStream {
            @Override // java.io.OutputStream
            public void write(int i) {
            }
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public void addOutputProperties(Map<String, Serializable> map) {
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public String getInputArg(String str) {
            return null;
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public Map<String, String> getInputArgs() {
            return new HashMap();
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public Map<String, Serializable> getOutputProperties() {
            return new HashMap();
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public InputStream openInputFile(String str) {
            return new NullInputStream();
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public InputStream openInternalInputFile(String str) {
            return new NullInputStream();
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public OutputStream openInternalOutputFile(String str) {
            return new NullOutputStream();
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public OutputStream openOutputFile(String str) {
            return new NullOutputStream();
        }

        @Override // androidx.test.platform.io.PlatformTestStorage
        public OutputStream openOutputFile(String str, boolean z6) {
            return new NullOutputStream();
        }
    }

    private PlatformTestStorageRegistry() {
    }

    public static synchronized PlatformTestStorage getInstance() {
        return testStorageInstance;
    }

    public static synchronized void registerInstance(PlatformTestStorage platformTestStorage) {
        testStorageInstance = (PlatformTestStorage) Checks.checkNotNull(platformTestStorage);
    }
}
