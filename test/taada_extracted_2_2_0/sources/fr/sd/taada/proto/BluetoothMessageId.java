package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum BluetoothMessageId implements Internal.EnumLite {
    BLUETOOTH_MESSAGE_PAIRING_REQUEST(32769),
    BLUETOOTH_MESSAGE_PAIRING_RESPONSE(32770),
    BLUETOOTH_MESSAGE_AUTHENTICATION_DATA(32771),
    BLUETOOTH_MESSAGE_AUTHENTICATION_RESULT(32772);

    public static final int BLUETOOTH_MESSAGE_AUTHENTICATION_DATA_VALUE = 32771;
    public static final int BLUETOOTH_MESSAGE_AUTHENTICATION_RESULT_VALUE = 32772;
    public static final int BLUETOOTH_MESSAGE_PAIRING_REQUEST_VALUE = 32769;
    public static final int BLUETOOTH_MESSAGE_PAIRING_RESPONSE_VALUE = 32770;
    private static final Internal.EnumLiteMap<BluetoothMessageId> internalValueMap = new Internal.EnumLiteMap<BluetoothMessageId>() { // from class: fr.sd.taada.proto.BluetoothMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public BluetoothMessageId findValueByNumber(int i) {
            return BluetoothMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class BluetoothMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new BluetoothMessageIdVerifier();

        private BluetoothMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return BluetoothMessageId.forNumber(i) != null;
        }
    }

    BluetoothMessageId(int i) {
        this.value = i;
    }

    public static BluetoothMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return BLUETOOTH_MESSAGE_PAIRING_REQUEST;
            case 32770:
                return BLUETOOTH_MESSAGE_PAIRING_RESPONSE;
            case 32771:
                return BLUETOOTH_MESSAGE_AUTHENTICATION_DATA;
            case 32772:
                return BLUETOOTH_MESSAGE_AUTHENTICATION_RESULT;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<BluetoothMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return BluetoothMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static BluetoothMessageId valueOf(int i) {
        return forNumber(i);
    }
}
