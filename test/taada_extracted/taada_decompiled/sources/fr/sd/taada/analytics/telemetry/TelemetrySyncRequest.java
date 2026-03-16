package fr.sd.taada.analytics.telemetry;

import fr.sd.taada.core.PreferencesHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetrySyncRequest;", "", PreferencesHelper.KEY_DEVICE_ID, "", "events", "", "Lfr/sd/taada/analytics/telemetry/TelemetryEventDto;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/util/List;)V", "getDevice_id", "()Ljava/lang/String;", "getEvents", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class TelemetrySyncRequest {

    @NotNull
    private final String device_id;

    @NotNull
    private final List<TelemetryEventDto> events;

    public TelemetrySyncRequest(@NotNull String device_id, @NotNull List<TelemetryEventDto> events) {
        h.f(device_id, "device_id");
        h.f(events, "events");
        this.device_id = device_id;
        this.events = events;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TelemetrySyncRequest copy$default(TelemetrySyncRequest telemetrySyncRequest, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = telemetrySyncRequest.device_id;
        }
        if ((i & 2) != 0) {
            list = telemetrySyncRequest.events;
        }
        return telemetrySyncRequest.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    public final List<TelemetryEventDto> component2() {
        return this.events;
    }

    @NotNull
    public final TelemetrySyncRequest copy(@NotNull String device_id, @NotNull List<TelemetryEventDto> events) {
        h.f(device_id, "device_id");
        h.f(events, "events");
        return new TelemetrySyncRequest(device_id, events);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetrySyncRequest)) {
            return false;
        }
        TelemetrySyncRequest telemetrySyncRequest = (TelemetrySyncRequest) other;
        return h.a(this.device_id, telemetrySyncRequest.device_id) && h.a(this.events, telemetrySyncRequest.events);
    }

    @NotNull
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    public final List<TelemetryEventDto> getEvents() {
        return this.events;
    }

    public int hashCode() {
        return this.events.hashCode() + (this.device_id.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "TelemetrySyncRequest(device_id=" + this.device_id + ", events=" + this.events + ')';
    }
}
