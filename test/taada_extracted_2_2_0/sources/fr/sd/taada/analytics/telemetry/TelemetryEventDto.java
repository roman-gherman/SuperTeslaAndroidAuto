package fr.sd.taada.analytics.telemetry;

import com.google.gson.p;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryEventDto;", "", "", "event_type", "", "timestamp", "Lcom/google/gson/p;", "metadata", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;JLcom/google/gson/p;)V", "component1", "()Ljava/lang/String;", "component2", "()J", "component3", "()Lcom/google/gson/p;", "copy", "(Ljava/lang/String;JLcom/google/gson/p;)Lfr/sd/taada/analytics/telemetry/TelemetryEventDto;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEvent_type", "J", "getTimestamp", "Lcom/google/gson/p;", "getMetadata", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class TelemetryEventDto {

    @NotNull
    private final String event_type;

    @Nullable
    private final p metadata;
    private final long timestamp;

    public TelemetryEventDto(@NotNull String event_type, long j6, @Nullable p pVar) {
        h.f(event_type, "event_type");
        this.event_type = event_type;
        this.timestamp = j6;
        this.metadata = pVar;
    }

    public static /* synthetic */ TelemetryEventDto copy$default(TelemetryEventDto telemetryEventDto, String str, long j6, p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = telemetryEventDto.event_type;
        }
        if ((i & 2) != 0) {
            j6 = telemetryEventDto.timestamp;
        }
        if ((i & 4) != 0) {
            pVar = telemetryEventDto.metadata;
        }
        return telemetryEventDto.copy(str, j6, pVar);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEvent_type() {
        return this.event_type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final p getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final TelemetryEventDto copy(@NotNull String event_type, long timestamp, @Nullable p metadata) {
        h.f(event_type, "event_type");
        return new TelemetryEventDto(event_type, timestamp, metadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetryEventDto)) {
            return false;
        }
        TelemetryEventDto telemetryEventDto = (TelemetryEventDto) other;
        return h.a(this.event_type, telemetryEventDto.event_type) && this.timestamp == telemetryEventDto.timestamp && h.a(this.metadata, telemetryEventDto.metadata);
    }

    @NotNull
    public final String getEvent_type() {
        return this.event_type;
    }

    @Nullable
    public final p getMetadata() {
        return this.metadata;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(this.timestamp) + (this.event_type.hashCode() * 31)) * 31;
        p pVar = this.metadata;
        return iHashCode + (pVar == null ? 0 : pVar.hashCode());
    }

    @NotNull
    public String toString() {
        return "TelemetryEventDto(event_type=" + this.event_type + ", timestamp=" + this.timestamp + ", metadata=" + this.metadata + ')';
    }
}
