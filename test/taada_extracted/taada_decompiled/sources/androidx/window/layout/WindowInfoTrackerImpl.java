package androidx.window.layout;

import N1.m;
import U1.g;
import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import p3.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "windowMetricsCalculator", "Landroidx/window/layout/WindowMetricsCalculator;", "windowBackend", "Landroidx/window/layout/WindowBackend;", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/window/layout/WindowLayoutInfo;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", i = {0, 0, 1, 1}, l = {54, 55}, m = "invokeSuspend", n = {"$this$flow", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER, "$this$flow", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1 extends g implements Function2<FlowCollector<? super WindowLayoutInfo>, Continuation<? super m>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m76invokeSuspend$lambda0(Channel channel, WindowLayoutInfo info) {
            h.e(info, "info");
            channel.mo106trySendJP2dKIU(info);
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = WindowInfoTrackerImpl.this.new AnonymousClass1(this.$activity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
        
            if (r5.emit(r11, r10) == r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:7:0x0018, B:18:0x0064, B:22:0x0077, B:24:0x007f, B:14:0x0035, B:17:0x005f), top: B:31:0x0006 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0091 -> B:8:0x001b). Please report as a decompilation issue!!! */
        @Override // U1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                T1.a r0 = T1.a.f1304a
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L39
                if (r1 == r3) goto L29
                if (r1 != r2) goto L21
                java.lang.Object r1 = r10.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r10.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r10.L$0
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.reflect.l.e0(r11)     // Catch: java.lang.Throwable -> L1e
            L1b:
                r11 = r5
                r5 = r1
                goto L64
            L1e:
                r11 = move-exception
                goto La0
            L21:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L29:
                java.lang.Object r1 = r10.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r10.L$1
                androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
                java.lang.Object r5 = r10.L$0
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.reflect.l.e0(r11)     // Catch: java.lang.Throwable -> L1e
                goto L77
            L39:
                kotlin.reflect.l.e0(r11)
                java.lang.Object r11 = r10.L$0
                kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                o3.a r1 = o3.EnumC0743a.b
                r4 = 4
                r5 = 10
                o3.n r1 = io.ktor.utils.io.jvm.javaio.q.a(r5, r1, r4)
                androidx.window.layout.a r4 = new androidx.window.layout.a
                r4.<init>()
                androidx.window.layout.WindowInfoTrackerImpl r5 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
                android.app.Activity r6 = r10.$activity
                androidx.arch.core.executor.a r7 = new androidx.arch.core.executor.a
                r8 = 2
                r7.<init>(r8)
                r5.registerLayoutChangeCallback(r6, r7, r4)
                o3.b r5 = new o3.b     // Catch: java.lang.Throwable -> L1e
                r5.<init>(r1)     // Catch: java.lang.Throwable -> L1e
            L64:
                r10.L$0 = r11     // Catch: java.lang.Throwable -> L1e
                r10.L$1 = r4     // Catch: java.lang.Throwable -> L1e
                r10.L$2 = r5     // Catch: java.lang.Throwable -> L1e
                r10.label = r3     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r1 = r5.hasNext(r10)     // Catch: java.lang.Throwable -> L1e
                if (r1 != r0) goto L73
                goto L93
            L73:
                r9 = r5
                r5 = r11
                r11 = r1
                r1 = r9
            L77:
                java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L1e
                boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L1e
                if (r11 == 0) goto L94
                java.lang.Object r11 = r1.next()     // Catch: java.lang.Throwable -> L1e
                androidx.window.layout.WindowLayoutInfo r11 = (androidx.window.layout.WindowLayoutInfo) r11     // Catch: java.lang.Throwable -> L1e
                r10.L$0 = r5     // Catch: java.lang.Throwable -> L1e
                r10.L$1 = r4     // Catch: java.lang.Throwable -> L1e
                r10.L$2 = r1     // Catch: java.lang.Throwable -> L1e
                r10.label = r2     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r11 = r5.emit(r11, r10)     // Catch: java.lang.Throwable -> L1e
                if (r11 != r0) goto L1b
            L93:
                return r0
            L94:
                androidx.window.layout.WindowInfoTrackerImpl r11 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r11 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r11)
                r11.unregisterLayoutChangeCallback(r4)
                N1.m r11 = N1.m.f1129a
                return r11
            La0:
                androidx.window.layout.WindowInfoTrackerImpl r0 = androidx.window.layout.WindowInfoTrackerImpl.this
                androidx.window.layout.WindowBackend r0 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r0)
                r0.unregisterLayoutChangeCallback(r4)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(FlowCollector<? super WindowLayoutInfo> flowCollector, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        h.f(windowMetricsCalculator, "windowMetricsCalculator");
        h.f(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        h.f(activity, "activity");
        return new r(new AnonymousClass1(activity, null));
    }
}
