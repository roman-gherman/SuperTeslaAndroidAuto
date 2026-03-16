package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum TrafficServiceType implements Internal.EnumLite {
    NO_TRAFFIC_SERVICE(0),
    TMC_TRAFFIC_SERVICE(1);

    public static final int NO_TRAFFIC_SERVICE_VALUE = 0;
    public static final int TMC_TRAFFIC_SERVICE_VALUE = 1;
    private static final Internal.EnumLiteMap<TrafficServiceType> internalValueMap = new Internal.EnumLiteMap<TrafficServiceType>() { // from class: fr.sd.taada.proto.TrafficServiceType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public TrafficServiceType findValueByNumber(int i) {
            return TrafficServiceType.forNumber(i);
        }
    };
    private final int value;

    public static final class TrafficServiceTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new TrafficServiceTypeVerifier();

        private TrafficServiceTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return TrafficServiceType.forNumber(i) != null;
        }
    }

    TrafficServiceType(int i) {
        this.value = i;
    }

    public static TrafficServiceType forNumber(int i) {
        if (i == 0) {
            return NO_TRAFFIC_SERVICE;
        }
        if (i != 1) {
            return null;
        }
        return TMC_TRAFFIC_SERVICE;
    }

    public static Internal.EnumLiteMap<TrafficServiceType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return TrafficServiceTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static TrafficServiceType valueOf(int i) {
        return forNumber(i);
    }
}
