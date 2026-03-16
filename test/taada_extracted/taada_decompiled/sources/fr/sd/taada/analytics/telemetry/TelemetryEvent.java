package fr.sd.taada.analytics.telemetry;

import androidx.constraintlayout.core.motion.a;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Entity(tableName = "telemetry_events")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lfr/sd/taada/analytics/telemetry/TelemetryEvent;", "", "id", "", "eventType", "", "timestamp", "metadata", "synced", "", "syncAttempts", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(JLjava/lang/String;JLjava/lang/String;ZI)V", "getId", "()J", "getEventType", "()Ljava/lang/String;", "getTimestamp", "getMetadata", "getSynced", "()Z", "getSyncAttempts", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class TelemetryEvent {

    @NotNull
    private final String eventType;

    @PrimaryKey(autoGenerate = true)
    private final long id;

    @Nullable
    private final String metadata;
    private final int syncAttempts;
    private final boolean synced;
    private final long timestamp;

    public TelemetryEvent(long j6, @NotNull String eventType, long j7, @Nullable String str, boolean z6, int i) {
        h.f(eventType, "eventType");
        this.id = j6;
        this.eventType = eventType;
        this.timestamp = j7;
        this.metadata = str;
        this.synced = z6;
        this.syncAttempts = i;
    }

    public static /* synthetic */ TelemetryEvent copy$default(TelemetryEvent telemetryEvent, long j6, String str, long j7, String str2, boolean z6, int i, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j6 = telemetryEvent.id;
        }
        long j8 = j6;
        if ((i3 & 2) != 0) {
            str = telemetryEvent.eventType;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            j7 = telemetryEvent.timestamp;
        }
        long j9 = j7;
        if ((i3 & 8) != 0) {
            str2 = telemetryEvent.metadata;
        }
        return telemetryEvent.copy(j8, str3, j9, str2, (i3 & 16) != 0 ? telemetryEvent.synced : z6, (i3 & 32) != 0 ? telemetryEvent.syncAttempts : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getSynced() {
        return this.synced;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSyncAttempts() {
        return this.syncAttempts;
    }

    @NotNull
    public final TelemetryEvent copy(long id, @NotNull String eventType, long timestamp, @Nullable String metadata, boolean synced, int syncAttempts) {
        h.f(eventType, "eventType");
        return new TelemetryEvent(id, eventType, timestamp, metadata, synced, syncAttempts);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetryEvent)) {
            return false;
        }
        TelemetryEvent telemetryEvent = (TelemetryEvent) other;
        return this.id == telemetryEvent.id && h.a(this.eventType, telemetryEvent.eventType) && this.timestamp == telemetryEvent.timestamp && h.a(this.metadata, telemetryEvent.metadata) && this.synced == telemetryEvent.synced && this.syncAttempts == telemetryEvent.syncAttempts;
    }

    @NotNull
    public final String getEventType() {
        return this.eventType;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getMetadata() {
        return this.metadata;
    }

    public final int getSyncAttempts() {
        return this.syncAttempts;
    }

    public final boolean getSynced() {
        return this.synced;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(this.timestamp) + a.c(Long.hashCode(this.id) * 31, 31, this.eventType)) * 31;
        String str = this.metadata;
        return Integer.hashCode(this.syncAttempts) + ((Boolean.hashCode(this.synced) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "TelemetryEvent(id=" + this.id + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ", metadata=" + this.metadata + ", synced=" + this.synced + ", syncAttempts=" + this.syncAttempts + ')';
    }

    public /* synthetic */ TelemetryEvent(long j6, String str, long j7, String str2, boolean z6, int i, int i3, d dVar) {
        this((i3 & 1) != 0 ? 0L : j6, str, (i3 & 4) != 0 ? System.currentTimeMillis() : j7, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? false : z6, (i3 & 32) != 0 ? 0 : i);
    }
}
