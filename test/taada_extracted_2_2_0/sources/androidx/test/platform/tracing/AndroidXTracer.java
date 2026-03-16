package androidx.test.platform.tracing;

import android.util.Log;
import androidx.test.platform.tracing.Tracer;
import androidx.tracing.Trace;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
class AndroidXTracer implements Tracer {
    private static final int MAX_SECTION_NAME_LEN = 127;
    private static final String TAG = "AndroidXTracer";

    public static class AndroidXTracerSpan implements Tracer.Span {
        private final ArrayDeque<AndroidXTracerSpan> nestedSpans;

        @Override // androidx.test.platform.tracing.Tracer.Span
        public Tracer.Span beginChildSpan(String str) {
            Trace.beginSection(AndroidXTracer.sanitizeSpanName(str));
            AndroidXTracerSpan androidXTracerSpan = new AndroidXTracerSpan();
            this.nestedSpans.add(androidXTracerSpan);
            return androidXTracerSpan;
        }

        @Override // androidx.test.platform.tracing.Tracer.Span, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            while (true) {
                AndroidXTracerSpan androidXTracerSpanPollLast = this.nestedSpans.pollLast();
                if (androidXTracerSpanPollLast == null) {
                    Trace.endSection();
                    return;
                }
                androidXTracerSpanPollLast.close();
            }
        }

        private AndroidXTracerSpan() {
            this.nestedSpans = new ArrayDeque<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sanitizeSpanName(String str) {
        if (str.length() <= 127) {
            return str;
        }
        Log.w(TAG, "Span name exceeds limits: ".concat(str));
        return str.substring(0, 127);
    }

    @Override // androidx.test.platform.tracing.Tracer
    public Tracer.Span beginSpan(String str) {
        Trace.beginSection(sanitizeSpanName(str));
        return new AndroidXTracerSpan();
    }
}
