package fr.sd.taada.core.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lfr/sd/taada/core/auth/DeviceRegistrationResponse;", "", "token", "", "expires_at", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/Long;)V", "getToken", "()Ljava/lang/String;", "getExpires_at", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lfr/sd/taada/core/auth/DeviceRegistrationResponse;", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DeviceRegistrationResponse {

    @Nullable
    private final Long expires_at;

    @NotNull
    private final String token;

    public DeviceRegistrationResponse(@NotNull String token, @Nullable Long l6) {
        h.f(token, "token");
        this.token = token;
        this.expires_at = l6;
    }

    public static /* synthetic */ DeviceRegistrationResponse copy$default(DeviceRegistrationResponse deviceRegistrationResponse, String str, Long l6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceRegistrationResponse.token;
        }
        if ((i & 2) != 0) {
            l6 = deviceRegistrationResponse.expires_at;
        }
        return deviceRegistrationResponse.copy(str, l6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getExpires_at() {
        return this.expires_at;
    }

    @NotNull
    public final DeviceRegistrationResponse copy(@NotNull String token, @Nullable Long expires_at) {
        h.f(token, "token");
        return new DeviceRegistrationResponse(token, expires_at);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceRegistrationResponse)) {
            return false;
        }
        DeviceRegistrationResponse deviceRegistrationResponse = (DeviceRegistrationResponse) other;
        return h.a(this.token, deviceRegistrationResponse.token) && h.a(this.expires_at, deviceRegistrationResponse.expires_at);
    }

    @Nullable
    public final Long getExpires_at() {
        return this.expires_at;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int iHashCode = this.token.hashCode() * 31;
        Long l6 = this.expires_at;
        return iHashCode + (l6 == null ? 0 : l6.hashCode());
    }

    @NotNull
    public String toString() {
        return "DeviceRegistrationResponse(token=" + this.token + ", expires_at=" + this.expires_at + ')';
    }

    public /* synthetic */ DeviceRegistrationResponse(String str, Long l6, int i, d dVar) {
        this(str, (i & 2) != 0 ? null : l6);
    }
}
