package androidx.test.platform.tracing;

import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.platform.tracing.Tracer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Tracing {
    private static final String TAG = "Tracing";
    private static final Tracing singleton = new Tracing();
    private final List<Tracer> tracers = Collections.synchronizedList(new ArrayList());

    public class TracerSpan implements Tracer.Span {
        private final Map<Tracer, Tracer.Span> spans;

        @Override // androidx.test.platform.tracing.Tracer.Span
        public Tracer.Span beginChildSpan(String str) {
            HashMap map;
            Checks.checkNotNull(str);
            synchronized (Tracing.this.tracers) {
                try {
                    map = new HashMap(Tracing.this.tracers.size());
                    for (Tracer tracer : Tracing.this.tracers) {
                        Tracer.Span span = this.spans.get(tracer);
                        if (span != null) {
                            map.put(tracer, Tracing.createUnmanagedChildSpan(span, str));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return Tracing.this.new TracerSpan(map);
        }

        @Override // androidx.test.platform.tracing.Tracer.Span, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<Tracer.Span> it = this.spans.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }

        private TracerSpan(Map<Tracer, Tracer.Span> map) {
            this.spans = map;
        }
    }

    private Tracing() {
        registerTracer(new AndroidXTracer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Tracer.Span createUnmanagedChildSpan(Tracer.Span span, String str) {
        return span.beginChildSpan(str);
    }

    private static Tracer.Span createUnmanagedSpan(Tracer tracer, String str) {
        return tracer.beginSpan(str);
    }

    public static Tracing getInstance() {
        return singleton;
    }

    public Tracer.Span beginSpan(String str) {
        HashMap map;
        Checks.checkNotNull(str);
        synchronized (this.tracers) {
            try {
                map = new HashMap(this.tracers.size());
                for (Tracer tracer : this.tracers) {
                    map.put(tracer, createUnmanagedSpan(tracer, str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new TracerSpan(map);
    }

    public void registerTracer(Tracer tracer) {
        Checks.checkNotNull(tracer, "Tracer cannot be null.");
        if (this.tracers.contains(tracer)) {
            Log.w(TAG, "Tracer already present: ".concat(String.valueOf(tracer.getClass())));
        } else {
            String.valueOf(tracer.getClass());
            this.tracers.add(tracer);
        }
    }

    public void unregisterTracer(Tracer tracer) {
        this.tracers.remove(tracer);
        String.valueOf(tracer == null ? null : tracer.getClass());
    }
}
