package fr.sd.taada.helpers.permissions;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import fr.sd.taada.R;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionItem {
    private final int iconRes;
    private final int iconTint;
    private final String name;
    private final Status status;
    private final PermissionType type;

    /* JADX INFO: renamed from: fr.sd.taada.helpers.permissions.PermissionItem$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$Status = iArr;
            try {
                iArr[Status.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$Status[Status.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$Status[Status.MANUAL_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$Status[Status.UNVERIFIABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum PermissionType {
        BLUETOOTH,
        MICROPHONE,
        NOTIFICATIONS,
        OVERLAY,
        WRITE_SETTINGS,
        VPN,
        BATTERY_OPTIMIZATION,
        CUSTOM_OS_LOCK_SCREEN,
        CUSTOM_OS_POPUP,
        CUSTOM_OS_AUTO_START
    }

    public enum Status {
        GRANTED,
        DENIED,
        MANUAL_REQUIRED,
        UNVERIFIABLE
    }

    public PermissionItem(@NonNull String str, @NonNull Status status, @NonNull PermissionType permissionType) {
        this.name = str;
        this.status = status;
        this.type = permissionType;
        int i = AnonymousClass1.$SwitchMap$fr$sd$taada$helpers$permissions$PermissionItem$Status[status.ordinal()];
        if (i == 1) {
            this.iconRes = R.drawable.ic_check_circle_24;
            this.iconTint = R.color.permission_granted;
            return;
        }
        if (i == 2) {
            this.iconRes = R.drawable.ic_error_24;
            this.iconTint = R.color.permission_denied;
        } else if (i == 3 || i == 4) {
            this.iconRes = R.drawable.ic_warning_24;
            this.iconTint = R.color.permission_warning;
        } else {
            this.iconRes = R.drawable.ic_error_24;
            this.iconTint = R.color.permission_denied;
        }
    }

    @DrawableRes
    public int getIconRes() {
        return this.iconRes;
    }

    @ColorRes
    public int getIconTint() {
        return this.iconTint;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public Status getStatus() {
        return this.status;
    }

    @NonNull
    public PermissionType getType() {
        return this.type;
    }

    public boolean isGranted() {
        Status status = this.status;
        return status == Status.GRANTED || status == Status.UNVERIFIABLE;
    }
}
