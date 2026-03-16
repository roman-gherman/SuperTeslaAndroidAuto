package fr.sd.taada.analytics.telemetry;

import U1.c;
import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import fr.sd.taada.core.PreferencesHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0082@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0002¨\u0006\u0013"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetrySyncWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncBatch", "", "events", "", "Lfr/sd/taada/analytics/telemetry/TelemetryEvent;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTelemetryEnabled", "Companion", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTelemetrySyncWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetrySyncWorker.kt\nfr/sd/taada/analytics/telemetry/TelemetrySyncWorker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1557#2:195\n1628#2,3:196\n1557#2:199\n1628#2,3:200\n*S KotlinDebug\n*F\n+ 1 TelemetrySyncWorker.kt\nfr/sd/taada/analytics/telemetry/TelemetrySyncWorker\n*L\n124#1:195\n124#1:196,3\n150#1:199\n150#1:200,3\n*E\n"})
public final class TelemetrySyncWorker extends CoroutineWorker {
    private static final int BATCH_SIZE = 50;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENDPOINT_BATCH = "/api/v1/telemetry/batch";

    @NotNull
    private static final String IMMEDIATE_SYNC_WORK_NAME = "telemetry_sync_immediate";

    @NotNull
    private static final String TAG = "Telemetry/SyncWorker";

    @NotNull
    private static final String WORK_NAME = "telemetry_sync";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetrySyncWorker$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "LN1/m;", "schedule", "(Landroid/content/Context;)V", "syncNow", "cancel", "", "TAG", "Ljava/lang/String;", "WORK_NAME", "ENDPOINT_BATCH", "", "BATCH_SIZE", "I", "IMMEDIATE_SYNC_WORK_NAME", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTelemetrySyncWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetrySyncWorker.kt\nfr/sd/taada/analytics/telemetry/TelemetrySyncWorker$Companion\n+ 2 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequestKt\n+ 3 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequestKt\n*L\n1#1,194:1\n272#2:195\n100#3:196\n*S KotlinDebug\n*F\n+ 1 TelemetrySyncWorker.kt\nfr/sd/taada/analytics/telemetry/TelemetrySyncWorker$Companion\n*L\n37#1:195\n67#1:196\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        public final void cancel(@NotNull Context context) {
            h.f(context, "context");
            WorkManager.getInstance(context).cancelUniqueWork(TelemetrySyncWorker.WORK_NAME);
        }

        public final void schedule(@NotNull Context context) {
            h.f(context, "context");
            Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            TimeUnit timeUnit = TimeUnit.MINUTES;
            WorkManager.getInstance(context).enqueueUniquePeriodicWork(TelemetrySyncWorker.WORK_NAME, ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) TelemetrySyncWorker.class, 15L, timeUnit).setConstraints(constraintsBuild).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 1L, timeUnit).build());
        }

        public final void syncNow(@NotNull Context context) {
            h.f(context, "context");
            WorkManager.getInstance(context).enqueueUniqueWork(TelemetrySyncWorker.IMMEDIATE_SYNC_WORK_NAME, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(TelemetrySyncWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.TelemetrySyncWorker$doWork$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.TelemetrySyncWorker", f = "TelemetrySyncWorker.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4}, l = {107, 119, 122, 124, 134}, m = "doWork", n = {"this", "telemetryManager", "this", "telemetryManager", "syncedTotal", "this", "telemetryManager", "events", "syncedTotal", "this", "telemetryManager", "events", "syncedTotal", "syncedTotal"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "I$0"})
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // U1.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TelemetrySyncWorker.this.doWork(this);
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.TelemetrySyncWorker$syncBatch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.TelemetrySyncWorker", f = "TelemetrySyncWorker.kt", i = {}, l = {175}, m = "syncBatch", n = {}, s = {})
    public static final class C04751 extends c {
        int label;
        /* synthetic */ Object result;

        public C04751(Continuation<? super C04751> continuation) {
            super(continuation);
        }

        @Override // U1.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TelemetrySyncWorker.this.syncBatch(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TelemetrySyncWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(context, params);
        h.f(context, "context");
        h.f(params, "params");
    }

    private final boolean isTelemetryEnabled() {
        try {
            return PreferencesHelper.INSTANCE.getInstance().isTelemetryEnabled();
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncBatch(java.util.List<fr.sd.taada.analytics.telemetry.TelemetryEvent> r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.telemetry.TelemetrySyncWorker.syncBatch(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x017d, code lost:
    
        if (fr.sd.taada.analytics.telemetry.TelemetryManager.purgeOldEvents$default(r6, 0, r2, 1, r0) == r3) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ef A[Catch: Exception -> 0x003f, PHI: r0 r4 r6 r7 r10 r14
      0x00ef: PHI (r0v21 java.lang.Object) = (r0v27 java.lang.Object), (r0v1 java.lang.Object) binds: [B:53:0x00eb, B:28:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r4v8 int) = (r4v10 int), (r4v15 int) binds: [B:53:0x00eb, B:28:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r6v4 fr.sd.taada.analytics.telemetry.TelemetryManager) = (r6v6 fr.sd.taada.analytics.telemetry.TelemetryManager), (r6v12 fr.sd.taada.analytics.telemetry.TelemetryManager) binds: [B:53:0x00eb, B:28:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r7v3 fr.sd.taada.analytics.telemetry.TelemetrySyncWorker) = (r7v5 fr.sd.taada.analytics.telemetry.TelemetrySyncWorker), (r7v9 fr.sd.taada.analytics.telemetry.TelemetrySyncWorker) binds: [B:53:0x00eb, B:28:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r10v3 int) = (r10v4 int), (r10v0 int) binds: [B:53:0x00eb, B:28:0x0082] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r14v2 java.lang.Object) = (r14v3 java.lang.Object), (r14v0 java.lang.Object) binds: [B:53:0x00eb, B:28:0x0082] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x003f, blocks: (B:15:0x003a, B:76:0x0180, B:22:0x0058, B:70:0x0152, B:52:0x00db, B:55:0x00ef, B:57:0x00f7, B:61:0x0110, B:63:0x0118, B:64:0x0125, B:66:0x012b, B:67:0x0141, B:71:0x0161, B:73:0x016e, B:25:0x006d, B:28:0x0082, B:31:0x008e, B:47:0x00c8, B:49:0x00d0, B:34:0x0095, B:36:0x009b, B:38:0x00a3, B:40:0x00ab, B:43:0x00b5, B:78:0x0185), top: B:82:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:15:0x003a, B:76:0x0180, B:22:0x0058, B:70:0x0152, B:52:0x00db, B:55:0x00ef, B:57:0x00f7, B:61:0x0110, B:63:0x0118, B:64:0x0125, B:66:0x012b, B:67:0x0141, B:71:0x0161, B:73:0x016e, B:25:0x006d, B:28:0x0082, B:31:0x008e, B:47:0x00c8, B:49:0x00d0, B:34:0x0095, B:36:0x009b, B:38:0x00a3, B:40:0x00ab, B:43:0x00b5, B:78:0x0185), top: B:82:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0118 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:15:0x003a, B:76:0x0180, B:22:0x0058, B:70:0x0152, B:52:0x00db, B:55:0x00ef, B:57:0x00f7, B:61:0x0110, B:63:0x0118, B:64:0x0125, B:66:0x012b, B:67:0x0141, B:71:0x0161, B:73:0x016e, B:25:0x006d, B:28:0x0082, B:31:0x008e, B:47:0x00c8, B:49:0x00d0, B:34:0x0095, B:36:0x009b, B:38:0x00a3, B:40:0x00ab, B:43:0x00b5, B:78:0x0185), top: B:82:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0161 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:15:0x003a, B:76:0x0180, B:22:0x0058, B:70:0x0152, B:52:0x00db, B:55:0x00ef, B:57:0x00f7, B:61:0x0110, B:63:0x0118, B:64:0x0125, B:66:0x012b, B:67:0x0141, B:71:0x0161, B:73:0x016e, B:25:0x006d, B:28:0x0082, B:31:0x008e, B:47:0x00c8, B:49:0x00d0, B:34:0x0095, B:36:0x009b, B:38:0x00a3, B:40:0x00ab, B:43:0x00b5, B:78:0x0185), top: B:82:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016e A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:15:0x003a, B:76:0x0180, B:22:0x0058, B:70:0x0152, B:52:0x00db, B:55:0x00ef, B:57:0x00f7, B:61:0x0110, B:63:0x0118, B:64:0x0125, B:66:0x012b, B:67:0x0141, B:71:0x0161, B:73:0x016e, B:25:0x006d, B:28:0x0082, B:31:0x008e, B:47:0x00c8, B:49:0x00d0, B:34:0x0095, B:36:0x009b, B:38:0x00a3, B:40:0x00ab, B:43:0x00b5, B:78:0x0185), top: B:82:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x014f -> B:23:0x005b). Please report as a decompilation issue!!! */
    @Override // androidx.work.CoroutineWorker
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.telemetry.TelemetrySyncWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
