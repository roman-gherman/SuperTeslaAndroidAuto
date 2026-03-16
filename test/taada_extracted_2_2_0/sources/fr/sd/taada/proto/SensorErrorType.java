package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum SensorErrorType implements Internal.EnumLite {
    SENSOR_OK(1),
    SENSOR_ERROR_TRANSIENT(2),
    SENSOR_ERROR_PERMANENT(3);

    public static final int SENSOR_ERROR_PERMANENT_VALUE = 3;
    public static final int SENSOR_ERROR_TRANSIENT_VALUE = 2;
    public static final int SENSOR_OK_VALUE = 1;
    private static final Internal.EnumLiteMap<SensorErrorType> internalValueMap = new Internal.EnumLiteMap<SensorErrorType>() { // from class: fr.sd.taada.proto.SensorErrorType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public SensorErrorType findValueByNumber(int i) {
            return SensorErrorType.forNumber(i);
        }
    };
    private final int value;

    public static final class SensorErrorTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SensorErrorTypeVerifier();

        private SensorErrorTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SensorErrorType.forNumber(i) != null;
        }
    }

    SensorErrorType(int i) {
        this.value = i;
    }

    public static SensorErrorType forNumber(int i) {
        if (i == 1) {
            return SENSOR_OK;
        }
        if (i == 2) {
            return SENSOR_ERROR_TRANSIENT;
        }
        if (i != 3) {
            return null;
        }
        return SENSOR_ERROR_PERMANENT;
    }

    public static Internal.EnumLiteMap<SensorErrorType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SensorErrorTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static SensorErrorType valueOf(int i) {
        return forNumber(i);
    }
}
