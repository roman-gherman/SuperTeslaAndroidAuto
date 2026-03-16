package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum DriverPosition implements Internal.EnumLite {
    DRIVER_POSITION_LEFT(0),
    DRIVER_POSITION_RIGHT(1),
    DRIVER_POSITION_CENTER(2),
    DRIVER_POSITION_UNKNOWN(3);

    public static final int DRIVER_POSITION_CENTER_VALUE = 2;
    public static final int DRIVER_POSITION_LEFT_VALUE = 0;
    public static final int DRIVER_POSITION_RIGHT_VALUE = 1;
    public static final int DRIVER_POSITION_UNKNOWN_VALUE = 3;
    private static final Internal.EnumLiteMap<DriverPosition> internalValueMap = new Internal.EnumLiteMap<DriverPosition>() { // from class: fr.sd.taada.proto.DriverPosition.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DriverPosition findValueByNumber(int i) {
            return DriverPosition.forNumber(i);
        }
    };
    private final int value;

    public static final class DriverPositionVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DriverPositionVerifier();

        private DriverPositionVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DriverPosition.forNumber(i) != null;
        }
    }

    DriverPosition(int i) {
        this.value = i;
    }

    public static DriverPosition forNumber(int i) {
        if (i == 0) {
            return DRIVER_POSITION_LEFT;
        }
        if (i == 1) {
            return DRIVER_POSITION_RIGHT;
        }
        if (i == 2) {
            return DRIVER_POSITION_CENTER;
        }
        if (i != 3) {
            return null;
        }
        return DRIVER_POSITION_UNKNOWN;
    }

    public static Internal.EnumLiteMap<DriverPosition> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DriverPositionVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DriverPosition valueOf(int i) {
        return forNumber(i);
    }
}
