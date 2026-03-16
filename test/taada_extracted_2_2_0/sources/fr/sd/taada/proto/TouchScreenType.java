package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum TouchScreenType implements Internal.EnumLite {
    CAPACITIVE(1),
    RESISTIVE(2),
    INFRARED(3);

    public static final int CAPACITIVE_VALUE = 1;
    public static final int INFRARED_VALUE = 3;
    public static final int RESISTIVE_VALUE = 2;
    private static final Internal.EnumLiteMap<TouchScreenType> internalValueMap = new Internal.EnumLiteMap<TouchScreenType>() { // from class: fr.sd.taada.proto.TouchScreenType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public TouchScreenType findValueByNumber(int i) {
            return TouchScreenType.forNumber(i);
        }
    };
    private final int value;

    public static final class TouchScreenTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new TouchScreenTypeVerifier();

        private TouchScreenTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return TouchScreenType.forNumber(i) != null;
        }
    }

    TouchScreenType(int i) {
        this.value = i;
    }

    public static TouchScreenType forNumber(int i) {
        if (i == 1) {
            return CAPACITIVE;
        }
        if (i == 2) {
            return RESISTIVE;
        }
        if (i != 3) {
            return null;
        }
        return INFRARED;
    }

    public static Internal.EnumLiteMap<TouchScreenType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return TouchScreenTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static TouchScreenType valueOf(int i) {
        return forNumber(i);
    }
}
