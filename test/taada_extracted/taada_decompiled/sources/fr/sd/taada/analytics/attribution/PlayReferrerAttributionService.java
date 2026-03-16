package fr.sd.taada.analytics.attribution;

import N1.e;
import N1.m;
import T1.a;
import U1.g;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import fr.sd.taada.analytics.attribution.IAttributionService;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.A;
import kotlin.collections.v;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlin.text.i;
import kotlin.text.r;
import kotlinx.coroutines.CoroutineScope;
import m3.AbstractC0690y;
import m3.G;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0014\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lfr/sd/taada/analytics/attribution/PlayReferrerAttributionService;", "Lfr/sd/taada/analytics/attribution/IAttributionService;", "Landroid/content/Context;", "context", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;)V", "", "getReferrerFromPlayStore", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "referrer", "Lfr/sd/taada/analytics/attribution/AttributionData;", "parseReferrer", "(Ljava/lang/String;)Lfr/sd/taada/analytics/attribution/AttributionData;", "utmSource", "utmMedium", "Lfr/sd/taada/analytics/attribution/AttributionSource;", "classifySource", "(Ljava/lang/String;Ljava/lang/String;)Lfr/sd/taada/analytics/attribution/AttributionSource;", "LN1/m;", "initialize", "fetchAttribution", "", "isAttributionFetched", "()Z", "Landroid/content/Context;", "fetched", "Z", "cachedData", "Lfr/sd/taada/analytics/attribution/AttributionData;", "Companion", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayReferrerAttributionService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayReferrerAttributionService.kt\nfr/sd/taada/analytics/attribution/PlayReferrerAttributionService\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,158:1\n314#2,11:159\n*S KotlinDebug\n*F\n+ 1 PlayReferrerAttributionService.kt\nfr/sd/taada/analytics/attribution/PlayReferrerAttributionService\n*L\n62#1:159,11\n*E\n"})
public final class PlayReferrerAttributionService implements IAttributionService {

    @NotNull
    private static final String TAG = "Attribution/PlayReferrer";

    @Nullable
    private AttributionData cachedData;

    @NotNull
    private final Context context;
    private volatile boolean fetched;

    /* JADX INFO: renamed from: fr.sd.taada.analytics.attribution.PlayReferrerAttributionService$fetchAttribution$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lfr/sd/taada/analytics/attribution/AttributionData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "fr.sd.taada.analytics.attribution.PlayReferrerAttributionService$fetchAttribution$2", f = "PlayReferrerAttributionService.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends g implements Function2<CoroutineScope, Continuation<? super AttributionData>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // U1.a
        public final Continuation<m> create(Object obj, Continuation<?> continuation) {
            return PlayReferrerAttributionService.this.new AnonymousClass2(continuation);
        }

        @Override // U1.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f1304a;
            int i = this.label;
            try {
                if (i == 0) {
                    l.e0(obj);
                    if (PlayReferrerAttributionService.this.cachedData != null) {
                        AttributionData attributionData = PlayReferrerAttributionService.this.cachedData;
                        h.c(attributionData);
                        return attributionData;
                    }
                    PlayReferrerAttributionService playReferrerAttributionService = PlayReferrerAttributionService.this;
                    this.label = 1;
                    obj = playReferrerAttributionService.getReferrerFromPlayStore(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.e0(obj);
                }
                AttributionData referrer = PlayReferrerAttributionService.this.parseReferrer((String) obj);
                PlayReferrerAttributionService.this.cachedData = referrer;
                PlayReferrerAttributionService.this.fetched = true;
                Objects.toString(referrer.getSource());
                return referrer;
            } catch (Exception e) {
                Log.e(PlayReferrerAttributionService.TAG, "Failed to fetch attribution", e);
                AttributionData attributionData2 = new AttributionData(AttributionSource.UNKNOWN, null, null, null, "error: " + e.getMessage(), 0L, 46, null);
                PlayReferrerAttributionService playReferrerAttributionService2 = PlayReferrerAttributionService.this;
                playReferrerAttributionService2.cachedData = attributionData2;
                playReferrerAttributionService2.fetched = true;
                return attributionData2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(CoroutineScope coroutineScope, Continuation<? super AttributionData> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(m.f1129a);
        }
    }

    public PlayReferrerAttributionService(@NotNull Context context) {
        h.f(context, "context");
        this.context = context;
    }

    private final AttributionSource classifySource(String utmSource, String utmMedium) {
        return (utmSource == null && utmMedium == null) ? AttributionSource.ORGANIC : (utmSource == null || !i.D(utmSource, "google", true)) ? (utmSource == null || !i.D(utmSource, "facebook", true)) ? (utmMedium == null || !i.D(utmMedium, "cpc", true)) ? (utmMedium == null || !i.D(utmMedium, "paid", true)) ? AttributionSource.UNKNOWN : AttributionSource.OTHER_PAID : AttributionSource.OTHER_PAID : AttributionSource.FACEBOOK : AttributionSource.GOOGLE_ADS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.android.installreferrer.api.InstallReferrerStateListener, fr.sd.taada.analytics.attribution.PlayReferrerAttributionService$getReferrerFromPlayStore$2$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getReferrerFromPlayStore(kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.analytics.attribution.PlayReferrerAttributionService.getReferrerFromPlayStore(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AttributionData parseReferrer(String referrer) {
        Map mapI;
        if (referrer == null || r.y(referrer)) {
            return new AttributionData(AttributionSource.ORGANIC, null, null, null, null, 0L, 62, null);
        }
        try {
            Uri uri = Uri.parse("https://dummy.com?" + referrer);
            mapI = A.I(new e("utm_source", uri.getQueryParameter("utm_source")), new e("utm_medium", uri.getQueryParameter("utm_medium")), new e("utm_campaign", uri.getQueryParameter("utm_campaign")));
        } catch (Exception unused) {
            Log.w(TAG, "Failed to parse referrer: " + referrer);
            mapI = v.f3805a;
        }
        String str = (String) mapI.get("utm_source");
        String str2 = (String) mapI.get("utm_medium");
        return new AttributionData(classifySource(str, str2), str, str2, (String) mapI.get("utm_campaign"), referrer, 0L, 32, null);
    }

    @Override // fr.sd.taada.analytics.attribution.IAttributionService
    @Nullable
    public Object fetchAttribution(@NotNull Continuation<? super AttributionData> continuation) {
        return AbstractC0690y.m(G.c, new AnonymousClass2(null), continuation);
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
