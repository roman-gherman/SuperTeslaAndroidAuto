package fr.sd.taada.analytics.attribution.mmp;

import N1.m;
import R0.h;
import android.content.Context;
import android.util.Log;
import fr.sd.taada.analytics.attribution.AttributionData;
import fr.sd.taada.analytics.attribution.AttributionSource;
import fr.sd.taada.analytics.attribution.IAttributionService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!¨\u0006$"}, d2 = {"Lfr/sd/taada/analytics/attribution/mmp/TenjinAttributionService;", "Lfr/sd/taada/analytics/attribution/IAttributionService;", "Landroid/content/Context;", "context", "", "apiKey", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Ljava/lang/String;)V", "LN1/m;", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfr/sd/taada/analytics/attribution/AttributionData;", "fetchAttribution", "", "isAttributionFetched", "()Z", "planType", "logTrialStarted", "(Ljava/lang/String;)V", "", "revenue", "currency", "productId", "logPurchase", "(DLjava/lang/String;Ljava/lang/String;)V", "logStreamSuccess", "()V", "Landroid/content/Context;", "Ljava/lang/String;", "LR0/h;", "tenjinInstance", "LR0/h;", "initialized", "Z", "attributionFetched", "Companion", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TenjinAttributionService implements IAttributionService {

    @NotNull
    private static final String TAG = "Attribution/Tenjin";

    @NotNull
    private final String apiKey;
    private boolean attributionFetched;

    @NotNull
    private final Context context;
    private boolean initialized;

    @Nullable
    private h tenjinInstance;

    public TenjinAttributionService(@NotNull Context context, @NotNull String apiKey) {
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(apiKey, "apiKey");
        this.context = context;
        this.apiKey = apiKey;
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    @Nullable
    public Object fetchAttribution(@NotNull Continuation<? super AttributionData> continuation) {
        this.attributionFetched = true;
        return new AttributionData(AttributionSource.OTHER_PAID, null, null, null, "tenjin-mmp", 0L, 46, null);
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    @Nullable
    public Object initialize(@NotNull Continuation<? super m> continuation) {
        boolean z6 = this.initialized;
        m mVar = m.f1129a;
        if (!z6) {
            try {
                h hVarP = h.p(this.context, this.apiKey);
                this.tenjinInstance = hVarP;
                if (hVarP != null) {
                    hVarP.j();
                }
                this.initialized = true;
                return mVar;
            } catch (Exception e) {
                Log.e(TAG, "Failed to initialize Tenjin SDK", e);
            }
        }
        return mVar;
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    /* JADX INFO: renamed from: isAttributionFetched, reason: from getter */
    public boolean getAttributionFetched() {
        return this.attributionFetched;
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    public void logPurchase(double revenue, @NotNull String currency, @NotNull String productId) {
        kotlin.jvm.internal.h.f(currency, "currency");
        kotlin.jvm.internal.h.f(productId, "productId");
        h hVar = this.tenjinInstance;
        if (hVar == null) {
            Log.w(TAG, "Tenjin not initialized, skipping purchase log for: ".concat(productId));
        } else {
            hVar.w(productId, currency, 1, revenue);
        }
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    public void logStreamSuccess() {
        h hVar = this.tenjinInstance;
        if (hVar == null) {
            Log.w(TAG, "Tenjin not initialized, skipping stream_success log");
        } else {
            hVar.l("stream_success");
        }
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    public void logTrialStarted(@NotNull String planType) {
        kotlin.jvm.internal.h.f(planType, "planType");
        h hVar = this.tenjinInstance;
        if (hVar == null) {
            Log.w(TAG, "Tenjin not initialized, skipping trial_started log");
        } else {
            hVar.l("trial_started_".concat(planType));
        }
    }
}
