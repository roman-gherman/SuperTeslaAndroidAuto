package fr.sd.taada.analytics.telemetry;

import E1.k;
import N1.e;
import T1.a;
import U1.c;
import U1.g;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.google.gson.m;
import fr.sd.taada.core.PreferencesHelper;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlin.text.i;
import kotlin.text.p;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0689x;
import m3.AbstractC0690y;
import m3.G;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0001BB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0014H\u0086@¢\u0006\u0004\b!\u0010\u0019J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0004\b\"\u0010\u001fJ\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\t¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b*\u0010+J1\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0002¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0002¢\u0006\u0004\b/\u0010+J\u0011\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\tH\u0002¢\u0006\u0004\b3\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryManager;", "", "Landroid/content/Context;", "context", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;)V", "Lfr/sd/taada/analytics/telemetry/FunnelEvent;", NotificationCompat.CATEGORY_EVENT, "", "", "metadata", "LN1/m;", "log", "(Lfr/sd/taada/analytics/telemetry/FunnelEvent;Ljava/util/Map;)V", "logAndSync", "syncNow", "()V", "eventType", "logCustom", "(Ljava/lang/String;Ljava/util/Map;)V", "", "limit", "", "Lfr/sd/taada/analytics/telemetry/TelemetryEvent;", "getUnsyncedEvents", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "eventIds", "markAsSynced", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "daysToKeep", "purgeOldEvents", "getLastEvent", "", "isEnabled", "()Z", "getSessionId", "()Ljava/lang/String;", "updateLastKnownStep", "(Lfr/sd/taada/analytics/telemetry/FunnelEvent;)V", "buildGlobalContext", "()Ljava/util/Map;", "eventMetadata", "mergeWithGlobalContext", "(Ljava/util/Map;)Ljava/util/Map;", "getBatteryInfo", "", "getCpuTemperature", "()Ljava/lang/Double;", "getAppVersion", "Landroid/content/Context;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lfr/sd/taada/analytics/telemetry/TelemetryDao;", "dao", "Lfr/sd/taada/analytics/telemetry/TelemetryDao;", "Lcom/google/gson/m;", "gson", "Lcom/google/gson/m;", "sessionId", "Ljava/lang/String;", "globalContext", "Ljava/util/Map;", "Companion", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTelemetryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryManager.kt\nfr/sd/taada/analytics/telemetry/TelemetryManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,319:1\n1#2:320\n*E\n"})
public final class TelemetryManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "Telemetry/Manager";

    @Nullable
    private static volatile TelemetryManager instance;

    @NotNull
    private final Context context;

    @NotNull
    private final TelemetryDao dao;

    @NotNull
    private final Map<String, String> globalContext;

    @NotNull
    private final m gson;

    @NotNull
    private final CoroutineScope scope;

    @NotNull
    private final String sessionId;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryManager$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "LN1/m;", "initialize", "(Landroid/content/Context;)V", "Lfr/sd/taada/analytics/telemetry/TelemetryManager;", "getInstance", "()Lfr/sd/taada/analytics/telemetry/TelemetryManager;", "", "isInitialized", "()Z", "", "TAG", "Ljava/lang/String;", "instance", "Lfr/sd/taada/analytics/telemetry/TelemetryManager;", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final TelemetryManager getInstance() {
            TelemetryManager telemetryManager = TelemetryManager.instance;
            if (telemetryManager != null) {
                return telemetryManager;
            }
            throw new IllegalStateException("TelemetryManager not initialized. Call initialize() first.");
        }

        @JvmStatic
        public final void initialize(@NotNull Context context) {
            h.f(context, "context");
            synchronized (this) {
                if (TelemetryManager.instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    h.e(applicationContext, "getApplicationContext(...)");
                    TelemetryManager.instance = new TelemetryManager(applicationContext, null);
                    TelemetryManager telemetryManager = TelemetryManager.instance;
                    h.c(telemetryManager);
                    String unused = telemetryManager.sessionId;
                }
            }
        }

        @JvmStatic
        public final boolean isInitialized() {
            return TelemetryManager.instance != null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.TelemetryManager$log$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.TelemetryManager$log$1", f = "TelemetryManager.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends g implements Function2<CoroutineScope, Continuation<? super N1.m>, Object> {
        final /* synthetic */ FunnelEvent $event;
        final /* synthetic */ Map<String, Object> $metadata;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map<String, ? extends Object> map, FunnelEvent funnelEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$metadata = map;
            this.$event = funnelEvent;
        }

        @Override // U1.a
        public final Continuation<N1.m> create(Object obj, Continuation<?> continuation) {
            return TelemetryManager.this.new AnonymousClass1(this.$metadata, this.$event, continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            try {
                if (i == 0) {
                    l.e0(obj);
                    TelemetryEvent telemetryEvent = new TelemetryEvent(0L, this.$event.getEventName(), 0L, TelemetryManager.this.gson.h(TelemetryManager.this.mergeWithGlobalContext(this.$metadata)), false, 0, 53, null);
                    TelemetryDao telemetryDao = TelemetryManager.this.dao;
                    this.label = 1;
                    if (telemetryDao.insert(telemetryEvent, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                }
                TelemetryManager.this.updateLastKnownStep(this.$event);
                this.$event.getEventName();
            } catch (Exception e) {
                Log.e(TelemetryManager.TAG, "Failed to log event: " + this.$event.getEventName(), e);
            }
            return N1.m.f1129a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super N1.m> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(N1.m.f1129a);
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.TelemetryManager$logCustom$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LN1/m;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 0, 0})
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.TelemetryManager$logCustom$1", f = "TelemetryManager.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04721 extends g implements Function2<CoroutineScope, Continuation<? super N1.m>, Object> {
        final /* synthetic */ String $eventType;
        final /* synthetic */ Map<String, Object> $metadata;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04721(Map<String, ? extends Object> map, String str, Continuation<? super C04721> continuation) {
            super(2, continuation);
            this.$metadata = map;
            this.$eventType = str;
        }

        @Override // U1.a
        public final Continuation<N1.m> create(Object obj, Continuation<?> continuation) {
            return TelemetryManager.this.new C04721(this.$metadata, this.$eventType, continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            try {
                if (i == 0) {
                    l.e0(obj);
                    TelemetryEvent telemetryEvent = new TelemetryEvent(0L, this.$eventType, 0L, TelemetryManager.this.gson.h(TelemetryManager.this.mergeWithGlobalContext(this.$metadata)), false, 0, 53, null);
                    TelemetryDao telemetryDao = TelemetryManager.this.dao;
                    this.label = 1;
                    if (telemetryDao.insert(telemetryEvent, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                }
            } catch (Exception e) {
                Log.e(TelemetryManager.TAG, "Failed to log custom event: " + this.$eventType, e);
            }
            return N1.m.f1129a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super N1.m> continuation) {
            return ((C04721) create(coroutineScope, continuation)).invokeSuspend(N1.m.f1129a);
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.TelemetryManager$markAsSynced$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.TelemetryManager", f = "TelemetryManager.kt", i = {0}, l = {149}, m = "markAsSynced", n = {"eventIds"}, s = {"L$0"})
    public static final class C04731 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C04731(Continuation<? super C04731> continuation) {
            super(continuation);
        }

        @Override // U1.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TelemetryManager.this.markAsSynced(null, this);
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.analytics.telemetry.TelemetryManager$purgeOldEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.telemetry.TelemetryManager", f = "TelemetryManager.kt", i = {}, l = {165}, m = "purgeOldEvents", n = {}, s = {})
    public static final class C04741 extends c {
        int label;
        /* synthetic */ Object result;

        public C04741(Continuation<? super C04741> continuation) {
            super(continuation);
        }

        @Override // U1.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TelemetryManager.this.purgeOldEvents(0, this);
        }
    }

    public /* synthetic */ TelemetryManager(Context context, d dVar) {
        this(context);
    }

    private final Map<String, String> buildGlobalContext() {
        return A.I(new e("session_id", this.sessionId), new e("device_model", Build.MODEL), new e("os_version", "Android " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ')'), new e("app_version", getAppVersion()));
    }

    private final String getAppVersion() {
        try {
            String str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
            return str == null ? EnvironmentCompat.MEDIA_UNKNOWN : str;
        } catch (Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private final Map<String, Object> getBatteryInfo() {
        try {
            Intent intentRegisterReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
            float f6 = (intExtra == -1 || intExtra2 == -1) ? -1.0f : (intExtra * 100) / intExtra2;
            int intExtra3 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1) : -1;
            boolean z6 = true;
            boolean z7 = intExtra3 == 2 || intExtra3 == 5;
            int intExtra4 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("plugged", -1) : -1;
            boolean z8 = intExtra4 == 2;
            if (intExtra4 != 1) {
                z6 = false;
            }
            return A.I(new e("battery_level", Float.valueOf(f6)), new e("is_charging", Boolean.valueOf(z7)), new e("charging_source", intExtra4 == 4 ? "Wireless" : z8 ? "USB" : z6 ? "AC" : "None"), new e("battery_temp", Float.valueOf((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("temperature", 0) : 0) / 10.0f)));
        } catch (Exception e) {
            Log.e(TAG, "Error getting battery info", e);
            return v.f3805a;
        }
    }

    private final Double getCpuTemperature() {
        Double dU;
        Iterator it = n.y("/sys/class/thermal/thermal_zone0/temp", "/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/thermal_stat/temp", "/sys/class/hwmon/hwmon0/temp1_input").iterator();
        while (it.hasNext()) {
            try {
                File file = new File((String) it.next());
                if (file.exists() && file.canRead()) {
                    String string = i.X(k.b0(file)).toString();
                    if (string.length() > 0 && (dU = p.u(string)) != null) {
                        if (dU.doubleValue() > 1000.0d) {
                            dU = Double.valueOf(dU.doubleValue() / 1000.0d);
                        }
                        return dU;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final TelemetryManager getInstance() {
        return INSTANCE.getInstance();
    }

    public static /* synthetic */ Object getUnsyncedEvents$default(TelemetryManager telemetryManager, int i, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 100;
        }
        return telemetryManager.getUnsyncedEvents(i, continuation);
    }

    @JvmStatic
    public static final void initialize(@NotNull Context context) {
        INSTANCE.initialize(context);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return INSTANCE.isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void log$default(TelemetryManager telemetryManager, FunnelEvent funnelEvent, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        telemetryManager.log(funnelEvent, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void logAndSync$default(TelemetryManager telemetryManager, FunnelEvent funnelEvent, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        telemetryManager.logAndSync(funnelEvent, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void logCustom$default(TelemetryManager telemetryManager, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        telemetryManager.logCustom(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> mergeWithGlobalContext(Map<String, ? extends Object> eventMetadata) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.globalContext);
        linkedHashMap.putAll(getBatteryInfo());
        Double cpuTemperature = getCpuTemperature();
        if (cpuTemperature != null) {
            linkedHashMap.put("cpu_temp", Double.valueOf(cpuTemperature.doubleValue()));
        }
        if (eventMetadata != null) {
            linkedHashMap.putAll(eventMetadata);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ Object purgeOldEvents$default(TelemetryManager telemetryManager, int i, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 7;
        }
        return telemetryManager.purgeOldEvents(i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLastKnownStep(FunnelEvent event) {
        try {
            PreferencesHelper.INSTANCE.getInstance().setLastKnownStep(event.getEventName());
        } catch (Exception e) {
            Log.w(TAG, "Failed to update last known step", e);
        }
    }

    @Nullable
    public final Object getLastEvent(@NotNull Continuation<? super TelemetryEvent> continuation) {
        return this.dao.getLastEvent(continuation);
    }

    @Nullable
    public final Object getPendingCount(@NotNull Continuation<? super Integer> continuation) {
        return this.dao.getUnsyncedCount(continuation);
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public final Object getUnsyncedEvents(int i, @NotNull Continuation<? super List<TelemetryEvent>> continuation) {
        return this.dao.getUnsyncedEvents(i, continuation);
    }

    public final boolean isEnabled() {
        try {
            return PreferencesHelper.INSTANCE.getInstance().isTelemetryEnabled();
        } catch (Exception unused) {
            return true;
        }
    }

    @JvmOverloads
    public final void log(@NotNull FunnelEvent event) {
        h.f(event, "event");
        log$default(this, event, null, 2, null);
    }

    @JvmOverloads
    public final void logAndSync(@NotNull FunnelEvent event) {
        h.f(event, "event");
        logAndSync$default(this, event, null, 2, null);
    }

    @JvmOverloads
    public final void logCustom(@NotNull String eventType) {
        h.f(eventType, "eventType");
        logCustom$default(this, eventType, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object markAsSynced(@org.jetbrains.annotations.NotNull java.util.List<java.lang.Long> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super N1.m> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof fr.sd.taada.analytics.telemetry.TelemetryManager.C04731
            if (r0 == 0) goto L13
            r0 = r6
            fr.sd.taada.analytics.telemetry.TelemetryManager$markAsSynced$1 r0 = (fr.sd.taada.analytics.telemetry.TelemetryManager.C04731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            fr.sd.taada.analytics.telemetry.TelemetryManager$markAsSynced$1 r0 = new fr.sd.taada.analytics.telemetry.TelemetryManager$markAsSynced$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.reflect.l.e0(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.reflect.l.e0(r6)
            fr.sd.taada.analytics.telemetry.TelemetryDao r6 = r4.dao
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.markAsSynced(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            r5.size()
            N1.m r5 = N1.m.f1129a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.telemetry.TelemetryManager.markAsSynced(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object purgeOldEvents(int r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof fr.sd.taada.analytics.telemetry.TelemetryManager.C04741
            if (r0 == 0) goto L13
            r0 = r10
            fr.sd.taada.analytics.telemetry.TelemetryManager$purgeOldEvents$1 r0 = (fr.sd.taada.analytics.telemetry.TelemetryManager.C04741) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            fr.sd.taada.analytics.telemetry.TelemetryManager$purgeOldEvents$1 r0 = new fr.sd.taada.analytics.telemetry.TelemetryManager$purgeOldEvents$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            T1.a r1 = T1.a.f1304a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.reflect.l.e0(r10)
            goto L4a
        L27:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2f:
            kotlin.reflect.l.e0(r10)
            long r4 = java.lang.System.currentTimeMillis()
            r10 = 86400(0x15180, float:1.21072E-40)
            int r9 = r9 * r10
            long r9 = (long) r9
            r6 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 * r6
            long r4 = r4 - r9
            fr.sd.taada.analytics.telemetry.TelemetryDao r9 = r8.dao
            r0.label = r3
            java.lang.Object r10 = r9.deleteSyncedOlderThan(r4, r0)
            if (r10 != r1) goto L4a
            return r1
        L4a:
            java.lang.Number r10 = (java.lang.Number) r10
            int r9 = r10.intValue()
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.telemetry.TelemetryManager.purgeOldEvents(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void syncNow() {
        try {
            TelemetrySyncWorker.Companion.syncNow(this.context);
        } catch (Exception e) {
            Log.w(TAG, "Failed to trigger immediate sync", e);
        }
    }

    private TelemetryManager(Context context) {
        this.context = context;
        this.scope = AbstractC0689x.a(kotlin.coroutines.a.d(AbstractC0690y.b(), G.c));
        this.dao = TelemetryDatabase.INSTANCE.getInstance(context).telemetryDao();
        this.gson = new m();
        String string = UUID.randomUUID().toString();
        h.e(string, "toString(...)");
        this.sessionId = string;
        this.globalContext = buildGlobalContext();
    }

    @JvmOverloads
    public final void log(@NotNull FunnelEvent event, @Nullable Map<String, ? extends Object> metadata) {
        h.f(event, "event");
        AbstractC0690y.g(this.scope, null, new AnonymousClass1(metadata, event, null), 3);
    }

    @JvmOverloads
    public final void logAndSync(@NotNull FunnelEvent event, @Nullable Map<String, ? extends Object> metadata) {
        h.f(event, "event");
        log(event, metadata);
        syncNow();
    }

    @JvmOverloads
    public final void logCustom(@NotNull String eventType, @Nullable Map<String, ? extends Object> metadata) {
        h.f(eventType, "eventType");
        AbstractC0690y.g(this.scope, null, new C04721(metadata, eventType, null), 3);
    }
}
