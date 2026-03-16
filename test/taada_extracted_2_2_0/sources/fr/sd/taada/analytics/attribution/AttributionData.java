package fr.sd.taada.analytics.attribution;

import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lfr/sd/taada/analytics/attribution/AttributionData;", "", "source", "Lfr/sd/taada/analytics/attribution/AttributionSource;", "utmSource", "", "utmMedium", "utmCampaign", "rawReferrer", "timestamp", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lfr/sd/taada/analytics/attribution/AttributionSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getSource", "()Lfr/sd/taada/analytics/attribution/AttributionSource;", "getUtmSource", "()Ljava/lang/String;", "getUtmMedium", "getUtmCampaign", "getRawReferrer", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AttributionData {

    @Nullable
    private final String rawReferrer;

    @NotNull
    private final AttributionSource source;
    private final long timestamp;

    @Nullable
    private final String utmCampaign;

    @Nullable
    private final String utmMedium;

    @Nullable
    private final String utmSource;

    public AttributionData(@NotNull AttributionSource source, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j6) {
        h.f(source, "source");
        this.source = source;
        this.utmSource = str;
        this.utmMedium = str2;
        this.utmCampaign = str3;
        this.rawReferrer = str4;
        this.timestamp = j6;
    }

    public static /* synthetic */ AttributionData copy$default(AttributionData attributionData, AttributionSource attributionSource, String str, String str2, String str3, String str4, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            attributionSource = attributionData.source;
        }
        if ((i & 2) != 0) {
            str = attributionData.utmSource;
        }
        if ((i & 4) != 0) {
            str2 = attributionData.utmMedium;
        }
        if ((i & 8) != 0) {
            str3 = attributionData.utmCampaign;
        }
        if ((i & 16) != 0) {
            str4 = attributionData.rawReferrer;
        }
        if ((i & 32) != 0) {
            j6 = attributionData.timestamp;
        }
        long j7 = j6;
        String str5 = str4;
        String str6 = str2;
        return attributionData.copy(attributionSource, str, str6, str3, str5, j7);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AttributionSource getSource() {
        return this.source;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUtmSource() {
        return this.utmSource;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUtmMedium() {
        return this.utmMedium;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUtmCampaign() {
        return this.utmCampaign;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRawReferrer() {
        return this.rawReferrer;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final AttributionData copy(@NotNull AttributionSource source, @Nullable String utmSource, @Nullable String utmMedium, @Nullable String utmCampaign, @Nullable String rawReferrer, long timestamp) {
        h.f(source, "source");
        return new AttributionData(source, utmSource, utmMedium, utmCampaign, rawReferrer, timestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttributionData)) {
            return false;
        }
        AttributionData attributionData = (AttributionData) other;
        return this.source == attributionData.source && h.a(this.utmSource, attributionData.utmSource) && h.a(this.utmMedium, attributionData.utmMedium) && h.a(this.utmCampaign, attributionData.utmCampaign) && h.a(this.rawReferrer, attributionData.rawReferrer) && this.timestamp == attributionData.timestamp;
    }

    @Nullable
    public final String getRawReferrer() {
        return this.rawReferrer;
    }

    @NotNull
    public final AttributionSource getSource() {
        return this.source;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getUtmCampaign() {
        return this.utmCampaign;
    }

    @Nullable
    public final String getUtmMedium() {
        return this.utmMedium;
    }

    @Nullable
    public final String getUtmSource() {
        return this.utmSource;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.utmSource;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.utmMedium;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.utmCampaign;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rawReferrer;
        return Long.hashCode(this.timestamp) + ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        return "AttributionData(source=" + this.source + ", utmSource=" + this.utmSource + ", utmMedium=" + this.utmMedium + ", utmCampaign=" + this.utmCampaign + ", rawReferrer=" + this.rawReferrer + ", timestamp=" + this.timestamp + ')';
    }

    public /* synthetic */ AttributionData(AttributionSource attributionSource, String str, String str2, String str3, String str4, long j6, int i, d dVar) {
        this(attributionSource, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? System.currentTimeMillis() : j6);
    }
}
