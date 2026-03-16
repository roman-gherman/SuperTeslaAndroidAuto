package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum SensorType implements Internal.EnumLite {
    SENSOR_LOCATION(1),
    SENSOR_COMPASS(2),
    SENSOR_SPEED(3),
    SENSOR_RPM(4),
    SENSOR_ODOMETER(5),
    SENSOR_FUEL(6),
    SENSOR_PARKING_BRAKE(7),
    SENSOR_GEAR(8),
    SENSOR_OBDII_DIAGNOSTIC_CODE(9),
    SENSOR_NIGHT_MODE(10),
    SENSOR_ENVIRONMENT_DATA(11),
    SENSOR_HVAC_DATA(12),
    SENSOR_DRIVING_STATUS_DATA(13),
    SENSOR_DEAD_RECKONING_DATA(14),
    SENSOR_PASSENGER_DATA(15),
    SENSOR_DOOR_DATA(16),
    SENSOR_LIGHT_DATA(17),
    SENSOR_TIRE_PRESSURE_DATA(18),
    SENSOR_ACCELEROMETER_DATA(19),
    SENSOR_GYROSCOPE_DATA(20),
    SENSOR_GPS_SATELLITE_DATA(21),
    SENSOR_TOLL_CARD(22);

    public static final int SENSOR_ACCELEROMETER_DATA_VALUE = 19;
    public static final int SENSOR_COMPASS_VALUE = 2;
    public static final int SENSOR_DEAD_RECKONING_DATA_VALUE = 14;
    public static final int SENSOR_DOOR_DATA_VALUE = 16;
    public static final int SENSOR_DRIVING_STATUS_DATA_VALUE = 13;
    public static final int SENSOR_ENVIRONMENT_DATA_VALUE = 11;
    public static final int SENSOR_FUEL_VALUE = 6;
    public static final int SENSOR_GEAR_VALUE = 8;
    public static final int SENSOR_GPS_SATELLITE_DATA_VALUE = 21;
    public static final int SENSOR_GYROSCOPE_DATA_VALUE = 20;
    public static final int SENSOR_HVAC_DATA_VALUE = 12;
    public static final int SENSOR_LIGHT_DATA_VALUE = 17;
    public static final int SENSOR_LOCATION_VALUE = 1;
    public static final int SENSOR_NIGHT_MODE_VALUE = 10;
    public static final int SENSOR_OBDII_DIAGNOSTIC_CODE_VALUE = 9;
    public static final int SENSOR_ODOMETER_VALUE = 5;
    public static final int SENSOR_PARKING_BRAKE_VALUE = 7;
    public static final int SENSOR_PASSENGER_DATA_VALUE = 15;
    public static final int SENSOR_RPM_VALUE = 4;
    public static final int SENSOR_SPEED_VALUE = 3;
    public static final int SENSOR_TIRE_PRESSURE_DATA_VALUE = 18;
    public static final int SENSOR_TOLL_CARD_VALUE = 22;
    private static final Internal.EnumLiteMap<SensorType> internalValueMap = new Internal.EnumLiteMap<SensorType>() { // from class: fr.sd.taada.proto.SensorType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public SensorType findValueByNumber(int i) {
            return SensorType.forNumber(i);
        }
    };
    private final int value;

    public static final class SensorTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SensorTypeVerifier();

        private SensorTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SensorType.forNumber(i) != null;
        }
    }

    SensorType(int i) {
        this.value = i;
    }

    public static SensorType forNumber(int i) {
        switch (i) {
            case 1:
                return SENSOR_LOCATION;
            case 2:
                return SENSOR_COMPASS;
            case 3:
                return SENSOR_SPEED;
            case 4:
                return SENSOR_RPM;
            case 5:
                return SENSOR_ODOMETER;
            case 6:
                return SENSOR_FUEL;
            case 7:
                return SENSOR_PARKING_BRAKE;
            case 8:
                return SENSOR_GEAR;
            case 9:
                return SENSOR_OBDII_DIAGNOSTIC_CODE;
            case 10:
                return SENSOR_NIGHT_MODE;
            case 11:
                return SENSOR_ENVIRONMENT_DATA;
            case 12:
                return SENSOR_HVAC_DATA;
            case 13:
                return SENSOR_DRIVING_STATUS_DATA;
            case 14:
                return SENSOR_DEAD_RECKONING_DATA;
            case 15:
                return SENSOR_PASSENGER_DATA;
            case 16:
                return SENSOR_DOOR_DATA;
            case 17:
                return SENSOR_LIGHT_DATA;
            case 18:
                return SENSOR_TIRE_PRESSURE_DATA;
            case 19:
                return SENSOR_ACCELEROMETER_DATA;
            case 20:
                return SENSOR_GYROSCOPE_DATA;
            case 21:
                return SENSOR_GPS_SATELLITE_DATA;
            case 22:
                return SENSOR_TOLL_CARD;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<SensorType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SensorTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static SensorType valueOf(int i) {
        return forNumber(i);
    }
}
