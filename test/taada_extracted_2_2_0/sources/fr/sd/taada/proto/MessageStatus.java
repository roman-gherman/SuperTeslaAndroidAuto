package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum MessageStatus implements Internal.EnumLite {
    STATUS_UNSOLICITED_MESSAGE(1),
    STATUS_SUCCESS(0),
    STATUS_NO_COMPATIBLE_VERSION(-1),
    STATUS_CERTIFICATE_ERROR(-2),
    STATUS_AUTHENTICATION_FAILURE(-3),
    STATUS_INVALID_SERVICE(-4),
    STATUS_INVALID_CHANNEL(-5),
    STATUS_INVALID_PRIORITY(-6),
    STATUS_INTERNAL_ERROR(-7),
    STATUS_MEDIA_CONFIG_MISMATCH(-8),
    STATUS_INVALID_SENSOR(-9),
    STATUS_BLUETOOTH_PAIRING_DELAYED(-10),
    STATUS_BLUETOOTH_UNAVAILABLE(-11),
    STATUS_BLUETOOTH_INVALID_ADDRESS(-12),
    STATUS_BLUETOOTH_INVALID_PAIRING_METHOD(-13),
    STATUS_BLUETOOTH_INVALID_AUTH_DATA(-14),
    STATUS_BLUETOOTH_AUTH_DATA_MISMATCH(-15),
    STATUS_BLUETOOTH_HFP_ANOTHER_CONNECTION(-16),
    STATUS_BLUETOOTH_HFP_CONNECTION_FAILURE(-17),
    STATUS_KEYCODE_NOT_BOUND(-18),
    STATUS_RADIO_INVALID_STATION(-19),
    STATUS_INVALID_INPUT(-20),
    STATUS_RADIO_STATION_PRESETS_NOT_SUPPORTED(-21),
    STATUS_RADIO_COMM_ERROR(-22),
    STATUS_AUTHENTICATION_FAILURE_CERT_NOT_YET_VALID(-23),
    STATUS_AUTHENTICATION_FAILURE_CERT_EXPIRED(-24),
    STATUS_PING_TIMEOUT(-25),
    STATUS_COMMAND_NOT_SUPPORTED(STATUS_COMMAND_NOT_SUPPORTED_VALUE),
    STATUS_FRAMING_ERROR(STATUS_FRAMING_ERROR_VALUE),
    STATUS_UNEXPECTED_MESSAGE(STATUS_UNEXPECTED_MESSAGE_VALUE),
    STATUS_BUSY(STATUS_BUSY_VALUE),
    STATUS_OUT_OF_MEMORY(STATUS_OUT_OF_MEMORY_VALUE);

    public static final int STATUS_AUTHENTICATION_FAILURE_CERT_EXPIRED_VALUE = -24;
    public static final int STATUS_AUTHENTICATION_FAILURE_CERT_NOT_YET_VALID_VALUE = -23;
    public static final int STATUS_AUTHENTICATION_FAILURE_VALUE = -3;
    public static final int STATUS_BLUETOOTH_AUTH_DATA_MISMATCH_VALUE = -15;
    public static final int STATUS_BLUETOOTH_HFP_ANOTHER_CONNECTION_VALUE = -16;
    public static final int STATUS_BLUETOOTH_HFP_CONNECTION_FAILURE_VALUE = -17;
    public static final int STATUS_BLUETOOTH_INVALID_ADDRESS_VALUE = -12;
    public static final int STATUS_BLUETOOTH_INVALID_AUTH_DATA_VALUE = -14;
    public static final int STATUS_BLUETOOTH_INVALID_PAIRING_METHOD_VALUE = -13;
    public static final int STATUS_BLUETOOTH_PAIRING_DELAYED_VALUE = -10;
    public static final int STATUS_BLUETOOTH_UNAVAILABLE_VALUE = -11;
    public static final int STATUS_BUSY_VALUE = -254;
    public static final int STATUS_CERTIFICATE_ERROR_VALUE = -2;
    public static final int STATUS_COMMAND_NOT_SUPPORTED_VALUE = -250;
    public static final int STATUS_FRAMING_ERROR_VALUE = -251;
    public static final int STATUS_INTERNAL_ERROR_VALUE = -7;
    public static final int STATUS_INVALID_CHANNEL_VALUE = -5;
    public static final int STATUS_INVALID_INPUT_VALUE = -20;
    public static final int STATUS_INVALID_PRIORITY_VALUE = -6;
    public static final int STATUS_INVALID_SENSOR_VALUE = -9;
    public static final int STATUS_INVALID_SERVICE_VALUE = -4;
    public static final int STATUS_KEYCODE_NOT_BOUND_VALUE = -18;
    public static final int STATUS_MEDIA_CONFIG_MISMATCH_VALUE = -8;
    public static final int STATUS_NO_COMPATIBLE_VERSION_VALUE = -1;
    public static final int STATUS_OUT_OF_MEMORY_VALUE = -255;
    public static final int STATUS_PING_TIMEOUT_VALUE = -25;
    public static final int STATUS_RADIO_COMM_ERROR_VALUE = -22;
    public static final int STATUS_RADIO_INVALID_STATION_VALUE = -19;
    public static final int STATUS_RADIO_STATION_PRESETS_NOT_SUPPORTED_VALUE = -21;
    public static final int STATUS_SUCCESS_VALUE = 0;
    public static final int STATUS_UNEXPECTED_MESSAGE_VALUE = -253;
    public static final int STATUS_UNSOLICITED_MESSAGE_VALUE = 1;
    private static final Internal.EnumLiteMap<MessageStatus> internalValueMap = new Internal.EnumLiteMap<MessageStatus>() { // from class: fr.sd.taada.proto.MessageStatus.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public MessageStatus findValueByNumber(int i) {
            return MessageStatus.forNumber(i);
        }
    };
    private final int value;

    public static final class MessageStatusVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new MessageStatusVerifier();

        private MessageStatusVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return MessageStatus.forNumber(i) != null;
        }
    }

    MessageStatus(int i) {
        this.value = i;
    }

    public static MessageStatus forNumber(int i) {
        if (i == -251) {
            return STATUS_FRAMING_ERROR;
        }
        if (i == -250) {
            return STATUS_COMMAND_NOT_SUPPORTED;
        }
        switch (i) {
            case STATUS_OUT_OF_MEMORY_VALUE:
                return STATUS_OUT_OF_MEMORY;
            case STATUS_BUSY_VALUE:
                return STATUS_BUSY;
            case STATUS_UNEXPECTED_MESSAGE_VALUE:
                return STATUS_UNEXPECTED_MESSAGE;
            default:
                switch (i) {
                    case STATUS_PING_TIMEOUT_VALUE:
                        return STATUS_PING_TIMEOUT;
                    case STATUS_AUTHENTICATION_FAILURE_CERT_EXPIRED_VALUE:
                        return STATUS_AUTHENTICATION_FAILURE_CERT_EXPIRED;
                    case STATUS_AUTHENTICATION_FAILURE_CERT_NOT_YET_VALID_VALUE:
                        return STATUS_AUTHENTICATION_FAILURE_CERT_NOT_YET_VALID;
                    case STATUS_RADIO_COMM_ERROR_VALUE:
                        return STATUS_RADIO_COMM_ERROR;
                    case STATUS_RADIO_STATION_PRESETS_NOT_SUPPORTED_VALUE:
                        return STATUS_RADIO_STATION_PRESETS_NOT_SUPPORTED;
                    case STATUS_INVALID_INPUT_VALUE:
                        return STATUS_INVALID_INPUT;
                    case STATUS_RADIO_INVALID_STATION_VALUE:
                        return STATUS_RADIO_INVALID_STATION;
                    case STATUS_KEYCODE_NOT_BOUND_VALUE:
                        return STATUS_KEYCODE_NOT_BOUND;
                    case STATUS_BLUETOOTH_HFP_CONNECTION_FAILURE_VALUE:
                        return STATUS_BLUETOOTH_HFP_CONNECTION_FAILURE;
                    case STATUS_BLUETOOTH_HFP_ANOTHER_CONNECTION_VALUE:
                        return STATUS_BLUETOOTH_HFP_ANOTHER_CONNECTION;
                    case STATUS_BLUETOOTH_AUTH_DATA_MISMATCH_VALUE:
                        return STATUS_BLUETOOTH_AUTH_DATA_MISMATCH;
                    case STATUS_BLUETOOTH_INVALID_AUTH_DATA_VALUE:
                        return STATUS_BLUETOOTH_INVALID_AUTH_DATA;
                    case STATUS_BLUETOOTH_INVALID_PAIRING_METHOD_VALUE:
                        return STATUS_BLUETOOTH_INVALID_PAIRING_METHOD;
                    case STATUS_BLUETOOTH_INVALID_ADDRESS_VALUE:
                        return STATUS_BLUETOOTH_INVALID_ADDRESS;
                    case STATUS_BLUETOOTH_UNAVAILABLE_VALUE:
                        return STATUS_BLUETOOTH_UNAVAILABLE;
                    case STATUS_BLUETOOTH_PAIRING_DELAYED_VALUE:
                        return STATUS_BLUETOOTH_PAIRING_DELAYED;
                    case -9:
                        return STATUS_INVALID_SENSOR;
                    case -8:
                        return STATUS_MEDIA_CONFIG_MISMATCH;
                    case -7:
                        return STATUS_INTERNAL_ERROR;
                    case -6:
                        return STATUS_INVALID_PRIORITY;
                    case -5:
                        return STATUS_INVALID_CHANNEL;
                    case -4:
                        return STATUS_INVALID_SERVICE;
                    case -3:
                        return STATUS_AUTHENTICATION_FAILURE;
                    case -2:
                        return STATUS_CERTIFICATE_ERROR;
                    case -1:
                        return STATUS_NO_COMPATIBLE_VERSION;
                    case 0:
                        return STATUS_SUCCESS;
                    case 1:
                        return STATUS_UNSOLICITED_MESSAGE;
                    default:
                        return null;
                }
        }
    }

    public static Internal.EnumLiteMap<MessageStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return MessageStatusVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static MessageStatus valueOf(int i) {
        return forNumber(i);
    }
}
