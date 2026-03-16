package fr.sd.taada.core.auth;

import U1.g;
import android.content.Context;
import android.util.Log;
import com.google.gson.m;
import fr.sd.taada.core.AnalyticsHttpClient;
import fr.sd.taada.core.PreferencesHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlin.text.i;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0690y;
import m3.G;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lfr/sd/taada/core/auth/AuthManager;", "", "", "baseUrl", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;)V", "", "isRegistered", "()Z", "ensureRegistered", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDevice", "getToken", "()Ljava/lang/String;", "LN1/m;", "clearAuth", "()V", "Ljava/lang/String;", "Lcom/google/gson/m;", "gson", "Lcom/google/gson/m;", "Companion", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuthManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENDPOINT_REGISTER = "/api/v1/auth/device";

    @NotNull
    private static final String TAG = "Core/AuthManager";

    @Nullable
    private static volatile AuthManager instance;

    @NotNull
    private final String baseUrl;

    @NotNull
    private final m gson;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lfr/sd/taada/core/auth/AuthManager$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "Landroid/content/Context;", "context", "", "baseUrl", "LN1/m;", "initialize", "(Landroid/content/Context;Ljava/lang/String;)V", "Lfr/sd/taada/core/auth/AuthManager;", "getInstance", "()Lfr/sd/taada/core/auth/AuthManager;", "", "isInitialized", "()Z", "TAG", "Ljava/lang/String;", "ENDPOINT_REGISTER", "instance", "Lfr/sd/taada/core/auth/AuthManager;", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String initialize$lambda$1$lambda$0() {
            return PreferencesHelper.INSTANCE.getInstance().getToken();
        }

        @NotNull
        public final AuthManager getInstance() {
            AuthManager authManager = AuthManager.instance;
            if (authManager != null) {
                return authManager;
            }
            throw new IllegalStateException("AuthManager not initialized. Call initialize() first.");
        }

        public final void initialize(@NotNull Context context, @NotNull String baseUrl) {
            h.f(context, "context");
            h.f(baseUrl, "baseUrl");
            synchronized (this) {
                try {
                    if (AuthManager.instance == null) {
                        PreferencesHelper.Companion companion = PreferencesHelper.INSTANCE;
                        if (!companion.isInitialized()) {
                            companion.initialize(context);
                        }
                        AnalyticsHttpClient.Companion companion2 = AnalyticsHttpClient.INSTANCE;
                        if (!companion2.isInitialized()) {
                            companion2.initialize(baseUrl, new a());
                        }
                        AuthManager.instance = new AuthManager(baseUrl, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean isInitialized() {
            return AuthManager.instance != null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: fr.sd.taada.core.auth.AuthManager$registerDevice$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.core.auth.AuthManager$registerDevice$2", f = "AuthManager.kt", i = {0}, l = {99}, m = "invokeSuspend", n = {"prefs"}, s = {"L$0"})
    public static final class AnonymousClass2 extends g implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // U1.a
        public final Continuation<N1.m> create(Object obj, Continuation<?> continuation) {
            return AuthManager.this.new AnonymousClass2(continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            PreferencesHelper preferencesHelper;
            Object obj2;
            T1.a aVar = T1.a.f1304a;
            int i = this.label;
            boolean z6 = false;
            try {
                if (i == 0) {
                    l.e0(obj);
                    PreferencesHelper companion = PreferencesHelper.INSTANCE.getInstance();
                    String orCreateDeviceId = companion.getOrCreateDeviceId();
                    i.W(8, orCreateDeviceId);
                    DeviceRegistrationRequest deviceRegistrationRequest = new DeviceRegistrationRequest(orCreateDeviceId);
                    AnalyticsHttpClient companion2 = AnalyticsHttpClient.INSTANCE.getInstance();
                    this.L$0 = companion;
                    this.label = 1;
                    Object objM91postRaw0E7RQCE = companion2.m91postRaw0E7RQCE(AuthManager.ENDPOINT_REGISTER, deviceRegistrationRequest, this);
                    if (objM91postRaw0E7RQCE == aVar) {
                        return aVar;
                    }
                    preferencesHelper = companion;
                    obj2 = objM91postRaw0E7RQCE;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    preferencesHelper = (PreferencesHelper) this.L$0;
                    l.e0(obj);
                    obj2 = ((N1.h) obj).f1124a;
                }
                AuthManager authManager = AuthManager.this;
                Throwable thA = N1.h.a(obj2);
                if (thA == null) {
                    try {
                        preferencesHelper.setToken(((DeviceRegistrationResponse) authManager.gson.d((String) obj2)).getToken());
                        z6 = true;
                    } catch (Exception e) {
                        Log.e(AuthManager.TAG, "Failed to parse registration response", e);
                    }
                } else {
                    Log.e(AuthManager.TAG, "Device registration failed: " + thA.getMessage());
                }
            } catch (Exception e6) {
                Log.e(AuthManager.TAG, "Unexpected error during registration", e6);
            }
            return Boolean.valueOf(z6);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(N1.m.f1129a);
        }
    }

    public /* synthetic */ AuthManager(String str, d dVar) {
        this(str);
    }

    public final void clearAuth() {
        PreferencesHelper.INSTANCE.getInstance().setString(PreferencesHelper.KEY_JWT_TOKEN, null);
    }

    @Nullable
    public final Object ensureRegistered(@NotNull Continuation<? super Boolean> continuation) {
        return isRegistered() ? Boolean.TRUE : registerDevice(continuation);
    }

    @Nullable
    public final String getToken() {
        return PreferencesHelper.INSTANCE.getInstance().getToken();
    }

    public final boolean isRegistered() {
        return PreferencesHelper.INSTANCE.getInstance().hasToken();
    }

    @Nullable
    public final Object registerDevice(@NotNull Continuation<? super Boolean> continuation) {
        return AbstractC0690y.m(G.c, new AnonymousClass2(null), continuation);
    }

    private AuthManager(String str) {
        this.baseUrl = str;
        this.gson = new m();
    }
}
