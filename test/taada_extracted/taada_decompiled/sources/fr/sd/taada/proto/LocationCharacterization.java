package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum LocationCharacterization implements Internal.EnumLite {
    PRIOR_LOCATIONS(1),
    GYROSCOPE_FUSION(2),
    ACCELEROMETER_FUSION(4),
    COMPASS_FUSION(8),
    WHEEL_SPEED_FUSION(16),
    STEERING_ANGLE_FUSION(32),
    CAR_SPEED_FUSION(64),
    DEAD_RECKONED(128),
    RAW_GPS_ONLY(256);

    public static final int ACCELEROMETER_FUSION_VALUE = 4;
    public static final int CAR_SPEED_FUSION_VALUE = 64;
    public static final int COMPASS_FUSION_VALUE = 8;
    public static final int DEAD_RECKONED_VALUE = 128;
    public static final int GYROSCOPE_FUSION_VALUE = 2;
    public static final int PRIOR_LOCATIONS_VALUE = 1;
    public static final int RAW_GPS_ONLY_VALUE = 256;
    public static final int STEERING_ANGLE_FUSION_VALUE = 32;
    public static final int WHEEL_SPEED_FUSION_VALUE = 16;
    private static final Internal.EnumLiteMap<LocationCharacterization> internalValueMap = new Internal.EnumLiteMap<LocationCharacterization>() { // from class: fr.sd.taada.proto.LocationCharacterization.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public LocationCharacterization findValueByNumber(int i) {
            return LocationCharacterization.forNumber(i);
        }
    };
    private final int value;

    public static final class LocationCharacterizationVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new LocationCharacterizationVerifier();

        private LocationCharacterizationVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return LocationCharacterization.forNumber(i) != null;
        }
    }

    LocationCharacterization(int i) {
        this.value = i;
    }

    public static LocationCharacterization forNumber(int i) {
        if (i == 1) {
            return PRIOR_LOCATIONS;
        }
        if (i == 2) {
            return GYROSCOPE_FUSION;
        }
        if (i == 4) {
            return ACCELEROMETER_FUSION;
        }
        if (i == 8) {
            return COMPASS_FUSION;
        }
        if (i == 16) {
            return WHEEL_SPEED_FUSION;
        }
        if (i == 32) {
            return STEERING_ANGLE_FUSION;
        }
        if (i == 64) {
            return CAR_SPEED_FUSION;
        }
        if (i == 128) {
            return DEAD_RECKONED;
        }
        if (i != 256) {
            return null;
        }
        return RAW_GPS_ONLY;
    }

    public static Internal.EnumLiteMap<LocationCharacterization> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LocationCharacterizationVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static LocationCharacterization valueOf(int i) {
        return forNumber(i);
    }
}
