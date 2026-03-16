package fr.sd.taada.analytics.attribution;

import N1.m;
import fr.sd.taada.analytics.attribution.IAttributionService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lfr/sd/taada/analytics/attribution/DummyAttributionService;", "Lfr/sd/taada/analytics/attribution/IAttributionService;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "LN1/m;", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfr/sd/taada/analytics/attribution/AttributionData;", "fetchAttribution", "", "isAttributionFetched", "()Z", "fetched", "Z", "Companion", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DummyAttributionService implements IAttributionService {

    @NotNull
    private static final String TAG = "Attribution/Dummy";
    private volatile boolean fetched;

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    @Nullable
    public Object fetchAttribution(@NotNull Continuation<? super AttributionData> continuation) {
        this.fetched = true;
        return new AttributionData(AttributionSource.ORGANIC, null, null, null, "dummy_service", 0L, 46, null);
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    @Nullable
    public Object initialize(@NotNull Continuation<? super m> continuation) {
        return m.f1129a;
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    /* JADX INFO: renamed from: isAttributionFetched, reason: from getter */
    public boolean getFetched() {
        return this.fetched;
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    public void logPurchase(double d, @NotNull String str, @NotNull String str2) {
        IAttributionService.DefaultImpls.logPurchase(this, d, str, str2);
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    public void logStreamSuccess() {
        IAttributionService.DefaultImpls.logStreamSuccess(this);
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    public void logTrialStarted(@NotNull String str) {
        IAttributionService.DefaultImpls.logTrialStarted(this, str);
    }
}
