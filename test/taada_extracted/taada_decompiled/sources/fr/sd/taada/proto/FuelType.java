package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum FuelType implements Internal.EnumLite {
    FUEL_TYPE_UNKNOWN(0),
    FUEL_TYPE_UNLEADED(1),
    FUEL_TYPE_LEADED(2),
    FUEL_TYPE_DIESEL_1(3),
    FUEL_TYPE_DIESEL_2(4),
    FUEL_TYPE_BIODIESEL(5),
    FUEL_TYPE_E85(6),
    FUEL_TYPE_LPG(7),
    FUEL_TYPE_CNG(8),
    FUEL_TYPE_LNG(9),
    FUEL_TYPE_ELECTRIC(10),
    FUEL_TYPE_HYDROGEN(11),
    FUEL_TYPE_OTHER(12);

    public static final int FUEL_TYPE_BIODIESEL_VALUE = 5;
    public static final int FUEL_TYPE_CNG_VALUE = 8;
    public static final int FUEL_TYPE_DIESEL_1_VALUE = 3;
    public static final int FUEL_TYPE_DIESEL_2_VALUE = 4;
    public static final int FUEL_TYPE_E85_VALUE = 6;
    public static final int FUEL_TYPE_ELECTRIC_VALUE = 10;
    public static final int FUEL_TYPE_HYDROGEN_VALUE = 11;
    public static final int FUEL_TYPE_LEADED_VALUE = 2;
    public static final int FUEL_TYPE_LNG_VALUE = 9;
    public static final int FUEL_TYPE_LPG_VALUE = 7;
    public static final int FUEL_TYPE_OTHER_VALUE = 12;
    public static final int FUEL_TYPE_UNKNOWN_VALUE = 0;
    public static final int FUEL_TYPE_UNLEADED_VALUE = 1;
    private static final Internal.EnumLiteMap<FuelType> internalValueMap = new Internal.EnumLiteMap<FuelType>() { // from class: fr.sd.taada.proto.FuelType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public FuelType findValueByNumber(int i) {
            return FuelType.forNumber(i);
        }
    };
    private final int value;

    public static final class FuelTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new FuelTypeVerifier();

        private FuelTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return FuelType.forNumber(i) != null;
        }
    }

    FuelType(int i) {
        this.value = i;
    }

    public static FuelType forNumber(int i) {
        switch (i) {
            case 0:
                return FUEL_TYPE_UNKNOWN;
            case 1:
                return FUEL_TYPE_UNLEADED;
            case 2:
                return FUEL_TYPE_LEADED;
            case 3:
                return FUEL_TYPE_DIESEL_1;
            case 4:
                return FUEL_TYPE_DIESEL_2;
            case 5:
                return FUEL_TYPE_BIODIESEL;
            case 6:
                return FUEL_TYPE_E85;
            case 7:
                return FUEL_TYPE_LPG;
            case 8:
                return FUEL_TYPE_CNG;
            case 9:
                return FUEL_TYPE_LNG;
            case 10:
                return FUEL_TYPE_ELECTRIC;
            case 11:
                return FUEL_TYPE_HYDROGEN;
            case 12:
                return FUEL_TYPE_OTHER;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<FuelType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FuelTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static FuelType valueOf(int i) {
        return forNumber(i);
    }
}
