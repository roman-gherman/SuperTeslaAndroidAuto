package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum ControlMessageType implements Internal.EnumLite {
    MESSAGE_VERSION_REQUEST(1),
    MESSAGE_VERSION_RESPONSE(2),
    MESSAGE_ENCAPSULATED_SSL(3),
    MESSAGE_AUTH_COMPLETE(4),
    MESSAGE_SERVICE_DISCOVERY_REQUEST(5),
    MESSAGE_SERVICE_DISCOVERY_RESPONSE(6),
    MESSAGE_CHANNEL_OPEN_REQUEST(7),
    MESSAGE_CHANNEL_OPEN_RESPONSE(8),
    MESSAGE_CHANNEL_CLOSE_NOTIFICATION(9),
    MESSAGE_PING_REQUEST(11),
    MESSAGE_PING_RESPONSE(12),
    MESSAGE_NAV_FOCUS_REQUEST(13),
    MESSAGE_NAV_FOCUS_NOTIFICATION(14),
    MESSAGE_BYEBYE_REQUEST(15),
    MESSAGE_BYEBYE_RESPONSE(16),
    MESSAGE_VOICE_SESSION_NOTIFICATION(17),
    MESSAGE_AUDIO_FOCUS_REQUEST(18),
    MESSAGE_AUDIO_FOCUS_NOTIFICATION(19),
    MESSAGE_CAR_CONNECTED_DEVICES_REQUEST(20),
    MESSAGE_CAR_CONNECTED_DEVICES_RESPONSE(21),
    MESSAGE_USER_SWITCH_REQUEST(22),
    MESSAGE_BATTERY_STATUS_NOTIFICATION(23),
    MESSAGE_CALL_AVAILABILITY_STATUS(24),
    MESSAGE_USER_SWITCH_RESPONSE(25),
    MESSAGE_SERVICE_DISCOVERY_UPDATE(26),
    MESSAGE_UNEXPECTED_MESSAGE(255),
    MESSAGE_FRAMING_ERROR(65535);

    public static final int MESSAGE_AUDIO_FOCUS_NOTIFICATION_VALUE = 19;
    public static final int MESSAGE_AUDIO_FOCUS_REQUEST_VALUE = 18;
    public static final int MESSAGE_AUTH_COMPLETE_VALUE = 4;
    public static final int MESSAGE_BATTERY_STATUS_NOTIFICATION_VALUE = 23;
    public static final int MESSAGE_BYEBYE_REQUEST_VALUE = 15;
    public static final int MESSAGE_BYEBYE_RESPONSE_VALUE = 16;
    public static final int MESSAGE_CALL_AVAILABILITY_STATUS_VALUE = 24;
    public static final int MESSAGE_CAR_CONNECTED_DEVICES_REQUEST_VALUE = 20;
    public static final int MESSAGE_CAR_CONNECTED_DEVICES_RESPONSE_VALUE = 21;
    public static final int MESSAGE_CHANNEL_CLOSE_NOTIFICATION_VALUE = 9;
    public static final int MESSAGE_CHANNEL_OPEN_REQUEST_VALUE = 7;
    public static final int MESSAGE_CHANNEL_OPEN_RESPONSE_VALUE = 8;
    public static final int MESSAGE_ENCAPSULATED_SSL_VALUE = 3;
    public static final int MESSAGE_FRAMING_ERROR_VALUE = 65535;
    public static final int MESSAGE_NAV_FOCUS_NOTIFICATION_VALUE = 14;
    public static final int MESSAGE_NAV_FOCUS_REQUEST_VALUE = 13;
    public static final int MESSAGE_PING_REQUEST_VALUE = 11;
    public static final int MESSAGE_PING_RESPONSE_VALUE = 12;
    public static final int MESSAGE_SERVICE_DISCOVERY_REQUEST_VALUE = 5;
    public static final int MESSAGE_SERVICE_DISCOVERY_RESPONSE_VALUE = 6;
    public static final int MESSAGE_SERVICE_DISCOVERY_UPDATE_VALUE = 26;
    public static final int MESSAGE_UNEXPECTED_MESSAGE_VALUE = 255;
    public static final int MESSAGE_USER_SWITCH_REQUEST_VALUE = 22;
    public static final int MESSAGE_USER_SWITCH_RESPONSE_VALUE = 25;
    public static final int MESSAGE_VERSION_REQUEST_VALUE = 1;
    public static final int MESSAGE_VERSION_RESPONSE_VALUE = 2;
    public static final int MESSAGE_VOICE_SESSION_NOTIFICATION_VALUE = 17;
    private static final Internal.EnumLiteMap<ControlMessageType> internalValueMap = new Internal.EnumLiteMap<ControlMessageType>() { // from class: fr.sd.taada.proto.ControlMessageType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ControlMessageType findValueByNumber(int i) {
            return ControlMessageType.forNumber(i);
        }
    };
    private final int value;

    public static final class ControlMessageTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ControlMessageTypeVerifier();

        private ControlMessageTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ControlMessageType.forNumber(i) != null;
        }
    }

    ControlMessageType(int i) {
        this.value = i;
    }

    public static ControlMessageType forNumber(int i) {
        if (i == 255) {
            return MESSAGE_UNEXPECTED_MESSAGE;
        }
        if (i == 65535) {
            return MESSAGE_FRAMING_ERROR;
        }
        switch (i) {
            case 1:
                return MESSAGE_VERSION_REQUEST;
            case 2:
                return MESSAGE_VERSION_RESPONSE;
            case 3:
                return MESSAGE_ENCAPSULATED_SSL;
            case 4:
                return MESSAGE_AUTH_COMPLETE;
            case 5:
                return MESSAGE_SERVICE_DISCOVERY_REQUEST;
            case 6:
                return MESSAGE_SERVICE_DISCOVERY_RESPONSE;
            case 7:
                return MESSAGE_CHANNEL_OPEN_REQUEST;
            case 8:
                return MESSAGE_CHANNEL_OPEN_RESPONSE;
            case 9:
                return MESSAGE_CHANNEL_CLOSE_NOTIFICATION;
            default:
                switch (i) {
                    case 11:
                        return MESSAGE_PING_REQUEST;
                    case 12:
                        return MESSAGE_PING_RESPONSE;
                    case 13:
                        return MESSAGE_NAV_FOCUS_REQUEST;
                    case 14:
                        return MESSAGE_NAV_FOCUS_NOTIFICATION;
                    case 15:
                        return MESSAGE_BYEBYE_REQUEST;
                    case 16:
                        return MESSAGE_BYEBYE_RESPONSE;
                    case 17:
                        return MESSAGE_VOICE_SESSION_NOTIFICATION;
                    case 18:
                        return MESSAGE_AUDIO_FOCUS_REQUEST;
                    case 19:
                        return MESSAGE_AUDIO_FOCUS_NOTIFICATION;
                    case 20:
                        return MESSAGE_CAR_CONNECTED_DEVICES_REQUEST;
                    case 21:
                        return MESSAGE_CAR_CONNECTED_DEVICES_RESPONSE;
                    case 22:
                        return MESSAGE_USER_SWITCH_REQUEST;
                    case 23:
                        return MESSAGE_BATTERY_STATUS_NOTIFICATION;
                    case 24:
                        return MESSAGE_CALL_AVAILABILITY_STATUS;
                    case 25:
                        return MESSAGE_USER_SWITCH_RESPONSE;
                    case 26:
                        return MESSAGE_SERVICE_DISCOVERY_UPDATE;
                    default:
                        return null;
                }
        }
    }

    public static Internal.EnumLiteMap<ControlMessageType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ControlMessageTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ControlMessageType valueOf(int i) {
        return forNumber(i);
    }
}
