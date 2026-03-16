package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum Gear implements Internal.EnumLite {
    GEAR_NEUTRAL(0),
    GEAR_1(1),
    GEAR_2(2),
    GEAR_3(3),
    GEAR_4(4),
    GEAR_5(5),
    GEAR_6(6),
    GEAR_7(7),
    GEAR_8(8),
    GEAR_9(9),
    GEAR_10(10),
    GEAR_DRIVE(100),
    GEAR_PARK(101),
    GEAR_REVERSE(102);

    public static final int GEAR_10_VALUE = 10;
    public static final int GEAR_1_VALUE = 1;
    public static final int GEAR_2_VALUE = 2;
    public static final int GEAR_3_VALUE = 3;
    public static final int GEAR_4_VALUE = 4;
    public static final int GEAR_5_VALUE = 5;
    public static final int GEAR_6_VALUE = 6;
    public static final int GEAR_7_VALUE = 7;
    public static final int GEAR_8_VALUE = 8;
    public static final int GEAR_9_VALUE = 9;
    public static final int GEAR_DRIVE_VALUE = 100;
    public static final int GEAR_NEUTRAL_VALUE = 0;
    public static final int GEAR_PARK_VALUE = 101;
    public static final int GEAR_REVERSE_VALUE = 102;
    private static final Internal.EnumLiteMap<Gear> internalValueMap = new Internal.EnumLiteMap<Gear>() { // from class: fr.sd.taada.proto.Gear.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Gear findValueByNumber(int i) {
            return Gear.forNumber(i);
        }
    };
    private final int value;

    public static final class GearVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new GearVerifier();

        private GearVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Gear.forNumber(i) != null;
        }
    }

    Gear(int i) {
        this.value = i;
    }

    public static Gear forNumber(int i) {
        switch (i) {
            case 0:
                return GEAR_NEUTRAL;
            case 1:
                return GEAR_1;
            case 2:
                return GEAR_2;
            case 3:
                return GEAR_3;
            case 4:
                return GEAR_4;
            case 5:
                return GEAR_5;
            case 6:
                return GEAR_6;
            case 7:
                return GEAR_7;
            case 8:
                return GEAR_8;
            case 9:
                return GEAR_9;
            case 10:
                return GEAR_10;
            default:
                switch (i) {
                    case 100:
                        return GEAR_DRIVE;
                    case 101:
                        return GEAR_PARK;
                    case 102:
                        return GEAR_REVERSE;
                    default:
                        return null;
                }
        }
    }

    public static Internal.EnumLiteMap<Gear> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return GearVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static Gear valueOf(int i) {
        return forNumber(i);
    }
}
