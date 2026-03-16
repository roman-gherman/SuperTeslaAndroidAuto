package fr.sd.taada.analytics.attribution;

import C5.f;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lfr/sd/taada/analytics/attribution/AttributionSource;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;I)V", "ORGANIC", "GOOGLE_ADS", "FACEBOOK", "OTHER_PAID", "UNKNOWN", "attribution_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AttributionSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AttributionSource[] $VALUES;
    public static final AttributionSource ORGANIC = new AttributionSource("ORGANIC", 0);
    public static final AttributionSource GOOGLE_ADS = new AttributionSource("GOOGLE_ADS", 1);
    public static final AttributionSource FACEBOOK = new AttributionSource("FACEBOOK", 2);
    public static final AttributionSource OTHER_PAID = new AttributionSource("OTHER_PAID", 3);
    public static final AttributionSource UNKNOWN = new AttributionSource("UNKNOWN", 4);

    private static final /* synthetic */ AttributionSource[] $values() {
        return new AttributionSource[]{ORGANIC, GOOGLE_ADS, FACEBOOK, OTHER_PAID, UNKNOWN};
    }

    static {
        AttributionSource[] attributionSourceArr$values = $values();
        $VALUES = attributionSourceArr$values;
        $ENTRIES = f.w(attributionSourceArr$values);
    }

    private AttributionSource(String str, int i) {
    }

    @NotNull
    public static EnumEntries<AttributionSource> getEntries() {
        return $ENTRIES;
    }

    public static AttributionSource valueOf(String str) {
        return (AttributionSource) Enum.valueOf(AttributionSource.class, str);
    }

    public static AttributionSource[] values() {
        return (AttributionSource[]) $VALUES.clone();
    }
}
