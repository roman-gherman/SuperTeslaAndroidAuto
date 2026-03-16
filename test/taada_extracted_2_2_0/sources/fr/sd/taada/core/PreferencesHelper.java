package fr.sd.taada.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.text.i;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u0015J\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0018J\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001f\u0010\u0015J\u0015\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0018J\r\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010\u001aJ\r\u0010#\u001a\u00020\f¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000f¢\u0006\u0004\b%\u0010\u001aJ\u0015\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u000f¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b)\u0010\u0015J\u0015\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0018J\r\u0010,\u001a\u00020\f¢\u0006\u0004\b,\u0010$R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lfr/sd/taada/core/PreferencesHelper;", "", "Landroid/content/Context;", "context", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;)V", "", "key", "default", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "value", "LN1/m;", "setString", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getBoolean", "(Ljava/lang/String;Z)Z", "setBoolean", "(Ljava/lang/String;Z)V", "getToken", "()Ljava/lang/String;", "token", "setToken", "(Ljava/lang/String;)V", "hasToken", "()Z", "getDeviceId", "deviceId", "setDeviceId", "getOrCreateDeviceId", "getAttributionSource", "source", "setAttributionSource", "isAttributionSent", "markAttributionSent", "()V", "isTelemetryEnabled", "enabled", "setTelemetryEnabled", "(Z)V", "getLastKnownStep", "step", "setLastKnownStep", "clearAll", "Landroid/content/SharedPreferences;", "prefs", "Landroid/content/SharedPreferences;", "Companion", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferencesHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferencesHelper.kt\nfr/sd/taada/core/PreferencesHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
public final class PreferencesHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_ATTRIBUTION_CAMPAIGN = "attribution_campaign";

    @NotNull
    public static final String KEY_ATTRIBUTION_SENT = "attribution_sent";

    @NotNull
    public static final String KEY_ATTRIBUTION_SOURCE = "attribution_source";

    @NotNull
    public static final String KEY_DEVICE_ID = "device_id";

    @NotNull
    public static final String KEY_JWT_TOKEN = "jwt_token";

    @NotNull
    public static final String KEY_LAST_KNOWN_STEP = "last_known_step";

    @NotNull
    public static final String KEY_TELEMETRY_ENABLED = "telemetry_enabled";

    @NotNull
    private static final String PREFS_FILE_NAME = "taada_analytics_prefs";

    @NotNull
    private static final String TAG = "Core/Preferences";

    @Nullable
    private static volatile PreferencesHelper instance;

    @NotNull
    private final SharedPreferences prefs;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lfr/sd/taada/core/PreferencesHelper$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "LN1/m;", "initialize", "(Landroid/content/Context;)V", "Lfr/sd/taada/core/PreferencesHelper;", "getInstance", "()Lfr/sd/taada/core/PreferencesHelper;", "", "isInitialized", "()Z", "", "TAG", "Ljava/lang/String;", "PREFS_FILE_NAME", "KEY_JWT_TOKEN", "KEY_DEVICE_ID", "KEY_ATTRIBUTION_SOURCE", "KEY_ATTRIBUTION_CAMPAIGN", "KEY_ATTRIBUTION_SENT", "KEY_LAST_KNOWN_STEP", "KEY_TELEMETRY_ENABLED", "instance", "Lfr/sd/taada/core/PreferencesHelper;", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PreferencesHelper getInstance() {
            PreferencesHelper preferencesHelper = PreferencesHelper.instance;
            if (preferencesHelper != null) {
                return preferencesHelper;
            }
            throw new IllegalStateException("PreferencesHelper not initialized. Call initialize() first.");
        }

        @JvmStatic
        public final void initialize(@NotNull Context context) {
            h.f(context, "context");
            synchronized (this) {
                if (PreferencesHelper.instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    h.e(applicationContext, "getApplicationContext(...)");
                    PreferencesHelper.instance = new PreferencesHelper(applicationContext, null);
                }
            }
        }

        @JvmStatic
        public final boolean isInitialized() {
            return PreferencesHelper.instance != null;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PreferencesHelper(Context context, d dVar) {
        this(context);
    }

    public static /* synthetic */ boolean getBoolean$default(PreferencesHelper preferencesHelper, String str, boolean z6, int i, Object obj) {
        if ((i & 2) != 0) {
            z6 = false;
        }
        return preferencesHelper.getBoolean(str, z6);
    }

    @JvmStatic
    @NotNull
    public static final PreferencesHelper getInstance() {
        return INSTANCE.getInstance();
    }

    public static /* synthetic */ String getString$default(PreferencesHelper preferencesHelper, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return preferencesHelper.getString(str, str2);
    }

    @JvmStatic
    public static final void initialize(@NotNull Context context) {
        INSTANCE.initialize(context);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return INSTANCE.isInitialized();
    }

    public final void clearAll() {
        this.prefs.edit().clear().apply();
        Log.w(TAG, "All preferences cleared");
    }

    @Nullable
    public final String getAttributionSource() {
        return getString$default(this, KEY_ATTRIBUTION_SOURCE, null, 2, null);
    }

    public final boolean getBoolean(@NotNull String key, boolean z6) {
        h.f(key, "key");
        return this.prefs.getBoolean(key, z6);
    }

    @Nullable
    public final String getDeviceId() {
        return getString$default(this, KEY_DEVICE_ID, null, 2, null);
    }

    @Nullable
    public final String getLastKnownStep() {
        return getString$default(this, KEY_LAST_KNOWN_STEP, null, 2, null);
    }

    @NotNull
    public final String getOrCreateDeviceId() {
        String deviceId = getDeviceId();
        if (deviceId != null) {
            return deviceId;
        }
        String string = UUID.randomUUID().toString();
        h.e(string, "toString(...)");
        setDeviceId(string);
        return string;
    }

    @Nullable
    public final String getString(@NotNull String key, @Nullable String str) {
        h.f(key, "key");
        return this.prefs.getString(key, str);
    }

    @Nullable
    public final String getToken() {
        return getString$default(this, KEY_JWT_TOKEN, null, 2, null);
    }

    public final boolean hasToken() {
        return getToken() != null;
    }

    public final boolean isAttributionSent() {
        return getBoolean(KEY_ATTRIBUTION_SENT, false);
    }

    public final boolean isTelemetryEnabled() {
        return getBoolean(KEY_TELEMETRY_ENABLED, true);
    }

    public final void markAttributionSent() {
        setBoolean(KEY_ATTRIBUTION_SENT, true);
    }

    public final void setAttributionSource(@NotNull String source) {
        h.f(source, "source");
        if (getAttributionSource() == null) {
            setString(KEY_ATTRIBUTION_SOURCE, source);
        }
    }

    public final void setBoolean(@NotNull String key, boolean value) {
        h.f(key, "key");
        this.prefs.edit().putBoolean(key, value).apply();
    }

    public final void setDeviceId(@NotNull String deviceId) {
        h.f(deviceId, "deviceId");
        setString(KEY_DEVICE_ID, deviceId);
    }

    public final void setLastKnownStep(@NotNull String step) {
        h.f(step, "step");
        setString(KEY_LAST_KNOWN_STEP, step);
    }

    public final void setString(@NotNull String key, @Nullable String value) {
        h.f(key, "key");
        this.prefs.edit().putString(key, value).apply();
        if (value != null) {
            i.W(10, value);
        }
    }

    public final void setTelemetryEnabled(boolean enabled) {
        setBoolean(KEY_TELEMETRY_ENABLED, enabled);
    }

    public final void setToken(@NotNull String token) {
        h.f(token, "token");
        setString(KEY_JWT_TOKEN, token);
    }

    private PreferencesHelper(Context context) {
        MasterKey masterKeyBuild = new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        h.e(masterKeyBuild, "build(...)");
        this.prefs = EncryptedSharedPreferences.create(context, PREFS_FILE_NAME, masterKeyBuild, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
    }
}
