package fr.sd.taada.analytics.attribution;

import N1.m;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lfr/sd/taada/analytics/attribution/IAttributionService;", "", "LN1/m;", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfr/sd/taada/analytics/attribution/AttributionData;", "fetchAttribution", "", "isAttributionFetched", "()Z", "", "planType", "logTrialStarted", "(Ljava/lang/String;)V", "", "revenue", "currency", "productId", "logPurchase", "(DLjava/lang/String;Ljava/lang/String;)V", "logStreamSuccess", "()V", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAttributionService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void logPurchase(@NotNull IAttributionService iAttributionService, double d, @NotNull String currency, @NotNull String productId) {
            h.f(currency, "currency");
            h.f(productId, "productId");
        }

        public static void logStreamSuccess(@NotNull IAttributionService iAttributionService) {
        }

        public static void logTrialStarted(@NotNull IAttributionService iAttributionService, @NotNull String planType) {
            h.f(planType, "planType");
        }
    }

    @Nullable
    Object fetchAttribution(@NotNull Continuation<? super AttributionData> continuation);

    @Nullable
    Object initialize(@NotNull Continuation<? super m> continuation);

    boolean isAttributionFetched();

    void logPurchase(double revenue, @NotNull String currency, @NotNull String productId);

    void logStreamSuccess();

    void logTrialStarted(@NotNull String planType);
}
