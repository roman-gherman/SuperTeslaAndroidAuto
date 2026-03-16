package fr.sd.taada.analytics.attribution;

import N1.m;
import U1.c;
import U1.g;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import fr.sd.taada.analytics.attribution.mmp.TenjinAttributionService;
import fr.sd.taada.core.PreferencesHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.text.r;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0690y;
import m3.G;
import m3.V;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\u0006\u0010\f\u001a\u00020\tJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lfr/sd/taada/analytics/attribution/AttributionManager;", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_SERVICE, "Lfr/sd/taada/analytics/attribution/IAttributionService;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Lfr/sd/taada/analytics/attribution/IAttributionService;)V", "fetchAndDispatch", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendToBackend", "isComplete", "getSource", "Lfr/sd/taada/analytics/attribution/AttributionSource;", "Companion", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AttributionManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENDPOINT_ATTRIBUTION = "/api/v1/attribution";

    @NotNull
    private static final String TAG = "Attribution/Manager";

    @Nullable
    private static volatile AttributionManager instance;

    @NotNull
    private final Context context;

    @NotNull
    private final IAttributionService service;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u0003R\u0014\u0010\u001f\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lfr/sd/taada/analytics/attribution/AttributionManager$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "LN1/m;", "initialize", "(Landroid/content/Context;)V", "Lfr/sd/taada/analytics/attribution/IAttributionService;", NotificationCompat.CATEGORY_SERVICE, "initializeWithService", "(Landroid/content/Context;Lfr/sd/taada/analytics/attribution/IAttributionService;)V", "Lfr/sd/taada/analytics/attribution/AttributionManager;", "getInstance", "()Lfr/sd/taada/analytics/attribution/AttributionManager;", "", "isInitialized", "()Z", "fetchAndDispatchAsync", "", "planType", "logTrialStarted", "(Ljava/lang/String;)V", "", "revenue", "currency", "productId", "logPurchase", "(DLjava/lang/String;Ljava/lang/String;)V", "logStreamSuccess", "TAG", "Ljava/lang/String;", "ENDPOINT_ATTRIBUTION", "instance", "Lfr/sd/taada/analytics/attribution/AttributionManager;", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        public final void fetchAndDispatchAsync() {
            if (isInitialized()) {
                AbstractC0690y.g(V.f4114a, G.c, new AttributionManager$Companion$fetchAndDispatchAsync$1(null), 2);
            } else {
                Log.w(AttributionManager.TAG, "AttributionManager not initialized, skipping dispatch");
            }
        }

        @JvmStatic
        @NotNull
        public final AttributionManager getInstance() {
            AttributionManager attributionManager = AttributionManager.instance;
            if (attributionManager != null) {
                return attributionManager;
            }
            throw new IllegalStateException("AttributionManager not initialized. Call initialize() first.");
        }

        @JvmStatic
        public final void initialize(@NotNull Context context) {
            h.f(context, "context");
            synchronized (this) {
                try {
                    if (AttributionManager.instance == null) {
                        IAttributionService tenjinAttributionService = !r.y(BuildConfig.TENJIN_API_KEY) ? new TenjinAttributionService(context, BuildConfig.TENJIN_API_KEY) : new PlayReferrerAttributionService(context);
                        Context applicationContext = context.getApplicationContext();
                        h.e(applicationContext, "getApplicationContext(...)");
                        AttributionManager.instance = new AttributionManager(applicationContext, tenjinAttributionService, null);
                        AbstractC0690y.g(V.f4114a, G.c, new AttributionManager$Companion$initialize$1$1(tenjinAttributionService, null), 2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @JvmStatic
        public final void initializeWithService(@NotNull Context context, @NotNull IAttributionService service) {
            h.f(context, "context");
            h.f(service, "service");
            synchronized (this) {
                if (AttributionManager.instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    h.e(applicationContext, "getApplicationContext(...)");
                    AttributionManager.instance = new AttributionManager(applicationContext, service, null);
                }
            }
        }

        @JvmStatic
        public final boolean isInitialized() {
            return AttributionManager.instance != null;
        }

        @JvmStatic
        public final void logPurchase(double revenue, @NotNull String currency, @NotNull String productId) {
            h.f(currency, "currency");
            h.f(productId, "productId");
            if (isInitialized()) {
                getInstance().service.logPurchase(revenue, currency, productId);
            }
        }

        @JvmStatic
        public final void logStreamSuccess() {
            if (isInitialized()) {
                getInstance().service.logStreamSuccess();
            }
        }

        @JvmStatic
        public final void logTrialStarted(@NotNull String planType) {
            h.f(planType, "planType");
            if (isInitialized()) {
                getInstance().service.logTrialStarted(planType);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.attribution.AttributionManager$fetchAndDispatch$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.attribution.AttributionManager$fetchAndDispatch$2", f = "AttributionManager.kt", i = {1}, l = {152, 159, 169}, m = "invokeSuspend", n = {"prefs"}, s = {"L$0"})
    public static final class AnonymousClass2 extends g implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return AttributionManager.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        
            if (r7.sendToBackend(r6) != r0) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0072 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:7:0x000f, B:14:0x0023, B:30:0x005f, B:32:0x0072, B:33:0x0077, B:15:0x0027, B:25:0x004b, B:18:0x002e, B:20:0x003a, B:22:0x0040, B:27:0x004e), top: B:39:0x0007 }] */
        @Override // U1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                T1.a r0 = T1.a.f1304a
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2b
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                kotlin.reflect.l.e0(r7)     // Catch: java.lang.Exception -> L14
                goto L94
            L14:
                r7 = move-exception
                goto L8c
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                java.lang.Object r1 = r6.L$0
                fr.sd.taada.core.PreferencesHelper r1 = (fr.sd.taada.core.PreferencesHelper) r1
                kotlin.reflect.l.e0(r7)     // Catch: java.lang.Exception -> L14
                goto L5f
            L27:
                kotlin.reflect.l.e0(r7)     // Catch: java.lang.Exception -> L14
                goto L4b
            L2b:
                kotlin.reflect.l.e0(r7)
                fr.sd.taada.core.PreferencesHelper$Companion r7 = fr.sd.taada.core.PreferencesHelper.INSTANCE     // Catch: java.lang.Exception -> L14
                fr.sd.taada.core.PreferencesHelper r1 = r7.getInstance()     // Catch: java.lang.Exception -> L14
                java.lang.String r7 = r1.getAttributionSource()     // Catch: java.lang.Exception -> L14
                if (r7 == 0) goto L4e
                boolean r7 = r1.isAttributionSent()     // Catch: java.lang.Exception -> L14
                if (r7 != 0) goto L4b
                fr.sd.taada.analytics.attribution.AttributionManager r7 = fr.sd.taada.analytics.attribution.AttributionManager.this     // Catch: java.lang.Exception -> L14
                r6.label = r4     // Catch: java.lang.Exception -> L14
                java.lang.Object r7 = fr.sd.taada.analytics.attribution.AttributionManager.access$sendToBackend(r7, r6)     // Catch: java.lang.Exception -> L14
                if (r7 != r0) goto L4b
                goto L8b
            L4b:
                java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L14
                return r7
            L4e:
                fr.sd.taada.analytics.attribution.AttributionManager r7 = fr.sd.taada.analytics.attribution.AttributionManager.this     // Catch: java.lang.Exception -> L14
                fr.sd.taada.analytics.attribution.IAttributionService r7 = fr.sd.taada.analytics.attribution.AttributionManager.access$getService$p(r7)     // Catch: java.lang.Exception -> L14
                r6.L$0 = r1     // Catch: java.lang.Exception -> L14
                r6.label = r3     // Catch: java.lang.Exception -> L14
                java.lang.Object r7 = r7.fetchAttribution(r6)     // Catch: java.lang.Exception -> L14
                if (r7 != r0) goto L5f
                goto L8b
            L5f:
                fr.sd.taada.analytics.attribution.AttributionData r7 = (fr.sd.taada.analytics.attribution.AttributionData) r7     // Catch: java.lang.Exception -> L14
                fr.sd.taada.analytics.attribution.AttributionSource r3 = r7.getSource()     // Catch: java.lang.Exception -> L14
                java.lang.String r3 = r3.name()     // Catch: java.lang.Exception -> L14
                r1.setAttributionSource(r3)     // Catch: java.lang.Exception -> L14
                java.lang.String r3 = r7.getUtmCampaign()     // Catch: java.lang.Exception -> L14
                if (r3 == 0) goto L77
                java.lang.String r5 = "attribution_campaign"
                r1.setString(r5, r3)     // Catch: java.lang.Exception -> L14
            L77:
                fr.sd.taada.analytics.attribution.AttributionSource r7 = r7.getSource()     // Catch: java.lang.Exception -> L14
                java.util.Objects.toString(r7)     // Catch: java.lang.Exception -> L14
                fr.sd.taada.analytics.attribution.AttributionManager r7 = fr.sd.taada.analytics.attribution.AttributionManager.this     // Catch: java.lang.Exception -> L14
                r1 = 0
                r6.L$0 = r1     // Catch: java.lang.Exception -> L14
                r6.label = r2     // Catch: java.lang.Exception -> L14
                java.lang.Object r7 = fr.sd.taada.analytics.attribution.AttributionManager.access$sendToBackend(r7, r6)     // Catch: java.lang.Exception -> L14
                if (r7 != r0) goto L94
            L8b:
                return r0
            L8c:
                java.lang.String r0 = "Attribution/Manager"
                java.lang.String r1 = "Attribution fetch/dispatch failed"
                android.util.Log.e(r0, r1, r7)
                r4 = 0
            L94:
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.attribution.AttributionManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.attribution.AttributionManager$sendToBackend$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.attribution.AttributionManager", f = "AttributionManager.kt", i = {0}, l = {201}, m = "sendToBackend", n = {"prefs"}, s = {"L$0"})
    public static final class AnonymousClass1 extends c {
        Object L$0;
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
            return AttributionManager.this.sendToBackend(this);
        }
    }

    public /* synthetic */ AttributionManager(Context context, IAttributionService iAttributionService, d dVar) {
        this(context, iAttributionService);
    }

    @JvmStatic
    public static final void fetchAndDispatchAsync() {
        INSTANCE.fetchAndDispatchAsync();
    }

    @JvmStatic
    @NotNull
    public static final AttributionManager getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final void initialize(@NotNull Context context) {
        INSTANCE.initialize(context);
    }

    @JvmStatic
    public static final void initializeWithService(@NotNull Context context, @NotNull IAttributionService iAttributionService) {
        INSTANCE.initializeWithService(context, iAttributionService);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return INSTANCE.isInitialized();
    }

    @JvmStatic
    public static final void logPurchase(double d, @NotNull String str, @NotNull String str2) {
        INSTANCE.logPurchase(d, str, str2);
    }

    @JvmStatic
    public static final void logStreamSuccess() {
        INSTANCE.logStreamSuccess();
    }

    @JvmStatic
    public static final void logTrialStarted(@NotNull String str) {
        INSTANCE.logTrialStarted(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendToBackend(kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r14 instanceof fr.sd.taada.analytics.attribution.AttributionManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            fr.sd.taada.analytics.attribution.AttributionManager$sendToBackend$1 r0 = (fr.sd.taada.analytics.attribution.AttributionManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            fr.sd.taada.analytics.attribution.AttributionManager$sendToBackend$1 r0 = new fr.sd.taada.analytics.attribution.AttributionManager$sendToBackend$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            fr.sd.taada.core.PreferencesHelper r0 = (fr.sd.taada.core.PreferencesHelper) r0
            kotlin.reflect.l.e0(r14)
            N1.h r14 = (N1.h) r14
            java.lang.Object r14 = r14.f1124a
            goto L7e
        L2f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L37:
            kotlin.reflect.l.e0(r14)
            fr.sd.taada.core.PreferencesHelper$Companion r14 = fr.sd.taada.core.PreferencesHelper.INSTANCE
            fr.sd.taada.core.PreferencesHelper r14 = r14.getInstance()
            boolean r2 = r14.isAttributionSent()
            if (r2 == 0) goto L49
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            return r14
        L49:
            java.lang.String r6 = r14.getAttributionSource()
            if (r6 != 0) goto L52
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            return r14
        L52:
            java.lang.String r5 = r14.getOrCreateDeviceId()
            r2 = 2
            r4 = 0
            java.lang.String r7 = "attribution_campaign"
            java.lang.String r9 = fr.sd.taada.core.PreferencesHelper.getString$default(r14, r7, r4, r2, r4)
            fr.sd.taada.analytics.attribution.AttributionRequest r4 = new fr.sd.taada.analytics.attribution.AttributionRequest
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            fr.sd.taada.core.AnalyticsHttpClient$Companion r2 = fr.sd.taada.core.AnalyticsHttpClient.INSTANCE
            fr.sd.taada.core.AnalyticsHttpClient r2 = r2.getInstance()
            r0.L$0 = r14
            r0.label = r3
            java.lang.String r3 = "/api/v1/attribution"
            java.lang.Object r0 = r2.m91postRaw0E7RQCE(r3, r4, r0)
            if (r0 != r1) goto L7b
            return r1
        L7b:
            r12 = r0
            r0 = r14
            r14 = r12
        L7e:
            java.lang.Throwable r1 = N1.h.a(r14)
            if (r1 != 0) goto L8c
            java.lang.String r14 = (java.lang.String) r14
            r0.markAttributionSent()
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            return r14
        L8c:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to send attribution: "
            r14.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "Attribution/Manager"
            android.util.Log.w(r0, r14)
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.attribution.AttributionManager.sendToBackend(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object fetchAndDispatch(@NotNull Continuation<? super Boolean> continuation) {
        return AbstractC0690y.m(G.c, new AnonymousClass2(null), continuation);
    }

    @Nullable
    public final AttributionSource getSource() {
        String attributionSource = PreferencesHelper.INSTANCE.getInstance().getAttributionSource();
        if (attributionSource == null) {
            return null;
        }
        try {
            return AttributionSource.valueOf(attributionSource);
        } catch (Exception unused) {
            return AttributionSource.UNKNOWN;
        }
    }

    public final boolean isComplete() {
        PreferencesHelper companion = PreferencesHelper.INSTANCE.getInstance();
        return companion.getAttributionSource() != null && companion.isAttributionSent();
    }

    private AttributionManager(Context context, IAttributionService iAttributionService) {
        this.context = context;
        this.service = iAttributionService;
    }
}
