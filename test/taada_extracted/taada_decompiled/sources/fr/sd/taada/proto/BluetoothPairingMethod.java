package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum BluetoothPairingMethod implements Internal.EnumLite {
    BLUETOOTH_PAIRING_UNAVAILABLE(-1),
    BLUETOOTH_PAIRING_OOB(1),
    BLUETOOTH_PAIRING_NUMERIC_COMPARISON(2),
    BLUETOOTH_PAIRING_PASSKEY_ENTRY(3),
    BLUETOOTH_PAIRING_PIN(4);

    public static final int BLUETOOTH_PAIRING_NUMERIC_COMPARISON_VALUE = 2;
    public static final int BLUETOOTH_PAIRING_OOB_VALUE = 1;
    public static final int BLUETOOTH_PAIRING_PASSKEY_ENTRY_VALUE = 3;
    public static final int BLUETOOTH_PAIRING_PIN_VALUE = 4;
    public static final int BLUETOOTH_PAIRING_UNAVAILABLE_VALUE = -1;
    private static final Internal.EnumLiteMap<BluetoothPairingMethod> internalValueMap = new Internal.EnumLiteMap<BluetoothPairingMethod>() { // from class: fr.sd.taada.proto.BluetoothPairingMethod.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public BluetoothPairingMethod findValueByNumber(int i) {
            return BluetoothPairingMethod.forNumber(i);
        }
    };
    private final int value;

    public static final class BluetoothPairingMethodVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new BluetoothPairingMethodVerifier();

        private BluetoothPairingMethodVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return BluetoothPairingMethod.forNumber(i) != null;
        }
    }

    BluetoothPairingMethod(int i) {
        this.value = i;
    }

    public static BluetoothPairingMethod forNumber(int i) {
        if (i == -1) {
            return BLUETOOTH_PAIRING_UNAVAILABLE;
        }
        if (i == 1) {
            return BLUETOOTH_PAIRING_OOB;
        }
        if (i == 2) {
            return BLUETOOTH_PAIRING_NUMERIC_COMPARISON;
        }
        if (i == 3) {
            return BLUETOOTH_PAIRING_PASSKEY_ENTRY;
        }
        if (i != 4) {
            return null;
        }
        return BLUETOOTH_PAIRING_PIN;
    }

    public static Internal.EnumLiteMap<BluetoothPairingMethod> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return BluetoothPairingMethodVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static BluetoothPairingMethod valueOf(int i) {
        return forNumber(i);
    }
}
