package fr.sd.taada.analytics.telemetry;

import N1.e;
import N1.m;
import T1.a;
import U1.g;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.util.Log;
import android.view.DefaultLifecycleObserver;
import android.view.LifecycleOwner;
import android.view.ProcessLifecycleOwner;
import androidx.core.os.EnvironmentCompat;
import fr.sd.taada.core.AnalyticsHttpClient;
import fr.sd.taada.core.PreferencesHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0689x;
import m3.AbstractC0690y;
import m3.G;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lfr/sd/taada/analytics/telemetry/LastBreathManager;", "Landroid/content/ComponentCallbacks2;", "Landroid/content/Context;", "context", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;)V", "", "state", "LN1/m;", "sendLifecycleEvent", "(Ljava/lang/String;)V", "", "memoryLevel", "sendLastBreath", "(I)V", "getBatteryLevel", "()I", "level", "onTrimMemory", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "()V", "triggerManually", "Landroid/content/Context;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/DefaultLifecycleObserver;", "Companion", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LastBreathManager implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENDPOINT_SOS = "/api/v1/telemetry/sos";

    @NotNull
    private static final String TAG = "Telemetry/LastBreath";

    @Nullable
    private static volatile LastBreathManager instance;

    @NotNull
    private final Context context;

    @NotNull
    private final DefaultLifecycleObserver lifecycleObserver;

    @NotNull
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lfr/sd/taada/analytics/telemetry/LastBreathManager$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "LN1/m;", "initialize", "(Landroid/content/Context;)V", "Lfr/sd/taada/analytics/telemetry/LastBreathManager;", "getInstance", "()Lfr/sd/taada/analytics/telemetry/LastBreathManager;", "", "isInitialized", "()Z", "", "TAG", "Ljava/lang/String;", "ENDPOINT_SOS", "instance", "Lfr/sd/taada/analytics/telemetry/LastBreathManager;", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @NotNull
        public final LastBreathManager getInstance() {
            LastBreathManager lastBreathManager = LastBreathManager.instance;
            if (lastBreathManager != null) {
                return lastBreathManager;
            }
            throw new IllegalStateException("LastBreathManager not initialized. Call initialize() first.");
        }

        public final void initialize(@NotNull Context context) {
            h.f(context, "context");
            synchronized (this) {
                if (LastBreathManager.instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    h.e(applicationContext, "getApplicationContext(...)");
                    LastBreathManager lastBreathManager = new LastBreathManager(applicationContext, null);
                    context.getApplicationContext().registerComponentCallbacks(lastBreathManager);
                    ProcessLifecycleOwner.INSTANCE.get().getLifecycle().addObserver(lastBreathManager.getLifecycleObserver());
                    LastBreathManager.instance = lastBreathManager;
                }
            }
        }

        public final boolean isInitialized() {
            return LastBreathManager.instance != null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.LastBreathManager$sendLastBreath$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.LastBreathManager$sendLastBreath$1", f = "LastBreathManager.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        final /* synthetic */ int $memoryLevel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$memoryLevel = i;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return LastBreathManager.this.new AnonymousClass1(this.$memoryLevel, continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            try {
                if (i == 0) {
                    l.e0(obj);
                    PreferencesHelper companion = PreferencesHelper.INSTANCE.getInstance();
                    String deviceId = companion.getDeviceId();
                    String str = deviceId == null ? EnvironmentCompat.MEDIA_UNKNOWN : deviceId;
                    String lastKnownStep = companion.getLastKnownStep();
                    String str2 = lastKnownStep == null ? EnvironmentCompat.MEDIA_UNKNOWN : lastKnownStep;
                    int batteryLevel = LastBreathManager.this.getBatteryLevel();
                    LastBreathPayload lastBreathPayload = new LastBreathPayload(str, str2, System.currentTimeMillis(), batteryLevel, this.$memoryLevel, null, 32, null);
                    Log.w(LastBreathManager.TAG, "Sending Last Breath: step=" + str2 + ", battery=" + batteryLevel + '%');
                    AnalyticsHttpClient.Companion companion2 = AnalyticsHttpClient.INSTANCE;
                    if (companion2.isInitialized()) {
                        AnalyticsHttpClient companion3 = companion2.getInstance();
                        this.label = 1;
                        if (companion3.fireAndForget(LastBreathManager.ENDPOINT_SOS, lastBreathPayload, this) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                }
            } catch (Exception e) {
                Log.e(LastBreathManager.TAG, "Failed to send Last Breath", e);
            }
            return m.f1129a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.LastBreathManager$sendLifecycleEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.LastBreathManager$sendLifecycleEvent$1", f = "LastBreathManager.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04711 extends g implements Function2<CoroutineScope, Continuation<? super m>, Object> {
        final /* synthetic */ String $state;
        int label;
        final /* synthetic */ LastBreathManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04711(String str, LastBreathManager lastBreathManager, Continuation<? super C04711> continuation) {
            super(2, continuation);
            this.$state = str;
            this.this$0 = lastBreathManager;
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return new C04711(this.$state, this.this$0, continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            m mVar = m.f1129a;
            try {
                if (i == 0) {
                    l.e0(obj);
                    PreferencesHelper companion = PreferencesHelper.INSTANCE.getInstance();
                    String deviceId = companion.getDeviceId();
                    if (deviceId == null) {
                        return mVar;
                    }
                    String lastKnownStep = companion.getLastKnownStep();
                    if (lastKnownStep == null) {
                        lastKnownStep = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    Map mapI = A.I(new e(PreferencesHelper.KEY_DEVICE_ID, deviceId), new e("state", this.$state), new e("last_step", lastKnownStep), new e("timestamp", new Long(System.currentTimeMillis())), new e("battery_level", new Integer(this.this$0.getBatteryLevel())));
                    AnalyticsHttpClient.Companion companion2 = AnalyticsHttpClient.INSTANCE;
                    if (companion2.isInitialized()) {
                        AnalyticsHttpClient companion3 = companion2.getInstance();
                        this.label = 1;
                        if (companion3.fireAndForget("/api/v1/telemetry/lifecycle", mapI, this) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                }
            } catch (Exception e) {
                Log.w(LastBreathManager.TAG, "Failed to send lifecycle event: " + e.getMessage());
            }
            return mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super m> continuation) {
            return ((C04711) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public /* synthetic */ LastBreathManager(Context context, d dVar) {
        this(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getBatteryLevel() {
        try {
            Intent intentRegisterReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", 100) : 100;
            int i = intExtra * 100;
            if (intExtra2 < 1) {
                intExtra2 = 1;
            }
            return i / intExtra2;
        } catch (Exception e) {
            Log.w(TAG, "Failed to get battery level", e);
            return -1;
        }
    }

    private final void sendLastBreath(int memoryLevel) {
        AbstractC0690y.g(this.scope, null, new AnonymousClass1(memoryLevel, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendLifecycleEvent(String state) {
        AbstractC0690y.g(this.scope, null, new C04711(state, this, null), 3);
    }

    @NotNull
    public final DefaultLifecycleObserver getLifecycleObserver() {
        return this.lifecycleObserver;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        h.f(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Log.w(TAG, "onLowMemory triggered");
        sendLastBreath(80);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        if (level == 10 || level == 15) {
            sendLastBreath(level);
        } else if (level == 20 || level == 80) {
            sendLastBreath(level);
        }
    }

    public final void triggerManually() {
        sendLastBreath(0);
    }

    private LastBreathManager(Context context) {
        this.context = context;
        this.scope = AbstractC0689x.a(kotlin.coroutines.a.d(AbstractC0690y.b(), G.c));
        this.lifecycleObserver = new DefaultLifecycleObserver() { // from class: fr.sd.taada.analytics.telemetry.LastBreathManager$lifecycleObserver$1
            @Override // android.view.DefaultLifecycleObserver
            public void onStart(LifecycleOwner owner) {
                h.f(owner, "owner");
                this.this$0.sendLifecycleEvent("FOREGROUND");
            }

            @Override // android.view.DefaultLifecycleObserver
            public void onStop(LifecycleOwner owner) {
                h.f(owner, "owner");
                this.this$0.sendLifecycleEvent("BACKGROUND");
            }
        };
    }
}
