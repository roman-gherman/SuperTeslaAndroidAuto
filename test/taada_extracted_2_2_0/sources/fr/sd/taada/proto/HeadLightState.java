package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum HeadLightState implements Internal.EnumLite {
    HEAD_LIGHT_STATE_OFF(1),
    HEAD_LIGHT_STATE_ON(2),
    HEAD_LIGHT_STATE_HIGH(3);

    public static final int HEAD_LIGHT_STATE_HIGH_VALUE = 3;
    public static final int HEAD_LIGHT_STATE_OFF_VALUE = 1;
    public static final int HEAD_LIGHT_STATE_ON_VALUE = 2;
    private static final Internal.EnumLiteMap<HeadLightState> internalValueMap = new Internal.EnumLiteMap<HeadLightState>() { // from class: fr.sd.taada.proto.HeadLightState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public HeadLightState findValueByNumber(int i) {
            return HeadLightState.forNumber(i);
        }
    };
    private final int value;

    public static final class HeadLightStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HeadLightStateVerifier();

        private HeadLightStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return HeadLightState.forNumber(i) != null;
        }
    }

    HeadLightState(int i) {
        this.value = i;
    }

    public static HeadLightState forNumber(int i) {
        if (i == 1) {
            return HEAD_LIGHT_STATE_OFF;
        }
        if (i == 2) {
            return HEAD_LIGHT_STATE_ON;
        }
        if (i != 3) {
            return null;
        }
        return HEAD_LIGHT_STATE_HIGH;
    }

    public static Internal.EnumLiteMap<HeadLightState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HeadLightStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static HeadLightState valueOf(int i) {
        return forNumber(i);
    }
}
