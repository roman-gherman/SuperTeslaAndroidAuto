package fr.sd.taada.core.auth;

import fr.sd.taada.core.PreferencesHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lfr/sd/taada/core/auth/DeviceRegistrationRequest;", "", PreferencesHelper.KEY_DEVICE_ID, "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;)V", "getDevice_id", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DeviceRegistrationRequest {

    @NotNull
    private final String device_id;

    public DeviceRegistrationRequest(@NotNull String device_id) {
        h.f(device_id, "device_id");
        this.device_id = device_id;
    }

    public static /* synthetic */ DeviceRegistrationRequest copy$default(DeviceRegistrationRequest deviceRegistrationRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceRegistrationRequest.device_id;
        }
        return deviceRegistrationRequest.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDevice_id() {
        return this.device_id;
    }

    @NotNull
    public final DeviceRegistrationRequest copy(@NotNull String device_id) {
        h.f(device_id, "device_id");
        return new DeviceRegistrationRequest(device_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeviceRegistrationRequest) && h.a(this.device_id, ((DeviceRegistrationRequest) other).device_id);
    }

    @NotNull
    public final String getDevice_id() {
        return this.device_id;
    }

    public int hashCode() {
        return this.device_id.hashCode();
    }

    @NotNull
    public String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("DeviceRegistrationRequest(device_id="), this.device_id, ')');
    }
}
