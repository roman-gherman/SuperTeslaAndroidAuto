package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum UserSwitchStatus implements Internal.EnumLite {
    STATUS_OK(0),
    ERROR_NO_RFCOMM_CONNECTION(-1),
    ERROR_BT_CLOSED_BEFORE_START(-2),
    ERROR_BT_CLOSED_AFTER_START(-3),
    ERROR_INCOMPATIBLE_PHONE_PROTOCOL_VERSION(-4),
    ERROR_PHONE_UNABLE_TO_CONNECT_WIFI(-5),
    ERROR_MULTIPLE_USER_SWITCH_REQUEST(-6),
    ERROR_HU_INTERNAL(-7),
    ERROR_INVALID_REQUEST(-8),
    ERROR_REQUEST_TIMEOUT(-9);

    public static final int ERROR_BT_CLOSED_AFTER_START_VALUE = -3;
    public static final int ERROR_BT_CLOSED_BEFORE_START_VALUE = -2;
    public static final int ERROR_HU_INTERNAL_VALUE = -7;
    public static final int ERROR_INCOMPATIBLE_PHONE_PROTOCOL_VERSION_VALUE = -4;
    public static final int ERROR_INVALID_REQUEST_VALUE = -8;
    public static final int ERROR_MULTIPLE_USER_SWITCH_REQUEST_VALUE = -6;
    public static final int ERROR_NO_RFCOMM_CONNECTION_VALUE = -1;
    public static final int ERROR_PHONE_UNABLE_TO_CONNECT_WIFI_VALUE = -5;
    public static final int ERROR_REQUEST_TIMEOUT_VALUE = -9;
    public static final int STATUS_OK_VALUE = 0;
    private static final Internal.EnumLiteMap<UserSwitchStatus> internalValueMap = new Internal.EnumLiteMap<UserSwitchStatus>() { // from class: fr.sd.taada.proto.UserSwitchStatus.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public UserSwitchStatus findValueByNumber(int i) {
            return UserSwitchStatus.forNumber(i);
        }
    };
    private final int value;

    public static final class UserSwitchStatusVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new UserSwitchStatusVerifier();

        private UserSwitchStatusVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return UserSwitchStatus.forNumber(i) != null;
        }
    }

    UserSwitchStatus(int i) {
        this.value = i;
    }

    public static UserSwitchStatus forNumber(int i) {
        switch (i) {
            case -9:
                return ERROR_REQUEST_TIMEOUT;
            case -8:
                return ERROR_INVALID_REQUEST;
            case -7:
                return ERROR_HU_INTERNAL;
            case -6:
                return ERROR_MULTIPLE_USER_SWITCH_REQUEST;
            case -5:
                return ERROR_PHONE_UNABLE_TO_CONNECT_WIFI;
            case -4:
                return ERROR_INCOMPATIBLE_PHONE_PROTOCOL_VERSION;
            case -3:
                return ERROR_BT_CLOSED_AFTER_START;
            case -2:
                return ERROR_BT_CLOSED_BEFORE_START;
            case -1:
                return ERROR_NO_RFCOMM_CONNECTION;
            case 0:
                return STATUS_OK;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<UserSwitchStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return UserSwitchStatusVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static UserSwitchStatus valueOf(int i) {
        return forNumber(i);
    }
}
