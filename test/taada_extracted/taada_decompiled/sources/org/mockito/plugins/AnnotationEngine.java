package org.mockito.plugins;

/* JADX INFO: loaded from: classes.dex */
public interface AnnotationEngine {

    public static class NoAction implements AutoCloseable {
        @Override // java.lang.AutoCloseable
        public void close() {
        }
    }

    AutoCloseable process(Class<?> cls, Object obj);
}
