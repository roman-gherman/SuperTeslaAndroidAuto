package fr.sd.taada.analytics.telemetry;

import N1.e;
import android.util.Log;
import android.view.DefaultLifecycleObserver;
import android.view.LifecycleOwner;
import android.view.ProcessLifecycleOwner;
import androidx.core.os.EnvironmentCompat;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.core.PreferencesHelper;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.collections.B;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lfr/sd/taada/analytics/telemetry/FailureStateDetector;", "Landroidx/lifecycle/DefaultLifecycleObserver;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "", "step", "LN1/m;", "updateCurrentStep", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onStart", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "getLastKnownStep", "()Ljava/lang/String;", "currentStep", "Ljava/lang/String;", "Companion", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FailureStateDetector implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "Telemetry/FailureState";

    @Nullable
    private static volatile FailureStateDetector instance;

    @NotNull
    private String currentStep;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lfr/sd/taada/analytics/telemetry/FailureStateDetector$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "LN1/m;", "initialize", "Lfr/sd/taada/analytics/telemetry/FailureStateDetector;", "getInstance", "()Lfr/sd/taada/analytics/telemetry/FailureStateDetector;", "", "isInitialized", "()Z", "", "TAG", "Ljava/lang/String;", "instance", "Lfr/sd/taada/analytics/telemetry/FailureStateDetector;", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(d dVar) {
            this();
        }

        @NotNull
        public final FailureStateDetector getInstance() {
            FailureStateDetector failureStateDetector = FailureStateDetector.instance;
            if (failureStateDetector != null) {
                return failureStateDetector;
            }
            throw new IllegalStateException("FailureStateDetector not initialized. Call initialize() first.");
        }

        public final void initialize() {
            synchronized (this) {
                if (FailureStateDetector.instance == null) {
                    FailureStateDetector failureStateDetector = new FailureStateDetector(null);
                    ProcessLifecycleOwner.INSTANCE.get().getLifecycle().addObserver(failureStateDetector);
                    FailureStateDetector.instance = failureStateDetector;
                }
            }
        }

        public final boolean isInitialized() {
            return FailureStateDetector.instance != null;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FailureStateDetector(d dVar) {
        this();
    }

    @Nullable
    public final String getLastKnownStep() {
        try {
            return PreferencesHelper.INSTANCE.getInstance().getLastKnownStep();
        } catch (Exception e) {
            Log.w(TAG, "Failed to get last known step", e);
            return null;
        }
    }

    @Override // android.view.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        h.f(owner, "owner");
        TelemetryManager.Companion companion = TelemetryManager.INSTANCE;
        if (companion.isInitialized()) {
            companion.getInstance().log(FunnelEvent.APP_OPENED, B.G(new e("from_background", Boolean.TRUE)));
        }
    }

    @Override // android.view.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        h.f(owner, "owner");
        try {
            PreferencesHelper.Companion companion = PreferencesHelper.INSTANCE;
            if (companion.isInitialized()) {
                companion.getInstance().setLastKnownStep(this.currentStep);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to persist last step", e);
        }
        TelemetryManager.Companion companion2 = TelemetryManager.INSTANCE;
        if (companion2.isInitialized()) {
            companion2.getInstance().log(FunnelEvent.APP_OPENED, A.I(new e("backgrounded", Boolean.TRUE), new e("last_step", this.currentStep)));
        }
    }

    public final void updateCurrentStep(@NotNull String step) {
        h.f(step, "step");
        this.currentStep = step;
    }

    private FailureStateDetector() {
        this.currentStep = EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
