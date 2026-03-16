package fr.sd.taada.analytics.telemetry;

import androidx.constraintlayout.core.motion.a;
import fr.sd.taada.core.PreferencesHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lfr/sd/taada/analytics/telemetry/LastBreathPayload;", "", PreferencesHelper.KEY_DEVICE_ID, "", "last_step", "timestamp", "", "battery_level", "", "memory_level", "event_type", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;)V", "getDevice_id", "()Ljava/lang/String;", "getLast_step", "getTimestamp", "()J", "getBattery_level", "()I", "getMemory_level", "getEvent_type", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "telemetry_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class LastBreathPayload {
    private final int battery_level;

    @NotNull
    private final String device_id;

    @NotNull
    private final String event_type;

    @NotNull
    private final String last_step;
    private final int memory_level;
    private final long timestamp;

    public LastBreathPayload(@NotNull String device_id, @NotNull String last_step, long j6, int i, int i3, @NotNull String event_type) {
        h.f(device_id, "device_id");
        h.f(last_step, "last_step");
        h.f(event_type, "event_type");
        this.device_id = device_id;
        this.last_step = last_step;
        this.timestamp = j6;
        this.battery_level = i;
        this.memory_level = i3;
        this.event_type = event_type;
    }

    public static /* synthetic */ LastBreathPayload copy$default(LastBreathPayload lastBreathPayload, String str, String str2, long j6, int i, int i3, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = lastBreathPayload.device_id;
        }
        if ((i4 & 2) != 0) {
            str2 = lastBreathPayload.last_step;
        }
        if ((i4 & 4) != 0) {
            j6 = lastBreathPayload.timestamp;
        }
        if ((i4 & 8) != 0) {
            i = lastBreathPayload.battery_level;
        }
        if ((i4 & 16) != 0) {
            i3 = lastBreathPayload.memory_level;
        }
        if ((i4 & 32) != 0) {
            str3 = lastBreathPayload.event_type;
        }
        String str4 = str3;
        int i5 = i;
        long j7 = j6;
        return lastBreathPayload.copy(str, str2, j7, i5, i3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLast_step() {
        return this.last_step;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBattery_level() {
        return this.battery_level;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMemory_level() {
        return this.memory_level;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEvent_type() {
        return this.event_type;
    }

    @NotNull
    public final LastBreathPayload copy(@NotNull String device_id, @NotNull String last_step, long timestamp, int battery_level, int memory_level, @NotNull String event_type) {
        h.f(device_id, "device_id");
        h.f(last_step, "last_step");
        h.f(event_type, "event_type");
        return new LastBreathPayload(device_id, last_step, timestamp, battery_level, memory_level, event_type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LastBreathPayload)) {
            return false;
        }
        LastBreathPayload lastBreathPayload = (LastBreathPayload) other;
        return h.a(this.device_id, lastBreathPayload.device_id) && h.a(this.last_step, lastBreathPayload.last_step) && this.timestamp == lastBreathPayload.timestamp && this.battery_level == lastBreathPayload.battery_level && this.memory_level == lastBreathPayload.memory_level && h.a(this.event_type, lastBreathPayload.event_type);
    }

    public final int getBattery_level() {
        return this.battery_level;
    }

    @NotNull
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    public final String getEvent_type() {
        return this.event_type;
    }

    @NotNull
    public final String getLast_step() {
        return this.last_step;
    }

    public final int getMemory_level() {
        return this.memory_level;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.event_type.hashCode() + ((Integer.hashCode(this.memory_level) + ((Integer.hashCode(this.battery_level) + ((Long.hashCode(this.timestamp) + a.c(this.device_id.hashCode() * 31, 31, this.last_step)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("LastBreathPayload(device_id=");
        sb.append(this.device_id);
        sb.append(", last_step=");
        sb.append(this.last_step);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", battery_level=");
        sb.append(this.battery_level);
        sb.append(", memory_level=");
        sb.append(this.memory_level);
        sb.append(", event_type=");
        return a.s(sb, this.event_type, ')');
    }

    public /* synthetic */ LastBreathPayload(String str, String str2, long j6, int i, int i3, String str3, int i4, d dVar) {
        this(str, str2, j6, i, i3, (i4 & 32) != 0 ? "last_breath" : str3);
    }
}
