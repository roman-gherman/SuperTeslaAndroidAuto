package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum TurnIndicatorState implements Internal.EnumLite {
    TURN_INDICATOR_NONE(1),
    TURN_INDICATOR_LEFT(2),
    TURN_INDICATOR_RIGHT(3);

    public static final int TURN_INDICATOR_LEFT_VALUE = 2;
    public static final int TURN_INDICATOR_NONE_VALUE = 1;
    public static final int TURN_INDICATOR_RIGHT_VALUE = 3;
    private static final Internal.EnumLiteMap<TurnIndicatorState> internalValueMap = new Internal.EnumLiteMap<TurnIndicatorState>() { // from class: fr.sd.taada.proto.TurnIndicatorState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public TurnIndicatorState findValueByNumber(int i) {
            return TurnIndicatorState.forNumber(i);
        }
    };
    private final int value;

    public static final class TurnIndicatorStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new TurnIndicatorStateVerifier();

        private TurnIndicatorStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return TurnIndicatorState.forNumber(i) != null;
        }
    }

    TurnIndicatorState(int i) {
        this.value = i;
    }

    public static TurnIndicatorState forNumber(int i) {
        if (i == 1) {
            return TURN_INDICATOR_NONE;
        }
        if (i == 2) {
            return TURN_INDICATOR_LEFT;
        }
        if (i != 3) {
            return null;
        }
        return TURN_INDICATOR_RIGHT;
    }

    public static Internal.EnumLiteMap<TurnIndicatorState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return TurnIndicatorStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static TurnIndicatorState valueOf(int i) {
        return forNumber(i);
    }
}
