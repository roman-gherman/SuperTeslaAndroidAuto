package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum ByeByeReason implements Internal.EnumLite {
    USER_SELECTION(1),
    DEVICE_SWITCH(2),
    NOT_SUPPORTED(3),
    NOT_CURRENTLY_SUPPORTED(4),
    PROBE_SUPPORTED(5);

    public static final int DEVICE_SWITCH_VALUE = 2;
    public static final int NOT_CURRENTLY_SUPPORTED_VALUE = 4;
    public static final int NOT_SUPPORTED_VALUE = 3;
    public static final int PROBE_SUPPORTED_VALUE = 5;
    public static final int USER_SELECTION_VALUE = 1;
    private static final Internal.EnumLiteMap<ByeByeReason> internalValueMap = new Internal.EnumLiteMap<ByeByeReason>() { // from class: fr.sd.taada.proto.ByeByeReason.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ByeByeReason findValueByNumber(int i) {
            return ByeByeReason.forNumber(i);
        }
    };
    private final int value;

    public static final class ByeByeReasonVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ByeByeReasonVerifier();

        private ByeByeReasonVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ByeByeReason.forNumber(i) != null;
        }
    }

    ByeByeReason(int i) {
        this.value = i;
    }

    public static ByeByeReason forNumber(int i) {
        if (i == 1) {
            return USER_SELECTION;
        }
        if (i == 2) {
            return DEVICE_SWITCH;
        }
        if (i == 3) {
            return NOT_SUPPORTED;
        }
        if (i == 4) {
            return NOT_CURRENTLY_SUPPORTED;
        }
        if (i != 5) {
            return null;
        }
        return PROBE_SUPPORTED;
    }

    public static Internal.EnumLiteMap<ByeByeReason> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ByeByeReasonVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ByeByeReason valueOf(int i) {
        return forNumber(i);
    }
}
