package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum EvConnectorType implements Internal.EnumLite {
    EV_CONNECTOR_TYPE_UNKNOWN(0),
    EV_CONNECTOR_TYPE_J1772(1),
    EV_CONNECTOR_TYPE_MENNEKES(2),
    EV_CONNECTOR_TYPE_CHADEMO(3),
    EV_CONNECTOR_TYPE_COMBO_1(4),
    EV_CONNECTOR_TYPE_COMBO_2(5),
    EV_CONNECTOR_TYPE_TESLA_ROADSTER(6),
    EV_CONNECTOR_TYPE_TESLA_HPWC(7),
    EV_CONNECTOR_TYPE_TESLA_SUPERCHARGER(8),
    EV_CONNECTOR_TYPE_GBT(9),
    EV_CONNECTOR_TYPE_OTHER(101);

    public static final int EV_CONNECTOR_TYPE_CHADEMO_VALUE = 3;
    public static final int EV_CONNECTOR_TYPE_COMBO_1_VALUE = 4;
    public static final int EV_CONNECTOR_TYPE_COMBO_2_VALUE = 5;
    public static final int EV_CONNECTOR_TYPE_GBT_VALUE = 9;
    public static final int EV_CONNECTOR_TYPE_J1772_VALUE = 1;
    public static final int EV_CONNECTOR_TYPE_MENNEKES_VALUE = 2;
    public static final int EV_CONNECTOR_TYPE_OTHER_VALUE = 101;
    public static final int EV_CONNECTOR_TYPE_TESLA_HPWC_VALUE = 7;
    public static final int EV_CONNECTOR_TYPE_TESLA_ROADSTER_VALUE = 6;
    public static final int EV_CONNECTOR_TYPE_TESLA_SUPERCHARGER_VALUE = 8;
    public static final int EV_CONNECTOR_TYPE_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<EvConnectorType> internalValueMap = new Internal.EnumLiteMap<EvConnectorType>() { // from class: fr.sd.taada.proto.EvConnectorType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EvConnectorType findValueByNumber(int i) {
            return EvConnectorType.forNumber(i);
        }
    };
    private final int value;

    public static final class EvConnectorTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EvConnectorTypeVerifier();

        private EvConnectorTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return EvConnectorType.forNumber(i) != null;
        }
    }

    EvConnectorType(int i) {
        this.value = i;
    }

    public static EvConnectorType forNumber(int i) {
        if (i == 101) {
            return EV_CONNECTOR_TYPE_OTHER;
        }
        switch (i) {
            case 0:
                return EV_CONNECTOR_TYPE_UNKNOWN;
            case 1:
                return EV_CONNECTOR_TYPE_J1772;
            case 2:
                return EV_CONNECTOR_TYPE_MENNEKES;
            case 3:
                return EV_CONNECTOR_TYPE_CHADEMO;
            case 4:
                return EV_CONNECTOR_TYPE_COMBO_1;
            case 5:
                return EV_CONNECTOR_TYPE_COMBO_2;
            case 6:
                return EV_CONNECTOR_TYPE_TESLA_ROADSTER;
            case 7:
                return EV_CONNECTOR_TYPE_TESLA_HPWC;
            case 8:
                return EV_CONNECTOR_TYPE_TESLA_SUPERCHARGER;
            case 9:
                return EV_CONNECTOR_TYPE_GBT;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<EvConnectorType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EvConnectorTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static EvConnectorType valueOf(int i) {
        return forNumber(i);
    }
}
