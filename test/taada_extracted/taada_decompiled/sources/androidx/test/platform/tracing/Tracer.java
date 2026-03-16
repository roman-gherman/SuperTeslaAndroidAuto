package androidx.test.platform.tracing;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface Tracer {

    public interface Span extends Closeable {
        Span beginChildSpan(String str);

        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    Span beginSpan(String str);
}
