package fr.sd.taada.analytics.attribution;

import androidx.constraintlayout.core.motion.a;
import fr.sd.taada.core.PreferencesHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lfr/sd/taada/analytics/attribution/AttributionRequest;", "", PreferencesHelper.KEY_DEVICE_ID, "", "source", "utm_source", "utm_medium", "utm_campaign", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDevice_id", "()Ljava/lang/String;", "getSource", "getUtm_source", "getUtm_medium", "getUtm_campaign", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AttributionRequest {

    @NotNull
    private final String device_id;

    @NotNull
    private final String source;

    @Nullable
    private final String utm_campaign;

    @Nullable
    private final String utm_medium;

    @Nullable
    private final String utm_source;

    public AttributionRequest(@NotNull String device_id, @NotNull String source, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        h.f(device_id, "device_id");
        h.f(source, "source");
        this.device_id = device_id;
        this.source = source;
        this.utm_source = str;
        this.utm_medium = str2;
        this.utm_campaign = str3;
    }

    public static /* synthetic */ AttributionRequest copy$default(AttributionRequest attributionRequest, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attributionRequest.device_id;
        }
        if ((i & 2) != 0) {
            str2 = attributionRequest.source;
        }
        if ((i & 4) != 0) {
            str3 = attributionRequest.utm_source;
        }
        if ((i & 8) != 0) {
            str4 = attributionRequest.utm_medium;
        }
        if ((i & 16) != 0) {
            str5 = attributionRequest.utm_campaign;
        }
        String str6 = str5;
        String str7 = str3;
        return attributionRequest.copy(str, str2, str7, str4, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUtm_source() {
        return this.utm_source;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUtm_medium() {
        return this.utm_medium;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUtm_campaign() {
        return this.utm_campaign;
    }

    @NotNull
    public final AttributionRequest copy(@NotNull String device_id, @NotNull String source, @Nullable String utm_source, @Nullable String utm_medium, @Nullable String utm_campaign) {
        h.f(device_id, "device_id");
        h.f(source, "source");
        return new AttributionRequest(device_id, source, utm_source, utm_medium, utm_campaign);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttributionRequest)) {
            return false;
        }
        AttributionRequest attributionRequest = (AttributionRequest) other;
        return h.a(this.device_id, attributionRequest.device_id) && h.a(this.source, attributionRequest.source) && h.a(this.utm_source, attributionRequest.utm_source) && h.a(this.utm_medium, attributionRequest.utm_medium) && h.a(this.utm_campaign, attributionRequest.utm_campaign);
    }

    @NotNull
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getUtm_campaign() {
        return this.utm_campaign;
    }

    @Nullable
    public final String getUtm_medium() {
        return this.utm_medium;
    }

    @Nullable
    public final String getUtm_source() {
        return this.utm_source;
    }

    public int hashCode() {
        int iC = a.c(this.device_id.hashCode() * 31, 31, this.source);
        String str = this.utm_source;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.utm_medium;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.utm_campaign;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AttributionRequest(device_id=");
        sb.append(this.device_id);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(", utm_source=");
        sb.append(this.utm_source);
        sb.append(", utm_medium=");
        sb.append(this.utm_medium);
        sb.append(", utm_campaign=");
        return a.s(sb, this.utm_campaign, ')');
    }

    public /* synthetic */ AttributionRequest(String str, String str2, String str3, String str4, String str5, int i, d dVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }
}
