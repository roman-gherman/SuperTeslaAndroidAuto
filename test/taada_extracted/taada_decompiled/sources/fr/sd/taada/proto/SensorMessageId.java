package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum SensorMessageId implements Internal.EnumLite {
    SENSOR_MESSAGE_REQUEST(32769),
    SENSOR_MESSAGE_RESPONSE(32770),
    SENSOR_MESSAGE_BATCH(32771),
    SENSOR_MESSAGE_ERROR(32772);

    public static final int SENSOR_MESSAGE_BATCH_VALUE = 32771;
    public static final int SENSOR_MESSAGE_ERROR_VALUE = 32772;
    public static final int SENSOR_MESSAGE_REQUEST_VALUE = 32769;
    public static final int SENSOR_MESSAGE_RESPONSE_VALUE = 32770;
    private static final Internal.EnumLiteMap<SensorMessageId> internalValueMap = new Internal.EnumLiteMap<SensorMessageId>() { // from class: fr.sd.taada.proto.SensorMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public SensorMessageId findValueByNumber(int i) {
            return SensorMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class SensorMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SensorMessageIdVerifier();

        private SensorMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SensorMessageId.forNumber(i) != null;
        }
    }

    SensorMessageId(int i) {
        this.value = i;
    }

    public static SensorMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return SENSOR_MESSAGE_REQUEST;
            case 32770:
                return SENSOR_MESSAGE_RESPONSE;
            case 32771:
                return SENSOR_MESSAGE_BATCH;
            case 32772:
                return SENSOR_MESSAGE_ERROR;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<SensorMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SensorMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static SensorMessageId valueOf(int i) {
        return forNumber(i);
    }
}
